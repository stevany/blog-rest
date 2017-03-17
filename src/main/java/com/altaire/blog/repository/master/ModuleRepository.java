package com.altaire.blog.repository.master;

import com.altaire.blog.model.master.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by cue on 3/16/2017.
 */
public interface ModuleRepository extends JpaRepository<Module,Long> {
    @Query("select m from Module m where name like :name% ")
    List<Module> findByNameLike(@Param("name")String name);
}
