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
public class OneClientOrder implements Serializable {
    private String event;
    private String kef;
    private String prognos;
    private String dateEvent;
    private int price;
    private String namePrognos;

    public OneClientOrder() {
    }
    
    public void setEvent(String buffer)
    {
        this.event =buffer;
    }
    
    public void setKef(String buffer)
    {
        this.kef =buffer;
    }
    
    public void setPrognos(String buffer)
    {
        this.prognos =buffer;
    }
    
    public void setDateEvent(String buffer)
    {
        this.dateEvent =buffer;
    }
    
    public void setPrice(int buffer)
    {
        this.price =buffer;
    }
    
    public void setNamePrognos(String buffer)
    {
        this.namePrognos =buffer;
    }
    
    public String getEvent()
    {
        return this.event;
    }
    
    public String getKef()
    {
        return this.kef;
    }
    
    public String getPrognos()
    {
        return this.prognos;
    }
    
    public String getDateEvent()
    {
        return this.dateEvent;
    }
    
    public int getPrice()
    {
       return this.price;
    }
    
    public String getNamePrognos()
    {
        return this.namePrognos;
    }
}
