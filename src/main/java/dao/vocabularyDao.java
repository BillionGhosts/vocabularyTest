package dao;

import models.Vocabulary;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

/**
 * Created by Bill on 14.04.2019.
 */
public class vocabularyDao extends  EntityDao{

    public vocabularyDao() {}

    /*
    public Vocabulary findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Vocabulary.class, id);
    }

    public void save(Vocabulary vocabulary) {
        try {
        //Открываю сессию для передачи данных
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        //Получаю из этой сессии транзакцию
        Transaction tx1 = session.beginTransaction();
        //Что то делаю
        session.save(vocabulary);
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

    public void update(Vocabulary voc) {
        try {Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(voc);
        tx1.commit();
        session.close(); }
        catch (Exception e) {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
            Transaction tx1 = session.getTransaction();
            tx1.rollback();
            session.close();
        }
    }

    public void delete(Vocabulary voc) {
        try {Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(voc);
        tx1.commit();
        session.close(); }
        catch (Exception e) {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
            Transaction tx1 = session.getTransaction();
            tx1.rollback();
            session.close();
        }
    }

    public List<Vocabulary> showAll() {
        try {Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
           List<Vocabulary> list = (List<Vocabulary>) session.createQuery("From "+Vocabulary.class.getSimpleName()).list();
            session.close();
            return list;

        }
        catch (Exception e) {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
            session.close();
            return null;
        }
    }*/

    public List<Vocabulary> firstLetterQuery(char first) {
        try {Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            List<Vocabulary> list = (List<Vocabulary>) session.createQuery("From "+Vocabulary.class.getSimpleName()+" AS voc " +
                                                                           "WHERE voc.word LIKE CONCAT(:firstLetter, '%')").setParameter("firstLetter", first).list();
            session.close();
            return list;

        }
        catch (Exception e) {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
            session.close();
            return null;
        }
    }


}
