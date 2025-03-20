-- ●	Crea una tabla llamada 'TB_Productos' que almacene información sobre productos en una tienda. 
--La tabla debe incluir columnas para el ID del producto (entero),
--nombre del producto (cadena de caracteres), 
--tipo del producto (cadena de caracteres solo se puede guardar los valores ‘Alimentación’,’Electrónica’, ‘Ropa’),
--precio (decimal) y 
--cantidad en stock (entero). 

--Ninguna columna puede estar vacía. Asegúrate de definir correctamente 
--los tipos de datos y las restricciones necesarias para cada columna. (2 puntos)


--●	Insertar productos en la tabla (1 punto)
--●	Consultar todos los productos de la tabla (1 punto)
--●	Calcular el precio medio y cuantos productos por cada tipo. (2 puntos)
--Usando JDBC, en una Clase con el método main 
--●	Consultarlos y mostrar los datos de todos (1.5 punto)
--●	Mostrar por cada tipo de producto el precio medio y cuantos productos hay disponibles (2.5 puntos)
DROP TABLE TB_PRODUCTOS;

CREATE TABLE TB_PRODUCTOS(
ID NUMBER (5) PRIMARY KEY,
NOMBRE VARCHAR2(75) NOT NULL,
TIPO VARCHAR2(75) NOT NULL CHECK (TIPO = 'Alimentacion' or TIPO = 'Electronica' or TIPO = 'Ropa'),
PRECIO NUMBER(10,2) NOT NULL ,
STOCK NUMBER(10) NOT NULL
);

INSERT ALL INTO TB_PRODUCTOS VALUES (1, 'Harina', 'Alimentacion', 5, 100)
INTO TB_PRODUCTOS VALUES (2, 'Guitarra', 'Electronica', 150, 20)
INTO TB_PRODUCTOS VALUES (3, 'Zapatos', 'Ropa', 80, 50)
SELECT * FROM DUAL;

SELECT ID, NOMBRE, TIPO, PRECIO, STOCK FROM TB_PRODUCTOS;

SELECT NOMBRE, TIPO, PRECIO FROM TB_PRODUCTOS ORDER BY TIPO;

SELECT TIPO, COUNT(TIPO) as TOTAL_DE_TIPOS_DE_PRODUCTOS,
         AVG(PRECIO) AS MEDIA_DE_PRECIO
FROM TB_PRODUCTOS
GROUP BY (TIPO)
HAVING COUNT (NOMBRE)>=1;
    

