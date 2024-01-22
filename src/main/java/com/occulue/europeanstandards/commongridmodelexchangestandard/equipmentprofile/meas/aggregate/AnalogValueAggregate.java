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
 * Aggregate handler for AnalogValue as outlined for the CQRS pattern, all write responsibilities
 * related to AnalogValue are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AnalogValueAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AnalogValueAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AnalogValueAggregate(CreateAnalogValueCommand command) throws Exception {
    LOGGER.info("Handling command CreateAnalogValueCommand");
    CreateAnalogValueEvent event = new CreateAnalogValueEvent(command.getAnalogValueId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAnalogValueCommand command) throws Exception {
    LOGGER.info("handling command UpdateAnalogValueCommand");
    UpdateAnalogValueEvent event =
        new UpdateAnalogValueEvent(
            command.getAnalogValueId(), command.getValue(), command.getAnalogValues());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAnalogValueCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAnalogValueCommand");
    apply(new DeleteAnalogValueEvent(command.getAnalogValueId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToAnalogValueCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToAnalogValueCommand");

    if (value != null && value.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignValueToAnalogValueEvent(command.getAnalogValueId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromAnalogValueCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromAnalogValueCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromAnalogValueEvent(command.getAnalogValueId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignAnalogValuesToAnalogValueCommand command) throws Exception {
    LOGGER.info("Handling command AssignAnalogValuesToAnalogValueCommand");

    if (analogValues.contains(command.getAddTo()))
      throw new ProcessingException(
          "AnalogValues already contains an entity with id "
              + command.getAddTo().getAnalogValueId());

    apply(new AssignAnalogValuesToAnalogValueEvent(command.getAnalogValueId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveAnalogValuesFromAnalogValueCommand command) throws Exception {
    LOGGER.info("Handling command RemoveAnalogValuesFromAnalogValueCommand");

    if (!analogValues.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "AnalogValues does not contain an entity with id "
              + command.getRemoveFrom().getAnalogValueId());

    apply(
        new RemoveAnalogValuesFromAnalogValueEvent(
            command.getAnalogValueId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAnalogValueEvent event) {
    LOGGER.info("Event sourcing CreateAnalogValueEvent");
    this.analogValueId = event.getAnalogValueId();
  }

  @EventSourcingHandler
  void on(UpdateAnalogValueEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.value = event.getValue();
    this.analogValues = event.getAnalogValues();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToAnalogValueEvent event) {
    LOGGER.info("Event sourcing AssignValueToAnalogValueEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromAnalogValueEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromAnalogValueEvent");
    this.value = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignAnalogValuesToAnalogValueEvent event) {
    LOGGER.info("Event sourcing AssignAnalogValuesToAnalogValueEvent");
    this.analogValues.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveAnalogValuesFromAnalogValueEvent event) {
    LOGGER.info("Event sourcing RemoveAnalogValuesFromAnalogValueEvent");
    this.analogValues.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID analogValueId;

  private Simple_Float value = null;
  private Set<AnalogValue> analogValues = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(AnalogValueAggregate.class.getName());
}
