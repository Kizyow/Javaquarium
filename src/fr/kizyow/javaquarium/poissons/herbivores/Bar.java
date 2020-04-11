package fr.kizyow.javaquarium.poissons.herbivores;

import fr.kizyow.javaquarium.entities.Race;
import fr.kizyow.javaquarium.entities.Sex;
import fr.kizyow.javaquarium.entities.SexType;

public class Bar extends Herbivore {

    public Bar(String name, Sex sex, int age) {
        super(name, sex, SexType.HERMAPHRODITE, age, Race.BAR);
    }

}
