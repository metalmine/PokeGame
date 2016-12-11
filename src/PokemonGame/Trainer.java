package PokemonGame;

public class Trainer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private char gender;

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

    private StorageSys teamID;

}
