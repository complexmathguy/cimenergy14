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
 * Aggregate handler for CapacitancePerLength as outlined for the CQRS pattern, all write
 * responsibilities related to CapacitancePerLength are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class CapacitancePerLengthAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public CapacitancePerLengthAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public CapacitancePerLengthAggregate(CreateCapacitancePerLengthCommand command) throws Exception {
    LOGGER.info("Handling command CreateCapacitancePerLengthCommand");
    CreateCapacitancePerLengthEvent event =
        new CreateCapacitancePerLengthEvent(
            command.getCapacitancePerLengthId(),
            command.getDenominatorMultiplier(),
            command.getDenominatorUnit(),
            command.getMultiplier(),
            command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateCapacitancePerLengthCommand command) throws Exception {
    LOGGER.info("handling command UpdateCapacitancePerLengthCommand");
    UpdateCapacitancePerLengthEvent event =
        new UpdateCapacitancePerLengthEvent(
            command.getCapacitancePerLengthId(),
            command.getDenominatorMultiplier(),
            command.getDenominatorUnit(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteCapacitancePerLengthCommand command) throws Exception {
    LOGGER.info("Handling command DeleteCapacitancePerLengthCommand");
    apply(new DeleteCapacitancePerLengthEvent(command.getCapacitancePerLengthId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToCapacitancePerLengthCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToCapacitancePerLengthCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(
        new AssignValueToCapacitancePerLengthEvent(
            command.getCapacitancePerLengthId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromCapacitancePerLengthCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromCapacitancePerLengthCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromCapacitancePerLengthEvent(command.getCapacitancePerLengthId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateCapacitancePerLengthEvent event) {
    LOGGER.info("Event sourcing CreateCapacitancePerLengthEvent");
    this.capacitancePerLengthId = event.getCapacitancePerLengthId();
    this.denominatorMultiplier = event.getDenominatorMultiplier();
    this.denominatorUnit = event.getDenominatorUnit();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateCapacitancePerLengthEvent event) {
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
  void on(AssignValueToCapacitancePerLengthEvent event) {
    LOGGER.info("Event sourcing AssignValueToCapacitancePerLengthEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromCapacitancePerLengthEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromCapacitancePerLengthEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID capacitancePerLengthId;

  private UnitMultiplier denominatorMultiplier;
  private UnitSymbol denominatorUnit;
  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private PerLengthDCLineParameter capacitance = null;

  private static final Logger LOGGER =
      Logger.getLogger(CapacitancePerLengthAggregate.class.getName());
}
