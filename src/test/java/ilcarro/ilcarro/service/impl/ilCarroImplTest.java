package ilcarro.ilcarro.service.impl;

import ilcarro.ilcarro.dto.Location;
import ilcarro.ilcarro.dto.carDto.CarRequestDto;
import ilcarro.ilcarro.dto.userDto.UserRequestDto;
import ilcarro.ilcarro.repository.ilCarroRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ilCarroImplTest {

    private static final String EMAIL = "nir.simkin@gmail.com";
    private static final String SERIAL_NUMBER = "123456";
    private static final List<String> FEATURES = Arrays.asList("features1","features2");
    static UserRequestDto userNir = new UserRequestDto("nir",
            "simkin","0524070215","image.com");
    static CarRequestDto carNir = new CarRequestDto(SERIAL_NUMBER,"audi","a1",2012,"engine",
            "30L", "Automatic","RWD",4,5,4,FEATURES,"C",20,30,"ABout Me",
            new Location("3555",30,40),FEATURES);
    static CarRequestDto carNir2 = new CarRequestDto(SERIAL_NUMBER+2,"audiX2","a1",2010,"engine",
            "30L", "Automatic","RWD",4,5,4,FEATURES,"C",20,30,"ABout Me",
            new Location("3555",30,40),FEATURES);

    @Autowired
    private ilCarroRepository userRepository;

    @Autowired
    private ilCarroImpl service;

    @Before
    public void before() {
        service.registerUser(EMAIL,userNir);
        service.addCar(carNir,EMAIL);
    }


    @Test
    public void testAddUser() {
        service.registerUser(EMAIL,userNir);
    }


}