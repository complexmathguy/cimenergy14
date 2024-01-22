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
 * Aggregate handler for OperationalLimitType as outlined for the CQRS pattern, all write
 * responsibilities related to OperationalLimitType are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class OperationalLimitTypeAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public OperationalLimitTypeAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public OperationalLimitTypeAggregate(CreateOperationalLimitTypeCommand command) throws Exception {
    LOGGER.info("Handling command CreateOperationalLimitTypeCommand");
    CreateOperationalLimitTypeEvent event =
        new CreateOperationalLimitTypeEvent(
            command.getOperationalLimitTypeId(), command.getDirection(), command.getLimitType());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateOperationalLimitTypeCommand command) throws Exception {
    LOGGER.info("handling command UpdateOperationalLimitTypeCommand");
    UpdateOperationalLimitTypeEvent event =
        new UpdateOperationalLimitTypeEvent(
            command.getOperationalLimitTypeId(),
            command.getAcceptableDuration(),
            command.getDirection(),
            command.getLimitType());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteOperationalLimitTypeCommand command) throws Exception {
    LOGGER.info("Handling command DeleteOperationalLimitTypeCommand");
    apply(new DeleteOperationalLimitTypeEvent(command.getOperationalLimitTypeId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAcceptableDurationToOperationalLimitTypeCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignAcceptableDurationToOperationalLimitTypeCommand");

    if (acceptableDuration != null
        && acceptableDuration.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "AcceptableDuration already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignAcceptableDurationToOperationalLimitTypeEvent(
            command.getOperationalLimitTypeId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAcceptableDurationFromOperationalLimitTypeCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignAcceptableDurationFromOperationalLimitTypeCommand");

    if (acceptableDuration == null)
      throw new ProcessingException("AcceptableDuration already has nothing assigned.");

    apply(
        new UnAssignAcceptableDurationFromOperationalLimitTypeEvent(
            command.getOperationalLimitTypeId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateOperationalLimitTypeEvent event) {
    LOGGER.info("Event sourcing CreateOperationalLimitTypeEvent");
    this.operationalLimitTypeId = event.getOperationalLimitTypeId();
    this.direction = event.getDirection();
    this.limitType = event.getLimitType();
  }

  @EventSourcingHandler
  void on(UpdateOperationalLimitTypeEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.acceptableDuration = event.getAcceptableDuration();
    this.direction = event.getDirection();
    this.limitType = event.getLimitType();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAcceptableDurationToOperationalLimitTypeEvent event) {
    LOGGER.info("Event sourcing AssignAcceptableDurationToOperationalLimitTypeEvent");
    this.acceptableDuration = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAcceptableDurationFromOperationalLimitTypeEvent event) {
    LOGGER.info("Event sourcing UnAssignAcceptableDurationFromOperationalLimitTypeEvent");
    this.acceptableDuration = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID operationalLimitTypeId;

  private OperationalLimitDirectionKind direction;
  private LimitTypeEnum limitType;
  private Seconds acceptableDuration = null;

  private static final Logger LOGGER =
      Logger.getLogger(OperationalLimitTypeAggregate.class.getName());
}
