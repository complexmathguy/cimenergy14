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
 * Aggregate handler for AnalogControl as outlined for the CQRS pattern, all write responsibilities
 * related to AnalogControl are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AnalogControlAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AnalogControlAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AnalogControlAggregate(CreateAnalogControlCommand command) throws Exception {
    LOGGER.info("Handling command CreateAnalogControlCommand");
    CreateAnalogControlEvent event = new CreateAnalogControlEvent(command.getAnalogControlId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAnalogControlCommand command) throws Exception {
    LOGGER.info("handling command UpdateAnalogControlCommand");
    UpdateAnalogControlEvent event =
        new UpdateAnalogControlEvent(
            command.getAnalogControlId(),
            command.getMaxValue(),
            command.getMinValue(),
            command.getAnalogControl());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAnalogControlCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAnalogControlCommand");
    apply(new DeleteAnalogControlEvent(command.getAnalogControlId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignMaxValueToAnalogControlCommand command) throws Exception {
    LOGGER.info("Handling command AssignMaxValueToAnalogControlCommand");

    if (maxValue != null
        && maxValue.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "MaxValue already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignMaxValueToAnalogControlEvent(
            command.getAnalogControlId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxValueFromAnalogControlCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxValueFromAnalogControlCommand");

    if (maxValue == null) throw new ProcessingException("MaxValue already has nothing assigned.");

    apply(new UnAssignMaxValueFromAnalogControlEvent(command.getAnalogControlId()));
  }

  @CommandHandler
  public void handle(AssignMinValueToAnalogControlCommand command) throws Exception {
    LOGGER.info("Handling command AssignMinValueToAnalogControlCommand");

    if (minValue != null
        && minValue.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "MinValue already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignMinValueToAnalogControlEvent(
            command.getAnalogControlId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinValueFromAnalogControlCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMinValueFromAnalogControlCommand");

    if (minValue == null) throw new ProcessingException("MinValue already has nothing assigned.");

    apply(new UnAssignMinValueFromAnalogControlEvent(command.getAnalogControlId()));
  }

  @CommandHandler
  public void handle(AssignAnalogControlToAnalogControlCommand command) throws Exception {
    LOGGER.info("Handling command AssignAnalogControlToAnalogControlCommand");

    if (analogControl != null
        && analogControl.getAnalogControlId() == command.getAssignment().getAnalogControlId())
      throw new ProcessingException(
          "AnalogControl already assigned with id " + command.getAssignment().getAnalogControlId());

    apply(
        new AssignAnalogControlToAnalogControlEvent(
            command.getAnalogControlId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAnalogControlFromAnalogControlCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAnalogControlFromAnalogControlCommand");

    if (analogControl == null)
      throw new ProcessingException("AnalogControl already has nothing assigned.");

    apply(new UnAssignAnalogControlFromAnalogControlEvent(command.getAnalogControlId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAnalogControlEvent event) {
    LOGGER.info("Event sourcing CreateAnalogControlEvent");
    this.analogControlId = event.getAnalogControlId();
  }

  @EventSourcingHandler
  void on(UpdateAnalogControlEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.maxValue = event.getMaxValue();
    this.minValue = event.getMinValue();
    this.analogControl = event.getAnalogControl();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignMaxValueToAnalogControlEvent event) {
    LOGGER.info("Event sourcing AssignMaxValueToAnalogControlEvent");
    this.maxValue = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxValueFromAnalogControlEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxValueFromAnalogControlEvent");
    this.maxValue = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinValueToAnalogControlEvent event) {
    LOGGER.info("Event sourcing AssignMinValueToAnalogControlEvent");
    this.minValue = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinValueFromAnalogControlEvent event) {
    LOGGER.info("Event sourcing UnAssignMinValueFromAnalogControlEvent");
    this.minValue = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignAnalogControlToAnalogControlEvent event) {
    LOGGER.info("Event sourcing AssignAnalogControlToAnalogControlEvent");
    this.analogControl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAnalogControlFromAnalogControlEvent event) {
    LOGGER.info("Event sourcing UnAssignAnalogControlFromAnalogControlEvent");
    this.analogControl = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID analogControlId;

  private Simple_Float maxValue = null;
  private Simple_Float minValue = null;
  private AnalogControl analogControl = null;

  private static final Logger LOGGER = Logger.getLogger(AnalogControlAggregate.class.getName());
}
