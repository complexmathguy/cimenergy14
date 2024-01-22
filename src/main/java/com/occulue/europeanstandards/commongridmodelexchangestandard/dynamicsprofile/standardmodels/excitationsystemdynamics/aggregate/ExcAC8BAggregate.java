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
 * Aggregate handler for ExcAC8B as outlined for the CQRS pattern, all write responsibilities
 * related to ExcAC8B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcAC8BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcAC8BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcAC8BAggregate(CreateExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcAC8BCommand");
    CreateExcAC8BEvent event = new CreateExcAC8BEvent(command.getExcAC8BId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcAC8BCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcAC8BCommand");
    UpdateExcAC8BEvent event =
        new UpdateExcAC8BEvent(
            command.getExcAC8BId(),
            command.getInlim(),
            command.getKa(),
            command.getKc(),
            command.getKd(),
            command.getKdr(),
            command.getKe(),
            command.getKir(),
            command.getKpr(),
            command.getKs(),
            command.getPidlim(),
            command.getSeve1(),
            command.getSeve2(),
            command.getTa(),
            command.getTdr(),
            command.getTe(),
            command.getTelim(),
            command.getVe1(),
            command.getVe2(),
            command.getVemin(),
            command.getVfemax(),
            command.getVimax(),
            command.getVimin(),
            command.getVpidmax(),
            command.getVpidmin(),
            command.getVrmax(),
            command.getVrmin(),
            command.getVtmult());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcAC8BCommand");
    apply(new DeleteExcAC8BEvent(command.getExcAC8BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignInlimToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignInlimToExcAC8BCommand");

    if (inlim != null && inlim.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Inlim already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignInlimToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignInlimFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignInlimFromExcAC8BCommand");

    if (inlim == null) throw new ProcessingException("Inlim already has nothing assigned.");

    apply(new UnAssignInlimFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcAC8BCommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcAC8BCommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcAC8BCommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcAC8BCommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcAC8BCommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcAC8BCommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignKdrToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdrToExcAC8BCommand");

    if (kdr != null && kdr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kdr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdrToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdrFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdrFromExcAC8BCommand");

    if (kdr == null) throw new ProcessingException("Kdr already has nothing assigned.");

    apply(new UnAssignKdrFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcAC8BCommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcAC8BCommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignKirToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKirToExcAC8BCommand");

    if (kir != null && kir.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kir already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKirToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKirFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKirFromExcAC8BCommand");

    if (kir == null) throw new ProcessingException("Kir already has nothing assigned.");

    apply(new UnAssignKirFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignKprToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKprToExcAC8BCommand");

    if (kpr != null && kpr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKprToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKprFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKprFromExcAC8BCommand");

    if (kpr == null) throw new ProcessingException("Kpr already has nothing assigned.");

    apply(new UnAssignKprFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignKsToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKsToExcAC8BCommand");

    if (ks != null && ks.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKsToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromExcAC8BCommand");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(new UnAssignKsFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignPidlimToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignPidlimToExcAC8BCommand");

    if (pidlim != null && pidlim.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Pidlim already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignPidlimToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPidlimFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPidlimFromExcAC8BCommand");

    if (pidlim == null) throw new ProcessingException("Pidlim already has nothing assigned.");

    apply(new UnAssignPidlimFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignSeve1ToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve1ToExcAC8BCommand");

    if (seve1 != null && seve1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve1ToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve1FromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve1FromExcAC8BCommand");

    if (seve1 == null) throw new ProcessingException("Seve1 already has nothing assigned.");

    apply(new UnAssignSeve1FromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignSeve2ToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve2ToExcAC8BCommand");

    if (seve2 != null && seve2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve2ToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve2FromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve2FromExcAC8BCommand");

    if (seve2 == null) throw new ProcessingException("Seve2 already has nothing assigned.");

    apply(new UnAssignSeve2FromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcAC8BCommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcAC8BCommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignTdrToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTdrToExcAC8BCommand");

    if (tdr != null && tdr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tdr already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdrToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdrFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdrFromExcAC8BCommand");

    if (tdr == null) throw new ProcessingException("Tdr already has nothing assigned.");

    apply(new UnAssignTdrFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcAC8BCommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcAC8BCommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignTelimToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTelimToExcAC8BCommand");

    if (telim != null && telim.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Telim already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignTelimToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTelimFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTelimFromExcAC8BCommand");

    if (telim == null) throw new ProcessingException("Telim already has nothing assigned.");

    apply(new UnAssignTelimFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVe1ToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVe1ToExcAC8BCommand");

    if (ve1 != null && ve1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe1ToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe1FromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe1FromExcAC8BCommand");

    if (ve1 == null) throw new ProcessingException("Ve1 already has nothing assigned.");

    apply(new UnAssignVe1FromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVe2ToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVe2ToExcAC8BCommand");

    if (ve2 != null && ve2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe2ToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe2FromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe2FromExcAC8BCommand");

    if (ve2 == null) throw new ProcessingException("Ve2 already has nothing assigned.");

    apply(new UnAssignVe2FromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVeminToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVeminToExcAC8BCommand");

    if (vemin != null && vemin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vemin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVeminToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVeminFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVeminFromExcAC8BCommand");

    if (vemin == null) throw new ProcessingException("Vemin already has nothing assigned.");

    apply(new UnAssignVeminFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVfemaxToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVfemaxToExcAC8BCommand");

    if (vfemax != null && vfemax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vfemax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVfemaxToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVfemaxFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVfemaxFromExcAC8BCommand");

    if (vfemax == null) throw new ProcessingException("Vfemax already has nothing assigned.");

    apply(new UnAssignVfemaxFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVimaxToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVimaxToExcAC8BCommand");

    if (vimax != null && vimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVimaxToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVimaxFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVimaxFromExcAC8BCommand");

    if (vimax == null) throw new ProcessingException("Vimax already has nothing assigned.");

    apply(new UnAssignVimaxFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignViminToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignViminToExcAC8BCommand");

    if (vimin != null && vimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignViminToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignViminFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignViminFromExcAC8BCommand");

    if (vimin == null) throw new ProcessingException("Vimin already has nothing assigned.");

    apply(new UnAssignViminFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVpidmaxToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVpidmaxToExcAC8BCommand");

    if (vpidmax != null && vpidmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vpidmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVpidmaxToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVpidmaxFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVpidmaxFromExcAC8BCommand");

    if (vpidmax == null) throw new ProcessingException("Vpidmax already has nothing assigned.");

    apply(new UnAssignVpidmaxFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVpidminToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVpidminToExcAC8BCommand");

    if (vpidmin != null && vpidmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vpidmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVpidminToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVpidminFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVpidminFromExcAC8BCommand");

    if (vpidmin == null) throw new ProcessingException("Vpidmin already has nothing assigned.");

    apply(new UnAssignVpidminFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcAC8BCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcAC8BCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcAC8BCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcAC8BCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcAC8BEvent(command.getExcAC8BId()));
  }

  @CommandHandler
  public void handle(AssignVtmultToExcAC8BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVtmultToExcAC8BCommand");

    if (vtmult != null && vtmult.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Vtmult already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignVtmultToExcAC8BEvent(command.getExcAC8BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVtmultFromExcAC8BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVtmultFromExcAC8BCommand");

    if (vtmult == null) throw new ProcessingException("Vtmult already has nothing assigned.");

    apply(new UnAssignVtmultFromExcAC8BEvent(command.getExcAC8BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcAC8BEvent event) {
    LOGGER.info("Event sourcing CreateExcAC8BEvent");
    this.excAC8BId = event.getExcAC8BId();
  }

  @EventSourcingHandler
  void on(UpdateExcAC8BEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.inlim = event.getInlim();
    this.ka = event.getKa();
    this.kc = event.getKc();
    this.kd = event.getKd();
    this.kdr = event.getKdr();
    this.ke = event.getKe();
    this.kir = event.getKir();
    this.kpr = event.getKpr();
    this.ks = event.getKs();
    this.pidlim = event.getPidlim();
    this.seve1 = event.getSeve1();
    this.seve2 = event.getSeve2();
    this.ta = event.getTa();
    this.tdr = event.getTdr();
    this.te = event.getTe();
    this.telim = event.getTelim();
    this.ve1 = event.getVe1();
    this.ve2 = event.getVe2();
    this.vemin = event.getVemin();
    this.vfemax = event.getVfemax();
    this.vimax = event.getVimax();
    this.vimin = event.getVimin();
    this.vpidmax = event.getVpidmax();
    this.vpidmin = event.getVpidmin();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
    this.vtmult = event.getVtmult();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignInlimToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignInlimToExcAC8BEvent");
    this.inlim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignInlimFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignInlimFromExcAC8BEvent");
    this.inlim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcAC8BEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcAC8BEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcAC8BEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcAC8BEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcAC8BEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcAC8BEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdrToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKdrToExcAC8BEvent");
    this.kdr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdrFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKdrFromExcAC8BEvent");
    this.kdr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcAC8BEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcAC8BEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKirToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKirToExcAC8BEvent");
    this.kir = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKirFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKirFromExcAC8BEvent");
    this.kir = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKprToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKprToExcAC8BEvent");
    this.kpr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKprFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKprFromExcAC8BEvent");
    this.kpr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignKsToExcAC8BEvent");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignKsFromExcAC8BEvent");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPidlimToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignPidlimToExcAC8BEvent");
    this.pidlim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPidlimFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignPidlimFromExcAC8BEvent");
    this.pidlim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve1ToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignSeve1ToExcAC8BEvent");
    this.seve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve1FromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve1FromExcAC8BEvent");
    this.seve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve2ToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignSeve2ToExcAC8BEvent");
    this.seve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve2FromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve2FromExcAC8BEvent");
    this.seve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcAC8BEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcAC8BEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdrToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignTdrToExcAC8BEvent");
    this.tdr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdrFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignTdrFromExcAC8BEvent");
    this.tdr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcAC8BEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcAC8BEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTelimToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignTelimToExcAC8BEvent");
    this.telim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTelimFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignTelimFromExcAC8BEvent");
    this.telim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe1ToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVe1ToExcAC8BEvent");
    this.ve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe1FromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVe1FromExcAC8BEvent");
    this.ve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe2ToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVe2ToExcAC8BEvent");
    this.ve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe2FromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVe2FromExcAC8BEvent");
    this.ve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVeminToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVeminToExcAC8BEvent");
    this.vemin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVeminFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVeminFromExcAC8BEvent");
    this.vemin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVfemaxToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVfemaxToExcAC8BEvent");
    this.vfemax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVfemaxFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVfemaxFromExcAC8BEvent");
    this.vfemax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVimaxToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVimaxToExcAC8BEvent");
    this.vimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVimaxFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVimaxFromExcAC8BEvent");
    this.vimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignViminToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignViminToExcAC8BEvent");
    this.vimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignViminFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignViminFromExcAC8BEvent");
    this.vimin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVpidmaxToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVpidmaxToExcAC8BEvent");
    this.vpidmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVpidmaxFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVpidmaxFromExcAC8BEvent");
    this.vpidmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVpidminToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVpidminToExcAC8BEvent");
    this.vpidmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVpidminFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVpidminFromExcAC8BEvent");
    this.vpidmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcAC8BEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcAC8BEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcAC8BEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcAC8BEvent");
    this.vrmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVtmultToExcAC8BEvent event) {
    LOGGER.info("Event sourcing AssignVtmultToExcAC8BEvent");
    this.vtmult = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVtmultFromExcAC8BEvent event) {
    LOGGER.info("Event sourcing UnAssignVtmultFromExcAC8BEvent");
    this.vtmult = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excAC8BId;

  private BooleanProxy inlim = null;
  private PU ka = null;
  private PU kc = null;
  private PU kd = null;
  private PU kdr = null;
  private PU ke = null;
  private PU kir = null;
  private PU kpr = null;
  private PU ks = null;
  private BooleanProxy pidlim = null;
  private Simple_Float seve1 = null;
  private Simple_Float seve2 = null;
  private Seconds ta = null;
  private Seconds tdr = null;
  private Seconds te = null;
  private BooleanProxy telim = null;
  private PU ve1 = null;
  private PU ve2 = null;
  private PU vemin = null;
  private PU vfemax = null;
  private PU vimax = null;
  private PU vimin = null;
  private PU vpidmax = null;
  private PU vpidmin = null;
  private PU vrmax = null;
  private PU vrmin = null;
  private BooleanProxy vtmult = null;

  private static final Logger LOGGER = Logger.getLogger(ExcAC8BAggregate.class.getName());
}
