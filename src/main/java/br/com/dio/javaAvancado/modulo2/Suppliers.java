package br.com.dio.javaAvancado.modulo2;

import java.util.function.Supplier;

public class Suppliers {
//	Retorna algo sem receber parametro
	public static void main(String[] args) {
//		Reference Method
		Supplier<Pessoa> suppliersMR = Pessoa::new;
		System.out.println(suppliersMR.get());

		Supplier<Pessoa> suppliers = () -> new Pessoa();
		System.out.println(suppliers.get());
	}
}

class Pessoa {
	private String nome;
	private Integer idade;

	public Pessoa() {
		nome = "Angelo";
		idade = 28;
	}

	@Override
	public String toString() {
		return String.format("Pessoa |Nome: %s, Idade: %d|", nome, idade);
	}
}
