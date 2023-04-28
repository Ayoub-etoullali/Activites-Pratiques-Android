package com.etoullali.ws.repositories;

import com.etoullali.ws.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    @Override
    Optional<Contact> findById(Long id);
}
