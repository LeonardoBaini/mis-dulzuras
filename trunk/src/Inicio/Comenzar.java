package Inicio;





import java.awt.Component;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import persistencia.Hibernate;
import sun.util.calendar.LocalGregorianCalendar.Date;




import Base.ConexionMySql;
import Base.metodosSql;
import ObjetosNoPersistentes.Aviso;
import ObjetosPersistentes.Venta;
import Pantallas.InfoFaltantes;
import Pantallas.PantallaPpal;

public class Comenzar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//	Hibernate.test();
		PantallaPpal pan=new PantallaPpal();
		
		
		pan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		pan.setVisible(true);
	
		ConexionMySql con=new ConexionMySql();
		if(con.conectar()==1){
			
			pan.setTitle("Mis Dulzuras");
			 URL urlDeLaImagen = Comenzar.class.getClassLoader().getResource("Imagenes/Muffin.png");
			 ImageIcon icon = new ImageIcon(urlDeLaImagen);

			

		    Component dialog = null;
		   // JOptionPane.showMessageDialog(dialog, "Blah blah blah", "Hello!", JOptionPane.WARNING_MESSAGE, icon);
			JOptionPane.showMessageDialog(dialog,null,"Bienvenida!", JOptionPane.WARNING_MESSAGE, icon);
			//this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Muffin.png")));
			//JOptionPane.showMessageDialog(null,"PRUEBA DE CONEXIÓN OK, CONECTADO A "+con.getHost().toUpperCase()+" BASE DE DATOS -> "+con.getBase().toUpperCase());
			if(Aviso.avisar().size()>0){
				InfoFaltantes info=new InfoFaltantes();
				info.setLocationRelativeTo(null);
				info.setVisible(true);
				
				
			}
			
			
		
		}else{
			
			pan.setTitle("Mis Dulzuras                                  					    			PRUEBA DE CONEXIÓN FALLIDA, REINTENTE");
			JOptionPane.showMessageDialog(null,"Asegurese que responda el ping a "+con.getHost()+"; telnet al puerto 3306 ; el proceso mysqld.exe esté corriendo; que la base se llame, misdulzuras.\n" +
					"; que el usuario y pass sea correcto, luego reintente" );
			
			pan.dispose();
			
		
		}
		
		
		
		
		
		
		
		
	}

}
