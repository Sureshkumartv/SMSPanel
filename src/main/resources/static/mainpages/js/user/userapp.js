/**
 * 
 */

var userapp = angular.module('userApp', [ 'ui.bootstrap' , 'blockUI' ]);

userapp.controller('UsersCntrl', [ '$scope', 'userService' , 'blockUI',
		function($scope, userService, blockUI) {
			$scope.user = {};
			$scope.users = [];
			$scope.smppIDs = [];
			$scope.smssendtypes = [{'id' : 1 , 'value': 'Information'}, { 'id': 2, 'value' : 'Promotional'}];
			

			$scope.loadUsers = function() {
				userService.getUsers().success(function(response) {
					$scope.users = response;
					$scope.currentPage = $scope.users.number + 1;

				}).error(function(response) {
					console.log("Error while fetching users");
				});
			}
			$scope.addUser = function(){
				$scope.user = {};
			} 
			$scope.editUser = function(user){
				$scope.user = user;
			}
			$scope.loadSmppIds= function() {
				userService.getSmppIds().success(function(response) {
					$scope.smppIDs = response;
				}).error(function(response) {
					console.log("Error while fetching users");
				});
			}
			$scope.loadUserTypes = function() {
				userService.getUserTypes().success(function(response) {
					$scope.usertypes = response;
				}).error(function(response) {
					console.log("Error while fetching users");
				});
			}

			$scope.pageChanged = function() {
				userService.page = $scope.currentPage - 1;
				userService.size = $scope.users.size;

				userService.getPagedUsers().success(function(response) {
					$scope.users = response;
					$scope.currentPage = $scope.users.number + 1;

				}).error(function(response) {
					console.log("Error while fetching users");
				});
				// $http.get(url + "?page=" + page + "&size=" + size).success(
				// function(response) {
				// $scope.users = response;
				// $scope.currentPage = $scope.users.number+1;
				// });
			};

			$scope.modalShown = false;
			$scope.toggleModal = function(user) {
				$scope.user = user;
				$scope.modalShown = !$scope.modalShown;
			};
			
			
			
			$scope.create = function(screen, user){
				if(true){
//					$scope.user = user;
					userService.saveorUpdate(user).success(function(data, status, headers, config) {
						console.log(data)
						if(data == true) {
							$scope.loadUsers();
							$scope.screen = 'list';
							$scope.notification = {};
							$scope.modalShown = !$scope.modalShown;
							$(".add-user-close").click();
							//menuService.setSuccess("Code saved successfully.");
						}else{
							$scope.errors = data.errors; 
							//menuService.setErrors(data.errors);
						}
					});
				}
			};
			
			$scope.addCredits = function(user){
				$scope.credits = {"userDetail" : user};
			}
			
			$scope.submitCredits = function(){
				userService.submitCredits($scope.credits).success(function(data, status, headers, config) {
					if(data == true) {
						$scope.loadUsers();
						$scope.screen = 'list';
						$scope.notification = {};
						$scope.modalShown = !$scope.modalShown;
						$(".add-credits-close").click();
					}else{
						$scope.errors = data.errors; 
					}
				});
			};

			$scope.loadUsers();
			$scope.loadUserTypes();
			$scope.loadSmppIds();
} ]);

function userService($http) {
	this.page = 0;
	this.size = 10;
	this.getUsers = function getUsers() {
		return $http.get('viewusers/getusers');
	};

	this.getPagedUsers = function getPagedUsers() {
		return $http.get('viewusers/getusers?page=' + this.page + '&size='
				+ this.size);
	}

	this.getUserTypes = function getUserTypes() {
		return $http.get('usertypes/getallusertypes');
	}
	
	this.saveorUpdate = function persistUser(user){
		return $http.post('viewusers/saveuser', user)
	}
	
	this.getSmppIds = function getSmppIds(){
		return $http.get("viewusers/getsmppids");
	}
	
	this.submitCredits = function submitCredits(credits){
		return $http.post("viewusers/submitcredits", credits);
	}
	
	
	
}

userapp.service('userService', userService);

// scripts/directives/integer.coffee
var INTEGER_REGEXP = /^\-?\d+$/;
userapp.directive('integer', function() {
	return {
		require : 'ngModel',
		link : function(scope, elm, attrs, ctrl) {
			ctrl.$validators.integer = function(modelValue, viewValue) {
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
userapp.filter('percentage', function() {
	return function(value) {
		return value * 100 + ' %';
	};
});

userapp.directive('modalDialog',
function() {
	return {
		restrict : 'E',
		scope : {
			show : '='
		},
		transclude : true, // Insert custom content inside the
							// directive
		link : function(scope, element, attrs) {
			console.log('attrs: ', attrs);
			scope.dialogStyle = {};
			if (attrs.boxWidth) {
				scope.dialogStyle.width = attrs.boxWidth;
			}
			if (attrs.boxHeight) {
				scope.dialogStyle.height = attrs.boxHeight;
			}
			scope.hideModal = function() {
				scope.show = false;
			};
		},
		template : "<div class='ng-modal' ng-show='show'>"
				+ "<div class='ng-modal-overlay' ng-click='hideModal()'></div> "
				+ " <div class='ng-modal-dialog' ng-style='dialogStyle'> "
				+ " <div class='ng-modal-close' ng-click='hideModal()'>X</div>"
				+ " <div class='ng-modal-dialog-content' ng-transclude></div>"
				+ " </div> " + " </div>"
	};
});
