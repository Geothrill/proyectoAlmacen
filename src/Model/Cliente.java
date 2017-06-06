package Model;

import java.io.Serializable;

/**
 * Created by pepe_ on 16/05/2017.
 */
public class Cliente extends compartido implements Serializable {
    protected String nombre;
    protected String nombreEmpresa;
    protected String apellido1;
    protected String apellido2;
    protected String contacto;
    protected String direccion;
    protected String cargo_departamento;
//constructor sin parametros
    public Cliente() {
    }
//constructor por defecto
    public Cliente(int identificadorCliente, String nombre, String nombreEmpresa, String apellido1,
                   String apellido2, String contacto, String direccion, String cargo_departamento) {
        super(identificadorCliente);
        setNombre(nombre);
        setNombreEmpresa(nombreEmpresa);
        setApellido1(apellido1);
        setApellido2(apellido2);
        setContacto(contacto);
        setCargo_departamento(cargo_departamento);
        setDireccion(direccion);
    }
//getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = sustituirNumeros(nombre);
        this.nombre = nombre;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        nombreEmpresa=sustituirNumeros(nombreEmpresa);
        this.nombreEmpresa=nombreEmpresa;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        apellido1 = sustituirNumeros(apellido1);
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        apellido2=sustituirNumeros(apellido2);
        this.apellido2 = apellido2;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        contacto = sustituirLetras(contacto);
        this.contacto = contacto;
    }

    public String getDireccion() {return direccion;
    }

    public void setDireccion(String direccion) {
        direccion = sustituirEspacio(direccion);
        this.direccion = direccion;
    }

    public String getCargo_departamento() {
        return cargo_departamento;
    }

    public void setCargo_departamento(String cargo_departamento) {
        cargo_departamento = sustituirNumeros(cargo_departamento);
        this.cargo_departamento = cargo_departamento;
    }
//metodo toString para poder imprimir los clientes
    @Override
    public String toString() {

        String resultado = "";
        resultado+= "Id cliente: " + identificadorCliente + " Empresa: " + nombreEmpresa + "\n";
        resultado+= "Nombre: " + nombre + "  " + apellido1 + "  " + apellido2 + "\n";
        resultado+= "Direccion: " + direccion + " Contacto: " + contacto + "\n";
        resultado+= "Cargo: " + cargo_departamento + "\n";

        return resultado;
    }
}

