package com.dao;

import com.entity.Manager;

import java.util.List;

public interface UserDao {
    public boolean login(String name,String password);
    public boolean register(Manager user);
 //   public List<Manager> getUserAll();
   // public boolean delete(int id);
    
   // public boolean update(int id,String param,String data);
}
