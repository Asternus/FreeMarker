package com.example.demo;

import com.example.demo.entity.Device;
import com.example.demo.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    DeviceService deviceService;

    @GetMapping("/welcome/{id}")
    public String adminAddUser(Model model, @PathVariable int id) {

        final Device deviceById = deviceService.getDeviceById(id);

        model.addAttribute("device", deviceById);

        return "hello";
    }

    @GetMapping("/allDevices")
    public String adminAddUser(Model model) {
        final List<Device> devices = deviceService.getDevices();

        model.addAttribute("devices", devices);

        return "hello1";
    }

}
