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
 * Aggregate handler for ExcREXS as outlined for the CQRS pattern, all write responsibilities
 * related to ExcREXS are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcREXSAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcREXSAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcREXSAggregate(CreateExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcREXSCommand");
    CreateExcREXSEvent event = new CreateExcREXSEvent(command.getExcREXSId(), command.getFbf());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcREXSCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcREXSCommand");
    UpdateExcREXSEvent event =
        new UpdateExcREXSEvent(
            command.getExcREXSId(),
            command.getE1(),
            command.getE2(),
            command.getFbf(),
            command.getFlimf(),
            command.getKc(),
            command.getKd(),
            command.getKe(),
            command.getKefd(),
            command.getKf(),
            command.getKh(),
            command.getKii(),
            command.getKip(),
            command.getKs(),
            command.getKvi(),
            command.getKvp(),
            command.getKvphz(),
            command.getNvphz(),
            command.getSe1(),
            command.getSe2(),
            command.getTa(),
            command.getTb1(),
            command.getTb2(),
            command.getTc1(),
            command.getTc2(),
            command.getTe(),
            command.getTf(),
            command.getTf1(),
            command.getTf2(),
            command.getTp(),
            command.getVcmax(),
            command.getVfmax(),
            command.getVfmin(),
            command.getVimax(),
            command.getVrmax(),
            command.getVrmin(),
            command.getXc());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcREXSCommand");
    apply(new DeleteExcREXSEvent(command.getExcREXSId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignE1ToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignE1ToExcREXSCommand");

    if (e1 != null && e1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "E1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignE1ToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignE1FromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignE1FromExcREXSCommand");

    if (e1 == null) throw new ProcessingException("E1 already has nothing assigned.");

    apply(new UnAssignE1FromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignE2ToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignE2ToExcREXSCommand");

    if (e2 != null && e2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "E2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignE2ToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignE2FromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignE2FromExcREXSCommand");

    if (e2 == null) throw new ProcessingException("E2 already has nothing assigned.");

    apply(new UnAssignE2FromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignFlimfToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignFlimfToExcREXSCommand");

    if (flimf != null && flimf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Flimf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFlimfToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFlimfFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFlimfFromExcREXSCommand");

    if (flimf == null) throw new ProcessingException("Flimf already has nothing assigned.");

    apply(new UnAssignFlimfFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcREXSCommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcREXSCommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcREXSCommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcREXSCommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignKeToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToExcREXSCommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromExcREXSCommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignKefdToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKefdToExcREXSCommand");

    if (kefd != null && kefd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kefd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKefdToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKefdFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKefdFromExcREXSCommand");

    if (kefd == null) throw new ProcessingException("Kefd already has nothing assigned.");

    apply(new UnAssignKefdFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignKfToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToExcREXSCommand");

    if (kf != null && kf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignKfToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromExcREXSCommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignKhToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKhToExcREXSCommand");

    if (kh != null && kh.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kh already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKhToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKhFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKhFromExcREXSCommand");

    if (kh == null) throw new ProcessingException("Kh already has nothing assigned.");

    apply(new UnAssignKhFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignKiiToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiiToExcREXSCommand");

    if (kii != null && kii.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kii already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiiToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiiFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiiFromExcREXSCommand");

    if (kii == null) throw new ProcessingException("Kii already has nothing assigned.");

    apply(new UnAssignKiiFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignKipToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKipToExcREXSCommand");

    if (kip != null && kip.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kip already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKipToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKipFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKipFromExcREXSCommand");

    if (kip == null) throw new ProcessingException("Kip already has nothing assigned.");

    apply(new UnAssignKipFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignKsToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKsToExcREXSCommand");

    if (ks != null && ks.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKsToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromExcREXSCommand");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(new UnAssignKsFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignKviToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKviToExcREXSCommand");

    if (kvi != null && kvi.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kvi already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKviToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKviFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKviFromExcREXSCommand");

    if (kvi == null) throw new ProcessingException("Kvi already has nothing assigned.");

    apply(new UnAssignKviFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignKvpToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKvpToExcREXSCommand");

    if (kvp != null && kvp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kvp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKvpToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKvpFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKvpFromExcREXSCommand");

    if (kvp == null) throw new ProcessingException("Kvp already has nothing assigned.");

    apply(new UnAssignKvpFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignKvphzToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKvphzToExcREXSCommand");

    if (kvphz != null && kvphz.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kvphz already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKvphzToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKvphzFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKvphzFromExcREXSCommand");

    if (kvphz == null) throw new ProcessingException("Kvphz already has nothing assigned.");

    apply(new UnAssignKvphzFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignNvphzToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignNvphzToExcREXSCommand");

    if (nvphz != null && nvphz.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Nvphz already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignNvphzToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNvphzFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNvphzFromExcREXSCommand");

    if (nvphz == null) throw new ProcessingException("Nvphz already has nothing assigned.");

    apply(new UnAssignNvphzFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignSe1ToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignSe1ToExcREXSCommand");

    if (se1 != null && se1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Se1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignSe1ToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSe1FromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSe1FromExcREXSCommand");

    if (se1 == null) throw new ProcessingException("Se1 already has nothing assigned.");

    apply(new UnAssignSe1FromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignSe2ToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignSe2ToExcREXSCommand");

    if (se2 != null && se2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Se2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignSe2ToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSe2FromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSe2FromExcREXSCommand");

    if (se2 == null) throw new ProcessingException("Se2 already has nothing assigned.");

    apply(new UnAssignSe2FromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignTaToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcREXSCommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcREXSCommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignTb1ToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTb1ToExcREXSCommand");

    if (tb1 != null && tb1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTb1ToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTb1FromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTb1FromExcREXSCommand");

    if (tb1 == null) throw new ProcessingException("Tb1 already has nothing assigned.");

    apply(new UnAssignTb1FromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignTb2ToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTb2ToExcREXSCommand");

    if (tb2 != null && tb2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTb2ToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTb2FromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTb2FromExcREXSCommand");

    if (tb2 == null) throw new ProcessingException("Tb2 already has nothing assigned.");

    apply(new UnAssignTb2FromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignTc1ToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTc1ToExcREXSCommand");

    if (tc1 != null && tc1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTc1ToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTc1FromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTc1FromExcREXSCommand");

    if (tc1 == null) throw new ProcessingException("Tc1 already has nothing assigned.");

    apply(new UnAssignTc1FromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignTc2ToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTc2ToExcREXSCommand");

    if (tc2 != null && tc2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTc2ToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTc2FromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTc2FromExcREXSCommand");

    if (tc2 == null) throw new ProcessingException("Tc2 already has nothing assigned.");

    apply(new UnAssignTc2FromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcREXSCommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcREXSCommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignTfToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToExcREXSCommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromExcREXSCommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignTf1ToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTf1ToExcREXSCommand");

    if (tf1 != null && tf1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf1ToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf1FromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf1FromExcREXSCommand");

    if (tf1 == null) throw new ProcessingException("Tf1 already has nothing assigned.");

    apply(new UnAssignTf1FromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignTf2ToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTf2ToExcREXSCommand");

    if (tf2 != null && tf2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf2ToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf2FromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf2FromExcREXSCommand");

    if (tf2 == null) throw new ProcessingException("Tf2 already has nothing assigned.");

    apply(new UnAssignTf2FromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignTpToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpToExcREXSCommand");

    if (tp != null && tp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpFromExcREXSCommand");

    if (tp == null) throw new ProcessingException("Tp already has nothing assigned.");

    apply(new UnAssignTpFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignVcmaxToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignVcmaxToExcREXSCommand");

    if (vcmax != null && vcmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vcmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVcmaxToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVcmaxFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVcmaxFromExcREXSCommand");

    if (vcmax == null) throw new ProcessingException("Vcmax already has nothing assigned.");

    apply(new UnAssignVcmaxFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignVfmaxToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignVfmaxToExcREXSCommand");

    if (vfmax != null && vfmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vfmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVfmaxToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVfmaxFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVfmaxFromExcREXSCommand");

    if (vfmax == null) throw new ProcessingException("Vfmax already has nothing assigned.");

    apply(new UnAssignVfmaxFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignVfminToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignVfminToExcREXSCommand");

    if (vfmin != null && vfmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vfmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVfminToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVfminFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVfminFromExcREXSCommand");

    if (vfmin == null) throw new ProcessingException("Vfmin already has nothing assigned.");

    apply(new UnAssignVfminFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignVimaxToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignVimaxToExcREXSCommand");

    if (vimax != null && vimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVimaxToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVimaxFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVimaxFromExcREXSCommand");

    if (vimax == null) throw new ProcessingException("Vimax already has nothing assigned.");

    apply(new UnAssignVimaxFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcREXSCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcREXSCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcREXSCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcREXSCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcREXSEvent(command.getExcREXSId()));
  }

  @CommandHandler
  public void handle(AssignXcToExcREXSCommand command) throws Exception {
    LOGGER.info("Handling command AssignXcToExcREXSCommand");

    if (xc != null && xc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignXcToExcREXSEvent(command.getExcREXSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXcFromExcREXSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXcFromExcREXSCommand");

    if (xc == null) throw new ProcessingException("Xc already has nothing assigned.");

    apply(new UnAssignXcFromExcREXSEvent(command.getExcREXSId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcREXSEvent event) {
    LOGGER.info("Event sourcing CreateExcREXSEvent");
    this.excREXSId = event.getExcREXSId();
    this.fbf = event.getFbf();
  }

  @EventSourcingHandler
  void on(UpdateExcREXSEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.e1 = event.getE1();
    this.e2 = event.getE2();
    this.fbf = event.getFbf();
    this.flimf = event.getFlimf();
    this.kc = event.getKc();
    this.kd = event.getKd();
    this.ke = event.getKe();
    this.kefd = event.getKefd();
    this.kf = event.getKf();
    this.kh = event.getKh();
    this.kii = event.getKii();
    this.kip = event.getKip();
    this.ks = event.getKs();
    this.kvi = event.getKvi();
    this.kvp = event.getKvp();
    this.kvphz = event.getKvphz();
    this.nvphz = event.getNvphz();
    this.se1 = event.getSe1();
    this.se2 = event.getSe2();
    this.ta = event.getTa();
    this.tb1 = event.getTb1();
    this.tb2 = event.getTb2();
    this.tc1 = event.getTc1();
    this.tc2 = event.getTc2();
    this.te = event.getTe();
    this.tf = event.getTf();
    this.tf1 = event.getTf1();
    this.tf2 = event.getTf2();
    this.tp = event.getTp();
    this.vcmax = event.getVcmax();
    this.vfmax = event.getVfmax();
    this.vfmin = event.getVfmin();
    this.vimax = event.getVimax();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
    this.xc = event.getXc();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignE1ToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignE1ToExcREXSEvent");
    this.e1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignE1FromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignE1FromExcREXSEvent");
    this.e1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignE2ToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignE2ToExcREXSEvent");
    this.e2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignE2FromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignE2FromExcREXSEvent");
    this.e2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFlimfToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignFlimfToExcREXSEvent");
    this.flimf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFlimfFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignFlimfFromExcREXSEvent");
    this.flimf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcREXSEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcREXSEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcREXSEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcREXSEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignKeToExcREXSEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromExcREXSEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKefdToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignKefdToExcREXSEvent");
    this.kefd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKefdFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignKefdFromExcREXSEvent");
    this.kefd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignKfToExcREXSEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromExcREXSEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKhToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignKhToExcREXSEvent");
    this.kh = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKhFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignKhFromExcREXSEvent");
    this.kh = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiiToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignKiiToExcREXSEvent");
    this.kii = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiiFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignKiiFromExcREXSEvent");
    this.kii = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKipToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignKipToExcREXSEvent");
    this.kip = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKipFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignKipFromExcREXSEvent");
    this.kip = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignKsToExcREXSEvent");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignKsFromExcREXSEvent");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKviToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignKviToExcREXSEvent");
    this.kvi = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKviFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignKviFromExcREXSEvent");
    this.kvi = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKvpToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignKvpToExcREXSEvent");
    this.kvp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKvpFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignKvpFromExcREXSEvent");
    this.kvp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKvphzToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignKvphzToExcREXSEvent");
    this.kvphz = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKvphzFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignKvphzFromExcREXSEvent");
    this.kvphz = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNvphzToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignNvphzToExcREXSEvent");
    this.nvphz = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNvphzFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignNvphzFromExcREXSEvent");
    this.nvphz = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSe1ToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignSe1ToExcREXSEvent");
    this.se1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSe1FromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignSe1FromExcREXSEvent");
    this.se1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSe2ToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignSe2ToExcREXSEvent");
    this.se2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSe2FromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignSe2FromExcREXSEvent");
    this.se2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignTaToExcREXSEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcREXSEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTb1ToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignTb1ToExcREXSEvent");
    this.tb1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTb1FromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignTb1FromExcREXSEvent");
    this.tb1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTb2ToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignTb2ToExcREXSEvent");
    this.tb2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTb2FromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignTb2FromExcREXSEvent");
    this.tb2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTc1ToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignTc1ToExcREXSEvent");
    this.tc1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTc1FromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignTc1FromExcREXSEvent");
    this.tc1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTc2ToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignTc2ToExcREXSEvent");
    this.tc2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTc2FromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignTc2FromExcREXSEvent");
    this.tc2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcREXSEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcREXSEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignTfToExcREXSEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromExcREXSEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf1ToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignTf1ToExcREXSEvent");
    this.tf1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf1FromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignTf1FromExcREXSEvent");
    this.tf1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf2ToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignTf2ToExcREXSEvent");
    this.tf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf2FromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignTf2FromExcREXSEvent");
    this.tf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignTpToExcREXSEvent");
    this.tp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignTpFromExcREXSEvent");
    this.tp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVcmaxToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignVcmaxToExcREXSEvent");
    this.vcmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVcmaxFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignVcmaxFromExcREXSEvent");
    this.vcmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVfmaxToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignVfmaxToExcREXSEvent");
    this.vfmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVfmaxFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignVfmaxFromExcREXSEvent");
    this.vfmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVfminToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignVfminToExcREXSEvent");
    this.vfmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVfminFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignVfminFromExcREXSEvent");
    this.vfmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVimaxToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignVimaxToExcREXSEvent");
    this.vimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVimaxFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignVimaxFromExcREXSEvent");
    this.vimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcREXSEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcREXSEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcREXSEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcREXSEvent");
    this.vrmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXcToExcREXSEvent event) {
    LOGGER.info("Event sourcing AssignXcToExcREXSEvent");
    this.xc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXcFromExcREXSEvent event) {
    LOGGER.info("Event sourcing UnAssignXcFromExcREXSEvent");
    this.xc = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excREXSId;

  private ExcREXSFeedbackSignalKind fbf;
  private PU e1 = null;
  private PU e2 = null;
  private PU flimf = null;
  private PU kc = null;
  private PU kd = null;
  private PU ke = null;
  private PU kefd = null;
  private Seconds kf = null;
  private PU kh = null;
  private PU kii = null;
  private PU kip = null;
  private PU ks = null;
  private PU kvi = null;
  private PU kvp = null;
  private PU kvphz = null;
  private PU nvphz = null;
  private PU se1 = null;
  private PU se2 = null;
  private Seconds ta = null;
  private Seconds tb1 = null;
  private Seconds tb2 = null;
  private Seconds tc1 = null;
  private Seconds tc2 = null;
  private Seconds te = null;
  private Seconds tf = null;
  private Seconds tf1 = null;
  private Seconds tf2 = null;
  private Seconds tp = null;
  private PU vcmax = null;
  private PU vfmax = null;
  private PU vfmin = null;
  private PU vimax = null;
  private PU vrmax = null;
  private PU vrmin = null;
  private PU xc = null;

  private static final Logger LOGGER = Logger.getLogger(ExcREXSAggregate.class.getName());
}
