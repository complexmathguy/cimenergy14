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
 * Aggregate handler for WindTurbineType4bIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindTurbineType4bIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindTurbineType4bIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindTurbineType4bIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindTurbineType4bIECAggregate(CreateWindTurbineType4bIECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindTurbineType4bIECCommand");
    CreateWindTurbineType4bIECEvent event =
        new CreateWindTurbineType4bIECEvent(command.getWindTurbineType4bIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindTurbineType4bIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindTurbineType4bIECCommand");
    UpdateWindTurbineType4bIECEvent event =
        new UpdateWindTurbineType4bIECEvent(
            command.getWindTurbineType4bIECId(), command.getWindTurbineType4bIEC());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindTurbineType4bIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindTurbineType4bIECCommand");
    apply(new DeleteWindTurbineType4bIECEvent(command.getWindTurbineType4bIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignWindTurbineType4bIECToWindTurbineType4bIECCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignWindTurbineType4bIECToWindTurbineType4bIECCommand");

    if (windTurbineType4bIEC != null
        && windTurbineType4bIEC.getWindTurbineType4bIECId()
            == command.getAssignment().getWindTurbineType4bIECId())
      throw new ProcessingException(
          "WindTurbineType4bIEC already assigned with id "
              + command.getAssignment().getWindTurbineType4bIECId());

    apply(
        new AssignWindTurbineType4bIECToWindTurbineType4bIECEvent(
            command.getWindTurbineType4bIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWindTurbineType4bIECFromWindTurbineType4bIECCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignWindTurbineType4bIECFromWindTurbineType4bIECCommand");

    if (windTurbineType4bIEC == null)
      throw new ProcessingException("WindTurbineType4bIEC already has nothing assigned.");

    apply(
        new UnAssignWindTurbineType4bIECFromWindTurbineType4bIECEvent(
            command.getWindTurbineType4bIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindTurbineType4bIECEvent event) {
    LOGGER.info("Event sourcing CreateWindTurbineType4bIECEvent");
    this.windTurbineType4bIECId = event.getWindTurbineType4bIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindTurbineType4bIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.windTurbineType4bIEC = event.getWindTurbineType4bIEC();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignWindTurbineType4bIECToWindTurbineType4bIECEvent event) {
    LOGGER.info("Event sourcing AssignWindTurbineType4bIECToWindTurbineType4bIECEvent");
    this.windTurbineType4bIEC = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWindTurbineType4bIECFromWindTurbineType4bIECEvent event) {
    LOGGER.info("Event sourcing UnAssignWindTurbineType4bIECFromWindTurbineType4bIECEvent");
    this.windTurbineType4bIEC = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windTurbineType4bIECId;

  private WindTurbineType4bIEC windTurbineType4bIEC = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindTurbineType4bIECAggregate.class.getName());
}
