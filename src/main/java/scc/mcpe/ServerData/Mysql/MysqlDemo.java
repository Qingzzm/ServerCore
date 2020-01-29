package scc.mcpe.ServerData.Mysql;

import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MysqlDemo {
    private String driver = "com.mysql.jdbc.Driver";
    final String url;
    final String user;
    final String password;
    private Statement statement;
    private ScheduledExecutorService oraclePool = Executors.newScheduledThreadPool(1);

    public MysqlDemo(String ip, int port, String database, String user, String password) {
        this.url = "jdbc:mysql://" + ip + ":" + port + "/" + database;
        this.user = user;
        this.password = password;

    }

    public void Connection() {
        /*
        加载驱动程序
         */
        try {
            Class.forName(this.driver);
            System.out.println("MYSQL驱动加载成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*
        链接数据库
         */
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(this.url, this.user, this.password);
            if (!connection.isClosed()) {
                System.out.println("数据库连接成功！");
                this.statement = connection.createStatement();
            } else {
                System.out.println("数据库连接失败！");
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败！ 错误: " + e.getMessage());
        }
     oraclePool.scheduleAtFixedRate(new MoniorThread(),0,10, TimeUnit.SECONDS);
    }

    /*
    执行sql语句
     */
    public void executeSql(String sql) {
        try {
            this.statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    查询SQL语句
     */
    public ResultSet querySql(String sql) {
        ResultSet res = null;
        try {
            return this.statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    args 需要的参数
     */
    public HashMap<String, String> getRsults(String table_name, String[] args) {
        try {
            ResultSet set = this.querySql("select * from "+table_name);
            if (!set.next()) return null;
            HashMap map = new HashMap<String, String>();
            for (String arg : args ) {
                map.put(arg, set.getString(arg));
            }
            return map;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    获取指定一个值
     */
    public String getResult(String sql) {
        try {
            ResultSet set = this.querySql(sql);
            if (!set.next()) return null;
            return set.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}


