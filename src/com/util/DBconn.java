package com.util;


import java.sql.*;

public class DBconn {

    private static final String url = "jdbc:mysql://localhost:3306/bigtest?serverTimezone=GMT%2B8";

    private static final String user = "root";

    private static final String password = "168168";

    private static Connection conn = null;

    private static ResultSet rs = null;

    private static PreparedStatement ps = null;

    public static void init(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            System.out.println("mysql驱动初始化失败");
            e.printStackTrace();
        }
    }
    public static int addUpDel(String sql){
        int number = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            number = ps.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println("数据库增加/删除异常");
            e.printStackTrace();
        }
        return number;
    }

    public static void creatSheet(String sheet){
        try{
            String sql = "CREATE TABLE IF NOT EXISTS " + sheet +"(" +
                    "id INT(7) UNSIGNED AUTO_INCREMENT PRIMARY KEY," +
                    "user_ VARCHAR(15) NOT NULL UNIQUE ," +
                    "password_ VARCHAR(60) NOT NULL ," +
                    "sex VARCHAR (10) NOT NULL ," +
                    "age VARCHAR (10) NOT NULL " +
                    ")ENGINE = InnoDb DEFAULT CHARSET = utf8";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static ResultSet selectData(String sql){
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
        }catch (SQLException e){
            System.out.println("数据库sql查询失败");
            e.printStackTrace();
        }
        return rs;
    }



    public static void closeConn(){
        try {
            conn.close();
        }catch (SQLException e){
            System.out.println("sql数据库关闭异常");
            e.printStackTrace();
        }
    }


}
