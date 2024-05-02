package DataObjects;

public class Weakness {
    public int weaknessID;
    public String weaknessName;
    public String weaknessDescription;

    public Weakness(int weaknessID, String weaknessName, String weaknessDescription) {
        this.weaknessID = weaknessID;
        this.weaknessName = weaknessName;
        this.weaknessDescription = weaknessDescription;
    }

    public int getWeaknessID() {
        return weaknessID;
    }

    public void setWeaknessID(int weaknessID) {
        this.weaknessID = weaknessID;
    }

    public String getWeaknessName() {
        return weaknessName;
    }

    public void setWeaknessName(String weaknessName) {
        this.weaknessName = weaknessName;
    }

    public String getWeaknessDescription() {
        return weaknessDescription;
    }

    public void setWeaknessDescription(String weaknessDescription) {
        this.weaknessDescription = weaknessDescription;
    }
}
