package com.example.repository;

import com.example.model.EmailBox;

public interface IEmailRepository {
    EmailBox getAllEmailBox();
    void updateEmailBox(EmailBox newEmailBox);
}
