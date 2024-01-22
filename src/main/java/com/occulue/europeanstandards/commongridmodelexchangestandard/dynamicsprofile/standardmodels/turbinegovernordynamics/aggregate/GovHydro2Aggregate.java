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
 * Aggregate handler for GovHydro2 as outlined for the CQRS pattern, all write responsibilities
 * related to GovHydro2 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovHydro2Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovHydro2Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovHydro2Aggregate(CreateGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command CreateGovHydro2Command");
    CreateGovHydro2Event event = new CreateGovHydro2Event(command.getGovHydro2Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovHydro2Command command) throws Exception {
    LOGGER.info("handling command UpdateGovHydro2Command");
    UpdateGovHydro2Event event =
        new UpdateGovHydro2Event(
            command.getGovHydro2Id(),
            command.getAturb(),
            command.getBturb(),
            command.getDb1(),
            command.getDb2(),
            command.getEps(),
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
  public void handle(DeleteGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovHydro2Command");
    apply(new DeleteGovHydro2Event(command.getGovHydro2Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAturbToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignAturbToGovHydro2Command");

    if (aturb != null && aturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Aturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAturbToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAturbFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAturbFromGovHydro2Command");

    if (aturb == null) throw new ProcessingException("Aturb already has nothing assigned.");

    apply(new UnAssignAturbFromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignBturbToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignBturbToGovHydro2Command");

    if (bturb != null && bturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBturbToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBturbFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBturbFromGovHydro2Command");

    if (bturb == null) throw new ProcessingException("Bturb already has nothing assigned.");

    apply(new UnAssignBturbFromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignDb1ToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignDb1ToGovHydro2Command");

    if (db1 != null && db1.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Db1 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignDb1ToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb1FromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb1FromGovHydro2Command");

    if (db1 == null) throw new ProcessingException("Db1 already has nothing assigned.");

    apply(new UnAssignDb1FromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignDb2ToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignDb2ToGovHydro2Command");

    if (db2 != null && db2.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Db2 already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignDb2ToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb2FromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb2FromGovHydro2Command");

    if (db2 == null) throw new ProcessingException("Db2 already has nothing assigned.");

    apply(new UnAssignDb2FromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignEpsToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignEpsToGovHydro2Command");

    if (eps != null && eps.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Eps already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignEpsToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEpsFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEpsFromGovHydro2Command");

    if (eps == null) throw new ProcessingException("Eps already has nothing assigned.");

    apply(new UnAssignEpsFromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignGv1ToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignGv1ToGovHydro2Command");

    if (gv1 != null && gv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv1ToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv1FromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv1FromGovHydro2Command");

    if (gv1 == null) throw new ProcessingException("Gv1 already has nothing assigned.");

    apply(new UnAssignGv1FromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignGv2ToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignGv2ToGovHydro2Command");

    if (gv2 != null && gv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv2ToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv2FromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv2FromGovHydro2Command");

    if (gv2 == null) throw new ProcessingException("Gv2 already has nothing assigned.");

    apply(new UnAssignGv2FromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignGv3ToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignGv3ToGovHydro2Command");

    if (gv3 != null && gv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv3ToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv3FromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv3FromGovHydro2Command");

    if (gv3 == null) throw new ProcessingException("Gv3 already has nothing assigned.");

    apply(new UnAssignGv3FromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignGv4ToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignGv4ToGovHydro2Command");

    if (gv4 != null && gv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv4ToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv4FromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv4FromGovHydro2Command");

    if (gv4 == null) throw new ProcessingException("Gv4 already has nothing assigned.");

    apply(new UnAssignGv4FromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignGv5ToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignGv5ToGovHydro2Command");

    if (gv5 != null && gv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv5ToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv5FromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv5FromGovHydro2Command");

    if (gv5 == null) throw new ProcessingException("Gv5 already has nothing assigned.");

    apply(new UnAssignGv5FromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignGv6ToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignGv6ToGovHydro2Command");

    if (gv6 != null && gv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv6ToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv6FromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv6FromGovHydro2Command");

    if (gv6 == null) throw new ProcessingException("Gv6 already has nothing assigned.");

    apply(new UnAssignGv6FromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignKturbToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignKturbToGovHydro2Command");

    if (kturb != null && kturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKturbToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKturbFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKturbFromGovHydro2Command");

    if (kturb == null) throw new ProcessingException("Kturb already has nothing assigned.");

    apply(new UnAssignKturbFromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovHydro2Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovHydro2Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignPgv1ToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv1ToGovHydro2Command");

    if (pgv1 != null && pgv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv1ToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv1FromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv1FromGovHydro2Command");

    if (pgv1 == null) throw new ProcessingException("Pgv1 already has nothing assigned.");

    apply(new UnAssignPgv1FromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignPgv2ToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv2ToGovHydro2Command");

    if (pgv2 != null && pgv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv2ToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv2FromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv2FromGovHydro2Command");

    if (pgv2 == null) throw new ProcessingException("Pgv2 already has nothing assigned.");

    apply(new UnAssignPgv2FromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignPgv3ToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv3ToGovHydro2Command");

    if (pgv3 != null && pgv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv3ToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv3FromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv3FromGovHydro2Command");

    if (pgv3 == null) throw new ProcessingException("Pgv3 already has nothing assigned.");

    apply(new UnAssignPgv3FromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignPgv4ToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv4ToGovHydro2Command");

    if (pgv4 != null && pgv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv4ToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv4FromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv4FromGovHydro2Command");

    if (pgv4 == null) throw new ProcessingException("Pgv4 already has nothing assigned.");

    apply(new UnAssignPgv4FromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignPgv5ToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv5ToGovHydro2Command");

    if (pgv5 != null && pgv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv5ToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv5FromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv5FromGovHydro2Command");

    if (pgv5 == null) throw new ProcessingException("Pgv5 already has nothing assigned.");

    apply(new UnAssignPgv5FromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignPgv6ToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv6ToGovHydro2Command");

    if (pgv6 != null && pgv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv6ToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv6FromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv6FromGovHydro2Command");

    if (pgv6 == null) throw new ProcessingException("Pgv6 already has nothing assigned.");

    apply(new UnAssignPgv6FromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignPmaxToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignPmaxToGovHydro2Command");

    if (pmax != null && pmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmaxToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxFromGovHydro2Command");

    if (pmax == null) throw new ProcessingException("Pmax already has nothing assigned.");

    apply(new UnAssignPmaxFromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignPminToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignPminToGovHydro2Command");

    if (pmin != null && pmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPminToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromGovHydro2Command");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignRpermToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignRpermToGovHydro2Command");

    if (rperm != null && rperm.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rperm already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRpermToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRpermFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRpermFromGovHydro2Command");

    if (rperm == null) throw new ProcessingException("Rperm already has nothing assigned.");

    apply(new UnAssignRpermFromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignRtempToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignRtempToGovHydro2Command");

    if (rtemp != null && rtemp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rtemp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRtempToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRtempFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRtempFromGovHydro2Command");

    if (rtemp == null) throw new ProcessingException("Rtemp already has nothing assigned.");

    apply(new UnAssignRtempFromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignTgToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignTgToGovHydro2Command");

    if (tg != null && tg.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tg already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTgToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTgFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTgFromGovHydro2Command");

    if (tg == null) throw new ProcessingException("Tg already has nothing assigned.");

    apply(new UnAssignTgFromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignTpToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignTpToGovHydro2Command");

    if (tp != null && tp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpFromGovHydro2Command");

    if (tp == null) throw new ProcessingException("Tp already has nothing assigned.");

    apply(new UnAssignTpFromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignTrToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignTrToGovHydro2Command");

    if (tr != null && tr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tr already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTrToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrFromGovHydro2Command");

    if (tr == null) throw new ProcessingException("Tr already has nothing assigned.");

    apply(new UnAssignTrFromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignTwToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignTwToGovHydro2Command");

    if (tw != null && tw.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTwToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwFromGovHydro2Command");

    if (tw == null) throw new ProcessingException("Tw already has nothing assigned.");

    apply(new UnAssignTwFromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignUcToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignUcToGovHydro2Command");

    if (uc != null && uc.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Uc already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignUcToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUcFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignUcFromGovHydro2Command");

    if (uc == null) throw new ProcessingException("Uc already has nothing assigned.");

    apply(new UnAssignUcFromGovHydro2Event(command.getGovHydro2Id()));
  }

  @CommandHandler
  public void handle(AssignUoToGovHydro2Command command) throws Exception {
    LOGGER.info("Handling command AssignUoToGovHydro2Command");

    if (uo != null && uo.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Uo already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignUoToGovHydro2Event(command.getGovHydro2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUoFromGovHydro2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignUoFromGovHydro2Command");

    if (uo == null) throw new ProcessingException("Uo already has nothing assigned.");

    apply(new UnAssignUoFromGovHydro2Event(command.getGovHydro2Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovHydro2Event event) {
    LOGGER.info("Event sourcing CreateGovHydro2Event");
    this.govHydro2Id = event.getGovHydro2Id();
  }

  @EventSourcingHandler
  void on(UpdateGovHydro2Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.aturb = event.getAturb();
    this.bturb = event.getBturb();
    this.db1 = event.getDb1();
    this.db2 = event.getDb2();
    this.eps = event.getEps();
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
  void on(AssignAturbToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignAturbToGovHydro2Event");
    this.aturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAturbFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignAturbFromGovHydro2Event");
    this.aturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBturbToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignBturbToGovHydro2Event");
    this.bturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBturbFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignBturbFromGovHydro2Event");
    this.bturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb1ToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignDb1ToGovHydro2Event");
    this.db1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb1FromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignDb1FromGovHydro2Event");
    this.db1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb2ToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignDb2ToGovHydro2Event");
    this.db2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb2FromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignDb2FromGovHydro2Event");
    this.db2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEpsToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignEpsToGovHydro2Event");
    this.eps = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEpsFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignEpsFromGovHydro2Event");
    this.eps = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv1ToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignGv1ToGovHydro2Event");
    this.gv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv1FromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignGv1FromGovHydro2Event");
    this.gv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv2ToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignGv2ToGovHydro2Event");
    this.gv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv2FromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignGv2FromGovHydro2Event");
    this.gv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv3ToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignGv3ToGovHydro2Event");
    this.gv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv3FromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignGv3FromGovHydro2Event");
    this.gv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv4ToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignGv4ToGovHydro2Event");
    this.gv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv4FromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignGv4FromGovHydro2Event");
    this.gv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv5ToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignGv5ToGovHydro2Event");
    this.gv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv5FromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignGv5FromGovHydro2Event");
    this.gv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv6ToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignGv6ToGovHydro2Event");
    this.gv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv6FromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignGv6FromGovHydro2Event");
    this.gv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKturbToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignKturbToGovHydro2Event");
    this.kturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKturbFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignKturbFromGovHydro2Event");
    this.kturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovHydro2Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovHydro2Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv1ToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignPgv1ToGovHydro2Event");
    this.pgv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv1FromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignPgv1FromGovHydro2Event");
    this.pgv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv2ToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignPgv2ToGovHydro2Event");
    this.pgv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv2FromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignPgv2FromGovHydro2Event");
    this.pgv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv3ToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignPgv3ToGovHydro2Event");
    this.pgv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv3FromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignPgv3FromGovHydro2Event");
    this.pgv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv4ToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignPgv4ToGovHydro2Event");
    this.pgv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv4FromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignPgv4FromGovHydro2Event");
    this.pgv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv5ToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignPgv5ToGovHydro2Event");
    this.pgv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv5FromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignPgv5FromGovHydro2Event");
    this.pgv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv6ToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignPgv6ToGovHydro2Event");
    this.pgv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv6FromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignPgv6FromGovHydro2Event");
    this.pgv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignPmaxToGovHydro2Event");
    this.pmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignPmaxFromGovHydro2Event");
    this.pmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignPminToGovHydro2Event");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignPminFromGovHydro2Event");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRpermToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignRpermToGovHydro2Event");
    this.rperm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRpermFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignRpermFromGovHydro2Event");
    this.rperm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRtempToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignRtempToGovHydro2Event");
    this.rtemp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRtempFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignRtempFromGovHydro2Event");
    this.rtemp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTgToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignTgToGovHydro2Event");
    this.tg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTgFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignTgFromGovHydro2Event");
    this.tg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignTpToGovHydro2Event");
    this.tp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignTpFromGovHydro2Event");
    this.tp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignTrToGovHydro2Event");
    this.tr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignTrFromGovHydro2Event");
    this.tr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignTwToGovHydro2Event");
    this.tw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignTwFromGovHydro2Event");
    this.tw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUcToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignUcToGovHydro2Event");
    this.uc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUcFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignUcFromGovHydro2Event");
    this.uc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUoToGovHydro2Event event) {
    LOGGER.info("Event sourcing AssignUoToGovHydro2Event");
    this.uo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUoFromGovHydro2Event event) {
    LOGGER.info("Event sourcing UnAssignUoFromGovHydro2Event");
    this.uo = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govHydro2Id;

  private PU aturb = null;
  private PU bturb = null;
  private Frequency db1 = null;
  private ActivePower db2 = null;
  private Frequency eps = null;
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

  private static final Logger LOGGER = Logger.getLogger(GovHydro2Aggregate.class.getName());
}
