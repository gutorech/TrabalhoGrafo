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


public class Aresta {
	
    private int fim;
    private int custo;

    public Aresta(int dest, int custo) {
        this.fim = dest;
        this.custo = custo;
    }

    public int getFim() {
        return fim;
    }

    public int getCusto() {
        return custo;
    }
}


