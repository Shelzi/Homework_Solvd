package com.shelzi.solvdlaba.hm2_oop.daohw.model.service.impl;

import com.shelzi.solvdlaba.hm2_oop.daohw.exception.DaoException;
import com.shelzi.solvdlaba.hm2_oop.daohw.exception.ServiceException;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.dao.BookingDao;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.dao.impl.BookingDaoImpl;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.Booking;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.service.BookingTravel;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookingTravelImpl implements BookingTravel {
    private static final BookingDao bookingDao = BookingDaoImpl.getInstance();
    private static final Lock locker = new ReentrantLock();
    private static BookingTravel instance;

    public static BookingTravel getInstance() {
        if (instance == null) {
            locker.lock();
            if (instance == null) {
                instance = new BookingTravelImpl();
            }
            locker.unlock();
        }
        return instance;
    }

    @Override
    public List<Booking> getAllBookings() throws ServiceException {
        try {
            return bookingDao.getAllBookings();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Booking findBookingById(int id) throws ServiceException {
        try {
            return bookingDao.findBookingById(id).orElseThrow();
        } catch (NoSuchElementException | DaoException e) {
            throw new ServiceException(e);
        }
    }


}
