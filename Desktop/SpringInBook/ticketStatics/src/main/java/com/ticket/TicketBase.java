package com.ticket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

/** The type Ticket base. */
public class TicketBase {

    @JsonProperty("ticket")
    private  List<Ticket> ticketList;

  /**
   * Instantiates a new Ticket base.
   *
   * @param ticketList the ticket list
   */
  public TicketBase(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

  /** Instantiates a new Ticket base. */
  public TicketBase() {}

  /**
   * get field @JsonProperty("ticket")
   *
   * @return ticketList @JsonProperty("ticket")
   */
  public List<Ticket> getTicketList() {
        return this.ticketList;
    }

  /**
   * set field @JsonProperty("ticket")
   *
   * @param ticketList @JsonProperty("ticket")
   */
  public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
