Blue Bank
- Desenvolvido utilizando:
	- Wildfly
	- MySQL
	- Eclipse
	- Maven
	- Spring
	- AngularJS
	
- Passos para testar

==>> 1- No MySQL, execute o script abaixo que cria um Schema e tabela para uso do BlueBank:

// ############################################################### //

CREATE DATABASE `db_bluebank` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE db_bluebank.tb_conta (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` bigint(20) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `nroconta` bigint(20) DEFAULT NULL,
  `saldo` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

// ############################################################### //

A carga no DB não é necessária, será possível realizar cadastro através do BlueBank, mas caso queira dar carga do db manualmente o script encontra abaixo:

// ############################################################### //

INSERT INTO db_bluebank.tb_conta (`id`,`cpf`,`nome`,`nroconta`,`saldo`) VALUES (1,12345678912,'Conta 1',11,100.00);
INSERT INTO db_bluebank.tb_conta (`id`,`cpf`,`nome`,`nroconta`,`saldo`) VALUES (2,98765432198,'Conta 2',22,100.00);
INSERT INTO db_bluebank.tb_conta (`id`,`cpf`,`nome`,`nroconta`,`saldo`) VALUES (3,14725836914,'Conta 2',33,100.00);
INSERT INTO db_bluebank.tb_conta (`id`,`cpf`,`nome`,`nroconta`,`saldo`) VALUES (4,45678912345,'Conta 4',44,100.00);

// ############################################################### //


==>> 2- No Eclipse, importe o projeto como "Existing Maven Project...", aguardar o download das bibliotecas pelo Maven. Se tudo correr bem, o projeto não deverá apresentar erro de compilação. Caso contrário force uma atualização pelo Maven clicando com o botão esquerdo do mouse sobre o projeto e escolha "Maven.. / Update Project..." e clique em "OK"

3- Não esquecer de configurar o arquivo persistence.xml na aplicação de acordo com um jdbc já configurado no Wildfly, ou faça a configuação usando como exemplo o trecho do arquivo standalone.xml abaixo, que é a configuração utilizada pelo persistence.xml deste projeto. 
NOTA: ATENÇÃO PARA USUÁRIO E SENHA CONFIGURADO DE ACORDO COM O USUÁRIO UTILIZADO NO MYSQL, no caso abaixo, user=root e pass=admin

- segue trecho do datasource configurado no wildfly, arquivo ==>> $WILDFLY_HOME/standalone/configuration/standalone.xml

    <datasources>
        <datasource jta="true" jndi-name="java:jboss/datasources/db_bluebank" pool-name="db_bluebank" enabled="true" use-java-context="true" use-ccm="true">
            <connection-url>jdbc:mysql://localhost:3306/db_bluebank</connection-url>
            <driver>mysql</driver>
            <transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
            <pool>
                <min-pool-size>10</min-pool-size>
                <max-pool-size>100</max-pool-size>
                <prefill>true</prefill>
            </pool>
            <security>
                <user-name>root</user-name>
                <password>admin</password>
            </security>
            <statement>
                <prepared-statement-cache-size>32</prepared-statement-cache-size>
                <share-prepared-statements>true</share-prepared-statements>
            </statement>
        </datasource>
        <drivers>
            <driver name="h2" module="com.h2database.h2">
                <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
            </driver>
            <driver name="mysql" module="com.mysql">
                <driver-class>com.mysql.jdbc.Driver</driver-class>
                <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
            </driver>
        </drivers>
    </datasources>


==> 4- Após isso, já é possível testar o BlueBank

TODO BlueBank:
- Front-end:
	. input:
		. melhorar a consistência de dados digitados pelo usuário, consistência do CPF, bloquear valores negativos, letras no lugar de números e vice-versa 
	. output:
        . mesmo trocando para locale pt-br, meu linux insiste em manter valores no formato 000,000,000.00 (verificar)

- Back-end:
    . incluir pacote de teste pelo JUnit/Mockito