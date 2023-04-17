package paquete_1_modos;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModoUsuario extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel panel;
	Logeo_usuario Panel1 = new Logeo_usuario();
	Logeo_admin Panel2 = new Logeo_admin();
	JScrollPane scrollPaneles;
	
	
	public ModoUsuario () {
		
		//Insertar elementos//
		this.setSize (500,381);
		setTitle("Biblioteca");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		paneles ();
		colocatTexto ();
		Imagenes ();
		Botones ();
	}
	
	//Insertar paneles//
	private void paneles () {
        
		panel = new JPanel ();
		panel.setLayout(null);
		this.getContentPane().add(panel);


	}
	
	//Insertar Texto//
	private void colocatTexto () {
		JLabel texto = new JLabel ("Pulse el modo en el que desea ingresar");
		texto.setFont(new Font("Elephant",0,17));
		texto.setBounds(90,0,334,100);
		panel.add(texto);

	}
	
	//Insertar imagenes//
	private void Imagenes () {
		ImageIcon imagen01 = new ImageIcon ("usuario.png");
		JLabel icono1 = new JLabel ();
		icono1.setBounds(100,125,40,40);
		icono1.setIcon(new ImageIcon(imagen01.getImage().getScaledInstance(icono1.getWidth(),icono1.getHeight(),0)));
		panel.add(icono1);
		
		ImageIcon imagen02 = new ImageIcon ("admin.png");
		JLabel icono2 = new JLabel ();
		icono2.setBounds(100,250,40,40);
		icono2.setIcon(new ImageIcon(imagen02.getImage().getScaledInstance(icono2.getWidth(),icono2.getHeight(),0)));
		panel.add(icono2);

	}
	
	//Insertar botones con sus acciones//
	private void Botones () {
		JButton Usuario = new JButton();
		Usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Panel1.setVisible(true);
			}
			});
		Usuario.setBounds(190,125,100,40);
		Usuario.setText("Usuario");
		Usuario.setEnabled(true);
		panel.add(Usuario);
		

		JButton Administrador = new JButton();
		Administrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Panel2.setVisible(true);
			}
		});
		Administrador.setBounds(165,250,150,40);
		Administrador.setText("Administrador");
		Administrador.setEnabled(true);
		panel.add(Administrador);
	
	}
	}

		
		