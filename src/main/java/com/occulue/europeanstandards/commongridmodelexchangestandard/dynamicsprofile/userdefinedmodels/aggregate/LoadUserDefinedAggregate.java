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
 * Aggregate handler for LoadUserDefined as outlined for the CQRS pattern, all write
 * responsibilities related to LoadUserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class LoadUserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public LoadUserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public LoadUserDefinedAggregate(CreateLoadUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command CreateLoadUserDefinedCommand");
    CreateLoadUserDefinedEvent event =
        new CreateLoadUserDefinedEvent(command.getLoadUserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateLoadUserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdateLoadUserDefinedCommand");
    UpdateLoadUserDefinedEvent event =
        new UpdateLoadUserDefinedEvent(command.getLoadUserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteLoadUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteLoadUserDefinedCommand");
    apply(new DeleteLoadUserDefinedEvent(command.getLoadUserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToLoadUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command AssignProprietaryToLoadUserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToLoadUserDefinedEvent(
            command.getLoadUserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromLoadUserDefinedCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromLoadUserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(new UnAssignProprietaryFromLoadUserDefinedEvent(command.getLoadUserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateLoadUserDefinedEvent event) {
    LOGGER.info("Event sourcing CreateLoadUserDefinedEvent");
    this.loadUserDefinedId = event.getLoadUserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdateLoadUserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToLoadUserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToLoadUserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromLoadUserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromLoadUserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID loadUserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER = Logger.getLogger(LoadUserDefinedAggregate.class.getName());
}
