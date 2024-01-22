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
 * Aggregate handler for ExcitationSystemUserDefined as outlined for the CQRS pattern, all write
 * responsibilities related to ExcitationSystemUserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcitationSystemUserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcitationSystemUserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcitationSystemUserDefinedAggregate(CreateExcitationSystemUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateExcitationSystemUserDefinedCommand");
    CreateExcitationSystemUserDefinedEvent event =
        new CreateExcitationSystemUserDefinedEvent(command.getExcitationSystemUserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcitationSystemUserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcitationSystemUserDefinedCommand");
    UpdateExcitationSystemUserDefinedEvent event =
        new UpdateExcitationSystemUserDefinedEvent(
            command.getExcitationSystemUserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcitationSystemUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcitationSystemUserDefinedCommand");
    apply(new DeleteExcitationSystemUserDefinedEvent(command.getExcitationSystemUserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToExcitationSystemUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignProprietaryToExcitationSystemUserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToExcitationSystemUserDefinedEvent(
            command.getExcitationSystemUserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromExcitationSystemUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromExcitationSystemUserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromExcitationSystemUserDefinedEvent(
            command.getExcitationSystemUserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcitationSystemUserDefinedEvent event) {
    LOGGER.info("Event sourcing CreateExcitationSystemUserDefinedEvent");
    this.excitationSystemUserDefinedId = event.getExcitationSystemUserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdateExcitationSystemUserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToExcitationSystemUserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToExcitationSystemUserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromExcitationSystemUserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromExcitationSystemUserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excitationSystemUserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(ExcitationSystemUserDefinedAggregate.class.getName());
}
