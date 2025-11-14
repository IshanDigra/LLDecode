package AsishPratapProblems.HARD.LinkedIn.Entities;

public class Profile {
    private String name;
    private String education;

    public Profile(String name, String education) {
        this.name = name;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
