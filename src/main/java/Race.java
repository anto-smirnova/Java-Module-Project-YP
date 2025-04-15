import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {

    private final List<Car> cars;

    public Race() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getRaceResults() {
        return cars.stream()
                .max(Comparator.comparingInt(c -> c.getSpeed() * 24))
                .map(Car::getName)
                .orElse(null);
    }

    //Альтернативное решение (если стримы считаются читерством)
/*
    public String getRaceResults() {
        Car winner = null;
        int maxDistance = -1;

        for (Car car : cars) {
            int distance = car.getSpeed() * 24;
            if (distance > maxDistance) {
                maxDistance = distance;
                winner = car;
            }
        }

        return winner.getName();
    }
 */
}