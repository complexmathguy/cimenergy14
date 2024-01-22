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
 * Aggregate handler for ExcSK as outlined for the CQRS pattern, all write responsibilities related
 * to ExcSK are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcSKAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcSKAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcSKAggregate(CreateExcSKCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcSKCommand");
    CreateExcSKEvent event = new CreateExcSKEvent(command.getExcSKId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcSKCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcSKCommand");
    UpdateExcSKEvent event =
        new UpdateExcSKEvent(
            command.getExcSKId(),
            command.getEfdmax(),
            command.getEfdmin(),
            command.getEmax(),
            command.getEmin(),
            command.getK(),
            command.getK1(),
            command.getK2(),
            command.getKc(),
            command.getKce(),
            command.getKd(),
            command.getKgob(),
            command.getKp(),
            command.getKqi(),
            command.getKqob(),
            command.getKqp(),
            command.getNq(),
            command.getQconoff(),
            command.getQz(),
            command.getRemote(),
            command.getSbase(),
            command.getTc(),
            command.getTe(),
            command.getTi(),
            command.getTp(),
            command.getTr(),
            command.getUimax(),
            command.getUimin(),
            command.getUrmax(),
            command.getUrmin(),
            command.getVtmax(),
            command.getVtmin(),
            command.getYp());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcSKCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcSKCommand");
    apply(new DeleteExcSKEvent(command.getExcSKId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfdmaxToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdmaxToExcSKCommand");

    if (efdmax != null && efdmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdmaxToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdmaxFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdmaxFromExcSKCommand");

    if (efdmax == null) throw new ProcessingException("Efdmax already has nothing assigned.");

    apply(new UnAssignEfdmaxFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignEfdminToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdminToExcSKCommand");

    if (efdmin != null && efdmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdminToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdminFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdminFromExcSKCommand");

    if (efdmin == null) throw new ProcessingException("Efdmin already has nothing assigned.");

    apply(new UnAssignEfdminFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignEmaxToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignEmaxToExcSKCommand");

    if (emax != null && emax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Emax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEmaxToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEmaxFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEmaxFromExcSKCommand");

    if (emax == null) throw new ProcessingException("Emax already has nothing assigned.");

    apply(new UnAssignEmaxFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignEminToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignEminToExcSKCommand");

    if (emin != null && emin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Emin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEminToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEminFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEminFromExcSKCommand");

    if (emin == null) throw new ProcessingException("Emin already has nothing assigned.");

    apply(new UnAssignEminFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignKToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignKToExcSKCommand");

    if (k != null && k.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKFromExcSKCommand");

    if (k == null) throw new ProcessingException("K already has nothing assigned.");

    apply(new UnAssignKFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignK1ToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignK1ToExcSKCommand");

    if (k1 != null && k1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK1ToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromExcSKCommand");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignK2ToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignK2ToExcSKCommand");

    if (k2 != null && k2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK2ToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK2FromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK2FromExcSKCommand");

    if (k2 == null) throw new ProcessingException("K2 already has nothing assigned.");

    apply(new UnAssignK2FromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignKcToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcSKCommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcSKCommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignKceToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignKceToExcSKCommand");

    if (kce != null && kce.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kce already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKceToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKceFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKceFromExcSKCommand");

    if (kce == null) throw new ProcessingException("Kce already has nothing assigned.");

    apply(new UnAssignKceFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignKdToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToExcSKCommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromExcSKCommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignKgobToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignKgobToExcSKCommand");

    if (kgob != null && kgob.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kgob already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKgobToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKgobFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKgobFromExcSKCommand");

    if (kgob == null) throw new ProcessingException("Kgob already has nothing assigned.");

    apply(new UnAssignKgobFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignKpToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToExcSKCommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromExcSKCommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignKqiToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignKqiToExcSKCommand");

    if (kqi != null && kqi.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kqi already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKqiToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKqiFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKqiFromExcSKCommand");

    if (kqi == null) throw new ProcessingException("Kqi already has nothing assigned.");

    apply(new UnAssignKqiFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignKqobToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignKqobToExcSKCommand");

    if (kqob != null && kqob.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kqob already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKqobToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKqobFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKqobFromExcSKCommand");

    if (kqob == null) throw new ProcessingException("Kqob already has nothing assigned.");

    apply(new UnAssignKqobFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignKqpToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignKqpToExcSKCommand");

    if (kqp != null && kqp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kqp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKqpToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKqpFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKqpFromExcSKCommand");

    if (kqp == null) throw new ProcessingException("Kqp already has nothing assigned.");

    apply(new UnAssignKqpFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignNqToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignNqToExcSKCommand");

    if (nq != null && nq.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Nq already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignNqToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNqFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNqFromExcSKCommand");

    if (nq == null) throw new ProcessingException("Nq already has nothing assigned.");

    apply(new UnAssignNqFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignQconoffToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignQconoffToExcSKCommand");

    if (qconoff != null
        && qconoff.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Qconoff already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignQconoffToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQconoffFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQconoffFromExcSKCommand");

    if (qconoff == null) throw new ProcessingException("Qconoff already has nothing assigned.");

    apply(new UnAssignQconoffFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignQzToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignQzToExcSKCommand");

    if (qz != null && qz.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Qz already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignQzToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQzFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQzFromExcSKCommand");

    if (qz == null) throw new ProcessingException("Qz already has nothing assigned.");

    apply(new UnAssignQzFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignRemoteToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignRemoteToExcSKCommand");

    if (remote != null && remote.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Remote already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignRemoteToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRemoteFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRemoteFromExcSKCommand");

    if (remote == null) throw new ProcessingException("Remote already has nothing assigned.");

    apply(new UnAssignRemoteFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignSbaseToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignSbaseToExcSKCommand");

    if (sbase != null && sbase.getApparentPowerId() == command.getAssignment().getApparentPowerId())
      throw new ProcessingException(
          "Sbase already assigned with id " + command.getAssignment().getApparentPowerId());

    apply(new AssignSbaseToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSbaseFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSbaseFromExcSKCommand");

    if (sbase == null) throw new ProcessingException("Sbase already has nothing assigned.");

    apply(new UnAssignSbaseFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignTcToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToExcSKCommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromExcSKCommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignTeToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcSKCommand");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcSKCommand");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignTiToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignTiToExcSKCommand");

    if (ti != null && ti.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTiToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTiFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTiFromExcSKCommand");

    if (ti == null) throw new ProcessingException("Ti already has nothing assigned.");

    apply(new UnAssignTiFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignTpToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpToExcSKCommand");

    if (tp != null && tp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpFromExcSKCommand");

    if (tp == null) throw new ProcessingException("Tp already has nothing assigned.");

    apply(new UnAssignTpFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignTrToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignTrToExcSKCommand");

    if (tr != null && tr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tr already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTrToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrFromExcSKCommand");

    if (tr == null) throw new ProcessingException("Tr already has nothing assigned.");

    apply(new UnAssignTrFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignUimaxToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignUimaxToExcSKCommand");

    if (uimax != null && uimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Uimax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignUimaxToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUimaxFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUimaxFromExcSKCommand");

    if (uimax == null) throw new ProcessingException("Uimax already has nothing assigned.");

    apply(new UnAssignUimaxFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignUiminToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignUiminToExcSKCommand");

    if (uimin != null && uimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Uimin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignUiminToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUiminFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUiminFromExcSKCommand");

    if (uimin == null) throw new ProcessingException("Uimin already has nothing assigned.");

    apply(new UnAssignUiminFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignUrmaxToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignUrmaxToExcSKCommand");

    if (urmax != null && urmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Urmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignUrmaxToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUrmaxFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUrmaxFromExcSKCommand");

    if (urmax == null) throw new ProcessingException("Urmax already has nothing assigned.");

    apply(new UnAssignUrmaxFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignUrminToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignUrminToExcSKCommand");

    if (urmin != null && urmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Urmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignUrminToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUrminFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUrminFromExcSKCommand");

    if (urmin == null) throw new ProcessingException("Urmin already has nothing assigned.");

    apply(new UnAssignUrminFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignVtmaxToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignVtmaxToExcSKCommand");

    if (vtmax != null && vtmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vtmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVtmaxToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVtmaxFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVtmaxFromExcSKCommand");

    if (vtmax == null) throw new ProcessingException("Vtmax already has nothing assigned.");

    apply(new UnAssignVtmaxFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignVtminToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignVtminToExcSKCommand");

    if (vtmin != null && vtmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vtmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVtminToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVtminFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVtminFromExcSKCommand");

    if (vtmin == null) throw new ProcessingException("Vtmin already has nothing assigned.");

    apply(new UnAssignVtminFromExcSKEvent(command.getExcSKId()));
  }

  @CommandHandler
  public void handle(AssignYpToExcSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignYpToExcSKCommand");

    if (yp != null && yp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Yp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignYpToExcSKEvent(command.getExcSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignYpFromExcSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignYpFromExcSKCommand");

    if (yp == null) throw new ProcessingException("Yp already has nothing assigned.");

    apply(new UnAssignYpFromExcSKEvent(command.getExcSKId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcSKEvent event) {
    LOGGER.info("Event sourcing CreateExcSKEvent");
    this.excSKId = event.getExcSKId();
  }

  @EventSourcingHandler
  void on(UpdateExcSKEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efdmax = event.getEfdmax();
    this.efdmin = event.getEfdmin();
    this.emax = event.getEmax();
    this.emin = event.getEmin();
    this.k = event.getK();
    this.k1 = event.getK1();
    this.k2 = event.getK2();
    this.kc = event.getKc();
    this.kce = event.getKce();
    this.kd = event.getKd();
    this.kgob = event.getKgob();
    this.kp = event.getKp();
    this.kqi = event.getKqi();
    this.kqob = event.getKqob();
    this.kqp = event.getKqp();
    this.nq = event.getNq();
    this.qconoff = event.getQconoff();
    this.qz = event.getQz();
    this.remote = event.getRemote();
    this.sbase = event.getSbase();
    this.tc = event.getTc();
    this.te = event.getTe();
    this.ti = event.getTi();
    this.tp = event.getTp();
    this.tr = event.getTr();
    this.uimax = event.getUimax();
    this.uimin = event.getUimin();
    this.urmax = event.getUrmax();
    this.urmin = event.getUrmin();
    this.vtmax = event.getVtmax();
    this.vtmin = event.getVtmin();
    this.yp = event.getYp();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfdmaxToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignEfdmaxToExcSKEvent");
    this.efdmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdmaxFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdmaxFromExcSKEvent");
    this.efdmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfdminToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignEfdminToExcSKEvent");
    this.efdmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdminFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdminFromExcSKEvent");
    this.efdmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEmaxToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignEmaxToExcSKEvent");
    this.emax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEmaxFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignEmaxFromExcSKEvent");
    this.emax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEminToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignEminToExcSKEvent");
    this.emin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEminFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignEminFromExcSKEvent");
    this.emin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignKToExcSKEvent");
    this.k = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignKFromExcSKEvent");
    this.k = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignK1ToExcSKEvent");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignK1FromExcSKEvent");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK2ToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignK2ToExcSKEvent");
    this.k2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK2FromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignK2FromExcSKEvent");
    this.k2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcSKEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcSKEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKceToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignKceToExcSKEvent");
    this.kce = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKceFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignKceFromExcSKEvent");
    this.kce = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignKdToExcSKEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromExcSKEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKgobToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignKgobToExcSKEvent");
    this.kgob = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKgobFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignKgobFromExcSKEvent");
    this.kgob = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignKpToExcSKEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromExcSKEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKqiToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignKqiToExcSKEvent");
    this.kqi = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKqiFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignKqiFromExcSKEvent");
    this.kqi = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKqobToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignKqobToExcSKEvent");
    this.kqob = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKqobFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignKqobFromExcSKEvent");
    this.kqob = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKqpToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignKqpToExcSKEvent");
    this.kqp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKqpFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignKqpFromExcSKEvent");
    this.kqp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNqToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignNqToExcSKEvent");
    this.nq = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNqFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignNqFromExcSKEvent");
    this.nq = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQconoffToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignQconoffToExcSKEvent");
    this.qconoff = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQconoffFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignQconoffFromExcSKEvent");
    this.qconoff = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQzToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignQzToExcSKEvent");
    this.qz = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQzFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignQzFromExcSKEvent");
    this.qz = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRemoteToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignRemoteToExcSKEvent");
    this.remote = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRemoteFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignRemoteFromExcSKEvent");
    this.remote = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSbaseToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignSbaseToExcSKEvent");
    this.sbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSbaseFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignSbaseFromExcSKEvent");
    this.sbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignTcToExcSKEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromExcSKEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignTeToExcSKEvent");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcSKEvent");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTiToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignTiToExcSKEvent");
    this.ti = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTiFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignTiFromExcSKEvent");
    this.ti = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignTpToExcSKEvent");
    this.tp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignTpFromExcSKEvent");
    this.tp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignTrToExcSKEvent");
    this.tr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignTrFromExcSKEvent");
    this.tr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUimaxToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignUimaxToExcSKEvent");
    this.uimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUimaxFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignUimaxFromExcSKEvent");
    this.uimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUiminToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignUiminToExcSKEvent");
    this.uimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUiminFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignUiminFromExcSKEvent");
    this.uimin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUrmaxToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignUrmaxToExcSKEvent");
    this.urmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUrmaxFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignUrmaxFromExcSKEvent");
    this.urmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUrminToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignUrminToExcSKEvent");
    this.urmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUrminFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignUrminFromExcSKEvent");
    this.urmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVtmaxToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignVtmaxToExcSKEvent");
    this.vtmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVtmaxFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignVtmaxFromExcSKEvent");
    this.vtmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVtminToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignVtminToExcSKEvent");
    this.vtmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVtminFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignVtminFromExcSKEvent");
    this.vtmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignYpToExcSKEvent event) {
    LOGGER.info("Event sourcing AssignYpToExcSKEvent");
    this.yp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignYpFromExcSKEvent event) {
    LOGGER.info("Event sourcing UnAssignYpFromExcSKEvent");
    this.yp = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excSKId;

  private PU efdmax = null;
  private PU efdmin = null;
  private PU emax = null;
  private PU emin = null;
  private PU k = null;
  private PU k1 = null;
  private PU k2 = null;
  private PU kc = null;
  private PU kce = null;
  private PU kd = null;
  private PU kgob = null;
  private PU kp = null;
  private PU kqi = null;
  private PU kqob = null;
  private PU kqp = null;
  private PU nq = null;
  private BooleanProxy qconoff = null;
  private PU qz = null;
  private BooleanProxy remote = null;
  private ApparentPower sbase = null;
  private Seconds tc = null;
  private Seconds te = null;
  private Seconds ti = null;
  private Seconds tp = null;
  private Seconds tr = null;
  private PU uimax = null;
  private PU uimin = null;
  private PU urmax = null;
  private PU urmin = null;
  private PU vtmax = null;
  private PU vtmin = null;
  private PU yp = null;

  private static final Logger LOGGER = Logger.getLogger(ExcSKAggregate.class.getName());
}
