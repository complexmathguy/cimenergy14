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
 * Aggregate handler for WindType1or2UserDefined as outlined for the CQRS pattern, all write
 * responsibilities related to WindType1or2UserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindType1or2UserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindType1or2UserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindType1or2UserDefinedAggregate(CreateWindType1or2UserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateWindType1or2UserDefinedCommand");
    CreateWindType1or2UserDefinedEvent event =
        new CreateWindType1or2UserDefinedEvent(command.getWindType1or2UserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindType1or2UserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindType1or2UserDefinedCommand");
    UpdateWindType1or2UserDefinedEvent event =
        new UpdateWindType1or2UserDefinedEvent(
            command.getWindType1or2UserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindType1or2UserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindType1or2UserDefinedCommand");
    apply(new DeleteWindType1or2UserDefinedEvent(command.getWindType1or2UserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToWindType1or2UserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command AssignProprietaryToWindType1or2UserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToWindType1or2UserDefinedEvent(
            command.getWindType1or2UserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromWindType1or2UserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromWindType1or2UserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromWindType1or2UserDefinedEvent(
            command.getWindType1or2UserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindType1or2UserDefinedEvent event) {
    LOGGER.info("Event sourcing CreateWindType1or2UserDefinedEvent");
    this.windType1or2UserDefinedId = event.getWindType1or2UserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdateWindType1or2UserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToWindType1or2UserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToWindType1or2UserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromWindType1or2UserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromWindType1or2UserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windType1or2UserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindType1or2UserDefinedAggregate.class.getName());
}
