package com.example.terminal.service.Abstract.Abstract;



import com.example.terminal.core.utils.results.DataResult;
import com.example.terminal.core.utils.results.Result;
import com.example.terminal.domain.Concrete.Terminals;

import javax.xml.crypto.Data;
import java.util.List;

public interface TerminalService {

    /**
     * Retrieves a list of all terminals in the system.
     *
     * @return A DataResult object containing a list of terminals and a success message.
     *         If terminals exist in the system, returns a SuccessDataResult with the list of terminals.
     *         If no terminals exist, returns an empty list and a success message.
     */
    DataResult<List<Terminals>> getAllTerminals();
    /**
     * Retrieves a list of all active terminals in the system.
     *
     * @return A DataResult object containing a list of active terminals.
     *         If active terminals exist in the system, returns a SuccessDataResult with the list of active terminals.
     *         If no active terminals exist, returns an empty list.
     */
    DataResult<List<Terminals>> getAllActiveTerminals();
    /**
     * Adds a new terminal to the system.
     *
     * @param terminals The terminal to be added.
     * @return A Result object indicating the outcome of the operation.
     *         If the terminal filters associated with the terminal do not exist in the system,
     *         they will be saved before adding the terminal.
     *         If the terminal is successfully added, returns a SuccessResult.
     */

    Result add(Terminals terminals);
    /**
     * Deletes a terminal from the system based on the given ID.
     *
     * @param id The ID of the terminal to be deleted.
     * @return A Result object indicating the outcome of the operation.
     *         If a terminal with the given ID exists and is successfully deleted,
     *         returns a SuccessResult.
     */

    Result delete(int id);
    /**
     * Updates an existing terminal in the system.
     *
     * @param terminals The terminal with updated information.
     * @return A Result object indicating the outcome of the operation.
     *         If a terminal with the given ID exists, it will be updated with the new information,
     *         and a SuccessResult will be returned.
     *         If a terminal with the given ID doesn't exist, returns an ErrorResult indicating that
     *         the terminal doesn't exist.
     */
    Result update(Terminals terminals);

}
