import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Введите название города на английском языке");
        Scanner scanner = new Scanner(System.in);
        String cityName = scanner.nextLine();
        String cityCode = WeatherResponse.detectCity(cityName);
        System.out.println(WeatherResponse.detectWheather(cityCode));

    }

}
