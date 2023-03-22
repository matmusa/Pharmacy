package pharmacy.impl;

import pharmacy.exception.MyException;
import pharmacy.model.Person;
import pharmacy.model.Pharmacy;
import pharmacy.interfaces.PersonFunction;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PersonImpl implements PersonFunction {
    @Override
    public Person addPersonToPharmacy(ArrayList<Pharmacy> pharmacies) {
        Person person = new Person();
        try {
            System.out.println("Enter pharmacy id: ");
            int pharmacyId = new Scanner(System.in).nextInt();
            for (Pharmacy p : pharmacies) {
                if (p.getId() == pharmacyId) {
                    System.out.println("Enter first name: ");
                    String name = new Scanner(System.in).nextLine();
                    person.setFirstName(name);
                    System.out.println("Enter last name: ");
                    String lastName = new Scanner(System.in).nextLine();
                    person.setLastName(lastName);
                    System.out.println("Enter email (@): ");
                    String email = new Scanner(System.in).nextLine();
                    if (!email.contains("@")) {
                        throw new MyException("Email must contains '@'!");
                    }
                    for (Pharmacy pharmacy : pharmacies) {
                        if (!pharmacy.getPeople().isEmpty()) {
                            for (Person person1 : pharmacy.getPeople()) {
                                if (person1.getEmail().equals(email)) {
                                    throw new MyException("same gmail!!");

                                } else {
                                    person.setEmail(email);
                                }
                            }

                        } else {
                            person.setEmail(email);
                            person.setId(p.getPeople().size()+1);
                            return person;
                        }
                    }


                }


            }


        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


    @Override
    public Person findPersonById(ArrayList<Pharmacy> pharmacies) {
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

                int idPeople = new Scanner(System.in).nextInt();
                for (Pharmacy i : pharmacies1) {
                    for (Person u : i.getPeople()) {
                        if (u.getId() == idPeople) {
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
            System.out.println("write a only numbers!");
        }
        return null;

    }


    @Override
    public List<Person> getAllPharmacyStaff(ArrayList<Pharmacy> pharmacies) {
        ArrayList<Person> people = new ArrayList<>();
        boolean isTrue = true;
        System.out.println("Write a id of pharmacy  :");
        int name = new Scanner(System.in).nextInt();
        try {
            for (Pharmacy p : pharmacies) {
                if (p.getId() == name) {
                    people.addAll(p.getPeople());
                    return people;

                } else {
                    isTrue = false;
                }
            }
            if (!isTrue) {
                throw new MyException("Uncorrect id!!!");
            }


        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("write a only numbers!");
        }
        return null;

    }


    @Override
    public Person updatePersonName(ArrayList<Pharmacy> pharmacies) {
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
                System.out.println("Write a id of staff  :");
                int idPeople = new Scanner(System.in).nextInt();
                for (Pharmacy i : pharmacies1) {
                    for (Person u : i.getPeople()) {
                        if (u.getId() == idPeople) {
                            System.out.println("Write new name of person");
                            String name12 = new Scanner(System.in).nextLine();
                            u.setFirstName(name12);
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
            System.out.println("write a only numbers!");
        }
        return null;

    }


    @Override
    public void deletePersonFromPharmacy(ArrayList<Pharmacy> pharmacies) {
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
                System.out.println("Write a id of staff  :");
                int idPeople = new Scanner(System.in).nextInt();
                for (Pharmacy i : pharmacies1) {
                    for (Person u : i.getPeople()) {
                        if (u.getId() == idPeople) {
                            i.getPeople().remove(u);

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

