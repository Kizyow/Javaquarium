package fr.kizyow.javaquarium.entities;

public abstract class Entity {

    private boolean dead = false;
    private int life = 10;
    private int age = 0;

    public void giveLife(int amount){
        life+= amount;
    }

    public void removeLife(int amount){
        life-= amount;
        if(life <= 0) kill();

    }

    public boolean isDead(){
        return dead || life <= 0;

    }

    public void kill(){
        this.dead = true;

    }

    public int getLife(){
        return life;

    }

    public void setLife(int life){
        this.life = life;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void growAge(){
        this.age++;
        if(age >= 20) kill();

    }
    public abstract Entity sex(Entity target);

}
