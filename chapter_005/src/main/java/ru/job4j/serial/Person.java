package ru.job4j.serial;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlAttribute
    private boolean sex;

    @XmlAttribute
    private int age;

    private Contact1 contact;

    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private String[] statuses;

    public Person() {
    }

    public Person(boolean sex, int age, Contact1 contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                +
                "sex=" + sex
                +
                ", age=" + age
                +
                ", contact=" + contact
                +
                ", statuses=" + Arrays.toString(statuses) + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Person person = new Person(false, 30,
                new Contact1("89233191980"), "Worker", "Married");
        System.out.println(person);

        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //сериализацияя/десериализация
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
            StringReader reader = new StringReader(xml);
            Person result = (Person) unmarshaller.unmarshal(reader);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Car car = new Car(false, 100000L, "toyota",
                new Engine("1zz-fe", 066),
                new String[]{"white", "metalic"}
        );
        System.out.println(car);

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));
        System.out.println(gson.toJson(car));

        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
    }
}
