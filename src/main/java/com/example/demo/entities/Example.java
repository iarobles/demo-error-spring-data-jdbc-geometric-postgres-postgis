package com.example.demo.entities;

import org.postgresql.geometric.PGpoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("example")
public class Example {
    @Id
    private int id;
    private String info;
    private PGpoint singlePoint;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public PGpoint getSinglePoint() {
        return singlePoint;
    }

    public void setSinglePoint(PGpoint singlePoint) {
        this.singlePoint = singlePoint;
    }

}
