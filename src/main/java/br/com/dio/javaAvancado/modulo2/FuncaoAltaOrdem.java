package br.com.dio.javaAvancado.modulo2;

public class FuncaoAltaOrdem {

	public static void main(String[] args) {
		Calculo soma = (a, b) -> a + b;
		System.out.println(executarOperacao(soma, 1, 3));
	}

//	Funcao de alta ordem - recebe otr funcao como parametro
	public static int executarOperacao(Calculo calculo, int a, int b) {
		return calculo.somar(a, b);
	}

}
