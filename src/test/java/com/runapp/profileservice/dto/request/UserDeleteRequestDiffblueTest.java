package com.runapp.profileservice.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserDeleteRequest.class})
@ExtendWith(SpringExtension.class)
class UserDeleteRequestDiffblueTest {
    @Autowired
    private UserDeleteRequest userDeleteRequest;

    /**
     * Method under test: {@link UserDeleteRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(userDeleteRequest.canEqual("Other"));
        assertTrue(userDeleteRequest.canEqual(userDeleteRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserDeleteRequest#UserDeleteRequest()}
     *   <li>{@link UserDeleteRequest#setFile_uri(String)}
     *   <li>{@link UserDeleteRequest#setUser_id(int)}
     *   <li>{@link UserDeleteRequest#toString()}
     *   <li>{@link UserDeleteRequest#getFile_uri()}
     *   <li>{@link UserDeleteRequest#getUser_id()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UserDeleteRequest actualUserDeleteRequest = new UserDeleteRequest();
        actualUserDeleteRequest.setFile_uri("File uri");
        actualUserDeleteRequest.setUser_id(1);
        String actualToStringResult = actualUserDeleteRequest.toString();
        String actualFile_uri = actualUserDeleteRequest.getFile_uri();
        assertEquals("File uri", actualFile_uri);
        assertEquals("UserDeleteRequest(file_uri=File uri, user_id=1)", actualToStringResult);
        assertEquals(1, actualUserDeleteRequest.getUser_id());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserDeleteRequest#UserDeleteRequest(String, int)}
     *   <li>{@link UserDeleteRequest#setFile_uri(String)}
     *   <li>{@link UserDeleteRequest#setUser_id(int)}
     *   <li>{@link UserDeleteRequest#toString()}
     *   <li>{@link UserDeleteRequest#getFile_uri()}
     *   <li>{@link UserDeleteRequest#getUser_id()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        UserDeleteRequest actualUserDeleteRequest = new UserDeleteRequest("File uri", 1);
        actualUserDeleteRequest.setFile_uri("File uri");
        actualUserDeleteRequest.setUser_id(1);
        String actualToStringResult = actualUserDeleteRequest.toString();
        String actualFile_uri = actualUserDeleteRequest.getFile_uri();
        assertEquals("File uri", actualFile_uri);
        assertEquals("UserDeleteRequest(file_uri=File uri, user_id=1)", actualToStringResult);
        assertEquals(1, actualUserDeleteRequest.getUser_id());
    }

    /**
     * Method under test: {@link UserDeleteRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new UserDeleteRequest("File uri", 1), null);
        assertNotEquals(new UserDeleteRequest("File uri", 1), "Different type to UserDeleteRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserDeleteRequest#equals(Object)}
     *   <li>{@link UserDeleteRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        UserDeleteRequest userDeleteRequest = new UserDeleteRequest("File uri", 1);
        assertEquals(userDeleteRequest, userDeleteRequest);
        int expectedHashCodeResult = userDeleteRequest.hashCode();
        assertEquals(expectedHashCodeResult, userDeleteRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserDeleteRequest#equals(Object)}
     *   <li>{@link UserDeleteRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        UserDeleteRequest userDeleteRequest = new UserDeleteRequest("File uri", 1);
        UserDeleteRequest userDeleteRequest2 = new UserDeleteRequest("File uri", 1);

        assertEquals(userDeleteRequest, userDeleteRequest2);
        int expectedHashCodeResult = userDeleteRequest.hashCode();
        assertEquals(expectedHashCodeResult, userDeleteRequest2.hashCode());
    }

    /**
     * Method under test: {@link UserDeleteRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        UserDeleteRequest userDeleteRequest = new UserDeleteRequest(null, 1);
        assertNotEquals(userDeleteRequest, new UserDeleteRequest("File uri", 1));
    }

    /**
     * Method under test: {@link UserDeleteRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        UserDeleteRequest userDeleteRequest = new UserDeleteRequest(
                "com.runapp.profileservice.dto.request.UserDeleteRequest", 1);
        assertNotEquals(userDeleteRequest, new UserDeleteRequest("File uri", 1));
    }

    /**
     * Method under test: {@link UserDeleteRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        UserDeleteRequest userDeleteRequest = new UserDeleteRequest("File uri", 2);
        assertNotEquals(userDeleteRequest, new UserDeleteRequest("File uri", 1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserDeleteRequest#equals(Object)}
     *   <li>{@link UserDeleteRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals7() {
        UserDeleteRequest userDeleteRequest = new UserDeleteRequest(null, 1);
        UserDeleteRequest userDeleteRequest2 = new UserDeleteRequest(null, 1);

        assertEquals(userDeleteRequest, userDeleteRequest2);
        int expectedHashCodeResult = userDeleteRequest.hashCode();
        assertEquals(expectedHashCodeResult, userDeleteRequest2.hashCode());
    }
}
