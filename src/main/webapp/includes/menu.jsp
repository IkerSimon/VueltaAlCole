
<%@page import="com.ipartek.modelo.I_Conexion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
String pagActual =(String) session.getAttribute("s_pagina_actual");





%>
    
   <head>
   <link rel="stylesheet" href="css/estilos.css">
   </head>
    <nav>
		<ul>
			<li>
			<% if(pagActual.equals(I_Conexion.JSP_INDEX)){ %>
				<a href="MenuProductos" class="seleccionado">Productos</a>
				<%}else {%>
			
				<a href="MenuProductos">Productos</a>
				<%} %>
			</li>
			<li>
				<a href="MenuCategorias" 
				<% if(pagActual.equals(I_Conexion.JSP_CATEGORIAS)){ %>
				class="seleccionado"
				<%} %>
				 >Categorias</a>
			</li>
		</ul>
	</nav>