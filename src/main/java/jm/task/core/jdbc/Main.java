package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
//        Util.getConnect();
        UserDao userDao = new UserDaoHibernateImpl();

        userDao.cleanUsersTable();
        userDao.createUsersTable();

        userDao.saveUser("User1", "LastName1", (byte) 19);
        userDao.saveUser("User2", "LastName2", (byte) 33);
        userDao.saveUser("User3", "LastName3", (byte) 24);
        userDao.saveUser("User4", "LastName4", (byte) 45);

        userDao.getAllUsers().forEach(System.out::println);
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
