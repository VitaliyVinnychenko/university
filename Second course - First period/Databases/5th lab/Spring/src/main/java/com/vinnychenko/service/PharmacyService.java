package com.vinnychenko.service;

import com.vinnychenko.Repository.MedicineRepository;
import com.vinnychenko.Repository.StreetRepository;
import com.vinnychenko.Repository.PharmacyRepository;
import com.vinnychenko.domain.Pharmacy;
import com.vinnychenko.domain.Street;
import com.vinnychenko.domain.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class PharmacyService {
    @Autowired
    PharmacyRepository pharmacyRepository;

    @Autowired
    StreetRepository streetRepository;

    @Autowired
    MedicineRepository medicineRepository;

    public Collection<Pharmacy> getPharmacyByStreetId(int city_id) {
        Street street = streetRepository.findById(city_id).get();
        return street.getPharmaciesByStreet();
    }

    public Pharmacy getPharmacy(Long person_id) {
        Pharmacy pharmacy = pharmacyRepository.findById(person_id.intValue()).get();
        return pharmacy;
    }

    public List<Pharmacy> getAllPharmacies() {
        return pharmacyRepository.findAll();
    }

    public List<Pharmacy> getPharmacyByMedicineId(Long medicine_id) {
        Medicine medicine = medicineRepository.findById(medicine_id.intValue()).get();
        return medicine.getPharmacies();
    }

    @Transactional
    public void createPharmacy(Pharmacy pharmacy, Long city_id) {
        if (city_id > 0) {
            Street street = streetRepository.findById(city_id.intValue()).get();
            pharmacy.setStreet(street);
        }
        pharmacyRepository.save(pharmacy);
    }

    @Transactional
    public void updatePharmacy(Pharmacy uPharmacy, Long person_id, Long city_id) {
        Street street = streetRepository.findById(city_id.intValue()).get();
        Pharmacy pharmacy = pharmacyRepository.findById(person_id.intValue()).get();

        pharmacy.setName(uPharmacy.getName());
        pharmacy.setOwnersFullName(uPharmacy.getOwnersFullName());
        pharmacy.setPhone(uPharmacy.getPhone());
        if (city_id > 0) pharmacy.setStreet(street);
        else pharmacy.setStreet(null);
        pharmacyRepository.save(pharmacy);
    }

    @Transactional
    public void deletePharmacy(Long person_id) {
        Pharmacy pharmacy = pharmacyRepository.findById(person_id.intValue()).get();
        pharmacyRepository.delete(pharmacy);
    }

    @Transactional
    public void addMedicineForPharmacy(Long person_id, Long book_id) {
        Pharmacy pharmacy = pharmacyRepository.findById(person_id.intValue()).get();
        Medicine medicine = medicineRepository.findById(book_id.intValue()).get();

        pharmacy.getMedicines().add(medicine);
        pharmacyRepository.save(pharmacy);
    }

    @Transactional
    public void removeMedicineForPharmacy(Long person_id, Long book_id) {
        Pharmacy pharmacy = pharmacyRepository.findById(person_id.intValue()).get();
        Medicine medicine = medicineRepository.findById(book_id.intValue()).get();
        pharmacy.getMedicines().remove(medicine);
        pharmacyRepository.save(pharmacy);
    }
}
