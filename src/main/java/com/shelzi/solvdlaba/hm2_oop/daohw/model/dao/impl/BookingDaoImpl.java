package com.shelzi.solvdlaba.hm2_oop.daohw.model.dao.impl;

import com.shelzi.solvdlaba.hm2_oop.daohw.exception.ConnectionPoolException;
import com.shelzi.solvdlaba.hm2_oop.daohw.exception.DaoException;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.dao.BookingDao;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.*;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.pool.ConnectionPool;
import com.shelzi.solvdlaba.hm2_oop.daohw.constants.SqlQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookingDaoImpl implements BookingDao {
    private static final Lock locker = new ReentrantLock();
    private static final ConnectionPool pool = ConnectionPool.getInstance();
    private static BookingDao instance;

    public static BookingDao getInstance() {
        if (instance == null) {
            locker.lock();
            if (instance == null) {
                instance = new BookingDaoImpl();
            }
            locker.unlock();
        }
        return instance;
    }

    @Override
    public Optional<Booking> findBookingById(int id) /*throws DaoException*/ {
        Optional<Booking> optionalBooking = Optional.empty();
        return Optional.empty();
/*        try (Connection connection = pool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery.SQL_FIND_BOOKING_BY_ID)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                optionalBooking.add(createBookingFromResultSet(resultSet));
            }

            return (resultSet.next() ? Optional.of(resultSet.getInt(1)) : Optional.empty());
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }*/
    }

    @Override
    public List<Booking> getAllBookings() throws DaoException {
        List<Booking> bookingList = new ArrayList<>();
        try (Connection connection = pool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.SQL_GET_ALL_BOOKINGS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bookingList.add(createBookingFromResultSet(resultSet));
            }
            return bookingList;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }

    }

    public Optional<Integer> findTownIdByName(String name) throws DaoException {
/*        try (Connection connection = pool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(SqlQuery.SQL_FIND_TOWN_ID_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            return (resultSet.next() ? Optional.of(resultSet.getInt(1)) : Optional.empty());
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }*/
        return Optional.empty();
    }

    private Booking createBookingFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("booking.id");
        String description = resultSet.getString("booking.description");
        String title = resultSet.getString("booking.title");
        Hotel hotel = createHotelFromResultSet(resultSet);
        Transportation transportation = createTransportationFromResultSet(resultSet); //TODO
        Payment payment = createPaymentFromResultSet(resultSet); //TODO
        return new Booking(id, description, title, hotel, transportation, payment);
    }

    private Hotel createHotelFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("hotel.id");
        int rating = resultSet.getInt("hotel.rating");
        String address = resultSet.getString("hotel.address");
        String name = resultSet.getString("hotel.name");
        String description = resultSet.getString("hotel.description");
        return new Hotel(id, rating, address, name, description);
    }

    private Payment createPaymentFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("payment.id");
        int amount = resultSet.getInt("payment.amount");
        LocalDateTime time = resultSet.getTimestamp("payment.time").toLocalDateTime();
        String description = resultSet.getString("payment.description");
        return new Payment(id, amount, time, description);
    }

    private Transportation createTransportationFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("transportation.id");
        String description = resultSet.getString("transportation.description");
        TransportType type = TransportType
                .valueOfRoleId(resultSet.getInt("transportation.transport_type_id_fk")).get();
        return new Transportation(id, description, type);
    }
}
