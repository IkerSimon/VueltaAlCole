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


@WebServlet("/AgregarCategoria")
public class AgregarCategoria extends HttpServlet implements I_Conexion{
	private static final long serialVersionUID = 1L;
       
   
    public AgregarCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//1 guardar datos
				String categoria = request.getParameter("p_cat");//Saca los datos si entre parentesis esta el name del input
			    
			    
			    //2Crear el objeto
			    Categoria nuevaCategoria= new Categoria(0,categoria);
			    System.out.println(nuevaCategoria);
			    
			    //3 Conectar
			    DB_Helper db = new DB_Helper();
			    Connection con = db.conectar();
			    
			    //4Haceer mochila
			    
			    int resultadoInsert = db.insertarCategoria(con, nuevaCategoria);
			    List<Categoria> listaCategorias = db.obtenerTodasCategorias(con);
			    List<V_Producto>listaProductos = db.obtenerTodosProductos(con);	
			    
			    //5 Desconectar
			    db.desconectar(con);
			    
			    
			    //6 mandar la mmochila
			    request.setAttribute(ATR_LISTA_PRODUCTOS, listaProductos);
			    request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategorias);
			    
			    //7 Viaje a la pagina
			    request.getRequestDispatcher(JSP_CATEGORIAS).forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
