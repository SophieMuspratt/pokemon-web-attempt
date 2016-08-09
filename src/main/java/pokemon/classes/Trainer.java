package pokemon.classes;

public class Trainer {

    private String trainerName;
    private String trainerAge;
    private String trainerGender;

    public Trainer(String trainerName, String trainerAge, String trainerGender) {
        this.trainerName = trainerName;
        this.trainerAge = trainerAge;
        this.trainerGender = trainerGender;
    }

    public String getTrainerName(){
        return trainerName;
    }

    public String getTrainerAge(){
        return trainerAge;
    }

    public String getTrainerGender(){
        return trainerGender;
    }

}
