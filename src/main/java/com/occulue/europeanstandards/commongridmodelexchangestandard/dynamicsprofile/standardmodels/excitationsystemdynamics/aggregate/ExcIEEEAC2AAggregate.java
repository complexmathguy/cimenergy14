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
 * Aggregate handler for ExcIEEEAC2A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEAC2A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEAC2AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEAC2AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEAC2AAggregate(CreateExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEAC2ACommand");
    CreateExcIEEEAC2AEvent event = new CreateExcIEEEAC2AEvent(command.getExcIEEEAC2AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEAC2ACommand");
    UpdateExcIEEEAC2AEvent event =
        new UpdateExcIEEEAC2AEvent(
            command.getExcIEEEAC2AId(),
            command.getKa(),
            command.getKb(),
            command.getKc(),
            command.getKd(),
            command.getKe(),
            command.getKf(),
            command.getKh(),
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
            command.getVfemax(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEAC2ACommand");
    apply(new DeleteExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKaToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcIEEEAC2ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcIEEEAC2ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKbToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKbToExcIEEEAC2ACommand");

    if (kb != null && kb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKbToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKbFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKbFromExcIEEEAC2ACommand");

    if (kb == null) throw new ProcessingException("Kb already has nothing assigned.");

    apply(new UnAssignKbFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcIEEEAC2ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcIEEEAC2ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcIEEEAC2ACommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcIEEEAC2ACommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcIEEEAC2ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcIEEEAC2ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcIEEEAC2ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcIEEEAC2ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKhToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKhToExcIEEEAC2ACommand");

    if (kh != null && kh.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kh already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKhToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKhFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKhFromExcIEEEAC2ACommand");

    if (kh == null) throw new ProcessingException("Kh already has nothing assigned.");

    apply(new UnAssignKhFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignSeve1ToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve1ToExcIEEEAC2ACommand");

    if (seve1 != null && seve1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve1ToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve1FromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve1FromExcIEEEAC2ACommand");

    if (seve1 == null) throw new ProcessingException("Seve1 already has nothing assigned.");

    apply(new UnAssignSeve1FromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignSeve2ToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve2ToExcIEEEAC2ACommand");

    if (seve2 != null && seve2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve2ToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve2FromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve2FromExcIEEEAC2ACommand");

    if (seve2 == null) throw new ProcessingException("Seve2 already has nothing assigned.");

    apply(new UnAssignSeve2FromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcIEEEAC2ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcIEEEAC2ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcIEEEAC2ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcIEEEAC2ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcIEEEAC2ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcIEEEAC2ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcIEEEAC2ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcIEEEAC2ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcIEEEAC2ACommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcIEEEAC2ACommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVamaxToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVamaxToExcIEEEAC2ACommand");

    if (vamax != null && vamax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVamaxToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVamaxFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVamaxFromExcIEEEAC2ACommand");

    if (vamax == null) throw new ProcessingException("Vamax already has nothing assigned.");

    apply(new UnAssignVamaxFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVaminToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVaminToExcIEEEAC2ACommand");

    if (vamin != null && vamin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVaminToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaminFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaminFromExcIEEEAC2ACommand");

    if (vamin == null) throw new ProcessingException("Vamin already has nothing assigned.");

    apply(new UnAssignVaminFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVe1ToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe1ToExcIEEEAC2ACommand");

    if (ve1 != null && ve1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe1ToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe1FromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe1FromExcIEEEAC2ACommand");

    if (ve1 == null) throw new ProcessingException("Ve1 already has nothing assigned.");

    apply(new UnAssignVe1FromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVe2ToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe2ToExcIEEEAC2ACommand");

    if (ve2 != null && ve2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe2ToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe2FromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe2FromExcIEEEAC2ACommand");

    if (ve2 == null) throw new ProcessingException("Ve2 already has nothing assigned.");

    apply(new UnAssignVe2FromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVfemaxToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVfemaxToExcIEEEAC2ACommand");

    if (vfemax != null && vfemax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vfemax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVfemaxToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVfemaxFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVfemaxFromExcIEEEAC2ACommand");

    if (vfemax == null) throw new ProcessingException("Vfemax already has nothing assigned.");

    apply(new UnAssignVfemaxFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEAC2ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEAC2ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEAC2ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEAC2AEvent(command.getExcIEEEAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEAC2ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEAC2AEvent(command.getExcIEEEAC2AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEAC2AEvent");
    this.excIEEEAC2AId = event.getExcIEEEAC2AId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ka = event.getKa();
    this.kb = event.getKb();
    this.kc = event.getKc();
    this.kd = event.getKd();
    this.ke = event.getKe();
    this.kf = event.getKf();
    this.kh = event.getKh();
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
    this.vfemax = event.getVfemax();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcIEEEAC2AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcIEEEAC2AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKbToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKbToExcIEEEAC2AEvent");
    this.kb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKbFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKbFromExcIEEEAC2AEvent");
    this.kb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcIEEEAC2AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcIEEEAC2AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcIEEEAC2AEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcIEEEAC2AEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcIEEEAC2AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcIEEEAC2AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcIEEEAC2AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcIEEEAC2AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKhToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKhToExcIEEEAC2AEvent");
    this.kh = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKhFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKhFromExcIEEEAC2AEvent");
    this.kh = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve1ToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignSeve1ToExcIEEEAC2AEvent");
    this.seve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve1FromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve1FromExcIEEEAC2AEvent");
    this.seve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve2ToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignSeve2ToExcIEEEAC2AEvent");
    this.seve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve2FromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve2FromExcIEEEAC2AEvent");
    this.seve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcIEEEAC2AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcIEEEAC2AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcIEEEAC2AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcIEEEAC2AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcIEEEAC2AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcIEEEAC2AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcIEEEAC2AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcIEEEAC2AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcIEEEAC2AEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcIEEEAC2AEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVamaxToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVamaxToExcIEEEAC2AEvent");
    this.vamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVamaxFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVamaxFromExcIEEEAC2AEvent");
    this.vamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaminToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVaminToExcIEEEAC2AEvent");
    this.vamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaminFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVaminFromExcIEEEAC2AEvent");
    this.vamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe1ToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVe1ToExcIEEEAC2AEvent");
    this.ve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe1FromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe1FromExcIEEEAC2AEvent");
    this.ve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe2ToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVe2ToExcIEEEAC2AEvent");
    this.ve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe2FromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe2FromExcIEEEAC2AEvent");
    this.ve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVfemaxToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVfemaxToExcIEEEAC2AEvent");
    this.vfemax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVfemaxFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVfemaxFromExcIEEEAC2AEvent");
    this.vfemax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEAC2AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEAC2AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEAC2AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEAC2AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEAC2AId;

  private PU ka = null;
  private PU kb = null;
  private PU kc = null;
  private PU kd = null;
  private PU ke = null;
  private PU kf = null;
  private PU kh = null;
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
  private PU vfemax = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC2AAggregate.class.getName());
}
