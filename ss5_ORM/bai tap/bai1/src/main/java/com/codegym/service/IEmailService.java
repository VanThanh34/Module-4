package com.codegym.service;

import com.codegym.entity.EmailSettings;

public interface IEmailService {
    EmailSettings getSettings();
    void update(EmailSettings settings);
}
