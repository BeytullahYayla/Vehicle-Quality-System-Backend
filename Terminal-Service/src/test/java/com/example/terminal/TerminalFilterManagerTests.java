package com.example.terminal;


import com.example.terminal.core.utils.results.DataResult;
import com.example.terminal.core.utils.results.Result;
import com.example.terminal.dao.Abstract.TerminalFilterDao;
import com.example.terminal.domain.Concrete.TerminalFilter;
import com.example.terminal.service.Concrete.TerminalFilterManager;
import jakarta.inject.Inject;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class TerminalFilterManagerTests {

    @Mock
    private TerminalFilterDao terminalFilterDao;

    @InjectMocks
    private TerminalFilterManager terminalFilterManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetAllFilterTerminal(){

        TerminalFilter terminalFilter=new TerminalFilter();
        TerminalFilter terminalFilter2=new TerminalFilter();

        List<TerminalFilter> expectedTerminalFilters= Arrays.asList(terminalFilter,terminalFilter2);

        Mockito.when(this.terminalFilterDao.findAll()).thenReturn(expectedTerminalFilters);

        DataResult<List<TerminalFilter>> result=this.terminalFilterManager.getAllFilters();

        assertNotNull(result.getData());
        assertEquals(expectedTerminalFilters.size(),result.getData().size());
        assertEquals(expectedTerminalFilters,result.getData());

        Mockito.verify(this.terminalFilterDao,Mockito.times(1)).findAll();







    }

    @Test
    public void testAdd(){
        TerminalFilter terminalFilter=new TerminalFilter();
        Mockito.when(terminalFilterDao.save(terminalFilter)).thenReturn(terminalFilter);

        Result result=terminalFilterManager.add(terminalFilter);

        assertTrue(result.isSuccess());
        assertEquals("Terminal Filter Added Successfully",result.getMessage());

        Mockito.verify(terminalFilterDao,Mockito.times(1)).save(terminalFilter);
    }
    @Test
    public void testUpdate(){
        TerminalFilter terminalFilter = new TerminalFilter();
        terminalFilter.setId(1);

        // terminalFilterDao.findById() metodu çağrıldığında null döndürmesini sağla
        Mockito.when(terminalFilterDao.findById(terminalFilter.getId())).thenReturn(null);

        // Metodu çağır ve sonucu kontrol et
        Result result = terminalFilterManager.update(terminalFilter);
        assertFalse(result.isSuccess());
        assertEquals("There is no terminalFilter that matchs with this informations", result.getMessage());

        // terminalFilterDao.findById() metodu bir kez çağrıldığından emin ol
        Mockito.verify(terminalFilterDao, Mockito.times(1)).findById(terminalFilter.getId());

        // terminalFilterDao.save() metodu çağrılmadığından emin ol
        Mockito.verify(terminalFilterDao, Mockito.never()).save(terminalFilter);
    }

}
