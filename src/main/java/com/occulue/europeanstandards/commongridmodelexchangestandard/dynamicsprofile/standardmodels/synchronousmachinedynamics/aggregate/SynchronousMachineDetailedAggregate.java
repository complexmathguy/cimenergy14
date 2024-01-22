package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.aggregate;

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
 * Aggregate handler for SynchronousMachineDetailed as outlined for the CQRS pattern, all write
 * responsibilities related to SynchronousMachineDetailed are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SynchronousMachineDetailedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SynchronousMachineDetailedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SynchronousMachineDetailedAggregate(CreateSynchronousMachineDetailedCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateSynchronousMachineDetailedCommand");
    CreateSynchronousMachineDetailedEvent event =
        new CreateSynchronousMachineDetailedEvent(
            command.getSynchronousMachineDetailedId(), command.getIfdBaseType());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSynchronousMachineDetailedCommand command) throws Exception {
    LOGGER.info("handling command UpdateSynchronousMachineDetailedCommand");
    UpdateSynchronousMachineDetailedEvent event =
        new UpdateSynchronousMachineDetailedEvent(
            command.getSynchronousMachineDetailedId(),
            command.getEfdBaseRatio(),
            command.getIfdBaseType(),
            command.getIfdBaseValue(),
            command.getSaturationFactor120QAxis(),
            command.getSaturationFactorQAxis());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSynchronousMachineDetailedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSynchronousMachineDetailedCommand");
    apply(new DeleteSynchronousMachineDetailedEvent(command.getSynchronousMachineDetailedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfdBaseRatioToSynchronousMachineDetailedCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignEfdBaseRatioToSynchronousMachineDetailedCommand");

    if (efdBaseRatio != null
        && efdBaseRatio.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "EfdBaseRatio already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignEfdBaseRatioToSynchronousMachineDetailedEvent(
            command.getSynchronousMachineDetailedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdBaseRatioFromSynchronousMachineDetailedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignEfdBaseRatioFromSynchronousMachineDetailedCommand");

    if (efdBaseRatio == null)
      throw new ProcessingException("EfdBaseRatio already has nothing assigned.");

    apply(
        new UnAssignEfdBaseRatioFromSynchronousMachineDetailedEvent(
            command.getSynchronousMachineDetailedId()));
  }

  @CommandHandler
  public void handle(AssignIfdBaseValueToSynchronousMachineDetailedCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignIfdBaseValueToSynchronousMachineDetailedCommand");

    if (ifdBaseValue != null
        && ifdBaseValue.getCurrentFlowId() == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "IfdBaseValue already assigned with id " + command.getAssignment().getCurrentFlowId());

    apply(
        new AssignIfdBaseValueToSynchronousMachineDetailedEvent(
            command.getSynchronousMachineDetailedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIfdBaseValueFromSynchronousMachineDetailedCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignIfdBaseValueFromSynchronousMachineDetailedCommand");

    if (ifdBaseValue == null)
      throw new ProcessingException("IfdBaseValue already has nothing assigned.");

    apply(
        new UnAssignIfdBaseValueFromSynchronousMachineDetailedEvent(
            command.getSynchronousMachineDetailedId()));
  }

  @CommandHandler
  public void handle(AssignSaturationFactor120QAxisToSynchronousMachineDetailedCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignSaturationFactor120QAxisToSynchronousMachineDetailedCommand");

    if (saturationFactor120QAxis != null
        && saturationFactor120QAxis.getSimple_FloatId()
            == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "SaturationFactor120QAxis already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignSaturationFactor120QAxisToSynchronousMachineDetailedEvent(
            command.getSynchronousMachineDetailedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedCommand");

    if (saturationFactor120QAxis == null)
      throw new ProcessingException("SaturationFactor120QAxis already has nothing assigned.");

    apply(
        new UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedEvent(
            command.getSynchronousMachineDetailedId()));
  }

  @CommandHandler
  public void handle(AssignSaturationFactorQAxisToSynchronousMachineDetailedCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignSaturationFactorQAxisToSynchronousMachineDetailedCommand");

    if (saturationFactorQAxis != null
        && saturationFactorQAxis.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "SaturationFactorQAxis already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignSaturationFactorQAxisToSynchronousMachineDetailedEvent(
            command.getSynchronousMachineDetailedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedCommand");

    if (saturationFactorQAxis == null)
      throw new ProcessingException("SaturationFactorQAxis already has nothing assigned.");

    apply(
        new UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedEvent(
            command.getSynchronousMachineDetailedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSynchronousMachineDetailedEvent event) {
    LOGGER.info("Event sourcing CreateSynchronousMachineDetailedEvent");
    this.synchronousMachineDetailedId = event.getSynchronousMachineDetailedId();
    this.ifdBaseType = event.getIfdBaseType();
  }

  @EventSourcingHandler
  void on(UpdateSynchronousMachineDetailedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efdBaseRatio = event.getEfdBaseRatio();
    this.ifdBaseType = event.getIfdBaseType();
    this.ifdBaseValue = event.getIfdBaseValue();
    this.saturationFactor120QAxis = event.getSaturationFactor120QAxis();
    this.saturationFactorQAxis = event.getSaturationFactorQAxis();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfdBaseRatioToSynchronousMachineDetailedEvent event) {
    LOGGER.info("Event sourcing AssignEfdBaseRatioToSynchronousMachineDetailedEvent");
    this.efdBaseRatio = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdBaseRatioFromSynchronousMachineDetailedEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdBaseRatioFromSynchronousMachineDetailedEvent");
    this.efdBaseRatio = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIfdBaseValueToSynchronousMachineDetailedEvent event) {
    LOGGER.info("Event sourcing AssignIfdBaseValueToSynchronousMachineDetailedEvent");
    this.ifdBaseValue = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIfdBaseValueFromSynchronousMachineDetailedEvent event) {
    LOGGER.info("Event sourcing UnAssignIfdBaseValueFromSynchronousMachineDetailedEvent");
    this.ifdBaseValue = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSaturationFactor120QAxisToSynchronousMachineDetailedEvent event) {
    LOGGER.info("Event sourcing AssignSaturationFactor120QAxisToSynchronousMachineDetailedEvent");
    this.saturationFactor120QAxis = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedEvent");
    this.saturationFactor120QAxis = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSaturationFactorQAxisToSynchronousMachineDetailedEvent event) {
    LOGGER.info("Event sourcing AssignSaturationFactorQAxisToSynchronousMachineDetailedEvent");
    this.saturationFactorQAxis = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedEvent event) {
    LOGGER.info("Event sourcing UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedEvent");
    this.saturationFactorQAxis = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID synchronousMachineDetailedId;

  private IfdBaseKind ifdBaseType;
  private Simple_Float efdBaseRatio = null;
  private CurrentFlow ifdBaseValue = null;
  private Simple_Float saturationFactor120QAxis = null;
  private Simple_Float saturationFactorQAxis = null;

  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineDetailedAggregate.class.getName());
}
