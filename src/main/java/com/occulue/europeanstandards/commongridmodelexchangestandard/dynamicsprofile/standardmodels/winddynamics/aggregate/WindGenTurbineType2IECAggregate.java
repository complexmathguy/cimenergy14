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
 * Aggregate handler for WindGenTurbineType2IEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindGenTurbineType2IEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindGenTurbineType2IECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindGenTurbineType2IECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindGenTurbineType2IECAggregate(CreateWindGenTurbineType2IECCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateWindGenTurbineType2IECCommand");
    CreateWindGenTurbineType2IECEvent event =
        new CreateWindGenTurbineType2IECEvent(command.getWindGenTurbineType2IECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindGenTurbineType2IECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindGenTurbineType2IECCommand");
    UpdateWindGenTurbineType2IECEvent event =
        new UpdateWindGenTurbineType2IECEvent(
            command.getWindGenTurbineType2IECId(), command.getWindGenTurbineType2IEC());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindGenTurbineType2IECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindGenTurbineType2IECCommand");
    apply(new DeleteWindGenTurbineType2IECEvent(command.getWindGenTurbineType2IECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignWindGenTurbineType2IECToWindGenTurbineType2IECCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignWindGenTurbineType2IECToWindGenTurbineType2IECCommand");

    if (windGenTurbineType2IEC != null
        && windGenTurbineType2IEC.getWindGenTurbineType2IECId()
            == command.getAssignment().getWindGenTurbineType2IECId())
      throw new ProcessingException(
          "WindGenTurbineType2IEC already assigned with id "
              + command.getAssignment().getWindGenTurbineType2IECId());

    apply(
        new AssignWindGenTurbineType2IECToWindGenTurbineType2IECEvent(
            command.getWindGenTurbineType2IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWindGenTurbineType2IECFromWindGenTurbineType2IECCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignWindGenTurbineType2IECFromWindGenTurbineType2IECCommand");

    if (windGenTurbineType2IEC == null)
      throw new ProcessingException("WindGenTurbineType2IEC already has nothing assigned.");

    apply(
        new UnAssignWindGenTurbineType2IECFromWindGenTurbineType2IECEvent(
            command.getWindGenTurbineType2IECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindGenTurbineType2IECEvent event) {
    LOGGER.info("Event sourcing CreateWindGenTurbineType2IECEvent");
    this.windGenTurbineType2IECId = event.getWindGenTurbineType2IECId();
  }

  @EventSourcingHandler
  void on(UpdateWindGenTurbineType2IECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.windGenTurbineType2IEC = event.getWindGenTurbineType2IEC();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignWindGenTurbineType2IECToWindGenTurbineType2IECEvent event) {
    LOGGER.info("Event sourcing AssignWindGenTurbineType2IECToWindGenTurbineType2IECEvent");
    this.windGenTurbineType2IEC = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWindGenTurbineType2IECFromWindGenTurbineType2IECEvent event) {
    LOGGER.info("Event sourcing UnAssignWindGenTurbineType2IECFromWindGenTurbineType2IECEvent");
    this.windGenTurbineType2IEC = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windGenTurbineType2IECId;

  private WindGenTurbineType2IEC windGenTurbineType2IEC = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType2IECAggregate.class.getName());
}
