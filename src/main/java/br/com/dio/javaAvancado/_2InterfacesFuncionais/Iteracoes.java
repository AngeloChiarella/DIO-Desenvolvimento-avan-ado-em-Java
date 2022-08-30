package br.com.dio.javaAvancado._2InterfacesFuncionais;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {

	public static void main(String[] args) {
		String[] nomes = { "Angelo", "Chiarella", "Fernandes", "Estudante", "Java" };
		Integer[] numeros = { 1, 2, 3, 4, 5 };
//		imprimirNomesFiltrados(nomes);
//		imprimirTodosOsNomes(nomes);
//		imprimirODobroDeCadaItemNaLista(numeros);

		List<String> profissoes = new ArrayList<>();
		profissoes.addAll(Arrays.asList("Desenvolvedor", "Testador", "Gerente de projeto", "Gerente de qualidade"));

		profissoes.stream()//
				.filter(profissao -> profissao.startsWith("Gerente"))//
				.forEach(System.out::println);//
		;
	}

	public static void imprimirTodosOsNomes(String[] nomes) {
		for (String nome : nomes) {
			System.out.println("Impresso pelo for: " + nome);
		}

		Stream.of(nomes)//
//				.forEach(System.out::println);
				.forEach(nome -> System.out.println("Impresso pelo forEach: " + nome));
	}

	public static void imprimirODobroDeCadaItemNaLista(Integer... numeros) {
//		for (Integer numero : numeros) {
//			System.out.println(numero * 2);
//		}
//		Stream.of(numeros).forEach(numero -> System.out.println(numero * 2));
		Stream.of(numeros).map(numero -> numero * 2).forEach(System.out::println);
	}

	public static void imprimirNomesFiltrados(String... nomes) {

		String nomesParaImprimir = "";

		for (int i = 0; i < nomes.length; i++) {
			if (nomes[i].equals("Angelo")) {
				nomesParaImprimir += " " + nomes[i];
			}
		}
		System.out.println("Nomes do FOR: " + nomesParaImprimir);

		String nomesParaImprimirStream = Stream.of(nomes)//
				.filter(nome -> nome.equals("Angelo"))//
				.collect(Collectors.joining());// Transforma um array de string em um string so

		System.out.println("Nomes do Stream: " + nomesParaImprimirStream);

	}

}
