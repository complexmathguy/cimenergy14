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
 * Aggregate handler for Pss5 as outlined for the CQRS pattern, all write responsibilities related
 * to Pss5 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class Pss5Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public Pss5Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public Pss5Aggregate(CreatePss5Command command) throws Exception {
    LOGGER.info("Handling command CreatePss5Command");
    CreatePss5Event event = new CreatePss5Event(command.getPss5Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePss5Command command) throws Exception {
    LOGGER.info("handling command UpdatePss5Command");
    UpdatePss5Event event =
        new UpdatePss5Event(
            command.getPss5Id(),
            command.getCtw2(),
            command.getDeadband(),
            command.getIsfreq(),
            command.getKf(),
            command.getKpe(),
            command.getKpss(),
            command.getPmm(),
            command.getTl1(),
            command.getTl2(),
            command.getTl3(),
            command.getTl4(),
            command.getTpe(),
            command.getTw1(),
            command.getTw2(),
            command.getVadat(),
            command.getVsmn(),
            command.getVsmx());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePss5Command command) throws Exception {
    LOGGER.info("Handling command DeletePss5Command");
    apply(new DeletePss5Event(command.getPss5Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignCtw2ToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignCtw2ToPss5Command");

    if (ctw2 != null && ctw2.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Ctw2 already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignCtw2ToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCtw2FromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignCtw2FromPss5Command");

    if (ctw2 == null) throw new ProcessingException("Ctw2 already has nothing assigned.");

    apply(new UnAssignCtw2FromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignDeadbandToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignDeadbandToPss5Command");

    if (deadband != null && deadband.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Deadband already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDeadbandToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDeadbandFromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDeadbandFromPss5Command");

    if (deadband == null) throw new ProcessingException("Deadband already has nothing assigned.");

    apply(new UnAssignDeadbandFromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignIsfreqToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignIsfreqToPss5Command");

    if (isfreq != null && isfreq.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Isfreq already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignIsfreqToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIsfreqFromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignIsfreqFromPss5Command");

    if (isfreq == null) throw new ProcessingException("Isfreq already has nothing assigned.");

    apply(new UnAssignIsfreqFromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignKfToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignKfToPss5Command");

    if (kf != null && kf.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKfToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromPss5Command");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignKpeToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignKpeToPss5Command");

    if (kpe != null && kpe.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kpe already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKpeToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpeFromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpeFromPss5Command");

    if (kpe == null) throw new ProcessingException("Kpe already has nothing assigned.");

    apply(new UnAssignKpeFromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignKpssToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignKpssToPss5Command");

    if (kpss != null && kpss.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kpss already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKpssToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpssFromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpssFromPss5Command");

    if (kpss == null) throw new ProcessingException("Kpss already has nothing assigned.");

    apply(new UnAssignKpssFromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignPmmToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignPmmToPss5Command");

    if (pmm != null && pmm.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmm already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmmToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmmFromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmmFromPss5Command");

    if (pmm == null) throw new ProcessingException("Pmm already has nothing assigned.");

    apply(new UnAssignPmmFromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignTl1ToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignTl1ToPss5Command");

    if (tl1 != null && tl1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl1ToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl1FromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl1FromPss5Command");

    if (tl1 == null) throw new ProcessingException("Tl1 already has nothing assigned.");

    apply(new UnAssignTl1FromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignTl2ToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignTl2ToPss5Command");

    if (tl2 != null && tl2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl2ToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl2FromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl2FromPss5Command");

    if (tl2 == null) throw new ProcessingException("Tl2 already has nothing assigned.");

    apply(new UnAssignTl2FromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignTl3ToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignTl3ToPss5Command");

    if (tl3 != null && tl3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl3ToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl3FromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl3FromPss5Command");

    if (tl3 == null) throw new ProcessingException("Tl3 already has nothing assigned.");

    apply(new UnAssignTl3FromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignTl4ToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignTl4ToPss5Command");

    if (tl4 != null && tl4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl4ToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl4FromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl4FromPss5Command");

    if (tl4 == null) throw new ProcessingException("Tl4 already has nothing assigned.");

    apply(new UnAssignTl4FromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignTpeToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignTpeToPss5Command");

    if (tpe != null && tpe.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpe already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpeToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpeFromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpeFromPss5Command");

    if (tpe == null) throw new ProcessingException("Tpe already has nothing assigned.");

    apply(new UnAssignTpeFromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignTw1ToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignTw1ToPss5Command");

    if (tw1 != null && tw1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTw1ToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTw1FromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTw1FromPss5Command");

    if (tw1 == null) throw new ProcessingException("Tw1 already has nothing assigned.");

    apply(new UnAssignTw1FromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignTw2ToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignTw2ToPss5Command");

    if (tw2 != null && tw2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTw2ToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTw2FromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTw2FromPss5Command");

    if (tw2 == null) throw new ProcessingException("Tw2 already has nothing assigned.");

    apply(new UnAssignTw2FromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignVadatToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignVadatToPss5Command");

    if (vadat != null && vadat.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Vadat already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignVadatToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVadatFromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVadatFromPss5Command");

    if (vadat == null) throw new ProcessingException("Vadat already has nothing assigned.");

    apply(new UnAssignVadatFromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignVsmnToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignVsmnToPss5Command");

    if (vsmn != null && vsmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsmnToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsmnFromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsmnFromPss5Command");

    if (vsmn == null) throw new ProcessingException("Vsmn already has nothing assigned.");

    apply(new UnAssignVsmnFromPss5Event(command.getPss5Id()));
  }

  @CommandHandler
  public void handle(AssignVsmxToPss5Command command) throws Exception {
    LOGGER.info("Handling command AssignVsmxToPss5Command");

    if (vsmx != null && vsmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsmxToPss5Event(command.getPss5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsmxFromPss5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsmxFromPss5Command");

    if (vsmx == null) throw new ProcessingException("Vsmx already has nothing assigned.");

    apply(new UnAssignVsmxFromPss5Event(command.getPss5Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePss5Event event) {
    LOGGER.info("Event sourcing CreatePss5Event");
    this.pss5Id = event.getPss5Id();
  }

  @EventSourcingHandler
  void on(UpdatePss5Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ctw2 = event.getCtw2();
    this.deadband = event.getDeadband();
    this.isfreq = event.getIsfreq();
    this.kf = event.getKf();
    this.kpe = event.getKpe();
    this.kpss = event.getKpss();
    this.pmm = event.getPmm();
    this.tl1 = event.getTl1();
    this.tl2 = event.getTl2();
    this.tl3 = event.getTl3();
    this.tl4 = event.getTl4();
    this.tpe = event.getTpe();
    this.tw1 = event.getTw1();
    this.tw2 = event.getTw2();
    this.vadat = event.getVadat();
    this.vsmn = event.getVsmn();
    this.vsmx = event.getVsmx();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignCtw2ToPss5Event event) {
    LOGGER.info("Event sourcing AssignCtw2ToPss5Event");
    this.ctw2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCtw2FromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignCtw2FromPss5Event");
    this.ctw2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDeadbandToPss5Event event) {
    LOGGER.info("Event sourcing AssignDeadbandToPss5Event");
    this.deadband = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDeadbandFromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignDeadbandFromPss5Event");
    this.deadband = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIsfreqToPss5Event event) {
    LOGGER.info("Event sourcing AssignIsfreqToPss5Event");
    this.isfreq = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIsfreqFromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignIsfreqFromPss5Event");
    this.isfreq = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToPss5Event event) {
    LOGGER.info("Event sourcing AssignKfToPss5Event");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignKfFromPss5Event");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpeToPss5Event event) {
    LOGGER.info("Event sourcing AssignKpeToPss5Event");
    this.kpe = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpeFromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignKpeFromPss5Event");
    this.kpe = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpssToPss5Event event) {
    LOGGER.info("Event sourcing AssignKpssToPss5Event");
    this.kpss = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpssFromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignKpssFromPss5Event");
    this.kpss = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmmToPss5Event event) {
    LOGGER.info("Event sourcing AssignPmmToPss5Event");
    this.pmm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmmFromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignPmmFromPss5Event");
    this.pmm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl1ToPss5Event event) {
    LOGGER.info("Event sourcing AssignTl1ToPss5Event");
    this.tl1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl1FromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignTl1FromPss5Event");
    this.tl1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl2ToPss5Event event) {
    LOGGER.info("Event sourcing AssignTl2ToPss5Event");
    this.tl2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl2FromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignTl2FromPss5Event");
    this.tl2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl3ToPss5Event event) {
    LOGGER.info("Event sourcing AssignTl3ToPss5Event");
    this.tl3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl3FromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignTl3FromPss5Event");
    this.tl3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl4ToPss5Event event) {
    LOGGER.info("Event sourcing AssignTl4ToPss5Event");
    this.tl4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl4FromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignTl4FromPss5Event");
    this.tl4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpeToPss5Event event) {
    LOGGER.info("Event sourcing AssignTpeToPss5Event");
    this.tpe = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpeFromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignTpeFromPss5Event");
    this.tpe = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTw1ToPss5Event event) {
    LOGGER.info("Event sourcing AssignTw1ToPss5Event");
    this.tw1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTw1FromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignTw1FromPss5Event");
    this.tw1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTw2ToPss5Event event) {
    LOGGER.info("Event sourcing AssignTw2ToPss5Event");
    this.tw2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTw2FromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignTw2FromPss5Event");
    this.tw2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVadatToPss5Event event) {
    LOGGER.info("Event sourcing AssignVadatToPss5Event");
    this.vadat = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVadatFromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignVadatFromPss5Event");
    this.vadat = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsmnToPss5Event event) {
    LOGGER.info("Event sourcing AssignVsmnToPss5Event");
    this.vsmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsmnFromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignVsmnFromPss5Event");
    this.vsmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsmxToPss5Event event) {
    LOGGER.info("Event sourcing AssignVsmxToPss5Event");
    this.vsmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsmxFromPss5Event event) {
    LOGGER.info("Event sourcing UnAssignVsmxFromPss5Event");
    this.vsmx = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pss5Id;

  private BooleanProxy ctw2 = null;
  private PU deadband = null;
  private BooleanProxy isfreq = null;
  private Simple_Float kf = null;
  private Simple_Float kpe = null;
  private Simple_Float kpss = null;
  private PU pmm = null;
  private Seconds tl1 = null;
  private Seconds tl2 = null;
  private Seconds tl3 = null;
  private Seconds tl4 = null;
  private Seconds tpe = null;
  private Seconds tw1 = null;
  private Seconds tw2 = null;
  private BooleanProxy vadat = null;
  private PU vsmn = null;
  private PU vsmx = null;

  private static final Logger LOGGER = Logger.getLogger(Pss5Aggregate.class.getName());
}
