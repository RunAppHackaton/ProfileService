package com.runapp.profileservice.dto.userDtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.profileservice.dto.request.UserRequest;
import com.runapp.profileservice.dto.response.UserResponse;
import com.runapp.profileservice.model.GoalModel;
import com.runapp.profileservice.model.UserModel;
import com.runapp.profileservice.utill.RoleEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserDtoMapper.class})
@ExtendWith(SpringExtension.class)
class UserDtoMapperDiffblueTest {
    @Autowired
    private UserDtoMapper userDtoMapper;

    /**
     * Method under test: {@link UserDtoMapper#toModel(UserRequest)}
     */
    @Test
    void testToModel() {
        UserModel actualToModelResult = userDtoMapper.toModel(new UserRequest());
        assertEquals("DEFAULT", actualToModelResult.getUserImageUrl());
        assertNull(actualToModelResult.getEmail());
        assertNull(actualToModelResult.getFirstName());
        assertNull(actualToModelResult.getLastName());
        assertNull(actualToModelResult.getUsername());
        assertNull(actualToModelResult.getCreateDate());
        assertEquals(RoleEnum.USER, actualToModelResult.getRole());
    }

    /**
     * Method under test: {@link UserDtoMapper#toModel(UserRequest)}
     */
    @Test
    void testToModel2() {
        UserRequest userRequest = mock(UserRequest.class);
        when(userRequest.getEmail()).thenReturn("jane.doe@example.org");
        when(userRequest.getLastName()).thenReturn("Doe");
        when(userRequest.getUsername()).thenReturn("janedoe");
        when(userRequest.getCreateDate()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
        UserModel actualToModelResult = userDtoMapper.toModel(userRequest);
        verify(userRequest).getCreateDate();
        verify(userRequest).getEmail();
        verify(userRequest).getLastName();
        verify(userRequest).getUsername();
        assertEquals("00:00", actualToModelResult.getCreateDate().toLocalTime().toString());
        assertEquals("DEFAULT", actualToModelResult.getUserImageUrl());
        assertEquals("Doe", actualToModelResult.getLastName());
        assertEquals("jane.doe@example.org", actualToModelResult.getEmail());
        assertEquals("janedoe", actualToModelResult.getUsername());
        assertNull(actualToModelResult.getFirstName());
        assertEquals(RoleEnum.USER, actualToModelResult.getRole());
    }

    /**
     * Method under test: {@link UserDtoMapper#toResponse(UserModel)}
     */
    @Test
    void testToResponse() {
        UserModel userModel = new UserModel();
        userModel.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel.setEmail("jane.doe@example.org");
        userModel.setFirstName("Jane");
        userModel.setGoalModelList(new ArrayList<>());
        userModel.setId(1);
        userModel.setLastName("Doe");
        userModel.setRole(RoleEnum.GUEST);
        userModel.setUserImageUrl("https://example.org/example");
        userModel.setUsername("janedoe");
        UserResponse actualToResponseResult = userDtoMapper.toResponse(userModel);
        assertTrue(actualToResponseResult.getRole() instanceof RoleEnum);
        assertEquals("00:00", actualToResponseResult.getCreateDate().toLocalTime().toString());
        assertEquals("Doe", actualToResponseResult.getLastName());
        assertEquals("Jane", actualToResponseResult.getFirstName());
        assertEquals("https://example.org/example", actualToResponseResult.getUserImageUrl());
        assertEquals("jane.doe@example.org", actualToResponseResult.getEmail());
        assertEquals("janedoe", actualToResponseResult.getUsername());
        assertEquals(1, actualToResponseResult.getId());
    }

    /**
     * Method under test: {@link UserDtoMapper#toResponse(UserModel)}
     */
    @Test
    void testToResponse2() {
        UserModel userModel = mock(UserModel.class);
        when(userModel.getRole()).thenReturn(RoleEnum.GUEST);
        when(userModel.getId()).thenReturn(1);
        when(userModel.getEmail()).thenReturn("jane.doe@example.org");
        when(userModel.getFirstName()).thenReturn("Jane");
        when(userModel.getLastName()).thenReturn("Doe");
        when(userModel.getUserImageUrl()).thenReturn("https://example.org/example");
        when(userModel.getUsername()).thenReturn("janedoe");
        when(userModel.getCreateDate()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
        doNothing().when(userModel).setCreateDate(Mockito.<LocalDateTime>any());
        doNothing().when(userModel).setEmail(Mockito.<String>any());
        doNothing().when(userModel).setFirstName(Mockito.<String>any());
        doNothing().when(userModel).setGoalModelList(Mockito.<List<GoalModel>>any());
        doNothing().when(userModel).setId(anyInt());
        doNothing().when(userModel).setLastName(Mockito.<String>any());
        doNothing().when(userModel).setRole(Mockito.<RoleEnum>any());
        doNothing().when(userModel).setUserImageUrl(Mockito.<String>any());
        doNothing().when(userModel).setUsername(Mockito.<String>any());
        userModel.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel.setEmail("jane.doe@example.org");
        userModel.setFirstName("Jane");
        userModel.setGoalModelList(new ArrayList<>());
        userModel.setId(1);
        userModel.setLastName("Doe");
        userModel.setRole(RoleEnum.GUEST);
        userModel.setUserImageUrl("https://example.org/example");
        userModel.setUsername("janedoe");
        UserResponse actualToResponseResult = userDtoMapper.toResponse(userModel);
        verify(userModel).getCreateDate();
        verify(userModel).getEmail();
        verify(userModel).getFirstName();
        verify(userModel).getId();
        verify(userModel).getLastName();
        verify(userModel).getRole();
        verify(userModel).getUserImageUrl();
        verify(userModel).getUsername();
        verify(userModel).setCreateDate(Mockito.<LocalDateTime>any());
        verify(userModel).setEmail(Mockito.<String>any());
        verify(userModel).setFirstName(Mockito.<String>any());
        verify(userModel).setGoalModelList(Mockito.<List<GoalModel>>any());
        verify(userModel).setId(anyInt());
        verify(userModel).setLastName(Mockito.<String>any());
        verify(userModel).setRole(Mockito.<RoleEnum>any());
        verify(userModel).setUserImageUrl(Mockito.<String>any());
        verify(userModel).setUsername(Mockito.<String>any());
        assertTrue(actualToResponseResult.getRole() instanceof RoleEnum);
        assertEquals("00:00", actualToResponseResult.getCreateDate().toLocalTime().toString());
        assertEquals("Doe", actualToResponseResult.getLastName());
        assertEquals("Jane", actualToResponseResult.getFirstName());
        assertEquals("https://example.org/example", actualToResponseResult.getUserImageUrl());
        assertEquals("jane.doe@example.org", actualToResponseResult.getEmail());
        assertEquals("janedoe", actualToResponseResult.getUsername());
        assertEquals(1, actualToResponseResult.getId());
    }
}
