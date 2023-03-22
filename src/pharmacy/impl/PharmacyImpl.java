package pharmacy.impl;

import pharmacy.exception.MyException;
import pharmacy.model.Medicine;
import pharmacy.model.Person;
import pharmacy.model.Pharmacy;
import pharmacy.interfaces.PharmacyFunction;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PharmacyImpl implements PharmacyFunction {
    @Override
    public Pharmacy addPharmacy(List<Pharmacy> pharmacies) {
        Pharmacy pharmacy = new Pharmacy();
        boolean isTrue = true;
        while (isTrue) {
            try {
                System.out.println("Write s name pharmacy :");
                String name = new Scanner(System.in).nextLine();
                pharmacy.setName(name);
                ArrayList<Person> people = new ArrayList<>();
                ArrayList<Medicine> medicines = new ArrayList<>();
                pharmacy.setPeople(people);
                pharmacy.setMedicines(medicines);
                System.out.println("Write a adress of pharmacy: ");
                String adress = new Scanner(System.in).nextLine();
                pharmacy.setAdress(adress);
                if (!pharmacies.isEmpty()) {
                    for (Pharmacy p : pharmacies) {
                        if (p.getName().equalsIgnoreCase(name)) {
                            pharmacy.setId(pharmacies.size() + 1);
                            pharmacies.add(pharmacy);
                            isTrue = false;
                            throw new MyException("Same pharmacay name !");
                        } else {
                            isTrue = false;
                            pharmacy.setId(pharmacies.size() + 1);
                            pharmacies.add(pharmacy);
                            return pharmacy;
                        }
                    }
                } else {
                    isTrue = false;
                    pharmacy.setName(name);
                    pharmacy.setPeople(people);
                    pharmacy.setMedicines(medicines);
                    pharmacy.setId(pharmacies.size() + 1);
                    pharmacies.add(pharmacy);
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
        return pharmacy;


    }


    @Override
    public Pharmacy getPharmacyById(List<Pharmacy> pharmacies) {
        ArrayList<Pharmacy> pharmacies1 = new ArrayList<>();
        System.out.println("write a id of pharmacy: ");
        int id = new Scanner(System.in).nextInt();
        try {
            for (Pharmacy p : pharmacies
            ) {
                if (p.getId() == id) {
                    pharmacies1.add(p);
                    break;
                }

            }
            if (!pharmacies1.isEmpty()) {
                for (Pharmacy p : pharmacies1
                ) {
                    return p;
                }
            } else {
                throw new MyException("Uncorect id");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Pharmacy> getAllPharmacy(List<Pharmacy> pharmacies) {
        return pharmacies;
    }

    @Override
    public List<Pharmacy> getPharmacyByAddress(List<Pharmacy> pharmacies) {
        ArrayList<Pharmacy> pharmacies1 = new ArrayList<>();
        ArrayList<Pharmacy> pharmacies2 = new ArrayList<>();
        boolean isTrue = true;
        System.out.println("write a adress of pharmacy: ");
        String id = new Scanner(System.in).nextLine();
        try {
            for (Pharmacy p : pharmacies
            ) {
                if (p.getAdress().equalsIgnoreCase(id)) {
                    pharmacies1.add(p);
                    isTrue = true;
                    break;
                } else {
                    isTrue = false;
                }

            }
            if (!pharmacies1.isEmpty()) {
                for (Pharmacy p : pharmacies1
                ) {
                    pharmacies2.add(p);
                    return pharmacies2;
                }
            } else if (isTrue) {
                throw new MyException("Uncorrect adress!!!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("write a only numbers!");
        }
        return pharmacies2;
    }

    @Override
    public Pharmacy updatePharmacyId(List<Pharmacy> pharmacies) {
        ArrayList<Pharmacy> pharmacies1 = new ArrayList<>();
        System.out.println("Write id of  pharmacy :");
        int name = new Scanner(System.in).nextInt();

        for (Pharmacy p : pharmacies
        ) {
            if (p.getId() == name) {
                pharmacies1.add(p);
                break;
            }
        }
        try {
            if (!pharmacies1.isEmpty()) {
                for (Pharmacy p : pharmacies1
                ) {
                    System.out.println("write a new name of pharmacy :");
                    String name1 = new Scanner(System.in).nextLine();
                    p.setName(name1);
                    return p;

                }

            } else {
                throw new MyException("Uncorrect pharmacy name!!!");
            }


        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deletePharmacyById(List<Pharmacy> pharmacies) {
        ArrayList<Pharmacy> pharmacies1 = new ArrayList<>();
        System.out.println("Write a id of  pharmacy :");
        int id = new Scanner(System.in).nextInt();

        for (Pharmacy p : pharmacies
        ) {
            if (p.getId() == id) {
                pharmacies1.add(p);
                break;
            }
        }
        try {
            if (!pharmacies1.isEmpty()) {
                for (Pharmacy p : pharmacies1
                ) {
                    pharmacies.remove(p);
                    System.out.println(p + "secsesfully removed !!");
                }

            } else {
                throw new MyException("Uncorrect pharmacy name!!!");
            }


        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }
}
