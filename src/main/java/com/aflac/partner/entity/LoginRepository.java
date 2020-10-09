package com.aflac.partner.entity;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author AshokKumarAvvaru
 *
 */
@Transactional
@Repository
public interface LoginRepository extends CrudRepository<LoginEntity, String> {
	@Query("select lgoin from LoginEntity lgoin where lgoin.userName=:userName")
	LoginEntity findByName(@Param("userName") String userName);

}
