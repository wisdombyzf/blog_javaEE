package dao.impl;

import VO.User;
import dao.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOimpl implements UserDAO
{
    private Connection con;

    ///PreparedStatement对象。。。具体操作还要好好学习
    private PreparedStatement preparedStatement;
    public UserDAOimpl(Connection connection)
    {
        this.con=connection;
    }
    /**
     * @param vo 要增加内容的vo对象
     * @return 成功返回true
     * @brief 创建一个新用户
     */
    @Override
    public boolean doCreate(User vo) throws SQLException
    {
        String sql = "INSERT INTO user(id,name,password) VALUES (?,?,?)" ;
        this.preparedStatement=this.con.prepareStatement(sql);
        this.preparedStatement.setString(1,vo.getId());
        this.preparedStatement.setString(2,vo.getName());
        this.preparedStatement.setString(3,vo.getPassword());
        return this.preparedStatement.executeUpdate()>0;
    }

    /**
     * @param vo 要修改内容的vo对象
     * @return 成功返回true
     * @brief 修改一位用户的信息
     */
    @Override
    public boolean doUpdata(User vo) throws SQLException
    {
        String sql = "UPDATE user SET id=?,name=?,password=?" ;
        this.preparedStatement=this.con.prepareStatement(sql);
        this.preparedStatement.setString(1,vo.getId());
        this.preparedStatement.setString(2,vo.getName());
        this.preparedStatement.setString(3,vo.getPassword());
        return this.preparedStatement.executeUpdate()>0;
    }

    /**
     * @param id 要删除的对象
     * @return 成功返回true
     * @brief 删除一位用户的信息
     */
    @Override
    public boolean doRemove(String id)
    {
        return false;
    }

    /**
     * @param id 要查询的对象
     * @return 返回该对象
     * @brief 根据id查询用户信息
     */
    @Override
    public User findById(String id) throws SQLException
    {
        User vo=null;
        String sql = "SELECT id,name,password FROM user WHERE id=?" ;
        this.preparedStatement=this.con.prepareStatement(sql);
        this.preparedStatement.setString(1,id);
        ResultSet resultSet=this.preparedStatement.executeQuery();
        if (resultSet.next())
        {
            vo=new User();
            vo.setId(id);
            vo.setName(resultSet.getString("name"));
            vo.setPassword(resultSet.getString("password"));
        }
        return vo;
    }
}
