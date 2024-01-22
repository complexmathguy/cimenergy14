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
 * Aggregate handler for AsynchronousMachineUserDefined as outlined for the CQRS pattern, all write
 * responsibilities related to AsynchronousMachineUserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AsynchronousMachineUserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AsynchronousMachineUserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AsynchronousMachineUserDefinedAggregate(
      CreateAsynchronousMachineUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command CreateAsynchronousMachineUserDefinedCommand");
    CreateAsynchronousMachineUserDefinedEvent event =
        new CreateAsynchronousMachineUserDefinedEvent(
            command.getAsynchronousMachineUserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAsynchronousMachineUserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdateAsynchronousMachineUserDefinedCommand");
    UpdateAsynchronousMachineUserDefinedEvent event =
        new UpdateAsynchronousMachineUserDefinedEvent(
            command.getAsynchronousMachineUserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAsynchronousMachineUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAsynchronousMachineUserDefinedCommand");
    apply(
        new DeleteAsynchronousMachineUserDefinedEvent(
            command.getAsynchronousMachineUserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToAsynchronousMachineUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignProprietaryToAsynchronousMachineUserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToAsynchronousMachineUserDefinedEvent(
            command.getAsynchronousMachineUserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromAsynchronousMachineUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromAsynchronousMachineUserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromAsynchronousMachineUserDefinedEvent(
            command.getAsynchronousMachineUserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAsynchronousMachineUserDefinedEvent event) {
    LOGGER.info("Event sourcing CreateAsynchronousMachineUserDefinedEvent");
    this.asynchronousMachineUserDefinedId = event.getAsynchronousMachineUserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdateAsynchronousMachineUserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToAsynchronousMachineUserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToAsynchronousMachineUserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromAsynchronousMachineUserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromAsynchronousMachineUserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID asynchronousMachineUserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineUserDefinedAggregate.class.getName());
}
