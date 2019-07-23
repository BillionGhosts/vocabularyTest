package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

/**
 * Created by Bill on 20.04.2019.
 */
public class EntityDao<T> {

    private T entity;


    public EntityDao() {}

    public EntityDao(T ob){
        this.entity = ob;
    }

    public T findById(int id) {
        return (T) HibernateSessionFactoryUtil.getSessionFactory().openSession().get(entity.getClass(), id);
    }

    public void save() {
        try {
            //Открываю сессию для передачи данных
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            //Получаю из этой сессии транзакцию
            Transaction tx1 = session.beginTransaction();
            //Что то делаю
            session.save(entity);
            //В транзакции делаю коммит
            tx1.commit();
            //Закрываю сессию
            session.close(); } catch (Exception e) {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
            Transaction tx1 = session.getTransaction();
            tx1.rollback();
            session.close();
        }
    }

    public void update() {
        try {Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(entity);
            tx1.commit();
            session.close(); }
        catch (Exception e) {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
            Transaction tx1 = session.getTransaction();
            tx1.rollback();
            session.close();
        }
    }

    public void delete() {
        try {Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(entity);
            tx1.commit();
            session.close(); }
        catch (Exception e) {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
            Transaction tx1 = session.getTransaction();
            tx1.rollback();
            session.close();
        }
    }

    public List<T> showAll() {
        try {Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            List<T> list = (List<T>) session.createQuery("From "+entity.getClass().getSimpleName()).list();
            session.close();
            return list; }
        catch (Exception e) {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
            session.close();
            return null;
        }
    }
}
