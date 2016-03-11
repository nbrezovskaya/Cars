package demo.test.model;

import java.util.List;

public class Car {
    private int year;
    private String make;
    private String model;
    private List<String> transmissions;
    private List<String> engines;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {this.make = make;}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return year == car.year && make.equals(car.make) && model.equals(car.model);

    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + make.hashCode();
        result = 31 * result + model.hashCode();
        return result;
    }

    public void setTransmissions(List<String> transmissions) {
        this.transmissions = transmissions;
    }

    public List<String> getTransmissions() {
        return transmissions;
    }

    public void setEngines(List<String> engines) {
        this.engines = engines;
    }

    public List<String> getEngines() {
        return engines;
    }
}
