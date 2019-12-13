package com.grokonez.jwtauthentication.controller;


import com.grokonez.jwtauthentication.model.ActivePassiv;
import com.grokonez.jwtauthentication.model.Role;
import com.grokonez.jwtauthentication.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class RoleController {


    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostMapping(value = "/saveRoleName")
    public ResponseEntity save(@RequestBody Role role) {
        Role list = roleRepository.save(role);
//        if (list.getName()){
//            return ResponseEntity.ok("No ok");
//        }
        return ResponseEntity.ok(list);
    }


    @GetMapping(value = "/RoleName")
    public List<Role> getRoleName() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }




    @DeleteMapping("/deleteRoleById/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id);

       return ResponseEntity.noContent().build();

    }

    @GetMapping(value = "/ActivePassivName")
    public ActivePassiv[] ActiveName() {
        ActivePassiv[] activePassivList = ActivePassiv.values();

        return activePassivList;
    }




}
