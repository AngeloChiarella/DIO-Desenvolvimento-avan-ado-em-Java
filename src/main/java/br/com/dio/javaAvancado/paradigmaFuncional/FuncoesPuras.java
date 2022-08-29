package br.com.dio.javaAvancado.paradigmaFuncional;

import java.util.function.BiPredicate;

public class FuncoesPuras {
// Funcao Pura: Quando invocada mais de uma vez e produz mesmo resultado.
	public static void main(String[] args) {
		BiPredicate<Integer, Integer> verificarSeEMaior = //
				(parametro, valorComparacao) -> parametro > valorComparacao;

		System.out.println(verificarSeEMaior.test(13, 12));
		System.out.println(verificarSeEMaior.test(13, 12));
	}
}
