package com.example.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private Repository repository;

    @GetMapping("/")
    public String getAllCustomers(Model model) {
        List<Customer> customers = repository.findAll();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/add")
    public String addCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "addCustomer";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer customer) {
        repository.save(customer);
        return "redirect:/";
    }

    @GetMapping("/details")
    public String detailCustomer(@RequestParam("id") int id, Model model) {
        Customer customer = repository.findById(id);
        model.addAttribute("customer", customer);
        return "detailCustomer";
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam("id") int id, Model model) {
        Customer customer = repository.findById(id);
        model.addAttribute("customer", customer);
        return "updateCustomer";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer) {
        repository.update(customer);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int id) {
        repository.deleteById(id);
        return "redirect:/";
    }

}
