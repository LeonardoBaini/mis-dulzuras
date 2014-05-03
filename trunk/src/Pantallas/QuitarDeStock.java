package Pantallas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Rectangle;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import persistencia.Hibernate;

import Base.metodosSql;
import ObjetosPersistentes.MateriaPrima;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("unused")
public class QuitarDeStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneStock = null;
	private JTable jTableElementos = null;
	private JLabel jLabel = null;
	private JButton jButtonQuitar = null;
	private JTextField jTextFieldCantidad = null;
	private JLabel jLabelCantidadAquitar = null;
	private JLabel jLabel1 = null;

	/**
	 * This is the default constructor
	 */
	public QuitarDeStock() {
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
	    
		this.setSize(848, 347);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Muffin.png")));
		this.setContentPane(getJContentPane());
		this.setTitle("Quitar de Stock");
		metodosSql metodos=new metodosSql();
		metodos.llenarJtable(jTableElementos, "select * from materia_prima");
		jTableElementos.getTableHeader().setReorderingAllowed(false) ;
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(401, 8, 426, 27));
			jLabel1.setText("*Ésta opción impactará en sus ganancias, ya que se considerará pérdida.*");
			jLabelCantidadAquitar = new JLabel();
			jLabelCantidadAquitar.setBounds(new Rectangle(13, 253, 237, 29));
			jLabelCantidadAquitar.setText("Cantidad a quitar");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(13, 9, 384, 25));
			jLabel.setText("Seleccione un elemento del stock y luego indique cantidad a sacar");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(238, 172, 217));
			jContentPane.add(getJScrollPaneStock(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButtonQuitar(), null);
			jContentPane.add(getJTextFieldCantidad(), null);
			jContentPane.add(jLabelCantidadAquitar, null);
			jContentPane.add(jLabel1, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneStock	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneStock() {
		if (jScrollPaneStock == null) {
			jScrollPaneStock = new JScrollPane();
			jScrollPaneStock.setBounds(new Rectangle(12, 42, 806, 192));
			jScrollPaneStock.setViewportView(getJTableElementos());
		}
		return jScrollPaneStock;
	}

	/**
	 * This method initializes jTableElementos	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableElementos() {
		if (jTableElementos == null) {
			jTableElementos = new JTable();
		}
		return jTableElementos;
	}

	/**
	 * This method initializes jButtonQuitar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonQuitar() {
		if (jButtonQuitar == null) {
			jButtonQuitar = new JButton();
			jButtonQuitar.setBounds(new Rectangle(704, 276, 126, 36));
			jButtonQuitar.setText("Quitar");
			jButtonQuitar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
					int fila=jTableElementos.getSelectedRow();
					int columna=jTableElementos.getColumn("NOMBRE").getModelIndex();
					String nombre=(String) jTableElementos.getValueAt(fila,columna);
					MateriaPrima mat=new MateriaPrima();
					mat=(MateriaPrima) Hibernate.dameObjeto(nombre,mat);
					System.out.println(mat.getPrecioXumedida());
					float aQuitar=Float.parseFloat(jTextFieldCantidad.getText());
					mat.setCantidad(mat.getCantidad()-aQuitar);
					if(mat.getCantidad()>=0){
					Hibernate.modificarObjeto(mat);
					}else{
						int decision;
						decision=JOptionPane.showConfirmDialog(null,"El valor a quitar es superior al valor de stock, quiere eliminar el ítem por completo?");
						if(decision==0){
							int status=0;
							status=Hibernate.borrarObjeto(mat);
							if(status==1){
								JOptionPane.showMessageDialog(null,"Se ha borrado el elemento "+mat.getNombre());
							metodosSql metodos=new metodosSql();
							metodos.llenarJtable(jTableElementos, "select * from materia_prima");		
							
							}
							
							
						}
						else{
							JOptionPane.showMessageDialog(null,"No se realizaron cambios");
						}
					
					
					}
					metodosSql metodos=new metodosSql();
					metodos.llenarJtable(jTableElementos, "select * from materia_prima");
					}catch(ArrayIndexOutOfBoundsException e1){
						
						JOptionPane.showMessageDialog(null,"Seleccione un elemento de la tabla");
					}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null,"Complete el campo Cantidad a quitar");
					}catch(IllegalArgumentException i){
						JOptionPane.showMessageDialog(null,"No hay más elementos a quitar, agregue alguno");
						
					}
					
					
				}
				
			});
		}
		return jButtonQuitar;
	}

	/**
	 * This method initializes jTextFieldCantidad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCantidad() {
		if (jTextFieldCantidad == null) {
			jTextFieldCantidad = new JTextField();
			jTextFieldCantidad.setBounds(new Rectangle(251, 252, 204, 30));
			jTextFieldCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if(e.getKeyChar()=='-'){
						JOptionPane.showMessageDialog(null,"No se permite el signo *menos* sumará en vez de restar, si quiere agregar stock use la opción Agregar a Stock");
						jTextFieldCantidad.setText("");
					}
				}
			});
		}
		return jTextFieldCantidad;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
