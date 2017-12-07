package com.vinnychenko.main.models;

import javax.persistence.*;

@Entity
@Table(name = "street", schema = "lab_5", catalog = "")
public class StreetEntity {
    private int id;
    private String name;

    public StreetEntity(){}
    public StreetEntity(String c){
        name = c;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getStreetId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getStreetName() {
        return name;
    }

    public void setStreetName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StreetEntity that = (StreetEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
