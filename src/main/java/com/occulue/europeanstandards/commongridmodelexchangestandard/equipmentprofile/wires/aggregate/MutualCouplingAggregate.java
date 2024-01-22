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
 * Aggregate handler for MutualCoupling as outlined for the CQRS pattern, all write responsibilities
 * related to MutualCoupling are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class MutualCouplingAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public MutualCouplingAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public MutualCouplingAggregate(CreateMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handling command CreateMutualCouplingCommand");
    CreateMutualCouplingEvent event = new CreateMutualCouplingEvent(command.getMutualCouplingId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateMutualCouplingCommand command) throws Exception {
    LOGGER.info("handling command UpdateMutualCouplingCommand");
    UpdateMutualCouplingEvent event =
        new UpdateMutualCouplingEvent(
            command.getMutualCouplingId(),
            command.getB0ch(),
            command.getDistance11(),
            command.getDistance12(),
            command.getDistance21(),
            command.getDistance22(),
            command.getG0ch(),
            command.getR0(),
            command.getX0(),
            command.getHasSecondMutualCoupling(),
            command.getHasFirstMutualCoupling());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handling command DeleteMutualCouplingCommand");
    apply(new DeleteMutualCouplingEvent(command.getMutualCouplingId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignB0chToMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handling command AssignB0chToMutualCouplingCommand");

    if (b0ch != null && b0ch.getSusceptanceId() == command.getAssignment().getSusceptanceId())
      throw new ProcessingException(
          "B0ch already assigned with id " + command.getAssignment().getSusceptanceId());

    apply(
        new AssignB0chToMutualCouplingEvent(
            command.getMutualCouplingId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignB0chFromMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignB0chFromMutualCouplingCommand");

    if (b0ch == null) throw new ProcessingException("B0ch already has nothing assigned.");

    apply(new UnAssignB0chFromMutualCouplingEvent(command.getMutualCouplingId()));
  }

  @CommandHandler
  public void handle(AssignDistance11ToMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handling command AssignDistance11ToMutualCouplingCommand");

    if (distance11 != null && distance11.getLengthId() == command.getAssignment().getLengthId())
      throw new ProcessingException(
          "Distance11 already assigned with id " + command.getAssignment().getLengthId());

    apply(
        new AssignDistance11ToMutualCouplingEvent(
            command.getMutualCouplingId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDistance11FromMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDistance11FromMutualCouplingCommand");

    if (distance11 == null)
      throw new ProcessingException("Distance11 already has nothing assigned.");

    apply(new UnAssignDistance11FromMutualCouplingEvent(command.getMutualCouplingId()));
  }

  @CommandHandler
  public void handle(AssignDistance12ToMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handling command AssignDistance12ToMutualCouplingCommand");

    if (distance12 != null && distance12.getLengthId() == command.getAssignment().getLengthId())
      throw new ProcessingException(
          "Distance12 already assigned with id " + command.getAssignment().getLengthId());

    apply(
        new AssignDistance12ToMutualCouplingEvent(
            command.getMutualCouplingId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDistance12FromMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDistance12FromMutualCouplingCommand");

    if (distance12 == null)
      throw new ProcessingException("Distance12 already has nothing assigned.");

    apply(new UnAssignDistance12FromMutualCouplingEvent(command.getMutualCouplingId()));
  }

  @CommandHandler
  public void handle(AssignDistance21ToMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handling command AssignDistance21ToMutualCouplingCommand");

    if (distance21 != null && distance21.getLengthId() == command.getAssignment().getLengthId())
      throw new ProcessingException(
          "Distance21 already assigned with id " + command.getAssignment().getLengthId());

    apply(
        new AssignDistance21ToMutualCouplingEvent(
            command.getMutualCouplingId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDistance21FromMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDistance21FromMutualCouplingCommand");

    if (distance21 == null)
      throw new ProcessingException("Distance21 already has nothing assigned.");

    apply(new UnAssignDistance21FromMutualCouplingEvent(command.getMutualCouplingId()));
  }

  @CommandHandler
  public void handle(AssignDistance22ToMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handling command AssignDistance22ToMutualCouplingCommand");

    if (distance22 != null && distance22.getLengthId() == command.getAssignment().getLengthId())
      throw new ProcessingException(
          "Distance22 already assigned with id " + command.getAssignment().getLengthId());

    apply(
        new AssignDistance22ToMutualCouplingEvent(
            command.getMutualCouplingId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDistance22FromMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDistance22FromMutualCouplingCommand");

    if (distance22 == null)
      throw new ProcessingException("Distance22 already has nothing assigned.");

    apply(new UnAssignDistance22FromMutualCouplingEvent(command.getMutualCouplingId()));
  }

  @CommandHandler
  public void handle(AssignG0chToMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handling command AssignG0chToMutualCouplingCommand");

    if (g0ch != null && g0ch.getConductanceId() == command.getAssignment().getConductanceId())
      throw new ProcessingException(
          "G0ch already assigned with id " + command.getAssignment().getConductanceId());

    apply(
        new AssignG0chToMutualCouplingEvent(
            command.getMutualCouplingId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignG0chFromMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignG0chFromMutualCouplingCommand");

    if (g0ch == null) throw new ProcessingException("G0ch already has nothing assigned.");

    apply(new UnAssignG0chFromMutualCouplingEvent(command.getMutualCouplingId()));
  }

  @CommandHandler
  public void handle(AssignR0ToMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handling command AssignR0ToMutualCouplingCommand");

    if (r0 != null && r0.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R0 already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignR0ToMutualCouplingEvent(command.getMutualCouplingId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignR0FromMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignR0FromMutualCouplingCommand");

    if (r0 == null) throw new ProcessingException("R0 already has nothing assigned.");

    apply(new UnAssignR0FromMutualCouplingEvent(command.getMutualCouplingId()));
  }

  @CommandHandler
  public void handle(AssignX0ToMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handling command AssignX0ToMutualCouplingCommand");

    if (x0 != null && x0.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "X0 already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignX0ToMutualCouplingEvent(command.getMutualCouplingId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignX0FromMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignX0FromMutualCouplingCommand");

    if (x0 == null) throw new ProcessingException("X0 already has nothing assigned.");

    apply(new UnAssignX0FromMutualCouplingEvent(command.getMutualCouplingId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignHasSecondMutualCouplingToMutualCouplingCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignHasSecondMutualCouplingToMutualCouplingCommand");

    if (hasSecondMutualCoupling.contains(command.getAddTo()))
      throw new ProcessingException(
          "HasSecondMutualCoupling already contains an entity with id "
              + command.getAddTo().getMutualCouplingId());

    apply(
        new AssignHasSecondMutualCouplingToMutualCouplingEvent(
            command.getMutualCouplingId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveHasSecondMutualCouplingFromMutualCouplingCommand command)
      throws Exception {
    LOGGER.info("Handling command RemoveHasSecondMutualCouplingFromMutualCouplingCommand");

    if (!hasSecondMutualCoupling.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "HasSecondMutualCoupling does not contain an entity with id "
              + command.getRemoveFrom().getMutualCouplingId());

    apply(
        new RemoveHasSecondMutualCouplingFromMutualCouplingEvent(
            command.getMutualCouplingId(), command.getRemoveFrom()));
  }

  @CommandHandler
  public void handle(AssignHasFirstMutualCouplingToMutualCouplingCommand command) throws Exception {
    LOGGER.info("Handling command AssignHasFirstMutualCouplingToMutualCouplingCommand");

    if (hasFirstMutualCoupling.contains(command.getAddTo()))
      throw new ProcessingException(
          "HasFirstMutualCoupling already contains an entity with id "
              + command.getAddTo().getMutualCouplingId());

    apply(
        new AssignHasFirstMutualCouplingToMutualCouplingEvent(
            command.getMutualCouplingId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveHasFirstMutualCouplingFromMutualCouplingCommand command)
      throws Exception {
    LOGGER.info("Handling command RemoveHasFirstMutualCouplingFromMutualCouplingCommand");

    if (!hasFirstMutualCoupling.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "HasFirstMutualCoupling does not contain an entity with id "
              + command.getRemoveFrom().getMutualCouplingId());

    apply(
        new RemoveHasFirstMutualCouplingFromMutualCouplingEvent(
            command.getMutualCouplingId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateMutualCouplingEvent event) {
    LOGGER.info("Event sourcing CreateMutualCouplingEvent");
    this.mutualCouplingId = event.getMutualCouplingId();
  }

  @EventSourcingHandler
  void on(UpdateMutualCouplingEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.b0ch = event.getB0ch();
    this.distance11 = event.getDistance11();
    this.distance12 = event.getDistance12();
    this.distance21 = event.getDistance21();
    this.distance22 = event.getDistance22();
    this.g0ch = event.getG0ch();
    this.r0 = event.getR0();
    this.x0 = event.getX0();
    this.hasSecondMutualCoupling = event.getHasSecondMutualCoupling();
    this.hasFirstMutualCoupling = event.getHasFirstMutualCoupling();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignB0chToMutualCouplingEvent event) {
    LOGGER.info("Event sourcing AssignB0chToMutualCouplingEvent");
    this.b0ch = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignB0chFromMutualCouplingEvent event) {
    LOGGER.info("Event sourcing UnAssignB0chFromMutualCouplingEvent");
    this.b0ch = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDistance11ToMutualCouplingEvent event) {
    LOGGER.info("Event sourcing AssignDistance11ToMutualCouplingEvent");
    this.distance11 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDistance11FromMutualCouplingEvent event) {
    LOGGER.info("Event sourcing UnAssignDistance11FromMutualCouplingEvent");
    this.distance11 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDistance12ToMutualCouplingEvent event) {
    LOGGER.info("Event sourcing AssignDistance12ToMutualCouplingEvent");
    this.distance12 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDistance12FromMutualCouplingEvent event) {
    LOGGER.info("Event sourcing UnAssignDistance12FromMutualCouplingEvent");
    this.distance12 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDistance21ToMutualCouplingEvent event) {
    LOGGER.info("Event sourcing AssignDistance21ToMutualCouplingEvent");
    this.distance21 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDistance21FromMutualCouplingEvent event) {
    LOGGER.info("Event sourcing UnAssignDistance21FromMutualCouplingEvent");
    this.distance21 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDistance22ToMutualCouplingEvent event) {
    LOGGER.info("Event sourcing AssignDistance22ToMutualCouplingEvent");
    this.distance22 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDistance22FromMutualCouplingEvent event) {
    LOGGER.info("Event sourcing UnAssignDistance22FromMutualCouplingEvent");
    this.distance22 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignG0chToMutualCouplingEvent event) {
    LOGGER.info("Event sourcing AssignG0chToMutualCouplingEvent");
    this.g0ch = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignG0chFromMutualCouplingEvent event) {
    LOGGER.info("Event sourcing UnAssignG0chFromMutualCouplingEvent");
    this.g0ch = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignR0ToMutualCouplingEvent event) {
    LOGGER.info("Event sourcing AssignR0ToMutualCouplingEvent");
    this.r0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignR0FromMutualCouplingEvent event) {
    LOGGER.info("Event sourcing UnAssignR0FromMutualCouplingEvent");
    this.r0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignX0ToMutualCouplingEvent event) {
    LOGGER.info("Event sourcing AssignX0ToMutualCouplingEvent");
    this.x0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignX0FromMutualCouplingEvent event) {
    LOGGER.info("Event sourcing UnAssignX0FromMutualCouplingEvent");
    this.x0 = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignHasSecondMutualCouplingToMutualCouplingEvent event) {
    LOGGER.info("Event sourcing AssignHasSecondMutualCouplingToMutualCouplingEvent");
    this.hasSecondMutualCoupling.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveHasSecondMutualCouplingFromMutualCouplingEvent event) {
    LOGGER.info("Event sourcing RemoveHasSecondMutualCouplingFromMutualCouplingEvent");
    this.hasSecondMutualCoupling.remove(event.getRemoveFrom());
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignHasFirstMutualCouplingToMutualCouplingEvent event) {
    LOGGER.info("Event sourcing AssignHasFirstMutualCouplingToMutualCouplingEvent");
    this.hasFirstMutualCoupling.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveHasFirstMutualCouplingFromMutualCouplingEvent event) {
    LOGGER.info("Event sourcing RemoveHasFirstMutualCouplingFromMutualCouplingEvent");
    this.hasFirstMutualCoupling.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID mutualCouplingId;

  private Susceptance b0ch = null;
  private Length distance11 = null;
  private Length distance12 = null;
  private Length distance21 = null;
  private Length distance22 = null;
  private Conductance g0ch = null;
  private Resistance r0 = null;
  private Reactance x0 = null;
  private Set<MutualCoupling> hasSecondMutualCoupling = new HashSet<>();
  private Set<MutualCoupling> hasFirstMutualCoupling = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(MutualCouplingAggregate.class.getName());
}
