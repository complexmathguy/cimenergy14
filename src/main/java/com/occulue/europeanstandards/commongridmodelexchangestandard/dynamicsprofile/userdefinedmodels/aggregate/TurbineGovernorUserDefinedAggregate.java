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
 * Aggregate handler for TurbineGovernorUserDefined as outlined for the CQRS pattern, all write
 * responsibilities related to TurbineGovernorUserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TurbineGovernorUserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TurbineGovernorUserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TurbineGovernorUserDefinedAggregate(CreateTurbineGovernorUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateTurbineGovernorUserDefinedCommand");
    CreateTurbineGovernorUserDefinedEvent event =
        new CreateTurbineGovernorUserDefinedEvent(command.getTurbineGovernorUserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTurbineGovernorUserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdateTurbineGovernorUserDefinedCommand");
    UpdateTurbineGovernorUserDefinedEvent event =
        new UpdateTurbineGovernorUserDefinedEvent(
            command.getTurbineGovernorUserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteTurbineGovernorUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteTurbineGovernorUserDefinedCommand");
    apply(new DeleteTurbineGovernorUserDefinedEvent(command.getTurbineGovernorUserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToTurbineGovernorUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignProprietaryToTurbineGovernorUserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToTurbineGovernorUserDefinedEvent(
            command.getTurbineGovernorUserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromTurbineGovernorUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromTurbineGovernorUserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromTurbineGovernorUserDefinedEvent(
            command.getTurbineGovernorUserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTurbineGovernorUserDefinedEvent event) {
    LOGGER.info("Event sourcing CreateTurbineGovernorUserDefinedEvent");
    this.turbineGovernorUserDefinedId = event.getTurbineGovernorUserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdateTurbineGovernorUserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToTurbineGovernorUserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToTurbineGovernorUserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromTurbineGovernorUserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromTurbineGovernorUserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID turbineGovernorUserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(TurbineGovernorUserDefinedAggregate.class.getName());
}
