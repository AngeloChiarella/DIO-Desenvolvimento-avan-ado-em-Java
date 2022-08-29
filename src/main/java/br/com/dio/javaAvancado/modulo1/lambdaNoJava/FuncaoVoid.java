package br.com.dio.javaAvancado.modulo1.lambdaNoJava;

//FunctionalInterface: Protege a interface pra que nao seja de outro tipo a nao ser "Funcional"
@FunctionalInterface
public interface FuncaoVoid {
	
//	Se tiver mais de um metodo sobrescrito na interface, java nao compila
	void gerar(String valor);
//	String gerar(String valor);
//	Integer gerarNumero(String valor);
}
