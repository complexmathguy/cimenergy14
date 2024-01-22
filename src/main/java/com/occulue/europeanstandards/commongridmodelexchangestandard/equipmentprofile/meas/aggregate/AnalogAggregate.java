package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.aggregate;

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
 * Aggregate handler for Analog as outlined for the CQRS pattern, all write responsibilities related
 * to Analog are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AnalogAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AnalogAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AnalogAggregate(CreateAnalogCommand command) throws Exception {
    LOGGER.info("Handling command CreateAnalogCommand");
    CreateAnalogEvent event = new CreateAnalogEvent(command.getAnalogId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAnalogCommand command) throws Exception {
    LOGGER.info("handling command UpdateAnalogCommand");
    UpdateAnalogEvent event =
        new UpdateAnalogEvent(command.getAnalogId(), command.getPositiveFlowIn());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAnalogCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAnalogCommand");
    apply(new DeleteAnalogEvent(command.getAnalogId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignPositiveFlowInToAnalogCommand command) throws Exception {
    LOGGER.info("Handling command AssignPositiveFlowInToAnalogCommand");

    if (positiveFlowIn != null
        && positiveFlowIn.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "PositiveFlowIn already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignPositiveFlowInToAnalogEvent(command.getAnalogId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPositiveFlowInFromAnalogCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPositiveFlowInFromAnalogCommand");

    if (positiveFlowIn == null)
      throw new ProcessingException("PositiveFlowIn already has nothing assigned.");

    apply(new UnAssignPositiveFlowInFromAnalogEvent(command.getAnalogId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAnalogEvent event) {
    LOGGER.info("Event sourcing CreateAnalogEvent");
    this.analogId = event.getAnalogId();
  }

  @EventSourcingHandler
  void on(UpdateAnalogEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.positiveFlowIn = event.getPositiveFlowIn();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignPositiveFlowInToAnalogEvent event) {
    LOGGER.info("Event sourcing AssignPositiveFlowInToAnalogEvent");
    this.positiveFlowIn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPositiveFlowInFromAnalogEvent event) {
    LOGGER.info("Event sourcing UnAssignPositiveFlowInFromAnalogEvent");
    this.positiveFlowIn = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID analogId;

  private BooleanProxy positiveFlowIn = null;

  private static final Logger LOGGER = Logger.getLogger(AnalogAggregate.class.getName());
}
