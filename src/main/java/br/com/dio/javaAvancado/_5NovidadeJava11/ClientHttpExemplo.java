package br.com.dio.javaAvancado._5NovidadeJava11;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class ClientHttpExemplo {

	static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {

		@Override
		public Thread newThread(Runnable runnable) {
			Thread thread = new Thread(runnable);
			System.out.println("Nova Thread criada " //
					+ (thread.isDaemon() ? "deamon" : "") //
					+ " Thread Gorup: "//
					+ thread.getThreadGroup()//
			);
			return thread;
		}
	});

	public static void main(String[] args) throws IOException, InterruptedException {
//		connectAndPrintUrlJavaOracle();
		connectAkamaiHttpClient();

	}

	private static void connectAkamaiHttpClient() {
		System.out.println("Running HTTP/1.1 exemple...");
		try {
			HttpClient httpClient = HttpClient.newBuilder()//
					.version(HttpClient.Version.HTTP_1_1)//
					.proxy(ProxySelector.getDefault())//
					.build();

			long start = System.currentTimeMillis();

			HttpRequest mainRequest = HttpRequest.newBuilder()//
					.uri(URI.create("http://http2.akamai.com/demo/h2_demo_frame.html"))//
					.build();
			HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());

			System.out.println("Statud Code ::: " + response.statusCode());
			System.out.println("Response Headers ::: " + response.headers());
			String responseBody = response.body();
			System.out.println(responseBody);

			List<Future<?>> future = new ArrayList<>();

			responseBody.lines()//
					.filter(line -> line.trim().startsWith("<img height"))//
					.map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))//
					.forEach(image -> {
						Future<?> imgFuture = executor.submit(() -> {
							HttpRequest imgRequest = HttpRequest.newBuilder()//
									.uri(URI.create("http://http2.akamai.com" + image))//
									.build();
							try {
								HttpResponse<String> imageResponse = httpClient.send(imgRequest,
										HttpResponse.BodyHandlers.ofString());
								System.out.println("Imagem Carregada :: " + image + " Status Code ::"
										+ imageResponse.statusCode());
							} catch (IOException | InterruptedException e) {
								e.printStackTrace();
							}
						});

						future.add(imgFuture);
						System.out.println("Submetido um futuro para imagem :: " + image);
					});

			future.forEach(f -> {
				try {
					f.get();
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			long end = System.currentTimeMillis();
			System.out.println("Tempo de carregamento total: " + (end - start));

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
	}

	private static void connectAndPrintUrlJavaOracle() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()//
				.GET().uri(URI.create("https://docs.oracle.com/javase/10/language"))//
				.build();

		HttpClient httpClient = HttpClient.newHttpClient();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println("Status code: " + response.statusCode());
		System.out.println("Headers response: " + response.headers());
		System.out.println(response.body());
	}
}
