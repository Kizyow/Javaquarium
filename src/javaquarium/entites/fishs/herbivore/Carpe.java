package javaquarium.entites.fishs.herbivore;

import javaquarium.entites.Sexe;
import javaquarium.entites.fishs.Poisson;
import javaquarium.entites.fishs.SexePoisson;

import java.io.Serializable;

public class Carpe extends Poisson implements Serializable {

    public Carpe(String name, int age, Sexe gender) {
        super(name, age, gender, new AlimentationHerbivore(), "Carpe", SexePoisson.MONOSEXUE);
    }

}
