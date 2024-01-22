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
 * Aggregate handler for GovHydroDD as outlined for the CQRS pattern, all write responsibilities
 * related to GovHydroDD are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovHydroDDAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovHydroDDAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovHydroDDAggregate(CreateGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command CreateGovHydroDDCommand");
    CreateGovHydroDDEvent event = new CreateGovHydroDDEvent(command.getGovHydroDDId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovHydroDDCommand command) throws Exception {
    LOGGER.info("handling command UpdateGovHydroDDCommand");
    UpdateGovHydroDDEvent event =
        new UpdateGovHydroDDEvent(
            command.getGovHydroDDId(),
            command.getAturb(),
            command.getBturb(),
            command.getDb1(),
            command.getDb2(),
            command.getEps(),
            command.getGmax(),
            command.getGmin(),
            command.getGv1(),
            command.getGv2(),
            command.getGv3(),
            command.getGv4(),
            command.getGv5(),
            command.getGv6(),
            command.getInputSignal(),
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
  public void handle(DeleteGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGovHydroDDCommand");
    apply(new DeleteGovHydroDDEvent(command.getGovHydroDDId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAturbToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignAturbToGovHydroDDCommand");

    if (aturb != null && aturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Aturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAturbToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAturbFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAturbFromGovHydroDDCommand");

    if (aturb == null) throw new ProcessingException("Aturb already has nothing assigned.");

    apply(new UnAssignAturbFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignBturbToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignBturbToGovHydroDDCommand");

    if (bturb != null && bturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBturbToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBturbFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBturbFromGovHydroDDCommand");

    if (bturb == null) throw new ProcessingException("Bturb already has nothing assigned.");

    apply(new UnAssignBturbFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignDb1ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignDb1ToGovHydroDDCommand");

    if (db1 != null && db1.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Db1 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignDb1ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb1FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb1FromGovHydroDDCommand");

    if (db1 == null) throw new ProcessingException("Db1 already has nothing assigned.");

    apply(new UnAssignDb1FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignDb2ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignDb2ToGovHydroDDCommand");

    if (db2 != null && db2.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Db2 already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignDb2ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb2FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb2FromGovHydroDDCommand");

    if (db2 == null) throw new ProcessingException("Db2 already has nothing assigned.");

    apply(new UnAssignDb2FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignEpsToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignEpsToGovHydroDDCommand");

    if (eps != null && eps.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Eps already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignEpsToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEpsFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEpsFromGovHydroDDCommand");

    if (eps == null) throw new ProcessingException("Eps already has nothing assigned.");

    apply(new UnAssignEpsFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignGmaxToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGmaxToGovHydroDDCommand");

    if (gmax != null && gmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGmaxToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGmaxFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGmaxFromGovHydroDDCommand");

    if (gmax == null) throw new ProcessingException("Gmax already has nothing assigned.");

    apply(new UnAssignGmaxFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignGminToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGminToGovHydroDDCommand");

    if (gmin != null && gmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGminToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGminFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGminFromGovHydroDDCommand");

    if (gmin == null) throw new ProcessingException("Gmin already has nothing assigned.");

    apply(new UnAssignGminFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignGv1ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv1ToGovHydroDDCommand");

    if (gv1 != null && gv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv1ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv1FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv1FromGovHydroDDCommand");

    if (gv1 == null) throw new ProcessingException("Gv1 already has nothing assigned.");

    apply(new UnAssignGv1FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignGv2ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv2ToGovHydroDDCommand");

    if (gv2 != null && gv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv2ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv2FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv2FromGovHydroDDCommand");

    if (gv2 == null) throw new ProcessingException("Gv2 already has nothing assigned.");

    apply(new UnAssignGv2FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignGv3ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv3ToGovHydroDDCommand");

    if (gv3 != null && gv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv3ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv3FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv3FromGovHydroDDCommand");

    if (gv3 == null) throw new ProcessingException("Gv3 already has nothing assigned.");

    apply(new UnAssignGv3FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignGv4ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv4ToGovHydroDDCommand");

    if (gv4 != null && gv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv4ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv4FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv4FromGovHydroDDCommand");

    if (gv4 == null) throw new ProcessingException("Gv4 already has nothing assigned.");

    apply(new UnAssignGv4FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignGv5ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv5ToGovHydroDDCommand");

    if (gv5 != null && gv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv5ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv5FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv5FromGovHydroDDCommand");

    if (gv5 == null) throw new ProcessingException("Gv5 already has nothing assigned.");

    apply(new UnAssignGv5FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignGv6ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv6ToGovHydroDDCommand");

    if (gv6 != null && gv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv6ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv6FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv6FromGovHydroDDCommand");

    if (gv6 == null) throw new ProcessingException("Gv6 already has nothing assigned.");

    apply(new UnAssignGv6FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignInputSignalToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignInputSignalToGovHydroDDCommand");

    if (inputSignal != null
        && inputSignal.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "InputSignal already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignInputSignalToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignInputSignalFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignInputSignalFromGovHydroDDCommand");

    if (inputSignal == null)
      throw new ProcessingException("InputSignal already has nothing assigned.");

    apply(new UnAssignInputSignalFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignK1ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignK1ToGovHydroDDCommand");

    if (k1 != null && k1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK1ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromGovHydroDDCommand");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignK2ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignK2ToGovHydroDDCommand");

    if (k2 != null && k2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK2ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK2FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK2FromGovHydroDDCommand");

    if (k2 == null) throw new ProcessingException("K2 already has nothing assigned.");

    apply(new UnAssignK2FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignKgToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignKgToGovHydroDDCommand");

    if (kg != null && kg.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kg already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKgToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKgFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKgFromGovHydroDDCommand");

    if (kg == null) throw new ProcessingException("Kg already has nothing assigned.");

    apply(new UnAssignKgFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignKiToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToGovHydroDDCommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromGovHydroDDCommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovHydroDDCommand");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovHydroDDCommand");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignPgv1ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv1ToGovHydroDDCommand");

    if (pgv1 != null && pgv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv1ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv1FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv1FromGovHydroDDCommand");

    if (pgv1 == null) throw new ProcessingException("Pgv1 already has nothing assigned.");

    apply(new UnAssignPgv1FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignPgv2ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv2ToGovHydroDDCommand");

    if (pgv2 != null && pgv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv2ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv2FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv2FromGovHydroDDCommand");

    if (pgv2 == null) throw new ProcessingException("Pgv2 already has nothing assigned.");

    apply(new UnAssignPgv2FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignPgv3ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv3ToGovHydroDDCommand");

    if (pgv3 != null && pgv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv3ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv3FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv3FromGovHydroDDCommand");

    if (pgv3 == null) throw new ProcessingException("Pgv3 already has nothing assigned.");

    apply(new UnAssignPgv3FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignPgv4ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv4ToGovHydroDDCommand");

    if (pgv4 != null && pgv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv4ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv4FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv4FromGovHydroDDCommand");

    if (pgv4 == null) throw new ProcessingException("Pgv4 already has nothing assigned.");

    apply(new UnAssignPgv4FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignPgv5ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv5ToGovHydroDDCommand");

    if (pgv5 != null && pgv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv5ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv5FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv5FromGovHydroDDCommand");

    if (pgv5 == null) throw new ProcessingException("Pgv5 already has nothing assigned.");

    apply(new UnAssignPgv5FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignPgv6ToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv6ToGovHydroDDCommand");

    if (pgv6 != null && pgv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv6ToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv6FromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv6FromGovHydroDDCommand");

    if (pgv6 == null) throw new ProcessingException("Pgv6 already has nothing assigned.");

    apply(new UnAssignPgv6FromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignPmaxToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmaxToGovHydroDDCommand");

    if (pmax != null && pmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmaxToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxFromGovHydroDDCommand");

    if (pmax == null) throw new ProcessingException("Pmax already has nothing assigned.");

    apply(new UnAssignPmaxFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignPminToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignPminToGovHydroDDCommand");

    if (pmin != null && pmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPminToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromGovHydroDDCommand");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignRToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignRToGovHydroDDCommand");

    if (r != null && r.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromGovHydroDDCommand");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignTdToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTdToGovHydroDDCommand");

    if (td != null && td.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Td already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdFromGovHydroDDCommand");

    if (td == null) throw new ProcessingException("Td already has nothing assigned.");

    apply(new UnAssignTdFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignTfToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToGovHydroDDCommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromGovHydroDDCommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignTpToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpToGovHydroDDCommand");

    if (tp != null && tp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpFromGovHydroDDCommand");

    if (tp == null) throw new ProcessingException("Tp already has nothing assigned.");

    apply(new UnAssignTpFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignTtToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTtToGovHydroDDCommand");

    if (tt != null && tt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tt already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTtToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTtFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTtFromGovHydroDDCommand");

    if (tt == null) throw new ProcessingException("Tt already has nothing assigned.");

    apply(new UnAssignTtFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignTturbToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignTturbToGovHydroDDCommand");

    if (tturb != null && tturb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tturb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTturbToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTturbFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTturbFromGovHydroDDCommand");

    if (tturb == null) throw new ProcessingException("Tturb already has nothing assigned.");

    apply(new UnAssignTturbFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignVelclToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignVelclToGovHydroDDCommand");

    if (velcl != null && velcl.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Velcl already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignVelclToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVelclFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVelclFromGovHydroDDCommand");

    if (velcl == null) throw new ProcessingException("Velcl already has nothing assigned.");

    apply(new UnAssignVelclFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  @CommandHandler
  public void handle(AssignVelopToGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handling command AssignVelopToGovHydroDDCommand");

    if (velop != null && velop.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Velop already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignVelopToGovHydroDDEvent(command.getGovHydroDDId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVelopFromGovHydroDDCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVelopFromGovHydroDDCommand");

    if (velop == null) throw new ProcessingException("Velop already has nothing assigned.");

    apply(new UnAssignVelopFromGovHydroDDEvent(command.getGovHydroDDId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovHydroDDEvent event) {
    LOGGER.info("Event sourcing CreateGovHydroDDEvent");
    this.govHydroDDId = event.getGovHydroDDId();
  }

  @EventSourcingHandler
  void on(UpdateGovHydroDDEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.aturb = event.getAturb();
    this.bturb = event.getBturb();
    this.db1 = event.getDb1();
    this.db2 = event.getDb2();
    this.eps = event.getEps();
    this.gmax = event.getGmax();
    this.gmin = event.getGmin();
    this.gv1 = event.getGv1();
    this.gv2 = event.getGv2();
    this.gv3 = event.getGv3();
    this.gv4 = event.getGv4();
    this.gv5 = event.getGv5();
    this.gv6 = event.getGv6();
    this.inputSignal = event.getInputSignal();
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
  void on(AssignAturbToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignAturbToGovHydroDDEvent");
    this.aturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAturbFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignAturbFromGovHydroDDEvent");
    this.aturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBturbToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignBturbToGovHydroDDEvent");
    this.bturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBturbFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignBturbFromGovHydroDDEvent");
    this.bturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb1ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignDb1ToGovHydroDDEvent");
    this.db1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb1FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignDb1FromGovHydroDDEvent");
    this.db1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb2ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignDb2ToGovHydroDDEvent");
    this.db2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb2FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignDb2FromGovHydroDDEvent");
    this.db2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEpsToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignEpsToGovHydroDDEvent");
    this.eps = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEpsFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignEpsFromGovHydroDDEvent");
    this.eps = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGmaxToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignGmaxToGovHydroDDEvent");
    this.gmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGmaxFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignGmaxFromGovHydroDDEvent");
    this.gmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGminToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignGminToGovHydroDDEvent");
    this.gmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGminFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignGminFromGovHydroDDEvent");
    this.gmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv1ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignGv1ToGovHydroDDEvent");
    this.gv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv1FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv1FromGovHydroDDEvent");
    this.gv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv2ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignGv2ToGovHydroDDEvent");
    this.gv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv2FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv2FromGovHydroDDEvent");
    this.gv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv3ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignGv3ToGovHydroDDEvent");
    this.gv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv3FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv3FromGovHydroDDEvent");
    this.gv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv4ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignGv4ToGovHydroDDEvent");
    this.gv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv4FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv4FromGovHydroDDEvent");
    this.gv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv5ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignGv5ToGovHydroDDEvent");
    this.gv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv5FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv5FromGovHydroDDEvent");
    this.gv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv6ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignGv6ToGovHydroDDEvent");
    this.gv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv6FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignGv6FromGovHydroDDEvent");
    this.gv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignInputSignalToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignInputSignalToGovHydroDDEvent");
    this.inputSignal = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignInputSignalFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignInputSignalFromGovHydroDDEvent");
    this.inputSignal = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignK1ToGovHydroDDEvent");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignK1FromGovHydroDDEvent");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK2ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignK2ToGovHydroDDEvent");
    this.k2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK2FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignK2FromGovHydroDDEvent");
    this.k2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKgToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignKgToGovHydroDDEvent");
    this.kg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKgFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignKgFromGovHydroDDEvent");
    this.kg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignKiToGovHydroDDEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromGovHydroDDEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovHydroDDEvent");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovHydroDDEvent");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv1ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignPgv1ToGovHydroDDEvent");
    this.pgv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv1FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv1FromGovHydroDDEvent");
    this.pgv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv2ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignPgv2ToGovHydroDDEvent");
    this.pgv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv2FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv2FromGovHydroDDEvent");
    this.pgv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv3ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignPgv3ToGovHydroDDEvent");
    this.pgv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv3FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv3FromGovHydroDDEvent");
    this.pgv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv4ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignPgv4ToGovHydroDDEvent");
    this.pgv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv4FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv4FromGovHydroDDEvent");
    this.pgv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv5ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignPgv5ToGovHydroDDEvent");
    this.pgv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv5FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv5FromGovHydroDDEvent");
    this.pgv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv6ToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignPgv6ToGovHydroDDEvent");
    this.pgv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv6FromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignPgv6FromGovHydroDDEvent");
    this.pgv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignPmaxToGovHydroDDEvent");
    this.pmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignPmaxFromGovHydroDDEvent");
    this.pmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignPminToGovHydroDDEvent");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignPminFromGovHydroDDEvent");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignRToGovHydroDDEvent");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignRFromGovHydroDDEvent");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignTdToGovHydroDDEvent");
    this.td = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignTdFromGovHydroDDEvent");
    this.td = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignTfToGovHydroDDEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromGovHydroDDEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignTpToGovHydroDDEvent");
    this.tp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignTpFromGovHydroDDEvent");
    this.tp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTtToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignTtToGovHydroDDEvent");
    this.tt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTtFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignTtFromGovHydroDDEvent");
    this.tt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTturbToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignTturbToGovHydroDDEvent");
    this.tturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTturbFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignTturbFromGovHydroDDEvent");
    this.tturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVelclToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignVelclToGovHydroDDEvent");
    this.velcl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVelclFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignVelclFromGovHydroDDEvent");
    this.velcl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVelopToGovHydroDDEvent event) {
    LOGGER.info("Event sourcing AssignVelopToGovHydroDDEvent");
    this.velop = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVelopFromGovHydroDDEvent event) {
    LOGGER.info("Event sourcing UnAssignVelopFromGovHydroDDEvent");
    this.velop = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govHydroDDId;

  private PU aturb = null;
  private PU bturb = null;
  private Frequency db1 = null;
  private ActivePower db2 = null;
  private Frequency eps = null;
  private PU gmax = null;
  private PU gmin = null;
  private PU gv1 = null;
  private PU gv2 = null;
  private PU gv3 = null;
  private PU gv4 = null;
  private PU gv5 = null;
  private PU gv6 = null;
  private BooleanProxy inputSignal = null;
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
  private PU r = null;
  private Seconds td = null;
  private Seconds tf = null;
  private Seconds tp = null;
  private Seconds tt = null;
  private Seconds tturb = null;
  private Simple_Float velcl = null;
  private Simple_Float velop = null;

  private static final Logger LOGGER = Logger.getLogger(GovHydroDDAggregate.class.getName());
}
