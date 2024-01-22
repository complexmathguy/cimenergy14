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
 * Aggregate handler for NonConformLoadSchedule as outlined for the CQRS pattern, all write
 * responsibilities related to NonConformLoadSchedule are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class NonConformLoadScheduleAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public NonConformLoadScheduleAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public NonConformLoadScheduleAggregate(CreateNonConformLoadScheduleCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateNonConformLoadScheduleCommand");
    CreateNonConformLoadScheduleEvent event =
        new CreateNonConformLoadScheduleEvent(command.getNonConformLoadScheduleId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateNonConformLoadScheduleCommand command) throws Exception {
    LOGGER.info("handling command UpdateNonConformLoadScheduleCommand");
    UpdateNonConformLoadScheduleEvent event =
        new UpdateNonConformLoadScheduleEvent(
            command.getNonConformLoadScheduleId(), command.getNonConformLoadSchedules());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteNonConformLoadScheduleCommand command) throws Exception {
    LOGGER.info("Handling command DeleteNonConformLoadScheduleCommand");
    apply(new DeleteNonConformLoadScheduleEvent(command.getNonConformLoadScheduleId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignNonConformLoadSchedulesToNonConformLoadScheduleCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignNonConformLoadSchedulesToNonConformLoadScheduleCommand");

    if (nonConformLoadSchedules.contains(command.getAddTo()))
      throw new ProcessingException(
          "NonConformLoadSchedules already contains an entity with id "
              + command.getAddTo().getNonConformLoadScheduleId());

    apply(
        new AssignNonConformLoadSchedulesToNonConformLoadScheduleEvent(
            command.getNonConformLoadScheduleId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveNonConformLoadSchedulesFromNonConformLoadScheduleCommand command)
      throws Exception {
    LOGGER.info("Handling command RemoveNonConformLoadSchedulesFromNonConformLoadScheduleCommand");

    if (!nonConformLoadSchedules.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "NonConformLoadSchedules does not contain an entity with id "
              + command.getRemoveFrom().getNonConformLoadScheduleId());

    apply(
        new RemoveNonConformLoadSchedulesFromNonConformLoadScheduleEvent(
            command.getNonConformLoadScheduleId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateNonConformLoadScheduleEvent event) {
    LOGGER.info("Event sourcing CreateNonConformLoadScheduleEvent");
    this.nonConformLoadScheduleId = event.getNonConformLoadScheduleId();
  }

  @EventSourcingHandler
  void on(UpdateNonConformLoadScheduleEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.nonConformLoadSchedules = event.getNonConformLoadSchedules();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignNonConformLoadSchedulesToNonConformLoadScheduleEvent event) {
    LOGGER.info("Event sourcing AssignNonConformLoadSchedulesToNonConformLoadScheduleEvent");
    this.nonConformLoadSchedules.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveNonConformLoadSchedulesFromNonConformLoadScheduleEvent event) {
    LOGGER.info("Event sourcing RemoveNonConformLoadSchedulesFromNonConformLoadScheduleEvent");
    this.nonConformLoadSchedules.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID nonConformLoadScheduleId;

  private Set<NonConformLoadSchedule> nonConformLoadSchedules = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(NonConformLoadScheduleAggregate.class.getName());
}
