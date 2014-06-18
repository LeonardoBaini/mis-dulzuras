package Pantallas;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;

import Base.metodosSql;

import java.awt.Toolkit;
import java.sql.SQLException;

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
	private JMenuItem jMenuItemBalance = null;
	private JMenu jMenuInicializar = null;
	private JMenuItem jMenuItemInicializarTablas = null;
	private JMenuItem jMenuItemSalir = null;

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
			jJMenuBar.add(getJMenuInicializar());
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
			jMenuArchivo.add(getJMenuItemSalir());
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
			jMenuInformes.add(getJMenuItemBalance());
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


	/**
	 * This method initializes jMenuItemBalance	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemBalance() {
		if (jMenuItemBalance == null) {
			jMenuItemBalance = new JMenuItem();
			jMenuItemBalance.setText("Balance mensual");
			jMenuItemBalance.setBackground(Color.magenta);
			jMenuItemBalance.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					InfoIngresos info=new InfoIngresos();
					info.setLocationRelativeTo(null);
					info.setVisible(true);
				}
			});
		}
		return jMenuItemBalance;
	}


	/**
	 * This method initializes jMenuInicializar	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuInicializar() {
		if (jMenuInicializar == null) {
			jMenuInicializar = new JMenu();
			jMenuInicializar.setText("Inicializar Base de Datos");
			jMenuInicializar.add(getJMenuItemInicializarTablas());
		}
		return jMenuInicializar;
	}


	/**
	 * This method initializes jMenuItemInicializarTablas	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemInicializarTablas() {
		if (jMenuItemInicializarTablas == null) {
			jMenuItemInicializarTablas = new JMenuItem();
			jMenuItemInicializarTablas.setText("ESTA OPCIÓN BORRA TODOS LOS DATOS Y REGENERA LA BASE DE DATOS");
			jMenuItemInicializarTablas
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							int preg1=0;
							int preg2=0;
							preg1=JOptionPane.showConfirmDialog(null,"Estás completamente segura?");
							preg2=JOptionPane.showConfirmDialog(null,"Confirmámelo una vez más.");
							if(preg1==0 && preg2==0){
							metodosSql metodos=new metodosSql();
							try {
								metodos.insertarOmodif("drop table `misdulzuras`.`materia_prima`");
								JOptionPane.showMessageDialog(null, "materia_prima BORRADO");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								metodos.insertarOmodif("drop table `misdulzuras`.`mostrador`");
								JOptionPane.showMessageDialog(null, "mostrador BORRADO");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								metodos.insertarOmodif("drop table `misdulzuras`.`ventas`");
								JOptionPane.showMessageDialog(null, "ventas BORRADO");
								JOptionPane.showMessageDialog(null, "HAY QUE AGREGAR ALGO EN EL STOCK PARA REGENERAR LA BASE");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}else{
								JOptionPane.showMessageDialog(null,"No hice ningún cambio");
							}
							
						}
					});
		}
		return jMenuItemInicializarTablas;
	}


	/**
	 * This method initializes jMenuItemSalir	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemSalir() {
		if (jMenuItemSalir == null) {
			jMenuItemSalir = new JMenuItem();
			jMenuItemSalir.setText("Salir");
			jMenuItemSalir.setBackground(Color.magenta);
			jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jMenuItemSalir;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
