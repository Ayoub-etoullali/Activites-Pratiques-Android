package com.etoullali.ws;

import com.etoullali.ws.entities.Contact;
import com.etoullali.ws.enums.SIM;
import com.etoullali.ws.repositories.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactWS {

    public static void main(String[] args) {
        SpringApplication.run(ContactWS.class, args);
    }
    @Bean
    CommandLineRunner initDatabase(ContactRepository contactRepository) {

        return args -> {

            contactRepository.save(new Contact(
                    1L,
                    "ayoub",
                    "ETOULLALI",
                    "ayoub@gmail.com",
                    "0658712011",
                    SIM.SIM_1
            ));
            contactRepository.save(new Contact(
                    2L,
                    "Elwalid",
                    "",
                    "Elwalid@gmail.com",
                    "0658981457",
                    SIM.SIM_2
            ));
            contactRepository.save(new Contact(
                    3L,
                    "Elwalida",
                    "",
                    "Elwalida@gmail.com",
                    "0658781457",
                    SIM.SIM_2
            ));
            contactRepository.save(new Contact(
                    4L,
                    "radouane",
                    "ETOULLALI",
                    "radouane@gmail.com",
                    "0658931457",
                    SIM.SIM_1
            ));
            contactRepository.save(new Contact(
                    5L,
                    "mustapha",
                    "ETOULLALI",
                    "mustapha@gmail.com",
                    "0657931457",
                    SIM.SIM_1
            ));
            contactRepository.save(new Contact(
                    6L,
                    "radouane",
                    "ETOULLALI",
                    "radouane@gmail.com",
                    "0658931457",
                    SIM.SIM_1
            ));
            contactRepository.save(new Contact(
                    7L,
                    "samira",
                    "ETOULLALI",
                    "samira@gmail.com",
                    "0658131457",
                    SIM.SIM_2
            ));
            contactRepository.save(new Contact(
                    8L,
                    "karima",
                    "ETOULLALI",
                    "karima@gmail.com",
                    "0651931457",
                    SIM.SIM_1
            ));
            contactRepository.save(new Contact(
                    9L,
                    "hayat",
                    "ETOULLALI",
                    "hayat@gmail.com",
                    "0618931457",
                    SIM.SIM_1
            ));

            System.out.println("\n***By Ayoub ETOULLALI ***");
        };

    }

}
