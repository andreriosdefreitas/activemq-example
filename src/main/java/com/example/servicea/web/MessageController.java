package com.example.servicea.web;

import com.example.servicea.dto.Message;
import com.example.servicea.jms.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private Sender sender;

    @PostMapping("/send")
    public void send(@RequestBody Message message) {
        sender.send(message.getMessage());
    }
}
