package br.com.dio.javaAvancado.modulo1.lambdaNoJava;

public class FuncaoRetornaString {

	public static void main(String[] args) {
		
		FuncaoString funcao3 = valor -> {
//			System.out.println(valor);
//			System.out.println(valor);
			return valor;
		};
		System.out.println(funcao3.gerar("funcao3: Angelo Chiarella"));
		System.out.println();


//		Retornando String
		FuncaoString funcao = valor -> valor;
		System.out.println(funcao.gerar("funcao: Angelo Chiarella"));
	}

}
