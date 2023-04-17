package paquete_2_admin;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Formatter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Admin_Agregar_Libros extends JFrame {

	public JPanel panel1;
	String barra = File.separator;
	public String ubicacion = System.getProperty("user.dir")+barra+"BasedeDatos"+barra;
	private static final long serialVersionUID = 1L;
	public JPanel panel;
	private JTextField NombreTextField;
	private JLabel AutorLabel;
	private JLabel GeneroLabel;
	private JLabel FechaLabel;
	private JLabel PrecioLabel;
	private JLabel CodigoLabel;
	private JTextField AutorTextField;
	private JTextField GeneroTextField;
	private JTextField FechaTextField;
	private JTextField PrecioTextField;
	private JTextField CodigoTextField;
	private JButton Regresar;
	
	public Admin_Agregar_Libros () {
		
		//Insertar componentes//
		this.setSize (480,438);
		setTitle("Agregar Libro");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		paneles ();
		Botones ();
		colocatTexto ();
		PanelesdeTexto();
	}
	
	//Insertar Paneles//
	private void paneles () {
		
		panel1 = new JPanel ();
		panel1.setLayout(null);
		this.getContentPane().add(panel1);
	}
	
	//Insertar Textos//
	private void colocatTexto () {
		JLabel texto = new JLabel ("Agregar Libro");
		texto.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		texto.setBounds(165,11,146,55);
		panel1.add(texto);
		
		
		CodigoLabel = new JLabel("Codigo");
		CodigoLabel.setFont(new Font("Adobe Garamond Pro Bold", Font.PLAIN, 18));
		CodigoLabel.setBounds(68, 75, 62, 26);
		panel1.add(CodigoLabel);
		
		JLabel NombreLabel = new JLabel("Nombre");
		NombreLabel.setFont(new Font("Adobe Garamond Pro Bold", Font.PLAIN, 18));
		NombreLabel.setBounds(339, 75, 62, 26);
		panel1.add(NombreLabel);
		
		AutorLabel = new JLabel("Autor");
		AutorLabel.setFont(new Font("Adobe Garamond Pro Bold", Font.PLAIN, 18));
		AutorLabel.setBounds(76, 165, 43, 26);
		panel1.add(AutorLabel);

		GeneroLabel = new JLabel("Genero");
		GeneroLabel.setFont(new Font("Adobe Garamond Pro Bold", Font.PLAIN, 18));
		GeneroLabel.setBounds(339, 165, 62, 26);
		panel1.add(GeneroLabel);
	
		FechaLabel = new JLabel("Fecha");
		FechaLabel.setFont(new Font("Adobe Garamond Pro Bold", Font.PLAIN, 18));
		FechaLabel.setBounds(76, 255, 48, 26);
		panel1.add(FechaLabel);
	
		PrecioLabel = new JLabel("Precio");
		PrecioLabel.setFont(new Font("Adobe Garamond Pro Bold", Font.PLAIN, 18));
		PrecioLabel.setBounds(339, 255, 55, 26);
		panel1.add(PrecioLabel);

	}
	
	//Insertar TextField de los datos del libro//
	private void PanelesdeTexto() {
		
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
		CodigoTextField.setBounds(10, 112, 182, 26);
		panel1.add(CodigoTextField);
		
		NombreTextField = new JTextField();
		NombreTextField.setBounds(273, 112, 182, 26);
		panel1.add(NombreTextField);
		NombreTextField.setColumns(10);
		
		AutorTextField = new JTextField();
		AutorTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isLetter(c)) && (!(Character.isWhitespace(c)))) {
					e.consume();
				}
			}
		});
		AutorTextField.setColumns(10);
		AutorTextField.setBounds(10, 202, 182, 26);
		panel1.add(AutorTextField);

		GeneroTextField = new JTextField();
		GeneroTextField.setColumns(10);
		GeneroTextField.setBounds(273, 202, 182, 26);
		panel1.add(GeneroTextField);

		FechaTextField = new JTextField();
		FechaTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))) {
					e.consume();
				}
			}
		});
		FechaTextField.setColumns(10);
		FechaTextField.setBounds(10, 295, 182, 26);
		panel1.add(FechaTextField);
		
		PrecioTextField = new JTextField();
		PrecioTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))) {
					e.consume();
				}				
			}
		});
		PrecioTextField.setColumns(10);
		PrecioTextField.setBounds(273, 295, 182, 26);
		panel1.add(PrecioTextField);

}	
	
	//Insertar botones con sus acciones//
	private void Botones () {

	JButton Agregar = new JButton();
		Agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crear();
			}	

		});
		Agregar.setBounds(241,357,135,29);
		Agregar.setText("Agregar");
		Agregar.setEnabled(true);
		panel1.add(Agregar);
		
		Regresar = new JButton();
		Regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin_Menu_Inicial menu = new Admin_Menu_Inicial();
				menu.setVisible(true);
			}
		});
		Regresar.setText("Regresar");
		Regresar.setEnabled(true);
		Regresar.setBounds(84, 357, 135, 29);
		panel1.add(Regresar);	
	}
	
	
	//Crear Base de datos de los libros//
	private void crear() {
		String archivo = CodigoTextField.getText()+".registro";
		File crea_ubicacion = new File(ubicacion);
		File crea_archivo = new File (ubicacion+archivo);
		
		if(CodigoTextField.getText().equals("") || NombreTextField.getText().equals("")||AutorTextField.getText().equals("")&CodigoTextField.getText().equals("")
				||GeneroTextField.getText().equals("")||PrecioTextField.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane,"Rellenar todos los datos");
		}
		else {
			
			try {
				if(crea_archivo.exists()) {
					JOptionPane.showMessageDialog(null,"Ya existe registro");

				}
				else {
					crea_ubicacion.mkdirs();
					Formatter crear = new Formatter(ubicacion+archivo);
					crear.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s","Nombre="+ NombreTextField.getText(),
							"Autor="+AutorTextField.getText(),"Materia="+GeneroTextField.getText(),
							"Fecha="+FechaTextField.getText(),"Precio="+PrecioTextField.getText(),
							"Codigo="+CodigoTextField.getText());
					crear.close();
					JOptionPane.showMessageDialog(rootPane,"Libro Registrado");
					NombreTextField.setText(null);
					AutorTextField.setText(null);
					GeneroTextField.setText(null);
					FechaTextField.setText(null);
					PrecioTextField.setText(null);
					CodigoTextField.setText(null);
					
					NombreTextField.requestFocus();
					AutorTextField.requestFocus();
					GeneroTextField.requestFocus();
					FechaTextField.requestFocus();
					PrecioTextField.requestFocus();
					CodigoTextField.requestFocus();

				}
			}
			
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null,"No se pudo registrar");
				
			}
			
		}
	}
}