package com.codegym.repository.impl;

import com.codegym.entity.EmailSettings;
import com.codegym.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepository implements IEmailRepository {

    private EmailSettings settings = new EmailSettings("English", 25, true, "King, Asgard");

    @Override
    public EmailSettings getSettings() {
        return settings;
    }

    @Override
    public void update(EmailSettings settings) {
        this.settings = settings;
    }
}
