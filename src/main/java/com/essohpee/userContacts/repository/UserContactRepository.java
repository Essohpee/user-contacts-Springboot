package com.essohpee.userContacts.repository;

import com.essohpee.userContacts.model.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserContactRepository extends JpaRepository<UserContact, Integer> {

}
