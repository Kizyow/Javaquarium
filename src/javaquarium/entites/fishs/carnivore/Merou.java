package javaquarium.entites.fishs.carnivore;

import javaquarium.entites.Sexe;
import javaquarium.entites.fishs.Poisson;
import javaquarium.entites.fishs.SexePoisson;

import java.io.Serializable;

public class Merou extends Poisson implements Serializable {

    public Merou(String name, int age, Sexe gender) {
        super(name, age, gender, new AlimentationCarnivore(), "Merou", SexePoisson.HERMAPHRODITE_AGE);
    }

}
