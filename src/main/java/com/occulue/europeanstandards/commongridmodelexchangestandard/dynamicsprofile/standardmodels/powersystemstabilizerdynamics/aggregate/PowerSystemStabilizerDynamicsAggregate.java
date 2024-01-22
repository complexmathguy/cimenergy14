package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.aggregate;

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
 * Aggregate handler for PowerSystemStabilizerDynamics as outlined for the CQRS pattern, all write
 * responsibilities related to PowerSystemStabilizerDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PowerSystemStabilizerDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PowerSystemStabilizerDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PowerSystemStabilizerDynamicsAggregate(CreatePowerSystemStabilizerDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreatePowerSystemStabilizerDynamicsCommand");
    CreatePowerSystemStabilizerDynamicsEvent event =
        new CreatePowerSystemStabilizerDynamicsEvent(command.getPowerSystemStabilizerDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePowerSystemStabilizerDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdatePowerSystemStabilizerDynamicsCommand");
    UpdatePowerSystemStabilizerDynamicsEvent event =
        new UpdatePowerSystemStabilizerDynamicsEvent(
            command.getPowerSystemStabilizerDynamicsId(),
            command.getPowerSystemStabilizerDynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePowerSystemStabilizerDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeletePowerSystemStabilizerDynamicsCommand");
    apply(
        new DeletePowerSystemStabilizerDynamicsEvent(command.getPowerSystemStabilizerDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(
      AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsCommand");

    if (powerSystemStabilizerDynamics != null
        && powerSystemStabilizerDynamics.getPowerSystemStabilizerDynamicsId()
            == command.getAssignment().getPowerSystemStabilizerDynamicsId())
      throw new ProcessingException(
          "PowerSystemStabilizerDynamics already assigned with id "
              + command.getAssignment().getPowerSystemStabilizerDynamicsId());

    apply(
        new AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsEvent(
            command.getPowerSystemStabilizerDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignPowerSystemStabilizerDynamicsFromPowerSystemStabilizerDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignPowerSystemStabilizerDynamicsFromPowerSystemStabilizerDynamicsCommand");

    if (powerSystemStabilizerDynamics == null)
      throw new ProcessingException("PowerSystemStabilizerDynamics already has nothing assigned.");

    apply(
        new UnAssignPowerSystemStabilizerDynamicsFromPowerSystemStabilizerDynamicsEvent(
            command.getPowerSystemStabilizerDynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePowerSystemStabilizerDynamicsEvent event) {
    LOGGER.info("Event sourcing CreatePowerSystemStabilizerDynamicsEvent");
    this.powerSystemStabilizerDynamicsId = event.getPowerSystemStabilizerDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdatePowerSystemStabilizerDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.powerSystemStabilizerDynamics = event.getPowerSystemStabilizerDynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsEvent");
    this.powerSystemStabilizerDynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPowerSystemStabilizerDynamicsFromPowerSystemStabilizerDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignPowerSystemStabilizerDynamicsFromPowerSystemStabilizerDynamicsEvent");
    this.powerSystemStabilizerDynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID powerSystemStabilizerDynamicsId;

  private PowerSystemStabilizerDynamics powerSystemStabilizerDynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(PowerSystemStabilizerDynamicsAggregate.class.getName());
}
