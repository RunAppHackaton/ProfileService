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

@ContextConfiguration(classes = {CreateWeightGoalRequest.class})
@ExtendWith(SpringExtension.class)
class CreateWeightGoalRequestDiffblueTest {
    @Autowired
    private CreateWeightGoalRequest createWeightGoalRequest;

    /**
     * Method under test: {@link CreateWeightGoalRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(createWeightGoalRequest.canEqual("Other"));
        assertTrue(createWeightGoalRequest.canEqual(createWeightGoalRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateWeightGoalRequest#CreateWeightGoalRequest()}
     *   <li>{@link CreateWeightGoalRequest#setCurrentWeight(Integer)}
     *   <li>{@link CreateWeightGoalRequest#setDateStart(LocalDateTime)}
     *   <li>{@link CreateWeightGoalRequest#setDateStop(LocalDateTime)}
     *   <li>{@link CreateWeightGoalRequest#setTargetWeight(Integer)}
     *   <li>{@link CreateWeightGoalRequest#setUser_id(Integer)}
     *   <li>{@link CreateWeightGoalRequest#toString()}
     *   <li>{@link CreateWeightGoalRequest#getCurrentWeight()}
     *   <li>{@link CreateWeightGoalRequest#getDateStart()}
     *   <li>{@link CreateWeightGoalRequest#getDateStop()}
     *   <li>{@link CreateWeightGoalRequest#getTargetWeight()}
     *   <li>{@link CreateWeightGoalRequest#getUser_id()}
     * </ul>
     */
    @Test
    void testConstructor() {
        CreateWeightGoalRequest actualCreateWeightGoalRequest = new CreateWeightGoalRequest();
        actualCreateWeightGoalRequest.setCurrentWeight(3);
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualCreateWeightGoalRequest.setDateStart(dateStart);
        LocalDateTime dateStop = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualCreateWeightGoalRequest.setDateStop(dateStop);
        actualCreateWeightGoalRequest.setTargetWeight(3);
        actualCreateWeightGoalRequest.setUser_id(1);
        String actualToStringResult = actualCreateWeightGoalRequest.toString();
        Integer actualCurrentWeight = actualCreateWeightGoalRequest.getCurrentWeight();
        LocalDateTime actualDateStart = actualCreateWeightGoalRequest.getDateStart();
        LocalDateTime actualDateStop = actualCreateWeightGoalRequest.getDateStop();
        Integer actualTargetWeight = actualCreateWeightGoalRequest.getTargetWeight();
        assertEquals(
                "CreateWeightGoalRequest(user_id=1, dateStart=1970-01-01T00:00, dateStop=1970-01-01T00:00, currentWeight=3,"
                        + " targetWeight=3)",
                actualToStringResult);
        assertEquals(1, actualCreateWeightGoalRequest.getUser_id().intValue());
        assertEquals(3, actualCurrentWeight.intValue());
        assertEquals(3, actualTargetWeight.intValue());
        assertSame(dateStart, actualDateStart);
        assertSame(dateStop, actualDateStop);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link CreateWeightGoalRequest#CreateWeightGoalRequest(Integer, LocalDateTime, LocalDateTime, Integer, Integer)}
     *   <li>{@link CreateWeightGoalRequest#setCurrentWeight(Integer)}
     *   <li>{@link CreateWeightGoalRequest#setDateStart(LocalDateTime)}
     *   <li>{@link CreateWeightGoalRequest#setDateStop(LocalDateTime)}
     *   <li>{@link CreateWeightGoalRequest#setTargetWeight(Integer)}
     *   <li>{@link CreateWeightGoalRequest#setUser_id(Integer)}
     *   <li>{@link CreateWeightGoalRequest#toString()}
     *   <li>{@link CreateWeightGoalRequest#getCurrentWeight()}
     *   <li>{@link CreateWeightGoalRequest#getDateStart()}
     *   <li>{@link CreateWeightGoalRequest#getDateStop()}
     *   <li>{@link CreateWeightGoalRequest#getTargetWeight()}
     *   <li>{@link CreateWeightGoalRequest#getUser_id()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        CreateWeightGoalRequest actualCreateWeightGoalRequest = new CreateWeightGoalRequest(1, dateStart,
                LocalDate.of(1970, 1, 1).atStartOfDay(), 1, 1);
        actualCreateWeightGoalRequest.setCurrentWeight(3);
        LocalDateTime dateStart2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualCreateWeightGoalRequest.setDateStart(dateStart2);
        LocalDateTime dateStop = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualCreateWeightGoalRequest.setDateStop(dateStop);
        actualCreateWeightGoalRequest.setTargetWeight(3);
        actualCreateWeightGoalRequest.setUser_id(1);
        String actualToStringResult = actualCreateWeightGoalRequest.toString();
        Integer actualCurrentWeight = actualCreateWeightGoalRequest.getCurrentWeight();
        LocalDateTime actualDateStart = actualCreateWeightGoalRequest.getDateStart();
        LocalDateTime actualDateStop = actualCreateWeightGoalRequest.getDateStop();
        Integer actualTargetWeight = actualCreateWeightGoalRequest.getTargetWeight();
        assertEquals(
                "CreateWeightGoalRequest(user_id=1, dateStart=1970-01-01T00:00, dateStop=1970-01-01T00:00, currentWeight=3,"
                        + " targetWeight=3)",
                actualToStringResult);
        assertEquals(1, actualCreateWeightGoalRequest.getUser_id().intValue());
        assertEquals(3, actualCurrentWeight.intValue());
        assertEquals(3, actualTargetWeight.intValue());
        assertSame(dateStart2, actualDateStart);
        assertSame(dateStop, actualDateStop);
    }

    /**
     * Method under test: {@link CreateWeightGoalRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new CreateWeightGoalRequest(), null);
        assertNotEquals(new CreateWeightGoalRequest(), "Different type to CreateWeightGoalRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateWeightGoalRequest#equals(Object)}
     *   <li>{@link CreateWeightGoalRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        CreateWeightGoalRequest createWeightGoalRequest = new CreateWeightGoalRequest();
        assertEquals(createWeightGoalRequest, createWeightGoalRequest);
        int expectedHashCodeResult = createWeightGoalRequest.hashCode();
        assertEquals(expectedHashCodeResult, createWeightGoalRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateWeightGoalRequest#equals(Object)}
     *   <li>{@link CreateWeightGoalRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        CreateWeightGoalRequest createWeightGoalRequest = new CreateWeightGoalRequest();
        CreateWeightGoalRequest createWeightGoalRequest2 = new CreateWeightGoalRequest();
        assertEquals(createWeightGoalRequest, createWeightGoalRequest2);
        int expectedHashCodeResult = createWeightGoalRequest.hashCode();
        assertEquals(expectedHashCodeResult, createWeightGoalRequest2.hashCode());
    }

    /**
     * Method under test: {@link CreateWeightGoalRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        CreateWeightGoalRequest createWeightGoalRequest = new CreateWeightGoalRequest(1, dateStart,
                LocalDate.of(1970, 1, 1).atStartOfDay(), 1, 1);
        assertNotEquals(createWeightGoalRequest, new CreateWeightGoalRequest());
    }

    /**
     * Method under test: {@link CreateWeightGoalRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        CreateWeightGoalRequest createWeightGoalRequest = new CreateWeightGoalRequest();
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        assertNotEquals(createWeightGoalRequest,
                new CreateWeightGoalRequest(1, dateStart, LocalDate.of(1970, 1, 1).atStartOfDay(), 1, 1));
    }

    /**
     * Method under test: {@link CreateWeightGoalRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        CreateWeightGoalRequest createWeightGoalRequest = new CreateWeightGoalRequest();
        createWeightGoalRequest.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(createWeightGoalRequest, new CreateWeightGoalRequest());
    }

    /**
     * Method under test: {@link CreateWeightGoalRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        CreateWeightGoalRequest createWeightGoalRequest = new CreateWeightGoalRequest();
        createWeightGoalRequest.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(createWeightGoalRequest, new CreateWeightGoalRequest());
    }

    /**
     * Method under test: {@link CreateWeightGoalRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        CreateWeightGoalRequest createWeightGoalRequest = new CreateWeightGoalRequest();
        createWeightGoalRequest.setCurrentWeight(3);
        assertNotEquals(createWeightGoalRequest, new CreateWeightGoalRequest());
    }

    /**
     * Method under test: {@link CreateWeightGoalRequest#equals(Object)}
     */
    @Test
    void testEquals9() {
        CreateWeightGoalRequest createWeightGoalRequest = new CreateWeightGoalRequest();
        createWeightGoalRequest.setTargetWeight(3);
        assertNotEquals(createWeightGoalRequest, new CreateWeightGoalRequest());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateWeightGoalRequest#equals(Object)}
     *   <li>{@link CreateWeightGoalRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        LocalDateTime dateStart = LocalDate.of(1970, 1, 1).atStartOfDay();
        CreateWeightGoalRequest createWeightGoalRequest = new CreateWeightGoalRequest(1, dateStart,
                LocalDate.of(1970, 1, 1).atStartOfDay(), 1, 1);
        LocalDateTime dateStart2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        CreateWeightGoalRequest createWeightGoalRequest2 = new CreateWeightGoalRequest(1, dateStart2,
                LocalDate.of(1970, 1, 1).atStartOfDay(), 1, 1);

        assertEquals(createWeightGoalRequest, createWeightGoalRequest2);
        int expectedHashCodeResult = createWeightGoalRequest.hashCode();
        assertEquals(expectedHashCodeResult, createWeightGoalRequest2.hashCode());
    }

    /**
     * Method under test: {@link CreateWeightGoalRequest#equals(Object)}
     */
    @Test
    void testEquals11() {
        CreateWeightGoalRequest createWeightGoalRequest = new CreateWeightGoalRequest();

        CreateWeightGoalRequest createWeightGoalRequest2 = new CreateWeightGoalRequest();
        createWeightGoalRequest2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(createWeightGoalRequest, createWeightGoalRequest2);
    }

    /**
     * Method under test: {@link CreateWeightGoalRequest#equals(Object)}
     */
    @Test
    void testEquals12() {
        CreateWeightGoalRequest createWeightGoalRequest = new CreateWeightGoalRequest();

        CreateWeightGoalRequest createWeightGoalRequest2 = new CreateWeightGoalRequest();
        createWeightGoalRequest2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(createWeightGoalRequest, createWeightGoalRequest2);
    }

    /**
     * Method under test: {@link CreateWeightGoalRequest#equals(Object)}
     */
    @Test
    void testEquals13() {
        CreateWeightGoalRequest createWeightGoalRequest = new CreateWeightGoalRequest();

        CreateWeightGoalRequest createWeightGoalRequest2 = new CreateWeightGoalRequest();
        createWeightGoalRequest2.setCurrentWeight(3);
        assertNotEquals(createWeightGoalRequest, createWeightGoalRequest2);
    }

    /**
     * Method under test: {@link CreateWeightGoalRequest#equals(Object)}
     */
    @Test
    void testEquals14() {
        CreateWeightGoalRequest createWeightGoalRequest = new CreateWeightGoalRequest();

        CreateWeightGoalRequest createWeightGoalRequest2 = new CreateWeightGoalRequest();
        createWeightGoalRequest2.setTargetWeight(3);
        assertNotEquals(createWeightGoalRequest, createWeightGoalRequest2);
    }
}
