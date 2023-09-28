package com.codecool.mypa.service;

import com.codecool.mypa.model.Attraction;
import com.codecool.mypa.model.Ticket;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TopThreeAttractions {

    public List<Attraction> topThreeAttractions(Set<Ticket> ticket){
        return ticket.stream().collect(Collectors.groupingBy(
                Ticket::attraction,
                Collectors.counting()
        )).entrySet().stream()
                .sorted(Map.Entry.<Attraction, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }
 }

//        Write a method that returns the top three attractions that have been visited the most, presented from most to least visited.
