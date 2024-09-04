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


@WebServlet("/FormModificar")
public class FormModificar extends HttpServlet implements I_Conexion {
	private static final long serialVersionUID = 1L;
       
    
    public FormModificar() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 pillar cual quiere editar
				String idStr = request.getParameter("p_id");
				int id = Integer.parseInt(idStr);
				
				
	
				//2 crear objeto (en caso de necesitarlo)
				
				
				
				//3 conectar 
				DB_Helper db = new DB_Helper();
				Connection con = db.conectar();
				
				//4 modificarlo
				//int resultadoModificar = db.modificarProducto(con, id);
				List<Categoria> listaCategorias = db.obtenerTodasCategorias(con);
				V_Producto Producto =  db.obtenerProductoPorID(con, id);
				
				System.out.println("AAAA"+Producto);
				
				//5 desconctar
				db.desconectar(con);
				
				
				//6 mochila
				
				request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategorias);
				request.setAttribute(ATR_PRODUCTO, Producto);
				
			
				
				
				//7 viajar
				request.getRequestDispatcher(JSP_MODIFICAR).forward(request, response);
			
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
