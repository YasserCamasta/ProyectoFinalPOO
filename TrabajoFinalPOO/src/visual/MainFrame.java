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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import logico.Cliente;
import logico.Componente;
import logico.Factura;
import logico.Tienda;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private JList<String> listado;
    private DefaultListModel<String> listModel;

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
        setTitle("Menú Principal");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

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
                abrirDialogoRegistrarCliente();
            }
        });
        mnRegistrar.add(mntmRegistrarCliente);

        JMenuItem mntmRegistrarVenta = new JMenuItem("Venta");
        mntmRegistrarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implementar...
            }
        });
        mnRegistrar.add(mntmRegistrarVenta);

        JMenuItem mntmRegistrarComponente = new JMenuItem("Componente");
        mntmRegistrarComponente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirDialogoRegistrarComponente();
            }
        });
        mnRegistrar.add(mntmRegistrarComponente);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);

        listModel = new DefaultListModel<>();
        listado = new JList<>(listModel);
        listado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listado.setLayoutOrientation(JList.VERTICAL);
        scrollPane.setViewportView(listado);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarRegistro();
            }
        });
        panel.add(btnEliminar, BorderLayout.SOUTH);

        JPanel panelBotones = new JPanel();
        contentPane.add(panelBotones, BorderLayout.SOUTH);

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

    private void mostrarListadoComponentes() {
        listModel.clear(); // Limpiamos el modelo de la lista

        // Obtenemos la lista de componentes del inventario de la tienda
        ArrayList<Componente> componentes = Tienda.getInstance().getInventario();

        // Iteramos sobre la lista de componentes y los agregamos al modelo de la lista
        for (Componente componente : componentes) {
            listModel.addElement(componente.obtenerDetalles());
        }
    }
    private void mostrarListadoClientes() {
        listModel.clear(); // Limpiamos el modelo de la lista

        // Obtenemos la lista de clientes de la tienda
        ArrayList<Cliente> clientes = Tienda.getInstance().getClientes();

        // Iteramos sobre la lista de clientes y agregamos sus nombres al modelo de la lista
        for (Cliente cliente : clientes) {
            listModel.addElement(cliente.getNombre());
        }
    }

    private void mostrarListadoFacturas() {
        listModel.clear(); // Limpiamos el modelo de la lista

        // Obtenemos la lista de facturas de la tienda
        ArrayList<Factura> facturas = Tienda.getInstance().getFacturas();

        // Iteramos sobre la lista de facturas y agregamos los números de factura al modelo de la lista
        for (Factura factura : facturas) {
            listModel.addElement(String.valueOf(factura.getNumeroFactura()));
        }
    }

    private void abrirDialogoRegistrarCliente() {
        // Mensaje de confirmación
        JOptionPane.showMessageDialog(this, "Abriendo menú para registrar cliente", "Registrar Cliente",
                JOptionPane.INFORMATION_MESSAGE);
        
        // Abrir el diálogo modal para registrar un cliente
        RegistrarCliente dialogoRegistrarCliente = new RegistrarCliente();
        dialogoRegistrarCliente.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialogoRegistrarCliente.setVisible(true);
    }

    private void abrirDialogoRegistrarComponente() {
        // Mensaje de confirmación
        JOptionPane.showMessageDialog(this, "Abriendo menú para registrar componente", "Registrar Componente",
                JOptionPane.INFORMATION_MESSAGE);
        
        // Abrir el diálogo modal para registrar un componente
        RegistrarComponente dialogoRegistrarComponente = new RegistrarComponente();
        dialogoRegistrarComponente.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialogoRegistrarComponente.setVisible(true);
    }

    private void eliminarRegistro() {
        int indiceSeleccionado = listado.getSelectedIndex();
        if (indiceSeleccionado != -1) {
            listModel.removeElementAt(indiceSeleccionado);
            JOptionPane.showMessageDialog(this, "Registro eliminado correctamente", "Eliminar Registro",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro para eliminar", "Eliminar Registro",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void salir() {
        System.exit(0);
    }

    private void resetearListado() {
        listModel.clear();
    }
}