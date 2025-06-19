package com.example.gestiondettes.controler;
import com.example.gestiondettes.entity.Admin;
import com.example.gestiondettes.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String motDePasse = loginData.get("motDePasse");

        Admin admin = adminRepository.findByEmail(email).orElse(null);
        if (admin != null && admin.getMotDePasse().equals(motDePasse)) {
            return ResponseEntity.ok("Connexion réussie !");
        }
        return ResponseEntity.status(401).body("Identifiants incorrects");
    }
}
