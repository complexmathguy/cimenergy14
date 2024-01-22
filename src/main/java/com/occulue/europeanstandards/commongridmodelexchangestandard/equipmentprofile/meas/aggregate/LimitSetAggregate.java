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
 * Aggregate handler for LimitSet as outlined for the CQRS pattern, all write responsibilities
 * related to LimitSet are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class LimitSetAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public LimitSetAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public LimitSetAggregate(CreateLimitSetCommand command) throws Exception {
    LOGGER.info("Handling command CreateLimitSetCommand");
    CreateLimitSetEvent event = new CreateLimitSetEvent(command.getLimitSetId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateLimitSetCommand command) throws Exception {
    LOGGER.info("handling command UpdateLimitSetCommand");
    UpdateLimitSetEvent event =
        new UpdateLimitSetEvent(command.getLimitSetId(), command.getPercentageLimitsFlag());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteLimitSetCommand command) throws Exception {
    LOGGER.info("Handling command DeleteLimitSetCommand");
    apply(new DeleteLimitSetEvent(command.getLimitSetId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignPercentageLimitsFlagToLimitSetCommand command) throws Exception {
    LOGGER.info("Handling command AssignPercentageLimitsFlagToLimitSetCommand");

    if (percentageLimitsFlag != null
        && percentageLimitsFlag.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "PercentageLimitsFlag already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignPercentageLimitsFlagToLimitSetEvent(
            command.getLimitSetId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPercentageLimitsFlagFromLimitSetCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPercentageLimitsFlagFromLimitSetCommand");

    if (percentageLimitsFlag == null)
      throw new ProcessingException("PercentageLimitsFlag already has nothing assigned.");

    apply(new UnAssignPercentageLimitsFlagFromLimitSetEvent(command.getLimitSetId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateLimitSetEvent event) {
    LOGGER.info("Event sourcing CreateLimitSetEvent");
    this.limitSetId = event.getLimitSetId();
  }

  @EventSourcingHandler
  void on(UpdateLimitSetEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.percentageLimitsFlag = event.getPercentageLimitsFlag();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignPercentageLimitsFlagToLimitSetEvent event) {
    LOGGER.info("Event sourcing AssignPercentageLimitsFlagToLimitSetEvent");
    this.percentageLimitsFlag = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPercentageLimitsFlagFromLimitSetEvent event) {
    LOGGER.info("Event sourcing UnAssignPercentageLimitsFlagFromLimitSetEvent");
    this.percentageLimitsFlag = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID limitSetId;

  private BooleanProxy percentageLimitsFlag = null;

  private static final Logger LOGGER = Logger.getLogger(LimitSetAggregate.class.getName());
}
