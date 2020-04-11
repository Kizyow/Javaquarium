package fr.kizyow.javaquarium.poissons.herbivores;

import fr.kizyow.javaquarium.entities.Race;
import fr.kizyow.javaquarium.entities.Sex;
import fr.kizyow.javaquarium.entities.SexType;

public class Carpe extends Herbivore {

    public Carpe(String name, Sex sex, int age) {
        super(name, sex, SexType.MONOSEXUE, age, Race.CARPE);
    }

}
