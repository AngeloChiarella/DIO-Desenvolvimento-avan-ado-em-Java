package br.com.dio.javaAvancado._3AssincronoEParalelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class FeatureExemplo {
	private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(3);

	public static void main(String[] args) throws InterruptedException {
		Casa casa = new Casa(new Quarto());
		List<? extends Future<String>> futuros = new CopyOnWriteArrayList<Future<String>>(
				casa.obterAFazeresDaCasa().stream()//
						.map(atividade -> pessoasParaExecutarAtividade.submit(() -> {
							try {
								return atividade.realizar();
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							return null;
						}))//
						.collect(Collectors.toList()));

		while (true) {
			int numeroDeAtividadesNaoFinalizadas = 0;

			for (Future<String> futuro : futuros) {
				if (futuro.isDone()) {
					try {
						System.out.println("Parabens, voce terminou de " + futuro.get());
						futuros.remove(futuro);
					} catch (InterruptedException e) {
						e.printStackTrace();

					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				} else {
					numeroDeAtividadesNaoFinalizadas++;
				}
			}
			if (futuros.stream().allMatch(Future::isDone)) {
				break;
			}

			System.out.println("Numero de atividades nao finalizadas: " + numeroDeAtividadesNaoFinalizadas);
			Thread.sleep(500);
		}

		pessoasParaExecutarAtividade.shutdown();
	}
}

class Casa {
	private List<Comodo> comodos;

	Casa(Comodo... comodos) {
		this.comodos = Arrays.asList(comodos);
	}

	List<Atividade> obterAFazeresDaCasa() {
		return this.comodos.stream()//
				.map(Comodo::obterAFazeresDoComodo)//
				.reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {//
					pivo.addAll(atividades);
					return pivo;
				});
	}
}

interface Atividade {
	String realizar() throws InterruptedException;
}

abstract class Comodo {
	abstract List<Atividade> obterAFazeresDoComodo();
}

class Quarto extends Comodo {
	@Override
	List<Atividade> obterAFazeresDoComodo() {
		return Arrays.asList(//
				this::arrumarACasa, //
				this::varrerOQuarto, //
				this::arrumarGuardaRoupa);
	}

	private String arrumarACasa() throws InterruptedException {
		Thread.sleep(5000);
		String arrumar_a_casa = "arrumar a casa";
		System.out.println(arrumar_a_casa);
		return arrumar_a_casa;
	}

	private String varrerOQuarto() throws InterruptedException {
		Thread.sleep(7000);
		String varrer_o_quarto = "varrer o quarto";
		System.out.println(varrer_o_quarto);
		return varrer_o_quarto;
	}

	private String arrumarGuardaRoupa() throws InterruptedException {
		Thread.sleep(1000);
		String arrumar_o_guarda_roupa = "Arrumar guarda-roupas";
		System.out.println(arrumar_o_guarda_roupa);
		return arrumar_o_guarda_roupa;
	}

}