package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.aggregate;

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
 * Aggregate handler for TurbLCFB1 as outlined for the CQRS pattern, all write responsibilities
 * related to TurbLCFB1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TurbLCFB1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TurbLCFB1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TurbLCFB1Aggregate(CreateTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handling command CreateTurbLCFB1Command");
    CreateTurbLCFB1Event event = new CreateTurbLCFB1Event(command.getTurbLCFB1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTurbLCFB1Command command) throws Exception {
    LOGGER.info("handling command UpdateTurbLCFB1Command");
    UpdateTurbLCFB1Event event =
        new UpdateTurbLCFB1Event(
            command.getTurbLCFB1Id(),
            command.getDb(),
            command.getEmax(),
            command.getFb(),
            command.getFbf(),
            command.getIrmax(),
            command.getKi(),
            command.getKp(),
            command.getMwbase(),
            command.getPbf(),
            command.getPmwset(),
            command.getSpeedReferenceGovernor(),
            command.getTpelec());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handling command DeleteTurbLCFB1Command");
    apply(new DeleteTurbLCFB1Event(command.getTurbLCFB1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDbToTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handling command AssignDbToTurbLCFB1Command");

    if (db != null && db.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Db already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDbToTurbLCFB1Event(command.getTurbLCFB1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDbFromTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDbFromTurbLCFB1Command");

    if (db == null) throw new ProcessingException("Db already has nothing assigned.");

    apply(new UnAssignDbFromTurbLCFB1Event(command.getTurbLCFB1Id()));
  }

  @CommandHandler
  public void handle(AssignEmaxToTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handling command AssignEmaxToTurbLCFB1Command");

    if (emax != null && emax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Emax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEmaxToTurbLCFB1Event(command.getTurbLCFB1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEmaxFromTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEmaxFromTurbLCFB1Command");

    if (emax == null) throw new ProcessingException("Emax already has nothing assigned.");

    apply(new UnAssignEmaxFromTurbLCFB1Event(command.getTurbLCFB1Id()));
  }

  @CommandHandler
  public void handle(AssignFbToTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handling command AssignFbToTurbLCFB1Command");

    if (fb != null && fb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFbToTurbLCFB1Event(command.getTurbLCFB1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFbFromTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFbFromTurbLCFB1Command");

    if (fb == null) throw new ProcessingException("Fb already has nothing assigned.");

    apply(new UnAssignFbFromTurbLCFB1Event(command.getTurbLCFB1Id()));
  }

  @CommandHandler
  public void handle(AssignFbfToTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handling command AssignFbfToTurbLCFB1Command");

    if (fbf != null && fbf.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Fbf already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignFbfToTurbLCFB1Event(command.getTurbLCFB1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFbfFromTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFbfFromTurbLCFB1Command");

    if (fbf == null) throw new ProcessingException("Fbf already has nothing assigned.");

    apply(new UnAssignFbfFromTurbLCFB1Event(command.getTurbLCFB1Id()));
  }

  @CommandHandler
  public void handle(AssignIrmaxToTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handling command AssignIrmaxToTurbLCFB1Command");

    if (irmax != null && irmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Irmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIrmaxToTurbLCFB1Event(command.getTurbLCFB1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIrmaxFromTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignIrmaxFromTurbLCFB1Command");

    if (irmax == null) throw new ProcessingException("Irmax already has nothing assigned.");

    apply(new UnAssignIrmaxFromTurbLCFB1Event(command.getTurbLCFB1Id()));
  }

  @CommandHandler
  public void handle(AssignKiToTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handling command AssignKiToTurbLCFB1Command");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToTurbLCFB1Event(command.getTurbLCFB1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromTurbLCFB1Command");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromTurbLCFB1Event(command.getTurbLCFB1Id()));
  }

  @CommandHandler
  public void handle(AssignKpToTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handling command AssignKpToTurbLCFB1Command");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToTurbLCFB1Event(command.getTurbLCFB1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromTurbLCFB1Command");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromTurbLCFB1Event(command.getTurbLCFB1Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToTurbLCFB1Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToTurbLCFB1Event(command.getTurbLCFB1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromTurbLCFB1Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromTurbLCFB1Event(command.getTurbLCFB1Id()));
  }

  @CommandHandler
  public void handle(AssignPbfToTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handling command AssignPbfToTurbLCFB1Command");

    if (pbf != null && pbf.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Pbf already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignPbfToTurbLCFB1Event(command.getTurbLCFB1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPbfFromTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPbfFromTurbLCFB1Command");

    if (pbf == null) throw new ProcessingException("Pbf already has nothing assigned.");

    apply(new UnAssignPbfFromTurbLCFB1Event(command.getTurbLCFB1Id()));
  }

  @CommandHandler
  public void handle(AssignPmwsetToTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handling command AssignPmwsetToTurbLCFB1Command");

    if (pmwset != null && pmwset.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Pmwset already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignPmwsetToTurbLCFB1Event(command.getTurbLCFB1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmwsetFromTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmwsetFromTurbLCFB1Command");

    if (pmwset == null) throw new ProcessingException("Pmwset already has nothing assigned.");

    apply(new UnAssignPmwsetFromTurbLCFB1Event(command.getTurbLCFB1Id()));
  }

  @CommandHandler
  public void handle(AssignSpeedReferenceGovernorToTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handling command AssignSpeedReferenceGovernorToTurbLCFB1Command");

    if (speedReferenceGovernor != null
        && speedReferenceGovernor.getBooleanProxyId()
            == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "SpeedReferenceGovernor already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignSpeedReferenceGovernorToTurbLCFB1Event(
            command.getTurbLCFB1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSpeedReferenceGovernorFromTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSpeedReferenceGovernorFromTurbLCFB1Command");

    if (speedReferenceGovernor == null)
      throw new ProcessingException("SpeedReferenceGovernor already has nothing assigned.");

    apply(new UnAssignSpeedReferenceGovernorFromTurbLCFB1Event(command.getTurbLCFB1Id()));
  }

  @CommandHandler
  public void handle(AssignTpelecToTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handling command AssignTpelecToTurbLCFB1Command");

    if (tpelec != null && tpelec.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpelec already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpelecToTurbLCFB1Event(command.getTurbLCFB1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpelecFromTurbLCFB1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpelecFromTurbLCFB1Command");

    if (tpelec == null) throw new ProcessingException("Tpelec already has nothing assigned.");

    apply(new UnAssignTpelecFromTurbLCFB1Event(command.getTurbLCFB1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTurbLCFB1Event event) {
    LOGGER.info("Event sourcing CreateTurbLCFB1Event");
    this.turbLCFB1Id = event.getTurbLCFB1Id();
  }

  @EventSourcingHandler
  void on(UpdateTurbLCFB1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.db = event.getDb();
    this.emax = event.getEmax();
    this.fb = event.getFb();
    this.fbf = event.getFbf();
    this.irmax = event.getIrmax();
    this.ki = event.getKi();
    this.kp = event.getKp();
    this.mwbase = event.getMwbase();
    this.pbf = event.getPbf();
    this.pmwset = event.getPmwset();
    this.speedReferenceGovernor = event.getSpeedReferenceGovernor();
    this.tpelec = event.getTpelec();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDbToTurbLCFB1Event event) {
    LOGGER.info("Event sourcing AssignDbToTurbLCFB1Event");
    this.db = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDbFromTurbLCFB1Event event) {
    LOGGER.info("Event sourcing UnAssignDbFromTurbLCFB1Event");
    this.db = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEmaxToTurbLCFB1Event event) {
    LOGGER.info("Event sourcing AssignEmaxToTurbLCFB1Event");
    this.emax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEmaxFromTurbLCFB1Event event) {
    LOGGER.info("Event sourcing UnAssignEmaxFromTurbLCFB1Event");
    this.emax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFbToTurbLCFB1Event event) {
    LOGGER.info("Event sourcing AssignFbToTurbLCFB1Event");
    this.fb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFbFromTurbLCFB1Event event) {
    LOGGER.info("Event sourcing UnAssignFbFromTurbLCFB1Event");
    this.fb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFbfToTurbLCFB1Event event) {
    LOGGER.info("Event sourcing AssignFbfToTurbLCFB1Event");
    this.fbf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFbfFromTurbLCFB1Event event) {
    LOGGER.info("Event sourcing UnAssignFbfFromTurbLCFB1Event");
    this.fbf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIrmaxToTurbLCFB1Event event) {
    LOGGER.info("Event sourcing AssignIrmaxToTurbLCFB1Event");
    this.irmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIrmaxFromTurbLCFB1Event event) {
    LOGGER.info("Event sourcing UnAssignIrmaxFromTurbLCFB1Event");
    this.irmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToTurbLCFB1Event event) {
    LOGGER.info("Event sourcing AssignKiToTurbLCFB1Event");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromTurbLCFB1Event event) {
    LOGGER.info("Event sourcing UnAssignKiFromTurbLCFB1Event");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToTurbLCFB1Event event) {
    LOGGER.info("Event sourcing AssignKpToTurbLCFB1Event");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromTurbLCFB1Event event) {
    LOGGER.info("Event sourcing UnAssignKpFromTurbLCFB1Event");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToTurbLCFB1Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToTurbLCFB1Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromTurbLCFB1Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromTurbLCFB1Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPbfToTurbLCFB1Event event) {
    LOGGER.info("Event sourcing AssignPbfToTurbLCFB1Event");
    this.pbf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPbfFromTurbLCFB1Event event) {
    LOGGER.info("Event sourcing UnAssignPbfFromTurbLCFB1Event");
    this.pbf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmwsetToTurbLCFB1Event event) {
    LOGGER.info("Event sourcing AssignPmwsetToTurbLCFB1Event");
    this.pmwset = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmwsetFromTurbLCFB1Event event) {
    LOGGER.info("Event sourcing UnAssignPmwsetFromTurbLCFB1Event");
    this.pmwset = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSpeedReferenceGovernorToTurbLCFB1Event event) {
    LOGGER.info("Event sourcing AssignSpeedReferenceGovernorToTurbLCFB1Event");
    this.speedReferenceGovernor = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSpeedReferenceGovernorFromTurbLCFB1Event event) {
    LOGGER.info("Event sourcing UnAssignSpeedReferenceGovernorFromTurbLCFB1Event");
    this.speedReferenceGovernor = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpelecToTurbLCFB1Event event) {
    LOGGER.info("Event sourcing AssignTpelecToTurbLCFB1Event");
    this.tpelec = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpelecFromTurbLCFB1Event event) {
    LOGGER.info("Event sourcing UnAssignTpelecFromTurbLCFB1Event");
    this.tpelec = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID turbLCFB1Id;

  private PU db = null;
  private PU emax = null;
  private PU fb = null;
  private BooleanProxy fbf = null;
  private PU irmax = null;
  private PU ki = null;
  private PU kp = null;
  private ActivePower mwbase = null;
  private BooleanProxy pbf = null;
  private ActivePower pmwset = null;
  private BooleanProxy speedReferenceGovernor = null;
  private Seconds tpelec = null;

  private static final Logger LOGGER = Logger.getLogger(TurbLCFB1Aggregate.class.getName());
}
