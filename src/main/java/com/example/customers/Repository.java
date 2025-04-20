package com.example.customers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    private static final String FILE_PATH = "customers.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    // ✔ JSON dosyasından müşteri listesini oku
    private List<Customer> loadCustomers() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, new TypeReference<List<Customer>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // ✔ Listeyi JSON dosyasına kaydet
    private void saveCustomers(List<Customer> customers) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), customers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✔ Tüm müşterileri getir
    public List<Customer> findAll() {
        return loadCustomers();
    }

    // ✔ ID'ye göre müşteri bul
    public Customer findById(int id) {
        return loadCustomers().stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // ✔ Yeni müşteri kaydet (otomatik ID verilir)
    public void save(Customer customer) {
        List<Customer> customers = loadCustomers();
        customer.setId(generateId(customers));
        customers.add(customer);
        saveCustomers(customers);
    }

    // ✔ Mevcut müşteriyi güncelle
    public void update(Customer customer) {
        List<Customer> customers = loadCustomers();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == customer.getId()) {
                customers.set(i, customer);
                saveCustomers(customers);
                return;
            }
        }
    }

    // ✔ Müşteriyi sil
    public void deleteById(int id) {
        List<Customer> customers = loadCustomers();
        customers.removeIf(c -> c.getId() == id);
        saveCustomers(customers);
    }

    // ✔ Yeni ID üret (otomatik)
    private int generateId(List<Customer> customers) {
        return customers.stream()
                .mapToInt(Customer::getId)
                .max()
                .orElse(0) + 1;
    }

}
