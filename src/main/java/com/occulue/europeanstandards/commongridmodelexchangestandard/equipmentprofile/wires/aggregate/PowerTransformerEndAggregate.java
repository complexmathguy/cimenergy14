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
 * Aggregate handler for PowerTransformerEnd as outlined for the CQRS pattern, all write
 * responsibilities related to PowerTransformerEnd are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PowerTransformerEndAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PowerTransformerEndAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PowerTransformerEndAggregate(CreatePowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command CreatePowerTransformerEndCommand");
    CreatePowerTransformerEndEvent event =
        new CreatePowerTransformerEndEvent(
            command.getPowerTransformerEndId(), command.getConnectionKind());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePowerTransformerEndCommand command) throws Exception {
    LOGGER.info("handling command UpdatePowerTransformerEndCommand");
    UpdatePowerTransformerEndEvent event =
        new UpdatePowerTransformerEndEvent(
            command.getPowerTransformerEndId(),
            command.getB(),
            command.getB0(),
            command.getConnectionKind(),
            command.getG(),
            command.getG0(),
            command.getPhaseAngleClock(),
            command.getR(),
            command.getR0(),
            command.getRatedS(),
            command.getRatedU(),
            command.getX(),
            command.getX0(),
            command.getPowerTransformerEnd());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command DeletePowerTransformerEndCommand");
    apply(new DeletePowerTransformerEndEvent(command.getPowerTransformerEndId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBToPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignBToPowerTransformerEndCommand");

    if (b != null && b.getSusceptanceId() == command.getAssignment().getSusceptanceId())
      throw new ProcessingException(
          "B already assigned with id " + command.getAssignment().getSusceptanceId());

    apply(
        new AssignBToPowerTransformerEndEvent(
            command.getPowerTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBFromPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBFromPowerTransformerEndCommand");

    if (b == null) throw new ProcessingException("B already has nothing assigned.");

    apply(new UnAssignBFromPowerTransformerEndEvent(command.getPowerTransformerEndId()));
  }

  @CommandHandler
  public void handle(AssignB0ToPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignB0ToPowerTransformerEndCommand");

    if (b0 != null && b0.getSusceptanceId() == command.getAssignment().getSusceptanceId())
      throw new ProcessingException(
          "B0 already assigned with id " + command.getAssignment().getSusceptanceId());

    apply(
        new AssignB0ToPowerTransformerEndEvent(
            command.getPowerTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignB0FromPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignB0FromPowerTransformerEndCommand");

    if (b0 == null) throw new ProcessingException("B0 already has nothing assigned.");

    apply(new UnAssignB0FromPowerTransformerEndEvent(command.getPowerTransformerEndId()));
  }

  @CommandHandler
  public void handle(AssignGToPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignGToPowerTransformerEndCommand");

    if (g != null && g.getConductanceId() == command.getAssignment().getConductanceId())
      throw new ProcessingException(
          "G already assigned with id " + command.getAssignment().getConductanceId());

    apply(
        new AssignGToPowerTransformerEndEvent(
            command.getPowerTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGFromPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGFromPowerTransformerEndCommand");

    if (g == null) throw new ProcessingException("G already has nothing assigned.");

    apply(new UnAssignGFromPowerTransformerEndEvent(command.getPowerTransformerEndId()));
  }

  @CommandHandler
  public void handle(AssignG0ToPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignG0ToPowerTransformerEndCommand");

    if (g0 != null && g0.getConductanceId() == command.getAssignment().getConductanceId())
      throw new ProcessingException(
          "G0 already assigned with id " + command.getAssignment().getConductanceId());

    apply(
        new AssignG0ToPowerTransformerEndEvent(
            command.getPowerTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignG0FromPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignG0FromPowerTransformerEndCommand");

    if (g0 == null) throw new ProcessingException("G0 already has nothing assigned.");

    apply(new UnAssignG0FromPowerTransformerEndEvent(command.getPowerTransformerEndId()));
  }

  @CommandHandler
  public void handle(AssignPhaseAngleClockToPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignPhaseAngleClockToPowerTransformerEndCommand");

    if (phaseAngleClock != null
        && phaseAngleClock.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "PhaseAngleClock already assigned with id "
              + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignPhaseAngleClockToPowerTransformerEndEvent(
            command.getPowerTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPhaseAngleClockFromPowerTransformerEndCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignPhaseAngleClockFromPowerTransformerEndCommand");

    if (phaseAngleClock == null)
      throw new ProcessingException("PhaseAngleClock already has nothing assigned.");

    apply(
        new UnAssignPhaseAngleClockFromPowerTransformerEndEvent(
            command.getPowerTransformerEndId()));
  }

  @CommandHandler
  public void handle(AssignRToPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignRToPowerTransformerEndCommand");

    if (r != null && r.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignRToPowerTransformerEndEvent(
            command.getPowerTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromPowerTransformerEndCommand");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromPowerTransformerEndEvent(command.getPowerTransformerEndId()));
  }

  @CommandHandler
  public void handle(AssignR0ToPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignR0ToPowerTransformerEndCommand");

    if (r0 != null && r0.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R0 already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignR0ToPowerTransformerEndEvent(
            command.getPowerTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignR0FromPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignR0FromPowerTransformerEndCommand");

    if (r0 == null) throw new ProcessingException("R0 already has nothing assigned.");

    apply(new UnAssignR0FromPowerTransformerEndEvent(command.getPowerTransformerEndId()));
  }

  @CommandHandler
  public void handle(AssignRatedSToPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignRatedSToPowerTransformerEndCommand");

    if (ratedS != null
        && ratedS.getApparentPowerId() == command.getAssignment().getApparentPowerId())
      throw new ProcessingException(
          "RatedS already assigned with id " + command.getAssignment().getApparentPowerId());

    apply(
        new AssignRatedSToPowerTransformerEndEvent(
            command.getPowerTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRatedSFromPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRatedSFromPowerTransformerEndCommand");

    if (ratedS == null) throw new ProcessingException("RatedS already has nothing assigned.");

    apply(new UnAssignRatedSFromPowerTransformerEndEvent(command.getPowerTransformerEndId()));
  }

  @CommandHandler
  public void handle(AssignRatedUToPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignRatedUToPowerTransformerEndCommand");

    if (ratedU != null && ratedU.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "RatedU already assigned with id " + command.getAssignment().getVoltageId());

    apply(
        new AssignRatedUToPowerTransformerEndEvent(
            command.getPowerTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRatedUFromPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRatedUFromPowerTransformerEndCommand");

    if (ratedU == null) throw new ProcessingException("RatedU already has nothing assigned.");

    apply(new UnAssignRatedUFromPowerTransformerEndEvent(command.getPowerTransformerEndId()));
  }

  @CommandHandler
  public void handle(AssignXToPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignXToPowerTransformerEndCommand");

    if (x != null && x.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "X already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignXToPowerTransformerEndEvent(
            command.getPowerTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXFromPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXFromPowerTransformerEndCommand");

    if (x == null) throw new ProcessingException("X already has nothing assigned.");

    apply(new UnAssignXFromPowerTransformerEndEvent(command.getPowerTransformerEndId()));
  }

  @CommandHandler
  public void handle(AssignX0ToPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignX0ToPowerTransformerEndCommand");

    if (x0 != null && x0.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "X0 already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignX0ToPowerTransformerEndEvent(
            command.getPowerTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignX0FromPowerTransformerEndCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignX0FromPowerTransformerEndCommand");

    if (x0 == null) throw new ProcessingException("X0 already has nothing assigned.");

    apply(new UnAssignX0FromPowerTransformerEndEvent(command.getPowerTransformerEndId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignPowerTransformerEndToPowerTransformerEndCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignPowerTransformerEndToPowerTransformerEndCommand");

    if (powerTransformerEnd.contains(command.getAddTo()))
      throw new ProcessingException(
          "PowerTransformerEnd already contains an entity with id "
              + command.getAddTo().getPowerTransformerEndId());

    apply(
        new AssignPowerTransformerEndToPowerTransformerEndEvent(
            command.getPowerTransformerEndId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemovePowerTransformerEndFromPowerTransformerEndCommand command)
      throws Exception {
    LOGGER.info("Handling command RemovePowerTransformerEndFromPowerTransformerEndCommand");

    if (!powerTransformerEnd.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "PowerTransformerEnd does not contain an entity with id "
              + command.getRemoveFrom().getPowerTransformerEndId());

    apply(
        new RemovePowerTransformerEndFromPowerTransformerEndEvent(
            command.getPowerTransformerEndId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing CreatePowerTransformerEndEvent");
    this.powerTransformerEndId = event.getPowerTransformerEndId();
    this.connectionKind = event.getConnectionKind();
  }

  @EventSourcingHandler
  void on(UpdatePowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.b = event.getB();
    this.b0 = event.getB0();
    this.connectionKind = event.getConnectionKind();
    this.g = event.getG();
    this.g0 = event.getG0();
    this.phaseAngleClock = event.getPhaseAngleClock();
    this.r = event.getR();
    this.r0 = event.getR0();
    this.ratedS = event.getRatedS();
    this.ratedU = event.getRatedU();
    this.x = event.getX();
    this.x0 = event.getX0();
    this.powerTransformerEnd = event.getPowerTransformerEnd();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBToPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignBToPowerTransformerEndEvent");
    this.b = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBFromPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignBFromPowerTransformerEndEvent");
    this.b = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignB0ToPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignB0ToPowerTransformerEndEvent");
    this.b0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignB0FromPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignB0FromPowerTransformerEndEvent");
    this.b0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGToPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignGToPowerTransformerEndEvent");
    this.g = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGFromPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignGFromPowerTransformerEndEvent");
    this.g = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignG0ToPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignG0ToPowerTransformerEndEvent");
    this.g0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignG0FromPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignG0FromPowerTransformerEndEvent");
    this.g0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPhaseAngleClockToPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignPhaseAngleClockToPowerTransformerEndEvent");
    this.phaseAngleClock = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPhaseAngleClockFromPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignPhaseAngleClockFromPowerTransformerEndEvent");
    this.phaseAngleClock = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignRToPowerTransformerEndEvent");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignRFromPowerTransformerEndEvent");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignR0ToPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignR0ToPowerTransformerEndEvent");
    this.r0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignR0FromPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignR0FromPowerTransformerEndEvent");
    this.r0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRatedSToPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignRatedSToPowerTransformerEndEvent");
    this.ratedS = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRatedSFromPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignRatedSFromPowerTransformerEndEvent");
    this.ratedS = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRatedUToPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignRatedUToPowerTransformerEndEvent");
    this.ratedU = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRatedUFromPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignRatedUFromPowerTransformerEndEvent");
    this.ratedU = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXToPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignXToPowerTransformerEndEvent");
    this.x = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXFromPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignXFromPowerTransformerEndEvent");
    this.x = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignX0ToPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignX0ToPowerTransformerEndEvent");
    this.x0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignX0FromPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignX0FromPowerTransformerEndEvent");
    this.x0 = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignPowerTransformerEndToPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignPowerTransformerEndToPowerTransformerEndEvent");
    this.powerTransformerEnd.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemovePowerTransformerEndFromPowerTransformerEndEvent event) {
    LOGGER.info("Event sourcing RemovePowerTransformerEndFromPowerTransformerEndEvent");
    this.powerTransformerEnd.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID powerTransformerEndId;

  private WindingConnection connectionKind;
  private Susceptance b = null;
  private Susceptance b0 = null;
  private Conductance g = null;
  private Conductance g0 = null;
  private IntegerProxy phaseAngleClock = null;
  private Resistance r = null;
  private Resistance r0 = null;
  private ApparentPower ratedS = null;
  private Voltage ratedU = null;
  private Reactance x = null;
  private Reactance x0 = null;
  private Set<PowerTransformerEnd> powerTransformerEnd = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(PowerTransformerEndAggregate.class.getName());
}
