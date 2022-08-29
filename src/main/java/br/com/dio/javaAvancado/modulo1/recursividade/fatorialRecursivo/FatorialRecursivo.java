package br.com.dio.javaAvancado.modulo1.recursividade.fatorialRecursivo;

public class FatorialRecursivo {
	public static void main(String[] args) {
		System.out.println(fatorial(5));
	}

	public static int fatorial(int valor) {
		if (valor == 1) {
			return valor;
		} else {
			return valor * fatorial((valor - 1));
		}
	}

//	5! = 5 * 4 * 3 * 2 * 1
//	5 = 120
}
