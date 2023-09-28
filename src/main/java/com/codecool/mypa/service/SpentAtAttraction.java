package com.codecool.mypa.service;

import com.codecool.mypa.model.Ticket;
import com.codecool.mypa.model.Visitor;

import java.util.Set;

public class SpentAtAttraction {


    public int howManyTimeSpent(Set<Ticket> tickets, Visitor visitor){

        return tickets.stream()
                .filter(ticket -> ticket.visitor().equals(visitor))
                .mapToInt(ticket -> ticket.attraction().duration()).sum();
    }
}
//        Write a method that returns how much time a given visitor spent using attractions in one given day.
