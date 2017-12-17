package com.vinnychenko.domain;

import javax.persistence.*;
import java.util.*;

import static java.lang.Math.toIntExact;


@Entity
@Table(name = "medicines", catalog = "")
public class Medicine {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "medicine_name", nullable = false, length = 150)
    private String name;

    @Column(name = "number_in_pack", nullable = false)
    private int numberInPack;

    @Column(name = "packing", nullable = false)
    private String packing;

    @Column(name = "instruction", nullable = false, length = 65535, columnDefinition="Text")
    private String instruction;

    @ManyToMany(mappedBy = "medicines")
    private List<Pharmacy> pharmacies;

    public Medicine() {}

    public Medicine(String name, int numberInPack, String packing, String instruction) {
        this.name = name;
        this.numberInPack = numberInPack;
        this.packing = packing;
        this.instruction = instruction;
    }

    public Integer getMedicineId() {
        return id;
    }

    public void setMedicineId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

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

        Medicine that = (Medicine) o;

        if (id != that.id) return false;
        if (numberInPack != that.numberInPack) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (packing != null ? !packing.equals(that.packing) : that.packing != null) return false;
        if (instruction != null ? !instruction.equals(that.instruction) : that.instruction != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = toIntExact(id);

        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (instruction != null ? instruction.hashCode() : 0);
        result = 31 * result + (packing != null ? packing.hashCode() : 0);
        result = 31 * result + numberInPack;

        return result;
    }

    public List<Pharmacy> getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(List<Pharmacy> pharmacies) {
        this.pharmacies = pharmacies;
    }
}
