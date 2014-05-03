package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.GenericJDBCException;

import Base.metodosSql;

import util.HibernateUtil;


@SuppressWarnings("unused")
public class Hibernate {	
	/** 
	 * Ejemplo de uso
	 * 	int  id=12;
		ComoMitigar comom =new ComoMitigar();
		comom=(ComoMitigar) Hibernate.dameObjeto(id,comom);
		
		;
		System.out.println(comom.getDescripcionOk());
		
	 */
	
	public static Object dameObjeto(Object id, Object objeto){
		Object como=null;
			
			
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession();//openSession();//getCurrentSession();
			 
			 

		    try 
		    { 
		    	session.beginTransaction();
		        como =  session.get(objeto.getClass(), (Serializable) id); 
		    } finally 
		    { 
		        session.close(); 
		    }  
		
		    
		  
		    
		return como;
	}
	private static void publicarMensajes(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static int guardarObjeto(Object objeto){
		int status=0;
		final Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			
		session.beginTransaction();
		
		session.save(objeto);
				
		session.getTransaction().commit();
		status=1;
		
		System.out.println("Guardado ok");
		}catch(SessionException e){
			System.out.println("Error desde consola "+e.getMessage());
			publicarMensajes("Error desde consola "+e.getMessage());
		session.getTransaction().rollback();	
		
		status=0;
			
		}catch( HibernateException Gen){
			
			publicarMensajes(Gen.getLocalizedMessage());
			session.getTransaction().rollback();
			return 0;
		}
		HibernateUtil.getSessionFactory().getCurrentSession().close();
		return status;
		
	}
	public static int modificarObjeto(Object objeto){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			
		session.beginTransaction();
		
		session.update(objeto);
				
		session.getTransaction().commit();
		return 1;
		}catch(Exception e){
		session.getTransaction().rollback();	
		return 0;
			
		}
		
		
	}
	public static int borrarObjeto(Object objeto){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			
		session.beginTransaction();
		
		session.delete(objeto);
				
		session.getTransaction().commit();
		return 1;
		}catch(Exception e){
		session.getTransaction().rollback();	
		return 0;
		}
		
		
	}
	public static ArrayList<Object>DameListaDeObjetos(String select1ColumaDeIdFromTabla,Object objeto){
		ArrayList<Object>objetos=new ArrayList<Object>();
		ArrayList<String>primaryKeys=null;
		metodosSql metodos=new metodosSql();
		primaryKeys=metodos.consultarUnaColumna(select1ColumaDeIdFromTabla);
		for(int i=0;i<primaryKeys.size();i++){
			String id=primaryKeys.get(i);
			objetos.add(dameObjeto(id, objeto));
			
		}
		
		
		
		
		return objetos;
		
	}
	
	

}
