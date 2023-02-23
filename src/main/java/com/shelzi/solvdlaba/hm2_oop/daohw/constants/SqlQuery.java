package com.shelzi.solvdlaba.hm2_oop.daohw.constants;

public class SqlQuery {

    private SqlQuery() {
    }

    public static final String SQL_FIND_BOOKING_BY_ID =  """
            SELECT * FROM booking
            JOIN payment ON booking.payment_id_fk = payment.id
            JOIN hotel ON booking.hotel_id_fk = hotel.id
            JOIN transportation ON booking.transportation_id_fk = transportation.id
            JOIN transport_type ON transportation.transport_type_id_fk = transport_type.id
            WHERE booking.id = ?;
            """;

    public static final String SQL_GET_ALL_BOOKINGS = """
            SELECT * FROM booking
            JOIN customer ON booking.customer_id_fk = customer.id
            JOIN user ON customer.user_id_fk = user.id
            JOIN user_role ON user.user_role_id_fk = user_role.id
            JOIN payment ON booking.payment_id_fk = payment.id
            JOIN hotel ON booking.hotel_id_fk = hotel.id
            JOIN transportation ON booking.transportation_id_fk = transportation.id
            JOIN transport_type ON transportation.transport_type_id_fk = transport_type.id;
            """;

}
