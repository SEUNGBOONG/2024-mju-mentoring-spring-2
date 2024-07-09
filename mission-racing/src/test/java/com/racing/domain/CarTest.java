package com.racing.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void 자동차_4이상일때_이동_테스트() {

        //given
        Car car = new Car("poby");

        //when
        car.move(4);

        //then
        assertEquals(1, car.getMoveCount());
    }

    @Test
    void 자동차_4이하일때_이동하지않는_테스트() {

        //given
        Car car = new Car("poby");

        //when
        car.move(3);

        //then
        assertNotEquals(1, car.getMoveCount());

    }

    @Test
    void isSameCount_테스트() {

        //given
        Car car = new Car("testCar");

        //when
        car.move(4);

        //then
        assertTrue(car.isSameCount(1));

    }
}