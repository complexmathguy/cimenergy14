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
 * Aggregate handler for InductancePerLength as outlined for the CQRS pattern, all write
 * responsibilities related to InductancePerLength are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class InductancePerLengthAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public InductancePerLengthAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public InductancePerLengthAggregate(CreateInductancePerLengthCommand command) throws Exception {
    LOGGER.info("Handling command CreateInductancePerLengthCommand");
    CreateInductancePerLengthEvent event =
        new CreateInductancePerLengthEvent(
            command.getInductancePerLengthId(),
            command.getDenominatorMultiplier(),
            command.getDenominatorUnit(),
            command.getMultiplier(),
            command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateInductancePerLengthCommand command) throws Exception {
    LOGGER.info("handling command UpdateInductancePerLengthCommand");
    UpdateInductancePerLengthEvent event =
        new UpdateInductancePerLengthEvent(
            command.getInductancePerLengthId(),
            command.getDenominatorMultiplier(),
            command.getDenominatorUnit(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteInductancePerLengthCommand command) throws Exception {
    LOGGER.info("Handling command DeleteInductancePerLengthCommand");
    apply(new DeleteInductancePerLengthEvent(command.getInductancePerLengthId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToInductancePerLengthCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToInductancePerLengthCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(
        new AssignValueToInductancePerLengthEvent(
            command.getInductancePerLengthId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromInductancePerLengthCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromInductancePerLengthCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromInductancePerLengthEvent(command.getInductancePerLengthId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateInductancePerLengthEvent event) {
    LOGGER.info("Event sourcing CreateInductancePerLengthEvent");
    this.inductancePerLengthId = event.getInductancePerLengthId();
    this.denominatorMultiplier = event.getDenominatorMultiplier();
    this.denominatorUnit = event.getDenominatorUnit();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateInductancePerLengthEvent event) {
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
  void on(AssignValueToInductancePerLengthEvent event) {
    LOGGER.info("Event sourcing AssignValueToInductancePerLengthEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromInductancePerLengthEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromInductancePerLengthEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID inductancePerLengthId;

  private UnitMultiplier denominatorMultiplier;
  private UnitSymbol denominatorUnit;
  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private PerLengthDCLineParameter inductance = null;

  private static final Logger LOGGER =
      Logger.getLogger(InductancePerLengthAggregate.class.getName());
}
