package paquete_2_admin;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import paquete_1_modos.ModoUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_Menu_Inicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel panel;
	ModoUsuario regreso = new ModoUsuario();
	Admin_Agregar_Libros Agregar = new Admin_Agregar_Libros();
	Admin_Lista_Libros Listado = new Admin_Lista_Libros();
	Admin_Editar_Eliminar_Libro Editar_Eliminar = new Admin_Editar_Eliminar_Libro();
	
	public Admin_Menu_Inicial () {
		
		//Insertar componentes//
		this.setSize (500,500);
		setTitle("Adminstrador");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		paneles ();
		colocatTexto ();
		Botones ();
		Imagenes();
	}
	
	//Insertar Paneles//
	private void paneles () {
		
        
		panel = new JPanel ();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}
	
	//Insertar Textos//
	private void colocatTexto () {
		JLabel texto = new JLabel ("Pulse el modo en el que desea ingresar");
		texto.setFont(new Font("Elephant",0,17));
		texto.setBounds(90,0,500,100);
		panel.add(texto);

	}
	
	//Insertar botones con sus acciones//
	private void Botones () {
		JButton AgregarLibros = new JButton();
		AgregarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Agregar.setVisible(true);
			}
		});
		AgregarLibros.setBounds(165,126,159,40);
		AgregarLibros.setText("Agregar Libros");
		AgregarLibros.setEnabled(true);
		panel.add(AgregarLibros);
		
		
		JButton ListadoLibros = new JButton();
		ListadoLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Listado.setVisible(true);
			}
		});
		ListadoLibros.setText("Lista de Libros");
		ListadoLibros.setEnabled(true);
		ListadoLibros.setBounds(165, 300, 150, 40);
		panel.add(ListadoLibros);

		JButton CerrasSesion = new JButton();
		CerrasSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				regreso.setVisible(true);
			}
		});
		CerrasSesion.setText("Cerrar Sesion");
		CerrasSesion.setEnabled(true);
		CerrasSesion.setBounds(165, 382, 150, 40);
		panel.add(CerrasSesion);
		
		JButton Editar_Eliminar_Libros = new JButton();
		Editar_Eliminar_Libros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Editar_Eliminar.setVisible(true);
			}
		});
		Editar_Eliminar_Libros.setText("Editar/Eliminar Libros");
		Editar_Eliminar_Libros.setEnabled(true);
		Editar_Eliminar_Libros.setBounds(156, 214, 168, 40);
		panel.add(Editar_Eliminar_Libros);	
	
	}
	
	//Insertar Imagenes//
	private void Imagenes() {
		ImageIcon imagen01 = new ImageIcon ("Añadir.png");
		JLabel icono1 = new JLabel ();
		icono1.setBounds(100,112,56,54);
		icono1.setIcon(new ImageIcon(imagen01.getImage().getScaledInstance(icono1.getWidth(),icono1.getHeight(),0)));
		panel.add(icono1);
		
		ImageIcon imagen02 = new ImageIcon ("Editar.png");
		JLabel icono2 = new JLabel ();
		icono2.setBounds(106,214,40,40);
		icono2.setIcon(new ImageIcon(imagen02.getImage().getScaledInstance(icono2.getWidth(),icono2.getHeight(),0)));
		panel.add(icono2);
		
		ImageIcon imagen03 = new ImageIcon ("Lista.png");
		JLabel icono3 = new JLabel ();
		icono3.setBounds(90,296,65,54);
		icono3.setIcon(new ImageIcon(imagen03.getImage().getScaledInstance(icono3.getWidth(),icono3.getHeight(),0)));
		panel.add(icono3);
		
		ImageIcon imagen04 = new ImageIcon ("CerrarSesion.png");
		JLabel icono4 = new JLabel ();
		icono4.setBounds(100,374,46,48);
		icono4.setIcon(new ImageIcon(imagen04.getImage().getScaledInstance(icono4.getWidth(),icono4.getHeight(),0)));
		panel.add(icono4);
	}
}
