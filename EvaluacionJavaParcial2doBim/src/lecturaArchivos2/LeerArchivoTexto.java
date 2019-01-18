package lecturaArchivos2;

// Fig. 14.11: LeerArchivoTexto.java
// Este programa lee un archivo de texto y muestra cada registro.

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

public class LeerArchivoTexto {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo(String archivo) {
        try {
            entrada = new Scanner(new File(archivo));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del m�todo abrirArchivo

    // lee registro del archivo
    
    public ArrayList<Profesor> leerRegistrost() {

        OperacionData operacion = new OperacionData();
        ArrayList<Profesor> lista = new ArrayList<>();

        try // lee registros del archivo, usando el objeto Scanner
        {
            entrada.nextLine();
            while (entrada.hasNext()) {
                // se crea el objeto para leer Json
                Gson g = new Gson();
                String linea = entrada.nextLine();
                // se hace el proceso de transformación
                Profesor p = g.fromJson(linea, Profesor.class);
                lista.add(p);
                //System.out.println(p);

            } // fin de while

        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
        return lista;
    } 

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del m�todo cerrarArchivo
    public ArrayList<Profesor> abrir_archivoc(){
        ArrayList<Profesor> nlista = new ArrayList<>();
        try{
            String l = entrada.nextLine();
            while(entrada.hasNext()){
                ArrayList<String> linea = new ArrayList<String>(Arrays.asList(l.split(",")));
                Profesor pro = new Profesor();
                pro.setCedula(linea.get(0));
                pro.setNombres(linea.get(1));
                pro.setZona(linea.get(2));
                pro.setProvincia(linea.get(3));
                pro.setCanton(linea.get(4));
                pro.setPersonalidad(linea.get(5));
                pro.setRazonamiento(linea.get(6));
                pro.setDictamenIdoniedad(linea.get(7));
                nlista.add(pro);
            }
        }
        catch (NoSuchElementException elementException) {           
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } 
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        }
        return nlista;
    }
    
    FileWriter dato = null;
    PrintWriter w = null;
    
    public void escribir_archivo(ArrayList<Profesor> lista) throws IOException{
        String direc = "data/nuevo.txt";
        File archivo = new File(direc);
        
        if (archivo.exists()) {
            archivo.createNewFile();
        }
        BufferedWriter b = null;
        String c = "";
        try{
            b = new BufferedWriter(new FileWriter(archivo));
            b.write("Nuevo archivo creado");
            b = new BufferedWriter(new FileWriter(archivo));
            for (int i = 0; i <lista.size(); i++) {
                Profesor p = lista.get(i);
                c = String.format("%s - %s - %s - %s - %s - %s - %s - %s\n", p.getCedula(), p.getNombres(), p.getZona(), p.getProvincia(), p.getCanton(), p.getPersonalidad(), p.getRazonamiento(), p.getDictamenIdoniedad());
                b.write(c);
            }
            b.close();
        }catch(IOException e){
            System.out.println("ERROR: "+ e);
        }
    }
    
} // fin de la clase LeerArchivoTexto

/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigaci�n y prueba de las teor�as y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garant�a de      *
 * ning�n tipo, expresa o impl�cita, en relaci�n con estos programas o    *
 * con la documentaci�n contenida en estos libros. Los autores y el       *
 * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de    *
 * estos programas.                                                       *
 *************************************************************************/
