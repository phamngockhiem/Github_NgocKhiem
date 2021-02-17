package com.ngockhiem.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngockhiem.app.entity.RoleEntity;

@Repository
public interface RoleRepository  extends JpaRepository<RoleEntity, Long>{

}
