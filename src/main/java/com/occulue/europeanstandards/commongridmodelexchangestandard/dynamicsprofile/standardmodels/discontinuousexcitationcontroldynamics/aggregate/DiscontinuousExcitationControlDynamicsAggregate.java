package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.aggregate;

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
 * Aggregate handler for DiscontinuousExcitationControlDynamics as outlined for the CQRS pattern,
 * all write responsibilities related to DiscontinuousExcitationControlDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DiscontinuousExcitationControlDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DiscontinuousExcitationControlDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DiscontinuousExcitationControlDynamicsAggregate(
      CreateDiscontinuousExcitationControlDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command CreateDiscontinuousExcitationControlDynamicsCommand");
    CreateDiscontinuousExcitationControlDynamicsEvent event =
        new CreateDiscontinuousExcitationControlDynamicsEvent(
            command.getDiscontinuousExcitationControlDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDiscontinuousExcitationControlDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateDiscontinuousExcitationControlDynamicsCommand");
    UpdateDiscontinuousExcitationControlDynamicsEvent event =
        new UpdateDiscontinuousExcitationControlDynamicsEvent(
            command.getDiscontinuousExcitationControlDynamicsId(),
            command.getDiscontinuousExcitationControlDynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDiscontinuousExcitationControlDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDiscontinuousExcitationControlDynamicsCommand");
    apply(
        new DeleteDiscontinuousExcitationControlDynamicsEvent(
            command.getDiscontinuousExcitationControlDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(
      AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsCommand
          command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsCommand");

    if (discontinuousExcitationControlDynamics != null
        && discontinuousExcitationControlDynamics.getDiscontinuousExcitationControlDynamicsId()
            == command.getAssignment().getDiscontinuousExcitationControlDynamicsId())
      throw new ProcessingException(
          "DiscontinuousExcitationControlDynamics already assigned with id "
              + command.getAssignment().getDiscontinuousExcitationControlDynamicsId());

    apply(
        new AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsEvent(
            command.getDiscontinuousExcitationControlDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignDiscontinuousExcitationControlDynamicsFromDiscontinuousExcitationControlDynamicsCommand
          command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignDiscontinuousExcitationControlDynamicsFromDiscontinuousExcitationControlDynamicsCommand");

    if (discontinuousExcitationControlDynamics == null)
      throw new ProcessingException(
          "DiscontinuousExcitationControlDynamics already has nothing assigned.");

    apply(
        new UnAssignDiscontinuousExcitationControlDynamicsFromDiscontinuousExcitationControlDynamicsEvent(
            command.getDiscontinuousExcitationControlDynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDiscontinuousExcitationControlDynamicsEvent event) {
    LOGGER.info("Event sourcing CreateDiscontinuousExcitationControlDynamicsEvent");
    this.discontinuousExcitationControlDynamicsId =
        event.getDiscontinuousExcitationControlDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateDiscontinuousExcitationControlDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.discontinuousExcitationControlDynamics = event.getDiscontinuousExcitationControlDynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(
      AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsEvent
          event) {
    LOGGER.info(
        "Event sourcing AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsEvent");
    this.discontinuousExcitationControlDynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(
      UnAssignDiscontinuousExcitationControlDynamicsFromDiscontinuousExcitationControlDynamicsEvent
          event) {
    LOGGER.info(
        "Event sourcing UnAssignDiscontinuousExcitationControlDynamicsFromDiscontinuousExcitationControlDynamicsEvent");
    this.discontinuousExcitationControlDynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID discontinuousExcitationControlDynamicsId;

  private DiscontinuousExcitationControlDynamics discontinuousExcitationControlDynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(DiscontinuousExcitationControlDynamicsAggregate.class.getName());
}
