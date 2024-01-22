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
 * Aggregate handler for SynchronousMachine as outlined for the CQRS pattern, all write
 * responsibilities related to SynchronousMachine are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SynchronousMachineAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SynchronousMachineAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SynchronousMachineAggregate(CreateSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command CreateSynchronousMachineCommand");
    CreateSynchronousMachineEvent event =
        new CreateSynchronousMachineEvent(
            command.getSynchronousMachineId(),
            command.getShortCircuitRotorType(),
            command.getType());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSynchronousMachineCommand command) throws Exception {
    LOGGER.info("handling command UpdateSynchronousMachineCommand");
    UpdateSynchronousMachineEvent event =
        new UpdateSynchronousMachineEvent(
            command.getSynchronousMachineId(),
            command.getEarthing(),
            command.getEarthingStarPointR(),
            command.getEarthingStarPointX(),
            command.getIkk(),
            command.getMaxQ(),
            command.getMinQ(),
            command.getMu(),
            command.getQPercent(),
            command.getR(),
            command.getR0(),
            command.getR2(),
            command.getSatDirectSubtransX(),
            command.getSatDirectSyncX(),
            command.getSatDirectTransX(),
            command.getShortCircuitRotorType(),
            command.getType(),
            command.getVoltageRegulationRange(),
            command.getX0(),
            command.getX2(),
            command.getInitiallyUsedBySynchronousMachines());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSynchronousMachineCommand");
    apply(new DeleteSynchronousMachineEvent(command.getSynchronousMachineId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEarthingToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignEarthingToSynchronousMachineCommand");

    if (earthing != null
        && earthing.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Earthing already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignEarthingToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEarthingFromSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEarthingFromSynchronousMachineCommand");

    if (earthing == null) throw new ProcessingException("Earthing already has nothing assigned.");

    apply(new UnAssignEarthingFromSynchronousMachineEvent(command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignEarthingStarPointRToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignEarthingStarPointRToSynchronousMachineCommand");

    if (earthingStarPointR != null
        && earthingStarPointR.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "EarthingStarPointR already assigned with id "
              + command.getAssignment().getResistanceId());

    apply(
        new AssignEarthingStarPointRToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEarthingStarPointRFromSynchronousMachineCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignEarthingStarPointRFromSynchronousMachineCommand");

    if (earthingStarPointR == null)
      throw new ProcessingException("EarthingStarPointR already has nothing assigned.");

    apply(
        new UnAssignEarthingStarPointRFromSynchronousMachineEvent(
            command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignEarthingStarPointXToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignEarthingStarPointXToSynchronousMachineCommand");

    if (earthingStarPointX != null
        && earthingStarPointX.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "EarthingStarPointX already assigned with id "
              + command.getAssignment().getReactanceId());

    apply(
        new AssignEarthingStarPointXToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEarthingStarPointXFromSynchronousMachineCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignEarthingStarPointXFromSynchronousMachineCommand");

    if (earthingStarPointX == null)
      throw new ProcessingException("EarthingStarPointX already has nothing assigned.");

    apply(
        new UnAssignEarthingStarPointXFromSynchronousMachineEvent(
            command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignIkkToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignIkkToSynchronousMachineCommand");

    if (ikk != null && ikk.getCurrentFlowId() == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "Ikk already assigned with id " + command.getAssignment().getCurrentFlowId());

    apply(
        new AssignIkkToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIkkFromSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIkkFromSynchronousMachineCommand");

    if (ikk == null) throw new ProcessingException("Ikk already has nothing assigned.");

    apply(new UnAssignIkkFromSynchronousMachineEvent(command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignMaxQToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignMaxQToSynchronousMachineCommand");

    if (maxQ != null && maxQ.getReactivePowerId() == command.getAssignment().getReactivePowerId())
      throw new ProcessingException(
          "MaxQ already assigned with id " + command.getAssignment().getReactivePowerId());

    apply(
        new AssignMaxQToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxQFromSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxQFromSynchronousMachineCommand");

    if (maxQ == null) throw new ProcessingException("MaxQ already has nothing assigned.");

    apply(new UnAssignMaxQFromSynchronousMachineEvent(command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignMinQToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignMinQToSynchronousMachineCommand");

    if (minQ != null && minQ.getReactivePowerId() == command.getAssignment().getReactivePowerId())
      throw new ProcessingException(
          "MinQ already assigned with id " + command.getAssignment().getReactivePowerId());

    apply(
        new AssignMinQToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinQFromSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMinQFromSynchronousMachineCommand");

    if (minQ == null) throw new ProcessingException("MinQ already has nothing assigned.");

    apply(new UnAssignMinQFromSynchronousMachineEvent(command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignMuToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignMuToSynchronousMachineCommand");

    if (mu != null && mu.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Mu already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignMuToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMuFromSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMuFromSynchronousMachineCommand");

    if (mu == null) throw new ProcessingException("Mu already has nothing assigned.");

    apply(new UnAssignMuFromSynchronousMachineEvent(command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignQPercentToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignQPercentToSynchronousMachineCommand");

    if (qPercent != null && qPercent.getPerCentId() == command.getAssignment().getPerCentId())
      throw new ProcessingException(
          "QPercent already assigned with id " + command.getAssignment().getPerCentId());

    apply(
        new AssignQPercentToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQPercentFromSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQPercentFromSynchronousMachineCommand");

    if (qPercent == null) throw new ProcessingException("QPercent already has nothing assigned.");

    apply(new UnAssignQPercentFromSynchronousMachineEvent(command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignRToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignRToSynchronousMachineCommand");

    if (r != null && r.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignRToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromSynchronousMachineCommand");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromSynchronousMachineEvent(command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignR0ToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignR0ToSynchronousMachineCommand");

    if (r0 != null && r0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R0 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignR0ToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignR0FromSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignR0FromSynchronousMachineCommand");

    if (r0 == null) throw new ProcessingException("R0 already has nothing assigned.");

    apply(new UnAssignR0FromSynchronousMachineEvent(command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignR2ToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignR2ToSynchronousMachineCommand");

    if (r2 != null && r2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R2 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignR2ToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignR2FromSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignR2FromSynchronousMachineCommand");

    if (r2 == null) throw new ProcessingException("R2 already has nothing assigned.");

    apply(new UnAssignR2FromSynchronousMachineEvent(command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignSatDirectSubtransXToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignSatDirectSubtransXToSynchronousMachineCommand");

    if (satDirectSubtransX != null
        && satDirectSubtransX.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "SatDirectSubtransX already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignSatDirectSubtransXToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSatDirectSubtransXFromSynchronousMachineCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignSatDirectSubtransXFromSynchronousMachineCommand");

    if (satDirectSubtransX == null)
      throw new ProcessingException("SatDirectSubtransX already has nothing assigned.");

    apply(
        new UnAssignSatDirectSubtransXFromSynchronousMachineEvent(
            command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignSatDirectSyncXToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignSatDirectSyncXToSynchronousMachineCommand");

    if (satDirectSyncX != null && satDirectSyncX.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "SatDirectSyncX already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignSatDirectSyncXToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSatDirectSyncXFromSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSatDirectSyncXFromSynchronousMachineCommand");

    if (satDirectSyncX == null)
      throw new ProcessingException("SatDirectSyncX already has nothing assigned.");

    apply(new UnAssignSatDirectSyncXFromSynchronousMachineEvent(command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignSatDirectTransXToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignSatDirectTransXToSynchronousMachineCommand");

    if (satDirectTransX != null && satDirectTransX.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "SatDirectTransX already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignSatDirectTransXToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSatDirectTransXFromSynchronousMachineCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignSatDirectTransXFromSynchronousMachineCommand");

    if (satDirectTransX == null)
      throw new ProcessingException("SatDirectTransX already has nothing assigned.");

    apply(
        new UnAssignSatDirectTransXFromSynchronousMachineEvent(command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignVoltageRegulationRangeToSynchronousMachineCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignVoltageRegulationRangeToSynchronousMachineCommand");

    if (voltageRegulationRange != null
        && voltageRegulationRange.getPerCentId() == command.getAssignment().getPerCentId())
      throw new ProcessingException(
          "VoltageRegulationRange already assigned with id "
              + command.getAssignment().getPerCentId());

    apply(
        new AssignVoltageRegulationRangeToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVoltageRegulationRangeFromSynchronousMachineCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignVoltageRegulationRangeFromSynchronousMachineCommand");

    if (voltageRegulationRange == null)
      throw new ProcessingException("VoltageRegulationRange already has nothing assigned.");

    apply(
        new UnAssignVoltageRegulationRangeFromSynchronousMachineEvent(
            command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignX0ToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignX0ToSynchronousMachineCommand");

    if (x0 != null && x0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "X0 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignX0ToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignX0FromSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignX0FromSynchronousMachineCommand");

    if (x0 == null) throw new ProcessingException("X0 already has nothing assigned.");

    apply(new UnAssignX0FromSynchronousMachineEvent(command.getSynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignX2ToSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignX2ToSynchronousMachineCommand");

    if (x2 != null && x2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "X2 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignX2ToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignX2FromSynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignX2FromSynchronousMachineCommand");

    if (x2 == null) throw new ProcessingException("X2 already has nothing assigned.");

    apply(new UnAssignX2FromSynchronousMachineEvent(command.getSynchronousMachineId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineCommand");

    if (initiallyUsedBySynchronousMachines.contains(command.getAddTo()))
      throw new ProcessingException(
          "InitiallyUsedBySynchronousMachines already contains an entity with id "
              + command.getAddTo().getSynchronousMachineId());

    apply(
        new AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineCommand");

    if (!initiallyUsedBySynchronousMachines.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "InitiallyUsedBySynchronousMachines does not contain an entity with id "
              + command.getRemoveFrom().getSynchronousMachineId());

    apply(
        new RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineEvent(
            command.getSynchronousMachineId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing CreateSynchronousMachineEvent");
    this.synchronousMachineId = event.getSynchronousMachineId();
    this.shortCircuitRotorType = event.getShortCircuitRotorType();
    this.type = event.getType();
  }

  @EventSourcingHandler
  void on(UpdateSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.earthing = event.getEarthing();
    this.earthingStarPointR = event.getEarthingStarPointR();
    this.earthingStarPointX = event.getEarthingStarPointX();
    this.ikk = event.getIkk();
    this.maxQ = event.getMaxQ();
    this.minQ = event.getMinQ();
    this.mu = event.getMu();
    this.qPercent = event.getQPercent();
    this.r = event.getR();
    this.r0 = event.getR0();
    this.r2 = event.getR2();
    this.satDirectSubtransX = event.getSatDirectSubtransX();
    this.satDirectSyncX = event.getSatDirectSyncX();
    this.satDirectTransX = event.getSatDirectTransX();
    this.shortCircuitRotorType = event.getShortCircuitRotorType();
    this.type = event.getType();
    this.voltageRegulationRange = event.getVoltageRegulationRange();
    this.x0 = event.getX0();
    this.x2 = event.getX2();
    this.initiallyUsedBySynchronousMachines = event.getInitiallyUsedBySynchronousMachines();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEarthingToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignEarthingToSynchronousMachineEvent");
    this.earthing = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEarthingFromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignEarthingFromSynchronousMachineEvent");
    this.earthing = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEarthingStarPointRToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignEarthingStarPointRToSynchronousMachineEvent");
    this.earthingStarPointR = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEarthingStarPointRFromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignEarthingStarPointRFromSynchronousMachineEvent");
    this.earthingStarPointR = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEarthingStarPointXToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignEarthingStarPointXToSynchronousMachineEvent");
    this.earthingStarPointX = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEarthingStarPointXFromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignEarthingStarPointXFromSynchronousMachineEvent");
    this.earthingStarPointX = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIkkToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignIkkToSynchronousMachineEvent");
    this.ikk = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIkkFromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignIkkFromSynchronousMachineEvent");
    this.ikk = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxQToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignMaxQToSynchronousMachineEvent");
    this.maxQ = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxQFromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxQFromSynchronousMachineEvent");
    this.maxQ = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinQToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignMinQToSynchronousMachineEvent");
    this.minQ = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinQFromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignMinQFromSynchronousMachineEvent");
    this.minQ = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMuToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignMuToSynchronousMachineEvent");
    this.mu = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMuFromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignMuFromSynchronousMachineEvent");
    this.mu = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQPercentToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignQPercentToSynchronousMachineEvent");
    this.qPercent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQPercentFromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignQPercentFromSynchronousMachineEvent");
    this.qPercent = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignRToSynchronousMachineEvent");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignRFromSynchronousMachineEvent");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignR0ToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignR0ToSynchronousMachineEvent");
    this.r0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignR0FromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignR0FromSynchronousMachineEvent");
    this.r0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignR2ToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignR2ToSynchronousMachineEvent");
    this.r2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignR2FromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignR2FromSynchronousMachineEvent");
    this.r2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSatDirectSubtransXToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignSatDirectSubtransXToSynchronousMachineEvent");
    this.satDirectSubtransX = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSatDirectSubtransXFromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignSatDirectSubtransXFromSynchronousMachineEvent");
    this.satDirectSubtransX = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSatDirectSyncXToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignSatDirectSyncXToSynchronousMachineEvent");
    this.satDirectSyncX = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSatDirectSyncXFromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignSatDirectSyncXFromSynchronousMachineEvent");
    this.satDirectSyncX = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSatDirectTransXToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignSatDirectTransXToSynchronousMachineEvent");
    this.satDirectTransX = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSatDirectTransXFromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignSatDirectTransXFromSynchronousMachineEvent");
    this.satDirectTransX = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVoltageRegulationRangeToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignVoltageRegulationRangeToSynchronousMachineEvent");
    this.voltageRegulationRange = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVoltageRegulationRangeFromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignVoltageRegulationRangeFromSynchronousMachineEvent");
    this.voltageRegulationRange = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignX0ToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignX0ToSynchronousMachineEvent");
    this.x0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignX0FromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignX0FromSynchronousMachineEvent");
    this.x0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignX2ToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignX2ToSynchronousMachineEvent");
    this.x2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignX2FromSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignX2FromSynchronousMachineEvent");
    this.x2 = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineEvent");
    this.initiallyUsedBySynchronousMachines.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineEvent event) {
    LOGGER.info(
        "Event sourcing RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineEvent");
    this.initiallyUsedBySynchronousMachines.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID synchronousMachineId;

  private ShortCircuitRotorKind shortCircuitRotorType;
  private SynchronousMachineKind type;
  private BooleanProxy earthing = null;
  private Resistance earthingStarPointR = null;
  private Reactance earthingStarPointX = null;
  private CurrentFlow ikk = null;
  private ReactivePower maxQ = null;
  private ReactivePower minQ = null;
  private Simple_Float mu = null;
  private PerCent qPercent = null;
  private Resistance r = null;
  private PU r0 = null;
  private PU r2 = null;
  private PU satDirectSubtransX = null;
  private PU satDirectSyncX = null;
  private PU satDirectTransX = null;
  private PerCent voltageRegulationRange = null;
  private PU x0 = null;
  private PU x2 = null;
  private Set<SynchronousMachine> initiallyUsedBySynchronousMachines = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineAggregate.class.getName());
}
