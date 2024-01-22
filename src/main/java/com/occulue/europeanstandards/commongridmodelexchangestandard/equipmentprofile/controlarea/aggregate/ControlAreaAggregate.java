package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.aggregate;

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
 * Aggregate handler for ControlArea as outlined for the CQRS pattern, all write responsibilities
 * related to ControlArea are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ControlAreaAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ControlAreaAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ControlAreaAggregate(CreateControlAreaCommand command) throws Exception {
    LOGGER.info("Handling command CreateControlAreaCommand");
    CreateControlAreaEvent event =
        new CreateControlAreaEvent(command.getControlAreaId(), command.getType());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateControlAreaCommand command) throws Exception {
    LOGGER.info("handling command UpdateControlAreaCommand");
    UpdateControlAreaEvent event =
        new UpdateControlAreaEvent(
            command.getControlAreaId(), command.getType(), command.getControlArea());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteControlAreaCommand command) throws Exception {
    LOGGER.info("Handling command DeleteControlAreaCommand");
    apply(new DeleteControlAreaEvent(command.getControlAreaId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignControlAreaToControlAreaCommand command) throws Exception {
    LOGGER.info("Handling command AssignControlAreaToControlAreaCommand");

    if (controlArea != null
        && controlArea.getControlAreaId() == command.getAssignment().getControlAreaId())
      throw new ProcessingException(
          "ControlArea already assigned with id " + command.getAssignment().getControlAreaId());

    apply(
        new AssignControlAreaToControlAreaEvent(
            command.getControlAreaId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignControlAreaFromControlAreaCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignControlAreaFromControlAreaCommand");

    if (controlArea == null)
      throw new ProcessingException("ControlArea already has nothing assigned.");

    apply(new UnAssignControlAreaFromControlAreaEvent(command.getControlAreaId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateControlAreaEvent event) {
    LOGGER.info("Event sourcing CreateControlAreaEvent");
    this.controlAreaId = event.getControlAreaId();
    this.type = event.getType();
  }

  @EventSourcingHandler
  void on(UpdateControlAreaEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.type = event.getType();
    this.controlArea = event.getControlArea();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignControlAreaToControlAreaEvent event) {
    LOGGER.info("Event sourcing AssignControlAreaToControlAreaEvent");
    this.controlArea = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignControlAreaFromControlAreaEvent event) {
    LOGGER.info("Event sourcing UnAssignControlAreaFromControlAreaEvent");
    this.controlArea = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID controlAreaId;

  private ControlAreaTypeKind type;
  private ControlArea controlArea = null;

  private static final Logger LOGGER = Logger.getLogger(ControlAreaAggregate.class.getName());
}
