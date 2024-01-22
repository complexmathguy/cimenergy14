package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.mechanicalloaddynamics.aggregate;

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
 * Aggregate handler for MechanicalLoadDynamics as outlined for the CQRS pattern, all write
 * responsibilities related to MechanicalLoadDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class MechanicalLoadDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public MechanicalLoadDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public MechanicalLoadDynamicsAggregate(CreateMechanicalLoadDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateMechanicalLoadDynamicsCommand");
    CreateMechanicalLoadDynamicsEvent event =
        new CreateMechanicalLoadDynamicsEvent(command.getMechanicalLoadDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateMechanicalLoadDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateMechanicalLoadDynamicsCommand");
    UpdateMechanicalLoadDynamicsEvent event =
        new UpdateMechanicalLoadDynamicsEvent(
            command.getMechanicalLoadDynamicsId(), command.getMechanicalLoadDynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteMechanicalLoadDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteMechanicalLoadDynamicsCommand");
    apply(new DeleteMechanicalLoadDynamicsEvent(command.getMechanicalLoadDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignMechanicalLoadDynamicsToMechanicalLoadDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignMechanicalLoadDynamicsToMechanicalLoadDynamicsCommand");

    if (mechanicalLoadDynamics != null
        && mechanicalLoadDynamics.getMechanicalLoadDynamicsId()
            == command.getAssignment().getMechanicalLoadDynamicsId())
      throw new ProcessingException(
          "MechanicalLoadDynamics already assigned with id "
              + command.getAssignment().getMechanicalLoadDynamicsId());

    apply(
        new AssignMechanicalLoadDynamicsToMechanicalLoadDynamicsEvent(
            command.getMechanicalLoadDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMechanicalLoadDynamicsFromMechanicalLoadDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignMechanicalLoadDynamicsFromMechanicalLoadDynamicsCommand");

    if (mechanicalLoadDynamics == null)
      throw new ProcessingException("MechanicalLoadDynamics already has nothing assigned.");

    apply(
        new UnAssignMechanicalLoadDynamicsFromMechanicalLoadDynamicsEvent(
            command.getMechanicalLoadDynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateMechanicalLoadDynamicsEvent event) {
    LOGGER.info("Event sourcing CreateMechanicalLoadDynamicsEvent");
    this.mechanicalLoadDynamicsId = event.getMechanicalLoadDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateMechanicalLoadDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.mechanicalLoadDynamics = event.getMechanicalLoadDynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignMechanicalLoadDynamicsToMechanicalLoadDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignMechanicalLoadDynamicsToMechanicalLoadDynamicsEvent");
    this.mechanicalLoadDynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMechanicalLoadDynamicsFromMechanicalLoadDynamicsEvent event) {
    LOGGER.info("Event sourcing UnAssignMechanicalLoadDynamicsFromMechanicalLoadDynamicsEvent");
    this.mechanicalLoadDynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID mechanicalLoadDynamicsId;

  private MechanicalLoadDynamics mechanicalLoadDynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(MechanicalLoadDynamicsAggregate.class.getName());
}
