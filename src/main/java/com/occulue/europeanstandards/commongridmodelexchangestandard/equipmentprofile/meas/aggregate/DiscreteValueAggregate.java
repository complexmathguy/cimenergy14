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
 * Aggregate handler for DiscreteValue as outlined for the CQRS pattern, all write responsibilities
 * related to DiscreteValue are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DiscreteValueAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DiscreteValueAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DiscreteValueAggregate(CreateDiscreteValueCommand command) throws Exception {
    LOGGER.info("Handling command CreateDiscreteValueCommand");
    CreateDiscreteValueEvent event = new CreateDiscreteValueEvent(command.getDiscreteValueId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDiscreteValueCommand command) throws Exception {
    LOGGER.info("handling command UpdateDiscreteValueCommand");
    UpdateDiscreteValueEvent event =
        new UpdateDiscreteValueEvent(
            command.getDiscreteValueId(), command.getValue(), command.getDiscreteValues());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDiscreteValueCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDiscreteValueCommand");
    apply(new DeleteDiscreteValueEvent(command.getDiscreteValueId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToDiscreteValueCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToDiscreteValueCommand");

    if (value != null && value.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignValueToDiscreteValueEvent(command.getDiscreteValueId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromDiscreteValueCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromDiscreteValueCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromDiscreteValueEvent(command.getDiscreteValueId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignDiscreteValuesToDiscreteValueCommand command) throws Exception {
    LOGGER.info("Handling command AssignDiscreteValuesToDiscreteValueCommand");

    if (discreteValues.contains(command.getAddTo()))
      throw new ProcessingException(
          "DiscreteValues already contains an entity with id "
              + command.getAddTo().getDiscreteValueId());

    apply(
        new AssignDiscreteValuesToDiscreteValueEvent(
            command.getDiscreteValueId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveDiscreteValuesFromDiscreteValueCommand command) throws Exception {
    LOGGER.info("Handling command RemoveDiscreteValuesFromDiscreteValueCommand");

    if (!discreteValues.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "DiscreteValues does not contain an entity with id "
              + command.getRemoveFrom().getDiscreteValueId());

    apply(
        new RemoveDiscreteValuesFromDiscreteValueEvent(
            command.getDiscreteValueId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDiscreteValueEvent event) {
    LOGGER.info("Event sourcing CreateDiscreteValueEvent");
    this.discreteValueId = event.getDiscreteValueId();
  }

  @EventSourcingHandler
  void on(UpdateDiscreteValueEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.value = event.getValue();
    this.discreteValues = event.getDiscreteValues();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToDiscreteValueEvent event) {
    LOGGER.info("Event sourcing AssignValueToDiscreteValueEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromDiscreteValueEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromDiscreteValueEvent");
    this.value = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignDiscreteValuesToDiscreteValueEvent event) {
    LOGGER.info("Event sourcing AssignDiscreteValuesToDiscreteValueEvent");
    this.discreteValues.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveDiscreteValuesFromDiscreteValueEvent event) {
    LOGGER.info("Event sourcing RemoveDiscreteValuesFromDiscreteValueEvent");
    this.discreteValues.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID discreteValueId;

  private IntegerProxy value = null;
  private Set<DiscreteValue> discreteValues = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(DiscreteValueAggregate.class.getName());
}
