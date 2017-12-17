package com.vinnychenko.controller;

import com.vinnychenko.DTO.StreetDTO;
import com.vinnychenko.domain.Street;
import com.vinnychenko.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class StreetController {
    @Autowired
    StreetService streetService;

    @GetMapping(value = "/api/street")
    public ResponseEntity<List<StreetDTO>> getAllStreets() {
        List<Street> streetList = streetService.getAllStreets();
        Link link = linkTo(methodOn(StreetController.class).getAllStreets()).withSelfRel();

        List<StreetDTO> citiesDTO = new ArrayList<>();
        for (Street entity : streetList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getStreetId()).withSelfRel();
            StreetDTO dto = new StreetDTO(entity, selfLink);
            citiesDTO.add(dto);
        }

        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/street/{city_id}")
    public ResponseEntity<StreetDTO> getStreet(@PathVariable Long city_id) {
        Street street = streetService.getStreet(city_id.intValue());
        Link link = linkTo(methodOn(StreetController.class).getStreet(city_id)).withSelfRel();

        StreetDTO cityDTO = new StreetDTO(street, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/street/{city_id}")
    public  ResponseEntity<StreetDTO> addStreet(@RequestBody Street newStreet) {
        streetService.createStreet(newStreet);
        Link link = linkTo(methodOn(StreetController.class).getStreet(newStreet.getStreetId())).withSelfRel();

        StreetDTO streetDTO = new StreetDTO(newStreet, link);

        return new ResponseEntity<>(streetDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/street/{city_id}")
    public  ResponseEntity<StreetDTO> updateStreet(@RequestBody Street uStreet, @PathVariable Long city_id) {
        streetService.updateStreet(uStreet, city_id.intValue());
        Street street = streetService.getStreet(city_id.intValue());
        Link link = linkTo(methodOn(StreetController.class).getStreet(city_id)).withSelfRel();

        StreetDTO streetDTO = new StreetDTO(street, link);

        return new ResponseEntity<>(streetDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/street/{city_id}")
    public  ResponseEntity deleteStreet(@PathVariable int city_id) {
        streetService.deleteStreet(city_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
