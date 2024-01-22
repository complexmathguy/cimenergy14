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
 * Aggregate handler for PssSB4 as outlined for the CQRS pattern, all write responsibilities related
 * to PssSB4 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PssSB4Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PssSB4Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PssSB4Aggregate(CreatePssSB4Command command) throws Exception {
    LOGGER.info("Handling command CreatePssSB4Command");
    CreatePssSB4Event event = new CreatePssSB4Event(command.getPssSB4Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePssSB4Command command) throws Exception {
    LOGGER.info("handling command UpdatePssSB4Command");
    UpdatePssSB4Event event =
        new UpdatePssSB4Event(
            command.getPssSB4Id(),
            command.getKx(),
            command.getTa(),
            command.getTb(),
            command.getTc(),
            command.getTd(),
            command.getTe(),
            command.getTt(),
            command.getTx1(),
            command.getTx2(),
            command.getVsmax(),
            command.getVsmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePssSB4Command command) throws Exception {
    LOGGER.info("Handling command DeletePssSB4Command");
    apply(new DeletePssSB4Event(command.getPssSB4Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKxToPssSB4Command command) throws Exception {
    LOGGER.info("Handling command AssignKxToPssSB4Command");

    if (kx != null && kx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKxToPssSB4Event(command.getPssSB4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKxFromPssSB4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKxFromPssSB4Command");

    if (kx == null) throw new ProcessingException("Kx already has nothing assigned.");

    apply(new UnAssignKxFromPssSB4Event(command.getPssSB4Id()));
  }

  @CommandHandler
  public void handle(AssignTaToPssSB4Command command) throws Exception {
    LOGGER.info("Handling command AssignTaToPssSB4Command");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToPssSB4Event(command.getPssSB4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromPssSB4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromPssSB4Command");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromPssSB4Event(command.getPssSB4Id()));
  }

  @CommandHandler
  public void handle(AssignTbToPssSB4Command command) throws Exception {
    LOGGER.info("Handling command AssignTbToPssSB4Command");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToPssSB4Event(command.getPssSB4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromPssSB4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromPssSB4Command");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromPssSB4Event(command.getPssSB4Id()));
  }

  @CommandHandler
  public void handle(AssignTcToPssSB4Command command) throws Exception {
    LOGGER.info("Handling command AssignTcToPssSB4Command");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToPssSB4Event(command.getPssSB4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromPssSB4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromPssSB4Command");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromPssSB4Event(command.getPssSB4Id()));
  }

  @CommandHandler
  public void handle(AssignTdToPssSB4Command command) throws Exception {
    LOGGER.info("Handling command AssignTdToPssSB4Command");

    if (td != null && td.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Td already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdToPssSB4Event(command.getPssSB4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdFromPssSB4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdFromPssSB4Command");

    if (td == null) throw new ProcessingException("Td already has nothing assigned.");

    apply(new UnAssignTdFromPssSB4Event(command.getPssSB4Id()));
  }

  @CommandHandler
  public void handle(AssignTeToPssSB4Command command) throws Exception {
    LOGGER.info("Handling command AssignTeToPssSB4Command");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToPssSB4Event(command.getPssSB4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromPssSB4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromPssSB4Command");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromPssSB4Event(command.getPssSB4Id()));
  }

  @CommandHandler
  public void handle(AssignTtToPssSB4Command command) throws Exception {
    LOGGER.info("Handling command AssignTtToPssSB4Command");

    if (tt != null && tt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tt already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTtToPssSB4Event(command.getPssSB4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTtFromPssSB4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTtFromPssSB4Command");

    if (tt == null) throw new ProcessingException("Tt already has nothing assigned.");

    apply(new UnAssignTtFromPssSB4Event(command.getPssSB4Id()));
  }

  @CommandHandler
  public void handle(AssignTx1ToPssSB4Command command) throws Exception {
    LOGGER.info("Handling command AssignTx1ToPssSB4Command");

    if (tx1 != null && tx1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tx1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTx1ToPssSB4Event(command.getPssSB4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTx1FromPssSB4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTx1FromPssSB4Command");

    if (tx1 == null) throw new ProcessingException("Tx1 already has nothing assigned.");

    apply(new UnAssignTx1FromPssSB4Event(command.getPssSB4Id()));
  }

  @CommandHandler
  public void handle(AssignTx2ToPssSB4Command command) throws Exception {
    LOGGER.info("Handling command AssignTx2ToPssSB4Command");

    if (tx2 != null && tx2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tx2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTx2ToPssSB4Event(command.getPssSB4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTx2FromPssSB4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTx2FromPssSB4Command");

    if (tx2 == null) throw new ProcessingException("Tx2 already has nothing assigned.");

    apply(new UnAssignTx2FromPssSB4Event(command.getPssSB4Id()));
  }

  @CommandHandler
  public void handle(AssignVsmaxToPssSB4Command command) throws Exception {
    LOGGER.info("Handling command AssignVsmaxToPssSB4Command");

    if (vsmax != null && vsmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsmaxToPssSB4Event(command.getPssSB4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsmaxFromPssSB4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsmaxFromPssSB4Command");

    if (vsmax == null) throw new ProcessingException("Vsmax already has nothing assigned.");

    apply(new UnAssignVsmaxFromPssSB4Event(command.getPssSB4Id()));
  }

  @CommandHandler
  public void handle(AssignVsminToPssSB4Command command) throws Exception {
    LOGGER.info("Handling command AssignVsminToPssSB4Command");

    if (vsmin != null && vsmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsminToPssSB4Event(command.getPssSB4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsminFromPssSB4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsminFromPssSB4Command");

    if (vsmin == null) throw new ProcessingException("Vsmin already has nothing assigned.");

    apply(new UnAssignVsminFromPssSB4Event(command.getPssSB4Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePssSB4Event event) {
    LOGGER.info("Event sourcing CreatePssSB4Event");
    this.pssSB4Id = event.getPssSB4Id();
  }

  @EventSourcingHandler
  void on(UpdatePssSB4Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.kx = event.getKx();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.tc = event.getTc();
    this.td = event.getTd();
    this.te = event.getTe();
    this.tt = event.getTt();
    this.tx1 = event.getTx1();
    this.tx2 = event.getTx2();
    this.vsmax = event.getVsmax();
    this.vsmin = event.getVsmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKxToPssSB4Event event) {
    LOGGER.info("Event sourcing AssignKxToPssSB4Event");
    this.kx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKxFromPssSB4Event event) {
    LOGGER.info("Event sourcing UnAssignKxFromPssSB4Event");
    this.kx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToPssSB4Event event) {
    LOGGER.info("Event sourcing AssignTaToPssSB4Event");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromPssSB4Event event) {
    LOGGER.info("Event sourcing UnAssignTaFromPssSB4Event");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToPssSB4Event event) {
    LOGGER.info("Event sourcing AssignTbToPssSB4Event");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromPssSB4Event event) {
    LOGGER.info("Event sourcing UnAssignTbFromPssSB4Event");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToPssSB4Event event) {
    LOGGER.info("Event sourcing AssignTcToPssSB4Event");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromPssSB4Event event) {
    LOGGER.info("Event sourcing UnAssignTcFromPssSB4Event");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdToPssSB4Event event) {
    LOGGER.info("Event sourcing AssignTdToPssSB4Event");
    this.td = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdFromPssSB4Event event) {
    LOGGER.info("Event sourcing UnAssignTdFromPssSB4Event");
    this.td = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToPssSB4Event event) {
    LOGGER.info("Event sourcing AssignTeToPssSB4Event");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromPssSB4Event event) {
    LOGGER.info("Event sourcing UnAssignTeFromPssSB4Event");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTtToPssSB4Event event) {
    LOGGER.info("Event sourcing AssignTtToPssSB4Event");
    this.tt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTtFromPssSB4Event event) {
    LOGGER.info("Event sourcing UnAssignTtFromPssSB4Event");
    this.tt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTx1ToPssSB4Event event) {
    LOGGER.info("Event sourcing AssignTx1ToPssSB4Event");
    this.tx1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTx1FromPssSB4Event event) {
    LOGGER.info("Event sourcing UnAssignTx1FromPssSB4Event");
    this.tx1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTx2ToPssSB4Event event) {
    LOGGER.info("Event sourcing AssignTx2ToPssSB4Event");
    this.tx2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTx2FromPssSB4Event event) {
    LOGGER.info("Event sourcing UnAssignTx2FromPssSB4Event");
    this.tx2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsmaxToPssSB4Event event) {
    LOGGER.info("Event sourcing AssignVsmaxToPssSB4Event");
    this.vsmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsmaxFromPssSB4Event event) {
    LOGGER.info("Event sourcing UnAssignVsmaxFromPssSB4Event");
    this.vsmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsminToPssSB4Event event) {
    LOGGER.info("Event sourcing AssignVsminToPssSB4Event");
    this.vsmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsminFromPssSB4Event event) {
    LOGGER.info("Event sourcing UnAssignVsminFromPssSB4Event");
    this.vsmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pssSB4Id;

  private PU kx = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private Seconds td = null;
  private Seconds te = null;
  private Seconds tt = null;
  private Seconds tx1 = null;
  private Seconds tx2 = null;
  private PU vsmax = null;
  private PU vsmin = null;

  private static final Logger LOGGER = Logger.getLogger(PssSB4Aggregate.class.getName());
}
