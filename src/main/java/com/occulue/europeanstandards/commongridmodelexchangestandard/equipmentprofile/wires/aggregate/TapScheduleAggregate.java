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
 * Aggregate handler for TapSchedule as outlined for the CQRS pattern, all write responsibilities
 * related to TapSchedule are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TapScheduleAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TapScheduleAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TapScheduleAggregate(CreateTapScheduleCommand command) throws Exception {
    LOGGER.info("Handling command CreateTapScheduleCommand");
    CreateTapScheduleEvent event = new CreateTapScheduleEvent(command.getTapScheduleId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTapScheduleCommand command) throws Exception {
    LOGGER.info("handling command UpdateTapScheduleCommand");
    UpdateTapScheduleEvent event =
        new UpdateTapScheduleEvent(command.getTapScheduleId(), command.getTapSchedules());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteTapScheduleCommand command) throws Exception {
    LOGGER.info("Handling command DeleteTapScheduleCommand");
    apply(new DeleteTapScheduleEvent(command.getTapScheduleId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignTapSchedulesToTapScheduleCommand command) throws Exception {
    LOGGER.info("Handling command AssignTapSchedulesToTapScheduleCommand");

    if (tapSchedules.contains(command.getAddTo()))
      throw new ProcessingException(
          "TapSchedules already contains an entity with id "
              + command.getAddTo().getTapScheduleId());

    apply(new AssignTapSchedulesToTapScheduleEvent(command.getTapScheduleId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveTapSchedulesFromTapScheduleCommand command) throws Exception {
    LOGGER.info("Handling command RemoveTapSchedulesFromTapScheduleCommand");

    if (!tapSchedules.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "TapSchedules does not contain an entity with id "
              + command.getRemoveFrom().getTapScheduleId());

    apply(
        new RemoveTapSchedulesFromTapScheduleEvent(
            command.getTapScheduleId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTapScheduleEvent event) {
    LOGGER.info("Event sourcing CreateTapScheduleEvent");
    this.tapScheduleId = event.getTapScheduleId();
  }

  @EventSourcingHandler
  void on(UpdateTapScheduleEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.tapSchedules = event.getTapSchedules();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignTapSchedulesToTapScheduleEvent event) {
    LOGGER.info("Event sourcing AssignTapSchedulesToTapScheduleEvent");
    this.tapSchedules.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveTapSchedulesFromTapScheduleEvent event) {
    LOGGER.info("Event sourcing RemoveTapSchedulesFromTapScheduleEvent");
    this.tapSchedules.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID tapScheduleId;

  private Set<TapSchedule> tapSchedules = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(TapScheduleAggregate.class.getName());
}
