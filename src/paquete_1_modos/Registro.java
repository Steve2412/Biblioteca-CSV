package paquete_1_modos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Formatter;

public class Registro extends JFrame {

	/**
	 * 
	 */
	String barra = File.separator;
	public String ubicacion = System.getProperty("user.dir")+barra+"Usuarios"+barra;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField jpassClave;
	private JButton btnIngresar;
	private JTextField txtCorreo;
	private JTextField txtCedula;
	private JTextField TelefonotextField;
	private JTextField textApellido;

	
	//Iniciar elementos//
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 279);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Insertar texto//
		JLabel lblLogin = new JLabel("REGISTRO DE USUARIO");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(151, 24, 136, 14);
		contentPane.add(lblLogin);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 101, 46, 14);
		contentPane.add(label);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(18, 54, 56, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(19, 84, 57, 14);
		contentPane.add(lblApellido);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(20, 110, 75, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCorreo.setBounds(38, 141, 57, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCedula.setBounds(38, 177, 46, 14);
		contentPane.add(lblCedula);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefono.setBounds(28, 212, 56, 14);
		contentPane.add(lblTelefono);
		
		//Insertar TextField con los datos del usuario para registrarlo//
		txtNombre = new JTextField();
		txtNombre.setBounds(84, 51, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(84, 80, 86, 20);
		contentPane.add(textApellido);
		
		jpassClave = new JTextField();
		jpassClave.setBounds(113, 107, 75, 20);
		contentPane.add(jpassClave);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(102, 138, 86, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))) {
					e.consume();
				}
			}
		});
		txtCedula.setBounds(91, 174, 86, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		TelefonotextField = new JTextField();
		TelefonotextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))) {
					e.consume();
				}
			}
		});
		TelefonotextField.setColumns(10);
		TelefonotextField.setBounds(91, 209, 86, 20);
		contentPane.add(TelefonotextField);
		
		
		//Insertar Botones con sus acciones//
		btnIngresar = new JButton("Registrarse");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUsuarios();
			}
		});
		btnIngresar.setBounds(255, 66, 109, 23);
		contentPane.add(btnIngresar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Logeo_usuario usuario = new Logeo_usuario();
				usuario.setVisible(true);
				
			}
		});
		btnRegresar.setBounds(255, 137, 109, 23);
		contentPane.add(btnRegresar);
		
	}
	
	//Crear base de datos de usuarios con sus datos//
	private void CrearUsuarios() {
		String archivo = txtNombre.getText()+".registro";
		File crea_ubicacion = new File(ubicacion);
		File crea_archivo = new File (ubicacion+archivo);

		
		if(txtNombre.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane,"No hay Nombre");
		}
		else {
			
			try {
				if(crea_archivo.exists()) {
					JOptionPane.showMessageDialog(null,"Ya existe registro");

				}
				else {
					crea_ubicacion.mkdirs();
					Formatter crear = new Formatter(crea_archivo);
					crear.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s","Usuario="+ txtNombre.getText(),
							"Apellido="+textApellido.getText(),"Contraseña="+jpassClave.getText(),"Correo="+txtCorreo.getText(),
							"Cedula="+txtCedula.getText(),"Telefono="+TelefonotextField.getText());
					crear.close();
					JOptionPane.showMessageDialog(rootPane,"Usuario Registrado");
					txtNombre.setText(null);
					textApellido.setText(null);
					jpassClave.setText(null);
					txtCorreo.setText(null);
					txtCedula.setText(null);
					TelefonotextField.setText(null);
					
					txtNombre.requestFocus();
					textApellido.requestFocus();
					jpassClave.requestFocus();
					txtCorreo.requestFocus();
					txtCedula.requestFocus();
					TelefonotextField.requestFocus();

				}
			}
			
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null,"No se pudo registrar");
				
			}
			
		}
	}
}
