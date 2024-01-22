package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.aggregate;

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
 * Aggregate handler for MonthDayInterval as outlined for the CQRS pattern, all write
 * responsibilities related to MonthDayInterval are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class MonthDayIntervalAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public MonthDayIntervalAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public MonthDayIntervalAggregate(CreateMonthDayIntervalCommand command) throws Exception {
    LOGGER.info("Handling command CreateMonthDayIntervalCommand");
    CreateMonthDayIntervalEvent event =
        new CreateMonthDayIntervalEvent(command.getMonthDayIntervalId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateMonthDayIntervalCommand command) throws Exception {
    LOGGER.info("handling command UpdateMonthDayIntervalCommand");
    UpdateMonthDayIntervalEvent event =
        new UpdateMonthDayIntervalEvent(
            command.getMonthDayIntervalId(), command.getEnd(), command.getStart());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteMonthDayIntervalCommand command) throws Exception {
    LOGGER.info("Handling command DeleteMonthDayIntervalCommand");
    apply(new DeleteMonthDayIntervalEvent(command.getMonthDayIntervalId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEndToMonthDayIntervalCommand command) throws Exception {
    LOGGER.info("Handling command AssignEndToMonthDayIntervalCommand");

    if (end != null && end.getMonthDayId() == command.getAssignment().getMonthDayId())
      throw new ProcessingException(
          "End already assigned with id " + command.getAssignment().getMonthDayId());

    apply(
        new AssignEndToMonthDayIntervalEvent(
            command.getMonthDayIntervalId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEndFromMonthDayIntervalCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEndFromMonthDayIntervalCommand");

    if (end == null) throw new ProcessingException("End already has nothing assigned.");

    apply(new UnAssignEndFromMonthDayIntervalEvent(command.getMonthDayIntervalId()));
  }

  @CommandHandler
  public void handle(AssignStartToMonthDayIntervalCommand command) throws Exception {
    LOGGER.info("Handling command AssignStartToMonthDayIntervalCommand");

    if (start != null && start.getMonthDayId() == command.getAssignment().getMonthDayId())
      throw new ProcessingException(
          "Start already assigned with id " + command.getAssignment().getMonthDayId());

    apply(
        new AssignStartToMonthDayIntervalEvent(
            command.getMonthDayIntervalId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignStartFromMonthDayIntervalCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignStartFromMonthDayIntervalCommand");

    if (start == null) throw new ProcessingException("Start already has nothing assigned.");

    apply(new UnAssignStartFromMonthDayIntervalEvent(command.getMonthDayIntervalId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateMonthDayIntervalEvent event) {
    LOGGER.info("Event sourcing CreateMonthDayIntervalEvent");
    this.monthDayIntervalId = event.getMonthDayIntervalId();
  }

  @EventSourcingHandler
  void on(UpdateMonthDayIntervalEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.end = event.getEnd();
    this.start = event.getStart();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEndToMonthDayIntervalEvent event) {
    LOGGER.info("Event sourcing AssignEndToMonthDayIntervalEvent");
    this.end = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEndFromMonthDayIntervalEvent event) {
    LOGGER.info("Event sourcing UnAssignEndFromMonthDayIntervalEvent");
    this.end = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignStartToMonthDayIntervalEvent event) {
    LOGGER.info("Event sourcing AssignStartToMonthDayIntervalEvent");
    this.start = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignStartFromMonthDayIntervalEvent event) {
    LOGGER.info("Event sourcing UnAssignStartFromMonthDayIntervalEvent");
    this.start = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID monthDayIntervalId;

  private MonthDay end = null;
  private MonthDay start = null;

  private static final Logger LOGGER = Logger.getLogger(MonthDayIntervalAggregate.class.getName());
}
