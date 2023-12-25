package com.runapp.profileservice.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CreateDurationGoalRequest.class})
@ExtendWith(SpringExtension.class)
class CreateDurationGoalRequestDiffblueTest {
    @Autowired
    private CreateDurationGoalRequest createDurationGoalRequest;

    /**
     * Method under test: {@link CreateDurationGoalRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(createDurationGoalRequest.canEqual("Other"));
        assertTrue(createDurationGoalRequest.canEqual(createDurationGoalRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateDurationGoalRequest#CreateDurationGoalRequest()}
     *   <li>{@link CreateDurationGoalRequest#setDateStart(LocalDateTime)}
     *   <li>{@link CreateDurationGoalRequest#setDateStop(LocalDateTime)}
     *   <li>{@link CreateDurationGoalRequest#setRunningTime(Duration)}
     *   <li>{@link CreateDurationGoalRequest#setUser_id(Integer)}
     *   <li>{@link CreateDurationGoalRequest#toString()}
     *   <li>{@link CreateDurationGoalRequest#getDateStart()}
     *   <li>{@link CreateDurationGoalRequest#getDateStop()}
     *   <li>{@link CreateDurationGoalRequest#getRunningTime()}
     *   <li>{@link CreateDurationGoalRequest#getUser_id()}
     * </ul>
     */
    @Test
    void testConstructor() {
        CreateDurationGoalRequest actualCreateDurationGoalRequest = new CreateDurationGoalRequest();
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualCreateDurationGoalRequest.setDateStart(dateStart);
        LocalDateTime dateStop = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualCreateDurationGoalRequest.setDateStop(dateStop);
        actualCreateDurationGoalRequest.setRunningTime(null);
        actualCreateDurationGoalRequest.setUser_id(1);
        String actualToStringResult = actualCreateDurationGoalRequest.toString();
        LocalDateTime actualDateStart = actualCreateDurationGoalRequest.getDateStart();
        LocalDateTime actualDateStop = actualCreateDurationGoalRequest.getDateStop();
        actualCreateDurationGoalRequest.getRunningTime();
        assertEquals("CreateDurationGoalRequest(user_id=1, dateStart=1970-01-01T00:00, dateStop=1970-01-01T00:00,"
                + " runningTime=null)", actualToStringResult);
        assertEquals(1, actualCreateDurationGoalRequest.getUser_id().intValue());
        assertSame(dateStart, actualDateStart);
        assertSame(dateStop, actualDateStop);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link CreateDurationGoalRequest#CreateDurationGoalRequest(Integer, LocalDateTime, LocalDateTime, Duration)}
     *   <li>{@link CreateDurationGoalRequest#setDateStart(LocalDateTime)}
     *   <li>{@link CreateDurationGoalRequest#setDateStop(LocalDateTime)}
     *   <li>{@link CreateDurationGoalRequest#setRunningTime(Duration)}
     *   <li>{@link CreateDurationGoalRequest#setUser_id(Integer)}
     *   <li>{@link CreateDurationGoalRequest#toString()}
     *   <li>{@link CreateDurationGoalRequest#getDateStart()}
     *   <li>{@link CreateDurationGoalRequest#getDateStop()}
     *   <li>{@link CreateDurationGoalRequest#getRunningTime()}
     *   <li>{@link CreateDurationGoalRequest#getUser_id()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        CreateDurationGoalRequest actualCreateDurationGoalRequest = new CreateDurationGoalRequest(1, dateStart,
                LocalDate.of(1970, 1, 1).atStartOfDay(), null);
        LocalDateTime dateStart2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualCreateDurationGoalRequest.setDateStart(dateStart2);
        LocalDateTime dateStop = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualCreateDurationGoalRequest.setDateStop(dateStop);
        actualCreateDurationGoalRequest.setRunningTime(null);
        actualCreateDurationGoalRequest.setUser_id(1);
        String actualToStringResult = actualCreateDurationGoalRequest.toString();
        LocalDateTime actualDateStart = actualCreateDurationGoalRequest.getDateStart();
        LocalDateTime actualDateStop = actualCreateDurationGoalRequest.getDateStop();
        actualCreateDurationGoalRequest.getRunningTime();
        assertEquals("CreateDurationGoalRequest(user_id=1, dateStart=1970-01-01T00:00, dateStop=1970-01-01T00:00,"
                + " runningTime=null)", actualToStringResult);
        assertEquals(1, actualCreateDurationGoalRequest.getUser_id().intValue());
        assertSame(dateStart2, actualDateStart);
        assertSame(dateStop, actualDateStop);
    }

    /**
     * Method under test: {@link CreateDurationGoalRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new CreateDurationGoalRequest(), null);
        assertNotEquals(new CreateDurationGoalRequest(), "Different type to CreateDurationGoalRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateDurationGoalRequest#equals(Object)}
     *   <li>{@link CreateDurationGoalRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        CreateDurationGoalRequest createDurationGoalRequest = new CreateDurationGoalRequest();
        assertEquals(createDurationGoalRequest, createDurationGoalRequest);
        int expectedHashCodeResult = createDurationGoalRequest.hashCode();
        assertEquals(expectedHashCodeResult, createDurationGoalRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateDurationGoalRequest#equals(Object)}
     *   <li>{@link CreateDurationGoalRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        CreateDurationGoalRequest createDurationGoalRequest = new CreateDurationGoalRequest();
        CreateDurationGoalRequest createDurationGoalRequest2 = new CreateDurationGoalRequest();
        assertEquals(createDurationGoalRequest, createDurationGoalRequest2);
        int expectedHashCodeResult = createDurationGoalRequest.hashCode();
        assertEquals(expectedHashCodeResult, createDurationGoalRequest2.hashCode());
    }

    /**
     * Method under test: {@link CreateDurationGoalRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        CreateDurationGoalRequest createDurationGoalRequest = new CreateDurationGoalRequest(1, dateStart,
                LocalDate.of(1970, 1, 1).atStartOfDay(), null);
        assertNotEquals(createDurationGoalRequest, new CreateDurationGoalRequest());
    }

    /**
     * Method under test: {@link CreateDurationGoalRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        CreateDurationGoalRequest createDurationGoalRequest = new CreateDurationGoalRequest();
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        assertNotEquals(createDurationGoalRequest,
                new CreateDurationGoalRequest(1, dateStart, LocalDate.of(1970, 1, 1).atStartOfDay(), null));
    }

    /**
     * Method under test: {@link CreateDurationGoalRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        CreateDurationGoalRequest createDurationGoalRequest = new CreateDurationGoalRequest();
        createDurationGoalRequest.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(createDurationGoalRequest, new CreateDurationGoalRequest());
    }

    /**
     * Method under test: {@link CreateDurationGoalRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        CreateDurationGoalRequest createDurationGoalRequest = new CreateDurationGoalRequest();
        createDurationGoalRequest.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(createDurationGoalRequest, new CreateDurationGoalRequest());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateDurationGoalRequest#equals(Object)}
     *   <li>{@link CreateDurationGoalRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals8() {
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        CreateDurationGoalRequest createDurationGoalRequest = new CreateDurationGoalRequest(1, dateStart,
                LocalDate.of(1970, 1, 1).atStartOfDay(), null);
        LocalDateTime dateStart2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        CreateDurationGoalRequest createDurationGoalRequest2 = new CreateDurationGoalRequest(1, dateStart2,
                LocalDate.of(1970, 1, 1).atStartOfDay(), null);

        assertEquals(createDurationGoalRequest, createDurationGoalRequest2);
        int expectedHashCodeResult = createDurationGoalRequest.hashCode();
        assertEquals(expectedHashCodeResult, createDurationGoalRequest2.hashCode());
    }

    /**
     * Method under test: {@link CreateDurationGoalRequest#equals(Object)}
     */
    @Test
    void testEquals9() {
        CreateDurationGoalRequest createDurationGoalRequest = new CreateDurationGoalRequest();

        CreateDurationGoalRequest createDurationGoalRequest2 = new CreateDurationGoalRequest();
        createDurationGoalRequest2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(createDurationGoalRequest, createDurationGoalRequest2);
    }

    /**
     * Method under test: {@link CreateDurationGoalRequest#equals(Object)}
     */
    @Test
    void testEquals10() {
        CreateDurationGoalRequest createDurationGoalRequest = new CreateDurationGoalRequest();

        CreateDurationGoalRequest createDurationGoalRequest2 = new CreateDurationGoalRequest();
        createDurationGoalRequest2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(createDurationGoalRequest, createDurationGoalRequest2);
    }
}
