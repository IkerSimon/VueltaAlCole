package com.ipartek.modelo;

public interface I_Conexion {

	
	//Conexion a la BD
	String BASE_DATOS = "vueltacole";
	String DRIVER = "com.mysql.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/"+BASE_DATOS;
	String USUARIO = "root";
	String PASS = "1234";
	
	
	//Archivos JSP
	String JSP_INDEX = "index.jsp";
	String JSP_CATEGORIAS= "categorias.jsp";
	String JSP_MODIFICAR= "modificar.jsp";
	
	
	//Tablas bd
	String V_PRODUCTOS="v_productos";
	String V_PRODUCTOS_ID="id";
	String V_PRODUCTOS_PRODUCTO="producto";
	String V_PRODUCTOS_PRECIO="precio";
	String V_PRODUCTOS_FK_CATEGORIA="FK_Categoria";
	String V_PRODUCTOS_CATEGORIA="categorias";
	
	String TABLA_CATEGORIAS="categorias";
	String CATEGORIAS_ID="id";
	String CATEGORIAS_NOMBRE="nombre";
	
	
	//stored procedures
	String SP_OBTENER_PRODUCTOS = "call sp_obtener_productos();";
	String SP_OBTENER_CATEGORIAS="call sp_obtener_categorias();";
	String SP_INSERTAR_PRODUCTO="call sp_insertar_producto(?, ?, ?);";
	String SP_BORRAR_PRODUCTO="call sp_borrar_producto(?);";
	String SP_BORRAR_CATEGORIAS="call sp_borrar_categoria(?);";
	String SP_INSERTAR_CATEGORIA="call sp_insertar_categoria(?);";
	String SP_MODIFICAR_PRODUCTO="call sp_modificar_producto(?,?,?);";
	String SP_OBTENER_PRODUCTO_X_ID="call sp_obtener_productos_x_id(?);";
	


	//atributos mochila
	String ATR_LISTA_PRODUCTOS="atr_lista_productos";
	String ATR_LISTA_CATEGORIAS="atr_lista_categorias";
	String ATR_PRODUCTO="atr_producto";
	
	
	
	//nombre cookie
	String S_PAGINA_ACTUAL="s_pagina_actual";
	
	
	
}
