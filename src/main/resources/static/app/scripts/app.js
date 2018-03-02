angular.module("customerApp", ['ui.bootstrap', 'ui.bootstrap.tpls', 'ui.bootstrap.modal', 'ngSanitize', 'ui.bootstrap.progressbar', 'ui.bootstrap.pagination','ngAnimate', 'ui.router', 'ui.grid'])
.controller('MainController', ['$scope',function($scope) {
	$scope.helloMessage = "Hi Kishore";
}])
.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise('/home');
	$stateProvider.state('home', {
		url: '/home',
		templateUrl: 'app/views/home.html'
	}).state('customers', {
		url: '/customers',
		templateUrl: 'app/views/customers.html',
		controller: 'CustomerController'
	}).state('createCustomer', {
		url: '/createCustomer',
		templateUrl: 'app/views/create-customer.html',
		controller: 'CustomerController'
	}).state('deleteCustomer', {
		url: '/deleteCustomer',
		templateUrl: 'app/views/delete-customer.html',
		controller: 'CustomerController'
	}).state('updateCustomer', {
		url: '/updateCustomer',
		templateUrl: 'app/views/update-customer.html',
		controller: 'CustomerController'
	}).state('searchCustomer', {
		url: '/searchCustomer',
		templateUrl: 'app/views/search-customer.html',
		controller: 'CustomerController'
	});
}]);

angular.element(document).ready(function () {
	angular.bootstrap(document, ['customerApp']);
});