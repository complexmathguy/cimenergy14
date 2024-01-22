package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.aggregate;

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
 * Aggregate handler for DynamicsFunctionBlock as outlined for the CQRS pattern, all write
 * responsibilities related to DynamicsFunctionBlock are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DynamicsFunctionBlockAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DynamicsFunctionBlockAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DynamicsFunctionBlockAggregate(CreateDynamicsFunctionBlockCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateDynamicsFunctionBlockCommand");
    CreateDynamicsFunctionBlockEvent event =
        new CreateDynamicsFunctionBlockEvent(command.getDynamicsFunctionBlockId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDynamicsFunctionBlockCommand command) throws Exception {
    LOGGER.info("handling command UpdateDynamicsFunctionBlockCommand");
    UpdateDynamicsFunctionBlockEvent event =
        new UpdateDynamicsFunctionBlockEvent(
            command.getDynamicsFunctionBlockId(), command.getEnabled());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDynamicsFunctionBlockCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDynamicsFunctionBlockCommand");
    apply(new DeleteDynamicsFunctionBlockEvent(command.getDynamicsFunctionBlockId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEnabledToDynamicsFunctionBlockCommand command) throws Exception {
    LOGGER.info("Handling command AssignEnabledToDynamicsFunctionBlockCommand");

    if (enabled != null
        && enabled.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Enabled already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignEnabledToDynamicsFunctionBlockEvent(
            command.getDynamicsFunctionBlockId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEnabledFromDynamicsFunctionBlockCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEnabledFromDynamicsFunctionBlockCommand");

    if (enabled == null) throw new ProcessingException("Enabled already has nothing assigned.");

    apply(new UnAssignEnabledFromDynamicsFunctionBlockEvent(command.getDynamicsFunctionBlockId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDynamicsFunctionBlockEvent event) {
    LOGGER.info("Event sourcing CreateDynamicsFunctionBlockEvent");
    this.dynamicsFunctionBlockId = event.getDynamicsFunctionBlockId();
  }

  @EventSourcingHandler
  void on(UpdateDynamicsFunctionBlockEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.enabled = event.getEnabled();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEnabledToDynamicsFunctionBlockEvent event) {
    LOGGER.info("Event sourcing AssignEnabledToDynamicsFunctionBlockEvent");
    this.enabled = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEnabledFromDynamicsFunctionBlockEvent event) {
    LOGGER.info("Event sourcing UnAssignEnabledFromDynamicsFunctionBlockEvent");
    this.enabled = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID dynamicsFunctionBlockId;

  private BooleanProxy enabled = null;

  private static final Logger LOGGER =
      Logger.getLogger(DynamicsFunctionBlockAggregate.class.getName());
}
