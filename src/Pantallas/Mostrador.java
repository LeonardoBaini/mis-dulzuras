package Pantallas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.UIManager;

import Base.metodosSql;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;

@SuppressWarnings("unused")
public class Mostrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelProductos = null;
	private JScrollPane jScrollPaneMostrador = null;
	private JTable jTableMostrador = null;
	private JButton jButtonVender = null;
	private JButton jButtonMermar = null;
	private JLabel jLabelAcobrar = null;
	private JLabel jLabelCantidadAcobrar = null;
	private JLabel jLabeleLEMENTOS = null;
	private JLabel jLabelCantElementos = null;
	private JLabel jLabelGanancia = null;
	private JLabel jLabelReposicion = null;
	private JLabel jLabelGanancias = null;
	private JLabel jLabelReposiciones = null;
	private JPanel jPanelInfo = null;

	/**
	 * This is the default constructor
	 */
	public Mostrador() {
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
		this.setSize(903, 359);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Muffin.png")));
		this.setContentPane(getJContentPane());
		this.setTitle("Mostrador");
		metodosSql metodos=new metodosSql();
		metodos.llenarJtable(jTableMostrador, "select * from mostrador");
		jTableMostrador.getTableHeader().setReorderingAllowed(false) ;
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelReposiciones = new JLabel();
			jLabelReposiciones.setText("");
			jLabelReposiciones.setBounds(new Rectangle(166, 99, 154, 24));
			jLabelGanancias = new JLabel();
			jLabelGanancias.setText("");
			jLabelGanancias.setBounds(new Rectangle(166, 73, 154, 22));
			jLabelReposicion = new JLabel();
			jLabelReposicion.setText("Reposición");
			jLabelReposicion.setBounds(new Rectangle(9, 100, 154, 23));
			jLabelGanancia = new JLabel();
			jLabelGanancia.setText("Ganancia");
			jLabelGanancia.setBounds(new Rectangle(9, 73, 153, 21));
			jLabelCantElementos = new JLabel();
			jLabelCantElementos.setText("");
			jLabelCantElementos.setBounds(new Rectangle(166, 16, 154, 23));
			jLabeleLEMENTOS = new JLabel();
			jLabeleLEMENTOS.setText("Elementos seleccionados");
			jLabeleLEMENTOS.setBounds(new Rectangle(9, 16, 154, 22));
			jLabelCantidadAcobrar = new JLabel();
			jLabelCantidadAcobrar.setText("");
			jLabelCantidadAcobrar.setBounds(new Rectangle(166, 46, 154, 22));
			jLabelAcobrar = new JLabel();
			jLabelAcobrar.setText("Suma total de dinero");
			jLabelAcobrar.setBounds(new Rectangle(9, 47, 154, 21));
			jLabelProductos = new JLabel();
			jLabelProductos.setBounds(new Rectangle(6, 4, 390, 27));
			jLabelProductos.setText("Muestra el listado de productos elaborados con sus carácteristicas");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(238, 176, 221));
			jContentPane.add(jLabelProductos, null);
			jContentPane.add(getJScrollPaneMostrador(), null);
			jContentPane.add(getJButtonVender(), null);
			jContentPane.add(getJButtonMermar(), null);
			jContentPane.add(getJPanelInfo(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneMostrador	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneMostrador() {
		if (jScrollPaneMostrador == null) {
			jScrollPaneMostrador = new JScrollPane();
			jScrollPaneMostrador.setBounds(new Rectangle(6, 35, 888, 131));
			jScrollPaneMostrador.setViewportView(getJTableMostrador());
		}
		return jScrollPaneMostrador;
	}

	private void darInfo(){
		try{
		float aCobrar=0;
		
		float reposicion = 0;
		int [] rows=jTableMostrador.getSelectedRows();
		for(int i=0;i<rows.length;i++){
		aCobrar=aCobrar+Float.parseFloat(jTableMostrador.getValueAt(rows[i], jTableMostrador.getColumn("PRECIOVENTAXUNIDAD").getModelIndex()).toString());
		reposicion=reposicion+Float.parseFloat(jTableMostrador.getValueAt(rows[i], jTableMostrador.getColumn("DINERO_A_REPONER").getModelIndex()).toString());
		
		}
		jLabelCantidadAcobrar.setText(String.valueOf(aCobrar));
		jLabelCantElementos.setText(String.valueOf(rows.length));
		jLabelGanancias.setText(String.valueOf(aCobrar-reposicion));
		jLabelReposiciones.setText(String.valueOf(reposicion));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error, no cambie las columnas de lugar");
			dispose();
			Mostrador m=new Mostrador();
			m.setVisible(true);
			
		}
	}
	/**
	 * This method initializes jTableMostrador	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableMostrador() {
		if (jTableMostrador == null) {
			jTableMostrador = new JTable();
			jTableMostrador.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseReleased(java.awt.event.MouseEvent e) {
				darInfo();
				}
			});
			jTableMostrador.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
				darInfo();
				}
			});
			
			
		}
		return jTableMostrador;
	}

	/**
	 * This method initializes jButtonVender	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonVender() {
		if (jButtonVender == null) {
			jButtonVender = new JButton();
			jButtonVender.setBounds(new Rectangle(14, 185, 175, 39));
			jButtonVender.setText("Vender");
			jButtonVender.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int [] rows=jTableMostrador.getSelectedRows();
					for(int i=0;i<rows.length;i++){
						System.out.println(rows[i]);
					}
				}
			});
		}
		return jButtonVender;
	}

	/**
	 * This method initializes jButtonMermar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonMermar() {
		if (jButtonMermar == null) {
			jButtonMermar = new JButton();
			jButtonMermar.setBounds(new Rectangle(14, 231, 175, 39));
			jButtonMermar.setText("Mermar");
		}
		return jButtonMermar;
	}

	/**
	 * This method initializes jPanelInfo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelInfo() {
		if (jPanelInfo == null) {
			jPanelInfo = new JPanel();
			jPanelInfo.setLayout(null);
			jPanelInfo.setBounds(new Rectangle(556, 179, 331, 143));
			jPanelInfo.setBackground(new Color(238, 221, 134));
			jPanelInfo.setBorder(BorderFactory.createTitledBorder(null, "Info", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			jPanelInfo.add(jLabeleLEMENTOS, null);
			jPanelInfo.add(jLabelCantElementos, null);
			jPanelInfo.add(jLabelAcobrar, null);
			jPanelInfo.add(jLabelCantidadAcobrar, null);
			jPanelInfo.add(jLabelGanancia, null);
			jPanelInfo.add(jLabelGanancias, null);
			jPanelInfo.add(jLabelReposicion, null);
			jPanelInfo.add(jLabelReposiciones, null);
		}
		return jPanelInfo;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
