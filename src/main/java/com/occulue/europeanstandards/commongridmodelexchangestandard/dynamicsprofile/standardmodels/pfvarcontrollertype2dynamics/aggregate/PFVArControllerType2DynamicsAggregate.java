package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.aggregate;

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
 * Aggregate handler for PFVArControllerType2Dynamics as outlined for the CQRS pattern, all write
 * responsibilities related to PFVArControllerType2Dynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PFVArControllerType2DynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PFVArControllerType2DynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PFVArControllerType2DynamicsAggregate(CreatePFVArControllerType2DynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreatePFVArControllerType2DynamicsCommand");
    CreatePFVArControllerType2DynamicsEvent event =
        new CreatePFVArControllerType2DynamicsEvent(command.getPFVArControllerType2DynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePFVArControllerType2DynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdatePFVArControllerType2DynamicsCommand");
    UpdatePFVArControllerType2DynamicsEvent event =
        new UpdatePFVArControllerType2DynamicsEvent(
            command.getPFVArControllerType2DynamicsId(), command.getPFVArControllerType2Dynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePFVArControllerType2DynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeletePFVArControllerType2DynamicsCommand");
    apply(new DeletePFVArControllerType2DynamicsEvent(command.getPFVArControllerType2DynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(
      AssignPFVArControllerType2DynamicsToPFVArControllerType2DynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignPFVArControllerType2DynamicsToPFVArControllerType2DynamicsCommand");

    if (pFVArControllerType2Dynamics != null
        && pFVArControllerType2Dynamics.getPFVArControllerType2DynamicsId()
            == command.getAssignment().getPFVArControllerType2DynamicsId())
      throw new ProcessingException(
          "PFVArControllerType2Dynamics already assigned with id "
              + command.getAssignment().getPFVArControllerType2DynamicsId());

    apply(
        new AssignPFVArControllerType2DynamicsToPFVArControllerType2DynamicsEvent(
            command.getPFVArControllerType2DynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignPFVArControllerType2DynamicsFromPFVArControllerType2DynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignPFVArControllerType2DynamicsFromPFVArControllerType2DynamicsCommand");

    if (pFVArControllerType2Dynamics == null)
      throw new ProcessingException("PFVArControllerType2Dynamics already has nothing assigned.");

    apply(
        new UnAssignPFVArControllerType2DynamicsFromPFVArControllerType2DynamicsEvent(
            command.getPFVArControllerType2DynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePFVArControllerType2DynamicsEvent event) {
    LOGGER.info("Event sourcing CreatePFVArControllerType2DynamicsEvent");
    this.pFVArControllerType2DynamicsId = event.getPFVArControllerType2DynamicsId();
  }

  @EventSourcingHandler
  void on(UpdatePFVArControllerType2DynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.pFVArControllerType2Dynamics = event.getPFVArControllerType2Dynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignPFVArControllerType2DynamicsToPFVArControllerType2DynamicsEvent event) {
    LOGGER.info(
        "Event sourcing AssignPFVArControllerType2DynamicsToPFVArControllerType2DynamicsEvent");
    this.pFVArControllerType2Dynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPFVArControllerType2DynamicsFromPFVArControllerType2DynamicsEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignPFVArControllerType2DynamicsFromPFVArControllerType2DynamicsEvent");
    this.pFVArControllerType2Dynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pFVArControllerType2DynamicsId;

  private PFVArControllerType2Dynamics pFVArControllerType2Dynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(PFVArControllerType2DynamicsAggregate.class.getName());
}
