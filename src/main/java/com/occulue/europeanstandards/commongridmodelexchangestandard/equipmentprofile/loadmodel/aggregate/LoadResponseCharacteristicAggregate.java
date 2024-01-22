package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.aggregate;

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
 * Aggregate handler for LoadResponseCharacteristic as outlined for the CQRS pattern, all write
 * responsibilities related to LoadResponseCharacteristic are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class LoadResponseCharacteristicAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public LoadResponseCharacteristicAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public LoadResponseCharacteristicAggregate(CreateLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateLoadResponseCharacteristicCommand");
    CreateLoadResponseCharacteristicEvent event =
        new CreateLoadResponseCharacteristicEvent(command.getLoadResponseCharacteristicId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateLoadResponseCharacteristicCommand command) throws Exception {
    LOGGER.info("handling command UpdateLoadResponseCharacteristicCommand");
    UpdateLoadResponseCharacteristicEvent event =
        new UpdateLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId(),
            command.getExponentModel(),
            command.getPConstantCurrent(),
            command.getPConstantImpedance(),
            command.getPConstantPower(),
            command.getPFrequencyExponent(),
            command.getPVoltageExponent(),
            command.getQConstantCurrent(),
            command.getQConstantImpedance(),
            command.getQConstantPower(),
            command.getQFrequencyExponent(),
            command.getQVoltageExponent());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteLoadResponseCharacteristicCommand command) throws Exception {
    LOGGER.info("Handling command DeleteLoadResponseCharacteristicCommand");
    apply(new DeleteLoadResponseCharacteristicEvent(command.getLoadResponseCharacteristicId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignExponentModelToLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignExponentModelToLoadResponseCharacteristicCommand");

    if (exponentModel != null
        && exponentModel.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "ExponentModel already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignExponentModelToLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignExponentModelFromLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignExponentModelFromLoadResponseCharacteristicCommand");

    if (exponentModel == null)
      throw new ProcessingException("ExponentModel already has nothing assigned.");

    apply(
        new UnAssignExponentModelFromLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId()));
  }

  @CommandHandler
  public void handle(AssignPConstantCurrentToLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignPConstantCurrentToLoadResponseCharacteristicCommand");

    if (pConstantCurrent != null
        && pConstantCurrent.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "PConstantCurrent already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignPConstantCurrentToLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPConstantCurrentFromLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignPConstantCurrentFromLoadResponseCharacteristicCommand");

    if (pConstantCurrent == null)
      throw new ProcessingException("PConstantCurrent already has nothing assigned.");

    apply(
        new UnAssignPConstantCurrentFromLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId()));
  }

  @CommandHandler
  public void handle(AssignPConstantImpedanceToLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignPConstantImpedanceToLoadResponseCharacteristicCommand");

    if (pConstantImpedance != null
        && pConstantImpedance.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "PConstantImpedance already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignPConstantImpedanceToLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPConstantImpedanceFromLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignPConstantImpedanceFromLoadResponseCharacteristicCommand");

    if (pConstantImpedance == null)
      throw new ProcessingException("PConstantImpedance already has nothing assigned.");

    apply(
        new UnAssignPConstantImpedanceFromLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId()));
  }

  @CommandHandler
  public void handle(AssignPConstantPowerToLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignPConstantPowerToLoadResponseCharacteristicCommand");

    if (pConstantPower != null
        && pConstantPower.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "PConstantPower already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignPConstantPowerToLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPConstantPowerFromLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignPConstantPowerFromLoadResponseCharacteristicCommand");

    if (pConstantPower == null)
      throw new ProcessingException("PConstantPower already has nothing assigned.");

    apply(
        new UnAssignPConstantPowerFromLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId()));
  }

  @CommandHandler
  public void handle(AssignPFrequencyExponentToLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignPFrequencyExponentToLoadResponseCharacteristicCommand");

    if (pFrequencyExponent != null
        && pFrequencyExponent.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "PFrequencyExponent already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignPFrequencyExponentToLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPFrequencyExponentFromLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignPFrequencyExponentFromLoadResponseCharacteristicCommand");

    if (pFrequencyExponent == null)
      throw new ProcessingException("PFrequencyExponent already has nothing assigned.");

    apply(
        new UnAssignPFrequencyExponentFromLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId()));
  }

  @CommandHandler
  public void handle(AssignPVoltageExponentToLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignPVoltageExponentToLoadResponseCharacteristicCommand");

    if (pVoltageExponent != null
        && pVoltageExponent.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "PVoltageExponent already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignPVoltageExponentToLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPVoltageExponentFromLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignPVoltageExponentFromLoadResponseCharacteristicCommand");

    if (pVoltageExponent == null)
      throw new ProcessingException("PVoltageExponent already has nothing assigned.");

    apply(
        new UnAssignPVoltageExponentFromLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId()));
  }

  @CommandHandler
  public void handle(AssignQConstantCurrentToLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignQConstantCurrentToLoadResponseCharacteristicCommand");

    if (qConstantCurrent != null
        && qConstantCurrent.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "QConstantCurrent already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignQConstantCurrentToLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQConstantCurrentFromLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignQConstantCurrentFromLoadResponseCharacteristicCommand");

    if (qConstantCurrent == null)
      throw new ProcessingException("QConstantCurrent already has nothing assigned.");

    apply(
        new UnAssignQConstantCurrentFromLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId()));
  }

  @CommandHandler
  public void handle(AssignQConstantImpedanceToLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignQConstantImpedanceToLoadResponseCharacteristicCommand");

    if (qConstantImpedance != null
        && qConstantImpedance.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "QConstantImpedance already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignQConstantImpedanceToLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQConstantImpedanceFromLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignQConstantImpedanceFromLoadResponseCharacteristicCommand");

    if (qConstantImpedance == null)
      throw new ProcessingException("QConstantImpedance already has nothing assigned.");

    apply(
        new UnAssignQConstantImpedanceFromLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId()));
  }

  @CommandHandler
  public void handle(AssignQConstantPowerToLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignQConstantPowerToLoadResponseCharacteristicCommand");

    if (qConstantPower != null
        && qConstantPower.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "QConstantPower already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignQConstantPowerToLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQConstantPowerFromLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignQConstantPowerFromLoadResponseCharacteristicCommand");

    if (qConstantPower == null)
      throw new ProcessingException("QConstantPower already has nothing assigned.");

    apply(
        new UnAssignQConstantPowerFromLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId()));
  }

  @CommandHandler
  public void handle(AssignQFrequencyExponentToLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignQFrequencyExponentToLoadResponseCharacteristicCommand");

    if (qFrequencyExponent != null
        && qFrequencyExponent.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "QFrequencyExponent already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignQFrequencyExponentToLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQFrequencyExponentFromLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignQFrequencyExponentFromLoadResponseCharacteristicCommand");

    if (qFrequencyExponent == null)
      throw new ProcessingException("QFrequencyExponent already has nothing assigned.");

    apply(
        new UnAssignQFrequencyExponentFromLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId()));
  }

  @CommandHandler
  public void handle(AssignQVoltageExponentToLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignQVoltageExponentToLoadResponseCharacteristicCommand");

    if (qVoltageExponent != null
        && qVoltageExponent.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "QVoltageExponent already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignQVoltageExponentToLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQVoltageExponentFromLoadResponseCharacteristicCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignQVoltageExponentFromLoadResponseCharacteristicCommand");

    if (qVoltageExponent == null)
      throw new ProcessingException("QVoltageExponent already has nothing assigned.");

    apply(
        new UnAssignQVoltageExponentFromLoadResponseCharacteristicEvent(
            command.getLoadResponseCharacteristicId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing CreateLoadResponseCharacteristicEvent");
    this.loadResponseCharacteristicId = event.getLoadResponseCharacteristicId();
  }

  @EventSourcingHandler
  void on(UpdateLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.exponentModel = event.getExponentModel();
    this.pConstantCurrent = event.getPConstantCurrent();
    this.pConstantImpedance = event.getPConstantImpedance();
    this.pConstantPower = event.getPConstantPower();
    this.pFrequencyExponent = event.getPFrequencyExponent();
    this.pVoltageExponent = event.getPVoltageExponent();
    this.qConstantCurrent = event.getQConstantCurrent();
    this.qConstantImpedance = event.getQConstantImpedance();
    this.qConstantPower = event.getQConstantPower();
    this.qFrequencyExponent = event.getQFrequencyExponent();
    this.qVoltageExponent = event.getQVoltageExponent();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignExponentModelToLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing AssignExponentModelToLoadResponseCharacteristicEvent");
    this.exponentModel = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignExponentModelFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing UnAssignExponentModelFromLoadResponseCharacteristicEvent");
    this.exponentModel = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPConstantCurrentToLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing AssignPConstantCurrentToLoadResponseCharacteristicEvent");
    this.pConstantCurrent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPConstantCurrentFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing UnAssignPConstantCurrentFromLoadResponseCharacteristicEvent");
    this.pConstantCurrent = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPConstantImpedanceToLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing AssignPConstantImpedanceToLoadResponseCharacteristicEvent");
    this.pConstantImpedance = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPConstantImpedanceFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing UnAssignPConstantImpedanceFromLoadResponseCharacteristicEvent");
    this.pConstantImpedance = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPConstantPowerToLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing AssignPConstantPowerToLoadResponseCharacteristicEvent");
    this.pConstantPower = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPConstantPowerFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing UnAssignPConstantPowerFromLoadResponseCharacteristicEvent");
    this.pConstantPower = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPFrequencyExponentToLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing AssignPFrequencyExponentToLoadResponseCharacteristicEvent");
    this.pFrequencyExponent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPFrequencyExponentFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing UnAssignPFrequencyExponentFromLoadResponseCharacteristicEvent");
    this.pFrequencyExponent = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPVoltageExponentToLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing AssignPVoltageExponentToLoadResponseCharacteristicEvent");
    this.pVoltageExponent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPVoltageExponentFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing UnAssignPVoltageExponentFromLoadResponseCharacteristicEvent");
    this.pVoltageExponent = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQConstantCurrentToLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing AssignQConstantCurrentToLoadResponseCharacteristicEvent");
    this.qConstantCurrent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQConstantCurrentFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing UnAssignQConstantCurrentFromLoadResponseCharacteristicEvent");
    this.qConstantCurrent = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQConstantImpedanceToLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing AssignQConstantImpedanceToLoadResponseCharacteristicEvent");
    this.qConstantImpedance = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQConstantImpedanceFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing UnAssignQConstantImpedanceFromLoadResponseCharacteristicEvent");
    this.qConstantImpedance = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQConstantPowerToLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing AssignQConstantPowerToLoadResponseCharacteristicEvent");
    this.qConstantPower = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQConstantPowerFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing UnAssignQConstantPowerFromLoadResponseCharacteristicEvent");
    this.qConstantPower = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQFrequencyExponentToLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing AssignQFrequencyExponentToLoadResponseCharacteristicEvent");
    this.qFrequencyExponent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQFrequencyExponentFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing UnAssignQFrequencyExponentFromLoadResponseCharacteristicEvent");
    this.qFrequencyExponent = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQVoltageExponentToLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing AssignQVoltageExponentToLoadResponseCharacteristicEvent");
    this.qVoltageExponent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQVoltageExponentFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("Event sourcing UnAssignQVoltageExponentFromLoadResponseCharacteristicEvent");
    this.qVoltageExponent = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID loadResponseCharacteristicId;

  private BooleanProxy exponentModel = null;
  private Simple_Float pConstantCurrent = null;
  private Simple_Float pConstantImpedance = null;
  private Simple_Float pConstantPower = null;
  private Simple_Float pFrequencyExponent = null;
  private Simple_Float pVoltageExponent = null;
  private Simple_Float qConstantCurrent = null;
  private Simple_Float qConstantImpedance = null;
  private Simple_Float qConstantPower = null;
  private Simple_Float qFrequencyExponent = null;
  private Simple_Float qVoltageExponent = null;

  private static final Logger LOGGER =
      Logger.getLogger(LoadResponseCharacteristicAggregate.class.getName());
}
