package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.dto.Categoria;
import com.ipartek.modelo.dto.Producto;
import com.ipartek.modelo.dto.V_Producto;

public class DB_Helper implements I_Conexion, I_Metodos{
	@Override
	public Connection conectar() {

		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION, USUARIO, PASS);

			System.out.println("BD conectada");

		} catch (ClassNotFoundException e) {
			System.out.println("Error de BD");
			System.out.println("No se encontró el driver");
			System.out.println(e.getMessage());

		} catch (SQLException e) {
			System.out.println("Error de BD");
			System.out.println("Ha fallado la conexiona la BD");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Error de BD");
			System.out.println("Error desconocido");
			System.out.println(e.getMessage());
		}

		return con;
	}
	
	@Override
	public void desconectar(Connection con) {

		try {
			con.close();
			System.out.println("BD desconectada");
		} catch (SQLException e) {
			System.out.println("Error BD");
			System.out.println("No se pudo cerrar la BD");
			System.out.println(e.getMessage());

		}
	}
//-------------------------Obtener todos los productos------------------------
	
	public List<V_Producto> obtenerTodosProductos(Connection con){
		
		List<V_Producto> lista = new ArrayList<V_Producto>();
		
		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_PRODUCTOS);
			
			boolean tieneSelect = cStmt.execute();
			
			if(tieneSelect == true) {
				ResultSet rs = cStmt.getResultSet();
				while (rs.next()) {
					V_Producto prod =new V_Producto();
					
				prod.setId(rs.getInt(V_PRODUCTOS_ID));
				prod.setNombre(rs.getString(V_PRODUCTOS_PRODUCTO));
				prod.setPrecio(rs.getDouble(V_PRODUCTOS_PRECIO));
				prod.setFk_categoria(rs.getInt(V_PRODUCTOS_FK_CATEGORIA));
				prod.setCategoria(rs.getString(V_PRODUCTOS_CATEGORIA));
				
				lista.add(prod);
			
				//System.out.println(lista);
				}
				return lista;
			}else {
				System.out.println("No se pudo obtener una lista de productos");
				System.out.println("El Stored procedure no tiene un RESULTSET");

				return new ArrayList<V_Producto>();
			}
			
		} catch (Exception e) {
		
		System.out.println("Error BD: Consulta");
		System.out.println("Error al obtener la lista de los productos");
		System.out.println(e.getMessage());
		
		return new ArrayList<V_Producto>();
		
	}
	
	}
	
	//-----------------------------LISTA CAT FORM----------------------------------
	
	public List<Categoria> obtenerTodasCategorias(Connection con) {

		List<Categoria> lista = new ArrayList<Categoria>();// List<Producto> lista = new ArrayList<>(); Es lo mismo

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_CATEGORIAS); // El CallableStatement d java.sql logo
																				// morado
			boolean tieneSelect = cStmt.execute();

			if (tieneSelect == true) {

				ResultSet rs = cStmt.getResultSet();

				while (rs.next()) {

					Categoria cat = new Categoria();
					// algo para rellenar el cat

					cat.setId(rs.getInt(CATEGORIAS_ID));
					cat.setNombre(rs.getString(CATEGORIAS_NOMBRE));

					lista.add(cat);
				}

				return lista;
			} else {
				System.out.println("No se pudo obtener una lista de categorias");
				System.out.println("El Stored procedure no tiene un RESULTSET");

				return new ArrayList<Categoria>();
			}

		} catch (SQLException e) {

			System.out.println("Error BD: Consulta");
			System.out.println("Error al obtener la lista de los categorias");
			System.out.println(e.getMessage());

			return new ArrayList<Categoria>(); // en el catch devolver algo vacio mejor

		}

	}
//------------------------------------INSERTAR PRODUCTO--------------------------
		public int insertarProducto(Connection con, Producto nuevoProducto) {

			try {
				// CALL sp_insertar_producto`(producto, precio, fk_categoria, foto)
				CallableStatement cstmt = con.prepareCall(SP_INSERTAR_PRODUCTO);

				cstmt.setString(1, nuevoProducto.getNombre());
				cstmt.setDouble(2, nuevoProducto.getPrecio());
				cstmt.setInt(3, nuevoProducto.getFk_categoria());
				

				return cstmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Errorrrr");
				e.printStackTrace();
			}

			return 0;
		}
		
//-------------------------------INSERTAR CATEGORIA-------------------------------
		public int insertarCategoria(Connection con, Categoria nuevaCategoria) {

			try {
				// CALL sp_insertar_producto`(producto, precio, fk_categoria, foto)
				CallableStatement cstmt = con.prepareCall(SP_INSERTAR_CATEGORIA);

				cstmt.setString(1, nuevaCategoria.getNombre());
				

				return cstmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Errorrrr");
				e.printStackTrace();
			}

			return 0;
		}
		
		
		
// ------------------------------BORRAR PRODUCTO---------------------------------

		public int borrarProducto(Connection con, int i) {

			try {

				CallableStatement cStmt = con.prepareCall(SP_BORRAR_PRODUCTO);

				cStmt.setInt(1, i);
				return cStmt.executeUpdate();

			} catch (Exception e) {
				System.out.println("Error de borrado");
			}

			return 0;

		}
		
//------------------------------BORRAR CATEGORIA---------------------------------

	public int borrarCategoria(Connection con, int i) {

		try {

			CallableStatement cStmt = con.prepareCall(SP_BORRAR_CATEGORIAS);

			cStmt.setInt(1, i);
			return cStmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error de borrado");
		}

		return 0;

	}
		
//--------------------------------Modificar Producto--------------------------------------
		
		public int modificarProducto(Connection con, Producto modificadoProducto) {
			
			try {
				CallableStatement cStmt = con.prepareCall(SP_MODIFICAR_PRODUCTO);
				
				
				cStmt.setInt(1, modificadoProducto.getId());
				cStmt.setString(2, modificadoProducto.getNombre());
				cStmt.setDouble(3, modificadoProducto.getPrecio());
				cStmt.setInt(4, modificadoProducto.getFk_categoria());
				
				System.out.println(cStmt);
				
				return cStmt.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return 0;
			
			
			
			
		}
//-----------------------------OBTENER PRODUCTO X ID-------------------------------------
		public V_Producto obtenerProductoPorID(Connection con, int id) {
			V_Producto prod = new V_Producto();

			try {
				CallableStatement cStmt = con.prepareCall(SP_OBTENER_PRODUCTO_X_ID);

				cStmt.setInt(1, id);

				boolean tieneSelect = cStmt.execute();

				if (tieneSelect == true) {
					ResultSet rs = cStmt.getResultSet();
					while (rs.next()) {
						prod.setId(rs.getInt(V_PRODUCTOS_ID));
						prod.setNombre(rs.getString(V_PRODUCTOS_PRODUCTO));
						prod.setPrecio(rs.getDouble(V_PRODUCTOS_PRECIO));
						prod.setFk_categoria(rs.getInt(V_PRODUCTOS_FK_CATEGORIA));
						prod.setCategoria(rs.getString(V_PRODUCTOS_CATEGORIA));
					}
					
					System.out.println("Se ha obtenido el porducto " + id);
					
					System.out.println(prod);

				} else {
					System.out.println("ERROR al pillar el producto");
					return new V_Producto();
				}

			} catch (Exception e) {
				// TODO: handle exception
				
				System.out.println(e.getMessage());
				return new V_Producto();
			}
			return prod;

		}

	
		
		
		
		
		
		
		
		
	
}
