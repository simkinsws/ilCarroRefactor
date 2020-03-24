package ilcarro.ilcarro.dto.commentDto;

public class CommentRequestDto {

    private String post;

    public CommentRequestDto(String post) {
        this.post = post;
    }

    public CommentRequestDto() {
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
