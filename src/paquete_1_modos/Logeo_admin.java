package paquete_1_modos;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paquete_2_admin.Admin_Menu_Inicial;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Logeo_admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField jpassClave;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logeo_admin frame = new Logeo_admin();
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
	
	//Insertar elementos//
	public Logeo_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 168);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Insertar Texto//
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(191, 24, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 101, 46, 14);
		contentPane.add(label);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(28, 54, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(28, 101, 75, 14);
		contentPane.add(lblContrasea);
		
		
		//Insertar TextField de Datos del admin//
		txtUsuario = new JTextField();
		txtUsuario.setBounds(84, 51, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		jpassClave = new JPasswordField();
		jpassClave.setBounds(102, 95, 75, 20);
		contentPane.add(jpassClave);
		
		
		//Insertar botones con sus acciones//
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				char[] clave = jpassClave.getPassword();
				String claveFinal = new String (clave);
				
				if(txtUsuario.getText().equals("admin") && claveFinal.equals("admin")){
					
					dispose();
					JOptionPane.showMessageDialog(null,"Bienvenido al sistema","Ingresaste",
							JOptionPane.INFORMATION_MESSAGE);
				Admin_Menu_Inicial inicializar = new Admin_Menu_Inicial ();
				inicializar.setVisible(true);

				}else {
					
				JOptionPane.showMessageDialog(null, "Usuario o Contraseña inocrrectos","Error" ,
						JOptionPane.ERROR_MESSAGE);
				
				
				}
			}
		});
		btnIngresar.setBounds(276, 50, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModoUsuario regresar = new ModoUsuario();
				regresar.setVisible(true);
			}
		});
		btnRegresar.setBounds(276, 92, 89, 23);
		contentPane.add(btnRegresar);
	}
}
