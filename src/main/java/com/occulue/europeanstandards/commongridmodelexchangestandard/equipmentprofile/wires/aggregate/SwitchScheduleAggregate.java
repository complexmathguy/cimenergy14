package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.aggregate;

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
 * Aggregate handler for SwitchSchedule as outlined for the CQRS pattern, all write responsibilities
 * related to SwitchSchedule are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SwitchScheduleAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SwitchScheduleAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SwitchScheduleAggregate(CreateSwitchScheduleCommand command) throws Exception {
    LOGGER.info("Handling command CreateSwitchScheduleCommand");
    CreateSwitchScheduleEvent event = new CreateSwitchScheduleEvent(command.getSwitchScheduleId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSwitchScheduleCommand command) throws Exception {
    LOGGER.info("handling command UpdateSwitchScheduleCommand");
    UpdateSwitchScheduleEvent event =
        new UpdateSwitchScheduleEvent(command.getSwitchScheduleId(), command.getSwitchSchedules());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSwitchScheduleCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSwitchScheduleCommand");
    apply(new DeleteSwitchScheduleEvent(command.getSwitchScheduleId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignSwitchSchedulesToSwitchScheduleCommand command) throws Exception {
    LOGGER.info("Handling command AssignSwitchSchedulesToSwitchScheduleCommand");

    if (switchSchedules.contains(command.getAddTo()))
      throw new ProcessingException(
          "SwitchSchedules already contains an entity with id "
              + command.getAddTo().getSwitchScheduleId());

    apply(
        new AssignSwitchSchedulesToSwitchScheduleEvent(
            command.getSwitchScheduleId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveSwitchSchedulesFromSwitchScheduleCommand command) throws Exception {
    LOGGER.info("Handling command RemoveSwitchSchedulesFromSwitchScheduleCommand");

    if (!switchSchedules.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "SwitchSchedules does not contain an entity with id "
              + command.getRemoveFrom().getSwitchScheduleId());

    apply(
        new RemoveSwitchSchedulesFromSwitchScheduleEvent(
            command.getSwitchScheduleId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSwitchScheduleEvent event) {
    LOGGER.info("Event sourcing CreateSwitchScheduleEvent");
    this.switchScheduleId = event.getSwitchScheduleId();
  }

  @EventSourcingHandler
  void on(UpdateSwitchScheduleEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.switchSchedules = event.getSwitchSchedules();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignSwitchSchedulesToSwitchScheduleEvent event) {
    LOGGER.info("Event sourcing AssignSwitchSchedulesToSwitchScheduleEvent");
    this.switchSchedules.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveSwitchSchedulesFromSwitchScheduleEvent event) {
    LOGGER.info("Event sourcing RemoveSwitchSchedulesFromSwitchScheduleEvent");
    this.switchSchedules.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID switchScheduleId;

  private Set<SwitchSchedule> switchSchedules = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(SwitchScheduleAggregate.class.getName());
}
