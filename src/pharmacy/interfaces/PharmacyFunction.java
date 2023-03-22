package pharmacy.interfaces;

import pharmacy.model.Pharmacy;

import java.util.ArrayList;
import java.util.List;

public interface PharmacyFunction {


    Pharmacy addPharmacy(List<Pharmacy> pharmacies);

    Pharmacy getPharmacyById(List<Pharmacy> pharmacies);

    List<Pharmacy> getAllPharmacy(List<Pharmacy> pharmacies);

    List<Pharmacy> getPharmacyByAddress(List<Pharmacy> pharmacies);

    Pharmacy updatePharmacyId(List<Pharmacy> pharmacies);

    void deletePharmacyById(List<Pharmacy> pharmacies);
}