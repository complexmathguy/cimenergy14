package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.aggregate;

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
 * Aggregate handler for Location as outlined for the CQRS pattern, all write responsibilities
 * related to Location are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class LocationAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public LocationAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public LocationAggregate(CreateLocationCommand command) throws Exception {
    LOGGER.info("Handling command CreateLocationCommand");
    CreateLocationEvent event = new CreateLocationEvent(command.getLocationId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateLocationCommand command) throws Exception {
    LOGGER.info("handling command UpdateLocationCommand");
    UpdateLocationEvent event =
        new UpdateLocationEvent(command.getLocationId(), command.getLocation());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteLocationCommand command) throws Exception {
    LOGGER.info("Handling command DeleteLocationCommand");
    apply(new DeleteLocationEvent(command.getLocationId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignLocationToLocationCommand command) throws Exception {
    LOGGER.info("Handling command AssignLocationToLocationCommand");

    if (location != null && location.getLocationId() == command.getAssignment().getLocationId())
      throw new ProcessingException(
          "Location already assigned with id " + command.getAssignment().getLocationId());

    apply(new AssignLocationToLocationEvent(command.getLocationId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLocationFromLocationCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLocationFromLocationCommand");

    if (location == null) throw new ProcessingException("Location already has nothing assigned.");

    apply(new UnAssignLocationFromLocationEvent(command.getLocationId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateLocationEvent event) {
    LOGGER.info("Event sourcing CreateLocationEvent");
    this.locationId = event.getLocationId();
  }

  @EventSourcingHandler
  void on(UpdateLocationEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.location = event.getLocation();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignLocationToLocationEvent event) {
    LOGGER.info("Event sourcing AssignLocationToLocationEvent");
    this.location = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLocationFromLocationEvent event) {
    LOGGER.info("Event sourcing UnAssignLocationFromLocationEvent");
    this.location = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID locationId;

  private Location location = null;

  private static final Logger LOGGER = Logger.getLogger(LocationAggregate.class.getName());
}
