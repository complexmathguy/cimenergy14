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
 * Aggregate handler for StringMeasurementValue as outlined for the CQRS pattern, all write
 * responsibilities related to StringMeasurementValue are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class StringMeasurementValueAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public StringMeasurementValueAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public StringMeasurementValueAggregate(CreateStringMeasurementValueCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateStringMeasurementValueCommand");
    CreateStringMeasurementValueEvent event =
        new CreateStringMeasurementValueEvent(command.getStringMeasurementValueId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateStringMeasurementValueCommand command) throws Exception {
    LOGGER.info("handling command UpdateStringMeasurementValueCommand");
    UpdateStringMeasurementValueEvent event =
        new UpdateStringMeasurementValueEvent(
            command.getStringMeasurementValueId(),
            command.getValue(),
            command.getStringMeasurementValues());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteStringMeasurementValueCommand command) throws Exception {
    LOGGER.info("Handling command DeleteStringMeasurementValueCommand");
    apply(new DeleteStringMeasurementValueEvent(command.getStringMeasurementValueId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToStringMeasurementValueCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToStringMeasurementValueCommand");

    if (value != null && value.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignValueToStringMeasurementValueEvent(
            command.getStringMeasurementValueId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromStringMeasurementValueCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromStringMeasurementValueCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromStringMeasurementValueEvent(command.getStringMeasurementValueId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignStringMeasurementValuesToStringMeasurementValueCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignStringMeasurementValuesToStringMeasurementValueCommand");

    if (stringMeasurementValues.contains(command.getAddTo()))
      throw new ProcessingException(
          "StringMeasurementValues already contains an entity with id "
              + command.getAddTo().getStringMeasurementValueId());

    apply(
        new AssignStringMeasurementValuesToStringMeasurementValueEvent(
            command.getStringMeasurementValueId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveStringMeasurementValuesFromStringMeasurementValueCommand command)
      throws Exception {
    LOGGER.info("Handling command RemoveStringMeasurementValuesFromStringMeasurementValueCommand");

    if (!stringMeasurementValues.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "StringMeasurementValues does not contain an entity with id "
              + command.getRemoveFrom().getStringMeasurementValueId());

    apply(
        new RemoveStringMeasurementValuesFromStringMeasurementValueEvent(
            command.getStringMeasurementValueId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateStringMeasurementValueEvent event) {
    LOGGER.info("Event sourcing CreateStringMeasurementValueEvent");
    this.stringMeasurementValueId = event.getStringMeasurementValueId();
  }

  @EventSourcingHandler
  void on(UpdateStringMeasurementValueEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.value = event.getValue();
    this.stringMeasurementValues = event.getStringMeasurementValues();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToStringMeasurementValueEvent event) {
    LOGGER.info("Event sourcing AssignValueToStringMeasurementValueEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromStringMeasurementValueEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromStringMeasurementValueEvent");
    this.value = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignStringMeasurementValuesToStringMeasurementValueEvent event) {
    LOGGER.info("Event sourcing AssignStringMeasurementValuesToStringMeasurementValueEvent");
    this.stringMeasurementValues.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveStringMeasurementValuesFromStringMeasurementValueEvent event) {
    LOGGER.info("Event sourcing RemoveStringMeasurementValuesFromStringMeasurementValueEvent");
    this.stringMeasurementValues.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID stringMeasurementValueId;

  private StringProxy value = null;
  private Set<StringMeasurementValue> stringMeasurementValues = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(StringMeasurementValueAggregate.class.getName());
}
