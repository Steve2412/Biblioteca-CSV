package paquete_3_usuario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import paquete_2_admin.Admin_Agregar_Libros;
public class Usuario_Lista_Libros extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TableRowSorter<DefaultTableModel> trs;
	Admin_Agregar_Libros ubicacion = new Admin_Agregar_Libros();
	public JPanel panel;
	File Contenedor = new File(ubicacion.ubicacion);
	File [] Registros = Contenedor.listFiles();
	String [] Columnas = {"Codigo","Nombre","Autor","Genero","Fecha","Precio"};
	DefaultTableModel dtm = new DefaultTableModel(null,Columnas) {
		private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(int filas, int columnas) {
			if (columnas==0 && columnas==1) {
				return true;
			}
			else {
				return false;
			}
		}
	};
	private JTable table;
	private JTextField textField;
	
	public Usuario_Lista_Libros() {
		
		//Insertar componentes//
		
		this.setSize (1000,543);
		setTitle("Listado de Libros");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		paneles ();
		colocatTexto ();
		Botones ();
		Tabla ();
		RegTabla();
		TextField();
	}
	
	//Insertar Paneles//
	private void paneles () {
		
		panel = new JPanel ();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}
	
	//Insertar textos//
	private void colocatTexto () {
		JLabel texto = new JLabel ("Lista de Libros");
		texto.setFont(new Font("Elephant",0,17));
		texto.setBounds(422,11,135,55);
		panel.add(texto);
		
		JLabel texto_2 = new JLabel("Filtrar:");
		texto_2.setFont(new Font("Elephant", Font.PLAIN, 17));
		texto_2.setBounds(310, 453, 77, 43);
		panel.add(texto_2);
	}
	
	//Insertar Text Field para filtrar libros//
	private void TextField() {
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				trs.setRowFilter(RowFilter.regexFilter("(?i)"+textField.getText(), 0,1,2,3,4,5));
			}
		});
		trs = new TableRowSorter<DefaultTableModel>(dtm);
		table.setRowSorter(trs);
		textField.setBounds(397, 466, 243, 20);
		panel.add(textField);
		textField.setColumns(10);
	}
	
	//Insertar tablas//
	private void Tabla () {
		table = new JTable();
		table.setBounds(21, 70, 436, 321);
		panel.add(table);
		
		JScrollPane scroll = new JScrollPane (table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(21, 70, 953, 381);
		panel.add(scroll);
	}

	//Mostrar listado de libros//
	private void RegTabla() {
		for (int i=0;i<Registros.length;i++) {
			File url = new File(ubicacion.ubicacion+Registros[i].getName());
			try {
				FileInputStream fis = new FileInputStream(url);
				Properties mostrar = new Properties();
				mostrar.load(fis);
				
				String filas [] = {Registros[i].getName().replace(".registro",""),
						mostrar.getProperty("Nombre"),mostrar.getProperty("Autor"),mostrar.getProperty("Materia"),
						mostrar.getProperty("Fecha"),mostrar.getProperty("Precio"),mostrar.getProperty("Codigo")};
				dtm.addRow(filas);

				}
			catch(Exception e){
				
			}
		table.setModel(dtm);
		}
	}
	
	//Insertar botones con sus acciones//
	private void Botones () {
		
		
		JButton Regresar = new JButton();
		Regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Usuario_Menu_Inicial menu = new Usuario_Menu_Inicial();
				menu.setVisible(true);
			}
		});
		Regresar.setText("Regresar");
		Regresar.setEnabled(true);
		Regresar.setBounds(21, 462, 135, 29);
		panel.add(Regresar);
		
		JButton Actualizar = new JButton();
		Actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actualizar ();
			}
		});
		Actualizar.setText("Actualizar");
		Actualizar.setEnabled(true);
		Actualizar.setBounds(839, 462, 135, 29);
		panel.add(Actualizar);
	}
	
	
	//Actualizar lista de libros//
	public void Actualizar () {
		Registros = Contenedor.listFiles();
		
		dtm.setRowCount(0);
		RegTabla();
	}
}