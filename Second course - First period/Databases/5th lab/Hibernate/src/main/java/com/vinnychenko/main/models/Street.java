package com.vinnychenko.main.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city", schema = "db_jdbc", catalog = "")
public class Street {
    private String name;

    public Street(){}
    public Street(String c){
        name=c;
    }

    @Id
    @Column(name = "", nullable = false, length = 25)
    public String getCity() {
        return name;
    }

    public void setCity(String name) {
        this.name = name;
    }
}
