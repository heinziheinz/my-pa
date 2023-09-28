package com.codecool.mypa.service;

import com.codecool.mypa.model.Attraction;
import com.codecool.mypa.model.Ticket;
import com.codecool.mypa.model.Visitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SpentAtAttractionTest {

    SpentAtAttraction spentAtAttraction = new SpentAtAttraction();

    public static Stream<Arguments> arguments() {
        Attraction waterfall = new Attraction(1, "Waterfall", 20, 30);
        Visitor visitor = new Visitor(1);

        Ticket ticket = new Ticket(1, 300, waterfall, visitor, LocalDateTime.now());
        Ticket ticketTwo = new Ticket(2, 300, waterfall, visitor, LocalDateTime.now());

        Set<Ticket> tickets = Set.of(ticket,  ticketTwo);
        return Stream.of(
                Arguments.of(Set.of(), 0,visitor ),
                Arguments.of(tickets, 40, visitor)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void howManyTimeSpent(Set<Ticket> ticket, int expected, Visitor visitor) {

        int actual = spentAtAttraction.howManyTimeSpent(ticket, visitor);
        Assertions.assertEquals(expected, actual);
    }
}