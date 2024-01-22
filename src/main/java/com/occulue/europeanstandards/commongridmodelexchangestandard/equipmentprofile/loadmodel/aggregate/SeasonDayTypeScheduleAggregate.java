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
 * Aggregate handler for SeasonDayTypeSchedule as outlined for the CQRS pattern, all write
 * responsibilities related to SeasonDayTypeSchedule are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SeasonDayTypeScheduleAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SeasonDayTypeScheduleAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SeasonDayTypeScheduleAggregate(CreateSeasonDayTypeScheduleCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateSeasonDayTypeScheduleCommand");
    CreateSeasonDayTypeScheduleEvent event =
        new CreateSeasonDayTypeScheduleEvent(command.getSeasonDayTypeScheduleId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSeasonDayTypeScheduleCommand command) throws Exception {
    LOGGER.info("handling command UpdateSeasonDayTypeScheduleCommand");
    UpdateSeasonDayTypeScheduleEvent event =
        new UpdateSeasonDayTypeScheduleEvent(
            command.getSeasonDayTypeScheduleId(), command.getSeasonDayTypeSchedules());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSeasonDayTypeScheduleCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSeasonDayTypeScheduleCommand");
    apply(new DeleteSeasonDayTypeScheduleEvent(command.getSeasonDayTypeScheduleId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleCommand");

    if (seasonDayTypeSchedules.contains(command.getAddTo()))
      throw new ProcessingException(
          "SeasonDayTypeSchedules already contains an entity with id "
              + command.getAddTo().getSeasonDayTypeScheduleId());

    apply(
        new AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleEvent(
            command.getSeasonDayTypeScheduleId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleCommand command)
      throws Exception {
    LOGGER.info("Handling command RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleCommand");

    if (!seasonDayTypeSchedules.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "SeasonDayTypeSchedules does not contain an entity with id "
              + command.getRemoveFrom().getSeasonDayTypeScheduleId());

    apply(
        new RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleEvent(
            command.getSeasonDayTypeScheduleId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSeasonDayTypeScheduleEvent event) {
    LOGGER.info("Event sourcing CreateSeasonDayTypeScheduleEvent");
    this.seasonDayTypeScheduleId = event.getSeasonDayTypeScheduleId();
  }

  @EventSourcingHandler
  void on(UpdateSeasonDayTypeScheduleEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.seasonDayTypeSchedules = event.getSeasonDayTypeSchedules();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleEvent event) {
    LOGGER.info("Event sourcing AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleEvent");
    this.seasonDayTypeSchedules.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleEvent event) {
    LOGGER.info("Event sourcing RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleEvent");
    this.seasonDayTypeSchedules.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID seasonDayTypeScheduleId;

  private Set<SeasonDayTypeSchedule> seasonDayTypeSchedules = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(SeasonDayTypeScheduleAggregate.class.getName());
}
