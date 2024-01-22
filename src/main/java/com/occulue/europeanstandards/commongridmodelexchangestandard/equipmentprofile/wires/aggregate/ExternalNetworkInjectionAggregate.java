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
 * Aggregate handler for ExternalNetworkInjection as outlined for the CQRS pattern, all write
 * responsibilities related to ExternalNetworkInjection are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExternalNetworkInjectionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExternalNetworkInjectionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExternalNetworkInjectionAggregate(CreateExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateExternalNetworkInjectionCommand");
    CreateExternalNetworkInjectionEvent event =
        new CreateExternalNetworkInjectionEvent(command.getExternalNetworkInjectionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExternalNetworkInjectionCommand command) throws Exception {
    LOGGER.info("handling command UpdateExternalNetworkInjectionCommand");
    UpdateExternalNetworkInjectionEvent event =
        new UpdateExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(),
            command.getGovernorSCD(),
            command.getIkSecond(),
            command.getMaxInitialSymShCCurrent(),
            command.getMaxP(),
            command.getMaxQ(),
            command.getMaxR0ToX0Ratio(),
            command.getMaxR1ToX1Ratio(),
            command.getMaxZ0ToZ1Ratio(),
            command.getMinInitialSymShCCurrent(),
            command.getMinP(),
            command.getMinQ(),
            command.getMinR0ToX0Ratio(),
            command.getMinR1ToX1Ratio(),
            command.getMinZ0ToZ1Ratio(),
            command.getVoltageFactor());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExternalNetworkInjectionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExternalNetworkInjectionCommand");
    apply(new DeleteExternalNetworkInjectionEvent(command.getExternalNetworkInjectionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignGovernorSCDToExternalNetworkInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignGovernorSCDToExternalNetworkInjectionCommand");

    if (governorSCD != null
        && governorSCD.getActivePowerPerFrequencyId()
            == command.getAssignment().getActivePowerPerFrequencyId())
      throw new ProcessingException(
          "GovernorSCD already assigned with id "
              + command.getAssignment().getActivePowerPerFrequencyId());

    apply(
        new AssignGovernorSCDToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGovernorSCDFromExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignGovernorSCDFromExternalNetworkInjectionCommand");

    if (governorSCD == null)
      throw new ProcessingException("GovernorSCD already has nothing assigned.");

    apply(
        new UnAssignGovernorSCDFromExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId()));
  }

  @CommandHandler
  public void handle(AssignIkSecondToExternalNetworkInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignIkSecondToExternalNetworkInjectionCommand");

    if (ikSecond != null
        && ikSecond.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "IkSecond already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignIkSecondToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIkSecondFromExternalNetworkInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIkSecondFromExternalNetworkInjectionCommand");

    if (ikSecond == null) throw new ProcessingException("IkSecond already has nothing assigned.");

    apply(
        new UnAssignIkSecondFromExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMaxInitialSymShCCurrentToExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignMaxInitialSymShCCurrentToExternalNetworkInjectionCommand");

    if (maxInitialSymShCCurrent != null
        && maxInitialSymShCCurrent.getCurrentFlowId() == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "MaxInitialSymShCCurrent already assigned with id "
              + command.getAssignment().getCurrentFlowId());

    apply(
        new AssignMaxInitialSymShCCurrentToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionCommand");

    if (maxInitialSymShCCurrent == null)
      throw new ProcessingException("MaxInitialSymShCCurrent already has nothing assigned.");

    apply(
        new UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMaxPToExternalNetworkInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignMaxPToExternalNetworkInjectionCommand");

    if (maxP != null && maxP.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "MaxP already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignMaxPToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxPFromExternalNetworkInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxPFromExternalNetworkInjectionCommand");

    if (maxP == null) throw new ProcessingException("MaxP already has nothing assigned.");

    apply(
        new UnAssignMaxPFromExternalNetworkInjectionEvent(command.getExternalNetworkInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMaxQToExternalNetworkInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignMaxQToExternalNetworkInjectionCommand");

    if (maxQ != null && maxQ.getReactivePowerId() == command.getAssignment().getReactivePowerId())
      throw new ProcessingException(
          "MaxQ already assigned with id " + command.getAssignment().getReactivePowerId());

    apply(
        new AssignMaxQToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxQFromExternalNetworkInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxQFromExternalNetworkInjectionCommand");

    if (maxQ == null) throw new ProcessingException("MaxQ already has nothing assigned.");

    apply(
        new UnAssignMaxQFromExternalNetworkInjectionEvent(command.getExternalNetworkInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMaxR0ToX0RatioToExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignMaxR0ToX0RatioToExternalNetworkInjectionCommand");

    if (maxR0ToX0Ratio != null
        && maxR0ToX0Ratio.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "MaxR0ToX0Ratio already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignMaxR0ToX0RatioToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionCommand");

    if (maxR0ToX0Ratio == null)
      throw new ProcessingException("MaxR0ToX0Ratio already has nothing assigned.");

    apply(
        new UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMaxR1ToX1RatioToExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignMaxR1ToX1RatioToExternalNetworkInjectionCommand");

    if (maxR1ToX1Ratio != null
        && maxR1ToX1Ratio.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "MaxR1ToX1Ratio already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignMaxR1ToX1RatioToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionCommand");

    if (maxR1ToX1Ratio == null)
      throw new ProcessingException("MaxR1ToX1Ratio already has nothing assigned.");

    apply(
        new UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMaxZ0ToZ1RatioToExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignMaxZ0ToZ1RatioToExternalNetworkInjectionCommand");

    if (maxZ0ToZ1Ratio != null
        && maxZ0ToZ1Ratio.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "MaxZ0ToZ1Ratio already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignMaxZ0ToZ1RatioToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionCommand");

    if (maxZ0ToZ1Ratio == null)
      throw new ProcessingException("MaxZ0ToZ1Ratio already has nothing assigned.");

    apply(
        new UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMinInitialSymShCCurrentToExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignMinInitialSymShCCurrentToExternalNetworkInjectionCommand");

    if (minInitialSymShCCurrent != null
        && minInitialSymShCCurrent.getCurrentFlowId() == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "MinInitialSymShCCurrent already assigned with id "
              + command.getAssignment().getCurrentFlowId());

    apply(
        new AssignMinInitialSymShCCurrentToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionCommand");

    if (minInitialSymShCCurrent == null)
      throw new ProcessingException("MinInitialSymShCCurrent already has nothing assigned.");

    apply(
        new UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMinPToExternalNetworkInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignMinPToExternalNetworkInjectionCommand");

    if (minP != null && minP.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "MinP already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignMinPToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinPFromExternalNetworkInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMinPFromExternalNetworkInjectionCommand");

    if (minP == null) throw new ProcessingException("MinP already has nothing assigned.");

    apply(
        new UnAssignMinPFromExternalNetworkInjectionEvent(command.getExternalNetworkInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMinQToExternalNetworkInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignMinQToExternalNetworkInjectionCommand");

    if (minQ != null && minQ.getReactivePowerId() == command.getAssignment().getReactivePowerId())
      throw new ProcessingException(
          "MinQ already assigned with id " + command.getAssignment().getReactivePowerId());

    apply(
        new AssignMinQToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinQFromExternalNetworkInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMinQFromExternalNetworkInjectionCommand");

    if (minQ == null) throw new ProcessingException("MinQ already has nothing assigned.");

    apply(
        new UnAssignMinQFromExternalNetworkInjectionEvent(command.getExternalNetworkInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMinR0ToX0RatioToExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignMinR0ToX0RatioToExternalNetworkInjectionCommand");

    if (minR0ToX0Ratio != null
        && minR0ToX0Ratio.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "MinR0ToX0Ratio already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignMinR0ToX0RatioToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinR0ToX0RatioFromExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignMinR0ToX0RatioFromExternalNetworkInjectionCommand");

    if (minR0ToX0Ratio == null)
      throw new ProcessingException("MinR0ToX0Ratio already has nothing assigned.");

    apply(
        new UnAssignMinR0ToX0RatioFromExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMinR1ToX1RatioToExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignMinR1ToX1RatioToExternalNetworkInjectionCommand");

    if (minR1ToX1Ratio != null
        && minR1ToX1Ratio.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "MinR1ToX1Ratio already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignMinR1ToX1RatioToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinR1ToX1RatioFromExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignMinR1ToX1RatioFromExternalNetworkInjectionCommand");

    if (minR1ToX1Ratio == null)
      throw new ProcessingException("MinR1ToX1Ratio already has nothing assigned.");

    apply(
        new UnAssignMinR1ToX1RatioFromExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMinZ0ToZ1RatioToExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignMinZ0ToZ1RatioToExternalNetworkInjectionCommand");

    if (minZ0ToZ1Ratio != null
        && minZ0ToZ1Ratio.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "MinZ0ToZ1Ratio already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignMinZ0ToZ1RatioToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionCommand");

    if (minZ0ToZ1Ratio == null)
      throw new ProcessingException("MinZ0ToZ1Ratio already has nothing assigned.");

    apply(
        new UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId()));
  }

  @CommandHandler
  public void handle(AssignVoltageFactorToExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignVoltageFactorToExternalNetworkInjectionCommand");

    if (voltageFactor != null && voltageFactor.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "VoltageFactor already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVoltageFactorToExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVoltageFactorFromExternalNetworkInjectionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignVoltageFactorFromExternalNetworkInjectionCommand");

    if (voltageFactor == null)
      throw new ProcessingException("VoltageFactor already has nothing assigned.");

    apply(
        new UnAssignVoltageFactorFromExternalNetworkInjectionEvent(
            command.getExternalNetworkInjectionId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing CreateExternalNetworkInjectionEvent");
    this.externalNetworkInjectionId = event.getExternalNetworkInjectionId();
  }

  @EventSourcingHandler
  void on(UpdateExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.governorSCD = event.getGovernorSCD();
    this.ikSecond = event.getIkSecond();
    this.maxInitialSymShCCurrent = event.getMaxInitialSymShCCurrent();
    this.maxP = event.getMaxP();
    this.maxQ = event.getMaxQ();
    this.maxR0ToX0Ratio = event.getMaxR0ToX0Ratio();
    this.maxR1ToX1Ratio = event.getMaxR1ToX1Ratio();
    this.maxZ0ToZ1Ratio = event.getMaxZ0ToZ1Ratio();
    this.minInitialSymShCCurrent = event.getMinInitialSymShCCurrent();
    this.minP = event.getMinP();
    this.minQ = event.getMinQ();
    this.minR0ToX0Ratio = event.getMinR0ToX0Ratio();
    this.minR1ToX1Ratio = event.getMinR1ToX1Ratio();
    this.minZ0ToZ1Ratio = event.getMinZ0ToZ1Ratio();
    this.voltageFactor = event.getVoltageFactor();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignGovernorSCDToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignGovernorSCDToExternalNetworkInjectionEvent");
    this.governorSCD = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGovernorSCDFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignGovernorSCDFromExternalNetworkInjectionEvent");
    this.governorSCD = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIkSecondToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignIkSecondToExternalNetworkInjectionEvent");
    this.ikSecond = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIkSecondFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignIkSecondFromExternalNetworkInjectionEvent");
    this.ikSecond = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxInitialSymShCCurrentToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMaxInitialSymShCCurrentToExternalNetworkInjectionEvent");
    this.maxInitialSymShCCurrent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionEvent");
    this.maxInitialSymShCCurrent = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxPToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMaxPToExternalNetworkInjectionEvent");
    this.maxP = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxPFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxPFromExternalNetworkInjectionEvent");
    this.maxP = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxQToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMaxQToExternalNetworkInjectionEvent");
    this.maxQ = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxQFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxQFromExternalNetworkInjectionEvent");
    this.maxQ = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxR0ToX0RatioToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMaxR0ToX0RatioToExternalNetworkInjectionEvent");
    this.maxR0ToX0Ratio = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionEvent");
    this.maxR0ToX0Ratio = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxR1ToX1RatioToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMaxR1ToX1RatioToExternalNetworkInjectionEvent");
    this.maxR1ToX1Ratio = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionEvent");
    this.maxR1ToX1Ratio = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxZ0ToZ1RatioToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMaxZ0ToZ1RatioToExternalNetworkInjectionEvent");
    this.maxZ0ToZ1Ratio = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionEvent");
    this.maxZ0ToZ1Ratio = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinInitialSymShCCurrentToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMinInitialSymShCCurrentToExternalNetworkInjectionEvent");
    this.minInitialSymShCCurrent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionEvent");
    this.minInitialSymShCCurrent = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinPToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMinPToExternalNetworkInjectionEvent");
    this.minP = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinPFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMinPFromExternalNetworkInjectionEvent");
    this.minP = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinQToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMinQToExternalNetworkInjectionEvent");
    this.minQ = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinQFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMinQFromExternalNetworkInjectionEvent");
    this.minQ = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinR0ToX0RatioToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMinR0ToX0RatioToExternalNetworkInjectionEvent");
    this.minR0ToX0Ratio = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinR0ToX0RatioFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMinR0ToX0RatioFromExternalNetworkInjectionEvent");
    this.minR0ToX0Ratio = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinR1ToX1RatioToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMinR1ToX1RatioToExternalNetworkInjectionEvent");
    this.minR1ToX1Ratio = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinR1ToX1RatioFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMinR1ToX1RatioFromExternalNetworkInjectionEvent");
    this.minR1ToX1Ratio = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinZ0ToZ1RatioToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMinZ0ToZ1RatioToExternalNetworkInjectionEvent");
    this.minZ0ToZ1Ratio = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionEvent");
    this.minZ0ToZ1Ratio = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVoltageFactorToExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing AssignVoltageFactorToExternalNetworkInjectionEvent");
    this.voltageFactor = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVoltageFactorFromExternalNetworkInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignVoltageFactorFromExternalNetworkInjectionEvent");
    this.voltageFactor = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID externalNetworkInjectionId;

  private ActivePowerPerFrequency governorSCD = null;
  private BooleanProxy ikSecond = null;
  private CurrentFlow maxInitialSymShCCurrent = null;
  private ActivePower maxP = null;
  private ReactivePower maxQ = null;
  private Simple_Float maxR0ToX0Ratio = null;
  private Simple_Float maxR1ToX1Ratio = null;
  private Simple_Float maxZ0ToZ1Ratio = null;
  private CurrentFlow minInitialSymShCCurrent = null;
  private ActivePower minP = null;
  private ReactivePower minQ = null;
  private Simple_Float minR0ToX0Ratio = null;
  private Simple_Float minR1ToX1Ratio = null;
  private Simple_Float minZ0ToZ1Ratio = null;
  private PU voltageFactor = null;

  private static final Logger LOGGER =
      Logger.getLogger(ExternalNetworkInjectionAggregate.class.getName());
}
