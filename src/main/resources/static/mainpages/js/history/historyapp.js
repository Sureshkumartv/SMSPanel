/**
 * 
 */

var historyapp = angular.module('historyApp', ['ui.bootstrap', 'blockUI']);

historyapp.controller('HistoryCntrl', [
    '$scope',
    'historyService', 'blockUI', 
    function ($scope, historyService, blockUI) {

        $scope.groups = [];
        $scope.deletehistory = function (client) {
            var index = $scope.clients.indexOf(client);
            $scope.clients.splice(index, 1);
        };

        $scope.createhistory = function () {
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

        $scope.loadHistory = function () {
            historyService.getHistory().success(function (response) {
                $scope.history = response;
                $scope.currentPage = $scope.history.number + 1;

            }).error(function (response) {
                console.log("Error while fetching senderids");
            });
        }

        $scope.pageChanged = function () {
            historyService.page = $scope.currentPage - 1;
            historyService.size = $scope.history.size;

            historyService.getPagedHistory().success(function (response) {
            	$scope.history = response;
                $scope.currentPage = $scope.history.number + 1;

            }).error(function (response) {
                console.log("Error while fetching history");
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

        $scope.loadHistory();
    }]);

function historyService($http) {
    this.page = 0;
    this.size = 10;
    this.getHistory = function getHistory() {
        return $http.get('viewhistory/gethttphistory');
    };

    this.getPagedHistory = function getPagedHistory() {
        return $http.get('viewhistory/gethttphistory?page=' + this.page + '&size=' + this.size);
    }
}

historyapp.service('historyService', historyService);

// scripts/directives/integer.coffee
var INTEGER_REGEXP = /^\-?\d+$/;
historyapp.directive('integer', function () {
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
historyapp.filter('percentage', function () {
    return function (value) {
        return value * 100 + ' %';
    };
});

historyapp.directive('modalDialog', function () {
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
