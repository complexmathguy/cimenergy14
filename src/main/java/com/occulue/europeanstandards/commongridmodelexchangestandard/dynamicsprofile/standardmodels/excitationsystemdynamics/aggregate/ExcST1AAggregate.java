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
 * Aggregate handler for ExcST1A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcST1A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcST1AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcST1AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcST1AAggregate(CreateExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcST1ACommand");
    CreateExcST1AEvent event = new CreateExcST1AEvent(command.getExcST1AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcST1ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcST1ACommand");
    UpdateExcST1AEvent event =
        new UpdateExcST1AEvent(
            command.getExcST1AId(),
            command.getIlr(),
            command.getKa(),
            command.getKc(),
            command.getKf(),
            command.getKlr(),
            command.getTa(),
            command.getTb(),
            command.getTb1(),
            command.getTc(),
            command.getTc1(),
            command.getTf(),
            command.getVamax(),
            command.getVamin(),
            command.getVimax(),
            command.getVimin(),
            command.getVrmax(),
            command.getVrmin(),
            command.getXe());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcST1ACommand");
    apply(new DeleteExcST1AEvent(command.getExcST1AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignIlrToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignIlrToExcST1ACommand");

    if (ilr != null && ilr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ilr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIlrToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIlrFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIlrFromExcST1ACommand");

    if (ilr == null) throw new ProcessingException("Ilr already has nothing assigned.");

    apply(new UnAssignIlrFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcST1ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcST1ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcST1ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcST1ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcST1ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcST1ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignKlrToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKlrToExcST1ACommand");

    if (klr != null && klr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Klr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKlrToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKlrFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKlrFromExcST1ACommand");

    if (klr == null) throw new ProcessingException("Klr already has nothing assigned.");

    apply(new UnAssignKlrFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcST1ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcST1ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcST1ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcST1ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignTb1ToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTb1ToExcST1ACommand");

    if (tb1 != null && tb1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTb1ToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTb1FromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTb1FromExcST1ACommand");

    if (tb1 == null) throw new ProcessingException("Tb1 already has nothing assigned.");

    apply(new UnAssignTb1FromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcST1ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcST1ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignTc1ToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTc1ToExcST1ACommand");

    if (tc1 != null && tc1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTc1ToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTc1FromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTc1FromExcST1ACommand");

    if (tc1 == null) throw new ProcessingException("Tc1 already has nothing assigned.");

    apply(new UnAssignTc1FromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcST1ACommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcST1ACommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignVamaxToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVamaxToExcST1ACommand");

    if (vamax != null && vamax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVamaxToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVamaxFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVamaxFromExcST1ACommand");

    if (vamax == null) throw new ProcessingException("Vamax already has nothing assigned.");

    apply(new UnAssignVamaxFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignVaminToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVaminToExcST1ACommand");

    if (vamin != null && vamin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVaminToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaminFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaminFromExcST1ACommand");

    if (vamin == null) throw new ProcessingException("Vamin already has nothing assigned.");

    apply(new UnAssignVaminFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignVimaxToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVimaxToExcST1ACommand");

    if (vimax != null && vimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVimaxToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVimaxFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVimaxFromExcST1ACommand");

    if (vimax == null) throw new ProcessingException("Vimax already has nothing assigned.");

    apply(new UnAssignVimaxFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignViminToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignViminToExcST1ACommand");

    if (vimin != null && vimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignViminToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignViminFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignViminFromExcST1ACommand");

    if (vimin == null) throw new ProcessingException("Vimin already has nothing assigned.");

    apply(new UnAssignViminFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcST1ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcST1ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcST1ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcST1ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcST1AEvent(command.getExcST1AId()));
  }

  @CommandHandler
  public void handle(AssignXeToExcST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignXeToExcST1ACommand");

    if (xe != null && xe.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xe already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignXeToExcST1AEvent(command.getExcST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXeFromExcST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXeFromExcST1ACommand");

    if (xe == null) throw new ProcessingException("Xe already has nothing assigned.");

    apply(new UnAssignXeFromExcST1AEvent(command.getExcST1AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcST1AEvent event) {
    LOGGER.info("Event sourcing CreateExcST1AEvent");
    this.excST1AId = event.getExcST1AId();
  }

  @EventSourcingHandler
  void on(UpdateExcST1AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ilr = event.getIlr();
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.kf = event.getKf();
    this.klr = event.getKlr();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.tb1 = event.getTb1();
    this.tc = event.getTc();
    this.tc1 = event.getTc1();
    this.tf = event.getTf();
    this.vamax = event.getVamax();
    this.vamin = event.getVamin();
    this.vimax = event.getVimax();
    this.vimin = event.getVimin();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
    this.xe = event.getXe();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignIlrToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignIlrToExcST1AEvent");
    this.ilr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIlrFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignIlrFromExcST1AEvent");
    this.ilr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcST1AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcST1AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcST1AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcST1AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcST1AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcST1AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKlrToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignKlrToExcST1AEvent");
    this.klr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKlrFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKlrFromExcST1AEvent");
    this.klr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcST1AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcST1AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcST1AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcST1AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTb1ToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignTb1ToExcST1AEvent");
    this.tb1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTb1FromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTb1FromExcST1AEvent");
    this.tb1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcST1AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcST1AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTc1ToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignTc1ToExcST1AEvent");
    this.tc1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTc1FromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTc1FromExcST1AEvent");
    this.tc1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcST1AEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcST1AEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVamaxToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignVamaxToExcST1AEvent");
    this.vamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVamaxFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVamaxFromExcST1AEvent");
    this.vamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaminToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignVaminToExcST1AEvent");
    this.vamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaminFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVaminFromExcST1AEvent");
    this.vamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVimaxToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignVimaxToExcST1AEvent");
    this.vimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVimaxFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVimaxFromExcST1AEvent");
    this.vimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignViminToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignViminToExcST1AEvent");
    this.vimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignViminFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignViminFromExcST1AEvent");
    this.vimin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcST1AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcST1AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcST1AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcST1AEvent");
    this.vrmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXeToExcST1AEvent event) {
    LOGGER.info("Event sourcing AssignXeToExcST1AEvent");
    this.xe = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXeFromExcST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignXeFromExcST1AEvent");
    this.xe = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excST1AId;

  private PU ilr = null;
  private PU ka = null;
  private PU kc = null;
  private PU kf = null;
  private PU klr = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds tb1 = null;
  private Seconds tc = null;
  private Seconds tc1 = null;
  private Seconds tf = null;
  private PU vamax = null;
  private PU vamin = null;
  private PU vimax = null;
  private PU vimin = null;
  private PU vrmax = null;
  private PU vrmin = null;
  private PU xe = null;

  private static final Logger LOGGER = Logger.getLogger(ExcST1AAggregate.class.getName());
}
