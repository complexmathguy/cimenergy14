package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.aggregate;

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
 * Aggregate handler for ExcitationSystemDynamics as outlined for the CQRS pattern, all write
 * responsibilities related to ExcitationSystemDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcitationSystemDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcitationSystemDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcitationSystemDynamicsAggregate(CreateExcitationSystemDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateExcitationSystemDynamicsCommand");
    CreateExcitationSystemDynamicsEvent event =
        new CreateExcitationSystemDynamicsEvent(command.getExcitationSystemDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcitationSystemDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcitationSystemDynamicsCommand");
    UpdateExcitationSystemDynamicsEvent event =
        new UpdateExcitationSystemDynamicsEvent(
            command.getExcitationSystemDynamicsId(), command.getExcitationSystemDynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcitationSystemDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcitationSystemDynamicsCommand");
    apply(new DeleteExcitationSystemDynamicsEvent(command.getExcitationSystemDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignExcitationSystemDynamicsToExcitationSystemDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignExcitationSystemDynamicsToExcitationSystemDynamicsCommand");

    if (excitationSystemDynamics != null
        && excitationSystemDynamics.getExcitationSystemDynamicsId()
            == command.getAssignment().getExcitationSystemDynamicsId())
      throw new ProcessingException(
          "ExcitationSystemDynamics already assigned with id "
              + command.getAssignment().getExcitationSystemDynamicsId());

    apply(
        new AssignExcitationSystemDynamicsToExcitationSystemDynamicsEvent(
            command.getExcitationSystemDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignExcitationSystemDynamicsFromExcitationSystemDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignExcitationSystemDynamicsFromExcitationSystemDynamicsCommand");

    if (excitationSystemDynamics == null)
      throw new ProcessingException("ExcitationSystemDynamics already has nothing assigned.");

    apply(
        new UnAssignExcitationSystemDynamicsFromExcitationSystemDynamicsEvent(
            command.getExcitationSystemDynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcitationSystemDynamicsEvent event) {
    LOGGER.info("Event sourcing CreateExcitationSystemDynamicsEvent");
    this.excitationSystemDynamicsId = event.getExcitationSystemDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateExcitationSystemDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.excitationSystemDynamics = event.getExcitationSystemDynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignExcitationSystemDynamicsToExcitationSystemDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignExcitationSystemDynamicsToExcitationSystemDynamicsEvent");
    this.excitationSystemDynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignExcitationSystemDynamicsFromExcitationSystemDynamicsEvent event) {
    LOGGER.info("Event sourcing UnAssignExcitationSystemDynamicsFromExcitationSystemDynamicsEvent");
    this.excitationSystemDynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excitationSystemDynamicsId;

  private ExcitationSystemDynamics excitationSystemDynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(ExcitationSystemDynamicsAggregate.class.getName());
}
