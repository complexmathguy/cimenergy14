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
 * Aggregate handler for ShuntCompensator as outlined for the CQRS pattern, all write
 * responsibilities related to ShuntCompensator are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ShuntCompensatorAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ShuntCompensatorAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ShuntCompensatorAggregate(CreateShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command CreateShuntCompensatorCommand");
    CreateShuntCompensatorEvent event =
        new CreateShuntCompensatorEvent(command.getShuntCompensatorId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateShuntCompensatorCommand command) throws Exception {
    LOGGER.info("handling command UpdateShuntCompensatorCommand");
    UpdateShuntCompensatorEvent event =
        new UpdateShuntCompensatorEvent(
            command.getShuntCompensatorId(),
            command.getAVRDelay(),
            command.getGrounded(),
            command.getMaximumSections(),
            command.getNomU(),
            command.getNormalSections(),
            command.getSwitchOnCount(),
            command.getSwitchOnDate(),
            command.getVoltageSensitivity());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command DeleteShuntCompensatorCommand");
    apply(new DeleteShuntCompensatorEvent(command.getShuntCompensatorId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAVRDelayToShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignAVRDelayToShuntCompensatorCommand");

    if (aVRDelay != null && aVRDelay.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "AVRDelay already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignAVRDelayToShuntCompensatorEvent(
            command.getShuntCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAVRDelayFromShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAVRDelayFromShuntCompensatorCommand");

    if (aVRDelay == null) throw new ProcessingException("AVRDelay already has nothing assigned.");

    apply(new UnAssignAVRDelayFromShuntCompensatorEvent(command.getShuntCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignGroundedToShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignGroundedToShuntCompensatorCommand");

    if (grounded != null
        && grounded.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Grounded already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignGroundedToShuntCompensatorEvent(
            command.getShuntCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGroundedFromShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGroundedFromShuntCompensatorCommand");

    if (grounded == null) throw new ProcessingException("Grounded already has nothing assigned.");

    apply(new UnAssignGroundedFromShuntCompensatorEvent(command.getShuntCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignMaximumSectionsToShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignMaximumSectionsToShuntCompensatorCommand");

    if (maximumSections != null
        && maximumSections.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "MaximumSections already assigned with id "
              + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignMaximumSectionsToShuntCompensatorEvent(
            command.getShuntCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaximumSectionsFromShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaximumSectionsFromShuntCompensatorCommand");

    if (maximumSections == null)
      throw new ProcessingException("MaximumSections already has nothing assigned.");

    apply(new UnAssignMaximumSectionsFromShuntCompensatorEvent(command.getShuntCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignNomUToShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignNomUToShuntCompensatorCommand");

    if (nomU != null && nomU.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "NomU already assigned with id " + command.getAssignment().getVoltageId());

    apply(
        new AssignNomUToShuntCompensatorEvent(
            command.getShuntCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNomUFromShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNomUFromShuntCompensatorCommand");

    if (nomU == null) throw new ProcessingException("NomU already has nothing assigned.");

    apply(new UnAssignNomUFromShuntCompensatorEvent(command.getShuntCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignNormalSectionsToShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignNormalSectionsToShuntCompensatorCommand");

    if (normalSections != null
        && normalSections.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "NormalSections already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignNormalSectionsToShuntCompensatorEvent(
            command.getShuntCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNormalSectionsFromShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNormalSectionsFromShuntCompensatorCommand");

    if (normalSections == null)
      throw new ProcessingException("NormalSections already has nothing assigned.");

    apply(new UnAssignNormalSectionsFromShuntCompensatorEvent(command.getShuntCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignSwitchOnCountToShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignSwitchOnCountToShuntCompensatorCommand");

    if (switchOnCount != null
        && switchOnCount.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "SwitchOnCount already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignSwitchOnCountToShuntCompensatorEvent(
            command.getShuntCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSwitchOnCountFromShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSwitchOnCountFromShuntCompensatorCommand");

    if (switchOnCount == null)
      throw new ProcessingException("SwitchOnCount already has nothing assigned.");

    apply(new UnAssignSwitchOnCountFromShuntCompensatorEvent(command.getShuntCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignSwitchOnDateToShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignSwitchOnDateToShuntCompensatorCommand");

    if (switchOnDate != null
        && switchOnDate.getDateTimeId() == command.getAssignment().getDateTimeId())
      throw new ProcessingException(
          "SwitchOnDate already assigned with id " + command.getAssignment().getDateTimeId());

    apply(
        new AssignSwitchOnDateToShuntCompensatorEvent(
            command.getShuntCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSwitchOnDateFromShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSwitchOnDateFromShuntCompensatorCommand");

    if (switchOnDate == null)
      throw new ProcessingException("SwitchOnDate already has nothing assigned.");

    apply(new UnAssignSwitchOnDateFromShuntCompensatorEvent(command.getShuntCompensatorId()));
  }

  @CommandHandler
  public void handle(AssignVoltageSensitivityToShuntCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignVoltageSensitivityToShuntCompensatorCommand");

    if (voltageSensitivity != null
        && voltageSensitivity.getVoltagePerReactivePowerId()
            == command.getAssignment().getVoltagePerReactivePowerId())
      throw new ProcessingException(
          "VoltageSensitivity already assigned with id "
              + command.getAssignment().getVoltagePerReactivePowerId());

    apply(
        new AssignVoltageSensitivityToShuntCompensatorEvent(
            command.getShuntCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVoltageSensitivityFromShuntCompensatorCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignVoltageSensitivityFromShuntCompensatorCommand");

    if (voltageSensitivity == null)
      throw new ProcessingException("VoltageSensitivity already has nothing assigned.");

    apply(new UnAssignVoltageSensitivityFromShuntCompensatorEvent(command.getShuntCompensatorId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing CreateShuntCompensatorEvent");
    this.shuntCompensatorId = event.getShuntCompensatorId();
  }

  @EventSourcingHandler
  void on(UpdateShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.aVRDelay = event.getAVRDelay();
    this.grounded = event.getGrounded();
    this.maximumSections = event.getMaximumSections();
    this.nomU = event.getNomU();
    this.normalSections = event.getNormalSections();
    this.switchOnCount = event.getSwitchOnCount();
    this.switchOnDate = event.getSwitchOnDate();
    this.voltageSensitivity = event.getVoltageSensitivity();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAVRDelayToShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignAVRDelayToShuntCompensatorEvent");
    this.aVRDelay = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAVRDelayFromShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignAVRDelayFromShuntCompensatorEvent");
    this.aVRDelay = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGroundedToShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignGroundedToShuntCompensatorEvent");
    this.grounded = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGroundedFromShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignGroundedFromShuntCompensatorEvent");
    this.grounded = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaximumSectionsToShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignMaximumSectionsToShuntCompensatorEvent");
    this.maximumSections = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaximumSectionsFromShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignMaximumSectionsFromShuntCompensatorEvent");
    this.maximumSections = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNomUToShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignNomUToShuntCompensatorEvent");
    this.nomU = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNomUFromShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignNomUFromShuntCompensatorEvent");
    this.nomU = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNormalSectionsToShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignNormalSectionsToShuntCompensatorEvent");
    this.normalSections = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNormalSectionsFromShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignNormalSectionsFromShuntCompensatorEvent");
    this.normalSections = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSwitchOnCountToShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignSwitchOnCountToShuntCompensatorEvent");
    this.switchOnCount = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSwitchOnCountFromShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignSwitchOnCountFromShuntCompensatorEvent");
    this.switchOnCount = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSwitchOnDateToShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignSwitchOnDateToShuntCompensatorEvent");
    this.switchOnDate = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSwitchOnDateFromShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignSwitchOnDateFromShuntCompensatorEvent");
    this.switchOnDate = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVoltageSensitivityToShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignVoltageSensitivityToShuntCompensatorEvent");
    this.voltageSensitivity = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVoltageSensitivityFromShuntCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignVoltageSensitivityFromShuntCompensatorEvent");
    this.voltageSensitivity = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID shuntCompensatorId;

  private Seconds aVRDelay = null;
  private BooleanProxy grounded = null;
  private IntegerProxy maximumSections = null;
  private Voltage nomU = null;
  private IntegerProxy normalSections = null;
  private IntegerProxy switchOnCount = null;
  private DateTime switchOnDate = null;
  private VoltagePerReactivePower voltageSensitivity = null;

  private static final Logger LOGGER = Logger.getLogger(ShuntCompensatorAggregate.class.getName());
}
