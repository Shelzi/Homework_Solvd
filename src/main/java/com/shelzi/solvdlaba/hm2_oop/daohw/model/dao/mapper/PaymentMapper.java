package com.shelzi.solvdlaba.hm2_oop.daohw.model.dao.mapper;

import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.Payment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PaymentMapper {
    @Insert("INSERT INTO payment (amount, time, description) VALUES (#{amount}, #{time}, #{description});")
    boolean insertPayment(Payment payment);

    @Select("SELECT * FROM payment WHERE id=#{id}")
    Payment getPaymentById(@Param("id") int id);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "amount", column = "amount"),
            @Result(property = "time", column = "time"),
            @Result(property = "description", column = "description")
    })
    @Select("SELECT * FROM payment")
    List<Payment> getAllPayments();

    @Update("UPDATE payment SET amount = #{amount}, time = #{time}, description = #{description} WHERE id = #{id}")
    boolean updatePayment(Payment payment);

    @Delete("DELETE FROM payment WHERE id=#{id}")
    boolean deletePaymentById(@Param("id") int id);
}
