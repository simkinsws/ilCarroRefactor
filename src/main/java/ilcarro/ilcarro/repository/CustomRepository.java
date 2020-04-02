package ilcarro.ilcarro.repository;

import com.mongodb.client.MongoCollection;
import ilcarro.ilcarro.dto.CarGetter;
import ilcarro.ilcarro.dto.Comment;
import ilcarro.ilcarro.dto.carDto.CarResponseDto;
import ilcarro.ilcarro.dto.carDto.CarResponseOwnerDto;
import ilcarro.ilcarro.entities.CarMongo;
import ilcarro.ilcarro.entities.UserMongo;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomRepository {
    List<UserMongo> getThreePopularCars();

//    @Query(fields = "{'comments.postDate': 1, _id: 0}")
//    List<UserMongo> findByCommentsPostDate();
    List<Comment> getLatestComments();
    List<Comment> latestComments();
    List<CarMongo> searchCar(String city);
    Page<CarGetter> findByFilters(DynamicQuery dynamicQuery, Pageable pageable);
    void findCommentBySerialNumber();
    List<CarMongo> findCarByCity(String city);
}
