package observer;
import subject.Subject;
import subject.WeatherData;

public class ForecastDisplay implements Observer, DisplayInterface {

    private float currentPressure = 1013f;
    private float lastPressure;

    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();
        display();
    }

    @Override
    public void display() {

        System.out.print("Forecast: ");

        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way");
        } 
        else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } 
        else {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}

