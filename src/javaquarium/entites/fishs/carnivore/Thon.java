package javaquarium.entites.fishs.carnivore;

import javaquarium.entites.Sexe;
import javaquarium.entites.fishs.Poisson;
import javaquarium.entites.fishs.SexePoisson;

import java.io.Serializable;

public class Thon extends Poisson implements Serializable {

    public Thon(String name, int age, Sexe gender) {
        super(name, age, gender, new AlimentationCarnivore(), "Thon", SexePoisson.MONOSEXUE);
    }

}
