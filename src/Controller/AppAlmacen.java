package Controller;

import Model.Almacen;
import Model.Cliente;
import Model.Producto;

import java.io.IOException;
import java.util.Scanner;



/**
 * Created by pepe_ on 22/05/2017.
 */

/*
clase AppAlmacen que nos permite interactuar con las clases del modelo a traves de la consola
 */
public class AppAlmacen {

    private Almacen miAlmacen;
/*
creamos el almacen y cargamos los datos de los ficheros
 */
    public  AppAlmacen(){
        miAlmacen = new Almacen();
        miAlmacen.loadData();
    }

    /*
    iniciamos la aplicacion y se nos muestran las opciones disponibles, cada una de ellas nos llevara a un menu diferente.
    todos los numeros excepto los incluidos en el switch haran que el menu se repita a excepcion del 0, que saldra del programa
    al cerrar el programa se guardaran todos los cambios producidos en los clientes y en los productos
     */
    public void start() {
        int option;

        while ((option = showMenu()) != 0) {
            switch (option) {
                case 1:
                    showElements();
                    break;
                case 2:
                    addElement();
                    break;
                case 3:
                    deleteElements();
                    break;
                case 4:
                    sortPedido();
                    break;
                case 5:
                    modifyElement();
                    break;
            }
        }
            miAlmacen.saveData();
    }


    /*
    opciones del metodo start(), retorna un numero entero el cual usaremos para poder navegar entre diferentes menus
     */
    private static int showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Bienvenido a la gestion del almacen, indique la accion que desea realizar:");
        System.out.println("1 - Mostrar elementos");
        System.out.println("2 - Añadir elementos");
        System.out.println("3 - Eliminar elementos");
        System.out.println("4 - Ordenar pedido");
        System.out.println("5 - Modificar elementos");
        System.out.println("0 - Salir");
        System.out.println("Opción: ");

        option = scanner.nextInt();

        return option;
    }

/*
opcion que nos listara y mostrara por pantalla los clientes y productos en funcion de la opcion seleccionada.
la tercera opcion nos llevara a otro menu.
todos los numeros excepto los incluidos en el switch haran que el menu se repita a excepcion del 0, que volvera al menu anterior
 */
    private void showElements(){
        int option;
        while ((option = showElementsOptions()) != 0) {
            switch (option) {
                case 1:
                    miAlmacen.showClientes();
                    break;
                case 2:
                    miAlmacen.showProductos();
                    break;
                case 3:
                    choosePedido();
                    break;
            }
        }
    }
/*
opciones del metodo showElements, retorna un numero entero para que podamos navegar entre diferentes menus
 */
    public int showElementsOptions(){
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Seleccione el elemento que desea ver");
        System.out.println(" 1 - Clientes del almacen");
        System.out.println(" 2 - Productos entrantes y salientes");
        System.out.println(" 3 - Pedido del almacen");
        System.out.println(" 0 - Salir al menu principal");
        System.out.println("Opción: ");
        option = scanner.nextInt();
        return option;
    }
/*
muestra los productos segun sean de entrada o salida
todos los numeros excepto los incluidos en el switch haran que el menu se repita a excepcion del 0, que volvera al menu anterior
 */

    public  void choosePedido() {
        int option;
        while ((option = choosePedidoOptions()) != 0) {
            switch (option) {
                case 1:
                    miAlmacen.showPedidoEntrante();
                    break;
                case 2:
                    miAlmacen.showPedidoSaliente();
                    break;
            }
        }
    }
/*
opciones del metodo choosePedido, retorna un entero que nos permite navegar entre diferentes menus
 */
    public  int choosePedidoOptions(){
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Seleccione el pedido que desea ver");
        System.out.println(" 1 - Entrante");
        System.out.println(" 2 - Saliente");
        System.out.println(" 0 - Salir al menu anterior");
        System.out.println("Opción: ");
        option = scanner.nextInt();

        return option;

    }
    /*
    metodo que nos permite agregar clientes productos o productos segun el pedido.
    todos los numeros excepto los incluidos en el switch haran que el menu se repita a excepcion del 0, que volvera al menu anterior
     */

    public  void addElement() {
        int option;
        while ((option = addElementOptions()) != 0) {
            switch (option) {
                case 1:
                    miAlmacen.addClientes();
                    break;
                case 2:
                    miAlmacen.addProductos();
                    break;
                case 3:
                    addToPedido();
                    break;
            }
        }
    }
/*
opciones del metodo addElement, devuelve un entero que nos permite navegar entre menus
 */
    public int addElementOptions(){
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Seleccione el elemento que añadir");
        System.out.println(" 1 - Clientes del almacen");
        System.out.println(" 2 - Productos entrantes y salientes");
        System.out.println(" 3 - Pedido del almacen");
        System.out.println(" 0 - Salir al menu principal");
        System.out.println("Opción: ");
        option = scanner.nextInt();
        return option;
    }
/*
metodo que nos permite agregar productos segun sean del pedido entrante o del pedido saliente
todos los numeros excepto los incluidos en el switch haran que el menu se repita a excepcion del 0, que volvera al menu anterior
 */
    public void addToPedido() {
        int option;
        while ((option = addToPedidoOptions()) != 0) {
            switch (option) {
                case 1:
                    miAlmacen.addToPedidoEntrante();
                    break;
                case 2:
                    miAlmacen.addToPedidoSaliente();
                    break;
            }
        }
    }
/*
opciones del metodo addToPedido(), devuelve un entero que nos permite navegar entre menus
 */
    public int addToPedidoOptions(){
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Seleccione el pedido donde desea añadir el producto");
        System.out.println(" 1 - Entrante");
        System.out.println(" 2 - Saliente");
        System.out.println(" 0 - Salir al menu anterior");
        System.out.println("Opción: ");
        option = scanner.nextInt();

        return option;

    }

    /*
metodo que nos permite eliminar clientes , productos y/o productos segun el pedido
todos los numeros excepto los incluidos en el switch haran que el menu se repita a excepcion del 0, que volvera al menu anterior
 */

    public  void deleteElements(){
        int option;
        while ((option = deleteElementsOptions()) != 0) {
            switch (option) {
                case 1:
                    miAlmacen.deleteCliente();
                    break;
                case 2:
                    miAlmacen.deleteProducto();
                    break;
            }
        }
    }
    /*
    opciones del metodo deleteElement(), devuelve un entero que nos permite navegar entre menus
     */
    public static int deleteElementsOptions(){
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Seleccione el elemento que desea eliminar");
        System.out.println(" 1 - Clientes del almacen");
        System.out.println(" 2 - Productos entrantes y salientes");
        System.out.println(" 0 - Salir al menu principal");
        System.out.println("Opción: ");
        option = scanner.nextInt();

        return option;
    }

    /*
metodo que nos permite ordenar productos segun sean del pedido entrante o del pedido saliente
todos los numeros excepto los incluidos en el switch haran que el menu se repita a excepcion del 0, que volvera al menu anterior
 */

    public  void sortPedido() {
        int option;
        while ((option = sortPedidoOptions()) != 0) {
            switch (option) {
                case 1:
                    sortPedidoEntrante();
                    break;
                case 2:
                    sortPedidoSaliente();
                    break;
            }
        }
    }


    /*
    opciones del metodo sortPedido(), devuelve un entero que nos permite navegar entre menus
     */
    public  int sortPedidoOptions(){
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Seleccione el pedido que desea ordenar");
        System.out.println(" 1 - Entrante");
        System.out.println(" 2 - Saliente");
        System.out.println(" 0 - Salir al menu principal");
        System.out.println("Opción: ");
        option = scanner.nextInt();

        return option;
    }

/*
metodo que nos permite ordenar productos del pedido entrante segun diferentes criterios
todos los numeros excepto los incluidos en el switch haran que el menu se repita a excepcion del 0, que volvera al menu anterior
 */

    public  void sortPedidoEntrante() {
        int option;
        while ((option = sortPedidoEntranteOptions()) != 0) {
            switch (option) {
                case 1:
                    miAlmacen.sortPedidoEntrantePorIdProducto();
                    break;
                case 2:
                    miAlmacen.sortPedidoEntrantePorIdCliente();
                    break;
                case 3:
                    miAlmacen.sortPedidoEntrantePorNombre();
            }
        }
    }
    /*
    opciones del metodo sortPedidoEntrante(), devuelve un entero que nos permite navegar entre menus
     */
    public  int sortPedidoEntranteOptions(){
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Seleccione como desea ordenar los productos del pedido");
        System.out.println(" 1 - Por identificador de producto");
        System.out.println(" 2 - Por identificador de cliente");
        System.out.println(" 3 - Por nombre del producto");
        System.out.println(" 0 - Salir al menu anterior");
        System.out.println("Opción: ");
        option = scanner.nextInt();

        return option;

    }
    /*
    metodo que nos permite ordenar productos del pedido saliente segun diferentes criterios
    todos los numeros excepto los incluidos en el switch haran que el menu se repita a excepcion del 0, que volvera al menu anterior
     */
    public  void sortPedidoSaliente(){
        int option;
        while ((option = sortPedidoSalienteOptions()) != 0) {
            switch (option) {
                case 1:
                    miAlmacen.sortPedidoSalientePorIdProducto();
                    break;
                case 2:
                    miAlmacen.sortPedidoSalientePorIdCliente();
                    break;
                case 3:
                    miAlmacen.sortPedidoSalientePorNombre();
            }
        }
    }
    /*
    opciones del metodo sortPedidoSaliente(), devuelve un entero que nos permite navegar entre menus
     */
    public int sortPedidoSalienteOptions(){
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Seleccione como desea ordenar los productos del pedido");
        System.out.println(" 1 - Por identificador de producto");
        System.out.println(" 2 - Por identificador de cliente");
        System.out.println(" 3 - Por nombre del producto");
        System.out.println(" 0 - Salir al menu anterior");
        System.out.println("Opción: ");
        option = scanner.nextInt();

        return option;

    }
    /*
    metodo que nos permite modificar elementos dentro de los arraylist ya existentes
    todos los numeros excepto los incluidos en el switch haran que el menu se repita a excepcion del 0, que volvera al menu anterior
     */
    public void modifyElement() {
        int option;
        while ((option = modifyElementOptions()) != 0) {
            switch (option) {
                case 1:
                    miAlmacen.modifyClient();
                    break;
                case 2:
                    modifyProduct();
                    break;
            }
        }
    }

    /*
        opciones del metodo modifyElement(), devuelve un entero que nos permite navegar entre menus
         */
    public int modifyElementOptions(){
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Seleccione que desea modificar");
        System.out.println(" 1 - Modificar cliente");
        System.out.println(" 2 - Modificar producto");
        System.out.println(" 0 - Salir al menu principal");
        System.out.println("Opción: ");
        option = scanner.nextInt();

        return option;

    }
    /*
    metodo que nos permite modificar productos dentro de los arraylist segun sean entrantes o salientes
    todos los numeros excepto los incluidos en el switch haran que el menu se repita a excepcion del 0, que volvera al menu anterior
     */
    public void modifyProduct() {
        int option;
        while ((option = modifyProductOptions()) != 0) {
            switch (option) {
                case 1:
                    miAlmacen.modifyIncomingProduct();
                    break;
                case 2:
                    miAlmacen.modifyOutgoingProduct();
                    break;
            }
        }
    }
    /*
            opciones del metodo modifyProduct(), devuelve un entero que nos permite navegar entre menus
             */
    public int modifyProductOptions(){
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Seleccione que tipo de producto desea modificar");
        System.out.println(" 1 - Modificar producto de entrada");
        System.out.println(" 2 - Modificar producto de salida");
        System.out.println(" 0 - Salir al menu anterior");
        System.out.println("Opción: ");
        option = scanner.nextInt();

        return option;

    }

}

