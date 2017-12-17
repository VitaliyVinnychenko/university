package com.vinnychenko.domain;

import javax.persistence.*;
import java.util.*;

import static java.lang.Math.toIntExact;


@Entity
@Table(name = "pharmacy", catalog = "")
public class Pharmacy {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "pharmacy_name", nullable = false, length = 50)
    private String name;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "owner_full_name", nullable = false, length = 15)
    private String ownersFullName;

    @ManyToOne
    @JoinColumn(name = "street", referencedColumnName = "id", nullable = false)
    private Street street;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "pharmacy_has_medicines",
            joinColumns = { @JoinColumn(name = "pharmacy_id") },
            inverseJoinColumns = { @JoinColumn(name = "medicine_id") }
    )
    private List<Medicine> medicines;

    public Pharmacy() {}

    public Pharmacy(String name, String phone, String ownersFullName, String street) {
        this.name = name;
        this.phone = phone;
        this.ownersFullName = ownersFullName;
        this.street = new Street(street);
    }

    public Integer getPharmacyId() {
        return id;
    }

    public void setPharmacyId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOwnersFullName() {
        return ownersFullName;
    }

    public void setOwnersFullName(String ownersFullName) {
        this.ownersFullName = ownersFullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pharmacy that = (Pharmacy) o;

        if (id != that.id) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (ownersFullName != null ? !ownersFullName.equals(that.ownersFullName) : that.ownersFullName != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = toIntExact(id);

        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (ownersFullName != null ? ownersFullName.hashCode() : 0);

        return result;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public void addMedicineEntity(Medicine medicineEntity){
        if(!getMedicines().contains(medicineEntity)){
            getMedicines().add(medicineEntity);
        }
        if(!medicineEntity.getPharmacies().contains(this)){
            medicineEntity.getPharmacies().add(this);
        }
    }
}
