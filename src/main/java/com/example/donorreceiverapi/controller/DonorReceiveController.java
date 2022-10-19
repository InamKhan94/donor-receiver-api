package com.example.donorreceiverapi.controller;

import com.example.donorreceiverapi.dto.DonorReceiverDTO;
import com.example.donorreceiverapi.repository.DonorReceiverRepository;
import com.example.donorreceiverapi.service.DonorReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DonorReceiveController {

    @Autowired
    private DonorReceiverService donorReceiverService;

    @Autowired
    private DonorReceiverRepository donorReceiverRepository;

    @PostMapping(value = "/create-donor-receiver")
    //,@RequestParam(value="Prescription", required = false) MultipartFile prescription
   // @ModelAttribute("donorReceiverDTO")
    public String createDonorReceiver(@ModelAttribute("donorReceiverDTO") DonorReceiverDTO donorReceiverDTO) {
        donorReceiverService.createDonorReceiver(donorReceiverDTO);
        return "redirect:/";
    }
    @GetMapping("/")
    public String viewHomePage(Model model) {
      //  model.addAttribute("donorReceiverList", donorReceiverRepository.findAll());
        return "index";
    }

    @GetMapping("/showNewDonorReceiverForm")
    public String showNewDonorForm(Model model) {
        // create model attribute to bind form data
        DonorReceiverDTO donorReceiverDTO = new DonorReceiverDTO();
        model.addAttribute("donorReceiverDTO", donorReceiverDTO);
        return "new_inventory";
    }
}