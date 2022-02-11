package com.essohpee.userContacts.service;

import com.essohpee.userContacts.model.UserContact;
import com.essohpee.userContacts.repository.UserContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserContactServiceImpl implements UserContactService {

    private final UserContactRepository userContactRepository;
    public UserContactServiceImpl(UserContactRepository userContactRepository) {
        this.userContactRepository = userContactRepository;
    }

    @Override
    public List<UserContact> getUserContacts() {
        return userContactRepository.findAll();
    }

    @Override
    public void saveUserContact(UserContact userContact) {
        userContactRepository.save(userContact);
    }

    @Override
    public UserContact getUserContactById(Integer id) {
        return userContactRepository.findById(id).get();
    }

    @Override
    public void updateUserContact(UserContact userContact) {
        userContactRepository.save(userContact);
    }

    @Override
    public void deleteUserContactById(Integer id) {
        userContactRepository.deleteById(id);
    }
}
