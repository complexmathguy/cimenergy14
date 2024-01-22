package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.aggregate;

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
 * Aggregate handler for WindPlantDynamics as outlined for the CQRS pattern, all write
 * responsibilities related to WindPlantDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindPlantDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindPlantDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindPlantDynamicsAggregate(CreateWindPlantDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindPlantDynamicsCommand");
    CreateWindPlantDynamicsEvent event =
        new CreateWindPlantDynamicsEvent(command.getWindPlantDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindPlantDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindPlantDynamicsCommand");
    UpdateWindPlantDynamicsEvent event =
        new UpdateWindPlantDynamicsEvent(
            command.getWindPlantDynamicsId(), command.getWindPlantDynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindPlantDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindPlantDynamicsCommand");
    apply(new DeleteWindPlantDynamicsEvent(command.getWindPlantDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignWindPlantDynamicsToWindPlantDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command AssignWindPlantDynamicsToWindPlantDynamicsCommand");

    if (windPlantDynamics != null
        && windPlantDynamics.getWindPlantDynamicsId()
            == command.getAssignment().getWindPlantDynamicsId())
      throw new ProcessingException(
          "WindPlantDynamics already assigned with id "
              + command.getAssignment().getWindPlantDynamicsId());

    apply(
        new AssignWindPlantDynamicsToWindPlantDynamicsEvent(
            command.getWindPlantDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWindPlantDynamicsFromWindPlantDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignWindPlantDynamicsFromWindPlantDynamicsCommand");

    if (windPlantDynamics == null)
      throw new ProcessingException("WindPlantDynamics already has nothing assigned.");

    apply(
        new UnAssignWindPlantDynamicsFromWindPlantDynamicsEvent(command.getWindPlantDynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindPlantDynamicsEvent event) {
    LOGGER.info("Event sourcing CreateWindPlantDynamicsEvent");
    this.windPlantDynamicsId = event.getWindPlantDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateWindPlantDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.windPlantDynamics = event.getWindPlantDynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignWindPlantDynamicsToWindPlantDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignWindPlantDynamicsToWindPlantDynamicsEvent");
    this.windPlantDynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWindPlantDynamicsFromWindPlantDynamicsEvent event) {
    LOGGER.info("Event sourcing UnAssignWindPlantDynamicsFromWindPlantDynamicsEvent");
    this.windPlantDynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windPlantDynamicsId;

  private WindPlantDynamics windPlantDynamics = null;

  private static final Logger LOGGER = Logger.getLogger(WindPlantDynamicsAggregate.class.getName());
}
