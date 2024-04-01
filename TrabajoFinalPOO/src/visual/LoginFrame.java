package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

    private JPanel contentPane;
    private JTextField textUsuario;
    private JPasswordField claveAcceso;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFrame frame = new LoginFrame();
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
    public LoginFrame() {
        setTitle("Inicio de Sesión");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsuario.setBounds(54, 72, 80, 25);
        contentPane.add(lblUsuario);

        textUsuario = new JTextField();
        textUsuario.setBounds(144, 72, 200, 25);
        contentPane.add(textUsuario);
        textUsuario.setColumns(10);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblContraseña.setBounds(54, 124, 80, 25);
        contentPane.add(lblContraseña);

        claveAcceso = new JPasswordField();
        claveAcceso.setBounds(144, 124, 200, 25);
        contentPane.add(claveAcceso);

        JButton btnLogin = new JButton("Iniciar Sesión");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });
        btnLogin.setBounds(144, 190, 120, 30);
        contentPane.add(btnLogin);
    }

    private void iniciarSesion() {
        String usuario = textUsuario.getText();
        String contraseña = new String(claveAcceso.getPassword());

        // Verificación de credenciales
        if (usuario.equals("YasserC") && contraseña.equals("contraseña1")) {
            // Inicio de sesión exitoso para el usuario YasserC
            JOptionPane.showMessageDialog(LoginFrame.this, "¡Bienvenido, Yasser Camasta!", "Inicio de Sesión Exitoso",
                    JOptionPane.INFORMATION_MESSAGE);
            abrirMainFrame();
        } else if (usuario.equals("MaximoH") && contraseña.equals("contraseña2")) {
            // Inicio de sesión exitoso para el usuario MaximoH
            JOptionPane.showMessageDialog(LoginFrame.this, "¡Bienvenido, Maximo Herrera!", "Inicio de Sesión Exitoso",
                    JOptionPane.INFORMATION_MESSAGE);
            abrirMainFrame();
        } else {
            // Credenciales inválidas, mostrar mensaje de error
            JOptionPane.showMessageDialog(LoginFrame.this, "Usuario o contraseña incorrectos",
                    "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirMainFrame() {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        dispose(); // Cerrar el frame de inicio de sesión después de abrir el MainFrame
    }
}
