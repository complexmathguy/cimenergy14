package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.aggregate;

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
 * Aggregate handler for GovSteamSGO as outlined for the CQRS pattern, all write responsibilities
 * related to GovSteamSGO are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovSteamSGOAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovSteamSGOAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovSteamSGOAggregate(CreateGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handling command CreateGovSteamSGOCommand");
    CreateGovSteamSGOEvent event = new CreateGovSteamSGOEvent(command.getGovSteamSGOId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovSteamSGOCommand command) throws Exception {
    LOGGER.info("handling command UpdateGovSteamSGOCommand");
    UpdateGovSteamSGOEvent event =
        new UpdateGovSteamSGOEvent(
            command.getGovSteamSGOId(),
            command.getK1(),
            command.getK2(),
            command.getK3(),
            command.getMwbase(),
            command.getPmax(),
            command.getPmin(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getT6());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGovSteamSGOCommand");
    apply(new DeleteGovSteamSGOEvent(command.getGovSteamSGOId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignK1ToGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handling command AssignK1ToGovSteamSGOCommand");

    if (k1 != null && k1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK1ToGovSteamSGOEvent(command.getGovSteamSGOId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromGovSteamSGOCommand");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromGovSteamSGOEvent(command.getGovSteamSGOId()));
  }

  @CommandHandler
  public void handle(AssignK2ToGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handling command AssignK2ToGovSteamSGOCommand");

    if (k2 != null && k2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK2ToGovSteamSGOEvent(command.getGovSteamSGOId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK2FromGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK2FromGovSteamSGOCommand");

    if (k2 == null) throw new ProcessingException("K2 already has nothing assigned.");

    apply(new UnAssignK2FromGovSteamSGOEvent(command.getGovSteamSGOId()));
  }

  @CommandHandler
  public void handle(AssignK3ToGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handling command AssignK3ToGovSteamSGOCommand");

    if (k3 != null && k3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK3ToGovSteamSGOEvent(command.getGovSteamSGOId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK3FromGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK3FromGovSteamSGOCommand");

    if (k3 == null) throw new ProcessingException("K3 already has nothing assigned.");

    apply(new UnAssignK3FromGovSteamSGOEvent(command.getGovSteamSGOId()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovSteamSGOCommand");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovSteamSGOEvent(command.getGovSteamSGOId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovSteamSGOCommand");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovSteamSGOEvent(command.getGovSteamSGOId()));
  }

  @CommandHandler
  public void handle(AssignPmaxToGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmaxToGovSteamSGOCommand");

    if (pmax != null && pmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmaxToGovSteamSGOEvent(command.getGovSteamSGOId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxFromGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxFromGovSteamSGOCommand");

    if (pmax == null) throw new ProcessingException("Pmax already has nothing assigned.");

    apply(new UnAssignPmaxFromGovSteamSGOEvent(command.getGovSteamSGOId()));
  }

  @CommandHandler
  public void handle(AssignPminToGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handling command AssignPminToGovSteamSGOCommand");

    if (pmin != null && pmin.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignPminToGovSteamSGOEvent(command.getGovSteamSGOId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromGovSteamSGOCommand");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromGovSteamSGOEvent(command.getGovSteamSGOId()));
  }

  @CommandHandler
  public void handle(AssignT1ToGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToGovSteamSGOCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToGovSteamSGOEvent(command.getGovSteamSGOId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromGovSteamSGOCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromGovSteamSGOEvent(command.getGovSteamSGOId()));
  }

  @CommandHandler
  public void handle(AssignT2ToGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToGovSteamSGOCommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToGovSteamSGOEvent(command.getGovSteamSGOId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromGovSteamSGOCommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromGovSteamSGOEvent(command.getGovSteamSGOId()));
  }

  @CommandHandler
  public void handle(AssignT3ToGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToGovSteamSGOCommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToGovSteamSGOEvent(command.getGovSteamSGOId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromGovSteamSGOCommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromGovSteamSGOEvent(command.getGovSteamSGOId()));
  }

  @CommandHandler
  public void handle(AssignT4ToGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handling command AssignT4ToGovSteamSGOCommand");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToGovSteamSGOEvent(command.getGovSteamSGOId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromGovSteamSGOCommand");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromGovSteamSGOEvent(command.getGovSteamSGOId()));
  }

  @CommandHandler
  public void handle(AssignT5ToGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handling command AssignT5ToGovSteamSGOCommand");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToGovSteamSGOEvent(command.getGovSteamSGOId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromGovSteamSGOCommand");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromGovSteamSGOEvent(command.getGovSteamSGOId()));
  }

  @CommandHandler
  public void handle(AssignT6ToGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handling command AssignT6ToGovSteamSGOCommand");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToGovSteamSGOEvent(command.getGovSteamSGOId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromGovSteamSGOCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromGovSteamSGOCommand");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromGovSteamSGOEvent(command.getGovSteamSGOId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing CreateGovSteamSGOEvent");
    this.govSteamSGOId = event.getGovSteamSGOId();
  }

  @EventSourcingHandler
  void on(UpdateGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.k1 = event.getK1();
    this.k2 = event.getK2();
    this.k3 = event.getK3();
    this.mwbase = event.getMwbase();
    this.pmax = event.getPmax();
    this.pmin = event.getPmin();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.t6 = event.getT6();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing AssignK1ToGovSteamSGOEvent");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing UnAssignK1FromGovSteamSGOEvent");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK2ToGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing AssignK2ToGovSteamSGOEvent");
    this.k2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK2FromGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing UnAssignK2FromGovSteamSGOEvent");
    this.k2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK3ToGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing AssignK3ToGovSteamSGOEvent");
    this.k3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK3FromGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing UnAssignK3FromGovSteamSGOEvent");
    this.k3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovSteamSGOEvent");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovSteamSGOEvent");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxToGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing AssignPmaxToGovSteamSGOEvent");
    this.pmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxFromGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing UnAssignPmaxFromGovSteamSGOEvent");
    this.pmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing AssignPminToGovSteamSGOEvent");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing UnAssignPminFromGovSteamSGOEvent");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing AssignT1ToGovSteamSGOEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromGovSteamSGOEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing AssignT2ToGovSteamSGOEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromGovSteamSGOEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing AssignT3ToGovSteamSGOEvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromGovSteamSGOEvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing AssignT4ToGovSteamSGOEvent");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing UnAssignT4FromGovSteamSGOEvent");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing AssignT5ToGovSteamSGOEvent");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing UnAssignT5FromGovSteamSGOEvent");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing AssignT6ToGovSteamSGOEvent");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromGovSteamSGOEvent event) {
    LOGGER.info("Event sourcing UnAssignT6FromGovSteamSGOEvent");
    this.t6 = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govSteamSGOId;

  private PU k1 = null;
  private PU k2 = null;
  private PU k3 = null;
  private ActivePower mwbase = null;
  private PU pmax = null;
  private Seconds pmin = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Seconds t6 = null;

  private static final Logger LOGGER = Logger.getLogger(GovSteamSGOAggregate.class.getName());
}
