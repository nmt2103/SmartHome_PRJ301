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
public class Rules {
    private int id;
    private String name;
    private String tri_type;
    private String con_json;
    private String act_json;
    private int priority;
    private boolean active;
    private LocalTime createAt;
    private Home homeId;
    private Alert alerId;

    public Rules() {
    }

    public Rules(int id, String name, String tri_type, String con_json, String act_json, int priority, boolean active, LocalTime createAt, Home homeId, Alert alerId) {
        this.id = id;
        this.name = name;
        this.tri_type = tri_type;
        this.con_json = con_json;
        this.act_json = act_json;
        this.priority = priority;
        this.active = active;
        this.createAt = createAt;
        this.homeId = homeId;
        this.alerId = alerId;
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

    public String getTri_type() {
        return tri_type;
    }

    public void setTri_type(String tri_type) {
        this.tri_type = tri_type;
    }

    public String getCon_json() {
        return con_json;
    }

    public void setCon_json(String con_json) {
        this.con_json = con_json;
    }

    public String getAct_json() {
        return act_json;
    }

    public void setAct_json(String act_json) {
        this.act_json = act_json;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalTime createAt) {
        this.createAt = createAt;
    }

    public Home getHomeId() {
        return homeId;
    }

    public void setHomeId(Home homeId) {
        this.homeId = homeId;
    }

    public Alert getAlerId() {
        return alerId;
    }

    public void setAlerId(Alert alerId) {
        this.alerId = alerId;
    }
    
}
