package br.com.dio.javaAvancado._5NovidadeJava11;

import java.util.stream.Collectors;

public class StringLinesExemplo {
	public static void main(String[] args) {
		String hmtl = "<html>\n<head>   \n</head>\n</html>";
	System.out.println(hmtl.lines().filter(s -> s.contains("head")).collect(Collectors.joining()));
	
	}
}
