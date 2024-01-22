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
 * Aggregate handler for Susceptance as outlined for the CQRS pattern, all write responsibilities
 * related to Susceptance are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SusceptanceAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SusceptanceAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SusceptanceAggregate(CreateSusceptanceCommand command) throws Exception {
    LOGGER.info("Handling command CreateSusceptanceCommand");
    CreateSusceptanceEvent event =
        new CreateSusceptanceEvent(
            command.getSusceptanceId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSusceptanceCommand command) throws Exception {
    LOGGER.info("handling command UpdateSusceptanceCommand");
    UpdateSusceptanceEvent event =
        new UpdateSusceptanceEvent(
            command.getSusceptanceId(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSusceptanceCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSusceptanceCommand");
    apply(new DeleteSusceptanceEvent(command.getSusceptanceId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToSusceptanceCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToSusceptanceCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToSusceptanceEvent(command.getSusceptanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromSusceptanceCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromSusceptanceCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromSusceptanceEvent(command.getSusceptanceId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSusceptanceEvent event) {
    LOGGER.info("Event sourcing CreateSusceptanceEvent");
    this.susceptanceId = event.getSusceptanceId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateSusceptanceEvent event) {
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
  void on(AssignValueToSusceptanceEvent event) {
    LOGGER.info("Event sourcing AssignValueToSusceptanceEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromSusceptanceEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromSusceptanceEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID susceptanceId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private ACLineSegment b0ch = null;
  private ACLineSegment bch = null;
  private LinearShuntCompensator b0PerSection = null;
  private LinearShuntCompensator bPerSection = null;
  private NonlinearShuntCompensatorPoint b = null;
  private NonlinearShuntCompensatorPoint b0 = null;

  private static final Logger LOGGER = Logger.getLogger(SusceptanceAggregate.class.getName());
}
