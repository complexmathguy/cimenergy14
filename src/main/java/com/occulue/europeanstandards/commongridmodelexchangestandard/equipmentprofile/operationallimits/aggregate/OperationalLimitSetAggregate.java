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
 * Aggregate handler for OperationalLimitSet as outlined for the CQRS pattern, all write
 * responsibilities related to OperationalLimitSet are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class OperationalLimitSetAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public OperationalLimitSetAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public OperationalLimitSetAggregate(CreateOperationalLimitSetCommand command) throws Exception {
    LOGGER.info("Handling command CreateOperationalLimitSetCommand");
    CreateOperationalLimitSetEvent event =
        new CreateOperationalLimitSetEvent(command.getOperationalLimitSetId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateOperationalLimitSetCommand command) throws Exception {
    LOGGER.info("handling command UpdateOperationalLimitSetCommand");
    UpdateOperationalLimitSetEvent event =
        new UpdateOperationalLimitSetEvent(
            command.getOperationalLimitSetId(), command.getOperationalLimitSet());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteOperationalLimitSetCommand command) throws Exception {
    LOGGER.info("Handling command DeleteOperationalLimitSetCommand");
    apply(new DeleteOperationalLimitSetEvent(command.getOperationalLimitSetId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignOperationalLimitSetToOperationalLimitSetCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignOperationalLimitSetToOperationalLimitSetCommand");

    if (operationalLimitSet.contains(command.getAddTo()))
      throw new ProcessingException(
          "OperationalLimitSet already contains an entity with id "
              + command.getAddTo().getOperationalLimitSetId());

    apply(
        new AssignOperationalLimitSetToOperationalLimitSetEvent(
            command.getOperationalLimitSetId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveOperationalLimitSetFromOperationalLimitSetCommand command)
      throws Exception {
    LOGGER.info("Handling command RemoveOperationalLimitSetFromOperationalLimitSetCommand");

    if (!operationalLimitSet.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "OperationalLimitSet does not contain an entity with id "
              + command.getRemoveFrom().getOperationalLimitSetId());

    apply(
        new RemoveOperationalLimitSetFromOperationalLimitSetEvent(
            command.getOperationalLimitSetId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateOperationalLimitSetEvent event) {
    LOGGER.info("Event sourcing CreateOperationalLimitSetEvent");
    this.operationalLimitSetId = event.getOperationalLimitSetId();
  }

  @EventSourcingHandler
  void on(UpdateOperationalLimitSetEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.operationalLimitSet = event.getOperationalLimitSet();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignOperationalLimitSetToOperationalLimitSetEvent event) {
    LOGGER.info("Event sourcing AssignOperationalLimitSetToOperationalLimitSetEvent");
    this.operationalLimitSet.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveOperationalLimitSetFromOperationalLimitSetEvent event) {
    LOGGER.info("Event sourcing RemoveOperationalLimitSetFromOperationalLimitSetEvent");
    this.operationalLimitSet.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID operationalLimitSetId;

  private Set<OperationalLimitSet> operationalLimitSet = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(OperationalLimitSetAggregate.class.getName());
}
