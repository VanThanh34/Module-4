package com.codegym.service.impl;

import com.codegym.entity.EmailSettings;
import com.codegym.repository.IEmailRepository;
import com.codegym.service.IEmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {


    private final IEmailRepository emailRepository;

    public EmailService(IEmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public EmailSettings getSettings() {
        return emailRepository.getSettings();
    }

    @Override
    public void update(EmailSettings settings) {
        emailRepository.update(settings);
    }
}
