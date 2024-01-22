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
 * Aggregate handler for ExcIEEEAC1A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEAC1A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEAC1AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEAC1AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEAC1AAggregate(CreateExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEAC1ACommand");
    CreateExcIEEEAC1AEvent event = new CreateExcIEEEAC1AEvent(command.getExcIEEEAC1AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEAC1ACommand");
    UpdateExcIEEEAC1AEvent event =
        new UpdateExcIEEEAC1AEvent(
            command.getExcIEEEAC1AId(),
            command.getKa(),
            command.getKc(),
            command.getKd(),
            command.getKe(),
            command.getKf(),
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
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEAC1ACommand");
    apply(new DeleteExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKaToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcIEEEAC1ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcIEEEAC1ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcIEEEAC1ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcIEEEAC1ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcIEEEAC1ACommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcIEEEAC1ACommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcIEEEAC1ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcIEEEAC1ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcIEEEAC1ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcIEEEAC1ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignSeve1ToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve1ToExcIEEEAC1ACommand");

    if (seve1 != null && seve1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve1ToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve1FromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve1FromExcIEEEAC1ACommand");

    if (seve1 == null) throw new ProcessingException("Seve1 already has nothing assigned.");

    apply(new UnAssignSeve1FromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignSeve2ToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve2ToExcIEEEAC1ACommand");

    if (seve2 != null && seve2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve2ToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve2FromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve2FromExcIEEEAC1ACommand");

    if (seve2 == null) throw new ProcessingException("Seve2 already has nothing assigned.");

    apply(new UnAssignSeve2FromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcIEEEAC1ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcIEEEAC1ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcIEEEAC1ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcIEEEAC1ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcIEEEAC1ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcIEEEAC1ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcIEEEAC1ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcIEEEAC1ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcIEEEAC1ACommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcIEEEAC1ACommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignVamaxToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVamaxToExcIEEEAC1ACommand");

    if (vamax != null && vamax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVamaxToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVamaxFromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVamaxFromExcIEEEAC1ACommand");

    if (vamax == null) throw new ProcessingException("Vamax already has nothing assigned.");

    apply(new UnAssignVamaxFromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignVaminToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVaminToExcIEEEAC1ACommand");

    if (vamin != null && vamin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVaminToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaminFromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaminFromExcIEEEAC1ACommand");

    if (vamin == null) throw new ProcessingException("Vamin already has nothing assigned.");

    apply(new UnAssignVaminFromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignVe1ToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe1ToExcIEEEAC1ACommand");

    if (ve1 != null && ve1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe1ToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe1FromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe1FromExcIEEEAC1ACommand");

    if (ve1 == null) throw new ProcessingException("Ve1 already has nothing assigned.");

    apply(new UnAssignVe1FromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignVe2ToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe2ToExcIEEEAC1ACommand");

    if (ve2 != null && ve2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe2ToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe2FromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe2FromExcIEEEAC1ACommand");

    if (ve2 == null) throw new ProcessingException("Ve2 already has nothing assigned.");

    apply(new UnAssignVe2FromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEAC1ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEAC1ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEAC1ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEAC1ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEAC1AEvent");
    this.excIEEEAC1AId = event.getExcIEEEAC1AId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.kd = event.getKd();
    this.ke = event.getKe();
    this.kf = event.getKf();
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
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcIEEEAC1AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcIEEEAC1AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcIEEEAC1AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcIEEEAC1AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcIEEEAC1AEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcIEEEAC1AEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcIEEEAC1AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcIEEEAC1AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcIEEEAC1AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcIEEEAC1AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve1ToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignSeve1ToExcIEEEAC1AEvent");
    this.seve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve1FromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve1FromExcIEEEAC1AEvent");
    this.seve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve2ToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignSeve2ToExcIEEEAC1AEvent");
    this.seve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve2FromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve2FromExcIEEEAC1AEvent");
    this.seve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcIEEEAC1AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcIEEEAC1AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcIEEEAC1AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcIEEEAC1AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcIEEEAC1AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcIEEEAC1AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcIEEEAC1AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcIEEEAC1AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcIEEEAC1AEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcIEEEAC1AEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVamaxToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignVamaxToExcIEEEAC1AEvent");
    this.vamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVamaxFromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVamaxFromExcIEEEAC1AEvent");
    this.vamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaminToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignVaminToExcIEEEAC1AEvent");
    this.vamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaminFromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVaminFromExcIEEEAC1AEvent");
    this.vamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe1ToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignVe1ToExcIEEEAC1AEvent");
    this.ve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe1FromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe1FromExcIEEEAC1AEvent");
    this.ve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe2ToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignVe2ToExcIEEEAC1AEvent");
    this.ve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe2FromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe2FromExcIEEEAC1AEvent");
    this.ve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEAC1AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEAC1AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEAC1AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEAC1AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEAC1AId;

  private PU ka = null;
  private PU kc = null;
  private PU kd = null;
  private PU ke = null;
  private PU kf = null;
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
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC1AAggregate.class.getName());
}
