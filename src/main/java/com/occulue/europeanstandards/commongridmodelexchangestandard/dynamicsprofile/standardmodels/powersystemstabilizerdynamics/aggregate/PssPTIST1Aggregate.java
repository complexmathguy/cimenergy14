package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.aggregate;

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
 * Aggregate handler for PssPTIST1 as outlined for the CQRS pattern, all write responsibilities
 * related to PssPTIST1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PssPTIST1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PssPTIST1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PssPTIST1Aggregate(CreatePssPTIST1Command command) throws Exception {
    LOGGER.info("Handling command CreatePssPTIST1Command");
    CreatePssPTIST1Event event = new CreatePssPTIST1Event(command.getPssPTIST1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePssPTIST1Command command) throws Exception {
    LOGGER.info("handling command UpdatePssPTIST1Command");
    UpdatePssPTIST1Event event =
        new UpdatePssPTIST1Event(
            command.getPssPTIST1Id(),
            command.getDtc(),
            command.getDtf(),
            command.getDtp(),
            command.getK(),
            command.getM(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getTf(),
            command.getTp());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePssPTIST1Command command) throws Exception {
    LOGGER.info("Handling command DeletePssPTIST1Command");
    apply(new DeletePssPTIST1Event(command.getPssPTIST1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDtcToPssPTIST1Command command) throws Exception {
    LOGGER.info("Handling command AssignDtcToPssPTIST1Command");

    if (dtc != null && dtc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Dtc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignDtcToPssPTIST1Event(command.getPssPTIST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDtcFromPssPTIST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDtcFromPssPTIST1Command");

    if (dtc == null) throw new ProcessingException("Dtc already has nothing assigned.");

    apply(new UnAssignDtcFromPssPTIST1Event(command.getPssPTIST1Id()));
  }

  @CommandHandler
  public void handle(AssignDtfToPssPTIST1Command command) throws Exception {
    LOGGER.info("Handling command AssignDtfToPssPTIST1Command");

    if (dtf != null && dtf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Dtf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignDtfToPssPTIST1Event(command.getPssPTIST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDtfFromPssPTIST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDtfFromPssPTIST1Command");

    if (dtf == null) throw new ProcessingException("Dtf already has nothing assigned.");

    apply(new UnAssignDtfFromPssPTIST1Event(command.getPssPTIST1Id()));
  }

  @CommandHandler
  public void handle(AssignDtpToPssPTIST1Command command) throws Exception {
    LOGGER.info("Handling command AssignDtpToPssPTIST1Command");

    if (dtp != null && dtp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Dtp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignDtpToPssPTIST1Event(command.getPssPTIST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDtpFromPssPTIST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDtpFromPssPTIST1Command");

    if (dtp == null) throw new ProcessingException("Dtp already has nothing assigned.");

    apply(new UnAssignDtpFromPssPTIST1Event(command.getPssPTIST1Id()));
  }

  @CommandHandler
  public void handle(AssignKToPssPTIST1Command command) throws Exception {
    LOGGER.info("Handling command AssignKToPssPTIST1Command");

    if (k != null && k.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKToPssPTIST1Event(command.getPssPTIST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKFromPssPTIST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKFromPssPTIST1Command");

    if (k == null) throw new ProcessingException("K already has nothing assigned.");

    apply(new UnAssignKFromPssPTIST1Event(command.getPssPTIST1Id()));
  }

  @CommandHandler
  public void handle(AssignMToPssPTIST1Command command) throws Exception {
    LOGGER.info("Handling command AssignMToPssPTIST1Command");

    if (m != null && m.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "M already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignMToPssPTIST1Event(command.getPssPTIST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMFromPssPTIST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMFromPssPTIST1Command");

    if (m == null) throw new ProcessingException("M already has nothing assigned.");

    apply(new UnAssignMFromPssPTIST1Event(command.getPssPTIST1Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToPssPTIST1Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToPssPTIST1Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToPssPTIST1Event(command.getPssPTIST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromPssPTIST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromPssPTIST1Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromPssPTIST1Event(command.getPssPTIST1Id()));
  }

  @CommandHandler
  public void handle(AssignT2ToPssPTIST1Command command) throws Exception {
    LOGGER.info("Handling command AssignT2ToPssPTIST1Command");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToPssPTIST1Event(command.getPssPTIST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromPssPTIST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromPssPTIST1Command");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromPssPTIST1Event(command.getPssPTIST1Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToPssPTIST1Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToPssPTIST1Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToPssPTIST1Event(command.getPssPTIST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromPssPTIST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromPssPTIST1Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromPssPTIST1Event(command.getPssPTIST1Id()));
  }

  @CommandHandler
  public void handle(AssignT4ToPssPTIST1Command command) throws Exception {
    LOGGER.info("Handling command AssignT4ToPssPTIST1Command");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToPssPTIST1Event(command.getPssPTIST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromPssPTIST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromPssPTIST1Command");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromPssPTIST1Event(command.getPssPTIST1Id()));
  }

  @CommandHandler
  public void handle(AssignTfToPssPTIST1Command command) throws Exception {
    LOGGER.info("Handling command AssignTfToPssPTIST1Command");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToPssPTIST1Event(command.getPssPTIST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromPssPTIST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromPssPTIST1Command");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromPssPTIST1Event(command.getPssPTIST1Id()));
  }

  @CommandHandler
  public void handle(AssignTpToPssPTIST1Command command) throws Exception {
    LOGGER.info("Handling command AssignTpToPssPTIST1Command");

    if (tp != null && tp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpToPssPTIST1Event(command.getPssPTIST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpFromPssPTIST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpFromPssPTIST1Command");

    if (tp == null) throw new ProcessingException("Tp already has nothing assigned.");

    apply(new UnAssignTpFromPssPTIST1Event(command.getPssPTIST1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePssPTIST1Event event) {
    LOGGER.info("Event sourcing CreatePssPTIST1Event");
    this.pssPTIST1Id = event.getPssPTIST1Id();
  }

  @EventSourcingHandler
  void on(UpdatePssPTIST1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dtc = event.getDtc();
    this.dtf = event.getDtf();
    this.dtp = event.getDtp();
    this.k = event.getK();
    this.m = event.getM();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.tf = event.getTf();
    this.tp = event.getTp();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDtcToPssPTIST1Event event) {
    LOGGER.info("Event sourcing AssignDtcToPssPTIST1Event");
    this.dtc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDtcFromPssPTIST1Event event) {
    LOGGER.info("Event sourcing UnAssignDtcFromPssPTIST1Event");
    this.dtc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDtfToPssPTIST1Event event) {
    LOGGER.info("Event sourcing AssignDtfToPssPTIST1Event");
    this.dtf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDtfFromPssPTIST1Event event) {
    LOGGER.info("Event sourcing UnAssignDtfFromPssPTIST1Event");
    this.dtf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDtpToPssPTIST1Event event) {
    LOGGER.info("Event sourcing AssignDtpToPssPTIST1Event");
    this.dtp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDtpFromPssPTIST1Event event) {
    LOGGER.info("Event sourcing UnAssignDtpFromPssPTIST1Event");
    this.dtp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKToPssPTIST1Event event) {
    LOGGER.info("Event sourcing AssignKToPssPTIST1Event");
    this.k = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKFromPssPTIST1Event event) {
    LOGGER.info("Event sourcing UnAssignKFromPssPTIST1Event");
    this.k = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMToPssPTIST1Event event) {
    LOGGER.info("Event sourcing AssignMToPssPTIST1Event");
    this.m = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMFromPssPTIST1Event event) {
    LOGGER.info("Event sourcing UnAssignMFromPssPTIST1Event");
    this.m = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToPssPTIST1Event event) {
    LOGGER.info("Event sourcing AssignT1ToPssPTIST1Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromPssPTIST1Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromPssPTIST1Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToPssPTIST1Event event) {
    LOGGER.info("Event sourcing AssignT2ToPssPTIST1Event");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromPssPTIST1Event event) {
    LOGGER.info("Event sourcing UnAssignT2FromPssPTIST1Event");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToPssPTIST1Event event) {
    LOGGER.info("Event sourcing AssignT3ToPssPTIST1Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromPssPTIST1Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromPssPTIST1Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToPssPTIST1Event event) {
    LOGGER.info("Event sourcing AssignT4ToPssPTIST1Event");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromPssPTIST1Event event) {
    LOGGER.info("Event sourcing UnAssignT4FromPssPTIST1Event");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToPssPTIST1Event event) {
    LOGGER.info("Event sourcing AssignTfToPssPTIST1Event");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromPssPTIST1Event event) {
    LOGGER.info("Event sourcing UnAssignTfFromPssPTIST1Event");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpToPssPTIST1Event event) {
    LOGGER.info("Event sourcing AssignTpToPssPTIST1Event");
    this.tp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpFromPssPTIST1Event event) {
    LOGGER.info("Event sourcing UnAssignTpFromPssPTIST1Event");
    this.tp = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pssPTIST1Id;

  private Seconds dtc = null;
  private Seconds dtf = null;
  private Seconds dtp = null;
  private PU k = null;
  private PU m = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds tf = null;
  private Seconds tp = null;

  private static final Logger LOGGER = Logger.getLogger(PssPTIST1Aggregate.class.getName());
}
