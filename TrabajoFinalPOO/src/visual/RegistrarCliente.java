package visual;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logico.Cliente;
import logico.Tienda;

public class RegistrarCliente extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldNombre;
    private JTextField textFieldDireccion;
    private JFormattedTextField formattedTextFieldTelefono; // Cambiado a JFormattedTextField

    /**
     * Create the dialog.
     */
    public RegistrarCliente() {
        setTitle("Registro de Cliente");
        setBounds(100, 100, 450, 250);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nombre:");
        lblNewLabel.setBounds(20, 20, 100, 20);
        contentPanel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Direcci�n:");
        lblNewLabel_1.setBounds(20, 60, 100, 20);
        contentPanel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Tel�fono:");
        lblNewLabel_2.setBounds(20, 100, 100, 20);
        contentPanel.add(lblNewLabel_2);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(130, 20, 250, 26);
        contentPanel.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        textFieldDireccion = new JTextField();
        textFieldDireccion.setBounds(130, 60, 250, 26);
        contentPanel.add(textFieldDireccion);
        textFieldDireccion.setColumns(10);

        try {
            // Utilizar una m�scara para el campo de tel�fono
            MaskFormatter formatter = new MaskFormatter("###-###-####");
            formattedTextFieldTelefono = new JFormattedTextField(formatter);
            formattedTextFieldTelefono.setBounds(130, 100, 250, 26);
            contentPanel.add(formattedTextFieldTelefono);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Guardar");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos ingresados por el usuario
                String nombre = textFieldNombre.getText().trim();
                String direccion = textFieldDireccion.getText().trim();
                String telefono = formattedTextFieldTelefono.getText().trim(); // Cambiado a formattedTextFieldTelefono

                // Validar que los campos no est�n vac�os
                if (nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(RegistrarCliente.this,
                            "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verificar si el tel�fono tiene la longitud correcta
                if (telefono.replaceAll("-", "").length() != 10) {
                    JOptionPane.showMessageDialog(RegistrarCliente.this,
                            "Por favor, ingrese un n�mero de tel�fono v�lido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Crear un nuevo objeto Cliente
                Cliente nuevoCliente = new Cliente(nombre, direccion, telefono);

                // Agregar el nuevo cliente al sistema de la tienda
                Tienda.getInstance().agregarCliente(nuevoCliente);

                // Mostrar mensaje de confirmaci�n
                JOptionPane.showMessageDialog(RegistrarCliente.this, "Cliente registrado exitosamente", "�xito",
                        JOptionPane.INFORMATION_MESSAGE);

                // Cerrar el di�logo
                dispose();
            }
        });
        okButton.setActionCommand("Guardar");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar el di�logo sin guardar ning�n cliente
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancelar");
        buttonPane.add(cancelButton);
    }
}
