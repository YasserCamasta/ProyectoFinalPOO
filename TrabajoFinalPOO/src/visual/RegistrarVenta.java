package visual;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Componente;
import logico.Factura;
import logico.Tienda;

public class RegistrarVenta extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JComboBox<String> comboBoxClientes;
    private JComboBox<Componente> comboBoxComponentes;
    private ArrayList<Componente> componentesSeleccionados;
    private JTable tableCarrito;
    private DefaultTableModel tableModel;
    private JTextField textFieldTotal;
    private JLabel lblCantidadComponentes;
    private JButton btnA�adirAlCarrito;
    private JButton btnRegistrarVenta;
    private JButton btnVolverMenuPrincipal;
    private JButton btnRegistrarCliente;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            RegistrarVenta dialog = new RegistrarVenta();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public RegistrarVenta() {
        setTitle("Registrar Venta");
        setBounds(100, 100, 708, 468);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setBounds(10, 11, 70, 14);
        contentPanel.add(lblCliente);

        comboBoxClientes = new JComboBox<>();
        comboBoxClientes.setBounds(127, 8, 200, 20);
        cargarClientes();
        contentPanel.add(comboBoxClientes);

        JLabel lblComponente = new JLabel("Componente:");
        lblComponente.setBounds(10, 42, 96, 14);
        contentPanel.add(lblComponente);

        comboBoxComponentes = new JComboBox<>();
        comboBoxComponentes.setBounds(127, 39, 193, 20);
        cargarComponentes();
        contentPanel.add(comboBoxComponentes);

        btnA�adirAlCarrito = new JButton("A�adir al Carrito");
        btnA�adirAlCarrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a�adirAlCarrito();
            }
        });
        btnA�adirAlCarrito.setBounds(340, 38, 250, 23);
        contentPanel.add(btnA�adirAlCarrito);

        lblCantidadComponentes = new JLabel("Cantidad de Componentes:");
        lblCantidadComponentes.setBounds(10, 73, 150, 14);
        contentPanel.add(lblCantidadComponentes);

        JScrollPane scrollPaneCarrito = new JScrollPane();
        scrollPaneCarrito.setBounds(10, 98, 580, 200);
        contentPanel.add(scrollPaneCarrito);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("N�mero de Serie");
        tableModel.addColumn("Precio");
        tableModel.addColumn("Marca");
        tableCarrito = new JTable(tableModel);
        scrollPaneCarrito.setViewportView(tableCarrito);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setBounds(429, 311, 46, 14);
        contentPanel.add(lblTotal);

        textFieldTotal = new JTextField();
        textFieldTotal.setEditable(false);
        textFieldTotal.setBounds(485, 308, 105, 20);
        contentPanel.add(textFieldTotal);
        textFieldTotal.setColumns(10);

        btnRegistrarVenta = new JButton("Registrar Venta");
        btnRegistrarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarVenta();
            }
        });
        btnRegistrarVenta.setBounds(451, 339, 141, 23);
        contentPanel.add(btnRegistrarVenta);

        btnVolverMenuPrincipal = new JButton("Volver al Men� Principal");
        btnVolverMenuPrincipal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                volverMenuPrincipal();
            }
        });
        btnVolverMenuPrincipal.setBounds(10, 339, 180, 23);
        contentPanel.add(btnVolverMenuPrincipal);

        btnRegistrarCliente = new JButton("Registrar Cliente");
        btnRegistrarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarCliente();
            }
        });
        btnRegistrarCliente.setBounds(200, 339, 180, 23);
        contentPanel.add(btnRegistrarCliente);

        // Inicializar la lista de componentes seleccionados
        componentesSeleccionados = new ArrayList<>();
    }

    // M�todo para cargar los clientes en el comboBox
    private void cargarClientes() {
        comboBoxClientes.removeAllItems();
        for (Cliente cliente : Tienda.getInstance().getClientes()) {
            comboBoxClientes.addItem(cliente.getNombre());
        }
    }

    // M�todo para cargar los componentes en el comboBox
    private void cargarComponentes() {
        comboBoxComponentes.removeAllItems();
        for (Componente componente : Tienda.getInstance().getInventario()) {
            comboBoxComponentes.addItem(componente);
        }
    }

    // M�todo para a�adir un componente al carrito
    private void a�adirAlCarrito() {
        Componente componenteSeleccionado = (Componente) comboBoxComponentes.getSelectedItem();
        componentesSeleccionados.add(componenteSeleccionado);

        Object[] rowData = {
            componenteSeleccionado.getNumeroSerie(),
            componenteSeleccionado.getPrecio(),
            componenteSeleccionado.getMarca()
        };
        tableModel.addRow(rowData);

        // Calcular y mostrar el total
        double total = calcularTotal();
        DecimalFormat df = new DecimalFormat("#.##");
        textFieldTotal.setText("$ " + df.format(total));

        // Aplicar descuento del 10% si se seleccionan al menos 3 componentes
        if (componentesSeleccionados.size() >= 3) {
            double descuento = total * 0.10;
            total -= descuento;
            textFieldTotal.setText("$ " + df.format(total) + " (-10%)");
        }

        // Deshabilitar el bot�n si ya se seleccionaron 6 componentes
        if (componentesSeleccionados.size() >= 6) {
            btnA�adirAlCarrito.setEnabled(false);
        }
    }

    // M�todo para calcular el total de la venta
    private double calcularTotal() {
        double total = 0;
        for (Componente componente : componentesSeleccionados) {
            total += componente.getPrecio();
        }
        return total;
    }

    // M�todo para registrar la venta
    private void registrarVenta() {
        Cliente clienteSeleccionado = Tienda.getInstance().buscarClientePorNombre((String) comboBoxClientes.getSelectedItem());
        if (clienteSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (componentesSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un componente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "�Est� seguro de registrar la venta?", "Confirmar Venta", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            Factura factura = new Factura(clienteSeleccionado, componentesSeleccionados);
            Tienda.getInstance().agregarFactura(factura);

            // Mostrar la factura en un di�logo emergente
            mostrarFactura(factura);
        }
    }

    // M�todo para mostrar la factura en un di�logo emergente
    private void mostrarFactura(Factura factura) {
        JTextArea textAreaFactura = new JTextArea();
        textAreaFactura.setEditable(false);
        textAreaFactura.append("FACTURA\n\n");
        textAreaFactura.append("Cliente: " + factura.getCliente().getNombre() + "\n");
        textAreaFactura.append("N�mero de Factura: " + factura.getNumeroFactura() + "\n\n");
        textAreaFactura.append("Componentes:\n");
        for (Componente componente : factura.getComponentes()) {
            textAreaFactura.append("- " + componente.toString() + "\n");
        }
        textAreaFactura.append("\nTotal: $ " + textFieldTotal.getText() + "\n");
        textAreaFactura.setBounds(10, 10, 400, 300);

        JScrollPane scrollPaneFactura = new JScrollPane(textAreaFactura);

        JOptionPane.showMessageDialog(this, scrollPaneFactura, "Factura", JOptionPane.PLAIN_MESSAGE);
    }

    // M�todo para volver al men� principal
    private void volverMenuPrincipal() {
        dispose(); // Cierra la ventana actual
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }

    // M�todo para abrir el formulario de registro de cliente
    private void registrarCliente() {
        
        RegistrarCliente registrarCliente = new RegistrarCliente();
        registrarCliente.setVisible(true);
    }
}