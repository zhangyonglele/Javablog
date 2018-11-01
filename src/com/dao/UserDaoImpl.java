package com.dao;

import com.entity.Manager;
import com.util.DBconn;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    @Override
    public boolean login(String name, String password) {
        boolean flag = false;
        try {
            DBconn.init();
            //拼装sql语句
            ResultSet rs = DBconn.selectData("SELECT * FROM manager WHERE user_='" + name + "' AND password_='" + password + "'");
            //判断用户密码和用户名是否符合规则
            while (rs.next()) {
                if (rs.getString("user_").equals(name) && rs.getString("password_").equals(password))
                    flag = true;
            }
            DBconn.closeConn();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean register(Manager user) {
        boolean flag = false;
        try {
            DBconn.init();
            //拼装sql语句和执行实例化方法
            int i = DBconn.addUpDel("INSERT INTO manager(user_,password_,age,sex) " +
                    "VALUES('" + user.getUserName() + "','" + user.getPassword() + "','" + user.getAge() + "','" + user.getSex() + "')");
            if (i > 0) {
                flag = true;
            }
            DBconn.closeConn();
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }
/*
    @Override
    public List<Manager> getUserAll() {
        List<Manager> list = new ArrayList<Manager>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectData("SELECT * FROM manager");
            while (rs.next()){
                Manager manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setUserName(rs.getString("user_"));
                manager.setAge(rs.getString("age"));
                manager.setSex(rs.getString("sex"));
                manager.setPassword(rs.getString("password_"));
                list.add(manager);
            }
            DBconn.closeConn();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            DBconn.init();
            String sql = "DELETE FROM manager WHERE id='" + id + "'";
            int i = DBconn.addUpDel(sql);
            if (i > 0){
                flag = true;
            }
            DBconn.closeConn();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(int id,String param,String data) {
        boolean flag = false;
        try {
            DBconn.init();
            String sql = "UPDATE manager SET " + param + "='" + data + "' WHERE id=" + id;
            int i = DBconn.addUpDel(sql);
            if (i > 0){
                flag = true;
            }
            DBconn.closeConn();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    */
}
