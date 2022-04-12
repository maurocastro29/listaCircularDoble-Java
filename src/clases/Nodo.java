/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Mauricio Castro
 */
public class Nodo {
    private int dato;
    private Nodo sgt;
    private Nodo ant;

    public Nodo(int dato) {
        this.dato = dato;
        this.sgt = null;
        this.ant = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSgt() {
        return sgt;
    }

    public void setSgt(Nodo sgt) {
        this.sgt = sgt;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }
    
    
}
