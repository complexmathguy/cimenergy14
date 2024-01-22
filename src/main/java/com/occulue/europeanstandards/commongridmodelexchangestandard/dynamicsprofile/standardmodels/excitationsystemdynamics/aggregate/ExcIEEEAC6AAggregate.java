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
 * Aggregate handler for ExcIEEEAC6A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEAC6A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEAC6AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEAC6AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEAC6AAggregate(CreateExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEAC6ACommand");
    CreateExcIEEEAC6AEvent event = new CreateExcIEEEAC6AEvent(command.getExcIEEEAC6AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEAC6ACommand");
    UpdateExcIEEEAC6AEvent event =
        new UpdateExcIEEEAC6AEvent(
            command.getExcIEEEAC6AId(),
            command.getKa(),
            command.getKc(),
            command.getKd(),
            command.getKe(),
            command.getKh(),
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
  public void handle(DeleteExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEAC6ACommand");
    apply(new DeleteExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKaToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcIEEEAC6ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcIEEEAC6ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcIEEEAC6ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcIEEEAC6ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcIEEEAC6ACommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcIEEEAC6ACommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcIEEEAC6ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcIEEEAC6ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignKhToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKhToExcIEEEAC6ACommand");

    if (kh != null && kh.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kh already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKhToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKhFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKhFromExcIEEEAC6ACommand");

    if (kh == null) throw new ProcessingException("Kh already has nothing assigned.");

    apply(new UnAssignKhFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignSeve1ToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve1ToExcIEEEAC6ACommand");

    if (seve1 != null && seve1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve1ToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve1FromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve1FromExcIEEEAC6ACommand");

    if (seve1 == null) throw new ProcessingException("Seve1 already has nothing assigned.");

    apply(new UnAssignSeve1FromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignSeve2ToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve2ToExcIEEEAC6ACommand");

    if (seve2 != null && seve2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve2ToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve2FromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve2FromExcIEEEAC6ACommand");

    if (seve2 == null) throw new ProcessingException("Seve2 already has nothing assigned.");

    apply(new UnAssignSeve2FromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcIEEEAC6ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcIEEEAC6ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcIEEEAC6ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcIEEEAC6ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcIEEEAC6ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcIEEEAC6ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcIEEEAC6ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcIEEEAC6ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignThToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignThToExcIEEEAC6ACommand");

    if (th != null && th.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Th already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignThToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignThFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignThFromExcIEEEAC6ACommand");

    if (th == null) throw new ProcessingException("Th already has nothing assigned.");

    apply(new UnAssignThFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignTjToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTjToExcIEEEAC6ACommand");

    if (tj != null && tj.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tj already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTjToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTjFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTjFromExcIEEEAC6ACommand");

    if (tj == null) throw new ProcessingException("Tj already has nothing assigned.");

    apply(new UnAssignTjFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignTkToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTkToExcIEEEAC6ACommand");

    if (tk != null && tk.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tk already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTkToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTkFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTkFromExcIEEEAC6ACommand");

    if (tk == null) throw new ProcessingException("Tk already has nothing assigned.");

    apply(new UnAssignTkFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVamaxToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVamaxToExcIEEEAC6ACommand");

    if (vamax != null && vamax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVamaxToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVamaxFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVamaxFromExcIEEEAC6ACommand");

    if (vamax == null) throw new ProcessingException("Vamax already has nothing assigned.");

    apply(new UnAssignVamaxFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVaminToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVaminToExcIEEEAC6ACommand");

    if (vamin != null && vamin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVaminToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaminFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaminFromExcIEEEAC6ACommand");

    if (vamin == null) throw new ProcessingException("Vamin already has nothing assigned.");

    apply(new UnAssignVaminFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVe1ToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe1ToExcIEEEAC6ACommand");

    if (ve1 != null && ve1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe1ToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe1FromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe1FromExcIEEEAC6ACommand");

    if (ve1 == null) throw new ProcessingException("Ve1 already has nothing assigned.");

    apply(new UnAssignVe1FromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVe2ToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe2ToExcIEEEAC6ACommand");

    if (ve2 != null && ve2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe2ToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe2FromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe2FromExcIEEEAC6ACommand");

    if (ve2 == null) throw new ProcessingException("Ve2 already has nothing assigned.");

    apply(new UnAssignVe2FromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVfelimToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVfelimToExcIEEEAC6ACommand");

    if (vfelim != null && vfelim.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vfelim already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVfelimToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVfelimFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVfelimFromExcIEEEAC6ACommand");

    if (vfelim == null) throw new ProcessingException("Vfelim already has nothing assigned.");

    apply(new UnAssignVfelimFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVhmaxToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVhmaxToExcIEEEAC6ACommand");

    if (vhmax != null && vhmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vhmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVhmaxToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVhmaxFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVhmaxFromExcIEEEAC6ACommand");

    if (vhmax == null) throw new ProcessingException("Vhmax already has nothing assigned.");

    apply(new UnAssignVhmaxFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEAC6ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEAC6ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEAC6ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEAC6ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEAC6ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEAC6AEvent");
    this.excIEEEAC6AId = event.getExcIEEEAC6AId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.kd = event.getKd();
    this.ke = event.getKe();
    this.kh = event.getKh();
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
  void on(AssignKaToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcIEEEAC6AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcIEEEAC6AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcIEEEAC6AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcIEEEAC6AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcIEEEAC6AEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcIEEEAC6AEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcIEEEAC6AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcIEEEAC6AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKhToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignKhToExcIEEEAC6AEvent");
    this.kh = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKhFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignKhFromExcIEEEAC6AEvent");
    this.kh = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve1ToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignSeve1ToExcIEEEAC6AEvent");
    this.seve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve1FromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve1FromExcIEEEAC6AEvent");
    this.seve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve2ToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignSeve2ToExcIEEEAC6AEvent");
    this.seve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve2FromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve2FromExcIEEEAC6AEvent");
    this.seve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcIEEEAC6AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcIEEEAC6AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcIEEEAC6AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcIEEEAC6AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcIEEEAC6AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcIEEEAC6AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcIEEEAC6AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcIEEEAC6AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignThToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignThToExcIEEEAC6AEvent");
    this.th = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignThFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignThFromExcIEEEAC6AEvent");
    this.th = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTjToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignTjToExcIEEEAC6AEvent");
    this.tj = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTjFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignTjFromExcIEEEAC6AEvent");
    this.tj = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTkToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignTkToExcIEEEAC6AEvent");
    this.tk = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTkFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignTkFromExcIEEEAC6AEvent");
    this.tk = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVamaxToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVamaxToExcIEEEAC6AEvent");
    this.vamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVamaxFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVamaxFromExcIEEEAC6AEvent");
    this.vamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaminToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVaminToExcIEEEAC6AEvent");
    this.vamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaminFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVaminFromExcIEEEAC6AEvent");
    this.vamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe1ToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVe1ToExcIEEEAC6AEvent");
    this.ve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe1FromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe1FromExcIEEEAC6AEvent");
    this.ve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe2ToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVe2ToExcIEEEAC6AEvent");
    this.ve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe2FromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe2FromExcIEEEAC6AEvent");
    this.ve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVfelimToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVfelimToExcIEEEAC6AEvent");
    this.vfelim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVfelimFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVfelimFromExcIEEEAC6AEvent");
    this.vfelim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVhmaxToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVhmaxToExcIEEEAC6AEvent");
    this.vhmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVhmaxFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVhmaxFromExcIEEEAC6AEvent");
    this.vhmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEAC6AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEAC6AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEAC6AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEAC6AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEAC6AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEAC6AId;

  private PU ka = null;
  private PU kc = null;
  private PU kd = null;
  private PU ke = null;
  private PU kh = null;
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

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC6AAggregate.class.getName());
}
