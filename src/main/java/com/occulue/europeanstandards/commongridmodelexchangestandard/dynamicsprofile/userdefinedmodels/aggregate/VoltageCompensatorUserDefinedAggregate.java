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
 * Aggregate handler for VoltageCompensatorUserDefined as outlined for the CQRS pattern, all write
 * responsibilities related to VoltageCompensatorUserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class VoltageCompensatorUserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public VoltageCompensatorUserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public VoltageCompensatorUserDefinedAggregate(CreateVoltageCompensatorUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateVoltageCompensatorUserDefinedCommand");
    CreateVoltageCompensatorUserDefinedEvent event =
        new CreateVoltageCompensatorUserDefinedEvent(command.getVoltageCompensatorUserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateVoltageCompensatorUserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdateVoltageCompensatorUserDefinedCommand");
    UpdateVoltageCompensatorUserDefinedEvent event =
        new UpdateVoltageCompensatorUserDefinedEvent(
            command.getVoltageCompensatorUserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteVoltageCompensatorUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteVoltageCompensatorUserDefinedCommand");
    apply(
        new DeleteVoltageCompensatorUserDefinedEvent(command.getVoltageCompensatorUserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToVoltageCompensatorUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignProprietaryToVoltageCompensatorUserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToVoltageCompensatorUserDefinedEvent(
            command.getVoltageCompensatorUserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromVoltageCompensatorUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromVoltageCompensatorUserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromVoltageCompensatorUserDefinedEvent(
            command.getVoltageCompensatorUserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateVoltageCompensatorUserDefinedEvent event) {
    LOGGER.info("Event sourcing CreateVoltageCompensatorUserDefinedEvent");
    this.voltageCompensatorUserDefinedId = event.getVoltageCompensatorUserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdateVoltageCompensatorUserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToVoltageCompensatorUserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToVoltageCompensatorUserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromVoltageCompensatorUserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromVoltageCompensatorUserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID voltageCompensatorUserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(VoltageCompensatorUserDefinedAggregate.class.getName());
}
