#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n2_barcoPirata
# Autor: Equipo Cupi2 2014
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/barcoPirata.jar:./test/lib/barcoPirataTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.barcoPirata.test.ContenedorTest
java -ea -classpath ./lib/barcoPirata.jar:./test/lib/barcoPirataTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.barcoPirata.test.BarcoPirataTest
cd bin/mac

stty echo
