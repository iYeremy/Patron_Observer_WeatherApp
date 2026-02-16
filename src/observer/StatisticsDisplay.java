package observer;
import subject.Subject;
import subject.WeatherData;

public class StatisticsDisplay implements Observer, DisplayInterface{

    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display(){
        System.out.println("Current conditions: " +
                temperature + "C, " +
                humidity + "% humidity and " + pressure + "");
    }

    @Override
    public void update(){
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.pressure = weatherData.getPressure();

        display();
        
    }

}