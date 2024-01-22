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
 * Aggregate handler for PhaseTapChangerNonLinear as outlined for the CQRS pattern, all write
 * responsibilities related to PhaseTapChangerNonLinear are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PhaseTapChangerNonLinearAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PhaseTapChangerNonLinearAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PhaseTapChangerNonLinearAggregate(CreatePhaseTapChangerNonLinearCommand command)
      throws Exception {
    LOGGER.info("Handling command CreatePhaseTapChangerNonLinearCommand");
    CreatePhaseTapChangerNonLinearEvent event =
        new CreatePhaseTapChangerNonLinearEvent(command.getPhaseTapChangerNonLinearId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePhaseTapChangerNonLinearCommand command) throws Exception {
    LOGGER.info("handling command UpdatePhaseTapChangerNonLinearCommand");
    UpdatePhaseTapChangerNonLinearEvent event =
        new UpdatePhaseTapChangerNonLinearEvent(
            command.getPhaseTapChangerNonLinearId(),
            command.getVoltageStepIncrement(),
            command.getXMax(),
            command.getXMin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePhaseTapChangerNonLinearCommand command) throws Exception {
    LOGGER.info("Handling command DeletePhaseTapChangerNonLinearCommand");
    apply(new DeletePhaseTapChangerNonLinearEvent(command.getPhaseTapChangerNonLinearId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignVoltageStepIncrementToPhaseTapChangerNonLinearCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignVoltageStepIncrementToPhaseTapChangerNonLinearCommand");

    if (voltageStepIncrement != null
        && voltageStepIncrement.getPerCentId() == command.getAssignment().getPerCentId())
      throw new ProcessingException(
          "VoltageStepIncrement already assigned with id "
              + command.getAssignment().getPerCentId());

    apply(
        new AssignVoltageStepIncrementToPhaseTapChangerNonLinearEvent(
            command.getPhaseTapChangerNonLinearId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVoltageStepIncrementFromPhaseTapChangerNonLinearCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignVoltageStepIncrementFromPhaseTapChangerNonLinearCommand");

    if (voltageStepIncrement == null)
      throw new ProcessingException("VoltageStepIncrement already has nothing assigned.");

    apply(
        new UnAssignVoltageStepIncrementFromPhaseTapChangerNonLinearEvent(
            command.getPhaseTapChangerNonLinearId()));
  }

  @CommandHandler
  public void handle(AssignXMaxToPhaseTapChangerNonLinearCommand command) throws Exception {
    LOGGER.info("Handling command AssignXMaxToPhaseTapChangerNonLinearCommand");

    if (xMax != null && xMax.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "XMax already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignXMaxToPhaseTapChangerNonLinearEvent(
            command.getPhaseTapChangerNonLinearId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXMaxFromPhaseTapChangerNonLinearCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXMaxFromPhaseTapChangerNonLinearCommand");

    if (xMax == null) throw new ProcessingException("XMax already has nothing assigned.");

    apply(
        new UnAssignXMaxFromPhaseTapChangerNonLinearEvent(command.getPhaseTapChangerNonLinearId()));
  }

  @CommandHandler
  public void handle(AssignXMinToPhaseTapChangerNonLinearCommand command) throws Exception {
    LOGGER.info("Handling command AssignXMinToPhaseTapChangerNonLinearCommand");

    if (xMin != null && xMin.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "XMin already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignXMinToPhaseTapChangerNonLinearEvent(
            command.getPhaseTapChangerNonLinearId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXMinFromPhaseTapChangerNonLinearCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXMinFromPhaseTapChangerNonLinearCommand");

    if (xMin == null) throw new ProcessingException("XMin already has nothing assigned.");

    apply(
        new UnAssignXMinFromPhaseTapChangerNonLinearEvent(command.getPhaseTapChangerNonLinearId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePhaseTapChangerNonLinearEvent event) {
    LOGGER.info("Event sourcing CreatePhaseTapChangerNonLinearEvent");
    this.phaseTapChangerNonLinearId = event.getPhaseTapChangerNonLinearId();
  }

  @EventSourcingHandler
  void on(UpdatePhaseTapChangerNonLinearEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.voltageStepIncrement = event.getVoltageStepIncrement();
    this.xMax = event.getXMax();
    this.xMin = event.getXMin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignVoltageStepIncrementToPhaseTapChangerNonLinearEvent event) {
    LOGGER.info("Event sourcing AssignVoltageStepIncrementToPhaseTapChangerNonLinearEvent");
    this.voltageStepIncrement = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVoltageStepIncrementFromPhaseTapChangerNonLinearEvent event) {
    LOGGER.info("Event sourcing UnAssignVoltageStepIncrementFromPhaseTapChangerNonLinearEvent");
    this.voltageStepIncrement = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXMaxToPhaseTapChangerNonLinearEvent event) {
    LOGGER.info("Event sourcing AssignXMaxToPhaseTapChangerNonLinearEvent");
    this.xMax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXMaxFromPhaseTapChangerNonLinearEvent event) {
    LOGGER.info("Event sourcing UnAssignXMaxFromPhaseTapChangerNonLinearEvent");
    this.xMax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXMinToPhaseTapChangerNonLinearEvent event) {
    LOGGER.info("Event sourcing AssignXMinToPhaseTapChangerNonLinearEvent");
    this.xMin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXMinFromPhaseTapChangerNonLinearEvent event) {
    LOGGER.info("Event sourcing UnAssignXMinFromPhaseTapChangerNonLinearEvent");
    this.xMin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID phaseTapChangerNonLinearId;

  private PerCent voltageStepIncrement = null;
  private Reactance xMax = null;
  private Reactance xMin = null;

  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerNonLinearAggregate.class.getName());
}
