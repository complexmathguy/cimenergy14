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
 * Aggregate handler for PowerSystemStabilizerUserDefined as outlined for the CQRS pattern, all
 * write responsibilities related to PowerSystemStabilizerUserDefined are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PowerSystemStabilizerUserDefinedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PowerSystemStabilizerUserDefinedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PowerSystemStabilizerUserDefinedAggregate(
      CreatePowerSystemStabilizerUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command CreatePowerSystemStabilizerUserDefinedCommand");
    CreatePowerSystemStabilizerUserDefinedEvent event =
        new CreatePowerSystemStabilizerUserDefinedEvent(
            command.getPowerSystemStabilizerUserDefinedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePowerSystemStabilizerUserDefinedCommand command) throws Exception {
    LOGGER.info("handling command UpdatePowerSystemStabilizerUserDefinedCommand");
    UpdatePowerSystemStabilizerUserDefinedEvent event =
        new UpdatePowerSystemStabilizerUserDefinedEvent(
            command.getPowerSystemStabilizerUserDefinedId(), command.getProprietary());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePowerSystemStabilizerUserDefinedCommand command) throws Exception {
    LOGGER.info("Handling command DeletePowerSystemStabilizerUserDefinedCommand");
    apply(
        new DeletePowerSystemStabilizerUserDefinedEvent(
            command.getPowerSystemStabilizerUserDefinedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignProprietaryToPowerSystemStabilizerUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignProprietaryToPowerSystemStabilizerUserDefinedCommand");

    if (proprietary != null
        && proprietary.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Proprietary already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignProprietaryToPowerSystemStabilizerUserDefinedEvent(
            command.getPowerSystemStabilizerUserDefinedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignProprietaryFromPowerSystemStabilizerUserDefinedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignProprietaryFromPowerSystemStabilizerUserDefinedCommand");

    if (proprietary == null)
      throw new ProcessingException("Proprietary already has nothing assigned.");

    apply(
        new UnAssignProprietaryFromPowerSystemStabilizerUserDefinedEvent(
            command.getPowerSystemStabilizerUserDefinedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePowerSystemStabilizerUserDefinedEvent event) {
    LOGGER.info("Event sourcing CreatePowerSystemStabilizerUserDefinedEvent");
    this.powerSystemStabilizerUserDefinedId = event.getPowerSystemStabilizerUserDefinedId();
  }

  @EventSourcingHandler
  void on(UpdatePowerSystemStabilizerUserDefinedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.proprietary = event.getProprietary();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignProprietaryToPowerSystemStabilizerUserDefinedEvent event) {
    LOGGER.info("Event sourcing AssignProprietaryToPowerSystemStabilizerUserDefinedEvent");
    this.proprietary = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignProprietaryFromPowerSystemStabilizerUserDefinedEvent event) {
    LOGGER.info("Event sourcing UnAssignProprietaryFromPowerSystemStabilizerUserDefinedEvent");
    this.proprietary = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID powerSystemStabilizerUserDefinedId;

  private BooleanProxy proprietary = null;

  private static final Logger LOGGER =
      Logger.getLogger(PowerSystemStabilizerUserDefinedAggregate.class.getName());
}
