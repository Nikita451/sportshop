/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.nikitainfo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Никита
 */
public class ClientOrders implements Serializable{
    private int id_deal;
    private int id_chek;
    private String sername;
    private String name;
    private String dateBegin;
    private String email;
    
    private List<OneClientOrder> orders;
    
    
    public void setId_deal(int buffer)
    {
        this.id_deal = buffer;
    }
    
     public void setId_chek(int buffer)
     {
        this.id_chek = buffer;
     }
     
    public void setSername(String buffer)
    {
        this.sername = buffer;
    }
    
    public void setName(String buffer)
    {
        this.name = buffer;
    }
     
    public void setDateBegin(String buffer)
    {
        this.dateBegin = buffer;
    }
    
    public void setEmail(String buffer)
    {
        this.email = buffer;
    }
    
    public void setOrders(List<OneClientOrder> buffer)
    {
        this.orders = buffer;
    }
    
    public List<OneClientOrder> getOrders()
    {
        return this.orders;
    }
    
    
    public int getId_deal()
    {
        return this.id_deal;
    }
    
     public int getId_chek()
     {
        return this.id_chek;
     }
     
    public String getSername()
    {
        return this.sername;
    }
    
    public String getName()
    {
        return this.name;
    }
     
    public String getDateBegin()
    {
        return this.dateBegin;
    }
    
    public String getEmail()
    {
        return this.email;
    }
}
