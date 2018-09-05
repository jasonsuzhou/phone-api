package com.xuya.charge.phone.infra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.xuya.charge.phone.infra.dao.entity.PhoneBlack;

@Repository
public interface PhoneBlackRepository extends JpaRepository<PhoneBlack, Long>, JpaSpecificationExecutor<PhoneBlack> {
	
}
