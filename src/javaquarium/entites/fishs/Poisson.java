package javaquarium.entites.fishs;

import javaquarium.Aquarium;
import javaquarium.Rapport;
import javaquarium.entites.EtreVivant;
import javaquarium.entites.Sexe;

import java.io.Serializable;

public class Poisson extends EtreVivant implements Serializable {

    private String nom;
    private Sexe sexe;
    private Alimentation alimentation;
    private String espece;
    private SexePoisson sexePoisson;

    public Poisson(String nom, int age, Sexe sexe, Alimentation alimentation, String espece, SexePoisson sexePoisson) {
        this.nom = nom;
        this.sexe = sexe;
        this.alimentation = alimentation;
        this.espece = espece;
        this.sexePoisson = sexePoisson;
        setAge(age);
    }

    public void seNourrir(Aquarium aquarium) {
        if (aFaim()) {
            alimentation.manger(this, aquarium);
        }
    }

    public boolean aFaim() {
        return getPV() > 0 && getPV() <= 5;
    }

    public void sexualite() {
        if (sexePoisson == SexePoisson.HERMAPHRODITE_AGE && getAge() == 10) {
            this.sexe = Sexe.changerSexualite(sexe);
            Rapport.info(this.getNom() + " change de sexe dû à son âge");
        }
    }

    public String getNom() {
        return nom;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public Alimentation getAlimentation() {
        return alimentation;
    }

    public String getEspece() {
        return espece;
    }

    @Override
    public void evoluer(Aquarium aquarium) {
        this.retirerPV(1);
        this.augmenterAge();
        this.sexualite();
        this.seNourrir(aquarium);
        this.reproduction(aquarium);
    }

    @Override
    public void reproduction(Aquarium aquarium) {
        if (!aFaim() && !estMort()) {

            int poissonIndex = aquarium.getRandom().nextInt(aquarium.getPoissons().size());
            Poisson poissonChoisi = aquarium.getPoissons().get(poissonIndex);

            if (this != poissonChoisi && poissonChoisi.getEspece().equals(this.getEspece())) {

                if (this.sexePoisson == SexePoisson.HERMAPHRODITE_OPPORTUNISTE && this.sexe == poissonChoisi.getSexe()) {
                    this.sexe = Sexe.changerSexualite(sexe);
                    Rapport.info(this.getNom() + " change de sexe afin de se reproduire avec un autre poisson de son espèce");
                }

                if (this.sexe != poissonChoisi.getSexe()) {

                    String nomJunior = "(" + poissonChoisi.getNom() + "/" + this.getNom() + ")";
                    Sexe sexeJunior = Sexe.random();
                    Poisson poisson = PoissonFactory.creerPoisson(nomJunior, 0, sexeJunior, this.getEspece());
                    aquarium.ajouterPoisson(poisson);

                    //Rapport.info("Le poisson " + this.getNom() + " s'est reproduit avec " + poissonChoisi.getNom() + " et a fait naître " + poisson);
                }

            }

        }

    }

    @Override
    public String toString() {
        return "Poisson{" +
                "nom='" + nom + '\'' +
                ", sexe=" + sexe +
                ", alimentation=" + alimentation +
                ", pv=" + getPV() +
                ", age=" + getAge() +
                ", espece='" + espece + '\'' +
                '}';
    }
}
