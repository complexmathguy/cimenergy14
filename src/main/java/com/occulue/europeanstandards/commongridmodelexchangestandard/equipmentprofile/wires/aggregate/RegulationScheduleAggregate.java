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
 * Aggregate handler for RegulationSchedule as outlined for the CQRS pattern, all write
 * responsibilities related to RegulationSchedule are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class RegulationScheduleAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public RegulationScheduleAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public RegulationScheduleAggregate(CreateRegulationScheduleCommand command) throws Exception {
    LOGGER.info("Handling command CreateRegulationScheduleCommand");
    CreateRegulationScheduleEvent event =
        new CreateRegulationScheduleEvent(command.getRegulationScheduleId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateRegulationScheduleCommand command) throws Exception {
    LOGGER.info("handling command UpdateRegulationScheduleCommand");
    UpdateRegulationScheduleEvent event =
        new UpdateRegulationScheduleEvent(
            command.getRegulationScheduleId(), command.getRegulationSchedule());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteRegulationScheduleCommand command) throws Exception {
    LOGGER.info("Handling command DeleteRegulationScheduleCommand");
    apply(new DeleteRegulationScheduleEvent(command.getRegulationScheduleId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignRegulationScheduleToRegulationScheduleCommand command) throws Exception {
    LOGGER.info("Handling command AssignRegulationScheduleToRegulationScheduleCommand");

    if (regulationSchedule.contains(command.getAddTo()))
      throw new ProcessingException(
          "RegulationSchedule already contains an entity with id "
              + command.getAddTo().getRegulationScheduleId());

    apply(
        new AssignRegulationScheduleToRegulationScheduleEvent(
            command.getRegulationScheduleId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveRegulationScheduleFromRegulationScheduleCommand command)
      throws Exception {
    LOGGER.info("Handling command RemoveRegulationScheduleFromRegulationScheduleCommand");

    if (!regulationSchedule.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "RegulationSchedule does not contain an entity with id "
              + command.getRemoveFrom().getRegulationScheduleId());

    apply(
        new RemoveRegulationScheduleFromRegulationScheduleEvent(
            command.getRegulationScheduleId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateRegulationScheduleEvent event) {
    LOGGER.info("Event sourcing CreateRegulationScheduleEvent");
    this.regulationScheduleId = event.getRegulationScheduleId();
  }

  @EventSourcingHandler
  void on(UpdateRegulationScheduleEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.regulationSchedule = event.getRegulationSchedule();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignRegulationScheduleToRegulationScheduleEvent event) {
    LOGGER.info("Event sourcing AssignRegulationScheduleToRegulationScheduleEvent");
    this.regulationSchedule.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveRegulationScheduleFromRegulationScheduleEvent event) {
    LOGGER.info("Event sourcing RemoveRegulationScheduleFromRegulationScheduleEvent");
    this.regulationSchedule.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID regulationScheduleId;

  private Set<RegulationSchedule> regulationSchedule = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(RegulationScheduleAggregate.class.getName());
}
