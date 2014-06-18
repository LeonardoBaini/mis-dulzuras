package Pantallas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

import persistencia.Hibernate;

import Base.metodosSql;
import ObjetosPersistentes.MateriaPrima;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("unused")
public class AgregarAStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelNombre = null;
	private JComboBox <String>jComboBoxNombresMatPrima = null;
	private JLabel jLabelCantidad = null;
	private JTextField jTextFieldCantidad = null;
	private JButton jButtonAgregarNombre = null;
	private JLabel jLabelUnidad = null;
	private JComboBox<String> jComboBoxUnidad = null;
	private JLabel jLabelTotalStock = null;
	private JLabel jLabelInfoStock = null;
	private JButton jButtonAgregarAStock = null;
	private JLabel jLabelPrecio = null;
	private JTextField jTextFieldPrecio = null;
	private JButton jButtonSalir = null;
	private JLabel jLabeliNFOaVISO = null;
	private JTextField jTextFieldAviso = null;
	private JLabel jLabel = null;
	/**
	 * This is the default constructor
	 */
	public AgregarAStock() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		try 
	    { 
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
	       
	       
	        
	    } 
	    catch(Exception e){ 
	    }
		this.setSize(884, 326);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Muffin.png")));
		this.setContentPane(getJContentPane());
		this.setTitle("Agregar material al Stock");
		jComboBoxUnidad.addItem("KG");
		jComboBoxUnidad.addItem("LT");
		jComboBoxUnidad.addItem("UNIDAD");
		metodosSql metodos=new metodosSql();
		try {
			metodos.llenarComboBox(jComboBoxNombresMatPrima, "select nombre from materia_prima");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(744, 89, 116, 34));
			jLabel.setText("(Vacio es sin aviso)");
			jLabeliNFOaVISO = new JLabel();
			jLabeliNFOaVISO.setBounds(new Rectangle(367, 91, 270, 33));
			jLabeliNFOaVISO.setText("TE AVISARÉ CUÁNDO TE QUEDE MENOS DE ->");
			jLabelPrecio = new JLabel();
			jLabelPrecio.setBounds(new Rectangle(10, 178, 161, 34));
			jLabelPrecio.setText("Precio por U. de medida");
			jLabelInfoStock = new JLabel();
			jLabelInfoStock.setBounds(new Rectangle(713, 8, 157, 25));
			jLabelInfoStock.setText("(info automática)");
			jLabelTotalStock = new JLabel();
			jLabelTotalStock.setBounds(new Rectangle(500, 8, 195, 26));
			jLabelTotalStock.setText("Informe de stock al día de hoy");
			jLabelUnidad = new JLabel();
			jLabelUnidad.setBounds(new Rectangle(9, 133, 112, 35));
			jLabelUnidad.setText("Unidad de medida");
			jLabelCantidad = new JLabel();
			jLabelCantidad.setBounds(new Rectangle(8, 94, 62, 29));
			jLabelCantidad.setText("Cantidad");
			jLabelNombre = new JLabel();
			jLabelNombre.setBounds(new Rectangle(7, 8, 248, 26));
			jLabelNombre.setText("Nombre de la materia prima seleccione:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(238, 181, 217));
			jContentPane.add(jLabelNombre, null);
			jContentPane.add(getJComboBoxNombresMatPrima(), null);
			jContentPane.add(jLabelCantidad, null);
			jContentPane.add(getJTextFieldCantidad(), null);
			jContentPane.add(getJButtonAgregarNombre(), null);
			jContentPane.add(jLabelUnidad, null);
			jContentPane.add(getJComboBoxUnidad(), null);
			jContentPane.add(jLabelTotalStock, null);
			jContentPane.add(jLabelInfoStock, null);
			jContentPane.add(getJButtonAgregarAStock(), null);
			jContentPane.add(jLabelPrecio, null);
			jContentPane.add(getJTextFieldPrecio(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(jLabeliNFOaVISO, null);
			jContentPane.add(getJTextFieldAviso(), null);
			jContentPane.add(jLabel, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jComboBoxNombresMatPrima	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox <String> getJComboBoxNombresMatPrima() {
		if (jComboBoxNombresMatPrima == null) {
			jComboBoxNombresMatPrima = new JComboBox<String>();
			jComboBoxNombresMatPrima.setBounds(new Rectangle(5, 37, 348, 33));
			
			jComboBoxNombresMatPrima.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					try{
						if(jComboBoxNombresMatPrima.getSelectedItem()!=jComboBoxNombresMatPrima.getItemAt(0)){
						MateriaPrima mat=new MateriaPrima();
						String nombre=jComboBoxNombresMatPrima.getSelectedItem().toString();
						mat=(MateriaPrima) Hibernate.dameObjeto(nombre, mat);
						jLabelInfoStock.setText(String.valueOf(mat.getCantidad()+" "+mat.getUnidadMedida()));
						jTextFieldAviso.setText(String.valueOf(mat.getAvisarCuandoCantidadsea()));
						}
						}catch(Exception e1){
							JOptionPane.showMessageDialog(null, "Error "+e1.getStackTrace());
							e1.printStackTrace();
						}
				}
			});
		}
		return jComboBoxNombresMatPrima;
	}

	/**
	 * This method initializes jTextFieldCantidad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCantidad() {
		if (jTextFieldCantidad == null) {
			jTextFieldCantidad = new JTextField();
			jTextFieldCantidad.setBounds(new Rectangle(122, 91, 231, 33));
			jTextFieldCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if(e.getKeyChar()=='-'){
						JOptionPane.showMessageDialog(null,"No se permite el signo menos");
						jTextFieldCantidad.setText("");
					}
				}
			});
						
		}
		return jTextFieldCantidad;
	}

	/**
	 * This method initializes jButtonAgregarNombre	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregarNombre() {
		if (jButtonAgregarNombre == null) {
			jButtonAgregarNombre = new JButton();
			jButtonAgregarNombre.setBounds(new Rectangle(360, 36, 299, 33));
			jButtonAgregarNombre.setText("Agregar nueva materia prima (si no existe)");
			jButtonAgregarNombre.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int status=0;
					String nombre=JOptionPane.showInputDialog("Ingrese el nombre de la materia prima").toUpperCase();
					MateriaPrima mat=new MateriaPrima();
					mat.setNombre(nombre);
					status=Hibernate.guardarObjeto(mat);
					if(status==1){
						JOptionPane.showMessageDialog(null,"Cargado con éxito!");
						dispose();
						AgregarAStock a=new AgregarAStock();
						a.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null,"Falla al cargar, reintente");
					}
				}
			});
			jButtonAgregarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					jButtonAgregarNombre.doClick();
				}
				}
			});
		}
		return jButtonAgregarNombre;
	}

	/**
	 * This method initializes jComboBoxUnidad	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getJComboBoxUnidad() {
		if (jComboBoxUnidad == null) {
			jComboBoxUnidad = new JComboBox<String>();
			jComboBoxUnidad.setBounds(new Rectangle(125, 132, 228, 33));
		}
		return jComboBoxUnidad;
	}

	/**
	 * This method initializes jButtonAgregarAStock	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregarAStock() {
		if (jButtonAgregarAStock == null) {
			jButtonAgregarAStock = new JButton();
			jButtonAgregarAStock.setBounds(new Rectangle(602, 260, 139, 31));
			jButtonAgregarAStock.setText("Agregar al Stock");
			jButtonAgregarAStock.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
					int status=0;
					MateriaPrima mat=new MateriaPrima();
					
					String nombre=jComboBoxNombresMatPrima.getSelectedItem().toString();
					String cantidad=jTextFieldCantidad.getText();
					String unidadMedida=jComboBoxUnidad.getSelectedItem().toString();
					String dinero=jTextFieldPrecio.getText();
					String aviso=jTextFieldAviso.getText();
					mat.setNombre(nombre);
					mat=(MateriaPrima) Hibernate.dameObjeto(nombre, mat);
					
					mat.setCantidad(mat.getCantidad()+Float.parseFloat(cantidad));
					mat.setUnidadMedida(unidadMedida);
					if(!aviso.isEmpty()){
					mat.setAvisarCuandoCantidadsea(Float.parseFloat(aviso));
					}else{
						mat.setAvisarCuandoCantidadsea(-1);
					}
					
					if(mat.getPrecioXumedida()<Float.parseFloat(dinero))
					mat.setPrecioXumedida(Float.parseFloat(dinero));
					status=Hibernate.modificarObjeto(mat);
					
					if(status==1){
						JOptionPane.showMessageDialog(null,"Datos cargados con éxito!");
						jLabelInfoStock.setText(String.valueOf(mat.getCantidad()+" "+mat.getUnidadMedida()));
					}else{
						JOptionPane.showMessageDialog(null,"Los datos no se guardaron, reintente.");
					}
					
				}catch(NumberFormatException e1){
					
					JOptionPane.showMessageDialog(null,"Error!,complete el campos CANTIDAD DE DINERO INVERTIDO y CANTIDAD, use punto, no coma para separar decimales si es que es decimal.");
				}catch(Exception e2){
					if(e2.getMessage()==null){
						JOptionPane.showMessageDialog(null,"Error! la causa es uno o más campos vacíos, reviselos y reintente.");
					}else{
					JOptionPane.showMessageDialog(null,"Error! la causa es -> " +e2.getMessage()+" revise los campos y reintente.");
					}
					
					
				}
				
				}
					
			});
			jButtonAgregarAStock.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER){
						jButtonAgregarAStock.doClick();
					}
				}
			});
		}
		return jButtonAgregarAStock;
	}

	/**
	 * This method initializes jTextFieldPrecio	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldPrecio() {
		if (jTextFieldPrecio == null) {
			jTextFieldPrecio = new JTextField();
			jTextFieldPrecio.setBounds(new Rectangle(175, 178, 178, 33));
			jTextFieldPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if(e.getKeyChar()=='-'){
						JOptionPane.showMessageDialog(null,"No se permite el signo menos");
						jTextFieldPrecio.setText("");
					}
				}
			});
		}
		return jTextFieldPrecio;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(794, 260, 64, 31));
			jButtonSalir.setText("Salir");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
			jButtonSalir.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER){
						jButtonSalir.doClick();
					}
				}
			});
		}
		return jButtonSalir;
	}

	/**
	 * This method initializes jTextFieldAviso	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldAviso() {
		if (jTextFieldAviso == null) {
			jTextFieldAviso = new JTextField();
			jTextFieldAviso.setBounds(new Rectangle(651, 91, 89, 33));
		}
		return jTextFieldAviso;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
