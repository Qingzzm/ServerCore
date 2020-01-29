package scc.mcpe.ServerData.Mysql;

import scc.mcpe.ServerPlugin.Core;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MoniorThread implements Runnable {
    public void run() {
        try {
            //System.out.println("MonitorThread~~~~~~~~~~~~~!!!!");
            String sql = "select 1 from dual";
            ResultSet resultSet = Core.mysql.querySql(sql);
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
           System.out.println("数据库连接中断，尝试重连" + e.getMessage());
            Core.mysql.Connection();
        }

    }
}

