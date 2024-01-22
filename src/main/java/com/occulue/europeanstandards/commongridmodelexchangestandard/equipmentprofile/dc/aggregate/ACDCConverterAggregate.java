package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.aggregate;

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
 * Aggregate handler for ACDCConverter as outlined for the CQRS pattern, all write responsibilities
 * related to ACDCConverter are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ACDCConverterAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ACDCConverterAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ACDCConverterAggregate(CreateACDCConverterCommand command) throws Exception {
    LOGGER.info("Handling command CreateACDCConverterCommand");
    CreateACDCConverterEvent event = new CreateACDCConverterEvent(command.getACDCConverterId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateACDCConverterCommand command) throws Exception {
    LOGGER.info("handling command UpdateACDCConverterCommand");
    UpdateACDCConverterEvent event =
        new UpdateACDCConverterEvent(
            command.getACDCConverterId(),
            command.getBaseS(),
            command.getIdleLoss(),
            command.getMaxUdc(),
            command.getMinUdc(),
            command.getNumberOfValves(),
            command.getRatedUdc(),
            command.getResistiveLoss(),
            command.getSwitchingLoss(),
            command.getValveU0(),
            command.getConverterDCSides());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteACDCConverterCommand command) throws Exception {
    LOGGER.info("Handling command DeleteACDCConverterCommand");
    apply(new DeleteACDCConverterEvent(command.getACDCConverterId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBaseSToACDCConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseSToACDCConverterCommand");

    if (baseS != null && baseS.getApparentPowerId() == command.getAssignment().getApparentPowerId())
      throw new ProcessingException(
          "BaseS already assigned with id " + command.getAssignment().getApparentPowerId());

    apply(
        new AssignBaseSToACDCConverterEvent(command.getACDCConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseSFromACDCConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseSFromACDCConverterCommand");

    if (baseS == null) throw new ProcessingException("BaseS already has nothing assigned.");

    apply(new UnAssignBaseSFromACDCConverterEvent(command.getACDCConverterId()));
  }

  @CommandHandler
  public void handle(AssignIdleLossToACDCConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignIdleLossToACDCConverterCommand");

    if (idleLoss != null
        && idleLoss.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "IdleLoss already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignIdleLossToACDCConverterEvent(
            command.getACDCConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIdleLossFromACDCConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIdleLossFromACDCConverterCommand");

    if (idleLoss == null) throw new ProcessingException("IdleLoss already has nothing assigned.");

    apply(new UnAssignIdleLossFromACDCConverterEvent(command.getACDCConverterId()));
  }

  @CommandHandler
  public void handle(AssignMaxUdcToACDCConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignMaxUdcToACDCConverterCommand");

    if (maxUdc != null && maxUdc.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "MaxUdc already assigned with id " + command.getAssignment().getVoltageId());

    apply(
        new AssignMaxUdcToACDCConverterEvent(
            command.getACDCConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxUdcFromACDCConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxUdcFromACDCConverterCommand");

    if (maxUdc == null) throw new ProcessingException("MaxUdc already has nothing assigned.");

    apply(new UnAssignMaxUdcFromACDCConverterEvent(command.getACDCConverterId()));
  }

  @CommandHandler
  public void handle(AssignMinUdcToACDCConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignMinUdcToACDCConverterCommand");

    if (minUdc != null && minUdc.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "MinUdc already assigned with id " + command.getAssignment().getVoltageId());

    apply(
        new AssignMinUdcToACDCConverterEvent(
            command.getACDCConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinUdcFromACDCConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMinUdcFromACDCConverterCommand");

    if (minUdc == null) throw new ProcessingException("MinUdc already has nothing assigned.");

    apply(new UnAssignMinUdcFromACDCConverterEvent(command.getACDCConverterId()));
  }

  @CommandHandler
  public void handle(AssignNumberOfValvesToACDCConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignNumberOfValvesToACDCConverterCommand");

    if (numberOfValves != null
        && numberOfValves.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "NumberOfValves already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignNumberOfValvesToACDCConverterEvent(
            command.getACDCConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNumberOfValvesFromACDCConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNumberOfValvesFromACDCConverterCommand");

    if (numberOfValves == null)
      throw new ProcessingException("NumberOfValves already has nothing assigned.");

    apply(new UnAssignNumberOfValvesFromACDCConverterEvent(command.getACDCConverterId()));
  }

  @CommandHandler
  public void handle(AssignRatedUdcToACDCConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignRatedUdcToACDCConverterCommand");

    if (ratedUdc != null && ratedUdc.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "RatedUdc already assigned with id " + command.getAssignment().getVoltageId());

    apply(
        new AssignRatedUdcToACDCConverterEvent(
            command.getACDCConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRatedUdcFromACDCConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRatedUdcFromACDCConverterCommand");

    if (ratedUdc == null) throw new ProcessingException("RatedUdc already has nothing assigned.");

    apply(new UnAssignRatedUdcFromACDCConverterEvent(command.getACDCConverterId()));
  }

  @CommandHandler
  public void handle(AssignResistiveLossToACDCConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignResistiveLossToACDCConverterCommand");

    if (resistiveLoss != null
        && resistiveLoss.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "ResistiveLoss already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignResistiveLossToACDCConverterEvent(
            command.getACDCConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignResistiveLossFromACDCConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignResistiveLossFromACDCConverterCommand");

    if (resistiveLoss == null)
      throw new ProcessingException("ResistiveLoss already has nothing assigned.");

    apply(new UnAssignResistiveLossFromACDCConverterEvent(command.getACDCConverterId()));
  }

  @CommandHandler
  public void handle(AssignSwitchingLossToACDCConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignSwitchingLossToACDCConverterCommand");

    if (switchingLoss != null
        && switchingLoss.getActivePowerPerCurrentFlowId()
            == command.getAssignment().getActivePowerPerCurrentFlowId())
      throw new ProcessingException(
          "SwitchingLoss already assigned with id "
              + command.getAssignment().getActivePowerPerCurrentFlowId());

    apply(
        new AssignSwitchingLossToACDCConverterEvent(
            command.getACDCConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSwitchingLossFromACDCConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSwitchingLossFromACDCConverterCommand");

    if (switchingLoss == null)
      throw new ProcessingException("SwitchingLoss already has nothing assigned.");

    apply(new UnAssignSwitchingLossFromACDCConverterEvent(command.getACDCConverterId()));
  }

  @CommandHandler
  public void handle(AssignValveU0ToACDCConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignValveU0ToACDCConverterCommand");

    if (valveU0 != null && valveU0.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "ValveU0 already assigned with id " + command.getAssignment().getVoltageId());

    apply(
        new AssignValveU0ToACDCConverterEvent(
            command.getACDCConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValveU0FromACDCConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValveU0FromACDCConverterCommand");

    if (valveU0 == null) throw new ProcessingException("ValveU0 already has nothing assigned.");

    apply(new UnAssignValveU0FromACDCConverterEvent(command.getACDCConverterId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignConverterDCSidesToACDCConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignConverterDCSidesToACDCConverterCommand");

    if (converterDCSides.contains(command.getAddTo()))
      throw new ProcessingException(
          "ConverterDCSides already contains an entity with id "
              + command.getAddTo().getACDCConverterId());

    apply(
        new AssignConverterDCSidesToACDCConverterEvent(
            command.getACDCConverterId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveConverterDCSidesFromACDCConverterCommand command) throws Exception {
    LOGGER.info("Handling command RemoveConverterDCSidesFromACDCConverterCommand");

    if (!converterDCSides.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "ConverterDCSides does not contain an entity with id "
              + command.getRemoveFrom().getACDCConverterId());

    apply(
        new RemoveConverterDCSidesFromACDCConverterEvent(
            command.getACDCConverterId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateACDCConverterEvent event) {
    LOGGER.info("Event sourcing CreateACDCConverterEvent");
    this.aCDCConverterId = event.getACDCConverterId();
  }

  @EventSourcingHandler
  void on(UpdateACDCConverterEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.baseS = event.getBaseS();
    this.idleLoss = event.getIdleLoss();
    this.maxUdc = event.getMaxUdc();
    this.minUdc = event.getMinUdc();
    this.numberOfValves = event.getNumberOfValves();
    this.ratedUdc = event.getRatedUdc();
    this.resistiveLoss = event.getResistiveLoss();
    this.switchingLoss = event.getSwitchingLoss();
    this.valveU0 = event.getValveU0();
    this.converterDCSides = event.getConverterDCSides();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBaseSToACDCConverterEvent event) {
    LOGGER.info("Event sourcing AssignBaseSToACDCConverterEvent");
    this.baseS = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseSFromACDCConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseSFromACDCConverterEvent");
    this.baseS = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIdleLossToACDCConverterEvent event) {
    LOGGER.info("Event sourcing AssignIdleLossToACDCConverterEvent");
    this.idleLoss = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIdleLossFromACDCConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignIdleLossFromACDCConverterEvent");
    this.idleLoss = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxUdcToACDCConverterEvent event) {
    LOGGER.info("Event sourcing AssignMaxUdcToACDCConverterEvent");
    this.maxUdc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxUdcFromACDCConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxUdcFromACDCConverterEvent");
    this.maxUdc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinUdcToACDCConverterEvent event) {
    LOGGER.info("Event sourcing AssignMinUdcToACDCConverterEvent");
    this.minUdc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinUdcFromACDCConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignMinUdcFromACDCConverterEvent");
    this.minUdc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNumberOfValvesToACDCConverterEvent event) {
    LOGGER.info("Event sourcing AssignNumberOfValvesToACDCConverterEvent");
    this.numberOfValves = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNumberOfValvesFromACDCConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignNumberOfValvesFromACDCConverterEvent");
    this.numberOfValves = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRatedUdcToACDCConverterEvent event) {
    LOGGER.info("Event sourcing AssignRatedUdcToACDCConverterEvent");
    this.ratedUdc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRatedUdcFromACDCConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignRatedUdcFromACDCConverterEvent");
    this.ratedUdc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignResistiveLossToACDCConverterEvent event) {
    LOGGER.info("Event sourcing AssignResistiveLossToACDCConverterEvent");
    this.resistiveLoss = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignResistiveLossFromACDCConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignResistiveLossFromACDCConverterEvent");
    this.resistiveLoss = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSwitchingLossToACDCConverterEvent event) {
    LOGGER.info("Event sourcing AssignSwitchingLossToACDCConverterEvent");
    this.switchingLoss = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSwitchingLossFromACDCConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignSwitchingLossFromACDCConverterEvent");
    this.switchingLoss = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignValveU0ToACDCConverterEvent event) {
    LOGGER.info("Event sourcing AssignValveU0ToACDCConverterEvent");
    this.valveU0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValveU0FromACDCConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignValveU0FromACDCConverterEvent");
    this.valveU0 = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignConverterDCSidesToACDCConverterEvent event) {
    LOGGER.info("Event sourcing AssignConverterDCSidesToACDCConverterEvent");
    this.converterDCSides.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveConverterDCSidesFromACDCConverterEvent event) {
    LOGGER.info("Event sourcing RemoveConverterDCSidesFromACDCConverterEvent");
    this.converterDCSides.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID aCDCConverterId;

  private ApparentPower baseS = null;
  private ActivePower idleLoss = null;
  private Voltage maxUdc = null;
  private Voltage minUdc = null;
  private IntegerProxy numberOfValves = null;
  private Voltage ratedUdc = null;
  private Resistance resistiveLoss = null;
  private ActivePowerPerCurrentFlow switchingLoss = null;
  private Voltage valveU0 = null;
  private Set<ACDCConverter> converterDCSides = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(ACDCConverterAggregate.class.getName());
}
