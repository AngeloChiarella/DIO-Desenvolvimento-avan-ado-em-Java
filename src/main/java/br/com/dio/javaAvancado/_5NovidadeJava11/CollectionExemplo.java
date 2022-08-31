package br.com.dio.javaAvancado._5NovidadeJava11;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CollectionExemplo {

	public static void main(String[] args) {
		List<String> nomes = List.of("Angelo", "Chiarella", "Fernandes", "Desenvolvedor", "Java");
		Collection<String> nomes2 = Set.of("Angelo", "Chiarella", "Fernandes", "Desenvolvedor", "Java");

		System.out.println(nomes);
		System.out.println(nomes2);
	}

}
