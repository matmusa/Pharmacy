package pharmacy.model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Pharmacy {
    private String name;
    private int id;
    private String adress;
    private ArrayList<Person> people;
    private ArrayList<Medicine> medicines;

    public Pharmacy() {
    }

    public Pharmacy(String name, int id, String adress, ArrayList<Person> people, ArrayList<Medicine> medicines) {
        this.name = name;
        this.id = id;
        this.adress = adress;
        this.people = people;
        this.medicines = medicines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<Medicine> medicines) {
        this.medicines = medicines;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "\nname='" + name + '\'' +
                "\n id=" + id +
                "\nadress='" + adress + '\'' +
                "\npeople=" + people +
                "\nmedicines=" + medicines +
                '}';
    }
}
