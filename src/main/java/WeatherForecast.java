public class WeatherForecast {
    String city;
    String localDate;
    String weatherText;
    int temperature;

    public WeatherForecast(String city, String localDate, String weatherText, int temperature) {
        this.city = city;
        this.localDate = localDate;
        this.weatherText = weatherText;
        this.temperature = temperature;
    }

    @Override
    public String toString(){
        return " | "  + city + " - " + localDate + " - " + weatherText + " - " + temperature + "|" ;
    }

}
