/**
 * 
 */

var contactsapp = angular.module('contactsApp', ['ui.bootstrap']);

contactsapp.controller('ContactsCntrl', [
    '$scope',
    'contactsService',
    function ($scope, contactsService) {
        $scope.contact = {};
        $scope.contacts = [];
        $scope.deletecontact = function (client) {
            var index = $scope.clients.indexOf(client);
            $scope.clients.splice(index, 1);
        };

        $scope.createcontacts = function () {
            $scope.newClient.id = $scope.clients.length + 1;
            $scope.clients.push($scope.newClient);
            $scope.newClient = null;
        };

        $scope.edit = function (client) {
            $scope.activeClient = client;
        };
        $scope.update = function (client) {
            $scope.activeClient = null;
        };

        $scope.loadContacts = function () {
            contactsService.getContacts().success(function (response) {
                $scope.contacts = response;
                $scope.currentPage = $scope.contacts.number + 1;

            }).error(function (response) {
                console.log("Error while fetching senderids");
            });
        }
        $scope.loadAllGroups = function () {
            contactsService.getAllGroups().success(function (response) {
                $scope.groups = response;

            }).error(function (response) {
                console.log("Error while fetching groups");
            });
        }

        $scope.pageChanged = function () {
            contactsService.page = $scope.currentPage - 1;
            contactsService.size = $scope.contacts.size;

            contactsService.getPagedContacts().success(function (response) {
                $scope.contacts = response;
                $scope.currentPage = $scope.contacts.number + 1;

            }).error(function (response) {
                console.log("Error while fetching contacts");
            });
//				$http.get(url + "?page=" + page + "&size=" + size).success(
//				function(response) {
//					$scope.users = response;
//					$scope.currentPage = $scope.users.number+1;
//				});
        };

        $scope.modalShown = false;
        $scope.toggleModal = function () {
            $scope.modalShown = !$scope.modalShown;
        };

        $scope.loadContacts();
         $scope.loadAllGroups();
        
    }]);

function contactsService($http) {
    this.page = 0;
    this.size = 10;
    this.getContacts = function getContacts() {
        return $http.get('viewcontacts/getcontacts');
    };

    this.getPagedContacts = function getPagedContacts() {
        return $http.get('viewcontacts/getcontacts?page=' + this.page + '&size=' + this.size);
    }
    this.getAllGroups = function getAllGroups() {
        return $http.get('viewgroups/getallgroups');
    };
}

contactsapp.service('contactsService', contactsService);

// scripts/directives/integer.coffee
var INTEGER_REGEXP = /^\-?\d+$/;
contactsapp.directive('integer', function () {
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
contactsapp.filter('percentage', function () {
    return function (value) {
        return value * 100 + ' %';
    };
});

contactsapp.directive('modalDialog', function () {
    return {
        restrict: 'E',
        scope: {
            show: '='
        },
        transclude: true, // Insert custom content inside the directive
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
                + " </div> "
                + " </div>"
    };
});
