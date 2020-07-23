/*Na contagem de votos de uma eleição, são gerados vários registros
de votação contendo o nome do candidato e a quantidade de votos
(formato .csv) que ele obteve em uma urna de votação. Você deve
fazer um programa para ler os registros de votação a partir de um
arquivo, e daí gerar um relatório consolidado com os totais de cada
candidato.*/
package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votos = new LinkedHashMap<>();
		
		System.out.print("Digite o caminho do pacote: ");
		String pacote = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(pacote))){
			
			String linha = br.readLine();
			while(linha != null) {
				
				String[] campo = linha.split(",");
				String nome = campo[0];
				int count = Integer.parseInt(campo[1]);
				
				if(votos.containsKey(nome)) {
					int votosAgr = votos.get(nome);
					votos.put(nome, count + votosAgr);
				}else {
					votos.put(nome, count);
				}
				linha = br.readLine();
			}
			
			for(String s: votos.keySet()) {
				System.out.println(s + ": " + votos.get(s));
			}
			
		}catch(IOException e) {
			System.out.println("Erro : " + e.getMessage());
		}
		
		sc.close();

	}

}
