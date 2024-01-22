package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.aggregate;

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
 * Aggregate handler for VoltageAdjusterDynamics as outlined for the CQRS pattern, all write
 * responsibilities related to VoltageAdjusterDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class VoltageAdjusterDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public VoltageAdjusterDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public VoltageAdjusterDynamicsAggregate(CreateVoltageAdjusterDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateVoltageAdjusterDynamicsCommand");
    CreateVoltageAdjusterDynamicsEvent event =
        new CreateVoltageAdjusterDynamicsEvent(command.getVoltageAdjusterDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateVoltageAdjusterDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateVoltageAdjusterDynamicsCommand");
    UpdateVoltageAdjusterDynamicsEvent event =
        new UpdateVoltageAdjusterDynamicsEvent(
            command.getVoltageAdjusterDynamicsId(), command.getVoltageAdjusterDynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteVoltageAdjusterDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteVoltageAdjusterDynamicsCommand");
    apply(new DeleteVoltageAdjusterDynamicsEvent(command.getVoltageAdjusterDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsCommand");

    if (voltageAdjusterDynamics != null
        && voltageAdjusterDynamics.getVoltageAdjusterDynamicsId()
            == command.getAssignment().getVoltageAdjusterDynamicsId())
      throw new ProcessingException(
          "VoltageAdjusterDynamics already assigned with id "
              + command.getAssignment().getVoltageAdjusterDynamicsId());

    apply(
        new AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsEvent(
            command.getVoltageAdjusterDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVoltageAdjusterDynamicsFromVoltageAdjusterDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignVoltageAdjusterDynamicsFromVoltageAdjusterDynamicsCommand");

    if (voltageAdjusterDynamics == null)
      throw new ProcessingException("VoltageAdjusterDynamics already has nothing assigned.");

    apply(
        new UnAssignVoltageAdjusterDynamicsFromVoltageAdjusterDynamicsEvent(
            command.getVoltageAdjusterDynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateVoltageAdjusterDynamicsEvent event) {
    LOGGER.info("Event sourcing CreateVoltageAdjusterDynamicsEvent");
    this.voltageAdjusterDynamicsId = event.getVoltageAdjusterDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateVoltageAdjusterDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.voltageAdjusterDynamics = event.getVoltageAdjusterDynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsEvent");
    this.voltageAdjusterDynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVoltageAdjusterDynamicsFromVoltageAdjusterDynamicsEvent event) {
    LOGGER.info("Event sourcing UnAssignVoltageAdjusterDynamicsFromVoltageAdjusterDynamicsEvent");
    this.voltageAdjusterDynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID voltageAdjusterDynamicsId;

  private VoltageAdjusterDynamics voltageAdjusterDynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(VoltageAdjusterDynamicsAggregate.class.getName());
}
