package br.com.dio.javaAvancado._2InterfacesFuncionais;

import java.util.function.Function;

public class Funcoes {

	public static void main(String[] args) {
		Function<String, String> retornarNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
		System.out.println(retornarNomeAoContrario.apply("Angelo"));
		
//		Function<String, Integer> converterStringParaInteiroECalcularODobro = Integer::valueOf;
		Function<String, Integer> converterStringParaInteiroECalcularODobro = string -> Integer.valueOf(string) * 2;
		System.out.println(converterStringParaInteiroECalcularODobro.apply("20"));
	}

}
