/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Castro
 */
public class ListaCircularDoble {
    private Nodo ptr;

    public ListaCircularDoble() {
        this.ptr = null;
    }

    public Nodo getPtr() {
        return ptr;
    }

    public void setPtr(Nodo ptr) {
        this.ptr = ptr;
    }
    
    public boolean isVacia(){
        return this.getPtr() == null;
    }
    
    public Nodo buscarNodo(int dato){
        if(!this.isVacia()){
            Nodo aux = this.getPtr();
            while(aux.getSgt() != this.getPtr()){
                if(aux.getDato() == dato){
                    return aux;
                }
                aux = aux.getSgt();
            }
            if(aux.getDato() == dato){
                return aux;
            }
        }
        return null;
    }
    
    public void insertarInicio(Nodo nodo){
        if(this.isVacia()){
            this.setPtr(nodo);
            this.getPtr().setSgt(this.getPtr());
            this.getPtr().setAnt(this.getPtr());
        }else{
            nodo.setSgt(this.getPtr());
            nodo.setAnt(this.getPtr().getAnt());
            this.getPtr().getAnt().setSgt(nodo);
            this.getPtr().setAnt(nodo);
            this.setPtr(nodo);
        }
    }
    
    public void insertarFinal(Nodo nodo){
        if(this.isVacia()){
            this.setPtr(nodo);
            this.getPtr().setSgt(this.getPtr());
            this.getPtr().setAnt(this.getPtr());
        }else{
            nodo.setSgt(this.getPtr());
            nodo.setAnt(this.getPtr().getAnt());
            this.getPtr().getAnt().setSgt(nodo);
            this.getPtr().setAnt(nodo);
        }
    }
    
    public void insertarDespues(Nodo nodo, int dato){
        if(!this.isVacia()){
            Nodo aux = buscarNodo(dato);
            if(aux!=null){
                nodo.setSgt(aux.getSgt());
                nodo.setAnt(aux);
                aux.getSgt().setAnt(nodo);
                aux.setSgt(nodo);
                JOptionPane.showMessageDialog(null, "Nodo insertado");
            }else{
                JOptionPane.showMessageDialog(null, "Nodo no encontrado.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }
    }
    
    public void insertarAntes(Nodo nodo, int dato){
        if(!this.isVacia()){
            Nodo aux = buscarNodo(dato);
            if(aux!=null){
                if(aux==this.getPtr()){
                    nodo.setSgt(this.getPtr());
                    nodo.setAnt(this.getPtr().getAnt());
                    aux.getAnt().setSgt(nodo);
                    aux.setAnt(nodo);
                    this.setPtr(nodo);
                }else{
                    nodo.setSgt(aux.getSgt());
                    nodo.setAnt(aux);
                    aux.getSgt().setAnt(nodo);
                    aux.setSgt(nodo);
                }
                JOptionPane.showMessageDialog(null, "Nodo insertado");
            }else{
                JOptionPane.showMessageDialog(null, "Nodo no encontrado.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }
    }
    
    public boolean editarNodo(int datoNuevo, int datoBuscar){
        if(!this.isVacia()){
            Nodo aux = buscarNodo(datoBuscar);
            if(aux!=null){
                aux.setDato(datoNuevo);
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarNodo(int datoBuscar){
        if(!this.isVacia()){
            Nodo aux = buscarNodo(datoBuscar);
            if(aux!=null){
                if(aux==this.getPtr()){
                    this.setPtr(aux.getSgt());
                    aux.getAnt().setSgt(aux.getSgt());
                    aux.getSgt().setAnt(aux.getAnt());
                    aux.setSgt(null);
                    aux.setAnt(null);
                }else{
                    aux.getAnt().setSgt(aux.getSgt());
                    aux.getSgt().setAnt(aux.getAnt());
                    aux.setSgt(null);
                    aux.setAnt(null);
                }
                return true;
            }
        }
        return false;
    }
    
    public void eliminarNodo(Nodo nodo){
        if(!this.isVacia()){
            
        }
    }
    
    public void listar(){
        if(!this.isVacia()){
            Nodo aux = this.getPtr();
            String datos = "";
            while(aux.getSgt() != this.getPtr()){
                datos += "["+aux.getDato()+"]->";
                aux = aux.getSgt();
            }
            datos += "["+aux.getDato()+"]->";
            JOptionPane.showMessageDialog(null, datos);
        }else{
            JOptionPane.showMessageDialog(null, "Lista vacia.");
        }
    }
    
    public void eliminarRepetidos(){
        if(!this.isVacia()){
            Nodo aux = this.getPtr();
            Nodo aux2 = aux.getSgt();
            while(aux.getSgt()!=this.getPtr()){
                while(aux2!=this.getPtr()){
                    if(aux.getDato() == aux2.getDato()){
                        aux2.getSgt().setAnt(aux2.getAnt());
                        aux2.getAnt().setSgt(aux2.getSgt());
                        aux2.setSgt(null);
                        aux2 = aux.getSgt();
                    }else{
                        aux2 = aux2.getSgt();
                    }
                }
                aux = aux.getSgt();
                aux2 = aux.getSgt();
            }
            JOptionPane.showMessageDialog(null, "Repetidos eliminados");
        }else{
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }
    }
    
}
