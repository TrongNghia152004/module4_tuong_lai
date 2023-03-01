package com.example.repository.impl;

import com.example.model.EmailBox;
import com.example.repository.IEmailRepository;

public class EmailRepository implements IEmailRepository {
    public static EmailBox emailBox;
    static {
        emailBox  = new EmailBox("English", "25", false, "Thor, King, Asgard");
    }

    @Override
    public EmailBox getAllEmailBox() {
        return emailBox;
    }

    @Override
    public void updateEmailBox(EmailBox newEmailBox) {
        emailBox.setLanguages(newEmailBox.getLanguages());
        emailBox.setPageSize(newEmailBox.getPageSize());
        emailBox.setSpamsFilter(newEmailBox.isSpamsFilter());
        emailBox.setSignature(newEmailBox.getSignature());
    }
}
