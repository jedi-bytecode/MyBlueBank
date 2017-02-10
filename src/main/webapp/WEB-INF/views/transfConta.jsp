<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE>
<html ng-app="transfContaControllerApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transferência entre Contas</title>

<style type="text/css">

	label{
	    display: inline-block;
	    width: 90px;
	}
	
</style>
<script type="text/javascript" src="<spring:url value="/resources/javascript/angular.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/javascript/transfContaController.js"/>"></script>

</head>
<body>

<form name="myForm" ng-controller="transfContaController">

	<h2>Transferência entre Contas</h2>
	<br/>

	<label for="input-contaorigem" style="width:150px;" >Conta Origem:</label>
	<br/>	
	<label for="input-id" style="width:150px;" >Id:</label>
	<input type="text" id="input-id" style="width:80px;" ng-model="id" readonly="readonly" ng-init="id='${contaModel.id}'"/>
	
	<br/><br/>
		
	<label for="input-nroconta" style="width:150px;" >Número da Conta:</label> 
	<input type="text" id="input-nroconta" style="width:220px;" ng-model="nroconta" readonly="readonly" ng-init="nroconta='${contaModel.nroconta}'"/>

	<br/><br/>

	<label for="input-cpf" style="width:150px;">C.P.F.:</label>
	<input type="text" id="input-cpf" style="width:220px;" ng-model="cpf" readonly="readonly" ng-init="cpf='${contaModel.cpf}'"/>
 		
	<br/><br/>
	
	<label for="input-nome" style="width:150px;">Nome:</label>
	<input type="text" id="input-nome" style="width:220px;" ng-model="nome" readonly="readonly" ng-init="nome='${contaModel.nome}'"/>

	<br/><br/>
		
	<label for="input-saldo" style="width:150px;">Saldo:</label>
	<input type="text" id="input-saldo" style="width:220px;" ng-model="saldo" readonly="readonly" ng-init="saldo='${contaModel.saldo}'"/>
	
	<br/><br/>
	
	<br/><br/>
	<label for="input-contadest" style="width:150px;">Conta Destino:</label>
	<br/>
		
	<label for="input-nrocontadest" style="width:150px;">Número da Conta:</label> 
	<input type="text" id="input-nrocontadest" style="width:220px;" ng-model="nrocontadest" ng-init="nrocontadest='${contaModel.nrocontadest}'"/>

	<br/><br/>
		
	<label for="input-valtransf" style="width:150px;">Valor a Transferir:</label>
	<input type="text" id="input-valtransf" style="width:220px;" ng-model="valtransf" ng-init="valtransf='${contaModel.valtransf}'"/>

	<br/><br/>
	
	
	<p>
		<a href= "../consultarContas.html">Voltar</a>		
		<input type="button" value="Transferir" ng-click="transfConta()"/>
				
	</p>
	
</form>
</body>
</html>