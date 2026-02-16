package observer;
import subject.Subject;
import subject.WeatherData;

public class StatisticsDisplay implements Observer, DisplayInterface {

    private float maxTemp = Float.MIN_VALUE;
    private float minTemp = Float.MAX_VALUE;
    private float tempSum = 0.0f;
    private int numReadings = 0;

    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        float temp = weatherData.getTemperature();

        tempSum += temp;
        numReadings++;

        if (temp > maxTemp) {
            maxTemp = temp;
        }

        if (temp < minTemp) {
            minTemp = temp;
        }

        display();
    }

    @Override
    public void display() {
        float avg = tempSum / numReadings;

        System.out.println(
            "Avg/Min/Max temperature = " +
            avg + "/" + minTemp + "/" + maxTemp
        );
    }
}
