package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.aggregate;

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
 * Aggregate handler for WindPlantIEC as outlined for the CQRS pattern, all write responsibilities
 * related to WindPlantIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindPlantIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindPlantIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindPlantIECAggregate(CreateWindPlantIECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindPlantIECCommand");
    CreateWindPlantIECEvent event = new CreateWindPlantIECEvent(command.getWindPlantIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindPlantIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindPlantIECCommand");
    UpdateWindPlantIECEvent event =
        new UpdateWindPlantIECEvent(command.getWindPlantIECId(), command.getWindPlantIEC());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindPlantIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindPlantIECCommand");
    apply(new DeleteWindPlantIECEvent(command.getWindPlantIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignWindPlantIECToWindPlantIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignWindPlantIECToWindPlantIECCommand");

    if (windPlantIEC != null
        && windPlantIEC.getWindPlantIECId() == command.getAssignment().getWindPlantIECId())
      throw new ProcessingException(
          "WindPlantIEC already assigned with id " + command.getAssignment().getWindPlantIECId());

    apply(
        new AssignWindPlantIECToWindPlantIECEvent(
            command.getWindPlantIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWindPlantIECFromWindPlantIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignWindPlantIECFromWindPlantIECCommand");

    if (windPlantIEC == null)
      throw new ProcessingException("WindPlantIEC already has nothing assigned.");

    apply(new UnAssignWindPlantIECFromWindPlantIECEvent(command.getWindPlantIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindPlantIECEvent event) {
    LOGGER.info("Event sourcing CreateWindPlantIECEvent");
    this.windPlantIECId = event.getWindPlantIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindPlantIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.windPlantIEC = event.getWindPlantIEC();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignWindPlantIECToWindPlantIECEvent event) {
    LOGGER.info("Event sourcing AssignWindPlantIECToWindPlantIECEvent");
    this.windPlantIEC = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWindPlantIECFromWindPlantIECEvent event) {
    LOGGER.info("Event sourcing UnAssignWindPlantIECFromWindPlantIECEvent");
    this.windPlantIEC = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windPlantIECId;

  private WindPlantIEC windPlantIEC = null;

  private static final Logger LOGGER = Logger.getLogger(WindPlantIECAggregate.class.getName());
}
