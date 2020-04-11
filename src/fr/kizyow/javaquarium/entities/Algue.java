package fr.kizyow.javaquarium.entities;

public class Algue extends Entity {

    public Algue(int age){
        this.setAge(age);
    }

    @Override
    public String toString(){
        return "Algue{age=" + getAge() + ", life=" + getLife() +"}";

    }

    @Override
    public Algue sex(Entity entity){

        if(getLife() >= 10){
            int newLife = getLife()/2;
            Algue algue = new Algue(0);
            algue.setLife(newLife);
            this.removeLife(newLife);

            return algue;

        }

        return null;

    }
}
