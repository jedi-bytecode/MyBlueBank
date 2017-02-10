<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html ng-app="consultarContasControllerApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Contas</title>

<script type="text/javascript" src="../resources/javascript/angular-locale_pt-br.js"></script>
<script type="text/javascript" src="../resources/javascript/angular.min.js"></script>
<script type="text/javascript" src="../resources/javascript/consultarContasController.js"></script>

</head>
<body>

	<table ng-controller="consultarContasController"  data-ng-init="init()">
     <thead>
       <tr>
       	 <th align="center">ID</th>
         <th align="center">Nro.Conta</th>
         <th align="center">C.P.F.</th>
         <th align="center">Nome</th>
         <th align="center">Saldo</th>
         <th></th>
         <th></th>
       </tr>
     </thead>
     <tbody>
       <tr ng-repeat="conta in contas">
                
         <td align="right">{{ conta.id }}</td>
         <td align="center">{{ conta.nroconta }}</td>
         <td align="left">{{ conta.cpf }}</td>          
         <td align="left">{{ conta.nome }}</td>
         <td align="right">{{ conta.saldo | currency : 'R$'}}</td>      
         <td><a ng-href="editarConta.html/{{conta.id}}" >Editar</a></td>
         <td align="right"></td>
         <td><a ng-href="transfConta.html/{{conta.id}}" >Transferir Valor</a></td>
         <td align="right"></td>
         <td><a href="#" ng-click="excluirConta(conta.id)">Excluir</a></td>         
       </tr>
     </tbody>
   </table>
   
   <a href= "../">Voltar</a>
   	
   
</body>
</html>