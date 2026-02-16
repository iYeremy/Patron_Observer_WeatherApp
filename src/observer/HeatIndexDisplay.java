package observer;
import observer.Observer;
import observer.DisplayInterface;
import subject.WeatherData;

public class HeatIndexDisplay implements Observer, DisplayInterface{

    private float heatIndex;
    private WeatherData weatherData;

    public HeatIndexDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        float t = weatherData.getTemperature();
        float r = weatherData.getHumidity();

        heatIndex = computeHeatIndex(t, r);
        display();
    }

    private float computeHeatIndex(float T, float R) {

        return (float)(
                -8.78469475556
                + 1.61139411 * T
                + 2.33854883889 * R
                - 0.14611605 * T * R
                - 0.012308094 * T * T
                - 0.0164248277778 * R * R
                + 0.002211732 * T * T * R
                + 0.00072546 * T * R * R
                - 0.000003582 * T * T * R * R
        );
    }

    @Override
    public void display() {
        System.out.println("Heat index is: " + heatIndex);
    }
}
