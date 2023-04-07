package com.bit.CVQS.service.Abstract.Abstract;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.domain.Concrete.TerminalFilter;

import java.util.List;

public interface TerminalFilterService {
    DataResult<List<TerminalFilter>> getAllFilters();
    Result add(TerminalFilter terminalFilter);
    Result update(TerminalFilter terminalFilter);
    Result delete(int id);
}
