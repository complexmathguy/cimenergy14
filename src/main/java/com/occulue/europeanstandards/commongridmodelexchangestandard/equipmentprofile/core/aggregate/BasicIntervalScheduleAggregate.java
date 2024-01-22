package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.aggregate;

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
 * Aggregate handler for BasicIntervalSchedule as outlined for the CQRS pattern, all write
 * responsibilities related to BasicIntervalSchedule are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class BasicIntervalScheduleAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public BasicIntervalScheduleAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public BasicIntervalScheduleAggregate(CreateBasicIntervalScheduleCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateBasicIntervalScheduleCommand");
    CreateBasicIntervalScheduleEvent event =
        new CreateBasicIntervalScheduleEvent(
            command.getBasicIntervalScheduleId(), command.getValue1Unit(), command.getValue2Unit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateBasicIntervalScheduleCommand command) throws Exception {
    LOGGER.info("handling command UpdateBasicIntervalScheduleCommand");
    UpdateBasicIntervalScheduleEvent event =
        new UpdateBasicIntervalScheduleEvent(
            command.getBasicIntervalScheduleId(),
            command.getStartTime(),
            command.getValue1Unit(),
            command.getValue2Unit());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteBasicIntervalScheduleCommand command) throws Exception {
    LOGGER.info("Handling command DeleteBasicIntervalScheduleCommand");
    apply(new DeleteBasicIntervalScheduleEvent(command.getBasicIntervalScheduleId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignStartTimeToBasicIntervalScheduleCommand command) throws Exception {
    LOGGER.info("Handling command AssignStartTimeToBasicIntervalScheduleCommand");

    if (startTime != null && startTime.getDateTimeId() == command.getAssignment().getDateTimeId())
      throw new ProcessingException(
          "StartTime already assigned with id " + command.getAssignment().getDateTimeId());

    apply(
        new AssignStartTimeToBasicIntervalScheduleEvent(
            command.getBasicIntervalScheduleId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignStartTimeFromBasicIntervalScheduleCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignStartTimeFromBasicIntervalScheduleCommand");

    if (startTime == null) throw new ProcessingException("StartTime already has nothing assigned.");

    apply(
        new UnAssignStartTimeFromBasicIntervalScheduleEvent(command.getBasicIntervalScheduleId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateBasicIntervalScheduleEvent event) {
    LOGGER.info("Event sourcing CreateBasicIntervalScheduleEvent");
    this.basicIntervalScheduleId = event.getBasicIntervalScheduleId();
    this.value1Unit = event.getValue1Unit();
    this.value2Unit = event.getValue2Unit();
  }

  @EventSourcingHandler
  void on(UpdateBasicIntervalScheduleEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.startTime = event.getStartTime();
    this.value1Unit = event.getValue1Unit();
    this.value2Unit = event.getValue2Unit();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignStartTimeToBasicIntervalScheduleEvent event) {
    LOGGER.info("Event sourcing AssignStartTimeToBasicIntervalScheduleEvent");
    this.startTime = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignStartTimeFromBasicIntervalScheduleEvent event) {
    LOGGER.info("Event sourcing UnAssignStartTimeFromBasicIntervalScheduleEvent");
    this.startTime = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID basicIntervalScheduleId;

  private UnitSymbol value1Unit;
  private UnitSymbol value2Unit;
  private DateTime startTime = null;

  private static final Logger LOGGER =
      Logger.getLogger(BasicIntervalScheduleAggregate.class.getName());
}
