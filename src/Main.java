import pharmacy.impl.MedicineImpl;
import pharmacy.impl.PersonImpl;
import pharmacy.impl.PharmacyImpl;
import pharmacy.model.Pharmacy;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        PharmacyImpl pharmacies1 = new PharmacyImpl();
        PersonImpl person = new PersonImpl();
        MedicineImpl medicine = new MedicineImpl();
        ArrayList<Pharmacy> pharmacies = new ArrayList<>();
        while (true) {
            try {
                System.out.println("""
                        1 -> Add new pharmacy
                        2 -> Get pharmacy by id
                        3 -> Update pharmacy by id
                        4 -> Get all pharmacy
                        5 -> Delete pharmacy by id
                        6 -> Get pharmacy by address
                        7->Add person to pharmacy
                        8->Find person by id
                        9->Update person name
                        10->Get all pharmacy staff
                        11->Delete person from pharmacy
                        12-> Add new medicine to pharmacy
                        13->Find medicine by name 
                        14->Get all pharmacy medicine 
                        15->Delete medicine by id 
                        """);
                System.out.println("Choose command:");
                int a = new Scanner(System.in).nextInt();
                switch (a) {
                    case 1 -> System.out.println(pharmacies1.addPharmacy(pharmacies));
                    case 2 -> System.out.println(pharmacies1.getPharmacyById(pharmacies));
                    case 3 -> System.out.println(pharmacies1.updatePharmacyId(pharmacies));
                    case 4 -> System.out.println(pharmacies1.getAllPharmacy(pharmacies));
                    case 5 -> pharmacies1.deletePharmacyById(pharmacies);
                    case 6 -> System.out.println(pharmacies1.getPharmacyByAddress(pharmacies));
                    case 7 -> System.out.println(person.addPersonToPharmacy(pharmacies));
                    case 8 -> System.out.println(person.findPersonById(pharmacies));
                    case 9 -> System.out.println(person.updatePersonName(pharmacies));
                    case 10 -> System.out.println(person.getAllPharmacyStaff(pharmacies));
                    case 11 -> person.deletePersonFromPharmacy(pharmacies);
                    case 12 -> System.out.println(medicine.addMedicineToPharmacy(pharmacies));
                    case 13 -> System.out.println(medicine.findMedicineByName(pharmacies));
                    case 14 -> System.out.println(medicine.getAllMedicine(pharmacies));
                    case 15 -> medicine.deleteMedicine(pharmacies);
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}