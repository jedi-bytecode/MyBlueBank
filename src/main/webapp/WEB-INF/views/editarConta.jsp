<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE>
<html ng-app="editarContaControllerApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Registro</title>

<style type="text/css">

	label{
	    display: inline-block;
	    width: 90px;
	}
	
</style>
<script type="text/javascript" src="<spring:url value="/resources/javascript/angular.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/javascript/editarContaController.js"/>"></script>

</head>
<body>

<form name="myForm" ng-controller="editarContaController">

	<h2>Editar Cadastro de Contas</h2>
	<br/>

	<label for="input-id" style="width:150px;" >Id:</label>
	<input type="text" id="input-id" style="width:80px;" ng-model="id" readonly="readonly"  ng-init="id='${contaModel.id}'"/>
	
	<br/><br/>
		
	<label for="input-nroconta" style="width:150px;" >Número da Conta:</label> 
	<input type="text" id="input-nroconta" style="width:220px;" ng-model="nroconta"  ng-init="nroconta='${contaModel.nroconta}'"/>

	<br/><br/>

	<label for="input-cpf" style="width:150px;" >C.P.F.:</label>
	<input type="text" id="input-cpf" style="width:220px;" ng-model="cpf"  ng-init="cpf='${contaModel.cpf}'"/>
 		
	<br/><br/>
	
	<label for="input-nome" style="width:150px;" >Nome:</label>
	<input type="text" id="input-nome" style="width:220px;" ng-model="nome"  ng-init="nome='${contaModel.nome}'"/>

	<br/><br/>
		
	<label for="input-saldo" style="width:150px;" >Saldo:</label>
	<input type="text" id="input-saldo" style="width:220px;" ng-model="saldo"  ng-init="saldo='${contaModel.saldo}'"/>
	
	<br/><br/>
	
	<p>
		<a href= "../consultarContas.html">Voltar</a>
		
		<input type="button" value="Salvar" ng-click="alterarConta()"/>
				
	</p>
	
</form>
</body>
</html>