package com.ipartek.modelo.dto;

/**
 * <b>Clase categoria</b>
 * 
 * <p>Clase Categoria que referencia la tabla Categoria en la BD<p>
 * 
 * @author Iker
 * 
 */

public class Categoria {
	/**
	 * Atributo ID: 
	 * <b>A la hora de insertar en la bd es AUTOUMERIC </b>
	 */

	private int id;
	
	/**
	 * Atributo nombre: 
	 * <b>Varchar(45) en la bd </b>
	 */
	private String nombre;

	
	/**
	 * Constructor completo 
	 * @param id un integer, si no lo hemos recogide de la BD no deberia ser 0 
	 * @param nombre 
	 */
	public Categoria(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Categoria() {
		super();
		this.id = 0;
		this.nombre = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}

}
