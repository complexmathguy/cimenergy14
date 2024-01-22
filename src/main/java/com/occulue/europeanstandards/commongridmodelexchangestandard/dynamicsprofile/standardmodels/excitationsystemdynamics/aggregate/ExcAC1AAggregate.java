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
 * Aggregate handler for ExcAC1A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcAC1A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcAC1AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcAC1AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcAC1AAggregate(CreateExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcAC1ACommand");
    CreateExcAC1AEvent event = new CreateExcAC1AEvent(command.getExcAC1AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcAC1ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcAC1ACommand");
    UpdateExcAC1AEvent event =
        new UpdateExcAC1AEvent(
            command.getExcAC1AId(),
            command.getHvlvgates(),
            command.getKa(),
            command.getKc(),
            command.getKd(),
            command.getKe(),
            command.getKf(),
            command.getKf1(),
            command.getKf2(),
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
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcAC1ACommand");
    apply(new DeleteExcAC1AEvent(command.getExcAC1AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignHvlvgatesToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignHvlvgatesToExcAC1ACommand");

    if (hvlvgates != null
        && hvlvgates.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Hvlvgates already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignHvlvgatesToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHvlvgatesFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignHvlvgatesFromExcAC1ACommand");

    if (hvlvgates == null) throw new ProcessingException("Hvlvgates already has nothing assigned.");

    apply(new UnAssignHvlvgatesFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcAC1ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcAC1ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcAC1ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcAC1ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcAC1ACommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcAC1ACommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcAC1ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcAC1ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcAC1ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcAC1ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignKf1ToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKf1ToExcAC1ACommand");

    if (kf1 != null && kf1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKf1ToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKf1FromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKf1FromExcAC1ACommand");

    if (kf1 == null) throw new ProcessingException("Kf1 already has nothing assigned.");

    apply(new UnAssignKf1FromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignKf2ToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKf2ToExcAC1ACommand");

    if (kf2 != null && kf2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKf2ToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKf2FromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKf2FromExcAC1ACommand");

    if (kf2 == null) throw new ProcessingException("Kf2 already has nothing assigned.");

    apply(new UnAssignKf2FromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignKsToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKsToExcAC1ACommand");

    if (ks != null && ks.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKsToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromExcAC1ACommand");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(new UnAssignKsFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignSeve1ToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve1ToExcAC1ACommand");

    if (seve1 != null && seve1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve1ToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve1FromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve1FromExcAC1ACommand");

    if (seve1 == null) throw new ProcessingException("Seve1 already has nothing assigned.");

    apply(new UnAssignSeve1FromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignSeve2ToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve2ToExcAC1ACommand");

    if (seve2 != null && seve2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve2ToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve2FromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve2FromExcAC1ACommand");

    if (seve2 == null) throw new ProcessingException("Seve2 already has nothing assigned.");

    apply(new UnAssignSeve2FromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcAC1ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcAC1ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcAC1ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcAC1ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcAC1ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcAC1ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcAC1ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcAC1ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcAC1ACommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcAC1ACommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignVamaxToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVamaxToExcAC1ACommand");

    if (vamax != null && vamax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVamaxToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVamaxFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVamaxFromExcAC1ACommand");

    if (vamax == null) throw new ProcessingException("Vamax already has nothing assigned.");

    apply(new UnAssignVamaxFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignVaminToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVaminToExcAC1ACommand");

    if (vamin != null && vamin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVaminToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaminFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaminFromExcAC1ACommand");

    if (vamin == null) throw new ProcessingException("Vamin already has nothing assigned.");

    apply(new UnAssignVaminFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignVe1ToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe1ToExcAC1ACommand");

    if (ve1 != null && ve1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe1ToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe1FromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe1FromExcAC1ACommand");

    if (ve1 == null) throw new ProcessingException("Ve1 already has nothing assigned.");

    apply(new UnAssignVe1FromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignVe2ToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe2ToExcAC1ACommand");

    if (ve2 != null && ve2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe2ToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe2FromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe2FromExcAC1ACommand");

    if (ve2 == null) throw new ProcessingException("Ve2 already has nothing assigned.");

    apply(new UnAssignVe2FromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcAC1ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcAC1ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcAC1AEvent(command.getExcAC1AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcAC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcAC1ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcAC1AEvent(command.getExcAC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcAC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcAC1ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcAC1AEvent(command.getExcAC1AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcAC1AEvent event) {
    LOGGER.info("Event sourcing CreateExcAC1AEvent");
    this.excAC1AId = event.getExcAC1AId();
  }

  @EventSourcingHandler
  void on(UpdateExcAC1AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.hvlvgates = event.getHvlvgates();
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.kd = event.getKd();
    this.ke = event.getKe();
    this.kf = event.getKf();
    this.kf1 = event.getKf1();
    this.kf2 = event.getKf2();
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
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignHvlvgatesToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignHvlvgatesToExcAC1AEvent");
    this.hvlvgates = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHvlvgatesFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignHvlvgatesFromExcAC1AEvent");
    this.hvlvgates = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcAC1AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcAC1AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcAC1AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcAC1AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcAC1AEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcAC1AEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcAC1AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcAC1AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcAC1AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcAC1AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKf1ToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignKf1ToExcAC1AEvent");
    this.kf1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKf1FromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKf1FromExcAC1AEvent");
    this.kf1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKf2ToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignKf2ToExcAC1AEvent");
    this.kf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKf2FromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKf2FromExcAC1AEvent");
    this.kf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignKsToExcAC1AEvent");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKsFromExcAC1AEvent");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve1ToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignSeve1ToExcAC1AEvent");
    this.seve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve1FromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve1FromExcAC1AEvent");
    this.seve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve2ToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignSeve2ToExcAC1AEvent");
    this.seve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve2FromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve2FromExcAC1AEvent");
    this.seve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcAC1AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcAC1AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcAC1AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcAC1AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcAC1AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcAC1AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcAC1AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcAC1AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcAC1AEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcAC1AEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVamaxToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignVamaxToExcAC1AEvent");
    this.vamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVamaxFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVamaxFromExcAC1AEvent");
    this.vamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaminToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignVaminToExcAC1AEvent");
    this.vamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaminFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVaminFromExcAC1AEvent");
    this.vamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe1ToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignVe1ToExcAC1AEvent");
    this.ve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe1FromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe1FromExcAC1AEvent");
    this.ve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe2ToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignVe2ToExcAC1AEvent");
    this.ve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe2FromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe2FromExcAC1AEvent");
    this.ve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcAC1AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcAC1AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcAC1AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcAC1AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcAC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcAC1AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excAC1AId;

  private BooleanProxy hvlvgates = null;
  private PU ka = null;
  private PU kc = null;
  private PU kd = null;
  private PU ke = null;
  private PU kf = null;
  private PU kf1 = null;
  private PU kf2 = null;
  private PU ks = null;
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

  private static final Logger LOGGER = Logger.getLogger(ExcAC1AAggregate.class.getName());
}
