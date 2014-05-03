package Pantallas;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import java.awt.Toolkit;

@SuppressWarnings("unused")
public class PantallaPpal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenuArchivo = null;
	private JMenu jMenuElaboracion = null;
	private JMenu jMenuVentas = null;
	private JMenu jMenuStock = null;
	private JMenu jMenuInformes = null;
	private JMenuItem jMenuItemCrearProducto = null;
	private JMenuItem jMenuItemMostrador = null;
	private JMenuItem jMenuItemAgregarStock = null;
	private JMenuItem jMenuItemQuitarStock = null;

	/**
	 * This is the default constructor
	 */
	public PantallaPpal() {
		super();
		initialize();
	}
	

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(852, 351);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Muffin.png")));
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Pantalla principal");
		setExtendedState(MAXIMIZED_BOTH);
		
		
	
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new FondoPpal();
			jContentPane.setLayout(null);
		}
		return jContentPane;
	}


	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.setBackground(new Color(255, 171, 233));
			jJMenuBar.add(getJMenuArchivo());
			jJMenuBar.add(getJMenuElaboracion());
			jJMenuBar.add(getJMenuVentas());
			jJMenuBar.add(getJMenuStock());
			jJMenuBar.add(getJMenuInformes());
		}
		return jJMenuBar;
	}


	/**
	 * This method initializes jMenuArchivo	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuArchivo() {
		if (jMenuArchivo == null) {
			jMenuArchivo = new JMenu();
			jMenuArchivo.setText("Archivo");
		}
		return jMenuArchivo;
	}


	/**
	 * This method initializes jMenuElaboracion	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuElaboracion() {
		if (jMenuElaboracion == null) {
			jMenuElaboracion = new JMenu();
			jMenuElaboracion.setText("Elaboración");
			jMenuElaboracion.add(getJMenuItemCrearProducto());
		}
		return jMenuElaboracion;
	}


	/**
	 * This method initializes jMenuVentas	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuVentas() {
		if (jMenuVentas == null) {
			jMenuVentas = new JMenu();
			jMenuVentas.setText("Ventas");
			jMenuVentas.add(getJMenuItemMostrador());
		}
		return jMenuVentas;
	}


	/**
	 * This method initializes jMenuStock	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuStock() {
		if (jMenuStock == null) {
			jMenuStock = new JMenu();
			jMenuStock.setText("Stock");
			jMenuStock.add(getJMenuItemAgregarStock());
			jMenuStock.add(getJMenuItemQuitarStock());
		}
		return jMenuStock;
	}


	/**
	 * This method initializes jMenuInformes	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuInformes() {
		if (jMenuInformes == null) {
			jMenuInformes = new JMenu();
			jMenuInformes.setText("Informes");
		}
		return jMenuInformes;
	}


	/**
	 * This method initializes jMenuItemCrearProducto	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemCrearProducto() {
		if (jMenuItemCrearProducto == null) {
			jMenuItemCrearProducto = new JMenuItem();
			jMenuItemCrearProducto.setText("Crear productos");
			jMenuItemCrearProducto.setBackground(Color.magenta);
			jMenuItemCrearProducto.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					CrearProducto cre=new CrearProducto();
					cre.setVisible(true);
				}
			});
		}
		return jMenuItemCrearProducto;
	}


	/**
	 * This method initializes jMenuItemMostrador	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemMostrador() {
		if (jMenuItemMostrador == null) {
			jMenuItemMostrador = new JMenuItem();
			jMenuItemMostrador.setText("Ir al mostrador");
			jMenuItemMostrador.setBackground(Color.magenta);
			jMenuItemMostrador.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Mostrador mos=new Mostrador();
					mos.setVisible(true);
				}
			});
		}
		return jMenuItemMostrador;
	}


	/**
	 * This method initializes jMenuItemAgregarStock	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemAgregarStock() {
		if (jMenuItemAgregarStock == null) {
			jMenuItemAgregarStock = new JMenuItem();
			jMenuItemAgregarStock.setText("Agregar al stock");
			jMenuItemAgregarStock.setBackground(Color.magenta);
			jMenuItemAgregarStock.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				AgregarAStock agr=new AgregarAStock();
				agr.setVisible(true);
				}
			});
		}
		return jMenuItemAgregarStock;
	}


	/**
	 * This method initializes jMenuItemQuitarStock	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemQuitarStock() {
		if (jMenuItemQuitarStock == null) {
			jMenuItemQuitarStock = new JMenuItem();
			jMenuItemQuitarStock.setText("Quitar del stock");
			jMenuItemQuitarStock.setBackground(Color.magenta);
			jMenuItemQuitarStock.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					QuitarDeStock qui=new QuitarDeStock();
					qui.setVisible(true);
				}
			});
		}
		return jMenuItemQuitarStock;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
