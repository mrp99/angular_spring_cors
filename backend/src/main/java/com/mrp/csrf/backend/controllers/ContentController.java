package com.mrp.csrf.backend.controllers;

import com.mrp.csrf.backend.dtos.ContentDTO;
import com.mrp.csrf.backend.services.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/messages")
    public ResponseEntity<List<ContentDTO>> messages() {
        return  ResponseEntity.ok(contentService.getMessages());
    }

    @PostMapping("/messages")
    public ResponseEntity<ContentDTO> createMessages(@RequestBody ContentDTO dto){
        return  ResponseEntity.ok(contentService.createMessages(dto));
    }
}
