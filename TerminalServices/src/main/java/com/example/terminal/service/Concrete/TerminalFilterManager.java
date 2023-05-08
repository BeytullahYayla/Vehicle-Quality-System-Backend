package com.example.terminal.service.Concrete;

import com.example.terminal.core.utils.results.*;
import com.example.terminal.dao.Abstract.TerminalFilterDao;
import com.example.terminal.domain.Concrete.TerminalFilter;
import com.example.terminal.service.Abstract.Abstract.TerminalFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminalFilterManager implements TerminalFilterService {
    @Autowired
    private TerminalFilterDao terminalFilterDao;


    @Override
    public DataResult<List<TerminalFilter>> getAllFilters() {
        return new SuccessDataResult<List<TerminalFilter>>(this.terminalFilterDao.findAll(),"TerminalFilters Listed Successfully");
    }


    @Override
    public Result add(TerminalFilter terminalFilter) {
         this.terminalFilterDao.save(terminalFilter);
         return new SuccessResult("Terminal Filter Added Successfully");
    }


    @Override
    public Result update(TerminalFilter terminalFilter) {
        if (this.terminalFilterDao.findById(terminalFilter.getId())!=null){
            terminalFilterDao.save(terminalFilter);
            return new SuccessResult("TerminalFilter Updated Successfully");
        }
        return new ErrorResult("There is no terminalFilter that matchs with this informations");
    }


    @Override
    public Result delete(int id) {
        this.terminalFilterDao.deleteById(id);
        return new SuccessResult("TerminalFilter Deleted Successfully");
    }
}
