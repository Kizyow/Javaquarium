package fr.kizyow.javaquarium.poissons.carnivores;

import fr.kizyow.javaquarium.entities.Race;
import fr.kizyow.javaquarium.entities.Sex;
import fr.kizyow.javaquarium.entities.SexType;

public class Thon extends Carnivore {

    public Thon(String name, Sex sex, int age) {
        super(name, sex, SexType.MONOSEXUE, age, Race.THON);
    }

}
