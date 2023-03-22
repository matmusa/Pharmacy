package pharmacy.impl;

import pharmacy.exception.MyException;
import pharmacy.model.Medicine;
import pharmacy.model.Person;
import pharmacy.model.Pharmacy;
import pharmacy.interfaces.MedicineFunction;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MedicineImpl implements MedicineFunction {
    @Override
    public Medicine addMedicineToPharmacy(List<Pharmacy> pharmacies) {
        System.out.println("Enter pharmacy id: ");
        int pharmacyId = new Scanner(System.in).nextInt();
        for (Pharmacy p : pharmacies) {
            if (p.getId() == pharmacyId) {
                System.out.println("Enter medicine name: ");
                String name = new Scanner(System.in).nextLine();
                System.out.println("Enter meicine price: ");
                int price = new Scanner(System.in).nextInt();

                try {
                    boolean isTrue = true;

                    for (Pharmacy pharmacy : pharmacies) {
                        if (pharmacy.getMedicines().isEmpty()) {
                            for (Medicine m : p.getMedicines()) {
                                if (m.getName().equals(name)) {
                                    isTrue = false;

                                } else {
                                    isTrue = true;
                                }
                            }
                        } else {
                            Medicine medicine = new Medicine();
                            medicine.setId(p.getMedicines().size() + 1);
                            medicine.setName(name);
                            medicine.setPrice(price);
                            return medicine;
                        }
                    }

                    if (isTrue) {
                        Medicine medicine = new Medicine();
                        medicine.setId(p.getMedicines().size() + 1);
                        medicine.setName(name);
                        medicine.setPrice(price);
                        return medicine;
                    } else if (!isTrue) {
                        throw new MyException("same medicine name!");
                    }

                } catch (MyException e) {
                    System.out.println();
                }
            }
        }

        return null;
    }

    @Override
    public Medicine findMedicineByName(List<Pharmacy> pharmacies) {
        ArrayList<Pharmacy> pharmacies1 = new ArrayList<>();
        boolean isTrue = true;
        System.out.println("Write a id of pharmacy  :");
        int idGroup = new Scanner(System.in).nextInt();

        try {
            for (Pharmacy p : pharmacies) {
                if (p.getId() == idGroup) {
                    pharmacies1.add(p);
                    break;
                } else {
                    isTrue = false;
                }
            }
            System.out.println("Write medicine name :");
            String medicineName = new Scanner(System.in).nextLine();
            {

                for (Pharmacy i : pharmacies1) {
                    for (Medicine u : i.getMedicines()) {
                        if (u.getName().equalsIgnoreCase(medicineName)) {
                            return u;
                        }
                    }
                }
            }
            if (!isTrue) {
                throw new MyException("Uncorrect id!!!");
            }


        } catch (
                MyException e) {
            System.out.println(e.getMessage());
        } catch (
                InputMismatchException e) {
            System.out.println("write a only words!");
        }
        return null;

    }

    @Override
    public List<Medicine> getAllMedicine(List<Pharmacy> pharmacies) {
        ArrayList<Medicine> medicines = new ArrayList<>();
        boolean isTrue = true;
        System.out.println("Write a id of pharmacy  :");
        int name = new Scanner(System.in).nextInt();
        try {
            for (Pharmacy p : pharmacies) {
                if (p.getId() == name) {
                    medicines.addAll(p.getMedicines());
                    return medicines;

                } else {
                    isTrue = false;
                }
            }
            if (!isTrue) {
                throw new MyException("Uncorrect id of pharmacy!!!");
            }


        } catch (MyException e) {
            System.out.println(e.getMessage());


        }
        return null;
    }

    @Override
    public void deleteMedicine(List<Pharmacy> pharmacies) {
        ArrayList<Pharmacy> pharmacies1 = new ArrayList<>();
        boolean isTrue = true;
        System.out.println("Write a id of pharmacy  :");
        int idGroup = new Scanner(System.in).nextInt();

        try {
            for (Pharmacy p : pharmacies) {
                if (p.getId() == idGroup) {
                    pharmacies1.add(p);
                    break;
                } else {
                    isTrue = false;
                }
            }
            {
                System.out.println("Write a id of medicine  :");
                int idMedicine = new Scanner(System.in).nextInt();
                for (Pharmacy i : pharmacies1) {
                    for (Medicine u : i.getMedicines()) {
                        if (u.getId() == idMedicine) {
                            i.getMedicines().remove(u);
                            System.out.println(u.getName() + "seccsesfully removed!!");
                        }
                    }
                }
            }
            if (!isTrue) {
                throw new MyException("Uncorrect id!!!");
            }


        } catch (
                MyException e) {
            System.out.println(e.getMessage());
        } catch (
                InputMismatchException e) {
            System.out.println("write a only numbers!");
        }

    }
}
