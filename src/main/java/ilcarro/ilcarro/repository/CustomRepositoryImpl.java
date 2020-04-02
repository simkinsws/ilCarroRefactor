package ilcarro.ilcarro.repository;

import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.internal.MongoDatabaseImpl;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Aggregates.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.UnwindOptions;
import com.mongodb.util.JSON;
import ilcarro.ilcarro.dto.CarGetter;
import ilcarro.ilcarro.dto.Comment;
import ilcarro.ilcarro.dto.carDto.CarResponseDto;
import ilcarro.ilcarro.dto.carDto.CarResponseOwnerDto;
import ilcarro.ilcarro.entities.CarMongo;
import ilcarro.ilcarro.entities.UserMongo;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;

import javax.print.Doc;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomRepositoryImpl implements CustomRepository {
    MongoTemplate mongoTemplate;
    @Autowired
    MongoOperations mongoOperations;

    MongoClientURI uri = new MongoClientURI("mongodb+srv://simkin:bhrxhnehi12@cluster0-8qosm.mongodb.net/testilcarro?retryWrites=true&w=majority");
    MongoClient client = new MongoClient(uri);
    MongoDatabase db = client.getDatabase("testilcarro");
    MongoCollection<Document> collection;
    /*
     MongoClientURI uri = new MongoClientURI("mongodb+srv://simkin:bhrxhnehi12@cluster0-8qosm.mongodb.net/testilcarro?retryWrites=true&w=majority");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase("testilcarro");
     */

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

    @Override
    public List<CarMongo> searchCar(String city) {
        Query query = new Query()
                .addCriteria(Criteria.where("pickUpPlace.placeId").is(city));
        return this.mongoOperations.find(query, UserMongo.class).stream()
                .flatMap(u -> u.getOwnCars().parallelStream())
                .collect(Collectors.toList());
    }

    @Override
    public Page<CarGetter> findByFilters(DynamicQuery dynamicQuery, Pageable pageable) {
        final Query query = new Query();
        query.with(pageable);
        final List<Criteria> criteria = new ArrayList<>();
        if(dynamicQuery.getMakeLike() != null) {
            criteria.add(Criteria.where("make").regex(dynamicQuery.getMakeLike()));
        }
        if(dynamicQuery.getModelLike() != null) {
            criteria.add(Criteria.where("model").regex(dynamicQuery.getModelLike()));
        }
        if(dynamicQuery.getYearLike()!= null) {
            criteria.add(Criteria.where("year").is(dynamicQuery.getYearLike()));
        }
        if(dynamicQuery.getEngineLike() != null) {
            criteria.add(Criteria.where("engine").regex(dynamicQuery.getEngineLike()));
        }
        if(dynamicQuery.getFuelLike() != null) {
            criteria.add(Criteria.where("fuel").regex(dynamicQuery.getFuelLike()));
        }
        if(dynamicQuery.getGearLike() != null) {
            criteria.add(Criteria.where("gear").regex(dynamicQuery.getGearLike()));
        }
        if(dynamicQuery.getWheelsDriveLike() != null) {
            criteria.add(Criteria.where("wheelsDrive").regex(dynamicQuery.getWheelsDriveLike()));
        }
        if(dynamicQuery.getFuelConsumptionLessThan() != null) {
            criteria.add(Criteria.where("fuelConsumption").lte(dynamicQuery.getFuelConsumptionGreaterThan())
            .gte(dynamicQuery.getFuelConsumptionLessThan()));
        }
        if(!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        }
        List<CarGetter> filterCars =
                mongoTemplate.find(query, CarGetter.class, "users");
        Page<CarGetter> carGetterPage = PageableExecutionUtils.getPage(
                filterCars,
                pageable,
                () -> mongoTemplate.count(query, CarGetter.class));
        return carGetterPage;
    }

    @Override
    public void findCommentBySerialNumber() {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://simkin:bhrxhnehi12@cluster0-8qosm.mongodb.net/testilcarro?retryWrites=true&w=majority");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase("testilcarro");
        MongoCollection<Document> collection = db.getCollection("users");

        FindIterable<Document> cursor = collection.find(Filters.eq("ownCars.pickUpPlace.placeId", "london"))
                .projection(Projections.include("ownCars.pickUpPlace.placeId"));


        AggregateIterable<Document> aggregateIterable = collection.aggregate(Arrays.asList(
                Aggregates.unwind("$ownCars"),
                Aggregates.match(Filters.eq("ownCars.pickUpPlace.placeId", "city1")),
                Aggregates.project(new Document("ownCars.pickUpPlace.placeId", 1).append("_id", 0))
                )
        );

        aggregateIterable.forEach((Block<Document>) document -> System.out.println(document.toJson()));
//        for(Document document : cursor) {
//            List<Document> ownCars = document.get("ownCars",List.class);
//            for(Document d : ownCars) {
//                System.out.println("ownCars = " + d.get("pickUpPlace"));
//                }
//            }
//        }
//        FindIterable<Document> database = db.getCollection("users").find();
//        System.out.println("doc =" + doc.toJson());
//        List<CarResponseOwnerDto> comments = doc.get("placeId",List.class);
//        System.out.println("try =" + comments);
//        while(iterator.hasNext()) {
//            Document doc = iterator.next();
//            String post = doc.getString("");
//            System.out.println("Post : "+ post);
//        }
//        return comments;

//        Query query = new Query();
//        query.addCriteria(Criteria.where("ownCars.pickUpPlace.placeId").is("city1"));
//        FindIterable<Document> cursor = users.find(query.getQueryObject());
//        MongoCursor<Document> iterator = cursor.iterator();
    }

    @Override
    public List<CarMongo> findCarByCity(String city) {
        collection = db.getCollection("users");
  List<CarMongo> cars = new ArrayList<>();
        AggregateIterable<Document> output = collection.aggregate(Arrays.asList(
                Aggregates.unwind("$ownCars"),
                Aggregates.match(Filters.eq("ownCars.pickUpPlace.placeId", "city1")),
                Aggregates.project(new Document("ownCars.pickUpPlace.placeId", 1).append("_id", 0))
        ));
//        List<CarResponseDto> cars = mongoTemplate.aggregate(new Aggregation())
         for(Document obj : output) {
             cars.add ((CarMongo) obj.get("ownCars.pickUpPlace.placeId"));
         }
         return (List<CarMongo>) mongoTemplate.getConverter().convertToMongoType(cars.toString());
    }

    @Override
    public List<Comment> latestComments() {
        Query query = new Query();
        query.fields().include("comments.postDate").include("comments.post").include("comments.firstName")
                .include("comments.secondName").include("comments.photoUrl").exclude("_id");
        List<Comment> comments = mongoOperations.find(query,UserMongo.class)
                .stream().flatMap(m-> m.getComments().parallelStream())
                .sorted(Comparator.comparing(Comment::getPostDate).reversed())
                .limit(6)
                .collect(Collectors.toList());
        return comments;
    }

}
