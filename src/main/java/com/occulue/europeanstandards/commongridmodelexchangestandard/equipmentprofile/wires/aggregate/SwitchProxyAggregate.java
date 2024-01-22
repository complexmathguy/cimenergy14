package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.aggregate;

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
 * Aggregate handler for SwitchProxy as outlined for the CQRS pattern, all write responsibilities
 * related to SwitchProxy are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SwitchProxyAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SwitchProxyAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SwitchProxyAggregate(CreateSwitchProxyCommand command) throws Exception {
    LOGGER.info("Handling command CreateSwitchProxyCommand");
    CreateSwitchProxyEvent event = new CreateSwitchProxyEvent(command.getSwitchProxyId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSwitchProxyCommand command) throws Exception {
    LOGGER.info("handling command UpdateSwitchProxyCommand");
    UpdateSwitchProxyEvent event =
        new UpdateSwitchProxyEvent(
            command.getSwitchProxyId(),
            command.getNormalOpen(),
            command.getRatedCurrent(),
            command.getRetained());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSwitchProxyCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSwitchProxyCommand");
    apply(new DeleteSwitchProxyEvent(command.getSwitchProxyId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignNormalOpenToSwitchProxyCommand command) throws Exception {
    LOGGER.info("Handling command AssignNormalOpenToSwitchProxyCommand");

    if (normalOpen != null
        && normalOpen.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "NormalOpen already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignNormalOpenToSwitchProxyEvent(
            command.getSwitchProxyId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNormalOpenFromSwitchProxyCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNormalOpenFromSwitchProxyCommand");

    if (normalOpen == null)
      throw new ProcessingException("NormalOpen already has nothing assigned.");

    apply(new UnAssignNormalOpenFromSwitchProxyEvent(command.getSwitchProxyId()));
  }

  @CommandHandler
  public void handle(AssignRatedCurrentToSwitchProxyCommand command) throws Exception {
    LOGGER.info("Handling command AssignRatedCurrentToSwitchProxyCommand");

    if (ratedCurrent != null
        && ratedCurrent.getCurrentFlowId() == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "RatedCurrent already assigned with id " + command.getAssignment().getCurrentFlowId());

    apply(
        new AssignRatedCurrentToSwitchProxyEvent(
            command.getSwitchProxyId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRatedCurrentFromSwitchProxyCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRatedCurrentFromSwitchProxyCommand");

    if (ratedCurrent == null)
      throw new ProcessingException("RatedCurrent already has nothing assigned.");

    apply(new UnAssignRatedCurrentFromSwitchProxyEvent(command.getSwitchProxyId()));
  }

  @CommandHandler
  public void handle(AssignRetainedToSwitchProxyCommand command) throws Exception {
    LOGGER.info("Handling command AssignRetainedToSwitchProxyCommand");

    if (retained != null
        && retained.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Retained already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignRetainedToSwitchProxyEvent(command.getSwitchProxyId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRetainedFromSwitchProxyCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRetainedFromSwitchProxyCommand");

    if (retained == null) throw new ProcessingException("Retained already has nothing assigned.");

    apply(new UnAssignRetainedFromSwitchProxyEvent(command.getSwitchProxyId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSwitchProxyEvent event) {
    LOGGER.info("Event sourcing CreateSwitchProxyEvent");
    this.switchProxyId = event.getSwitchProxyId();
  }

  @EventSourcingHandler
  void on(UpdateSwitchProxyEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.normalOpen = event.getNormalOpen();
    this.ratedCurrent = event.getRatedCurrent();
    this.retained = event.getRetained();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignNormalOpenToSwitchProxyEvent event) {
    LOGGER.info("Event sourcing AssignNormalOpenToSwitchProxyEvent");
    this.normalOpen = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNormalOpenFromSwitchProxyEvent event) {
    LOGGER.info("Event sourcing UnAssignNormalOpenFromSwitchProxyEvent");
    this.normalOpen = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRatedCurrentToSwitchProxyEvent event) {
    LOGGER.info("Event sourcing AssignRatedCurrentToSwitchProxyEvent");
    this.ratedCurrent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRatedCurrentFromSwitchProxyEvent event) {
    LOGGER.info("Event sourcing UnAssignRatedCurrentFromSwitchProxyEvent");
    this.ratedCurrent = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRetainedToSwitchProxyEvent event) {
    LOGGER.info("Event sourcing AssignRetainedToSwitchProxyEvent");
    this.retained = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRetainedFromSwitchProxyEvent event) {
    LOGGER.info("Event sourcing UnAssignRetainedFromSwitchProxyEvent");
    this.retained = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID switchProxyId;

  private BooleanProxy normalOpen = null;
  private CurrentFlow ratedCurrent = null;
  private BooleanProxy retained = null;

  private static final Logger LOGGER = Logger.getLogger(SwitchProxyAggregate.class.getName());
}
