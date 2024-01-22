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
 * Aggregate handler for WindPlantUserDefined as outlined for the CQRS pattern, all write
 * responsibilities related to WindPlantUserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindPlantUserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindPlantUserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindPlantUserDefinedAggregate(CreateWindPlantUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindPlantUserDefinedCommand");
    CreateWindPlantUserDefinedEvent event =
        new CreateWindPlantUserDefinedEvent(command.getWindPlantUserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindPlantUserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindPlantUserDefinedCommand");
    UpdateWindPlantUserDefinedEvent event =
        new UpdateWindPlantUserDefinedEvent(
            command.getWindPlantUserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindPlantUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindPlantUserDefinedCommand");
    apply(new DeleteWindPlantUserDefinedEvent(command.getWindPlantUserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToWindPlantUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command AssignProprietaryToWindPlantUserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToWindPlantUserDefinedEvent(
            command.getWindPlantUserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromWindPlantUserDefinedCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromWindPlantUserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromWindPlantUserDefinedEvent(command.getWindPlantUserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindPlantUserDefinedEvent event) {
    LOGGER.info("Event sourcing CreateWindPlantUserDefinedEvent");
    this.windPlantUserDefinedId = event.getWindPlantUserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdateWindPlantUserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToWindPlantUserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToWindPlantUserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromWindPlantUserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromWindPlantUserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windPlantUserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindPlantUserDefinedAggregate.class.getName());
}
