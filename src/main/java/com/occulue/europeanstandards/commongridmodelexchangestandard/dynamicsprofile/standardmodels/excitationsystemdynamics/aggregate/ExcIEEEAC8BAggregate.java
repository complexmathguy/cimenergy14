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
 * Aggregate handler for ExcIEEEAC8B as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEAC8B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEAC8BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEAC8BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEAC8BAggregate(CreateExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEAC8BCommand");
    CreateExcIEEEAC8BEvent event = new CreateExcIEEEAC8BEvent(command.getExcIEEEAC8BId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEAC8BCommand");
    UpdateExcIEEEAC8BEvent event =
        new UpdateExcIEEEAC8BEvent(
            command.getExcIEEEAC8BId(),
            command.getKa(),
            command.getKc(),
            command.getKd(),
            command.getKdr(),
            command.getKe(),
            command.getKir(),
            command.getKpr(),
            command.getSeve1(),
            command.getSeve2(),
            command.getTa(),
            command.getTdr(),
            command.getTe(),
            command.getVe1(),
            command.getVe2(),
            command.getVemin(),
            command.getVfemax(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEAC8BCommand");
    apply(new DeleteExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKaToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcIEEEAC8BCommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcIEEEAC8BCommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcIEEEAC8BCommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcIEEEAC8BCommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcIEEEAC8BCommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcIEEEAC8BCommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignKdrToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdrToExcIEEEAC8BCommand");

    if (kdr != null && kdr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kdr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdrToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdrFromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdrFromExcIEEEAC8BCommand");

    if (kdr == null) throw new ProcessingException("Kdr already has nothing assigned.");

    apply(new UnAssignKdrFromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcIEEEAC8BCommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcIEEEAC8BCommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignKirToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKirToExcIEEEAC8BCommand");

    if (kir != null && kir.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kir already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKirToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKirFromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKirFromExcIEEEAC8BCommand");

    if (kir == null) throw new ProcessingException("Kir already has nothing assigned.");

    apply(new UnAssignKirFromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignKprToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKprToExcIEEEAC8BCommand");

    if (kpr != null && kpr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKprToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKprFromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKprFromExcIEEEAC8BCommand");

    if (kpr == null) throw new ProcessingException("Kpr already has nothing assigned.");

    apply(new UnAssignKprFromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignSeve1ToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve1ToExcIEEEAC8BCommand");

    if (seve1 != null && seve1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve1ToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve1FromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve1FromExcIEEEAC8BCommand");

    if (seve1 == null) throw new ProcessingException("Seve1 already has nothing assigned.");

    apply(new UnAssignSeve1FromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignSeve2ToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve2ToExcIEEEAC8BCommand");

    if (seve2 != null && seve2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve2ToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve2FromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve2FromExcIEEEAC8BCommand");

    if (seve2 == null) throw new ProcessingException("Seve2 already has nothing assigned.");

    apply(new UnAssignSeve2FromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcIEEEAC8BCommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcIEEEAC8BCommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignTdrToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTdrToExcIEEEAC8BCommand");

    if (tdr != null && tdr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tdr already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdrToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdrFromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdrFromExcIEEEAC8BCommand");

    if (tdr == null) throw new ProcessingException("Tdr already has nothing assigned.");

    apply(new UnAssignTdrFromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcIEEEAC8BCommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcIEEEAC8BCommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVe1ToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVe1ToExcIEEEAC8BCommand");

    if (ve1 != null && ve1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe1ToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe1FromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe1FromExcIEEEAC8BCommand");

    if (ve1 == null) throw new ProcessingException("Ve1 already has nothing assigned.");

    apply(new UnAssignVe1FromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVe2ToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVe2ToExcIEEEAC8BCommand");

    if (ve2 != null && ve2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe2ToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe2FromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe2FromExcIEEEAC8BCommand");

    if (ve2 == null) throw new ProcessingException("Ve2 already has nothing assigned.");

    apply(new UnAssignVe2FromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVeminToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVeminToExcIEEEAC8BCommand");

    if (vemin != null && vemin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vemin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVeminToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVeminFromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVeminFromExcIEEEAC8BCommand");

    if (vemin == null) throw new ProcessingException("Vemin already has nothing assigned.");

    apply(new UnAssignVeminFromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVfemaxToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVfemaxToExcIEEEAC8BCommand");

    if (vfemax != null && vfemax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vfemax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVfemaxToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVfemaxFromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVfemaxFromExcIEEEAC8BCommand");

    if (vfemax == null) throw new ProcessingException("Vfemax already has nothing assigned.");

    apply(new UnAssignVfemaxFromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEAC8BCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEAC8BCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEAC8BCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEAC8BCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEAC8BEvent");
    this.excIEEEAC8BId = event.getExcIEEEAC8BId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.kd = event.getKd();
    this.kdr = event.getKdr();
    this.ke = event.getKe();
    this.kir = event.getKir();
    this.kpr = event.getKpr();
    this.seve1 = event.getSeve1();
    this.seve2 = event.getSeve2();
    this.ta = event.getTa();
    this.tdr = event.getTdr();
    this.te = event.getTe();
    this.ve1 = event.getVe1();
    this.ve2 = event.getVe2();
    this.vemin = event.getVemin();
    this.vfemax = event.getVfemax();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcIEEEAC8BEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcIEEEAC8BEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcIEEEAC8BEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcIEEEAC8BEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcIEEEAC8BEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcIEEEAC8BEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdrToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKdrToExcIEEEAC8BEvent");
    this.kdr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdrFromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKdrFromExcIEEEAC8BEvent");
    this.kdr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcIEEEAC8BEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcIEEEAC8BEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKirToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKirToExcIEEEAC8BEvent");
    this.kir = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKirFromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKirFromExcIEEEAC8BEvent");
    this.kir = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKprToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKprToExcIEEEAC8BEvent");
    this.kpr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKprFromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKprFromExcIEEEAC8BEvent");
    this.kpr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve1ToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignSeve1ToExcIEEEAC8BEvent");
    this.seve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve1FromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve1FromExcIEEEAC8BEvent");
    this.seve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve2ToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignSeve2ToExcIEEEAC8BEvent");
    this.seve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve2FromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve2FromExcIEEEAC8BEvent");
    this.seve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcIEEEAC8BEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcIEEEAC8BEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdrToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignTdrToExcIEEEAC8BEvent");
    this.tdr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdrFromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignTdrFromExcIEEEAC8BEvent");
    this.tdr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcIEEEAC8BEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcIEEEAC8BEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe1ToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVe1ToExcIEEEAC8BEvent");
    this.ve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe1FromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVe1FromExcIEEEAC8BEvent");
    this.ve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe2ToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVe2ToExcIEEEAC8BEvent");
    this.ve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe2FromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVe2FromExcIEEEAC8BEvent");
    this.ve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVeminToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVeminToExcIEEEAC8BEvent");
    this.vemin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVeminFromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVeminFromExcIEEEAC8BEvent");
    this.vemin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVfemaxToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVfemaxToExcIEEEAC8BEvent");
    this.vfemax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVfemaxFromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVfemaxFromExcIEEEAC8BEvent");
    this.vfemax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEAC8BEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEAC8BEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEAC8BEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEAC8BEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEAC8BId;

  private PU ka = null;
  private PU kc = null;
  private PU kd = null;
  private PU kdr = null;
  private PU ke = null;
  private PU kir = null;
  private PU kpr = null;
  private Simple_Float seve1 = null;
  private Simple_Float seve2 = null;
  private Seconds ta = null;
  private Seconds tdr = null;
  private Seconds te = null;
  private PU ve1 = null;
  private PU ve2 = null;
  private PU vemin = null;
  private PU vfemax = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC8BAggregate.class.getName());
}
