package com.ticket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/** The type Run app. */
public class RunApp {

    private final List<Ticket> tickets;

  /**
   * Instantiates a new Run app.
   *
   * @param base the base
   */
  public RunApp(TicketBase base) {
        this(base.getTicketList());
    }

  /**
   * Instantiates a new Run app.
   *
   * @param tickets the tickets
   */
  public RunApp(List<Ticket> tickets) {
        this.tickets = tickets;
    }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws IOException the io exception
   */
  public static void main(String[] args) throws IOException {
    String departure = "Владивосток";
    String arrive = "Тель-Авив";
    int percentile = 90;

    if (args.length >= 2) {
      departure = args[0];
      arrive = args[1];

      if (args.length == 3) {
        int p = Integer.parseInt(args[2]);
        if (p > 0 && p <= 100) {
          percentile = p;
        }
      }
    } else if (args.length == 1) {
      int p = Integer.parseInt(args[0]);
      if (p > 0 && p <= 100) {
        percentile = p;
      }
    }

    System.out.println(
        String.format(
            "Вылет с : %s, Прилет в : %s, процентиль : %d" + System.lineSeparator(),
            departure,
            arrive,
            percentile));

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    TicketBase base = mapper.readValue(new File("/Users/user/Desktop/SpringInBook/ticketStatics/src/main/resources/ticket.json"), TicketBase.class);

    RunApp app = new RunApp(base);
    long deltaMinuts = app.getDeltaFlightTime(departure, arrive).toMinutes();

    System.out.printf(
            "Cреднее время полета между городами %s и %s : %dh %dm\n",
            departure, arrive, deltaMinuts/60, deltaMinuts%60);

    long percentilTime = app.percentilFlightTime(percentile, departure, arrive).toMinutes();

    System.out.printf(
        "90-й процентиль времени полета между городами %s и %s : %dh %dm",
            departure, arrive, percentilTime / 60, percentilTime % 60);
}
  /**
   * Percentil flight time duration.
   *
   * @param percentil the percentil
   * @param departure the departure
   * @param arrive the arrive
   * @return the duration
   */
  public Duration percentilFlightTime(int percentil, String departure, String arrive) {

        List<Ticket> timeOfTicket = tickets.stream()
                                           .filter(ticket -> ticket.getDepartureFrom().equals(departure))
                                           .filter(ticket -> ticket.getArriveTo().equals(arrive))
                                           .distinct()
                                           .sorted((t1, t2) ->
                                                   (int) (flightTime(t1).toMinutes() - flightTime(t2).toMinutes()))
                                           .collect(Collectors.toList());
        double perk =(double) percentil/100 * timeOfTicket.size();
        int ind =(int) Math.ceil(perk) -1;
        return flightTime(timeOfTicket.get(ind));
    }

  /**
   * Gets delta flight time.
   *
   * @param departure the departure
   * @param arrive the arrive
   * @return the delta flight time
   */
  public Duration getDeltaFlightTime(String departure, String arrive) {
        Duration deltaTime = Duration.ZERO;
        int m=0;
        for (Ticket ticket : tickets) {
            if (ticket.getDepartureFrom().equals(departure) && ticket.getArriveTo().equals(arrive)) {
                deltaTime = deltaTime.plus(flightTime(ticket));
                m++;
            }
        }
        return deltaTime.dividedBy(m);
    }

  /**
   * Flight time duration.
   *
   * @param ticket the ticket
   * @return the duration
   */
  public Duration flightTime(Ticket ticket) {
    LocalDateTime timeDeparture = LocalDateTime.of(ticket.getDateDeparture(), ticket.getTimeDeparture());
    LocalDateTime timeArrive = LocalDateTime.of(ticket.getDateArrive(), ticket.getTimeArrive());
    return Duration.between(timeDeparture, timeArrive);
  }
 }
