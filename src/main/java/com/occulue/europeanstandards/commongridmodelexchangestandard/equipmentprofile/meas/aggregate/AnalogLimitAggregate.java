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
 * Aggregate handler for AnalogLimit as outlined for the CQRS pattern, all write responsibilities
 * related to AnalogLimit are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AnalogLimitAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AnalogLimitAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AnalogLimitAggregate(CreateAnalogLimitCommand command) throws Exception {
    LOGGER.info("Handling command CreateAnalogLimitCommand");
    CreateAnalogLimitEvent event = new CreateAnalogLimitEvent(command.getAnalogLimitId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAnalogLimitCommand command) throws Exception {
    LOGGER.info("handling command UpdateAnalogLimitCommand");
    UpdateAnalogLimitEvent event =
        new UpdateAnalogLimitEvent(
            command.getAnalogLimitId(), command.getValue(), command.getLimits());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAnalogLimitCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAnalogLimitCommand");
    apply(new DeleteAnalogLimitEvent(command.getAnalogLimitId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToAnalogLimitCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToAnalogLimitCommand");

    if (value != null && value.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignValueToAnalogLimitEvent(command.getAnalogLimitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromAnalogLimitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromAnalogLimitCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromAnalogLimitEvent(command.getAnalogLimitId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignLimitsToAnalogLimitCommand command) throws Exception {
    LOGGER.info("Handling command AssignLimitsToAnalogLimitCommand");

    if (limits.contains(command.getAddTo()))
      throw new ProcessingException(
          "Limits already contains an entity with id " + command.getAddTo().getAnalogLimitId());

    apply(new AssignLimitsToAnalogLimitEvent(command.getAnalogLimitId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveLimitsFromAnalogLimitCommand command) throws Exception {
    LOGGER.info("Handling command RemoveLimitsFromAnalogLimitCommand");

    if (!limits.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "Limits does not contain an entity with id "
              + command.getRemoveFrom().getAnalogLimitId());

    apply(
        new RemoveLimitsFromAnalogLimitEvent(command.getAnalogLimitId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAnalogLimitEvent event) {
    LOGGER.info("Event sourcing CreateAnalogLimitEvent");
    this.analogLimitId = event.getAnalogLimitId();
  }

  @EventSourcingHandler
  void on(UpdateAnalogLimitEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.value = event.getValue();
    this.limits = event.getLimits();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToAnalogLimitEvent event) {
    LOGGER.info("Event sourcing AssignValueToAnalogLimitEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromAnalogLimitEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromAnalogLimitEvent");
    this.value = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignLimitsToAnalogLimitEvent event) {
    LOGGER.info("Event sourcing AssignLimitsToAnalogLimitEvent");
    this.limits.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveLimitsFromAnalogLimitEvent event) {
    LOGGER.info("Event sourcing RemoveLimitsFromAnalogLimitEvent");
    this.limits.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID analogLimitId;

  private Simple_Float value = null;
  private Set<AnalogLimit> limits = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(AnalogLimitAggregate.class.getName());
}
