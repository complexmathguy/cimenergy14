package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.aggregate;

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
 * Aggregate handler for ExcAC6A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcAC6A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcAC6AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcAC6AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcAC6AAggregate(CreateExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcAC6ACommand");
    CreateExcAC6AEvent event = new CreateExcAC6AEvent(command.getExcAC6AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcAC6ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcAC6ACommand");
    UpdateExcAC6AEvent event =
        new UpdateExcAC6AEvent(
            command.getExcAC6AId(),
            command.getKa(),
            command.getKc(),
            command.getKd(),
            command.getKe(),
            command.getKh(),
            command.getKs(),
            command.getSeve1(),
            command.getSeve2(),
            command.getTa(),
            command.getTb(),
            command.getTc(),
            command.getTe(),
            command.getTh(),
            command.getTj(),
            command.getTk(),
            command.getVamax(),
            command.getVamin(),
            command.getVe1(),
            command.getVe2(),
            command.getVfelim(),
            command.getVhmax(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcAC6ACommand");
    apply(new DeleteExcAC6AEvent(command.getExcAC6AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKaToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcAC6ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcAC6ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcAC6ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcAC6ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcAC6ACommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcAC6ACommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcAC6ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcAC6ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignKhToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKhToExcAC6ACommand");

    if (kh != null && kh.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kh already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKhToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKhFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKhFromExcAC6ACommand");

    if (kh == null) throw new ProcessingException("Kh already has nothing assigned.");

    apply(new UnAssignKhFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignKsToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKsToExcAC6ACommand");

    if (ks != null && ks.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKsToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromExcAC6ACommand");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(new UnAssignKsFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignSeve1ToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve1ToExcAC6ACommand");

    if (seve1 != null && seve1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve1ToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve1FromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve1FromExcAC6ACommand");

    if (seve1 == null) throw new ProcessingException("Seve1 already has nothing assigned.");

    apply(new UnAssignSeve1FromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignSeve2ToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve2ToExcAC6ACommand");

    if (seve2 != null && seve2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve2ToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve2FromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve2FromExcAC6ACommand");

    if (seve2 == null) throw new ProcessingException("Seve2 already has nothing assigned.");

    apply(new UnAssignSeve2FromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcAC6ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcAC6ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcAC6ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcAC6ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcAC6ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcAC6ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcAC6ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcAC6ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignThToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignThToExcAC6ACommand");

    if (th != null && th.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Th already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignThToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignThFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignThFromExcAC6ACommand");

    if (th == null) throw new ProcessingException("Th already has nothing assigned.");

    apply(new UnAssignThFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignTjToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTjToExcAC6ACommand");

    if (tj != null && tj.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tj already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTjToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTjFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTjFromExcAC6ACommand");

    if (tj == null) throw new ProcessingException("Tj already has nothing assigned.");

    apply(new UnAssignTjFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignTkToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTkToExcAC6ACommand");

    if (tk != null && tk.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tk already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTkToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTkFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTkFromExcAC6ACommand");

    if (tk == null) throw new ProcessingException("Tk already has nothing assigned.");

    apply(new UnAssignTkFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVamaxToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVamaxToExcAC6ACommand");

    if (vamax != null && vamax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVamaxToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVamaxFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVamaxFromExcAC6ACommand");

    if (vamax == null) throw new ProcessingException("Vamax already has nothing assigned.");

    apply(new UnAssignVamaxFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVaminToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVaminToExcAC6ACommand");

    if (vamin != null && vamin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVaminToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaminFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaminFromExcAC6ACommand");

    if (vamin == null) throw new ProcessingException("Vamin already has nothing assigned.");

    apply(new UnAssignVaminFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVe1ToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe1ToExcAC6ACommand");

    if (ve1 != null && ve1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe1ToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe1FromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe1FromExcAC6ACommand");

    if (ve1 == null) throw new ProcessingException("Ve1 already has nothing assigned.");

    apply(new UnAssignVe1FromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVe2ToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe2ToExcAC6ACommand");

    if (ve2 != null && ve2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe2ToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe2FromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe2FromExcAC6ACommand");

    if (ve2 == null) throw new ProcessingException("Ve2 already has nothing assigned.");

    apply(new UnAssignVe2FromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVfelimToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVfelimToExcAC6ACommand");

    if (vfelim != null && vfelim.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vfelim already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVfelimToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVfelimFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVfelimFromExcAC6ACommand");

    if (vfelim == null) throw new ProcessingException("Vfelim already has nothing assigned.");

    apply(new UnAssignVfelimFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVhmaxToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVhmaxToExcAC6ACommand");

    if (vhmax != null && vhmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vhmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVhmaxToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVhmaxFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVhmaxFromExcAC6ACommand");

    if (vhmax == null) throw new ProcessingException("Vhmax already has nothing assigned.");

    apply(new UnAssignVhmaxFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcAC6ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcAC6ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcAC6AEvent(command.getExcAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcAC6ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcAC6AEvent(command.getExcAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcAC6ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcAC6AEvent(command.getExcAC6AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcAC6AEvent event) {
    LOGGER.info("Event sourcing CreateExcAC6AEvent");
    this.excAC6AId = event.getExcAC6AId();
  }

  @EventSourcingHandler
  void on(UpdateExcAC6AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.kd = event.getKd();
    this.ke = event.getKe();
    this.kh = event.getKh();
    this.ks = event.getKs();
    this.seve1 = event.getSeve1();
    this.seve2 = event.getSeve2();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.tc = event.getTc();
    this.te = event.getTe();
    this.th = event.getTh();
    this.tj = event.getTj();
    this.tk = event.getTk();
    this.vamax = event.getVamax();
    this.vamin = event.getVamin();
    this.ve1 = event.getVe1();
    this.ve2 = event.getVe2();
    this.vfelim = event.getVfelim();
    this.vhmax = event.getVhmax();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcAC6AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcAC6AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcAC6AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcAC6AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcAC6AEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcAC6AEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcAC6AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcAC6AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKhToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignKhToExcAC6AEvent");
    this.kh = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKhFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignKhFromExcAC6AEvent");
    this.kh = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignKsToExcAC6AEvent");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignKsFromExcAC6AEvent");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve1ToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignSeve1ToExcAC6AEvent");
    this.seve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve1FromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve1FromExcAC6AEvent");
    this.seve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve2ToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignSeve2ToExcAC6AEvent");
    this.seve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve2FromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve2FromExcAC6AEvent");
    this.seve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcAC6AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcAC6AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcAC6AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcAC6AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcAC6AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcAC6AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcAC6AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcAC6AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignThToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignThToExcAC6AEvent");
    this.th = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignThFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignThFromExcAC6AEvent");
    this.th = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTjToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignTjToExcAC6AEvent");
    this.tj = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTjFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignTjFromExcAC6AEvent");
    this.tj = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTkToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignTkToExcAC6AEvent");
    this.tk = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTkFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignTkFromExcAC6AEvent");
    this.tk = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVamaxToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVamaxToExcAC6AEvent");
    this.vamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVamaxFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVamaxFromExcAC6AEvent");
    this.vamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaminToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVaminToExcAC6AEvent");
    this.vamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaminFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVaminFromExcAC6AEvent");
    this.vamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe1ToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVe1ToExcAC6AEvent");
    this.ve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe1FromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe1FromExcAC6AEvent");
    this.ve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe2ToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVe2ToExcAC6AEvent");
    this.ve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe2FromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe2FromExcAC6AEvent");
    this.ve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVfelimToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVfelimToExcAC6AEvent");
    this.vfelim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVfelimFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVfelimFromExcAC6AEvent");
    this.vfelim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVhmaxToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVhmaxToExcAC6AEvent");
    this.vhmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVhmaxFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVhmaxFromExcAC6AEvent");
    this.vhmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcAC6AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcAC6AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcAC6AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcAC6AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excAC6AId;

  private PU ka = null;
  private PU kc = null;
  private PU kd = null;
  private PU ke = null;
  private PU kh = null;
  private PU ks = null;
  private Simple_Float seve1 = null;
  private Simple_Float seve2 = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private Seconds te = null;
  private Seconds th = null;
  private Seconds tj = null;
  private Seconds tk = null;
  private PU vamax = null;
  private PU vamin = null;
  private PU ve1 = null;
  private PU ve2 = null;
  private PU vfelim = null;
  private PU vhmax = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcAC6AAggregate.class.getName());
}
