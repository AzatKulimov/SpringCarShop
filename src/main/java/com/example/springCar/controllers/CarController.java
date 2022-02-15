package com.example.springCar.controllers;

import com.example.springCar.models.Car;
import com.example.springCar.models.Country;
import com.example.springCar.models.DBManager;
import com.example.springCar.services.CarService;
import com.example.springCar.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private CountryService countryService;
    @GetMapping("/")
    public String getIndex(Model model){
        List<Car> cars= carService.getAllCars();
        model.addAttribute("car",cars );
        model.addAttribute("title", "Home");
        return "index";
    }

    @GetMapping("/add")
    public String getCarPage(Model model){
        model.addAttribute("title", "AddCar");
        List<Country>countries=countryService.countryList();
        model.addAttribute("countries", countries );
        return "addCar";
    }

    @PostMapping("/addCar")
    public String addCarPage(Model model, @RequestParam(name="car_mark")String mark,
    @RequestParam(name="car_model")String modelka, @RequestParam(name="car_price")int price,
    @RequestParam(name="country_id")int country_id ){
        Country country=countryService.getCountry(country_id);
        Car car=new Car(null, mark, modelka, price, country);
        carService.addCar(car);
        return "redirect:/";
    }

    ///edit/1
    @GetMapping("/edit/{idCar}")
    public String getEditPhonePage(
            @PathVariable(name="idCar") Integer id, Model model
    ){
        Car c = carService.getCar(id);
        List<Country>countries=countryService.countryList();
        model.addAttribute("countries", countries );
        model.addAttribute("car", c);
        model.addAttribute("title", "Edit Car #" + id);
        return "edit";
    }

    @PostMapping(value = "/editCar/{idCar}")
    public String edit(@PathVariable(name="idCar") int id,@RequestParam(name="car_mark")String mark,
                       @RequestParam(name="car_model")String modelka,
                       @RequestParam(name="car_price")int price, @RequestParam(name="country_id") Integer country_id
                       ){
        Car car=carService.getCar(id);
        if(car!=null)
            { Country country=countryService.getCountry(country_id);
            if(country!=null) {
                car.setMark(mark);
                car.setModel(modelka);
                car.setPrice(price);
                car.setCountry(country);
            }
                carService.editCar(car);
            }
        return "redirect:/";
    }
    @PostMapping(value="/delete/{idCar}")
    public String deleteCar( @PathVariable(name="idCar") int id ) {
        Car car=carService.getCar(id);
        if(car!=null) {
            carService.deleteCar(car);
        }
        return "redirect:/";
    }



}
