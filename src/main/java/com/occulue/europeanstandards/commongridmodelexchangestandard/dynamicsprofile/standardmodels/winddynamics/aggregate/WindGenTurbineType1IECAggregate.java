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
 * Aggregate handler for WindGenTurbineType1IEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindGenTurbineType1IEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindGenTurbineType1IECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindGenTurbineType1IECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindGenTurbineType1IECAggregate(CreateWindGenTurbineType1IECCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateWindGenTurbineType1IECCommand");
    CreateWindGenTurbineType1IECEvent event =
        new CreateWindGenTurbineType1IECEvent(command.getWindGenTurbineType1IECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindGenTurbineType1IECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindGenTurbineType1IECCommand");
    UpdateWindGenTurbineType1IECEvent event =
        new UpdateWindGenTurbineType1IECEvent(
            command.getWindGenTurbineType1IECId(), command.getWindGenTurbineType1IEC());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindGenTurbineType1IECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindGenTurbineType1IECCommand");
    apply(new DeleteWindGenTurbineType1IECEvent(command.getWindGenTurbineType1IECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignWindGenTurbineType1IECToWindGenTurbineType1IECCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignWindGenTurbineType1IECToWindGenTurbineType1IECCommand");

    if (windGenTurbineType1IEC != null
        && windGenTurbineType1IEC.getWindGenTurbineType1IECId()
            == command.getAssignment().getWindGenTurbineType1IECId())
      throw new ProcessingException(
          "WindGenTurbineType1IEC already assigned with id "
              + command.getAssignment().getWindGenTurbineType1IECId());

    apply(
        new AssignWindGenTurbineType1IECToWindGenTurbineType1IECEvent(
            command.getWindGenTurbineType1IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWindGenTurbineType1IECFromWindGenTurbineType1IECCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignWindGenTurbineType1IECFromWindGenTurbineType1IECCommand");

    if (windGenTurbineType1IEC == null)
      throw new ProcessingException("WindGenTurbineType1IEC already has nothing assigned.");

    apply(
        new UnAssignWindGenTurbineType1IECFromWindGenTurbineType1IECEvent(
            command.getWindGenTurbineType1IECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindGenTurbineType1IECEvent event) {
    LOGGER.info("Event sourcing CreateWindGenTurbineType1IECEvent");
    this.windGenTurbineType1IECId = event.getWindGenTurbineType1IECId();
  }

  @EventSourcingHandler
  void on(UpdateWindGenTurbineType1IECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.windGenTurbineType1IEC = event.getWindGenTurbineType1IEC();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignWindGenTurbineType1IECToWindGenTurbineType1IECEvent event) {
    LOGGER.info("Event sourcing AssignWindGenTurbineType1IECToWindGenTurbineType1IECEvent");
    this.windGenTurbineType1IEC = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWindGenTurbineType1IECFromWindGenTurbineType1IECEvent event) {
    LOGGER.info("Event sourcing UnAssignWindGenTurbineType1IECFromWindGenTurbineType1IECEvent");
    this.windGenTurbineType1IEC = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windGenTurbineType1IECId;

  private WindGenTurbineType1IEC windGenTurbineType1IEC = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType1IECAggregate.class.getName());
}
