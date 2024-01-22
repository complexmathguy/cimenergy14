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
 * Aggregate handler for PetersenCoil as outlined for the CQRS pattern, all write responsibilities
 * related to PetersenCoil are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PetersenCoilAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PetersenCoilAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PetersenCoilAggregate(CreatePetersenCoilCommand command) throws Exception {
    LOGGER.info("Handling command CreatePetersenCoilCommand");
    CreatePetersenCoilEvent event =
        new CreatePetersenCoilEvent(command.getPetersenCoilId(), command.getMode());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePetersenCoilCommand command) throws Exception {
    LOGGER.info("handling command UpdatePetersenCoilCommand");
    UpdatePetersenCoilEvent event =
        new UpdatePetersenCoilEvent(
            command.getPetersenCoilId(),
            command.getMode(),
            command.getNominalU(),
            command.getOffsetCurrent(),
            command.getPositionCurrent(),
            command.getXGroundMax(),
            command.getXGroundMin(),
            command.getXGroundNominal());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePetersenCoilCommand command) throws Exception {
    LOGGER.info("Handling command DeletePetersenCoilCommand");
    apply(new DeletePetersenCoilEvent(command.getPetersenCoilId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignNominalUToPetersenCoilCommand command) throws Exception {
    LOGGER.info("Handling command AssignNominalUToPetersenCoilCommand");

    if (nominalU != null && nominalU.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "NominalU already assigned with id " + command.getAssignment().getVoltageId());

    apply(
        new AssignNominalUToPetersenCoilEvent(
            command.getPetersenCoilId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNominalUFromPetersenCoilCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNominalUFromPetersenCoilCommand");

    if (nominalU == null) throw new ProcessingException("NominalU already has nothing assigned.");

    apply(new UnAssignNominalUFromPetersenCoilEvent(command.getPetersenCoilId()));
  }

  @CommandHandler
  public void handle(AssignOffsetCurrentToPetersenCoilCommand command) throws Exception {
    LOGGER.info("Handling command AssignOffsetCurrentToPetersenCoilCommand");

    if (offsetCurrent != null
        && offsetCurrent.getCurrentFlowId() == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "OffsetCurrent already assigned with id " + command.getAssignment().getCurrentFlowId());

    apply(
        new AssignOffsetCurrentToPetersenCoilEvent(
            command.getPetersenCoilId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOffsetCurrentFromPetersenCoilCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignOffsetCurrentFromPetersenCoilCommand");

    if (offsetCurrent == null)
      throw new ProcessingException("OffsetCurrent already has nothing assigned.");

    apply(new UnAssignOffsetCurrentFromPetersenCoilEvent(command.getPetersenCoilId()));
  }

  @CommandHandler
  public void handle(AssignPositionCurrentToPetersenCoilCommand command) throws Exception {
    LOGGER.info("Handling command AssignPositionCurrentToPetersenCoilCommand");

    if (positionCurrent != null
        && positionCurrent.getCurrentFlowId() == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "PositionCurrent already assigned with id " + command.getAssignment().getCurrentFlowId());

    apply(
        new AssignPositionCurrentToPetersenCoilEvent(
            command.getPetersenCoilId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPositionCurrentFromPetersenCoilCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPositionCurrentFromPetersenCoilCommand");

    if (positionCurrent == null)
      throw new ProcessingException("PositionCurrent already has nothing assigned.");

    apply(new UnAssignPositionCurrentFromPetersenCoilEvent(command.getPetersenCoilId()));
  }

  @CommandHandler
  public void handle(AssignXGroundMaxToPetersenCoilCommand command) throws Exception {
    LOGGER.info("Handling command AssignXGroundMaxToPetersenCoilCommand");

    if (xGroundMax != null
        && xGroundMax.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "XGroundMax already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignXGroundMaxToPetersenCoilEvent(
            command.getPetersenCoilId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXGroundMaxFromPetersenCoilCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXGroundMaxFromPetersenCoilCommand");

    if (xGroundMax == null)
      throw new ProcessingException("XGroundMax already has nothing assigned.");

    apply(new UnAssignXGroundMaxFromPetersenCoilEvent(command.getPetersenCoilId()));
  }

  @CommandHandler
  public void handle(AssignXGroundMinToPetersenCoilCommand command) throws Exception {
    LOGGER.info("Handling command AssignXGroundMinToPetersenCoilCommand");

    if (xGroundMin != null
        && xGroundMin.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "XGroundMin already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignXGroundMinToPetersenCoilEvent(
            command.getPetersenCoilId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXGroundMinFromPetersenCoilCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXGroundMinFromPetersenCoilCommand");

    if (xGroundMin == null)
      throw new ProcessingException("XGroundMin already has nothing assigned.");

    apply(new UnAssignXGroundMinFromPetersenCoilEvent(command.getPetersenCoilId()));
  }

  @CommandHandler
  public void handle(AssignXGroundNominalToPetersenCoilCommand command) throws Exception {
    LOGGER.info("Handling command AssignXGroundNominalToPetersenCoilCommand");

    if (xGroundNominal != null
        && xGroundNominal.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "XGroundNominal already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignXGroundNominalToPetersenCoilEvent(
            command.getPetersenCoilId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXGroundNominalFromPetersenCoilCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXGroundNominalFromPetersenCoilCommand");

    if (xGroundNominal == null)
      throw new ProcessingException("XGroundNominal already has nothing assigned.");

    apply(new UnAssignXGroundNominalFromPetersenCoilEvent(command.getPetersenCoilId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePetersenCoilEvent event) {
    LOGGER.info("Event sourcing CreatePetersenCoilEvent");
    this.petersenCoilId = event.getPetersenCoilId();
    this.mode = event.getMode();
  }

  @EventSourcingHandler
  void on(UpdatePetersenCoilEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.mode = event.getMode();
    this.nominalU = event.getNominalU();
    this.offsetCurrent = event.getOffsetCurrent();
    this.positionCurrent = event.getPositionCurrent();
    this.xGroundMax = event.getXGroundMax();
    this.xGroundMin = event.getXGroundMin();
    this.xGroundNominal = event.getXGroundNominal();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignNominalUToPetersenCoilEvent event) {
    LOGGER.info("Event sourcing AssignNominalUToPetersenCoilEvent");
    this.nominalU = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNominalUFromPetersenCoilEvent event) {
    LOGGER.info("Event sourcing UnAssignNominalUFromPetersenCoilEvent");
    this.nominalU = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOffsetCurrentToPetersenCoilEvent event) {
    LOGGER.info("Event sourcing AssignOffsetCurrentToPetersenCoilEvent");
    this.offsetCurrent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOffsetCurrentFromPetersenCoilEvent event) {
    LOGGER.info("Event sourcing UnAssignOffsetCurrentFromPetersenCoilEvent");
    this.offsetCurrent = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPositionCurrentToPetersenCoilEvent event) {
    LOGGER.info("Event sourcing AssignPositionCurrentToPetersenCoilEvent");
    this.positionCurrent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPositionCurrentFromPetersenCoilEvent event) {
    LOGGER.info("Event sourcing UnAssignPositionCurrentFromPetersenCoilEvent");
    this.positionCurrent = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXGroundMaxToPetersenCoilEvent event) {
    LOGGER.info("Event sourcing AssignXGroundMaxToPetersenCoilEvent");
    this.xGroundMax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXGroundMaxFromPetersenCoilEvent event) {
    LOGGER.info("Event sourcing UnAssignXGroundMaxFromPetersenCoilEvent");
    this.xGroundMax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXGroundMinToPetersenCoilEvent event) {
    LOGGER.info("Event sourcing AssignXGroundMinToPetersenCoilEvent");
    this.xGroundMin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXGroundMinFromPetersenCoilEvent event) {
    LOGGER.info("Event sourcing UnAssignXGroundMinFromPetersenCoilEvent");
    this.xGroundMin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXGroundNominalToPetersenCoilEvent event) {
    LOGGER.info("Event sourcing AssignXGroundNominalToPetersenCoilEvent");
    this.xGroundNominal = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXGroundNominalFromPetersenCoilEvent event) {
    LOGGER.info("Event sourcing UnAssignXGroundNominalFromPetersenCoilEvent");
    this.xGroundNominal = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID petersenCoilId;

  private PetersenCoilModeKind mode;
  private Voltage nominalU = null;
  private CurrentFlow offsetCurrent = null;
  private CurrentFlow positionCurrent = null;
  private Reactance xGroundMax = null;
  private Reactance xGroundMin = null;
  private Reactance xGroundNominal = null;

  private static final Logger LOGGER = Logger.getLogger(PetersenCoilAggregate.class.getName());
}
