

package util;
import org.hibernate.*;
import org.hibernate.cfg.*;

@SuppressWarnings("deprecation")
public class HibernateUtil {
private static final SessionFactory sessionFactory;
static {
try {
// Cree la SessionFactory para hibernate.cfg.xml
sessionFactory = new Configuration().configure().buildSessionFactory();
} catch (Throwable ex) {
// Asegúrese de loguear la excepción, dado que puede ser "tragada"
System.err.println("Initial SessionFactory creation failed." + ex);
throw new ExceptionInInitializerError(ex);
}
}
public static SessionFactory getSessionFactory() {
return sessionFactory;
}
}