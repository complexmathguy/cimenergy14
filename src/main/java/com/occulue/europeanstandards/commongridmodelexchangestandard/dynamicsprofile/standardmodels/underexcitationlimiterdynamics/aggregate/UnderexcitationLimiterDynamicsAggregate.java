package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.aggregate;

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
 * Aggregate handler for UnderexcitationLimiterDynamics as outlined for the CQRS pattern, all write
 * responsibilities related to UnderexcitationLimiterDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class UnderexcitationLimiterDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public UnderexcitationLimiterDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public UnderexcitationLimiterDynamicsAggregate(
      CreateUnderexcitationLimiterDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command CreateUnderexcitationLimiterDynamicsCommand");
    CreateUnderexcitationLimiterDynamicsEvent event =
        new CreateUnderexcitationLimiterDynamicsEvent(
            command.getUnderexcitationLimiterDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateUnderexcitationLimiterDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateUnderexcitationLimiterDynamicsCommand");
    UpdateUnderexcitationLimiterDynamicsEvent event =
        new UpdateUnderexcitationLimiterDynamicsEvent(
            command.getUnderexcitationLimiterDynamicsId(),
            command.getUnderexcitationLimiterDynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteUnderexcitationLimiterDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteUnderexcitationLimiterDynamicsCommand");
    apply(
        new DeleteUnderexcitationLimiterDynamicsEvent(
            command.getUnderexcitationLimiterDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(
      AssignUnderexcitationLimiterDynamicsToUnderexcitationLimiterDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignUnderexcitationLimiterDynamicsToUnderexcitationLimiterDynamicsCommand");

    if (underexcitationLimiterDynamics != null
        && underexcitationLimiterDynamics.getUnderexcitationLimiterDynamicsId()
            == command.getAssignment().getUnderexcitationLimiterDynamicsId())
      throw new ProcessingException(
          "UnderexcitationLimiterDynamics already assigned with id "
              + command.getAssignment().getUnderexcitationLimiterDynamicsId());

    apply(
        new AssignUnderexcitationLimiterDynamicsToUnderexcitationLimiterDynamicsEvent(
            command.getUnderexcitationLimiterDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignUnderexcitationLimiterDynamicsFromUnderexcitationLimiterDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignUnderexcitationLimiterDynamicsFromUnderexcitationLimiterDynamicsCommand");

    if (underexcitationLimiterDynamics == null)
      throw new ProcessingException("UnderexcitationLimiterDynamics already has nothing assigned.");

    apply(
        new UnAssignUnderexcitationLimiterDynamicsFromUnderexcitationLimiterDynamicsEvent(
            command.getUnderexcitationLimiterDynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateUnderexcitationLimiterDynamicsEvent event) {
    LOGGER.info("Event sourcing CreateUnderexcitationLimiterDynamicsEvent");
    this.underexcitationLimiterDynamicsId = event.getUnderexcitationLimiterDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateUnderexcitationLimiterDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.underexcitationLimiterDynamics = event.getUnderexcitationLimiterDynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignUnderexcitationLimiterDynamicsToUnderexcitationLimiterDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing AssignUnderexcitationLimiterDynamicsToUnderexcitationLimiterDynamicsEvent");
    this.underexcitationLimiterDynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUnderexcitationLimiterDynamicsFromUnderexcitationLimiterDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignUnderexcitationLimiterDynamicsFromUnderexcitationLimiterDynamicsEvent");
    this.underexcitationLimiterDynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID underexcitationLimiterDynamicsId;

  private UnderexcitationLimiterDynamics underexcitationLimiterDynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(UnderexcitationLimiterDynamicsAggregate.class.getName());
}
