package paquete_3_usuario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import paquete_1_modos.ModoUsuario;
public class Usuario_Menu_Inicial extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel panel;
	public Usuario_Menu_Inicial () {
			
	//Insertar componentes//
		
		this.setSize (500,500);
		setTitle("Usuario");
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
		
	//Insertar textos//	
	private void colocatTexto () {
			JLabel texto = new JLabel ("Pulse el modo en el que desea ingresar");
			texto.setFont(new Font("Elephant",0,17));
			texto.setBounds(90,0,500,100);
			panel.add(texto);

		}
		
	//Insertar botones con sus acciones//	
	private void Botones () {
			JButton AquirirLibros = new JButton();
			AquirirLibros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Usuario_Comprar_Libros comprar = new Usuario_Comprar_Libros();
					comprar.setVisible(true);
				}
			});
			AquirirLibros.setBounds(165,126,159,40);
			AquirirLibros.setText("Adquirir Libros");
			AquirirLibros.setEnabled(true);
			panel.add(AquirirLibros);
			
			
			JButton ListadoLibros = new JButton();
			ListadoLibros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Usuario_Lista_Libros listado = new Usuario_Lista_Libros();
					listado.setVisible(true);
				}
			});
			ListadoLibros.setText("Libros de la Biblioteca");
			ListadoLibros.setEnabled(true);
			ListadoLibros.setBounds(151, 245, 173, 40);
			panel.add(ListadoLibros);

			JButton CerrasSesion = new JButton();
			CerrasSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					ModoUsuario regreso = new ModoUsuario();
					regreso.setVisible(true);
				}
			});
			CerrasSesion.setText("Cerrar Sesion");
			CerrasSesion.setEnabled(true);
			CerrasSesion.setBounds(165, 363, 150, 40);
			panel.add(CerrasSesion);
		
		}
		
	//Insertar Imagenes//
	private void Imagenes() {
			
			ImageIcon imagen01 = new ImageIcon ("Adquirir.png");
			JLabel icono1 = new JLabel ();
			icono1.setBounds(90,126,66,40);
			icono1.setIcon(new ImageIcon(imagen01.getImage().getScaledInstance(icono1.getWidth(),icono1.getHeight(),0)));
			panel.add(icono1);		
						
			ImageIcon imagen03 = new ImageIcon ("Lista.png");
			JLabel icono3 = new JLabel ();
			icono3.setBounds(75,237,65,48);
			icono3.setIcon(new ImageIcon(imagen03.getImage().getScaledInstance(icono3.getWidth(),icono3.getHeight(),0)));
			panel.add(icono3);
			
			ImageIcon imagen04 = new ImageIcon ("CerrarSesion.png");
			JLabel icono4 = new JLabel ();
			icono4.setBounds(90,363,46,48);
			icono4.setIcon(new ImageIcon(imagen04.getImage().getScaledInstance(icono4.getWidth(),icono4.getHeight(),0)));
			panel.add(icono4);
		}
	}
