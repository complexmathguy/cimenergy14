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
 * Aggregate handler for GovHydroPID as outlined for the CQRS pattern, all write responsibilities
 * related to GovHydroPID are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovHydroPIDAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovHydroPIDAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovHydroPIDAggregate(CreateGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command CreateGovHydroPIDCommand");
    CreateGovHydroPIDEvent event = new CreateGovHydroPIDEvent(command.getGovHydroPIDId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovHydroPIDCommand command) throws Exception {
    LOGGER.info("handling command UpdateGovHydroPIDCommand");
    UpdateGovHydroPIDEvent event =
        new UpdateGovHydroPIDEvent(
            command.getGovHydroPIDId(),
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
            command.getInputSignal(),
            command.getKd(),
            command.getKg(),
            command.getKi(),
            command.getKp(),
            command.getMwbase(),
            command.getPgv1(),
            command.getPgv2(),
            command.getPgv3(),
            command.getPgv4(),
            command.getPgv5(),
            command.getPgv6(),
            command.getPmax(),
            command.getPmin(),
            command.getR(),
            command.getTd(),
            command.getTf(),
            command.getTp(),
            command.getTt(),
            command.getTturb(),
            command.getVelcl(),
            command.getVelop());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGovHydroPIDCommand");
    apply(new DeleteGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAturbToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignAturbToGovHydroPIDCommand");

    if (aturb != null && aturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Aturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAturbToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAturbFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAturbFromGovHydroPIDCommand");

    if (aturb == null) throw new ProcessingException("Aturb already has nothing assigned.");

    apply(new UnAssignAturbFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignBturbToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignBturbToGovHydroPIDCommand");

    if (bturb != null && bturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBturbToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBturbFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBturbFromGovHydroPIDCommand");

    if (bturb == null) throw new ProcessingException("Bturb already has nothing assigned.");

    apply(new UnAssignBturbFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignDb1ToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignDb1ToGovHydroPIDCommand");

    if (db1 != null && db1.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Db1 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignDb1ToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb1FromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb1FromGovHydroPIDCommand");

    if (db1 == null) throw new ProcessingException("Db1 already has nothing assigned.");

    apply(new UnAssignDb1FromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignDb2ToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignDb2ToGovHydroPIDCommand");

    if (db2 != null && db2.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Db2 already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignDb2ToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb2FromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb2FromGovHydroPIDCommand");

    if (db2 == null) throw new ProcessingException("Db2 already has nothing assigned.");

    apply(new UnAssignDb2FromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignEpsToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignEpsToGovHydroPIDCommand");

    if (eps != null && eps.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Eps already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignEpsToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEpsFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEpsFromGovHydroPIDCommand");

    if (eps == null) throw new ProcessingException("Eps already has nothing assigned.");

    apply(new UnAssignEpsFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignGv1ToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv1ToGovHydroPIDCommand");

    if (gv1 != null && gv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv1ToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv1FromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv1FromGovHydroPIDCommand");

    if (gv1 == null) throw new ProcessingException("Gv1 already has nothing assigned.");

    apply(new UnAssignGv1FromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignGv2ToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv2ToGovHydroPIDCommand");

    if (gv2 != null && gv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv2ToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv2FromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv2FromGovHydroPIDCommand");

    if (gv2 == null) throw new ProcessingException("Gv2 already has nothing assigned.");

    apply(new UnAssignGv2FromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignGv3ToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv3ToGovHydroPIDCommand");

    if (gv3 != null && gv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv3ToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv3FromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv3FromGovHydroPIDCommand");

    if (gv3 == null) throw new ProcessingException("Gv3 already has nothing assigned.");

    apply(new UnAssignGv3FromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignGv4ToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv4ToGovHydroPIDCommand");

    if (gv4 != null && gv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv4ToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv4FromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv4FromGovHydroPIDCommand");

    if (gv4 == null) throw new ProcessingException("Gv4 already has nothing assigned.");

    apply(new UnAssignGv4FromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignGv5ToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv5ToGovHydroPIDCommand");

    if (gv5 != null && gv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv5ToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv5FromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv5FromGovHydroPIDCommand");

    if (gv5 == null) throw new ProcessingException("Gv5 already has nothing assigned.");

    apply(new UnAssignGv5FromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignGv6ToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv6ToGovHydroPIDCommand");

    if (gv6 != null && gv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv6ToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv6FromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv6FromGovHydroPIDCommand");

    if (gv6 == null) throw new ProcessingException("Gv6 already has nothing assigned.");

    apply(new UnAssignGv6FromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignInputSignalToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignInputSignalToGovHydroPIDCommand");

    if (inputSignal != null
        && inputSignal.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "InputSignal already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignInputSignalToGovHydroPIDEvent(
            command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignInputSignalFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignInputSignalFromGovHydroPIDCommand");

    if (inputSignal == null)
      throw new ProcessingException("InputSignal already has nothing assigned.");

    apply(new UnAssignInputSignalFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignKdToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToGovHydroPIDCommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromGovHydroPIDCommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignKgToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignKgToGovHydroPIDCommand");

    if (kg != null && kg.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kg already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKgToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKgFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKgFromGovHydroPIDCommand");

    if (kg == null) throw new ProcessingException("Kg already has nothing assigned.");

    apply(new UnAssignKgFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignKiToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToGovHydroPIDCommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromGovHydroPIDCommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignKpToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToGovHydroPIDCommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromGovHydroPIDCommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovHydroPIDCommand");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovHydroPIDCommand");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignPgv1ToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv1ToGovHydroPIDCommand");

    if (pgv1 != null && pgv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv1ToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv1FromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv1FromGovHydroPIDCommand");

    if (pgv1 == null) throw new ProcessingException("Pgv1 already has nothing assigned.");

    apply(new UnAssignPgv1FromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignPgv2ToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv2ToGovHydroPIDCommand");

    if (pgv2 != null && pgv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv2ToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv2FromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv2FromGovHydroPIDCommand");

    if (pgv2 == null) throw new ProcessingException("Pgv2 already has nothing assigned.");

    apply(new UnAssignPgv2FromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignPgv3ToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv3ToGovHydroPIDCommand");

    if (pgv3 != null && pgv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv3ToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv3FromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv3FromGovHydroPIDCommand");

    if (pgv3 == null) throw new ProcessingException("Pgv3 already has nothing assigned.");

    apply(new UnAssignPgv3FromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignPgv4ToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv4ToGovHydroPIDCommand");

    if (pgv4 != null && pgv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv4ToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv4FromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv4FromGovHydroPIDCommand");

    if (pgv4 == null) throw new ProcessingException("Pgv4 already has nothing assigned.");

    apply(new UnAssignPgv4FromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignPgv5ToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv5ToGovHydroPIDCommand");

    if (pgv5 != null && pgv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv5ToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv5FromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv5FromGovHydroPIDCommand");

    if (pgv5 == null) throw new ProcessingException("Pgv5 already has nothing assigned.");

    apply(new UnAssignPgv5FromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignPgv6ToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv6ToGovHydroPIDCommand");

    if (pgv6 != null && pgv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv6ToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv6FromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv6FromGovHydroPIDCommand");

    if (pgv6 == null) throw new ProcessingException("Pgv6 already has nothing assigned.");

    apply(new UnAssignPgv6FromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignPmaxToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmaxToGovHydroPIDCommand");

    if (pmax != null && pmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmaxToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxFromGovHydroPIDCommand");

    if (pmax == null) throw new ProcessingException("Pmax already has nothing assigned.");

    apply(new UnAssignPmaxFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignPminToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPminToGovHydroPIDCommand");

    if (pmin != null && pmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPminToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromGovHydroPIDCommand");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignRToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignRToGovHydroPIDCommand");

    if (r != null && r.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromGovHydroPIDCommand");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignTdToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTdToGovHydroPIDCommand");

    if (td != null && td.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Td already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdFromGovHydroPIDCommand");

    if (td == null) throw new ProcessingException("Td already has nothing assigned.");

    apply(new UnAssignTdFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignTfToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToGovHydroPIDCommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromGovHydroPIDCommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignTpToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpToGovHydroPIDCommand");

    if (tp != null && tp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpFromGovHydroPIDCommand");

    if (tp == null) throw new ProcessingException("Tp already has nothing assigned.");

    apply(new UnAssignTpFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignTtToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTtToGovHydroPIDCommand");

    if (tt != null && tt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tt already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTtToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTtFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTtFromGovHydroPIDCommand");

    if (tt == null) throw new ProcessingException("Tt already has nothing assigned.");

    apply(new UnAssignTtFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignTturbToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTturbToGovHydroPIDCommand");

    if (tturb != null && tturb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tturb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTturbToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTturbFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTturbFromGovHydroPIDCommand");

    if (tturb == null) throw new ProcessingException("Tturb already has nothing assigned.");

    apply(new UnAssignTturbFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignVelclToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignVelclToGovHydroPIDCommand");

    if (velcl != null && velcl.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Velcl already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignVelclToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVelclFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVelclFromGovHydroPIDCommand");

    if (velcl == null) throw new ProcessingException("Velcl already has nothing assigned.");

    apply(new UnAssignVelclFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  @CommandHandler
  public void handle(AssignVelopToGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handling command AssignVelopToGovHydroPIDCommand");

    if (velop != null && velop.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Velop already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignVelopToGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVelopFromGovHydroPIDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVelopFromGovHydroPIDCommand");

    if (velop == null) throw new ProcessingException("Velop already has nothing assigned.");

    apply(new UnAssignVelopFromGovHydroPIDEvent(command.getGovHydroPIDId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing CreateGovHydroPIDEvent");
    this.govHydroPIDId = event.getGovHydroPIDId();
  }

  @EventSourcingHandler
  void on(UpdateGovHydroPIDEvent event) {
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
    this.inputSignal = event.getInputSignal();
    this.kd = event.getKd();
    this.kg = event.getKg();
    this.ki = event.getKi();
    this.kp = event.getKp();
    this.mwbase = event.getMwbase();
    this.pgv1 = event.getPgv1();
    this.pgv2 = event.getPgv2();
    this.pgv3 = event.getPgv3();
    this.pgv4 = event.getPgv4();
    this.pgv5 = event.getPgv5();
    this.pgv6 = event.getPgv6();
    this.pmax = event.getPmax();
    this.pmin = event.getPmin();
    this.r = event.getR();
    this.td = event.getTd();
    this.tf = event.getTf();
    this.tp = event.getTp();
    this.tt = event.getTt();
    this.tturb = event.getTturb();
    this.velcl = event.getVelcl();
    this.velop = event.getVelop();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAturbToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignAturbToGovHydroPIDEvent");
    this.aturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAturbFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignAturbFromGovHydroPIDEvent");
    this.aturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBturbToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignBturbToGovHydroPIDEvent");
    this.bturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBturbFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignBturbFromGovHydroPIDEvent");
    this.bturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb1ToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignDb1ToGovHydroPIDEvent");
    this.db1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb1FromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignDb1FromGovHydroPIDEvent");
    this.db1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb2ToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignDb2ToGovHydroPIDEvent");
    this.db2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb2FromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignDb2FromGovHydroPIDEvent");
    this.db2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEpsToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignEpsToGovHydroPIDEvent");
    this.eps = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEpsFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignEpsFromGovHydroPIDEvent");
    this.eps = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv1ToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignGv1ToGovHydroPIDEvent");
    this.gv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv1FromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv1FromGovHydroPIDEvent");
    this.gv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv2ToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignGv2ToGovHydroPIDEvent");
    this.gv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv2FromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv2FromGovHydroPIDEvent");
    this.gv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv3ToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignGv3ToGovHydroPIDEvent");
    this.gv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv3FromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv3FromGovHydroPIDEvent");
    this.gv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv4ToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignGv4ToGovHydroPIDEvent");
    this.gv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv4FromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv4FromGovHydroPIDEvent");
    this.gv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv5ToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignGv5ToGovHydroPIDEvent");
    this.gv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv5FromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv5FromGovHydroPIDEvent");
    this.gv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv6ToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignGv6ToGovHydroPIDEvent");
    this.gv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv6FromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv6FromGovHydroPIDEvent");
    this.gv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignInputSignalToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignInputSignalToGovHydroPIDEvent");
    this.inputSignal = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignInputSignalFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignInputSignalFromGovHydroPIDEvent");
    this.inputSignal = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignKdToGovHydroPIDEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromGovHydroPIDEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKgToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignKgToGovHydroPIDEvent");
    this.kg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKgFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignKgFromGovHydroPIDEvent");
    this.kg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignKiToGovHydroPIDEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromGovHydroPIDEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignKpToGovHydroPIDEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromGovHydroPIDEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovHydroPIDEvent");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovHydroPIDEvent");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv1ToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignPgv1ToGovHydroPIDEvent");
    this.pgv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv1FromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv1FromGovHydroPIDEvent");
    this.pgv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv2ToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignPgv2ToGovHydroPIDEvent");
    this.pgv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv2FromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv2FromGovHydroPIDEvent");
    this.pgv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv3ToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignPgv3ToGovHydroPIDEvent");
    this.pgv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv3FromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv3FromGovHydroPIDEvent");
    this.pgv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv4ToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignPgv4ToGovHydroPIDEvent");
    this.pgv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv4FromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv4FromGovHydroPIDEvent");
    this.pgv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv5ToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignPgv5ToGovHydroPIDEvent");
    this.pgv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv5FromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv5FromGovHydroPIDEvent");
    this.pgv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv6ToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignPgv6ToGovHydroPIDEvent");
    this.pgv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv6FromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv6FromGovHydroPIDEvent");
    this.pgv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignPmaxToGovHydroPIDEvent");
    this.pmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignPmaxFromGovHydroPIDEvent");
    this.pmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignPminToGovHydroPIDEvent");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignPminFromGovHydroPIDEvent");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignRToGovHydroPIDEvent");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignRFromGovHydroPIDEvent");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignTdToGovHydroPIDEvent");
    this.td = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignTdFromGovHydroPIDEvent");
    this.td = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignTfToGovHydroPIDEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromGovHydroPIDEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignTpToGovHydroPIDEvent");
    this.tp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignTpFromGovHydroPIDEvent");
    this.tp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTtToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignTtToGovHydroPIDEvent");
    this.tt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTtFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignTtFromGovHydroPIDEvent");
    this.tt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTturbToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignTturbToGovHydroPIDEvent");
    this.tturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTturbFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignTturbFromGovHydroPIDEvent");
    this.tturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVelclToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignVelclToGovHydroPIDEvent");
    this.velcl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVelclFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignVelclFromGovHydroPIDEvent");
    this.velcl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVelopToGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing AssignVelopToGovHydroPIDEvent");
    this.velop = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVelopFromGovHydroPIDEvent event) {
    LOGGER.info("Event sourcing UnAssignVelopFromGovHydroPIDEvent");
    this.velop = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govHydroPIDId;

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
  private BooleanProxy inputSignal = null;
  private PU kd = null;
  private PU kg = null;
  private PU ki = null;
  private PU kp = null;
  private ActivePower mwbase = null;
  private PU pgv1 = null;
  private PU pgv2 = null;
  private PU pgv3 = null;
  private PU pgv4 = null;
  private PU pgv5 = null;
  private PU pgv6 = null;
  private PU pmax = null;
  private PU pmin = null;
  private PU r = null;
  private Seconds td = null;
  private Seconds tf = null;
  private Seconds tp = null;
  private Seconds tt = null;
  private Seconds tturb = null;
  private Simple_Float velcl = null;
  private Simple_Float velop = null;

  private static final Logger LOGGER = Logger.getLogger(GovHydroPIDAggregate.class.getName());
}
