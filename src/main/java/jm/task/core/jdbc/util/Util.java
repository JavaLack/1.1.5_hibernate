package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import javax.imageio.spi.ServiceRegistry;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static SessionFactory sessionFactory;


    // реализуйте настройку соеденения с БД

    private static final String URL = "jdbc:mysql://localhost:3306/data_basa";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "MagomedKhanKadirov1488";
    private static final String DIALECT = "org.hibernate.dialect.MySQLDialect";
    private static final String SHOW_SQL = "true";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String CURRENT_SESSION_CONTEXT_CLASS = "thread";
    private static final String HBM2DDL_AUTO = "create-drop";



    public static Connection getConnect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено");
            }
        } catch (SQLException e) {
            System.err.println("не удалось загрузить драйвер");
        }
        return connection;
    }



    static {
        try {
            sessionFactory = new Configuration().addAnnotatedClass(User.class).buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
