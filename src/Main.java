import subject.*;
import observer.*;

public class Main {
    public static void main(String[] args) {
        
        // create Subject
        WeatherData weatherData = new WeatherData();

        // create observers (register in constructor)
        CurrentConditionsDisplay conditions = 
        new CurrentConditionsDisplay(weatherData);

        StatisticsDisplay stats =
        new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(28, 65, 1010);
        weatherData.setMeasurements(38, 85, 1030);

        

    }
}
