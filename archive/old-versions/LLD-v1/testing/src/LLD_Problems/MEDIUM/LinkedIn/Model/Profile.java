package LLD_Problems.MEDIUM.LinkedIn.Model;

import java.util.List;

public class Profile {private String profilePicture;
    private String headline;
    private String summary;
    private List<Experience> experiences;
    private List<Education> educations;
    private List<Skills> skills;

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getHeadline() {
        return headline;
    }

    public String getSummary() {
        return summary;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public List<Skills> getSkills() {
        return skills;
    }
}
