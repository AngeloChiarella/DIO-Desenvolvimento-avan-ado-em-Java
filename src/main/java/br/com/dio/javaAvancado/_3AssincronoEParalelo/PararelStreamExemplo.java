package br.com.dio.javaAvancado._3AssincronoEParalelo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PararelStreamExemplo {
	public static void main(String[] args) {
		
//		Serial
		long inicio = System.currentTimeMillis();
		IntStream.range(1, 100000).forEach(numero -> fatorial(numero));
		long fim = System.currentTimeMillis();
		System.out.println("Tempo de execucao (Serial): " + (fim - inicio));

//		Parallel
		inicio = System.currentTimeMillis();
		IntStream.range(1, 100000).parallel().forEach(numero -> fatorial(numero));
		fim = System.currentTimeMillis();
		System.out.println("Tempo de execucao (Parallel): " + (fim - inicio));
	
		
		List<String> nomes = Arrays.asList("Angelo","Chiarella","Fernandes","Desenvolvedor","Java");
		nomes.parallelStream().forEach(System.out::println);
	
	
	}

	public static long fatorial(long numero) {
		long fat = 1;
		for (long i = 2; i <= numero; i++) {
			fat *= i;
		}
		return fat;
	}

}
