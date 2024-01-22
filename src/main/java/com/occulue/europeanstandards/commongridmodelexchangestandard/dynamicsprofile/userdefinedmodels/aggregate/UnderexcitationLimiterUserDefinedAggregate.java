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
 * Aggregate handler for UnderexcitationLimiterUserDefined as outlined for the CQRS pattern, all
 * write responsibilities related to UnderexcitationLimiterUserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class UnderexcitationLimiterUserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public UnderexcitationLimiterUserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public UnderexcitationLimiterUserDefinedAggregate(
      CreateUnderexcitationLimiterUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command CreateUnderexcitationLimiterUserDefinedCommand");
    CreateUnderexcitationLimiterUserDefinedEvent event =
        new CreateUnderexcitationLimiterUserDefinedEvent(
            command.getUnderexcitationLimiterUserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateUnderexcitationLimiterUserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdateUnderexcitationLimiterUserDefinedCommand");
    UpdateUnderexcitationLimiterUserDefinedEvent event =
        new UpdateUnderexcitationLimiterUserDefinedEvent(
            command.getUnderexcitationLimiterUserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteUnderexcitationLimiterUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteUnderexcitationLimiterUserDefinedCommand");
    apply(
        new DeleteUnderexcitationLimiterUserDefinedEvent(
            command.getUnderexcitationLimiterUserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToUnderexcitationLimiterUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignProprietaryToUnderexcitationLimiterUserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToUnderexcitationLimiterUserDefinedEvent(
            command.getUnderexcitationLimiterUserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromUnderexcitationLimiterUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromUnderexcitationLimiterUserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromUnderexcitationLimiterUserDefinedEvent(
            command.getUnderexcitationLimiterUserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateUnderexcitationLimiterUserDefinedEvent event) {
    LOGGER.info("Event sourcing CreateUnderexcitationLimiterUserDefinedEvent");
    this.underexcitationLimiterUserDefinedId = event.getUnderexcitationLimiterUserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdateUnderexcitationLimiterUserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToUnderexcitationLimiterUserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToUnderexcitationLimiterUserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromUnderexcitationLimiterUserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromUnderexcitationLimiterUserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID underexcitationLimiterUserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(UnderexcitationLimiterUserDefinedAggregate.class.getName());
}
