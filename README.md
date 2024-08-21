Projeto para estudo JAVA JDBC - BANKCALI

Este projeto "BANKCALI" é uma aplicação, onde o intuito é realizar operações que faríamos em um banco, como: abertura de contas, listagem de contas, saques e transferencia de valores.

Foi instalado a biblioteca(driver) de conexão MySQL e neste projeto estamos utilizando o gerenciador de dependências Maven.
Maven é responsável por fazer o download das dependências e colocá-las no classpath da nossa aplicação.
Uma vez que esses recursos estejam no classpath podemos usar suas classes e interfaces, que abstraem toda a complexidade dos protocolos de banco de dados.

Padrão Factory tem como objetivo principal nos auxiliar a reduzir o acoplamento em nosso software, ou seja, manter dependências flexíveis, utilizando uma ConnectionFactory, fornece uma maneira mais simples de criar um objeto.
A Factory Pattern é um padrão reconhecido e útil em vários contextos. Na API Java, encontramos vários exemplos do Factory Pattern, como o Calender.getInstance() ou Integer.valueOf("3").

POOL de conexões - recurso do banco de dados onde podemos definir um determinado número de conexões. 
Para escalar conexões, é possível utilizar um poll, no qual será aberta uma quantidade configurável de conexões que serão reaproveitadas entre os clientes. O Pool utilizado na palicação é o HikaniCP.

Foi realizado o delete lógico, com o qual não apagamos o dado do banco e só informamos se a conta está ativa ou não. Caso esteja ativa o valor é retornado na pesquisa, caso contrários não retornará.
