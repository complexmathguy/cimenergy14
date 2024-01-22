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
 * Aggregate handler for GovSteamFV3 as outlined for the CQRS pattern, all write responsibilities
 * related to GovSteamFV3 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovSteamFV3Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovSteamFV3Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovSteamFV3Aggregate(CreateGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command CreateGovSteamFV3Command");
    CreateGovSteamFV3Event event = new CreateGovSteamFV3Event(command.getGovSteamFV3Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovSteamFV3Command command) throws Exception {
    LOGGER.info("handling command UpdateGovSteamFV3Command");
    UpdateGovSteamFV3Event event =
        new UpdateGovSteamFV3Event(
            command.getGovSteamFV3Id(),
            command.getK(),
            command.getK1(),
            command.getK2(),
            command.getK3(),
            command.getMwbase(),
            command.getPmax(),
            command.getPmin(),
            command.getPrmax(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getT6(),
            command.getTa(),
            command.getTb(),
            command.getTc(),
            command.getUc(),
            command.getUo());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovSteamFV3Command");
    apply(new DeleteGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignKToGovSteamFV3Command");

    if (k != null && k.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKFromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKFromGovSteamFV3Command");

    if (k == null) throw new ProcessingException("K already has nothing assigned.");

    apply(new UnAssignKFromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignK1ToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignK1ToGovSteamFV3Command");

    if (k1 != null && k1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK1ToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromGovSteamFV3Command");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignK2ToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignK2ToGovSteamFV3Command");

    if (k2 != null && k2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK2ToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK2FromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK2FromGovSteamFV3Command");

    if (k2 == null) throw new ProcessingException("K2 already has nothing assigned.");

    apply(new UnAssignK2FromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignK3ToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignK3ToGovSteamFV3Command");

    if (k3 != null && k3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK3ToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK3FromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK3FromGovSteamFV3Command");

    if (k3 == null) throw new ProcessingException("K3 already has nothing assigned.");

    apply(new UnAssignK3FromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovSteamFV3Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovSteamFV3Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignPmaxToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignPmaxToGovSteamFV3Command");

    if (pmax != null && pmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmaxToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxFromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxFromGovSteamFV3Command");

    if (pmax == null) throw new ProcessingException("Pmax already has nothing assigned.");

    apply(new UnAssignPmaxFromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignPminToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignPminToGovSteamFV3Command");

    if (pmin != null && pmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPminToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromGovSteamFV3Command");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignPrmaxToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignPrmaxToGovSteamFV3Command");

    if (prmax != null && prmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Prmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPrmaxToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPrmaxFromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPrmaxFromGovSteamFV3Command");

    if (prmax == null) throw new ProcessingException("Prmax already has nothing assigned.");

    apply(new UnAssignPrmaxFromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToGovSteamFV3Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromGovSteamFV3Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignT2ToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignT2ToGovSteamFV3Command");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromGovSteamFV3Command");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToGovSteamFV3Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromGovSteamFV3Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignT4ToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignT4ToGovSteamFV3Command");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromGovSteamFV3Command");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignT5ToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignT5ToGovSteamFV3Command");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromGovSteamFV3Command");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignT6ToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignT6ToGovSteamFV3Command");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromGovSteamFV3Command");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignTaToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignTaToGovSteamFV3Command");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromGovSteamFV3Command");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignTbToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignTbToGovSteamFV3Command");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromGovSteamFV3Command");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignTcToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignTcToGovSteamFV3Command");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromGovSteamFV3Command");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignUcToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignUcToGovSteamFV3Command");

    if (uc != null && uc.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Uc already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignUcToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUcFromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignUcFromGovSteamFV3Command");

    if (uc == null) throw new ProcessingException("Uc already has nothing assigned.");

    apply(new UnAssignUcFromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  @CommandHandler
  public void handle(AssignUoToGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handling command AssignUoToGovSteamFV3Command");

    if (uo != null && uo.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Uo already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignUoToGovSteamFV3Event(command.getGovSteamFV3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUoFromGovSteamFV3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignUoFromGovSteamFV3Command");

    if (uo == null) throw new ProcessingException("Uo already has nothing assigned.");

    apply(new UnAssignUoFromGovSteamFV3Event(command.getGovSteamFV3Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovSteamFV3Event event) {
    LOGGER.info("Event sourcing CreateGovSteamFV3Event");
    this.govSteamFV3Id = event.getGovSteamFV3Id();
  }

  @EventSourcingHandler
  void on(UpdateGovSteamFV3Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.k = event.getK();
    this.k1 = event.getK1();
    this.k2 = event.getK2();
    this.k3 = event.getK3();
    this.mwbase = event.getMwbase();
    this.pmax = event.getPmax();
    this.pmin = event.getPmin();
    this.prmax = event.getPrmax();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.t6 = event.getT6();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.tc = event.getTc();
    this.uc = event.getUc();
    this.uo = event.getUo();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignKToGovSteamFV3Event");
    this.k = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKFromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignKFromGovSteamFV3Event");
    this.k = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignK1ToGovSteamFV3Event");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignK1FromGovSteamFV3Event");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK2ToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignK2ToGovSteamFV3Event");
    this.k2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK2FromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignK2FromGovSteamFV3Event");
    this.k2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK3ToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignK3ToGovSteamFV3Event");
    this.k3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK3FromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignK3FromGovSteamFV3Event");
    this.k3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovSteamFV3Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovSteamFV3Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignPmaxToGovSteamFV3Event");
    this.pmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxFromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignPmaxFromGovSteamFV3Event");
    this.pmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignPminToGovSteamFV3Event");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignPminFromGovSteamFV3Event");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPrmaxToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignPrmaxToGovSteamFV3Event");
    this.prmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPrmaxFromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignPrmaxFromGovSteamFV3Event");
    this.prmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignT1ToGovSteamFV3Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromGovSteamFV3Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignT2ToGovSteamFV3Event");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignT2FromGovSteamFV3Event");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignT3ToGovSteamFV3Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromGovSteamFV3Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignT4ToGovSteamFV3Event");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignT4FromGovSteamFV3Event");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignT5ToGovSteamFV3Event");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignT5FromGovSteamFV3Event");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignT6ToGovSteamFV3Event");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignT6FromGovSteamFV3Event");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignTaToGovSteamFV3Event");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignTaFromGovSteamFV3Event");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignTbToGovSteamFV3Event");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignTbFromGovSteamFV3Event");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignTcToGovSteamFV3Event");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignTcFromGovSteamFV3Event");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUcToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignUcToGovSteamFV3Event");
    this.uc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUcFromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignUcFromGovSteamFV3Event");
    this.uc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUoToGovSteamFV3Event event) {
    LOGGER.info("Event sourcing AssignUoToGovSteamFV3Event");
    this.uo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUoFromGovSteamFV3Event event) {
    LOGGER.info("Event sourcing UnAssignUoFromGovSteamFV3Event");
    this.uo = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govSteamFV3Id;

  private PU k = null;
  private PU k1 = null;
  private PU k2 = null;
  private PU k3 = null;
  private ActivePower mwbase = null;
  private PU pmax = null;
  private PU pmin = null;
  private PU prmax = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Seconds t6 = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private Simple_Float uc = null;
  private Simple_Float uo = null;

  private static final Logger LOGGER = Logger.getLogger(GovSteamFV3Aggregate.class.getName());
}
