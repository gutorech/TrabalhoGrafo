/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhografo;

import java.util.LinkedList;

public class Grafo {
		int key;
		LinkedList<Aresta> adjacencia[];

		@SuppressWarnings("unchecked")
		Grafo(int k) {
			this.key = k;
			adjacencia = new LinkedList[k];

			for (int i = 0; i < k; i++) {
				adjacencia[i] = new LinkedList<>();
			}
		}

		static void addAresta(Grafo grafo, int inicio, int fim, int custo) {
			grafo.adjacencia[inicio].addLast(new Aresta(fim, custo));
			grafo.adjacencia[fim].addLast(new Aresta(inicio, custo));
		}
	}