package pl.chrislem.phonebook.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.chrislem.phonebook.models.entities.ContactEntity;
import pl.chrislem.phonebook.models.forms.ContactForm;
import pl.chrislem.phonebook.models.repositories.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    public boolean checkIfContactExists(String surname) {
        return contactRepository.existsBySurname(surname);
    }

    public void addContact(ContactForm contactForm) {
        ContactEntity newContact = new ContactEntity();
        newContact.setName(contactForm.getName());
        newContact.setSurname(contactForm.getSurname());
        newContact.setNumber(contactForm.getPhone());


        contactRepository.save(newContact);
    }

    public Optional<ContactEntity> findOneContact(int id) {
        return contactRepository.findById(id);
    }

    public Optional<ContactEntity> findOneContact(String surname) {
        return contactRepository.findContactBySurname(surname);
    }

    public List<ContactEntity> getContacts() {
        return contactRepository.findAllContacts();
    }
}