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
 * Aggregate handler for GovSteamIEEE1 as outlined for the CQRS pattern, all write responsibilities
 * related to GovSteamIEEE1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovSteamIEEE1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovSteamIEEE1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovSteamIEEE1Aggregate(CreateGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command CreateGovSteamIEEE1Command");
    CreateGovSteamIEEE1Event event = new CreateGovSteamIEEE1Event(command.getGovSteamIEEE1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("handling command UpdateGovSteamIEEE1Command");
    UpdateGovSteamIEEE1Event event =
        new UpdateGovSteamIEEE1Event(
            command.getGovSteamIEEE1Id(),
            command.getK(),
            command.getK1(),
            command.getK2(),
            command.getK3(),
            command.getK4(),
            command.getK5(),
            command.getK6(),
            command.getK7(),
            command.getK8(),
            command.getMwbase(),
            command.getPmax(),
            command.getPmin(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getT6(),
            command.getT7(),
            command.getUc(),
            command.getUo());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovSteamIEEE1Command");
    apply(new DeleteGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignKToGovSteamIEEE1Command");

    if (k != null && k.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKFromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKFromGovSteamIEEE1Command");

    if (k == null) throw new ProcessingException("K already has nothing assigned.");

    apply(new UnAssignKFromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignK1ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignK1ToGovSteamIEEE1Command");

    if (k1 != null && k1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK1ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromGovSteamIEEE1Command");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignK2ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignK2ToGovSteamIEEE1Command");

    if (k2 != null && k2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK2ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK2FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK2FromGovSteamIEEE1Command");

    if (k2 == null) throw new ProcessingException("K2 already has nothing assigned.");

    apply(new UnAssignK2FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignK3ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignK3ToGovSteamIEEE1Command");

    if (k3 != null && k3.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K3 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK3ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK3FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK3FromGovSteamIEEE1Command");

    if (k3 == null) throw new ProcessingException("K3 already has nothing assigned.");

    apply(new UnAssignK3FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignK4ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignK4ToGovSteamIEEE1Command");

    if (k4 != null && k4.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K4 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK4ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK4FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK4FromGovSteamIEEE1Command");

    if (k4 == null) throw new ProcessingException("K4 already has nothing assigned.");

    apply(new UnAssignK4FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignK5ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignK5ToGovSteamIEEE1Command");

    if (k5 != null && k5.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K5 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK5ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK5FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK5FromGovSteamIEEE1Command");

    if (k5 == null) throw new ProcessingException("K5 already has nothing assigned.");

    apply(new UnAssignK5FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignK6ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignK6ToGovSteamIEEE1Command");

    if (k6 != null && k6.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K6 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK6ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK6FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK6FromGovSteamIEEE1Command");

    if (k6 == null) throw new ProcessingException("K6 already has nothing assigned.");

    apply(new UnAssignK6FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignK7ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignK7ToGovSteamIEEE1Command");

    if (k7 != null && k7.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K7 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK7ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK7FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK7FromGovSteamIEEE1Command");

    if (k7 == null) throw new ProcessingException("K7 already has nothing assigned.");

    apply(new UnAssignK7FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignK8ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignK8ToGovSteamIEEE1Command");

    if (k8 != null && k8.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K8 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK8ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK8FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK8FromGovSteamIEEE1Command");

    if (k8 == null) throw new ProcessingException("K8 already has nothing assigned.");

    apply(new UnAssignK8FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovSteamIEEE1Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignMwbaseToGovSteamIEEE1Event(
            command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovSteamIEEE1Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignPmaxToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignPmaxToGovSteamIEEE1Command");

    if (pmax != null && pmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPmaxToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxFromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxFromGovSteamIEEE1Command");

    if (pmax == null) throw new ProcessingException("Pmax already has nothing assigned.");

    apply(new UnAssignPmaxFromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignPminToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignPminToGovSteamIEEE1Command");

    if (pmin != null && pmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPminToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromGovSteamIEEE1Command");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToGovSteamIEEE1Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromGovSteamIEEE1Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignT2ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignT2ToGovSteamIEEE1Command");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromGovSteamIEEE1Command");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToGovSteamIEEE1Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromGovSteamIEEE1Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignT4ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignT4ToGovSteamIEEE1Command");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromGovSteamIEEE1Command");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignT5ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignT5ToGovSteamIEEE1Command");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromGovSteamIEEE1Command");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignT6ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignT6ToGovSteamIEEE1Command");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromGovSteamIEEE1Command");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignT7ToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignT7ToGovSteamIEEE1Command");

    if (t7 != null && t7.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T7 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT7ToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT7FromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT7FromGovSteamIEEE1Command");

    if (t7 == null) throw new ProcessingException("T7 already has nothing assigned.");

    apply(new UnAssignT7FromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignUcToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignUcToGovSteamIEEE1Command");

    if (uc != null && uc.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Uc already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignUcToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUcFromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignUcFromGovSteamIEEE1Command");

    if (uc == null) throw new ProcessingException("Uc already has nothing assigned.");

    apply(new UnAssignUcFromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  @CommandHandler
  public void handle(AssignUoToGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handling command AssignUoToGovSteamIEEE1Command");

    if (uo != null && uo.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Uo already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignUoToGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUoFromGovSteamIEEE1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignUoFromGovSteamIEEE1Command");

    if (uo == null) throw new ProcessingException("Uo already has nothing assigned.");

    apply(new UnAssignUoFromGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing CreateGovSteamIEEE1Event");
    this.govSteamIEEE1Id = event.getGovSteamIEEE1Id();
  }

  @EventSourcingHandler
  void on(UpdateGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.k = event.getK();
    this.k1 = event.getK1();
    this.k2 = event.getK2();
    this.k3 = event.getK3();
    this.k4 = event.getK4();
    this.k5 = event.getK5();
    this.k6 = event.getK6();
    this.k7 = event.getK7();
    this.k8 = event.getK8();
    this.mwbase = event.getMwbase();
    this.pmax = event.getPmax();
    this.pmin = event.getPmin();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.t6 = event.getT6();
    this.t7 = event.getT7();
    this.uc = event.getUc();
    this.uo = event.getUo();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignKToGovSteamIEEE1Event");
    this.k = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKFromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignKFromGovSteamIEEE1Event");
    this.k = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignK1ToGovSteamIEEE1Event");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignK1FromGovSteamIEEE1Event");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK2ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignK2ToGovSteamIEEE1Event");
    this.k2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK2FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignK2FromGovSteamIEEE1Event");
    this.k2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK3ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignK3ToGovSteamIEEE1Event");
    this.k3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK3FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignK3FromGovSteamIEEE1Event");
    this.k3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK4ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignK4ToGovSteamIEEE1Event");
    this.k4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK4FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignK4FromGovSteamIEEE1Event");
    this.k4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK5ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignK5ToGovSteamIEEE1Event");
    this.k5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK5FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignK5FromGovSteamIEEE1Event");
    this.k5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK6ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignK6ToGovSteamIEEE1Event");
    this.k6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK6FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignK6FromGovSteamIEEE1Event");
    this.k6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK7ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignK7ToGovSteamIEEE1Event");
    this.k7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK7FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignK7FromGovSteamIEEE1Event");
    this.k7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK8ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignK8ToGovSteamIEEE1Event");
    this.k8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK8FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignK8FromGovSteamIEEE1Event");
    this.k8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovSteamIEEE1Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovSteamIEEE1Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignPmaxToGovSteamIEEE1Event");
    this.pmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxFromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignPmaxFromGovSteamIEEE1Event");
    this.pmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignPminToGovSteamIEEE1Event");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignPminFromGovSteamIEEE1Event");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignT1ToGovSteamIEEE1Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromGovSteamIEEE1Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignT2ToGovSteamIEEE1Event");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignT2FromGovSteamIEEE1Event");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignT3ToGovSteamIEEE1Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromGovSteamIEEE1Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignT4ToGovSteamIEEE1Event");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignT4FromGovSteamIEEE1Event");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignT5ToGovSteamIEEE1Event");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignT5FromGovSteamIEEE1Event");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignT6ToGovSteamIEEE1Event");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignT6FromGovSteamIEEE1Event");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT7ToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignT7ToGovSteamIEEE1Event");
    this.t7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT7FromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignT7FromGovSteamIEEE1Event");
    this.t7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUcToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignUcToGovSteamIEEE1Event");
    this.uc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUcFromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignUcFromGovSteamIEEE1Event");
    this.uc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUoToGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing AssignUoToGovSteamIEEE1Event");
    this.uo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUoFromGovSteamIEEE1Event event) {
    LOGGER.info("Event sourcing UnAssignUoFromGovSteamIEEE1Event");
    this.uo = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govSteamIEEE1Id;

  private PU k = null;
  private Simple_Float k1 = null;
  private Simple_Float k2 = null;
  private Simple_Float k3 = null;
  private Simple_Float k4 = null;
  private Simple_Float k5 = null;
  private Simple_Float k6 = null;
  private Simple_Float k7 = null;
  private Simple_Float k8 = null;
  private ActivePower mwbase = null;
  private PU pmax = null;
  private PU pmin = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Seconds t6 = null;
  private Seconds t7 = null;
  private Simple_Float uc = null;
  private Simple_Float uo = null;

  private static final Logger LOGGER = Logger.getLogger(GovSteamIEEE1Aggregate.class.getName());
}
