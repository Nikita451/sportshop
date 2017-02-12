/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.nikitainfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Никита
 */
public class Users {

    int user_group = 1; // номер группы пользователи
    
    public Users() {
    }
    
 //   @Resource(name = "jdbc/mypool")
 //   DataSource dataSource;
    
    public int addNewUser(String name,String sername,String email,String password) throws NamingException
    {
        String sql = "INSERT INTO client(sername,name,email,password) VALUES(?,?,?,?)";
        InitialContext init = new InitialContext();
        DataSource dataSource = (DataSource) init.lookup("jdbc/mypool");
        
        try {
            Connection con=dataSource.getConnection();
            
            PreparedStatement state=con.prepareStatement(sql);
            state.setString(1, sername);
            state.setString(2,name);
            state.setString(3, email);
            state.setString(4, password);
            
            boolean flag = state.execute();
            state.clearBatch();
            state.clearParameters();
            state.clearWarnings();
           
               String sql2 = "SELECT id_client FROM client WHERE email = ?";   
               state = con.prepareStatement(sql2);
               state.setString(1, email);
               ResultSet resultSet = state.executeQuery();
               resultSet.next();
               int mykey = resultSet.getInt("id_client");
               
               state.clearBatch();
               state.clearParameters();
               state.clearWarnings();
               
               
               String sql3 = "INSERT INTO user_groups(user_id,group_id) VALUES(?,?)";
               
               state = con.prepareStatement(sql3);
               state.setInt(1, mykey);
               state.setInt(2, user_group);
               state.execute();
               
               
               resultSet.close();
               state.close();
               con.close();
               
               return mykey;
           
            
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
}
