package fr.kizyow.javaquarium.poissons;

import fr.kizyow.javaquarium.entities.Entity;
import fr.kizyow.javaquarium.entities.Race;
import fr.kizyow.javaquarium.entities.Sex;
import fr.kizyow.javaquarium.entities.SexType;
import fr.kizyow.javaquarium.poissons.carnivores.Merou;
import fr.kizyow.javaquarium.poissons.carnivores.PoissonClown;
import fr.kizyow.javaquarium.poissons.carnivores.Thon;
import fr.kizyow.javaquarium.poissons.herbivores.Bar;
import fr.kizyow.javaquarium.poissons.herbivores.Carpe;
import fr.kizyow.javaquarium.poissons.herbivores.Sole;

import java.util.Random;

public abstract class Poisson extends Entity {

    private final String name;
    private Sex sex;
    private final SexType sexType;
    private final Race race;

    public Poisson(String name, Sex sex, SexType sexType, int age, Race race){
        this.name = name;
        this.sex = sex;
        this.sexType = sexType;
        this.setAge(age);
        this.race = race;

    }

    public abstract void eat(Entity entity);

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Race getRace() {
        return race;
    }

    public SexType getSexType() {
        return sexType;
    }

    @Override
    public void growAge() {
        super.growAge();
        if(getAge() >= 10 && this.sexType == SexType.HERMAPHRODITE){
            if(sex == Sex.MALE) setSex(Sex.FEMALE);
            else setSex(Sex.MALE);
            System.out.println("nouveau sex agé wtf");
        }

    }

    @Override
    public String toString(){
        return "Poisson{name='" + name + ", sex=" + sex + ", life=" + getLife() + ", age=" + getAge() +"}";

    }

    @Override
    public Poisson sex(Entity entity){

        Poisson poisson = (Poisson) entity;

        if(this.sexType == SexType.OPPORTUNISTE){
            if(sex == Sex.MALE) setSex(Sex.FEMALE);
            else setSex(Sex.MALE);
            System.out.println("nouveau sex opprtun wtf");
        }

        if(this.getLife() >= 5 && poisson.getRace() == this.getRace() && poisson.getSex() != this.getSex()){

            Random random = new Random();
            int bin = random.nextInt(2);

            Sex sex = Sex.fromBinary(bin);

            Poisson baby = new Merou(this.getName() + poisson.getName(), sex, 0);

            if(this instanceof Merou) baby = new Merou(this.getName() + poisson.getName(), sex, 0);
            if(this instanceof PoissonClown) new PoissonClown(this.getName() + poisson.getName(), sex, 0);
            if(this instanceof Thon) baby = new Thon(this.getName() + poisson.getName(), sex, 0);
            if(this instanceof Bar) baby = new Bar(this.getName() + poisson.getName(), sex, 0);
            if(this instanceof Carpe) baby = new Carpe(this.getName() + poisson.getName(), sex, 0);
            if(this instanceof Sole) baby = new Sole(this.getName() + poisson.getName(), sex, 0);

            return baby;

        }

        return null;

    }

}
