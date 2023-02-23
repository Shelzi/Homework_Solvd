package com.shelzi.solvdlaba.hm2_oop;

import com.shelzi.solvdlaba.hm2_oop.daohw.exception.ServiceException;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.Booking;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.Bookings;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.Payment;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.pool.ConnectionPool;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.service.BookingTravel;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.service.impl.BookingTravelImpl;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.service.impl.PaymentService;
import com.shelzi.solvdlaba.hm2_oop.daohw.parser.dom.DomXmlUtil;
import com.shelzi.solvdlaba.hm2_oop.daohw.parser.jaxb.JaxbXmlUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Runner {
    private static final Logger logger = LogManager.getRootLogger();
    private static final BookingTravel service = BookingTravelImpl.getInstance();

    public static void main(String[] args) throws IOException, ServiceException, JAXBException, ParserConfigurationException, SAXException {
        ConnectionPool.getInstance().init();
        PaymentService paymentService = new PaymentService();

        boolean exit = true;
        while (exit) {
            int menu;
            Scanner s = new Scanner(System.in);
            logger.info("""
                     
                    \n 1                    // SHOW ALL
                     2                    // CREATION
                     3                    // SHOW BY ID
                     4                    // UPDATE
                     5                    // DELETE
                     6                    // JDBC EXAMPLE
                     7                    // Marshal XML by JAXB
                     8                    // Unmarshal XML by JAXB
                     9                    // Unmarshal XML by DOM
                     CHOOSE: 
                     """);
            menu = s.nextInt();
            switch (menu) {
                case 1 -> {
                    // SHOW ALL
                    for (Payment p : paymentService.read()) {
                        logger.info(p);
                    }
                }
                case 2 -> {
                    // CREATION
                    int amount = new Random().nextInt(10000, 100000); // что бы быть уверенным
                    Payment newPayment = Payment.builder().time(LocalDateTime.now()).amount(amount).description("Test").build();
                    logger.info(paymentService.create(newPayment));
                }
                case 3 -> {
                    // SHOW BY ID
                    logger.info("id: ");
                    int id = s.nextInt();
                    Payment paymentFromDb = paymentService.read(id);
                    logger.info(paymentFromDb);
                }
                case 4 -> {
                    // UPDATE
                    logger.info("id: ");
                    int id = s.nextInt();
                    logger.info("amount: ");
                    int amount = s.nextInt();
                    Payment updatedPayment = Payment.builder().id(id).time(LocalDateTime.now()).amount(amount).description("UPDATED").build();
                    logger.info(paymentService.update(updatedPayment));
                }
                case 5 -> {
                    // DELETE
                    logger.info("id: ");
                    int id = s.nextInt();
                    logger.info(paymentService.delete(id));
                }
                case 6 -> {
                    // JDBC EXAMPLE
                    List<Booking> bookingList = new BookingTravelImpl().getAllBookings();
                    for (Booking b : bookingList) {
                        logger.info(b);
                    }
                    int id = s.nextInt();
                    logger.info(new BookingTravelImpl().findBookingById(id));
                }
                case 7 -> {
                    // Marshal XML by JAXB
                    List<Booking> bookingList = new BookingTravelImpl().getAllBookings();
                    JaxbXmlUtil jaxbXmlUtil = new JaxbXmlUtil();
                    jaxbXmlUtil.marshal(new Bookings(bookingList));
                }
                case 8 -> {
                    // Unmarshal XML by JAXB
                    JaxbXmlUtil jaxbXmlUtil = new JaxbXmlUtil();
                    List<Booking> bookingList = jaxbXmlUtil.unmarshall();
                    for (Booking b : bookingList) {
                        logger.info(b);
                    }
                }
                case 9 -> {
                    //Unmarshal XLM by DOM
                    new DomXmlUtil().unmarshal();

                }
                case 0 -> exit = false;
            }
        }
    }
}