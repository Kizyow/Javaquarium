package javaquarium.entites.fishs.carnivore;

import javaquarium.entites.Sexe;
import javaquarium.entites.fishs.Poisson;
import javaquarium.entites.fishs.SexePoisson;

import java.io.Serializable;

public class Clown extends Poisson implements Serializable {

    public Clown(String name, int age, Sexe gender) {
        super(name, age, gender, new AlimentationCarnivore(), "Poisson-clown", SexePoisson.HERMAPHRODITE_OPPORTUNISTE);
    }

}
