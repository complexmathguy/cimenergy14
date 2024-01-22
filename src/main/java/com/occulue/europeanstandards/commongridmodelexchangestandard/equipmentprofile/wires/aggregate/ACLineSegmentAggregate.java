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
 * Aggregate handler for ACLineSegment as outlined for the CQRS pattern, all write responsibilities
 * related to ACLineSegment are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ACLineSegmentAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ACLineSegmentAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ACLineSegmentAggregate(CreateACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handling command CreateACLineSegmentCommand");
    CreateACLineSegmentEvent event = new CreateACLineSegmentEvent(command.getACLineSegmentId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateACLineSegmentCommand command) throws Exception {
    LOGGER.info("handling command UpdateACLineSegmentCommand");
    UpdateACLineSegmentEvent event =
        new UpdateACLineSegmentEvent(
            command.getACLineSegmentId(),
            command.getB0ch(),
            command.getBch(),
            command.getG0ch(),
            command.getGch(),
            command.getR(),
            command.getR0(),
            command.getShortCircuitEndTemperature(),
            command.getX(),
            command.getX0());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handling command DeleteACLineSegmentCommand");
    apply(new DeleteACLineSegmentEvent(command.getACLineSegmentId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignB0chToACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handling command AssignB0chToACLineSegmentCommand");

    if (b0ch != null && b0ch.getSusceptanceId() == command.getAssignment().getSusceptanceId())
      throw new ProcessingException(
          "B0ch already assigned with id " + command.getAssignment().getSusceptanceId());

    apply(
        new AssignB0chToACLineSegmentEvent(command.getACLineSegmentId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignB0chFromACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignB0chFromACLineSegmentCommand");

    if (b0ch == null) throw new ProcessingException("B0ch already has nothing assigned.");

    apply(new UnAssignB0chFromACLineSegmentEvent(command.getACLineSegmentId()));
  }

  @CommandHandler
  public void handle(AssignBchToACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handling command AssignBchToACLineSegmentCommand");

    if (bch != null && bch.getSusceptanceId() == command.getAssignment().getSusceptanceId())
      throw new ProcessingException(
          "Bch already assigned with id " + command.getAssignment().getSusceptanceId());

    apply(new AssignBchToACLineSegmentEvent(command.getACLineSegmentId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBchFromACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBchFromACLineSegmentCommand");

    if (bch == null) throw new ProcessingException("Bch already has nothing assigned.");

    apply(new UnAssignBchFromACLineSegmentEvent(command.getACLineSegmentId()));
  }

  @CommandHandler
  public void handle(AssignG0chToACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handling command AssignG0chToACLineSegmentCommand");

    if (g0ch != null && g0ch.getConductanceId() == command.getAssignment().getConductanceId())
      throw new ProcessingException(
          "G0ch already assigned with id " + command.getAssignment().getConductanceId());

    apply(
        new AssignG0chToACLineSegmentEvent(command.getACLineSegmentId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignG0chFromACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignG0chFromACLineSegmentCommand");

    if (g0ch == null) throw new ProcessingException("G0ch already has nothing assigned.");

    apply(new UnAssignG0chFromACLineSegmentEvent(command.getACLineSegmentId()));
  }

  @CommandHandler
  public void handle(AssignGchToACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handling command AssignGchToACLineSegmentCommand");

    if (gch != null && gch.getConductanceId() == command.getAssignment().getConductanceId())
      throw new ProcessingException(
          "Gch already assigned with id " + command.getAssignment().getConductanceId());

    apply(new AssignGchToACLineSegmentEvent(command.getACLineSegmentId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGchFromACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGchFromACLineSegmentCommand");

    if (gch == null) throw new ProcessingException("Gch already has nothing assigned.");

    apply(new UnAssignGchFromACLineSegmentEvent(command.getACLineSegmentId()));
  }

  @CommandHandler
  public void handle(AssignRToACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handling command AssignRToACLineSegmentCommand");

    if (r != null && r.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getResistanceId());

    apply(new AssignRToACLineSegmentEvent(command.getACLineSegmentId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromACLineSegmentCommand");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromACLineSegmentEvent(command.getACLineSegmentId()));
  }

  @CommandHandler
  public void handle(AssignR0ToACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handling command AssignR0ToACLineSegmentCommand");

    if (r0 != null && r0.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R0 already assigned with id " + command.getAssignment().getResistanceId());

    apply(new AssignR0ToACLineSegmentEvent(command.getACLineSegmentId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignR0FromACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignR0FromACLineSegmentCommand");

    if (r0 == null) throw new ProcessingException("R0 already has nothing assigned.");

    apply(new UnAssignR0FromACLineSegmentEvent(command.getACLineSegmentId()));
  }

  @CommandHandler
  public void handle(AssignShortCircuitEndTemperatureToACLineSegmentCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignShortCircuitEndTemperatureToACLineSegmentCommand");

    if (shortCircuitEndTemperature != null
        && shortCircuitEndTemperature.getTemperatureId()
            == command.getAssignment().getTemperatureId())
      throw new ProcessingException(
          "ShortCircuitEndTemperature already assigned with id "
              + command.getAssignment().getTemperatureId());

    apply(
        new AssignShortCircuitEndTemperatureToACLineSegmentEvent(
            command.getACLineSegmentId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignShortCircuitEndTemperatureFromACLineSegmentCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignShortCircuitEndTemperatureFromACLineSegmentCommand");

    if (shortCircuitEndTemperature == null)
      throw new ProcessingException("ShortCircuitEndTemperature already has nothing assigned.");

    apply(
        new UnAssignShortCircuitEndTemperatureFromACLineSegmentEvent(command.getACLineSegmentId()));
  }

  @CommandHandler
  public void handle(AssignXToACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handling command AssignXToACLineSegmentCommand");

    if (x != null && x.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "X already assigned with id " + command.getAssignment().getReactanceId());

    apply(new AssignXToACLineSegmentEvent(command.getACLineSegmentId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXFromACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXFromACLineSegmentCommand");

    if (x == null) throw new ProcessingException("X already has nothing assigned.");

    apply(new UnAssignXFromACLineSegmentEvent(command.getACLineSegmentId()));
  }

  @CommandHandler
  public void handle(AssignX0ToACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handling command AssignX0ToACLineSegmentCommand");

    if (x0 != null && x0.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "X0 already assigned with id " + command.getAssignment().getReactanceId());

    apply(new AssignX0ToACLineSegmentEvent(command.getACLineSegmentId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignX0FromACLineSegmentCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignX0FromACLineSegmentCommand");

    if (x0 == null) throw new ProcessingException("X0 already has nothing assigned.");

    apply(new UnAssignX0FromACLineSegmentEvent(command.getACLineSegmentId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateACLineSegmentEvent event) {
    LOGGER.info("Event sourcing CreateACLineSegmentEvent");
    this.aCLineSegmentId = event.getACLineSegmentId();
  }

  @EventSourcingHandler
  void on(UpdateACLineSegmentEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.b0ch = event.getB0ch();
    this.bch = event.getBch();
    this.g0ch = event.getG0ch();
    this.gch = event.getGch();
    this.r = event.getR();
    this.r0 = event.getR0();
    this.shortCircuitEndTemperature = event.getShortCircuitEndTemperature();
    this.x = event.getX();
    this.x0 = event.getX0();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignB0chToACLineSegmentEvent event) {
    LOGGER.info("Event sourcing AssignB0chToACLineSegmentEvent");
    this.b0ch = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignB0chFromACLineSegmentEvent event) {
    LOGGER.info("Event sourcing UnAssignB0chFromACLineSegmentEvent");
    this.b0ch = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBchToACLineSegmentEvent event) {
    LOGGER.info("Event sourcing AssignBchToACLineSegmentEvent");
    this.bch = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBchFromACLineSegmentEvent event) {
    LOGGER.info("Event sourcing UnAssignBchFromACLineSegmentEvent");
    this.bch = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignG0chToACLineSegmentEvent event) {
    LOGGER.info("Event sourcing AssignG0chToACLineSegmentEvent");
    this.g0ch = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignG0chFromACLineSegmentEvent event) {
    LOGGER.info("Event sourcing UnAssignG0chFromACLineSegmentEvent");
    this.g0ch = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGchToACLineSegmentEvent event) {
    LOGGER.info("Event sourcing AssignGchToACLineSegmentEvent");
    this.gch = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGchFromACLineSegmentEvent event) {
    LOGGER.info("Event sourcing UnAssignGchFromACLineSegmentEvent");
    this.gch = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToACLineSegmentEvent event) {
    LOGGER.info("Event sourcing AssignRToACLineSegmentEvent");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromACLineSegmentEvent event) {
    LOGGER.info("Event sourcing UnAssignRFromACLineSegmentEvent");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignR0ToACLineSegmentEvent event) {
    LOGGER.info("Event sourcing AssignR0ToACLineSegmentEvent");
    this.r0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignR0FromACLineSegmentEvent event) {
    LOGGER.info("Event sourcing UnAssignR0FromACLineSegmentEvent");
    this.r0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignShortCircuitEndTemperatureToACLineSegmentEvent event) {
    LOGGER.info("Event sourcing AssignShortCircuitEndTemperatureToACLineSegmentEvent");
    this.shortCircuitEndTemperature = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignShortCircuitEndTemperatureFromACLineSegmentEvent event) {
    LOGGER.info("Event sourcing UnAssignShortCircuitEndTemperatureFromACLineSegmentEvent");
    this.shortCircuitEndTemperature = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXToACLineSegmentEvent event) {
    LOGGER.info("Event sourcing AssignXToACLineSegmentEvent");
    this.x = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXFromACLineSegmentEvent event) {
    LOGGER.info("Event sourcing UnAssignXFromACLineSegmentEvent");
    this.x = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignX0ToACLineSegmentEvent event) {
    LOGGER.info("Event sourcing AssignX0ToACLineSegmentEvent");
    this.x0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignX0FromACLineSegmentEvent event) {
    LOGGER.info("Event sourcing UnAssignX0FromACLineSegmentEvent");
    this.x0 = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID aCLineSegmentId;

  private Susceptance b0ch = null;
  private Susceptance bch = null;
  private Conductance g0ch = null;
  private Conductance gch = null;
  private Resistance r = null;
  private Resistance r0 = null;
  private Temperature shortCircuitEndTemperature = null;
  private Reactance x = null;
  private Reactance x0 = null;

  private static final Logger LOGGER = Logger.getLogger(ACLineSegmentAggregate.class.getName());
}
