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
 * Aggregate handler for Pss1 as outlined for the CQRS pattern, all write responsibilities related
 * to Pss1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class Pss1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public Pss1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public Pss1Aggregate(CreatePss1Command command) throws Exception {
    LOGGER.info("Handling command CreatePss1Command");
    CreatePss1Event event = new CreatePss1Event(command.getPss1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePss1Command command) throws Exception {
    LOGGER.info("handling command UpdatePss1Command");
    UpdatePss1Event event =
        new UpdatePss1Event(
            command.getPss1Id(),
            command.getKf(),
            command.getKpe(),
            command.getKs(),
            command.getKw(),
            command.getPmin(),
            command.getT10(),
            command.getT5(),
            command.getT6(),
            command.getT7(),
            command.getT8(),
            command.getT9(),
            command.getTpe(),
            command.getVadat(),
            command.getVsmn(),
            command.getVsmx());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePss1Command command) throws Exception {
    LOGGER.info("Handling command DeletePss1Command");
    apply(new DeletePss1Event(command.getPss1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKfToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignKfToPss1Command");

    if (kf != null && kf.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKfToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromPss1Command");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromPss1Event(command.getPss1Id()));
  }

  @CommandHandler
  public void handle(AssignKpeToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignKpeToPss1Command");

    if (kpe != null && kpe.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kpe already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKpeToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpeFromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpeFromPss1Command");

    if (kpe == null) throw new ProcessingException("Kpe already has nothing assigned.");

    apply(new UnAssignKpeFromPss1Event(command.getPss1Id()));
  }

  @CommandHandler
  public void handle(AssignKsToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignKsToPss1Command");

    if (ks != null && ks.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKsToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromPss1Command");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(new UnAssignKsFromPss1Event(command.getPss1Id()));
  }

  @CommandHandler
  public void handle(AssignKwToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignKwToPss1Command");

    if (kw != null && kw.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kw already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKwToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKwFromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKwFromPss1Command");

    if (kw == null) throw new ProcessingException("Kw already has nothing assigned.");

    apply(new UnAssignKwFromPss1Event(command.getPss1Id()));
  }

  @CommandHandler
  public void handle(AssignPminToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignPminToPss1Command");

    if (pmin != null && pmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPminToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromPss1Command");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromPss1Event(command.getPss1Id()));
  }

  @CommandHandler
  public void handle(AssignT10ToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignT10ToPss1Command");

    if (t10 != null && t10.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T10 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT10ToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT10FromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT10FromPss1Command");

    if (t10 == null) throw new ProcessingException("T10 already has nothing assigned.");

    apply(new UnAssignT10FromPss1Event(command.getPss1Id()));
  }

  @CommandHandler
  public void handle(AssignT5ToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignT5ToPss1Command");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromPss1Command");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromPss1Event(command.getPss1Id()));
  }

  @CommandHandler
  public void handle(AssignT6ToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignT6ToPss1Command");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromPss1Command");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromPss1Event(command.getPss1Id()));
  }

  @CommandHandler
  public void handle(AssignT7ToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignT7ToPss1Command");

    if (t7 != null && t7.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T7 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT7ToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT7FromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT7FromPss1Command");

    if (t7 == null) throw new ProcessingException("T7 already has nothing assigned.");

    apply(new UnAssignT7FromPss1Event(command.getPss1Id()));
  }

  @CommandHandler
  public void handle(AssignT8ToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignT8ToPss1Command");

    if (t8 != null && t8.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T8 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT8ToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT8FromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT8FromPss1Command");

    if (t8 == null) throw new ProcessingException("T8 already has nothing assigned.");

    apply(new UnAssignT8FromPss1Event(command.getPss1Id()));
  }

  @CommandHandler
  public void handle(AssignT9ToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignT9ToPss1Command");

    if (t9 != null && t9.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T9 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT9ToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT9FromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT9FromPss1Command");

    if (t9 == null) throw new ProcessingException("T9 already has nothing assigned.");

    apply(new UnAssignT9FromPss1Event(command.getPss1Id()));
  }

  @CommandHandler
  public void handle(AssignTpeToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignTpeToPss1Command");

    if (tpe != null && tpe.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpe already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpeToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpeFromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpeFromPss1Command");

    if (tpe == null) throw new ProcessingException("Tpe already has nothing assigned.");

    apply(new UnAssignTpeFromPss1Event(command.getPss1Id()));
  }

  @CommandHandler
  public void handle(AssignVadatToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignVadatToPss1Command");

    if (vadat != null && vadat.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Vadat already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignVadatToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVadatFromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVadatFromPss1Command");

    if (vadat == null) throw new ProcessingException("Vadat already has nothing assigned.");

    apply(new UnAssignVadatFromPss1Event(command.getPss1Id()));
  }

  @CommandHandler
  public void handle(AssignVsmnToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignVsmnToPss1Command");

    if (vsmn != null && vsmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsmnToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsmnFromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsmnFromPss1Command");

    if (vsmn == null) throw new ProcessingException("Vsmn already has nothing assigned.");

    apply(new UnAssignVsmnFromPss1Event(command.getPss1Id()));
  }

  @CommandHandler
  public void handle(AssignVsmxToPss1Command command) throws Exception {
    LOGGER.info("Handling command AssignVsmxToPss1Command");

    if (vsmx != null && vsmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsmxToPss1Event(command.getPss1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsmxFromPss1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsmxFromPss1Command");

    if (vsmx == null) throw new ProcessingException("Vsmx already has nothing assigned.");

    apply(new UnAssignVsmxFromPss1Event(command.getPss1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePss1Event event) {
    LOGGER.info("Event sourcing CreatePss1Event");
    this.pss1Id = event.getPss1Id();
  }

  @EventSourcingHandler
  void on(UpdatePss1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.kf = event.getKf();
    this.kpe = event.getKpe();
    this.ks = event.getKs();
    this.kw = event.getKw();
    this.pmin = event.getPmin();
    this.t10 = event.getT10();
    this.t5 = event.getT5();
    this.t6 = event.getT6();
    this.t7 = event.getT7();
    this.t8 = event.getT8();
    this.t9 = event.getT9();
    this.tpe = event.getTpe();
    this.vadat = event.getVadat();
    this.vsmn = event.getVsmn();
    this.vsmx = event.getVsmx();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKfToPss1Event event) {
    LOGGER.info("Event sourcing AssignKfToPss1Event");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignKfFromPss1Event");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpeToPss1Event event) {
    LOGGER.info("Event sourcing AssignKpeToPss1Event");
    this.kpe = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpeFromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignKpeFromPss1Event");
    this.kpe = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsToPss1Event event) {
    LOGGER.info("Event sourcing AssignKsToPss1Event");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignKsFromPss1Event");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKwToPss1Event event) {
    LOGGER.info("Event sourcing AssignKwToPss1Event");
    this.kw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKwFromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignKwFromPss1Event");
    this.kw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToPss1Event event) {
    LOGGER.info("Event sourcing AssignPminToPss1Event");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignPminFromPss1Event");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT10ToPss1Event event) {
    LOGGER.info("Event sourcing AssignT10ToPss1Event");
    this.t10 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT10FromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignT10FromPss1Event");
    this.t10 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToPss1Event event) {
    LOGGER.info("Event sourcing AssignT5ToPss1Event");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignT5FromPss1Event");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToPss1Event event) {
    LOGGER.info("Event sourcing AssignT6ToPss1Event");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignT6FromPss1Event");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT7ToPss1Event event) {
    LOGGER.info("Event sourcing AssignT7ToPss1Event");
    this.t7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT7FromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignT7FromPss1Event");
    this.t7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT8ToPss1Event event) {
    LOGGER.info("Event sourcing AssignT8ToPss1Event");
    this.t8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT8FromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignT8FromPss1Event");
    this.t8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT9ToPss1Event event) {
    LOGGER.info("Event sourcing AssignT9ToPss1Event");
    this.t9 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT9FromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignT9FromPss1Event");
    this.t9 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpeToPss1Event event) {
    LOGGER.info("Event sourcing AssignTpeToPss1Event");
    this.tpe = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpeFromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignTpeFromPss1Event");
    this.tpe = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVadatToPss1Event event) {
    LOGGER.info("Event sourcing AssignVadatToPss1Event");
    this.vadat = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVadatFromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignVadatFromPss1Event");
    this.vadat = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsmnToPss1Event event) {
    LOGGER.info("Event sourcing AssignVsmnToPss1Event");
    this.vsmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsmnFromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignVsmnFromPss1Event");
    this.vsmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsmxToPss1Event event) {
    LOGGER.info("Event sourcing AssignVsmxToPss1Event");
    this.vsmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsmxFromPss1Event event) {
    LOGGER.info("Event sourcing UnAssignVsmxFromPss1Event");
    this.vsmx = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pss1Id;

  private Simple_Float kf = null;
  private Simple_Float kpe = null;
  private Simple_Float ks = null;
  private Simple_Float kw = null;
  private PU pmin = null;
  private Seconds t10 = null;
  private Seconds t5 = null;
  private Seconds t6 = null;
  private Seconds t7 = null;
  private Seconds t8 = null;
  private Seconds t9 = null;
  private Seconds tpe = null;
  private BooleanProxy vadat = null;
  private PU vsmn = null;
  private PU vsmx = null;

  private static final Logger LOGGER = Logger.getLogger(Pss1Aggregate.class.getName());
}
