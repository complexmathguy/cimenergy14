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
 * Aggregate handler for ConformLoadSchedule as outlined for the CQRS pattern, all write
 * responsibilities related to ConformLoadSchedule are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ConformLoadScheduleAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ConformLoadScheduleAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ConformLoadScheduleAggregate(CreateConformLoadScheduleCommand command) throws Exception {
    LOGGER.info("Handling command CreateConformLoadScheduleCommand");
    CreateConformLoadScheduleEvent event =
        new CreateConformLoadScheduleEvent(command.getConformLoadScheduleId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateConformLoadScheduleCommand command) throws Exception {
    LOGGER.info("handling command UpdateConformLoadScheduleCommand");
    UpdateConformLoadScheduleEvent event =
        new UpdateConformLoadScheduleEvent(
            command.getConformLoadScheduleId(), command.getConformLoadSchedules());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteConformLoadScheduleCommand command) throws Exception {
    LOGGER.info("Handling command DeleteConformLoadScheduleCommand");
    apply(new DeleteConformLoadScheduleEvent(command.getConformLoadScheduleId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignConformLoadSchedulesToConformLoadScheduleCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignConformLoadSchedulesToConformLoadScheduleCommand");

    if (conformLoadSchedules.contains(command.getAddTo()))
      throw new ProcessingException(
          "ConformLoadSchedules already contains an entity with id "
              + command.getAddTo().getConformLoadScheduleId());

    apply(
        new AssignConformLoadSchedulesToConformLoadScheduleEvent(
            command.getConformLoadScheduleId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveConformLoadSchedulesFromConformLoadScheduleCommand command)
      throws Exception {
    LOGGER.info("Handling command RemoveConformLoadSchedulesFromConformLoadScheduleCommand");

    if (!conformLoadSchedules.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "ConformLoadSchedules does not contain an entity with id "
              + command.getRemoveFrom().getConformLoadScheduleId());

    apply(
        new RemoveConformLoadSchedulesFromConformLoadScheduleEvent(
            command.getConformLoadScheduleId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateConformLoadScheduleEvent event) {
    LOGGER.info("Event sourcing CreateConformLoadScheduleEvent");
    this.conformLoadScheduleId = event.getConformLoadScheduleId();
  }

  @EventSourcingHandler
  void on(UpdateConformLoadScheduleEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.conformLoadSchedules = event.getConformLoadSchedules();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignConformLoadSchedulesToConformLoadScheduleEvent event) {
    LOGGER.info("Event sourcing AssignConformLoadSchedulesToConformLoadScheduleEvent");
    this.conformLoadSchedules.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveConformLoadSchedulesFromConformLoadScheduleEvent event) {
    LOGGER.info("Event sourcing RemoveConformLoadSchedulesFromConformLoadScheduleEvent");
    this.conformLoadSchedules.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID conformLoadScheduleId;

  private Set<ConformLoadSchedule> conformLoadSchedules = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(ConformLoadScheduleAggregate.class.getName());
}
