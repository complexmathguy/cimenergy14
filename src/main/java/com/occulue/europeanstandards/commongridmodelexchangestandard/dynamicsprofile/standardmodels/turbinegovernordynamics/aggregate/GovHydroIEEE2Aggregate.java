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
 * Aggregate handler for GovHydroIEEE2 as outlined for the CQRS pattern, all write responsibilities
 * related to GovHydroIEEE2 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovHydroIEEE2Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovHydroIEEE2Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovHydroIEEE2Aggregate(CreateGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command CreateGovHydroIEEE2Command");
    CreateGovHydroIEEE2Event event = new CreateGovHydroIEEE2Event(command.getGovHydroIEEE2Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("handling command UpdateGovHydroIEEE2Command");
    UpdateGovHydroIEEE2Event event =
        new UpdateGovHydroIEEE2Event(
            command.getGovHydroIEEE2Id(),
            command.getAturb(),
            command.getBturb(),
            command.getGv1(),
            command.getGv2(),
            command.getGv3(),
            command.getGv4(),
            command.getGv5(),
            command.getGv6(),
            command.getKturb(),
            command.getMwbase(),
            command.getPgv1(),
            command.getPgv2(),
            command.getPgv3(),
            command.getPgv4(),
            command.getPgv5(),
            command.getPgv6(),
            command.getPmax(),
            command.getPmin(),
            command.getRperm(),
            command.getRtemp(),
            command.getTg(),
            command.getTp(),
            command.getTr(),
            command.getTw(),
            command.getUc(),
            command.getUo());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovHydroIEEE2Command");
    apply(new DeleteGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAturbToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignAturbToGovHydroIEEE2Command");

    if (aturb != null && aturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Aturb already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignAturbToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAturbFromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAturbFromGovHydroIEEE2Command");

    if (aturb == null) throw new ProcessingException("Aturb already has nothing assigned.");

    apply(new UnAssignAturbFromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignBturbToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignBturbToGovHydroIEEE2Command");

    if (bturb != null && bturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bturb already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignBturbToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBturbFromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBturbFromGovHydroIEEE2Command");

    if (bturb == null) throw new ProcessingException("Bturb already has nothing assigned.");

    apply(new UnAssignBturbFromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignGv1ToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignGv1ToGovHydroIEEE2Command");

    if (gv1 != null && gv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv1ToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv1FromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv1FromGovHydroIEEE2Command");

    if (gv1 == null) throw new ProcessingException("Gv1 already has nothing assigned.");

    apply(new UnAssignGv1FromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignGv2ToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignGv2ToGovHydroIEEE2Command");

    if (gv2 != null && gv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv2ToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv2FromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv2FromGovHydroIEEE2Command");

    if (gv2 == null) throw new ProcessingException("Gv2 already has nothing assigned.");

    apply(new UnAssignGv2FromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignGv3ToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignGv3ToGovHydroIEEE2Command");

    if (gv3 != null && gv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv3ToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv3FromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv3FromGovHydroIEEE2Command");

    if (gv3 == null) throw new ProcessingException("Gv3 already has nothing assigned.");

    apply(new UnAssignGv3FromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignGv4ToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignGv4ToGovHydroIEEE2Command");

    if (gv4 != null && gv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv4ToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv4FromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv4FromGovHydroIEEE2Command");

    if (gv4 == null) throw new ProcessingException("Gv4 already has nothing assigned.");

    apply(new UnAssignGv4FromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignGv5ToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignGv5ToGovHydroIEEE2Command");

    if (gv5 != null && gv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv5ToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv5FromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv5FromGovHydroIEEE2Command");

    if (gv5 == null) throw new ProcessingException("Gv5 already has nothing assigned.");

    apply(new UnAssignGv5FromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignGv6ToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignGv6ToGovHydroIEEE2Command");

    if (gv6 != null && gv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv6ToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv6FromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv6FromGovHydroIEEE2Command");

    if (gv6 == null) throw new ProcessingException("Gv6 already has nothing assigned.");

    apply(new UnAssignGv6FromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignKturbToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignKturbToGovHydroIEEE2Command");

    if (kturb != null && kturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kturb already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKturbToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKturbFromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKturbFromGovHydroIEEE2Command");

    if (kturb == null) throw new ProcessingException("Kturb already has nothing assigned.");

    apply(new UnAssignKturbFromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovHydroIEEE2Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignMwbaseToGovHydroIEEE2Event(
            command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovHydroIEEE2Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignPgv1ToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv1ToGovHydroIEEE2Command");

    if (pgv1 != null && pgv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv1 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPgv1ToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv1FromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv1FromGovHydroIEEE2Command");

    if (pgv1 == null) throw new ProcessingException("Pgv1 already has nothing assigned.");

    apply(new UnAssignPgv1FromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignPgv2ToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv2ToGovHydroIEEE2Command");

    if (pgv2 != null && pgv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv2 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPgv2ToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv2FromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv2FromGovHydroIEEE2Command");

    if (pgv2 == null) throw new ProcessingException("Pgv2 already has nothing assigned.");

    apply(new UnAssignPgv2FromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignPgv3ToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv3ToGovHydroIEEE2Command");

    if (pgv3 != null && pgv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv3 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPgv3ToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv3FromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv3FromGovHydroIEEE2Command");

    if (pgv3 == null) throw new ProcessingException("Pgv3 already has nothing assigned.");

    apply(new UnAssignPgv3FromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignPgv4ToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv4ToGovHydroIEEE2Command");

    if (pgv4 != null && pgv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv4 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPgv4ToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv4FromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv4FromGovHydroIEEE2Command");

    if (pgv4 == null) throw new ProcessingException("Pgv4 already has nothing assigned.");

    apply(new UnAssignPgv4FromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignPgv5ToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv5ToGovHydroIEEE2Command");

    if (pgv5 != null && pgv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv5 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPgv5ToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv5FromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv5FromGovHydroIEEE2Command");

    if (pgv5 == null) throw new ProcessingException("Pgv5 already has nothing assigned.");

    apply(new UnAssignPgv5FromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignPgv6ToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv6ToGovHydroIEEE2Command");

    if (pgv6 != null && pgv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv6 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPgv6ToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv6FromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv6FromGovHydroIEEE2Command");

    if (pgv6 == null) throw new ProcessingException("Pgv6 already has nothing assigned.");

    apply(new UnAssignPgv6FromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignPmaxToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignPmaxToGovHydroIEEE2Command");

    if (pmax != null && pmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPmaxToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxFromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxFromGovHydroIEEE2Command");

    if (pmax == null) throw new ProcessingException("Pmax already has nothing assigned.");

    apply(new UnAssignPmaxFromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignPminToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignPminToGovHydroIEEE2Command");

    if (pmin != null && pmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPminToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromGovHydroIEEE2Command");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignRpermToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignRpermToGovHydroIEEE2Command");

    if (rperm != null && rperm.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rperm already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignRpermToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRpermFromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRpermFromGovHydroIEEE2Command");

    if (rperm == null) throw new ProcessingException("Rperm already has nothing assigned.");

    apply(new UnAssignRpermFromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignRtempToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignRtempToGovHydroIEEE2Command");

    if (rtemp != null && rtemp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rtemp already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignRtempToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRtempFromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRtempFromGovHydroIEEE2Command");

    if (rtemp == null) throw new ProcessingException("Rtemp already has nothing assigned.");

    apply(new UnAssignRtempFromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignTgToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignTgToGovHydroIEEE2Command");

    if (tg != null && tg.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tg already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTgToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTgFromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTgFromGovHydroIEEE2Command");

    if (tg == null) throw new ProcessingException("Tg already has nothing assigned.");

    apply(new UnAssignTgFromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignTpToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignTpToGovHydroIEEE2Command");

    if (tp != null && tp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpFromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpFromGovHydroIEEE2Command");

    if (tp == null) throw new ProcessingException("Tp already has nothing assigned.");

    apply(new UnAssignTpFromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignTrToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignTrToGovHydroIEEE2Command");

    if (tr != null && tr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tr already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTrToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrFromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrFromGovHydroIEEE2Command");

    if (tr == null) throw new ProcessingException("Tr already has nothing assigned.");

    apply(new UnAssignTrFromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignTwToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignTwToGovHydroIEEE2Command");

    if (tw != null && tw.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTwToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwFromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwFromGovHydroIEEE2Command");

    if (tw == null) throw new ProcessingException("Tw already has nothing assigned.");

    apply(new UnAssignTwFromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignUcToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignUcToGovHydroIEEE2Command");

    if (uc != null && uc.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Uc already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignUcToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUcFromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignUcFromGovHydroIEEE2Command");

    if (uc == null) throw new ProcessingException("Uc already has nothing assigned.");

    apply(new UnAssignUcFromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignUoToGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignUoToGovHydroIEEE2Command");

    if (uo != null && uo.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Uo already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignUoToGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUoFromGovHydroIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignUoFromGovHydroIEEE2Command");

    if (uo == null) throw new ProcessingException("Uo already has nothing assigned.");

    apply(new UnAssignUoFromGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing CreateGovHydroIEEE2Event");
    this.govHydroIEEE2Id = event.getGovHydroIEEE2Id();
  }

  @EventSourcingHandler
  void on(UpdateGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.aturb = event.getAturb();
    this.bturb = event.getBturb();
    this.gv1 = event.getGv1();
    this.gv2 = event.getGv2();
    this.gv3 = event.getGv3();
    this.gv4 = event.getGv4();
    this.gv5 = event.getGv5();
    this.gv6 = event.getGv6();
    this.kturb = event.getKturb();
    this.mwbase = event.getMwbase();
    this.pgv1 = event.getPgv1();
    this.pgv2 = event.getPgv2();
    this.pgv3 = event.getPgv3();
    this.pgv4 = event.getPgv4();
    this.pgv5 = event.getPgv5();
    this.pgv6 = event.getPgv6();
    this.pmax = event.getPmax();
    this.pmin = event.getPmin();
    this.rperm = event.getRperm();
    this.rtemp = event.getRtemp();
    this.tg = event.getTg();
    this.tp = event.getTp();
    this.tr = event.getTr();
    this.tw = event.getTw();
    this.uc = event.getUc();
    this.uo = event.getUo();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAturbToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignAturbToGovHydroIEEE2Event");
    this.aturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAturbFromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignAturbFromGovHydroIEEE2Event");
    this.aturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBturbToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignBturbToGovHydroIEEE2Event");
    this.bturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBturbFromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignBturbFromGovHydroIEEE2Event");
    this.bturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv1ToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignGv1ToGovHydroIEEE2Event");
    this.gv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv1FromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignGv1FromGovHydroIEEE2Event");
    this.gv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv2ToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignGv2ToGovHydroIEEE2Event");
    this.gv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv2FromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignGv2FromGovHydroIEEE2Event");
    this.gv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv3ToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignGv3ToGovHydroIEEE2Event");
    this.gv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv3FromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignGv3FromGovHydroIEEE2Event");
    this.gv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv4ToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignGv4ToGovHydroIEEE2Event");
    this.gv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv4FromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignGv4FromGovHydroIEEE2Event");
    this.gv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv5ToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignGv5ToGovHydroIEEE2Event");
    this.gv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv5FromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignGv5FromGovHydroIEEE2Event");
    this.gv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv6ToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignGv6ToGovHydroIEEE2Event");
    this.gv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv6FromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignGv6FromGovHydroIEEE2Event");
    this.gv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKturbToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignKturbToGovHydroIEEE2Event");
    this.kturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKturbFromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignKturbFromGovHydroIEEE2Event");
    this.kturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovHydroIEEE2Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovHydroIEEE2Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv1ToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignPgv1ToGovHydroIEEE2Event");
    this.pgv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv1FromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignPgv1FromGovHydroIEEE2Event");
    this.pgv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv2ToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignPgv2ToGovHydroIEEE2Event");
    this.pgv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv2FromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignPgv2FromGovHydroIEEE2Event");
    this.pgv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv3ToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignPgv3ToGovHydroIEEE2Event");
    this.pgv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv3FromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignPgv3FromGovHydroIEEE2Event");
    this.pgv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv4ToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignPgv4ToGovHydroIEEE2Event");
    this.pgv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv4FromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignPgv4FromGovHydroIEEE2Event");
    this.pgv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv5ToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignPgv5ToGovHydroIEEE2Event");
    this.pgv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv5FromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignPgv5FromGovHydroIEEE2Event");
    this.pgv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv6ToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignPgv6ToGovHydroIEEE2Event");
    this.pgv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv6FromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignPgv6FromGovHydroIEEE2Event");
    this.pgv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignPmaxToGovHydroIEEE2Event");
    this.pmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxFromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignPmaxFromGovHydroIEEE2Event");
    this.pmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignPminToGovHydroIEEE2Event");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignPminFromGovHydroIEEE2Event");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRpermToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignRpermToGovHydroIEEE2Event");
    this.rperm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRpermFromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignRpermFromGovHydroIEEE2Event");
    this.rperm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRtempToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignRtempToGovHydroIEEE2Event");
    this.rtemp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRtempFromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignRtempFromGovHydroIEEE2Event");
    this.rtemp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTgToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignTgToGovHydroIEEE2Event");
    this.tg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTgFromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignTgFromGovHydroIEEE2Event");
    this.tg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignTpToGovHydroIEEE2Event");
    this.tp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpFromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignTpFromGovHydroIEEE2Event");
    this.tp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignTrToGovHydroIEEE2Event");
    this.tr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrFromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignTrFromGovHydroIEEE2Event");
    this.tr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignTwToGovHydroIEEE2Event");
    this.tw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwFromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignTwFromGovHydroIEEE2Event");
    this.tw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUcToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignUcToGovHydroIEEE2Event");
    this.uc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUcFromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignUcFromGovHydroIEEE2Event");
    this.uc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUoToGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing AssignUoToGovHydroIEEE2Event");
    this.uo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUoFromGovHydroIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignUoFromGovHydroIEEE2Event");
    this.uo = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govHydroIEEE2Id;

  private PU aturb = null;
  private PU bturb = null;
  private PU gv1 = null;
  private PU gv2 = null;
  private PU gv3 = null;
  private PU gv4 = null;
  private PU gv5 = null;
  private PU gv6 = null;
  private PU kturb = null;
  private ActivePower mwbase = null;
  private PU pgv1 = null;
  private PU pgv2 = null;
  private PU pgv3 = null;
  private PU pgv4 = null;
  private PU pgv5 = null;
  private PU pgv6 = null;
  private PU pmax = null;
  private PU pmin = null;
  private PU rperm = null;
  private PU rtemp = null;
  private Seconds tg = null;
  private Seconds tp = null;
  private Seconds tr = null;
  private Seconds tw = null;
  private Simple_Float uc = null;
  private Simple_Float uo = null;

  private static final Logger LOGGER = Logger.getLogger(GovHydroIEEE2Aggregate.class.getName());
}
