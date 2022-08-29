package br.com.dio.javaAvancado.modulo2;

import java.util.function.Consumer;

public class Consumidores {

	public static void main(String[] args) {
//		Method Reference
//		apenas utilizar o parametro da forma que ele foi recebido
		
		Consumer<String> imprimirUmaFrase = System.out::println;
		imprimirUmaFrase.accept("imprimirUmaFrase: Hello World");

		Consumer<String> imprimirUmaFrase2 = frase -> System.out.println(frase);
		imprimirUmaFrase2.accept("imprimirUmaFrase2: Hello World");
		
	}

}
