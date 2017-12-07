package com.vinnychenko.main.models;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "medicines", schema = "lab_5", catalog = "")
public class MedicineEntity {
    private int id;
    private String name;
    private int numberInPack;
    private String packing;
    private String instruction;
    private List<PharmacyEntity> pharmacies;

    public MedicineEntity() {}

    public MedicineEntity(String name, int numberInPack, String packing, String instruction) {
        this.name = name;
        this.numberInPack = numberInPack;
        this.packing = packing;
        this.instruction = instruction;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "name", nullable = false)
    public int getMedicineId() {
        return id;
    }

    public void setMedicineId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 150)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "packing", nullable = false, length = 50)
    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    @Column(name = "instruction", nullable = false, length = 65535, columnDefinition="Text")
    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Column(name = "number_in_pack", nullable = false)
    public int getNumberInPack() {
        return numberInPack;
    }

    public void setNumberInPack(int numberInPack) {
        this.numberInPack = numberInPack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicineEntity that = (MedicineEntity) o;

        if (id != that.id) return false;
        if (numberInPack != that.numberInPack) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (packing != null ? !packing.equals(that.packing) : that.packing != null) return false;
        if (instruction != null ? !instruction.equals(that.instruction) : that.instruction != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;

        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (instruction != null ? instruction.hashCode() : 0);
        result = 31 * result + (packing != null ? packing.hashCode() : 0);
        result = 31 * result + numberInPack;

        return result;
    }

    @ManyToMany(mappedBy = "projects")
    public List<PharmacyEntity> getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(List<PharmacyEntity> pharmacies) {
        this.pharmacies = pharmacies;
    }
}
