package com.bit.CVQS.service.Abstract.Abstract;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.domain.Concrete.Defect;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DefectService {
    DataResult<List<Defect>> getAllDefects();
    DataResult<Page<Defect>> getAllDefectsByPage(int pageNumber, int pageSize);

    DataResult<Page<Defect>> getAllDefectsWithSortedPagination(int pageNumber,int pageSize,String sortBy,String keyword);
    Result add(Defect defect);
}
