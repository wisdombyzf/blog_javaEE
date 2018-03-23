package factory;

import dao.UserDAO;
import dao.impl.UserDAOimpl;

import java.sql.Connection;

public class DAOFactory
{
    public static UserDAO getUserDAOInstance(Connection connection)
    {
        return new UserDAOimpl(connection);
    }
}
