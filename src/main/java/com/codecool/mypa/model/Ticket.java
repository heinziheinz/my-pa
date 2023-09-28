package com.codecool.mypa.model;

import java.time.LocalDateTime;

public record Ticket(int id, double price, Attraction attraction, Visitor visitor, LocalDateTime timestamp) {
}
//    Write a program that manages some of the tedious tasks of an amusement park.
//    Attractions have a unique name, a duration in seconds, and the number of visitors that can experience it at the same time.
//    Visitors have a unique id.
//    Tickets have a price, the attraction they belong to, the visitor that purchased it and a timestamp.
//        Write a method that returns how much time a given visitor spent using attractions in one given day.
//        Write a method that returns the visitor that paid the most amount of money
//        Write a method that returns the top three attractions that have