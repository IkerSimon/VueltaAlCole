package com.ipartke.admin;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Conexion;
import com.ipartek.modelo.dto.Categoria;
import com.ipartek.modelo.dto.Producto;
import com.ipartek.modelo.dto.V_Producto;


@WebServlet("/ModificarProducto")
public class ModificarProducto extends HttpServlet implements I_Conexion {
	private static final long serialVersionUID = 1L;
       
    
    public ModificarProducto() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	//1 
		String idStr =request.getParameter("p_id");
		int id=Integer.parseInt(idStr);
		String producto =request.getParameter("p_prod");
		String precioStr =request.getParameter("p_precio");
		double precio = Double.parseDouble(precioStr);
		String categoriaStr =request.getParameter("p_categoria");
		int Fk_categoria = Integer.parseInt(categoriaStr);
		
		
		//2 
		Producto modificadoProducto = new Producto(id, producto, precio, Fk_categoria);
		
		
		
		//3
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
	
		
		//4
	
		int resultadoModificar= db.modificarProducto(con, modificadoProducto);
		List<Categoria> listaCategorias = db.obtenerTodasCategorias(con);
		List<V_Producto> listaProductos=   db.obtenerTodosProductos(con);
	
		//5
		db.desconectar(con);
	
		
		
		//6
		request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategorias);
		request.setAttribute(ATR_LISTA_PRODUCTOS, listaProductos);
		
		
		
		//7
		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
