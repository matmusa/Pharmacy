package pharmacy.interfaces;

import pharmacy.model.Medicine;
import pharmacy.model.Pharmacy;

import java.util.List;

public interface MedicineFunction {
    Medicine addMedicineToPharmacy(List<Pharmacy> pharmacies);

    Medicine findMedicineByName(List<Pharmacy> pharmacies);

    List<Medicine> getAllMedicine(List<Pharmacy> pharmacies);
    void deleteMedicine(List<Pharmacy> pharmacies);


}
