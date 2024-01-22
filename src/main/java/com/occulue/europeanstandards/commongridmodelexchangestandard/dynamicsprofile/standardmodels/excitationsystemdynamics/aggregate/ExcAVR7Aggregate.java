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
 * Aggregate handler for ExcAVR7 as outlined for the CQRS pattern, all write responsibilities
 * related to ExcAVR7 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcAVR7Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcAVR7Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcAVR7Aggregate(CreateExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command CreateExcAVR7Command");
    CreateExcAVR7Event event = new CreateExcAVR7Event(command.getExcAVR7Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcAVR7Command command) throws Exception {
    LOGGER.info("handling command UpdateExcAVR7Command");
    UpdateExcAVR7Event event =
        new UpdateExcAVR7Event(
            command.getExcAVR7Id(),
            command.getA1(),
            command.getA2(),
            command.getA3(),
            command.getA4(),
            command.getA5(),
            command.getA6(),
            command.getK1(),
            command.getK3(),
            command.getK5(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getT6(),
            command.getVmax1(),
            command.getVmax3(),
            command.getVmax5(),
            command.getVmin1(),
            command.getVmin3(),
            command.getVmin5());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command DeleteExcAVR7Command");
    apply(new DeleteExcAVR7Event(command.getExcAVR7Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignA1ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignA1ToExcAVR7Command");

    if (a1 != null && a1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA1ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA1FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignA1FromExcAVR7Command");

    if (a1 == null) throw new ProcessingException("A1 already has nothing assigned.");

    apply(new UnAssignA1FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignA2ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignA2ToExcAVR7Command");

    if (a2 != null && a2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA2ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA2FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignA2FromExcAVR7Command");

    if (a2 == null) throw new ProcessingException("A2 already has nothing assigned.");

    apply(new UnAssignA2FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignA3ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignA3ToExcAVR7Command");

    if (a3 != null && a3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA3ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA3FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignA3FromExcAVR7Command");

    if (a3 == null) throw new ProcessingException("A3 already has nothing assigned.");

    apply(new UnAssignA3FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignA4ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignA4ToExcAVR7Command");

    if (a4 != null && a4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA4ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA4FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignA4FromExcAVR7Command");

    if (a4 == null) throw new ProcessingException("A4 already has nothing assigned.");

    apply(new UnAssignA4FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignA5ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignA5ToExcAVR7Command");

    if (a5 != null && a5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA5ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA5FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignA5FromExcAVR7Command");

    if (a5 == null) throw new ProcessingException("A5 already has nothing assigned.");

    apply(new UnAssignA5FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignA6ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignA6ToExcAVR7Command");

    if (a6 != null && a6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA6ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA6FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignA6FromExcAVR7Command");

    if (a6 == null) throw new ProcessingException("A6 already has nothing assigned.");

    apply(new UnAssignA6FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignK1ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignK1ToExcAVR7Command");

    if (k1 != null && k1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK1ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromExcAVR7Command");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignK3ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignK3ToExcAVR7Command");

    if (k3 != null && k3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK3ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK3FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK3FromExcAVR7Command");

    if (k3 == null) throw new ProcessingException("K3 already has nothing assigned.");

    apply(new UnAssignK3FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignK5ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignK5ToExcAVR7Command");

    if (k5 != null && k5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK5ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK5FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK5FromExcAVR7Command");

    if (k5 == null) throw new ProcessingException("K5 already has nothing assigned.");

    apply(new UnAssignK5FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToExcAVR7Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromExcAVR7Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignT2ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignT2ToExcAVR7Command");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromExcAVR7Command");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToExcAVR7Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromExcAVR7Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignT4ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignT4ToExcAVR7Command");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromExcAVR7Command");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignT5ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignT5ToExcAVR7Command");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromExcAVR7Command");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignT6ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignT6ToExcAVR7Command");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromExcAVR7Command");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignVmax1ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignVmax1ToExcAVR7Command");

    if (vmax1 != null && vmax1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmax1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmax1ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmax1FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmax1FromExcAVR7Command");

    if (vmax1 == null) throw new ProcessingException("Vmax1 already has nothing assigned.");

    apply(new UnAssignVmax1FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignVmax3ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignVmax3ToExcAVR7Command");

    if (vmax3 != null && vmax3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmax3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmax3ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmax3FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmax3FromExcAVR7Command");

    if (vmax3 == null) throw new ProcessingException("Vmax3 already has nothing assigned.");

    apply(new UnAssignVmax3FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignVmax5ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignVmax5ToExcAVR7Command");

    if (vmax5 != null && vmax5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmax5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmax5ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmax5FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmax5FromExcAVR7Command");

    if (vmax5 == null) throw new ProcessingException("Vmax5 already has nothing assigned.");

    apply(new UnAssignVmax5FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignVmin1ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignVmin1ToExcAVR7Command");

    if (vmin1 != null && vmin1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmin1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmin1ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmin1FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmin1FromExcAVR7Command");

    if (vmin1 == null) throw new ProcessingException("Vmin1 already has nothing assigned.");

    apply(new UnAssignVmin1FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignVmin3ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignVmin3ToExcAVR7Command");

    if (vmin3 != null && vmin3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmin3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmin3ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmin3FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmin3FromExcAVR7Command");

    if (vmin3 == null) throw new ProcessingException("Vmin3 already has nothing assigned.");

    apply(new UnAssignVmin3FromExcAVR7Event(command.getExcAVR7Id()));
  }

  @CommandHandler
  public void handle(AssignVmin5ToExcAVR7Command command) throws Exception {
    LOGGER.info("Handling command AssignVmin5ToExcAVR7Command");

    if (vmin5 != null && vmin5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmin5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmin5ToExcAVR7Event(command.getExcAVR7Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmin5FromExcAVR7Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmin5FromExcAVR7Command");

    if (vmin5 == null) throw new ProcessingException("Vmin5 already has nothing assigned.");

    apply(new UnAssignVmin5FromExcAVR7Event(command.getExcAVR7Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcAVR7Event event) {
    LOGGER.info("Event sourcing CreateExcAVR7Event");
    this.excAVR7Id = event.getExcAVR7Id();
  }

  @EventSourcingHandler
  void on(UpdateExcAVR7Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.a1 = event.getA1();
    this.a2 = event.getA2();
    this.a3 = event.getA3();
    this.a4 = event.getA4();
    this.a5 = event.getA5();
    this.a6 = event.getA6();
    this.k1 = event.getK1();
    this.k3 = event.getK3();
    this.k5 = event.getK5();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.t6 = event.getT6();
    this.vmax1 = event.getVmax1();
    this.vmax3 = event.getVmax3();
    this.vmax5 = event.getVmax5();
    this.vmin1 = event.getVmin1();
    this.vmin3 = event.getVmin3();
    this.vmin5 = event.getVmin5();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignA1ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignA1ToExcAVR7Event");
    this.a1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA1FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignA1FromExcAVR7Event");
    this.a1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA2ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignA2ToExcAVR7Event");
    this.a2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA2FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignA2FromExcAVR7Event");
    this.a2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA3ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignA3ToExcAVR7Event");
    this.a3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA3FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignA3FromExcAVR7Event");
    this.a3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA4ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignA4ToExcAVR7Event");
    this.a4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA4FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignA4FromExcAVR7Event");
    this.a4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA5ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignA5ToExcAVR7Event");
    this.a5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA5FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignA5FromExcAVR7Event");
    this.a5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA6ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignA6ToExcAVR7Event");
    this.a6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA6FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignA6FromExcAVR7Event");
    this.a6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignK1ToExcAVR7Event");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignK1FromExcAVR7Event");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK3ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignK3ToExcAVR7Event");
    this.k3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK3FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignK3FromExcAVR7Event");
    this.k3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK5ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignK5ToExcAVR7Event");
    this.k5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK5FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignK5FromExcAVR7Event");
    this.k5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignT1ToExcAVR7Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromExcAVR7Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignT2ToExcAVR7Event");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignT2FromExcAVR7Event");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignT3ToExcAVR7Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromExcAVR7Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignT4ToExcAVR7Event");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignT4FromExcAVR7Event");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignT5ToExcAVR7Event");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignT5FromExcAVR7Event");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignT6ToExcAVR7Event");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignT6FromExcAVR7Event");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmax1ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignVmax1ToExcAVR7Event");
    this.vmax1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmax1FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignVmax1FromExcAVR7Event");
    this.vmax1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmax3ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignVmax3ToExcAVR7Event");
    this.vmax3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmax3FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignVmax3FromExcAVR7Event");
    this.vmax3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmax5ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignVmax5ToExcAVR7Event");
    this.vmax5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmax5FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignVmax5FromExcAVR7Event");
    this.vmax5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmin1ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignVmin1ToExcAVR7Event");
    this.vmin1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmin1FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignVmin1FromExcAVR7Event");
    this.vmin1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmin3ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignVmin3ToExcAVR7Event");
    this.vmin3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmin3FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignVmin3FromExcAVR7Event");
    this.vmin3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmin5ToExcAVR7Event event) {
    LOGGER.info("Event sourcing AssignVmin5ToExcAVR7Event");
    this.vmin5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmin5FromExcAVR7Event event) {
    LOGGER.info("Event sourcing UnAssignVmin5FromExcAVR7Event");
    this.vmin5 = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excAVR7Id;

  private PU a1 = null;
  private PU a2 = null;
  private PU a3 = null;
  private PU a4 = null;
  private PU a5 = null;
  private PU a6 = null;
  private PU k1 = null;
  private PU k3 = null;
  private PU k5 = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Seconds t6 = null;
  private PU vmax1 = null;
  private PU vmax3 = null;
  private PU vmax5 = null;
  private PU vmin1 = null;
  private PU vmin3 = null;
  private PU vmin5 = null;

  private static final Logger LOGGER = Logger.getLogger(ExcAVR7Aggregate.class.getName());
}
