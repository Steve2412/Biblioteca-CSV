package paquete_1_modos;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paquete_3_usuario.Usuario_Menu_Inicial;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.RandomAccessFile;
import java.awt.event.ActionEvent;

public class Logeo_usuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Registro localizacion = new Registro();
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField jpassClave;
	private JButton btnIngresar;
	Registro registrarse = new Registro();
	private JTextField textApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logeo_usuario frame = new Logeo_usuario();
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
	public Logeo_usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 168);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Insertar textos//
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(191, 24, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 101, 46, 14);
		contentPane.add(label);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(28, 39, 53, 14);
		contentPane.add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(28, 101, 75, 14);
		contentPane.add(lblContrasea);
		
		
		//Insertar TextField de datos del usuario//
		txtNombre = new JTextField();
		txtNombre.setBounds(91, 36, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		jpassClave = new JTextField();
		jpassClave.setBounds(102, 95, 75, 20);
		contentPane.add(jpassClave);
		
		
		//Insertar botones con sus acciones//
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnIngresar.setBounds(267, 35, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				registrarse.setVisible(true);
				
			}
		});
		btnRegistrar.setBounds(256, 69, 110, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModoUsuario regresar = new ModoUsuario();
				regresar.setVisible(true);
			}
		});
		btnRegresar.setBounds(256, 101, 110, 23);
		contentPane.add(btnRegresar);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(28, 69, 53, 14);
		contentPane.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(91, 67, 86, 20);
		contentPane.add(textApellido);
		
	}
	
	//Comprobar datos del Login//
	private void login() {
		if(txtNombre.getText().equals("")||textApellido.getText().equals("")||jpassClave.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Ingrese todos los datos solicitados");
		}else {
			try {
				try (RandomAccessFile raf = new RandomAccessFile(localizacion.ubicacion+txtNombre.getText()+".registro", "rw")) {
					String forNombre = raf.readLine().substring(8);
					String forApellido = raf.readLine().substring(9);
					String forContra = raf.readLine().substring(11);
					if(txtNombre.getText().equals(forNombre) & textApellido.getText().equals(forApellido) & jpassClave.getText().equals(forContra)) {
						JOptionPane.showMessageDialog(rootPane, "Has ingresado al sistema");
						dispose();
						Usuario_Menu_Inicial inicializar = new Usuario_Menu_Inicial ();
						inicializar.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(rootPane, "Usuario o Contraseña incorrectos");
					}
				}
			}
			catch (Exception e1) {
				JOptionPane.showMessageDialog(rootPane, "No se encuentra este usuario en el sistema");
				
			}
		}
			
		}
		
		
}
