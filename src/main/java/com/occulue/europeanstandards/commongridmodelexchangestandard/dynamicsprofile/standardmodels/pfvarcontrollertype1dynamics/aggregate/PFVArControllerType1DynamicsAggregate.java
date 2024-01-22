package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.aggregate;

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
 * Aggregate handler for PFVArControllerType1Dynamics as outlined for the CQRS pattern, all write
 * responsibilities related to PFVArControllerType1Dynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PFVArControllerType1DynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PFVArControllerType1DynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PFVArControllerType1DynamicsAggregate(CreatePFVArControllerType1DynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreatePFVArControllerType1DynamicsCommand");
    CreatePFVArControllerType1DynamicsEvent event =
        new CreatePFVArControllerType1DynamicsEvent(command.getPFVArControllerType1DynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePFVArControllerType1DynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdatePFVArControllerType1DynamicsCommand");
    UpdatePFVArControllerType1DynamicsEvent event =
        new UpdatePFVArControllerType1DynamicsEvent(
            command.getPFVArControllerType1DynamicsId(), command.getPFVArControllerType1Dynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePFVArControllerType1DynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeletePFVArControllerType1DynamicsCommand");
    apply(new DeletePFVArControllerType1DynamicsEvent(command.getPFVArControllerType1DynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(
      AssignPFVArControllerType1DynamicsToPFVArControllerType1DynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignPFVArControllerType1DynamicsToPFVArControllerType1DynamicsCommand");

    if (pFVArControllerType1Dynamics != null
        && pFVArControllerType1Dynamics.getPFVArControllerType1DynamicsId()
            == command.getAssignment().getPFVArControllerType1DynamicsId())
      throw new ProcessingException(
          "PFVArControllerType1Dynamics already assigned with id "
              + command.getAssignment().getPFVArControllerType1DynamicsId());

    apply(
        new AssignPFVArControllerType1DynamicsToPFVArControllerType1DynamicsEvent(
            command.getPFVArControllerType1DynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignPFVArControllerType1DynamicsFromPFVArControllerType1DynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignPFVArControllerType1DynamicsFromPFVArControllerType1DynamicsCommand");

    if (pFVArControllerType1Dynamics == null)
      throw new ProcessingException("PFVArControllerType1Dynamics already has nothing assigned.");

    apply(
        new UnAssignPFVArControllerType1DynamicsFromPFVArControllerType1DynamicsEvent(
            command.getPFVArControllerType1DynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePFVArControllerType1DynamicsEvent event) {
    LOGGER.info("Event sourcing CreatePFVArControllerType1DynamicsEvent");
    this.pFVArControllerType1DynamicsId = event.getPFVArControllerType1DynamicsId();
  }

  @EventSourcingHandler
  void on(UpdatePFVArControllerType1DynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.pFVArControllerType1Dynamics = event.getPFVArControllerType1Dynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignPFVArControllerType1DynamicsToPFVArControllerType1DynamicsEvent event) {
    LOGGER.info(
        "Event sourcing AssignPFVArControllerType1DynamicsToPFVArControllerType1DynamicsEvent");
    this.pFVArControllerType1Dynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPFVArControllerType1DynamicsFromPFVArControllerType1DynamicsEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignPFVArControllerType1DynamicsFromPFVArControllerType1DynamicsEvent");
    this.pFVArControllerType1Dynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pFVArControllerType1DynamicsId;

  private PFVArControllerType1Dynamics pFVArControllerType1Dynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(PFVArControllerType1DynamicsAggregate.class.getName());
}
