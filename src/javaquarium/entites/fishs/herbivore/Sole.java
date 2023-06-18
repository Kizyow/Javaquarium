package javaquarium.entites.fishs.herbivore;

import javaquarium.entites.Sexe;
import javaquarium.entites.fishs.Poisson;
import javaquarium.entites.fishs.SexePoisson;

import java.io.Serializable;

public class Sole extends Poisson implements Serializable {

    public Sole(String name, int age, Sexe gender) {
        super(name, age, gender, new AlimentationHerbivore(), "Sole", SexePoisson.HERMAPHRODITE_OPPORTUNISTE);
    }

}
