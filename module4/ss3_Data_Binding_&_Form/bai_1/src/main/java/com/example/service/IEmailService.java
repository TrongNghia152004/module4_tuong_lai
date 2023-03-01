package com.example.service;

import com.example.model.EmailBox;

public interface IEmailService {
    EmailBox getAllEmailBox();
    void updateEmailBox(EmailBox newEmailBox);
}
