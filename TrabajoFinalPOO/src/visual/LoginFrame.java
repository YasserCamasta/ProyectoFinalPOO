package visual;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

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
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Yasser\\Downloads\\pngfind.com-technology-icon-png-2158883.png"));
        setTitle("Inicio de Sesi�n");
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

        JLabel lblContrase�a = new JLabel("Contrase�a:");
        lblContrase�a.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblContrase�a.setBounds(54, 124, 80, 25);
        contentPane.add(lblContrase�a);

        claveAcceso = new JPasswordField();
        claveAcceso.setBounds(144, 124, 200, 25);
        contentPane.add(claveAcceso);

        JButton btnLogin = new JButton("Iniciar Sesi�n");
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
        String contrase�a = new String(claveAcceso.getPassword());
        String rolUsuario = ""; // Variable para almacenar el rol del usuario

        // Verificaci�n de credenciales
        if (usuario.equals("YasserC") && contrase�a.equals("contrase�a1")) {
            // Inicio de sesi�n exitoso para el usuario YasserC
            JOptionPane.showMessageDialog(LoginFrame.this, "�Bienvenido, Yasser Camasta!", "Inicio de Sesi�n Exitoso", JOptionPane.INFORMATION_MESSAGE);
            rolUsuario = "administrador"; // Asignar el rol del usuario
        } else if (usuario.equals("MaximoH") && contrase�a.equals("contrase�a2")) {
            // Inicio de sesi�n exitoso para el usuario MaximoH
            JOptionPane.showMessageDialog(LoginFrame.this, "�Bienvenido, Maximo Herrera!", "Inicio de Sesi�n Exitoso", JOptionPane.INFORMATION_MESSAGE);
            rolUsuario = "usuario"; // Asignar el rol del usuario
        } else {
            // Credenciales inv�lidas, mostrar mensaje de error
            JOptionPane.showMessageDialog(LoginFrame.this, "Usuario o contrase�a incorrectos", "Error de Inicio de Sesi�n", JOptionPane.ERROR_MESSAGE);
            return; // Salir del m�todo si las credenciales son inv�lidas
        }

        // Abrir el MainFrame y pasar el rol del usuario
        abrirMainFrame(rolUsuario);
    }

    private void abrirMainFrame(String rolUsuario) {
        MainFrame mainFrame = new MainFrame();

        // L�gica de manejo de roles
        if (rolUsuario.equals("administrador")) {
            mainFrame.habilitarFuncionalidadAdmin(); // Habilitar funcionalidades de administrador
        } else {
            mainFrame.deshabilitarFuncionalidadAdmin(); // Deshabilitar funcionalidades de administrador
        }

        mainFrame.setVisible(true);
        dispose(); // Cerrar el frame de inicio de sesi�n despu�s de abrir el MainFrame
    }
}