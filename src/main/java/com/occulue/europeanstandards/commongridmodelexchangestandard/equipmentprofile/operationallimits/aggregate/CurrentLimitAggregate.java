package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.aggregate;

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
 * Aggregate handler for CurrentLimit as outlined for the CQRS pattern, all write responsibilities
 * related to CurrentLimit are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class CurrentLimitAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public CurrentLimitAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public CurrentLimitAggregate(CreateCurrentLimitCommand command) throws Exception {
    LOGGER.info("Handling command CreateCurrentLimitCommand");
    CreateCurrentLimitEvent event = new CreateCurrentLimitEvent(command.getCurrentLimitId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateCurrentLimitCommand command) throws Exception {
    LOGGER.info("handling command UpdateCurrentLimitCommand");
    UpdateCurrentLimitEvent event =
        new UpdateCurrentLimitEvent(command.getCurrentLimitId(), command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteCurrentLimitCommand command) throws Exception {
    LOGGER.info("Handling command DeleteCurrentLimitCommand");
    apply(new DeleteCurrentLimitEvent(command.getCurrentLimitId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToCurrentLimitCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToCurrentLimitCommand");

    if (value != null && value.getCurrentFlowId() == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getCurrentFlowId());

    apply(new AssignValueToCurrentLimitEvent(command.getCurrentLimitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromCurrentLimitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromCurrentLimitCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromCurrentLimitEvent(command.getCurrentLimitId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateCurrentLimitEvent event) {
    LOGGER.info("Event sourcing CreateCurrentLimitEvent");
    this.currentLimitId = event.getCurrentLimitId();
  }

  @EventSourcingHandler
  void on(UpdateCurrentLimitEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.value = event.getValue();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToCurrentLimitEvent event) {
    LOGGER.info("Event sourcing AssignValueToCurrentLimitEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromCurrentLimitEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromCurrentLimitEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID currentLimitId;

  private CurrentFlow value = null;

  private static final Logger LOGGER = Logger.getLogger(CurrentLimitAggregate.class.getName());
}
