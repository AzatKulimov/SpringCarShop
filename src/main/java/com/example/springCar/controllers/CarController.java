package com.example.springCar.controllers;

import com.example.springCar.models.Car;
import com.example.springCar.models.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {
    @GetMapping("/")
    public String getIndex(Model model){
        List<Car>cars= DBManager.getCars();
        model.addAttribute("car", cars);
        return "index";
    }

    @GetMapping("/add")
    public String getCarPage(Model model){
        return "AddCar";
    }

    @PostMapping("/addCar")
    public String addCarPage(Model model, @RequestParam(name="car_mark")String mark,
    @RequestParam(name="car_model")String modelka, @RequestParam(name="car_price")int price){
        DBManager.addCar(new Car(null, mark, modelka, price));
        return "redirect:/";
    }

    ///edit/1
    @GetMapping("/edit/{idCar}")
    public String getEditPhonePage(
            @PathVariable(name="idCar") int id, Model model
    ){
        Car c = DBManager.getTheCar(id);
        model.addAttribute("car", c);
        return "edit";
    }

    @PostMapping(value = "/editCar/{idCar}")
    public String edit(@PathVariable(name="idCar") int id,@RequestParam(name="car_mark")String mark,
                       @RequestParam(name="car_model")String modelka,
                       @RequestParam(name="car_price")int price
                       ){
        DBManager.updateCar(id, mark, modelka, price);
        return "redirect:/";
    }


}
