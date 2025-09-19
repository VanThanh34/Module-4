package com.codegym.repository;

import com.codegym.entity.EmailSettings;

public interface IEmailRepository {
    EmailSettings getSettings();
    void update(EmailSettings settings);
}
