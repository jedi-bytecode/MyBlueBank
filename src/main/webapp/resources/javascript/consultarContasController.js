var consultarContasControllerApp = angular.module("consultarContasControllerApp",[]);

consultarContasControllerApp.controller("consultarContasController",function($scope, $window, $http){
	
	/*CRIANDO UM ARRAY PARA OS REGISTROS QUE VÃO SER RETORNADOS PELO SPRING*/
	 $scope.contas = new Array();
	 
	 $scope.init = function(){
	
		 /*CHAMA O MÉTODO consultarTodasContas DO CONTROLLER GERENCIADO PELO SPRING*/
		 var response = $http.get("consultarTodasContas");
		 
		 response.success(function(data, status, headers, config) {
			
			 /*SETA OS REGISTROS QUE FORAM RETORNADOS DO CONTROLLER DO SPRING,
			  ESSE REGISTROS VÃO PREENCHER OS CAMPOS DA TABELA DA PÁGINA consultarConta.jsp
			  ATAVÉS DO ng-repeat do AngularJS*/
			 $scope.contas = data;
			 
		 });
		 
		 response.error(function(data, status, headers, config) {
			 /*SE OCORRER ERRO NÃO TRATADO IREMOS MOSTRA EM MENSAGEM*/
			 $window.alert(data);
			
		 });
	 }
	 
	 /*FUNÇÃO PARA EXCLUIR UM REGISTRO*/	 
	 $scope.excluirConta = function(id){
		 
		 if($window.confirm("Deseja realmente excluir esse registro?")){

			 /*CHAMA O MÉTODO DO SPRING PARA EXCLUIR UM REGISTRO*/
			 var response = $http.delete("excluirConta/" + id);
			 
			 response.success(function(data, status, headers, config) {
			
				 /*RECARREGANDO OS REGISTROS CADASTRADOS*/
				 $scope.init();
				 
			 });
			 
			 response.error(function(data, status, headers, config) {
				 /*SE OCORRER ERRO NÃO TRATADO IREMOS MOSTRA EM MENSAGEM*/
				 $window.alert(data);
				
			 });
			 
		 }
		 
		 
	 }
	 
});