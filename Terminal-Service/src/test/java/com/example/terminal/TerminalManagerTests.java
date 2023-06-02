package com.example.terminal;


import com.example.terminal.core.utils.results.DataResult;
import com.example.terminal.core.utils.results.Result;
import com.example.terminal.dao.Abstract.TerminalDao;
import com.example.terminal.dao.Abstract.TerminalFilterDao;
import com.example.terminal.domain.Concrete.TerminalFilter;
import com.example.terminal.domain.Concrete.Terminals;
import com.example.terminal.service.Concrete.TerminalManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class TerminalManagerTests {
    //Silme testi eksik

    @Mock
    private TerminalDao terminalDao;

    @Mock
    private TerminalFilterDao terminalFilterDao;

    @InjectMocks
    private TerminalManager terminalService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllTerminals(){
        List<Terminals> terminalsList = new ArrayList<>();

        when(terminalDao.findAll()).thenReturn(terminalsList);

        DataResult<List<Terminals>> result=terminalService.getAllTerminals();

        assertNotNull(result.getData());
        assertEquals(terminalsList,result.getData());

        assertEquals(terminalsList.size(), result.getData().size());
        assertEquals("Terminals Listed Successfully", result.getMessage());

        // terminalDao.findAll() metodu bir kez çağrıldığından emin ol
        verify(terminalDao, times(1)).findAll();








    }
    @Test
    public void testGetAllActiveTerminals() {
        // Örnek veri oluştur
        List<Terminals> activeTerminalsList = new ArrayList<>();
        // activeTerminalsList listesine örnek verileri ekle

        // terminalDao.findByIsActiveTrue() metodu çağrıldığında örnek veriyi döndürmesini sağla
        when(terminalDao.findByIsActiveTrue()).thenReturn(activeTerminalsList);

        // Metodu çağır ve sonucu kontrol et
        DataResult<List<Terminals>> result = terminalService.getAllActiveTerminals();
        assertNotNull(result.getData());
        assertEquals(activeTerminalsList.size(), result.getData().size());

        // terminalDao.findByIsActiveTrue() metodu bir kez çağrıldığından emin ol
        verify(terminalDao, times(1)).findByIsActiveTrue();
    }

    @Test
    public void testAdd() {
        Terminals terminals = new Terminals();
        TerminalFilter filter=new TerminalFilter();
        filter.setId(1);
        filter.setName("CVQXRS");
        terminals.setTerminalFilters(Arrays.asList(filter));
        // terminalFilterDao.findById() metodu çağrıldığında Optional.empty() döndürmesini sağla
        when(terminalFilterDao.findById(anyInt())).thenReturn(Optional.ofNullable(null));


        // Metodu çağır ve sonucu kontrol et
        Result result = terminalService.add(terminals);
        assertTrue(result.isSuccess());
        assertEquals("Terminal Added Successfully", result.getMessage());

        // terminalFilterDao.findById() ve terminalFilterDao.save() metotlarının çağrıldığından emin ol
        verify(terminalFilterDao, times(terminals.getTerminalFilters().size())).findById(anyInt());
        verify(terminalFilterDao, times(terminals.getTerminalFilters().size())).save(any(TerminalFilter.class));

        // terminalDao.save() metodu bir kez çağrıldığından emin ol
        verify(terminalDao, times(1)).save(terminals);

}}
