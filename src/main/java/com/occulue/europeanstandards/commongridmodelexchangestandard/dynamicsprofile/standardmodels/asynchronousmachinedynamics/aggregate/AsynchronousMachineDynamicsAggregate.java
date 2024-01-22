package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.asynchronousmachinedynamics.aggregate;

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
 * Aggregate handler for AsynchronousMachineDynamics as outlined for the CQRS pattern, all write
 * responsibilities related to AsynchronousMachineDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AsynchronousMachineDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AsynchronousMachineDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AsynchronousMachineDynamicsAggregate(CreateAsynchronousMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateAsynchronousMachineDynamicsCommand");
    CreateAsynchronousMachineDynamicsEvent event =
        new CreateAsynchronousMachineDynamicsEvent(command.getAsynchronousMachineDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAsynchronousMachineDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateAsynchronousMachineDynamicsCommand");
    UpdateAsynchronousMachineDynamicsEvent event =
        new UpdateAsynchronousMachineDynamicsEvent(
            command.getAsynchronousMachineDynamicsId(), command.getAsynchronousMachineDynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAsynchronousMachineDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAsynchronousMachineDynamicsCommand");
    apply(new DeleteAsynchronousMachineDynamicsEvent(command.getAsynchronousMachineDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsCommand");

    if (asynchronousMachineDynamics != null
        && asynchronousMachineDynamics.getAsynchronousMachineDynamicsId()
            == command.getAssignment().getAsynchronousMachineDynamicsId())
      throw new ProcessingException(
          "AsynchronousMachineDynamics already assigned with id "
              + command.getAssignment().getAsynchronousMachineDynamicsId());

    apply(
        new AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsEvent(
            command.getAsynchronousMachineDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignAsynchronousMachineDynamicsFromAsynchronousMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignAsynchronousMachineDynamicsFromAsynchronousMachineDynamicsCommand");

    if (asynchronousMachineDynamics == null)
      throw new ProcessingException("AsynchronousMachineDynamics already has nothing assigned.");

    apply(
        new UnAssignAsynchronousMachineDynamicsFromAsynchronousMachineDynamicsEvent(
            command.getAsynchronousMachineDynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAsynchronousMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing CreateAsynchronousMachineDynamicsEvent");
    this.asynchronousMachineDynamicsId = event.getAsynchronousMachineDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateAsynchronousMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.asynchronousMachineDynamics = event.getAsynchronousMachineDynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsEvent");
    this.asynchronousMachineDynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAsynchronousMachineDynamicsFromAsynchronousMachineDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignAsynchronousMachineDynamicsFromAsynchronousMachineDynamicsEvent");
    this.asynchronousMachineDynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID asynchronousMachineDynamicsId;

  private AsynchronousMachineDynamics asynchronousMachineDynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineDynamicsAggregate.class.getName());
}
