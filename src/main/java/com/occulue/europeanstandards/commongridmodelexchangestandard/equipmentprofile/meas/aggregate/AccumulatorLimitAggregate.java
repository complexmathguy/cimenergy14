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
 * Aggregate handler for AccumulatorLimit as outlined for the CQRS pattern, all write
 * responsibilities related to AccumulatorLimit are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AccumulatorLimitAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AccumulatorLimitAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AccumulatorLimitAggregate(CreateAccumulatorLimitCommand command) throws Exception {
    LOGGER.info("Handling command CreateAccumulatorLimitCommand");
    CreateAccumulatorLimitEvent event =
        new CreateAccumulatorLimitEvent(command.getAccumulatorLimitId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAccumulatorLimitCommand command) throws Exception {
    LOGGER.info("handling command UpdateAccumulatorLimitCommand");
    UpdateAccumulatorLimitEvent event =
        new UpdateAccumulatorLimitEvent(
            command.getAccumulatorLimitId(), command.getValue(), command.getLimits());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAccumulatorLimitCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAccumulatorLimitCommand");
    apply(new DeleteAccumulatorLimitEvent(command.getAccumulatorLimitId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToAccumulatorLimitCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToAccumulatorLimitCommand");

    if (value != null && value.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignValueToAccumulatorLimitEvent(
            command.getAccumulatorLimitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromAccumulatorLimitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromAccumulatorLimitCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromAccumulatorLimitEvent(command.getAccumulatorLimitId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignLimitsToAccumulatorLimitCommand command) throws Exception {
    LOGGER.info("Handling command AssignLimitsToAccumulatorLimitCommand");

    if (limits.contains(command.getAddTo()))
      throw new ProcessingException(
          "Limits already contains an entity with id "
              + command.getAddTo().getAccumulatorLimitId());

    apply(
        new AssignLimitsToAccumulatorLimitEvent(
            command.getAccumulatorLimitId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveLimitsFromAccumulatorLimitCommand command) throws Exception {
    LOGGER.info("Handling command RemoveLimitsFromAccumulatorLimitCommand");

    if (!limits.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "Limits does not contain an entity with id "
              + command.getRemoveFrom().getAccumulatorLimitId());

    apply(
        new RemoveLimitsFromAccumulatorLimitEvent(
            command.getAccumulatorLimitId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAccumulatorLimitEvent event) {
    LOGGER.info("Event sourcing CreateAccumulatorLimitEvent");
    this.accumulatorLimitId = event.getAccumulatorLimitId();
  }

  @EventSourcingHandler
  void on(UpdateAccumulatorLimitEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.value = event.getValue();
    this.limits = event.getLimits();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToAccumulatorLimitEvent event) {
    LOGGER.info("Event sourcing AssignValueToAccumulatorLimitEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromAccumulatorLimitEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromAccumulatorLimitEvent");
    this.value = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignLimitsToAccumulatorLimitEvent event) {
    LOGGER.info("Event sourcing AssignLimitsToAccumulatorLimitEvent");
    this.limits.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveLimitsFromAccumulatorLimitEvent event) {
    LOGGER.info("Event sourcing RemoveLimitsFromAccumulatorLimitEvent");
    this.limits.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID accumulatorLimitId;

  private IntegerProxy value = null;
  private Set<AccumulatorLimit> limits = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(AccumulatorLimitAggregate.class.getName());
}
