
package visual;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegistrarComponente extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldNumeroSerie;
    private JTextField textFieldMarca;
    private JTextField textFieldModelo;
    private JTextField textFieldCapacidadGB;
    private JTextField textFieldTipoConexion;
    private JTextField textFieldTipoSocket;
    private JTextField textFieldVelocidadProcesamiento;
    private JTextField textFieldTipoMemoriaRAM;
    private JComboBox<String> comboBoxTipoComponente;

    /**
     * Create the dialog.
     */
    public RegistrarComponente() {
        setBounds(100, 100, 450, 400);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Número de Serie:");
        lblNewLabel.setBounds(20, 20, 150, 20);
        contentPanel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Marca:");
        lblNewLabel_1.setBounds(20, 60, 100, 20);
        contentPanel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Modelo:");
        lblNewLabel_2.setBounds(20, 100, 100, 20);
        contentPanel.add(lblNewLabel_2);

        JLabel lblTipoComponente = new JLabel("Tipo de Componente:");
        lblTipoComponente.setBounds(20, 140, 150, 20);
        contentPanel.add(lblTipoComponente);

        textFieldNumeroSerie = new JTextField();
        textFieldNumeroSerie.setBounds(180, 20, 220, 26);
        contentPanel.add(textFieldNumeroSerie);
        textFieldNumeroSerie.setColumns(10);

        textFieldMarca = new JTextField();
        textFieldMarca.setBounds(180, 60, 220, 26);
        contentPanel.add(textFieldMarca);
        textFieldMarca.setColumns(10);

        textFieldModelo = new JTextField();
        textFieldModelo.setBounds(180, 100, 220, 26);
        contentPanel.add(textFieldModelo);
        textFieldModelo.setColumns(10);

        comboBoxTipoComponente = new JComboBox<>();
        comboBoxTipoComponente.addItem("Disco Duro");
        comboBoxTipoComponente.addItem("Microprocesador");
        comboBoxTipoComponente.addItem("Memoria RAM");
        comboBoxTipoComponente.addItem("Tarjeta Madre (Motherboard)");
        comboBoxTipoComponente.setBounds(180, 140, 220, 26);
        contentPanel.add(comboBoxTipoComponente);

        JLabel lblNewLabel_3 = new JLabel("Capacidad (GB):");
        lblNewLabel_3.setBounds(20, 180, 150, 20);
        contentPanel.add(lblNewLabel_3);

        textFieldCapacidadGB = new JTextField();
        textFieldCapacidadGB.setBounds(180, 180, 220, 26);
        contentPanel.add(textFieldCapacidadGB);
        textFieldCapacidadGB.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Tipo de Conexión:");
        lblNewLabel_4.setBounds(20, 220, 150, 20);
        contentPanel.add(lblNewLabel_4);

        textFieldTipoConexion = new JTextField();
        textFieldTipoConexion.setBounds(180, 220, 220, 26);
        contentPanel.add(textFieldTipoConexion);
        textFieldTipoConexion.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Tipo de Socket:");
        lblNewLabel_5.setBounds(20, 260, 150, 20);
        contentPanel.add(lblNewLabel_5);

        textFieldTipoSocket = new JTextField();
        textFieldTipoSocket.setBounds(180, 260, 220, 26);
        contentPanel.add(textFieldTipoSocket);
        textFieldTipoSocket.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Velocidad de Procesamiento (GHz):");
        lblNewLabel_6.setBounds(20, 300, 300, 20);
        contentPanel.add(lblNewLabel_6);

        textFieldVelocidadProcesamiento = new JTextField();
        textFieldVelocidadProcesamiento.setBounds(330, 300, 70, 26);
        contentPanel.add(textFieldVelocidadProcesamiento);
        textFieldVelocidadProcesamiento.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("Tipo de Memoria RAM:");
        lblNewLabel_7.setBounds(20, 340, 200, 20);
        contentPanel.add(lblNewLabel_7);

        textFieldTipoMemoriaRAM = new JTextField();
        textFieldTipoMemoriaRAM.setBounds(210, 340, 190, 26);
        contentPanel.add(textFieldTipoMemoriaRAM);
        textFieldTipoMemoriaRAM.setColumns(10);

        // Ocultar campos no relevantes inicialmente
        textFieldCapacidadGB.setVisible(false);
        textFieldTipoConexion.setVisible(false);
        textFieldTipoSocket.setVisible(false);
        textFieldVelocidadProcesamiento.setVisible(false);
        textFieldTipoMemoriaRAM.setVisible(false);

        // Listener para el JComboBox
        comboBoxTipoComponente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedType = comboBoxTipoComponente.getSelectedItem().toString();

                // Mostrar u ocultar campos según el tipo de componente seleccionado
                switch (selectedType) {
                    case "Disco Duro":
                        textFieldCapacidadGB.setVisible(true);
                        textFieldTipoConexion.setVisible(true);
                        textFieldTipoSocket.setVisible(false);
                        textFieldVelocidadProcesamiento.setVisible(false);
                        textFieldTipoMemoriaRAM.setVisible(false);
                        break;
                    case "Microprocesador":
                        textFieldCapacidadGB.setVisible(false);
                        textFieldTipoConexion.setVisible(false);
                        textFieldTipoSocket.setVisible(true);
                        textFieldVelocidadProcesamiento.setVisible(true);
                        textFieldTipoMemoriaRAM.setVisible(false);
                        break;
                    case "Memoria RAM":
                        textFieldCapacidadGB.setVisible(true);
                        textFieldTipoConexion.setVisible(false);
                        textFieldTipoSocket.setVisible(false);
                        textFieldVelocidadProcesamiento.setVisible(false);
                        textFieldTipoMemoriaRAM.setVisible(true);
                        break;
                    case "Tarjeta Madre (Motherboard)":
                        textFieldCapacidadGB.setVisible(false);
                        textFieldTipoConexion.setVisible(false);
                        textFieldTipoSocket.setVisible(true); // Especifique el tipo de Socket para la Motherboard
                        textFieldVelocidadProcesamiento.setVisible(false);
                        textFieldTipoMemoriaRAM.setVisible(true); // Especifique el tipo de Memoria RAM para la Motherboard
                        break;
                    default:
                        break;
                }
            }
        });

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Guardar");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos ingresados por el usuario
                String numeroSerie = textFieldNumeroSerie.getText().trim();
                String marca = textFieldMarca.getText().trim();
                String modelo = textFieldModelo.getText().trim();
                String tipoComponente = comboBoxTipoComponente.getSelectedItem().toString();

                // Validar que los campos no estén vacíos
                if (numeroSerie.isEmpty() || marca.isEmpty() || modelo.isEmpty()) {
                    JOptionPane.showMessageDialog(RegistrarComponente.this,
                            "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Crear un nuevo objeto Componente según el tipo seleccionado
                Componente nuevoComponente = null;

                switch (tipoComponente) {
                    case "Disco Duro":
                        double capacidadDisco = Double.parseDouble(textFieldCapacidadGB.getText().trim());
                        String tipoConexion = textFieldTipoConexion.getText().trim();
                        nuevoComponente = new Disco(numeroSerie, marca, modelo, capacidadDisco, tipoConexion);
                        break;
                    case "Microprocesador":
                        String tipoSocket = textFieldTipoSocket.getText().trim();
                        double velocidadProcesamiento = Double.parseDouble(textFieldVelocidadProcesamiento.getText().trim());
                        nuevoComponente = new Micro(numeroSerie, marca, modelo, tipoSocket, velocidadProcesamiento);
                        break;
                    case "Memoria RAM":
                        int capacidadRAM = Integer.parseInt(textFieldCapacidadGB.getText().trim());
                        String tipoRAM = textFieldTipoMemoriaRAM.getText().trim();
                        nuevoComponente = new Ram(numeroSerie, marca, capacidadRAM, tipoRAM);
                        break;
                    case "Tarjeta Madre (Motherboard)":
                        String socket = textFieldTipoSocket.getText().trim();
                        String tipoMemoriaRAM = textFieldTipoMemoriaRAM.getText().trim();
                        // se necesita lógica para obtener las conexiones de discos aceptadas
                        ArrayList<String> conexionesDiscos = new ArrayList<>();
                        // se necesitan agregat las conexiones de discos aceptadas a la lista conexionesDiscos
                        nuevoComponente = new Motherboard(numeroSerie, marca, modelo, socket, tipoMemoriaRAM, conexionesDiscos);
                        break;
                    default:
                        break;
                }

                // Agregar el nuevo componente al sistema de la tienda
                Tienda.getInstance().agregarComponente(nuevoComponente);

                // Mostrar mensaje de confirmación
                JOptionPane.showMessageDialog(RegistrarComponente.this, "Componente registrado exitosamente", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);

                // Cerrar el diálogo
                dispose();
            }
        });
        okButton.setActionCommand("Guardar");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar el diálogo sin guardar ningún componente
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancelar");
        buttonPane.add(cancelButton);
    }
}
