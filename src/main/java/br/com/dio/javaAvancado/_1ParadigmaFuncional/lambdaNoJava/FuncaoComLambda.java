package br.com.dio.javaAvancado._1ParadigmaFuncional.lambdaNoJava;

public class FuncaoComLambda {

	public static void main(String[] args) {
		FuncaoString colocarPrefixoSenhorNaString = valor -> "Sr. " + valor;
		System.out.println(colocarPrefixoSenhorNaString.gerar("Angelo"));
	}
}
/*
 * REGRAS PARA INSTANCIAR LAMBDA: Quando uma lambda possui apenas uma instrucao
 * no corpo de sua logica nao e necessario o uso de chaves. 
 * Exemplo: 
 * Funcao colocarPrefixoSenhorNaString = valor -> "Sr. " + valor;
 * 
 * Se a funcao possui mais de um parametro DEVEMOS utilizar chaves {} e alem
 * disso deve explicitar o retorno caso seja diferente de void. 
 * Exemplo: 
 * Funcao colocarPrefixoSenhorNaString = valor -> { 
 * 		String valorComPrefixo = "Sr" + valor; 
 * 		String valorComPrefixoEPontoFinal = valorComPrefixo + "."; 
 * 		return valorComPrefixoEPontoFinal; 
 * };
 */