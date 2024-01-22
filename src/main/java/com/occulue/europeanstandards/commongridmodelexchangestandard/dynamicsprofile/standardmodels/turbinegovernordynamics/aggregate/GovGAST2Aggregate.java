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
 * Aggregate handler for GovGAST2 as outlined for the CQRS pattern, all write responsibilities
 * related to GovGAST2 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovGAST2Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovGAST2Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovGAST2Aggregate(CreateGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command CreateGovGAST2Command");
    CreateGovGAST2Event event = new CreateGovGAST2Event(command.getGovGAST2Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovGAST2Command command) throws Exception {
    LOGGER.info("handling command UpdateGovGAST2Command");
    UpdateGovGAST2Event event =
        new UpdateGovGAST2Event(
            command.getGovGAST2Id(),
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
            command.getKf(),
            command.getMwbase(),
            command.getT(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getTc(),
            command.getTcd(),
            command.getTf(),
            command.getTmax(),
            command.getTmin(),
            command.getTr(),
            command.getTrate(),
            command.getTt(),
            command.getW(),
            command.getX(),
            command.getY(),
            command.getZ());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovGAST2Command");
    apply(new DeleteGovGAST2Event(command.getGovGAST2Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignAToGovGAST2Command");

    if (a != null && a.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "A already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignAToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAFromGovGAST2Command");

    if (a == null) throw new ProcessingException("A already has nothing assigned.");

    apply(new UnAssignAFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignAf1ToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignAf1ToGovGAST2Command");

    if (af1 != null && af1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Af1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAf1ToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAf1FromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAf1FromGovGAST2Command");

    if (af1 == null) throw new ProcessingException("Af1 already has nothing assigned.");

    apply(new UnAssignAf1FromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignAf2ToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignAf2ToGovGAST2Command");

    if (af2 != null && af2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Af2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAf2ToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAf2FromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAf2FromGovGAST2Command");

    if (af2 == null) throw new ProcessingException("Af2 already has nothing assigned.");

    apply(new UnAssignAf2FromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignBToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignBToGovGAST2Command");

    if (b != null && b.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "B already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignBToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBFromGovGAST2Command");

    if (b == null) throw new ProcessingException("B already has nothing assigned.");

    apply(new UnAssignBFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignBf1ToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignBf1ToGovGAST2Command");

    if (bf1 != null && bf1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bf1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBf1ToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBf1FromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBf1FromGovGAST2Command");

    if (bf1 == null) throw new ProcessingException("Bf1 already has nothing assigned.");

    apply(new UnAssignBf1FromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignBf2ToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignBf2ToGovGAST2Command");

    if (bf2 != null && bf2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bf2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBf2ToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBf2FromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBf2FromGovGAST2Command");

    if (bf2 == null) throw new ProcessingException("Bf2 already has nothing assigned.");

    apply(new UnAssignBf2FromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignCToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignCToGovGAST2Command");

    if (c != null && c.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "C already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignCToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignCFromGovGAST2Command");

    if (c == null) throw new ProcessingException("C already has nothing assigned.");

    apply(new UnAssignCFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignCf2ToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignCf2ToGovGAST2Command");

    if (cf2 != null && cf2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Cf2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignCf2ToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCf2FromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignCf2FromGovGAST2Command");

    if (cf2 == null) throw new ProcessingException("Cf2 already has nothing assigned.");

    apply(new UnAssignCf2FromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignEcrToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignEcrToGovGAST2Command");

    if (ecr != null && ecr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ecr already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignEcrToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEcrFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEcrFromGovGAST2Command");

    if (ecr == null) throw new ProcessingException("Ecr already has nothing assigned.");

    apply(new UnAssignEcrFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignEtdToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignEtdToGovGAST2Command");

    if (etd != null && etd.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Etd already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignEtdToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEtdFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEtdFromGovGAST2Command");

    if (etd == null) throw new ProcessingException("Etd already has nothing assigned.");

    apply(new UnAssignEtdFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignK3ToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignK3ToGovGAST2Command");

    if (k3 != null && k3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK3ToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK3FromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK3FromGovGAST2Command");

    if (k3 == null) throw new ProcessingException("K3 already has nothing assigned.");

    apply(new UnAssignK3FromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignK4ToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignK4ToGovGAST2Command");

    if (k4 != null && k4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK4ToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK4FromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK4FromGovGAST2Command");

    if (k4 == null) throw new ProcessingException("K4 already has nothing assigned.");

    apply(new UnAssignK4FromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignK5ToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignK5ToGovGAST2Command");

    if (k5 != null && k5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK5ToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK5FromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK5FromGovGAST2Command");

    if (k5 == null) throw new ProcessingException("K5 already has nothing assigned.");

    apply(new UnAssignK5FromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignK6ToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignK6ToGovGAST2Command");

    if (k6 != null && k6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK6ToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK6FromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK6FromGovGAST2Command");

    if (k6 == null) throw new ProcessingException("K6 already has nothing assigned.");

    apply(new UnAssignK6FromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignKfToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignKfToGovGAST2Command");

    if (kf != null && kf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfFromGovGAST2Command");

    if (kf == null) throw new ProcessingException("Kf already has nothing assigned.");

    apply(new UnAssignKfFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovGAST2Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovGAST2Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignTToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignTToGovGAST2Command");

    if (t != null && t.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTFromGovGAST2Command");

    if (t == null) throw new ProcessingException("T already has nothing assigned.");

    apply(new UnAssignTFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToGovGAST2Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromGovGAST2Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignT4ToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignT4ToGovGAST2Command");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromGovGAST2Command");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignT5ToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignT5ToGovGAST2Command");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromGovGAST2Command");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignTcToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignTcToGovGAST2Command");

    if (tc != null && tc.getTemperatureId() == command.getAssignment().getTemperatureId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getTemperatureId());

    apply(new AssignTcToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromGovGAST2Command");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignTcdToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignTcdToGovGAST2Command");

    if (tcd != null && tcd.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tcd already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcdToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcdFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcdFromGovGAST2Command");

    if (tcd == null) throw new ProcessingException("Tcd already has nothing assigned.");

    apply(new UnAssignTcdFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignTfToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignTfToGovGAST2Command");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromGovGAST2Command");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignTmaxToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignTmaxToGovGAST2Command");

    if (tmax != null && tmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Tmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignTmaxToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTmaxFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTmaxFromGovGAST2Command");

    if (tmax == null) throw new ProcessingException("Tmax already has nothing assigned.");

    apply(new UnAssignTmaxFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignTminToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignTminToGovGAST2Command");

    if (tmin != null && tmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Tmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignTminToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTminFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTminFromGovGAST2Command");

    if (tmin == null) throw new ProcessingException("Tmin already has nothing assigned.");

    apply(new UnAssignTminFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignTrToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignTrToGovGAST2Command");

    if (tr != null && tr.getTemperatureId() == command.getAssignment().getTemperatureId())
      throw new ProcessingException(
          "Tr already assigned with id " + command.getAssignment().getTemperatureId());

    apply(new AssignTrToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrFromGovGAST2Command");

    if (tr == null) throw new ProcessingException("Tr already has nothing assigned.");

    apply(new UnAssignTrFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignTrateToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignTrateToGovGAST2Command");

    if (trate != null && trate.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Trate already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignTrateToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrateFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrateFromGovGAST2Command");

    if (trate == null) throw new ProcessingException("Trate already has nothing assigned.");

    apply(new UnAssignTrateFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignTtToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignTtToGovGAST2Command");

    if (tt != null && tt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tt already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTtToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTtFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTtFromGovGAST2Command");

    if (tt == null) throw new ProcessingException("Tt already has nothing assigned.");

    apply(new UnAssignTtFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignWToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignWToGovGAST2Command");

    if (w != null && w.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "W already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignWToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignWFromGovGAST2Command");

    if (w == null) throw new ProcessingException("W already has nothing assigned.");

    apply(new UnAssignWFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignXToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignXToGovGAST2Command");

    if (x != null && x.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "X already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignXToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignXFromGovGAST2Command");

    if (x == null) throw new ProcessingException("X already has nothing assigned.");

    apply(new UnAssignXFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignYToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignYToGovGAST2Command");

    if (y != null && y.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Y already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignYToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignYFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignYFromGovGAST2Command");

    if (y == null) throw new ProcessingException("Y already has nothing assigned.");

    apply(new UnAssignYFromGovGAST2Event(command.getGovGAST2Id()));
  }

  @CommandHandler
  public void handle(AssignZToGovGAST2Command command) throws Exception {
    LOGGER.info("Handling command AssignZToGovGAST2Command");

    if (z != null && z.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Z already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignZToGovGAST2Event(command.getGovGAST2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignZFromGovGAST2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignZFromGovGAST2Command");

    if (z == null) throw new ProcessingException("Z already has nothing assigned.");

    apply(new UnAssignZFromGovGAST2Event(command.getGovGAST2Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovGAST2Event event) {
    LOGGER.info("Event sourcing CreateGovGAST2Event");
    this.govGAST2Id = event.getGovGAST2Id();
  }

  @EventSourcingHandler
  void on(UpdateGovGAST2Event event) {
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
    this.kf = event.getKf();
    this.mwbase = event.getMwbase();
    this.t = event.getT();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.tc = event.getTc();
    this.tcd = event.getTcd();
    this.tf = event.getTf();
    this.tmax = event.getTmax();
    this.tmin = event.getTmin();
    this.tr = event.getTr();
    this.trate = event.getTrate();
    this.tt = event.getTt();
    this.w = event.getW();
    this.x = event.getX();
    this.y = event.getY();
    this.z = event.getZ();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignAToGovGAST2Event");
    this.a = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignAFromGovGAST2Event");
    this.a = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignAf1ToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignAf1ToGovGAST2Event");
    this.af1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAf1FromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignAf1FromGovGAST2Event");
    this.af1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignAf2ToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignAf2ToGovGAST2Event");
    this.af2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAf2FromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignAf2FromGovGAST2Event");
    this.af2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignBToGovGAST2Event");
    this.b = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignBFromGovGAST2Event");
    this.b = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBf1ToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignBf1ToGovGAST2Event");
    this.bf1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBf1FromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignBf1FromGovGAST2Event");
    this.bf1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBf2ToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignBf2ToGovGAST2Event");
    this.bf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBf2FromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignBf2FromGovGAST2Event");
    this.bf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignCToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignCToGovGAST2Event");
    this.c = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignCFromGovGAST2Event");
    this.c = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignCf2ToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignCf2ToGovGAST2Event");
    this.cf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCf2FromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignCf2FromGovGAST2Event");
    this.cf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEcrToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignEcrToGovGAST2Event");
    this.ecr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEcrFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignEcrFromGovGAST2Event");
    this.ecr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEtdToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignEtdToGovGAST2Event");
    this.etd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEtdFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignEtdFromGovGAST2Event");
    this.etd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK3ToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignK3ToGovGAST2Event");
    this.k3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK3FromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignK3FromGovGAST2Event");
    this.k3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK4ToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignK4ToGovGAST2Event");
    this.k4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK4FromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignK4FromGovGAST2Event");
    this.k4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK5ToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignK5ToGovGAST2Event");
    this.k5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK5FromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignK5FromGovGAST2Event");
    this.k5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK6ToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignK6ToGovGAST2Event");
    this.k6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK6FromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignK6FromGovGAST2Event");
    this.k6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignKfToGovGAST2Event");
    this.kf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignKfFromGovGAST2Event");
    this.kf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovGAST2Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovGAST2Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignTToGovGAST2Event");
    this.t = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignTFromGovGAST2Event");
    this.t = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignT3ToGovGAST2Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromGovGAST2Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignT4ToGovGAST2Event");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignT4FromGovGAST2Event");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignT5ToGovGAST2Event");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignT5FromGovGAST2Event");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignTcToGovGAST2Event");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignTcFromGovGAST2Event");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcdToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignTcdToGovGAST2Event");
    this.tcd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcdFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignTcdFromGovGAST2Event");
    this.tcd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignTfToGovGAST2Event");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignTfFromGovGAST2Event");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTmaxToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignTmaxToGovGAST2Event");
    this.tmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTmaxFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignTmaxFromGovGAST2Event");
    this.tmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTminToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignTminToGovGAST2Event");
    this.tmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTminFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignTminFromGovGAST2Event");
    this.tmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignTrToGovGAST2Event");
    this.tr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignTrFromGovGAST2Event");
    this.tr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrateToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignTrateToGovGAST2Event");
    this.trate = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrateFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignTrateFromGovGAST2Event");
    this.trate = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTtToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignTtToGovGAST2Event");
    this.tt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTtFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignTtFromGovGAST2Event");
    this.tt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignWToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignWToGovGAST2Event");
    this.w = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignWFromGovGAST2Event");
    this.w = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignXToGovGAST2Event");
    this.x = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignXFromGovGAST2Event");
    this.x = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignYToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignYToGovGAST2Event");
    this.y = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignYFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignYFromGovGAST2Event");
    this.y = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignZToGovGAST2Event event) {
    LOGGER.info("Event sourcing AssignZToGovGAST2Event");
    this.z = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignZFromGovGAST2Event event) {
    LOGGER.info("Event sourcing UnAssignZFromGovGAST2Event");
    this.z = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govGAST2Id;

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
  private PU kf = null;
  private ActivePower mwbase = null;
  private Seconds t = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Temperature tc = null;
  private Seconds tcd = null;
  private Seconds tf = null;
  private PU tmax = null;
  private PU tmin = null;
  private Temperature tr = null;
  private ActivePower trate = null;
  private Seconds tt = null;
  private PU w = null;
  private Seconds x = null;
  private Seconds y = null;
  private BooleanProxy z = null;

  private static final Logger LOGGER = Logger.getLogger(GovGAST2Aggregate.class.getName());
}
