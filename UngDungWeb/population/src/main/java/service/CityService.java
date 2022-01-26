package service;

import model.City;

import java.util.ArrayList;

public class CityService {
    private static final ArrayList<City> cities;

    static {
        cities = new ArrayList<>();
        cities.add(new City(1, "Paris", 1000000, 2000000, 80000000, "France"));
        cities.add(new City(2, "Boston", 2000000, 2000000, 80000000, "USA"));
        cities.add(new City(3, "NewYork", 3000000, 2500000, 70000000, "USA"));
    }

    public ArrayList<City> getCityList() {
        return cities;
    }

    public City getCity(int id) {
        for (City city : cities) {
            if (city.getId() == id) {
                return city;
            }
        }
        return null;
    }

    public void createCity(City city) {
        cities.add(city);
    }

    public void deleteCity(City city) {
        cities.remove(city);
    }

    public void editCity(int index, City city) {
        cities.set(index, city);
    }

    public ArrayList<City> sortCityList() {
        cities.sort((o1, o2) -> (int) (o1.getGdp()-o2.getGdp()));
        return cities;
    }

    public ArrayList<City> getCityListByGdp() {
        ArrayList<City> cityArrayList = new ArrayList<>();
        for (City city: cities) {
            if (city.getGdp() >= 20000) {
                cityArrayList.add(city);
            }
        }
        return cityArrayList;
    }

    public ArrayList<City> searchCityByName(String name) {
        ArrayList<City> cityArrayList = new ArrayList<>();
        for (City city: cities) {
            if (city.getName().equals(name)) {
                cityArrayList.add(city);
            }
        }
        return cityArrayList;
    }
}
