package com.shelzi.solvdlaba.hm2_oop;

import com.shelzi.solvdlaba.hm2_oop.daohw.exception.ServiceException;

import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.Booking;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.pool.ConnectionPool;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.service.ServiceTravel;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.service.impl.ServiceTravelImpl;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.util.*;

public class Runner {
    private static final Logger logger = LogManager.getRootLogger();
    private static final ServiceTravel service = ServiceTravelImpl.getInstance();

    static {
        ConnectionPool.getInstance().init();
    }

    public static void main(String[] args) throws IOException, ServiceException {

        boolean exit = true;
        while (exit) {
            int menu;
            Scanner s = new Scanner(System.in);
            menu = s.nextInt();
            switch (menu) {
                case 1: {
                    for (Booking b: service.getAllBookings()) {
                        System.out.println(b);
                    }
                }
                case 0: {
                    exit = false;
                    break;
                }
            }
        }
    }
}