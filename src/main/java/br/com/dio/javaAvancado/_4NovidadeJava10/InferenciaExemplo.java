package br.com.dio.javaAvancado._4NovidadeJava10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class InferenciaExemplo {

	public static void main(String[] args) throws IOException {
		printarNomeCompleto("Angelo", "Chiarella");
		printarSoma(5, 5, 5);
	}

	private static void connectAndPrintUrlJavaOracle() throws MalformedURLException, IOException {
		var url = new URL("https://docs.oracle.com/javase/10/language");
		var urlConnection = url.openConnection();

		var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
	}

	public static void printarNomeCompleto(String nome, String sobreNome) {
		var nomeCompleto = String.format("%s %s", nome, sobreNome);
		System.out.println(nomeCompleto);

	}

	public static void printarSoma(int... numeros) {
		int soma;
		if (numeros.length > 0) {
			soma = 0;
//			for (var numero : numeros) {
//				soma += numero;
//			}
//			System.out.println("A soma é : " + soma);
			for (var numero = 0 ; numero < numeros.length; numero++) {
				soma += numeros[numero];
			}
			System.out.println("A soma é : " + soma);
		}
	}

}

//pode usar em variaveis locais inicializadas, suport do enhaced for, e for iterativo

//var nao pode ser usado em nivel de classe, como parametro, variaveis locais nao inicializadas