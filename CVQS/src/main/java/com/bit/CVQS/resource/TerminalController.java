package com.bit.CVQS.resource;


import com.bit.CVQS.core.utils.results.*;
import com.bit.CVQS.domain.Concrete.Terminals;
import com.bit.CVQS.service.Abstract.Abstract.TerminalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/Terminal")
public class TerminalController {
    @Autowired
    TerminalService terminalService;

    @GetMapping("/getAllTerminals")

    public DataResult<List<Terminals>> getAll(){

        try{
            log.debug("Terminal getAll() method executed");
            return this.terminalService.getAllTerminals();
        }
        catch (Exception e){
            log.error("An error occured while listing terminals");
            return new ErrorDataResult<>("An error occured while listing terminals");

        }




    }
    @GetMapping("getAllActiveTerminals")
    public DataResult<List<Terminals>> getAllActiveTerminals(){
        try{
            log.debug("Terminal getAllActiveTerminals() method executed");
            return this.terminalService.getAllActiveTerminals();
        }catch (Exception e){
            log.error("An error occured while listing active terminals");
            return new ErrorDataResult<>("An error occured while listing active terminals");


        }



    }
    @PostMapping("/add")
    public Result add(@RequestBody Terminals terminals){

        try{
            log.info("Terminal add() method executed");
            return this.terminalService.add(terminals);

        }catch (Exception e){
            log.error("Error occured while adding terminal id:"+terminals.getId(),e);
            return new ErrorResult("Error occured while adding terminal");

        }


    }

    @PutMapping("/update")
    public Result update(@RequestBody Terminals terminals){
        try{
            log.info("Terminal update() method executed");
            return this.terminalService.update(terminals);

        }catch (Exception e){
            log.error("Error occured while updating terminal id:"+terminals.getId(),e);
            return new ErrorResult("Error occured while updating terminal");

        }


    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
        try{
            log.info("Terminal delete() method executed");
            return this.terminalService.delete(id);
        }catch (Exception e){
            return new ErrorResult("Terminal delete() method executed");

        }


    }

}
