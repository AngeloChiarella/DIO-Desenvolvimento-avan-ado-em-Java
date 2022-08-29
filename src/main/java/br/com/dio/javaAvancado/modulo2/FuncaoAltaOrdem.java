package br.com.dio.javaAvancado.modulo2;

public class FuncaoAltaOrdem {

	public static void main(String[] args) {
		Calculo soma = (a, b) -> a + b;
		Calculo subtracao = (a, b) -> a - b;
		Calculo divisao = (a, b) -> a / b;
		Calculo multiplicacao = (a, b) -> a * b;

		System.out.println(executarOperacao(soma, 1, 3));//4
		System.out.println(executarOperacao(subtracao, 4, 3));//1
		System.out.println(executarOperacao(divisao, 4, 2));//2
		System.out.println(executarOperacao(multiplicacao, 7, 3));//21
	}

//	Funcao de alta ordem - recebe otr funcao como parametro ou retorna outra funcao	
	public static int executarOperacao(Calculo calculo, int a, int b) {
		return calculo.somar(a, b);
	}

}
