package com.bit.CVQS;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.dao.Abstract.VehicleDao;
import com.bit.CVQS.domain.Concrete.Vehicle;
import com.bit.CVQS.service.Abstract.Abstract.VehicleService;
import com.bit.CVQS.service.Concrete.VehicleManager;
import jakarta.inject.Inject;
import org.aspectj.weaver.patterns.IVerificationRequired;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
public class VehicleManagerTests {

    //Update testi eksik

    @Mock
    private VehicleDao vehicleDao;

    @InjectMocks
    private VehicleManager vehicleService;

    @BeforeEach
    public void setUp(){

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testGetAllVehicles(){
        Vehicle vehicle=new Vehicle(
        );

        Vehicle vehicle2=new Vehicle();
        List<Vehicle> expectedVehicleList= Arrays.asList(vehicle,vehicle2);

        Mockito.when(vehicleDao.findAll()).thenReturn(expectedVehicleList);

        DataResult<List<Vehicle>> vehicles=vehicleService.getAll();
        assertNotNull(vehicles.getData());
        assertEquals(expectedVehicleList.size(),vehicles.getData().size());
        assertEquals(expectedVehicleList,vehicles.getData());

        verify(vehicleDao, times(1)).findAll();



    }

    @Test
    public void testAddVehicle(){
        Vehicle vehicle=new Vehicle();

        Mockito.when(vehicleDao.save(vehicle)).thenReturn(vehicle);

        Result result=this.vehicleService.add(vehicle);

        assertTrue(result.isSuccess());
        assertEquals("Vehicle Added Successfully",result.getMessage());

        verify(vehicleDao, times(1)).save(vehicle);
    }
}
