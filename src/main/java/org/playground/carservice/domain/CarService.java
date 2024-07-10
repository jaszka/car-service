package org.playground.carservice.domain;

import lombok.RequiredArgsConstructor;
import org.playground.carservice.domain.entity.Car;
import org.playground.carservice.domain.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car save(String manufacturer, String modelName, int productionYear) {
        var car = new Car();
        car.setManufacturer(manufacturer);
        car.setModelName(modelName);
        car.setProductionYear(productionYear);
        return carRepository.save(car);
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
