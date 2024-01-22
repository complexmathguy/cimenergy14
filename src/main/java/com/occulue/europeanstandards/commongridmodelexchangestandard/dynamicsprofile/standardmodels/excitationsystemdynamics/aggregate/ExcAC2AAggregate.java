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
 * Aggregate handler for ExcAC2A as outlined for the CQRS pattern, all write responsibilities
 * related to ExcAC2A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcAC2AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcAC2AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcAC2AAggregate(CreateExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command CreateExcAC2ACommand");
    CreateExcAC2AEvent event = new CreateExcAC2AEvent(command.getExcAC2AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcAC2ACommand command) throws Exception {
    LOGGER.info("handling command UpdateExcAC2ACommand");
    UpdateExcAC2AEvent event =
        new UpdateExcAC2AEvent(
            command.getExcAC2AId(),
            command.getHvgate(),
            command.getKa(),
            command.getKb(),
            command.getKb1(),
            command.getKc(),
            command.getKd(),
            command.getKe(),
            command.getKf(),
            command.getKh(),
            command.getKl(),
            command.getKl1(),
            command.getKs(),
            command.getLvgate(),
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
            command.getVlr(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcAC2ACommand");
    apply(new DeleteExcAC2AEvent(command.getExcAC2AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignHvgateToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignHvgateToExcAC2ACommand");

    if (hvgate != null && hvgate.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Hvgate already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignHvgateToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHvgateFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignHvgateFromExcAC2ACommand");

    if (hvgate == null) throw new ProcessingException("Hvgate already has nothing assigned.");

    apply(new UnAssignHvgateFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKaToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcAC2ACommand");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcAC2ACommand");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKbToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKbToExcAC2ACommand");

    if (kb != null && kb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKbToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKbFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKbFromExcAC2ACommand");

    if (kb == null) throw new ProcessingException("Kb already has nothing assigned.");

    apply(new UnAssignKbFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKb1ToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKb1ToExcAC2ACommand");

    if (kb1 != null && kb1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kb1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKb1ToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKb1FromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKb1FromExcAC2ACommand");

    if (kb1 == null) throw new ProcessingException("Kb1 already has nothing assigned.");

    apply(new UnAssignKb1FromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcAC2ACommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcAC2ACommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcAC2ACommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcAC2ACommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcAC2ACommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcAC2ACommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcAC2ACommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcAC2ACommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKhToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKhToExcAC2ACommand");

    if (kh != null && kh.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kh already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKhToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKhFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKhFromExcAC2ACommand");

    if (kh == null) throw new ProcessingException("Kh already has nothing assigned.");

    apply(new UnAssignKhFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKlToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKlToExcAC2ACommand");

    if (kl != null && kl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKlToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKlFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKlFromExcAC2ACommand");

    if (kl == null) throw new ProcessingException("Kl already has nothing assigned.");

    apply(new UnAssignKlFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKl1ToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKl1ToExcAC2ACommand");

    if (kl1 != null && kl1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kl1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKl1ToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKl1FromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKl1FromExcAC2ACommand");

    if (kl1 == null) throw new ProcessingException("Kl1 already has nothing assigned.");

    apply(new UnAssignKl1FromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignKsToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKsToExcAC2ACommand");

    if (ks != null && ks.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKsToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromExcAC2ACommand");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(new UnAssignKsFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignLvgateToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignLvgateToExcAC2ACommand");

    if (lvgate != null && lvgate.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Lvgate already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignLvgateToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLvgateFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLvgateFromExcAC2ACommand");

    if (lvgate == null) throw new ProcessingException("Lvgate already has nothing assigned.");

    apply(new UnAssignLvgateFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignSeve1ToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve1ToExcAC2ACommand");

    if (seve1 != null && seve1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve1ToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve1FromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve1FromExcAC2ACommand");

    if (seve1 == null) throw new ProcessingException("Seve1 already has nothing assigned.");

    apply(new UnAssignSeve1FromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignSeve2ToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve2ToExcAC2ACommand");

    if (seve2 != null && seve2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve2ToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve2FromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve2FromExcAC2ACommand");

    if (seve2 == null) throw new ProcessingException("Seve2 already has nothing assigned.");

    apply(new UnAssignSeve2FromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcAC2ACommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcAC2ACommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcAC2ACommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcAC2ACommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcAC2ACommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcAC2ACommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcAC2ACommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcAC2ACommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcAC2ACommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcAC2ACommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVamaxToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVamaxToExcAC2ACommand");

    if (vamax != null && vamax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVamaxToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVamaxFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVamaxFromExcAC2ACommand");

    if (vamax == null) throw new ProcessingException("Vamax already has nothing assigned.");

    apply(new UnAssignVamaxFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVaminToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVaminToExcAC2ACommand");

    if (vamin != null && vamin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVaminToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaminFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaminFromExcAC2ACommand");

    if (vamin == null) throw new ProcessingException("Vamin already has nothing assigned.");

    apply(new UnAssignVaminFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVe1ToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe1ToExcAC2ACommand");

    if (ve1 != null && ve1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe1ToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe1FromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe1FromExcAC2ACommand");

    if (ve1 == null) throw new ProcessingException("Ve1 already has nothing assigned.");

    apply(new UnAssignVe1FromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVe2ToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVe2ToExcAC2ACommand");

    if (ve2 != null && ve2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe2ToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe2FromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe2FromExcAC2ACommand");

    if (ve2 == null) throw new ProcessingException("Ve2 already has nothing assigned.");

    apply(new UnAssignVe2FromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVfemaxToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVfemaxToExcAC2ACommand");

    if (vfemax != null && vfemax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vfemax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVfemaxToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVfemaxFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVfemaxFromExcAC2ACommand");

    if (vfemax == null) throw new ProcessingException("Vfemax already has nothing assigned.");

    apply(new UnAssignVfemaxFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVlrToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVlrToExcAC2ACommand");

    if (vlr != null && vlr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vlr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVlrToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVlrFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVlrFromExcAC2ACommand");

    if (vlr == null) throw new ProcessingException("Vlr already has nothing assigned.");

    apply(new UnAssignVlrFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcAC2ACommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcAC2ACommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcAC2AEvent(command.getExcAC2AId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcAC2ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcAC2ACommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcAC2AEvent(command.getExcAC2AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcAC2ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcAC2ACommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcAC2AEvent(command.getExcAC2AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcAC2AEvent event) {
    LOGGER.info("Event sourcing CreateExcAC2AEvent");
    this.excAC2AId = event.getExcAC2AId();
  }

  @EventSourcingHandler
  void on(UpdateExcAC2AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.hvgate = event.getHvgate();
    this.ka = event.getKa();
    this.kb = event.getKb();
    this.kb1 = event.getKb1();
    this.kc = event.getKc();
    this.kd = event.getKd();
    this.ke = event.getKe();
    this.kf = event.getKf();
    this.kh = event.getKh();
    this.kl = event.getKl();
    this.kl1 = event.getKl1();
    this.ks = event.getKs();
    this.lvgate = event.getLvgate();
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
    this.vlr = event.getVlr();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignHvgateToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignHvgateToExcAC2AEvent");
    this.hvgate = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHvgateFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignHvgateFromExcAC2AEvent");
    this.hvgate = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKaToExcAC2AEvent");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcAC2AEvent");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKbToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKbToExcAC2AEvent");
    this.kb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKbFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKbFromExcAC2AEvent");
    this.kb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKb1ToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKb1ToExcAC2AEvent");
    this.kb1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKb1FromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKb1FromExcAC2AEvent");
    this.kb1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcAC2AEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcAC2AEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcAC2AEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcAC2AEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcAC2AEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcAC2AEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcAC2AEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcAC2AEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKhToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKhToExcAC2AEvent");
    this.kh = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKhFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKhFromExcAC2AEvent");
    this.kh = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKlToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKlToExcAC2AEvent");
    this.kl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKlFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKlFromExcAC2AEvent");
    this.kl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKl1ToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKl1ToExcAC2AEvent");
    this.kl1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKl1FromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKl1FromExcAC2AEvent");
    this.kl1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignKsToExcAC2AEvent");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignKsFromExcAC2AEvent");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLvgateToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignLvgateToExcAC2AEvent");
    this.lvgate = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLvgateFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignLvgateFromExcAC2AEvent");
    this.lvgate = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve1ToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignSeve1ToExcAC2AEvent");
    this.seve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve1FromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve1FromExcAC2AEvent");
    this.seve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve2ToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignSeve2ToExcAC2AEvent");
    this.seve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve2FromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve2FromExcAC2AEvent");
    this.seve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcAC2AEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcAC2AEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcAC2AEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcAC2AEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcAC2AEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcAC2AEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcAC2AEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcAC2AEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcAC2AEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcAC2AEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVamaxToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVamaxToExcAC2AEvent");
    this.vamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVamaxFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVamaxFromExcAC2AEvent");
    this.vamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaminToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVaminToExcAC2AEvent");
    this.vamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaminFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVaminFromExcAC2AEvent");
    this.vamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe1ToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVe1ToExcAC2AEvent");
    this.ve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe1FromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe1FromExcAC2AEvent");
    this.ve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe2ToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVe2ToExcAC2AEvent");
    this.ve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe2FromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVe2FromExcAC2AEvent");
    this.ve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVfemaxToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVfemaxToExcAC2AEvent");
    this.vfemax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVfemaxFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVfemaxFromExcAC2AEvent");
    this.vfemax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVlrToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVlrToExcAC2AEvent");
    this.vlr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVlrFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVlrFromExcAC2AEvent");
    this.vlr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcAC2AEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcAC2AEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcAC2AEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcAC2AEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcAC2AEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcAC2AEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excAC2AId;

  private BooleanProxy hvgate = null;
  private PU ka = null;
  private PU kb = null;
  private PU kb1 = null;
  private PU kc = null;
  private PU kd = null;
  private PU ke = null;
  private PU kf = null;
  private PU kh = null;
  private PU kl = null;
  private PU kl1 = null;
  private PU ks = null;
  private BooleanProxy lvgate = null;
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
  private PU vlr = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcAC2AAggregate.class.getName());
}
