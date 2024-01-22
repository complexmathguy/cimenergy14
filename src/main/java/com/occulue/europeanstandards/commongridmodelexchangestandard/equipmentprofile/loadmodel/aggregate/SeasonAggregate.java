package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * Aggregate handler for Season as outlined for the CQRS pattern, all write responsibilities related
 * to Season are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SeasonAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SeasonAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SeasonAggregate(CreateSeasonCommand command) throws Exception {
    LOGGER.info("Handling command CreateSeasonCommand");
    CreateSeasonEvent event = new CreateSeasonEvent(command.getSeasonId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSeasonCommand command) throws Exception {
    LOGGER.info("handling command UpdateSeasonCommand");
    UpdateSeasonEvent event =
        new UpdateSeasonEvent(command.getSeasonId(), command.getEndDate(), command.getStartDate());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSeasonCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSeasonCommand");
    apply(new DeleteSeasonEvent(command.getSeasonId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEndDateToSeasonCommand command) throws Exception {
    LOGGER.info("Handling command AssignEndDateToSeasonCommand");

    if (endDate != null && endDate.getMonthDayId() == command.getAssignment().getMonthDayId())
      throw new ProcessingException(
          "EndDate already assigned with id " + command.getAssignment().getMonthDayId());

    apply(new AssignEndDateToSeasonEvent(command.getSeasonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEndDateFromSeasonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEndDateFromSeasonCommand");

    if (endDate == null) throw new ProcessingException("EndDate already has nothing assigned.");

    apply(new UnAssignEndDateFromSeasonEvent(command.getSeasonId()));
  }

  @CommandHandler
  public void handle(AssignStartDateToSeasonCommand command) throws Exception {
    LOGGER.info("Handling command AssignStartDateToSeasonCommand");

    if (startDate != null && startDate.getMonthDayId() == command.getAssignment().getMonthDayId())
      throw new ProcessingException(
          "StartDate already assigned with id " + command.getAssignment().getMonthDayId());

    apply(new AssignStartDateToSeasonEvent(command.getSeasonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignStartDateFromSeasonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignStartDateFromSeasonCommand");

    if (startDate == null) throw new ProcessingException("StartDate already has nothing assigned.");

    apply(new UnAssignStartDateFromSeasonEvent(command.getSeasonId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSeasonEvent event) {
    LOGGER.info("Event sourcing CreateSeasonEvent");
    this.seasonId = event.getSeasonId();
  }

  @EventSourcingHandler
  void on(UpdateSeasonEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.endDate = event.getEndDate();
    this.startDate = event.getStartDate();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEndDateToSeasonEvent event) {
    LOGGER.info("Event sourcing AssignEndDateToSeasonEvent");
    this.endDate = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEndDateFromSeasonEvent event) {
    LOGGER.info("Event sourcing UnAssignEndDateFromSeasonEvent");
    this.endDate = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignStartDateToSeasonEvent event) {
    LOGGER.info("Event sourcing AssignStartDateToSeasonEvent");
    this.startDate = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignStartDateFromSeasonEvent event) {
    LOGGER.info("Event sourcing UnAssignStartDateFromSeasonEvent");
    this.startDate = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID seasonId;

  private MonthDay endDate = null;
  private MonthDay startDate = null;

  private static final Logger LOGGER = Logger.getLogger(SeasonAggregate.class.getName());
}
