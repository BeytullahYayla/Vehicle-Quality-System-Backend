package com.example.terminal.resource;


import com.example.terminal.core.utils.results.*;
import com.example.terminal.domain.Concrete.TerminalFilter;
import com.example.terminal.service.Abstract.Abstract.TerminalFilterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            log.debug("Terminal Filter GetALl() method executed successfully");
            return this.terminalFilterService.getAllFilters();



        }
        catch (Exception e){
            log.error("An error occured while listing terminal filters");
            return new ErrorDataResult<>("An error occured while listing terminal filters");

        }


    }
    @PostMapping("/add")
    public Result add(@RequestBody TerminalFilter terminalFilter){
        try{
            log.info("Terminal Filter add() method executed successfully");
            this.terminalFilterService.add(terminalFilter);
            return new SuccessResult("Terminal Filter Added Successfully");



        }
        catch (Exception e){
            log.error("An error occured while adding terminal filters");
            return new ErrorResult("An error occured while adding terminal filters");

        }


    }

}
