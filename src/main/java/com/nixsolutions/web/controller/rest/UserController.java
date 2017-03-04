package com.nixsolutions.web.controller.rest;

import com.nixsolutions.model.User;
import com.nixsolutions.service.UserService;
import com.nixsolutions.web.controller.rest.exception.UserControllerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Controller
@Path("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GET
    @Path("{user_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("user_id") Long userID) throws UserControllerException {
        User user;
        try {
            user = userService.getUser(userID);
        } catch (Exception e) {
            throw new UserControllerException("User with id: " + userID + " absent in database.");
        }
        return user;
    }

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    public String saveUser(@RequestBody User user) {
        userService.add(user);
        return user.getUserID().toString();
    }

    @POST
    @Path("/update")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateUser(@RequestBody User user) {
        userService.edit(user);
        return user.getUserID().toString();
    }

    @DELETE
    @Path("{user_id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteUser(@PathParam("user_id") Long userID) {
        userService.delete(userID);
        return userID.toString();
    }
}