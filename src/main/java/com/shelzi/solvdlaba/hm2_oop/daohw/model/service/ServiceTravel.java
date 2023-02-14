package com.shelzi.solvdlaba.hm2_oop.daohw.model.service;

import com.shelzi.solvdlaba.hm2_oop.daohw.exception.ServiceException;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.Booking;

import java.util.List;

public interface ServiceTravel {
    List<Booking> getAllBookings() throws ServiceException;
}
