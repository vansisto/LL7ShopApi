package com.vansisto.ll7shopapi.controller;

import com.vansisto.ll7shopapi.aws.DynamoClient;
import com.vansisto.ll7shopapi.dto.DynamoRecordDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/dynamo")
public class DynamoController {
    private final DynamoClient dynamoClient;

    @PostMapping
    public void storeMessage(@RequestBody String message) {
        dynamoClient.storeMessage(message);
    }

    @GetMapping("/{uuid}")
    public DynamoRecordDTO getById(@PathVariable UUID uuid) {
        return dynamoClient.getById(uuid);
    }
}
