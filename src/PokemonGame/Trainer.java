package PokemonGame;

public class Trainer {
    private String name;
    private char gender;
    private StorageSys teamID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public StorageSys getTeamID() {
        return teamID;
    }

    public void setTeamID(StorageSys teamID) {
        this.teamID = teamID;
    }


}
