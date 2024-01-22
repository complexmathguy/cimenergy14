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
 * Aggregate handler for GovHydro1 as outlined for the CQRS pattern, all write responsibilities
 * related to GovHydro1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovHydro1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovHydro1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovHydro1Aggregate(CreateGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command CreateGovHydro1Command");
    CreateGovHydro1Event event = new CreateGovHydro1Event(command.getGovHydro1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovHydro1Command command) throws Exception {
    LOGGER.info("handling command UpdateGovHydro1Command");
    UpdateGovHydro1Event event =
        new UpdateGovHydro1Event(
            command.getGovHydro1Id(),
            command.getAt(),
            command.getDturb(),
            command.getGmax(),
            command.getGmin(),
            command.getHdam(),
            command.getMwbase(),
            command.getQnl(),
            command.getRperm(),
            command.getRtemp(),
            command.getTf(),
            command.getTg(),
            command.getTr(),
            command.getTw(),
            command.getVelm());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovHydro1Command");
    apply(new DeleteGovHydro1Event(command.getGovHydro1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAtToGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command AssignAtToGovHydro1Command");

    if (at != null && at.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "At already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAtToGovHydro1Event(command.getGovHydro1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAtFromGovHydro1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAtFromGovHydro1Command");

    if (at == null) throw new ProcessingException("At already has nothing assigned.");

    apply(new UnAssignAtFromGovHydro1Event(command.getGovHydro1Id()));
  }

  @CommandHandler
  public void handle(AssignDturbToGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command AssignDturbToGovHydro1Command");

    if (dturb != null && dturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDturbToGovHydro1Event(command.getGovHydro1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDturbFromGovHydro1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDturbFromGovHydro1Command");

    if (dturb == null) throw new ProcessingException("Dturb already has nothing assigned.");

    apply(new UnAssignDturbFromGovHydro1Event(command.getGovHydro1Id()));
  }

  @CommandHandler
  public void handle(AssignGmaxToGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command AssignGmaxToGovHydro1Command");

    if (gmax != null && gmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGmaxToGovHydro1Event(command.getGovHydro1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGmaxFromGovHydro1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGmaxFromGovHydro1Command");

    if (gmax == null) throw new ProcessingException("Gmax already has nothing assigned.");

    apply(new UnAssignGmaxFromGovHydro1Event(command.getGovHydro1Id()));
  }

  @CommandHandler
  public void handle(AssignGminToGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command AssignGminToGovHydro1Command");

    if (gmin != null && gmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGminToGovHydro1Event(command.getGovHydro1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGminFromGovHydro1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGminFromGovHydro1Command");

    if (gmin == null) throw new ProcessingException("Gmin already has nothing assigned.");

    apply(new UnAssignGminFromGovHydro1Event(command.getGovHydro1Id()));
  }

  @CommandHandler
  public void handle(AssignHdamToGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command AssignHdamToGovHydro1Command");

    if (hdam != null && hdam.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Hdam already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignHdamToGovHydro1Event(command.getGovHydro1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHdamFromGovHydro1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignHdamFromGovHydro1Command");

    if (hdam == null) throw new ProcessingException("Hdam already has nothing assigned.");

    apply(new UnAssignHdamFromGovHydro1Event(command.getGovHydro1Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovHydro1Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovHydro1Event(command.getGovHydro1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovHydro1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovHydro1Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovHydro1Event(command.getGovHydro1Id()));
  }

  @CommandHandler
  public void handle(AssignQnlToGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command AssignQnlToGovHydro1Command");

    if (qnl != null && qnl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Qnl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignQnlToGovHydro1Event(command.getGovHydro1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQnlFromGovHydro1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQnlFromGovHydro1Command");

    if (qnl == null) throw new ProcessingException("Qnl already has nothing assigned.");

    apply(new UnAssignQnlFromGovHydro1Event(command.getGovHydro1Id()));
  }

  @CommandHandler
  public void handle(AssignRpermToGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command AssignRpermToGovHydro1Command");

    if (rperm != null && rperm.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rperm already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRpermToGovHydro1Event(command.getGovHydro1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRpermFromGovHydro1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRpermFromGovHydro1Command");

    if (rperm == null) throw new ProcessingException("Rperm already has nothing assigned.");

    apply(new UnAssignRpermFromGovHydro1Event(command.getGovHydro1Id()));
  }

  @CommandHandler
  public void handle(AssignRtempToGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command AssignRtempToGovHydro1Command");

    if (rtemp != null && rtemp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rtemp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRtempToGovHydro1Event(command.getGovHydro1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRtempFromGovHydro1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRtempFromGovHydro1Command");

    if (rtemp == null) throw new ProcessingException("Rtemp already has nothing assigned.");

    apply(new UnAssignRtempFromGovHydro1Event(command.getGovHydro1Id()));
  }

  @CommandHandler
  public void handle(AssignTfToGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command AssignTfToGovHydro1Command");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToGovHydro1Event(command.getGovHydro1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromGovHydro1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromGovHydro1Command");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromGovHydro1Event(command.getGovHydro1Id()));
  }

  @CommandHandler
  public void handle(AssignTgToGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command AssignTgToGovHydro1Command");

    if (tg != null && tg.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tg already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTgToGovHydro1Event(command.getGovHydro1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTgFromGovHydro1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTgFromGovHydro1Command");

    if (tg == null) throw new ProcessingException("Tg already has nothing assigned.");

    apply(new UnAssignTgFromGovHydro1Event(command.getGovHydro1Id()));
  }

  @CommandHandler
  public void handle(AssignTrToGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command AssignTrToGovHydro1Command");

    if (tr != null && tr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tr already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTrToGovHydro1Event(command.getGovHydro1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrFromGovHydro1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrFromGovHydro1Command");

    if (tr == null) throw new ProcessingException("Tr already has nothing assigned.");

    apply(new UnAssignTrFromGovHydro1Event(command.getGovHydro1Id()));
  }

  @CommandHandler
  public void handle(AssignTwToGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command AssignTwToGovHydro1Command");

    if (tw != null && tw.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTwToGovHydro1Event(command.getGovHydro1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwFromGovHydro1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwFromGovHydro1Command");

    if (tw == null) throw new ProcessingException("Tw already has nothing assigned.");

    apply(new UnAssignTwFromGovHydro1Event(command.getGovHydro1Id()));
  }

  @CommandHandler
  public void handle(AssignVelmToGovHydro1Command command) throws Exception {
    LOGGER.info("Handling command AssignVelmToGovHydro1Command");

    if (velm != null && velm.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Velm already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignVelmToGovHydro1Event(command.getGovHydro1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVelmFromGovHydro1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVelmFromGovHydro1Command");

    if (velm == null) throw new ProcessingException("Velm already has nothing assigned.");

    apply(new UnAssignVelmFromGovHydro1Event(command.getGovHydro1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovHydro1Event event) {
    LOGGER.info("Event sourcing CreateGovHydro1Event");
    this.govHydro1Id = event.getGovHydro1Id();
  }

  @EventSourcingHandler
  void on(UpdateGovHydro1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.at = event.getAt();
    this.dturb = event.getDturb();
    this.gmax = event.getGmax();
    this.gmin = event.getGmin();
    this.hdam = event.getHdam();
    this.mwbase = event.getMwbase();
    this.qnl = event.getQnl();
    this.rperm = event.getRperm();
    this.rtemp = event.getRtemp();
    this.tf = event.getTf();
    this.tg = event.getTg();
    this.tr = event.getTr();
    this.tw = event.getTw();
    this.velm = event.getVelm();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAtToGovHydro1Event event) {
    LOGGER.info("Event sourcing AssignAtToGovHydro1Event");
    this.at = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAtFromGovHydro1Event event) {
    LOGGER.info("Event sourcing UnAssignAtFromGovHydro1Event");
    this.at = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDturbToGovHydro1Event event) {
    LOGGER.info("Event sourcing AssignDturbToGovHydro1Event");
    this.dturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDturbFromGovHydro1Event event) {
    LOGGER.info("Event sourcing UnAssignDturbFromGovHydro1Event");
    this.dturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGmaxToGovHydro1Event event) {
    LOGGER.info("Event sourcing AssignGmaxToGovHydro1Event");
    this.gmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGmaxFromGovHydro1Event event) {
    LOGGER.info("Event sourcing UnAssignGmaxFromGovHydro1Event");
    this.gmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGminToGovHydro1Event event) {
    LOGGER.info("Event sourcing AssignGminToGovHydro1Event");
    this.gmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGminFromGovHydro1Event event) {
    LOGGER.info("Event sourcing UnAssignGminFromGovHydro1Event");
    this.gmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignHdamToGovHydro1Event event) {
    LOGGER.info("Event sourcing AssignHdamToGovHydro1Event");
    this.hdam = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHdamFromGovHydro1Event event) {
    LOGGER.info("Event sourcing UnAssignHdamFromGovHydro1Event");
    this.hdam = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovHydro1Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovHydro1Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovHydro1Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovHydro1Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQnlToGovHydro1Event event) {
    LOGGER.info("Event sourcing AssignQnlToGovHydro1Event");
    this.qnl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQnlFromGovHydro1Event event) {
    LOGGER.info("Event sourcing UnAssignQnlFromGovHydro1Event");
    this.qnl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRpermToGovHydro1Event event) {
    LOGGER.info("Event sourcing AssignRpermToGovHydro1Event");
    this.rperm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRpermFromGovHydro1Event event) {
    LOGGER.info("Event sourcing UnAssignRpermFromGovHydro1Event");
    this.rperm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRtempToGovHydro1Event event) {
    LOGGER.info("Event sourcing AssignRtempToGovHydro1Event");
    this.rtemp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRtempFromGovHydro1Event event) {
    LOGGER.info("Event sourcing UnAssignRtempFromGovHydro1Event");
    this.rtemp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToGovHydro1Event event) {
    LOGGER.info("Event sourcing AssignTfToGovHydro1Event");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromGovHydro1Event event) {
    LOGGER.info("Event sourcing UnAssignTfFromGovHydro1Event");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTgToGovHydro1Event event) {
    LOGGER.info("Event sourcing AssignTgToGovHydro1Event");
    this.tg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTgFromGovHydro1Event event) {
    LOGGER.info("Event sourcing UnAssignTgFromGovHydro1Event");
    this.tg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrToGovHydro1Event event) {
    LOGGER.info("Event sourcing AssignTrToGovHydro1Event");
    this.tr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrFromGovHydro1Event event) {
    LOGGER.info("Event sourcing UnAssignTrFromGovHydro1Event");
    this.tr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwToGovHydro1Event event) {
    LOGGER.info("Event sourcing AssignTwToGovHydro1Event");
    this.tw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwFromGovHydro1Event event) {
    LOGGER.info("Event sourcing UnAssignTwFromGovHydro1Event");
    this.tw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVelmToGovHydro1Event event) {
    LOGGER.info("Event sourcing AssignVelmToGovHydro1Event");
    this.velm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVelmFromGovHydro1Event event) {
    LOGGER.info("Event sourcing UnAssignVelmFromGovHydro1Event");
    this.velm = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govHydro1Id;

  private PU at = null;
  private PU dturb = null;
  private PU gmax = null;
  private PU gmin = null;
  private PU hdam = null;
  private ActivePower mwbase = null;
  private PU qnl = null;
  private PU rperm = null;
  private PU rtemp = null;
  private Seconds tf = null;
  private Seconds tg = null;
  private Seconds tr = null;
  private Seconds tw = null;
  private Simple_Float velm = null;

  private static final Logger LOGGER = Logger.getLogger(GovHydro1Aggregate.class.getName());
}
