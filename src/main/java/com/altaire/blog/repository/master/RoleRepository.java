package com.altaire.blog.repository.master;

import com.altaire.blog.model.master.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("select r from Role r where name like :name% ")
    List<Role> findByNameLike(@Param("name")String name);
}
