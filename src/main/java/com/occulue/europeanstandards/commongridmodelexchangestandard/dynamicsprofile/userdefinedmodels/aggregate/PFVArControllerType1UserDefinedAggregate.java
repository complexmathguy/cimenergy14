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
 * Aggregate handler for PFVArControllerType1UserDefined as outlined for the CQRS pattern, all write
 * responsibilities related to PFVArControllerType1UserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PFVArControllerType1UserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PFVArControllerType1UserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PFVArControllerType1UserDefinedAggregate(
      CreatePFVArControllerType1UserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command CreatePFVArControllerType1UserDefinedCommand");
    CreatePFVArControllerType1UserDefinedEvent event =
        new CreatePFVArControllerType1UserDefinedEvent(
            command.getPFVArControllerType1UserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePFVArControllerType1UserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdatePFVArControllerType1UserDefinedCommand");
    UpdatePFVArControllerType1UserDefinedEvent event =
        new UpdatePFVArControllerType1UserDefinedEvent(
            command.getPFVArControllerType1UserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePFVArControllerType1UserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeletePFVArControllerType1UserDefinedCommand");
    apply(
        new DeletePFVArControllerType1UserDefinedEvent(
            command.getPFVArControllerType1UserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToPFVArControllerType1UserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignProprietaryToPFVArControllerType1UserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToPFVArControllerType1UserDefinedEvent(
            command.getPFVArControllerType1UserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromPFVArControllerType1UserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromPFVArControllerType1UserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromPFVArControllerType1UserDefinedEvent(
            command.getPFVArControllerType1UserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePFVArControllerType1UserDefinedEvent event) {
    LOGGER.info("Event sourcing CreatePFVArControllerType1UserDefinedEvent");
    this.pFVArControllerType1UserDefinedId = event.getPFVArControllerType1UserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdatePFVArControllerType1UserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToPFVArControllerType1UserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToPFVArControllerType1UserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromPFVArControllerType1UserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromPFVArControllerType1UserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pFVArControllerType1UserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(PFVArControllerType1UserDefinedAggregate.class.getName());
}
