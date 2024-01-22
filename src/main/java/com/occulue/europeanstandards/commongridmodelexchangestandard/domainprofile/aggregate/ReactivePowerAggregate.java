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
 * Aggregate handler for ReactivePower as outlined for the CQRS pattern, all write responsibilities
 * related to ReactivePower are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ReactivePowerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ReactivePowerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ReactivePowerAggregate(CreateReactivePowerCommand command) throws Exception {
    LOGGER.info("Handling command CreateReactivePowerCommand");
    CreateReactivePowerEvent event =
        new CreateReactivePowerEvent(
            command.getReactivePowerId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateReactivePowerCommand command) throws Exception {
    LOGGER.info("handling command UpdateReactivePowerCommand");
    UpdateReactivePowerEvent event =
        new UpdateReactivePowerEvent(
            command.getReactivePowerId(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteReactivePowerCommand command) throws Exception {
    LOGGER.info("Handling command DeleteReactivePowerCommand");
    apply(new DeleteReactivePowerEvent(command.getReactivePowerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToReactivePowerCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToReactivePowerCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(
        new AssignValueToReactivePowerEvent(command.getReactivePowerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromReactivePowerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromReactivePowerCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromReactivePowerEvent(command.getReactivePowerId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateReactivePowerEvent event) {
    LOGGER.info("Event sourcing CreateReactivePowerEvent");
    this.reactivePowerId = event.getReactivePowerId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateReactivePowerEvent event) {
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
  void on(AssignValueToReactivePowerEvent event) {
    LOGGER.info("Event sourcing AssignValueToReactivePowerEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromReactivePowerEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromReactivePowerEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID reactivePowerId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private EnergyConsumer qfixed = null;
  private ExternalNetworkInjection maxQ = null;
  private ExternalNetworkInjection minQ = null;
  private SvInjection qInjection = null;
  private SvPowerFlow q = null;

  private static final Logger LOGGER = Logger.getLogger(ReactivePowerAggregate.class.getName());
}
