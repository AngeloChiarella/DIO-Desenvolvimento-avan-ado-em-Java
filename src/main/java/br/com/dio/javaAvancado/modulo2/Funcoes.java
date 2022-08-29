package br.com.dio.javaAvancado.modulo2;

import java.util.function.Function;

public class Funcoes {

	public static void main(String[] args) {
		Function<String, String> retornarNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
		System.out.println(retornarNomeAoContrario.apply("Angelo"));
	}

}
