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
 * Aggregate handler for ExcAC3A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcAC3A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcAC3AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcAC3AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcAC3AAggregate(CreateExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcAC3ACommand");
    CreateExcAC3AEvent event = new CreateExcAC3AEvent(command.getExcAC3AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcAC3ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcAC3ACommand");
    UpdateExcAC3AEvent event =
        new UpdateExcAC3AEvent(
            command.getExcAC3AId(),
            command.getEfdn(),
            command.getKa(),
            command.getKc(),
            command.getKd(),
            command.getKe(),
            command.getKf(),
            command.getKf1(),
            command.getKf2(),
            command.getKlv(),
            command.getKn(),
            command.getKr(),
            command.getKs(),
            command.getSeve1(),
            command.getSeve2(),
            command.getTa(),
            command.getTb(),
            command.getTc(),
            command.getTe(),
            command.getTf(),
            command.getVamax(),
            command.getVamin(),
            command.getVe1(),
            command.getVe2(),
            command.getVemin(),
            command.getVfemax(),
            command.getVlv());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcAC3ACommand");
    apply(new DeleteExcAC3AEvent(command.getExcAC3AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfdnToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdnToExcAC3ACommand");

    if (efdn != null && efdn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdnToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdnFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdnFromExcAC3ACommand");

    if (efdn == null) throw new ProcessingException("Efdn already has nothing assigned.");

    apply(new UnAssignEfdnFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcAC3ACommand");

    if (ka != null && ka.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignKaToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcAC3ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcAC3ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcAC3ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcAC3ACommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcAC3ACommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcAC3ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcAC3ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcAC3ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcAC3ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKf1ToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKf1ToExcAC3ACommand");

    if (kf1 != null && kf1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKf1ToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKf1FromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKf1FromExcAC3ACommand");

    if (kf1 == null) throw new ProcessingException("Kf1 already has nothing assigned.");

    apply(new UnAssignKf1FromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKf2ToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKf2ToExcAC3ACommand");

    if (kf2 != null && kf2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKf2ToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKf2FromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKf2FromExcAC3ACommand");

    if (kf2 == null) throw new ProcessingException("Kf2 already has nothing assigned.");

    apply(new UnAssignKf2FromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKlvToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKlvToExcAC3ACommand");

    if (klv != null && klv.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Klv already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKlvToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKlvFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKlvFromExcAC3ACommand");

    if (klv == null) throw new ProcessingException("Klv already has nothing assigned.");

    apply(new UnAssignKlvFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKnToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKnToExcAC3ACommand");

    if (kn != null && kn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKnToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKnFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKnFromExcAC3ACommand");

    if (kn == null) throw new ProcessingException("Kn already has nothing assigned.");

    apply(new UnAssignKnFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKrToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKrToExcAC3ACommand");

    if (kr != null && kr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKrToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKrFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKrFromExcAC3ACommand");

    if (kr == null) throw new ProcessingException("Kr already has nothing assigned.");

    apply(new UnAssignKrFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKsToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKsToExcAC3ACommand");

    if (ks != null && ks.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKsToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromExcAC3ACommand");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(new UnAssignKsFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignSeve1ToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve1ToExcAC3ACommand");

    if (seve1 != null && seve1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve1ToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve1FromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve1FromExcAC3ACommand");

    if (seve1 == null) throw new ProcessingException("Seve1 already has nothing assigned.");

    apply(new UnAssignSeve1FromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignSeve2ToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve2ToExcAC3ACommand");

    if (seve2 != null && seve2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve2ToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve2FromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve2FromExcAC3ACommand");

    if (seve2 == null) throw new ProcessingException("Seve2 already has nothing assigned.");

    apply(new UnAssignSeve2FromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcAC3ACommand");

    if (ta != null && ta.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignTaToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcAC3ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcAC3ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcAC3ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcAC3ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcAC3ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcAC3ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcAC3ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcAC3ACommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcAC3ACommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignVamaxToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVamaxToExcAC3ACommand");

    if (vamax != null && vamax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVamaxToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVamaxFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVamaxFromExcAC3ACommand");

    if (vamax == null) throw new ProcessingException("Vamax already has nothing assigned.");

    apply(new UnAssignVamaxFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignVaminToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVaminToExcAC3ACommand");

    if (vamin != null && vamin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVaminToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaminFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaminFromExcAC3ACommand");

    if (vamin == null) throw new ProcessingException("Vamin already has nothing assigned.");

    apply(new UnAssignVaminFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignVe1ToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe1ToExcAC3ACommand");

    if (ve1 != null && ve1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe1ToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe1FromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe1FromExcAC3ACommand");

    if (ve1 == null) throw new ProcessingException("Ve1 already has nothing assigned.");

    apply(new UnAssignVe1FromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignVe2ToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe2ToExcAC3ACommand");

    if (ve2 != null && ve2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe2ToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe2FromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe2FromExcAC3ACommand");

    if (ve2 == null) throw new ProcessingException("Ve2 already has nothing assigned.");

    apply(new UnAssignVe2FromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignVeminToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVeminToExcAC3ACommand");

    if (vemin != null && vemin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vemin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVeminToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVeminFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVeminFromExcAC3ACommand");

    if (vemin == null) throw new ProcessingException("Vemin already has nothing assigned.");

    apply(new UnAssignVeminFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignVfemaxToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVfemaxToExcAC3ACommand");

    if (vfemax != null && vfemax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vfemax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVfemaxToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVfemaxFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVfemaxFromExcAC3ACommand");

    if (vfemax == null) throw new ProcessingException("Vfemax already has nothing assigned.");

    apply(new UnAssignVfemaxFromExcAC3AEvent(command.getExcAC3AId()));
  }

  @CommandHandler
  public void handle(AssignVlvToExcAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVlvToExcAC3ACommand");

    if (vlv != null && vlv.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vlv already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVlvToExcAC3AEvent(command.getExcAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVlvFromExcAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVlvFromExcAC3ACommand");

    if (vlv == null) throw new ProcessingException("Vlv already has nothing assigned.");

    apply(new UnAssignVlvFromExcAC3AEvent(command.getExcAC3AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcAC3AEvent event) {
    LOGGER.info("Event sourcing CreateExcAC3AEvent");
    this.excAC3AId = event.getExcAC3AId();
  }

  @EventSourcingHandler
  void on(UpdateExcAC3AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efdn = event.getEfdn();
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.kd = event.getKd();
    this.ke = event.getKe();
    this.kf = event.getKf();
    this.kf1 = event.getKf1();
    this.kf2 = event.getKf2();
    this.klv = event.getKlv();
    this.kn = event.getKn();
    this.kr = event.getKr();
    this.ks = event.getKs();
    this.seve1 = event.getSeve1();
    this.seve2 = event.getSeve2();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.tc = event.getTc();
    this.te = event.getTe();
    this.tf = event.getTf();
    this.vamax = event.getVamax();
    this.vamin = event.getVamin();
    this.ve1 = event.getVe1();
    this.ve2 = event.getVe2();
    this.vemin = event.getVemin();
    this.vfemax = event.getVfemax();
    this.vlv = event.getVlv();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfdnToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignEfdnToExcAC3AEvent");
    this.efdn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdnFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdnFromExcAC3AEvent");
    this.efdn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcAC3AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcAC3AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcAC3AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcAC3AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcAC3AEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcAC3AEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcAC3AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcAC3AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcAC3AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcAC3AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKf1ToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKf1ToExcAC3AEvent");
    this.kf1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKf1FromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKf1FromExcAC3AEvent");
    this.kf1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKf2ToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKf2ToExcAC3AEvent");
    this.kf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKf2FromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKf2FromExcAC3AEvent");
    this.kf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKlvToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKlvToExcAC3AEvent");
    this.klv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKlvFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKlvFromExcAC3AEvent");
    this.klv = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKnToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKnToExcAC3AEvent");
    this.kn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKnFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKnFromExcAC3AEvent");
    this.kn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKrToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKrToExcAC3AEvent");
    this.kr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKrFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKrFromExcAC3AEvent");
    this.kr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKsToExcAC3AEvent");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKsFromExcAC3AEvent");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve1ToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignSeve1ToExcAC3AEvent");
    this.seve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve1FromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve1FromExcAC3AEvent");
    this.seve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve2ToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignSeve2ToExcAC3AEvent");
    this.seve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve2FromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve2FromExcAC3AEvent");
    this.seve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcAC3AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcAC3AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcAC3AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcAC3AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcAC3AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcAC3AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcAC3AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcAC3AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcAC3AEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcAC3AEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVamaxToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignVamaxToExcAC3AEvent");
    this.vamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVamaxFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVamaxFromExcAC3AEvent");
    this.vamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaminToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignVaminToExcAC3AEvent");
    this.vamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaminFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVaminFromExcAC3AEvent");
    this.vamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe1ToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignVe1ToExcAC3AEvent");
    this.ve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe1FromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe1FromExcAC3AEvent");
    this.ve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe2ToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignVe2ToExcAC3AEvent");
    this.ve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe2FromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe2FromExcAC3AEvent");
    this.ve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVeminToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignVeminToExcAC3AEvent");
    this.vemin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVeminFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVeminFromExcAC3AEvent");
    this.vemin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVfemaxToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignVfemaxToExcAC3AEvent");
    this.vfemax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVfemaxFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVfemaxFromExcAC3AEvent");
    this.vfemax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVlvToExcAC3AEvent event) {
    LOGGER.info("Event sourcing AssignVlvToExcAC3AEvent");
    this.vlv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVlvFromExcAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVlvFromExcAC3AEvent");
    this.vlv = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excAC3AId;

  private PU efdn = null;
  private Seconds ka = null;
  private PU kc = null;
  private PU kd = null;
  private PU ke = null;
  private PU kf = null;
  private PU kf1 = null;
  private PU kf2 = null;
  private PU klv = null;
  private PU kn = null;
  private PU kr = null;
  private PU ks = null;
  private Simple_Float seve1 = null;
  private Simple_Float seve2 = null;
  private PU ta = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private Seconds te = null;
  private Seconds tf = null;
  private PU vamax = null;
  private PU vamin = null;
  private PU ve1 = null;
  private PU ve2 = null;
  private PU vemin = null;
  private PU vfemax = null;
  private PU vlv = null;

  private static final Logger LOGGER = Logger.getLogger(ExcAC3AAggregate.class.getName());
}
