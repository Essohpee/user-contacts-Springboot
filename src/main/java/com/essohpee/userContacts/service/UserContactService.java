package com.essohpee.userContacts.service;

import com.essohpee.userContacts.model.UserContact;

import java.util.List;

public interface UserContactService {

    List<UserContact> getUserContacts();

    void saveUserContact(UserContact userContact);

    UserContact getUserContactById(Integer id);

    void updateUserContact(UserContact userContact);

    void deleteUserContactById(Integer id);
}
