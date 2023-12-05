
package configuration;

import dao.BukuDaoImpl;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import dao.BukuDao;

public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY;
    private static final BukuDao BUKU_DAO;
    static {
        try {
           SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
           BUKU_DAO = new BukuDaoImpl(SESSION_FACTORY);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
    
    public static BukuDao getBukuDao() {
        return BUKU_DAO;
    }
}