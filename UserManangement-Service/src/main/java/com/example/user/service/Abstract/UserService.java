package com.example.user.service.Abstract;


import com.example.user.core.results.DataResult;
import com.example.user.core.results.Result;
import com.example.user.domain.Role;
import com.example.user.domain.User;

import java.util.List;

public interface UserService {
    /**
     * Retrieves all users from the system
     * @return A DataResult object containing list of user
     *         If the retrieval successful, returns a SuccessDataResult object with the user list
     *         Otherwise returns an ErrorDataResult object
     */
    DataResult<List<User>> getAll();
    /**
     *Retrieves user that has specified id
     *
     * @param id id of the user to return.
     * @return A DataResult object containing user object
     *         If the retrieval successfull, returns a SuccessDataResult object with user object.
     */
    DataResult<User> getById(int id);
    /**
     * Retrieves a list of users based on the specified role.
     *
     * @param role The role of the users to retrieve.
     * @return A DataResult object containing a list of users with the specified role.
     *         If the retrieval is successful, returns a SuccessDataResult with the user list.
     *         Otherwise, returns an ErrorDataResult.
     */

    DataResult<List<User>> getByRole(Role role);
    /**
     * Retrieves a user by their username.
     *
     * @param userName The username of the user to retrieve.
     * @return A DataResult object containing the user with the specified username.
     *         If the retrieval is successful, returns a SuccessDataResult with the user.
     *         Otherwise, returns an ErrorDataResult.
     */

    DataResult<User> getByUserName(String userName);
    /**
     * Adds a new user to the system.
     *
     * @param user The user to be added.
     * @return A Result object indicating the outcome of the operation.
     *         If the user's roles list is empty, the method adds a default role to the user.
     *         If the user is successfully saved, returns a SuccessResult.
     */

    Result add(User user);
    /**
     * Updates an existing user in the system.
     *
     * @param user The user to be updated.
     * @return A Result object indicating the outcome of the operation.
     *         If the user does not exist, returns an ErrorResult with the corresponding message.
     *         If the user is successfully updated, returns a SuccessResult.
     */

    Result update(User user);
    /**
     * Deletes a user from the system by the specified ID.
     *
     * @param id The ID of the user to be deleted.
     * @return A Result object indicating the outcome of the operation.
     *         If the user is successfully deleted, returns a SuccessResult.
     */

    Result delete(int id);

}
