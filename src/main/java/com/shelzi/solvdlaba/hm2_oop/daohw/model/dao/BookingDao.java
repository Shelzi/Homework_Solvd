package com.shelzi.solvdlaba.hm2_oop.daohw.model.dao;

import com.shelzi.solvdlaba.hm2_oop.daohw.exception.DaoException;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingDao {
    Optional<Booking> findBookingById(int id);

    List<Booking> getAllBookings() throws DaoException;
}
