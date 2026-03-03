/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author DELL
 */
public class Room {
    private int id;
    private String name;
    private int floor;
    private String type;
    private String status;
    private Home homeId;

    public Room() {
    }

    public Room(int id, String name, int floor, String type, String status, Home homeId) {
        this.id = id;
        this.name = name;
        this.floor = floor;
        this.type = type;
        this.status = status;
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Home getHomeId() {
        return homeId;
    }

    public void setHomeId(Home homeId) {
        this.homeId = homeId;
    }
    
}
