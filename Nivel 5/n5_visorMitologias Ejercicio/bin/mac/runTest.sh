#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n5_visorMitologias
# Autor: Equipo Cupi2 2014
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/visorMitologias.jar:./test/lib/visorMitologiasTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.visorMitologias.test.DiosTest
java -ea -classpath ./lib/visorMitologias.jar:./test/lib/visorMitologiasTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.visorMitologias.test.MitologiaTest
java -ea -classpath ./lib/visorMitologias.jar:./test/lib/visorMitologiasTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.visorMitologias.test.VisorMitologiasTest
cd bin/mac

stty echo
