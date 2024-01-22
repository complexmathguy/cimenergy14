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
 * Aggregate handler for GovGAST1 as outlined for the CQRS pattern, all write responsibilities
 * related to GovGAST1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovGAST1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovGAST1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovGAST1Aggregate(CreateGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command CreateGovGAST1Command");
    CreateGovGAST1Event event = new CreateGovGAST1Event(command.getGovGAST1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovGAST1Command command) throws Exception {
    LOGGER.info("handling command UpdateGovGAST1Command");
    UpdateGovGAST1Event event =
        new UpdateGovGAST1Event(
            command.getGovGAST1Id(),
            command.getA(),
            command.getB(),
            command.getDb1(),
            command.getDb2(),
            command.getEps(),
            command.getFidle(),
            command.getGv1(),
            command.getGv2(),
            command.getGv3(),
            command.getGv4(),
            command.getGv5(),
            command.getGv6(),
            command.getKa(),
            command.getKt(),
            command.getLmax(),
            command.getLoadinc(),
            command.getLtrate(),
            command.getMwbase(),
            command.getPgv1(),
            command.getPgv2(),
            command.getPgv3(),
            command.getPgv4(),
            command.getPgv5(),
            command.getPgv6(),
            command.getR(),
            command.getRmax(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getTltr(),
            command.getVmax(),
            command.getVmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovGAST1Command");
    apply(new DeleteGovGAST1Event(command.getGovGAST1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignAToGovGAST1Command");

    if (a != null && a.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "A already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignAToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAFromGovGAST1Command");

    if (a == null) throw new ProcessingException("A already has nothing assigned.");

    apply(new UnAssignAFromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignBToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignBToGovGAST1Command");

    if (b != null && b.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "B already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignBToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBFromGovGAST1Command");

    if (b == null) throw new ProcessingException("B already has nothing assigned.");

    apply(new UnAssignBFromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignDb1ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignDb1ToGovGAST1Command");

    if (db1 != null && db1.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Db1 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignDb1ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb1FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb1FromGovGAST1Command");

    if (db1 == null) throw new ProcessingException("Db1 already has nothing assigned.");

    apply(new UnAssignDb1FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignDb2ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignDb2ToGovGAST1Command");

    if (db2 != null && db2.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Db2 already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignDb2ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb2FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb2FromGovGAST1Command");

    if (db2 == null) throw new ProcessingException("Db2 already has nothing assigned.");

    apply(new UnAssignDb2FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignEpsToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignEpsToGovGAST1Command");

    if (eps != null && eps.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Eps already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignEpsToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEpsFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEpsFromGovGAST1Command");

    if (eps == null) throw new ProcessingException("Eps already has nothing assigned.");

    apply(new UnAssignEpsFromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignFidleToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignFidleToGovGAST1Command");

    if (fidle != null && fidle.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fidle already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFidleToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFidleFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFidleFromGovGAST1Command");

    if (fidle == null) throw new ProcessingException("Fidle already has nothing assigned.");

    apply(new UnAssignFidleFromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignGv1ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignGv1ToGovGAST1Command");

    if (gv1 != null && gv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv1ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv1FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv1FromGovGAST1Command");

    if (gv1 == null) throw new ProcessingException("Gv1 already has nothing assigned.");

    apply(new UnAssignGv1FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignGv2ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignGv2ToGovGAST1Command");

    if (gv2 != null && gv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv2ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv2FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv2FromGovGAST1Command");

    if (gv2 == null) throw new ProcessingException("Gv2 already has nothing assigned.");

    apply(new UnAssignGv2FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignGv3ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignGv3ToGovGAST1Command");

    if (gv3 != null && gv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv3ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv3FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv3FromGovGAST1Command");

    if (gv3 == null) throw new ProcessingException("Gv3 already has nothing assigned.");

    apply(new UnAssignGv3FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignGv4ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignGv4ToGovGAST1Command");

    if (gv4 != null && gv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv4ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv4FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv4FromGovGAST1Command");

    if (gv4 == null) throw new ProcessingException("Gv4 already has nothing assigned.");

    apply(new UnAssignGv4FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignGv5ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignGv5ToGovGAST1Command");

    if (gv5 != null && gv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv5ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv5FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv5FromGovGAST1Command");

    if (gv5 == null) throw new ProcessingException("Gv5 already has nothing assigned.");

    apply(new UnAssignGv5FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignGv6ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignGv6ToGovGAST1Command");

    if (gv6 != null && gv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv6ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv6FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv6FromGovGAST1Command");

    if (gv6 == null) throw new ProcessingException("Gv6 already has nothing assigned.");

    apply(new UnAssignGv6FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignKaToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignKaToGovGAST1Command");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromGovGAST1Command");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignKtToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignKtToGovGAST1Command");

    if (kt != null && kt.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kt already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKtToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKtFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKtFromGovGAST1Command");

    if (kt == null) throw new ProcessingException("Kt already has nothing assigned.");

    apply(new UnAssignKtFromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignLmaxToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignLmaxToGovGAST1Command");

    if (lmax != null && lmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Lmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignLmaxToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLmaxFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignLmaxFromGovGAST1Command");

    if (lmax == null) throw new ProcessingException("Lmax already has nothing assigned.");

    apply(new UnAssignLmaxFromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignLoadincToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignLoadincToGovGAST1Command");

    if (loadinc != null && loadinc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Loadinc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignLoadincToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLoadincFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignLoadincFromGovGAST1Command");

    if (loadinc == null) throw new ProcessingException("Loadinc already has nothing assigned.");

    apply(new UnAssignLoadincFromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignLtrateToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignLtrateToGovGAST1Command");

    if (ltrate != null && ltrate.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ltrate already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignLtrateToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLtrateFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignLtrateFromGovGAST1Command");

    if (ltrate == null) throw new ProcessingException("Ltrate already has nothing assigned.");

    apply(new UnAssignLtrateFromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovGAST1Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovGAST1Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignPgv1ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv1ToGovGAST1Command");

    if (pgv1 != null && pgv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv1ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv1FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv1FromGovGAST1Command");

    if (pgv1 == null) throw new ProcessingException("Pgv1 already has nothing assigned.");

    apply(new UnAssignPgv1FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignPgv2ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv2ToGovGAST1Command");

    if (pgv2 != null && pgv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv2ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv2FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv2FromGovGAST1Command");

    if (pgv2 == null) throw new ProcessingException("Pgv2 already has nothing assigned.");

    apply(new UnAssignPgv2FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignPgv3ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv3ToGovGAST1Command");

    if (pgv3 != null && pgv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv3ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv3FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv3FromGovGAST1Command");

    if (pgv3 == null) throw new ProcessingException("Pgv3 already has nothing assigned.");

    apply(new UnAssignPgv3FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignPgv4ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv4ToGovGAST1Command");

    if (pgv4 != null && pgv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv4ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv4FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv4FromGovGAST1Command");

    if (pgv4 == null) throw new ProcessingException("Pgv4 already has nothing assigned.");

    apply(new UnAssignPgv4FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignPgv5ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv5ToGovGAST1Command");

    if (pgv5 != null && pgv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv5ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv5FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv5FromGovGAST1Command");

    if (pgv5 == null) throw new ProcessingException("Pgv5 already has nothing assigned.");

    apply(new UnAssignPgv5FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignPgv6ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv6ToGovGAST1Command");

    if (pgv6 != null && pgv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv6ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv6FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv6FromGovGAST1Command");

    if (pgv6 == null) throw new ProcessingException("Pgv6 already has nothing assigned.");

    apply(new UnAssignPgv6FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignRToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignRToGovGAST1Command");

    if (r != null && r.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromGovGAST1Command");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignRmaxToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignRmaxToGovGAST1Command");

    if (rmax != null && rmax.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Rmax already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignRmaxToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRmaxFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRmaxFromGovGAST1Command");

    if (rmax == null) throw new ProcessingException("Rmax already has nothing assigned.");

    apply(new UnAssignRmaxFromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToGovGAST1Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromGovGAST1Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignT2ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignT2ToGovGAST1Command");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromGovGAST1Command");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToGovGAST1Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromGovGAST1Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignT4ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignT4ToGovGAST1Command");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromGovGAST1Command");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignT5ToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignT5ToGovGAST1Command");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromGovGAST1Command");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignTltrToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignTltrToGovGAST1Command");

    if (tltr != null && tltr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tltr already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTltrToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTltrFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTltrFromGovGAST1Command");

    if (tltr == null) throw new ProcessingException("Tltr already has nothing assigned.");

    apply(new UnAssignTltrFromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignVmaxToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignVmaxToGovGAST1Command");

    if (vmax != null && vmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmaxToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmaxFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmaxFromGovGAST1Command");

    if (vmax == null) throw new ProcessingException("Vmax already has nothing assigned.");

    apply(new UnAssignVmaxFromGovGAST1Event(command.getGovGAST1Id()));
  }

  @CommandHandler
  public void handle(AssignVminToGovGAST1Command command) throws Exception {
    LOGGER.info("Handling command AssignVminToGovGAST1Command");

    if (vmin != null && vmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVminToGovGAST1Event(command.getGovGAST1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVminFromGovGAST1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVminFromGovGAST1Command");

    if (vmin == null) throw new ProcessingException("Vmin already has nothing assigned.");

    apply(new UnAssignVminFromGovGAST1Event(command.getGovGAST1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovGAST1Event event) {
    LOGGER.info("Event sourcing CreateGovGAST1Event");
    this.govGAST1Id = event.getGovGAST1Id();
  }

  @EventSourcingHandler
  void on(UpdateGovGAST1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.a = event.getA();
    this.b = event.getB();
    this.db1 = event.getDb1();
    this.db2 = event.getDb2();
    this.eps = event.getEps();
    this.fidle = event.getFidle();
    this.gv1 = event.getGv1();
    this.gv2 = event.getGv2();
    this.gv3 = event.getGv3();
    this.gv4 = event.getGv4();
    this.gv5 = event.getGv5();
    this.gv6 = event.getGv6();
    this.ka = event.getKa();
    this.kt = event.getKt();
    this.lmax = event.getLmax();
    this.loadinc = event.getLoadinc();
    this.ltrate = event.getLtrate();
    this.mwbase = event.getMwbase();
    this.pgv1 = event.getPgv1();
    this.pgv2 = event.getPgv2();
    this.pgv3 = event.getPgv3();
    this.pgv4 = event.getPgv4();
    this.pgv5 = event.getPgv5();
    this.pgv6 = event.getPgv6();
    this.r = event.getR();
    this.rmax = event.getRmax();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.tltr = event.getTltr();
    this.vmax = event.getVmax();
    this.vmin = event.getVmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignAToGovGAST1Event");
    this.a = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignAFromGovGAST1Event");
    this.a = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignBToGovGAST1Event");
    this.b = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignBFromGovGAST1Event");
    this.b = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb1ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignDb1ToGovGAST1Event");
    this.db1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb1FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignDb1FromGovGAST1Event");
    this.db1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb2ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignDb2ToGovGAST1Event");
    this.db2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb2FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignDb2FromGovGAST1Event");
    this.db2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEpsToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignEpsToGovGAST1Event");
    this.eps = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEpsFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignEpsFromGovGAST1Event");
    this.eps = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFidleToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignFidleToGovGAST1Event");
    this.fidle = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFidleFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignFidleFromGovGAST1Event");
    this.fidle = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv1ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignGv1ToGovGAST1Event");
    this.gv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv1FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignGv1FromGovGAST1Event");
    this.gv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv2ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignGv2ToGovGAST1Event");
    this.gv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv2FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignGv2FromGovGAST1Event");
    this.gv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv3ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignGv3ToGovGAST1Event");
    this.gv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv3FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignGv3FromGovGAST1Event");
    this.gv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv4ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignGv4ToGovGAST1Event");
    this.gv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv4FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignGv4FromGovGAST1Event");
    this.gv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv5ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignGv5ToGovGAST1Event");
    this.gv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv5FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignGv5FromGovGAST1Event");
    this.gv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv6ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignGv6ToGovGAST1Event");
    this.gv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv6FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignGv6FromGovGAST1Event");
    this.gv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignKaToGovGAST1Event");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignKaFromGovGAST1Event");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKtToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignKtToGovGAST1Event");
    this.kt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKtFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignKtFromGovGAST1Event");
    this.kt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLmaxToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignLmaxToGovGAST1Event");
    this.lmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLmaxFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignLmaxFromGovGAST1Event");
    this.lmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLoadincToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignLoadincToGovGAST1Event");
    this.loadinc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLoadincFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignLoadincFromGovGAST1Event");
    this.loadinc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLtrateToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignLtrateToGovGAST1Event");
    this.ltrate = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLtrateFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignLtrateFromGovGAST1Event");
    this.ltrate = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovGAST1Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovGAST1Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv1ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignPgv1ToGovGAST1Event");
    this.pgv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv1FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignPgv1FromGovGAST1Event");
    this.pgv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv2ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignPgv2ToGovGAST1Event");
    this.pgv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv2FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignPgv2FromGovGAST1Event");
    this.pgv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv3ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignPgv3ToGovGAST1Event");
    this.pgv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv3FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignPgv3FromGovGAST1Event");
    this.pgv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv4ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignPgv4ToGovGAST1Event");
    this.pgv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv4FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignPgv4FromGovGAST1Event");
    this.pgv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv5ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignPgv5ToGovGAST1Event");
    this.pgv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv5FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignPgv5FromGovGAST1Event");
    this.pgv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv6ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignPgv6ToGovGAST1Event");
    this.pgv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv6FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignPgv6FromGovGAST1Event");
    this.pgv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignRToGovGAST1Event");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignRFromGovGAST1Event");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRmaxToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignRmaxToGovGAST1Event");
    this.rmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRmaxFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignRmaxFromGovGAST1Event");
    this.rmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignT1ToGovGAST1Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromGovGAST1Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignT2ToGovGAST1Event");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignT2FromGovGAST1Event");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignT3ToGovGAST1Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromGovGAST1Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignT4ToGovGAST1Event");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignT4FromGovGAST1Event");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignT5ToGovGAST1Event");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignT5FromGovGAST1Event");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTltrToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignTltrToGovGAST1Event");
    this.tltr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTltrFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignTltrFromGovGAST1Event");
    this.tltr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmaxToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignVmaxToGovGAST1Event");
    this.vmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmaxFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignVmaxFromGovGAST1Event");
    this.vmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVminToGovGAST1Event event) {
    LOGGER.info("Event sourcing AssignVminToGovGAST1Event");
    this.vmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVminFromGovGAST1Event event) {
    LOGGER.info("Event sourcing UnAssignVminFromGovGAST1Event");
    this.vmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govGAST1Id;

  private Simple_Float a = null;
  private Simple_Float b = null;
  private Frequency db1 = null;
  private ActivePower db2 = null;
  private Frequency eps = null;
  private PU fidle = null;
  private PU gv1 = null;
  private PU gv2 = null;
  private PU gv3 = null;
  private PU gv4 = null;
  private PU gv5 = null;
  private PU gv6 = null;
  private PU ka = null;
  private PU kt = null;
  private PU lmax = null;
  private PU loadinc = null;
  private Simple_Float ltrate = null;
  private ActivePower mwbase = null;
  private PU pgv1 = null;
  private PU pgv2 = null;
  private PU pgv3 = null;
  private PU pgv4 = null;
  private PU pgv5 = null;
  private PU pgv6 = null;
  private PU r = null;
  private Simple_Float rmax = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Seconds tltr = null;
  private PU vmax = null;
  private PU vmin = null;

  private static final Logger LOGGER = Logger.getLogger(GovGAST1Aggregate.class.getName());
}
