package ru.job4j.serial;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class CarXML {
    public static void main(String[] args) throws JAXBException {
        Car car = new Car(false, 100000L, "toyota",
                new Engine("1zz-fe", 066),
                new String[]{"white", "metalic"}
        );
        System.out.println(car);

        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //сериализацияя/десериализация
        String xml = "";
        try (StringWriter wr = new StringWriter()) {
            marshaller.marshal(car, wr);
            xml = wr.getBuffer().toString();
            System.out.println(xml);
            StringReader rd = new StringReader(xml);
            Car result = (Car) unmarshaller.unmarshal(rd);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
