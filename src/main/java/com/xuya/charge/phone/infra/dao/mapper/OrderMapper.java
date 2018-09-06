package com.xuya.charge.phone.infra.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xuya.charge.phone.domain.model.order.Order;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Order(rs.getString("status"), rs.getString("error_message"));
	}

}
