/**
 * 
 */

var senderidapp = angular.module('senderidApp', ['ui.bootstrap', 'blockUI']);

senderidapp.controller('SenderidsCntrl', [
    '$scope',
    '$http',
    'senderidService',
    'blockUI',
    function ($scope,$http, senderidService, blockUI) {
        $scope.senderids = [];
        $scope.deleteSenderid = function (client) {
            var index = $scope.clients.indexOf(client);
            $scope.clients.splice(index, 1);
        };

        $scope.saveSnderId=function(val){
        	 $http.get("viewsenderids/savesenderid/"+val).then(function(res) {
        		 $("#addsender").modal('hide');
             });
        	 $scope.loadSenderids();
        }
        
        $scope.createSenderid = function () {
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

        $scope.loadSenderids = function () {
        	blockUI.start();
            senderidService.getSenderids().success(function (response) {
                $scope.senderids = response;
                $scope.currentPage = $scope.senderids.number + 1;
                blockUI.stop();
            }).error(function (response) {
                console.log("Error while fetching senderids");
            });
        }

        $scope.pageChanged = function () {
            senderidService.page = $scope.currentPage - 1;
            senderidService.size = $scope.senderids.size;

            senderidService.getPagedSenderids().success(function (response) {
                $scope.senderids = response;
                $scope.currentPage = $scope.senderids.number + 1;

            }).error(function (response) {
                console.log("Error while fetching senderids");
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

        $scope.loadSenderids();
    }]);

function senderidService($http) {
    this.page = 0;
    this.size = 10;
    this.getSenderids = function getSenderids() {
        return $http.get('viewsenderids/getsenderids');
    };

    this.getPagedSenderids = function getPagedSenderids() {
        return $http.get('viewsenderids/getsenderids?page=' + this.page + '&size=' + this.size);
    }
}

senderidapp.service('senderidService', senderidService);

// scripts/directives/integer.coffee
var INTEGER_REGEXP = /^\-?\d+$/;
senderidapp.directive('integer', function () {
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
senderidapp.filter('percentage', function () {
    return function (value) {
        return value * 100 + ' %';
    };
});

senderidapp.directive('modalDialog', function () {
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
