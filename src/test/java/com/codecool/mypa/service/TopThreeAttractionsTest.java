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
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TopThreeAttractionsTest {
    TopThreeAttractions topThreeAttractions = new TopThreeAttractions();
    public static Stream<Arguments> Parameter() {
        Attraction waterfall = new Attraction(1, "Waterfall", 20, 30);
        Attraction spring = new Attraction(2, "Spring", 20, 30);
        Attraction superStone = new Attraction(3, "Superstone", 20, 30);
        Attraction windingPath = new Attraction(4, "WindingPath", 20, 30);
        Visitor visitor = new Visitor(1);

        Ticket ticket = new Ticket(1, 300, waterfall, visitor, LocalDateTime.now());
        Ticket ticketTwo = new Ticket(2, 300, waterfall, visitor, LocalDateTime.now());
        Ticket ticketThree = new Ticket(3, 300, waterfall, visitor, LocalDateTime.now());
        Ticket ticketFour = new Ticket(4, 300, waterfall, visitor, LocalDateTime.now());
        Ticket ticketFive = new Ticket(5, 300, spring, visitor, LocalDateTime.now());
        Ticket ticketSix = new Ticket(6, 300, spring, visitor, LocalDateTime.now());
        Ticket ticketSeven = new Ticket(7, 300, spring, visitor, LocalDateTime.now());
        Ticket ticketEight = new Ticket(7, 300, superStone, visitor, LocalDateTime.now());
        Ticket ticketNine = new Ticket(7, 300, superStone, visitor, LocalDateTime.now());
        Ticket ticketTen = new Ticket(7, 300, windingPath, visitor, LocalDateTime.now());

        Set<Ticket> tickets = Set.of(
                ticket,  ticketTwo, ticketThree, ticketFour, ticketFive, ticketSix, ticketSeven, ticketEight, ticketNine, ticketTen
        );
        return Stream.of(
                Arguments.of(Set.of(), List.of() ),
                Arguments.of(tickets,List.of(waterfall, spring, superStone))
        );
    }

    @ParameterizedTest
    @MethodSource("Parameter")
    void topThreeAttractions(Set<Ticket> tickets, List<Attraction> expected) {
        List<Attraction> actual = topThreeAttractions.topThreeAttractions(tickets);
        Assertions.assertEquals(expected, actual);
    }
}