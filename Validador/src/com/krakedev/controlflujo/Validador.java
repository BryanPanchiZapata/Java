package com.krakedev.controlflujo;

public class Validador {
	public void validarEdad(int edad) {
		if (edad >= 18) {
			System.out.println("Es mayor de edad");
		} else if (edad >= 12 && edad <= 17) {
			System.out.println("Es Adolescente");
		} else if (edad >= 0 && edad < 12) {
			System.out.println("Es un niño");
		} else {
			System.out.println("Edad incorrecta");
		}
	}
}
