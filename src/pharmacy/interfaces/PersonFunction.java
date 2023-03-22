package pharmacy.interfaces;

import pharmacy.model.Person;
import pharmacy.model.Pharmacy;

import java.util.ArrayList;
import java.util.List;

public interface PersonFunction {
    Person addPersonToPharmacy(ArrayList<Pharmacy> pharmacies);

    Person findPersonById(ArrayList<Pharmacy> pharmacies);

    List<Person> getAllPharmacyStaff(ArrayList<Pharmacy> pharmacies);

    Person updatePersonName(ArrayList<Pharmacy> pharmacies);

    void deletePersonFromPharmacy(ArrayList<Pharmacy> pharmacies);
}
