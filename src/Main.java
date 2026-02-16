import subject.*;
import observer.*;

public class Main {
    public static void main(String[] args) {
        
        // create Subject
        WeatherData weatherData = new WeatherData();

        // create observers (register in constructor)
        StatisticsDisplay display = 
        new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(28, 65, 1010);

    }
}
