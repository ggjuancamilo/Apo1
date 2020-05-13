@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n3_observatorio
REM Autor: Equipo cupi2 2014
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd../..
java -classpath ./lib/observatorio.jar;./test/lib/observatorioTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.observatorio.test.SateliteNaturalTest
java -classpath ./lib/observatorio.jar;./test/lib/observatorioTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.observatorio.test.SateliteArtificialTest
java -classpath ./lib/observatorio.jar;./test/lib/observatorioTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.observatorio.test.PlanetaTest
java -classpath ./lib/observatorio.jar;./test/lib/observatorioTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.observatorio.test.ObservatorioTest

pause