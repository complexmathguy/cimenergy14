package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.aggregate;

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
 * Aggregate handler for VoltageCompensatorDynamics as outlined for the CQRS pattern, all write
 * responsibilities related to VoltageCompensatorDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class VoltageCompensatorDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public VoltageCompensatorDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public VoltageCompensatorDynamicsAggregate(CreateVoltageCompensatorDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateVoltageCompensatorDynamicsCommand");
    CreateVoltageCompensatorDynamicsEvent event =
        new CreateVoltageCompensatorDynamicsEvent(command.getVoltageCompensatorDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateVoltageCompensatorDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateVoltageCompensatorDynamicsCommand");
    UpdateVoltageCompensatorDynamicsEvent event =
        new UpdateVoltageCompensatorDynamicsEvent(
            command.getVoltageCompensatorDynamicsId(), command.getVoltageCompensatorDynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteVoltageCompensatorDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteVoltageCompensatorDynamicsCommand");
    apply(new DeleteVoltageCompensatorDynamicsEvent(command.getVoltageCompensatorDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsCommand");

    if (voltageCompensatorDynamics != null
        && voltageCompensatorDynamics.getVoltageCompensatorDynamicsId()
            == command.getAssignment().getVoltageCompensatorDynamicsId())
      throw new ProcessingException(
          "VoltageCompensatorDynamics already assigned with id "
              + command.getAssignment().getVoltageCompensatorDynamicsId());

    apply(
        new AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsEvent(
            command.getVoltageCompensatorDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignVoltageCompensatorDynamicsFromVoltageCompensatorDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignVoltageCompensatorDynamicsFromVoltageCompensatorDynamicsCommand");

    if (voltageCompensatorDynamics == null)
      throw new ProcessingException("VoltageCompensatorDynamics already has nothing assigned.");

    apply(
        new UnAssignVoltageCompensatorDynamicsFromVoltageCompensatorDynamicsEvent(
            command.getVoltageCompensatorDynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateVoltageCompensatorDynamicsEvent event) {
    LOGGER.info("Event sourcing CreateVoltageCompensatorDynamicsEvent");
    this.voltageCompensatorDynamicsId = event.getVoltageCompensatorDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateVoltageCompensatorDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.voltageCompensatorDynamics = event.getVoltageCompensatorDynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsEvent");
    this.voltageCompensatorDynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVoltageCompensatorDynamicsFromVoltageCompensatorDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignVoltageCompensatorDynamicsFromVoltageCompensatorDynamicsEvent");
    this.voltageCompensatorDynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID voltageCompensatorDynamicsId;

  private VoltageCompensatorDynamics voltageCompensatorDynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(VoltageCompensatorDynamicsAggregate.class.getName());
}
