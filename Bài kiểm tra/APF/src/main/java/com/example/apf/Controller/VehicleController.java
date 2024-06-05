package com.example.apf.Controller;

import ch.qos.logback.core.model.Model;
import com.example.apf.Entity.Vehicle;
import com.example.apf.service.UserService;
import com.example.apf.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public String listVehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "catalog";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicle_form";
    }

    @PostMapping
    public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return "redirect:/admin/vehicles";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("vehicle", vehicleService.getVehicleById(id).orElse(new Vehicle()));
        return "vehicle_form";
    }

    @PostMapping("/update")
    public String updateVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return "redirect:/admin/vehicles";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable("id") Long id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/admin/vehicles";
    }
}


