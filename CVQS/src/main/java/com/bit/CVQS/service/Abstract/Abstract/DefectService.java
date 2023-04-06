package com.bit.CVQS.service.Abstract.Abstract;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.domain.Concrete.Defect;

import java.util.List;

public interface DefectService {
    DataResult<List<Defect>> getAllDefects();
    Result add(Defect defect);
}
