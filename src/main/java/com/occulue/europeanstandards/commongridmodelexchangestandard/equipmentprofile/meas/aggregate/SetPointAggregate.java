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
 * Aggregate handler for SetPoint as outlined for the CQRS pattern, all write responsibilities
 * related to SetPoint are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SetPointAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SetPointAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SetPointAggregate(CreateSetPointCommand command) throws Exception {
    LOGGER.info("Handling command CreateSetPointCommand");
    CreateSetPointEvent event = new CreateSetPointEvent(command.getSetPointId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSetPointCommand command) throws Exception {
    LOGGER.info("handling command UpdateSetPointCommand");
    UpdateSetPointEvent event =
        new UpdateSetPointEvent(
            command.getSetPointId(), command.getNormalValue(), command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSetPointCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSetPointCommand");
    apply(new DeleteSetPointEvent(command.getSetPointId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignNormalValueToSetPointCommand command) throws Exception {
    LOGGER.info("Handling command AssignNormalValueToSetPointCommand");

    if (normalValue != null
        && normalValue.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "NormalValue already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignNormalValueToSetPointEvent(command.getSetPointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNormalValueFromSetPointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNormalValueFromSetPointCommand");

    if (normalValue == null)
      throw new ProcessingException("NormalValue already has nothing assigned.");

    apply(new UnAssignNormalValueFromSetPointEvent(command.getSetPointId()));
  }

  @CommandHandler
  public void handle(AssignValueToSetPointCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToSetPointCommand");

    if (value != null && value.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignValueToSetPointEvent(command.getSetPointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromSetPointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromSetPointCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromSetPointEvent(command.getSetPointId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSetPointEvent event) {
    LOGGER.info("Event sourcing CreateSetPointEvent");
    this.setPointId = event.getSetPointId();
  }

  @EventSourcingHandler
  void on(UpdateSetPointEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.normalValue = event.getNormalValue();
    this.value = event.getValue();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignNormalValueToSetPointEvent event) {
    LOGGER.info("Event sourcing AssignNormalValueToSetPointEvent");
    this.normalValue = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNormalValueFromSetPointEvent event) {
    LOGGER.info("Event sourcing UnAssignNormalValueFromSetPointEvent");
    this.normalValue = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignValueToSetPointEvent event) {
    LOGGER.info("Event sourcing AssignValueToSetPointEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromSetPointEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromSetPointEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID setPointId;

  private Simple_Float normalValue = null;
  private Simple_Float value = null;

  private static final Logger LOGGER = Logger.getLogger(SetPointAggregate.class.getName());
}
