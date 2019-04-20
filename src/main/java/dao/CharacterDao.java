package dao;

/**
 * Created by Bill on 20.04.2019.
 */
public class CharacterDao {
    public CharacterDao () {}
/*
    public Character findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Character.class, id);
    }

    public void save(Character cha) {
        try {
            //Открываю сессию для передачи данных
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            //Получаю из этой сессии транзакцию
            Transaction tx1 = session.beginTransaction();
            //Что то делаю
            session.save(cha);
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

    public void update(Character cha) {
        try {Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(cha);
            tx1.commit();
            session.close(); }
        catch (Exception e) {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
            Transaction tx1 = session.getTransaction();
            tx1.rollback();
            session.close();
        }
    }

    public void delete(Character cha) {
        try {Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(cha);
            tx1.commit();
            session.close(); }
        catch (Exception e) {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
            Transaction tx1 = session.getTransaction();
            tx1.rollback();
            session.close();
        }
    }

    public List<Character> showAll() {
        try {Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            List<Character> list = (List<Character>) session.createQuery("From "+Character.class.getSimpleName()).list();
            session.close();
            return list;}
            */
}
