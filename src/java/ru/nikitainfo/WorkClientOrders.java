/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.nikitainfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
public class WorkClientOrders implements Serializable{
    ArrayList<ClientOrders> orders = new ArrayList<ClientOrders>();

    public WorkClientOrders() {
    }
    
    
    
    public void setOrders(ClientOrders buffer)
    {
        
    }
    
    public ArrayList<ClientOrders> getOrders()
    {
        try {
            String sql = "SELECT id_deal,id_chek,date_begin,name,sername,email FROM orders1 ORDER BY id_deal DESC";
            String sql2 = "SELECT event,kef,prognos,date_event,price,name_prognos FROM orders2 WHERE id_chek=?";
            InitialContext init = new InitialContext();
            DataSource dataSource = (DataSource) init.lookup("jdbc/mypool");
            Connection con=dataSource.getConnection();
            PreparedStatement ps =  con.prepareStatement(sql);
            ResultSet result =  ps.executeQuery();
            PreparedStatement ps2;
            
            while(result.next())
            {
                //вытаскиваем простые данные
                ClientOrders clientOrders = new ClientOrders();
                clientOrders.setId_deal(result.getInt("id_deal"));
                int id_chek = result.getInt("id_chek");
                clientOrders.setId_chek(id_chek);
                clientOrders.setName(result.getString("name"));
                clientOrders.setSername(result.getString("sername"));
                clientOrders.setEmail(result.getString("email"));
                
                //вытаскиваем дату в TimeStamp
                java.sql.Timestamp myTimestamp;
                myTimestamp = result.getTimestamp("date_begin");
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy HH:mm");
                clientOrders.setDateBegin(sdf.format(myTimestamp));
                
                //вытаскиваем заказы клиента
                ps2 = con.prepareStatement(sql2);
                ps2.setInt(1, id_chek);
                
                ResultSet result2 = ps2.executeQuery();
                List<OneClientOrder> list = new ArrayList<OneClientOrder>();
                while(result2.next())
                {
                    OneClientOrder oneClientOrder = new OneClientOrder();
                    oneClientOrder.setDateEvent(result2.getString("date_event"));
                    oneClientOrder.setEvent(result2.getString("event"));
                    oneClientOrder.setKef(result2.getString("kef"));
                    oneClientOrder.setPrognos(result2.getString("prognos"));
                    oneClientOrder.setPrice(result2.getInt("price"));
                    oneClientOrder.setNamePrognos(result2.getString("name_prognos"));
                    list.add(oneClientOrder);
                }
                
                clientOrders.setOrders(list);
                this.orders.add(clientOrders);
                
                result2.clearWarnings();
                result2.close();
                
                ps2.clearBatch();
                ps2.clearParameters();
                ps2.clearWarnings();
                
            }
            
            
            
            result.close();
            ps.close();
            con.close();
            
            return orders;
        } catch (NamingException ex) {
            
            
            
            Logger.getLogger(WorkClientOrders.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            
            
            Logger.getLogger(WorkClientOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
