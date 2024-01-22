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
 * Aggregate handler for ExcIEEEST1A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEST1A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEST1AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEST1AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEST1AAggregate(CreateExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEST1ACommand");
    CreateExcIEEEST1AEvent event =
        new CreateExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getUelin());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEST1ACommand");
    UpdateExcIEEEST1AEvent event =
        new UpdateExcIEEEST1AEvent(
            command.getExcIEEEST1AId(),
            command.getIlr(),
            command.getKa(),
            command.getKc(),
            command.getKf(),
            command.getKlr(),
            command.getPssin(),
            command.getTa(),
            command.getTb(),
            command.getTb1(),
            command.getTc(),
            command.getTc1(),
            command.getTf(),
            command.getUelin(),
            command.getVamax(),
            command.getVamin(),
            command.getVimax(),
            command.getVimin(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEST1ACommand");
    apply(new DeleteExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignIlrToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignIlrToExcIEEEST1ACommand");

    if (ilr != null && ilr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ilr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIlrToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIlrFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIlrFromExcIEEEST1ACommand");

    if (ilr == null) throw new ProcessingException("Ilr already has nothing assigned.");

    apply(new UnAssignIlrFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcIEEEST1ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcIEEEST1ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcIEEEST1ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcIEEEST1ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcIEEEST1ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcIEEEST1ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignKlrToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKlrToExcIEEEST1ACommand");

    if (klr != null && klr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Klr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKlrToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKlrFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKlrFromExcIEEEST1ACommand");

    if (klr == null) throw new ProcessingException("Klr already has nothing assigned.");

    apply(new UnAssignKlrFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignPssinToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignPssinToExcIEEEST1ACommand");

    if (pssin != null && pssin.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Pssin already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignPssinToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPssinFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPssinFromExcIEEEST1ACommand");

    if (pssin == null) throw new ProcessingException("Pssin already has nothing assigned.");

    apply(new UnAssignPssinFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcIEEEST1ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcIEEEST1ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcIEEEST1ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcIEEEST1ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignTb1ToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTb1ToExcIEEEST1ACommand");

    if (tb1 != null && tb1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTb1ToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTb1FromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTb1FromExcIEEEST1ACommand");

    if (tb1 == null) throw new ProcessingException("Tb1 already has nothing assigned.");

    apply(new UnAssignTb1FromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcIEEEST1ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcIEEEST1ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignTc1ToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTc1ToExcIEEEST1ACommand");

    if (tc1 != null && tc1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTc1ToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTc1FromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTc1FromExcIEEEST1ACommand");

    if (tc1 == null) throw new ProcessingException("Tc1 already has nothing assigned.");

    apply(new UnAssignTc1FromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcIEEEST1ACommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcIEEEST1ACommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignVamaxToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVamaxToExcIEEEST1ACommand");

    if (vamax != null && vamax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVamaxToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVamaxFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVamaxFromExcIEEEST1ACommand");

    if (vamax == null) throw new ProcessingException("Vamax already has nothing assigned.");

    apply(new UnAssignVamaxFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignVaminToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVaminToExcIEEEST1ACommand");

    if (vamin != null && vamin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVaminToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaminFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaminFromExcIEEEST1ACommand");

    if (vamin == null) throw new ProcessingException("Vamin already has nothing assigned.");

    apply(new UnAssignVaminFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignVimaxToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVimaxToExcIEEEST1ACommand");

    if (vimax != null && vimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVimaxToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVimaxFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVimaxFromExcIEEEST1ACommand");

    if (vimax == null) throw new ProcessingException("Vimax already has nothing assigned.");

    apply(new UnAssignVimaxFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignViminToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignViminToExcIEEEST1ACommand");

    if (vimin != null && vimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignViminToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignViminFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignViminFromExcIEEEST1ACommand");

    if (vimin == null) throw new ProcessingException("Vimin already has nothing assigned.");

    apply(new UnAssignViminFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEST1ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEST1ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEST1ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEST1AEvent(command.getExcIEEEST1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEST1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEST1ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEST1AEvent(command.getExcIEEEST1AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEST1AEvent");
    this.excIEEEST1AId = event.getExcIEEEST1AId();
    this.uelin = event.getUelin();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ilr = event.getIlr();
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.kf = event.getKf();
    this.klr = event.getKlr();
    this.pssin = event.getPssin();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.tb1 = event.getTb1();
    this.tc = event.getTc();
    this.tc1 = event.getTc1();
    this.tf = event.getTf();
    this.uelin = event.getUelin();
    this.vamax = event.getVamax();
    this.vamin = event.getVamin();
    this.vimax = event.getVimax();
    this.vimin = event.getVimin();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignIlrToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignIlrToExcIEEEST1AEvent");
    this.ilr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIlrFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignIlrFromExcIEEEST1AEvent");
    this.ilr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcIEEEST1AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcIEEEST1AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcIEEEST1AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcIEEEST1AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcIEEEST1AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcIEEEST1AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKlrToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignKlrToExcIEEEST1AEvent");
    this.klr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKlrFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKlrFromExcIEEEST1AEvent");
    this.klr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPssinToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignPssinToExcIEEEST1AEvent");
    this.pssin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPssinFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignPssinFromExcIEEEST1AEvent");
    this.pssin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcIEEEST1AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcIEEEST1AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcIEEEST1AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcIEEEST1AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTb1ToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignTb1ToExcIEEEST1AEvent");
    this.tb1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTb1FromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTb1FromExcIEEEST1AEvent");
    this.tb1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcIEEEST1AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcIEEEST1AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTc1ToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignTc1ToExcIEEEST1AEvent");
    this.tc1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTc1FromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTc1FromExcIEEEST1AEvent");
    this.tc1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcIEEEST1AEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcIEEEST1AEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVamaxToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignVamaxToExcIEEEST1AEvent");
    this.vamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVamaxFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVamaxFromExcIEEEST1AEvent");
    this.vamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaminToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignVaminToExcIEEEST1AEvent");
    this.vamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaminFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVaminFromExcIEEEST1AEvent");
    this.vamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVimaxToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignVimaxToExcIEEEST1AEvent");
    this.vimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVimaxFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVimaxFromExcIEEEST1AEvent");
    this.vimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignViminToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignViminToExcIEEEST1AEvent");
    this.vimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignViminFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignViminFromExcIEEEST1AEvent");
    this.vimin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEST1AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEST1AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEST1AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEST1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEST1AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEST1AId;

  private ExcIEEEST1AUELselectorKind uelin;
  private PU ilr = null;
  private PU ka = null;
  private PU kc = null;
  private PU kf = null;
  private PU klr = null;
  private BooleanProxy pssin = null;
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

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST1AAggregate.class.getName());
}
