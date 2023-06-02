package com.example.defects;


import com.example.defects.core.results.DataResult;
import com.example.defects.core.results.Result;
import com.example.defects.dao.Abstract.VehicleDao;
import com.example.defects.domain.Vehicle;
import com.example.defects.service.Concrete.VehicleManager;
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
import java.util.Optional;

import static org.mockito.Mockito.*;
public class VehicleManagerTests {



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

    @Test
    public void testUpdateVehicle(){
        Vehicle vehicle=new Vehicle();
        vehicle.setId(1);
        vehicle.setName("Ford");
        vehicle.setDeleted(Boolean.FALSE);
        Mockito.when(vehicleDao.findById(vehicle.getId())).thenReturn(Optional.of(vehicle));

        Result result=this.vehicleService.update(vehicle);
        Mockito.verify(vehicleDao,Mockito.times(1)).save(vehicle);

        assertTrue(result.isSuccess());
        assertEquals("Vehicle Updated Successfully",result.getMessage());
    }
}
