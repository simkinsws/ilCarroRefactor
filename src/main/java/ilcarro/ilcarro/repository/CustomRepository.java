package ilcarro.ilcarro.repository;

import ilcarro.ilcarro.dto.Comment;
import ilcarro.ilcarro.entities.UserMongo;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomRepository {
    List<UserMongo> getThreePopularCars();

//    @Query(fields = "{'comments.postDate': 1, _id: 0}")
//    List<UserMongo> findByCommentsPostDate();
    List<Comment> getLatestComments();
}
