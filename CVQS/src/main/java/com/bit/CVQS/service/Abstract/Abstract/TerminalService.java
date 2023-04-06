package com.bit.CVQS.service.Abstract.Abstract;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.domain.Concrete.Terminals;

import javax.xml.crypto.Data;
import java.util.List;

public interface TerminalService {

    DataResult<List<Terminals>> getAllTerminals();
    DataResult<List<Terminals>> getAllActiveTerminals();
    Result add(Terminals terminals);
    Result delete(int id);
    Result update(Terminals terminals);

}
