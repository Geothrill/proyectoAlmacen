package Model;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by pepe_ on 16/05/2017.
 */
public class Producto extends compartido implements Comparable<Producto>,Serializable {
    protected String nombre;
    protected int numeroCajas;
    public boolean entradaSalida; //si es true el producto es entrante, si es false el producto es saliente

//constructor sin parametros
    public Producto() {

    }
//constructor por defecto
    public Producto(int identificadorProducto, int identificadorCliente, String nombre, int numeroCajas, boolean entradaSalida) {
        super(identificadorProducto, identificadorCliente);
        setNombre(nombre);
        setNumeroCajas(numeroCajas);
        setEntradaSalida(entradaSalida);
    }
//getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = sustituirNumeros(nombre);
        this.nombre = nombre;
    }

    public int getNumeroCajas() {
        return numeroCajas;
    }

    public void setNumeroCajas(int numeroCajas) {
        this.numeroCajas = numeroCajas;
    }

    public boolean isEntradaSalida() {
        return entradaSalida;
    }

    public void setEntradaSalida(boolean entradaSalida) {
        this.entradaSalida = entradaSalida;
    }

   /*
    comparador de productos segun el identificador del producto, de menor a mayor
     */

    public static Comparator<Producto> comparadorPorIdProducto = new Comparator<Producto>() {
        @Override
        public int compare(Producto o1, Producto o2) {
            return o1.getIdentificadorProducto() - o2.getIdentificadorProducto();
        }
    };
/*
comparador del producto segun el identificador del cliente, de menor a mayor
 */
    public static Comparator<Producto> comparadorPorIdCliente = new Comparator<Producto>() {
        @Override
        public int compare(Producto o1, Producto o2) {
            if (o1.getIdentificadorCliente() == o2.getIdentificadorCliente()){
               return o1.getNombre().compareTo(o2.getNombre());
            }
            return o1.getIdentificadorCliente() - o2.getIdentificadorCliente();
        }
    };
/*
comparador por nombre ordenado alfabeticamente
 */
    public static Comparator<Producto> comparadorPorNombre = new Comparator<Producto>() {
        @Override
        public int compare(Producto o1, Producto o2) {
            return o1.getNombre().compareTo(o2.getNombre());
        }
    };
    /*
    sobrecarga del metodo compareTo para poder comparar elementos de tipo String y ordenarlos por su nombre
     */
    @Override
    public int compareTo(Producto producto) {
        int resultado;
        resultado = this.getNombre().compareToIgnoreCase(producto.getNombre());

        return resultado;
    }
/*
metodo toString para poder imprimir los productos, no detallara si el producto es de entrada o de salida
 */
    @Override
    public String toString() {
        String resultado = "";

        resultado+= "Id producto: " + super.identificadorProducto + "\n";
        resultado+= "Id cliente: " + super.identificadorCliente + "\n";
        resultado+= "Nombre: " + nombre + "\n";
        resultado+= "Numero de cajas: " +  numeroCajas + "\n";

        return resultado;
    }


}

