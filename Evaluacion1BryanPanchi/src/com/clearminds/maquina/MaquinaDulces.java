package com.clearminds.maquina;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private ArrayList<Celda> celdas;
	private double saldo;

	public MaquinaDulces() {
		celdas = new ArrayList<>();
	}

	public void agregarCelda(Celda codigo) {
		celdas.add(codigo);
	}

	public void mostrarConfiguracion() {
		Celda elementoCelda = null;
		for (int i = 0; i < celdas.size(); i++) {
			elementoCelda = celdas.get(i);
			System.out.println("Celda" + (i + 1) + ":" + elementoCelda.getCodigo());
		}
	}

	public Celda buscarCelda(String codigo) {
		Celda celdaEncontrada = null;
		Celda elementoCelda = null;
		for (int i = 0; i < celdas.size(); i++) {
			elementoCelda = celdas.get(i);
			if (codigo.equals(elementoCelda.getCodigo())) {
				celdaEncontrada = elementoCelda;
			}

		}
		return celdaEncontrada;
	}

	public void cargarProducto(Producto producto, String codigo, int items) {
		Celda celdaRecuperada = buscarCelda(codigo);
		celdaRecuperada.ingresarProducto(producto, items);
	}

	public void mostrarProductos() {

		for (int i = 0; i < celdas.size(); i++) {
			Celda elementoCelda = celdas.get(i);

			if (elementoCelda.getProducto() == null) {
				System.out.println("Celda:" + elementoCelda.getCodigo() + " Stock:" + elementoCelda.getStock() + " "
						+ "Sin Producto asignado");
			} else {
				System.out.println("Celda:" + elementoCelda.getCodigo() + " Stock:" + elementoCelda.getStock() + " "
						+ "Producto: " + elementoCelda.getProducto().getNombre() + " "
						+ elementoCelda.getProducto().getPrecio());
			}

		}

	}

	public Producto buscarProductoEnCelda(String codigo) {
		Producto elementoEncontrado = null;
		for (int i = 0; i < celdas.size(); i++) {
			if (codigo.equals(celdas.get(i).getCodigo())) {
				elementoEncontrado = celdas.get(i).getProducto();
			}
		}
		return elementoEncontrado;
	}

	public double consultarPrecio(String codigo) {
		double elementoEncontrado = 0;
		for (int i = 0; i < celdas.size(); i++) {
			if (codigo.equals(celdas.get(i).getCodigo())) {
				elementoEncontrado = celdas.get(i).getProducto().getPrecio();
			}
		}
		return elementoEncontrado;
	}

	public Celda buscarCeldaProducto(String codigo) {
		Celda elementoEncontrado = null;
		for (int i = 0; i < celdas.size(); i++) {
			if (celdas.get(i).getProducto() != null) {
				if (codigo.equals(celdas.get(i).getProducto().getCodigo())) {
					elementoEncontrado = celdas.get(i);
				}

			}
		}
		return elementoEncontrado;
	}

	public void incrementarProductos(String codigo, int items) {
		Celda celdaEncontrada = buscarCeldaProducto(codigo);
		celdaEncontrada.setStock(celdaEncontrada.getStock() + items);
	}

	public void vender(String codigo) {
		Celda celdaEncontrada = buscarCelda(codigo);
		celdaEncontrada.setStock(celdaEncontrada.getStock() - 1);
		double valorSaldo = celdaEncontrada.getProducto().getPrecio();
		saldo = getSaldo() + valorSaldo;
		System.out.println(saldo);
	}

	public double venderConCambio(String codigo, double valorCliente) {
		Celda celdaEncontrada = buscarCelda(codigo);
		celdaEncontrada.setStock(celdaEncontrada.getStock() - 1);
		double valorSaldo = celdaEncontrada.getProducto().getPrecio();
		saldo = getSaldo() + valorSaldo;
		System.out.println("Saldo: " + saldo);
		return valorCliente - valorSaldo;
	}

	public ArrayList<Producto> buscarMenores(double limite) {
		ArrayList<Producto> producto = new ArrayList<>();
		Producto elementoEncontrado = null;
		for (int i = 0; i < celdas.size(); i++) {
			if (celdas.get(i).getProducto().getPrecio() < limite) {
				producto.add(elementoEncontrado);
			}
		}
		return producto;
	}

	public void mostrarProductosPrecio() {

		for (int i = 0; i < celdas.size(); i++) {
			Celda elementoCelda = celdas.get(i);

			if (elementoCelda.getProducto() == null) {
				System.out.println("Celda:" + elementoCelda.getCodigo());
			} else {
				System.out.println("Nombre: "
						+ elementoCelda.getProducto().getNombre() + " Precio: " + elementoCelda.getProducto().getPrecio());
			}

		}

	}

	public ArrayList<Celda> getCeldas() {
		return celdas;
	}

	public void setCeldas(ArrayList<Celda> celdas) {
		this.celdas = celdas;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
