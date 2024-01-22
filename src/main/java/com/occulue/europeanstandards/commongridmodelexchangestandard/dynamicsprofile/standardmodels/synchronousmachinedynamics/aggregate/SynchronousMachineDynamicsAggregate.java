package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.aggregate;

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
 * Aggregate handler for SynchronousMachineDynamics as outlined for the CQRS pattern, all write
 * responsibilities related to SynchronousMachineDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SynchronousMachineDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SynchronousMachineDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SynchronousMachineDynamicsAggregate(CreateSynchronousMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateSynchronousMachineDynamicsCommand");
    CreateSynchronousMachineDynamicsEvent event =
        new CreateSynchronousMachineDynamicsEvent(command.getSynchronousMachineDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSynchronousMachineDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateSynchronousMachineDynamicsCommand");
    UpdateSynchronousMachineDynamicsEvent event =
        new UpdateSynchronousMachineDynamicsEvent(
            command.getSynchronousMachineDynamicsId(), command.getSynchronousMachineDynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSynchronousMachineDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSynchronousMachineDynamicsCommand");
    apply(new DeleteSynchronousMachineDynamicsEvent(command.getSynchronousMachineDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignSynchronousMachineDynamicsToSynchronousMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignSynchronousMachineDynamicsToSynchronousMachineDynamicsCommand");

    if (synchronousMachineDynamics != null
        && synchronousMachineDynamics.getSynchronousMachineDynamicsId()
            == command.getAssignment().getSynchronousMachineDynamicsId())
      throw new ProcessingException(
          "SynchronousMachineDynamics already assigned with id "
              + command.getAssignment().getSynchronousMachineDynamicsId());

    apply(
        new AssignSynchronousMachineDynamicsToSynchronousMachineDynamicsEvent(
            command.getSynchronousMachineDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignSynchronousMachineDynamicsFromSynchronousMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignSynchronousMachineDynamicsFromSynchronousMachineDynamicsCommand");

    if (synchronousMachineDynamics == null)
      throw new ProcessingException("SynchronousMachineDynamics already has nothing assigned.");

    apply(
        new UnAssignSynchronousMachineDynamicsFromSynchronousMachineDynamicsEvent(
            command.getSynchronousMachineDynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSynchronousMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing CreateSynchronousMachineDynamicsEvent");
    this.synchronousMachineDynamicsId = event.getSynchronousMachineDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateSynchronousMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.synchronousMachineDynamics = event.getSynchronousMachineDynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignSynchronousMachineDynamicsToSynchronousMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignSynchronousMachineDynamicsToSynchronousMachineDynamicsEvent");
    this.synchronousMachineDynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSynchronousMachineDynamicsFromSynchronousMachineDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignSynchronousMachineDynamicsFromSynchronousMachineDynamicsEvent");
    this.synchronousMachineDynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID synchronousMachineDynamicsId;

  private SynchronousMachineDynamics synchronousMachineDynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineDynamicsAggregate.class.getName());
}
