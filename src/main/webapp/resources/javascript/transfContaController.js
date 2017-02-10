var transfContaControllerApp = angular.module("transfContaControllerApp",[]);

transfContaControllerApp.controller("transfContaController",function($scope, $window, $http){
	
	/*DEFININDO O MODELO PARA O NOSSO FORMULÁRIO*/
	$scope.id			= null;
	$scope.nroconta		= null;
	$scope.cpf			= null;
	$scope.nome			= null;
	$scope.saldo 		= null;
	$scope.nrocontadest = null;
	$scope.valtransf	= null;
		
	$scope.transfConta = function(){
		
		/*DEFINI O OBJETO QUE VAI SER ENVIADO VIA AJAX PELO ANGULARJS*/
		var contaModel 			=  new Object();
		contaModel.id			= $scope.id;
		contaModel.nroconta		= $scope.nroconta;
		contaModel.cpf			= $scope.cpf;			
		contaModel.nome			= $scope.nome;
		contaModel.saldo  		= $scope.saldo;
		contaModel.nrocontadest	= $scope.nrocontadest;
		contaModel.valtransf	= $scope.valtransf;
		
		/*EXECUTA O POST PARA TRANSFERENCIA DE VALORES*/
		var response = $http.post("../transferir", contaModel);
		
		response.success(function(data, status, headers, config) {
	
		 /*MOSTRA O RESULTADO QUE RETORNOU DO SPRING*/
		 if(data.codigo == 1){
			 
			 /*MENSAGEM DE SUCESSO*/
			 $window.alert(data.mensagem);
			 
			 /*REDIRECIONA APÓS ALTERARMOS O REGISTRO*/
			 window.location.href = "../consultarContas.html";
			 
		 }
		 else{
			 
			 /*MOSTRA O ERRO TRATO PELO SPRING (OBJETO ResultadoModel)*/
			 $window.alert(data.mensagem);
			 
		 }
	 });
		
	 response.error(function(data, status, headers, config) {
		 /*SE OCORRER ERRO NÃO TRATADO IREMOS MOSTRA EM MENSAGEM*/
		 $window.alert(data);
		
	 });		
				
		
	};
	
});