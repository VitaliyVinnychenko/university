package com.vinnychenko.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "street", catalog = "")
public class Street {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "street_name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "street")
    private Collection<Pharmacy> pharmaciesByStreet;

    public Street(){}
    public Street(String c){
        name = c;
    }

    public Long getStreetId() {
        return new Long(id);
    }

    public void setStreetId(Integer id) {
        this.id = id;
    }

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

        Street that = (Street) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public Collection<Pharmacy> getPharmaciesByStreet() {
        return pharmaciesByStreet;
    }

    public void setPharmaciesByStreet(Collection<Pharmacy> pharmaciesByStreet) {
        this.pharmaciesByStreet = pharmaciesByStreet;
    }
}
