package com.vinnychenko.main.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "street", catalog = "")
public class StreetEntity {
    private String name;
    private Collection<PharmacyEntity> pharmaciesByStreet;

    public StreetEntity(){}
    public StreetEntity(String c){
        name = c;
    }

    @Id
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

    @OneToMany(mappedBy = "street")
    public Collection<PharmacyEntity> getPharmaciesByStreet() {
        return pharmaciesByStreet;
    }

    public void setPharmaciesByStreet(Collection<PharmacyEntity> pharmaciesByStreet) {
        this.pharmaciesByStreet = pharmaciesByStreet;
    }
}
