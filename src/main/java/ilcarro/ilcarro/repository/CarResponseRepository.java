package ilcarro.ilcarro.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ilcarro.ilcarro.dto.carDto.CarResponseOwnerDto;

@Repository
public interface CarResponseRepository extends MongoRepository<CarResponseOwnerDto, String>, CustomRepository {
	@Query(fields = "{'ownCars.pickUpPlace.placeId':':city'}")
	List<CarResponseOwnerDto> findByBookedPeriod(@Param("city") String city, String startDate, String endDate, String minAmount,
			String maxAmount, String ascending, String itemOnPage, String currentPage);
}
