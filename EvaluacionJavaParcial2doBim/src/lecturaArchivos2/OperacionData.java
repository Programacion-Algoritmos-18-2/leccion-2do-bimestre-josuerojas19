/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author reroes
 */
public class OperacionData {

    ArrayList<Profesor> informacion = new ArrayList<>();

    public void agregarInformacion(ArrayList<Profesor> info) {
        informacion = info;
    }

    public ArrayList<Profesor> obtenerInformacion() {
        return informacion;
    }

    public double obtenerPromedioCapacidad() {
        double suma = 0;
        return suma;
    }
    
    // proceso de ordenar, a través del uso de Collections
    public void ordenarPorCanton(){
        ArrayList<Profesor> dataPorCantones = new ArrayList<>();
        dataPorCantones.addAll(informacion);
        Collections.sort(dataPorCantones, 
                        (o1, o2) -> o1.canton.compareTo(o2.canton));
        for (int i = 0; i < dataPorCantones.size(); i++) {
            System.out.println(dataPorCantones.get(i));
        }
    }
    
    public ArrayList<Profesor> ordenarPorNombres(){
        ArrayList<Profesor> dataPorNombres = new ArrayList<>();
        dataPorNombres.addAll(informacion);
        Collections.sort(dataPorNombres, 
                        (o1, o2) -> o1.nombres.compareTo(o2.nombres));
        return dataPorNombres;
        
    }
    
    public void cantidad_personali(){
        int cade = 0;
        int cpra = 0;
        for (int i = 0; i < this.informacion.size(); i++) {
            if (this.informacion.get(i).getPersonalidad().equals("ADECUADO")) {
                cade++;
            }else if (this.informacion.get(i).getPersonalidad().equals("POR CONVOCAR")) {
                cpra++;
            }
            System.out.println("Cantidad de personas con personalidad ADECUADO : "+cade);
            System.out.println("Cantidad de personas con personalidad POR CONVOCADO : "+cpra);
        }
        
    }
    public void cantidad_idoneidad(){
        int ci = 0;
        int cni = 0;
        for (int i = 0; i < this.informacion.size(); i++) {
            if (this.informacion.get(i).getDictamenIdoniedad().equals("IDONEO")) {
                ci++;
            } else if (this.informacion.get(i).getDictamenIdoniedad().equals("NO IDONEO")) {
                cni ++;
            }
        }
        System.out.println("Cantidad de personas IDONEO : "+ci);
        System.out.println("Cantidad de personas NO IDONEO : "+cni);
    }
    
    public void lecturaData() {
        for (int i = 0; i<obtenerInformacion().size(); i++) {
            System.out.println(obtenerInformacion().get(i));
            
        }
        
    }

}
