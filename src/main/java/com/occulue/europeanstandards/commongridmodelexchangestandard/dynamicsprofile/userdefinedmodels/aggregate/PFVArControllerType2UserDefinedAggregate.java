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
 * Aggregate handler for PFVArControllerType2UserDefined as outlined for the CQRS pattern, all write
 * responsibilities related to PFVArControllerType2UserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PFVArControllerType2UserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PFVArControllerType2UserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PFVArControllerType2UserDefinedAggregate(
      CreatePFVArControllerType2UserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command CreatePFVArControllerType2UserDefinedCommand");
    CreatePFVArControllerType2UserDefinedEvent event =
        new CreatePFVArControllerType2UserDefinedEvent(
            command.getPFVArControllerType2UserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePFVArControllerType2UserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdatePFVArControllerType2UserDefinedCommand");
    UpdatePFVArControllerType2UserDefinedEvent event =
        new UpdatePFVArControllerType2UserDefinedEvent(
            command.getPFVArControllerType2UserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePFVArControllerType2UserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeletePFVArControllerType2UserDefinedCommand");
    apply(
        new DeletePFVArControllerType2UserDefinedEvent(
            command.getPFVArControllerType2UserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToPFVArControllerType2UserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignProprietaryToPFVArControllerType2UserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToPFVArControllerType2UserDefinedEvent(
            command.getPFVArControllerType2UserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromPFVArControllerType2UserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromPFVArControllerType2UserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromPFVArControllerType2UserDefinedEvent(
            command.getPFVArControllerType2UserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePFVArControllerType2UserDefinedEvent event) {
    LOGGER.info("Event sourcing CreatePFVArControllerType2UserDefinedEvent");
    this.pFVArControllerType2UserDefinedId = event.getPFVArControllerType2UserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdatePFVArControllerType2UserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToPFVArControllerType2UserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToPFVArControllerType2UserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromPFVArControllerType2UserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromPFVArControllerType2UserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pFVArControllerType2UserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(PFVArControllerType2UserDefinedAggregate.class.getName());
}
