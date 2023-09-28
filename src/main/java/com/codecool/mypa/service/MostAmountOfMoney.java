package com.codecool.mypa.service;

import com.codecool.mypa.model.Ticket;
import com.codecool.mypa.model.Visitor;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class MostAmountOfMoney {
    public Optional<Visitor> mostAmountOfMoney(Set<Ticket> tickets){
        return tickets.stream()
                .collect(Collectors.groupingBy(
                        Ticket::visitor,
                        Collectors.summingDouble(Ticket::price)
                )).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
    }

}
//        Write a method that returns the visitor that paid the most amount of money