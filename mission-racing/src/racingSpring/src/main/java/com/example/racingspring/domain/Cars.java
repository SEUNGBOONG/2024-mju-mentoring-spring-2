package com.example.racingspring.domain;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequestMapping("api/cars")
public class Cars {

    private static final String SPLIT_COMMA = ",";
    private static final int MAX_MOVE_COUNT = 1;

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String names) {
        List<Car> cars = Arrays.stream(names.split(SPLIT_COMMA))
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }
    @RequestMapping("api/cars/racing")
    public void moveCars(int inputCount, final NumberGenerator numberGenerator) {
        for (int i = 0; i < inputCount; i++) {
            for (Car car : cars) {
                car.move(numberGenerator.generateRandom());
            }
        }
    }

    @GetMapping("api/cars")
    public List<String> findsWinner() {
        int maxMoveCount = findWinnerMaxCount();
        return findWinner(maxMoveCount);
    }

    private List<String> findWinner(final int maxMoveCount) {
        return cars.stream()
                .filter(car -> car.isSameCount(maxMoveCount))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findWinnerMaxCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(MAX_MOVE_COUNT);
    }

    public List<String> getCarStates() {
        return cars.stream()
                .map(car -> car.getName() + ": " + "-".repeat(car.getMoveCount()))
                .collect(Collectors.toList());
    }
}
