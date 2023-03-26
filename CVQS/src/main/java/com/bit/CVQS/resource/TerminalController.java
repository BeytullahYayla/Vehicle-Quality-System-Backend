package com.bit.CVQS.resource;


import com.bit.CVQS.core.utils.results.*;
import com.bit.CVQS.domain.Concrete.Terminals;
import com.bit.CVQS.domain.Concrete.User;
import com.bit.CVQS.service.Abstract.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Terminal")
public class TerminalController {
    @Autowired
    TerminalService terminalService;

    @GetMapping("/getAllTerminals")

    public DataResult<List<Terminals>> getAll(){
        if (this.terminalService.getAllTerminals().isSuccess()){
            return this.terminalService.getAllTerminals();
        }
        else return null;

    }
    @GetMapping("getAllActiveTerminals")
    public DataResult<List<Terminals>> getAllActiveTerminals(){
        if (this.terminalService.getAllActiveTerminals().isSuccess()){
            return this.terminalService.getAllActiveTerminals();
        }
        else return null;
    }
    @PostMapping("/add")
    public Result add(@RequestBody Terminals terminals){


        this.terminalService.add(terminals);
        return new SuccessResult("Terminal Added Successfully");
    }

    @PutMapping("/update")
    public Result update(@RequestBody Terminals terminals){

        this.terminalService.update(terminals);
        return new SuccessResult("Terminal Updated Successfully");
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
        this.terminalService.delete(id);
        return new SuccessResult("Terminal Deleted Successfully");
    }

}
