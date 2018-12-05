package org.vironit.timoshuk.computershop.DAO;

import org.hibernate.HibernateException;

public class DBException extends HibernateException {
    public DBException(String message) {
        super(message);
    }

    public DBException(Throwable cause) {
        super(cause);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}
