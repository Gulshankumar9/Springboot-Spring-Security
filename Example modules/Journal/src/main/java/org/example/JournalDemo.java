package org.example;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.persistence.Query;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Hello world!
 */
public class JournalDemo {

    private static final Logger log = LogManager.getLogger(JournalDemo.class);

    public static void main(String[] args) throws IOException {

        Properties applicationproperties = new Properties();

        FileInputStream file;

        String path = "C:\\Users\\Gulshan\\Desktop\\work\\springsecurity6-main\\springsecurity6-main\\Example modules\\Journal\\src\\main\\resources\\application.properties";

        file = new FileInputStream(path);

        applicationproperties.load(file);

        log.info("application properties file read");

        file.close();

        Session session = null;

        session = getsession(applicationproperties, session);

        session.beginTransaction();

        Transaction transaction = session.getTransaction();

        readoperation(session);

        transaction.commit();
        //writeOperation(session);

        // Close the Session object if it is not null
        if (session != null) {
            session.close();
            log.info("session closed");
        }

    }

    public static void writeOperation(Session session) {

        Student student123 = new Student();
        student123.setId(1);
        student123.setFirstName("abi");
        student123.setLastName("naem");
        student123.setEmail("A@gmail.com");
        session.save(student123);
        session.getTransaction().commit();
    }


    public static void readoperation(Session session) {

        // Use the Session object to perform CRUD operations on the student entity
        // Create a Query object from the Session object and specify the HQL query
        Query query = session.createQuery("from Student");

        // Execute the query and get the result as a List
        List<Student> students = query.getResultList();

        // Print the result using a loop
        for (Student student : students) {
            System.out.println(student);
            log.info(student);
        }
    }


    public static Session getsession(Properties applicationproperties, Session session) {

        try {
            Properties dbconfig = new Properties();
            dbconfig.put(Environment.DRIVER, applicationproperties.getProperty("datasource.driverClassName"));
            dbconfig.put(Environment.URL, applicationproperties.getProperty("datasource.url"));
            dbconfig.put(Environment.USER, applicationproperties.getProperty("datasource.username"));
            dbconfig.put(Environment.PASS, applicationproperties.getProperty("datasource.password"));

            // Create a Configuration object and set the Hibernate properties from the dbconfig object
            Configuration configuration = new Configuration();
            configuration.setProperties(dbconfig);

            // Add the mapping resource or class for the student entity
            configuration.configure();
            //configuration.addClass(Student.class);

            // Build a SessionFactory object from the Configuration object
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            // Open a Session object from the SessionFactory object
            session = sessionFactory.openSession();

            log.info("session opened.");

            return session;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}