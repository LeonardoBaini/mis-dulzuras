package Pantallas;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;

import Base.metodosSql;
import ObjetosPersistentes.MateriaPrima;
import ObjetosPersistentes.Mostradorp;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import persistencia.Hibernate;
import java.awt.Toolkit;

@SuppressWarnings("unused")
public class CrearProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static ArrayList<ArrayList<String>> matriz = null;  //  @jve:decl-index=0:
	protected static Vector<String> columnasNombre = null;  //  @jve:decl-index=0:
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneMateriales = null;
	private JTable jTableMateriales = null;
	private JScrollPane jScrollPaneProducto = null;
	private JTable jTableProducto =null;
	private JLabel jLabelCostoMatPrima = null;
	private JButton jButtonAgregar = null;
	private JButton jButtonQuitar = null;
	private JButton jButtonMostrador = null;
	private JLabel jLabelSubtotalsuma = null;
	private JLabel jLabelManoObra = null;
	private JTextField jTextFieldManoDeObra = null;
	private JLabel jLabelPrecioFinal = null;
	private JLabel jLabelSumaPrecioFinal = null;
	private JLabel jLabelMateriales = null;
	private JLabel jLabelCrearProducto = null;
	private JButton jButtonUsarComoMat = null;
	private JLabel jLabelFiltro = null;
	private JLabel jLabelFoto = null;
	private JLabel jLabelNombre = null;
	private JButton jButtonRefresh = null;
	private JTextField jTextFieldFiltro = null;
	private JButton jButtonFiltrar = null;
	private JTextField jTextFieldNombreProducto = null;
	private JLabel jLabelCantidad = null;
	private JTextField jTextFieldCantidadUnitaria = null;
	/**
	 * This is the default constructor
	 */
	public CrearProducto() {
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
	   
		this.setSize(954, 475);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Muffin.png")));
		this.setContentPane(getJContentPane());
		this.setTitle("Elaboración de productos ");
		
		metodosSql metodos=new metodosSql();
		metodos.llenarJtable(jTableMateriales, "select * from materia_prima");
		
		matriz=new ArrayList<ArrayList<String>>();
		columnasNombre=new Vector<String>();
		columnasNombre.addElement("NOMBRE MATERIAL");
		columnasNombre.addElement("CANTIDAD");
		columnasNombre.addElement("UNIDAD DE MEDIDA");
		columnasNombre.addElement("PRECIOXUNIDADMEDIDA");
		 
		    jTableMateriales.getTableHeader().setReorderingAllowed(false) ;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelCantidad = new JLabel();
			jLabelCantidad.setBounds(new Rectangle(544, 381, 253, 19));
			jLabelCantidad.setText("Cantidad de productos resultantes");
			jLabelNombre = new JLabel();
			jLabelNombre.setBounds(new Rectangle(542, 326, 383, 18));
			jLabelNombre.setText("Seleccione un nombre para el producto");
			jLabelFoto = new JLabel();
			jLabelFoto.setBounds(new Rectangle(37, 283, 368, 102));
			jLabelFoto.setText("");
			jLabelFiltro = new JLabel();
			jLabelFiltro.setBounds(new Rectangle(35, 223, 301, 24));
			jLabelFiltro.setText("Filtrar por nombre de material");
			jLabelCrearProducto = new JLabel();
			jLabelCrearProducto.setBounds(new Rectangle(541, 11, 384, 22));
			jLabelCrearProducto.setText("Producto eleborado");
			jLabelMateriales = new JLabel();
			jLabelMateriales.setBounds(new Rectangle(33, 14, 279, 24));
			jLabelMateriales.setText("Materiales disponibles");
			jLabelSumaPrecioFinal = new JLabel();
			jLabelSumaPrecioFinal.setBounds(new Rectangle(731, 291, 193, 24));
			jLabelSumaPrecioFinal.setText("");
			jLabelPrecioFinal = new JLabel();
			jLabelPrecioFinal.setBounds(new Rectangle(542, 292, 178, 22));
			jLabelPrecioFinal.setText("Precio final");
			jLabelManoObra = new JLabel();
			jLabelManoObra.setBounds(new Rectangle(542, 266, 179, 22));
			jLabelManoObra.setText("Mano de obra recomendada");
			jLabelSubtotalsuma = new JLabel();
			jLabelSubtotalsuma.setBounds(new Rectangle(730, 237, 196, 27));
			jLabelSubtotalsuma.setText("");
			jLabelCostoMatPrima = new JLabel();
			jLabelCostoMatPrima.setBounds(new Rectangle(541, 238, 181, 24));
			jLabelCostoMatPrima.setText("Sub-total  (costo de materiales)");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(238, 179, 218));
			jContentPane.add(getJScrollPaneMateriales(), null);
			jContentPane.add(getJScrollPaneProducto(), null);
			jContentPane.add(jLabelCostoMatPrima, null);
			jContentPane.add(getJButtonAgregar(), null);
			jContentPane.add(getJButtonQuitar(), null);
			jContentPane.add(getJButtonMostrador(), null);
			jContentPane.add(jLabelSubtotalsuma, null);
			jContentPane.add(jLabelManoObra, null);
			jContentPane.add(getJTextFieldManoDeObra(), null);
			jContentPane.add(jLabelPrecioFinal, null);
			jContentPane.add(jLabelSumaPrecioFinal, null);
			jContentPane.add(jLabelMateriales, null);
			jContentPane.add(jLabelCrearProducto, null);
			jContentPane.add(getJButtonUsarComoMat(), null);
			jContentPane.add(jLabelFiltro, null);
			jContentPane.add(jLabelFoto, null);
			jContentPane.add(jLabelNombre, null);
			jContentPane.add(getJButtonRefresh(), null);
			jContentPane.add(getJTextFieldFiltro(), null);
			jContentPane.add(getJButtonFiltrar(), null);
			jContentPane.add(getJTextFieldNombreProducto(), null);
			jContentPane.add(jLabelCantidad, null);
			jContentPane.add(getJTextFieldCantidadUnitaria(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneMateriales	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneMateriales() {
		if (jScrollPaneMateriales == null) {
			jScrollPaneMateriales = new JScrollPane();
			jScrollPaneMateriales.setBounds(new Rectangle(34, 36, 373, 184));
			jScrollPaneMateriales.setViewportView(getJTableMateriales());
		}
		return jScrollPaneMateriales;
	}

	/**
	 * This method initializes jTableMateriales	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableMateriales() {
		if (jTableMateriales == null) {
			jTableMateriales = new JTable();
		}
		return jTableMateriales;
	}

	/**
	 * This method initializes jScrollPaneProducto	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneProducto() {
		if (jScrollPaneProducto == null) {
			jScrollPaneProducto = new JScrollPane();
			jScrollPaneProducto.setBounds(new Rectangle(540, 36, 387, 190));
			jScrollPaneProducto.setViewportView(getJTableProducto());
		}
		return jScrollPaneProducto;
	}

	/**
	 * This method initializes jTableProducto	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableProducto() {
		if (jTableProducto == null) {
			jTableProducto = new JTable();
			jTableProducto.addComponentListener(new java.awt.event.ComponentAdapter() {
				public void componentResized(java.awt.event.ComponentEvent e) {
					try{
						int columnaProducto=jTableProducto.getColumn("PRECIOXUNIDAD").getModelIndex();
						int filaProducto=jTableProducto.getSelectedRow();
						int precioXunidad=Integer.parseInt((String) jTableProducto.getValueAt(filaProducto, columnaProducto));
						jLabelSubtotalsuma.setText(matriz.get(0).get(1));
						
					}catch(Exception e1){
						
					}
				}
			});
			
		}
		return jTableProducto;
	}
	
	private void actualizarValores(){
		float subtotal=0;
		for(int i=0;i<matriz.size();i++){
		
		float cant=Float.parseFloat(matriz.get(i).get(1));
		float precio=Float.parseFloat(matriz.get(i).get(3));
		subtotal=subtotal+(cant*precio);
		}
		float manoObra=subtotal*3;
		float precioFinal=manoObra+subtotal;
		jLabelSubtotalsuma.setText(String.valueOf(subtotal));
		jTextFieldManoDeObra.setText(String.valueOf(manoObra));
		jLabelSumaPrecioFinal.setText(String.valueOf(precioFinal));
	}

	private void actualizarValoresEnFuncionNvaManoObra(float manoObra){
		float subtotal=0;
		for(int i=0;i<matriz.size();i++){
		
		float cant=Float.parseFloat(matriz.get(i).get(1));
		float precio=Float.parseFloat(matriz.get(i).get(3));
		subtotal=subtotal+(cant*precio);
		}
		
		float precioFinal=manoObra+subtotal;
		jLabelSubtotalsuma.setText(String.valueOf(subtotal));
		jTextFieldManoDeObra.setText(String.valueOf(manoObra));
		jLabelSumaPrecioFinal.setText(String.valueOf(precioFinal));
	}
	
	private int quitarDeStock(String nombre,double cantidad){
		int status=0;
		try{
		double auxCant=0;
		MateriaPrima mat = new MateriaPrima();
		mat=(MateriaPrima) Hibernate.dameObjeto(nombre, mat);
		auxCant=mat.getCantidad();
		if(auxCant>=cantidad && cantidad >0){
		mat.setCantidad(mat.getCantidad()- cantidad);
		status=Hibernate.modificarObjeto(mat);
		}else{
			JOptionPane.showMessageDialog(null,"No hay tanta materia prima en el stock, hay que comprar más!");
		}
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null,"Verificá los datos que cargaste "+e1.getMessage());
		}
		return status;
		
		
	}
	private int agregarStock(String nombre,double cantidad){
		
		int status=0;
		try{
		double auxCant=0;
		MateriaPrima mat = new MateriaPrima();
		mat=(MateriaPrima) Hibernate.dameObjeto(nombre, mat);
		auxCant=mat.getCantidad();
		if(cantidad>0){
		mat.setCantidad(mat.getCantidad()+ cantidad);
		status=Hibernate.modificarObjeto(mat);
		}
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null,"Verificá los datos que cargaste "+e1.getMessage());
		}
		
		return status;
		
		
	}
	
	/**
	 * This method initializes jButtonAgregar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregar() {
		if (jButtonAgregar == null) {
			jButtonAgregar = new JButton();
			jButtonAgregar.setBounds(new Rectangle(416, 39, 119, 37));
			jButtonAgregar.setIcon(new ImageIcon(getClass().getResource("/iconos/Next.png")));
			jButtonAgregar.setText("Agregar");
			jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTableProducto.getTableHeader().setReorderingAllowed(false) ;
					String cantidad=JOptionPane.showInputDialog("Cantidad?");
					
					metodosSql metodos=new metodosSql();
					ArrayList<String> fila=new ArrayList<String>();
					int indice=jTableMateriales.getSelectedRow();
					fila.add((String) jTableMateriales.getValueAt(indice,jTableMateriales.getColumn("NOMBRE").getModelIndex()));
					fila.add(cantidad);
					fila.add((String) jTableMateriales.getValueAt(indice,jTableMateriales.getColumn("UNIDADMEDIDA").getModelIndex()));
					fila.add((String) jTableMateriales.getValueAt(indice,jTableMateriales.getColumn("PRECIOXUMEDIDA").getModelIndex()));
					
					if(quitarDeStock(fila.get(0), Double.parseDouble(fila.get(1)))==1){
						matriz.add(fila);
						metodos.llenarJtableSinConexion(jTableProducto, matriz, columnasNombre);					
						actualizarValores();
						jButtonRefresh.doClick();
						
					}
					
					
				}
			});
		}
		return jButtonAgregar;
	}

	/**
	 * This method initializes jButtonQuitar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonQuitar() {
		if (jButtonQuitar == null) {
			jButtonQuitar = new JButton();
			jButtonQuitar.setBounds(new Rectangle(416, 82, 119, 37));
			jButtonQuitar.setIcon(new ImageIcon(getClass().getResource("/iconos/Back.png")));
			jButtonQuitar.setText("Quitar");
			jButtonQuitar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
					int indice=jTableProducto.getSelectedRow();
					String nombreProducto=matriz.get(indice).get(0);
					String cantidad=matriz.get(indice).get(1);
					matriz.remove(indice);
					metodosSql metodos=new metodosSql();
					metodos.llenarJtableSinConexion(jTableProducto, matriz, columnasNombre);
					actualizarValores();
					agregarStock(nombreProducto, Double.parseDouble(cantidad));
					jButtonRefresh.doClick();
					}catch(ArrayIndexOutOfBoundsException a){
						JOptionPane.showMessageDialog(null,"Seleccione un elemento a quitar del producto");
					}
				}
			});
		}
		return jButtonQuitar;
	}

	/**
	 * This method initializes jButtonMostrador	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonMostrador() {
		if (jButtonMostrador == null) {
			jButtonMostrador = new JButton();
			jButtonMostrador.setBounds(new Rectangle(746, 405, 196, 40));
			jButtonMostrador.setIcon(new ImageIcon(getClass().getResource("/iconos/Save.png")));
			jButtonMostrador.setText("Colocar en mostrador");
			jButtonMostrador.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int cantidadProductos=Integer.parseInt(jTextFieldCantidadUnitaria.getText());
					float subtotal=Float.parseFloat(jLabelSubtotalsuma.getText().toString());
					float precioFinal=Float.parseFloat(jLabelSumaPrecioFinal.getText().toString());
					String nombreProducto=jTextFieldNombreProducto.getText();
					float precioUnitario=precioFinal/cantidadProductos;
					float manoDeObra=precioFinal-subtotal;
					float paraReponerEnMatPrima=subtotal/cantidadProductos;
					metodosSql metodos=new metodosSql();
					int status=0;
					for(int i=0;i<cantidadProductos;i++){
						Mostradorp m=new Mostradorp();
						
						m.setFechaElaboracion(metodos.dameFechaDeHoy());
						m.setNombre(nombreProducto);
						m.setPrecio(precioUnitario);
						m.setDinero_a_reponer(paraReponerEnMatPrima);
						status=status+Hibernate.guardarObjeto(m);
						
						
					}
					if(status==cantidadProductos){
						JOptionPane.showMessageDialog(null,"Producto /s agregado /s al mostrador.");
						
						
						
						
					}else{
						JOptionPane.showMessageDialog(null,"No los pude guardar en mostrador... reintentá.");
					}
				}
			});
		}
		return jButtonMostrador;
	}

	/**
	 * This method initializes jTextFieldManoDeObra	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldManoDeObra() {
		if (jTextFieldManoDeObra == null) {
			jTextFieldManoDeObra = new JTextField();
			jTextFieldManoDeObra.setBounds(new Rectangle(731, 266, 194, 22));
			
			jTextFieldManoDeObra.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						float manoObra=Float.parseFloat(jTextFieldManoDeObra.getText());
						actualizarValoresEnFuncionNvaManoObra(manoObra);
						}catch(Exception e1){
							
						}
				}
			});
		}
		return jTextFieldManoDeObra;
	}

	/**
	 * This method initializes jButtonUsarComoMat	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonUsarComoMat() {
		if (jButtonUsarComoMat == null) {
			jButtonUsarComoMat = new JButton();
			jButtonUsarComoMat.setBounds(new Rectangle(522, 405, 211, 40));
			jButtonUsarComoMat.setIcon(new ImageIcon(getClass().getResource("/iconos/Save.png")));
			jButtonUsarComoMat.setText("Usar como materia prima");
			jButtonUsarComoMat.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Proximamente...");
				
				
				
				
				
				}
			});
		}
		return jButtonUsarComoMat;
	}

	/**
	 * This method initializes jButtonRefresh	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRefresh() {
		if (jButtonRefresh == null) {
			jButtonRefresh = new JButton();
			jButtonRefresh.setBounds(new Rectangle(316, 16, 89, 22));
			jButtonRefresh.setText("REFRESH");
			jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					metodosSql metodos=new metodosSql();
					metodos.llenarJtable(jTableMateriales, "select * from materia_prima");
				}
			});
		}
		return jButtonRefresh;
	}

	/**
	 * This method initializes jTextFieldFiltro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldFiltro() {
		if (jTextFieldFiltro == null) {
			jTextFieldFiltro = new JTextField();
			jTextFieldFiltro.setBounds(new Rectangle(36, 248, 369, 30));
			jTextFieldFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER){
						jButtonFiltrar.doClick();
					}
				}
			});
			
		}
		return jTextFieldFiltro;
	}

	/**
	 * This method initializes jButtonFiltrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonFiltrar() {
		if (jButtonFiltrar == null) {
			jButtonFiltrar = new JButton();
			jButtonFiltrar.setBounds(new Rectangle(340, 222, 66, 25));
			jButtonFiltrar.setIcon(new ImageIcon(getClass().getResource("/iconos/Search.png")));
			jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String nombre=jTextFieldFiltro.getText();
					
					metodosSql metodos=new metodosSql();
					if(!nombre.isEmpty()){
					metodos.llenarJtable(jTableMateriales, "select * from materia_prima where nombre like '"+nombre+"%';");
					}else{
						metodos.llenarJtable(jTableMateriales, "select * from materia_prima");
					}
					
				}
			});
		}
		return jButtonFiltrar;
	}

	/**
	 * This method initializes jTextFieldNombreProducto	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNombreProducto() {
		if (jTextFieldNombreProducto == null) {
			jTextFieldNombreProducto = new JTextField();
			jTextFieldNombreProducto.setBounds(new Rectangle(542, 351, 383, 22));
		}
		return jTextFieldNombreProducto;
	}

	/**
	 * This method initializes jTextFieldCantidadUnitaria	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCantidadUnitaria() {
		if (jTextFieldCantidadUnitaria == null) {
			jTextFieldCantidadUnitaria = new JTextField();
			jTextFieldCantidadUnitaria.setBounds(new Rectangle(804, 379, 120, 22));
		}
		return jTextFieldCantidadUnitaria;
	}

}  //  @jve:decl-index=0:visual-constraint="12,11"
