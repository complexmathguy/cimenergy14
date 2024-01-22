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
 * Aggregate handler for RegulatingControl as outlined for the CQRS pattern, all write
 * responsibilities related to RegulatingControl are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class RegulatingControlAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public RegulatingControlAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public RegulatingControlAggregate(CreateRegulatingControlCommand command) throws Exception {
    LOGGER.info("Handling command CreateRegulatingControlCommand");
    CreateRegulatingControlEvent event =
        new CreateRegulatingControlEvent(command.getRegulatingControlId(), command.getMode());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateRegulatingControlCommand command) throws Exception {
    LOGGER.info("handling command UpdateRegulatingControlCommand");
    UpdateRegulatingControlEvent event =
        new UpdateRegulatingControlEvent(
            command.getRegulatingControlId(), command.getMode(), command.getRegulatingControl());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteRegulatingControlCommand command) throws Exception {
    LOGGER.info("Handling command DeleteRegulatingControlCommand");
    apply(new DeleteRegulatingControlEvent(command.getRegulatingControlId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignRegulatingControlToRegulatingControlCommand command) throws Exception {
    LOGGER.info("Handling command AssignRegulatingControlToRegulatingControlCommand");

    if (regulatingControl != null
        && regulatingControl.getRegulatingControlId()
            == command.getAssignment().getRegulatingControlId())
      throw new ProcessingException(
          "RegulatingControl already assigned with id "
              + command.getAssignment().getRegulatingControlId());

    apply(
        new AssignRegulatingControlToRegulatingControlEvent(
            command.getRegulatingControlId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRegulatingControlFromRegulatingControlCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignRegulatingControlFromRegulatingControlCommand");

    if (regulatingControl == null)
      throw new ProcessingException("RegulatingControl already has nothing assigned.");

    apply(
        new UnAssignRegulatingControlFromRegulatingControlEvent(command.getRegulatingControlId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateRegulatingControlEvent event) {
    LOGGER.info("Event sourcing CreateRegulatingControlEvent");
    this.regulatingControlId = event.getRegulatingControlId();
    this.mode = event.getMode();
  }

  @EventSourcingHandler
  void on(UpdateRegulatingControlEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.mode = event.getMode();
    this.regulatingControl = event.getRegulatingControl();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignRegulatingControlToRegulatingControlEvent event) {
    LOGGER.info("Event sourcing AssignRegulatingControlToRegulatingControlEvent");
    this.regulatingControl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRegulatingControlFromRegulatingControlEvent event) {
    LOGGER.info("Event sourcing UnAssignRegulatingControlFromRegulatingControlEvent");
    this.regulatingControl = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID regulatingControlId;

  private RegulatingControlModeKind mode;
  private RegulatingControl regulatingControl = null;

  private static final Logger LOGGER = Logger.getLogger(RegulatingControlAggregate.class.getName());
}
