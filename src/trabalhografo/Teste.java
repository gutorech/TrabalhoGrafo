/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhografo;

/**
 *
 * @author Micro
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Teste {
	static int qntd;

	public static void main(String args[]) throws FileNotFoundException {
		Scanner s = new Scanner(new FileReader("database.txt")).useDelimiter("\n");
		String linha = s.next();
		Scanner conteudo = new Scanner(linha).useDelimiter(" ");
		qntd = conteudo.nextInt();
		Grafo grafo = new Grafo(qntd);
		while (s.hasNext()) {
			String linhaAresta = s.next();
			addData(linhaAresta, grafo);
		}
		int linhamatriz[] = new int[qntd];
		int matrizgrafo[][] = new int[qntd][qntd];

		for (int x = 0; x < qntd; x++) {
			for (int m = 0; m < qntd; m++) {
				linhamatriz[m] = addMatriz(grafo, x, m);
			}

			for (int y = 0; y < qntd; y++) {
				matrizgrafo[x][y] = linhamatriz[y];
			}
		}
		Prim prim = new Prim();
		prim.primMST(matrizgrafo);

	}
	static int addMatriz(Grafo grafo, int vertice, int fim) {
		for (Aresta aresta : grafo.adjacencia[vertice]) {
			if (aresta.getFim() == fim) {
				return aresta.getCusto();
			}
		}
		return 0;
	}
	static void addData(String linhaAresta, Grafo grafo) {
		Scanner conteudoAresta = new Scanner(linhaAresta).useDelimiter("[ \n]");
		int inicio = conteudoAresta.nextInt() - 1;
		int fim = conteudoAresta.nextInt() - 1;
		int custo = conteudoAresta.next().charAt(0) - '0';
		addVertice(grafo, inicio, fim, custo);
	}
	static void addVertice(Grafo grafo, int src, int dest, int custo) {
		grafo.adjacencia[src].addFirst(new Aresta(dest, custo));
		grafo.adjacencia[dest].addFirst(new Aresta(src, custo));
	}
	static void printgrafo(Grafo grafo) {
		for (int v = 0; v < grafo.key; v++) {
			System.out.println("Pontos ligados ao vertice " + (v + 1));
			for (Aresta aresta : grafo.adjacencia[v]) {
				System.out.println("Ligação: " + (aresta.getFim() + 1) + " || Custo: " + aresta.getCusto());
			}
			System.out.println("---------------------------");
		}
	}

}
