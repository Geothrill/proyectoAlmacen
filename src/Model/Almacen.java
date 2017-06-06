package Model;


import java.io.*;
import java.util.*;

/**
 * Created by pepe_ on 03/06/2017.
 */
public class Almacen extends compartido {


    private  ArrayList<Cliente> clientes;
    private  ArrayList<Producto> productos;
//constructor del almacen
    public Almacen() {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
    }
// carga de datos mediante el uso de ficheros
    public void loadData() {
        try {
            ObjectInputStream clientesData = new ObjectInputStream(new FileInputStream("info/clientes.dat"));
            ObjectInputStream productosData = new ObjectInputStream(new FileInputStream("info/productos.dat"));
            clientes = (ArrayList<Cliente>)clientesData.readObject();
            productos = (ArrayList<Producto>)productosData.readObject();
            clientesData.close();
            productosData.close();

        } catch (IOException e) {
            System.out.println("Fallo al cargar el archivo");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra la clase");
        }
    }
//metodo para guardar los datos de los arraylist, utilizado automaticamente al salir del programa
    public void saveData() {
        try {
            ObjectOutputStream clientesData = new ObjectOutputStream( new FileOutputStream("info/clientes.dat"));
            clientesData.writeObject( clientes );
            clientesData.close();

            ObjectOutputStream productosData = new ObjectOutputStream( new FileOutputStream("info/productos.dat"));
            productosData.writeObject( productos );
            productosData.close();
        } catch (IOException e) {
            System.out.println("Fallo al guardar el archivo");
        }
    }
//muestra los clientes, el contador a 1 nos permite que la lista a modo visual no empiece por 0
    public  void showClientes() {
        int contador=1;
        for (Cliente cliente : clientes) {
            System.out.println("Cliente " + contador++);
            System.out.println(cliente);
        }
    }
    //muestra los productos, el contador a 1 nos permite que la lista a modo visual no empiece por 0
    public  void showProductos() {
        int contador=1;
        for (Producto producto : productos) {
            System.out.println("Producto " + contador++);
            System.out.println(producto);
        }
    }

    //muestra el pedido saliente, el contador a 1 nos permite que la lista a modo visual no empiece por 0
    public  void showPedidoSaliente() {
        int contador = 1;
        for (Producto producto : productos) {
            if (producto.entradaSalida == false) {
                System.out.println("Producto " + contador++);
                System.out.println(producto);
            }
        }
        }

    //muestra los pedido entrante, el contador a 1 nos permite que la lista a modo visual no empiece por 0
    public  void showPedidoEntrante() {
        int contador = 1;
        for (Producto producto : productos) {
            if (producto.entradaSalida==true) {
                System.out.println("Producto " + contador++);
            System.out.println(producto);
            }
        }
    }

//agrega uno o mas clientes solicitando los parametros por consola
    public  void addClientes() {
        Scanner scanner = new Scanner(System.in);
        int numeroClientes=0;
        int identificadorCliente=0;
        String nombre, nombreEmpresa, apellido1, apellido2,
                contacto, direccion, cargo_departamento;

                System.out.println("Introduzca el numero de clientes que desea añadir");
                numeroClientes = scanner.nextInt();

        if (numeroClientes > 0) {
            for (int i = 0; i < numeroClientes; i++) {

                System.out.println("Introduzca el identificador de cliente");
                identificadorCliente = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Introduzca el nombre del cliente");
                nombre = scanner.nextLine();

                System.out.println("Introduzca el primer apellido");
                apellido1 = scanner.nextLine();

                System.out.println("Introduzca el segundo apellido");
                apellido2 = scanner.nextLine();

                System.out.println("Introduzca el nombre de la empresa");
                nombreEmpresa = scanner.nextLine();

                System.out.println("introduzca el numero de contacto");
                contacto = scanner.nextLine();

                System.out.println("Introduzca la direccion");
                direccion = scanner.nextLine();

                System.out.println("Introduzca el cargo del cliente");
                cargo_departamento = scanner.nextLine();

                Cliente cliente = new Cliente(identificadorCliente, nombre, apellido1, apellido2,
                        nombreEmpresa, contacto, direccion, cargo_departamento);

                clientes.add(cliente);
            }
        }
    }
    //agrega uno o mas productos solicitando los parametros por consola
    public void addProductos() {
        Scanner scanner = new Scanner(System.in);
        int numeroProductos, identificadorCliente, identificadorProducto;
        String nombre, esEntradaSalida;
        boolean entradaSalida = true;//inicializamos la variable

        System.out.println("Introduzca el numero de productos que desea añadir");
        numeroProductos = scanner.nextInt();

        if (numeroProductos > 0) {
            for (int i = 0; i < numeroProductos; i++) {
                System.out.println("Producto: " + i);
                System.out.println();

                System.out.println("Introduzca el identificador de cliente");
                identificadorCliente = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Introduzca el identificador del producto");
                identificadorProducto = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Introduzca el nombre del producto");
                nombre = scanner.nextLine();
                scanner.nextLine();

                System.out.println("Introduzca el numero de cajas del producto");
                numeroProductos = scanner.nextInt();
                scanner.nextLine();
                //asignamos la variable en funcion de si el producto es de entrada o de salida
                do {
                    System.out.println("Indique si es de entrada o salida");
                    esEntradaSalida = scanner.nextLine();
                    if (esEntradaSalida.toLowerCase().equals("entrada")) {
                        entradaSalida = true;
                    } else if (esEntradaSalida.toLowerCase().equals("salida")) {
                        entradaSalida = false;
                    } else {
                        esEntradaSalida = "";
                    }

                } while (esEntradaSalida.equals(""));

                Producto producto = new Producto(identificadorProducto, identificadorCliente, nombre, numeroProductos, entradaSalida);

                productos.add(producto);
            }
        }
    }
    //agrega uno o mas productos entrantes solicitando los parametros por consola
    public void addToPedidoEntrante() {
        Scanner scanner = new Scanner(System.in);
        int numeroProductos, identificadorCliente, identificadorProducto;
        String nombre;
        final boolean ENTRADASALIDA = true;//ver clase Producto

        System.out.println("Introduzca el numero de productos que desea añadir");

        numeroProductos = scanner.nextInt();

        if (numeroProductos>0){
            for (int i = 0; i < numeroProductos; i++) {
                System.out.println("Introduzca el identificador de cliente");
                identificadorCliente = scanner.nextInt();

                System.out.println("Introduzca el identificador del producto");
                identificadorProducto = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Introduzca el nombre del producto");
                nombre = scanner.nextLine();

                System.out.println("Introduzca el numero de cajas del producto");
                numeroProductos = scanner.nextInt();


                Producto producto = new Producto(identificadorProducto, identificadorCliente, nombre, numeroProductos, ENTRADASALIDA);

                productos.add(producto);
            }
        }
    }
    //agrega uno o mas productos salientes  solicitando los parametros por consola
    public void addToPedidoSaliente() {
        Scanner scanner = new Scanner(System.in);
        int numeroProductos, identificadorCliente, identificadorProducto;
        String nombre;
        final boolean ENTRADASALIDA = false;//ver clase producto

        System.out.println("Introduzca el numero de productos que desea añadir");

        numeroProductos = scanner.nextInt();

        if (numeroProductos > 0) {
            for (int i = 0; i < numeroProductos; i++) {
                System.out.println("Introduzca el identificador de cliente");
                identificadorCliente = scanner.nextInt();

                System.out.println("Introduzca el identificador del producto");
                identificadorProducto = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Introduzca el nombre del producto");
                nombre = scanner.nextLine();

                System.out.println("Introduzca el numero de cajas del producto");
                numeroProductos = scanner.nextInt();

                Producto producto = new Producto(identificadorProducto, identificadorCliente, nombre, numeroProductos, ENTRADASALIDA);

                productos.add(producto);
            }
        }
    }
//elimina un cliente y todos los productos que coincidan con su identificador de cliente tanto entrantes como salientes
    public void deleteCliente() {
        Scanner scanner = new Scanner(System.in);
        int indice;
        Cliente cliente;
        Producto producto;
        showClientes();
        System.out.println("Indique el indice del cliente que desea eliminar");
        indice = scanner.nextInt();
        indice--;//reducimos el indice para que la lista comience por 0, de lo contrario podria dar un OutOfBound
        cliente = clientes.get(indice);
        for (int i = 0; i < productos.size(); i++) {
            producto = productos.get(i);
            if (Objects.equals(producto.identificadorCliente, cliente.identificadorCliente)) {
                productos.remove(i);
            }
        }
        clientes.remove(indice);

    }

/*
eliminamos un producto del almacen, no tendremos en cuenta si es entrante o saliente
 */
    public void deleteProducto() {
        Scanner scanner = new Scanner(System.in);
        int indice;
        showProductos();
        System.out.println("Indique el indice del producto que desea eliminar");
        indice = scanner.nextInt();
        indice--;//reducimos el indice para que la lista comience por 0
        productos.remove(indice);

    }

/*
metodo para ordenar el pedido entrante segun la id del producto
primero se crea un Arraylist que contenga los elementos, los distinguimos por entrada o salida
y se imprime el array
 */
    public void sortPedidoEntrantePorIdProducto() {
        ArrayList<Producto> pedido = new ArrayList<>();
        for (Producto producto: productos) {
            if ((producto.isEntradaSalida())) {
                pedido.add(producto);
            }
        }
        Collections.sort(pedido, Producto.comparadorPorIdProducto);
        for (Producto producto: pedido){
            System.out.println(producto);
        }
    }
    /*
    metodo para ordenar el pedido entrante segun la id del cliente
    primero se crea un Arraylist que contenga los elementos, los distinguimos por entrada o salida
    y se imprime el array
     */
    public void sortPedidoEntrantePorIdCliente() {
        ArrayList<Producto> pedido = new ArrayList<>();
        for (Producto producto: productos){
            if (producto.entradaSalida)
                pedido.add(producto);
        }
        Collections.sort(pedido, Producto.comparadorPorIdCliente);
        for (Producto producto: pedido){
            System.out.println(producto);
        }
    }
    /*
    metodo para ordenar el pedido entrante segun el nombre del producto
    primero se crea un Arraylist que contenga los elementos, los distinguimos por entrada o salida
    y se imprime el array
     */
    public void sortPedidoEntrantePorNombre() {
        ArrayList<Producto> pedido = new ArrayList<>();
        for (Producto producto: productos){
            if (producto.entradaSalida)
                pedido.add(producto);
        }
        Collections.sort(pedido,Producto.comparadorPorNombre);

        for (Producto producto: pedido){
            System.out.println(producto);
        }
    }
    /*
    metodo para ordenar el pedido saliente segun la id del producto
    primero se crea un Arraylist que contenga los elementos, los distinguimos por entrada o salida
    y se imprime el array
     */
    public void sortPedidoSalientePorIdProducto() {
        ArrayList<Producto> pedido = new ArrayList<>();
        for (Producto producto: productos){
            if (producto.entradaSalida)
                pedido.add(producto);
        }
        Collections.sort(pedido, Producto.comparadorPorIdProducto);

        for (Producto producto: pedido){
            System.out.println(producto);
        }

    }
    /*
    metodo para ordenar el pedido saliente segun la id del cliente
    primero se crea un Arraylist que contenga los elementos, los distinguimos por entrada o salida
    y se imprime el array
     */
    public void sortPedidoSalientePorIdCliente() {
        ArrayList<Producto> pedido = new ArrayList<>();
        for (Producto producto: productos){
            if (producto.entradaSalida)
                pedido.add(producto);
        }
        Collections.sort(pedido, Producto.comparadorPorIdCliente);
        for (Producto producto: pedido){
            System.out.println(producto);
        }

    }
    /*
    metodo para ordenar el pedido saliente segun el nombre del producto
    primero se crea un Arraylist que contenga los elementos, los distinguimos por entrada o salida
    y se imprime el array
     */
    public void sortPedidoSalientePorNombre() {
        ArrayList<Producto> pedido = new ArrayList<>();
        for (Producto producto: productos){
            if (producto.entradaSalida)
                pedido.add(producto);
        }
        Collections.sort(pedido,Producto.comparadorPorNombre);
        for (Producto producto: pedido){
            System.out.println(producto);
        }

    }

    /*
     *metodo que nos permite modificar un cliente ya existente
     * en el caso de introducir una cadena vacia o un entero de valor 0 o menor, se mantendra el valor ya existente
     */

    public void modifyClient() {
        int indice;
        int identificadorCliente;
        String nombre, apellido1, apellido2,
                nombreEmpresa, contacto, direccion, cargo_departamento;
        showClientes();
        System.out.println("Indique el indice del cliente que desea modificar");
        Scanner scanner = new Scanner(System.in);
        indice = scanner.nextInt();
        indice--;

        Cliente cliente = clientes.get(indice);

        System.out.println("Introduzca el nuevo identificador de cliente");
        identificadorCliente = scanner.nextInt();

        if (identificadorCliente < 0) {
            cliente.setIdentificadorCliente(cliente.identificadorCliente);
        } else {
            cliente.setIdentificadorCliente(identificadorCliente);
        }
            System.out.println("Introduzca el nuevo nombre");
            nombre = scanner.nextLine();
            sustituirNumeros(nombre);

            if (nombre.equals(" ")){
                cliente.setNombre(cliente.nombre);
            } else{
                cliente.setNombre(nombre);
            }


        System.out.println("Introduzca el nuevo primer apellido");
        apellido1 = scanner.nextLine();
        sustituirNumeros(apellido1);


        if (apellido1.equals(" ")){
            cliente.setApellido1(cliente.apellido1);
        } else{
            cliente.setApellido1(apellido1);
        }
        System.out.println("Introduzca el nuevo segundo apellido");
        apellido2 = scanner.nextLine();
        sustituirNumeros(apellido2);


        if (apellido2.equals(" ")){
            cliente.setApellido2(cliente.apellido2);
        } else{
            cliente.setApellido2(apellido2);
        }
        System.out.println("Introduzca el nuevo nombre de la empresa");
        nombreEmpresa = scanner.nextLine();
        sustituirNumeros(nombreEmpresa);

        if (nombreEmpresa.equals(" ")){
            cliente.setNombreEmpresa(cliente.nombreEmpresa);
        } else{
            cliente.setNombreEmpresa(nombreEmpresa);
        }
        System.out.println("Introduzca el nuevo contacto");
        contacto = scanner.nextLine();
        sustituirLetras(contacto);

        if (contacto.equals(" ")){
            cliente.setContacto(cliente.contacto);
        } else{
            cliente.setContacto(contacto);
        }
        System.out.println("Introduzca la nueva direccion");
        direccion = scanner.nextLine();
        sustituirEspacio(direccion);

        if (direccion.equals(" ")){
            cliente.setDireccion(cliente.direccion);
        } else{
            cliente.setDireccion(direccion);
        }

        System.out.println("Introduzca el nuevo cargo de departamento");
        cargo_departamento = scanner.nextLine();
        sustituirNumeros(cargo_departamento);


        if (cargo_departamento.equals(" ")){
            cliente.setCargo_departamento(cliente.cargo_departamento);
        } else{
            cliente.setCargo_departamento(cargo_departamento);
        }

    }
    /*
    metodo que nos permite modificar un producto entrante
    en el caso de introducir una cadena vacia o un entero de valor 0 o menor, se mantendra el valor ya existente
     */


    public void modifyIncomingProduct() {
        int indice;
        int contador=0;
        int identificadorCliente, identificadorProducto, numeroCajas;
        String nombre;
        showPedidoEntrante();
        System.out.println("Indique el indice del producto entrante que desea modificar");
        Scanner scanner = new Scanner(System.in);
        indice = scanner.nextInt();
        indice--;

        for (Producto producto: productos){
            if(producto.entradaSalida){
                contador++;
                if (contador==indice){
                    System.out.println("Introduzca el nuevo identificador de cliente");
                    identificadorCliente = scanner.nextInt();

                    if (identificadorCliente<0){
                        producto.setIdentificadorCliente(producto.identificadorCliente);
                    }else{
                        producto.setIdentificadorCliente(identificadorCliente);
                    }

                    System.out.println("Introduzca el nuevo identificador de producto");
                    identificadorProducto = scanner.nextInt();

                    if (identificadorProducto<0){
                        producto.setIdentificadorProducto(producto.identificadorProducto);
                    }else{
                        producto.setIdentificadorProducto(identificadorProducto);
                    }
                    scanner.nextLine();

                    System.out.println("Introduzca el nuevo nombre");
                    nombre = scanner.nextLine();

                    if (nombre.equals("")){
                        producto.setNombre(producto.nombre);
                    } else{
                        producto.setNombre(nombre);
                    }

                    System.out.println("Introduzca el numero de cajas");
                    numeroCajas = scanner.nextInt();

                    if (numeroCajas<0){
                        producto.setNumeroCajas(producto.numeroCajas);
                    }else{
                        producto.setNumeroCajas(numeroCajas);;
                    }
                }
            }
        }

    }
    /*
       metodo que nos permite modificar un producto entrante
       en el caso de introducir una cadena vacia o un entero de valor 0 o menor, se mantendra el valor ya existente
        */
    public void modifyOutgoingProduct() {
        int indice;
        int contador=0;
        int identificadorCliente, identificadorProducto, numeroCajas;
        String nombre;
        showPedidoSaliente();
        System.out.println("Indique el indice del producto entrante que desea modificar");
        Scanner scanner = new Scanner(System.in);
        indice = scanner.nextInt();
        indice--;

        for (Producto producto: productos){
            if(!producto.entradaSalida){
                contador++;
                if (contador==indice){
                    System.out.println("Introduzca el nuevo identificador de cliente");
                    identificadorCliente = scanner.nextInt();

                    if (identificadorCliente<0){
                        producto.setIdentificadorCliente(producto.identificadorCliente);
                    }else{
                        producto.setIdentificadorCliente(identificadorCliente);
                    }

                    System.out.println("Introduzca el nuevo identificador de producto");
                    identificadorProducto = scanner.nextInt();

                    if (identificadorProducto<0){
                        producto.setIdentificadorProducto(producto.identificadorProducto);
                    }else{
                        producto.setIdentificadorProducto(identificadorProducto);
                    }
                    scanner.nextLine();
                    System.out.println("Introduzca el nuevo nombre");
                    nombre = scanner.nextLine();

                    if (nombre.equals("")){
                        producto.setNombre(producto.nombre);
                    } else{
                        producto.setNombre(nombre);
                    }

                    System.out.println("Introduzca el numero de cajas");
                    numeroCajas = scanner.nextInt();

                    if (numeroCajas<0){
                        producto.setNumeroCajas(producto.numeroCajas);
                    }else{
                        producto.setNumeroCajas(numeroCajas);;
                    }
                }
            }
        }
    }
}


