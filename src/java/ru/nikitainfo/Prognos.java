/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.nikitainfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Никита
 */
public class Prognos {

    
    public Prognos() {
    }
    
    ArrayList<OnePrognos> progs = new ArrayList<OnePrognos>();
    public boolean addPrognos(ArrayList<String> pars) throws FileNotFoundException
    {
        String sql = "INSERT INTO prognos(id_type_prognos,event,prognos,price,date_event,kef,foto1,foto2,foto3) "
                + " VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            InitialContext init = new InitialContext();
            DataSource dataSource = (DataSource) init.lookup("jdbc/mypool");
            Connection con = dataSource.getConnection();
            PreparedStatement pr =  con.prepareStatement(sql);
             pr.setInt(1,Integer.valueOf(pars.get(0)));
             for (int i=2;i<=9;i++)
             {
                 if (i!=4)
                    pr.setString(i, pars.get(i-1));
                 else 
                     pr.setInt(i,Integer.valueOf(pars.get(i-1)));
             }
             
               pr.execute();
               pr.close();
               con.close();
               
             return true;
             
        } catch (NamingException ex) {
            Logger.getLogger(Prognos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Prognos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
    
    public void setProgs()
    {
        
    }
    
    public ArrayList<OnePrognos> getProgs()
    {
        try {
            String sql ="SELECT * FROM prognos";
            InitialContext init = new InitialContext();
            DataSource dataSource = (DataSource) init.lookup("jdbc/mypool");
            Connection con = dataSource.getConnection();
            PreparedStatement pr =  con.prepareStatement(sql);
            ResultSet res =  pr.executeQuery();
            
            while (res.next())
            {
                OnePrognos prog = new OnePrognos();
                prog.setId(res.getInt(1));
                 prog.setType(res.getInt(2));
                 prog.setEvent(res.getString(3));
                 prog.setPrognos(res.getString(4));
                 prog.setPrice(res.getInt(5));
                 prog.setDate_event(res.getString(6));
                 prog.setKef(res.getString(7));
                 prog.setFoto1(res.getString(8));
                 prog.setFoto2(res.getString(9));
                 prog.setFoto3(res.getString(10));
                 progs.add(prog);
            }
            
            res.close();
            pr.close();
            con.close();
            
            return progs;
            
        } catch (NamingException ex) {
            Logger.getLogger(Prognos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Prognos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
