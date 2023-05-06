package com.bit.CVQS.service.Abstract.Abstract;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.domain.Concrete.Defect;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DefectService {
    /**
     *
     * @return A DataResult object containing a list of Defect and a Success message
     *         If defects exist in system, returns SuccessDataResult with the list of defects
     *         If no defects exist, returns empty list and a SuccessMessage
     */
    DataResult<List<Defect>> getAllDefects();
    /**
     * Retrieves all defects from the system by page.
     *
     * @param pageNumber The page number of the defects to retrieve.
     * @param pageSize The maximum number of defects to include in a page.
     * @return A DataResult object containing a Page of Defect objects and a success message.
     *         The Page object represents a subset of all defects, based on the provided page number and page size.
     *         If the operation is successful, the DataResult will contain the Page of Defect objects.
     *         If any errors occur during the retrieval process, an appropriate error message will be returned.
     */
    DataResult<Page<Defect>> getAllDefectsByPage(int pageNumber, int pageSize);
    /**
     * Retrieves all defects from the system with sorted pagination.
     *
     * @param pageNumber The page number of the defects to retrieve.
     * @param pageSize The maximum number of defects to include in a page.
     * @param sortBy The field to sort the defects by.
     * @param keyword The keyword to search for in defect names.
     * @return A DataResult object containing a Page of Defect objects and a success message.
     *         The Page object represents a subset of all defects, based on the provided page number and page size, sorted by the specified field.
     *         If a keyword is provided, the defects will be filtered based on the keyword in the defect names.
     *         If the operation is successful, the DataResult will contain the Page of Defect objects.
     *         If any errors occur during the retrieval process, an appropriate error message will be returned.
     */

    DataResult<Page<Defect>> getAllDefectsWithSortedPagination(int pageNumber,int pageSize,String sortBy,String keyword);
    /**

     Retrieves a list of defects filtered by the given search keyword.
     @param searchKeyword the keyword to search for in the defect attributes
     @return a DataResult object containing a list of Defect objects matching the search criteria and a success message
     */

    DataResult<List<Defect>> getAllDefectsWithFilter(String searchKeyword);
    /**

     Adds a new defect to the system.
     @param defect the defect to be added
     @return a Result object indicating the success status of the operation
     */

    Result add(Defect defect);

    /**
     * Deletes a defect from the system by the specified ID.
     *
     * @param id The ID of the defect to be deleted.
     * @return A Result object indicating the outcome of the operation.
     *         If the defect is successfully deleted, returns a SuccessResult.
     */

    Result delete(int id);

}
