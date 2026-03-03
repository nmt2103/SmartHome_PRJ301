/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author DELL
 */
public class Alert {
    private int id;
    private String type;
    private String severity;
    private String status;
    private LocalTime startTs;
    private LocalTime endTs;
    private String message;
    private LocalDateTime createAt;
    private Users userId;
    private Home homeId;
    private Device deviceId;
    private Room roomId;

    public Alert() {
    }

    public Alert(int id, String type, String severity, String status, LocalTime startTs, LocalTime endTs, String message, LocalDateTime createAt, Users userId, Home homeId, Device deviceId, Room roomId) {
        this.id = id;
        this.type = type;
        this.severity = severity;
        this.status = status;
        this.startTs = startTs;
        this.endTs = endTs;
        this.message = message;
        this.createAt = createAt;
        this.userId = userId;
        this.homeId = homeId;
        this.deviceId = deviceId;
        this.roomId = roomId;
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

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalTime getStartTs() {
        return startTs;
    }

    public void setStartTs(LocalTime startTs) {
        this.startTs = startTs;
    }

    public LocalTime getEndTs() {
        return endTs;
    }

    public void setEndTs(LocalTime endTs) {
        this.endTs = endTs;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Home getHomeId() {
        return homeId;
    }

    public void setHomeId(Home homeId) {
        this.homeId = homeId;
    }

    public Device getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }
    
    
}
