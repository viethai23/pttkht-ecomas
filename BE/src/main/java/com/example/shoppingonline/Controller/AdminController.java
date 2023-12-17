package com.example.shoppingonline.Controller;

import com.example.shoppingonline.DAO.AdminDAO.AdminDAO;
import com.example.shoppingonline.Model.User.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminDAO adminDAO;

    @DeleteMapping("/{adminId}")
    public ResponseEntity<String> deleteAdmin(@PathVariable int adminId) {
        if (adminDAO.deleteAdmin(adminId)) {
            return ResponseEntity.ok("Admin deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
        }
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<String> editAdmin(@PathVariable int adminId, @RequestBody Admin updatedAdmin) {
        if (adminDAO.editAdmin(adminId, updatedAdmin)) {
            return ResponseEntity.ok("Admin updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
        }
    }

    @PostMapping
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        Admin newAdmin = adminDAO.addAdmin(admin);
        return ResponseEntity.ok(newAdmin);
    }
}
