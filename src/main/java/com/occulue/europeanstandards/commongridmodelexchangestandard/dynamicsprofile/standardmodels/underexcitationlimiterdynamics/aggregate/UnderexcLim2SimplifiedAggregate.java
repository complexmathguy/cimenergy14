package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.aggregate;

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
 * Aggregate handler for UnderexcLim2Simplified as outlined for the CQRS pattern, all write
 * responsibilities related to UnderexcLim2Simplified are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class UnderexcLim2SimplifiedAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public UnderexcLim2SimplifiedAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public UnderexcLim2SimplifiedAggregate(CreateUnderexcLim2SimplifiedCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateUnderexcLim2SimplifiedCommand");
    CreateUnderexcLim2SimplifiedEvent event =
        new CreateUnderexcLim2SimplifiedEvent(command.getUnderexcLim2SimplifiedId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("handling command UpdateUnderexcLim2SimplifiedCommand");
    UpdateUnderexcLim2SimplifiedEvent event =
        new UpdateUnderexcLim2SimplifiedEvent(
            command.getUnderexcLim2SimplifiedId(),
            command.getKui(),
            command.getP0(),
            command.getP1(),
            command.getQ0(),
            command.getQ1(),
            command.getVuimax(),
            command.getVuimin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handling command DeleteUnderexcLim2SimplifiedCommand");
    apply(new DeleteUnderexcLim2SimplifiedEvent(command.getUnderexcLim2SimplifiedId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKuiToUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handling command AssignKuiToUnderexcLim2SimplifiedCommand");

    if (kui != null && kui.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kui already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKuiToUnderexcLim2SimplifiedEvent(
            command.getUnderexcLim2SimplifiedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKuiFromUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKuiFromUnderexcLim2SimplifiedCommand");

    if (kui == null) throw new ProcessingException("Kui already has nothing assigned.");

    apply(new UnAssignKuiFromUnderexcLim2SimplifiedEvent(command.getUnderexcLim2SimplifiedId()));
  }

  @CommandHandler
  public void handle(AssignP0ToUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handling command AssignP0ToUnderexcLim2SimplifiedCommand");

    if (p0 != null && p0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P0 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignP0ToUnderexcLim2SimplifiedEvent(
            command.getUnderexcLim2SimplifiedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP0FromUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignP0FromUnderexcLim2SimplifiedCommand");

    if (p0 == null) throw new ProcessingException("P0 already has nothing assigned.");

    apply(new UnAssignP0FromUnderexcLim2SimplifiedEvent(command.getUnderexcLim2SimplifiedId()));
  }

  @CommandHandler
  public void handle(AssignP1ToUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handling command AssignP1ToUnderexcLim2SimplifiedCommand");

    if (p1 != null && p1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P1 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignP1ToUnderexcLim2SimplifiedEvent(
            command.getUnderexcLim2SimplifiedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP1FromUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignP1FromUnderexcLim2SimplifiedCommand");

    if (p1 == null) throw new ProcessingException("P1 already has nothing assigned.");

    apply(new UnAssignP1FromUnderexcLim2SimplifiedEvent(command.getUnderexcLim2SimplifiedId()));
  }

  @CommandHandler
  public void handle(AssignQ0ToUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handling command AssignQ0ToUnderexcLim2SimplifiedCommand");

    if (q0 != null && q0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Q0 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQ0ToUnderexcLim2SimplifiedEvent(
            command.getUnderexcLim2SimplifiedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQ0FromUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQ0FromUnderexcLim2SimplifiedCommand");

    if (q0 == null) throw new ProcessingException("Q0 already has nothing assigned.");

    apply(new UnAssignQ0FromUnderexcLim2SimplifiedEvent(command.getUnderexcLim2SimplifiedId()));
  }

  @CommandHandler
  public void handle(AssignQ1ToUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handling command AssignQ1ToUnderexcLim2SimplifiedCommand");

    if (q1 != null && q1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Q1 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQ1ToUnderexcLim2SimplifiedEvent(
            command.getUnderexcLim2SimplifiedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQ1FromUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQ1FromUnderexcLim2SimplifiedCommand");

    if (q1 == null) throw new ProcessingException("Q1 already has nothing assigned.");

    apply(new UnAssignQ1FromUnderexcLim2SimplifiedEvent(command.getUnderexcLim2SimplifiedId()));
  }

  @CommandHandler
  public void handle(AssignVuimaxToUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handling command AssignVuimaxToUnderexcLim2SimplifiedCommand");

    if (vuimax != null && vuimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vuimax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVuimaxToUnderexcLim2SimplifiedEvent(
            command.getUnderexcLim2SimplifiedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVuimaxFromUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVuimaxFromUnderexcLim2SimplifiedCommand");

    if (vuimax == null) throw new ProcessingException("Vuimax already has nothing assigned.");

    apply(new UnAssignVuimaxFromUnderexcLim2SimplifiedEvent(command.getUnderexcLim2SimplifiedId()));
  }

  @CommandHandler
  public void handle(AssignVuiminToUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handling command AssignVuiminToUnderexcLim2SimplifiedCommand");

    if (vuimin != null && vuimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vuimin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVuiminToUnderexcLim2SimplifiedEvent(
            command.getUnderexcLim2SimplifiedId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVuiminFromUnderexcLim2SimplifiedCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVuiminFromUnderexcLim2SimplifiedCommand");

    if (vuimin == null) throw new ProcessingException("Vuimin already has nothing assigned.");

    apply(new UnAssignVuiminFromUnderexcLim2SimplifiedEvent(command.getUnderexcLim2SimplifiedId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing CreateUnderexcLim2SimplifiedEvent");
    this.underexcLim2SimplifiedId = event.getUnderexcLim2SimplifiedId();
  }

  @EventSourcingHandler
  void on(UpdateUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.kui = event.getKui();
    this.p0 = event.getP0();
    this.p1 = event.getP1();
    this.q0 = event.getQ0();
    this.q1 = event.getQ1();
    this.vuimax = event.getVuimax();
    this.vuimin = event.getVuimin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKuiToUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing AssignKuiToUnderexcLim2SimplifiedEvent");
    this.kui = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKuiFromUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing UnAssignKuiFromUnderexcLim2SimplifiedEvent");
    this.kui = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP0ToUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing AssignP0ToUnderexcLim2SimplifiedEvent");
    this.p0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP0FromUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing UnAssignP0FromUnderexcLim2SimplifiedEvent");
    this.p0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP1ToUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing AssignP1ToUnderexcLim2SimplifiedEvent");
    this.p1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP1FromUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing UnAssignP1FromUnderexcLim2SimplifiedEvent");
    this.p1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQ0ToUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing AssignQ0ToUnderexcLim2SimplifiedEvent");
    this.q0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQ0FromUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing UnAssignQ0FromUnderexcLim2SimplifiedEvent");
    this.q0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQ1ToUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing AssignQ1ToUnderexcLim2SimplifiedEvent");
    this.q1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQ1FromUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing UnAssignQ1FromUnderexcLim2SimplifiedEvent");
    this.q1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVuimaxToUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing AssignVuimaxToUnderexcLim2SimplifiedEvent");
    this.vuimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVuimaxFromUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing UnAssignVuimaxFromUnderexcLim2SimplifiedEvent");
    this.vuimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVuiminToUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing AssignVuiminToUnderexcLim2SimplifiedEvent");
    this.vuimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVuiminFromUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("Event sourcing UnAssignVuiminFromUnderexcLim2SimplifiedEvent");
    this.vuimin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID underexcLim2SimplifiedId;

  private PU kui = null;
  private PU p0 = null;
  private PU p1 = null;
  private PU q0 = null;
  private PU q1 = null;
  private PU vuimax = null;
  private PU vuimin = null;

  private static final Logger LOGGER =
      Logger.getLogger(UnderexcLim2SimplifiedAggregate.class.getName());
}
