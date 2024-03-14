package com.codeOlogy.booktheshow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeOlogy.booktheshow.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    public Optional<Seat> findBySeatNumber(String seatNumber);
}
