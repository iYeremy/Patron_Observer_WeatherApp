import subject.*;
import observer.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Weather Station Simulation ===\n");

        // Create Subject
        WeatherData weatherData = new WeatherData();

        // Create Observers (auto-register in constructor)
        CurrentConditionsDisplay currentDisplay =
                new CurrentConditionsDisplay(weatherData);

        StatisticsDisplay statisticsDisplay =
                new StatisticsDisplay(weatherData);

        ForecastDisplay forecastDisplay =
                new ForecastDisplay(weatherData);

        PressureDisplay pressureDisplay =
                new PressureDisplay(weatherData);

        HeatIndexDisplay heatIndexDisplay =
                new HeatIndexDisplay(weatherData);

        // Simulated measurements
        System.out.println("---- New Measurements ----");
        weatherData.setMeasurements(28f, 65f, 1010f);

        System.out.println("\n---- New Measurements ----");
        weatherData.setMeasurements(38f, 85f, 1030f);

        System.out.println("\n---- End Simulation ----");
    }
}
