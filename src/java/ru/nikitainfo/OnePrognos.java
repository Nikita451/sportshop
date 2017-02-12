/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.nikitainfo;

import java.io.Serializable;

/**
 *
 * @author Никита
 */
public class OnePrognos implements Serializable{
    private int type;
    private int price;
    private String event;
    private String kef;
    private String date_event;
    private String foto1;
    private String foto2;
    private String foto3;
    private String prognos;

    private int id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    public OnePrognos() {
    }
    
    public void setType(int t)
    {
        this.type = t;
    }
    
    public void setPrice(int t)
    {
        this.price = t;
    }
    
    public void setEvent(String t)
    {
        this.event = t;
    }
    
    public void setKef(String t)
    {
        this.kef = t;
    }
    
    public void setDate_event(String t)
    {
        this.date_event = t;
    }
    
    public void setPrognos(String t)
    {
        this.prognos = t;
    }
    
    public void setFoto1(String t)
    {
        this.foto1 = t;
    }
    
    public void setFoto2(String t)
    {
        this.foto2 = t;
    }
     public void setFoto3(String t)
    {
        this.foto3 = t;
    }
   
    
    public int getType()
    {
        return this.type;
    }
    
    public int getPrice()
    {
        return this.price;
    }
    
    public String getEvent()
    {
        return this.event ;
    }
    
    public String getKef()
    {
        return this.kef;
    }
    
    public String getDate_event()
    {
        return this.date_event ;
    }
    
    public String getPrognos()
    {
        return this.prognos;
    }
    
    public String getFoto1()
    {
        return this.foto1;
    }
    
    public String getFoto2()
    {
        return this.foto2;
    }
    
     public String getFoto3()
    {
        return this.foto3;
    }

    @Override
    public String toString() {
        
        String t = "";
        
        t = type + "  " + event + "  " + price;
        return t;
    }
     
}
