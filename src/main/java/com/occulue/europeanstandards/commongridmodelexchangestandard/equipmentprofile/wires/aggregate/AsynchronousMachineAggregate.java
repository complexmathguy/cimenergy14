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
 * Aggregate handler for AsynchronousMachine as outlined for the CQRS pattern, all write
 * responsibilities related to AsynchronousMachine are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AsynchronousMachineAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AsynchronousMachineAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AsynchronousMachineAggregate(CreateAsynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command CreateAsynchronousMachineCommand");
    CreateAsynchronousMachineEvent event =
        new CreateAsynchronousMachineEvent(command.getAsynchronousMachineId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAsynchronousMachineCommand command) throws Exception {
    LOGGER.info("handling command UpdateAsynchronousMachineCommand");
    UpdateAsynchronousMachineEvent event =
        new UpdateAsynchronousMachineEvent(
            command.getAsynchronousMachineId(),
            command.getConverterFedDrive(),
            command.getEfficiency(),
            command.getIaIrRatio(),
            command.getNominalFrequency(),
            command.getNominalSpeed(),
            command.getPolePairNumber(),
            command.getRatedMechanicalPower(),
            command.getReversible(),
            command.getRxLockedRotorRatio());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAsynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAsynchronousMachineCommand");
    apply(new DeleteAsynchronousMachineEvent(command.getAsynchronousMachineId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignConverterFedDriveToAsynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignConverterFedDriveToAsynchronousMachineCommand");

    if (converterFedDrive != null
        && converterFedDrive.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "ConverterFedDrive already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignConverterFedDriveToAsynchronousMachineEvent(
            command.getAsynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignConverterFedDriveFromAsynchronousMachineCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignConverterFedDriveFromAsynchronousMachineCommand");

    if (converterFedDrive == null)
      throw new ProcessingException("ConverterFedDrive already has nothing assigned.");

    apply(
        new UnAssignConverterFedDriveFromAsynchronousMachineEvent(
            command.getAsynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignEfficiencyToAsynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignEfficiencyToAsynchronousMachineCommand");

    if (efficiency != null && efficiency.getPerCentId() == command.getAssignment().getPerCentId())
      throw new ProcessingException(
          "Efficiency already assigned with id " + command.getAssignment().getPerCentId());

    apply(
        new AssignEfficiencyToAsynchronousMachineEvent(
            command.getAsynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfficiencyFromAsynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfficiencyFromAsynchronousMachineCommand");

    if (efficiency == null)
      throw new ProcessingException("Efficiency already has nothing assigned.");

    apply(new UnAssignEfficiencyFromAsynchronousMachineEvent(command.getAsynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignIaIrRatioToAsynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignIaIrRatioToAsynchronousMachineCommand");

    if (iaIrRatio != null
        && iaIrRatio.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "IaIrRatio already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignIaIrRatioToAsynchronousMachineEvent(
            command.getAsynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIaIrRatioFromAsynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIaIrRatioFromAsynchronousMachineCommand");

    if (iaIrRatio == null) throw new ProcessingException("IaIrRatio already has nothing assigned.");

    apply(new UnAssignIaIrRatioFromAsynchronousMachineEvent(command.getAsynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignNominalFrequencyToAsynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignNominalFrequencyToAsynchronousMachineCommand");

    if (nominalFrequency != null
        && nominalFrequency.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "NominalFrequency already assigned with id " + command.getAssignment().getFrequencyId());

    apply(
        new AssignNominalFrequencyToAsynchronousMachineEvent(
            command.getAsynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNominalFrequencyFromAsynchronousMachineCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignNominalFrequencyFromAsynchronousMachineCommand");

    if (nominalFrequency == null)
      throw new ProcessingException("NominalFrequency already has nothing assigned.");

    apply(
        new UnAssignNominalFrequencyFromAsynchronousMachineEvent(
            command.getAsynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignNominalSpeedToAsynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignNominalSpeedToAsynchronousMachineCommand");

    if (nominalSpeed != null
        && nominalSpeed.getRotationSpeedId() == command.getAssignment().getRotationSpeedId())
      throw new ProcessingException(
          "NominalSpeed already assigned with id " + command.getAssignment().getRotationSpeedId());

    apply(
        new AssignNominalSpeedToAsynchronousMachineEvent(
            command.getAsynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNominalSpeedFromAsynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNominalSpeedFromAsynchronousMachineCommand");

    if (nominalSpeed == null)
      throw new ProcessingException("NominalSpeed already has nothing assigned.");

    apply(new UnAssignNominalSpeedFromAsynchronousMachineEvent(command.getAsynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignPolePairNumberToAsynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignPolePairNumberToAsynchronousMachineCommand");

    if (polePairNumber != null
        && polePairNumber.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "PolePairNumber already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignPolePairNumberToAsynchronousMachineEvent(
            command.getAsynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPolePairNumberFromAsynchronousMachineCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignPolePairNumberFromAsynchronousMachineCommand");

    if (polePairNumber == null)
      throw new ProcessingException("PolePairNumber already has nothing assigned.");

    apply(
        new UnAssignPolePairNumberFromAsynchronousMachineEvent(command.getAsynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignRatedMechanicalPowerToAsynchronousMachineCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignRatedMechanicalPowerToAsynchronousMachineCommand");

    if (ratedMechanicalPower != null
        && ratedMechanicalPower.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "RatedMechanicalPower already assigned with id "
              + command.getAssignment().getActivePowerId());

    apply(
        new AssignRatedMechanicalPowerToAsynchronousMachineEvent(
            command.getAsynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRatedMechanicalPowerFromAsynchronousMachineCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignRatedMechanicalPowerFromAsynchronousMachineCommand");

    if (ratedMechanicalPower == null)
      throw new ProcessingException("RatedMechanicalPower already has nothing assigned.");

    apply(
        new UnAssignRatedMechanicalPowerFromAsynchronousMachineEvent(
            command.getAsynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignReversibleToAsynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handling command AssignReversibleToAsynchronousMachineCommand");

    if (reversible != null
        && reversible.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Reversible already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignReversibleToAsynchronousMachineEvent(
            command.getAsynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignReversibleFromAsynchronousMachineCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignReversibleFromAsynchronousMachineCommand");

    if (reversible == null)
      throw new ProcessingException("Reversible already has nothing assigned.");

    apply(new UnAssignReversibleFromAsynchronousMachineEvent(command.getAsynchronousMachineId()));
  }

  @CommandHandler
  public void handle(AssignRxLockedRotorRatioToAsynchronousMachineCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignRxLockedRotorRatioToAsynchronousMachineCommand");

    if (rxLockedRotorRatio != null
        && rxLockedRotorRatio.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "RxLockedRotorRatio already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignRxLockedRotorRatioToAsynchronousMachineEvent(
            command.getAsynchronousMachineId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRxLockedRotorRatioFromAsynchronousMachineCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignRxLockedRotorRatioFromAsynchronousMachineCommand");

    if (rxLockedRotorRatio == null)
      throw new ProcessingException("RxLockedRotorRatio already has nothing assigned.");

    apply(
        new UnAssignRxLockedRotorRatioFromAsynchronousMachineEvent(
            command.getAsynchronousMachineId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing CreateAsynchronousMachineEvent");
    this.asynchronousMachineId = event.getAsynchronousMachineId();
  }

  @EventSourcingHandler
  void on(UpdateAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.converterFedDrive = event.getConverterFedDrive();
    this.efficiency = event.getEfficiency();
    this.iaIrRatio = event.getIaIrRatio();
    this.nominalFrequency = event.getNominalFrequency();
    this.nominalSpeed = event.getNominalSpeed();
    this.polePairNumber = event.getPolePairNumber();
    this.ratedMechanicalPower = event.getRatedMechanicalPower();
    this.reversible = event.getReversible();
    this.rxLockedRotorRatio = event.getRxLockedRotorRatio();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignConverterFedDriveToAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignConverterFedDriveToAsynchronousMachineEvent");
    this.converterFedDrive = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignConverterFedDriveFromAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignConverterFedDriveFromAsynchronousMachineEvent");
    this.converterFedDrive = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfficiencyToAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignEfficiencyToAsynchronousMachineEvent");
    this.efficiency = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfficiencyFromAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignEfficiencyFromAsynchronousMachineEvent");
    this.efficiency = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIaIrRatioToAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignIaIrRatioToAsynchronousMachineEvent");
    this.iaIrRatio = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIaIrRatioFromAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignIaIrRatioFromAsynchronousMachineEvent");
    this.iaIrRatio = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNominalFrequencyToAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignNominalFrequencyToAsynchronousMachineEvent");
    this.nominalFrequency = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNominalFrequencyFromAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignNominalFrequencyFromAsynchronousMachineEvent");
    this.nominalFrequency = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNominalSpeedToAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignNominalSpeedToAsynchronousMachineEvent");
    this.nominalSpeed = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNominalSpeedFromAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignNominalSpeedFromAsynchronousMachineEvent");
    this.nominalSpeed = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPolePairNumberToAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignPolePairNumberToAsynchronousMachineEvent");
    this.polePairNumber = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPolePairNumberFromAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignPolePairNumberFromAsynchronousMachineEvent");
    this.polePairNumber = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRatedMechanicalPowerToAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignRatedMechanicalPowerToAsynchronousMachineEvent");
    this.ratedMechanicalPower = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRatedMechanicalPowerFromAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignRatedMechanicalPowerFromAsynchronousMachineEvent");
    this.ratedMechanicalPower = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignReversibleToAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignReversibleToAsynchronousMachineEvent");
    this.reversible = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignReversibleFromAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignReversibleFromAsynchronousMachineEvent");
    this.reversible = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRxLockedRotorRatioToAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing AssignRxLockedRotorRatioToAsynchronousMachineEvent");
    this.rxLockedRotorRatio = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRxLockedRotorRatioFromAsynchronousMachineEvent event) {
    LOGGER.info("Event sourcing UnAssignRxLockedRotorRatioFromAsynchronousMachineEvent");
    this.rxLockedRotorRatio = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID asynchronousMachineId;

  private BooleanProxy converterFedDrive = null;
  private PerCent efficiency = null;
  private Simple_Float iaIrRatio = null;
  private Frequency nominalFrequency = null;
  private RotationSpeed nominalSpeed = null;
  private IntegerProxy polePairNumber = null;
  private ActivePower ratedMechanicalPower = null;
  private BooleanProxy reversible = null;
  private Simple_Float rxLockedRotorRatio = null;

  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineAggregate.class.getName());
}
