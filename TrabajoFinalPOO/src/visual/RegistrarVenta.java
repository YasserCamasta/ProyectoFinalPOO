package visual;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

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
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Yasser\\Downloads\\pngfind.com-technology-icon-png-2158883.png"));
    	setResizable(false);
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
        lblCantidadComponentes.setBounds(10, 73, 193, 14);
        contentPanel.add(lblCantidadComponentes);

        JScrollPane scrollPaneCarrito = new JScrollPane();
        scrollPaneCarrito.setBounds(10, 98, 580, 200);
        contentPanel.add(scrollPaneCarrito);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("N�mero de Serie");
        tableModel.addColumn("Precio");
        tableModel.addColumn("Marca");
        tableModel.addColumn(""); // Columna adicional para el bot�n de eliminar
        tableCarrito = new JTable(tableModel);
        scrollPaneCarrito.setViewportView(tableCarrito);
        tableCarrito.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        tableCarrito.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox()));

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
            componenteSeleccionado.getMarca(),
            "Eliminar" // Bot�n para eliminar el componente
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

        // Crear el bot�n para guardar la factura
        JButton btnSave = new JButton("Guardar Factura");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarFacturaComoArchivoTxt(factura);
            }
        });

        // Panel para el bot�n de guardar factura
        JPanel btnPanel = new JPanel();
        btnPanel.add(btnSave);

        // Agregar el panel al di�logo emergente
        JScrollPane scrollPaneFactura = new JScrollPane(textAreaFactura);
        scrollPaneFactura.setColumnHeaderView(btnPanel);

        JOptionPane.showMessageDialog(this, scrollPaneFactura, "Factura", JOptionPane.PLAIN_MESSAGE);
    }

    // M�todo para guardar la factura como archivo de texto en Eclipse
    private void guardarFacturaComoArchivoTxt(Factura factura) {
        try {
            // Obtener el directorio actual del proyecto en Eclipse
            String currentDirectory = System.getProperty("user.dir");

            // Crear la ruta relativa para el directorio de facturas
            String facturaDirectory = currentDirectory + "/facturas";

            // Crear el directorio de facturas si no existe
            File directory = new File(facturaDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Crear el nombre del archivo
            String fileName = facturaDirectory + "/Factura_" + factura.getNumeroFactura() + ".txt";

            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribir la informaci�n de la factura en el archivo de texto
            bufferedWriter.write("Factura #" + factura.getNumeroFactura() + "\n");
            bufferedWriter.write("Cliente: " + factura.getCliente().getNombre() + "\n");
            bufferedWriter.write("Componentes:\n");
            factura.getComponentes().forEach(componente -> {
                try {
                    bufferedWriter.write(componente.obtenerDetalles() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bufferedWriter.write("Total: $" + calcularTotal() + "\n");

            bufferedWriter.close();

            JOptionPane.showMessageDialog(this, "Factura guardada correctamente como archivo de texto.", "Guardar Factura",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar la factura como archivo de texto: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
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

    // Clase interna para renderizar el bot�n de eliminar en la tabla
    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    // Clase interna para manejar el evento del bot�n de eliminar en la tabla
    class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                // Aqu� puedes manejar la eliminaci�n del componente del carrito
                int option = JOptionPane.showConfirmDialog(null, "�Seguro que deseas eliminar este componente del carrito?", "Confirmar eliminaci�n", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    int row = tableCarrito.getSelectedRow();
                    tableModel.removeRow(row);
                    componentesSeleccionados.remove(row);
                    double total = calcularTotal();
                    DecimalFormat df = new DecimalFormat("#.##");
                    textFieldTotal.setText("$ " + df.format(total));
                }
            }
            isPushed = false;
            return new String(label);
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}