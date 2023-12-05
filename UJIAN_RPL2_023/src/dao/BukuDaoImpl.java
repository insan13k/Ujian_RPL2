
package dao;

import java.util.List;
import model.Buku;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BukuDaoImpl implements BukuDao {
    private final SessionFactory sessionFactory;
    
    public BukuDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    public void save(Buku buku){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(buku);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    public void update(Buku buku) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(buku);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    public void delete(Buku buku) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(buku);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    public Buku getBuku(String idBuku) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Buku buku = (Buku) session.get(Buku.class, idBuku);
            session.getTransaction().commit();
            return buku;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    public List<Buku> getBukus() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List<Buku> bukus = session.createCriteria(Buku.class).list();
            session.getTransaction().commit();
            return bukus;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }
}