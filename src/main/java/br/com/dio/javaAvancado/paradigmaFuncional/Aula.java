package br.com.dio.javaAvancado.paradigmaFuncional;

import java.util.function.UnaryOperator;

public class Aula {
	public static void main(String[] args) {
		
// segundo exemplo - paradigma funcional
//		(declara o comportamento antes de precisar usar)
		UnaryOperator<Integer> calcularValoresVezes3 = valor2 -> valor2 * 3;
		int valor2 = 10;
		System.out.println("O resultado é: " + calcularValoresVezes3.apply(10));

// primeiro exemplo - - paradigma imperativo
		int valor = 10;
		int resultado = valor * 3;
		System.out.println("O resultado é: " + resultado);

	}
}
