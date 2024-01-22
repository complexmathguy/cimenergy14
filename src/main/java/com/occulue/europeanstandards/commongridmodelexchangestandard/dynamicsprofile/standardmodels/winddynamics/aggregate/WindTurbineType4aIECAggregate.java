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
 * Aggregate handler for WindTurbineType4aIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindTurbineType4aIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindTurbineType4aIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindTurbineType4aIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindTurbineType4aIECAggregate(CreateWindTurbineType4aIECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindTurbineType4aIECCommand");
    CreateWindTurbineType4aIECEvent event =
        new CreateWindTurbineType4aIECEvent(command.getWindTurbineType4aIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindTurbineType4aIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindTurbineType4aIECCommand");
    UpdateWindTurbineType4aIECEvent event =
        new UpdateWindTurbineType4aIECEvent(
            command.getWindTurbineType4aIECId(), command.getWindTurbineType4aIEC());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindTurbineType4aIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindTurbineType4aIECCommand");
    apply(new DeleteWindTurbineType4aIECEvent(command.getWindTurbineType4aIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignWindTurbineType4aIECToWindTurbineType4aIECCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignWindTurbineType4aIECToWindTurbineType4aIECCommand");

    if (windTurbineType4aIEC != null
        && windTurbineType4aIEC.getWindTurbineType4aIECId()
            == command.getAssignment().getWindTurbineType4aIECId())
      throw new ProcessingException(
          "WindTurbineType4aIEC already assigned with id "
              + command.getAssignment().getWindTurbineType4aIECId());

    apply(
        new AssignWindTurbineType4aIECToWindTurbineType4aIECEvent(
            command.getWindTurbineType4aIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWindTurbineType4aIECFromWindTurbineType4aIECCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignWindTurbineType4aIECFromWindTurbineType4aIECCommand");

    if (windTurbineType4aIEC == null)
      throw new ProcessingException("WindTurbineType4aIEC already has nothing assigned.");

    apply(
        new UnAssignWindTurbineType4aIECFromWindTurbineType4aIECEvent(
            command.getWindTurbineType4aIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindTurbineType4aIECEvent event) {
    LOGGER.info("Event sourcing CreateWindTurbineType4aIECEvent");
    this.windTurbineType4aIECId = event.getWindTurbineType4aIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindTurbineType4aIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.windTurbineType4aIEC = event.getWindTurbineType4aIEC();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignWindTurbineType4aIECToWindTurbineType4aIECEvent event) {
    LOGGER.info("Event sourcing AssignWindTurbineType4aIECToWindTurbineType4aIECEvent");
    this.windTurbineType4aIEC = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWindTurbineType4aIECFromWindTurbineType4aIECEvent event) {
    LOGGER.info("Event sourcing UnAssignWindTurbineType4aIECFromWindTurbineType4aIECEvent");
    this.windTurbineType4aIEC = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windTurbineType4aIECId;

  private WindTurbineType4aIEC windTurbineType4aIEC = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindTurbineType4aIECAggregate.class.getName());
}
