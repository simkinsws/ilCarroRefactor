package ilcarro.ilcarro.dto;

import java.time.LocalDate;


public class Comment {
    private String firstName;
    private String secondName;
    private String photoUrl;
    private LocalDate postDate;
    private String post;

    public Comment() {
    }

    public Comment(String firstName,
                   String secondName,
                   String photoUrl,
                   LocalDate postDate,
                   String post) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.photoUrl = photoUrl;
        this.postDate = postDate;
        this.post = post;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", postDate=" + postDate +
                ", post='" + post + '\'' +
                '}';
    }
}
