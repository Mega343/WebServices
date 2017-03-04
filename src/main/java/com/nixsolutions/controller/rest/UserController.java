package com.nixsolutions.controller.rest;

import com.nixsolutions.model.User;
import com.nixsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Controller
@Path("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GET
    @Path("{user_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("user_id") Long userID) {
        User user = userService.getUser(userID);
        if(user == null) {
            throw new RuntimeException("User with id: " + userID + " absent in database.");
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