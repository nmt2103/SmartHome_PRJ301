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
public class Device {
    private int id;
    private String type;
    private String serial;
    private String vendor;
    private String status;
    private LocalTime lastSeen;
    private Room roomId;

    public Device() {
    }

    public Device(int id, String type, String serial, String vendor, String status, LocalTime lastSeen, Room roomId) {
        this.id = id;
        this.type = type;
        this.serial = serial;
        this.vendor = vendor;
        this.status = status;
        this.lastSeen = lastSeen;
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

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalTime getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(LocalTime lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }
    
}
