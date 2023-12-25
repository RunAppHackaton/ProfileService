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

@ContextConfiguration(classes = {CreateDistanceGoalRequest.class})
@ExtendWith(SpringExtension.class)
class CreateDistanceGoalRequestDiffblueTest {
    @Autowired
    private CreateDistanceGoalRequest createDistanceGoalRequest;

    /**
     * Method under test: {@link CreateDistanceGoalRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(createDistanceGoalRequest.canEqual("Other"));
        assertTrue(createDistanceGoalRequest.canEqual(createDistanceGoalRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateDistanceGoalRequest#CreateDistanceGoalRequest()}
     *   <li>{@link CreateDistanceGoalRequest#setDateStart(LocalDateTime)}
     *   <li>{@link CreateDistanceGoalRequest#setDateStop(LocalDateTime)}
     *   <li>{@link CreateDistanceGoalRequest#setDistance_km(Long)}
     *   <li>{@link CreateDistanceGoalRequest#setUser_id(Integer)}
     *   <li>{@link CreateDistanceGoalRequest#toString()}
     *   <li>{@link CreateDistanceGoalRequest#getDateStart()}
     *   <li>{@link CreateDistanceGoalRequest#getDateStop()}
     *   <li>{@link CreateDistanceGoalRequest#getDistance_km()}
     *   <li>{@link CreateDistanceGoalRequest#getUser_id()}
     * </ul>
     */
    @Test
    void testConstructor() {
        CreateDistanceGoalRequest actualCreateDistanceGoalRequest = new CreateDistanceGoalRequest();
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualCreateDistanceGoalRequest.setDateStart(dateStart);
        LocalDateTime dateStop = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualCreateDistanceGoalRequest.setDateStop(dateStop);
        actualCreateDistanceGoalRequest.setDistance_km(1L);
        actualCreateDistanceGoalRequest.setUser_id(1);
        String actualToStringResult = actualCreateDistanceGoalRequest.toString();
        LocalDateTime actualDateStart = actualCreateDistanceGoalRequest.getDateStart();
        LocalDateTime actualDateStop = actualCreateDistanceGoalRequest.getDateStop();
        Long actualDistance_km = actualCreateDistanceGoalRequest.getDistance_km();
        assertEquals("CreateDistanceGoalRequest(user_id=1, dateStart=1970-01-01T00:00, dateStop=1970-01-01T00:00,"
                + " distance_km=1)", actualToStringResult);
        assertEquals(1, actualCreateDistanceGoalRequest.getUser_id().intValue());
        assertEquals(1L, actualDistance_km.longValue());
        assertSame(dateStart, actualDateStart);
        assertSame(dateStop, actualDateStop);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link CreateDistanceGoalRequest#CreateDistanceGoalRequest(Integer, LocalDateTime, LocalDateTime, Long)}
     *   <li>{@link CreateDistanceGoalRequest#setDateStart(LocalDateTime)}
     *   <li>{@link CreateDistanceGoalRequest#setDateStop(LocalDateTime)}
     *   <li>{@link CreateDistanceGoalRequest#setDistance_km(Long)}
     *   <li>{@link CreateDistanceGoalRequest#setUser_id(Integer)}
     *   <li>{@link CreateDistanceGoalRequest#toString()}
     *   <li>{@link CreateDistanceGoalRequest#getDateStart()}
     *   <li>{@link CreateDistanceGoalRequest#getDateStop()}
     *   <li>{@link CreateDistanceGoalRequest#getDistance_km()}
     *   <li>{@link CreateDistanceGoalRequest#getUser_id()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        CreateDistanceGoalRequest actualCreateDistanceGoalRequest = new CreateDistanceGoalRequest(1, dateStart,
                LocalDate.of(1970, 1, 1).atStartOfDay(), 1L);
        LocalDateTime dateStart2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualCreateDistanceGoalRequest.setDateStart(dateStart2);
        LocalDateTime dateStop = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualCreateDistanceGoalRequest.setDateStop(dateStop);
        actualCreateDistanceGoalRequest.setDistance_km(1L);
        actualCreateDistanceGoalRequest.setUser_id(1);
        String actualToStringResult = actualCreateDistanceGoalRequest.toString();
        LocalDateTime actualDateStart = actualCreateDistanceGoalRequest.getDateStart();
        LocalDateTime actualDateStop = actualCreateDistanceGoalRequest.getDateStop();
        Long actualDistance_km = actualCreateDistanceGoalRequest.getDistance_km();
        assertEquals("CreateDistanceGoalRequest(user_id=1, dateStart=1970-01-01T00:00, dateStop=1970-01-01T00:00,"
                + " distance_km=1)", actualToStringResult);
        assertEquals(1, actualCreateDistanceGoalRequest.getUser_id().intValue());
        assertEquals(1L, actualDistance_km.longValue());
        assertSame(dateStart2, actualDateStart);
        assertSame(dateStop, actualDateStop);
    }

    /**
     * Method under test: {@link CreateDistanceGoalRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new CreateDistanceGoalRequest(), null);
        assertNotEquals(new CreateDistanceGoalRequest(), "Different type to CreateDistanceGoalRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateDistanceGoalRequest#equals(Object)}
     *   <li>{@link CreateDistanceGoalRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        CreateDistanceGoalRequest createDistanceGoalRequest = new CreateDistanceGoalRequest();
        assertEquals(createDistanceGoalRequest, createDistanceGoalRequest);
        int expectedHashCodeResult = createDistanceGoalRequest.hashCode();
        assertEquals(expectedHashCodeResult, createDistanceGoalRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateDistanceGoalRequest#equals(Object)}
     *   <li>{@link CreateDistanceGoalRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        CreateDistanceGoalRequest createDistanceGoalRequest = new CreateDistanceGoalRequest();
        CreateDistanceGoalRequest createDistanceGoalRequest2 = new CreateDistanceGoalRequest();
        assertEquals(createDistanceGoalRequest, createDistanceGoalRequest2);
        int expectedHashCodeResult = createDistanceGoalRequest.hashCode();
        assertEquals(expectedHashCodeResult, createDistanceGoalRequest2.hashCode());
    }

    /**
     * Method under test: {@link CreateDistanceGoalRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        CreateDistanceGoalRequest createDistanceGoalRequest = new CreateDistanceGoalRequest(1, dateStart,
                LocalDate.of(1970, 1, 1).atStartOfDay(), 1L);
        assertNotEquals(createDistanceGoalRequest, new CreateDistanceGoalRequest());
    }

    /**
     * Method under test: {@link CreateDistanceGoalRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        CreateDistanceGoalRequest createDistanceGoalRequest = new CreateDistanceGoalRequest();
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        assertNotEquals(createDistanceGoalRequest,
                new CreateDistanceGoalRequest(1, dateStart, LocalDate.of(1970, 1, 1).atStartOfDay(), 1L));
    }

    /**
     * Method under test: {@link CreateDistanceGoalRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        CreateDistanceGoalRequest createDistanceGoalRequest = new CreateDistanceGoalRequest();
        createDistanceGoalRequest.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(createDistanceGoalRequest, new CreateDistanceGoalRequest());
    }

    /**
     * Method under test: {@link CreateDistanceGoalRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        CreateDistanceGoalRequest createDistanceGoalRequest = new CreateDistanceGoalRequest();
        createDistanceGoalRequest.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(createDistanceGoalRequest, new CreateDistanceGoalRequest());
    }

    /**
     * Method under test: {@link CreateDistanceGoalRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        CreateDistanceGoalRequest createDistanceGoalRequest = new CreateDistanceGoalRequest();
        createDistanceGoalRequest.setDistance_km(1L);
        assertNotEquals(createDistanceGoalRequest, new CreateDistanceGoalRequest());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateDistanceGoalRequest#equals(Object)}
     *   <li>{@link CreateDistanceGoalRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        CreateDistanceGoalRequest createDistanceGoalRequest = new CreateDistanceGoalRequest(1, dateStart,
                LocalDate.of(1970, 1, 1).atStartOfDay(), 1L);
        LocalDateTime dateStart2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        CreateDistanceGoalRequest createDistanceGoalRequest2 = new CreateDistanceGoalRequest(1, dateStart2,
                LocalDate.of(1970, 1, 1).atStartOfDay(), 1L);

        assertEquals(createDistanceGoalRequest, createDistanceGoalRequest2);
        int expectedHashCodeResult = createDistanceGoalRequest.hashCode();
        assertEquals(expectedHashCodeResult, createDistanceGoalRequest2.hashCode());
    }

    /**
     * Method under test: {@link CreateDistanceGoalRequest#equals(Object)}
     */
    @Test
    void testEquals10() {
        CreateDistanceGoalRequest createDistanceGoalRequest = new CreateDistanceGoalRequest();

        CreateDistanceGoalRequest createDistanceGoalRequest2 = new CreateDistanceGoalRequest();
        createDistanceGoalRequest2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(createDistanceGoalRequest, createDistanceGoalRequest2);
    }

    /**
     * Method under test: {@link CreateDistanceGoalRequest#equals(Object)}
     */
    @Test
    void testEquals11() {
        CreateDistanceGoalRequest createDistanceGoalRequest = new CreateDistanceGoalRequest();

        CreateDistanceGoalRequest createDistanceGoalRequest2 = new CreateDistanceGoalRequest();
        createDistanceGoalRequest2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(createDistanceGoalRequest, createDistanceGoalRequest2);
    }

    /**
     * Method under test: {@link CreateDistanceGoalRequest#equals(Object)}
     */
    @Test
    void testEquals12() {
        CreateDistanceGoalRequest createDistanceGoalRequest = new CreateDistanceGoalRequest();

        CreateDistanceGoalRequest createDistanceGoalRequest2 = new CreateDistanceGoalRequest();
        createDistanceGoalRequest2.setDistance_km(1L);
        assertNotEquals(createDistanceGoalRequest, createDistanceGoalRequest2);
    }
}
