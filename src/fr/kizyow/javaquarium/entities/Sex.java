package fr.kizyow.javaquarium.entities;

public enum Sex {

    MALE(0),
    FEMALE(1);

    private int binary;

    Sex(int binary) {
        this.binary = binary;
    }

    public static Sex fromBinary(int binary){
        for(Sex sex : values()){
            if(binary == sex.binary){
                return sex;
            }
        }
        return MALE;
    }

}
