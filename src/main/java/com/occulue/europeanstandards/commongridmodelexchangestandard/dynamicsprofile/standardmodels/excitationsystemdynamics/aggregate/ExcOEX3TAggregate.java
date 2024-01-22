package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.aggregate;

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
 * Aggregate handler for ExcOEX3T as outlined for the CQRS pattern, all write responsibilities
 * related to ExcOEX3T are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcOEX3TAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcOEX3TAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcOEX3TAggregate(CreateExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcOEX3TCommand");
    CreateExcOEX3TEvent event = new CreateExcOEX3TEvent(command.getExcOEX3TId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcOEX3TCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcOEX3TCommand");
    UpdateExcOEX3TEvent event =
        new UpdateExcOEX3TEvent(
            command.getExcOEX3TId(),
            command.getE1(),
            command.getE2(),
            command.getKa(),
            command.getKc(),
            command.getKd(),
            command.getKe(),
            command.getKf(),
            command.getSee1(),
            command.getSee2(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getT6(),
            command.getTe(),
            command.getTf(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcOEX3TCommand");
    apply(new DeleteExcOEX3TEvent(command.getExcOEX3TId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignE1ToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignE1ToExcOEX3TCommand");

    if (e1 != null && e1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "E1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignE1ToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignE1FromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignE1FromExcOEX3TCommand");

    if (e1 == null) throw new ProcessingException("E1 already has nothing assigned.");

    apply(new UnAssignE1FromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignE2ToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignE2ToExcOEX3TCommand");

    if (e2 != null && e2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "E2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignE2ToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignE2FromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignE2FromExcOEX3TCommand");

    if (e2 == null) throw new ProcessingException("E2 already has nothing assigned.");

    apply(new UnAssignE2FromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcOEX3TCommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcOEX3TCommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcOEX3TCommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcOEX3TCommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcOEX3TCommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcOEX3TCommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcOEX3TCommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcOEX3TCommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcOEX3TCommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcOEX3TCommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignSee1ToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignSee1ToExcOEX3TCommand");

    if (see1 != null && see1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "See1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignSee1ToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSee1FromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSee1FromExcOEX3TCommand");

    if (see1 == null) throw new ProcessingException("See1 already has nothing assigned.");

    apply(new UnAssignSee1FromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignSee2ToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignSee2ToExcOEX3TCommand");

    if (see2 != null && see2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "See2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignSee2ToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSee2FromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSee2FromExcOEX3TCommand");

    if (see2 == null) throw new ProcessingException("See2 already has nothing assigned.");

    apply(new UnAssignSee2FromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignT1ToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToExcOEX3TCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromExcOEX3TCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignT2ToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToExcOEX3TCommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromExcOEX3TCommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignT3ToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToExcOEX3TCommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromExcOEX3TCommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignT4ToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignT4ToExcOEX3TCommand");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromExcOEX3TCommand");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignT5ToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignT5ToExcOEX3TCommand");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromExcOEX3TCommand");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignT6ToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignT6ToExcOEX3TCommand");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromExcOEX3TCommand");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcOEX3TCommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcOEX3TCommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcOEX3TCommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcOEX3TCommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcOEX3TCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcOEX3TCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcOEX3TCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcOEX3TEvent(command.getExcOEX3TId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcOEX3TCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcOEX3TCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcOEX3TEvent(command.getExcOEX3TId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcOEX3TEvent event) {
    LOGGER.info("Event sourcing CreateExcOEX3TEvent");
    this.excOEX3TId = event.getExcOEX3TId();
  }

  @EventSourcingHandler
  void on(UpdateExcOEX3TEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.e1 = event.getE1();
    this.e2 = event.getE2();
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.kd = event.getKd();
    this.ke = event.getKe();
    this.kf = event.getKf();
    this.see1 = event.getSee1();
    this.see2 = event.getSee2();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.t6 = event.getT6();
    this.te = event.getTe();
    this.tf = event.getTf();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignE1ToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignE1ToExcOEX3TEvent");
    this.e1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignE1FromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignE1FromExcOEX3TEvent");
    this.e1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignE2ToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignE2ToExcOEX3TEvent");
    this.e2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignE2FromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignE2FromExcOEX3TEvent");
    this.e2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcOEX3TEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcOEX3TEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcOEX3TEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcOEX3TEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcOEX3TEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcOEX3TEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcOEX3TEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcOEX3TEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcOEX3TEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcOEX3TEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSee1ToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignSee1ToExcOEX3TEvent");
    this.see1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSee1FromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignSee1FromExcOEX3TEvent");
    this.see1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSee2ToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignSee2ToExcOEX3TEvent");
    this.see2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSee2FromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignSee2FromExcOEX3TEvent");
    this.see2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignT1ToExcOEX3TEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromExcOEX3TEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignT2ToExcOEX3TEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromExcOEX3TEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignT3ToExcOEX3TEvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromExcOEX3TEvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignT4ToExcOEX3TEvent");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignT4FromExcOEX3TEvent");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignT5ToExcOEX3TEvent");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignT5FromExcOEX3TEvent");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignT6ToExcOEX3TEvent");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignT6FromExcOEX3TEvent");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcOEX3TEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcOEX3TEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcOEX3TEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcOEX3TEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcOEX3TEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcOEX3TEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcOEX3TEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcOEX3TEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcOEX3TEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcOEX3TEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excOEX3TId;

  private PU e1 = null;
  private PU e2 = null;
  private PU ka = null;
  private PU kc = null;
  private PU kd = null;
  private PU ke = null;
  private PU kf = null;
  private PU see1 = null;
  private PU see2 = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Seconds t6 = null;
  private Seconds te = null;
  private Seconds tf = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcOEX3TAggregate.class.getName());
}
