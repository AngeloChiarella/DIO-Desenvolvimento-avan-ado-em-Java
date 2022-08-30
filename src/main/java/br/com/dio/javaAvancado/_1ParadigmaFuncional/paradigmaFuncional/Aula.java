package br.com.dio.javaAvancado._1ParadigmaFuncional.paradigmaFuncional;

import java.util.function.Function;

public class Aula {
//	EXEMPLO AULA: Funções e imutabilidade em Paradigma Funcional
	public static void main(String[] args) {
		
//		funcional
		Function<Integer, Object> buscarUsuario2 = idUsuario2 -> new Object();

//		imperativo
		System.out.println(buscarUsuario(15));

	}

	public static Object buscarUsuario(int idUsuario) {
//		retornar o usuario
		return new Object();
	}

}
