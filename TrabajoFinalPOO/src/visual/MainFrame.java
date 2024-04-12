package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logico.Cliente;
import logico.Componente;
import logico.Factura;
import logico.Tienda;
import logico.Motherboard;
import logico.Disco;
import logico.Micro;
import logico.Ram;
import java.awt.Toolkit;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnEliminar;
    private Object[] rowData;
    private int selectedRowIndex = -1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainFrame() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Yasser\\Downloads\\pngfind.com-technology-icon-png-2158883.png"));
        setTitle("Menú Principal");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 400);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnListar = new JMenu("Listar");
        menuBar.add(mnListar);

        JMenuItem mntmListarComponentes = new JMenuItem("Componentes");
        mntmListarComponentes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarListadoComponentes();
            }
        });
        mnListar.add(mntmListarComponentes);

        JMenuItem mntmListarClientes = new JMenuItem("Clientes");
        mntmListarClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarListadoClientes();
            }
        });
        mnListar.add(mntmListarClientes);

        JMenuItem mntmListarFacturas = new JMenuItem("Facturas");
        mntmListarFacturas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarListadoFacturas();
            }
        });
        mnListar.add(mntmListarFacturas);

        JMenu mnRegistrar = new JMenu("Registrar");
        menuBar.add(mnRegistrar);

        JMenuItem mntmRegistrarCliente = new JMenuItem("Cliente");
        mntmRegistrarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormulario(new RegistrarCliente());
            }
        });
        mnRegistrar.add(mntmRegistrarCliente);

        JMenuItem mntmRegistrarComponente = new JMenuItem("Componente");
        mntmRegistrarComponente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormulario(new RegistrarComponente());
            }
        });
        mnRegistrar.add(mntmRegistrarComponente);

        JMenuItem mntmRegistrarVenta = new JMenuItem("Venta");
        mntmRegistrarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormulario(new RegistrarVenta());
            }
        });
        mnRegistrar.add(mntmRegistrarVenta);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(table);

        JPanel panelBotones = new JPanel();
        contentPane.add(panelBotones, BorderLayout.SOUTH);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedRowIndex != -1) {
                    eliminarRegistro();
                }
            }
        });
        panelBotones.add(btnEliminar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        });
        panelBotones.add(btnSalir);

        JButton btnResetearListado = new JButton("Resetear Listado");
        btnResetearListado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetearListado();
            }
        });
        panelBotones.add(btnResetearListado);
    }

    private void abrirFormulario(JDialog frame) {
        frame.setVisible(true);
    }
    // Método para habilitar funcionalidades de administrador
    public void habilitarFuncionalidadAdmin() {
        btnEliminar.setEnabled(true); // Habilitar el botón de eliminar
    }

    // Método para deshabilitar funcionalidades de administrador
    public void deshabilitarFuncionalidadAdmin() {
        btnEliminar.setEnabled(false); // Deshabilitar el botón de eliminar
    }

    private void mostrarListadoComponentes() {
        tableModel.setColumnCount(0); // Limpiamos las columnas
        tableModel.setRowCount(0); // Limpiamos las filas

        // Definimos las columnas de la tabla para los componentes
        tableModel.addColumn("Número de Serie");
        tableModel.addColumn("Precio");
        tableModel.addColumn("Cantidad Disponible");
        tableModel.addColumn("Marca");

        // oobtenemos la lista de componentes del inventario de la tienda
        ArrayList<Componente> componentes = Tienda.getInstance().getInventario();

        // agregamos los datos a la tabla
        for (Componente componente : componentes) {
            if (componente instanceof Disco) {
                rowData = new Object[]{
                        componente.getNumeroSerie(),
                        componente.getPrecio(),
                        componente.getCantidadDisponible(),
                        componente.getMarca(),
                        ((Disco) componente).getModelo(),
                        ((Disco) componente).getCapacidadGB(),
                        ((Disco) componente).getTipoConexion()
                };
            } else if (componente instanceof Micro) {
                rowData = new Object[]{
                        componente.getNumeroSerie(),
                        componente.getPrecio(),
                        componente.getCantidadDisponible(),
                        componente.getMarca(),
                        ((Micro) componente).getModelo(),
                        ((Micro) componente).getTipoSocket(),
                        ((Micro) componente).getVelocidadProcesamiento()
                };
            } else if (componente instanceof Motherboard) {
                rowData = new Object[]{
                        componente.getNumeroSerie(),
                        componente.getPrecio(),
                        componente.getCantidadDisponible(),
                        componente.getMarca(),
                        ((Motherboard) componente).getModelo(),
                        ((Motherboard) componente).getSocket(),
                        ((Motherboard) componente).getTipoMemoriaRAM(),
                        ((Motherboard) componente).getConexionesDiscos()
                };
            } else if (componente instanceof Ram) {
                rowData = new Object[]{
                        componente.getNumeroSerie(),
                        componente.getPrecio(),
                        componente.getCantidadDisponible(),
                        componente.getMarca(),
                        ((Ram) componente).getCapacidadGB(),
                        ((Ram) componente).getTipo()
                };
            }
            tableModel.addRow(rowData);
        }

        // Desactivamos los botones de eliminar
        btnEliminar.setEnabled(false);
    }

    private void mostrarListadoClientes() {
        tableModel.setColumnCount(0); // Limpiamos las columnas
        tableModel.setRowCount(0); // Limpiamos las filas

        // Definimos las columnas de la tabla para los clientes
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Dirección");
        tableModel.addColumn("Teléfono");

        // Obtenemos la lista de clientes de la tienda
        ArrayList<Cliente> clientes = Tienda.getInstance().getClientes();

        // Iteramos sobre la lista de clientes y agregamos los datos a la tabla
        for (Cliente cliente : clientes) {
            rowData = new Object[]{
                    cliente.getNombre(),
                    cliente.getDireccion(),
                    cliente.getTelefono()
            };
            tableModel.addRow(rowData);
        }

        // Desactivamos los botones de eliminar
        btnEliminar.setEnabled(false);
    }

    private void mostrarListadoFacturas() {
        tableModel.setColumnCount(0); // Limpiamos las columnas
        tableModel.setRowCount(0); // Limpiamos las filas

        // Definimos las columnas de la tabla para las facturas
        tableModel.addColumn("Número de Factura");
        tableModel.addColumn("Cliente");
        tableModel.addColumn("Total");
        tableModel.addColumn("Componentes");

        // Obtenemos la lista de facturas de la tienda
        ArrayList<Factura> facturas = Tienda.getInstance().getFacturas();

        // Iteramos sobre la lista de facturas y agregamos los datos a la tabla
        for (Factura factura : facturas) {
            rowData = new Object[]{
                    factura.getNumeroFactura(),
                    factura.getCliente().getNombre(),
                    factura.calcularTotalConDescuento(),
                    factura.getComponentes()
            };
            tableModel.addRow(rowData);
        }

        // Desactivamos los botones de eliminar
        btnEliminar.setEnabled(false);
    }

    private void eliminarRegistro() {
        if (selectedRowIndex != -1) {
            // Mensaje de advertencia
            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar este registro?", "Eliminar Registro", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                
                JOptionPane.showMessageDialog(this, "¡Registro eliminado correctamente!", "Eliminar Registro", JOptionPane.INFORMATION_MESSAGE);
                tableModel.removeRow(selectedRowIndex);
                selectedRowIndex = -1;
                btnEliminar.setEnabled(false);
            }
        }
    }

    private void salir() {
        System.exit(0);
    }

    private void resetearListado() {
        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);
        selectedRowIndex = -1;
        btnEliminar.setEnabled(false);
    }
}