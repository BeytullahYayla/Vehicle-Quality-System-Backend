package com.bit.CVQS;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.SuccessDataResult;
import com.bit.CVQS.core.utils.spesifications.DefectSpesifications;
import com.bit.CVQS.dao.Abstract.DefectDao;
import com.bit.CVQS.dao.Abstract.LocationDao;
import com.bit.CVQS.dao.Abstract.VehicleDao;
import com.bit.CVQS.domain.Concrete.Defect;
import com.bit.CVQS.domain.Concrete.DefectLocation;
import com.bit.CVQS.domain.Concrete.Vehicle;
import com.bit.CVQS.dto.DefectDto;
import com.bit.CVQS.dto.DefectLocationDto;
import com.bit.CVQS.dto.VehicleDto;
import com.bit.CVQS.service.Abstract.Abstract.DefectService;
import com.bit.CVQS.service.Concrete.DefectManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class DefectManagerTests {
    //Filtre ile arama testi eksik
    @Mock
    private DefectDao defectDao;
    @Mock
    private LocationDao locationDao;


    @InjectMocks
    private DefectManager defectService;
    @Captor
    private ArgumentCaptor<Defect> defectCaptor;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test

    public void testGetAll(){
        Defect defect1 = new Defect();
        Defect defect2 = new Defect();
        List<Defect> expectedDefects = Arrays.asList(defect1, defect2);

        Mockito.when(defectDao.findAll()).thenReturn(expectedDefects);

        DataResult<List<Defect>> result = defectService.getAllDefects();

        assertNotNull(result.getData());
        assertEquals(expectedDefects.size(), result.getData().size());
        assertEquals(expectedDefects, result.getData());

        verify(defectDao, times(1)).findAll();

    }

    @Test
    public void testAddVehicle(){
        Defect defect=new Defect();
        DefectLocation defectLocation1=new DefectLocation();
        defectLocation1.setId(1);

        DefectLocation defectLocation2=new DefectLocation();
        defectLocation2.setId(2);

        List<DefectLocation> locations=Arrays.asList(defectLocation1,defectLocation2);
        defect.setLocations(locations);

        when(locationDao.findById(1)).thenReturn(Optional.of(defectLocation1));
        when(locationDao.findById(2)).thenReturn(Optional.of(defectLocation2));

        defectService.add(defect);

        verify(locationDao,times(2)).findById(anyInt());
        verify(locationDao,never()).save(any());
        verify(defectDao).save(defectCaptor.capture());

        Defect savedDefect = defectCaptor.getValue();
        assertEquals(defect, savedDefect);
        assertEquals(locations.size(), savedDefect.getLocations().size());
        assertTrue(savedDefect.getLocations().containsAll(locations));


    }
    @Test
    public void testGetAllDefectsByPage() {
        // Test data
        int pageNumber = 0;
        int pageSize = 10;

        // Mocking the repository behavior
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Defect> expectedPagedResult = new PageImpl<>(Arrays.asList(new Defect(), new Defect()), pageable, 2);
        when(defectDao.findAll(pageable)).thenReturn(expectedPagedResult);

        // Calling the service method
        DataResult<Page<Defect>> result = defectService.getAllDefectsByPage(pageNumber, pageSize);

        // Assertions
        assertNotNull(result);
        assertEquals(expectedPagedResult, result.getData());
    }
    @Test
    public void testGetAllDefectsWithSortedPagination() {
        // Test data
        int pageNumber = 0;
        int pageSize = 10;
        String sortBy = "defectName";
        String keyword = "searchKeyword";

        // Mocking the repository behavior
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Specification<Defect> specification = Specification.where(null);
        if (keyword != null && !keyword.isEmpty()) {
            specification = specification.and(DefectSpesifications.search(keyword));
        }
        Page<Defect> pagedResult = new PageImpl<>(Arrays.asList(new Defect(), new Defect()), pageable, 2);
        when(defectDao.findAllByOrderByDefectNameAsc(pageable)).thenReturn(pagedResult);

        // Calling the service method
        DataResult<Page<Defect>> result = defectService.getAllDefectsWithSortedPagination(pageNumber, pageSize, sortBy, keyword);

        // Assertions
        assertNotNull(result);
        assertEquals(pagedResult, result.getData());
    }











}
