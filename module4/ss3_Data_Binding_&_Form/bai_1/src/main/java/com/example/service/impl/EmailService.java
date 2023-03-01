package com.example.service.impl;

import com.example.model.EmailBox;
import com.example.repository.IEmailRepository;
import com.example.repository.impl.EmailRepository;
import com.example.service.IEmailService;

public class EmailService implements IEmailService {
    IEmailRepository iEmailRepository = new EmailRepository();

    @Override
    public EmailBox getAllEmailBox() {
        return iEmailRepository.getAllEmailBox();
    }

    @Override
    public void updateEmailBox(EmailBox newEmailBox) {
        iEmailRepository.updateEmailBox(newEmailBox);
    }
}
