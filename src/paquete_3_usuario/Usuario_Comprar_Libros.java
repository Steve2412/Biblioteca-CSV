package paquete_3_usuario;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Usuario_Comprar_Libros extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String barra = File.separator;
	public String ubicacion = System.getProperty("user.dir")+barra+"BasedeDatos"+barra;
	public JPanel panel;
	private JTextField NombreTextField;
	private JTextField AutorTextField;
	private JTextField FechaTextField;
	private JTextField PrecioTextField;
	private JTextField GeneroTextField;
	private JTextField CodigoTextField;
	private JTextField CodigoTextFieldReal;
	
	public Usuario_Comprar_Libros() {
		
		//Insertar componentes//
		
		this.setSize (500,456);
		setTitle("Editar/Eliminar Libros");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		paneles ();
		PanelesdeTexto();
		colocatTexto ();
		Botones ();
	}
	
	//Insertar Paneles//
	private void paneles () {
		
        
		panel = new JPanel ();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}
	
	//Insertar textos//
	private void colocatTexto () {
		JLabel texto = 	new JLabel ("Seleccione el codigo del libro a adquirir: ");
		texto.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		texto.setBounds(33,11,428,40);
		panel.add(texto);
		
		JLabel CodigoLabel = new JLabel("Codigo");
		CodigoLabel.setFont(new Font("Adobe Garamond Pro Bold", Font.PLAIN, 18));
		CodigoLabel.setBounds(68, 96, 62, 26);
		panel.add(CodigoLabel);
		
		JLabel NombreLabel = new JLabel("Nombre");
		NombreLabel.setFont(new Font("Adobe Garamond Pro Bold", Font.PLAIN, 18));
		NombreLabel.setBounds(339, 96, 62, 26);
		panel.add(NombreLabel);
		
		JLabel AutorLabel = new JLabel("Autor");
		AutorLabel.setFont(new Font("Adobe Garamond Pro Bold", Font.PLAIN, 18));
		AutorLabel.setBounds(76, 186, 43, 26);
		panel.add(AutorLabel);

		JLabel GeneroLabel = new JLabel("Genero");
		GeneroLabel.setFont(new Font("Adobe Garamond Pro Bold", Font.PLAIN, 18));
		GeneroLabel.setBounds(339, 186, 62, 26);
		panel.add(GeneroLabel);
	
		JLabel FechaLabel = new JLabel("Fecha");
		FechaLabel.setFont(new Font("Adobe Garamond Pro Bold", Font.PLAIN, 18));
		FechaLabel.setBounds(76, 276, 48, 26);
		panel.add(FechaLabel);
	
		JLabel PrecioLabel = new JLabel("Precio");
		PrecioLabel.setFont(new Font("Adobe Garamond Pro Bold", Font.PLAIN, 18));
		PrecioLabel.setBounds(339, 276, 55, 26);
		panel.add(PrecioLabel);

	}
	
	//Insertar TextField donde se mostraran los datos del libro//
	private void PanelesdeTexto() {
		
		CodigoTextFieldReal = new JTextField();
		CodigoTextFieldReal.setColumns(10);
		CodigoTextFieldReal.setBounds(10, 125, 182, 26);
		CodigoTextFieldReal.setEditable(false);
		panel.add(CodigoTextFieldReal);
		
		NombreTextField = new JTextField();
		NombreTextField.setBounds(273, 125, 182, 26);
		panel.add(NombreTextField);
		NombreTextField.setColumns(10);
		NombreTextField.setEditable(false);
		
		AutorTextField = new JTextField();
		AutorTextField.setColumns(10);
		AutorTextField.setBounds(10, 215, 182, 26);
		AutorTextField.setEditable(false);
		panel.add(AutorTextField);

		GeneroTextField = new JTextField();
		GeneroTextField.setColumns(10);
		GeneroTextField.setBounds(273, 215, 182, 26);
		GeneroTextField.setEditable(false);
		panel.add(GeneroTextField);

		FechaTextField = new JTextField();
		FechaTextField.setColumns(10);
		FechaTextField.setBounds(10, 308, 182, 26);
		FechaTextField.setEditable(false);
		panel.add(FechaTextField);
		
		PrecioTextField = new JTextField();
		PrecioTextField.setColumns(10);
		PrecioTextField.setBounds(273, 308, 182, 26);
		PrecioTextField.setEditable(false);
		panel.add(PrecioTextField);
		
		CodigoTextField = new JTextField();
		CodigoTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))) {
					e.consume();
				}
			}
		});
		CodigoTextField.setColumns(10);
		CodigoTextField.setBounds(129, 60, 141, 20);
		panel.add(CodigoTextField);


}	
	//Insertar Botones con sus acciones//
	private void Botones () {
		JButton AgregarLibros = new JButton();
		AgregarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(rootPane, "¿Deseas adquirir este libro?");
				if (a==JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(rootPane, "El libro a sido adquirido");
				}
			}
		});
		AgregarLibros.setBounds(295,372,159,40);
		AgregarLibros.setText("Adquirir");
		AgregarLibros.setEnabled(true);
		panel.add(AgregarLibros);

		JButton Regresar = new JButton();
		Regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Usuario_Menu_Inicial regresar = new Usuario_Menu_Inicial();
				regresar.setVisible(true);
			}
		});
		Regresar.setText("Regresar");
		Regresar.setEnabled(true);
		Regresar.setBounds(21, 372, 159, 40);
		panel.add(Regresar);
		
		JButton Cargar_Datos = new JButton();
		Cargar_Datos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mostrar();
			}
		});
		Cargar_Datos.setText("Cargar");
		Cargar_Datos.setEnabled(true);
		Cargar_Datos.setBounds(285, 60, 81, 20);
		panel.add(Cargar_Datos);

	}		

	//Mostrar datos del libro libros//
	public void Mostrar() {
		File url = new File(ubicacion+CodigoTextField.getText()+".registro");
		if(CodigoTextField.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Introduzca un codigo");
		}
		else {
			
			if(url.exists()) {
				try {
					FileInputStream fis = new FileInputStream (url);
					Properties mostrar = new Properties();
					mostrar.load(fis);
						
					NombreTextField.setText(mostrar.getProperty("Nombre"));
					AutorTextField.setText(mostrar.getProperty("Autor"));
					GeneroTextField.setText(mostrar.getProperty("Materia"));
					FechaTextField.setText(mostrar.getProperty("Fecha"));
					PrecioTextField.setText(mostrar.getProperty("Precio"));
					CodigoTextFieldReal.setText(mostrar.getProperty("Codigo"));
					System.gc();
				}
				catch (Exception e1) {

				}
			}
			else {
				JOptionPane.showMessageDialog(rootPane, "El libro no existe");
			}
		}
	}
}
