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
 * Aggregate handler for WindType3or4UserDefined as outlined for the CQRS pattern, all write
 * responsibilities related to WindType3or4UserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindType3or4UserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindType3or4UserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindType3or4UserDefinedAggregate(CreateWindType3or4UserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateWindType3or4UserDefinedCommand");
    CreateWindType3or4UserDefinedEvent event =
        new CreateWindType3or4UserDefinedEvent(command.getWindType3or4UserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindType3or4UserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindType3or4UserDefinedCommand");
    UpdateWindType3or4UserDefinedEvent event =
        new UpdateWindType3or4UserDefinedEvent(
            command.getWindType3or4UserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindType3or4UserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindType3or4UserDefinedCommand");
    apply(new DeleteWindType3or4UserDefinedEvent(command.getWindType3or4UserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToWindType3or4UserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command AssignProprietaryToWindType3or4UserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToWindType3or4UserDefinedEvent(
            command.getWindType3or4UserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromWindType3or4UserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromWindType3or4UserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromWindType3or4UserDefinedEvent(
            command.getWindType3or4UserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindType3or4UserDefinedEvent event) {
    LOGGER.info("Event sourcing CreateWindType3or4UserDefinedEvent");
    this.windType3or4UserDefinedId = event.getWindType3or4UserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdateWindType3or4UserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToWindType3or4UserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToWindType3or4UserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromWindType3or4UserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromWindType3or4UserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windType3or4UserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindType3or4UserDefinedAggregate.class.getName());
}
