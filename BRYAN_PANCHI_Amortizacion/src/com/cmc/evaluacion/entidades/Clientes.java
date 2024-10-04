package com.cmc.evaluacion.entidades;

public class Clientes {
	private String cedula;
	private String nombre;
	private String apellido;

	public Clientes(String cedula, String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
	}

	public void mostrarCliente() {
		System.out
				.println("[" + "cédula: " + cedula + ", " + "nombre: " + nombre + ", " + "apellido: " + apellido + "]");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
