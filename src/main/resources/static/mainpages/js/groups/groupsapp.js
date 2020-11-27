/**
 * 
 */

var groupapp = angular.module('groupApp', ['ui.bootstrap' , 'blockUI']);

groupapp.controller('GroupsCntrl', ['$scope', 'groupService', 'blockUI',
    function ($scope, groupService, blockUI) {
        $scope.group = {};
        $scope.groups = [];

        $scope.loadGroups = function () {
            groupService.getGroups().success(function (response) {
                $scope.groups = response;
                $scope.currentPage = $scope.groups.number + 1;

            }).error(function (response) {
                console.log("Error while fetching Groups1");
            });
        };
        
        $scope.loadContacts = function (groupId) {
            groupService.getPagedGroupContacts(groupId).success(function (response) {
                $scope.groupContacts = response;
                $scope.contactsCurrentPage = $scope.groupContacts.number + 1;

            }).error(function (response) {
                console.log("Error while fetching Groups1");
            });
        };
        $scope.addGroup = function () {
            $scope.group = {};
        };
        $scope.editGroup = function (group) {
            $scope.group = group;
        };
        
        $scope.addContact = function (groupid) {
            $scope.contact = {'groupId' : groupid};
        };
        
        
        $scope.deleteGroup = function (groupid) {
        	groupService.deleteGroup(groupid).success(function (data, status, headers, config) {
                console.log('---------------------------------------------------------------------------'+data);
                if (data === true) {
                    $scope.loadGroups();
                    $scope.screen = 'list';
                    $scope.notification = {};
                    $scope.modalShown = !$scope.modalShown;
                    $(".add-group-close").click();
                    //menuService.setSuccess("Code saved successfully.");
                } else {
                    $scope.errors = data.errors;
                    //menuService.setErrors(data.errors);
                }
            });
        };

        $scope.pageChanged = function () {
            groupService.page = $scope.currentPage - 1;
            groupService.size = $scope.groups.size;

            groupService.getPagedGroups().success(function (response) {
                $scope.groups = response;
                $scope.currentPage = $scope.groups.number + 1;

            }).error(function (response) {
                console.log("Error while fetching Groups2");
            });
        };
        
        
        $scope.contactsPageChanged = function () {
            groupService.cpage = $scope.contactsCurrentPage - 1;
            groupService.csize = $scope.groupContacts.size;

            groupService.getPagedGroupContacts().success(function (response) {
                $scope.groups = response;
                $scope.contactsCurrentPage = $scope.groupContacts.number + 1;

            }).error(function (response) {
                console.log("Error while fetching Groups2");
            });
        };

        $scope.create = function (screen, group) {
            if (true) {
//					$scope.user = user;
                groupService.saveorUpdate(group).success(function (data, status, headers, config) {
                    console.log('---------------------------------------------------------------------------'+data);
                    if (data === true) {
                        $scope.loadGroups();
                        $scope.screen = 'list';
                        $scope.notification = {};
                        $scope.modalShown = !$scope.modalShown;
                        $(".add-group-close").click();
                        //menuService.setSuccess("Code saved successfully.");
                    } else {
                        $scope.errors = data.errors;
                        //menuService.setErrors(data.errors);
                    }
                });
            }
        };
        
        $scope.createContact = function (screen) {
//					$scope.user = user;
            groupService.saveorUpdateContact($scope.contact).success(function (data, status, headers, config) {
                console.log('---------------------------------------------------------------------------'+data);
                if (data === true) {
                    $scope.loadGroups();
                    $scope.screen = 'list';
                    $scope.contact = {};
                    $(".add-group-contact-close").click();
                } else {
                    $scope.errors = data.errors;
                }
            });
        };

        $scope.uploadContacts = function() {
        	var file = $scope.customfile;
            var fd = new FormData();
            if (null != file) {
                fd.append("file", file);
            }
//            fd.append("info", angular.toJson($scope.obj));
            groupService.uploadFiles(fd, 'viewgroup/saveuploadcontacts/'+$scope.contact.groupId).success(function(data, status, headers, config) {
                console.log(data)
                if (data) {
                	  $(".upload-contact-close").click();
                	  $scope.loadGroups();
                } else {
                    $scope.errors = data.errors;
                    //menuService.setErrors(data.errors);
                }
            });
        }

        $scope.$on('fileuploaded1', function(ev, args) {
            $scope.saveExcelUpload();
        });

        $scope.loadGroups();

    }]);

function groupService($http) {
    this.page = 0;
    this.size = 10;
    this.getGroups = function getGroups() {
        return $http.get('viewgroup/getgroup');
    };

    this.getPagedGroups = function getPagedGroups() {
        return $http.get('viewgroup/getgroup?page=' + this.page + '&size='
                + this.size);
    }
    
    this.getPagedGroupContacts = function getPagedGroupsContacts(groupid) {
//    	var result = groupids.map(function(a) {return a.groupsno;});
    	var result = [];
    	result.push(groupid)
        return $http.post('viewcontacts/allcontacts/' , {'idsList' : result})
//        return $http.get('viewcontacts/m1v9d7?page=' + this.page + '&size='
//                + this.size+'&groupId='+groupid);
    } 

    this.saveorUpdate = function persistGroup(group) {
        return $http.post('viewgroup/savegroup', group)
    }
    
    this.deleteGroup = function deleteGroups(groupid) {
        return $http.get('viewgroup/deletegroup?id=' +groupid);
    }
    
    this.saveorUpdateContact = function persistContact(contact){
    	return $http.post('viewcontacts/savecontact', contact)
    }
    
    this.uploadFiles = function uploadFiles(fd, action) {
        return $http.post(action, fd, {
            transformRequest: angular.identity,
            headers: {
                'Content-Type': undefined
            }
        });
    }

}

groupapp.service('groupService', groupService);

// scripts/directives/integer.coffee
var INTEGER_REGEXP = /^\-?\d+$/;
groupapp.directive('integer', function () {
    return {
        require: 'ngModel',
        link: function (scope, elm, attrs, ctrl) {
            ctrl.$validators.integer = function (modelValue, viewValue) {
                if (ctrl.$isEmpty(modelValue))
                    return true;
                if (INTEGER_REGEXP.test(viewValue))
                    return true;
                return false;
            };
        }
    };
});

// scripts/filters/percentage.coffee
groupapp.filter('percentage', function () {
    return function (value) {
        return value * 100 + ' %';
    };
});

groupapp.directive('modalDialog',
        function () {
            return {
                restrict: 'E',
                scope: {
                    show: '='
                },
                transclude: true, // Insert custom content inside the
                // directive
                link: function (scope, element, attrs) {
                    console.log('attrs: ', attrs);
                    scope.dialogStyle = {};
                    if (attrs.boxWidth) {
                        scope.dialogStyle.width = attrs.boxWidth;
                    }
                    if (attrs.boxHeight) {
                        scope.dialogStyle.height = attrs.boxHeight;
                    }
                    scope.hideModal = function () {
                        scope.show = false;
                    };
                },
                template: "<div class='ng-modal' ng-show='show'>"
                        + "<div class='ng-modal-overlay' ng-click='hideModal()'></div> "
                        + " <div class='ng-modal-dialog' ng-style='dialogStyle'> "
                        + " <div class='ng-modal-close' ng-click='hideModal()'>X</div>"
                        + " <div class='ng-modal-dialog-content' ng-transclude></div>"
                        + " </div> " + " </div>"
            };
        });

groupapp.directive('fileModel', ['$parse', function($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            element.bind('change', function(evt) {
                scope.$apply(function() {
                    modelSetter(scope, element[0].files[0]);
//                    console.log(element);
                    if ($(element).hasClass('file')) {
                        scope.$broadcast('fileuploaded1');
                    } 
                    // evt.target.value = "";
                });
            });
        }
    };
}]);
