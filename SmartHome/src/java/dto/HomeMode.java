/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalTime;

/**
 *
 * @author DELL
 */
public class HomeMode {
    private int id;
    private String name;
    private LocalTime act_fr;
    private LocalTime act_to;
    private boolean is_act;
    private Home homeId;

    public HomeMode() {
    }

    public HomeMode(int id, String name, LocalTime act_fr, LocalTime act_to, boolean is_act, Home homeId) {
        this.id = id;
        this.name = name;
        this.act_fr = act_fr;
        this.act_to = act_to;
        this.is_act = is_act;
        this.homeId = homeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getAct_fr() {
        return act_fr;
    }

    public void setAct_fr(LocalTime act_fr) {
        this.act_fr = act_fr;
    }

    public LocalTime getAct_to() {
        return act_to;
    }

    public void setAct_to(LocalTime act_to) {
        this.act_to = act_to;
    }

    public boolean isIs_act() {
        return is_act;
    }

    public void setIs_act(boolean is_act) {
        this.is_act = is_act;
    }

    public Home getHomeId() {
        return homeId;
    }

    public void setHomeId(Home homeId) {
        this.homeId = homeId;
    }
    
}
