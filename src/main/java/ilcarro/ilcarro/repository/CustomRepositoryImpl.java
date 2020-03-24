package ilcarro.ilcarro.repository;

import ilcarro.ilcarro.dto.Comment;
import ilcarro.ilcarro.entities.UserMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class CustomRepositoryImpl implements CustomRepository {
    MongoTemplate mongoTemplate;

    @Autowired
    public CustomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @Override
    public List<UserMongo> getThreePopularCars() {
        Query query = new Query();
        query.addCriteria(Criteria.where("ownCars.bookedPeriod").gte(10));
        query.with(Sort.by(Sort.Order.desc("ownCars.bookedPeriod"))).limit(3);
        return mongoTemplate.find(query, UserMongo.class);
    }

    @Override
    public List<Comment> getLatestComments() {
        Query query = new Query();
        query.addCriteria(Criteria.where("comments.firstName").is("nir"));
        //        query.with(Sort.by(Sort.Order.desc("firstName"))).limit(6);
        return mongoTemplate.find(query, Comment.class);
    }
}
