package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.aggregate;

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
 * Aggregate handler for ActivePowerPerFrequency as outlined for the CQRS pattern, all write
 * responsibilities related to ActivePowerPerFrequency are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ActivePowerPerFrequencyAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ActivePowerPerFrequencyAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ActivePowerPerFrequencyAggregate(CreateActivePowerPerFrequencyCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateActivePowerPerFrequencyCommand");
    CreateActivePowerPerFrequencyEvent event =
        new CreateActivePowerPerFrequencyEvent(
            command.getActivePowerPerFrequencyId(),
            command.getDenominatorMultiplier(),
            command.getDenominatorUnit(),
            command.getMultiplier(),
            command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateActivePowerPerFrequencyCommand command) throws Exception {
    LOGGER.info("handling command UpdateActivePowerPerFrequencyCommand");
    UpdateActivePowerPerFrequencyEvent event =
        new UpdateActivePowerPerFrequencyEvent(
            command.getActivePowerPerFrequencyId(),
            command.getDenominatorMultiplier(),
            command.getDenominatorUnit(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteActivePowerPerFrequencyCommand command) throws Exception {
    LOGGER.info("Handling command DeleteActivePowerPerFrequencyCommand");
    apply(new DeleteActivePowerPerFrequencyEvent(command.getActivePowerPerFrequencyId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToActivePowerPerFrequencyCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToActivePowerPerFrequencyCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(
        new AssignValueToActivePowerPerFrequencyEvent(
            command.getActivePowerPerFrequencyId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromActivePowerPerFrequencyCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromActivePowerPerFrequencyCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(
        new UnAssignValueFromActivePowerPerFrequencyEvent(command.getActivePowerPerFrequencyId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateActivePowerPerFrequencyEvent event) {
    LOGGER.info("Event sourcing CreateActivePowerPerFrequencyEvent");
    this.activePowerPerFrequencyId = event.getActivePowerPerFrequencyId();
    this.denominatorMultiplier = event.getDenominatorMultiplier();
    this.denominatorUnit = event.getDenominatorUnit();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateActivePowerPerFrequencyEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.denominatorMultiplier = event.getDenominatorMultiplier();
    this.denominatorUnit = event.getDenominatorUnit();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
    this.value = event.getValue();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToActivePowerPerFrequencyEvent event) {
    LOGGER.info("Event sourcing AssignValueToActivePowerPerFrequencyEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromActivePowerPerFrequencyEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromActivePowerPerFrequencyEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID activePowerPerFrequencyId;

  private UnitMultiplier denominatorMultiplier;
  private UnitSymbol denominatorUnit;
  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private ExternalNetworkInjection governorSCD = null;

  private static final Logger LOGGER =
      Logger.getLogger(ActivePowerPerFrequencyAggregate.class.getName());
}
