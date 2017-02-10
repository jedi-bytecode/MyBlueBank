var incluirContaControllerApp = angular.module("incluirContaControllerApp",[]);

incluirContaControllerApp.controller("incluirContaController",function($scope, $window, $http){
	
	/* DEFININDO O MODELO PARA O NOSSO FORMULÁRIO */
	$scope.id 		= null;
	$scope.nroconta	= null;
	$scope.cpf		= null;
	$scope.nome 	= null;
	$scope.saldo 	= null;

	$scope.salvarConta = function(){
		
		/* DEFINI O OBJETO QUE VAI SER ENVIADO VIA AJAX PELO ANGULARJS */
		var contaModel 			= new Object();
		contaModel.nroconta		= $scope.nroconta;
		contaModel.cpf 			= $scope.cpf;		
		contaModel.nome			= $scope.nome;	
		contaModel.saldo		= $scope.saldo;
		
		/* EXECUTA O POST PARA SALVAR O REGISTRO */
		var response = $http.post("salvar", contaModel);
	 
		response.success(function(data, status, headers, config) {
	
		 /* MOSTRA O RESULTADO QUE RETORNOU DO SPRING */
		 if(data.codigo == 1){
			 
			 /* MENSAGEM DE SUCESSO */
			 $window.alert(data.mensagem);
			 
			 /* LIMPA OS CAMPOS APÓS SALVAR O REGISTRO COM SUCESSO */
			 $scope.nroconta	= null;
			 $scope.cpf			= null;
			 $scope.nome		= null;
			 $scope.saldo		= null;
		 }
		 else{
			 
			 /* MOSTRA O ERRO TRATO PELO SPRING (OBJETO ResultadoModel) */
			 $window.alert(data.mensagem);
			 
		 }
	 });
		
	 response.error(function(data, status, headers, config) {
		 /* SE OCORRER ERRO NÃO TRATADO IREMOS MOSTRA EM MENSAGEM */
		 $window.alert(data);
		
	 });						
		
	};
	
});