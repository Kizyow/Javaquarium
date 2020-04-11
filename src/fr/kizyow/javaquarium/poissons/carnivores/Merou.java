package fr.kizyow.javaquarium.poissons.carnivores;

import fr.kizyow.javaquarium.entities.Race;
import fr.kizyow.javaquarium.entities.Sex;
import fr.kizyow.javaquarium.entities.SexType;

public class Merou extends Carnivore {

    public Merou(String name, Sex sex, int age){
        super(name, sex, SexType.HERMAPHRODITE, age, Race.MEROU);

    }

}
