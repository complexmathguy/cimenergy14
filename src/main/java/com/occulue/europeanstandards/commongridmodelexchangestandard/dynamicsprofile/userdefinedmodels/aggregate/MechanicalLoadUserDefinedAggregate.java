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
 * Aggregate handler for MechanicalLoadUserDefined as outlined for the CQRS pattern, all write
 * responsibilities related to MechanicalLoadUserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class MechanicalLoadUserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public MechanicalLoadUserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public MechanicalLoadUserDefinedAggregate(CreateMechanicalLoadUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateMechanicalLoadUserDefinedCommand");
    CreateMechanicalLoadUserDefinedEvent event =
        new CreateMechanicalLoadUserDefinedEvent(command.getMechanicalLoadUserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateMechanicalLoadUserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdateMechanicalLoadUserDefinedCommand");
    UpdateMechanicalLoadUserDefinedEvent event =
        new UpdateMechanicalLoadUserDefinedEvent(
            command.getMechanicalLoadUserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteMechanicalLoadUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteMechanicalLoadUserDefinedCommand");
    apply(new DeleteMechanicalLoadUserDefinedEvent(command.getMechanicalLoadUserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToMechanicalLoadUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command AssignProprietaryToMechanicalLoadUserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToMechanicalLoadUserDefinedEvent(
            command.getMechanicalLoadUserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromMechanicalLoadUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromMechanicalLoadUserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromMechanicalLoadUserDefinedEvent(
            command.getMechanicalLoadUserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateMechanicalLoadUserDefinedEvent event) {
    LOGGER.info("Event sourcing CreateMechanicalLoadUserDefinedEvent");
    this.mechanicalLoadUserDefinedId = event.getMechanicalLoadUserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdateMechanicalLoadUserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToMechanicalLoadUserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToMechanicalLoadUserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromMechanicalLoadUserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromMechanicalLoadUserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID mechanicalLoadUserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(MechanicalLoadUserDefinedAggregate.class.getName());
}
