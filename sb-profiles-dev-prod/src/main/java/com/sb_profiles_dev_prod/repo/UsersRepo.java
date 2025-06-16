package com.sb_profiles_dev_prod.repo;

import com.sb_profiles_dev_prod.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
}
