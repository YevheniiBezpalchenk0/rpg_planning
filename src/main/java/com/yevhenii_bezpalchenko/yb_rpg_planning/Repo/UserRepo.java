package com.yevhenii_bezpalchenko.yb_rpg_planning.Repo;

import com.yevhenii_bezpalchenko.yb_rpg_planning.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}