package com.etoullali.ws.web;

import com.etoullali.ws.entities.Contact;
import com.etoullali.ws.repositories.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ContactController {
    private ContactRepository contactRepository;

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        System.out.println("getContacts");
        return contactRepository.findAll();
    }

    @GetMapping("/contacts/{id}")
    Optional<Contact> getContact(@PathVariable Long id) {
        System.out.println("getContact(" + id + ")");
        return contactRepository.findById(id);
    }

    @PostMapping("/contact")
    Contact addContact(@RequestBody Contact newContact) {
        System.out.println("addContact");
        return contactRepository.save(newContact);
    }

    @PutMapping("/contacts/{id}")
    Contact updateContact(@RequestBody Contact newContact, @PathVariable Long id) {
        return contactRepository.findById(id).map(
                        contact -> {
                            contact.setPrenom(newContact.getPrenom());
                            contact.setTele(newContact.getTele());
                            contact.setNom(newContact.getNom());
                            contact.setEmail(newContact.getEmail());
                            contact.setSim(newContact.getSim());
                            System.out.println("updateContact(" + id + ")");
                            return contactRepository.save(contact);
                        })
                .orElseGet(() -> {
                    newContact.setId(id);
                    System.out.println("addContact(" + id + ")");
                    return contactRepository.save(newContact);
                });
    }

    @DeleteMapping("/deleteContacts/{id}")
    void deleteContact(@PathVariable Long id) {
        System.out.println("deleteContact(" + id + ")");
        contactRepository.deleteById(id);
    }

}
