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
 * Aggregate handler for StaticVarCompensator as outlined for the CQRS pattern, all write
 * responsibilities related to StaticVarCompensator are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class StaticVarCompensatorAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public StaticVarCompensatorAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public StaticVarCompensatorAggregate(CreateStaticVarCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command CreateStaticVarCompensatorCommand");
    CreateStaticVarCompensatorEvent event =
        new CreateStaticVarCompensatorEvent(
            command.getStaticVarCompensatorId(), command.getSVCControlMode());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateStaticVarCompensatorCommand command) throws Exception {
    LOGGER.info("handling command UpdateStaticVarCompensatorCommand");
    UpdateStaticVarCompensatorEvent event =
        new UpdateStaticVarCompensatorEvent(
            command.getStaticVarCompensatorId(),
            command.getCapacitiveRating(),
            command.getInductiveRating(),
            command.getSlope(),
            command.getSVCControlMode(),
            command.getVoltageSetPoint());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteStaticVarCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command DeleteStaticVarCompensatorCommand");
    apply(new DeleteStaticVarCompensatorEvent(command.getStaticVarCompensatorId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignCapacitiveRatingToStaticVarCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignCapacitiveRatingToStaticVarCompensatorCommand");

    if (capacitiveRating != null
        && capacitiveRating.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "CapacitiveRating already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignCapacitiveRatingToStaticVarCompensatorEvent(
            command.getStaticVarCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCapacitiveRatingFromStaticVarCompensatorCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignCapacitiveRatingFromStaticVarCompensatorCommand");

    if (capacitiveRating == null)
      throw new ProcessingException("CapacitiveRating already has nothing assigned.");

    apply(
        new UnAssignCapacitiveRatingFromStaticVarCompensatorEvent(
            command.getStaticVarCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignInductiveRatingToStaticVarCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignInductiveRatingToStaticVarCompensatorCommand");

    if (inductiveRating != null
        && inductiveRating.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "InductiveRating already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignInductiveRatingToStaticVarCompensatorEvent(
            command.getStaticVarCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignInductiveRatingFromStaticVarCompensatorCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignInductiveRatingFromStaticVarCompensatorCommand");

    if (inductiveRating == null)
      throw new ProcessingException("InductiveRating already has nothing assigned.");

    apply(
        new UnAssignInductiveRatingFromStaticVarCompensatorEvent(
            command.getStaticVarCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignSlopeToStaticVarCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignSlopeToStaticVarCompensatorCommand");

    if (slope != null
        && slope.getVoltagePerReactivePowerId()
            == command.getAssignment().getVoltagePerReactivePowerId())
      throw new ProcessingException(
          "Slope already assigned with id "
              + command.getAssignment().getVoltagePerReactivePowerId());

    apply(
        new AssignSlopeToStaticVarCompensatorEvent(
            command.getStaticVarCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSlopeFromStaticVarCompensatorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSlopeFromStaticVarCompensatorCommand");

    if (slope == null) throw new ProcessingException("Slope already has nothing assigned.");

    apply(new UnAssignSlopeFromStaticVarCompensatorEvent(command.getStaticVarCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignVoltageSetPointToStaticVarCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignVoltageSetPointToStaticVarCompensatorCommand");

    if (voltageSetPoint != null
        && voltageSetPoint.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "VoltageSetPoint already assigned with id " + command.getAssignment().getVoltageId());

    apply(
        new AssignVoltageSetPointToStaticVarCompensatorEvent(
            command.getStaticVarCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVoltageSetPointFromStaticVarCompensatorCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignVoltageSetPointFromStaticVarCompensatorCommand");

    if (voltageSetPoint == null)
      throw new ProcessingException("VoltageSetPoint already has nothing assigned.");

    apply(
        new UnAssignVoltageSetPointFromStaticVarCompensatorEvent(
            command.getStaticVarCompensatorId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateStaticVarCompensatorEvent event) {
    LOGGER.info("Event sourcing CreateStaticVarCompensatorEvent");
    this.staticVarCompensatorId = event.getStaticVarCompensatorId();
    this.sVCControlMode = event.getSVCControlMode();
  }

  @EventSourcingHandler
  void on(UpdateStaticVarCompensatorEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.capacitiveRating = event.getCapacitiveRating();
    this.inductiveRating = event.getInductiveRating();
    this.slope = event.getSlope();
    this.sVCControlMode = event.getSVCControlMode();
    this.voltageSetPoint = event.getVoltageSetPoint();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignCapacitiveRatingToStaticVarCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignCapacitiveRatingToStaticVarCompensatorEvent");
    this.capacitiveRating = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCapacitiveRatingFromStaticVarCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignCapacitiveRatingFromStaticVarCompensatorEvent");
    this.capacitiveRating = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignInductiveRatingToStaticVarCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignInductiveRatingToStaticVarCompensatorEvent");
    this.inductiveRating = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignInductiveRatingFromStaticVarCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignInductiveRatingFromStaticVarCompensatorEvent");
    this.inductiveRating = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSlopeToStaticVarCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignSlopeToStaticVarCompensatorEvent");
    this.slope = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSlopeFromStaticVarCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignSlopeFromStaticVarCompensatorEvent");
    this.slope = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVoltageSetPointToStaticVarCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignVoltageSetPointToStaticVarCompensatorEvent");
    this.voltageSetPoint = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVoltageSetPointFromStaticVarCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignVoltageSetPointFromStaticVarCompensatorEvent");
    this.voltageSetPoint = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID staticVarCompensatorId;

  private SVCControlMode sVCControlMode;
  private Reactance capacitiveRating = null;
  private Reactance inductiveRating = null;
  private VoltagePerReactivePower slope = null;
  private Voltage voltageSetPoint = null;

  private static final Logger LOGGER =
      Logger.getLogger(StaticVarCompensatorAggregate.class.getName());
}
