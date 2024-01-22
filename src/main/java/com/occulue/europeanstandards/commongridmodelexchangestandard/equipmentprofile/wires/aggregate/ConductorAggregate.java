package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.aggregate;

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
 * Aggregate handler for Conductor as outlined for the CQRS pattern, all write responsibilities
 * related to Conductor are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ConductorAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ConductorAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ConductorAggregate(CreateConductorCommand command) throws Exception {
    LOGGER.info("Handling command CreateConductorCommand");
    CreateConductorEvent event = new CreateConductorEvent(command.getConductorId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateConductorCommand command) throws Exception {
    LOGGER.info("handling command UpdateConductorCommand");
    UpdateConductorEvent event =
        new UpdateConductorEvent(command.getConductorId(), command.getLength());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteConductorCommand command) throws Exception {
    LOGGER.info("Handling command DeleteConductorCommand");
    apply(new DeleteConductorEvent(command.getConductorId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignLengthToConductorCommand command) throws Exception {
    LOGGER.info("Handling command AssignLengthToConductorCommand");

    if (length != null && length.getLengthId() == command.getAssignment().getLengthId())
      throw new ProcessingException(
          "Length already assigned with id " + command.getAssignment().getLengthId());

    apply(new AssignLengthToConductorEvent(command.getConductorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLengthFromConductorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLengthFromConductorCommand");

    if (length == null) throw new ProcessingException("Length already has nothing assigned.");

    apply(new UnAssignLengthFromConductorEvent(command.getConductorId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateConductorEvent event) {
    LOGGER.info("Event sourcing CreateConductorEvent");
    this.conductorId = event.getConductorId();
  }

  @EventSourcingHandler
  void on(UpdateConductorEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.length = event.getLength();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignLengthToConductorEvent event) {
    LOGGER.info("Event sourcing AssignLengthToConductorEvent");
    this.length = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLengthFromConductorEvent event) {
    LOGGER.info("Event sourcing UnAssignLengthFromConductorEvent");
    this.length = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID conductorId;

  private Length length = null;

  private static final Logger LOGGER = Logger.getLogger(ConductorAggregate.class.getName());
}
