package com.vinnychenko.DTO;

import com.vinnychenko.controller.PharmacyController;
import com.vinnychenko.domain.Medicine;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class MedicineDTO extends ResourceSupport {
    Medicine medicine;

    public MedicineDTO(Medicine medicine, Link selfLink) {
        this.medicine=medicine;
        add(selfLink);
        add(linkTo(methodOn(PharmacyController.class).getPharmacyByMedicineID(medicine.getMedicineId().longValue())).withRel("pharmacies"));
    }

    public Integer getMedicineId() {
        return medicine.getMedicineId();
    }

    public String getMedicineName() {
        return medicine.getName();
    }

    public String getInstruction() {
        return medicine.getInstruction();
    }

    public String getPacking() {
        return medicine.getPacking();
    }

    public int getNumberInPack() {
        return medicine.getNumberInPack();
    }
}
