package br.com.dio.javaAvancado._5NovidadeJava11;

public class StringRepeatExemplo {

	public static void main(String[] args) {

		String nome = "Angelo ";

//		Jeito java11
		System.out.println(nome.repeat(10));

//		Jeito antigo
		String aux = "";

		for (int i = 0; i < 10; i++) {
			aux += nome;
		}
		System.out.println(aux);

	}

}
