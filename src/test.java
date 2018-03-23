import VO.User;
import dao.DatabaseConnection;
import dao.UserDAO;
import factory.DAOFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class test
{
    public static void main(String[] args)
    {
        User vo=null;
        DatabaseConnection databaseConnection =new DatabaseConnection();
        Connection connection= databaseConnection.getConnection();
        UserDAO userDAO= DAOFactory.getUserDAOInstance(connection);
        try
        {
            vo=userDAO.findById("love");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        System.out.println(vo.getName());
    }

}
