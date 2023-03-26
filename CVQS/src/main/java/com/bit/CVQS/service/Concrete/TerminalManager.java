package com.bit.CVQS.service.Concrete;

import com.bit.CVQS.core.utils.results.*;
import com.bit.CVQS.dao.Abstract.TerminalDao;
import com.bit.CVQS.domain.Concrete.Terminals;
import com.bit.CVQS.service.Abstract.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminalManager implements TerminalService {

    @Autowired
    private TerminalDao terminalDao;
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
        this.terminalDao.save(terminals);
        return new SuccessResult("Terminal Added Successfully");
    }

    @Override
    public Result delete(int id) {
        this.terminalDao.deleteById(id);
        return new SuccessResult("Terminal Deleted Successfully");
    }

    @Override
    public Result update(Terminals terminals) {
        if (this.terminalDao.findById(terminals.getId()).isEmpty()){
            return new ErrorResult("User Don't Exist");
        }
        return new SuccessResult("Terminal Updated Successfully");
    }
}
