package br.com.dio.javaAvancado.lambdaNoJava;

public class FuncaoRetornaVoid {

	public static void main(String[] args) {
		
// 		Retornando mais de um parametro no lambda
		FuncaoVoid funcao2 = valor -> {
			System.out.println(valor);
			System.out.println(valor);
		};
		funcao2.gerar("funcao2: Angelo Chiarella");
		System.out.println();

//		'println' tem retorno void
		FuncaoVoid funcao1 = valor -> System.out.println(valor);
		funcao1.gerar("funcao1: Angelo Chiarella");
		System.out.println();

	}

}
