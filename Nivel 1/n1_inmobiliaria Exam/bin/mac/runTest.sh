#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogotá - Colombia)
# Departamento de Ingeniería de Sistemas y Computación
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n1_inmobiliaria
# Autor: Equipo Cupi2 2014
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecución de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/inmobiliaria.jar:./test/lib/inmobiliariaTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.inmobiliaria.test.MansionTest
java -ea -classpath ./lib/inmobiliaria.jar:./test/lib/inmobiliariaTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.inmobiliaria.test.InmobiliariaTest
cd bin/mac

stty echo
