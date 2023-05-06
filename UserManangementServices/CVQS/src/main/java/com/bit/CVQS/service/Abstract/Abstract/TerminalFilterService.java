package com.bit.CVQS.service.Abstract.Abstract;

import com.bit.CVQS.core.utils.results.DataResult;
import com.bit.CVQS.core.utils.results.Result;
import com.bit.CVQS.domain.Concrete.TerminalFilter;

import java.util.List;

public interface TerminalFilterService {
    /**
     *
     * @return A DataResult object containing a list of filters and a success message.
     *         If terminals exist in the system, returns a SuccessDataResult with the list of filters.
     *         If no terminals exist, returns an empty list and a success message.
     */
    DataResult<List<TerminalFilter>> getAllFilters();
    /**
     * Adds a new terminal filter to the system.
     *
     * @param terminalFilter The terminal filter to be added.
     * @return A Result object indicating the outcome of the operation.
     *         If the terminal filter is successfully added, returns a SuccessResult.
     */


    Result add(TerminalFilter terminalFilter);
    /**
     * Updates an existing terminal filter in the system.
     *
     * @param terminalFilter The terminal filter with updated information.
     * @return A Result object indicating the outcome of the operation.
     *         If a terminal filter with the given ID exists, it will be updated with the new information,
     *         and a SuccessResult will be returned.
     *         If a terminal filter with the given ID doesn't exist, returns an ErrorResult indicating that
     *         there is no terminal filter that matches the provided information.
     */

    Result update(TerminalFilter terminalFilter);
    /**
     * Deletes a terminal filter from the system based on the given ID.
     *
     * @param id The ID of the terminal filter to be deleted.
     * @return A Result object indicating the outcome of the operation.
     *         If a terminal filter with the given ID exists and is successfully deleted,
     *         returns a SuccessResult.
     */

    Result delete(int id);
}
