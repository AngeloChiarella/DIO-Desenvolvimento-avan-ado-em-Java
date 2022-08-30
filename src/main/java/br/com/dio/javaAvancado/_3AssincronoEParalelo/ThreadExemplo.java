package br.com.dio.javaAvancado._3AssincronoEParalelo;

public class ThreadExemplo {
	public static void main(String[] args) {

		GeradorPDF iniciarGeradorPDF = new GeradorPDF();
		BarraDeCarregamento iniciarBarraDeCarregamento = new BarraDeCarregamento(iniciarGeradorPDF);

		iniciarGeradorPDF.start();
		iniciarBarraDeCarregamento.start();

	}
}
//		Thread thread1 = new Thread(new BarraDeCarregamento2());
//		Thread thread2 = new Thread(new BarraDeCarregamento3());
//		
//		thread1.start();
//		thread2.start();
//
//		System.out.println("Nome da Thread: " + thread1.getName());
//		System.out.println("Nome da Thread: " + thread2.getName());

class GeradorPDF extends Thread {
	@Override
	public void run() {
		try {
			System.out.println("Iniciar geracao de PDF..");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("PDF gerado com sucesso!");
	}
}

class BarraDeCarregamento extends Thread {
	private Thread iniciarGeradorPDF;

	public BarraDeCarregamento(Thread iniciarGeradorPDF) {
		this.iniciarGeradorPDF = iniciarGeradorPDF;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);

				if (!iniciarGeradorPDF.isAlive()) {
					break;
				}
				System.out.println("Loading... ");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

//class BarraDeCarregamento2 implements Runnable {
//	@Override
//	public void run() {
//		try {
//			Thread.sleep(3000);
//			System.out.println("rodei Carregamento2 : ");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//}
//
//class BarraDeCarregamento3 implements Runnable {
//	@Override
//	public void run() {
//		try {
//			Thread.sleep(1000);
//			System.out.println("rodei Carregamento3 : ");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//}