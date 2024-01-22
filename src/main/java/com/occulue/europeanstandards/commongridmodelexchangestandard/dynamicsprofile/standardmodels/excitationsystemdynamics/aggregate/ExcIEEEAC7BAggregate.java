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
 * Aggregate handler for ExcIEEEAC7B as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEAC7B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEAC7BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEAC7BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEAC7BAggregate(CreateExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEAC7BCommand");
    CreateExcIEEEAC7BEvent event = new CreateExcIEEEAC7BEvent(command.getExcIEEEAC7BId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEAC7BCommand");
    UpdateExcIEEEAC7BEvent event =
        new UpdateExcIEEEAC7BEvent(
            command.getExcIEEEAC7BId(),
            command.getKc(),
            command.getKd(),
            command.getKdr(),
            command.getKe(),
            command.getKf1(),
            command.getKf2(),
            command.getKf3(),
            command.getKia(),
            command.getKir(),
            command.getKl(),
            command.getKp(),
            command.getKpa(),
            command.getKpr(),
            command.getSeve1(),
            command.getSeve2(),
            command.getTdr(),
            command.getTe(),
            command.getTf(),
            command.getVamax(),
            command.getVamin(),
            command.getVe1(),
            command.getVe2(),
            command.getVemin(),
            command.getVfemax(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEAC7BCommand");
    apply(new DeleteExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKcToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcIEEEAC7BCommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcIEEEAC7BCommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcIEEEAC7BCommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcIEEEAC7BCommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignKdrToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdrToExcIEEEAC7BCommand");

    if (kdr != null && kdr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kdr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdrToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdrFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdrFromExcIEEEAC7BCommand");

    if (kdr == null) throw new ProcessingException("Kdr already has nothing assigned.");

    apply(new UnAssignKdrFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcIEEEAC7BCommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcIEEEAC7BCommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignKf1ToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKf1ToExcIEEEAC7BCommand");

    if (kf1 != null && kf1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKf1ToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKf1FromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKf1FromExcIEEEAC7BCommand");

    if (kf1 == null) throw new ProcessingException("Kf1 already has nothing assigned.");

    apply(new UnAssignKf1FromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignKf2ToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKf2ToExcIEEEAC7BCommand");

    if (kf2 != null && kf2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKf2ToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKf2FromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKf2FromExcIEEEAC7BCommand");

    if (kf2 == null) throw new ProcessingException("Kf2 already has nothing assigned.");

    apply(new UnAssignKf2FromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignKf3ToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKf3ToExcIEEEAC7BCommand");

    if (kf3 != null && kf3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKf3ToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKf3FromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKf3FromExcIEEEAC7BCommand");

    if (kf3 == null) throw new ProcessingException("Kf3 already has nothing assigned.");

    apply(new UnAssignKf3FromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignKiaToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiaToExcIEEEAC7BCommand");

    if (kia != null && kia.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kia already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiaToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiaFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiaFromExcIEEEAC7BCommand");

    if (kia == null) throw new ProcessingException("Kia already has nothing assigned.");

    apply(new UnAssignKiaFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignKirToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKirToExcIEEEAC7BCommand");

    if (kir != null && kir.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kir already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKirToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKirFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKirFromExcIEEEAC7BCommand");

    if (kir == null) throw new ProcessingException("Kir already has nothing assigned.");

    apply(new UnAssignKirFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignKlToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKlToExcIEEEAC7BCommand");

    if (kl != null && kl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKlToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKlFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKlFromExcIEEEAC7BCommand");

    if (kl == null) throw new ProcessingException("Kl already has nothing assigned.");

    apply(new UnAssignKlFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignKpToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToExcIEEEAC7BCommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromExcIEEEAC7BCommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignKpaToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpaToExcIEEEAC7BCommand");

    if (kpa != null && kpa.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpa already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpaToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpaFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpaFromExcIEEEAC7BCommand");

    if (kpa == null) throw new ProcessingException("Kpa already has nothing assigned.");

    apply(new UnAssignKpaFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignKprToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKprToExcIEEEAC7BCommand");

    if (kpr != null && kpr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKprToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKprFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKprFromExcIEEEAC7BCommand");

    if (kpr == null) throw new ProcessingException("Kpr already has nothing assigned.");

    apply(new UnAssignKprFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignSeve1ToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve1ToExcIEEEAC7BCommand");

    if (seve1 != null && seve1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve1ToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve1FromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve1FromExcIEEEAC7BCommand");

    if (seve1 == null) throw new ProcessingException("Seve1 already has nothing assigned.");

    apply(new UnAssignSeve1FromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignSeve2ToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignSeve2ToExcIEEEAC7BCommand");

    if (seve2 != null && seve2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Seve2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSeve2ToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve2FromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve2FromExcIEEEAC7BCommand");

    if (seve2 == null) throw new ProcessingException("Seve2 already has nothing assigned.");

    apply(new UnAssignSeve2FromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignTdrToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTdrToExcIEEEAC7BCommand");

    if (tdr != null && tdr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tdr already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdrToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdrFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdrFromExcIEEEAC7BCommand");

    if (tdr == null) throw new ProcessingException("Tdr already has nothing assigned.");

    apply(new UnAssignTdrFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcIEEEAC7BCommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcIEEEAC7BCommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcIEEEAC7BCommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcIEEEAC7BCommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignVamaxToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVamaxToExcIEEEAC7BCommand");

    if (vamax != null && vamax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVamaxToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVamaxFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVamaxFromExcIEEEAC7BCommand");

    if (vamax == null) throw new ProcessingException("Vamax already has nothing assigned.");

    apply(new UnAssignVamaxFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignVaminToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVaminToExcIEEEAC7BCommand");

    if (vamin != null && vamin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vamin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVaminToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaminFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaminFromExcIEEEAC7BCommand");

    if (vamin == null) throw new ProcessingException("Vamin already has nothing assigned.");

    apply(new UnAssignVaminFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignVe1ToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVe1ToExcIEEEAC7BCommand");

    if (ve1 != null && ve1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe1ToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe1FromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe1FromExcIEEEAC7BCommand");

    if (ve1 == null) throw new ProcessingException("Ve1 already has nothing assigned.");

    apply(new UnAssignVe1FromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignVe2ToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVe2ToExcIEEEAC7BCommand");

    if (ve2 != null && ve2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe2ToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe2FromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe2FromExcIEEEAC7BCommand");

    if (ve2 == null) throw new ProcessingException("Ve2 already has nothing assigned.");

    apply(new UnAssignVe2FromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignVeminToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVeminToExcIEEEAC7BCommand");

    if (vemin != null && vemin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vemin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVeminToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVeminFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVeminFromExcIEEEAC7BCommand");

    if (vemin == null) throw new ProcessingException("Vemin already has nothing assigned.");

    apply(new UnAssignVeminFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignVfemaxToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVfemaxToExcIEEEAC7BCommand");

    if (vfemax != null && vfemax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vfemax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVfemaxToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVfemaxFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVfemaxFromExcIEEEAC7BCommand");

    if (vfemax == null) throw new ProcessingException("Vfemax already has nothing assigned.");

    apply(new UnAssignVfemaxFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEAC7BCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEAC7BCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEAC7BCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEAC7BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEAC7BCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEAC7BEvent");
    this.excIEEEAC7BId = event.getExcIEEEAC7BId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.kc = event.getKc();
    this.kd = event.getKd();
    this.kdr = event.getKdr();
    this.ke = event.getKe();
    this.kf1 = event.getKf1();
    this.kf2 = event.getKf2();
    this.kf3 = event.getKf3();
    this.kia = event.getKia();
    this.kir = event.getKir();
    this.kl = event.getKl();
    this.kp = event.getKp();
    this.kpa = event.getKpa();
    this.kpr = event.getKpr();
    this.seve1 = event.getSeve1();
    this.seve2 = event.getSeve2();
    this.tdr = event.getTdr();
    this.te = event.getTe();
    this.tf = event.getTf();
    this.vamax = event.getVamax();
    this.vamin = event.getVamin();
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
  void on(AssignKcToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcIEEEAC7BEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcIEEEAC7BEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcIEEEAC7BEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcIEEEAC7BEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdrToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignKdrToExcIEEEAC7BEvent");
    this.kdr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdrFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKdrFromExcIEEEAC7BEvent");
    this.kdr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcIEEEAC7BEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcIEEEAC7BEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKf1ToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignKf1ToExcIEEEAC7BEvent");
    this.kf1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKf1FromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKf1FromExcIEEEAC7BEvent");
    this.kf1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKf2ToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignKf2ToExcIEEEAC7BEvent");
    this.kf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKf2FromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKf2FromExcIEEEAC7BEvent");
    this.kf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKf3ToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignKf3ToExcIEEEAC7BEvent");
    this.kf3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKf3FromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKf3FromExcIEEEAC7BEvent");
    this.kf3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiaToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignKiaToExcIEEEAC7BEvent");
    this.kia = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiaFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKiaFromExcIEEEAC7BEvent");
    this.kia = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKirToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignKirToExcIEEEAC7BEvent");
    this.kir = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKirFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKirFromExcIEEEAC7BEvent");
    this.kir = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKlToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignKlToExcIEEEAC7BEvent");
    this.kl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKlFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKlFromExcIEEEAC7BEvent");
    this.kl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignKpToExcIEEEAC7BEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromExcIEEEAC7BEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpaToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignKpaToExcIEEEAC7BEvent");
    this.kpa = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpaFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKpaFromExcIEEEAC7BEvent");
    this.kpa = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKprToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignKprToExcIEEEAC7BEvent");
    this.kpr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKprFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignKprFromExcIEEEAC7BEvent");
    this.kpr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve1ToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignSeve1ToExcIEEEAC7BEvent");
    this.seve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve1FromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve1FromExcIEEEAC7BEvent");
    this.seve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve2ToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignSeve2ToExcIEEEAC7BEvent");
    this.seve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve2FromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignSeve2FromExcIEEEAC7BEvent");
    this.seve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdrToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignTdrToExcIEEEAC7BEvent");
    this.tdr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdrFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignTdrFromExcIEEEAC7BEvent");
    this.tdr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcIEEEAC7BEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcIEEEAC7BEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcIEEEAC7BEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcIEEEAC7BEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVamaxToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignVamaxToExcIEEEAC7BEvent");
    this.vamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVamaxFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVamaxFromExcIEEEAC7BEvent");
    this.vamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaminToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignVaminToExcIEEEAC7BEvent");
    this.vamin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaminFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVaminFromExcIEEEAC7BEvent");
    this.vamin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe1ToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignVe1ToExcIEEEAC7BEvent");
    this.ve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe1FromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVe1FromExcIEEEAC7BEvent");
    this.ve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe2ToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignVe2ToExcIEEEAC7BEvent");
    this.ve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe2FromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVe2FromExcIEEEAC7BEvent");
    this.ve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVeminToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignVeminToExcIEEEAC7BEvent");
    this.vemin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVeminFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVeminFromExcIEEEAC7BEvent");
    this.vemin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVfemaxToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignVfemaxToExcIEEEAC7BEvent");
    this.vfemax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVfemaxFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVfemaxFromExcIEEEAC7BEvent");
    this.vfemax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEAC7BEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEAC7BEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEAC7BEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEAC7BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEAC7BEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEAC7BId;

  private PU kc = null;
  private PU kd = null;
  private PU kdr = null;
  private PU ke = null;
  private PU kf1 = null;
  private PU kf2 = null;
  private PU kf3 = null;
  private PU kia = null;
  private PU kir = null;
  private PU kl = null;
  private PU kp = null;
  private PU kpa = null;
  private PU kpr = null;
  private Simple_Float seve1 = null;
  private Simple_Float seve2 = null;
  private Seconds tdr = null;
  private Seconds te = null;
  private Seconds tf = null;
  private PU vamax = null;
  private PU vamin = null;
  private PU ve1 = null;
  private PU ve2 = null;
  private PU vemin = null;
  private PU vfemax = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC7BAggregate.class.getName());
}
