package LLD_Problems.MEDIUM.FaceBook.Model;

public class Profile {
    private String profilePicture;
    private String biography;
    private String interests;

    public Profile(String profilePicture, String biography, String interests) {
        this.profilePicture = profilePicture;
        this.biography = biography;
        this.interests = interests;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }
}
