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
 * Aggregate handler for ResistancePerLength as outlined for the CQRS pattern, all write
 * responsibilities related to ResistancePerLength are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ResistancePerLengthAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ResistancePerLengthAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ResistancePerLengthAggregate(CreateResistancePerLengthCommand command) throws Exception {
    LOGGER.info("Handling command CreateResistancePerLengthCommand");
    CreateResistancePerLengthEvent event =
        new CreateResistancePerLengthEvent(
            command.getResistancePerLengthId(),
            command.getDenominatorMultiplier(),
            command.getDenominatorUnit(),
            command.getMultiplier(),
            command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateResistancePerLengthCommand command) throws Exception {
    LOGGER.info("handling command UpdateResistancePerLengthCommand");
    UpdateResistancePerLengthEvent event =
        new UpdateResistancePerLengthEvent(
            command.getResistancePerLengthId(),
            command.getDenominatorMultiplier(),
            command.getDenominatorUnit(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteResistancePerLengthCommand command) throws Exception {
    LOGGER.info("Handling command DeleteResistancePerLengthCommand");
    apply(new DeleteResistancePerLengthEvent(command.getResistancePerLengthId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToResistancePerLengthCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToResistancePerLengthCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(
        new AssignValueToResistancePerLengthEvent(
            command.getResistancePerLengthId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromResistancePerLengthCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromResistancePerLengthCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromResistancePerLengthEvent(command.getResistancePerLengthId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateResistancePerLengthEvent event) {
    LOGGER.info("Event sourcing CreateResistancePerLengthEvent");
    this.resistancePerLengthId = event.getResistancePerLengthId();
    this.denominatorMultiplier = event.getDenominatorMultiplier();
    this.denominatorUnit = event.getDenominatorUnit();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateResistancePerLengthEvent event) {
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
  void on(AssignValueToResistancePerLengthEvent event) {
    LOGGER.info("Event sourcing AssignValueToResistancePerLengthEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromResistancePerLengthEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromResistancePerLengthEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID resistancePerLengthId;

  private UnitMultiplier denominatorMultiplier;
  private UnitSymbol denominatorUnit;
  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private PerLengthDCLineParameter resistance = null;

  private static final Logger LOGGER =
      Logger.getLogger(ResistancePerLengthAggregate.class.getName());
}
