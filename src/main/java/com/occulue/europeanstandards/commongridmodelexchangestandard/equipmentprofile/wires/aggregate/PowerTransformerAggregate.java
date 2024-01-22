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
 * Aggregate handler for PowerTransformer as outlined for the CQRS pattern, all write
 * responsibilities related to PowerTransformer are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PowerTransformerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PowerTransformerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PowerTransformerAggregate(CreatePowerTransformerCommand command) throws Exception {
    LOGGER.info("Handling command CreatePowerTransformerCommand");
    CreatePowerTransformerEvent event =
        new CreatePowerTransformerEvent(command.getPowerTransformerId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePowerTransformerCommand command) throws Exception {
    LOGGER.info("handling command UpdatePowerTransformerCommand");
    UpdatePowerTransformerEvent event =
        new UpdatePowerTransformerEvent(
            command.getPowerTransformerId(),
            command.getBeforeShCircuitHighestOperatingCurrent(),
            command.getBeforeShCircuitHighestOperatingVoltage(),
            command.getBeforeShortCircuitAnglePf(),
            command.getHighSideMinOperatingU(),
            command.getPartOfGeneratorUnitFlag(),
            command.getOperationalValuesConsidered());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePowerTransformerCommand command) throws Exception {
    LOGGER.info("Handling command DeletePowerTransformerCommand");
    apply(new DeletePowerTransformerEvent(command.getPowerTransformerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerCommand");

    if (beforeShCircuitHighestOperatingCurrent != null
        && beforeShCircuitHighestOperatingCurrent.getCurrentFlowId()
            == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "BeforeShCircuitHighestOperatingCurrent already assigned with id "
              + command.getAssignment().getCurrentFlowId());

    apply(
        new AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerEvent(
            command.getPowerTransformerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerCommand");

    if (beforeShCircuitHighestOperatingCurrent == null)
      throw new ProcessingException(
          "BeforeShCircuitHighestOperatingCurrent already has nothing assigned.");

    apply(
        new UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerEvent(
            command.getPowerTransformerId()));
  }

  @CommandHandler
  public void handle(AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerCommand");

    if (beforeShCircuitHighestOperatingVoltage != null
        && beforeShCircuitHighestOperatingVoltage.getVoltageId()
            == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "BeforeShCircuitHighestOperatingVoltage already assigned with id "
              + command.getAssignment().getVoltageId());

    apply(
        new AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerEvent(
            command.getPowerTransformerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerCommand");

    if (beforeShCircuitHighestOperatingVoltage == null)
      throw new ProcessingException(
          "BeforeShCircuitHighestOperatingVoltage already has nothing assigned.");

    apply(
        new UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerEvent(
            command.getPowerTransformerId()));
  }

  @CommandHandler
  public void handle(AssignBeforeShortCircuitAnglePfToPowerTransformerCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignBeforeShortCircuitAnglePfToPowerTransformerCommand");

    if (beforeShortCircuitAnglePf != null
        && beforeShortCircuitAnglePf.getAngleDegreesId()
            == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "BeforeShortCircuitAnglePf already assigned with id "
              + command.getAssignment().getAngleDegreesId());

    apply(
        new AssignBeforeShortCircuitAnglePfToPowerTransformerEvent(
            command.getPowerTransformerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBeforeShortCircuitAnglePfFromPowerTransformerCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignBeforeShortCircuitAnglePfFromPowerTransformerCommand");

    if (beforeShortCircuitAnglePf == null)
      throw new ProcessingException("BeforeShortCircuitAnglePf already has nothing assigned.");

    apply(
        new UnAssignBeforeShortCircuitAnglePfFromPowerTransformerEvent(
            command.getPowerTransformerId()));
  }

  @CommandHandler
  public void handle(AssignHighSideMinOperatingUToPowerTransformerCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignHighSideMinOperatingUToPowerTransformerCommand");

    if (highSideMinOperatingU != null
        && highSideMinOperatingU.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "HighSideMinOperatingU already assigned with id "
              + command.getAssignment().getVoltageId());

    apply(
        new AssignHighSideMinOperatingUToPowerTransformerEvent(
            command.getPowerTransformerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHighSideMinOperatingUFromPowerTransformerCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignHighSideMinOperatingUFromPowerTransformerCommand");

    if (highSideMinOperatingU == null)
      throw new ProcessingException("HighSideMinOperatingU already has nothing assigned.");

    apply(
        new UnAssignHighSideMinOperatingUFromPowerTransformerEvent(
            command.getPowerTransformerId()));
  }

  @CommandHandler
  public void handle(AssignPartOfGeneratorUnitFlagToPowerTransformerCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignPartOfGeneratorUnitFlagToPowerTransformerCommand");

    if (partOfGeneratorUnitFlag != null
        && partOfGeneratorUnitFlag.getBooleanProxyId()
            == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "PartOfGeneratorUnitFlag already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignPartOfGeneratorUnitFlagToPowerTransformerEvent(
            command.getPowerTransformerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPartOfGeneratorUnitFlagFromPowerTransformerCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignPartOfGeneratorUnitFlagFromPowerTransformerCommand");

    if (partOfGeneratorUnitFlag == null)
      throw new ProcessingException("PartOfGeneratorUnitFlag already has nothing assigned.");

    apply(
        new UnAssignPartOfGeneratorUnitFlagFromPowerTransformerEvent(
            command.getPowerTransformerId()));
  }

  @CommandHandler
  public void handle(AssignOperationalValuesConsideredToPowerTransformerCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignOperationalValuesConsideredToPowerTransformerCommand");

    if (operationalValuesConsidered != null
        && operationalValuesConsidered.getBooleanProxyId()
            == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "OperationalValuesConsidered already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignOperationalValuesConsideredToPowerTransformerEvent(
            command.getPowerTransformerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOperationalValuesConsideredFromPowerTransformerCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignOperationalValuesConsideredFromPowerTransformerCommand");

    if (operationalValuesConsidered == null)
      throw new ProcessingException("OperationalValuesConsidered already has nothing assigned.");

    apply(
        new UnAssignOperationalValuesConsideredFromPowerTransformerEvent(
            command.getPowerTransformerId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePowerTransformerEvent event) {
    LOGGER.info("Event sourcing CreatePowerTransformerEvent");
    this.powerTransformerId = event.getPowerTransformerId();
  }

  @EventSourcingHandler
  void on(UpdatePowerTransformerEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.beforeShCircuitHighestOperatingCurrent = event.getBeforeShCircuitHighestOperatingCurrent();
    this.beforeShCircuitHighestOperatingVoltage = event.getBeforeShCircuitHighestOperatingVoltage();
    this.beforeShortCircuitAnglePf = event.getBeforeShortCircuitAnglePf();
    this.highSideMinOperatingU = event.getHighSideMinOperatingU();
    this.partOfGeneratorUnitFlag = event.getPartOfGeneratorUnitFlag();
    this.operationalValuesConsidered = event.getOperationalValuesConsidered();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerEvent event) {
    LOGGER.info(
        "Event sourcing AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerEvent");
    this.beforeShCircuitHighestOperatingCurrent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerEvent");
    this.beforeShCircuitHighestOperatingCurrent = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerEvent event) {
    LOGGER.info(
        "Event sourcing AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerEvent");
    this.beforeShCircuitHighestOperatingVoltage = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerEvent");
    this.beforeShCircuitHighestOperatingVoltage = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBeforeShortCircuitAnglePfToPowerTransformerEvent event) {
    LOGGER.info("Event sourcing AssignBeforeShortCircuitAnglePfToPowerTransformerEvent");
    this.beforeShortCircuitAnglePf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBeforeShortCircuitAnglePfFromPowerTransformerEvent event) {
    LOGGER.info("Event sourcing UnAssignBeforeShortCircuitAnglePfFromPowerTransformerEvent");
    this.beforeShortCircuitAnglePf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignHighSideMinOperatingUToPowerTransformerEvent event) {
    LOGGER.info("Event sourcing AssignHighSideMinOperatingUToPowerTransformerEvent");
    this.highSideMinOperatingU = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHighSideMinOperatingUFromPowerTransformerEvent event) {
    LOGGER.info("Event sourcing UnAssignHighSideMinOperatingUFromPowerTransformerEvent");
    this.highSideMinOperatingU = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPartOfGeneratorUnitFlagToPowerTransformerEvent event) {
    LOGGER.info("Event sourcing AssignPartOfGeneratorUnitFlagToPowerTransformerEvent");
    this.partOfGeneratorUnitFlag = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPartOfGeneratorUnitFlagFromPowerTransformerEvent event) {
    LOGGER.info("Event sourcing UnAssignPartOfGeneratorUnitFlagFromPowerTransformerEvent");
    this.partOfGeneratorUnitFlag = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOperationalValuesConsideredToPowerTransformerEvent event) {
    LOGGER.info("Event sourcing AssignOperationalValuesConsideredToPowerTransformerEvent");
    this.operationalValuesConsidered = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOperationalValuesConsideredFromPowerTransformerEvent event) {
    LOGGER.info("Event sourcing UnAssignOperationalValuesConsideredFromPowerTransformerEvent");
    this.operationalValuesConsidered = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID powerTransformerId;

  private CurrentFlow beforeShCircuitHighestOperatingCurrent = null;
  private Voltage beforeShCircuitHighestOperatingVoltage = null;
  private AngleDegrees beforeShortCircuitAnglePf = null;
  private Voltage highSideMinOperatingU = null;
  private BooleanProxy partOfGeneratorUnitFlag = null;
  private BooleanProxy operationalValuesConsidered = null;

  private static final Logger LOGGER = Logger.getLogger(PowerTransformerAggregate.class.getName());
}
