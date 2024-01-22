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
 * Aggregate handler for GovHydro3 as outlined for the CQRS pattern, all write responsibilities
 * related to GovHydro3 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovHydro3Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovHydro3Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovHydro3Aggregate(CreateGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command CreateGovHydro3Command");
    CreateGovHydro3Event event = new CreateGovHydro3Event(command.getGovHydro3Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovHydro3Command command) throws Exception {
    LOGGER.info("handling command UpdateGovHydro3Command");
    UpdateGovHydro3Event event =
        new UpdateGovHydro3Event(
            command.getGovHydro3Id(),
            command.getAt(),
            command.getDb1(),
            command.getDb2(),
            command.getDturb(),
            command.getEps(),
            command.getGovernorControl(),
            command.getGv1(),
            command.getGv2(),
            command.getGv3(),
            command.getGv4(),
            command.getGv5(),
            command.getGv6(),
            command.getH0(),
            command.getK1(),
            command.getK2(),
            command.getKg(),
            command.getKi(),
            command.getMwbase(),
            command.getPgv1(),
            command.getPgv2(),
            command.getPgv3(),
            command.getPgv4(),
            command.getPgv5(),
            command.getPgv6(),
            command.getPmax(),
            command.getPmin(),
            command.getQnl(),
            command.getRelec(),
            command.getRgate(),
            command.getTd(),
            command.getTf(),
            command.getTp(),
            command.getTt(),
            command.getTw(),
            command.getVelcl(),
            command.getVelop());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovHydro3Command");
    apply(new DeleteGovHydro3Event(command.getGovHydro3Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAtToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignAtToGovHydro3Command");

    if (at != null && at.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "At already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAtToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAtFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAtFromGovHydro3Command");

    if (at == null) throw new ProcessingException("At already has nothing assigned.");

    apply(new UnAssignAtFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignDb1ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignDb1ToGovHydro3Command");

    if (db1 != null && db1.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Db1 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignDb1ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb1FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb1FromGovHydro3Command");

    if (db1 == null) throw new ProcessingException("Db1 already has nothing assigned.");

    apply(new UnAssignDb1FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignDb2ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignDb2ToGovHydro3Command");

    if (db2 != null && db2.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Db2 already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignDb2ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb2FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb2FromGovHydro3Command");

    if (db2 == null) throw new ProcessingException("Db2 already has nothing assigned.");

    apply(new UnAssignDb2FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignDturbToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignDturbToGovHydro3Command");

    if (dturb != null && dturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDturbToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDturbFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDturbFromGovHydro3Command");

    if (dturb == null) throw new ProcessingException("Dturb already has nothing assigned.");

    apply(new UnAssignDturbFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignEpsToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignEpsToGovHydro3Command");

    if (eps != null && eps.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Eps already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignEpsToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEpsFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEpsFromGovHydro3Command");

    if (eps == null) throw new ProcessingException("Eps already has nothing assigned.");

    apply(new UnAssignEpsFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignGovernorControlToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignGovernorControlToGovHydro3Command");

    if (governorControl != null
        && governorControl.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "GovernorControl already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignGovernorControlToGovHydro3Event(
            command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGovernorControlFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGovernorControlFromGovHydro3Command");

    if (governorControl == null)
      throw new ProcessingException("GovernorControl already has nothing assigned.");

    apply(new UnAssignGovernorControlFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignGv1ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignGv1ToGovHydro3Command");

    if (gv1 != null && gv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv1ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv1FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv1FromGovHydro3Command");

    if (gv1 == null) throw new ProcessingException("Gv1 already has nothing assigned.");

    apply(new UnAssignGv1FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignGv2ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignGv2ToGovHydro3Command");

    if (gv2 != null && gv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv2ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv2FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv2FromGovHydro3Command");

    if (gv2 == null) throw new ProcessingException("Gv2 already has nothing assigned.");

    apply(new UnAssignGv2FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignGv3ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignGv3ToGovHydro3Command");

    if (gv3 != null && gv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv3ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv3FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv3FromGovHydro3Command");

    if (gv3 == null) throw new ProcessingException("Gv3 already has nothing assigned.");

    apply(new UnAssignGv3FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignGv4ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignGv4ToGovHydro3Command");

    if (gv4 != null && gv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv4ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv4FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv4FromGovHydro3Command");

    if (gv4 == null) throw new ProcessingException("Gv4 already has nothing assigned.");

    apply(new UnAssignGv4FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignGv5ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignGv5ToGovHydro3Command");

    if (gv5 != null && gv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv5ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv5FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv5FromGovHydro3Command");

    if (gv5 == null) throw new ProcessingException("Gv5 already has nothing assigned.");

    apply(new UnAssignGv5FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignGv6ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignGv6ToGovHydro3Command");

    if (gv6 != null && gv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv6ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv6FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv6FromGovHydro3Command");

    if (gv6 == null) throw new ProcessingException("Gv6 already has nothing assigned.");

    apply(new UnAssignGv6FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignH0ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignH0ToGovHydro3Command");

    if (h0 != null && h0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "H0 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignH0ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignH0FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignH0FromGovHydro3Command");

    if (h0 == null) throw new ProcessingException("H0 already has nothing assigned.");

    apply(new UnAssignH0FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignK1ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignK1ToGovHydro3Command");

    if (k1 != null && k1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK1ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromGovHydro3Command");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignK2ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignK2ToGovHydro3Command");

    if (k2 != null && k2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK2ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK2FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK2FromGovHydro3Command");

    if (k2 == null) throw new ProcessingException("K2 already has nothing assigned.");

    apply(new UnAssignK2FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignKgToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignKgToGovHydro3Command");

    if (kg != null && kg.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kg already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKgToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKgFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKgFromGovHydro3Command");

    if (kg == null) throw new ProcessingException("Kg already has nothing assigned.");

    apply(new UnAssignKgFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignKiToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignKiToGovHydro3Command");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromGovHydro3Command");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovHydro3Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovHydro3Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignPgv1ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv1ToGovHydro3Command");

    if (pgv1 != null && pgv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv1ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv1FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv1FromGovHydro3Command");

    if (pgv1 == null) throw new ProcessingException("Pgv1 already has nothing assigned.");

    apply(new UnAssignPgv1FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignPgv2ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv2ToGovHydro3Command");

    if (pgv2 != null && pgv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv2ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv2FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv2FromGovHydro3Command");

    if (pgv2 == null) throw new ProcessingException("Pgv2 already has nothing assigned.");

    apply(new UnAssignPgv2FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignPgv3ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv3ToGovHydro3Command");

    if (pgv3 != null && pgv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv3ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv3FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv3FromGovHydro3Command");

    if (pgv3 == null) throw new ProcessingException("Pgv3 already has nothing assigned.");

    apply(new UnAssignPgv3FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignPgv4ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv4ToGovHydro3Command");

    if (pgv4 != null && pgv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv4ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv4FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv4FromGovHydro3Command");

    if (pgv4 == null) throw new ProcessingException("Pgv4 already has nothing assigned.");

    apply(new UnAssignPgv4FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignPgv5ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv5ToGovHydro3Command");

    if (pgv5 != null && pgv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv5ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv5FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv5FromGovHydro3Command");

    if (pgv5 == null) throw new ProcessingException("Pgv5 already has nothing assigned.");

    apply(new UnAssignPgv5FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignPgv6ToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignPgv6ToGovHydro3Command");

    if (pgv6 != null && pgv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv6ToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv6FromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv6FromGovHydro3Command");

    if (pgv6 == null) throw new ProcessingException("Pgv6 already has nothing assigned.");

    apply(new UnAssignPgv6FromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignPmaxToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignPmaxToGovHydro3Command");

    if (pmax != null && pmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmaxToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxFromGovHydro3Command");

    if (pmax == null) throw new ProcessingException("Pmax already has nothing assigned.");

    apply(new UnAssignPmaxFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignPminToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignPminToGovHydro3Command");

    if (pmin != null && pmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPminToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromGovHydro3Command");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignQnlToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignQnlToGovHydro3Command");

    if (qnl != null && qnl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Qnl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignQnlToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQnlFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQnlFromGovHydro3Command");

    if (qnl == null) throw new ProcessingException("Qnl already has nothing assigned.");

    apply(new UnAssignQnlFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignRelecToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignRelecToGovHydro3Command");

    if (relec != null && relec.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Relec already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRelecToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRelecFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRelecFromGovHydro3Command");

    if (relec == null) throw new ProcessingException("Relec already has nothing assigned.");

    apply(new UnAssignRelecFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignRgateToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignRgateToGovHydro3Command");

    if (rgate != null && rgate.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rgate already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRgateToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRgateFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRgateFromGovHydro3Command");

    if (rgate == null) throw new ProcessingException("Rgate already has nothing assigned.");

    apply(new UnAssignRgateFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignTdToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignTdToGovHydro3Command");

    if (td != null && td.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Td already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdFromGovHydro3Command");

    if (td == null) throw new ProcessingException("Td already has nothing assigned.");

    apply(new UnAssignTdFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignTfToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignTfToGovHydro3Command");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromGovHydro3Command");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignTpToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignTpToGovHydro3Command");

    if (tp != null && tp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpFromGovHydro3Command");

    if (tp == null) throw new ProcessingException("Tp already has nothing assigned.");

    apply(new UnAssignTpFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignTtToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignTtToGovHydro3Command");

    if (tt != null && tt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tt already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTtToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTtFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTtFromGovHydro3Command");

    if (tt == null) throw new ProcessingException("Tt already has nothing assigned.");

    apply(new UnAssignTtFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignTwToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignTwToGovHydro3Command");

    if (tw != null && tw.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTwToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwFromGovHydro3Command");

    if (tw == null) throw new ProcessingException("Tw already has nothing assigned.");

    apply(new UnAssignTwFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignVelclToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignVelclToGovHydro3Command");

    if (velcl != null && velcl.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Velcl already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignVelclToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVelclFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVelclFromGovHydro3Command");

    if (velcl == null) throw new ProcessingException("Velcl already has nothing assigned.");

    apply(new UnAssignVelclFromGovHydro3Event(command.getGovHydro3Id()));
  }

  @CommandHandler
  public void handle(AssignVelopToGovHydro3Command command) throws Exception {
    LOGGER.info("Handling command AssignVelopToGovHydro3Command");

    if (velop != null && velop.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Velop already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignVelopToGovHydro3Event(command.getGovHydro3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVelopFromGovHydro3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVelopFromGovHydro3Command");

    if (velop == null) throw new ProcessingException("Velop already has nothing assigned.");

    apply(new UnAssignVelopFromGovHydro3Event(command.getGovHydro3Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovHydro3Event event) {
    LOGGER.info("Event sourcing CreateGovHydro3Event");
    this.govHydro3Id = event.getGovHydro3Id();
  }

  @EventSourcingHandler
  void on(UpdateGovHydro3Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.at = event.getAt();
    this.db1 = event.getDb1();
    this.db2 = event.getDb2();
    this.dturb = event.getDturb();
    this.eps = event.getEps();
    this.governorControl = event.getGovernorControl();
    this.gv1 = event.getGv1();
    this.gv2 = event.getGv2();
    this.gv3 = event.getGv3();
    this.gv4 = event.getGv4();
    this.gv5 = event.getGv5();
    this.gv6 = event.getGv6();
    this.h0 = event.getH0();
    this.k1 = event.getK1();
    this.k2 = event.getK2();
    this.kg = event.getKg();
    this.ki = event.getKi();
    this.mwbase = event.getMwbase();
    this.pgv1 = event.getPgv1();
    this.pgv2 = event.getPgv2();
    this.pgv3 = event.getPgv3();
    this.pgv4 = event.getPgv4();
    this.pgv5 = event.getPgv5();
    this.pgv6 = event.getPgv6();
    this.pmax = event.getPmax();
    this.pmin = event.getPmin();
    this.qnl = event.getQnl();
    this.relec = event.getRelec();
    this.rgate = event.getRgate();
    this.td = event.getTd();
    this.tf = event.getTf();
    this.tp = event.getTp();
    this.tt = event.getTt();
    this.tw = event.getTw();
    this.velcl = event.getVelcl();
    this.velop = event.getVelop();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAtToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignAtToGovHydro3Event");
    this.at = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAtFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignAtFromGovHydro3Event");
    this.at = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb1ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignDb1ToGovHydro3Event");
    this.db1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb1FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignDb1FromGovHydro3Event");
    this.db1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb2ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignDb2ToGovHydro3Event");
    this.db2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb2FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignDb2FromGovHydro3Event");
    this.db2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDturbToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignDturbToGovHydro3Event");
    this.dturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDturbFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignDturbFromGovHydro3Event");
    this.dturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEpsToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignEpsToGovHydro3Event");
    this.eps = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEpsFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignEpsFromGovHydro3Event");
    this.eps = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGovernorControlToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignGovernorControlToGovHydro3Event");
    this.governorControl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGovernorControlFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignGovernorControlFromGovHydro3Event");
    this.governorControl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv1ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignGv1ToGovHydro3Event");
    this.gv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv1FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignGv1FromGovHydro3Event");
    this.gv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv2ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignGv2ToGovHydro3Event");
    this.gv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv2FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignGv2FromGovHydro3Event");
    this.gv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv3ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignGv3ToGovHydro3Event");
    this.gv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv3FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignGv3FromGovHydro3Event");
    this.gv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv4ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignGv4ToGovHydro3Event");
    this.gv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv4FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignGv4FromGovHydro3Event");
    this.gv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv5ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignGv5ToGovHydro3Event");
    this.gv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv5FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignGv5FromGovHydro3Event");
    this.gv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv6ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignGv6ToGovHydro3Event");
    this.gv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv6FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignGv6FromGovHydro3Event");
    this.gv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignH0ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignH0ToGovHydro3Event");
    this.h0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignH0FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignH0FromGovHydro3Event");
    this.h0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignK1ToGovHydro3Event");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignK1FromGovHydro3Event");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK2ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignK2ToGovHydro3Event");
    this.k2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK2FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignK2FromGovHydro3Event");
    this.k2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKgToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignKgToGovHydro3Event");
    this.kg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKgFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignKgFromGovHydro3Event");
    this.kg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignKiToGovHydro3Event");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignKiFromGovHydro3Event");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovHydro3Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovHydro3Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv1ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignPgv1ToGovHydro3Event");
    this.pgv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv1FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignPgv1FromGovHydro3Event");
    this.pgv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv2ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignPgv2ToGovHydro3Event");
    this.pgv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv2FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignPgv2FromGovHydro3Event");
    this.pgv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv3ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignPgv3ToGovHydro3Event");
    this.pgv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv3FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignPgv3FromGovHydro3Event");
    this.pgv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv4ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignPgv4ToGovHydro3Event");
    this.pgv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv4FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignPgv4FromGovHydro3Event");
    this.pgv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv5ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignPgv5ToGovHydro3Event");
    this.pgv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv5FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignPgv5FromGovHydro3Event");
    this.pgv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv6ToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignPgv6ToGovHydro3Event");
    this.pgv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv6FromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignPgv6FromGovHydro3Event");
    this.pgv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignPmaxToGovHydro3Event");
    this.pmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignPmaxFromGovHydro3Event");
    this.pmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignPminToGovHydro3Event");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignPminFromGovHydro3Event");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQnlToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignQnlToGovHydro3Event");
    this.qnl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQnlFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignQnlFromGovHydro3Event");
    this.qnl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRelecToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignRelecToGovHydro3Event");
    this.relec = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRelecFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignRelecFromGovHydro3Event");
    this.relec = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRgateToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignRgateToGovHydro3Event");
    this.rgate = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRgateFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignRgateFromGovHydro3Event");
    this.rgate = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignTdToGovHydro3Event");
    this.td = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignTdFromGovHydro3Event");
    this.td = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignTfToGovHydro3Event");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignTfFromGovHydro3Event");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignTpToGovHydro3Event");
    this.tp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignTpFromGovHydro3Event");
    this.tp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTtToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignTtToGovHydro3Event");
    this.tt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTtFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignTtFromGovHydro3Event");
    this.tt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignTwToGovHydro3Event");
    this.tw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignTwFromGovHydro3Event");
    this.tw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVelclToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignVelclToGovHydro3Event");
    this.velcl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVelclFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignVelclFromGovHydro3Event");
    this.velcl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVelopToGovHydro3Event event) {
    LOGGER.info("Event sourcing AssignVelopToGovHydro3Event");
    this.velop = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVelopFromGovHydro3Event event) {
    LOGGER.info("Event sourcing UnAssignVelopFromGovHydro3Event");
    this.velop = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govHydro3Id;

  private PU at = null;
  private Frequency db1 = null;
  private ActivePower db2 = null;
  private PU dturb = null;
  private Frequency eps = null;
  private BooleanProxy governorControl = null;
  private PU gv1 = null;
  private PU gv2 = null;
  private PU gv3 = null;
  private PU gv4 = null;
  private PU gv5 = null;
  private PU gv6 = null;
  private PU h0 = null;
  private PU k1 = null;
  private PU k2 = null;
  private PU kg = null;
  private PU ki = null;
  private ActivePower mwbase = null;
  private PU pgv1 = null;
  private PU pgv2 = null;
  private PU pgv3 = null;
  private PU pgv4 = null;
  private PU pgv5 = null;
  private PU pgv6 = null;
  private PU pmax = null;
  private PU pmin = null;
  private PU qnl = null;
  private PU relec = null;
  private PU rgate = null;
  private Seconds td = null;
  private Seconds tf = null;
  private Seconds tp = null;
  private Seconds tt = null;
  private Seconds tw = null;
  private Simple_Float velcl = null;
  private Simple_Float velop = null;

  private static final Logger LOGGER = Logger.getLogger(GovHydro3Aggregate.class.getName());
}
