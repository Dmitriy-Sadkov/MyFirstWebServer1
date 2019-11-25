package DAO;

import dataSets.UserDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserDAO {
    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public UserDataSet get(long id) throws HibernateException {
        return (UserDataSet) session.get(UserDataSet.class, id);
    }

    public long getUserId(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(UserDataSet.class);
        return ((UserDataSet) criteria.add(Restrictions.eq("userName", name)).uniqueResult()).getId();
    }

    public long insertUser(String name,String password) throws HibernateException {
        return (Long) session.save(new UserDataSet(name,password));
    }
}
