package com.xuya.charge.phone.infra.dao;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xuya.charge.phone.domain.model.order.Order;
import com.xuya.charge.phone.domain.repository.IOrderRepository;
import com.xuya.charge.phone.infra.dao.mapper.OrderMapper;

@Repository
public class OrderRepository implements IOrderRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Order findOrder(String orderId) {
		String sql = "select status, error_message from phone_order where order_id = ?";
		return this.jdbcTemplate.queryForObject(sql, new Object[] { orderId }, new int[] { Types.VARCHAR }, new OrderMapper());
	}

}
