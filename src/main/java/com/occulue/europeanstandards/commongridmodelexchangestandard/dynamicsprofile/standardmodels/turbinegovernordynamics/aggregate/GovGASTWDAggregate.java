package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.aggregate;

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
 * Aggregate handler for GovGASTWD as outlined for the CQRS pattern, all write responsibilities
 * related to GovGASTWD are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovGASTWDAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovGASTWDAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovGASTWDAggregate(CreateGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command CreateGovGASTWDCommand");
    CreateGovGASTWDEvent event = new CreateGovGASTWDEvent(command.getGovGASTWDId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovGASTWDCommand command) throws Exception {
    LOGGER.info("handling command UpdateGovGASTWDCommand");
    UpdateGovGASTWDEvent event =
        new UpdateGovGASTWDEvent(
            command.getGovGASTWDId(),
            command.getA(),
            command.getAf1(),
            command.getAf2(),
            command.getB(),
            command.getBf1(),
            command.getBf2(),
            command.getC(),
            command.getCf2(),
            command.getEcr(),
            command.getEtd(),
            command.getK3(),
            command.getK4(),
            command.getK5(),
            command.getK6(),
            command.getKd(),
            command.getKdroop(),
            command.getKf(),
            command.getKi(),
            command.getKp(),
            command.getMwbase(),
            command.getT(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getTc(),
            command.getTcd(),
            command.getTd(),
            command.getTf(),
            command.getTmax(),
            command.getTmin(),
            command.getTr(),
            command.getTrate(),
            command.getTt());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGovGASTWDCommand");
    apply(new DeleteGovGASTWDEvent(command.getGovGASTWDId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignAToGovGASTWDCommand");

    if (a != null && a.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "A already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignAToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAFromGovGASTWDCommand");

    if (a == null) throw new ProcessingException("A already has nothing assigned.");

    apply(new UnAssignAFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignAf1ToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignAf1ToGovGASTWDCommand");

    if (af1 != null && af1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Af1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAf1ToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAf1FromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAf1FromGovGASTWDCommand");

    if (af1 == null) throw new ProcessingException("Af1 already has nothing assigned.");

    apply(new UnAssignAf1FromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignAf2ToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignAf2ToGovGASTWDCommand");

    if (af2 != null && af2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Af2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAf2ToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAf2FromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAf2FromGovGASTWDCommand");

    if (af2 == null) throw new ProcessingException("Af2 already has nothing assigned.");

    apply(new UnAssignAf2FromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignBToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignBToGovGASTWDCommand");

    if (b != null && b.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "B already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignBToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBFromGovGASTWDCommand");

    if (b == null) throw new ProcessingException("B already has nothing assigned.");

    apply(new UnAssignBFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignBf1ToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignBf1ToGovGASTWDCommand");

    if (bf1 != null && bf1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bf1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBf1ToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBf1FromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBf1FromGovGASTWDCommand");

    if (bf1 == null) throw new ProcessingException("Bf1 already has nothing assigned.");

    apply(new UnAssignBf1FromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignBf2ToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignBf2ToGovGASTWDCommand");

    if (bf2 != null && bf2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bf2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBf2ToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBf2FromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBf2FromGovGASTWDCommand");

    if (bf2 == null) throw new ProcessingException("Bf2 already has nothing assigned.");

    apply(new UnAssignBf2FromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignCToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignCToGovGASTWDCommand");

    if (c != null && c.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "C already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignCToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignCFromGovGASTWDCommand");

    if (c == null) throw new ProcessingException("C already has nothing assigned.");

    apply(new UnAssignCFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignCf2ToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignCf2ToGovGASTWDCommand");

    if (cf2 != null && cf2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Cf2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignCf2ToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCf2FromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignCf2FromGovGASTWDCommand");

    if (cf2 == null) throw new ProcessingException("Cf2 already has nothing assigned.");

    apply(new UnAssignCf2FromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignEcrToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignEcrToGovGASTWDCommand");

    if (ecr != null && ecr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ecr already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignEcrToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEcrFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEcrFromGovGASTWDCommand");

    if (ecr == null) throw new ProcessingException("Ecr already has nothing assigned.");

    apply(new UnAssignEcrFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignEtdToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignEtdToGovGASTWDCommand");

    if (etd != null && etd.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Etd already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignEtdToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEtdFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEtdFromGovGASTWDCommand");

    if (etd == null) throw new ProcessingException("Etd already has nothing assigned.");

    apply(new UnAssignEtdFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignK3ToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignK3ToGovGASTWDCommand");

    if (k3 != null && k3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK3ToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK3FromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK3FromGovGASTWDCommand");

    if (k3 == null) throw new ProcessingException("K3 already has nothing assigned.");

    apply(new UnAssignK3FromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignK4ToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignK4ToGovGASTWDCommand");

    if (k4 != null && k4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK4ToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK4FromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK4FromGovGASTWDCommand");

    if (k4 == null) throw new ProcessingException("K4 already has nothing assigned.");

    apply(new UnAssignK4FromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignK5ToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignK5ToGovGASTWDCommand");

    if (k5 != null && k5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK5ToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK5FromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK5FromGovGASTWDCommand");

    if (k5 == null) throw new ProcessingException("K5 already has nothing assigned.");

    apply(new UnAssignK5FromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignK6ToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignK6ToGovGASTWDCommand");

    if (k6 != null && k6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK6ToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK6FromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK6FromGovGASTWDCommand");

    if (k6 == null) throw new ProcessingException("K6 already has nothing assigned.");

    apply(new UnAssignK6FromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignKdToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToGovGASTWDCommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromGovGASTWDCommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignKdroopToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdroopToGovGASTWDCommand");

    if (kdroop != null && kdroop.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kdroop already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdroopToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdroopFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdroopFromGovGASTWDCommand");

    if (kdroop == null) throw new ProcessingException("Kdroop already has nothing assigned.");

    apply(new UnAssignKdroopFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignKfToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignKfToGovGASTWDCommand");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromGovGASTWDCommand");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignKiToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToGovGASTWDCommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromGovGASTWDCommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignKpToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToGovGASTWDCommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromGovGASTWDCommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovGASTWDCommand");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovGASTWDCommand");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignTToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTToGovGASTWDCommand");

    if (t != null && t.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTFromGovGASTWDCommand");

    if (t == null) throw new ProcessingException("T already has nothing assigned.");

    apply(new UnAssignTFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignT3ToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToGovGASTWDCommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromGovGASTWDCommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignT4ToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignT4ToGovGASTWDCommand");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromGovGASTWDCommand");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignT5ToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignT5ToGovGASTWDCommand");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromGovGASTWDCommand");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignTcToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTcToGovGASTWDCommand");

    if (tc != null && tc.getTemperatureId() == command.getAssignment().getTemperatureId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getTemperatureId());

    apply(new AssignTcToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromGovGASTWDCommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignTcdToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTcdToGovGASTWDCommand");

    if (tcd != null && tcd.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tcd already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcdToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcdFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcdFromGovGASTWDCommand");

    if (tcd == null) throw new ProcessingException("Tcd already has nothing assigned.");

    apply(new UnAssignTcdFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignTdToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTdToGovGASTWDCommand");

    if (td != null && td.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Td already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdFromGovGASTWDCommand");

    if (td == null) throw new ProcessingException("Td already has nothing assigned.");

    apply(new UnAssignTdFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignTfToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToGovGASTWDCommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromGovGASTWDCommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignTmaxToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTmaxToGovGASTWDCommand");

    if (tmax != null && tmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Tmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignTmaxToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTmaxFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTmaxFromGovGASTWDCommand");

    if (tmax == null) throw new ProcessingException("Tmax already has nothing assigned.");

    apply(new UnAssignTmaxFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignTminToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTminToGovGASTWDCommand");

    if (tmin != null && tmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Tmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignTminToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTminFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTminFromGovGASTWDCommand");

    if (tmin == null) throw new ProcessingException("Tmin already has nothing assigned.");

    apply(new UnAssignTminFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignTrToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTrToGovGASTWDCommand");

    if (tr != null && tr.getTemperatureId() == command.getAssignment().getTemperatureId())
      throw new ProcessingException(
          "Tr already assigned with id " + command.getAssignment().getTemperatureId());

    apply(new AssignTrToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrFromGovGASTWDCommand");

    if (tr == null) throw new ProcessingException("Tr already has nothing assigned.");

    apply(new UnAssignTrFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignTrateToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTrateToGovGASTWDCommand");

    if (trate != null && trate.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Trate already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignTrateToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrateFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrateFromGovGASTWDCommand");

    if (trate == null) throw new ProcessingException("Trate already has nothing assigned.");

    apply(new UnAssignTrateFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  @CommandHandler
  public void handle(AssignTtToGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTtToGovGASTWDCommand");

    if (tt != null && tt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tt already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTtToGovGASTWDEvent(command.getGovGASTWDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTtFromGovGASTWDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTtFromGovGASTWDCommand");

    if (tt == null) throw new ProcessingException("Tt already has nothing assigned.");

    apply(new UnAssignTtFromGovGASTWDEvent(command.getGovGASTWDId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovGASTWDEvent event) {
    LOGGER.info("Event sourcing CreateGovGASTWDEvent");
    this.govGASTWDId = event.getGovGASTWDId();
  }

  @EventSourcingHandler
  void on(UpdateGovGASTWDEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.a = event.getA();
    this.af1 = event.getAf1();
    this.af2 = event.getAf2();
    this.b = event.getB();
    this.bf1 = event.getBf1();
    this.bf2 = event.getBf2();
    this.c = event.getC();
    this.cf2 = event.getCf2();
    this.ecr = event.getEcr();
    this.etd = event.getEtd();
    this.k3 = event.getK3();
    this.k4 = event.getK4();
    this.k5 = event.getK5();
    this.k6 = event.getK6();
    this.kd = event.getKd();
    this.kdroop = event.getKdroop();
    this.kf = event.getKf();
    this.ki = event.getKi();
    this.kp = event.getKp();
    this.mwbase = event.getMwbase();
    this.t = event.getT();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.tc = event.getTc();
    this.tcd = event.getTcd();
    this.td = event.getTd();
    this.tf = event.getTf();
    this.tmax = event.getTmax();
    this.tmin = event.getTmin();
    this.tr = event.getTr();
    this.trate = event.getTrate();
    this.tt = event.getTt();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignAToGovGASTWDEvent");
    this.a = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignAFromGovGASTWDEvent");
    this.a = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignAf1ToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignAf1ToGovGASTWDEvent");
    this.af1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAf1FromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignAf1FromGovGASTWDEvent");
    this.af1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignAf2ToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignAf2ToGovGASTWDEvent");
    this.af2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAf2FromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignAf2FromGovGASTWDEvent");
    this.af2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignBToGovGASTWDEvent");
    this.b = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignBFromGovGASTWDEvent");
    this.b = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBf1ToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignBf1ToGovGASTWDEvent");
    this.bf1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBf1FromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignBf1FromGovGASTWDEvent");
    this.bf1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBf2ToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignBf2ToGovGASTWDEvent");
    this.bf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBf2FromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignBf2FromGovGASTWDEvent");
    this.bf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignCToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignCToGovGASTWDEvent");
    this.c = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignCFromGovGASTWDEvent");
    this.c = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignCf2ToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignCf2ToGovGASTWDEvent");
    this.cf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCf2FromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignCf2FromGovGASTWDEvent");
    this.cf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEcrToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignEcrToGovGASTWDEvent");
    this.ecr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEcrFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignEcrFromGovGASTWDEvent");
    this.ecr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEtdToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignEtdToGovGASTWDEvent");
    this.etd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEtdFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignEtdFromGovGASTWDEvent");
    this.etd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK3ToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignK3ToGovGASTWDEvent");
    this.k3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK3FromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignK3FromGovGASTWDEvent");
    this.k3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK4ToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignK4ToGovGASTWDEvent");
    this.k4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK4FromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignK4FromGovGASTWDEvent");
    this.k4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK5ToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignK5ToGovGASTWDEvent");
    this.k5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK5FromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignK5FromGovGASTWDEvent");
    this.k5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK6ToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignK6ToGovGASTWDEvent");
    this.k6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK6FromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignK6FromGovGASTWDEvent");
    this.k6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignKdToGovGASTWDEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromGovGASTWDEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdroopToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignKdroopToGovGASTWDEvent");
    this.kdroop = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdroopFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignKdroopFromGovGASTWDEvent");
    this.kdroop = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignKfToGovGASTWDEvent");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignKfFromGovGASTWDEvent");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignKiToGovGASTWDEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromGovGASTWDEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignKpToGovGASTWDEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromGovGASTWDEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovGASTWDEvent");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovGASTWDEvent");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignTToGovGASTWDEvent");
    this.t = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignTFromGovGASTWDEvent");
    this.t = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignT3ToGovGASTWDEvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromGovGASTWDEvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignT4ToGovGASTWDEvent");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignT4FromGovGASTWDEvent");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignT5ToGovGASTWDEvent");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignT5FromGovGASTWDEvent");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignTcToGovGASTWDEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromGovGASTWDEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcdToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignTcdToGovGASTWDEvent");
    this.tcd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcdFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignTcdFromGovGASTWDEvent");
    this.tcd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignTdToGovGASTWDEvent");
    this.td = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignTdFromGovGASTWDEvent");
    this.td = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignTfToGovGASTWDEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromGovGASTWDEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTmaxToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignTmaxToGovGASTWDEvent");
    this.tmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTmaxFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignTmaxFromGovGASTWDEvent");
    this.tmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTminToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignTminToGovGASTWDEvent");
    this.tmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTminFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignTminFromGovGASTWDEvent");
    this.tmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignTrToGovGASTWDEvent");
    this.tr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignTrFromGovGASTWDEvent");
    this.tr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrateToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignTrateToGovGASTWDEvent");
    this.trate = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrateFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignTrateFromGovGASTWDEvent");
    this.trate = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTtToGovGASTWDEvent event) {
    LOGGER.info("Event sourcing AssignTtToGovGASTWDEvent");
    this.tt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTtFromGovGASTWDEvent event) {
    LOGGER.info("Event sourcing UnAssignTtFromGovGASTWDEvent");
    this.tt = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govGASTWDId;

  private Simple_Float a = null;
  private PU af1 = null;
  private PU af2 = null;
  private Simple_Float b = null;
  private PU bf1 = null;
  private PU bf2 = null;
  private Simple_Float c = null;
  private PU cf2 = null;
  private Seconds ecr = null;
  private Seconds etd = null;
  private PU k3 = null;
  private PU k4 = null;
  private PU k5 = null;
  private PU k6 = null;
  private PU kd = null;
  private PU kdroop = null;
  private PU kf = null;
  private PU ki = null;
  private PU kp = null;
  private ActivePower mwbase = null;
  private Seconds t = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Temperature tc = null;
  private Seconds tcd = null;
  private Seconds td = null;
  private Seconds tf = null;
  private PU tmax = null;
  private PU tmin = null;
  private Temperature tr = null;
  private ActivePower trate = null;
  private Seconds tt = null;

  private static final Logger LOGGER = Logger.getLogger(GovGASTWDAggregate.class.getName());
}
