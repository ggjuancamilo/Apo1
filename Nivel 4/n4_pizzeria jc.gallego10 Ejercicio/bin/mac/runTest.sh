#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogotá - Colombia)
# Departamento de Ingeniería de Sistemas y Computación
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n4_pizzeria
# Autor: Equipo Cupi2 2014
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecución de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/pizzeria.jar:./test/lib/pizzeriaTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.pizzeria.test.ClienteTest
java -ea -classpath ./lib/pizzeria.jar:./test/lib/pizzeriaTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.pizzeria.test.ProductoTest
java -ea -classpath ./lib/pizzeria.jar:./test/lib/pizzeriaTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.pizzeria.test.PedidoTest
java -ea -classpath ./lib/pizzeria.jar:./test/lib/pizzeriaTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.pizzeria.test.PizzeriaTest
cd bin/mac

stty echo
