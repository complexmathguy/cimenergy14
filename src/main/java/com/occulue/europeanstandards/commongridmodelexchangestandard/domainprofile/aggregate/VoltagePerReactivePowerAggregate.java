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
 * Aggregate handler for VoltagePerReactivePower as outlined for the CQRS pattern, all write
 * responsibilities related to VoltagePerReactivePower are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class VoltagePerReactivePowerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public VoltagePerReactivePowerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public VoltagePerReactivePowerAggregate(CreateVoltagePerReactivePowerCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateVoltagePerReactivePowerCommand");
    CreateVoltagePerReactivePowerEvent event =
        new CreateVoltagePerReactivePowerEvent(
            command.getVoltagePerReactivePowerId(),
            command.getDenominatorMultiplier(),
            command.getDenominatorUnit(),
            command.getMultiplier(),
            command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateVoltagePerReactivePowerCommand command) throws Exception {
    LOGGER.info("handling command UpdateVoltagePerReactivePowerCommand");
    UpdateVoltagePerReactivePowerEvent event =
        new UpdateVoltagePerReactivePowerEvent(
            command.getVoltagePerReactivePowerId(),
            command.getDenominatorMultiplier(),
            command.getDenominatorUnit(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteVoltagePerReactivePowerCommand command) throws Exception {
    LOGGER.info("Handling command DeleteVoltagePerReactivePowerCommand");
    apply(new DeleteVoltagePerReactivePowerEvent(command.getVoltagePerReactivePowerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToVoltagePerReactivePowerCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToVoltagePerReactivePowerCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(
        new AssignValueToVoltagePerReactivePowerEvent(
            command.getVoltagePerReactivePowerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromVoltagePerReactivePowerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromVoltagePerReactivePowerCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(
        new UnAssignValueFromVoltagePerReactivePowerEvent(command.getVoltagePerReactivePowerId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateVoltagePerReactivePowerEvent event) {
    LOGGER.info("Event sourcing CreateVoltagePerReactivePowerEvent");
    this.voltagePerReactivePowerId = event.getVoltagePerReactivePowerId();
    this.denominatorMultiplier = event.getDenominatorMultiplier();
    this.denominatorUnit = event.getDenominatorUnit();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateVoltagePerReactivePowerEvent event) {
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
  void on(AssignValueToVoltagePerReactivePowerEvent event) {
    LOGGER.info("Event sourcing AssignValueToVoltagePerReactivePowerEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromVoltagePerReactivePowerEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromVoltagePerReactivePowerEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID voltagePerReactivePowerId;

  private UnitMultiplier denominatorMultiplier;
  private UnitSymbol denominatorUnit;
  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private ShuntCompensator voltageSensitivity = null;
  private StaticVarCompensator slope = null;

  private static final Logger LOGGER =
      Logger.getLogger(VoltagePerReactivePowerAggregate.class.getName());
}
