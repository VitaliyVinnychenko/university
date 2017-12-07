package com.vinnychenko.main.models;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "pharmacy", catalog = "")
public class PharmacyEntity {
    private int id;
    private String name;
    private String phone;
    private String ownersFullName;
    private StreetEntity street;
    private List<MedicineEntity> medicines;

    public PharmacyEntity() {}

    public PharmacyEntity(String name, String phone, String ownersFullName, String street) {
        this.name = name;
        this.phone = phone;
        this.ownersFullName = ownersFullName;
        this.street = new StreetEntity(street);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getPharmacyId() {
        return id;
    }

    public void setPharmacyId(int id) {
        this.id = id;
    }

    @Column(name = "pharmacy_name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "phone", nullable = false, length = 15)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "owner_full_name", nullable = false, length = 15)
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

        PharmacyEntity that = (PharmacyEntity) o;

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
        int result = id;

        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (ownersFullName != null ? ownersFullName.hashCode() : 0);

        return result;
    }

    @ManyToOne
    @JoinColumn(name = "street", referencedColumnName = "name", nullable = false)
    public StreetEntity getStreet() {
        return street;
    }

    public void setStreet(StreetEntity street) {
        this.street = street;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "pharmacy_has_medicines",
            joinColumns = { @JoinColumn(name = "pharmacy_id") },
            inverseJoinColumns = { @JoinColumn(name = "medicine_id") }
    )
    public List<MedicineEntity> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<MedicineEntity> medicines) {
        this.medicines = medicines;
    }

    public void addMedicineEntity(MedicineEntity medicineEntity){
        if(!getMedicines().contains(medicineEntity)){
            getMedicines().add(medicineEntity);
        }
        if(!medicineEntity.getPharmacies().contains(this)){
            medicineEntity.getPharmacies().add(this);
        }
    }
}
