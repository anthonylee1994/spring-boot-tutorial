package com.learn.springboottutorial.controller;

import com.learn.springboottutorial.dto.EntityConverter;
import com.learn.springboottutorial.dto.UserDto;
import com.learn.springboottutorial.exception.ResourceNotFoundException;
import com.learn.springboottutorial.exception.UserAlreadyExistsException;
import com.learn.springboottutorial.model.User;
import com.learn.springboottutorial.request.RegistrationRequest;
import com.learn.springboottutorial.request.UserUpdateRequest;
import com.learn.springboottutorial.response.ApiResponse;
import com.learn.springboottutorial.service.user.IUserService;
import com.learn.springboottutorial.utils.FeedBackMessage;
import com.learn.springboottutorial.utils.UrlMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * @author anthonylee
 */
@RequiredArgsConstructor
@RequestMapping(UrlMapping.USERS)
@RestController
public class UserController {
    private final IUserService userService;
    private final EntityConverter<User, UserDto> entityConverter;

    @PostMapping(UrlMapping.REGISTER_USER)
    public ResponseEntity<ApiResponse> register(@RequestBody RegistrationRequest request) {
        try {
            User theUser = userService.register(request);
            UserDto registeredUser = entityConverter.mapEntityToDto(theUser, UserDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.SUCCESS, registeredUser));
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping(UrlMapping.UPDATE_USER)
    public ResponseEntity<ApiResponse> update(@PathVariable Long userId, @RequestBody UserUpdateRequest request) {
        try {
            User theUser = userService.update(userId, request);
            UserDto updatedUser = entityConverter.mapEntityToDto(theUser, UserDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.UPDATE_SUCCESS, updatedUser));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping(UrlMapping.GET_USER_BY_ID)
    public ResponseEntity<ApiResponse> findById(@PathVariable Long userId) {
        try {
            User user = userService.findById(userId);
            UserDto theUser = entityConverter.mapEntityToDto(user, UserDto.class);
            return ResponseEntity.status(FOUND).body(new ApiResponse(FeedBackMessage.FOUND, theUser));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping(UrlMapping.DELETE_USER_BY_ID)
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Long userId) {
        try {
            userService.delete(userId);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DELETE_SUCCESS, null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping(UrlMapping.GET_ALL_USERS)
    public ResponseEntity<ApiResponse> getAllUsers() {
        try {
            List<UserDto> users = userService.getAllUsers();
            return ResponseEntity.status(FOUND).body(new ApiResponse(FeedBackMessage.SUCCESS, users));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
