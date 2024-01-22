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
 * Aggregate handler for GovSteam1 as outlined for the CQRS pattern, all write responsibilities
 * related to GovSteam1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovSteam1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovSteam1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovSteam1Aggregate(CreateGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command CreateGovSteam1Command");
    CreateGovSteam1Event event = new CreateGovSteam1Event(command.getGovSteam1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovSteam1Command command) throws Exception {
    LOGGER.info("handling command UpdateGovSteam1Command");
    UpdateGovSteam1Event event =
        new UpdateGovSteam1Event(
            command.getGovSteam1Id(),
            command.getDb1(),
            command.getDb2(),
            command.getEps(),
            command.getGv1(),
            command.getGv2(),
            command.getGv3(),
            command.getGv4(),
            command.getGv5(),
            command.getGv6(),
            command.getK(),
            command.getK1(),
            command.getK2(),
            command.getK3(),
            command.getK4(),
            command.getK5(),
            command.getK6(),
            command.getK7(),
            command.getK8(),
            command.getMwbase(),
            command.getPgv1(),
            command.getPgv2(),
            command.getPgv3(),
            command.getPgv4(),
            command.getPgv5(),
            command.getPgv6(),
            command.getPmax(),
            command.getPmin(),
            command.getSdb1(),
            command.getSdb2(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getT6(),
            command.getT7(),
            command.getUc(),
            command.getUo(),
            command.getValve());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovSteam1Command");
    apply(new DeleteGovSteam1Event(command.getGovSteam1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDb1ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignDb1ToGovSteam1Command");

    if (db1 != null && db1.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Db1 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignDb1ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb1FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb1FromGovSteam1Command");

    if (db1 == null) throw new ProcessingException("Db1 already has nothing assigned.");

    apply(new UnAssignDb1FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignDb2ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignDb2ToGovSteam1Command");

    if (db2 != null && db2.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Db2 already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignDb2ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb2FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb2FromGovSteam1Command");

    if (db2 == null) throw new ProcessingException("Db2 already has nothing assigned.");

    apply(new UnAssignDb2FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignEpsToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignEpsToGovSteam1Command");

    if (eps != null && eps.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Eps already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignEpsToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEpsFromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEpsFromGovSteam1Command");

    if (eps == null) throw new ProcessingException("Eps already has nothing assigned.");

    apply(new UnAssignEpsFromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignGv1ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignGv1ToGovSteam1Command");

    if (gv1 != null && gv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv1ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv1FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv1FromGovSteam1Command");

    if (gv1 == null) throw new ProcessingException("Gv1 already has nothing assigned.");

    apply(new UnAssignGv1FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignGv2ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignGv2ToGovSteam1Command");

    if (gv2 != null && gv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv2ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv2FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv2FromGovSteam1Command");

    if (gv2 == null) throw new ProcessingException("Gv2 already has nothing assigned.");

    apply(new UnAssignGv2FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignGv3ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignGv3ToGovSteam1Command");

    if (gv3 != null && gv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv3ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv3FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv3FromGovSteam1Command");

    if (gv3 == null) throw new ProcessingException("Gv3 already has nothing assigned.");

    apply(new UnAssignGv3FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignGv4ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignGv4ToGovSteam1Command");

    if (gv4 != null && gv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv4ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv4FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv4FromGovSteam1Command");

    if (gv4 == null) throw new ProcessingException("Gv4 already has nothing assigned.");

    apply(new UnAssignGv4FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignGv5ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignGv5ToGovSteam1Command");

    if (gv5 != null && gv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv5ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv5FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv5FromGovSteam1Command");

    if (gv5 == null) throw new ProcessingException("Gv5 already has nothing assigned.");

    apply(new UnAssignGv5FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignGv6ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignGv6ToGovSteam1Command");

    if (gv6 != null && gv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv6ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv6FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv6FromGovSteam1Command");

    if (gv6 == null) throw new ProcessingException("Gv6 already has nothing assigned.");

    apply(new UnAssignGv6FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignKToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignKToGovSteam1Command");

    if (k != null && k.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKFromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKFromGovSteam1Command");

    if (k == null) throw new ProcessingException("K already has nothing assigned.");

    apply(new UnAssignKFromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignK1ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignK1ToGovSteam1Command");

    if (k1 != null && k1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK1ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromGovSteam1Command");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignK2ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignK2ToGovSteam1Command");

    if (k2 != null && k2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK2ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK2FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK2FromGovSteam1Command");

    if (k2 == null) throw new ProcessingException("K2 already has nothing assigned.");

    apply(new UnAssignK2FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignK3ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignK3ToGovSteam1Command");

    if (k3 != null && k3.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K3 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK3ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK3FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK3FromGovSteam1Command");

    if (k3 == null) throw new ProcessingException("K3 already has nothing assigned.");

    apply(new UnAssignK3FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignK4ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignK4ToGovSteam1Command");

    if (k4 != null && k4.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K4 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK4ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK4FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK4FromGovSteam1Command");

    if (k4 == null) throw new ProcessingException("K4 already has nothing assigned.");

    apply(new UnAssignK4FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignK5ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignK5ToGovSteam1Command");

    if (k5 != null && k5.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K5 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK5ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK5FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK5FromGovSteam1Command");

    if (k5 == null) throw new ProcessingException("K5 already has nothing assigned.");

    apply(new UnAssignK5FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignK6ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignK6ToGovSteam1Command");

    if (k6 != null && k6.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K6 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK6ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK6FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK6FromGovSteam1Command");

    if (k6 == null) throw new ProcessingException("K6 already has nothing assigned.");

    apply(new UnAssignK6FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignK7ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignK7ToGovSteam1Command");

    if (k7 != null && k7.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K7 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK7ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK7FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK7FromGovSteam1Command");

    if (k7 == null) throw new ProcessingException("K7 already has nothing assigned.");

    apply(new UnAssignK7FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignK8ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignK8ToGovSteam1Command");

    if (k8 != null && k8.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K8 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK8ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK8FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK8FromGovSteam1Command");

    if (k8 == null) throw new ProcessingException("K8 already has nothing assigned.");

    apply(new UnAssignK8FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovSteam1Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovSteam1Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignPgv1ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv1ToGovSteam1Command");

    if (pgv1 != null && pgv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv1ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv1FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv1FromGovSteam1Command");

    if (pgv1 == null) throw new ProcessingException("Pgv1 already has nothing assigned.");

    apply(new UnAssignPgv1FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignPgv2ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv2ToGovSteam1Command");

    if (pgv2 != null && pgv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv2ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv2FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv2FromGovSteam1Command");

    if (pgv2 == null) throw new ProcessingException("Pgv2 already has nothing assigned.");

    apply(new UnAssignPgv2FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignPgv3ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv3ToGovSteam1Command");

    if (pgv3 != null && pgv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv3ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv3FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv3FromGovSteam1Command");

    if (pgv3 == null) throw new ProcessingException("Pgv3 already has nothing assigned.");

    apply(new UnAssignPgv3FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignPgv4ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv4ToGovSteam1Command");

    if (pgv4 != null && pgv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv4ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv4FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv4FromGovSteam1Command");

    if (pgv4 == null) throw new ProcessingException("Pgv4 already has nothing assigned.");

    apply(new UnAssignPgv4FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignPgv5ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv5ToGovSteam1Command");

    if (pgv5 != null && pgv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv5ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv5FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv5FromGovSteam1Command");

    if (pgv5 == null) throw new ProcessingException("Pgv5 already has nothing assigned.");

    apply(new UnAssignPgv5FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignPgv6ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv6ToGovSteam1Command");

    if (pgv6 != null && pgv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv6ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv6FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv6FromGovSteam1Command");

    if (pgv6 == null) throw new ProcessingException("Pgv6 already has nothing assigned.");

    apply(new UnAssignPgv6FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignPmaxToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignPmaxToGovSteam1Command");

    if (pmax != null && pmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmaxToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxFromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxFromGovSteam1Command");

    if (pmax == null) throw new ProcessingException("Pmax already has nothing assigned.");

    apply(new UnAssignPmaxFromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignPminToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignPminToGovSteam1Command");

    if (pmin != null && pmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPminToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromGovSteam1Command");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignSdb1ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignSdb1ToGovSteam1Command");

    if (sdb1 != null && sdb1.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Sdb1 already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignSdb1ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSdb1FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSdb1FromGovSteam1Command");

    if (sdb1 == null) throw new ProcessingException("Sdb1 already has nothing assigned.");

    apply(new UnAssignSdb1FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignSdb2ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignSdb2ToGovSteam1Command");

    if (sdb2 != null && sdb2.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Sdb2 already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignSdb2ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSdb2FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSdb2FromGovSteam1Command");

    if (sdb2 == null) throw new ProcessingException("Sdb2 already has nothing assigned.");

    apply(new UnAssignSdb2FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToGovSteam1Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromGovSteam1Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignT2ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignT2ToGovSteam1Command");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromGovSteam1Command");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToGovSteam1Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromGovSteam1Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignT4ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignT4ToGovSteam1Command");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromGovSteam1Command");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignT5ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignT5ToGovSteam1Command");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromGovSteam1Command");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignT6ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignT6ToGovSteam1Command");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromGovSteam1Command");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignT7ToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignT7ToGovSteam1Command");

    if (t7 != null && t7.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T7 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT7ToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT7FromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT7FromGovSteam1Command");

    if (t7 == null) throw new ProcessingException("T7 already has nothing assigned.");

    apply(new UnAssignT7FromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignUcToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignUcToGovSteam1Command");

    if (uc != null && uc.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Uc already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignUcToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUcFromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignUcFromGovSteam1Command");

    if (uc == null) throw new ProcessingException("Uc already has nothing assigned.");

    apply(new UnAssignUcFromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignUoToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignUoToGovSteam1Command");

    if (uo != null && uo.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Uo already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignUoToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUoFromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignUoFromGovSteam1Command");

    if (uo == null) throw new ProcessingException("Uo already has nothing assigned.");

    apply(new UnAssignUoFromGovSteam1Event(command.getGovSteam1Id()));
  }

  @CommandHandler
  public void handle(AssignValveToGovSteam1Command command) throws Exception {
    LOGGER.info("Handling command AssignValveToGovSteam1Command");

    if (valve != null && valve.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Valve already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignValveToGovSteam1Event(command.getGovSteam1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValveFromGovSteam1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignValveFromGovSteam1Command");

    if (valve == null) throw new ProcessingException("Valve already has nothing assigned.");

    apply(new UnAssignValveFromGovSteam1Event(command.getGovSteam1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovSteam1Event event) {
    LOGGER.info("Event sourcing CreateGovSteam1Event");
    this.govSteam1Id = event.getGovSteam1Id();
  }

  @EventSourcingHandler
  void on(UpdateGovSteam1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.db1 = event.getDb1();
    this.db2 = event.getDb2();
    this.eps = event.getEps();
    this.gv1 = event.getGv1();
    this.gv2 = event.getGv2();
    this.gv3 = event.getGv3();
    this.gv4 = event.getGv4();
    this.gv5 = event.getGv5();
    this.gv6 = event.getGv6();
    this.k = event.getK();
    this.k1 = event.getK1();
    this.k2 = event.getK2();
    this.k3 = event.getK3();
    this.k4 = event.getK4();
    this.k5 = event.getK5();
    this.k6 = event.getK6();
    this.k7 = event.getK7();
    this.k8 = event.getK8();
    this.mwbase = event.getMwbase();
    this.pgv1 = event.getPgv1();
    this.pgv2 = event.getPgv2();
    this.pgv3 = event.getPgv3();
    this.pgv4 = event.getPgv4();
    this.pgv5 = event.getPgv5();
    this.pgv6 = event.getPgv6();
    this.pmax = event.getPmax();
    this.pmin = event.getPmin();
    this.sdb1 = event.getSdb1();
    this.sdb2 = event.getSdb2();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.t6 = event.getT6();
    this.t7 = event.getT7();
    this.uc = event.getUc();
    this.uo = event.getUo();
    this.valve = event.getValve();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDb1ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignDb1ToGovSteam1Event");
    this.db1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb1FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignDb1FromGovSteam1Event");
    this.db1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb2ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignDb2ToGovSteam1Event");
    this.db2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb2FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignDb2FromGovSteam1Event");
    this.db2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEpsToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignEpsToGovSteam1Event");
    this.eps = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEpsFromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignEpsFromGovSteam1Event");
    this.eps = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv1ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignGv1ToGovSteam1Event");
    this.gv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv1FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignGv1FromGovSteam1Event");
    this.gv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv2ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignGv2ToGovSteam1Event");
    this.gv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv2FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignGv2FromGovSteam1Event");
    this.gv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv3ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignGv3ToGovSteam1Event");
    this.gv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv3FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignGv3FromGovSteam1Event");
    this.gv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv4ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignGv4ToGovSteam1Event");
    this.gv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv4FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignGv4FromGovSteam1Event");
    this.gv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv5ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignGv5ToGovSteam1Event");
    this.gv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv5FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignGv5FromGovSteam1Event");
    this.gv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv6ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignGv6ToGovSteam1Event");
    this.gv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv6FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignGv6FromGovSteam1Event");
    this.gv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignKToGovSteam1Event");
    this.k = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKFromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignKFromGovSteam1Event");
    this.k = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignK1ToGovSteam1Event");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignK1FromGovSteam1Event");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK2ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignK2ToGovSteam1Event");
    this.k2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK2FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignK2FromGovSteam1Event");
    this.k2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK3ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignK3ToGovSteam1Event");
    this.k3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK3FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignK3FromGovSteam1Event");
    this.k3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK4ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignK4ToGovSteam1Event");
    this.k4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK4FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignK4FromGovSteam1Event");
    this.k4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK5ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignK5ToGovSteam1Event");
    this.k5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK5FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignK5FromGovSteam1Event");
    this.k5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK6ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignK6ToGovSteam1Event");
    this.k6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK6FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignK6FromGovSteam1Event");
    this.k6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK7ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignK7ToGovSteam1Event");
    this.k7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK7FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignK7FromGovSteam1Event");
    this.k7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK8ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignK8ToGovSteam1Event");
    this.k8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK8FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignK8FromGovSteam1Event");
    this.k8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovSteam1Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovSteam1Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv1ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignPgv1ToGovSteam1Event");
    this.pgv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv1FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignPgv1FromGovSteam1Event");
    this.pgv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv2ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignPgv2ToGovSteam1Event");
    this.pgv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv2FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignPgv2FromGovSteam1Event");
    this.pgv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv3ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignPgv3ToGovSteam1Event");
    this.pgv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv3FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignPgv3FromGovSteam1Event");
    this.pgv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv4ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignPgv4ToGovSteam1Event");
    this.pgv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv4FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignPgv4FromGovSteam1Event");
    this.pgv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv5ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignPgv5ToGovSteam1Event");
    this.pgv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv5FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignPgv5FromGovSteam1Event");
    this.pgv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv6ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignPgv6ToGovSteam1Event");
    this.pgv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv6FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignPgv6FromGovSteam1Event");
    this.pgv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignPmaxToGovSteam1Event");
    this.pmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxFromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignPmaxFromGovSteam1Event");
    this.pmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignPminToGovSteam1Event");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignPminFromGovSteam1Event");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSdb1ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignSdb1ToGovSteam1Event");
    this.sdb1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSdb1FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignSdb1FromGovSteam1Event");
    this.sdb1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSdb2ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignSdb2ToGovSteam1Event");
    this.sdb2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSdb2FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignSdb2FromGovSteam1Event");
    this.sdb2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignT1ToGovSteam1Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromGovSteam1Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignT2ToGovSteam1Event");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignT2FromGovSteam1Event");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignT3ToGovSteam1Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromGovSteam1Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignT4ToGovSteam1Event");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignT4FromGovSteam1Event");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignT5ToGovSteam1Event");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignT5FromGovSteam1Event");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignT6ToGovSteam1Event");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignT6FromGovSteam1Event");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT7ToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignT7ToGovSteam1Event");
    this.t7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT7FromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignT7FromGovSteam1Event");
    this.t7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUcToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignUcToGovSteam1Event");
    this.uc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUcFromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignUcFromGovSteam1Event");
    this.uc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUoToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignUoToGovSteam1Event");
    this.uo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUoFromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignUoFromGovSteam1Event");
    this.uo = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignValveToGovSteam1Event event) {
    LOGGER.info("Event sourcing AssignValveToGovSteam1Event");
    this.valve = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValveFromGovSteam1Event event) {
    LOGGER.info("Event sourcing UnAssignValveFromGovSteam1Event");
    this.valve = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govSteam1Id;

  private Frequency db1 = null;
  private ActivePower db2 = null;
  private Frequency eps = null;
  private PU gv1 = null;
  private PU gv2 = null;
  private PU gv3 = null;
  private PU gv4 = null;
  private PU gv5 = null;
  private PU gv6 = null;
  private PU k = null;
  private Simple_Float k1 = null;
  private Simple_Float k2 = null;
  private Simple_Float k3 = null;
  private Simple_Float k4 = null;
  private Simple_Float k5 = null;
  private Simple_Float k6 = null;
  private Simple_Float k7 = null;
  private Simple_Float k8 = null;
  private ActivePower mwbase = null;
  private PU pgv1 = null;
  private PU pgv2 = null;
  private PU pgv3 = null;
  private PU pgv4 = null;
  private PU pgv5 = null;
  private PU pgv6 = null;
  private PU pmax = null;
  private PU pmin = null;
  private BooleanProxy sdb1 = null;
  private BooleanProxy sdb2 = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Seconds t6 = null;
  private Seconds t7 = null;
  private Simple_Float uc = null;
  private Simple_Float uo = null;
  private BooleanProxy valve = null;

  private static final Logger LOGGER = Logger.getLogger(GovSteam1Aggregate.class.getName());
}
