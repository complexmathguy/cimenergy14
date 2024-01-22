package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.aggregate;

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
 * Aggregate handler for SvTapStep as outlined for the CQRS pattern, all write responsibilities
 * related to SvTapStep are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SvTapStepAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SvTapStepAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SvTapStepAggregate(CreateSvTapStepCommand command) throws Exception {
    LOGGER.info("Handling command CreateSvTapStepCommand");
    CreateSvTapStepEvent event = new CreateSvTapStepEvent(command.getSvTapStepId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSvTapStepCommand command) throws Exception {
    LOGGER.info("handling command UpdateSvTapStepCommand");
    UpdateSvTapStepEvent event =
        new UpdateSvTapStepEvent(
            command.getSvTapStepId(), command.getPosition(), command.getSvTapStep());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSvTapStepCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSvTapStepCommand");
    apply(new DeleteSvTapStepEvent(command.getSvTapStepId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignPositionToSvTapStepCommand command) throws Exception {
    LOGGER.info("Handling command AssignPositionToSvTapStepCommand");

    if (position != null
        && position.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Position already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignPositionToSvTapStepEvent(command.getSvTapStepId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPositionFromSvTapStepCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPositionFromSvTapStepCommand");

    if (position == null) throw new ProcessingException("Position already has nothing assigned.");

    apply(new UnAssignPositionFromSvTapStepEvent(command.getSvTapStepId()));
  }

  @CommandHandler
  public void handle(AssignSvTapStepToSvTapStepCommand command) throws Exception {
    LOGGER.info("Handling command AssignSvTapStepToSvTapStepCommand");

    if (svTapStep != null && svTapStep.getSvTapStepId() == command.getAssignment().getSvTapStepId())
      throw new ProcessingException(
          "SvTapStep already assigned with id " + command.getAssignment().getSvTapStepId());

    apply(new AssignSvTapStepToSvTapStepEvent(command.getSvTapStepId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSvTapStepFromSvTapStepCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSvTapStepFromSvTapStepCommand");

    if (svTapStep == null) throw new ProcessingException("SvTapStep already has nothing assigned.");

    apply(new UnAssignSvTapStepFromSvTapStepEvent(command.getSvTapStepId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSvTapStepEvent event) {
    LOGGER.info("Event sourcing CreateSvTapStepEvent");
    this.svTapStepId = event.getSvTapStepId();
  }

  @EventSourcingHandler
  void on(UpdateSvTapStepEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.position = event.getPosition();
    this.svTapStep = event.getSvTapStep();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignPositionToSvTapStepEvent event) {
    LOGGER.info("Event sourcing AssignPositionToSvTapStepEvent");
    this.position = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPositionFromSvTapStepEvent event) {
    LOGGER.info("Event sourcing UnAssignPositionFromSvTapStepEvent");
    this.position = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSvTapStepToSvTapStepEvent event) {
    LOGGER.info("Event sourcing AssignSvTapStepToSvTapStepEvent");
    this.svTapStep = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSvTapStepFromSvTapStepEvent event) {
    LOGGER.info("Event sourcing UnAssignSvTapStepFromSvTapStepEvent");
    this.svTapStep = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID svTapStepId;

  private Simple_Float position = null;
  private SvTapStep svTapStep = null;

  private static final Logger LOGGER = Logger.getLogger(SvTapStepAggregate.class.getName());
}
