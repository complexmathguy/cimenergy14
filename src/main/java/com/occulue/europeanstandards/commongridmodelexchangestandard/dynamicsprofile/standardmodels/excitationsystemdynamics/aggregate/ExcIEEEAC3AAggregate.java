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
 * Aggregate handler for ExcIEEEAC3A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEAC3A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEAC3AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEAC3AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEAC3AAggregate(CreateExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEAC3ACommand");
    CreateExcIEEEAC3AEvent event = new CreateExcIEEEAC3AEvent(command.getExcIEEEAC3AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEAC3ACommand");
    UpdateExcIEEEAC3AEvent event =
        new UpdateExcIEEEAC3AEvent(
            command.getExcIEEEAC3AId(),
            command.getEfdn(),
            command.getKa(),
            command.getKc(),
            command.getKd(),
            command.getKe(),
            command.getKf(),
            command.getKn(),
            command.getKr(),
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
            command.getVfemax());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEAC3ACommand");
    apply(new DeleteExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfdnToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdnToExcIEEEAC3ACommand");

    if (efdn != null && efdn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdnToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdnFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdnFromExcIEEEAC3ACommand");

    if (efdn == null) throw new ProcessingException("Efdn already has nothing assigned.");

    apply(new UnAssignEfdnFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcIEEEAC3ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcIEEEAC3ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcIEEEAC3ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcIEEEAC3ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcIEEEAC3ACommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcIEEEAC3ACommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcIEEEAC3ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcIEEEAC3ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcIEEEAC3ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcIEEEAC3ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKnToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKnToExcIEEEAC3ACommand");

    if (kn != null && kn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKnToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKnFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKnFromExcIEEEAC3ACommand");

    if (kn == null) throw new ProcessingException("Kn already has nothing assigned.");

    apply(new UnAssignKnFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignKrToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKrToExcIEEEAC3ACommand");

    if (kr != null && kr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKrToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKrFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKrFromExcIEEEAC3ACommand");

    if (kr == null) throw new ProcessingException("Kr already has nothing assigned.");

    apply(new UnAssignKrFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignSeve1ToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve1ToExcIEEEAC3ACommand");

    if (seve1 != null && seve1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve1ToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve1FromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve1FromExcIEEEAC3ACommand");

    if (seve1 == null) throw new ProcessingException("Seve1 already has nothing assigned.");

    apply(new UnAssignSeve1FromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignSeve2ToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve2ToExcIEEEAC3ACommand");

    if (seve2 != null && seve2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve2ToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve2FromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve2FromExcIEEEAC3ACommand");

    if (seve2 == null) throw new ProcessingException("Seve2 already has nothing assigned.");

    apply(new UnAssignSeve2FromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcIEEEAC3ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcIEEEAC3ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcIEEEAC3ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcIEEEAC3ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcIEEEAC3ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcIEEEAC3ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcIEEEAC3ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcIEEEAC3ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcIEEEAC3ACommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcIEEEAC3ACommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignVamaxToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVamaxToExcIEEEAC3ACommand");

    if (vamax != null && vamax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVamaxToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVamaxFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVamaxFromExcIEEEAC3ACommand");

    if (vamax == null) throw new ProcessingException("Vamax already has nothing assigned.");

    apply(new UnAssignVamaxFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignVaminToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVaminToExcIEEEAC3ACommand");

    if (vamin != null && vamin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVaminToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaminFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaminFromExcIEEEAC3ACommand");

    if (vamin == null) throw new ProcessingException("Vamin already has nothing assigned.");

    apply(new UnAssignVaminFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignVe1ToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe1ToExcIEEEAC3ACommand");

    if (ve1 != null && ve1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe1ToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe1FromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe1FromExcIEEEAC3ACommand");

    if (ve1 == null) throw new ProcessingException("Ve1 already has nothing assigned.");

    apply(new UnAssignVe1FromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignVe2ToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe2ToExcIEEEAC3ACommand");

    if (ve2 != null && ve2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe2ToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe2FromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe2FromExcIEEEAC3ACommand");

    if (ve2 == null) throw new ProcessingException("Ve2 already has nothing assigned.");

    apply(new UnAssignVe2FromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignVeminToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVeminToExcIEEEAC3ACommand");

    if (vemin != null && vemin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vemin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVeminToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVeminFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVeminFromExcIEEEAC3ACommand");

    if (vemin == null) throw new ProcessingException("Vemin already has nothing assigned.");

    apply(new UnAssignVeminFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  @CommandHandler
  public void handle(AssignVfemaxToExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVfemaxToExcIEEEAC3ACommand");

    if (vfemax != null && vfemax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vfemax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVfemaxToExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVfemaxFromExcIEEEAC3ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVfemaxFromExcIEEEAC3ACommand");

    if (vfemax == null) throw new ProcessingException("Vfemax already has nothing assigned.");

    apply(new UnAssignVfemaxFromExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEAC3AEvent");
    this.excIEEEAC3AId = event.getExcIEEEAC3AId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efdn = event.getEfdn();
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.kd = event.getKd();
    this.ke = event.getKe();
    this.kf = event.getKf();
    this.kn = event.getKn();
    this.kr = event.getKr();
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
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfdnToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignEfdnToExcIEEEAC3AEvent");
    this.efdn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdnFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdnFromExcIEEEAC3AEvent");
    this.efdn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcIEEEAC3AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcIEEEAC3AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcIEEEAC3AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcIEEEAC3AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcIEEEAC3AEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcIEEEAC3AEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcIEEEAC3AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcIEEEAC3AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcIEEEAC3AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcIEEEAC3AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKnToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKnToExcIEEEAC3AEvent");
    this.kn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKnFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKnFromExcIEEEAC3AEvent");
    this.kn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKrToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignKrToExcIEEEAC3AEvent");
    this.kr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKrFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignKrFromExcIEEEAC3AEvent");
    this.kr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve1ToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignSeve1ToExcIEEEAC3AEvent");
    this.seve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve1FromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve1FromExcIEEEAC3AEvent");
    this.seve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve2ToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignSeve2ToExcIEEEAC3AEvent");
    this.seve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve2FromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve2FromExcIEEEAC3AEvent");
    this.seve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcIEEEAC3AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcIEEEAC3AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcIEEEAC3AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcIEEEAC3AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcIEEEAC3AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcIEEEAC3AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcIEEEAC3AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcIEEEAC3AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcIEEEAC3AEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcIEEEAC3AEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVamaxToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignVamaxToExcIEEEAC3AEvent");
    this.vamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVamaxFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVamaxFromExcIEEEAC3AEvent");
    this.vamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaminToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignVaminToExcIEEEAC3AEvent");
    this.vamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaminFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVaminFromExcIEEEAC3AEvent");
    this.vamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe1ToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignVe1ToExcIEEEAC3AEvent");
    this.ve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe1FromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe1FromExcIEEEAC3AEvent");
    this.ve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe2ToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignVe2ToExcIEEEAC3AEvent");
    this.ve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe2FromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe2FromExcIEEEAC3AEvent");
    this.ve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVeminToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignVeminToExcIEEEAC3AEvent");
    this.vemin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVeminFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVeminFromExcIEEEAC3AEvent");
    this.vemin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVfemaxToExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing AssignVfemaxToExcIEEEAC3AEvent");
    this.vfemax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVfemaxFromExcIEEEAC3AEvent event) {
    LOGGER.info("Event sourcing UnAssignVfemaxFromExcIEEEAC3AEvent");
    this.vfemax = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEAC3AId;

  private PU efdn = null;
  private PU ka = null;
  private PU kc = null;
  private PU kd = null;
  private PU ke = null;
  private PU kf = null;
  private PU kn = null;
  private PU kr = null;
  private Simple_Float seve1 = null;
  private Simple_Float seve2 = null;
  private Seconds ta = null;
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

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC3AAggregate.class.getName());
}
