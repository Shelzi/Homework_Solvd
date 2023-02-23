package com.shelzi.solvdlaba.hm2_oop.daohw.model.service.impl;

import com.shelzi.solvdlaba.hm2_oop.daohw.model.dao.MyBatisUtil;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.dao.mapper.PaymentMapper;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.Payment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PaymentService {
    private final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
    private static final Logger logger = LogManager.getRootLogger();

    public PaymentService() {
    }

    public boolean create(Payment payment) {
        boolean res = false;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            try {
                res = mapper.insertPayment(payment);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public Payment read(Integer id) {
        Payment payment;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            payment = mapper.getPaymentById(id);
        }
        return payment;
    }

    public List<Payment> read() {
        List<Payment> payments;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            payments = mapper.getAllPayments();
        }
        return payments;
    }

    public Payment update(Payment payment) {
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            try {
                mapper.updatePayment(payment);
                session.commit();
            } catch (Exception e) {
                logger.warn(e);
                session.rollback();
            }
        }
        return payment;
    }

    public boolean delete(Integer id) {
        boolean res = false;
        try (SqlSession session = SESSION_FACTORY.openSession()) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            try {
                res = mapper.deletePaymentById(id);
                session.commit();
            } catch (Exception e) {
                session.rollback();
            }
        }
        return res;
    }

    public boolean delete(Payment id) {
        return delete((int)id.getId());
    }
}
