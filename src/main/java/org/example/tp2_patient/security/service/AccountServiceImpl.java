package org.example.tp2_patient.security.service;

import lombok.AllArgsConstructor;
import org.example.tp2_patient.security.entities.AppRole;
import org.example.tp2_patient.security.entities.AppUser;
import org.example.tp2_patient.security.repo.AppRoleRepository;
import org.example.tp2_patient.security.repo.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;
//    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
//        this.appUserRepository = appUserRepository;
//        this.appRoleRepository = appRoleRepository;
//    }


    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmPassword) {
        AppUser appUser=appUserRepository.findByUsername(username);
        if (appUser!=null) throw  new RuntimeException("this user already exist");
        if (!password.equals(confirmPassword)) throw  new RuntimeException("Passwords not match");

        appUser=AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        AppUser saved= appUserRepository.save(appUser);
        return saved;
    }

    @Override
    public AppRole addNewRole(String role) {
        AppRole appRole=appRoleRepository.findById(role).orElse(null);
        if(appRole!=null) throw new RuntimeException("This role already exist");
        return appRoleRepository.save(AppRole.builder().role(role).build());
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findById(role).get();
        appUser.getRoles().add(appRole);
       // appUserRepository.save(appUser);
    }

    @Override
    public void removeRoleFromUser(String username, String role) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findById(role).get();
        appUser.getRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

}
