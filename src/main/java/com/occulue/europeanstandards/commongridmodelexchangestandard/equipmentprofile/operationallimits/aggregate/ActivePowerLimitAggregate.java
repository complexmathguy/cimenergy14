package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.aggregate;

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
 * Aggregate handler for ActivePowerLimit as outlined for the CQRS pattern, all write
 * responsibilities related to ActivePowerLimit are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ActivePowerLimitAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ActivePowerLimitAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ActivePowerLimitAggregate(CreateActivePowerLimitCommand command) throws Exception {
    LOGGER.info("Handling command CreateActivePowerLimitCommand");
    CreateActivePowerLimitEvent event =
        new CreateActivePowerLimitEvent(command.getActivePowerLimitId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateActivePowerLimitCommand command) throws Exception {
    LOGGER.info("handling command UpdateActivePowerLimitCommand");
    UpdateActivePowerLimitEvent event =
        new UpdateActivePowerLimitEvent(command.getActivePowerLimitId(), command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteActivePowerLimitCommand command) throws Exception {
    LOGGER.info("Handling command DeleteActivePowerLimitCommand");
    apply(new DeleteActivePowerLimitEvent(command.getActivePowerLimitId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToActivePowerLimitCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToActivePowerLimitCommand");

    if (value != null && value.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignValueToActivePowerLimitEvent(
            command.getActivePowerLimitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromActivePowerLimitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromActivePowerLimitCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromActivePowerLimitEvent(command.getActivePowerLimitId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateActivePowerLimitEvent event) {
    LOGGER.info("Event sourcing CreateActivePowerLimitEvent");
    this.activePowerLimitId = event.getActivePowerLimitId();
  }

  @EventSourcingHandler
  void on(UpdateActivePowerLimitEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.value = event.getValue();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToActivePowerLimitEvent event) {
    LOGGER.info("Event sourcing AssignValueToActivePowerLimitEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromActivePowerLimitEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromActivePowerLimitEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID activePowerLimitId;

  private ActivePower value = null;

  private static final Logger LOGGER = Logger.getLogger(ActivePowerLimitAggregate.class.getName());
}
