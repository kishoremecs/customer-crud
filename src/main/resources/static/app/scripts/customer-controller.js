angular.module("customerApp")
.controller("CustomerController", ["$scope", "$http", function ($scope, $http) {

	var baseUrl = "/customerApp";
	$http.get(baseUrl+'/customer/list')
	.success(function(data) {
		$scope.custoemrs = data;
	});

	$scope.gridOptions = {
        data: 'custoemrs',
        enablePaging: true,
        showFooter: true
    };

	$scope.createCustomer = function () {
		
		$http.put(baseUrl+'/customer/save/', 
			JSON.stringify(
				{
					name: $scope.customerName,
					address: $scope.customerAddress,
					phoneNumber: $scope.customerPhone
				}
			)
		).success(function(data, status) {
			alert(status);
			if(status == 200) {
				alert('Successfully created the Customer');
			}
		});
	}

	$scope.deleteCustomer = function () {
		$http.delete(baseUrl+'/customer/delete/'+$scope.customerName)
		.success(function(data, status) {

			if(status == 200) {
				alert('Successfully deleted the Customer');
			}
		});
	}

	$scope.updateCustomer = function () {
		$http.post(baseUrl+'/customer/update/',
		JSON.stringify(
				{
					name: $scope.customerName,
					address: $scope.customerAddress,
					phoneNumber: $scope.customerPhone
				}
			))
		.success(function(data, status) {

			if(status == 200) {
				alert('Successfully deleted the Customer');
			}
		});
	}

	$scope.searchCustomer = function () {
		$http.get(baseUrl+'/customer/search/'+$scope.customerName)
		.success(function(data, status) {
			$scope.custoemrs = data;
		}) ;
	}
}]);