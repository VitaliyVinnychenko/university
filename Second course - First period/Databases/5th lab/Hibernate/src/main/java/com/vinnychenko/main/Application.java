package com.vinnychenko.main;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;
import com.vinnychenko.main.models.*;


public class Application {

    private static SessionFactory ourSessionFactory;
    static {
        try {
            ourSessionFactory =  new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) { throw new ExceptionInInitializerError(ex); }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {

        Session session = getSession();

        try {
            readAllTable(session);

            System.out.println("\n\nFinish work!");
        } finally {
            session.close();
            System.exit(0);
        }
    }

    private static void readAllTable(Session session){

        Query query = session.createQuery("from " + "PharmacyEntity");
        System.out.format("\nTable Pharmacy --------------------\n");
        System.out.format("%3s %-20s %-15s %-20s %s\n", "ID", "Phone", "Name", "Street", "Owner's full name");
        for (Object obj : query.list()) {
            PharmacyEntity pharmacy = (PharmacyEntity) obj;
            System.out.format("%3d %-15s %-15s %-20s %s\n", pharmacy.getPharmacyId(),
                    pharmacy.getPhone(), pharmacy.getName(), pharmacy.getStreet().getStreetName(),
                    pharmacy.getOwnersFullName());
        }


        query = session.createQuery("from " + "MedicineEntity");
        System.out.format("\nTable Medicine --------------------\n");
        System.out.format("%3s %-18s %-18s %s\n", "ID", "Name", "Packing", "Instruction");
        for (Object obj : query.list()) {
            MedicineEntity medicine = (MedicineEntity) obj;
            System.out.format("%3d %-18s %-18s %s\n", medicine.getMedicineId(),
                    medicine.getName(), medicine.getPacking(), medicine.getInstruction());
        }

        query = session.createQuery("from " + "StreetEntity");
        System.out.format("\nTable Street --------------------\n");
        for (Object obj : query.list()) {
            StreetEntity street = (StreetEntity) obj;
            System.out.format("%s\n", street.getStreetName());
        }
    }

    private static void readStreetFilter(Session session){

        Scanner input = new Scanner(System.in);
        System.out.println("Input street name for pharmacy: ");
        String street_in = input.next();

        StreetEntity streetEntity = (StreetEntity) session.load(StreetEntity.class, street_in);

        if (streetEntity != null){
            System.out.format("\n%s: %s\n", street_in, "Name");

            for (PharmacyEntity obj : streetEntity.getPharmaciesByStreet())
                System.out.format("    %s\n", obj.getName());
        } else {
            System.out.println("invalid name of city");
        }
    }

    private static void readMedicinesOfPharmacy(Session session){
        Query query = session.createQuery("from " + "PharmacyEntity");

        System.out.format("\nTable Pharmacy --------------------\n");
        System.out.format("%3s %-12s %-12s \n","ID", "Name", "Owner's full name");

        for (Object obj : query.list()) {
            PharmacyEntity pharmacy = (PharmacyEntity) obj;

            System.out.format("%3s %-12s %-20s->\n", pharmacy.getPharmacyId(), pharmacy.getName(),
                    pharmacy.getOwnersFullName());

            for (MedicineEntity medicines : pharmacy.getMedicines()) {
                System.out.format("\t\t%s - %s\n", medicines.getName(),  medicines.getPacking());
            }

            System.out.println();
        }
    }

    private static void readStreetTable(Session session){

        Query query = session.createQuery("from " + "StreetEntity");
        System.out.format("\nTable Street --------------------\n");

        for (Object obj : query.list()) {
            StreetEntity city = (StreetEntity) obj;
            System.out.format("%s\n", city.getStreetName());
        }
    }

    private static void insertStreet(Session session){
        Scanner input = new Scanner(System.in);
        System.out.println("Input a new name street: ");
        String newStreet = input.next();

        session.beginTransaction();
        StreetEntity streetEntity = new StreetEntity(newStreet);
        session.save(streetEntity);
        session.getTransaction().commit();

        System.out.println("end insert street");
    }

    private static void insertPharmacy(Session session){
        Scanner input = new Scanner(System.in);

        System.out.println("Input new Pharmacy name: ");
        String name = input.next();
        System.out.println("Input new Pharmacy phone: ");
        String phone = input.next();
        System.out.println("Input the street for Pharmacy: ");
        String street = input.next();
        System.out.println("Input new Pharmacy owner's full name: ");
        String ownersFullName = input.next();

        session.beginTransaction();

        PharmacyEntity pharmacyEntity = new PharmacyEntity(name, phone, ownersFullName, street);
        session.save(pharmacyEntity);

        session.getTransaction().commit();

        System.out.println("end insert person");
    }

    private static void updateStreet(Session session){
        Scanner input = new Scanner(System.in);

        System.out.println("\nInput a name street: ");
        String street = input.next();
        System.out.println("Input new name street: ");
        String newStreet = input.next();

        StreetEntity streetEntity = (StreetEntity) session.load(StreetEntity.class, street);

        if(streetEntity != null){
            session.beginTransaction();

            Query query = session.createQuery("update StreetEntity set name=:code1  where name = :code2");
            query.setParameter("code1", newStreet);
            query.setParameter("code2", street);

            int result = query.executeUpdate();

            session.getTransaction().commit();

            System.out.println("end update street: " + result);
        } else {
            System.out.println("There is no the street");
        }
    }

    private static void addMedicineForPharmacy(Session session){
        System.out.println("Give a medicine to pharmacy--------------");
        Scanner input = new Scanner(System.in);

        System.out.println("Choose Pharmacy name:");
        String pharmacyName = input.next();
        System.out.println("Choose Medicine name:");
        String medicineName = input.next();

        Query query = session.createQuery("from " + "PharmacyEntity where pharmacy_name = :code");
        query.setParameter("code", pharmacyName);

        if (!query.list().isEmpty()) {

            PharmacyEntity pharmacyEntity = (PharmacyEntity) query.list().get(0);

            query = session.createQuery("from " + "MedicineEntity where medicine_name = :code");
            query.setParameter("code", medicineName);

            if(!query.list().isEmpty()){

                MedicineEntity medicineEntity = (MedicineEntity) query.list().get(0);

                session.beginTransaction();
                pharmacyEntity.addMedicineEntity(medicineEntity);
                session.save(pharmacyEntity);

                session.getTransaction().commit();
                System.out.println("end insert medicine for pharmacy");
            } else {
                System.out.println("There is no the medicine");
            }
        } else {
            System.out.println("There is no this pharmacy");
        }
    }
}