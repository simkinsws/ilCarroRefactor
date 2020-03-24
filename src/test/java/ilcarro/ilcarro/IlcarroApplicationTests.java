//package ilcarro.ilcarro;
//
//import ilcarro.ilcarro.dto.Location;
//import ilcarro.ilcarro.dto.bookingDto.BookedPeriodDto;
//import ilcarro.ilcarro.dto.carDto.CarRequestDto;
//import ilcarro.ilcarro.dto.carDto.CarResponseDto;
//import ilcarro.ilcarro.dto.carDto.CarResponseOwnerDto;
//import ilcarro.ilcarro.dto.carDto.OwnerDto;
//import ilcarro.ilcarro.dto.commentDto.CommentRequestDto;
//import ilcarro.ilcarro.dto.userDto.UserRequestDto;
//import ilcarro.ilcarro.dto.userDto.UserResponseDto;
//import ilcarro.ilcarro.entities.CarMongo;
//import ilcarro.ilcarro.entities.UserMongo;
//import ilcarro.ilcarro.exceptions.errors.UserNotFoundException;
//import ilcarro.ilcarro.repository.ilCarroRepository;
//import ilcarro.ilcarro.service.ilCarroService;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootApplication
//public class IlcarroApplicationTests {
//
//    private static final String EMAIL = "nir.simkin@gmail.com";
//    private static final String SERIAL_NUMBER = "123456";
//    private static final List<String> FEATURES = Arrays.asList("features1","features2");
//    static UserRequestDto userNir = new UserRequestDto(EMAIL,"nir",
//            "simkin","0524070215","image.com");
//    static CarRequestDto carNir = new CarRequestDto(SERIAL_NUMBER,"audi","a1",2012,"engine",
//            "30L", "Automatic","RWD",4,5,4,FEATURES,"C",20,30,"ABout Me",
//            new Location("3555",30,40),FEATURES);
//    static CarRequestDto carNir2 = new CarRequestDto(SERIAL_NUMBER+2,"audiX2","a1",2010,"engine",
//            "30L", "Automatic","RWD",4,5,4,FEATURES,"C",20,30,"ABout Me",
//            new Location("3555",30,40),FEATURES);
////    static CarResponseOwnerDto carToUpdate = new CarResponseOwnerDto(SERIAL_NUMBER,"audi","a1",2010,"engine","30L","Automatic","RWD",4
////    ,5,4,FEATURES,"C",20,30,"ABout Me", carNir.getPickUpPlace(),FEATURES,
////            new OwnerDto(),new ArrayList<>());
//
//    ilCarroService service;
//    ConfigurableApplicationContext ctx;
//
//    @Autowired
//    private ilCarroRepository ilCarroRepository;
//
//    @Before
//    public void setUp() throws Exception {
//        ctx = SpringApplication.run(IlcarroApplicationTests.class);
//        service = ctx.getBean(ilCarroService.class);
////        service.registerUser(userNir);
//        service.addCar(carNir,EMAIL);
//        service.addCar(carNir2,EMAIL);
////        service.updateCar(carNir2,EMAIL,carNir.getSerialNumber());
//    }
//
//    @After
//    public void tearDown() {
//        ctx.close();
//    }
//
//    @Test
//    public void testGetOwnerCarsByEmail() {
//        assertEquals(service.getOwnerCarsById(EMAIL).size(),2);
//        System.out.println(service.getOwnerCarsById(EMAIL).get(0));
//    }
//
//    @Test
//    public void testGetOwnerCarById() {
//        assertEquals(service.getOwnerCarById(EMAIL,SERIAL_NUMBER).getSerialNumber(),SERIAL_NUMBER);
//        System.out.println(service.getOwnerCarById(EMAIL,SERIAL_NUMBER));
//    }
//
//    @Test
//    public void testUpdateUser(){
//        UserRequestDto userToUpdate = new UserRequestDto("sasha","sim","054","image.com");
//        service.updateUser(EMAIL,userToUpdate);
//        UserResponseDto user = service.getUser(EMAIL);
//        assertEquals("sasha",user.getFirstName());
//        UserRequestDto userToUpdateExpNull = new UserRequestDto(EMAIL+2,"nirs","Second",
//                "05","HTPP");
//    }
//
//
//    @Test
//    public void testDeleteUser(){
//        service.deleteUser(userNir.getEmail());
//    }
//
////    @Test
////    public void testUpdateCar() {
////        System.out.println("Before : " + carNir);
////        service.updateCar(carNir2,EMAIL,carNir.getSerialNumber());
////        System.out.println("After :" + service.updateCar(carNir2,EMAIL,carNir.getSerialNumber()));
////    }
//
//    @Test
//    public void testGetCar(){
//        service.getCar("1234562");
//        System.out.println(service.getCar("1234562"));
//    }
//
//    @Test
//    public void getUser() {
////        service.getUser(EMAIL);
//        System.out.println(service.getUser(SERIAL_NUMBER));
//    }
//
//    @Test
//    public void testOwnerBookedPeriodsById(){
//        service.getOwnerCarBookedPeriods(EMAIL,SERIAL_NUMBER);
//        System.out.println(service.getOwnerCarBookedPeriods(EMAIL,SERIAL_NUMBER));
//    }
//
//    @Test
//    public void addComment() {
//        System.out.println(service.addComment("TRRYSSADA", SERIAL_NUMBER, EMAIL));
//        System.out.println(service.getComments());
//        System.out.println(service.getComment());
//    }
//}
