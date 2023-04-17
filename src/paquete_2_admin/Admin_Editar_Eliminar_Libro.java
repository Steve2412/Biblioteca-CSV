package paquete_2_admin;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Admin_Editar_Eliminar_Libro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel panel;
	Admin_Agregar_Libros localizacion = new Admin_Agregar_Libros();
	private JTextField NombreTextField;
	private JTextField AutorTextField;
	private JTextField FechaTextField;
	private JTextField PrecioTextField;
	private JTextField GeneroTextField;
	private JTextField CodigoTextField;
	private JTextField CodigoTextFieldReal;
	
	public Admin_Editar_Eliminar_Libro() {
		
		//Insertar componentes//
		
		this.setSize (500,500);
		setTitle("Editar/Eliminar Libros");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		paneles ();
		PanelesdeTexto();
		colocatTexto ();
		Botones ();
	}
	
	//Insertar paneles//
	private void paneles () {
		
        
		panel = new JPanel ();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}
	
	//Insertar textos//
	private void colocatTexto () {
		JLabel texto = 	new JLabel ("Seleccione el codigo del libro: ");
		texto.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		texto.setBounds(94,11,312,40);
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
	
	//Insertar TextField de los datos del libro//
	private void PanelesdeTexto() {
		
		CodigoTextFieldReal = new JTextField();
		CodigoTextFieldReal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))) {
					e.consume();
				}
			}
		});
		CodigoTextFieldReal.setColumns(10);
		CodigoTextFieldReal.setBounds(10, 125, 182, 26);
		panel.add(CodigoTextFieldReal);
		
		NombreTextField = new JTextField();
		NombreTextField.setBounds(273, 125, 182, 26);
		panel.add(NombreTextField);
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
		AutorTextField.setBounds(10, 215, 182, 26);
		panel.add(AutorTextField);

		GeneroTextField = new JTextField();
		GeneroTextField.setColumns(10);
		GeneroTextField.setBounds(273, 215, 182, 26);
		panel.add(GeneroTextField);

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
		FechaTextField.setBounds(10, 308, 182, 26);
		panel.add(FechaTextField);
		
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
		PrecioTextField.setBounds(273, 308, 182, 26);
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
	
	//Insertar botones con sus acciones//
	private void Botones () {
		JButton AgregarLibros = new JButton();
		AgregarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar ();
			}
		});
		AgregarLibros.setBounds(23,359,159,40);
		AgregarLibros.setText("Editar");
		AgregarLibros.setEnabled(true);
		panel.add(AgregarLibros);

		JButton Eliminar = new JButton();
		Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		Eliminar.setText("Eliminar");
		Eliminar.setEnabled(true);
		Eliminar.setBounds(298, 359, 159, 40);
		panel.add(Eliminar);

		JButton Regresar = new JButton();
		Regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin_Menu_Inicial menu = new Admin_Menu_Inicial();
				menu.setVisible(true);
			}
		});
		Regresar.setText("Regresar");
		Regresar.setEnabled(true);
		Regresar.setBounds(160, 410, 159, 40);
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

	//Mostrar datos del libro//
	public void Mostrar() {
		File url = new File(localizacion.ubicacion+CodigoTextField.getText()+".registro");
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
	
	
	//Editar libros//
	public void editar () {
		File url = new File(localizacion.ubicacion+CodigoTextField.getText()+".registro");
		if(CodigoTextField.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Introduzca el libro a editar");
    		}	
    		else {
    			if (url.exists()) {
        			try {
        				FileWriter permitir_edicion = new FileWriter(localizacion.ubicacion+CodigoTextField.getText()+".registro");
        				String Nombre = "Nombre=";
        				String Autor = "Autor=";
        				String Materia = "Materia=";
        				String Fecha = "Fecha=";
        				String Precio = "Precio=";
        				String Codigo = "Codigo=";
        				
        				PrintWriter guardar = new PrintWriter(permitir_edicion);
        				guardar.println(Nombre+NombreTextField.getText());
        				guardar.println(Autor+AutorTextField.getText());
        				guardar.println(Materia+GeneroTextField.getText());
        				guardar.println(Fecha+FechaTextField.getText());
        				guardar.println(Precio+PrecioTextField.getText());
        				guardar.println(Codigo+CodigoTextFieldReal.getText());
        				permitir_edicion.close();
        				JOptionPane.showMessageDialog(AutorTextField, "Libro Editado");
    					NombreTextField.setText(null);
    					AutorTextField.setText(null);
    					GeneroTextField.setText(null);
    					FechaTextField.setText(null);
    					PrecioTextField.setText(null);
    					CodigoTextFieldReal.setText(null);
    					CodigoTextField.setText(null);
    					
    					NombreTextField.requestFocus();
    					AutorTextField.requestFocus();
    					GeneroTextField.requestFocus();
    					FechaTextField.requestFocus();
    					PrecioTextField.requestFocus();
    					CodigoTextField.requestFocus();
    					CodigoTextFieldReal.requestFocus();
      
        					
        				}
        			catch (Exception e1) {
        				
        			}
        		}
        		else {
    				JOptionPane.showMessageDialog(rootPane, "El libro no existe");
    			}

    		}		
	}
    
	//Eliminar libro//
	public void eliminar() {
    	System.gc();
    	File url = new File (localizacion.ubicacion+CodigoTextFieldReal.getText()+".registro");
		if(CodigoTextFieldReal.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "No ha colocado el codigo del libro");
    		}	
    		else {
    			if (url.exists()) {
        			try {
        				FileInputStream cerrar = new FileInputStream(url);
        				cerrar.close();
        				System.gc();
        				url.delete();
       
        				JOptionPane.showMessageDialog(rootPane, "El libro ha sido eliminado");
        				CodigoTextField.setText(null);
        				NombreTextField.setText(null);
    					AutorTextField.setText(null);
    					GeneroTextField.setText(null);
    					FechaTextField.setText(null);
    					PrecioTextField.setText(null);
    					CodigoTextFieldReal.setText(null);
    					
    					CodigoTextField.requestFocus();
    					NombreTextField.requestFocus();
    					AutorTextField.requestFocus();
    					GeneroTextField.requestFocus();
    					FechaTextField.requestFocus();
    					PrecioTextField.requestFocus();
    					CodigoTextFieldReal.requestFocus();
        			}
        			catch (Exception e1) {
        				
        			}
        		}
        		else {
        			JOptionPane.showMessageDialog(rootPane, "Ese libro no existe");
    			}

    		}
    	}

}
