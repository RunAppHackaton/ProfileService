package com.runapp.profileservice.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.profileservice.dto.request.*;
import com.runapp.profileservice.dto.response.UserResponse;
import com.runapp.profileservice.dto.userDtoMapper.UserDtoMapper;
import com.runapp.profileservice.exceptions.GlobalExceptionHandler;
import com.runapp.profileservice.feignClient.StorageServiceClient;
import com.runapp.profileservice.model.*;
import com.runapp.profileservice.repository.*;
import com.runapp.profileservice.service.UserService;
import com.runapp.profileservice.utill.GoalTypeEnum;
import com.runapp.profileservice.utill.RoleEnum;
import feign.FeignException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(classes = {UserController.class})
@WebMvcTest(UserController.class)
@ExtendWith(SpringExtension.class)
class UserControllerDiffblueTest {
    @MockBean
    private StorageServiceClient storageServiceClient;

    @Autowired
    private UserController userController;

    @MockBean
    private UserDtoMapper userDtoMapper;

    @MockBean
    private UserService userService;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ObjectMapper objectMapper;
    private MockMvc mockMvc;
    @MockBean
    private UserRepository userRepository;
    @BeforeEach
    void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }
    @Test
    void testCreateUser() {
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
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.save(Mockito.<UserModel>any())).thenReturn(userModel);
        UserService userService = new UserService(userRepository, mock(GoalRepository.class),
                mock(DistanceGoalRepository.class), mock(DurationGoalRepository.class), mock(WeightGoalRepository.class), passwordEncoder);

        UserController userController = new UserController(userService, new UserDtoMapper(), storageServiceClient);
        UserRequest userRequest = new UserRequest();
        ResponseEntity<Object> actualCreateUserResult = userController.createUser(userRequest);
        verify(userRepository).save(Mockito.<UserModel>any());
        assertTrue(((UserResponse) actualCreateUserResult.getBody()).getRole() instanceof RoleEnum);
        assertEquals("00:00", ((UserResponse) actualCreateUserResult.getBody()).getCreateDate().toLocalTime().toString());
        assertEquals("Doe", ((UserResponse) actualCreateUserResult.getBody()).getLastName());
        assertEquals("Jane", ((UserResponse) actualCreateUserResult.getBody()).getFirstName());
        assertEquals("https://example.org/example", ((UserResponse) actualCreateUserResult.getBody()).getUserImageUrl());
        assertEquals("jane.doe@example.org", ((UserResponse) actualCreateUserResult.getBody()).getEmail());
        assertEquals("janedoe", ((UserResponse) actualCreateUserResult.getBody()).getUsername());
        assertEquals(1, ((UserResponse) actualCreateUserResult.getBody()).getId());
        assertEquals(201, actualCreateUserResult.getStatusCodeValue());
        assertTrue(actualCreateUserResult.hasBody());
        assertTrue(actualCreateUserResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link UserController#createUser(UserRequest, BindingResult)}
     */
    @Test
    void testCreateUser2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.runapp.profileservice.dto.request.UserRequest["createDate"])
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
        //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1308)
        //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:772)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:479)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:318)
        //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4719)
        //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:3964)
        //   See https://diff.blue/R013 to resolve this issue.

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
        UserService userService = mock(UserService.class);
        when(userService.createUser(Mockito.<UserModel>any())).thenReturn(userModel);
        UserController userController = new UserController(userService, new UserDtoMapper(), storageServiceClient);
        UserRequest userRequest = new UserRequest();
        ResponseEntity<Object> actualCreateUserResult = userController.createUser(userRequest);
        verify(userService).createUser(Mockito.<UserModel>any());
        assertTrue(((UserResponse) actualCreateUserResult.getBody()).getRole() instanceof RoleEnum);
        assertEquals("00:00", ((UserResponse) actualCreateUserResult.getBody()).getCreateDate().toLocalTime().toString());
        assertEquals("Doe", ((UserResponse) actualCreateUserResult.getBody()).getLastName());
        assertEquals("Jane", ((UserResponse) actualCreateUserResult.getBody()).getFirstName());
        assertEquals("https://example.org/example", ((UserResponse) actualCreateUserResult.getBody()).getUserImageUrl());
        assertEquals("jane.doe@example.org", ((UserResponse) actualCreateUserResult.getBody()).getEmail());
        assertEquals("janedoe", ((UserResponse) actualCreateUserResult.getBody()).getUsername());
        assertEquals(1, ((UserResponse) actualCreateUserResult.getBody()).getId());
        assertEquals(201, actualCreateUserResult.getStatusCodeValue());
        assertTrue(actualCreateUserResult.hasBody());
        assertTrue(actualCreateUserResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link UserController#createUser(UserRequest, BindingResult)}
     */
    @Test
    void testCreateUser3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.runapp.profileservice.dto.request.UserRequest["createDate"])
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
        //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1308)
        //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:772)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:479)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:318)
        //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4719)
        //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:3964)
        //   See https://diff.blue/R013 to resolve this issue.

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
        UserService userService = mock(UserService.class);
        when(userService.createUser(Mockito.<UserModel>any())).thenReturn(userModel);

        UserModel userModel2 = new UserModel();
        userModel2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel2.setEmail("jane.doe@example.org");
        userModel2.setFirstName("Jane");
        userModel2.setGoalModelList(new ArrayList<>());
        userModel2.setId(1);
        userModel2.setLastName("Doe");
        userModel2.setRole(RoleEnum.GUEST);
        userModel2.setUserImageUrl("https://example.org/example");
        userModel2.setUsername("janedoe");
        UserDtoMapper userDtoMapper = mock(UserDtoMapper.class);
        when(userDtoMapper.toResponse(Mockito.<UserModel>any())).thenReturn(new UserResponse());
        when(userDtoMapper.toModel(Mockito.<UserRequest>any())).thenReturn(userModel2);
        UserController userController = new UserController(userService, userDtoMapper, storageServiceClient);
        UserRequest userRequest = new UserRequest();
        ResponseEntity<Object> actualCreateUserResult = userController.createUser(userRequest);
        verify(userDtoMapper).toModel(Mockito.<UserRequest>any());
        verify(userDtoMapper).toResponse(Mockito.<UserModel>any());
        verify(userService).createUser(Mockito.<UserModel>any());
        assertEquals(201, actualCreateUserResult.getStatusCodeValue());
        assertTrue(actualCreateUserResult.hasBody());
        assertTrue(actualCreateUserResult.getHeaders().isEmpty());
    }
    /**
     * Method under test:
     * {@link UserController#createUser(UserRequest, BindingResult)}
     */
    @Test
    void testCreateUser4() throws Exception {

        UserController userController = new UserController(mock(UserService.class), mock(UserDtoMapper.class), storageServiceClient);
        UserRequest userRequest = new UserRequest();

        userRequest.setUsername("");
        userRequest.setPassword("password123");
        userRequest.setFirstName("Aaaaaaaaaa");
        userRequest.setLastName("Bbbbbbbbb");
        userRequest.setEmail("invalid@gmail.com");
        userRequest.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
        // Perform the request and assert the response
        mockMvc.perform(post("/users/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    /**
     * Method under test: {@link UserController#getUserById(int)}
     */
    @Test
    void testGetUserById() throws Exception {
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
        Optional<UserModel> ofResult = Optional.of(userModel);
        when(userService.getUserById(anyInt())).thenReturn(ofResult);
        when(userDtoMapper.toResponse(Mockito.<UserModel>any())).thenReturn(new UserResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{userId}", 1);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content()
                        .string(
                                "{\"id\":0,\"username\":null,\"password\":null,\"firstName\":null,\"lastName\":null,\"role\":null,\"email\":null,\"createDate\":null,"
                                        + "\"userImageUrl\":null}"));
    }

    /**
     * Method under test: {@link UserController#getUserById(int)}
     */
    @Test
    void testGetUserById2() throws Exception {
        Optional<UserModel> emptyResult = Optional.empty();
        when(userService.getUserById(anyInt())).thenReturn(emptyResult);
        FeignException feignException = mock(FeignException.class);
        when(feignException.getCause()).thenReturn(new Throwable());
        when(userDtoMapper.toResponse(Mockito.<UserModel>any())).thenThrow(feignException);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{userId}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController).setControllerAdvice(new GlobalExceptionHandler()).build().perform(requestBuilder);
        actualPerformResult.andExpect(status().isNotFound());
    }

    /**
     * Method under test: {@link UserController#getAllUsers()}
     */
    @Test
    void testGetAllUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("[]"));
    }

    @Test
    public void testUpdateUser_ValidRequest() throws Exception {
        int userId = 1;

        // Mock the behavior of userService.updateUser
        UserModel updatedUser = new UserModel();
        updatedUser.setUsername("John Doe");
        updatedUser.setPassword("password123");
        updatedUser.setFirstName("Aaaaaaaaaa");
        updatedUser.setLastName("Bbbbbbbbb");
        updatedUser.setEmail("invalid@gmail.com");
        updatedUser.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        Mockito.when(userService.updateUser(userId, userDtoMapper.toModel(Mockito.any(UserRequest.class))))
                .thenReturn(updatedUser);

        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("John Doe");
        userRequest.setPassword("password123");
        userRequest.setFirstName("Aaaaaaaaaa");
        userRequest.setLastName("Bbbbbbbbb");
        userRequest.setEmail("invalid@gmail.com");
        // Populate other fields as needed
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
        // Perform the request and assert the response
        mockMvc.perform(put("/users/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateUser_UserNotFound() throws Exception {
        int userId = 1;

        // Mock the behavior of userService.updateUser when the user is not found
        Mockito.when(userService.updateUser(userId, userDtoMapper.toModel(Mockito.any(UserRequest.class))))
                .thenReturn(null);

        // Prepare a valid UserRequest
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("John Doe");
        userRequest.setPassword("password123");
        userRequest.setFirstName("Aaaaaaaaaa");
        userRequest.setLastName("Bbbbbbbbb");
        userRequest.setEmail("invalid@gmail.com");
        userRequest.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
        // Perform the request and assert the response
        mockMvc.perform(put("/users/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateUser_InvalidRequest() throws Exception {
        int userId = 1;
        UserRequest invalidUserRequest = new UserRequest();
        invalidUserRequest.setUsername("1");
        invalidUserRequest.setPassword("password123");
        invalidUserRequest.setFirstName("John");
        invalidUserRequest.setLastName("Doe");
        invalidUserRequest.setEmail("johndoe@gmail.com");
        invalidUserRequest.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
        // Perform the request and assert the response
        mockMvc.perform(put("/users/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidUserRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].defaultMessage", containsString("The 'username' length must be between 3 and 15 characters.")));
    }

    /**
     * Method under test: {@link UserController#deleteUser(int)}
     */
    @Test
    void testDeleteUser() throws Exception {
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
        Optional<UserModel> ofResult = Optional.of(userModel);
        doNothing().when(userService).deleteUser(anyInt());
        when(userService.getUserById(anyInt())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/{userId}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController).build().perform(requestBuilder);
        actualPerformResult.andExpect(status().isNoContent());
    }

    /**
     * Method under test: {@link UserController#deleteUser(int)}
     */
    @Test
    void testDeleteUser2() throws Exception {
        FeignException feignException = mock(FeignException.class);
        when(feignException.getCause()).thenReturn(new Throwable());
        doThrow(feignException).when(userService).deleteUser(anyInt());
        Optional<UserModel> emptyResult = Optional.empty();
        when(userService.getUserById(anyInt())).thenReturn(emptyResult);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/{userId}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(status().isNotFound());
    }

    /**
     * Method under test: {@link UserController#uploadImage(MultipartFile, int)}
     */
    @Test
    void testUploadImage() throws Exception {
        // Mock the behavior when findById is called
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        // Perform the request
        mockMvc.perform(multipart("/users/{userId}/upload-image", 1)
                        .file(new MockMultipartFile("file", "Name", "text/plain", "AXAXAXAX".getBytes())))
                .andExpect(status().isNotFound());
        // Ensure that save is not called
        verify(userRepository, never()).save(any(UserModel.class));
    }

    /**
     * Method under test:
     * {@link UserController#addDistanceGoalToUser(CreateDistanceGoalRequest)}
     */
    @Test
    void testAddDistanceGoalToUser() {
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
        Optional<UserModel> ofResult = Optional.of(userModel);
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        GoalModel goalModel = new GoalModel();
        goalModel.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDistanceGoal(new DistanceGoalModel());
        goalModel.setDurationGoal(new DurationGoalModel());
        goalModel.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel.setId(1L);
        goalModel.setUser(new UserModel());
        goalModel.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal = new DistanceGoalModel();
        distanceGoal.setDistance(1L);
        distanceGoal.setGoalModel(goalModel);
        distanceGoal.setId(1L);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDistanceGoal(new DistanceGoalModel());
        goalModel2.setDurationGoal(new DurationGoalModel());
        goalModel2.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel2.setId(1L);
        goalModel2.setUser(new UserModel());
        goalModel2.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal = new DurationGoalModel();
        durationGoal.setGoalModel(goalModel2);
        durationGoal.setId(1L);

        UserModel user = new UserModel();
        user.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setGoalModelList(new ArrayList<>());
        user.setId(1);
        user.setLastName("Doe");
        user.setRole(RoleEnum.GUEST);
        user.setUserImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        GoalModel goalModel3 = new GoalModel();
        goalModel3.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDistanceGoal(new DistanceGoalModel());
        goalModel3.setDurationGoal(new DurationGoalModel());
        goalModel3.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel3.setId(1L);
        goalModel3.setUser(new UserModel());
        goalModel3.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal = new WeightGoalModel();
        weightGoal.setCurrentWeight(3);
        weightGoal.setGoalModel(goalModel3);
        weightGoal.setId(1L);
        weightGoal.setTargetWeight(3);

        GoalModel goalModel4 = new GoalModel();
        goalModel4.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDistanceGoal(distanceGoal);
        goalModel4.setDurationGoal(durationGoal);
        goalModel4.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel4.setId(1L);
        goalModel4.setUser(user);
        goalModel4.setWeightGoal(weightGoal);

        DistanceGoalModel distanceGoal2 = new DistanceGoalModel();
        distanceGoal2.setDistance(1L);
        distanceGoal2.setGoalModel(goalModel4);
        distanceGoal2.setId(1L);

        GoalModel goalModel5 = new GoalModel();
        goalModel5.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDistanceGoal(new DistanceGoalModel());
        goalModel5.setDurationGoal(new DurationGoalModel());
        goalModel5.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel5.setId(1L);
        goalModel5.setUser(new UserModel());
        goalModel5.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal3 = new DistanceGoalModel();
        distanceGoal3.setDistance(1L);
        distanceGoal3.setGoalModel(goalModel5);
        distanceGoal3.setId(1L);

        GoalModel goalModel6 = new GoalModel();
        goalModel6.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDistanceGoal(new DistanceGoalModel());
        goalModel6.setDurationGoal(new DurationGoalModel());
        goalModel6.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel6.setId(1L);
        goalModel6.setUser(new UserModel());
        goalModel6.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal2 = new DurationGoalModel();
        durationGoal2.setGoalModel(goalModel6);
        durationGoal2.setId(1L);

        UserModel user2 = new UserModel();
        user2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setGoalModelList(new ArrayList<>());
        user2.setId(1);
        user2.setLastName("Doe");
        user2.setRole(RoleEnum.GUEST);
        user2.setUserImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        GoalModel goalModel7 = new GoalModel();
        goalModel7.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDistanceGoal(new DistanceGoalModel());
        goalModel7.setDurationGoal(new DurationGoalModel());
        goalModel7.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel7.setId(1L);
        goalModel7.setUser(new UserModel());
        goalModel7.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal2 = new WeightGoalModel();
        weightGoal2.setCurrentWeight(3);
        weightGoal2.setGoalModel(goalModel7);
        weightGoal2.setId(1L);
        weightGoal2.setTargetWeight(3);

        GoalModel goalModel8 = new GoalModel();
        goalModel8.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDistanceGoal(distanceGoal3);
        goalModel8.setDurationGoal(durationGoal2);
        goalModel8.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel8.setId(1L);
        goalModel8.setUser(user2);
        goalModel8.setWeightGoal(weightGoal2);

        DurationGoalModel durationGoal3 = new DurationGoalModel();
        durationGoal3.setGoalModel(goalModel8);
        durationGoal3.setId(1L);

        UserModel user3 = new UserModel();
        user3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user3.setEmail("jane.doe@example.org");
        user3.setFirstName("Jane");
        user3.setGoalModelList(new ArrayList<>());
        user3.setId(1);
        user3.setLastName("Doe");
        user3.setRole(RoleEnum.GUEST);
        user3.setUserImageUrl("https://example.org/example");
        user3.setUsername("janedoe");

        GoalModel goalModel9 = new GoalModel();
        goalModel9.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel9.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel9.setDistanceGoal(new DistanceGoalModel());
        goalModel9.setDurationGoal(new DurationGoalModel());
        goalModel9.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel9.setId(1L);
        goalModel9.setUser(new UserModel());
        goalModel9.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(1L);
        distanceGoal4.setGoalModel(goalModel9);
        distanceGoal4.setId(1L);

        GoalModel goalModel10 = new GoalModel();
        goalModel10.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel10.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel10.setDistanceGoal(new DistanceGoalModel());
        goalModel10.setDurationGoal(new DurationGoalModel());
        goalModel10.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel10.setId(1L);
        goalModel10.setUser(new UserModel());
        goalModel10.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(goalModel10);
        durationGoal4.setId(1L);

        UserModel user4 = new UserModel();
        user4.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user4.setEmail("jane.doe@example.org");
        user4.setFirstName("Jane");
        user4.setGoalModelList(new ArrayList<>());
        user4.setId(1);
        user4.setLastName("Doe");
        user4.setRole(RoleEnum.GUEST);
        user4.setUserImageUrl("https://example.org/example");
        user4.setUsername("janedoe");

        GoalModel goalModel11 = new GoalModel();
        goalModel11.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel11.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel11.setDistanceGoal(new DistanceGoalModel());
        goalModel11.setDurationGoal(new DurationGoalModel());
        goalModel11.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel11.setId(1L);
        goalModel11.setUser(new UserModel());
        goalModel11.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal3 = new WeightGoalModel();
        weightGoal3.setCurrentWeight(3);
        weightGoal3.setGoalModel(goalModel11);
        weightGoal3.setId(1L);
        weightGoal3.setTargetWeight(3);

        GoalModel goalModel12 = new GoalModel();
        goalModel12.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel12.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel12.setDistanceGoal(distanceGoal4);
        goalModel12.setDurationGoal(durationGoal4);
        goalModel12.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel12.setId(1L);
        goalModel12.setUser(user4);
        goalModel12.setWeightGoal(weightGoal3);

        WeightGoalModel weightGoal4 = new WeightGoalModel();
        weightGoal4.setCurrentWeight(3);
        weightGoal4.setGoalModel(goalModel12);
        weightGoal4.setId(1L);
        weightGoal4.setTargetWeight(3);

        GoalModel goalModel13 = new GoalModel();
        goalModel13.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel13.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel13.setDistanceGoal(distanceGoal2);
        goalModel13.setDurationGoal(durationGoal3);
        goalModel13.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel13.setId(1L);
        goalModel13.setUser(user3);
        goalModel13.setWeightGoal(weightGoal4);
        GoalRepository goalRepository = mock(GoalRepository.class);
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel13);

        DistanceGoalModel distanceGoal5 = new DistanceGoalModel();
        distanceGoal5.setDistance(1L);
        distanceGoal5.setGoalModel(new GoalModel());
        distanceGoal5.setId(1L);

        DurationGoalModel durationGoal5 = new DurationGoalModel();
        durationGoal5.setGoalModel(new GoalModel());
        durationGoal5.setId(1L);

        UserModel user5 = new UserModel();
        user5.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user5.setEmail("jane.doe@example.org");
        user5.setFirstName("Jane");
        user5.setGoalModelList(new ArrayList<>());
        user5.setId(1);
        user5.setLastName("Doe");
        user5.setRole(RoleEnum.GUEST);
        user5.setUserImageUrl("https://example.org/example");
        user5.setUsername("janedoe");

        WeightGoalModel weightGoal5 = new WeightGoalModel();
        weightGoal5.setCurrentWeight(3);
        weightGoal5.setGoalModel(new GoalModel());
        weightGoal5.setId(1L);
        weightGoal5.setTargetWeight(3);

        GoalModel goalModel14 = new GoalModel();
        goalModel14.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel14.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel14.setDistanceGoal(distanceGoal5);
        goalModel14.setDurationGoal(durationGoal5);
        goalModel14.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel14.setId(1L);
        goalModel14.setUser(user5);
        goalModel14.setWeightGoal(weightGoal5);

        DistanceGoalModel distanceGoal6 = new DistanceGoalModel();
        distanceGoal6.setDistance(1L);
        distanceGoal6.setGoalModel(goalModel14);
        distanceGoal6.setId(1L);

        DistanceGoalModel distanceGoal7 = new DistanceGoalModel();
        distanceGoal7.setDistance(1L);
        distanceGoal7.setGoalModel(new GoalModel());
        distanceGoal7.setId(1L);

        DurationGoalModel durationGoal6 = new DurationGoalModel();
        durationGoal6.setGoalModel(new GoalModel());
        durationGoal6.setId(1L);

        UserModel user6 = new UserModel();
        user6.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user6.setEmail("jane.doe@example.org");
        user6.setFirstName("Jane");
        user6.setGoalModelList(new ArrayList<>());
        user6.setId(1);
        user6.setLastName("Doe");
        user6.setRole(RoleEnum.GUEST);
        user6.setUserImageUrl("https://example.org/example");
        user6.setUsername("janedoe");

        WeightGoalModel weightGoal6 = new WeightGoalModel();
        weightGoal6.setCurrentWeight(3);
        weightGoal6.setGoalModel(new GoalModel());
        weightGoal6.setId(1L);
        weightGoal6.setTargetWeight(3);

        GoalModel goalModel15 = new GoalModel();
        goalModel15.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel15.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel15.setDistanceGoal(distanceGoal7);
        goalModel15.setDurationGoal(durationGoal6);
        goalModel15.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel15.setId(1L);
        goalModel15.setUser(user6);
        goalModel15.setWeightGoal(weightGoal6);

        DurationGoalModel durationGoal7 = new DurationGoalModel();
        durationGoal7.setGoalModel(goalModel15);
        durationGoal7.setId(1L);

        UserModel user7 = new UserModel();
        user7.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user7.setEmail("jane.doe@example.org");
        user7.setFirstName("Jane");
        user7.setGoalModelList(new ArrayList<>());
        user7.setId(1);
        user7.setLastName("Doe");
        user7.setRole(RoleEnum.GUEST);
        user7.setUserImageUrl("https://example.org/example");
        user7.setUsername("janedoe");

        DistanceGoalModel distanceGoal8 = new DistanceGoalModel();
        distanceGoal8.setDistance(1L);
        distanceGoal8.setGoalModel(new GoalModel());
        distanceGoal8.setId(1L);

        DurationGoalModel durationGoal8 = new DurationGoalModel();
        durationGoal8.setGoalModel(new GoalModel());
        durationGoal8.setId(1L);

        UserModel user8 = new UserModel();
        user8.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user8.setEmail("jane.doe@example.org");
        user8.setFirstName("Jane");
        user8.setGoalModelList(new ArrayList<>());
        user8.setId(1);
        user8.setLastName("Doe");
        user8.setRole(RoleEnum.GUEST);
        user8.setUserImageUrl("https://example.org/example");
        user8.setUsername("janedoe");

        WeightGoalModel weightGoal7 = new WeightGoalModel();
        weightGoal7.setCurrentWeight(3);
        weightGoal7.setGoalModel(new GoalModel());
        weightGoal7.setId(1L);
        weightGoal7.setTargetWeight(3);

        GoalModel goalModel16 = new GoalModel();
        goalModel16.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel16.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel16.setDistanceGoal(distanceGoal8);
        goalModel16.setDurationGoal(durationGoal8);
        goalModel16.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel16.setId(1L);
        goalModel16.setUser(user8);
        goalModel16.setWeightGoal(weightGoal7);

        WeightGoalModel weightGoal8 = new WeightGoalModel();
        weightGoal8.setCurrentWeight(3);
        weightGoal8.setGoalModel(goalModel16);
        weightGoal8.setId(1L);
        weightGoal8.setTargetWeight(3);

        GoalModel goalModel17 = new GoalModel();
        goalModel17.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel17.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel17.setDistanceGoal(distanceGoal6);
        goalModel17.setDurationGoal(durationGoal7);
        goalModel17.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel17.setId(1L);
        goalModel17.setUser(user7);
        goalModel17.setWeightGoal(weightGoal8);

        DistanceGoalModel distanceGoalModel = new DistanceGoalModel();
        distanceGoalModel.setDistance(1L);
        distanceGoalModel.setGoalModel(goalModel17);
        distanceGoalModel.setId(1L);
        DistanceGoalRepository distanceGoalRepository = mock(DistanceGoalRepository.class);
        when(distanceGoalRepository.save(Mockito.<DistanceGoalModel>any())).thenReturn(distanceGoalModel);
        UserService userService = new UserService(userRepository, goalRepository, distanceGoalRepository,
                mock(DurationGoalRepository.class), mock(WeightGoalRepository.class), passwordEncoder);

        UserController userController = new UserController(userService, new UserDtoMapper(), storageServiceClient);
        ResponseEntity<DistanceGoalModel> actualAddDistanceGoalToUserResult = userController
                .addDistanceGoalToUser(new CreateDistanceGoalRequest());
        verify(userRepository).findById(Mockito.<Integer>any());
        verify(distanceGoalRepository).save(Mockito.<DistanceGoalModel>any());
        verify(goalRepository).save(Mockito.<GoalModel>any());
        assertEquals(201, actualAddDistanceGoalToUserResult.getStatusCodeValue());
        assertTrue(actualAddDistanceGoalToUserResult.hasBody());
        assertTrue(actualAddDistanceGoalToUserResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link UserController#addDurationGoalToUser(CreateDurationGoalRequest)}
     */
    @Test
    void testAddDurationGoalToUser() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.runapp.profileservice.dto.request.CreateDurationGoalRequest["dateStart"])
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
        //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1308)
        //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:772)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:479)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:318)
        //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4719)
        //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:3964)
        //   See https://diff.blue/R013 to resolve this issue.

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
        Optional<UserModel> ofResult = Optional.of(userModel);
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        GoalModel goalModel = new GoalModel();
        goalModel.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDistanceGoal(new DistanceGoalModel());
        goalModel.setDurationGoal(new DurationGoalModel());
        goalModel.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel.setId(1L);
        goalModel.setUser(new UserModel());
        goalModel.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal = new DistanceGoalModel();
        distanceGoal.setDistance(1L);
        distanceGoal.setGoalModel(goalModel);
        distanceGoal.setId(1L);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDistanceGoal(new DistanceGoalModel());
        goalModel2.setDurationGoal(new DurationGoalModel());
        goalModel2.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel2.setId(1L);
        goalModel2.setUser(new UserModel());
        goalModel2.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal = new DurationGoalModel();
        durationGoal.setGoalModel(goalModel2);
        durationGoal.setId(1L);

        UserModel user = new UserModel();
        user.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setGoalModelList(new ArrayList<>());
        user.setId(1);
        user.setLastName("Doe");
        user.setRole(RoleEnum.GUEST);
        user.setUserImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        GoalModel goalModel3 = new GoalModel();
        goalModel3.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDistanceGoal(new DistanceGoalModel());
        goalModel3.setDurationGoal(new DurationGoalModel());
        goalModel3.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel3.setId(1L);
        goalModel3.setUser(new UserModel());
        goalModel3.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal = new WeightGoalModel();
        weightGoal.setCurrentWeight(3);
        weightGoal.setGoalModel(goalModel3);
        weightGoal.setId(1L);
        weightGoal.setTargetWeight(3);

        GoalModel goalModel4 = new GoalModel();
        goalModel4.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDistanceGoal(distanceGoal);
        goalModel4.setDurationGoal(durationGoal);
        goalModel4.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel4.setId(1L);
        goalModel4.setUser(user);
        goalModel4.setWeightGoal(weightGoal);

        DistanceGoalModel distanceGoal2 = new DistanceGoalModel();
        distanceGoal2.setDistance(1L);
        distanceGoal2.setGoalModel(goalModel4);
        distanceGoal2.setId(1L);

        GoalModel goalModel5 = new GoalModel();
        goalModel5.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDistanceGoal(new DistanceGoalModel());
        goalModel5.setDurationGoal(new DurationGoalModel());
        goalModel5.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel5.setId(1L);
        goalModel5.setUser(new UserModel());
        goalModel5.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal3 = new DistanceGoalModel();
        distanceGoal3.setDistance(1L);
        distanceGoal3.setGoalModel(goalModel5);
        distanceGoal3.setId(1L);

        GoalModel goalModel6 = new GoalModel();
        goalModel6.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDistanceGoal(new DistanceGoalModel());
        goalModel6.setDurationGoal(new DurationGoalModel());
        goalModel6.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel6.setId(1L);
        goalModel6.setUser(new UserModel());
        goalModel6.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal2 = new DurationGoalModel();
        durationGoal2.setGoalModel(goalModel6);
        durationGoal2.setId(1L);

        UserModel user2 = new UserModel();
        user2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setGoalModelList(new ArrayList<>());
        user2.setId(1);
        user2.setLastName("Doe");
        user2.setRole(RoleEnum.GUEST);
        user2.setUserImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        GoalModel goalModel7 = new GoalModel();
        goalModel7.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDistanceGoal(new DistanceGoalModel());
        goalModel7.setDurationGoal(new DurationGoalModel());
        goalModel7.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel7.setId(1L);
        goalModel7.setUser(new UserModel());
        goalModel7.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal2 = new WeightGoalModel();
        weightGoal2.setCurrentWeight(3);
        weightGoal2.setGoalModel(goalModel7);
        weightGoal2.setId(1L);
        weightGoal2.setTargetWeight(3);

        GoalModel goalModel8 = new GoalModel();
        goalModel8.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDistanceGoal(distanceGoal3);
        goalModel8.setDurationGoal(durationGoal2);
        goalModel8.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel8.setId(1L);
        goalModel8.setUser(user2);
        goalModel8.setWeightGoal(weightGoal2);

        DurationGoalModel durationGoal3 = new DurationGoalModel();
        durationGoal3.setGoalModel(goalModel8);
        durationGoal3.setId(1L);

        UserModel user3 = new UserModel();
        user3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user3.setEmail("jane.doe@example.org");
        user3.setFirstName("Jane");
        user3.setGoalModelList(new ArrayList<>());
        user3.setId(1);
        user3.setLastName("Doe");
        user3.setRole(RoleEnum.GUEST);
        user3.setUserImageUrl("https://example.org/example");
        user3.setUsername("janedoe");

        GoalModel goalModel9 = new GoalModel();
        goalModel9.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel9.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel9.setDistanceGoal(new DistanceGoalModel());
        goalModel9.setDurationGoal(new DurationGoalModel());
        goalModel9.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel9.setId(1L);
        goalModel9.setUser(new UserModel());
        goalModel9.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(1L);
        distanceGoal4.setGoalModel(goalModel9);
        distanceGoal4.setId(1L);

        GoalModel goalModel10 = new GoalModel();
        goalModel10.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel10.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel10.setDistanceGoal(new DistanceGoalModel());
        goalModel10.setDurationGoal(new DurationGoalModel());
        goalModel10.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel10.setId(1L);
        goalModel10.setUser(new UserModel());
        goalModel10.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(goalModel10);
        durationGoal4.setId(1L);

        UserModel user4 = new UserModel();
        user4.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user4.setEmail("jane.doe@example.org");
        user4.setFirstName("Jane");
        user4.setGoalModelList(new ArrayList<>());
        user4.setId(1);
        user4.setLastName("Doe");
        user4.setRole(RoleEnum.GUEST);
        user4.setUserImageUrl("https://example.org/example");
        user4.setUsername("janedoe");

        GoalModel goalModel11 = new GoalModel();
        goalModel11.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel11.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel11.setDistanceGoal(new DistanceGoalModel());
        goalModel11.setDurationGoal(new DurationGoalModel());
        goalModel11.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel11.setId(1L);
        goalModel11.setUser(new UserModel());
        goalModel11.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal3 = new WeightGoalModel();
        weightGoal3.setCurrentWeight(3);
        weightGoal3.setGoalModel(goalModel11);
        weightGoal3.setId(1L);
        weightGoal3.setTargetWeight(3);

        GoalModel goalModel12 = new GoalModel();
        goalModel12.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel12.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel12.setDistanceGoal(distanceGoal4);
        goalModel12.setDurationGoal(durationGoal4);
        goalModel12.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel12.setId(1L);
        goalModel12.setUser(user4);
        goalModel12.setWeightGoal(weightGoal3);

        WeightGoalModel weightGoal4 = new WeightGoalModel();
        weightGoal4.setCurrentWeight(3);
        weightGoal4.setGoalModel(goalModel12);
        weightGoal4.setId(1L);
        weightGoal4.setTargetWeight(3);

        GoalModel goalModel13 = new GoalModel();
        goalModel13.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel13.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel13.setDistanceGoal(distanceGoal2);
        goalModel13.setDurationGoal(durationGoal3);
        goalModel13.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel13.setId(1L);
        goalModel13.setUser(user3);
        goalModel13.setWeightGoal(weightGoal4);
        GoalRepository goalRepository = mock(GoalRepository.class);
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel13);

        DistanceGoalModel distanceGoal5 = new DistanceGoalModel();
        distanceGoal5.setDistance(1L);
        distanceGoal5.setGoalModel(new GoalModel());
        distanceGoal5.setId(1L);

        DurationGoalModel durationGoal5 = new DurationGoalModel();
        durationGoal5.setGoalModel(new GoalModel());
        durationGoal5.setId(1L);

        UserModel user5 = new UserModel();
        user5.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user5.setEmail("jane.doe@example.org");
        user5.setFirstName("Jane");
        user5.setGoalModelList(new ArrayList<>());
        user5.setId(1);
        user5.setLastName("Doe");
        user5.setRole(RoleEnum.GUEST);
        user5.setUserImageUrl("https://example.org/example");
        user5.setUsername("janedoe");

        WeightGoalModel weightGoal5 = new WeightGoalModel();
        weightGoal5.setCurrentWeight(3);
        weightGoal5.setGoalModel(new GoalModel());
        weightGoal5.setId(1L);
        weightGoal5.setTargetWeight(3);

        GoalModel goalModel14 = new GoalModel();
        goalModel14.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel14.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel14.setDistanceGoal(distanceGoal5);
        goalModel14.setDurationGoal(durationGoal5);
        goalModel14.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel14.setId(1L);
        goalModel14.setUser(user5);
        goalModel14.setWeightGoal(weightGoal5);

        DistanceGoalModel distanceGoal6 = new DistanceGoalModel();
        distanceGoal6.setDistance(1L);
        distanceGoal6.setGoalModel(goalModel14);
        distanceGoal6.setId(1L);

        DistanceGoalModel distanceGoal7 = new DistanceGoalModel();
        distanceGoal7.setDistance(1L);
        distanceGoal7.setGoalModel(new GoalModel());
        distanceGoal7.setId(1L);

        DurationGoalModel durationGoal6 = new DurationGoalModel();
        durationGoal6.setGoalModel(new GoalModel());
        durationGoal6.setId(1L);

        UserModel user6 = new UserModel();
        user6.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user6.setEmail("jane.doe@example.org");
        user6.setFirstName("Jane");
        user6.setGoalModelList(new ArrayList<>());
        user6.setId(1);
        user6.setLastName("Doe");
        user6.setRole(RoleEnum.GUEST);
        user6.setUserImageUrl("https://example.org/example");
        user6.setUsername("janedoe");

        WeightGoalModel weightGoal6 = new WeightGoalModel();
        weightGoal6.setCurrentWeight(3);
        weightGoal6.setGoalModel(new GoalModel());
        weightGoal6.setId(1L);
        weightGoal6.setTargetWeight(3);

        GoalModel goalModel15 = new GoalModel();
        goalModel15.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel15.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel15.setDistanceGoal(distanceGoal7);
        goalModel15.setDurationGoal(durationGoal6);
        goalModel15.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel15.setId(1L);
        goalModel15.setUser(user6);
        goalModel15.setWeightGoal(weightGoal6);

        DurationGoalModel durationGoal7 = new DurationGoalModel();
        durationGoal7.setGoalModel(goalModel15);
        durationGoal7.setId(1L);

        UserModel user7 = new UserModel();
        user7.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user7.setEmail("jane.doe@example.org");
        user7.setFirstName("Jane");
        user7.setGoalModelList(new ArrayList<>());
        user7.setId(1);
        user7.setLastName("Doe");
        user7.setRole(RoleEnum.GUEST);
        user7.setUserImageUrl("https://example.org/example");
        user7.setUsername("janedoe");

        DistanceGoalModel distanceGoal8 = new DistanceGoalModel();
        distanceGoal8.setDistance(1L);
        distanceGoal8.setGoalModel(new GoalModel());
        distanceGoal8.setId(1L);

        DurationGoalModel durationGoal8 = new DurationGoalModel();
        durationGoal8.setGoalModel(new GoalModel());
        durationGoal8.setId(1L);

        UserModel user8 = new UserModel();
        user8.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user8.setEmail("jane.doe@example.org");
        user8.setFirstName("Jane");
        user8.setGoalModelList(new ArrayList<>());
        user8.setId(1);
        user8.setLastName("Doe");
        user8.setRole(RoleEnum.GUEST);
        user8.setUserImageUrl("https://example.org/example");
        user8.setUsername("janedoe");

        WeightGoalModel weightGoal7 = new WeightGoalModel();
        weightGoal7.setCurrentWeight(3);
        weightGoal7.setGoalModel(new GoalModel());
        weightGoal7.setId(1L);
        weightGoal7.setTargetWeight(3);

        GoalModel goalModel16 = new GoalModel();
        goalModel16.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel16.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel16.setDistanceGoal(distanceGoal8);
        goalModel16.setDurationGoal(durationGoal8);
        goalModel16.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel16.setId(1L);
        goalModel16.setUser(user8);
        goalModel16.setWeightGoal(weightGoal7);

        WeightGoalModel weightGoal8 = new WeightGoalModel();
        weightGoal8.setCurrentWeight(3);
        weightGoal8.setGoalModel(goalModel16);
        weightGoal8.setId(1L);
        weightGoal8.setTargetWeight(3);

        GoalModel goalModel17 = new GoalModel();
        goalModel17.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel17.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel17.setDistanceGoal(distanceGoal6);
        goalModel17.setDurationGoal(durationGoal7);
        goalModel17.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel17.setId(1L);
        goalModel17.setUser(user7);
        goalModel17.setWeightGoal(weightGoal8);

        DurationGoalModel durationGoalModel = new DurationGoalModel();
        durationGoalModel.setGoalModel(goalModel17);
        durationGoalModel.setId(1L);
        DurationGoalRepository durationGoalRepository = mock(DurationGoalRepository.class);
        when(durationGoalRepository.save(Mockito.<DurationGoalModel>any())).thenReturn(durationGoalModel);
        UserService userService = new UserService(userRepository, goalRepository, mock(DistanceGoalRepository.class),
                durationGoalRepository, mock(WeightGoalRepository.class), passwordEncoder);

        UserController userController = new UserController(userService, new UserDtoMapper(), storageServiceClient);
        ResponseEntity<DurationGoalModel> actualAddDurationGoalToUserResult = userController
                .addDurationGoalToUser(new CreateDurationGoalRequest());
        verify(userRepository).findById(Mockito.<Integer>any());
        verify(durationGoalRepository).save(Mockito.<DurationGoalModel>any());
        verify(goalRepository).save(Mockito.<GoalModel>any());
        assertEquals(201, actualAddDurationGoalToUserResult.getStatusCodeValue());
        assertTrue(actualAddDurationGoalToUserResult.hasBody());
        assertTrue(actualAddDurationGoalToUserResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link UserController#addWeightGoalToUser(CreateWeightGoalRequest)}
     */
    @Test
    void testAddWeightGoalToUser() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.runapp.profileservice.dto.request.CreateWeightGoalRequest["dateStart"])
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
        //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1308)
        //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:772)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:479)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:318)
        //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4719)
        //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:3964)
        //   See https://diff.blue/R013 to resolve this issue.

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
        Optional<UserModel> ofResult = Optional.of(userModel);
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        GoalModel goalModel = new GoalModel();
        goalModel.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDistanceGoal(new DistanceGoalModel());
        goalModel.setDurationGoal(new DurationGoalModel());
        goalModel.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel.setId(1L);
        goalModel.setUser(new UserModel());
        goalModel.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal = new DistanceGoalModel();
        distanceGoal.setDistance(1L);
        distanceGoal.setGoalModel(goalModel);
        distanceGoal.setId(1L);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDistanceGoal(new DistanceGoalModel());
        goalModel2.setDurationGoal(new DurationGoalModel());
        goalModel2.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel2.setId(1L);
        goalModel2.setUser(new UserModel());
        goalModel2.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal = new DurationGoalModel();
        durationGoal.setGoalModel(goalModel2);
        durationGoal.setId(1L);

        UserModel user = new UserModel();
        user.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setGoalModelList(new ArrayList<>());
        user.setId(1);
        user.setLastName("Doe");
        user.setRole(RoleEnum.GUEST);
        user.setUserImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        GoalModel goalModel3 = new GoalModel();
        goalModel3.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDistanceGoal(new DistanceGoalModel());
        goalModel3.setDurationGoal(new DurationGoalModel());
        goalModel3.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel3.setId(1L);
        goalModel3.setUser(new UserModel());
        goalModel3.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal = new WeightGoalModel();
        weightGoal.setCurrentWeight(3);
        weightGoal.setGoalModel(goalModel3);
        weightGoal.setId(1L);
        weightGoal.setTargetWeight(3);

        GoalModel goalModel4 = new GoalModel();
        goalModel4.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDistanceGoal(distanceGoal);
        goalModel4.setDurationGoal(durationGoal);
        goalModel4.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel4.setId(1L);
        goalModel4.setUser(user);
        goalModel4.setWeightGoal(weightGoal);

        DistanceGoalModel distanceGoal2 = new DistanceGoalModel();
        distanceGoal2.setDistance(1L);
        distanceGoal2.setGoalModel(goalModel4);
        distanceGoal2.setId(1L);

        GoalModel goalModel5 = new GoalModel();
        goalModel5.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDistanceGoal(new DistanceGoalModel());
        goalModel5.setDurationGoal(new DurationGoalModel());
        goalModel5.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel5.setId(1L);
        goalModel5.setUser(new UserModel());
        goalModel5.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal3 = new DistanceGoalModel();
        distanceGoal3.setDistance(1L);
        distanceGoal3.setGoalModel(goalModel5);
        distanceGoal3.setId(1L);

        GoalModel goalModel6 = new GoalModel();
        goalModel6.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDistanceGoal(new DistanceGoalModel());
        goalModel6.setDurationGoal(new DurationGoalModel());
        goalModel6.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel6.setId(1L);
        goalModel6.setUser(new UserModel());
        goalModel6.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal2 = new DurationGoalModel();
        durationGoal2.setGoalModel(goalModel6);
        durationGoal2.setId(1L);

        UserModel user2 = new UserModel();
        user2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setGoalModelList(new ArrayList<>());
        user2.setId(1);
        user2.setLastName("Doe");
        user2.setRole(RoleEnum.GUEST);
        user2.setUserImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        GoalModel goalModel7 = new GoalModel();
        goalModel7.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDistanceGoal(new DistanceGoalModel());
        goalModel7.setDurationGoal(new DurationGoalModel());
        goalModel7.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel7.setId(1L);
        goalModel7.setUser(new UserModel());
        goalModel7.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal2 = new WeightGoalModel();
        weightGoal2.setCurrentWeight(3);
        weightGoal2.setGoalModel(goalModel7);
        weightGoal2.setId(1L);
        weightGoal2.setTargetWeight(3);

        GoalModel goalModel8 = new GoalModel();
        goalModel8.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDistanceGoal(distanceGoal3);
        goalModel8.setDurationGoal(durationGoal2);
        goalModel8.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel8.setId(1L);
        goalModel8.setUser(user2);
        goalModel8.setWeightGoal(weightGoal2);

        DurationGoalModel durationGoal3 = new DurationGoalModel();
        durationGoal3.setGoalModel(goalModel8);
        durationGoal3.setId(1L);

        UserModel user3 = new UserModel();
        user3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user3.setEmail("jane.doe@example.org");
        user3.setFirstName("Jane");
        user3.setGoalModelList(new ArrayList<>());
        user3.setId(1);
        user3.setLastName("Doe");
        user3.setRole(RoleEnum.GUEST);
        user3.setUserImageUrl("https://example.org/example");
        user3.setUsername("janedoe");

        GoalModel goalModel9 = new GoalModel();
        goalModel9.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel9.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel9.setDistanceGoal(new DistanceGoalModel());
        goalModel9.setDurationGoal(new DurationGoalModel());
        goalModel9.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel9.setId(1L);
        goalModel9.setUser(new UserModel());
        goalModel9.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(1L);
        distanceGoal4.setGoalModel(goalModel9);
        distanceGoal4.setId(1L);

        GoalModel goalModel10 = new GoalModel();
        goalModel10.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel10.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel10.setDistanceGoal(new DistanceGoalModel());
        goalModel10.setDurationGoal(new DurationGoalModel());
        goalModel10.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel10.setId(1L);
        goalModel10.setUser(new UserModel());
        goalModel10.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(goalModel10);
        durationGoal4.setId(1L);

        UserModel user4 = new UserModel();
        user4.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user4.setEmail("jane.doe@example.org");
        user4.setFirstName("Jane");
        user4.setGoalModelList(new ArrayList<>());
        user4.setId(1);
        user4.setLastName("Doe");
        user4.setRole(RoleEnum.GUEST);
        user4.setUserImageUrl("https://example.org/example");
        user4.setUsername("janedoe");

        GoalModel goalModel11 = new GoalModel();
        goalModel11.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel11.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel11.setDistanceGoal(new DistanceGoalModel());
        goalModel11.setDurationGoal(new DurationGoalModel());
        goalModel11.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel11.setId(1L);
        goalModel11.setUser(new UserModel());
        goalModel11.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal3 = new WeightGoalModel();
        weightGoal3.setCurrentWeight(3);
        weightGoal3.setGoalModel(goalModel11);
        weightGoal3.setId(1L);
        weightGoal3.setTargetWeight(3);

        GoalModel goalModel12 = new GoalModel();
        goalModel12.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel12.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel12.setDistanceGoal(distanceGoal4);
        goalModel12.setDurationGoal(durationGoal4);
        goalModel12.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel12.setId(1L);
        goalModel12.setUser(user4);
        goalModel12.setWeightGoal(weightGoal3);

        WeightGoalModel weightGoal4 = new WeightGoalModel();
        weightGoal4.setCurrentWeight(3);
        weightGoal4.setGoalModel(goalModel12);
        weightGoal4.setId(1L);
        weightGoal4.setTargetWeight(3);

        GoalModel goalModel13 = new GoalModel();
        goalModel13.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel13.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel13.setDistanceGoal(distanceGoal2);
        goalModel13.setDurationGoal(durationGoal3);
        goalModel13.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel13.setId(1L);
        goalModel13.setUser(user3);
        goalModel13.setWeightGoal(weightGoal4);
        GoalRepository goalRepository = mock(GoalRepository.class);
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel13);

        DistanceGoalModel distanceGoal5 = new DistanceGoalModel();
        distanceGoal5.setDistance(1L);
        distanceGoal5.setGoalModel(new GoalModel());
        distanceGoal5.setId(1L);

        DurationGoalModel durationGoal5 = new DurationGoalModel();
        durationGoal5.setGoalModel(new GoalModel());
        durationGoal5.setId(1L);

        UserModel user5 = new UserModel();
        user5.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user5.setEmail("jane.doe@example.org");
        user5.setFirstName("Jane");
        user5.setGoalModelList(new ArrayList<>());
        user5.setId(1);
        user5.setLastName("Doe");
        user5.setRole(RoleEnum.GUEST);
        user5.setUserImageUrl("https://example.org/example");
        user5.setUsername("janedoe");

        WeightGoalModel weightGoal5 = new WeightGoalModel();
        weightGoal5.setCurrentWeight(3);
        weightGoal5.setGoalModel(new GoalModel());
        weightGoal5.setId(1L);
        weightGoal5.setTargetWeight(3);

        GoalModel goalModel14 = new GoalModel();
        goalModel14.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel14.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel14.setDistanceGoal(distanceGoal5);
        goalModel14.setDurationGoal(durationGoal5);
        goalModel14.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel14.setId(1L);
        goalModel14.setUser(user5);
        goalModel14.setWeightGoal(weightGoal5);

        DistanceGoalModel distanceGoal6 = new DistanceGoalModel();
        distanceGoal6.setDistance(1L);
        distanceGoal6.setGoalModel(goalModel14);
        distanceGoal6.setId(1L);

        DistanceGoalModel distanceGoal7 = new DistanceGoalModel();
        distanceGoal7.setDistance(1L);
        distanceGoal7.setGoalModel(new GoalModel());
        distanceGoal7.setId(1L);

        DurationGoalModel durationGoal6 = new DurationGoalModel();
        durationGoal6.setGoalModel(new GoalModel());
        durationGoal6.setId(1L);

        UserModel user6 = new UserModel();
        user6.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user6.setEmail("jane.doe@example.org");
        user6.setFirstName("Jane");
        user6.setGoalModelList(new ArrayList<>());
        user6.setId(1);
        user6.setLastName("Doe");
        user6.setRole(RoleEnum.GUEST);
        user6.setUserImageUrl("https://example.org/example");
        user6.setUsername("janedoe");

        WeightGoalModel weightGoal6 = new WeightGoalModel();
        weightGoal6.setCurrentWeight(3);
        weightGoal6.setGoalModel(new GoalModel());
        weightGoal6.setId(1L);
        weightGoal6.setTargetWeight(3);

        GoalModel goalModel15 = new GoalModel();
        goalModel15.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel15.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel15.setDistanceGoal(distanceGoal7);
        goalModel15.setDurationGoal(durationGoal6);
        goalModel15.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel15.setId(1L);
        goalModel15.setUser(user6);
        goalModel15.setWeightGoal(weightGoal6);

        DurationGoalModel durationGoal7 = new DurationGoalModel();
        durationGoal7.setGoalModel(goalModel15);
        durationGoal7.setId(1L);

        UserModel user7 = new UserModel();
        user7.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user7.setEmail("jane.doe@example.org");
        user7.setFirstName("Jane");
        user7.setGoalModelList(new ArrayList<>());
        user7.setId(1);
        user7.setLastName("Doe");
        user7.setRole(RoleEnum.GUEST);
        user7.setUserImageUrl("https://example.org/example");
        user7.setUsername("janedoe");

        DistanceGoalModel distanceGoal8 = new DistanceGoalModel();
        distanceGoal8.setDistance(1L);
        distanceGoal8.setGoalModel(new GoalModel());
        distanceGoal8.setId(1L);

        DurationGoalModel durationGoal8 = new DurationGoalModel();
        durationGoal8.setGoalModel(new GoalModel());
        durationGoal8.setId(1L);

        UserModel user8 = new UserModel();
        user8.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user8.setEmail("jane.doe@example.org");
        user8.setFirstName("Jane");
        user8.setGoalModelList(new ArrayList<>());
        user8.setId(1);
        user8.setLastName("Doe");
        user8.setRole(RoleEnum.GUEST);
        user8.setUserImageUrl("https://example.org/example");
        user8.setUsername("janedoe");

        WeightGoalModel weightGoal7 = new WeightGoalModel();
        weightGoal7.setCurrentWeight(3);
        weightGoal7.setGoalModel(new GoalModel());
        weightGoal7.setId(1L);
        weightGoal7.setTargetWeight(3);

        GoalModel goalModel16 = new GoalModel();
        goalModel16.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel16.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel16.setDistanceGoal(distanceGoal8);
        goalModel16.setDurationGoal(durationGoal8);
        goalModel16.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel16.setId(1L);
        goalModel16.setUser(user8);
        goalModel16.setWeightGoal(weightGoal7);

        WeightGoalModel weightGoal8 = new WeightGoalModel();
        weightGoal8.setCurrentWeight(3);
        weightGoal8.setGoalModel(goalModel16);
        weightGoal8.setId(1L);
        weightGoal8.setTargetWeight(3);

        GoalModel goalModel17 = new GoalModel();
        goalModel17.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel17.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel17.setDistanceGoal(distanceGoal6);
        goalModel17.setDurationGoal(durationGoal7);
        goalModel17.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel17.setId(1L);
        goalModel17.setUser(user7);
        goalModel17.setWeightGoal(weightGoal8);

        WeightGoalModel weightGoalModel = new WeightGoalModel();
        weightGoalModel.setCurrentWeight(3);
        weightGoalModel.setGoalModel(goalModel17);
        weightGoalModel.setId(1L);
        weightGoalModel.setTargetWeight(3);
        WeightGoalRepository weightGoalRepository = mock(WeightGoalRepository.class);
        when(weightGoalRepository.save(Mockito.<WeightGoalModel>any())).thenReturn(weightGoalModel);
        UserService userService = new UserService(userRepository, goalRepository, mock(DistanceGoalRepository.class),
                mock(DurationGoalRepository.class), weightGoalRepository, passwordEncoder);

        UserController userController = new UserController(userService, new UserDtoMapper(), storageServiceClient);
        ResponseEntity<WeightGoalModel> actualAddWeightGoalToUserResult = userController
                .addWeightGoalToUser(new CreateWeightGoalRequest());
        verify(userRepository).findById(Mockito.<Integer>any());
        verify(goalRepository).save(Mockito.<GoalModel>any());
        verify(weightGoalRepository).save(Mockito.<WeightGoalModel>any());
        assertEquals(201, actualAddWeightGoalToUserResult.getStatusCodeValue());
        assertTrue(actualAddWeightGoalToUserResult.hasBody());
        assertTrue(actualAddWeightGoalToUserResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link UserController#deleteImage(UserDeleteRequest)}
     */
    @Test
    void testDeleteImage() throws Exception {
        FeignException feignException = mock(FeignException.class);
        when(feignException.getCause()).thenReturn(new Throwable());
        when(storageServiceClient.deleteFile(Mockito.<DeleteStorageRequest>any())).thenThrow(feignException);
        FeignException feignException2 = mock(FeignException.class);
        when(feignException2.getCause()).thenReturn(new Throwable());
        when(userService.updateUser(anyInt(), Mockito.<UserModel>any())).thenThrow(feignException2);
        Optional<UserModel> emptyResult = Optional.empty();
        when(userService.getUserById(anyInt())).thenReturn(emptyResult);

        UserDeleteRequest userDeleteRequest = new UserDeleteRequest();
        userDeleteRequest.setFile_uri("File uri");
        userDeleteRequest.setUser_id(1);
        String content = (new ObjectMapper()).writeValueAsString(userDeleteRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/delete-image")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = mockMvc.perform(requestBuilder);
        actualPerformResult.andExpect(status().isNotFound())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(content().string("User with id 1 not found"));
    }
}
