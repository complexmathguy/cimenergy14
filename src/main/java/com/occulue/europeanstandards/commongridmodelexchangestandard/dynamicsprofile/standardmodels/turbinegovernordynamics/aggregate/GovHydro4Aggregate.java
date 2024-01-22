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
 * Aggregate handler for GovHydro4 as outlined for the CQRS pattern, all write responsibilities
 * related to GovHydro4 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovHydro4Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovHydro4Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovHydro4Aggregate(CreateGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command CreateGovHydro4Command");
    CreateGovHydro4Event event = new CreateGovHydro4Event(command.getGovHydro4Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovHydro4Command command) throws Exception {
    LOGGER.info("handling command UpdateGovHydro4Command");
    UpdateGovHydro4Event event =
        new UpdateGovHydro4Event(
            command.getGovHydro4Id(),
            command.getAt(),
            command.getBgv0(),
            command.getBgv1(),
            command.getBgv2(),
            command.getBgv3(),
            command.getBgv4(),
            command.getBgv5(),
            command.getBmax(),
            command.getDb1(),
            command.getDb2(),
            command.getDturb(),
            command.getEps(),
            command.getGmax(),
            command.getGmin(),
            command.getGv0(),
            command.getGv1(),
            command.getGv2(),
            command.getGv3(),
            command.getGv4(),
            command.getGv5(),
            command.getHdam(),
            command.getMwbase(),
            command.getPgv0(),
            command.getPgv1(),
            command.getPgv2(),
            command.getPgv3(),
            command.getPgv4(),
            command.getPgv5(),
            command.getQn1(),
            command.getRperm(),
            command.getRtemp(),
            command.getTblade(),
            command.getTg(),
            command.getTp(),
            command.getTr(),
            command.getTw(),
            command.getUc(),
            command.getUo());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovHydro4Command");
    apply(new DeleteGovHydro4Event(command.getGovHydro4Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAtToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignAtToGovHydro4Command");

    if (at != null && at.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "At already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAtToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAtFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAtFromGovHydro4Command");

    if (at == null) throw new ProcessingException("At already has nothing assigned.");

    apply(new UnAssignAtFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignBgv0ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignBgv0ToGovHydro4Command");

    if (bgv0 != null && bgv0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bgv0 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBgv0ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBgv0FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBgv0FromGovHydro4Command");

    if (bgv0 == null) throw new ProcessingException("Bgv0 already has nothing assigned.");

    apply(new UnAssignBgv0FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignBgv1ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignBgv1ToGovHydro4Command");

    if (bgv1 != null && bgv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bgv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBgv1ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBgv1FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBgv1FromGovHydro4Command");

    if (bgv1 == null) throw new ProcessingException("Bgv1 already has nothing assigned.");

    apply(new UnAssignBgv1FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignBgv2ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignBgv2ToGovHydro4Command");

    if (bgv2 != null && bgv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bgv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBgv2ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBgv2FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBgv2FromGovHydro4Command");

    if (bgv2 == null) throw new ProcessingException("Bgv2 already has nothing assigned.");

    apply(new UnAssignBgv2FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignBgv3ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignBgv3ToGovHydro4Command");

    if (bgv3 != null && bgv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bgv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBgv3ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBgv3FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBgv3FromGovHydro4Command");

    if (bgv3 == null) throw new ProcessingException("Bgv3 already has nothing assigned.");

    apply(new UnAssignBgv3FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignBgv4ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignBgv4ToGovHydro4Command");

    if (bgv4 != null && bgv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bgv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBgv4ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBgv4FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBgv4FromGovHydro4Command");

    if (bgv4 == null) throw new ProcessingException("Bgv4 already has nothing assigned.");

    apply(new UnAssignBgv4FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignBgv5ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignBgv5ToGovHydro4Command");

    if (bgv5 != null && bgv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bgv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBgv5ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBgv5FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBgv5FromGovHydro4Command");

    if (bgv5 == null) throw new ProcessingException("Bgv5 already has nothing assigned.");

    apply(new UnAssignBgv5FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignBmaxToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignBmaxToGovHydro4Command");

    if (bmax != null && bmax.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Bmax already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignBmaxToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBmaxFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBmaxFromGovHydro4Command");

    if (bmax == null) throw new ProcessingException("Bmax already has nothing assigned.");

    apply(new UnAssignBmaxFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignDb1ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignDb1ToGovHydro4Command");

    if (db1 != null && db1.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Db1 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignDb1ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb1FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb1FromGovHydro4Command");

    if (db1 == null) throw new ProcessingException("Db1 already has nothing assigned.");

    apply(new UnAssignDb1FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignDb2ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignDb2ToGovHydro4Command");

    if (db2 != null && db2.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Db2 already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignDb2ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb2FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb2FromGovHydro4Command");

    if (db2 == null) throw new ProcessingException("Db2 already has nothing assigned.");

    apply(new UnAssignDb2FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignDturbToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignDturbToGovHydro4Command");

    if (dturb != null && dturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDturbToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDturbFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDturbFromGovHydro4Command");

    if (dturb == null) throw new ProcessingException("Dturb already has nothing assigned.");

    apply(new UnAssignDturbFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignEpsToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignEpsToGovHydro4Command");

    if (eps != null && eps.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Eps already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignEpsToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEpsFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEpsFromGovHydro4Command");

    if (eps == null) throw new ProcessingException("Eps already has nothing assigned.");

    apply(new UnAssignEpsFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignGmaxToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignGmaxToGovHydro4Command");

    if (gmax != null && gmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGmaxToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGmaxFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGmaxFromGovHydro4Command");

    if (gmax == null) throw new ProcessingException("Gmax already has nothing assigned.");

    apply(new UnAssignGmaxFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignGminToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignGminToGovHydro4Command");

    if (gmin != null && gmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGminToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGminFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGminFromGovHydro4Command");

    if (gmin == null) throw new ProcessingException("Gmin already has nothing assigned.");

    apply(new UnAssignGminFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignGv0ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignGv0ToGovHydro4Command");

    if (gv0 != null && gv0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv0 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv0ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv0FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv0FromGovHydro4Command");

    if (gv0 == null) throw new ProcessingException("Gv0 already has nothing assigned.");

    apply(new UnAssignGv0FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignGv1ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignGv1ToGovHydro4Command");

    if (gv1 != null && gv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv1ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv1FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv1FromGovHydro4Command");

    if (gv1 == null) throw new ProcessingException("Gv1 already has nothing assigned.");

    apply(new UnAssignGv1FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignGv2ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignGv2ToGovHydro4Command");

    if (gv2 != null && gv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv2ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv2FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv2FromGovHydro4Command");

    if (gv2 == null) throw new ProcessingException("Gv2 already has nothing assigned.");

    apply(new UnAssignGv2FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignGv3ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignGv3ToGovHydro4Command");

    if (gv3 != null && gv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv3ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv3FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv3FromGovHydro4Command");

    if (gv3 == null) throw new ProcessingException("Gv3 already has nothing assigned.");

    apply(new UnAssignGv3FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignGv4ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignGv4ToGovHydro4Command");

    if (gv4 != null && gv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv4ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv4FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv4FromGovHydro4Command");

    if (gv4 == null) throw new ProcessingException("Gv4 already has nothing assigned.");

    apply(new UnAssignGv4FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignGv5ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignGv5ToGovHydro4Command");

    if (gv5 != null && gv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv5ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv5FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv5FromGovHydro4Command");

    if (gv5 == null) throw new ProcessingException("Gv5 already has nothing assigned.");

    apply(new UnAssignGv5FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignHdamToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignHdamToGovHydro4Command");

    if (hdam != null && hdam.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Hdam already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignHdamToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHdamFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignHdamFromGovHydro4Command");

    if (hdam == null) throw new ProcessingException("Hdam already has nothing assigned.");

    apply(new UnAssignHdamFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovHydro4Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovHydro4Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignPgv0ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv0ToGovHydro4Command");

    if (pgv0 != null && pgv0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv0 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv0ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv0FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv0FromGovHydro4Command");

    if (pgv0 == null) throw new ProcessingException("Pgv0 already has nothing assigned.");

    apply(new UnAssignPgv0FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignPgv1ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv1ToGovHydro4Command");

    if (pgv1 != null && pgv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv1ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv1FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv1FromGovHydro4Command");

    if (pgv1 == null) throw new ProcessingException("Pgv1 already has nothing assigned.");

    apply(new UnAssignPgv1FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignPgv2ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv2ToGovHydro4Command");

    if (pgv2 != null && pgv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv2ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv2FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv2FromGovHydro4Command");

    if (pgv2 == null) throw new ProcessingException("Pgv2 already has nothing assigned.");

    apply(new UnAssignPgv2FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignPgv3ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv3ToGovHydro4Command");

    if (pgv3 != null && pgv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv3ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv3FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv3FromGovHydro4Command");

    if (pgv3 == null) throw new ProcessingException("Pgv3 already has nothing assigned.");

    apply(new UnAssignPgv3FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignPgv4ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv4ToGovHydro4Command");

    if (pgv4 != null && pgv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv4ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv4FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv4FromGovHydro4Command");

    if (pgv4 == null) throw new ProcessingException("Pgv4 already has nothing assigned.");

    apply(new UnAssignPgv4FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignPgv5ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv5ToGovHydro4Command");

    if (pgv5 != null && pgv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv5ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv5FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv5FromGovHydro4Command");

    if (pgv5 == null) throw new ProcessingException("Pgv5 already has nothing assigned.");

    apply(new UnAssignPgv5FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignQn1ToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignQn1ToGovHydro4Command");

    if (qn1 != null && qn1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Qn1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignQn1ToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQn1FromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQn1FromGovHydro4Command");

    if (qn1 == null) throw new ProcessingException("Qn1 already has nothing assigned.");

    apply(new UnAssignQn1FromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignRpermToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignRpermToGovHydro4Command");

    if (rperm != null && rperm.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Rperm already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignRpermToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRpermFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRpermFromGovHydro4Command");

    if (rperm == null) throw new ProcessingException("Rperm already has nothing assigned.");

    apply(new UnAssignRpermFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignRtempToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignRtempToGovHydro4Command");

    if (rtemp != null && rtemp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Rtemp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignRtempToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRtempFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRtempFromGovHydro4Command");

    if (rtemp == null) throw new ProcessingException("Rtemp already has nothing assigned.");

    apply(new UnAssignRtempFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignTbladeToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignTbladeToGovHydro4Command");

    if (tblade != null && tblade.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tblade already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbladeToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbladeFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbladeFromGovHydro4Command");

    if (tblade == null) throw new ProcessingException("Tblade already has nothing assigned.");

    apply(new UnAssignTbladeFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignTgToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignTgToGovHydro4Command");

    if (tg != null && tg.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tg already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTgToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTgFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTgFromGovHydro4Command");

    if (tg == null) throw new ProcessingException("Tg already has nothing assigned.");

    apply(new UnAssignTgFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignTpToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignTpToGovHydro4Command");

    if (tp != null && tp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpFromGovHydro4Command");

    if (tp == null) throw new ProcessingException("Tp already has nothing assigned.");

    apply(new UnAssignTpFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignTrToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignTrToGovHydro4Command");

    if (tr != null && tr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tr already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTrToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrFromGovHydro4Command");

    if (tr == null) throw new ProcessingException("Tr already has nothing assigned.");

    apply(new UnAssignTrFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignTwToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignTwToGovHydro4Command");

    if (tw != null && tw.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTwToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwFromGovHydro4Command");

    if (tw == null) throw new ProcessingException("Tw already has nothing assigned.");

    apply(new UnAssignTwFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignUcToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignUcToGovHydro4Command");

    if (uc != null && uc.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Uc already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignUcToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUcFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignUcFromGovHydro4Command");

    if (uc == null) throw new ProcessingException("Uc already has nothing assigned.");

    apply(new UnAssignUcFromGovHydro4Event(command.getGovHydro4Id()));
  }

  @CommandHandler
  public void handle(AssignUoToGovHydro4Command command) throws Exception {
    LOGGER.info("Handling command AssignUoToGovHydro4Command");

    if (uo != null && uo.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Uo already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignUoToGovHydro4Event(command.getGovHydro4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUoFromGovHydro4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignUoFromGovHydro4Command");

    if (uo == null) throw new ProcessingException("Uo already has nothing assigned.");

    apply(new UnAssignUoFromGovHydro4Event(command.getGovHydro4Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovHydro4Event event) {
    LOGGER.info("Event sourcing CreateGovHydro4Event");
    this.govHydro4Id = event.getGovHydro4Id();
  }

  @EventSourcingHandler
  void on(UpdateGovHydro4Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.at = event.getAt();
    this.bgv0 = event.getBgv0();
    this.bgv1 = event.getBgv1();
    this.bgv2 = event.getBgv2();
    this.bgv3 = event.getBgv3();
    this.bgv4 = event.getBgv4();
    this.bgv5 = event.getBgv5();
    this.bmax = event.getBmax();
    this.db1 = event.getDb1();
    this.db2 = event.getDb2();
    this.dturb = event.getDturb();
    this.eps = event.getEps();
    this.gmax = event.getGmax();
    this.gmin = event.getGmin();
    this.gv0 = event.getGv0();
    this.gv1 = event.getGv1();
    this.gv2 = event.getGv2();
    this.gv3 = event.getGv3();
    this.gv4 = event.getGv4();
    this.gv5 = event.getGv5();
    this.hdam = event.getHdam();
    this.mwbase = event.getMwbase();
    this.pgv0 = event.getPgv0();
    this.pgv1 = event.getPgv1();
    this.pgv2 = event.getPgv2();
    this.pgv3 = event.getPgv3();
    this.pgv4 = event.getPgv4();
    this.pgv5 = event.getPgv5();
    this.qn1 = event.getQn1();
    this.rperm = event.getRperm();
    this.rtemp = event.getRtemp();
    this.tblade = event.getTblade();
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
  void on(AssignAtToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignAtToGovHydro4Event");
    this.at = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAtFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignAtFromGovHydro4Event");
    this.at = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBgv0ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignBgv0ToGovHydro4Event");
    this.bgv0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBgv0FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignBgv0FromGovHydro4Event");
    this.bgv0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBgv1ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignBgv1ToGovHydro4Event");
    this.bgv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBgv1FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignBgv1FromGovHydro4Event");
    this.bgv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBgv2ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignBgv2ToGovHydro4Event");
    this.bgv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBgv2FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignBgv2FromGovHydro4Event");
    this.bgv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBgv3ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignBgv3ToGovHydro4Event");
    this.bgv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBgv3FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignBgv3FromGovHydro4Event");
    this.bgv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBgv4ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignBgv4ToGovHydro4Event");
    this.bgv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBgv4FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignBgv4FromGovHydro4Event");
    this.bgv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBgv5ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignBgv5ToGovHydro4Event");
    this.bgv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBgv5FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignBgv5FromGovHydro4Event");
    this.bgv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBmaxToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignBmaxToGovHydro4Event");
    this.bmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBmaxFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignBmaxFromGovHydro4Event");
    this.bmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb1ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignDb1ToGovHydro4Event");
    this.db1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb1FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignDb1FromGovHydro4Event");
    this.db1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb2ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignDb2ToGovHydro4Event");
    this.db2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb2FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignDb2FromGovHydro4Event");
    this.db2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDturbToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignDturbToGovHydro4Event");
    this.dturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDturbFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignDturbFromGovHydro4Event");
    this.dturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEpsToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignEpsToGovHydro4Event");
    this.eps = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEpsFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignEpsFromGovHydro4Event");
    this.eps = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGmaxToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignGmaxToGovHydro4Event");
    this.gmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGmaxFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignGmaxFromGovHydro4Event");
    this.gmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGminToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignGminToGovHydro4Event");
    this.gmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGminFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignGminFromGovHydro4Event");
    this.gmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv0ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignGv0ToGovHydro4Event");
    this.gv0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv0FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignGv0FromGovHydro4Event");
    this.gv0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv1ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignGv1ToGovHydro4Event");
    this.gv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv1FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignGv1FromGovHydro4Event");
    this.gv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv2ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignGv2ToGovHydro4Event");
    this.gv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv2FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignGv2FromGovHydro4Event");
    this.gv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv3ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignGv3ToGovHydro4Event");
    this.gv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv3FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignGv3FromGovHydro4Event");
    this.gv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv4ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignGv4ToGovHydro4Event");
    this.gv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv4FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignGv4FromGovHydro4Event");
    this.gv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv5ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignGv5ToGovHydro4Event");
    this.gv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv5FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignGv5FromGovHydro4Event");
    this.gv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignHdamToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignHdamToGovHydro4Event");
    this.hdam = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHdamFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignHdamFromGovHydro4Event");
    this.hdam = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovHydro4Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovHydro4Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv0ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignPgv0ToGovHydro4Event");
    this.pgv0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv0FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignPgv0FromGovHydro4Event");
    this.pgv0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv1ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignPgv1ToGovHydro4Event");
    this.pgv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv1FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignPgv1FromGovHydro4Event");
    this.pgv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv2ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignPgv2ToGovHydro4Event");
    this.pgv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv2FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignPgv2FromGovHydro4Event");
    this.pgv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv3ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignPgv3ToGovHydro4Event");
    this.pgv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv3FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignPgv3FromGovHydro4Event");
    this.pgv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv4ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignPgv4ToGovHydro4Event");
    this.pgv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv4FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignPgv4FromGovHydro4Event");
    this.pgv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv5ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignPgv5ToGovHydro4Event");
    this.pgv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv5FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignPgv5FromGovHydro4Event");
    this.pgv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQn1ToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignQn1ToGovHydro4Event");
    this.qn1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQn1FromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignQn1FromGovHydro4Event");
    this.qn1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRpermToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignRpermToGovHydro4Event");
    this.rperm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRpermFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignRpermFromGovHydro4Event");
    this.rperm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRtempToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignRtempToGovHydro4Event");
    this.rtemp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRtempFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignRtempFromGovHydro4Event");
    this.rtemp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbladeToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignTbladeToGovHydro4Event");
    this.tblade = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbladeFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignTbladeFromGovHydro4Event");
    this.tblade = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTgToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignTgToGovHydro4Event");
    this.tg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTgFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignTgFromGovHydro4Event");
    this.tg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignTpToGovHydro4Event");
    this.tp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignTpFromGovHydro4Event");
    this.tp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignTrToGovHydro4Event");
    this.tr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignTrFromGovHydro4Event");
    this.tr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignTwToGovHydro4Event");
    this.tw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignTwFromGovHydro4Event");
    this.tw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUcToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignUcToGovHydro4Event");
    this.uc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUcFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignUcFromGovHydro4Event");
    this.uc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUoToGovHydro4Event event) {
    LOGGER.info("Event sourcing AssignUoToGovHydro4Event");
    this.uo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUoFromGovHydro4Event event) {
    LOGGER.info("Event sourcing UnAssignUoFromGovHydro4Event");
    this.uo = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govHydro4Id;

  private PU at = null;
  private PU bgv0 = null;
  private PU bgv1 = null;
  private PU bgv2 = null;
  private PU bgv3 = null;
  private PU bgv4 = null;
  private PU bgv5 = null;
  private Simple_Float bmax = null;
  private Frequency db1 = null;
  private ActivePower db2 = null;
  private PU dturb = null;
  private Frequency eps = null;
  private PU gmax = null;
  private PU gmin = null;
  private PU gv0 = null;
  private PU gv1 = null;
  private PU gv2 = null;
  private PU gv3 = null;
  private PU gv4 = null;
  private PU gv5 = null;
  private PU hdam = null;
  private ActivePower mwbase = null;
  private PU pgv0 = null;
  private PU pgv1 = null;
  private PU pgv2 = null;
  private PU pgv3 = null;
  private PU pgv4 = null;
  private PU pgv5 = null;
  private PU qn1 = null;
  private Seconds rperm = null;
  private Seconds rtemp = null;
  private Seconds tblade = null;
  private Seconds tg = null;
  private Seconds tp = null;
  private Seconds tr = null;
  private Seconds tw = null;
  private Simple_Float uc = null;
  private Simple_Float uo = null;

  private static final Logger LOGGER = Logger.getLogger(GovHydro4Aggregate.class.getName());
}
