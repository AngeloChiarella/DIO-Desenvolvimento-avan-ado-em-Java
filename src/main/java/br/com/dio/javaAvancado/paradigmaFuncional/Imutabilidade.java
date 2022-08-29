package br.com.dio.javaAvancado.paradigmaFuncional;

import java.util.function.UnaryOperator;

public class Imutabilidade {
//Imutabilidade: Variavel que recebe valor, permanece com ele pra sempre, ou obj criado n pode ser modificado
	public static void main(String[] args) {
		int valor = 20;
		UnaryOperator<Integer> retornarDobro = v -> v * 2;

//		UnaryOperator<Integer> retornarDobro = v -> {
//			valor = 30; *****ALTERAR VARIAVEL DENTRO DE OP LAMBDA
//			return v * 2;
//		}; *********** ISSO O JAVA NAO ACEITA

		System.out.println(retornarDobro.apply(valor)); // retornar o dobro do valor '40'
		System.out.println(valor);// valor n sera alterado '20'
	}
}