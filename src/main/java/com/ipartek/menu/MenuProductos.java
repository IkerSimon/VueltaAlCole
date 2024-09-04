package com.ipartek.menu;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Conexion;
import com.ipartek.modelo.dto.Categoria;
import com.ipartek.modelo.dto.V_Producto;

@WebServlet("/MenuProductos")
public class MenuProductos extends HttpServlet implements I_Conexion {
	private static final long serialVersionUID = 1L;
   
    public MenuProductos() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DB_Helper db=new DB_Helper();
		Connection con= db.conectar();
		
		//4
		List<V_Producto>listaProductos = db.obtenerTodosProductos(con);	
		List<Categoria> listaCategorias = db.obtenerTodasCategorias(con);
		
		
		request.setAttribute(ATR_LISTA_PRODUCTOS, listaProductos);
		request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategorias);
		
		HttpSession session= request.getSession();
		session.setAttribute(S_PAGINA_ACTUAL, JSP_INDEX);
		
	request.getRequestDispatcher(JSP_INDEX).forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
