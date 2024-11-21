package com.mrp.csrf.backend.services;

import com.mrp.csrf.backend.dtos.ContentDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentService {

    private final List<ContentDTO> messages = new ArrayList<>();

    public List<ContentDTO> getMessages() {
        return messages;
    }

    public ContentDTO createMessages(ContentDTO dto) {
        messages.add(dto);
        return dto;
    }
}
