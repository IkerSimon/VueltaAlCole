<%@page import="com.ipartek.modelo.dto.Categoria"%>
<%@page import="com.ipartek.modelo.dto.V_Producto"%>
<%@page import="com.ipartek.modelo.I_Conexion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.Producto"%>
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
<title>Vuelta al cole</title>
</head>
<body>

<%@ include file="includes/menu.jsp"%>

<h1>Insertar producto</h1>
	<form method="get" action="AgregarProducto" >
	<input type="text" name="p_prod" placeholder="Producto">
	<input type="number" name="p_precio" placeholder="Precio" min="0" step="0.01" required>
	<select name="p_categoria" id="categoria">
	<%for (Categoria elem:listaCategorias){ %>
		<option value="<%=elem.getId() %>"><%=elem.getNombre() %> </option>
	
	<%} %>
	</select>
	<input type="submit" value="Agregar">
	</form>
	
	<form action="BorrarProducto" method="get">
	<table>
	<tr>
		<th></th>
		<th>Producto</th>
		<th>Precio</th>
		<th>Categoria</th>
		<th><input type="submit" value="Borrar"></th>
	</tr>
		<%for (Producto elem:listaProductos){ %>
	<tr>
		<td><input type="checkbox" name="p_check" value="<%=elem.getId()%>"></td>
		<td><%=elem.getNombre() %> </td>
		<td><%=elem.getPrecio()%>€</td>
		<td><%=elem.getFk_categoria()%></td>
		<td><a href="FormModificar?p_id=<%=elem.getId()%>">Modificar</a>
		
	
	</tr>	
	<%} %>
	</table>
	</form>
</body>
</html>