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
 * Aggregate handler for Conductance as outlined for the CQRS pattern, all write responsibilities
 * related to Conductance are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ConductanceAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ConductanceAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ConductanceAggregate(CreateConductanceCommand command) throws Exception {
    LOGGER.info("Handling command CreateConductanceCommand");
    CreateConductanceEvent event =
        new CreateConductanceEvent(
            command.getConductanceId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateConductanceCommand command) throws Exception {
    LOGGER.info("handling command UpdateConductanceCommand");
    UpdateConductanceEvent event =
        new UpdateConductanceEvent(
            command.getConductanceId(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteConductanceCommand command) throws Exception {
    LOGGER.info("Handling command DeleteConductanceCommand");
    apply(new DeleteConductanceEvent(command.getConductanceId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToConductanceCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToConductanceCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToConductanceEvent(command.getConductanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromConductanceCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromConductanceCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromConductanceEvent(command.getConductanceId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateConductanceEvent event) {
    LOGGER.info("Event sourcing CreateConductanceEvent");
    this.conductanceId = event.getConductanceId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateConductanceEvent event) {
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
  void on(AssignValueToConductanceEvent event) {
    LOGGER.info("Event sourcing AssignValueToConductanceEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromConductanceEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromConductanceEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID conductanceId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private ACLineSegment g0ch = null;
  private ACLineSegment gch = null;
  private LinearShuntCompensator g0PerSection = null;
  private LinearShuntCompensator gPerSection = null;
  private NonlinearShuntCompensatorPoint g = null;
  private NonlinearShuntCompensatorPoint g0 = null;

  private static final Logger LOGGER = Logger.getLogger(ConductanceAggregate.class.getName());
}
