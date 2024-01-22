package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.aggregate;

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
 * Aggregate handler for OverexcitationLimiterDynamics as outlined for the CQRS pattern, all write
 * responsibilities related to OverexcitationLimiterDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class OverexcitationLimiterDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public OverexcitationLimiterDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public OverexcitationLimiterDynamicsAggregate(CreateOverexcitationLimiterDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateOverexcitationLimiterDynamicsCommand");
    CreateOverexcitationLimiterDynamicsEvent event =
        new CreateOverexcitationLimiterDynamicsEvent(command.getOverexcitationLimiterDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateOverexcitationLimiterDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateOverexcitationLimiterDynamicsCommand");
    UpdateOverexcitationLimiterDynamicsEvent event =
        new UpdateOverexcitationLimiterDynamicsEvent(
            command.getOverexcitationLimiterDynamicsId(),
            command.getOverexcitationLimiterDynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteOverexcitationLimiterDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteOverexcitationLimiterDynamicsCommand");
    apply(
        new DeleteOverexcitationLimiterDynamicsEvent(command.getOverexcitationLimiterDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(
      AssignOverexcitationLimiterDynamicsToOverexcitationLimiterDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignOverexcitationLimiterDynamicsToOverexcitationLimiterDynamicsCommand");

    if (overexcitationLimiterDynamics != null
        && overexcitationLimiterDynamics.getOverexcitationLimiterDynamicsId()
            == command.getAssignment().getOverexcitationLimiterDynamicsId())
      throw new ProcessingException(
          "OverexcitationLimiterDynamics already assigned with id "
              + command.getAssignment().getOverexcitationLimiterDynamicsId());

    apply(
        new AssignOverexcitationLimiterDynamicsToOverexcitationLimiterDynamicsEvent(
            command.getOverexcitationLimiterDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignOverexcitationLimiterDynamicsFromOverexcitationLimiterDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignOverexcitationLimiterDynamicsFromOverexcitationLimiterDynamicsCommand");

    if (overexcitationLimiterDynamics == null)
      throw new ProcessingException("OverexcitationLimiterDynamics already has nothing assigned.");

    apply(
        new UnAssignOverexcitationLimiterDynamicsFromOverexcitationLimiterDynamicsEvent(
            command.getOverexcitationLimiterDynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateOverexcitationLimiterDynamicsEvent event) {
    LOGGER.info("Event sourcing CreateOverexcitationLimiterDynamicsEvent");
    this.overexcitationLimiterDynamicsId = event.getOverexcitationLimiterDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateOverexcitationLimiterDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.overexcitationLimiterDynamics = event.getOverexcitationLimiterDynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignOverexcitationLimiterDynamicsToOverexcitationLimiterDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing AssignOverexcitationLimiterDynamicsToOverexcitationLimiterDynamicsEvent");
    this.overexcitationLimiterDynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOverexcitationLimiterDynamicsFromOverexcitationLimiterDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignOverexcitationLimiterDynamicsFromOverexcitationLimiterDynamicsEvent");
    this.overexcitationLimiterDynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID overexcitationLimiterDynamicsId;

  private OverexcitationLimiterDynamics overexcitationLimiterDynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(OverexcitationLimiterDynamicsAggregate.class.getName());
}
