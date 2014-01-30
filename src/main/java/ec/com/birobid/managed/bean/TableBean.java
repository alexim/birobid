package ec.com.birobid.managed.bean;

import java.io.Serializable;  
import java.util.List;  
import java.util.UUID;  

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ec.com.birobid.web.Car;  
import ec.com.birobid.web.LazyCarDataModel;
import ec.com.birobid.web.LazyDataModel;  

@ManagedBean(name="tableBean")
@RequestScoped
public class TableBean implements Serializable{  
      
    /**
	 * 
	 */
	private static final long serialVersionUID = -6857693382529749591L;

	private LazyDataModel<Car> lazyModel;  
  
    private Car selectedCar;  
  
    private List<Car> cars;  
  
    private final static String [] colors;
    private final static String [] manufacturers;
    
    static {  
        colors = new String[10];  
        colors[0] = "Black";  
        colors[1] = "White";  
        colors[2] = "Green";  
        colors[3] = "Red";  
        colors[4] = "Blue";  
        colors[5] = "Orange";  
        colors[6] = "Silver";  
        colors[7] = "Yellow";  
        colors[8] = "Brown";  
        colors[9] = "Maroon";  
          
        manufacturers = new String[10];  
        manufacturers[0] = "Mercedes";  
        manufacturers[1] = "BMW";  
        manufacturers[2] = "Volvo";  
        manufacturers[3] = "Audi";  
        manufacturers[4] = "Renault";  
        manufacturers[5] = "Opel";  
        manufacturers[6] = "Volkswagen";  
        manufacturers[7] = "Chrysler";  
        manufacturers[8] = "Ferrari";  
        manufacturers[9] = "Ford";  
    }  
  
    public TableBean() {  
        populateRandomCars(cars, 50);  
        lazyModel = new LazyCarDataModel(cars);  
    }  
  
    public Car getSelectedCar() {  
        return selectedCar;  
    }  
  
    public void setSelectedCar(Car selectedCar) {  
        this.selectedCar = selectedCar;  
    }  
      
    public LazyDataModel<Car> getLazyModel() {  
        return lazyModel;  
    }  
  
    private void populateRandomCars(List<Car> list, int size) {  
        for(int i = 0 ; i < size ; i++) {  
            list.add(new Car(getRandomModel(), getRandomYear(), getRandomManufacturer(), getRandomColor()));  
        }  
    }  
  
    private String getRandomColor() {  
        return colors[(int) (Math.random() * 10)];  
    }  
  
    private String getRandomManufacturer() {  
        return manufacturers[(int) (Math.random() * 10)];  
    }  
  
    private int getRandomYear() {  
        return (int) (Math.random() * 50 + 1960);  
    }  
    
    private String getRandomModel() {
        return UUID.randomUUID().toString().substring(0, 8);
}
}  