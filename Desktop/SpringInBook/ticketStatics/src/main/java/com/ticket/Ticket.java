package com.ticket;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import javafx.util.converter.LocalDateTimeStringConverter;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/** The type Ticket. */
@JsonIgnoreProperties("ticket")
@JsonDeserialize(as = Ticket.class)
public class Ticket {
    @JsonProperty("id")
    private int id;

    @JsonProperty("arrive")
    private String arriveTo;

    @JsonProperty("departure")
    private String departureFrom;

    @JsonProperty("arrive_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy")
    private LocalDate dateArrive;

    @JsonProperty("arrive_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "H:mm")
    private LocalTime timeArrive;

    @JsonProperty("departure_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy")
    private LocalDate dateDeparture;

    @JsonProperty("departure_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "H:mm")
    private LocalTime timeDeparture;

  /** Instantiates a new Ticket. */
  public Ticket() {}

  /**
   * Instantiates a new Ticket.
   *
   * @param id the id
   * @param arriveTo the arrive to
   * @param departureFrom the departure from
   * @param dateArrive the date arrive
   * @param timeArrive the time arrive
   * @param dateDeparture the date departure
   * @param timeDeparture the time departure
   */
  public Ticket(
      int id,
      String arriveTo,
      String departureFrom,
      LocalDate dateArrive,
      LocalTime timeArrive,
      LocalDate dateDeparture,
      LocalTime timeDeparture) {
        this.id = id;
        this.arriveTo = arriveTo;
        this.departureFrom = departureFrom;
        this.dateArrive = dateArrive;
        this.timeArrive = timeArrive;
        this.dateDeparture = dateDeparture;
        this.timeDeparture = timeDeparture;
    }

  /**
   * get field @JsonProperty("id")
   *
   * @return id @JsonProperty("id")
   */
  public int getId() {
        return this.id;
    }

  /**
   * set field @JsonProperty("id")
   *
   * @param id @JsonProperty("id")
   */
  public void setId(int id) {
        this.id = id;
    }

  /**
   * get field @JsonProperty("arrive")
   *
   * @return arriveTo @JsonProperty("arrive")
   */
  public String getArriveTo() {
        return this.arriveTo;
    }

  /**
   * set field @JsonProperty("arrive")
   *
   * @param arriveTo @JsonProperty("arrive")
   */
  public void setArriveTo(String arriveTo) {
        this.arriveTo = arriveTo;
    }

  /**
   * get field @JsonProperty("departure")
   *
   * @return departureFrom @JsonProperty("departure")
   */
  public String getDepartureFrom() {
        return this.departureFrom;
    }

  /**
   * set field @JsonProperty("departure")
   *
   * @param departureFrom @JsonProperty("departure")
   */
  public void setDepartureFrom(String departureFrom) {
        this.departureFrom = departureFrom;
    }

  /**
   * get field @JsonProperty("arrive_date") @JsonFormat(shape = JsonFormat.Shape.STRING pattern =
   * "dd-MM-yyyy")
   *
   * @return dateArrive @JsonProperty("arrive_date") @JsonFormat(shape = JsonFormat.Shape.STRING
   *     pattern = "dd-MM-yyyy")
   */
  public LocalDate getDateArrive() {
        return this.dateArrive;
    }

  /**
   * set field @JsonProperty("arrive_date") @JsonFormat(shape = JsonFormat.Shape.STRING pattern =
   * "dd-MM-yyyy")
   *
   * @param dateArrive @JsonProperty("arrive_date") @JsonFormat(shape = JsonFormat.Shape.STRING
   *     pattern = "dd-MM-yyyy")
   */
  public void setDateArrive(LocalDate dateArrive) {
        this.dateArrive = dateArrive;
    }

  /**
   * get field @JsonProperty("departure_date") @JsonFormat(shape = JsonFormat.Shape.STRING pattern =
   * "dd-MM-yyyy")
   *
   * @return dateDeparture @JsonProperty("departure_date") @JsonFormat(shape =
   *     JsonFormat.Shape.STRING pattern = "dd-MM-yyyy")
   */
  public LocalDate getDateDeparture() {
        return this.dateDeparture;
    }

  /**
   * set field @JsonProperty("departure_date") @JsonFormat(shape = JsonFormat.Shape.STRING pattern =
   * "dd-MM-yyyy")
   *
   * @param dateDeparture @JsonProperty("departure_date") @JsonFormat(shape =
   *     JsonFormat.Shape.STRING pattern = "dd-MM-yyyy")
   */
  public void setDateDeparture(LocalDate dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

  /**
   * get field @JsonProperty("arrive_time") @JsonFormat(shape = JsonFormat.Shape.STRING pattern =
   * "H:mm")
   *
   * @return timeArrive @JsonProperty("arrive_time") @JsonFormat(shape = JsonFormat.Shape.STRING
   *     pattern = "H:mm")
   */
  public LocalTime getTimeArrive() {
        return this.timeArrive;
    }

  /**
   * set field @JsonProperty("arrive_time") @JsonFormat(shape = JsonFormat.Shape.STRING pattern =
   * "H:mm")
   *
   * @param timeArrive @JsonProperty("arrive_time") @JsonFormat(shape = JsonFormat.Shape.STRING
   *     pattern = "H:mm")
   */
  public void setTimeArrive(LocalTime timeArrive) {
        this.timeArrive = timeArrive;
    }

  /**
   * get field @JsonProperty("departure_time") @JsonFormat(shape = JsonFormat.Shape.STRING pattern =
   * "H:mm")
   *
   * @return timeDeparture @JsonProperty("departure_time") @JsonFormat(shape =
   *     JsonFormat.Shape.STRING pattern = "H:mm")
   */
  public LocalTime getTimeDeparture() {
        return this.timeDeparture;
    }

  /**
   * set field @JsonProperty("departure_time") @JsonFormat(shape = JsonFormat.Shape.STRING pattern =
   * "H:mm")
   *
   * @param timeDeparture @JsonProperty("departure_time") @JsonFormat(shape =
   *     JsonFormat.Shape.STRING pattern = "H:mm")
   */
  public void setTimeDeparture(LocalTime timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    @Override
    public String toString () {
        return "Ticket{" +
                "id=" + id +
                ", arriveTo='" + arriveTo + '\'' +
                ", departureFrom='" + departureFrom + '\'' +
                ", dateArrive=" + dateArrive +
                ", dateDeparture=" + dateDeparture +
                ", timeArrive=" + timeArrive +
                ", timeDeparture=" + timeDeparture +
                '}';
    }
}
