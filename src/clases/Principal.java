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
public class Principal {
    public static void main(String[] argv){
        ListaCircularDoble ptr = new ListaCircularDoble();
        int dato;
        int op = -1;
        boolean sw = true;
        while(sw == true){
            try{
                op = new Integer(
                    JOptionPane.showInputDialog(""
                            + "MENU DE OPCIONES\n\n"
                            + "1. Insertar al Inicio de la lista\n"
                            + "2. Insertar al Final de la lista\n"
                            + "3. Insertar despues de:\n"
                            + "4. Insertar antes de:\n"
                            + "5. Listar\n"
                            + "6. Buscar nodo\n"
                            + "7. Editar nodo\n"
                            + "8. Eliminar nodo\n"
                            + "9. Eliminar repetidos\n"
                            + "10. Salir\n"));
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error en la informacion suministrada, debe digitar un numero");
            }
            switch(op){
                case 1:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite el dato a insertar"));
                    Nodo n = new Nodo(dato);
                    ptr.insertarInicio(n);
                    break;
                }
                case 2:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite el dato a insertar"));
                    Nodo n = new Nodo(dato);
                    ptr.insertarFinal(n);
                    break;
                }
                case 3:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite el dato a insertar"));
                    Nodo n = new Nodo(dato);
                    int datoBuscar = new Integer(JOptionPane.showInputDialog("Digite el dato a buscar"));
                    ptr.insertarDespues(n, datoBuscar);
                    break;
                }
                case 4:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite el dato a insertar"));
                    Nodo n = new Nodo(dato);
                    int datoBuscar = new Integer(JOptionPane.showInputDialog("Digite el dato a buscar"));
                    ptr.insertarAntes(n, datoBuscar);
                    
                    break;
                }
                case 5:{
                    ptr.listar();
                    break;
                }
                case 6:{
                    int datoBuscar = new Integer(JOptionPane.showInputDialog("Digite el dato a buscar"));
                    Nodo aux = ptr.buscarNodo(datoBuscar);
                    if(aux == null){
                        JOptionPane.showMessageDialog(null, "No se encontro el dato en la lista ");
                    }else{
                        JOptionPane.showMessageDialog(null, "Dato encontrado");
                    }
                    break;
                }
                case 7:{
                    int datoBuscar = new Integer(JOptionPane.showInputDialog("Digite el dato a editar"));
                    dato = new Integer(JOptionPane.showInputDialog("Digite el nuevo dato"));
                    boolean edit = ptr.editarNodo(dato, datoBuscar);
                    if(edit){
                        JOptionPane.showMessageDialog(null, "Nodo editado con exito");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al editar el nodo.");
                    }
                    break;
                }
                case 8:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite nombre a eliminar"));
                    boolean elim = ptr.eliminarNodo(dato);
                    if(elim){
                        JOptionPane.showMessageDialog(null, "Nodo eliminado con exito");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al eliminar el nodo.");
                    }
                    break;
                }
                case 9:{
                    ptr.eliminarRepetidos();
                    break;
                }
                case 10:{
                    int salir = JOptionPane.showConfirmDialog(null, "Realmente desea salir?");
                    if(salir == 0){
                        sw = false;
                    }
                    break;
                }
                default:{
                    JOptionPane.showMessageDialog(null, "Opcion invalida, intentelo nuevamente");
                    break;
                }
            }
        }
    }
}
