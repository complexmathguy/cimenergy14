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
 * Aggregate handler for GovHydroPID2 as outlined for the CQRS pattern, all write responsibilities
 * related to GovHydroPID2 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovHydroPID2Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovHydroPID2Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovHydroPID2Aggregate(CreateGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command CreateGovHydroPID2Command");
    CreateGovHydroPID2Event event = new CreateGovHydroPID2Event(command.getGovHydroPID2Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovHydroPID2Command command) throws Exception {
    LOGGER.info("handling command UpdateGovHydroPID2Command");
    UpdateGovHydroPID2Event event =
        new UpdateGovHydroPID2Event(
            command.getGovHydroPID2Id(),
            command.getAtw(),
            command.getD(),
            command.getFeedbackSignal(),
            command.getG0(),
            command.getG1(),
            command.getG2(),
            command.getGmax(),
            command.getGmin(),
            command.getKd(),
            command.getKi(),
            command.getKp(),
            command.getMwbase(),
            command.getP1(),
            command.getP2(),
            command.getP3(),
            command.getRperm(),
            command.getTa(),
            command.getTb(),
            command.getTreg(),
            command.getTw(),
            command.getVelmax(),
            command.getVelmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovHydroPID2Command");
    apply(new DeleteGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAtwToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignAtwToGovHydroPID2Command");

    if (atw != null && atw.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Atw already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAtwToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAtwFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAtwFromGovHydroPID2Command");

    if (atw == null) throw new ProcessingException("Atw already has nothing assigned.");

    apply(new UnAssignAtwFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignDToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignDToGovHydroPID2Command");

    if (d != null && d.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "D already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDFromGovHydroPID2Command");

    if (d == null) throw new ProcessingException("D already has nothing assigned.");

    apply(new UnAssignDFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignFeedbackSignalToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignFeedbackSignalToGovHydroPID2Command");

    if (feedbackSignal != null
        && feedbackSignal.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "FeedbackSignal already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignFeedbackSignalToGovHydroPID2Event(
            command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFeedbackSignalFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFeedbackSignalFromGovHydroPID2Command");

    if (feedbackSignal == null)
      throw new ProcessingException("FeedbackSignal already has nothing assigned.");

    apply(new UnAssignFeedbackSignalFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignG0ToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignG0ToGovHydroPID2Command");

    if (g0 != null && g0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "G0 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignG0ToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignG0FromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignG0FromGovHydroPID2Command");

    if (g0 == null) throw new ProcessingException("G0 already has nothing assigned.");

    apply(new UnAssignG0FromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignG1ToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignG1ToGovHydroPID2Command");

    if (g1 != null && g1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "G1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignG1ToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignG1FromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignG1FromGovHydroPID2Command");

    if (g1 == null) throw new ProcessingException("G1 already has nothing assigned.");

    apply(new UnAssignG1FromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignG2ToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignG2ToGovHydroPID2Command");

    if (g2 != null && g2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "G2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignG2ToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignG2FromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignG2FromGovHydroPID2Command");

    if (g2 == null) throw new ProcessingException("G2 already has nothing assigned.");

    apply(new UnAssignG2FromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignGmaxToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignGmaxToGovHydroPID2Command");

    if (gmax != null && gmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGmaxToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGmaxFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGmaxFromGovHydroPID2Command");

    if (gmax == null) throw new ProcessingException("Gmax already has nothing assigned.");

    apply(new UnAssignGmaxFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignGminToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignGminToGovHydroPID2Command");

    if (gmin != null && gmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGminToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGminFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGminFromGovHydroPID2Command");

    if (gmin == null) throw new ProcessingException("Gmin already has nothing assigned.");

    apply(new UnAssignGminFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignKdToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignKdToGovHydroPID2Command");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromGovHydroPID2Command");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignKiToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignKiToGovHydroPID2Command");

    if (ki != null && ki.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKiToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromGovHydroPID2Command");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignKpToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignKpToGovHydroPID2Command");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromGovHydroPID2Command");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovHydroPID2Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignMwbaseToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovHydroPID2Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignP1ToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignP1ToGovHydroPID2Command");

    if (p1 != null && p1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignP1ToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP1FromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignP1FromGovHydroPID2Command");

    if (p1 == null) throw new ProcessingException("P1 already has nothing assigned.");

    apply(new UnAssignP1FromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignP2ToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignP2ToGovHydroPID2Command");

    if (p2 != null && p2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignP2ToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP2FromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignP2FromGovHydroPID2Command");

    if (p2 == null) throw new ProcessingException("P2 already has nothing assigned.");

    apply(new UnAssignP2FromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignP3ToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignP3ToGovHydroPID2Command");

    if (p3 != null && p3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignP3ToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP3FromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignP3FromGovHydroPID2Command");

    if (p3 == null) throw new ProcessingException("P3 already has nothing assigned.");

    apply(new UnAssignP3FromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignRpermToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignRpermToGovHydroPID2Command");

    if (rperm != null && rperm.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rperm already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRpermToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRpermFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRpermFromGovHydroPID2Command");

    if (rperm == null) throw new ProcessingException("Rperm already has nothing assigned.");

    apply(new UnAssignRpermFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignTaToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignTaToGovHydroPID2Command");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromGovHydroPID2Command");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignTbToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignTbToGovHydroPID2Command");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromGovHydroPID2Command");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignTregToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignTregToGovHydroPID2Command");

    if (treg != null && treg.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Treg already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTregToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTregFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTregFromGovHydroPID2Command");

    if (treg == null) throw new ProcessingException("Treg already has nothing assigned.");

    apply(new UnAssignTregFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignTwToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignTwToGovHydroPID2Command");

    if (tw != null && tw.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTwToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwFromGovHydroPID2Command");

    if (tw == null) throw new ProcessingException("Tw already has nothing assigned.");

    apply(new UnAssignTwFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignVelmaxToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignVelmaxToGovHydroPID2Command");

    if (velmax != null && velmax.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Velmax already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignVelmaxToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVelmaxFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVelmaxFromGovHydroPID2Command");

    if (velmax == null) throw new ProcessingException("Velmax already has nothing assigned.");

    apply(new UnAssignVelmaxFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  @CommandHandler
  public void handle(AssignVelminToGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handling command AssignVelminToGovHydroPID2Command");

    if (velmin != null && velmin.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Velmin already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignVelminToGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVelminFromGovHydroPID2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVelminFromGovHydroPID2Command");

    if (velmin == null) throw new ProcessingException("Velmin already has nothing assigned.");

    apply(new UnAssignVelminFromGovHydroPID2Event(command.getGovHydroPID2Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovHydroPID2Event event) {
    LOGGER.info("Event sourcing CreateGovHydroPID2Event");
    this.govHydroPID2Id = event.getGovHydroPID2Id();
  }

  @EventSourcingHandler
  void on(UpdateGovHydroPID2Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.atw = event.getAtw();
    this.d = event.getD();
    this.feedbackSignal = event.getFeedbackSignal();
    this.g0 = event.getG0();
    this.g1 = event.getG1();
    this.g2 = event.getG2();
    this.gmax = event.getGmax();
    this.gmin = event.getGmin();
    this.kd = event.getKd();
    this.ki = event.getKi();
    this.kp = event.getKp();
    this.mwbase = event.getMwbase();
    this.p1 = event.getP1();
    this.p2 = event.getP2();
    this.p3 = event.getP3();
    this.rperm = event.getRperm();
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
  void on(AssignAtwToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignAtwToGovHydroPID2Event");
    this.atw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAtwFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignAtwFromGovHydroPID2Event");
    this.atw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignDToGovHydroPID2Event");
    this.d = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignDFromGovHydroPID2Event");
    this.d = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFeedbackSignalToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignFeedbackSignalToGovHydroPID2Event");
    this.feedbackSignal = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFeedbackSignalFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignFeedbackSignalFromGovHydroPID2Event");
    this.feedbackSignal = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignG0ToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignG0ToGovHydroPID2Event");
    this.g0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignG0FromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignG0FromGovHydroPID2Event");
    this.g0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignG1ToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignG1ToGovHydroPID2Event");
    this.g1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignG1FromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignG1FromGovHydroPID2Event");
    this.g1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignG2ToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignG2ToGovHydroPID2Event");
    this.g2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignG2FromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignG2FromGovHydroPID2Event");
    this.g2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGmaxToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignGmaxToGovHydroPID2Event");
    this.gmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGmaxFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignGmaxFromGovHydroPID2Event");
    this.gmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGminToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignGminToGovHydroPID2Event");
    this.gmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGminFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignGminFromGovHydroPID2Event");
    this.gmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignKdToGovHydroPID2Event");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignKdFromGovHydroPID2Event");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignKiToGovHydroPID2Event");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignKiFromGovHydroPID2Event");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignKpToGovHydroPID2Event");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignKpFromGovHydroPID2Event");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovHydroPID2Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovHydroPID2Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP1ToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignP1ToGovHydroPID2Event");
    this.p1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP1FromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignP1FromGovHydroPID2Event");
    this.p1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP2ToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignP2ToGovHydroPID2Event");
    this.p2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP2FromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignP2FromGovHydroPID2Event");
    this.p2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP3ToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignP3ToGovHydroPID2Event");
    this.p3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP3FromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignP3FromGovHydroPID2Event");
    this.p3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRpermToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignRpermToGovHydroPID2Event");
    this.rperm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRpermFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignRpermFromGovHydroPID2Event");
    this.rperm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignTaToGovHydroPID2Event");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignTaFromGovHydroPID2Event");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignTbToGovHydroPID2Event");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignTbFromGovHydroPID2Event");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTregToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignTregToGovHydroPID2Event");
    this.treg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTregFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignTregFromGovHydroPID2Event");
    this.treg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignTwToGovHydroPID2Event");
    this.tw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignTwFromGovHydroPID2Event");
    this.tw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVelmaxToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignVelmaxToGovHydroPID2Event");
    this.velmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVelmaxFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignVelmaxFromGovHydroPID2Event");
    this.velmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVelminToGovHydroPID2Event event) {
    LOGGER.info("Event sourcing AssignVelminToGovHydroPID2Event");
    this.velmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVelminFromGovHydroPID2Event event) {
    LOGGER.info("Event sourcing UnAssignVelminFromGovHydroPID2Event");
    this.velmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govHydroPID2Id;

  private PU atw = null;
  private PU d = null;
  private BooleanProxy feedbackSignal = null;
  private PU g0 = null;
  private PU g1 = null;
  private PU g2 = null;
  private PU gmax = null;
  private PU gmin = null;
  private PU kd = null;
  private Simple_Float ki = null;
  private PU kp = null;
  private ActivePower mwbase = null;
  private PU p1 = null;
  private PU p2 = null;
  private PU p3 = null;
  private PU rperm = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds treg = null;
  private Seconds tw = null;
  private Simple_Float velmax = null;
  private Simple_Float velmin = null;

  private static final Logger LOGGER = Logger.getLogger(GovHydroPID2Aggregate.class.getName());
}
