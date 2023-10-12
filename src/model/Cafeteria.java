package model;

import utils.Demonstrate;

public class Cafeteria implements Demonstrate {
    private int cafId;
    private String cafName;
    private String cafAddres;

    public Cafeteria(String cafName, String cafAddres) {
        this.cafId = (int) (Math.random() * 1000);
        this.cafName = cafName;
        this.cafAddres = cafAddres;
    }

    public Cafeteria() {
        this.cafId = (int) (Math.random() * 1000);
    }

    public int getCafId() {
        return cafId;
    }

    public void setCafId(int cafId) {
        this.cafId = cafId;
    }

    public String getCafName() {
        return cafName;
    }

    public void setCafName(String cafName) {
        this.cafName = cafName;
    }

    public String getCafAddres() {
        return cafAddres;
    }

    public void setCafAddres(String cafAddres) {
        this.cafAddres = cafAddres;
    }

    @Override
    public void demonstrate() {
        System.out.println(cafId + " " + cafName + " ул." + cafAddres);
        System.out.println("____________________________");
    }
}
