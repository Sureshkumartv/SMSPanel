/**
 * 
 */

var scheduledapp = angular.module('scheduledApp', ['ui.bootstrap' , 'blockUI']);

scheduledapp.controller('ScheduledCntrl', [
    '$scope',
    'scheduledService', 'blockUI',
    function ($scope, scheduledService, blockUI) {
    	$scope.excelSno = 0;
        $scope.schudeled = [];
        $scope.reportType = 'Web Reports'
        $scope.deletescheduled = function (client) {
            var index = $scope.clients.indexOf(client);
            $scope.clients.splice(index, 1);
        };

        $scope.createscheduled = function () {
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

        $scope.loadScheduled = function () {
           scheduledService.getScheduled().success(function (response) {
                $scope.scheduled = response;
                $scope.currentPage = $scope.scheduled.number + 1;

            }).error(function (response) {
                console.log("Error while fetching scheduled");
            });
        }

        $scope.pageChanged = function () {
            scheduledService.page = $scope.currentPage - 1;
            scheduledService.size = $scope.scheduled.size;

            scheduledService.getPagedScheduled().success(function (response) {
                $scope.scheduled = response;
                $scope.currentPage = $scope.scheduled.number + 1;

            }).error(function (response) {
                console.log("Error while fetching scheduled");
            });
        };
        
        $scope.loadScheduledHistory = function (excelsno) {
            scheduledService.getScheduledHistory(excelsno).success(function (response) {
                 $scope.history = response;
             }).error(function (response) {
                 console.log("Error while fetching scheduled");
             });
         }
        
        $scope.loadHttpHistory = function(date){
        	scheduledService.getHttpHistory(date).success(function (response) {
                $scope.history = response;
            }).error(function (response) {
                console.log("Error while fetching scheduled");
            });
        }
        
        $scope.setExcelSno = function(excelSno){
        	$scope.excelSno = excelSno;
        	$scope.date = '';
        }
        $scope.setDate = function(date){
        	$scope.excelSno = '';
        	$scope.date = date;
        }
        
        $scope.hideModal = function(){
        	$("#downloadModal").modal('hide');
        }

        $scope.modalShown = false;
        $scope.toggleModal = function () {
            $scope.modalShown = !$scope.modalShown;
        };
        
        $(".close").on('click', function(event, reason, closed) {
        	 $scope.history  = [];
        });

        $scope.loadScheduled();
        
        $scope.loadHttpScheduled = function () {
            scheduledService.getHttpScheduled().success(function (response) {
                 $scope.httpscheduled = response;
                 $scope.currentPage = $scope.scheduled.number + 1;

             }).error(function (response) {
                 console.log("Error while fetching scheduled");
             });
         }
        
        $scope.loadHttpScheduled();
        
        $('.btn-toggle').click(function() {
            $(this).find('.btn').toggleClass('active');  
            
            if ($(this).find('.btn-primary').length>0) {
            	$(this).find('.btn').toggleClass('btn-primary');
            }
            if ($(this).find('.btn-danger').length>0) {
            	$(this).find('.btn').toggleClass('btn-danger');
            }
            if ($(this).find('.btn-success').length>0) {
            	$(this).find('.btn').toggleClass('btn-success');
            }
            if ($(this).find('.btn-info').length>0) {
            	$(this).find('.btn').toggleClass('btn-info');
            }
            
            $(this).find('.btn').toggleClass('btn-default');
            
            if($(this).find('.btn').hasClass('active')){
            	$scope.reportType = $(this).find('.btn').html();
            }
               
        });

        
    }]);

function scheduledService($http) {
    this.page = 0;
    this.size = 10;
    this.getScheduled = function getScheduled() {
        return $http.get('viewscheduled/getscheduled');
    };

    this.getPagedScheduled = function getPagedScheduled() {
        return $http.get('viewscheduled/getscheduled?page=' + this.page + '&size=' + this.size);
    }
    
    this.getScheduledHistory = function getScheduledHistory(excelsno) {
        return $http.get('viewhistory/getexcelhistory?excelsno=' +excelsno);
    } 
    
    this.getHttpScheduled = function getScheduledHttpHistory() {
        return $http.get('viewhistory/gethttpscheduled?page=' + this.page + '&size=' + this.size);
    } 
    
    this.getHttpHistory = function getHttpHistory(date) {
        return $http.get('viewhistory/gethttphistory?date='+date);
    } 
    
    
}

scheduledapp.service('scheduledService', scheduledService);

// scripts/directives/integer.coffee
var INTEGER_REGEXP = /^\-?\d+$/;
scheduledapp.directive('integer', function () {
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
scheduledapp.filter('percentage', function () {
    return function (value) {
        return value * 100 + ' %';
    };
});

scheduledapp.directive('modalDialog', function () {
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


//function hideModal(){
//	$("#downloadModal").modal('hide');
//	
//}