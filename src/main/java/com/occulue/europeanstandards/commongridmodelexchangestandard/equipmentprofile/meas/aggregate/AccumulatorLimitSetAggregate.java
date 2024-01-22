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
 * Aggregate handler for AccumulatorLimitSet as outlined for the CQRS pattern, all write
 * responsibilities related to AccumulatorLimitSet are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AccumulatorLimitSetAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AccumulatorLimitSetAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AccumulatorLimitSetAggregate(CreateAccumulatorLimitSetCommand command) throws Exception {
    LOGGER.info("Handling command CreateAccumulatorLimitSetCommand");
    CreateAccumulatorLimitSetEvent event =
        new CreateAccumulatorLimitSetEvent(command.getAccumulatorLimitSetId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAccumulatorLimitSetCommand command) throws Exception {
    LOGGER.info("handling command UpdateAccumulatorLimitSetCommand");
    UpdateAccumulatorLimitSetEvent event =
        new UpdateAccumulatorLimitSetEvent(
            command.getAccumulatorLimitSetId(), command.getLimitSets());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAccumulatorLimitSetCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAccumulatorLimitSetCommand");
    apply(new DeleteAccumulatorLimitSetEvent(command.getAccumulatorLimitSetId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignLimitSetsToAccumulatorLimitSetCommand command) throws Exception {
    LOGGER.info("Handling command AssignLimitSetsToAccumulatorLimitSetCommand");

    if (limitSets.contains(command.getAddTo()))
      throw new ProcessingException(
          "LimitSets already contains an entity with id "
              + command.getAddTo().getAccumulatorLimitSetId());

    apply(
        new AssignLimitSetsToAccumulatorLimitSetEvent(
            command.getAccumulatorLimitSetId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveLimitSetsFromAccumulatorLimitSetCommand command) throws Exception {
    LOGGER.info("Handling command RemoveLimitSetsFromAccumulatorLimitSetCommand");

    if (!limitSets.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "LimitSets does not contain an entity with id "
              + command.getRemoveFrom().getAccumulatorLimitSetId());

    apply(
        new RemoveLimitSetsFromAccumulatorLimitSetEvent(
            command.getAccumulatorLimitSetId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAccumulatorLimitSetEvent event) {
    LOGGER.info("Event sourcing CreateAccumulatorLimitSetEvent");
    this.accumulatorLimitSetId = event.getAccumulatorLimitSetId();
  }

  @EventSourcingHandler
  void on(UpdateAccumulatorLimitSetEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.limitSets = event.getLimitSets();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignLimitSetsToAccumulatorLimitSetEvent event) {
    LOGGER.info("Event sourcing AssignLimitSetsToAccumulatorLimitSetEvent");
    this.limitSets.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveLimitSetsFromAccumulatorLimitSetEvent event) {
    LOGGER.info("Event sourcing RemoveLimitSetsFromAccumulatorLimitSetEvent");
    this.limitSets.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID accumulatorLimitSetId;

  private Set<AccumulatorLimitSet> limitSets = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(AccumulatorLimitSetAggregate.class.getName());
}
