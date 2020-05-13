@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n2_barcoPirata
REM Autor: Equipo cupi2 2014
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd../..
java -classpath ./lib/barcoPirata.jar;./test/lib/barcoPirataTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.barcoPirata.test.ContenedorTest
java -classpath ./lib/barcoPirata.jar;./test/lib/barcoPirataTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.barcoPirata.test.BarcoPirataTest

pause