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
 * Aggregate handler for RegularIntervalSchedule as outlined for the CQRS pattern, all write
 * responsibilities related to RegularIntervalSchedule are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class RegularIntervalScheduleAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public RegularIntervalScheduleAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public RegularIntervalScheduleAggregate(CreateRegularIntervalScheduleCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateRegularIntervalScheduleCommand");
    CreateRegularIntervalScheduleEvent event =
        new CreateRegularIntervalScheduleEvent(command.getRegularIntervalScheduleId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateRegularIntervalScheduleCommand command) throws Exception {
    LOGGER.info("handling command UpdateRegularIntervalScheduleCommand");
    UpdateRegularIntervalScheduleEvent event =
        new UpdateRegularIntervalScheduleEvent(
            command.getRegularIntervalScheduleId(), command.getEndTime(), command.getTimeStep());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteRegularIntervalScheduleCommand command) throws Exception {
    LOGGER.info("Handling command DeleteRegularIntervalScheduleCommand");
    apply(new DeleteRegularIntervalScheduleEvent(command.getRegularIntervalScheduleId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEndTimeToRegularIntervalScheduleCommand command) throws Exception {
    LOGGER.info("Handling command AssignEndTimeToRegularIntervalScheduleCommand");

    if (endTime != null && endTime.getDateTimeId() == command.getAssignment().getDateTimeId())
      throw new ProcessingException(
          "EndTime already assigned with id " + command.getAssignment().getDateTimeId());

    apply(
        new AssignEndTimeToRegularIntervalScheduleEvent(
            command.getRegularIntervalScheduleId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEndTimeFromRegularIntervalScheduleCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEndTimeFromRegularIntervalScheduleCommand");

    if (endTime == null) throw new ProcessingException("EndTime already has nothing assigned.");

    apply(
        new UnAssignEndTimeFromRegularIntervalScheduleEvent(
            command.getRegularIntervalScheduleId()));
  }

  @CommandHandler
  public void handle(AssignTimeStepToRegularIntervalScheduleCommand command) throws Exception {
    LOGGER.info("Handling command AssignTimeStepToRegularIntervalScheduleCommand");

    if (timeStep != null && timeStep.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "TimeStep already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTimeStepToRegularIntervalScheduleEvent(
            command.getRegularIntervalScheduleId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTimeStepFromRegularIntervalScheduleCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTimeStepFromRegularIntervalScheduleCommand");

    if (timeStep == null) throw new ProcessingException("TimeStep already has nothing assigned.");

    apply(
        new UnAssignTimeStepFromRegularIntervalScheduleEvent(
            command.getRegularIntervalScheduleId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateRegularIntervalScheduleEvent event) {
    LOGGER.info("Event sourcing CreateRegularIntervalScheduleEvent");
    this.regularIntervalScheduleId = event.getRegularIntervalScheduleId();
  }

  @EventSourcingHandler
  void on(UpdateRegularIntervalScheduleEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.endTime = event.getEndTime();
    this.timeStep = event.getTimeStep();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEndTimeToRegularIntervalScheduleEvent event) {
    LOGGER.info("Event sourcing AssignEndTimeToRegularIntervalScheduleEvent");
    this.endTime = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEndTimeFromRegularIntervalScheduleEvent event) {
    LOGGER.info("Event sourcing UnAssignEndTimeFromRegularIntervalScheduleEvent");
    this.endTime = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTimeStepToRegularIntervalScheduleEvent event) {
    LOGGER.info("Event sourcing AssignTimeStepToRegularIntervalScheduleEvent");
    this.timeStep = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTimeStepFromRegularIntervalScheduleEvent event) {
    LOGGER.info("Event sourcing UnAssignTimeStepFromRegularIntervalScheduleEvent");
    this.timeStep = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID regularIntervalScheduleId;

  private DateTime endTime = null;
  private Seconds timeStep = null;

  private static final Logger LOGGER =
      Logger.getLogger(RegularIntervalScheduleAggregate.class.getName());
}
