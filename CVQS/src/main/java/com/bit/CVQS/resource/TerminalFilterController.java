package com.bit.CVQS.resource;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.ErrorResult;
import com.bit.CVQS.domain.Concrete.TerminalFilter;
import com.bit.CVQS.service.Abstract.Abstract.TerminalFilterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/TerminalFilters")
public class TerminalFilterController {

    @Autowired
    private TerminalFilterService terminalFilterService;
    @GetMapping("/getAll")
    public DataResult<List<TerminalFilter>> getAll(){
        try{

        }
        catch (Exception e){

        }

       return this.terminalFilterService.getAllFilters();
    }
}
