package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.aggregate;

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
 * Aggregate handler for VoltageAdjusterUserDefined as outlined for the CQRS pattern, all write
 * responsibilities related to VoltageAdjusterUserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class VoltageAdjusterUserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public VoltageAdjusterUserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public VoltageAdjusterUserDefinedAggregate(CreateVoltageAdjusterUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateVoltageAdjusterUserDefinedCommand");
    CreateVoltageAdjusterUserDefinedEvent event =
        new CreateVoltageAdjusterUserDefinedEvent(command.getVoltageAdjusterUserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateVoltageAdjusterUserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdateVoltageAdjusterUserDefinedCommand");
    UpdateVoltageAdjusterUserDefinedEvent event =
        new UpdateVoltageAdjusterUserDefinedEvent(
            command.getVoltageAdjusterUserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteVoltageAdjusterUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteVoltageAdjusterUserDefinedCommand");
    apply(new DeleteVoltageAdjusterUserDefinedEvent(command.getVoltageAdjusterUserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToVoltageAdjusterUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignProprietaryToVoltageAdjusterUserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToVoltageAdjusterUserDefinedEvent(
            command.getVoltageAdjusterUserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromVoltageAdjusterUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromVoltageAdjusterUserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromVoltageAdjusterUserDefinedEvent(
            command.getVoltageAdjusterUserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateVoltageAdjusterUserDefinedEvent event) {
    LOGGER.info("Event sourcing CreateVoltageAdjusterUserDefinedEvent");
    this.voltageAdjusterUserDefinedId = event.getVoltageAdjusterUserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdateVoltageAdjusterUserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToVoltageAdjusterUserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToVoltageAdjusterUserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromVoltageAdjusterUserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromVoltageAdjusterUserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID voltageAdjusterUserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(VoltageAdjusterUserDefinedAggregate.class.getName());
}
