package com.shelzi.solvdlaba.hm2_oop.daohw.parser.jaxb;

import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.Booking;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.Bookings;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JaxbXmlUtil {
    public void marshal(Bookings bookings) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Bookings.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(bookings, new File("./book.xml"));
    }


    public List<Booking> unmarshall() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Bookings.class);
        Bookings bookings = (Bookings) context.createUnmarshaller()
                .unmarshal(new FileReader("./book.xml"));
        return bookings.getBookingList();
    }
}
