package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class Device {

    private int id;

    private String type;

    private String name;

    private double price;

    private Date date;

    private String description;

    private boolean availability;

    private int factoryId;

    public Device() {
    }
}
