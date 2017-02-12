/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.nikitainfo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Никита
 */
public class SaveOrder {

    public SaveOrder() {
    }
    public String saveNewOrder(String email,List<String> orders)
    {
        try {
            InitialContext init = new InitialContext();
            DataSource dataSource = (DataSource) init.lookup("jdbc/mypool");
            Connection con=dataSource.getConnection();
            String sql2 = "SELECT id_client FROM client WHERE email = ?";
            PreparedStatement state = con.prepareStatement(sql2);
            state.setString(1, email);
            ResultSet resultSet = state.executeQuery();
            resultSet.next();
            int mykey = resultSet.getInt("id_client");
           // resultSet.close();
            state.clearBatch();
            state.clearParameters();
            state.clearWarnings();
            //узнаем слудующий auto_increment
            String sql3 = "SHOW TABLE STATUS LIKE 'chek'";
            state = con.prepareStatement(sql3);
            ResultSet res2 =  state.executeQuery();
            res2.next();
            int incChek = res2.getInt("Auto_increment");
          //  res2.close();
            state.clearBatch();
            state.clearParameters();
            state.clearWarnings();
            
            
            //создаем чек
            Calendar c = Calendar.getInstance();
            java.sql.Timestamp ta = new Timestamp(c.getTimeInMillis());
            
            sql2 = "INSERT INTO chek(id_chek,date_begin,date_end) VALUES(?,?,?)";
            state = con.prepareStatement(sql2);
            state.setInt(1, incChek);
            state.setTimestamp(2, ta);
            state.setTimestamp(3, ta);
            state.execute();
            
            state.clearBatch();
            state.clearParameters();
            state.clearWarnings();
            
            
            //вставляем данные в таблицу товары
            for (String idpr:orders)
            {
                String sql = "INSERT INTO goods VALUES(?,?)";
                state = con.prepareStatement(sql);
                state.setInt(1, incChek);
                state.setInt(2, Integer.valueOf(idpr));
                state.execute();
                
                state.clearBatch();
                state.clearParameters();
                state.clearWarnings();
            }
                       
            //и наконец создаем новое дело, где сопоставляем чек и клиента
            sql2 = "INSERT INTO deal(id_chek,id_client) VALUES(?,?)";
            state = con.prepareStatement(sql2);
            state.setInt(1, incChek);
            state.setInt(2, mykey);
            state.execute();
            
            state.close();
            con.close();
            
            return "";
        } catch (NamingException ex) {
            Logger.getLogger(SaveOrder.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(SaveOrder.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
        
        
    }
}
