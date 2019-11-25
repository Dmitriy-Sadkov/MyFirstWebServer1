package dbService;

import org.hibernate.HibernateException;

public class DBException extends Exception {
    public DBException(Throwable message) {
        super(message);
    }
}
