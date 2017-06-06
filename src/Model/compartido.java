package Model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pepe_ on 21/05/2017.
 */
/*
Clase compartida con cliente y producto, contiene tanto atributos como metodos para usar en ambas
 */
public class compartido implements Serializable{
    protected int identificadorProducto;
    protected int identificadorCliente;

// constructor sin parametros
    public compartido() {
    }
//constructor para el cliente
    public compartido(int identificadorCliente) {
        setIdentificadorCliente(identificadorCliente);
    }

    //constructor para el producto
    public compartido(int identificadorProducto, int identificadorCliente) {
        setIdentificadorCliente(identificadorCliente);
        setIdentificadorProducto(identificadorProducto);
    }

    public int getIdentificadorProducto() {
        return identificadorProducto;
    }

    public void setIdentificadorProducto(int identificadorProducto) {
            this.identificadorProducto = identificadorProducto;

    }

    public int getIdentificadorCliente() {
        return identificadorCliente;
    }

    public void setIdentificadorCliente(int identificadorCliente) {
        this.identificadorCliente = identificadorCliente;
    }

//metodos para sustituir elementos no necesarios de un String

    public String sustituirNumeros(String sustituir) {
        Pattern patron = Pattern.compile("[1-9 ]*");
        Matcher matcher = patron.matcher(sustituir);
        sustituir = matcher.replaceAll(" ");
        sustituirEspacio(sustituir);

        return sustituir;

    }

    public String sustituirLetras(String sustituir) {
        Pattern patron = Pattern.compile("[a-zA-Z ]*");
        Matcher matcher = patron.matcher(sustituir);
        sustituir = matcher.replaceAll("");
        sustituirEspacio(sustituir);
        return sustituir;
    }

    public String sustituirEspacio(String sustituir) {
        Pattern patron = Pattern.compile("\\+");
        Matcher matcher = patron.matcher(sustituir);
        sustituir = matcher.replaceAll(" ");
        return sustituir;
    }
//toString por defecto
    @Override
    public String toString() {
        return "compartido{" +
                "identificadorProducto=" + identificadorProducto +
                ", identificadorCliente=" + identificadorCliente +
                '}';
    }
}