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
 * Aggregate handler for GovHydroWPID as outlined for the CQRS pattern, all write responsibilities
 * related to GovHydroWPID are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovHydroWPIDAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovHydroWPIDAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovHydroWPIDAggregate(CreateGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command CreateGovHydroWPIDCommand");
    CreateGovHydroWPIDEvent event = new CreateGovHydroWPIDEvent(command.getGovHydroWPIDId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("handling command UpdateGovHydroWPIDCommand");
    UpdateGovHydroWPIDEvent event =
        new UpdateGovHydroWPIDEvent(
            command.getGovHydroWPIDId(),
            command.getD(),
            command.getGatmax(),
            command.getGatmin(),
            command.getGv1(),
            command.getGv2(),
            command.getGv3(),
            command.getKd(),
            command.getKi(),
            command.getKp(),
            command.getMwbase(),
            command.getPgv1(),
            command.getPgv2(),
            command.getPgv3(),
            command.getPmax(),
            command.getPmin(),
            command.getReg(),
            command.getTa(),
            command.getTb(),
            command.getTreg(),
            command.getTw(),
            command.getVelmax(),
            command.getVelmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGovHydroWPIDCommand");
    apply(new DeleteGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignDToGovHydroWPIDCommand");

    if (d != null && d.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "D already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDFromGovHydroWPIDCommand");

    if (d == null) throw new ProcessingException("D already has nothing assigned.");

    apply(new UnAssignDFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignGatmaxToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGatmaxToGovHydroWPIDCommand");

    if (gatmax != null && gatmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gatmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignGatmaxToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGatmaxFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGatmaxFromGovHydroWPIDCommand");

    if (gatmax == null) throw new ProcessingException("Gatmax already has nothing assigned.");

    apply(new UnAssignGatmaxFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignGatminToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGatminToGovHydroWPIDCommand");

    if (gatmin != null && gatmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gatmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignGatminToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGatminFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGatminFromGovHydroWPIDCommand");

    if (gatmin == null) throw new ProcessingException("Gatmin already has nothing assigned.");

    apply(new UnAssignGatminFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignGv1ToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv1ToGovHydroWPIDCommand");

    if (gv1 != null && gv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv1ToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv1FromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv1FromGovHydroWPIDCommand");

    if (gv1 == null) throw new ProcessingException("Gv1 already has nothing assigned.");

    apply(new UnAssignGv1FromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignGv2ToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv2ToGovHydroWPIDCommand");

    if (gv2 != null && gv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv2ToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv2FromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv2FromGovHydroWPIDCommand");

    if (gv2 == null) throw new ProcessingException("Gv2 already has nothing assigned.");

    apply(new UnAssignGv2FromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignGv3ToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv3ToGovHydroWPIDCommand");

    if (gv3 != null && gv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv3ToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv3FromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv3FromGovHydroWPIDCommand");

    if (gv3 == null) throw new ProcessingException("Gv3 already has nothing assigned.");

    apply(new UnAssignGv3FromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignKdToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToGovHydroWPIDCommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromGovHydroWPIDCommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignKiToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToGovHydroWPIDCommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromGovHydroWPIDCommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignKpToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToGovHydroWPIDCommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromGovHydroWPIDCommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovHydroWPIDCommand");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignMwbaseToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovHydroWPIDCommand");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignPgv1ToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv1ToGovHydroWPIDCommand");

    if (pgv1 != null && pgv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv1ToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv1FromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv1FromGovHydroWPIDCommand");

    if (pgv1 == null) throw new ProcessingException("Pgv1 already has nothing assigned.");

    apply(new UnAssignPgv1FromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignPgv2ToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv2ToGovHydroWPIDCommand");

    if (pgv2 != null && pgv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv2ToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv2FromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv2FromGovHydroWPIDCommand");

    if (pgv2 == null) throw new ProcessingException("Pgv2 already has nothing assigned.");

    apply(new UnAssignPgv2FromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignPgv3ToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv3ToGovHydroWPIDCommand");

    if (pgv3 != null && pgv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv3ToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv3FromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv3FromGovHydroWPIDCommand");

    if (pgv3 == null) throw new ProcessingException("Pgv3 already has nothing assigned.");

    apply(new UnAssignPgv3FromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignPmaxToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmaxToGovHydroWPIDCommand");

    if (pmax != null && pmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmaxToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxFromGovHydroWPIDCommand");

    if (pmax == null) throw new ProcessingException("Pmax already has nothing assigned.");

    apply(new UnAssignPmaxFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignPminToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPminToGovHydroWPIDCommand");

    if (pmin != null && pmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPminToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromGovHydroWPIDCommand");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignRegToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignRegToGovHydroWPIDCommand");

    if (reg != null && reg.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Reg already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRegToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRegFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRegFromGovHydroWPIDCommand");

    if (reg == null) throw new ProcessingException("Reg already has nothing assigned.");

    apply(new UnAssignRegFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignTaToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToGovHydroWPIDCommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromGovHydroWPIDCommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignTbToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToGovHydroWPIDCommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromGovHydroWPIDCommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignTregToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTregToGovHydroWPIDCommand");

    if (treg != null && treg.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Treg already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTregToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTregFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTregFromGovHydroWPIDCommand");

    if (treg == null) throw new ProcessingException("Treg already has nothing assigned.");

    apply(new UnAssignTregFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignTwToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwToGovHydroWPIDCommand");

    if (tw != null && tw.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTwToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwFromGovHydroWPIDCommand");

    if (tw == null) throw new ProcessingException("Tw already has nothing assigned.");

    apply(new UnAssignTwFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignVelmaxToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignVelmaxToGovHydroWPIDCommand");

    if (velmax != null && velmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Velmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVelmaxToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVelmaxFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVelmaxFromGovHydroWPIDCommand");

    if (velmax == null) throw new ProcessingException("Velmax already has nothing assigned.");

    apply(new UnAssignVelmaxFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  @CommandHandler
  public void handle(AssignVelminToGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignVelminToGovHydroWPIDCommand");

    if (velmin != null && velmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Velmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVelminToGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVelminFromGovHydroWPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVelminFromGovHydroWPIDCommand");

    if (velmin == null) throw new ProcessingException("Velmin already has nothing assigned.");

    apply(new UnAssignVelminFromGovHydroWPIDEvent(command.getGovHydroWPIDId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing CreateGovHydroWPIDEvent");
    this.govHydroWPIDId = event.getGovHydroWPIDId();
  }

  @EventSourcingHandler
  void on(UpdateGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.d = event.getD();
    this.gatmax = event.getGatmax();
    this.gatmin = event.getGatmin();
    this.gv1 = event.getGv1();
    this.gv2 = event.getGv2();
    this.gv3 = event.getGv3();
    this.kd = event.getKd();
    this.ki = event.getKi();
    this.kp = event.getKp();
    this.mwbase = event.getMwbase();
    this.pgv1 = event.getPgv1();
    this.pgv2 = event.getPgv2();
    this.pgv3 = event.getPgv3();
    this.pmax = event.getPmax();
    this.pmin = event.getPmin();
    this.reg = event.getReg();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.treg = event.getTreg();
    this.tw = event.getTw();
    this.velmax = event.getVelmax();
    this.velmin = event.getVelmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignDToGovHydroWPIDEvent");
    this.d = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignDFromGovHydroWPIDEvent");
    this.d = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGatmaxToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignGatmaxToGovHydroWPIDEvent");
    this.gatmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGatmaxFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignGatmaxFromGovHydroWPIDEvent");
    this.gatmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGatminToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignGatminToGovHydroWPIDEvent");
    this.gatmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGatminFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignGatminFromGovHydroWPIDEvent");
    this.gatmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv1ToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignGv1ToGovHydroWPIDEvent");
    this.gv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv1FromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv1FromGovHydroWPIDEvent");
    this.gv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv2ToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignGv2ToGovHydroWPIDEvent");
    this.gv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv2FromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv2FromGovHydroWPIDEvent");
    this.gv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv3ToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignGv3ToGovHydroWPIDEvent");
    this.gv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv3FromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv3FromGovHydroWPIDEvent");
    this.gv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignKdToGovHydroWPIDEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromGovHydroWPIDEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignKiToGovHydroWPIDEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromGovHydroWPIDEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignKpToGovHydroWPIDEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromGovHydroWPIDEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovHydroWPIDEvent");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovHydroWPIDEvent");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv1ToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignPgv1ToGovHydroWPIDEvent");
    this.pgv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv1FromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv1FromGovHydroWPIDEvent");
    this.pgv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv2ToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignPgv2ToGovHydroWPIDEvent");
    this.pgv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv2FromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv2FromGovHydroWPIDEvent");
    this.pgv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv3ToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignPgv3ToGovHydroWPIDEvent");
    this.pgv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv3FromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv3FromGovHydroWPIDEvent");
    this.pgv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignPmaxToGovHydroWPIDEvent");
    this.pmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignPmaxFromGovHydroWPIDEvent");
    this.pmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignPminToGovHydroWPIDEvent");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignPminFromGovHydroWPIDEvent");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRegToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignRegToGovHydroWPIDEvent");
    this.reg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRegFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignRegFromGovHydroWPIDEvent");
    this.reg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignTaToGovHydroWPIDEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromGovHydroWPIDEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignTbToGovHydroWPIDEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromGovHydroWPIDEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTregToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignTregToGovHydroWPIDEvent");
    this.treg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTregFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignTregFromGovHydroWPIDEvent");
    this.treg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignTwToGovHydroWPIDEvent");
    this.tw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignTwFromGovHydroWPIDEvent");
    this.tw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVelmaxToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignVelmaxToGovHydroWPIDEvent");
    this.velmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVelmaxFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignVelmaxFromGovHydroWPIDEvent");
    this.velmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVelminToGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing AssignVelminToGovHydroWPIDEvent");
    this.velmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVelminFromGovHydroWPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignVelminFromGovHydroWPIDEvent");
    this.velmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govHydroWPIDId;

  private PU d = null;
  private PU gatmax = null;
  private PU gatmin = null;
  private PU gv1 = null;
  private PU gv2 = null;
  private PU gv3 = null;
  private PU kd = null;
  private PU ki = null;
  private PU kp = null;
  private ActivePower mwbase = null;
  private PU pgv1 = null;
  private PU pgv2 = null;
  private PU pgv3 = null;
  private PU pmax = null;
  private PU pmin = null;
  private PU reg = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds treg = null;
  private Seconds tw = null;
  private PU velmax = null;
  private PU velmin = null;

  private static final Logger LOGGER = Logger.getLogger(GovHydroWPIDAggregate.class.getName());
}
