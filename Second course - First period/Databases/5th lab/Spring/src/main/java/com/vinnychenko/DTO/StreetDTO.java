package com.vinnychenko.DTO;

import com.vinnychenko.controller.PharmacyController;
import com.vinnychenko.domain.Street;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class StreetDTO extends ResourceSupport {
    Street street;

    public StreetDTO(Street street, Link selfLink) {
        this.street=street;
        add(selfLink);
        add(linkTo(methodOn(PharmacyController.class).getPharmacyByStreetID(street.getStreetId())).withRel("pharmacies"));
    }

    public int getCityId() { return street.getStreetId().intValue(); }

    public String getCity() {
        return street.getStreetName();
    }
}
