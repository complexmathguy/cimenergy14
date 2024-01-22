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
 * Aggregate handler for Inductance as outlined for the CQRS pattern, all write responsibilities
 * related to Inductance are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class InductanceAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public InductanceAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public InductanceAggregate(CreateInductanceCommand command) throws Exception {
    LOGGER.info("Handling command CreateInductanceCommand");
    CreateInductanceEvent event =
        new CreateInductanceEvent(
            command.getInductanceId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateInductanceCommand command) throws Exception {
    LOGGER.info("handling command UpdateInductanceCommand");
    UpdateInductanceEvent event =
        new UpdateInductanceEvent(
            command.getInductanceId(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteInductanceCommand command) throws Exception {
    LOGGER.info("Handling command DeleteInductanceCommand");
    apply(new DeleteInductanceEvent(command.getInductanceId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToInductanceCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToInductanceCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToInductanceEvent(command.getInductanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromInductanceCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromInductanceCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromInductanceEvent(command.getInductanceId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateInductanceEvent event) {
    LOGGER.info("Event sourcing CreateInductanceEvent");
    this.inductanceId = event.getInductanceId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateInductanceEvent event) {
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
  void on(AssignValueToInductanceEvent event) {
    LOGGER.info("Event sourcing AssignValueToInductanceEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromInductanceEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromInductanceEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID inductanceId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private DCGround inductance = null;

  private static final Logger LOGGER = Logger.getLogger(InductanceAggregate.class.getName());
}
