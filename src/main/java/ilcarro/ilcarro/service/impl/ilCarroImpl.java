package ilcarro.ilcarro.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import ilcarro.ilcarro.api.ilCarroReturnCode;
import ilcarro.ilcarro.dto.Comment;
import ilcarro.ilcarro.dto.Renter;
import ilcarro.ilcarro.dto.bookingDto.BookedCarDto;
import ilcarro.ilcarro.dto.bookingDto.BookedPeriodDto;
import ilcarro.ilcarro.dto.carDto.CarRequestDto;
import ilcarro.ilcarro.dto.carDto.CarResponseDto;
import ilcarro.ilcarro.dto.carDto.CarResponseOwnerDto;
import ilcarro.ilcarro.dto.carDto.OwnerDto;
import ilcarro.ilcarro.dto.commentDto.CommentRequestDto;
import ilcarro.ilcarro.dto.reservationDto.ReservationRequestDto;
import ilcarro.ilcarro.dto.reservationDto.ReservationResponseDto;
import ilcarro.ilcarro.dto.userDto.UserRequestDto;
import ilcarro.ilcarro.dto.userDto.UserResponseDto;
import ilcarro.ilcarro.entities.BookedCarMongo;
import ilcarro.ilcarro.entities.CarMongo;
import ilcarro.ilcarro.entities.OwnerBookedPeriod;
import ilcarro.ilcarro.entities.RenterBookedPeriod;
import ilcarro.ilcarro.entities.UserMongo;
import ilcarro.ilcarro.exceptions.errors.CarNotFoundException;
import ilcarro.ilcarro.exceptions.errors.UserNotFoundException;
import ilcarro.ilcarro.repository.ilCarroRepository;
import ilcarro.ilcarro.service.ilCarroService;

@Service
public class ilCarroImpl implements ilCarroService {

	@Autowired
	private ilCarroRepository ilCarroRepository;
	@Autowired
	private PasswordEncoder bcryptEncode;
	private static long CURRENT_ORDER_ID = 0;

	@Override
	@Transactional
	public UserResponseDto registerUser(UserRequestDto userRequestDto) {
		if (ilCarroRepository.existsById(userRequestDto.getEmail())) {
			return null;
		}

		UserMongo userMongo = new UserMongo(userRequestDto.getEmail(), userRequestDto.getFirstName(),
				userRequestDto.getSecondName(), userRequestDto.getPhotoUrl(), userRequestDto.getPhone(),
				bcryptEncode.encode(userRequestDto.getPassword()), getCurrentDate(), new ArrayList<Comment>(),
				new ArrayList<CarMongo>(), new ArrayList<BookedCarMongo>(), new ArrayList<BookedCarMongo>());
		ilCarroRepository.save(userMongo);

		return toUserDto(userMongo);
	}

	@Override
	@Transactional
	public UserResponseDto updateUser(String email, UserRequestDto userRequestDto) {
		UserMongo userMongo = ilCarroRepository.findById(email).orElse(null);

		if (userMongo == null) {
			throw new UserNotFoundException("User " + email + " Not Found.");
		}
		userMongo.setFirstName(userRequestDto.getFirstName());
		userMongo.setSecondName(userRequestDto.getSecondName());
		userMongo.setPhotoUrl(userRequestDto.getPhotoUrl());
		userMongo.setPhone(userRequestDto.getPhone());
		ilCarroRepository.save(userMongo);
		return toUserDto(userMongo);
	}

	@Override
	@Transactional
	public ilCarroReturnCode deleteUser(String email) {
		UserMongo user = ilCarroRepository.findById(email).orElse(null);
		if (user.getEmail().equals(email)) {
			ilCarroRepository.delete(user);
			return ilCarroReturnCode.OK;
		} else {
			return ilCarroReturnCode.UNAUTHORIZED;
		}

	}

	@Override
	@Transactional
	public CarResponseOwnerDto addCar(CarRequestDto carRequestDto, String email) {

		if (carRequestDto.getSerialNumber().length() < 7 && carRequestDto.getSerialNumber().length() > 8) {
			throw new UserNotFoundException("CAR MUST BE 7-8 digits");
		}

		if (!isSerialNumberUnique(carRequestDto.getSerialNumber())) {
			throw new CarNotFoundException("Car Already Exists");
		}

		UserMongo userMongo = ilCarroRepository.findById(email)
				.orElseThrow(() -> new UserNotFoundException("User with email " + email + " is not found"));
		CarMongo carMongo = new CarMongo(carRequestDto.getSerialNumber(), carRequestDto.getMake(),
				carRequestDto.getModel(), carRequestDto.getYear(), carRequestDto.getEngine(), carRequestDto.getFuel(),
				carRequestDto.getGear(), carRequestDto.getWheelsDrive(), carRequestDto.getDoors(),
				carRequestDto.getSeats(), carRequestDto.getFuelConsumption(), carRequestDto.getFeatures(),
				carRequestDto.getCarClass(), carRequestDto.getPricePerDay(), carRequestDto.getDistance(),
				carRequestDto.getAbout(), carRequestDto.getPickUpPlace(), carRequestDto.getImageUrl(),
				new ArrayList<OwnerBookedPeriod>());

		userMongo.getOwnCars().add(carMongo);
		ilCarroRepository.save(userMongo);

		return toCarResponseOwnerDto(userMongo.getFirstName(), userMongo.getSecondName(),
				userMongo.getRegistrationDate(), carMongo);
	}

	@Override
	public CarResponseDto getOwnerCarById(String email, String serialNumber) {
		UserMongo owner = ilCarroRepository.findById(email)
				.orElseThrow(() -> new UserNotFoundException("User Not Found :" + email));
		CarMongo car = owner.getOwnCars().stream().filter(c -> c.getSerialNumber().equals(serialNumber)).findFirst()
				.orElseThrow(() -> new CarNotFoundException("Car with serialNumber : " + serialNumber + " not Found"));
		return toCarResponseDto(car);
	}

	@Override
	public List<CarResponseDto> getOwnerCarsById(String email) {
		UserMongo userMongo = ilCarroRepository.findCarsByOwnerEmail(email);
		if (userMongo == null) {
			throw new UserNotFoundException("User not Found with this email :" + email);
		}
		if (userMongo.getOwnCars().isEmpty()) {
			throw new CarNotFoundException("No Cars Found");
		}
		return toCarResponseDtoList(userMongo.getOwnCars());
	}

	@Override
	@Transactional
	public CarResponseOwnerDto updateCar(String email, CarRequestDto carRequestDto) {

		UserMongo owner = ilCarroRepository.findById(email)
				.orElseThrow(() -> new UserNotFoundException("user not found : " + email));
		CarMongo newCar = owner.getOwnCars().stream()
				.filter(c -> c.getSerialNumber().equals(carRequestDto.getSerialNumber())).findFirst()
				.orElseThrow(() -> new CarNotFoundException(
						"car with serialNumber : " + carRequestDto.getSerialNumber() + "not found!"));

		newCar.setMake(carRequestDto.getMake());
		newCar.setModel(carRequestDto.getModel());
		newCar.setYear(carRequestDto.getYear());
		newCar.setEngine(carRequestDto.getEngine());
		newCar.setFuel(carRequestDto.getFuel());
		newCar.setGear(carRequestDto.getGear());
		newCar.setWheelsDrive(carRequestDto.getWheelsDrive());
		newCar.setDoors(carRequestDto.getDoors());
		newCar.setSeats(carRequestDto.getSeats());
		newCar.setFuelConsumption(carRequestDto.getFuelConsumption());
		newCar.setFeatures(carRequestDto.getFeatures());
		newCar.setCarClass(carRequestDto.getCarClass());
		newCar.setPricePerDay(carRequestDto.getPricePerDay());
		newCar.setDistance(carRequestDto.getDistance());
		newCar.setAbout(carRequestDto.getAbout());
		newCar.setPickUpPlace(carRequestDto.getPickUpPlace());
		newCar.setImageUrl(carRequestDto.getImageUrl());

		ilCarroRepository.save(owner);

		return toCarResponseOwnerDto(owner.getFirstName(), owner.getSecondName(), owner.getRegistrationDate(), newCar);
	}

	@Override
	public List<BookedPeriodDto> getOwnerCarBookedPeriods(String email, String serialNumber) {
		UserMongo userBookedPeriods = ilCarroRepository.findById(email)
				.orElseThrow(() -> new UserNotFoundException("User Not Found with email :" + email));
		return toBookedPeriodDtoList(userBookedPeriods.getOwnCars().stream()
				.filter(c -> c.getSerialNumber().equals(serialNumber)).findFirst()
				.orElseThrow(() -> new CarNotFoundException("Car" + serialNumber + " Not Found")).getBookedPeriod());
	}

	@Override
	public CarResponseOwnerDto getCar(String serialNumber) {
		UserMongo user = ilCarroRepository.findByOwnCarsSerialNumber(serialNumber).findFirst()
				.orElseThrow(() -> new CarNotFoundException("Car Not Found with serialNumber : " + serialNumber));
		List<CarMongo> cars = user.getOwnCars().stream()
				.filter(carMongo -> carMongo.getSerialNumber().equals(serialNumber)).collect(Collectors.toList());

		CarMongo car = cars.get(0);
		return toCarResponseOwnerDto(user.getFirstName(), user.getSecondName(), user.getRegistrationDate(), car);
	}

	@Override
	public UserResponseDto getUser(String serialNumber) {
//        return toUserDto(ilCarroRepository.findById(email).orElseThrow(() ->
//                new UserNotFoundException("User with email : "+email + " Not Found")));
//        return toUserDto(ilCarroRepository.findByOwnCarsSerialNumber(serialNumber).findAny().orElse(null));
		return null;
	}

	@Override
	@Transactional
	public void deleteCar(String email, String serialNumber) {
		UserMongo user = ilCarroRepository.findById(email)
				.orElseThrow(() -> new UserNotFoundException("user with email :" + email + " not found!"));
		CarMongo car = user.getOwnCars().stream().filter(c -> c.getSerialNumber().equals(serialNumber)).findFirst()
				.orElseThrow(() -> new CarNotFoundException("Car not found with serial number : " + serialNumber));
		user.getOwnCars().remove(car);
		ilCarroRepository.save(user);
	}

	@Override
	public List<Comment> getComments() {
		List<Comment> comments = ilCarroRepository.findByOrderByComments();
		if (comments.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comments Not Found");
		}
		if (comments.size() > 6) {
			comments = comments.subList(comments.size() - 6, comments.size());
		}
		for (Comment comment : comments) {
			UserMongo userMongo = ilCarroRepository.findById("nir.simkin@gmail.com").orElse(null);
			if (userMongo != null) {
				if (!comment.getFirstName().equals(userMongo.getFirstName())) {
					comment.setFirstName(userMongo.getFirstName());
				}
				if (!comment.getSecondName().equals(userMongo.getSecondName())) {
					comment.setSecondName(userMongo.getSecondName());
				}
			}
		}

		return comments;
	}

	@Override
	public Comment getComment() {
		return ilCarroRepository.findBy().findAny().orElse(null).getComments().get(0);
	}

	@Override
	@Transactional
	public ReservationResponseDto makeReservation(String email, String serialNumber,
			ReservationRequestDto reservationRequestDto) {
		UserMongo owner = ilCarroRepository.findByOwnCarsSerialNumber(serialNumber).findFirst()
				.orElseThrow(() -> new CarNotFoundException("Car Not Exists On User"));
		CarMongo car = getOwnCar(owner.getOwnCars(), serialNumber);
		if (!isCarFree(car.getBookedPeriod(), reservationRequestDto.getStartDate(),
				reservationRequestDto.getEndDate())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car is Already in use try again later.");
		}
		UserMongo renter = ilCarroRepository.findById(email)
				.orElseThrow(() -> new UserNotFoundException("User Not Found"));
		long orderId = getNewOrderId();
		float amount = ChronoUnit.DAYS.between(reservationRequestDto.getStartDate(), reservationRequestDto.getEndDate())
				* car.getPricePerDay();
		LocalDate bookingDate = LocalDate.now();
		car.getBookedPeriod().add(new OwnerBookedPeriod(orderId, reservationRequestDto.getStartDate(),
				reservationRequestDto.getEndDate(), false, amount, bookingDate,
				new Renter(renter.getEmail(), renter.getFirstName(), renter.getSecondName(), renter.getPhone())));
		renter.getBookedCars().add(new BookedCarMongo(serialNumber, new RenterBookedPeriod(orderId,
				reservationRequestDto.getStartDate(), reservationRequestDto.getEndDate(), false, amount, bookingDate)));
		ilCarroRepository.save(owner);
		ilCarroRepository.save(renter);
		Thread thread = new Thread() {
			public void run() {
				try {
					this.sleep(10000);
					confPayment(orderId, serialNumber, owner.getEmail(), email);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		};
		thread.run();
		return new ReservationResponseDto(orderId, amount, bookingDate);
	}

	private void confPayment(long orderId, String serialNumber, String ownerEmail, String renterEmail) {
		UserMongo owner = ilCarroRepository.findById(ownerEmail)
				.orElseThrow(() -> new UserNotFoundException("No User Found"));
		CarMongo car = getOwnCar(owner.getOwnCars(), serialNumber);
		OwnerBookedPeriod bookedPeriod = car.getBookedPeriod().stream().filter(p -> p.getOrderId() == orderId).findAny()
				.orElse(null);
		UserMongo renter = ilCarroRepository.findById(renterEmail)
				.orElseThrow(() -> new UserNotFoundException("No Renter User Found"));
		if (!bookedPeriod.isPaid()) {
			car.getBookedPeriod().remove(bookedPeriod);
			BookedCarMongo bookedCarMongo = renter.getBookedCars().stream()
					.filter(c -> c.getBookedPeriod().getOrderId() == orderId).findFirst().orElse(null);
			renter.getBookedCars().remove(bookedCarMongo);
			ilCarroRepository.save(owner);
			ilCarroRepository.save(renter);
		}
	}

	@Override
	public List<UserResponseDto> getThreePopularCars() {
		List<UserMongo> popularCars = ilCarroRepository.findTop3ByOwnCarsOrderBySecondNameDesc();
		return toUserDtoList(popularCars);
	}

	@Override
	public List<Comment> comments() {
		return ilCarroRepository.getLatestComments();
	}

	@Override
	public List<BookedPeriodDto> findBestCars() {
		return toBookedPeriodDtoList(
				ilCarroRepository.findTop3ByOrderByOwnCarsBookedPeriod().get(0).getOwnCars().get(0).getBookedPeriod());
	}

	private List<UserResponseDto> toUserDtoList(List<UserMongo> popularCars) {
		return popularCars.stream().map(this::toUserDto).collect(Collectors.toList());
	}

	private boolean isCarFree(List<OwnerBookedPeriod> bookedPeriod, LocalDate startDate, LocalDate endDate) {
		return bookedPeriod.stream()
				.filter(p -> (startDate.isAfter(p.getStartDate()) && startDate.isBefore(p.getEndDate()))
						|| (endDate.isAfter(p.getStartDate()) && endDate.isBefore(p.getEndDate()))
						|| (startDate.isBefore(p.getStartDate()) && endDate.isAfter(p.getEndDate()))
						|| (startDate.equals(p.getStartDate())) || (endDate.equals(p.getEndDate())))
				.collect(Collectors.toList()).isEmpty();
		// Reserve to p.getStartDate = 2012-02-02 until p.getEndDate = 2012-15-02
		// Want to reserve startDate = 2012-01-02 until endDate = 2012-13-02
	}

	private CarMongo getOwnCar(List<CarMongo> ownCars, String serialNumber) {
		return ownCars.stream().filter(c -> c.getSerialNumber().equals(serialNumber)).findAny().orElse(null);
	}

	private long getNewOrderId() {
		if (CURRENT_ORDER_ID == 0) {
			CURRENT_ORDER_ID = findMaxOrderId(
					ilCarroRepository.findTopByOrderByOwnCarsBookedPeriodOrderId().getOwnCars());
		}
		return CURRENT_ORDER_ID + 1;

	}

	private long findMaxOrderId(List<CarMongo> ownCars) {
		long max = 0;
		for (CarMongo car : ownCars) {
			for (OwnerBookedPeriod period : car.getBookedPeriod()) {
				if (period.getOrderId() > max) {
					max = period.getOrderId();
				}
			}
		}
		return max;
	}

	@Override
	@Transactional
	public Comment addComment(String serialNumber, String email, CommentRequestDto commentRequestDto) {

		UserMongo owner = ilCarroRepository.findByOwnCarsSerialNumber(serialNumber).findFirst()
				.orElseThrow(() -> new CarNotFoundException("car with serial number :" + serialNumber + " not found"));

		if (owner == null) {
			throw new CarNotFoundException("Car : " + serialNumber + " Not found ");
		}
		UserMongo renter = ilCarroRepository.findById(email)
				.orElseThrow(() -> new UserNotFoundException("user " + "with email : " + email + "not found"));

		Comment comment = new Comment(renter.getFirstName(), renter.getSecondName(), renter.getPhotoUrl(),
				LocalDate.now(), commentRequestDto.getPost());

		owner.getComments().add(comment);
		ilCarroRepository.save(renter);
		ilCarroRepository.save(owner);

		return comment;
	}

	private UserResponseDto toUserDto(UserMongo userMongo) {
		return new UserResponseDto(userMongo.getFirstName(), userMongo.getSecondName(), userMongo.getEmail(),
				userMongo.getRegistrationDate(), userMongo.getComments(), toCarResponseDtoList(userMongo.getOwnCars()),
				toBookedCarDtoList(userMongo.getBookedCars()), toBookedCarDtoList(userMongo.getHistory()));
	}

	private List<BookedCarDto> toBookedCarDtoList(List<BookedCarMongo> bookedCars) {
		return bookedCars.stream().map(this::toBookedCarDto).collect(Collectors.toList());
	}

	private BookedCarDto toBookedCarDto(BookedCarMongo bookedCarMongo) {
		return new BookedCarDto(bookedCarMongo.getSerialNumber(), toBookedPeriodDto(bookedCarMongo.getBookedPeriod()));
	}

	private List<BookedPeriodDto> toBookedPeriodDtoList(List<OwnerBookedPeriod> ownerBookedPeriod) {
		if (ownerBookedPeriod == null) {
			return new ArrayList<>();
		}
		return ownerBookedPeriod.stream().map(this::toBookedPeriod).collect(Collectors.toList());
	}

	private BookedPeriodDto toBookedPeriod(OwnerBookedPeriod ownerBookedPeriod) {
		return new BookedPeriodDto(ownerBookedPeriod.getOrderId(), ownerBookedPeriod.getStartDate(),
				ownerBookedPeriod.getEndDate(), ownerBookedPeriod.isPaid(), ownerBookedPeriod.getAmount(),
				ownerBookedPeriod.getBookingDate(), ownerBookedPeriod.getPersonWhoBooked());
	}

	private BookedPeriodDto toBookedPeriodDto(RenterBookedPeriod bookedPeriod) {
		return new BookedPeriodDto(bookedPeriod.getOrderId(), bookedPeriod.getStartDate(), bookedPeriod.getEndDate(),
				bookedPeriod.isPaid(), bookedPeriod.getAmount(), bookedPeriod.getBookingDate());
	}

	private List<CarResponseDto> toCarResponseDtoList(List<CarMongo> carsMongo) {
		return carsMongo.stream().map(this::toCarResponseDto).collect(Collectors.toList());
	}

	private List<CarResponseDto> toCarResponseOwnerDtoList(List<CarMongo> popularCars) {
//        ArrayList<CarResponseDto> list = new ArrayList<>();
//        if(!popularCars.isEmpty()) {
//            for(CarMongo carMongo: popularCars) {
//                list.add(toCarResponseDto(carMongo));
//            }
//        }
		return popularCars.stream().map(this::toCarResponseDto).collect(Collectors.toList());
	}

	private CarResponseDto toCarResponseDto(CarMongo carMongo) {
		return new CarResponseDto(carMongo.getSerialNumber(), carMongo.getMake(), carMongo.getModel(),
				carMongo.getYear(), carMongo.getEngine(), carMongo.getFuel(), carMongo.getGear(),
				carMongo.getWheelsDrive(), carMongo.getDoors(), carMongo.getSeats(), carMongo.getFuelConsumption(),
				carMongo.getFeatures(), carMongo.getCarClass(), carMongo.getPricePerDay(), carMongo.getDistance(),
				carMongo.getAbout(), carMongo.getPickUpPlace(), carMongo.getImageUrl(),
				toBookedPeriodDtoList(carMongo.getBookedPeriod()));
	}

	private CarResponseOwnerDto toCarResponseOwnerDto(String firstName, String secondName, String registrationDate,
			CarMongo carMongo) {
		return new CarResponseOwnerDto(carMongo.getSerialNumber(), carMongo.getMake(), carMongo.getModel(),
				carMongo.getYear(), carMongo.getEngine(), carMongo.getFuel(), carMongo.getGear(),
				carMongo.getWheelsDrive(), carMongo.getDoors(), carMongo.getSeats(), carMongo.getFuelConsumption(),
				carMongo.getFeatures(), carMongo.getCarClass(), carMongo.getPricePerDay(), carMongo.getDistance(),
				carMongo.getAbout(), carMongo.getPickUpPlace(), carMongo.getImageUrl(),
				toOwnerDto(firstName, secondName, registrationDate), toBookedPeriodDtoList(carMongo.getBookedPeriod()));
	}

	private OwnerDto toOwnerDto(String firstName, String secondName, String registrationDate) {
		OwnerDto ownerDto = new OwnerDto();
		ownerDto.setFirstName(firstName);
		ownerDto.setSecondName(secondName);
		ownerDto.setRegistrationDate(registrationDate);
		return ownerDto;
	}

	private List<BookedPeriodDto> toBookedPeriodRenterList(List<RenterBookedPeriod> bookedPeriods) {
		return bookedPeriods.stream().map(this::toBookedPeriodDto).collect(Collectors.toList());
	}

	private boolean isSerialNumberUnique(String serialNumber) {
		UserMongo user = ilCarroRepository.findByOwnCarsSerialNumber(serialNumber).findFirst().orElse(null);
		return user == null;
	}

	private String getCurrentDate() {
		DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		timeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));
		String curTime = timeFormat.format(new Date());
		return curTime;
	}
}
