package br.ifsp.library.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEventDTO {
	private Long reservationId;
    private Long bookId;
    private Long userId;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    private String bookTitle;
}
