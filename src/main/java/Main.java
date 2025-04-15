import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int SPEED_LIMIT = 250;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        List<Car> cars = race.getCars();

        for (int i = 1; i <= 3; i++) {
            System.out.printf("— Введите название машины №:%s\n", i);
            String name = scanner.next();

            System.out.printf("— Введите скорость машины №:%d\n", i);
            String speed = scanner.next();

            while (!isValidSpeed(speed)) {
                System.out.println("— Неправильная скорость");
                System.out.printf("— Введите скорость машины №:%d\n", i);
                speed = scanner.next();
            }

            cars.add(new Car(name, Integer.parseInt(speed)));
        }

        System.out.printf("Самая быстрая машина: %s\n", race.getRaceResults());
    }

    private static boolean isValidSpeed(String speed) {
        try {
            int intSpeed = Integer.parseInt(speed);
            //В формулировке задания встречаются противоречащие требования касательно включения '0' в диапазон :(
            return intSpeed >= 0 && intSpeed <= SPEED_LIMIT;
        } catch (Exception e) {
            return false;
        }
    }
}