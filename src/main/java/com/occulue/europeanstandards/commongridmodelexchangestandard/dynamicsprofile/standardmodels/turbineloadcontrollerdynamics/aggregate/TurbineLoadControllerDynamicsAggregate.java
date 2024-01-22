package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.aggregate;

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
 * Aggregate handler for TurbineLoadControllerDynamics as outlined for the CQRS pattern, all write
 * responsibilities related to TurbineLoadControllerDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TurbineLoadControllerDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TurbineLoadControllerDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TurbineLoadControllerDynamicsAggregate(CreateTurbineLoadControllerDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateTurbineLoadControllerDynamicsCommand");
    CreateTurbineLoadControllerDynamicsEvent event =
        new CreateTurbineLoadControllerDynamicsEvent(command.getTurbineLoadControllerDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTurbineLoadControllerDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateTurbineLoadControllerDynamicsCommand");
    UpdateTurbineLoadControllerDynamicsEvent event =
        new UpdateTurbineLoadControllerDynamicsEvent(
            command.getTurbineLoadControllerDynamicsId(),
            command.getTurbineLoadControllerDynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteTurbineLoadControllerDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteTurbineLoadControllerDynamicsCommand");
    apply(
        new DeleteTurbineLoadControllerDynamicsEvent(command.getTurbineLoadControllerDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(
      AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsCommand");

    if (turbineLoadControllerDynamics != null
        && turbineLoadControllerDynamics.getTurbineLoadControllerDynamicsId()
            == command.getAssignment().getTurbineLoadControllerDynamicsId())
      throw new ProcessingException(
          "TurbineLoadControllerDynamics already assigned with id "
              + command.getAssignment().getTurbineLoadControllerDynamicsId());

    apply(
        new AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsEvent(
            command.getTurbineLoadControllerDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignTurbineLoadControllerDynamicsFromTurbineLoadControllerDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignTurbineLoadControllerDynamicsFromTurbineLoadControllerDynamicsCommand");

    if (turbineLoadControllerDynamics == null)
      throw new ProcessingException("TurbineLoadControllerDynamics already has nothing assigned.");

    apply(
        new UnAssignTurbineLoadControllerDynamicsFromTurbineLoadControllerDynamicsEvent(
            command.getTurbineLoadControllerDynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTurbineLoadControllerDynamicsEvent event) {
    LOGGER.info("Event sourcing CreateTurbineLoadControllerDynamicsEvent");
    this.turbineLoadControllerDynamicsId = event.getTurbineLoadControllerDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateTurbineLoadControllerDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.turbineLoadControllerDynamics = event.getTurbineLoadControllerDynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsEvent");
    this.turbineLoadControllerDynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTurbineLoadControllerDynamicsFromTurbineLoadControllerDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignTurbineLoadControllerDynamicsFromTurbineLoadControllerDynamicsEvent");
    this.turbineLoadControllerDynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID turbineLoadControllerDynamicsId;

  private TurbineLoadControllerDynamics turbineLoadControllerDynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(TurbineLoadControllerDynamicsAggregate.class.getName());
}
