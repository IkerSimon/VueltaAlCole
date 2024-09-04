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
import com.ipartek.modelo.dto.V_Producto;


@WebServlet("/BorrarProducto")
public class BorrarProducto extends HttpServlet implements I_Conexion{
	private static final long serialVersionUID = 1L;
       
   
    public BorrarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1 pillar cuales quiere borrar
		
				int[] p_id= {};
				if (request.getParameterValues("p_check")!=null) {
					try{ 
						String[] p_idArrayString= request.getParameterValues("p_check");
						
						p_id=new int[p_idArrayString.length];
						
						for (int i = 0; i < p_idArrayString.length; i++) {
							
							p_id[i]= Integer.parseInt(p_idArrayString[i]);
							
							
						}
						
					}catch (Exception e) {
						p_id=new int[0];
					}
				}
	
				
				//3 conectar
				DB_Helper db = new DB_Helper();
				Connection con = db.conectar();
				
				//4 borrarlo
				for (int i : p_id) {
					int resultadoBorrado = db.borrarProducto(con, i);
				}
				List<Categoria> listaCategorias = db.obtenerTodasCategorias(con);
				List<V_Producto> listaProductos=   db.obtenerTodosProductos(con);
				
				
				//5 desconectar
				db.desconectar(con);
				
				//6 Mandar la mochila
				request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategorias);
				request.setAttribute(ATR_LISTA_PRODUCTOS, listaProductos);
				
				//7 Ir a la pagina de nuevo
				
				request.getRequestDispatcher(JSP_INDEX).forward(request, response);
				
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
