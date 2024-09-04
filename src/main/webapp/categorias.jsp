<%@page import="com.ipartek.modelo.dto.V_Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.Categoria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
List<V_Producto> listaProductos =new ArrayList<V_Producto>();
if(request.getAttribute(I_Conexion.ATR_LISTA_PRODUCTOS)!=null){
	listaProductos=(List<V_Producto>)request.getAttribute(I_Conexion.ATR_LISTA_PRODUCTOS);
	
}

List<Categoria> listaCategorias =new ArrayList<Categoria>();
if(request.getAttribute(I_Conexion.ATR_LISTA_CATEGORIAS)!=null){
	listaCategorias=(List<Categoria>)request.getAttribute(I_Conexion.ATR_LISTA_CATEGORIAS);
}
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categorias</title>
</head>
<body>

	<header> CABECERA </header>

	<%@ include file="includes/menu.jsp"%>

	<h1>Insertar categoria</h1>
	<form method="get" action="AgregarCategoria" >
	<input type="text" name="p_cat" placeholder="Categoria">
	<input type="submit" value="Agregar">
	</form>
	
	
	<form action="BorrarCategoria" method="get">
	<table>
	<tr>
		<th></th>
		<th>ID</th>
		<th>Categoria</th>
		<th><input type="submit" value="Borrar"></th>
		
	</tr>
		<%for (Categoria elem:listaCategorias){ %>
		
<%-- 		<%for (V_Producto prod:listaProductos){ %> --%>
	<tr>
		<td><input type="checkbox" name="p_check" value="<%=elem.getId()%>"></td>
		<td><%=elem.getId()%></td>
		<td><%=elem.getNombre()%> </td>
		
	
	</tr>	
	<%}%>
	</table>
	</form>

</body>
</html>