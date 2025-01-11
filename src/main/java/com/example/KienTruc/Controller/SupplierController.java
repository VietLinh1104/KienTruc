package com.example.KienTruc.Controller;

import com.example.KienTruc.Models.Supplier;
import com.example.KienTruc.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/get-all")
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierService.saveSupplier(supplier);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplierDetails) {
        return supplierService.getSupplierById(id)
                .map(existingSupplier -> {
                    existingSupplier.setName(supplierDetails.getName());
                    existingSupplier.setContactInfo(supplierDetails.getContactInfo());
                    existingSupplier.setAddress(supplierDetails.getAddress());
                    return ResponseEntity.ok(supplierService.saveSupplier(existingSupplier));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
        return supplierService.getSupplierById(id)
                .map(supplier -> {
                    supplierService.deleteSupplier(id);
                    return ResponseEntity.ok("Supplier with ID " + id + " was deleted successfully.");
                })
                .orElseGet(() -> ResponseEntity.status(404).body("Supplier with ID " + id + " not found."));
    }
}
