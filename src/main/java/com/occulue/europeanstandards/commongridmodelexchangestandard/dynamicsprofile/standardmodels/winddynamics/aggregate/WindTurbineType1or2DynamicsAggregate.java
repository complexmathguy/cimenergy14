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
 * Aggregate handler for WindTurbineType1or2Dynamics as outlined for the CQRS pattern, all write
 * responsibilities related to WindTurbineType1or2Dynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindTurbineType1or2DynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindTurbineType1or2DynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindTurbineType1or2DynamicsAggregate(CreateWindTurbineType1or2DynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateWindTurbineType1or2DynamicsCommand");
    CreateWindTurbineType1or2DynamicsEvent event =
        new CreateWindTurbineType1or2DynamicsEvent(command.getWindTurbineType1or2DynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindTurbineType1or2DynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindTurbineType1or2DynamicsCommand");
    UpdateWindTurbineType1or2DynamicsEvent event =
        new UpdateWindTurbineType1or2DynamicsEvent(
            command.getWindTurbineType1or2DynamicsId(), command.getWindTurbineType1or2Dynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindTurbineType1or2DynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindTurbineType1or2DynamicsCommand");
    apply(new DeleteWindTurbineType1or2DynamicsEvent(command.getWindTurbineType1or2DynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignWindTurbineType1or2DynamicsToWindTurbineType1or2DynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignWindTurbineType1or2DynamicsToWindTurbineType1or2DynamicsCommand");

    if (windTurbineType1or2Dynamics != null
        && windTurbineType1or2Dynamics.getWindTurbineType1or2DynamicsId()
            == command.getAssignment().getWindTurbineType1or2DynamicsId())
      throw new ProcessingException(
          "WindTurbineType1or2Dynamics already assigned with id "
              + command.getAssignment().getWindTurbineType1or2DynamicsId());

    apply(
        new AssignWindTurbineType1or2DynamicsToWindTurbineType1or2DynamicsEvent(
            command.getWindTurbineType1or2DynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignWindTurbineType1or2DynamicsFromWindTurbineType1or2DynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignWindTurbineType1or2DynamicsFromWindTurbineType1or2DynamicsCommand");

    if (windTurbineType1or2Dynamics == null)
      throw new ProcessingException("WindTurbineType1or2Dynamics already has nothing assigned.");

    apply(
        new UnAssignWindTurbineType1or2DynamicsFromWindTurbineType1or2DynamicsEvent(
            command.getWindTurbineType1or2DynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindTurbineType1or2DynamicsEvent event) {
    LOGGER.info("Event sourcing CreateWindTurbineType1or2DynamicsEvent");
    this.windTurbineType1or2DynamicsId = event.getWindTurbineType1or2DynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateWindTurbineType1or2DynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.windTurbineType1or2Dynamics = event.getWindTurbineType1or2Dynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignWindTurbineType1or2DynamicsToWindTurbineType1or2DynamicsEvent event) {
    LOGGER.info(
        "Event sourcing AssignWindTurbineType1or2DynamicsToWindTurbineType1or2DynamicsEvent");
    this.windTurbineType1or2Dynamics = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWindTurbineType1or2DynamicsFromWindTurbineType1or2DynamicsEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignWindTurbineType1or2DynamicsFromWindTurbineType1or2DynamicsEvent");
    this.windTurbineType1or2Dynamics = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windTurbineType1or2DynamicsId;

  private WindTurbineType1or2Dynamics windTurbineType1or2Dynamics = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindTurbineType1or2DynamicsAggregate.class.getName());
}
