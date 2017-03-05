package com.nixsolutions.web.controller.rest;

import com.nixsolutions.dto.UserDTO;
import com.nixsolutions.model.User;
import com.nixsolutions.service.UserService;
import com.nixsolutions.web.controller.rest.exception.UserControllerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String saveUser(UserDTO userDTO) {
        User user = UserDTO.getUser(userDTO);
        userService.add(user);
        return user.getUserID().toString();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateUser(UserDTO userDTO) {
        User user = UserDTO.getUser(userDTO);
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