package fr.kizyow.javaquarium.poissons.herbivores;

import fr.kizyow.javaquarium.entities.Race;
import fr.kizyow.javaquarium.entities.Sex;
import fr.kizyow.javaquarium.entities.SexType;

public class Sole extends Herbivore {

    public Sole(String name, Sex sex, int age) {
        super(name, sex, SexType.OPPORTUNISTE, age, Race.SOLE);
    }

}
