/**
 * 
 */
var app = angular.module('smsApp', ['ui.bootstrap', 'blockUI', 'dropdown-multiselect']);

app.controller('smsController', ['$scope', '$http', '$timeout', 'smsService', '$location', 'blockUI', function($scope, $http, $timeout, smsService, $location, blockUI) {
    var $ctrl = this;
    $scope.obj = {'type' : 'number'};
    $scope.date = 'no';
    
    
    $scope.sendSms = function(obj) {
    	if(obj.type === 'group'){
    		obj.smsMsisdn = obj.groupnumbers;
    	}
    	var d = new Date();
    	if(null != obj.date){
    		var s = obj.date;
    		var startDate = moment(s).toDate();
    		obj.date = moment(startDate).format('MM/DD/YYYY hh:mm a');
    	}
//    	obj.date=d.getDay()+"/"+parseInt(d.getMonth()+1)+"/"+d.getFullYear();
        $http.post("sendsms/smsDetails", obj).then(function(res) {
        	var prevType = $scope.obj.type;
        	$scope.obj = {'type' : prevType};
        	$scope.customfile = '';
        	$scope.file = '';
        	alert("sms Uploaded sucessfully");
        });
    }
    
    $scope.previewdata = [];
    $scope.preview = function(obj) {
        $http.post("sendsms/previewsms", obj).then(function(res) {
        	$scope.previewdata = res.data;
        });
    }


    $scope.saveExcelUpload = function() {
        var file = $scope.file;
        var fd = new FormData();
        if (null != file) {
            fd.append("excelfile", file);
        }
        fd.append("info", angular.toJson($scope.obj));

        smsService.uploadFiles(fd, 'sendsms/saveupload').success(function(data, status, headers, config) {
            console.log(data)
            $scope.uploadCounts = data.dto;
            alert("total :: " + data.dto.total + " ,  invalid :: " + data.dto.invalid + " ,  duplicate :: " + data.dto.duplicate);
            $scope.obj['filepath'] = data.fileName;
            $scope.file = null;
            if (data == true) {

                //				$scope.loadUsers();
                //				$scope.screen = 'list';
                //				$scope.notification = {};
                //				$scope.modalShown = !$scope.modalShown;
                //menuService.setSuccess("Code saved successfully.");
            } else {
                $scope.errors = data.errors;
                //menuService.setErrors(data.errors);
            }
        });

    }

    $scope.$on('fileuploaded1', function(ev, args) {
        $scope.saveExcelUpload();
    });

    $scope.$on('fileuploaded', function(ev, args) {
        $scope.saveImage();
    });
    
    
    $scope.uploadCustomSms = function() {
        var file = $scope.customfile;
        var fd = new FormData();
        if (null != file) {
            fd.append("file", file);
        }
        smsService.uploadFiles(fd, 'sendsms/customsms').success(function(data, status, headers, config) {
            console.log(data)
            if (data != null) {
            	var count = 0 ;
            	$scope.customsms = data.sampledata;
            	$scope.obj['filepath'] = data.fileName;
            	console.log($scope.customsms)
            } else {
                $scope.errors = data.errors;
            }
        });
    }
    
    
    $scope.custommsg = function(column){
    	$scope.obj.smsMessage = ($scope.obj.smsMessage != null ? $scope.obj.smsMessage : '') + '#' + column +'#';
    }

    $scope.saveImage = function() {
        var type = 1;
        var file = $scope.image;
        if (file == null) {
            type = 2;
            var file = $scope.video;
        }
        var fd = new FormData();
        if (null != file) {
            fd.append("file", file);
        }
        smsService.uploadFiles(fd, 'sendsms/saveimage?type=' + type).success(function(data, status, headers, config) {
            console.log(data)
            if (data != null) {

                $scope.obj.smsMessage = ($scope.obj.smsMessage != undefined ? ($scope.obj.smsMessage + ' ') : '') + $location.protocol() + '://' + $location.host() + ':' + $location.port() + '/cms/' + data;

                //				$scope.imagedisplay = $location.protocol() + '://'+ $location.host() +':'+  $location.port()  +'/'+data;
                //				$scope.loadUsers();
                //				$scope.screen = 'list';
                //				$scope.notification = {};
                //				$scope.modalShown = !$scope.modalShown;
                //menuService.setSuccess("Code saved successfully.");
            } else {
                $scope.errors = data.errors;
                //menuService.setErrors(data.errors);
            }
        });

    }

    $scope.groups = [];
   $scope.getGroups =  function(){
		   smsService.getGroups().success(function(response) {
	        $scope.groups = response;
	    }).error(function(response) {
	        console.log("Error while fetching users");
	    });
   }


    smsService.getSenderIds().success(function(response) {
        $scope.senderids = response;
    }).error(function(response) {
        console.log("Error while fetching users");
    });

    $scope.selectedgroups = [];
    
    $scope.fetchcontacts = function(){
    	console.log($scope.selectedgroups);
    	smsService.getGroupContacts($scope.selectedgroups).success(function(response) {
	        $scope.contacts = response;
	        $scope.changegrounumbers();
	    }).error(function(response) {
	        console.log("Error while fetching users");
	    });
    }
    $scope.changegrounumbers = function(){
    	var result = $scope.contacts.map(function(a) { 
    		if(a.selected) {
    			return a.msisdn;
    		}else{
    			return null;
    		}
    	});
        $scope.obj['groupnumbers'] = result.filter(function(el){ return (el !== "" && el !== null) }).join(",");
        $scope.count($scope.obj['groupnumbers'], true);
    }
    $scope.charcnt = 0;
    $scope.creditscnt = 0;
    $scope.mobilecnt = 0;
    $scope.count = function(string, mobile){
    	if(mobile){
    		$scope.mobilecnt = string.length > 0 ?  string.split(",").length : 0;
    	}else {
    		$scope.charcnt = string.length;
    		$scope.creditscnt = parseInt(string.length / 160) +1 ;
    	}
    }

    $scope.config = {
        options: $scope.groups,
        trackBy: 'groupsno',
        displayBy: ['groupname', 'contactsCount'],
        divider: ':',
        icon: 'glyphicon glyphicon-heart',
        displayBadge: true,
        height: '200px',
        filter: true
    };
    $scope.drafts = [];
    $scope.fetchdrafts = function(){
    	if($scope.drafts.length == 0){
	    	smsService.fetchDetails('sendsms/drafts').success(function(response) {
		        $scope.drafts = response;
		    }).error(function(response) {
		        console.log("Error while fetching drafts");
		    });
    	}
    }
    
    $scope.smppids = [];
	smsService.fetchDetails('viewusers/getsmppids').success(function(response) {
        $scope.smppids = response;
    }).error(function(response) {
        console.log("Error while fetching drafts");
    });
    
    
    
    $scope.savedraft = function(message){
    	if(message != null && message != ''){
		    	smsService.savedraft({'draftMessage' : message}).success(function(response) {
			        $scope.drafts = response;
			    }).error(function(response) {
			        console.log("Error while fetching drafts");
			    });
    	}
    }
    
    $scope.dropdownSelected = function(){
    	$scope.fetchcontacts();
    }
    
    $scope.langChange = function onLoad(){	
    	try {
            var options = {
                sourceLanguage: 'en',
                destinationLanguage: ['hi', 'kn', 'ml', 'ta', 'te', 'ur'],
                shortcutKey: 'ctrl+g',
                transliterationEnabled: true
            };
//            $('#showLangControls').show();
            // Create an instance on TransliterationControl with the required
            // options.
            var control =
                    new google.elements.transliteration.TransliterationControl(options);
            $('#showLangControls').html("");
            if($scope.obj.messageType != 1){
	            // Enable transliteration in the textfields with the given ids.
            	$("#encodedMessage").show();
            	$("#smsMessage").hide();
	            var ids = ["encodedMessage"];
	            control.makeTransliteratable(ids);
	            // Show the transliteration control which can be used to toggle between
	            // English and Hindi and also choose other destination language.
	            $('#showLangControls').show();
	            control.showControl('showLangControls');
	            
            }else{
 	            $('#showLangControls').hide();
 	           $("#encodedMessage").hide();
 	           $("#smsMessage").show();
            }
        } catch (ex) {
        	console.log(ex);
        }	
    	
    }
    
    //$scope.$watch($scope.selectedgroups, $scope.fetchcontacts());

}]);

function smsService($http) {
    this.page = 0;
    this.size = 10;
    this.getUsers = function getUsers() {
        return $http.get('viewusers/getusers');
    };

    this.getPagedUsers = function getPagedUsers() {
        return $http.get('viewusers/getusers?page=' + this.page + '&size=' +
            this.size);
    }

    this.getUserTypes = function getUserTypes() {
        return $http.get('usertypes/getallusertypes');
    }

    this.saveorUpdate = function persistUser(user) {
        return $http.post('viewusers/saveuser', user)
    }
    
    this.savedraft = function persistdraft(draft) {
        return $http.post('sendsms/savedraft', draft)
    }

    this.getSenderIds = function fetchSenderIds() {
        return $http.get('viewsenderids/getallsenderids')
    }

    this.getGroups = function fetchGroups() {
        return $http.get('viewgroup/getallgroup')
    }
    
    this.fetchDetails = function fetchDetails(url){
    	return $http.get(url);
    }

    this.getGroupContacts = function fetchGroupContacts(groupids) {
    	var result = groupids.map(function(a) {return a.groupsno;});
        return $http.post('viewcontacts/allcontacts/' , {'idsList' : result})
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

app.service('smsService', smsService);

app.directive('fileModel', ['$parse', function($parse) {
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
                    } else if ($(element).hasClass('image') || $(element).hasClass('video')){
                        scope.$broadcast('fileuploaded');
                    }
                    // evt.target.value = "";
                });
            });
        }
    };
}]);


