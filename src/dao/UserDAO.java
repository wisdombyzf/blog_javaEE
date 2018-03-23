package dao;

import VO.User;

import java.sql.SQLException;

public interface UserDAO
{
    /**
     * @brief 创建一个新用户
     * @param vo 要增加内容的vo对象
     * @return 成功返回true
     */
    boolean doCreate(User vo) throws SQLException;

    /**
     * @brief 修改一位用户的信息
     * @param vo 要修改内容的vo对象
     * @return 成功返回true
     */
    boolean doUpdata(User vo) throws SQLException;

    /**
     * @brief 删除一位用户的信息
     * @param id 要删除的对象
     * @return 成功返回true
     */
    boolean doRemove(String id);

    /**
     * @brief 根据id查询用户信息
     * @param id 要查询的对象
     * @return 返回该对象
     */
    User findById(String id) throws SQLException;
}
