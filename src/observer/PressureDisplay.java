package observer;
import subject.Subject;
import subject.WeatherData;

public class PressureDisplay implements Observer, DisplayInterface{

    private float pressure;
    private WeatherData weatherData;

    public PressureDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display(){
        System.out.println("Current pressure: " + pressure + "hPa");
    }

    @Override
    public void update(){
        this.pressure = weatherData.getPressure();
        display();
        
    }

}