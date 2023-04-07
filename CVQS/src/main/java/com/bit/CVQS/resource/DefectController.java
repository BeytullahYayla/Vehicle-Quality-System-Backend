package com.bit.CVQS.resource;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.domain.Concrete.Defect;
import com.bit.CVQS.service.Abstract.Abstract.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Defects")
public class DefectController {
    @Autowired
    private DefectService defectService;

    @GetMapping("/getAll")
    public DataResult<List<Defect>> getAll() {
        return this.defectService.getAllDefects();
    }

    @GetMapping("/getAllByPage/{pageNumber}/{pageSize}")
    public DataResult<Page<Defect>> getAllByPage(@PathVariable int pageNumber,@PathVariable int pageSize){
        return this.defectService.getAllDefectsByPage(pageNumber,pageSize);
    }

    @GetMapping("/getAllBySortedPage/{pageNumber}/{pageSize}")
    public DataResult<Page<Defect>> getAllBySortedPage(@PathVariable int pageNumber,@PathVariable int pageSize){
        return this.defectService.getAllDefectsWithSortedPagination(pageNumber,pageSize,"defectName","Çapakxx");
    }
    @PostMapping("/add")
    public Result add(@RequestBody Defect defect){
        return this.defectService.add(defect);
    }
}
