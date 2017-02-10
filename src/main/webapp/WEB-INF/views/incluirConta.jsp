<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE>
<html ng-app="incluirContaControllerApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incluir Conta</title>

<style type="text/css">

	label{
	    display: inline-block;
	    width: 90px;
	}
	
</style>
<script type="text/javascript" src="../resources/javascript/angular.min.js"></script>
<script type="text/javascript" src="../resources/javascript/incluirContaController.js"></script>

</head>
<body>

<form ng-controller="incluirContaController">
    	
	<h2>Novo Cadastro de Conta</h2>
	<br/>
		
	<label for="input-nroconta" style="width:150px;" >Nro. Conta:</label>
	<input type="text" id="input-nroconta" style="width:220px;" ng-model="nroconta"/>

	<br/><br/>

	<label for="input-cpf" style="width:150px;" >CPF:</label>
	<input type="text" id="input-cpf" style="width:220px;" ng-model="cpf"/>
 		
	<br/><br/>
	
	<label for="input-nome" style="width:150px;" >Nome:</label>
	<input type="text" id="input-nome" style="width:220px;" ng-model="nome"/>
 		
	<br/><br/>

	<label for="input-saldo" style="width:150px;" >Saldo:</label>
	<input type="text" id="input-saldo" style="width:220px;" ng-model="saldo"/>
 		
	<br/><br/>

	<p>
		<a href= "../">Voltar</a>
		
		<input type="button" value="Salvar" ng-click="salvarConta()"/>
	 		
	</p>    
        
</form>



</html>