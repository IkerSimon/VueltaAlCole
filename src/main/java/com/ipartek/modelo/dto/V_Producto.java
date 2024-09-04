package com.ipartek.modelo.dto;

public class V_Producto extends Producto {

	
	private String categoria;

	public V_Producto(int id, String nombre, double precio, int fk_categoria, String categoria) {
		super(id, nombre, precio, fk_categoria);
		this.categoria = categoria;
	}
	public V_Producto() {
		super();
		this.categoria = "";
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "V_Producto [categoria=" + categoria + "]";
	}
	
	
	
}
