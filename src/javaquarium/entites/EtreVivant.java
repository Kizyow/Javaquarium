package javaquarium.entites;

import javaquarium.Aquarium;

import java.io.Serializable;

public abstract class EtreVivant implements Serializable {

    private int pv;
    private int age;

    public EtreVivant() {
        this.pv = 10;
    }

    public boolean estMort() {
        return pv <= 0 || age > 20;
    }

    public void ajouterPV(int pv) {
        this.pv += pv;
    }

    public void retirerPV(int pv) {
        this.pv -= pv;
    }

    public int getPV() {
        return pv;
    }

    public void setPV(int pv) {
        this.pv = pv;
    }

    public void augmenterAge(){
        this.age += 1;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void evoluer(Aquarium aquarium);

    public abstract void reproduction(Aquarium aquarium);

    @Override
    public String toString() {
        return "EtreVivant{" +
                "pv=" + pv +
                ", age=" + age +
                '}';
    }
}
