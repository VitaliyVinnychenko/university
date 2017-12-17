package com.vinnychenko.DTO;

import com.vinnychenko.controller.MedicineController;
import com.vinnychenko.domain.Pharmacy;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PharmacyDTO extends ResourceSupport {
    Pharmacy pharmacy;
    public PharmacyDTO(Pharmacy pharmacy, Link selfLink) {
        this.pharmacy=pharmacy;
        add(selfLink);
        add(linkTo(methodOn(MedicineController.class).getMedicineByPharmacyID(new Long(pharmacy.getPharmacyId())))
                .withRel("medicines"));
    }

    public Integer getPharmacyId() {
        return pharmacy.getPharmacyId();
    }

    public String getName() {
        return pharmacy.getName();
    }

    public String getOwnersFullName() {
        return pharmacy.getOwnersFullName();
    }

    public String getPhone() {
        return pharmacy.getPhone();
    }

    public String getStreet() {
        if(pharmacy.getStreet()==null) return "";
        return pharmacy.getStreet().getStreetName();
    }
}