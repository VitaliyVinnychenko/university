package com.vinnychenko.controller;

import com.vinnychenko.DTO.MedicineDTO;
import com.vinnychenko.domain.Medicine;
import com.vinnychenko.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class MedicineController {
    @Autowired
    MedicineService medicineService;

    @GetMapping(value = "/api/medicine/pharmacy/{person_id}")
    public ResponseEntity<List<MedicineDTO>> getMedicineByPharmacyID(@PathVariable Long person_id) {
        List<Medicine> bookList = medicineService.getMedicineByPharmacyId(person_id);
        Link link = linkTo(methodOn(MedicineController.class).getAllMedicines()).withSelfRel();

        List<MedicineDTO> medicineDTO = new ArrayList<>();
        for (Medicine entity : bookList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getMedicineId()).withSelfRel();
            MedicineDTO dto = new MedicineDTO(entity, selfLink);
            medicineDTO.add(dto);
        }

        return new ResponseEntity<>(medicineDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/medicine/{book_id}")
    public ResponseEntity<MedicineDTO> getMedicine(@PathVariable Long book_id) {
        Medicine medicine = medicineService.getMedicine(book_id);
        Link link = linkTo(methodOn(MedicineController.class).getMedicine(book_id)).withSelfRel();

        MedicineDTO medicineDTO = new MedicineDTO(medicine, link);

        return new ResponseEntity<>(medicineDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/medicine")
    public ResponseEntity<List<MedicineDTO>> getAllMedicines() {
        List<Medicine> medicinesList = medicineService.getAllMedicines();
        Link link = linkTo(methodOn(MedicineController.class).getAllMedicines()).withSelfRel();

        List<MedicineDTO> medicineDTO = new ArrayList<>();
        for (Medicine entity : medicinesList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getMedicineId()).withSelfRel();
            MedicineDTO dto = new MedicineDTO(entity, selfLink);
            medicineDTO.add(dto);
        }

        return new ResponseEntity<>(medicineDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/medicine")
    public ResponseEntity<MedicineDTO> addMedicine(@RequestBody Medicine newMedicine) {
        medicineService.createMedicines(newMedicine);
        Link link = linkTo(methodOn(MedicineController.class).getMedicine(newMedicine.getMedicineId().longValue())).withSelfRel();

        MedicineDTO medicineDTO = new MedicineDTO(newMedicine, link);

        return new ResponseEntity<>(medicineDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/medicine/{book_id}")
    public ResponseEntity<MedicineDTO> updateMedicine(@RequestBody Medicine uMedicine, @PathVariable Long book_id) {
        medicineService.updateMedicine(uMedicine, book_id);
        Medicine medicine = medicineService.getMedicine(book_id);
        Link link = linkTo(methodOn(MedicineController.class).getMedicine(book_id)).withSelfRel();

        MedicineDTO medicineDTO = new MedicineDTO(medicine, link);

        return new ResponseEntity<>(medicineDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/medicine/{book_id}")
    public  ResponseEntity deleteMedicine(@PathVariable Long book_id) {
        medicineService.deleteMedicine(book_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
