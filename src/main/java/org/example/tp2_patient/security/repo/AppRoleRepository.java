package org.example.tp2_patient.security.repo;

import org.example.tp2_patient.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,String> {


}
