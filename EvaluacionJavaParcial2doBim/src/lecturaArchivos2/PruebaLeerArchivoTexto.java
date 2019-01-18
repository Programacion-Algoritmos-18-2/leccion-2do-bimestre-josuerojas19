package lecturaArchivos2;

// Fig. 14.12: PruebaLeerArchivoTexto.java
import java.util.ArrayList;

public class PruebaLeerArchivoTexto {

    public static void main(String args[]) {
        LeerArchivoTexto aplicacion = new LeerArchivoTexto();
        OperacionData operacion = new OperacionData(); 
        aplicacion.abrirArchivo("data/data2.txt");
        ArrayList<Profesor> lista = aplicacion.leerRegistrost();
        aplicacion.abrirArchivo("data/data1.csv");
        ArrayList<Profesor> lista_txt = aplicacion.abrir_archivoc();
        operacion.agregarInformacion(lista);
        ArrayList<Profesor> nlista = new ArrayList<>();
         for (int i = 0; i < lista.size(); i++) {
            nlista.add(lista.get(i));
        }
        for (int i = 0; i < lista_txt.size(); i++) {
            nlista.add(lista_txt.get(i));
        }
        operacion.agregarInformacion(nlista);
        operacion.cantidad_idoneidad();
        operacion.cantidad_personali();

        // operacion.lecturaData();

        operacion.ordenarPorCanton();
        ArrayList<Profesor> lista2 = operacion.ordenarPorNombres();
        System.out.println(lista2);
        // System.out.println("-------");
        // operacion.lecturaData();
        aplicacion.cerrarArchivo();
    } // fin de main
} // fin de la clase PruebaLeerArchivoTexto

