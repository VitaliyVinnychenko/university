package com.vinnychenko.controller;

import com.vinnychenko.DTO.PharmacyDTO;
import com.vinnychenko.domain.Pharmacy;
import com.vinnychenko.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class PharmacyController {
    @Autowired
    PharmacyService pharmacyService;

    @GetMapping(value = "/api/pharmacy/street/{city_id}")
    public ResponseEntity<List<PharmacyDTO>> getPharmacyByStreetID(@PathVariable Long city_id) {
        Collection<Pharmacy> personList = pharmacyService.getPharmacyByStreetId(city_id.intValue());

        Link link = linkTo(methodOn(PharmacyController.class).getAllPharmacies()).withSelfRel();

        List<PharmacyDTO> personsDTO = new ArrayList<>();
        for (Pharmacy entity : personList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getPharmacyId()).withSelfRel();
            PharmacyDTO dto = new PharmacyDTO(entity, selfLink);
            personsDTO.add(dto);
        }

        return new ResponseEntity<>(personsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/pharmacy/{person_id}")
    public ResponseEntity<PharmacyDTO> getPharmacy(@PathVariable int person_id) {
        Pharmacy pharmacy = pharmacyService.getPharmacy((long) person_id);
        Link link = linkTo(methodOn(PharmacyController.class).getPharmacy(person_id)).withSelfRel();

        PharmacyDTO pharmacyDTO = new PharmacyDTO(pharmacy, link);

        return new ResponseEntity<>(pharmacyDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/pharmacy")
    public ResponseEntity<List<PharmacyDTO>> getAllPharmacies() {
        List<Pharmacy> personList = pharmacyService.getAllPharmacies();
        Link link = linkTo(methodOn(PharmacyController.class).getAllPharmacies()).withSelfRel();

        List<PharmacyDTO> pharmacyDTO = new ArrayList<>();
        for (Pharmacy entity : personList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getPharmacyId()).withSelfRel();
            PharmacyDTO dto = new PharmacyDTO(entity, selfLink);
            pharmacyDTO.add(dto);
        }

        return new ResponseEntity<>(pharmacyDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/pharmacy/medicine/{book_id}")
    public ResponseEntity<List<PharmacyDTO>> getPharmacyByMedicineID(@PathVariable Long book_id) {
        List<Pharmacy> personList = pharmacyService.getPharmacyByMedicineId(book_id);
        Link link = linkTo(methodOn(PharmacyController.class).getAllPharmacies()).withSelfRel();

        List<PharmacyDTO> pharmacyDTO = new ArrayList<>();
        for (Pharmacy entity : personList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getPharmacyId()).withSelfRel();
            PharmacyDTO dto = new PharmacyDTO(entity, selfLink);
            pharmacyDTO.add(dto);
        }

        return new ResponseEntity<>(pharmacyDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/pharmacy/street/{city_id}")
    public  ResponseEntity<PharmacyDTO> addPharmacy(@RequestBody Pharmacy newPharmacy, @PathVariable Long city_id) {
        pharmacyService.createPharmacy(newPharmacy, city_id);
        Link link = linkTo(methodOn(PharmacyController.class).getPharmacy(newPharmacy.getPharmacyId().intValue())).withSelfRel();

        PharmacyDTO pharmacyDTO = new PharmacyDTO(newPharmacy, link);

        return new ResponseEntity<>(pharmacyDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/pharmacy/{person_id}/street/{city_id}")
    public  ResponseEntity<PharmacyDTO> updatePharmacy(@RequestBody Pharmacy uPharmacy,
                                                   @PathVariable Long person_id, @PathVariable Long city_id) {
        pharmacyService.updatePharmacy(uPharmacy, person_id, city_id);
        Pharmacy pharmacy =pharmacyService.getPharmacy(person_id);
        Link link = linkTo(methodOn(PharmacyController.class).getPharmacy(person_id.intValue())).withSelfRel();

        PharmacyDTO pharmacyDTO = new PharmacyDTO(pharmacy, link);

        return new ResponseEntity<>(pharmacyDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/pharmacy/{person_id}")
    public  ResponseEntity deletePharmacy(@PathVariable Long person_id) {
        pharmacyService.deletePharmacy(person_id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/api/pharmacy/{person_id}/medicine/{book_id}")
    public  ResponseEntity<PharmacyDTO> addBookForPerson(@PathVariable Long person_id, @PathVariable Long book_id) {
        pharmacyService.addMedicineForPharmacy(person_id,book_id);
        Pharmacy pharmacy = pharmacyService.getPharmacy(person_id);
        Link link = linkTo(methodOn(PharmacyController.class).getPharmacy(person_id.intValue())).withSelfRel();

        PharmacyDTO pharmacyDTO = new PharmacyDTO(pharmacy, link);

        return new ResponseEntity<>(pharmacyDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/pharmacy/{person_id}/medicine/{book_id}")
    public  ResponseEntity<PharmacyDTO> removeMedicineForPharmacy(@PathVariable Long person_id, @PathVariable Long book_id) {
        pharmacyService.removeMedicineForPharmacy(person_id,book_id);
        Pharmacy pharmacy = pharmacyService.getPharmacy(person_id);
        Link link = linkTo(methodOn(PharmacyController.class).getPharmacy(person_id.intValue())).withSelfRel();

        PharmacyDTO pharmacyDTO = new PharmacyDTO(pharmacy, link);

        return new ResponseEntity<>(pharmacyDTO, HttpStatus.OK);
    }

}
