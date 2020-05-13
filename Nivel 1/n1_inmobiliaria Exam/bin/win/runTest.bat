@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n1_inmobiliaria
REM Autor: Equipo cupi2 2014
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd../..
java -classpath ./lib/inmobiliaria.jar;./test/lib/inmobiliariaTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.inmobiliaria.test.MansionTest
java -classpath ./lib/inmobiliaria.jar;./test/lib/inmobiliariaTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.inmobiliaria.test.InmobiliariaTest