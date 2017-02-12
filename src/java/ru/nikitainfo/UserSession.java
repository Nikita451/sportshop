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
public class UserSession implements Serializable{

    private String name;
    private String sername;
    
    public UserSession() {
    }
    
    public void setName(String n)
    {
        this.name = n;
    }
    
    public void setSername(String n)
    {
        this.sername = n;
    }
    
    public String getName()
    {
       return this.name;
    }
    
    public String getSername()
    {
       return this.sername;
    }
    
}
