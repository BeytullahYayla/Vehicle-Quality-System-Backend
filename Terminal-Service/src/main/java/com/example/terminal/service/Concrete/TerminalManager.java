package com.example.terminal.service.Concrete;


import com.example.terminal.core.utils.results.*;
import com.example.terminal.dao.Abstract.TerminalDao;
import com.example.terminal.dao.Abstract.TerminalFilterDao;
import com.example.terminal.domain.Concrete.TerminalFilter;
import com.example.terminal.domain.Concrete.Terminals;
import com.example.terminal.service.Abstract.Abstract.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminalManager implements TerminalService {

    @Autowired
    private TerminalDao terminalDao;

    @Autowired
    private TerminalFilterDao terminalFilterDao;

    @Override
    public DataResult<List<Terminals>> getAllTerminals() {
        return new SuccessDataResult<List<Terminals>>(this.terminalDao.findAll(),"Terminals Listed Successfully");
    }

    @Override
    public DataResult<List<Terminals>> getAllActiveTerminals() {

        return new SuccessDataResult<List<Terminals>>(this.terminalDao.findByIsActiveTrue());
    }


    @Override
    public Result add(Terminals terminals) {
        for (TerminalFilter terminalFilter:terminals.getTerminalFilters()){
            if (this.terminalFilterDao.findById(terminalFilter.getId()).isEmpty()){
                this.terminalFilterDao.save(terminalFilter);
            }
        }



        this.terminalDao.save(terminals);
        return new SuccessResult("Terminal Added Successfully");
    }


    @Override
    public Result delete(int id) {
        this.terminalDao.softDelete(id);
        return new SuccessResult("Terminal Deleted Successfully");
    }


    @Override
    public Result update(Terminals terminals) {
        if (this.terminalDao.findById(terminals.getId()).isEmpty()){
            return new ErrorResult("User Don't Exist");
        }
        this.terminalDao.save(terminals);
        return new SuccessResult("Terminal Updated Successfully");
    }
}
