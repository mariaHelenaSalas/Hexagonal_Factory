package com.hexagonaljava;

import java.util.List;
import java.util.Scanner;

import com.hexagonaljava.application.usecase.client.ClientUseCase;
import com.hexagonaljava.application.usecase.product.ProductUseCase;
import com.hexagonaljava.domain.entity.Client;
import com.hexagonaljava.domain.entity.Product;
import com.hexagonaljava.domain.repository.ClientRespository;
import com.hexagonaljava.domain.repository.ProductRepository;
import com.hexagonaljava.infrastructure.database.ConnectionFactory;
import com.hexagonaljava.infrastructure.persistence.client.ClientRepositoryImpl;
import com.hexagonaljava.infrastructure.persistence.product.ProductRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        ClientRespository clientRepository = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
        ProductRepository productRepository = new ProductRepositoryImpl(ConnectionFactory.crearConexion());

        ClientUseCase clientUseCase = new ClientUseCase(clientRepository);
        ProductUseCase productUseCase = new ProductUseCase(productRepository);

        
        try (Scanner teclado = new Scanner(System.in)) {
            int option;

            do {
                System.out.println("\n=================================");
                System.out.println("         MENU PRINCIPAL         ");
                System.out.println("=================================");
                System.out.println("1  Gestión de Clientes");
                System.out.println("2  Gestión de Productos");
                System.out.println("0  Salir");
                System.out.println("=================================");
                System.out.print("Ingrese una opción: ");

                while (!teclado.hasNextInt()) { // Validar que sea un número
                    System.out.println(" Entrada inválida. Ingrese un número.");
                    teclado.next(); // Limpiar entrada incorrecta
                }
                option = teclado.nextInt();
                teclado.nextLine(); // Limpiar buffer

                switch (option) {
                    case 1:
                        menuClientes(teclado, clientUseCase);
                        break;
                    case 2:
                        menuProductos(teclado, productUseCase);
                        break;
                    case 0:
                        System.out.println(" Saliendo... ¡Hasta luego!");
                        break;
                    default:
                        System.out.println(" Opción no válida. Intente nuevamente.");
                }
            } while (option != 0);
        }
    }

    private static void menuClientes(Scanner teclado, ClientUseCase clientUseCase) {
        int opcion;
        do {
            System.out.println("\n=================================");
            System.out.println("      GESTIÓN DE CLIENTES        ");
            System.out.println("=================================");
            System.out.println("1  Registrar Cliente");
            System.out.println("2  Listar Clientes");
            System.out.println("3  Actualizar Cliente");
            System.out.println("4  Eliminar Cliente");
            System.out.println("0  Volver al menú principal");
            System.out.println("=================================");
            System.out.print("Seleccione una opción: ");

            while (!teclado.hasNextInt()) {
                System.out.println(" Entrada inválida. Ingrese un número.");
                teclado.next();
            }
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del cliente: ");
                    int id = validarEntero(teclado);
                    
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Ingrese el Email: ");
                    String email = teclado.nextLine();

                    clientUseCase.registrarCliente(id, nombre, email);
                    System.out.println(" CLIENTE REGISTRADO CON ÉXITO");
                    break;

                case 2:
                    List<Client> clientes = clientUseCase.listarClientes();
                    System.out.println("\n Lista de Clientes:");
                    for (Client cliente : clientes) {
                        System.out.println(cliente);
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el ID del cliente que desea actualizar: ");
                    int idActualizar = validarEntero(teclado);

                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = teclado.nextLine();

                    System.out.print("Ingrese el nuevo email: ");
                    String nuevoEmail = teclado.nextLine();

                    clientUseCase.actualizarCliente(idActualizar, nuevoNombre, nuevoEmail);
                    System.out.println(" CLIENTE ACTUALIZADO CON ÉXITO");
                    break;

                case 4:
                    System.out.print("Ingrese el ID del cliente a eliminar: ");
                    int idEliminar = validarEntero(teclado);

                    clientUseCase.eliminarCliente(idEliminar);
                    System.out.println(" CLIENTE ELIMINADO CON ÉXITO");
                    break;

                case 0:
                    System.out.println(" Volviendo al menú principal...");
                    break;

                default:
                    System.out.println(" Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void menuProductos(Scanner teclado, ProductUseCase productUseCase) {
        int opcion;
        do {
            System.out.println("\n=================================");
            System.out.println("     GESTIÓN DE PRODUCTOS        ");
            System.out.println("=================================");
            System.out.println("1  Registrar Producto");
            System.out.println("2  Listar Productos");
            System.out.println("3  Actualizar Producto");
            System.out.println("4  Eliminar Producto");
            System.out.println("0  Volver al menú principal");
            System.out.println("=================================");
            System.out.print("Seleccione una opción: ");

            while (!teclado.hasNextInt()) {
                System.out.println(" Entrada inválida. Ingrese un número.");
                teclado.next();
            }
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del producto: ");
                    int id = validarEntero(teclado);

                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Ingrese el stock del producto: ");
                    int stock = validarEntero(teclado);

                    productUseCase.registrarproducto(id, nombre, stock);
                    System.out.println(" PRODUCTO REGISTRADO CON ÉXITO");
                    break;

                case 2:
                    List<Product> productos = productUseCase.listarProductos();
                    System.out.println("\n Lista de Productos:");
                    for (Product producto : productos) {
                        System.out.println(producto);
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el ID del producto a actualizar: ");
                    int idActualizar = validarEntero(teclado);

                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = teclado.nextLine();

                    System.out.print("Ingrese el nuevo stock: ");
                    int nuevoStock = validarEntero(teclado);

                    productUseCase.actualizarproducto(idActualizar, nuevoNombre, nuevoStock);
                    System.out.println(" PRODUCTO ACTUALIZADO CON ÉXITO");
                    break;

                case 4:
                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    int idEliminar = validarEntero(teclado);

                    productUseCase.eliminarproducto(idEliminar);
                    System.out.println(" PRODUCTO ELIMINADO CON ÉXITO");
                    break;

                case 0:
                    System.out.println(" Volviendo al menú principal...");
                    break;

                default:
                    System.out.println(" Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static int validarEntero(Scanner teclado) {
        while (!teclado.hasNextInt()) {
            System.out.println(" Entrada inválida. Ingrese un número válido.");
            teclado.next();
        }
        int numero = teclado.nextInt();
        teclado.nextLine(); // Limpiar buffer
        return numero;
    }
}
