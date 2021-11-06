import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        System.out.println("Введите название города на английском языке");
        Scanner scanner = new Scanner(System.in);
        String cityName = scanner.nextLine();
        String cityCode = WeatherResponse.detectCity(cityName);
        System.out.println(WeatherResponse.detectWheather(cityCode));

        WeatherForecast weatherForecast1 = new WeatherForecast("Moscow", "6 октября", "Облачно", 5);
        WeatherForecast weatherForecast2 = new WeatherForecast("Moscow", "7 октября", "Небольшие осадки", 15);
        WeatherForecast weatherForecast3 = new WeatherForecast("Moscow", "8 октября", "Снегопад", 2);
        WeatherForecast weatherForecast4 = new WeatherForecast("Moscow", "9 октября", "снег с дождём", 1);

        DbHandler dbHandler = new DbHandler();

        dbHandler.addWeather(weatherForecast1);
        dbHandler.addWeather(weatherForecast2);
        dbHandler.addWeather(weatherForecast3);
        dbHandler.addWeather(weatherForecast4);

        System.out.println(dbHandler.getWeather());
    }

}
