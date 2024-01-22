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
 * Aggregate handler for OverexcitationLimiterUserDefined as outlined for the CQRS pattern, all
 * write responsibilities related to OverexcitationLimiterUserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class OverexcitationLimiterUserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public OverexcitationLimiterUserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public OverexcitationLimiterUserDefinedAggregate(
      CreateOverexcitationLimiterUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command CreateOverexcitationLimiterUserDefinedCommand");
    CreateOverexcitationLimiterUserDefinedEvent event =
        new CreateOverexcitationLimiterUserDefinedEvent(
            command.getOverexcitationLimiterUserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateOverexcitationLimiterUserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdateOverexcitationLimiterUserDefinedCommand");
    UpdateOverexcitationLimiterUserDefinedEvent event =
        new UpdateOverexcitationLimiterUserDefinedEvent(
            command.getOverexcitationLimiterUserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteOverexcitationLimiterUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteOverexcitationLimiterUserDefinedCommand");
    apply(
        new DeleteOverexcitationLimiterUserDefinedEvent(
            command.getOverexcitationLimiterUserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToOverexcitationLimiterUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignProprietaryToOverexcitationLimiterUserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToOverexcitationLimiterUserDefinedEvent(
            command.getOverexcitationLimiterUserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromOverexcitationLimiterUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromOverexcitationLimiterUserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromOverexcitationLimiterUserDefinedEvent(
            command.getOverexcitationLimiterUserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateOverexcitationLimiterUserDefinedEvent event) {
    LOGGER.info("Event sourcing CreateOverexcitationLimiterUserDefinedEvent");
    this.overexcitationLimiterUserDefinedId = event.getOverexcitationLimiterUserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdateOverexcitationLimiterUserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToOverexcitationLimiterUserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToOverexcitationLimiterUserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromOverexcitationLimiterUserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromOverexcitationLimiterUserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID overexcitationLimiterUserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(OverexcitationLimiterUserDefinedAggregate.class.getName());
}
