<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.modelo.I_Conexion"%>
<%@page import="com.ipartek.modelo.dto.V_Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<%
V_Producto producto =new V_Producto();
if(request.getAttribute(I_Conexion.ATR_PRODUCTO)!=null){
	producto=(V_Producto)request.getAttribute(I_Conexion.ATR_PRODUCTO);
}else{
	
}
%>
    
<%
List<Categoria> listaCategorias =new ArrayList<Categoria>();
if(request.getAttribute(I_Conexion.ATR_LISTA_CATEGORIAS)!=null){
	listaCategorias=(List<Categoria>)request.getAttribute(I_Conexion.ATR_LISTA_CATEGORIAS);
}else{
	
}
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar</title>
</head>
<body>

<h1>Modificar Producto</h1>
<h2><%=producto.getNombre() %></h2>

<form method="post" action="ModificarProducto">
	<input type="text" readonly="readonly" id="p_id" name="p_id" value="<%=producto.getId() %>">
	<input type="text" value="<%=producto.getNombre()%>" id="p_nombre" name="p_nombre">
	<input type="number" value="<%=producto.getPrecio()%>" min="0" step="0.01" name="p_precio">
	<select id="categoria" name="p_categoria" required>
		
			<%for (Categoria elem:listaCategorias){ 
			
				if(elem.getId()!=producto.getFk_categoria()){
					//mostrar el select sin seleccionar%>
					<option value="<%=elem.getId() %>"><%=elem.getNombre()%></option>
					
				<% }else{
					//mostrar la categoria correspondiente
					%>
					<option value="<%=elem.getId() %>" selected="<%=producto.getFk_categoria()%>"><%=elem.getNombre()%></option>
					
				<%}
				
			
			
					
			} %>
		</select>
		<input type="submit" value="Guardar">

</form>








</body>
</html>