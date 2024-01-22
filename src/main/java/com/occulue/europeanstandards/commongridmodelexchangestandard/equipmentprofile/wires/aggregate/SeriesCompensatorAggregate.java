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
 * Aggregate handler for SeriesCompensator as outlined for the CQRS pattern, all write
 * responsibilities related to SeriesCompensator are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SeriesCompensatorAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SeriesCompensatorAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SeriesCompensatorAggregate(CreateSeriesCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command CreateSeriesCompensatorCommand");
    CreateSeriesCompensatorEvent event =
        new CreateSeriesCompensatorEvent(command.getSeriesCompensatorId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSeriesCompensatorCommand command) throws Exception {
    LOGGER.info("handling command UpdateSeriesCompensatorCommand");
    UpdateSeriesCompensatorEvent event =
        new UpdateSeriesCompensatorEvent(
            command.getSeriesCompensatorId(),
            command.getR(),
            command.getR0(),
            command.getVaristorPresent(),
            command.getVaristorRatedCurrent(),
            command.getVaristorVoltageThreshold(),
            command.getX(),
            command.getX0());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSeriesCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSeriesCompensatorCommand");
    apply(new DeleteSeriesCompensatorEvent(command.getSeriesCompensatorId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignRToSeriesCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignRToSeriesCompensatorCommand");

    if (r != null && r.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignRToSeriesCompensatorEvent(
            command.getSeriesCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromSeriesCompensatorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromSeriesCompensatorCommand");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromSeriesCompensatorEvent(command.getSeriesCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignR0ToSeriesCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignR0ToSeriesCompensatorCommand");

    if (r0 != null && r0.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R0 already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignR0ToSeriesCompensatorEvent(
            command.getSeriesCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignR0FromSeriesCompensatorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignR0FromSeriesCompensatorCommand");

    if (r0 == null) throw new ProcessingException("R0 already has nothing assigned.");

    apply(new UnAssignR0FromSeriesCompensatorEvent(command.getSeriesCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignVaristorPresentToSeriesCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignVaristorPresentToSeriesCompensatorCommand");

    if (varistorPresent != null
        && varistorPresent.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "VaristorPresent already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignVaristorPresentToSeriesCompensatorEvent(
            command.getSeriesCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaristorPresentFromSeriesCompensatorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaristorPresentFromSeriesCompensatorCommand");

    if (varistorPresent == null)
      throw new ProcessingException("VaristorPresent already has nothing assigned.");

    apply(new UnAssignVaristorPresentFromSeriesCompensatorEvent(command.getSeriesCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignVaristorRatedCurrentToSeriesCompensatorCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignVaristorRatedCurrentToSeriesCompensatorCommand");

    if (varistorRatedCurrent != null
        && varistorRatedCurrent.getCurrentFlowId() == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "VaristorRatedCurrent already assigned with id "
              + command.getAssignment().getCurrentFlowId());

    apply(
        new AssignVaristorRatedCurrentToSeriesCompensatorEvent(
            command.getSeriesCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaristorRatedCurrentFromSeriesCompensatorCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignVaristorRatedCurrentFromSeriesCompensatorCommand");

    if (varistorRatedCurrent == null)
      throw new ProcessingException("VaristorRatedCurrent already has nothing assigned.");

    apply(
        new UnAssignVaristorRatedCurrentFromSeriesCompensatorEvent(
            command.getSeriesCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignVaristorVoltageThresholdToSeriesCompensatorCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignVaristorVoltageThresholdToSeriesCompensatorCommand");

    if (varistorVoltageThreshold != null
        && varistorVoltageThreshold.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "VaristorVoltageThreshold already assigned with id "
              + command.getAssignment().getVoltageId());

    apply(
        new AssignVaristorVoltageThresholdToSeriesCompensatorEvent(
            command.getSeriesCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaristorVoltageThresholdFromSeriesCompensatorCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignVaristorVoltageThresholdFromSeriesCompensatorCommand");

    if (varistorVoltageThreshold == null)
      throw new ProcessingException("VaristorVoltageThreshold already has nothing assigned.");

    apply(
        new UnAssignVaristorVoltageThresholdFromSeriesCompensatorEvent(
            command.getSeriesCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignXToSeriesCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignXToSeriesCompensatorCommand");

    if (x != null && x.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "X already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignXToSeriesCompensatorEvent(
            command.getSeriesCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXFromSeriesCompensatorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXFromSeriesCompensatorCommand");

    if (x == null) throw new ProcessingException("X already has nothing assigned.");

    apply(new UnAssignXFromSeriesCompensatorEvent(command.getSeriesCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignX0ToSeriesCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignX0ToSeriesCompensatorCommand");

    if (x0 != null && x0.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "X0 already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignX0ToSeriesCompensatorEvent(
            command.getSeriesCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignX0FromSeriesCompensatorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignX0FromSeriesCompensatorCommand");

    if (x0 == null) throw new ProcessingException("X0 already has nothing assigned.");

    apply(new UnAssignX0FromSeriesCompensatorEvent(command.getSeriesCompensatorId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing CreateSeriesCompensatorEvent");
    this.seriesCompensatorId = event.getSeriesCompensatorId();
  }

  @EventSourcingHandler
  void on(UpdateSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.r = event.getR();
    this.r0 = event.getR0();
    this.varistorPresent = event.getVaristorPresent();
    this.varistorRatedCurrent = event.getVaristorRatedCurrent();
    this.varistorVoltageThreshold = event.getVaristorVoltageThreshold();
    this.x = event.getX();
    this.x0 = event.getX0();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignRToSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignRToSeriesCompensatorEvent");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignRFromSeriesCompensatorEvent");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignR0ToSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignR0ToSeriesCompensatorEvent");
    this.r0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignR0FromSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignR0FromSeriesCompensatorEvent");
    this.r0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaristorPresentToSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignVaristorPresentToSeriesCompensatorEvent");
    this.varistorPresent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaristorPresentFromSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignVaristorPresentFromSeriesCompensatorEvent");
    this.varistorPresent = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaristorRatedCurrentToSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignVaristorRatedCurrentToSeriesCompensatorEvent");
    this.varistorRatedCurrent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaristorRatedCurrentFromSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignVaristorRatedCurrentFromSeriesCompensatorEvent");
    this.varistorRatedCurrent = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaristorVoltageThresholdToSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignVaristorVoltageThresholdToSeriesCompensatorEvent");
    this.varistorVoltageThreshold = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaristorVoltageThresholdFromSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignVaristorVoltageThresholdFromSeriesCompensatorEvent");
    this.varistorVoltageThreshold = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXToSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignXToSeriesCompensatorEvent");
    this.x = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXFromSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignXFromSeriesCompensatorEvent");
    this.x = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignX0ToSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignX0ToSeriesCompensatorEvent");
    this.x0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignX0FromSeriesCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignX0FromSeriesCompensatorEvent");
    this.x0 = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID seriesCompensatorId;

  private Resistance r = null;
  private Resistance r0 = null;
  private BooleanProxy varistorPresent = null;
  private CurrentFlow varistorRatedCurrent = null;
  private Voltage varistorVoltageThreshold = null;
  private Reactance x = null;
  private Reactance x0 = null;

  private static final Logger LOGGER = Logger.getLogger(SeriesCompensatorAggregate.class.getName());
}
