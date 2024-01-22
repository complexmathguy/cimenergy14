package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.aggregate;

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
 * Aggregate handler for TurbineGovernorDynamics as outlined for the CQRS pattern, all write
 * responsibilities related to TurbineGovernorDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TurbineGovernorDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TurbineGovernorDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TurbineGovernorDynamicsAggregate(CreateTurbineGovernorDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateTurbineGovernorDynamicsCommand");
    CreateTurbineGovernorDynamicsEvent event =
        new CreateTurbineGovernorDynamicsEvent(command.getTurbineGovernorDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTurbineGovernorDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateTurbineGovernorDynamicsCommand");
    UpdateTurbineGovernorDynamicsEvent event =
        new UpdateTurbineGovernorDynamicsEvent(
            command.getTurbineGovernorDynamicsId(), command.getTurbineGovernorDynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteTurbineGovernorDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteTurbineGovernorDynamicsCommand");
    apply(new DeleteTurbineGovernorDynamicsEvent(command.getTurbineGovernorDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignTurbineGovernorDynamicsToTurbineGovernorDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignTurbineGovernorDynamicsToTurbineGovernorDynamicsCommand");

    if (turbineGovernorDynamics != null
        && turbineGovernorDynamics.getTurbineGovernorDynamicsId()
            == command.getAssignment().getTurbineGovernorDynamicsId())
      throw new ProcessingException(
          "TurbineGovernorDynamics already assigned with id "
              + command.getAssignment().getTurbineGovernorDynamicsId());

    apply(
        new AssignTurbineGovernorDynamicsToTurbineGovernorDynamicsEvent(
            command.getTurbineGovernorDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTurbineGovernorDynamicsFromTurbineGovernorDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignTurbineGovernorDynamicsFromTurbineGovernorDynamicsCommand");

    if (turbineGovernorDynamics == null)
      throw new ProcessingException("TurbineGovernorDynamics already has nothing assigned.");

    apply(
        new UnAssignTurbineGovernorDynamicsFromTurbineGovernorDynamicsEvent(
            command.getTurbineGovernorDynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTurbineGovernorDynamicsEvent event) {
    LOGGER.info("Event sourcing CreateTurbineGovernorDynamicsEvent");
    this.turbineGovernorDynamicsId = event.getTurbineGovernorDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateTurbineGovernorDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.turbineGovernorDynamics = event.getTurbineGovernorDynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignTurbineGovernorDynamicsToTurbineGovernorDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignTurbineGovernorDynamicsToTurbineGovernorDynamicsEvent");
    this.turbineGovernorDynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTurbineGovernorDynamicsFromTurbineGovernorDynamicsEvent event) {
    LOGGER.info("Event sourcing UnAssignTurbineGovernorDynamicsFromTurbineGovernorDynamicsEvent");
    this.turbineGovernorDynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID turbineGovernorDynamicsId;

  private TurbineGovernorDynamics turbineGovernorDynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(TurbineGovernorDynamicsAggregate.class.getName());
}
