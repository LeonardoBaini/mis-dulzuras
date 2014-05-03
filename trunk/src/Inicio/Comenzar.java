package Inicio;

import javax.swing.JFrame;
import javax.swing.JOptionPane;




import Base.ConexionMySql;
import Pantallas.PantallaPpal;

public class Comenzar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PantallaPpal pan=new PantallaPpal();
		
		
		pan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		pan.setVisible(true);
	
		ConexionMySql con=new ConexionMySql();
		if(con.conectar()==1){
			
			pan.setTitle("Mis Dulzuras");
			JOptionPane.showMessageDialog(null,"PRUEBA DE CONEXIÓN OK, CONECTADO A "+con.getHost().toUpperCase()+" BASE DE DATOS -> "+con.getBase().toUpperCase());
			
			
			
		
		}else{
			
			pan.setTitle("Shiteck                                  					    			PRUEBA DE CONEXIÓN FALLIDA, REINTENTE");
			JOptionPane.showMessageDialog(null,"Asegurese que responda el ping a "+con.getHost()+"; telnet al puerto 3306 ; el proceso mysqld.exe esté corriendo; que la base se llame, shiteckhibernate.\n" +
					"; que el usuario y pass sea correcto, luego reintente" );
			
			pan.dispose();
			
		
		}
		
		
		
	}

}
