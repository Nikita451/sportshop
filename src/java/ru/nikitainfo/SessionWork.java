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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Никита
 */
public class SessionWork {

    private DataSource dataSource;
    Connection con;
    int id;
    static  int MY_TIMEOUT = 10000;
    //заполняются только при добавлении пользователя в сессию
    String user_name;
    String user_sername;
    public SessionWork() {
        this.user_name = "";
        this.user_sername = "";
    }
    
    public void createConnection()
    {
        try {
            InitialContext init = new InitialContext();
            dataSource = (DataSource)init.lookup("jdbc/mypool");
            con = dataSource.getConnection();
            
            
            
        } catch (NamingException ex) {
            Logger.getLogger(SessionWork.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SessionWork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean addUserToSession(String sess_id,String email)
    {
        String sql = "SELECT id_client as id,sername,name FROM client WHERE email = ?";
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, email);
            ResultSet result = pr.executeQuery();
            result.next();
            int id_client = result.getInt("id");
            this.user_sername = result.getString("sername");
            this.user_name = result.getString("name");
            this.id = id_client;
            result.close();
            pr.clearBatch();
            pr.clearParameters();
            pr.clearWarnings();
            
            Calendar c = Calendar.getInstance(new Locale("ru"));
            
            sql = "INSERT INTO session VALUES(?,?,?)";
            pr =  con.prepareStatement(sql);
            pr.setString(1, sess_id);
            pr.setInt(2, id_client);
            pr.setTimestamp(3, new java.sql.Timestamp(c.getTimeInMillis()));
            pr.executeUpdate();
            
            
            pr.close();
            
            
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SessionWork.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public String getUser_name()
    {
        return this.user_name;
    }
    
    public String getUser_sername()
    {
        return this.user_sername;
    }
    
    public void updateSession(String sess_id)
    {
        
        Calendar c = Calendar.getInstance(new Locale("ru"));
        long t = c.getTimeInMillis();
        try {
            //обновляем сессию для текущего пользователя
            String sql = "UPDATE session SET last_request=? WHERE session_id=?";
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setTimestamp(1, new java.sql.Timestamp(t));
            pr.setString(2, sess_id);
            pr.executeUpdate();
            
            pr.clearBatch();
            pr.clearParameters();
            pr.clearWarnings();
            
            sql = "DELETE FROM session WHERE last_request < ?";
            pr = con.prepareStatement(sql);
            pr.setTimestamp(1, new java.sql.Timestamp(t-SessionWork.MY_TIMEOUT));
            pr.executeUpdate();
            
            pr.close();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SessionWork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<UserSession> getUsersInSession()
    {
        try {
            String sql = "SELECT sername,name FROM session JOIN client ON client.id_client=session.id_client";
            ArrayList<UserSession> list = new ArrayList<UserSession>();
            
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet result =  pr.executeQuery();
            
            while(result.next())
            {
                UserSession us = new UserSession();
                us.setSername(result.getString("sername"));
                us.setName(result.getString("name"));
                list.add(us);
            }
            
            result.close();
            pr.close();
            
            
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(SessionWork.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void stopConnection() throws SQLException
    {
        this.con.close();
    }
}
