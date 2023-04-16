package com.bit.CVQS.resource;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.ErrorDataResult;
import com.bit.CVQS.core.utils.results.ErrorResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.domain.Concrete.Defect;
import com.bit.CVQS.service.Abstract.Abstract.DefectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/Defects")
public class DefectController {
    @Autowired
    private DefectService defectService;

    @GetMapping("/getAll")
    public DataResult<List<Defect>> getAll() {
        log.debug("Defect getAll() method executed successfully");
        return this.defectService.getAllDefects();
    }

    @GetMapping("/getAllByPage/{pageNumber}/{pageSize}")
    public DataResult<Page<Defect>> getAllByPage(@PathVariable int pageNumber,@PathVariable int pageSize){
        try{
            log.debug("Defect getAllByPage() method executed successfully");
            return this.defectService.getAllDefectsByPage(pageNumber,pageSize);

        }catch (Exception e){
            log.error("An error occured while listing defects by page");
            return new ErrorDataResult<>("An error occured while listing defects by page");
        }

    }

    @PostMapping("/getAllBySortedPage/{pageNumber}/{pageSize}")
    public DataResult<Page<Defect>> getAllBySortedPage(@PathVariable int pageNumber,@PathVariable int pageSize,@RequestParam(defaultValue = "defectName") String sortingParam,@RequestParam(defaultValue = "A") String filter){

        try{
            log.debug("Vehicle getAllBySortedPage() method executed");
            return this.defectService.getAllDefectsWithSortedPagination(pageNumber,pageSize,sortingParam,filter);

        }catch (Exception e){
            log.error("An error occured while listing defects by sorted pages");
            return new ErrorDataResult<>("An error occured while listing defects by sorted pages");

        }

    }

    @PostMapping("/getDefectsWithFilter")
    public DataResult<List<Defect>> getDefectsWithFilter(@RequestParam String filter){
        try{
            log.debug("Defect getDefecgtsWithFilter() method executed");
            return this.defectService.getAllDefectsWithFilter(filter);

        }catch (Exception e){
            log.error("An error occured while listing defects with filter");
            return new ErrorDataResult<>("An error occured while listing defects with filter");

        }

    }

    @PostMapping("/add")
    public Result add(@RequestBody Defect defect){

        try{
            log.info("Defect add() method executed");
            return this.defectService.add(defect);

        }catch(Exception e){
            log.error("An error occured while adding defect id:"+defect.getId(),e);
            return new ErrorResult("An error occured while adding defect");
        }

    }
}
