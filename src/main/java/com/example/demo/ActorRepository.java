package com.example.demo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ActorRepository extends JpaRepository <Actor,Long> {

	@Query("select u from Actor u where u.actor_id = ?1")
	List<Actor> myFindById(long actor_id);

	@Query("select u from Actor u where u.first_name= ?1")
	List<Actor> myFindByFirstName(String first_name);

	@Modifying
	@Query(value = "insert into Actor VALUES(:actor_id,:first_name,:last_name,CURRENT_DATE,0)",nativeQuery = true)
	@Transactional
	void mySave(@Param("actor_id") long actor_id, @Param("first_name") String first_name,
			@Param("last_name") String last_nmae);

	@Modifying
	@Query(value = "update Actor set first_name = :first_name,last_name = :last_name where actor_id = :actor_id",nativeQuery = true)
	@Transactional
	void myUpdate(@Param("actor_id") long actor_id, @Param("first_name") String first_name,
			@Param("last_name") String last_nmae);
}
