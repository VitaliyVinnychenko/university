package com.vinnychenko.service;

import com.vinnychenko.Repository.StreetRepository;
import com.vinnychenko.Repository.PharmacyRepository;
import com.vinnychenko.domain.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StreetService {
    @Autowired
    StreetRepository streetRepository;
    private boolean ascending;

    @Autowired
    PharmacyRepository pharmacyRepository;

    public List<Street> getAllStreets() {
        return streetRepository.findAll();
    }

    public Street getStreet(int city_id) {
        Street street = streetRepository.findById(city_id).get();
        return street;
    }

    @Transactional
    public void createStreet(Street street) {
        streetRepository.save(street);
    }

    @Transactional
    public void updateStreet(Street uStreet, int city_id) {
        Street street = streetRepository.findById(city_id).get();

        street.setStreetName(uStreet.getStreetName());
        streetRepository.save(street);
    }

    @Transactional
    public void deleteStreet(int city_id) {
        Street street = streetRepository.findById(city_id).get();

        streetRepository.delete(street);
    }
}
