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
 * Aggregate handler for WindTurbineType3or4IEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindTurbineType3or4IEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindTurbineType3or4IECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindTurbineType3or4IECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindTurbineType3or4IECAggregate(CreateWindTurbineType3or4IECCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateWindTurbineType3or4IECCommand");
    CreateWindTurbineType3or4IECEvent event =
        new CreateWindTurbineType3or4IECEvent(command.getWindTurbineType3or4IECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindTurbineType3or4IECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindTurbineType3or4IECCommand");
    UpdateWindTurbineType3or4IECEvent event =
        new UpdateWindTurbineType3or4IECEvent(
            command.getWindTurbineType3or4IECId(), command.getWindTurbineType3or4IEC());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindTurbineType3or4IECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindTurbineType3or4IECCommand");
    apply(new DeleteWindTurbineType3or4IECEvent(command.getWindTurbineType3or4IECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignWindTurbineType3or4IECToWindTurbineType3or4IECCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignWindTurbineType3or4IECToWindTurbineType3or4IECCommand");

    if (windTurbineType3or4IEC != null
        && windTurbineType3or4IEC.getWindTurbineType3or4IECId()
            == command.getAssignment().getWindTurbineType3or4IECId())
      throw new ProcessingException(
          "WindTurbineType3or4IEC already assigned with id "
              + command.getAssignment().getWindTurbineType3or4IECId());

    apply(
        new AssignWindTurbineType3or4IECToWindTurbineType3or4IECEvent(
            command.getWindTurbineType3or4IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWindTurbineType3or4IECFromWindTurbineType3or4IECCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignWindTurbineType3or4IECFromWindTurbineType3or4IECCommand");

    if (windTurbineType3or4IEC == null)
      throw new ProcessingException("WindTurbineType3or4IEC already has nothing assigned.");

    apply(
        new UnAssignWindTurbineType3or4IECFromWindTurbineType3or4IECEvent(
            command.getWindTurbineType3or4IECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindTurbineType3or4IECEvent event) {
    LOGGER.info("Event sourcing CreateWindTurbineType3or4IECEvent");
    this.windTurbineType3or4IECId = event.getWindTurbineType3or4IECId();
  }

  @EventSourcingHandler
  void on(UpdateWindTurbineType3or4IECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.windTurbineType3or4IEC = event.getWindTurbineType3or4IEC();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignWindTurbineType3or4IECToWindTurbineType3or4IECEvent event) {
    LOGGER.info("Event sourcing AssignWindTurbineType3or4IECToWindTurbineType3or4IECEvent");
    this.windTurbineType3or4IEC = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWindTurbineType3or4IECFromWindTurbineType3or4IECEvent event) {
    LOGGER.info("Event sourcing UnAssignWindTurbineType3or4IECFromWindTurbineType3or4IECEvent");
    this.windTurbineType3or4IEC = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windTurbineType3or4IECId;

  private WindTurbineType3or4IEC windTurbineType3or4IEC = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindTurbineType3or4IECAggregate.class.getName());
}
