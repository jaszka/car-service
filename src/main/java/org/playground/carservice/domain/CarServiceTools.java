package org.playground.carservice.domain;

import dev.langchain4j.agent.tool.Tool;
import lombok.RequiredArgsConstructor;
import org.playground.carservice.domain.entity.Car;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CarServiceTools {

    private final CarService carService;

    @Tool("Gets all cars saved in DB")
    public List<Car> getAllCars() {
        System.out.println("Getting all cars from DB...");
        return carService.findAll();
    }

    @Tool("Gets all car manufacturers saved in DB")
    public List<String> getAllManufacturers() {
        System.out.println("Getting car manufacturers from DB...");
        return carService.findAll().stream()
                .map(Car::getManufacturer)
                .distinct()
                .toList();
    }

    @Tool("Saves new car into DB")
    public Car addCar(String manufacturer, String modelName, int productionYear) {
        System.out.println("Saving new car into DB...");
        return carService.save(manufacturer, modelName, productionYear);
    }

    @Tool("Deletes car by its id from DB")
    public void deleteCarById(Long id) {
        System.out.println("Deleting car by its id from DB...");
        carService.deleteById(id);
    }
}