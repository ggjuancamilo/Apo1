#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n3_observatorio
# Autor: Equipo Cupi2 2014
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/observatorio.jar:./test/lib/observatorioTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.observatorio.test.SateliteNaturalTest
java -ea -classpath ./lib/observatorio.jar:./test/lib/observatorioTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.observatorio.test.SateliteArtificialTest
java -ea -classpath ./lib/observatorio.jar:./test/lib/observatorioTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.observatorio.test.PlanetaTest
java -ea -classpath ./lib/observatorio.jar:./test/lib/observatorioTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.observatorio.test.ObservatorioTest
cd bin/mac

stty echo
