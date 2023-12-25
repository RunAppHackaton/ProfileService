package com.runapp.profileservice.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserRequest.class})
@ExtendWith(SpringExtension.class)
class UserRequestDiffblueTest {
    @Autowired
    private UserRequest userRequest;

    /**
     * Method under test: {@link UserRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(userRequest.canEqual("Other"));
        assertTrue(userRequest.canEqual(userRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserRequest#UserRequest()}
     *   <li>{@link UserRequest#setCreateDate(LocalDateTime)}
     *   <li>{@link UserRequest#setEmail(String)}
     *   <li>{@link UserRequest#setFirstName(String)}
     *   <li>{@link UserRequest#setLastName(String)}
     *   <li>{@link UserRequest#setUserImageUrl(String)}
     *   <li>{@link UserRequest#setUsername(String)}
     *   <li>{@link UserRequest#toString()}
     *   <li>{@link UserRequest#getCreateDate()}
     *   <li>{@link UserRequest#getEmail()}
     *   <li>{@link UserRequest#getFirstName()}
     *   <li>{@link UserRequest#getLastName()}
     *   <li>{@link UserRequest#getUserImageUrl()}
     *   <li>{@link UserRequest#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UserRequest actualUserRequest = new UserRequest();
        LocalDateTime createDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualUserRequest.setCreateDate(createDate);
        actualUserRequest.setEmail("jane.doe@example.org");
        actualUserRequest.setFirstName("Jane");
        actualUserRequest.setLastName("Doe");
        actualUserRequest.setUserImageUrl("https://example.org/example");
        actualUserRequest.setUsername("janedoe");
        String actualToStringResult = actualUserRequest.toString();
        LocalDateTime actualCreateDate = actualUserRequest.getCreateDate();
        String actualEmail = actualUserRequest.getEmail();
        String actualFirstName = actualUserRequest.getFirstName();
        String actualLastName = actualUserRequest.getLastName();
        String actualUserImageUrl = actualUserRequest.getUserImageUrl();
        assertEquals("Doe", actualLastName);
        assertEquals("Jane", actualFirstName);
        assertEquals("UserRequest(username=janedoe, firstName=Jane, lastName=Doe, email=jane.doe@example.org, createDate"
                + "=1970-01-01T00:00, userImageUrl=https://example.org/example)", actualToStringResult);
        assertEquals("https://example.org/example", actualUserImageUrl);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals("janedoe", actualUserRequest.getUsername());
        assertSame(createDate, actualCreateDate);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link UserRequest#UserRequest(String, String, String, String, LocalDateTime, String)}
     *   <li>{@link UserRequest#setCreateDate(LocalDateTime)}
     *   <li>{@link UserRequest#setEmail(String)}
     *   <li>{@link UserRequest#setFirstName(String)}
     *   <li>{@link UserRequest#setLastName(String)}
     *   <li>{@link UserRequest#setUserImageUrl(String)}
     *   <li>{@link UserRequest#setUsername(String)}
     *   <li>{@link UserRequest#toString()}
     *   <li>{@link UserRequest#getCreateDate()}
     *   <li>{@link UserRequest#getEmail()}
     *   <li>{@link UserRequest#getFirstName()}
     *   <li>{@link UserRequest#getLastName()}
     *   <li>{@link UserRequest#getUserImageUrl()}
     *   <li>{@link UserRequest#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        UserRequest actualUserRequest = new UserRequest("janedoe", "Jane", "Doe", "jane.doe@example.org",
                LocalDate.of(1970, 1, 1).atStartOfDay(), "https://example.org/example");
        LocalDateTime createDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualUserRequest.setCreateDate(createDate);
        actualUserRequest.setEmail("jane.doe@example.org");
        actualUserRequest.setFirstName("Jane");
        actualUserRequest.setLastName("Doe");
        actualUserRequest.setUserImageUrl("https://example.org/example");
        actualUserRequest.setUsername("janedoe");
        String actualToStringResult = actualUserRequest.toString();
        LocalDateTime actualCreateDate = actualUserRequest.getCreateDate();
        String actualEmail = actualUserRequest.getEmail();
        String actualFirstName = actualUserRequest.getFirstName();
        String actualLastName = actualUserRequest.getLastName();
        String actualUserImageUrl = actualUserRequest.getUserImageUrl();
        assertEquals("Doe", actualLastName);
        assertEquals("Jane", actualFirstName);
        assertEquals("UserRequest(username=janedoe, firstName=Jane, lastName=Doe, email=jane.doe@example.org, createDate"
                + "=1970-01-01T00:00, userImageUrl=https://example.org/example)", actualToStringResult);
        assertEquals("https://example.org/example", actualUserImageUrl);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals("janedoe", actualUserRequest.getUsername());
        assertSame(createDate, actualCreateDate);
    }

    /**
     * Method under test: {@link UserRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new UserRequest(), null);
        assertNotEquals(new UserRequest(), "Different type to UserRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserRequest#equals(Object)}
     *   <li>{@link UserRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        UserRequest userRequest = new UserRequest();
        assertEquals(userRequest, userRequest);
        int expectedHashCodeResult = userRequest.hashCode();
        assertEquals(expectedHashCodeResult, userRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserRequest#equals(Object)}
     *   <li>{@link UserRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        UserRequest userRequest = new UserRequest();
        UserRequest userRequest2 = new UserRequest();
        assertEquals(userRequest, userRequest2);
        int expectedHashCodeResult = userRequest.hashCode();
        assertEquals(expectedHashCodeResult, userRequest2.hashCode());
    }

    /**
     * Method under test: {@link UserRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        UserRequest userRequest = new UserRequest("janedoe", "Jane", "Doe", "jane.doe@example.org",
                LocalDate.of(1970, 1, 1).atStartOfDay(), "https://example.org/example");
        assertNotEquals(userRequest, new UserRequest());
    }

    /**
     * Method under test: {@link UserRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        UserRequest userRequest = new UserRequest();
        assertNotEquals(userRequest, new UserRequest("janedoe", "Jane", "Doe", "jane.doe@example.org",
                LocalDate.of(1970, 1, 1).atStartOfDay(), "https://example.org/example"));
    }

    /**
     * Method under test: {@link UserRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("Jane");
        assertNotEquals(userRequest, new UserRequest());
    }

    /**
     * Method under test: {@link UserRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        UserRequest userRequest = new UserRequest();
        userRequest.setLastName("Doe");
        assertNotEquals(userRequest, new UserRequest());
    }

    /**
     * Method under test: {@link UserRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("jane.doe@example.org");
        assertNotEquals(userRequest, new UserRequest());
    }

    /**
     * Method under test: {@link UserRequest#equals(Object)}
     */
    @Test
    void testEquals9() {
        UserRequest userRequest = new UserRequest();
        userRequest.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(userRequest, new UserRequest());
    }

    /**
     * Method under test: {@link UserRequest#equals(Object)}
     */
    @Test
    void testEquals10() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserImageUrl("https://example.org/example");
        assertNotEquals(userRequest, new UserRequest());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserRequest#equals(Object)}
     *   <li>{@link UserRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        UserRequest userRequest = new UserRequest("janedoe", "Jane", "Doe", "jane.doe@example.org",
                LocalDate.of(1970, 1, 1).atStartOfDay(), "https://example.org/example");
        UserRequest userRequest2 = new UserRequest("janedoe", "Jane", "Doe", "jane.doe@example.org",
                LocalDate.of(1970, 1, 1).atStartOfDay(), "https://example.org/example");

        assertEquals(userRequest, userRequest2);
        int expectedHashCodeResult = userRequest.hashCode();
        assertEquals(expectedHashCodeResult, userRequest2.hashCode());
    }

    /**
     * Method under test: {@link UserRequest#equals(Object)}
     */
    @Test
    void testEquals12() {
        UserRequest userRequest = new UserRequest();

        UserRequest userRequest2 = new UserRequest();
        userRequest2.setFirstName("Jane");
        assertNotEquals(userRequest, userRequest2);
    }

    /**
     * Method under test: {@link UserRequest#equals(Object)}
     */
    @Test
    void testEquals13() {
        UserRequest userRequest = new UserRequest();

        UserRequest userRequest2 = new UserRequest();
        userRequest2.setLastName("Doe");
        assertNotEquals(userRequest, userRequest2);
    }

    /**
     * Method under test: {@link UserRequest#equals(Object)}
     */
    @Test
    void testEquals14() {
        UserRequest userRequest = new UserRequest();

        UserRequest userRequest2 = new UserRequest();
        userRequest2.setEmail("jane.doe@example.org");
        assertNotEquals(userRequest, userRequest2);
    }

    /**
     * Method under test: {@link UserRequest#equals(Object)}
     */
    @Test
    void testEquals15() {
        UserRequest userRequest = new UserRequest();

        UserRequest userRequest2 = new UserRequest();
        userRequest2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(userRequest, userRequest2);
    }

    /**
     * Method under test: {@link UserRequest#equals(Object)}
     */
    @Test
    void testEquals16() {
        UserRequest userRequest = new UserRequest();

        UserRequest userRequest2 = new UserRequest();
        userRequest2.setUserImageUrl("https://example.org/example");
        assertNotEquals(userRequest, userRequest2);
    }
}
