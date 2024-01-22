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
 * Aggregate handler for Capacitance as outlined for the CQRS pattern, all write responsibilities
 * related to Capacitance are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class CapacitanceAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public CapacitanceAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public CapacitanceAggregate(CreateCapacitanceCommand command) throws Exception {
    LOGGER.info("Handling command CreateCapacitanceCommand");
    CreateCapacitanceEvent event =
        new CreateCapacitanceEvent(
            command.getCapacitanceId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateCapacitanceCommand command) throws Exception {
    LOGGER.info("handling command UpdateCapacitanceCommand");
    UpdateCapacitanceEvent event =
        new UpdateCapacitanceEvent(
            command.getCapacitanceId(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteCapacitanceCommand command) throws Exception {
    LOGGER.info("Handling command DeleteCapacitanceCommand");
    apply(new DeleteCapacitanceEvent(command.getCapacitanceId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToCapacitanceCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToCapacitanceCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToCapacitanceEvent(command.getCapacitanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromCapacitanceCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromCapacitanceCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromCapacitanceEvent(command.getCapacitanceId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateCapacitanceEvent event) {
    LOGGER.info("Event sourcing CreateCapacitanceEvent");
    this.capacitanceId = event.getCapacitanceId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateCapacitanceEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
    this.value = event.getValue();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToCapacitanceEvent event) {
    LOGGER.info("Event sourcing AssignValueToCapacitanceEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromCapacitanceEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromCapacitanceEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID capacitanceId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private DCLineSegment capacitance = null;

  private static final Logger LOGGER = Logger.getLogger(CapacitanceAggregate.class.getName());
}
