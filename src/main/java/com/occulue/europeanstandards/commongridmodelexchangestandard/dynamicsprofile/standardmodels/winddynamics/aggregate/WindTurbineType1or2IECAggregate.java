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
 * Aggregate handler for WindTurbineType1or2IEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindTurbineType1or2IEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindTurbineType1or2IECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindTurbineType1or2IECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindTurbineType1or2IECAggregate(CreateWindTurbineType1or2IECCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateWindTurbineType1or2IECCommand");
    CreateWindTurbineType1or2IECEvent event =
        new CreateWindTurbineType1or2IECEvent(command.getWindTurbineType1or2IECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindTurbineType1or2IECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindTurbineType1or2IECCommand");
    UpdateWindTurbineType1or2IECEvent event =
        new UpdateWindTurbineType1or2IECEvent(
            command.getWindTurbineType1or2IECId(), command.getWindTurbineType1or2IEC());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindTurbineType1or2IECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindTurbineType1or2IECCommand");
    apply(new DeleteWindTurbineType1or2IECEvent(command.getWindTurbineType1or2IECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignWindTurbineType1or2IECToWindTurbineType1or2IECCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignWindTurbineType1or2IECToWindTurbineType1or2IECCommand");

    if (windTurbineType1or2IEC != null
        && windTurbineType1or2IEC.getWindTurbineType1or2IECId()
            == command.getAssignment().getWindTurbineType1or2IECId())
      throw new ProcessingException(
          "WindTurbineType1or2IEC already assigned with id "
              + command.getAssignment().getWindTurbineType1or2IECId());

    apply(
        new AssignWindTurbineType1or2IECToWindTurbineType1or2IECEvent(
            command.getWindTurbineType1or2IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECCommand");

    if (windTurbineType1or2IEC == null)
      throw new ProcessingException("WindTurbineType1or2IEC already has nothing assigned.");

    apply(
        new UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECEvent(
            command.getWindTurbineType1or2IECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindTurbineType1or2IECEvent event) {
    LOGGER.info("Event sourcing CreateWindTurbineType1or2IECEvent");
    this.windTurbineType1or2IECId = event.getWindTurbineType1or2IECId();
  }

  @EventSourcingHandler
  void on(UpdateWindTurbineType1or2IECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.windTurbineType1or2IEC = event.getWindTurbineType1or2IEC();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignWindTurbineType1or2IECToWindTurbineType1or2IECEvent event) {
    LOGGER.info("Event sourcing AssignWindTurbineType1or2IECToWindTurbineType1or2IECEvent");
    this.windTurbineType1or2IEC = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECEvent event) {
    LOGGER.info("Event sourcing UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECEvent");
    this.windTurbineType1or2IEC = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windTurbineType1or2IECId;

  private WindTurbineType1or2IEC windTurbineType1or2IEC = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindTurbineType1or2IECAggregate.class.getName());
}
