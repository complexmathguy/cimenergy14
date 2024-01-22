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
 * Aggregate handler for SynchronousMachineUserDefined as outlined for the CQRS pattern, all write
 * responsibilities related to SynchronousMachineUserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SynchronousMachineUserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SynchronousMachineUserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SynchronousMachineUserDefinedAggregate(CreateSynchronousMachineUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateSynchronousMachineUserDefinedCommand");
    CreateSynchronousMachineUserDefinedEvent event =
        new CreateSynchronousMachineUserDefinedEvent(command.getSynchronousMachineUserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSynchronousMachineUserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdateSynchronousMachineUserDefinedCommand");
    UpdateSynchronousMachineUserDefinedEvent event =
        new UpdateSynchronousMachineUserDefinedEvent(
            command.getSynchronousMachineUserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSynchronousMachineUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSynchronousMachineUserDefinedCommand");
    apply(
        new DeleteSynchronousMachineUserDefinedEvent(command.getSynchronousMachineUserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToSynchronousMachineUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignProprietaryToSynchronousMachineUserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToSynchronousMachineUserDefinedEvent(
            command.getSynchronousMachineUserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromSynchronousMachineUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromSynchronousMachineUserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromSynchronousMachineUserDefinedEvent(
            command.getSynchronousMachineUserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSynchronousMachineUserDefinedEvent event) {
    LOGGER.info("Event sourcing CreateSynchronousMachineUserDefinedEvent");
    this.synchronousMachineUserDefinedId = event.getSynchronousMachineUserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdateSynchronousMachineUserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToSynchronousMachineUserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToSynchronousMachineUserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromSynchronousMachineUserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromSynchronousMachineUserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID synchronousMachineUserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineUserDefinedAggregate.class.getName());
}
