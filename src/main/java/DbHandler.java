import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHandler {
    private final String PATH_TO_DB = "jdbc:sqlite:E:\\Java\\Geekbrains\\Java_Core\\HomeWork-7\\src\\main\\resources\\HomeWork-8.db";

    private Connection connection;

    public DbHandler () throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(PATH_TO_DB);
    }

    public void addWeather (WeatherForecast weatherForecast) throws SQLException {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO WeatherForecast ('city', 'localDate', 'weatherText', 'temperature') " +
                        "VALUES (?, ?, ?, ?)"
        )) {
            statement.setObject(1, weatherForecast.city);
            statement.setObject(2, weatherForecast.localDate);
            statement.setObject(3, weatherForecast.weatherText);
            statement.setObject(4, weatherForecast.temperature);
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteWeather (String localDate) throws SQLException {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM WeatherForecast where localDate = ?"
        )) {
            statement.setObject(1, localDate);
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<WeatherForecast> getWeather (){
        List<WeatherForecast> weatherForecasts = new ArrayList<>();
        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT city, localDate, weatherText, temperature FROM WeatherForecast");
            while (resultSet.next()){
                weatherForecasts.add(new WeatherForecast(
                        resultSet.getString("city"),
                        resultSet.getString("localDate"),
                        resultSet.getString("weatherText"),
                        resultSet.getInt("temperature")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weatherForecasts;
    }


}
