package logico;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Crear algunos clientes
        Cliente cliente1 = new Cliente("123456789", "Juan Pérez", "Calle 123");
        Cliente cliente2 = new Cliente("987654321", "María González", "Avenida 456");

        // Crear algunos componentes
        Componente micro1 = new Micro("MS123", "Intel", "i7", "Socket123", 3.2);
        Componente ram1 = new Ram("RAM123", "Kingston", 8, "DDR4");
        Componente disco1 = new Disco("DISCO123", "Seagate", "ModeloX", 1000, "SATA");

        // Agregar los componentes al inventario de la tienda
        Tienda.getInstance().agregarComponente(micro1);
        Tienda.getInstance().agregarComponente(ram1);
        Tienda.getInstance().agregarComponente(disco1);

        // Crear una factura para el cliente1
        Factura factura1 = new Factura(cliente1);
        factura1.agregarComponente(micro1);
        factura1.agregarComponente(ram1);
        factura1.agregarComponente(disco1);

        // Mostrar la información de la factura
        System.out.println("Factura #" + factura1.getNumeroFactura());
        System.out.println("Cliente: " + factura1.getCliente().getNombre());
        System.out.println("Componentes:");
        for (Componente componente : factura1.getComponentes()) {
            System.out.println(componente.obtenerDetalles());
        }
        System.out.println("Total: $" + factura1.calcularTotal());
        System.out.println("Total con descuento: $" + factura1.calcularTotalConDescuento());
    }
}