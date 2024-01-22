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
 * Aggregate handler for PhaseTapChangerLinear as outlined for the CQRS pattern, all write
 * responsibilities related to PhaseTapChangerLinear are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PhaseTapChangerLinearAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PhaseTapChangerLinearAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PhaseTapChangerLinearAggregate(CreatePhaseTapChangerLinearCommand command)
      throws Exception {
    LOGGER.info("Handling command CreatePhaseTapChangerLinearCommand");
    CreatePhaseTapChangerLinearEvent event =
        new CreatePhaseTapChangerLinearEvent(command.getPhaseTapChangerLinearId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePhaseTapChangerLinearCommand command) throws Exception {
    LOGGER.info("handling command UpdatePhaseTapChangerLinearCommand");
    UpdatePhaseTapChangerLinearEvent event =
        new UpdatePhaseTapChangerLinearEvent(
            command.getPhaseTapChangerLinearId(),
            command.getStepPhaseShiftIncrement(),
            command.getXMax(),
            command.getXMin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePhaseTapChangerLinearCommand command) throws Exception {
    LOGGER.info("Handling command DeletePhaseTapChangerLinearCommand");
    apply(new DeletePhaseTapChangerLinearEvent(command.getPhaseTapChangerLinearId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignStepPhaseShiftIncrementToPhaseTapChangerLinearCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignStepPhaseShiftIncrementToPhaseTapChangerLinearCommand");

    if (stepPhaseShiftIncrement != null
        && stepPhaseShiftIncrement.getAngleDegreesId()
            == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "StepPhaseShiftIncrement already assigned with id "
              + command.getAssignment().getAngleDegreesId());

    apply(
        new AssignStepPhaseShiftIncrementToPhaseTapChangerLinearEvent(
            command.getPhaseTapChangerLinearId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearCommand");

    if (stepPhaseShiftIncrement == null)
      throw new ProcessingException("StepPhaseShiftIncrement already has nothing assigned.");

    apply(
        new UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearEvent(
            command.getPhaseTapChangerLinearId()));
  }

  @CommandHandler
  public void handle(AssignXMaxToPhaseTapChangerLinearCommand command) throws Exception {
    LOGGER.info("Handling command AssignXMaxToPhaseTapChangerLinearCommand");

    if (xMax != null && xMax.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "XMax already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignXMaxToPhaseTapChangerLinearEvent(
            command.getPhaseTapChangerLinearId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXMaxFromPhaseTapChangerLinearCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXMaxFromPhaseTapChangerLinearCommand");

    if (xMax == null) throw new ProcessingException("XMax already has nothing assigned.");

    apply(new UnAssignXMaxFromPhaseTapChangerLinearEvent(command.getPhaseTapChangerLinearId()));
  }

  @CommandHandler
  public void handle(AssignXMinToPhaseTapChangerLinearCommand command) throws Exception {
    LOGGER.info("Handling command AssignXMinToPhaseTapChangerLinearCommand");

    if (xMin != null && xMin.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "XMin already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignXMinToPhaseTapChangerLinearEvent(
            command.getPhaseTapChangerLinearId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXMinFromPhaseTapChangerLinearCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXMinFromPhaseTapChangerLinearCommand");

    if (xMin == null) throw new ProcessingException("XMin already has nothing assigned.");

    apply(new UnAssignXMinFromPhaseTapChangerLinearEvent(command.getPhaseTapChangerLinearId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePhaseTapChangerLinearEvent event) {
    LOGGER.info("Event sourcing CreatePhaseTapChangerLinearEvent");
    this.phaseTapChangerLinearId = event.getPhaseTapChangerLinearId();
  }

  @EventSourcingHandler
  void on(UpdatePhaseTapChangerLinearEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.stepPhaseShiftIncrement = event.getStepPhaseShiftIncrement();
    this.xMax = event.getXMax();
    this.xMin = event.getXMin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignStepPhaseShiftIncrementToPhaseTapChangerLinearEvent event) {
    LOGGER.info("Event sourcing AssignStepPhaseShiftIncrementToPhaseTapChangerLinearEvent");
    this.stepPhaseShiftIncrement = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearEvent event) {
    LOGGER.info("Event sourcing UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearEvent");
    this.stepPhaseShiftIncrement = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXMaxToPhaseTapChangerLinearEvent event) {
    LOGGER.info("Event sourcing AssignXMaxToPhaseTapChangerLinearEvent");
    this.xMax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXMaxFromPhaseTapChangerLinearEvent event) {
    LOGGER.info("Event sourcing UnAssignXMaxFromPhaseTapChangerLinearEvent");
    this.xMax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXMinToPhaseTapChangerLinearEvent event) {
    LOGGER.info("Event sourcing AssignXMinToPhaseTapChangerLinearEvent");
    this.xMin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXMinFromPhaseTapChangerLinearEvent event) {
    LOGGER.info("Event sourcing UnAssignXMinFromPhaseTapChangerLinearEvent");
    this.xMin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID phaseTapChangerLinearId;

  private AngleDegrees stepPhaseShiftIncrement = null;
  private Reactance xMax = null;
  private Reactance xMin = null;

  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerLinearAggregate.class.getName());
}
