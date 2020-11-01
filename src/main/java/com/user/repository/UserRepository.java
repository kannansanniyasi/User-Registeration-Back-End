package com.user.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.entity.UserEntity;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	@Query("from UserEntity")
	public List<UserEntity> doGetUserList();

	@Modifying
	@Query("update UserEntity u set u.name=:#{#userEntity.getName()},u.email=:#{#userEntity.getEmail()}"
			+ " ,u.address=:#{#userEntity.getAddress()} where u.id=:#{#userEntity.getId()}  ")
	public void doUpdateUser(@Param("userEntity") UserEntity userEntity);

	@Modifying
	@Query("delete from UserEntity u where u.id=:id")
	public void doDeleteUser(@Param("id") Long id);

}
