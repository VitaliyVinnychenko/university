package com.vinnychenko.service;

import com.vinnychenko.Repository.MedicineRepository;
import com.vinnychenko.Repository.PharmacyRepository;
import com.vinnychenko.domain.Pharmacy;
import com.vinnychenko.domain.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MedicineService {
    @Autowired
    MedicineRepository medicineRepository;

    @Autowired
    PharmacyRepository pharmacyRepository;

    public List<Medicine> getMedicineByPharmacyId(Long person_id) {
        Pharmacy pharmacy = pharmacyRepository.findById(person_id.intValue()).get();
        return pharmacy.getMedicines();
    }

    public Medicine getMedicine(Long book_id) {
        Medicine medicine = medicineRepository.findById(book_id.intValue()).get();
        return medicine;
    }

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    @Transactional
    public void createMedicines(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    @Transactional
    public void updateMedicine(Medicine uMedicine, Long book_id) {
        Medicine medicine = medicineRepository.findById(book_id.intValue()).get();

        medicine.setName(uMedicine.getName());
        medicine.setInstruction(uMedicine.getInstruction());
        medicine.setNumberInPack(uMedicine.getNumberInPack());
        medicine.setPacking(uMedicine.getPacking());
    }

    @Transactional
    public void deleteMedicine(Long book_id) {
        Medicine medicine = medicineRepository.findById(book_id.intValue()).get();

        medicineRepository.delete(medicine);
    }
}
