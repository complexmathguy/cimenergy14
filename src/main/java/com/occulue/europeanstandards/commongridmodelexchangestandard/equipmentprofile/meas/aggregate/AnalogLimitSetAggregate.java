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
 * Aggregate handler for AnalogLimitSet as outlined for the CQRS pattern, all write responsibilities
 * related to AnalogLimitSet are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AnalogLimitSetAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AnalogLimitSetAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AnalogLimitSetAggregate(CreateAnalogLimitSetCommand command) throws Exception {
    LOGGER.info("Handling command CreateAnalogLimitSetCommand");
    CreateAnalogLimitSetEvent event = new CreateAnalogLimitSetEvent(command.getAnalogLimitSetId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAnalogLimitSetCommand command) throws Exception {
    LOGGER.info("handling command UpdateAnalogLimitSetCommand");
    UpdateAnalogLimitSetEvent event =
        new UpdateAnalogLimitSetEvent(command.getAnalogLimitSetId(), command.getLimitSets());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAnalogLimitSetCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAnalogLimitSetCommand");
    apply(new DeleteAnalogLimitSetEvent(command.getAnalogLimitSetId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignLimitSetsToAnalogLimitSetCommand command) throws Exception {
    LOGGER.info("Handling command AssignLimitSetsToAnalogLimitSetCommand");

    if (limitSets.contains(command.getAddTo()))
      throw new ProcessingException(
          "LimitSets already contains an entity with id "
              + command.getAddTo().getAnalogLimitSetId());

    apply(
        new AssignLimitSetsToAnalogLimitSetEvent(
            command.getAnalogLimitSetId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveLimitSetsFromAnalogLimitSetCommand command) throws Exception {
    LOGGER.info("Handling command RemoveLimitSetsFromAnalogLimitSetCommand");

    if (!limitSets.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "LimitSets does not contain an entity with id "
              + command.getRemoveFrom().getAnalogLimitSetId());

    apply(
        new RemoveLimitSetsFromAnalogLimitSetEvent(
            command.getAnalogLimitSetId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAnalogLimitSetEvent event) {
    LOGGER.info("Event sourcing CreateAnalogLimitSetEvent");
    this.analogLimitSetId = event.getAnalogLimitSetId();
  }

  @EventSourcingHandler
  void on(UpdateAnalogLimitSetEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.limitSets = event.getLimitSets();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignLimitSetsToAnalogLimitSetEvent event) {
    LOGGER.info("Event sourcing AssignLimitSetsToAnalogLimitSetEvent");
    this.limitSets.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveLimitSetsFromAnalogLimitSetEvent event) {
    LOGGER.info("Event sourcing RemoveLimitSetsFromAnalogLimitSetEvent");
    this.limitSets.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID analogLimitSetId;

  private Set<AnalogLimitSet> limitSets = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(AnalogLimitSetAggregate.class.getName());
}
