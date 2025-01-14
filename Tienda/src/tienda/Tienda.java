package tienda;
import java.util.Scanner;
/**
 *
 * @author Chengxuan
 */
public class Tienda {

    /**
     * Función principal que ejecuta el programa.
     * Muestra el menú y permite al usuario seleccionar un producto, 
     * ingresar la cantidad y mostrar el precio final con y sin IVA.
     * 
     * @param args Argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        Tienda hoja = new Tienda();
        int opcion;
        
        // El menú sigue ejecutándose hasta que el usuario elija la opción de salir
        do{        
            opcion = hoja.mostrarMenu();      
            switch (opcion) {
                case 1:
                    procesarCompra("Camiseta", 20.0);
                    break;
                case 2:
                    procesarCompra("Pantalón", 30.0);
                    break;
                case 3:
                    procesarCompra("Zapatos", 50.0);
                    break;
                case 4:
                    procesarCompra("Sombrero", 15.0);
                    break;
                case 5:
                    procesarCompra("Gafas de sol", 25.0);
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }while (opcion!=0); 
    }

    /**
     * Muestra el menú de productos disponibles en la tienda.
     * El usuario puede elegir uno de los productos listados.
     */
    public int mostrarMenu() {
        Scanner teclado = new Scanner(System.in);
        int op;
        System.out.println("\n---- Menú de productos ----");
        System.out.println("1. Camiseta - $20.00");
        System.out.println("2. Pantalón - $30.00");
        System.out.println("3. Zapatos - $50.00");
        System.out.println("4. Sombrero - $15.00");
        System.out.println("5. Gafas de sol - $25.00");
        System.out.println("0. Salir");
        System.out.print("Elige un producto (1-5): ");
        System.out.print("Introduzca una opcion: ");
        op = teclado.nextInt();
        return op;
    }

    /**
     * Procesa la compra de un producto seleccionado por el usuario.
     * Permite al usuario ingresar la cantidad del producto y muestra los precios
     * con y sin IVA.
     * 
     * @param producto El nombre del producto seleccionado.
     * @param precioUnitario El precio unitario del producto seleccionado.
     */
    public static void procesarCompra(String producto, double precioUnitario) {
        Scanner scanner = new Scanner(System.in);

        // Solicita la cantidad del producto que desea comprar
        System.out.print("¿Cuántos " + producto + " quieres comprar? ");
        int cantidad = scanner.nextInt();

        // Crear una instancia de la clase Calculadora
        CalculadoraTienda calculadora = new CalculadoraTienda();

        // Calcula el precio final y el precio con IVA
        double precioFinal = calculadora.calcularPrecioFinal(precioUnitario, cantidad);
        double precioConIVA = calculadora.calcularPrecioConIVA(precioFinal);

        // Muestra los detalles de la compra
        System.out.println("\n---- Detalles de la compra ----");
        System.out.println("Producto: " + producto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio sin IVA: $" + precioFinal);
        System.out.println("Precio con IVA (21%): $" + precioConIVA);
    }
}
