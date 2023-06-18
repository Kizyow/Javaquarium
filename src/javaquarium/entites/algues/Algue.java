package javaquarium.entites.algues;

import javaquarium.Aquarium;
import javaquarium.entites.EtreVivant;

import java.io.Serializable;

public class Algue extends EtreVivant implements Serializable {

    public Algue(int age) {
        setAge(age);
    }

    @Override
    public void evoluer(Aquarium aquarium) {
        this.ajouterPV(1);
        this.augmenterAge();
        this.reproduction(aquarium);
    }

    @Override
    public void reproduction(Aquarium aquarium) {
        if (this.getPV() >= 10) {
            int pv = this.getPV() / 2;
            Algue algue = aquarium.ajouterAlgue(0);
            algue.setPV(pv);
            this.setPV(pv);
        }
    }

    @Override
    public String toString() {
        return "Algue{" +
                "pv='" + getPV() + '\'' +
                "age='" + getAge() + '\'' +
                '}';
    }
}
