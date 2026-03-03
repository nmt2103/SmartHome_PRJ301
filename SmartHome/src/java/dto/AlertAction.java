/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDateTime;

/**
 *
 * @author DELL
 */
public class AlertAction {
    private int id;
    private String type;
    private String note;
    private LocalDateTime act_ts;
    private Users userId;
    private Alert alerId;

    public AlertAction() {
    }

    public AlertAction(int id, String type, String note, LocalDateTime act_ts, Users userId, Alert alerId) {
        this.id = id;
        this.type = type;
        this.note = note;
        this.act_ts = act_ts;
        this.userId = userId;
        this.alerId = alerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getAct_ts() {
        return act_ts;
    }

    public void setAct_ts(LocalDateTime act_ts) {
        this.act_ts = act_ts;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Alert getAlerId() {
        return alerId;
    }

    public void setAlerId(Alert alerId) {
        this.alerId = alerId;
    }
    
}
