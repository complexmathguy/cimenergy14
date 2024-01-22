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
 * Aggregate handler for GovHydroR as outlined for the CQRS pattern, all write responsibilities
 * related to GovHydroR are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovHydroRAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovHydroRAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovHydroRAggregate(CreateGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command CreateGovHydroRCommand");
    CreateGovHydroREvent event = new CreateGovHydroREvent(command.getGovHydroRId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovHydroRCommand command) throws Exception {
    LOGGER.info("handling command UpdateGovHydroRCommand");
    UpdateGovHydroREvent event =
        new UpdateGovHydroREvent(
            command.getGovHydroRId(),
            command.getAt(),
            command.getDb1(),
            command.getDb2(),
            command.getDturb(),
            command.getEps(),
            command.getGmax(),
            command.getGmin(),
            command.getGv1(),
            command.getGv2(),
            command.getGv3(),
            command.getGv4(),
            command.getGv5(),
            command.getGv6(),
            command.getH0(),
            command.getInputSignal(),
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
            command.getR(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getT6(),
            command.getT7(),
            command.getT8(),
            command.getTd(),
            command.getTp(),
            command.getTt(),
            command.getTw(),
            command.getVelcl(),
            command.getVelop());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGovHydroRCommand");
    apply(new DeleteGovHydroREvent(command.getGovHydroRId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAtToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignAtToGovHydroRCommand");

    if (at != null && at.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "At already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAtToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAtFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAtFromGovHydroRCommand");

    if (at == null) throw new ProcessingException("At already has nothing assigned.");

    apply(new UnAssignAtFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignDb1ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignDb1ToGovHydroRCommand");

    if (db1 != null && db1.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Db1 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignDb1ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb1FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb1FromGovHydroRCommand");

    if (db1 == null) throw new ProcessingException("Db1 already has nothing assigned.");

    apply(new UnAssignDb1FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignDb2ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignDb2ToGovHydroRCommand");

    if (db2 != null && db2.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Db2 already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignDb2ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb2FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb2FromGovHydroRCommand");

    if (db2 == null) throw new ProcessingException("Db2 already has nothing assigned.");

    apply(new UnAssignDb2FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignDturbToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignDturbToGovHydroRCommand");

    if (dturb != null && dturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDturbToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDturbFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDturbFromGovHydroRCommand");

    if (dturb == null) throw new ProcessingException("Dturb already has nothing assigned.");

    apply(new UnAssignDturbFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignEpsToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignEpsToGovHydroRCommand");

    if (eps != null && eps.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Eps already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignEpsToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEpsFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEpsFromGovHydroRCommand");

    if (eps == null) throw new ProcessingException("Eps already has nothing assigned.");

    apply(new UnAssignEpsFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignGmaxToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignGmaxToGovHydroRCommand");

    if (gmax != null && gmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGmaxToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGmaxFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGmaxFromGovHydroRCommand");

    if (gmax == null) throw new ProcessingException("Gmax already has nothing assigned.");

    apply(new UnAssignGmaxFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignGminToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignGminToGovHydroRCommand");

    if (gmin != null && gmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGminToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGminFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGminFromGovHydroRCommand");

    if (gmin == null) throw new ProcessingException("Gmin already has nothing assigned.");

    apply(new UnAssignGminFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignGv1ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv1ToGovHydroRCommand");

    if (gv1 != null && gv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv1ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv1FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv1FromGovHydroRCommand");

    if (gv1 == null) throw new ProcessingException("Gv1 already has nothing assigned.");

    apply(new UnAssignGv1FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignGv2ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv2ToGovHydroRCommand");

    if (gv2 != null && gv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv2ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv2FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv2FromGovHydroRCommand");

    if (gv2 == null) throw new ProcessingException("Gv2 already has nothing assigned.");

    apply(new UnAssignGv2FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignGv3ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv3ToGovHydroRCommand");

    if (gv3 != null && gv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv3ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv3FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv3FromGovHydroRCommand");

    if (gv3 == null) throw new ProcessingException("Gv3 already has nothing assigned.");

    apply(new UnAssignGv3FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignGv4ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv4ToGovHydroRCommand");

    if (gv4 != null && gv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv4ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv4FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv4FromGovHydroRCommand");

    if (gv4 == null) throw new ProcessingException("Gv4 already has nothing assigned.");

    apply(new UnAssignGv4FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignGv5ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv5ToGovHydroRCommand");

    if (gv5 != null && gv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv5ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv5FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv5FromGovHydroRCommand");

    if (gv5 == null) throw new ProcessingException("Gv5 already has nothing assigned.");

    apply(new UnAssignGv5FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignGv6ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv6ToGovHydroRCommand");

    if (gv6 != null && gv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv6ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv6FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv6FromGovHydroRCommand");

    if (gv6 == null) throw new ProcessingException("Gv6 already has nothing assigned.");

    apply(new UnAssignGv6FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignH0ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignH0ToGovHydroRCommand");

    if (h0 != null && h0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "H0 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignH0ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignH0FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignH0FromGovHydroRCommand");

    if (h0 == null) throw new ProcessingException("H0 already has nothing assigned.");

    apply(new UnAssignH0FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignInputSignalToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignInputSignalToGovHydroRCommand");

    if (inputSignal != null
        && inputSignal.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "InputSignal already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignInputSignalToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignInputSignalFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignInputSignalFromGovHydroRCommand");

    if (inputSignal == null)
      throw new ProcessingException("InputSignal already has nothing assigned.");

    apply(new UnAssignInputSignalFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignKgToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignKgToGovHydroRCommand");

    if (kg != null && kg.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kg already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKgToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKgFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKgFromGovHydroRCommand");

    if (kg == null) throw new ProcessingException("Kg already has nothing assigned.");

    apply(new UnAssignKgFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignKiToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToGovHydroRCommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromGovHydroRCommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovHydroRCommand");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovHydroRCommand");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignPgv1ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv1ToGovHydroRCommand");

    if (pgv1 != null && pgv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv1ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv1FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv1FromGovHydroRCommand");

    if (pgv1 == null) throw new ProcessingException("Pgv1 already has nothing assigned.");

    apply(new UnAssignPgv1FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignPgv2ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv2ToGovHydroRCommand");

    if (pgv2 != null && pgv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv2ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv2FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv2FromGovHydroRCommand");

    if (pgv2 == null) throw new ProcessingException("Pgv2 already has nothing assigned.");

    apply(new UnAssignPgv2FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignPgv3ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv3ToGovHydroRCommand");

    if (pgv3 != null && pgv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv3ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv3FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv3FromGovHydroRCommand");

    if (pgv3 == null) throw new ProcessingException("Pgv3 already has nothing assigned.");

    apply(new UnAssignPgv3FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignPgv4ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv4ToGovHydroRCommand");

    if (pgv4 != null && pgv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv4ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv4FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv4FromGovHydroRCommand");

    if (pgv4 == null) throw new ProcessingException("Pgv4 already has nothing assigned.");

    apply(new UnAssignPgv4FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignPgv5ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv5ToGovHydroRCommand");

    if (pgv5 != null && pgv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv5ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv5FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv5FromGovHydroRCommand");

    if (pgv5 == null) throw new ProcessingException("Pgv5 already has nothing assigned.");

    apply(new UnAssignPgv5FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignPgv6ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignPgv6ToGovHydroRCommand");

    if (pgv6 != null && pgv6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pgv6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPgv6ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPgv6FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPgv6FromGovHydroRCommand");

    if (pgv6 == null) throw new ProcessingException("Pgv6 already has nothing assigned.");

    apply(new UnAssignPgv6FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignPmaxToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmaxToGovHydroRCommand");

    if (pmax != null && pmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmaxToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxFromGovHydroRCommand");

    if (pmax == null) throw new ProcessingException("Pmax already has nothing assigned.");

    apply(new UnAssignPmaxFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignPminToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignPminToGovHydroRCommand");

    if (pmin != null && pmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPminToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromGovHydroRCommand");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignQnlToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignQnlToGovHydroRCommand");

    if (qnl != null && qnl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Qnl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignQnlToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQnlFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQnlFromGovHydroRCommand");

    if (qnl == null) throw new ProcessingException("Qnl already has nothing assigned.");

    apply(new UnAssignQnlFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignRToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignRToGovHydroRCommand");

    if (r != null && r.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromGovHydroRCommand");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignT1ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToGovHydroRCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromGovHydroRCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignT2ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToGovHydroRCommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromGovHydroRCommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignT3ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToGovHydroRCommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromGovHydroRCommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignT4ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignT4ToGovHydroRCommand");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromGovHydroRCommand");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignT5ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignT5ToGovHydroRCommand");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromGovHydroRCommand");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignT6ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignT6ToGovHydroRCommand");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromGovHydroRCommand");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignT7ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignT7ToGovHydroRCommand");

    if (t7 != null && t7.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T7 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT7ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT7FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT7FromGovHydroRCommand");

    if (t7 == null) throw new ProcessingException("T7 already has nothing assigned.");

    apply(new UnAssignT7FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignT8ToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignT8ToGovHydroRCommand");

    if (t8 != null && t8.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T8 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT8ToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT8FromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT8FromGovHydroRCommand");

    if (t8 == null) throw new ProcessingException("T8 already has nothing assigned.");

    apply(new UnAssignT8FromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignTdToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignTdToGovHydroRCommand");

    if (td != null && td.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Td already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdFromGovHydroRCommand");

    if (td == null) throw new ProcessingException("Td already has nothing assigned.");

    apply(new UnAssignTdFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignTpToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpToGovHydroRCommand");

    if (tp != null && tp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpFromGovHydroRCommand");

    if (tp == null) throw new ProcessingException("Tp already has nothing assigned.");

    apply(new UnAssignTpFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignTtToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignTtToGovHydroRCommand");

    if (tt != null && tt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tt already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTtToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTtFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTtFromGovHydroRCommand");

    if (tt == null) throw new ProcessingException("Tt already has nothing assigned.");

    apply(new UnAssignTtFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignTwToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwToGovHydroRCommand");

    if (tw != null && tw.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTwToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwFromGovHydroRCommand");

    if (tw == null) throw new ProcessingException("Tw already has nothing assigned.");

    apply(new UnAssignTwFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignVelclToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignVelclToGovHydroRCommand");

    if (velcl != null && velcl.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Velcl already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignVelclToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVelclFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVelclFromGovHydroRCommand");

    if (velcl == null) throw new ProcessingException("Velcl already has nothing assigned.");

    apply(new UnAssignVelclFromGovHydroREvent(command.getGovHydroRId()));
  }

  @CommandHandler
  public void handle(AssignVelopToGovHydroRCommand command) throws Exception {
    LOGGER.info("Handling command AssignVelopToGovHydroRCommand");

    if (velop != null && velop.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Velop already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignVelopToGovHydroREvent(command.getGovHydroRId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVelopFromGovHydroRCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVelopFromGovHydroRCommand");

    if (velop == null) throw new ProcessingException("Velop already has nothing assigned.");

    apply(new UnAssignVelopFromGovHydroREvent(command.getGovHydroRId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovHydroREvent event) {
    LOGGER.info("Event sourcing CreateGovHydroREvent");
    this.govHydroRId = event.getGovHydroRId();
  }

  @EventSourcingHandler
  void on(UpdateGovHydroREvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.at = event.getAt();
    this.db1 = event.getDb1();
    this.db2 = event.getDb2();
    this.dturb = event.getDturb();
    this.eps = event.getEps();
    this.gmax = event.getGmax();
    this.gmin = event.getGmin();
    this.gv1 = event.getGv1();
    this.gv2 = event.getGv2();
    this.gv3 = event.getGv3();
    this.gv4 = event.getGv4();
    this.gv5 = event.getGv5();
    this.gv6 = event.getGv6();
    this.h0 = event.getH0();
    this.inputSignal = event.getInputSignal();
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
    this.r = event.getR();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.t6 = event.getT6();
    this.t7 = event.getT7();
    this.t8 = event.getT8();
    this.td = event.getTd();
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
  void on(AssignAtToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignAtToGovHydroREvent");
    this.at = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAtFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignAtFromGovHydroREvent");
    this.at = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb1ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignDb1ToGovHydroREvent");
    this.db1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb1FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignDb1FromGovHydroREvent");
    this.db1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb2ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignDb2ToGovHydroREvent");
    this.db2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb2FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignDb2FromGovHydroREvent");
    this.db2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDturbToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignDturbToGovHydroREvent");
    this.dturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDturbFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignDturbFromGovHydroREvent");
    this.dturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEpsToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignEpsToGovHydroREvent");
    this.eps = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEpsFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignEpsFromGovHydroREvent");
    this.eps = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGmaxToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignGmaxToGovHydroREvent");
    this.gmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGmaxFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignGmaxFromGovHydroREvent");
    this.gmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGminToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignGminToGovHydroREvent");
    this.gmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGminFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignGminFromGovHydroREvent");
    this.gmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv1ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignGv1ToGovHydroREvent");
    this.gv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv1FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignGv1FromGovHydroREvent");
    this.gv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv2ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignGv2ToGovHydroREvent");
    this.gv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv2FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignGv2FromGovHydroREvent");
    this.gv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv3ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignGv3ToGovHydroREvent");
    this.gv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv3FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignGv3FromGovHydroREvent");
    this.gv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv4ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignGv4ToGovHydroREvent");
    this.gv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv4FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignGv4FromGovHydroREvent");
    this.gv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv5ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignGv5ToGovHydroREvent");
    this.gv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv5FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignGv5FromGovHydroREvent");
    this.gv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv6ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignGv6ToGovHydroREvent");
    this.gv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv6FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignGv6FromGovHydroREvent");
    this.gv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignH0ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignH0ToGovHydroREvent");
    this.h0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignH0FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignH0FromGovHydroREvent");
    this.h0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignInputSignalToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignInputSignalToGovHydroREvent");
    this.inputSignal = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignInputSignalFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignInputSignalFromGovHydroREvent");
    this.inputSignal = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKgToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignKgToGovHydroREvent");
    this.kg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKgFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignKgFromGovHydroREvent");
    this.kg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignKiToGovHydroREvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromGovHydroREvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovHydroREvent");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovHydroREvent");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv1ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignPgv1ToGovHydroREvent");
    this.pgv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv1FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignPgv1FromGovHydroREvent");
    this.pgv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv2ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignPgv2ToGovHydroREvent");
    this.pgv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv2FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignPgv2FromGovHydroREvent");
    this.pgv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv3ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignPgv3ToGovHydroREvent");
    this.pgv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv3FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignPgv3FromGovHydroREvent");
    this.pgv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv4ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignPgv4ToGovHydroREvent");
    this.pgv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv4FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignPgv4FromGovHydroREvent");
    this.pgv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv5ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignPgv5ToGovHydroREvent");
    this.pgv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv5FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignPgv5FromGovHydroREvent");
    this.pgv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPgv6ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignPgv6ToGovHydroREvent");
    this.pgv6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPgv6FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignPgv6FromGovHydroREvent");
    this.pgv6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignPmaxToGovHydroREvent");
    this.pmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignPmaxFromGovHydroREvent");
    this.pmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignPminToGovHydroREvent");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignPminFromGovHydroREvent");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQnlToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignQnlToGovHydroREvent");
    this.qnl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQnlFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignQnlFromGovHydroREvent");
    this.qnl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignRToGovHydroREvent");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignRFromGovHydroREvent");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignT1ToGovHydroREvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromGovHydroREvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignT2ToGovHydroREvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromGovHydroREvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignT3ToGovHydroREvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromGovHydroREvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignT4ToGovHydroREvent");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignT4FromGovHydroREvent");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignT5ToGovHydroREvent");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignT5FromGovHydroREvent");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignT6ToGovHydroREvent");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignT6FromGovHydroREvent");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT7ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignT7ToGovHydroREvent");
    this.t7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT7FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignT7FromGovHydroREvent");
    this.t7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT8ToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignT8ToGovHydroREvent");
    this.t8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT8FromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignT8FromGovHydroREvent");
    this.t8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignTdToGovHydroREvent");
    this.td = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignTdFromGovHydroREvent");
    this.td = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignTpToGovHydroREvent");
    this.tp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignTpFromGovHydroREvent");
    this.tp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTtToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignTtToGovHydroREvent");
    this.tt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTtFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignTtFromGovHydroREvent");
    this.tt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignTwToGovHydroREvent");
    this.tw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignTwFromGovHydroREvent");
    this.tw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVelclToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignVelclToGovHydroREvent");
    this.velcl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVelclFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignVelclFromGovHydroREvent");
    this.velcl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVelopToGovHydroREvent event) {
    LOGGER.info("Event sourcing AssignVelopToGovHydroREvent");
    this.velop = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVelopFromGovHydroREvent event) {
    LOGGER.info("Event sourcing UnAssignVelopFromGovHydroREvent");
    this.velop = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govHydroRId;

  private PU at = null;
  private Frequency db1 = null;
  private ActivePower db2 = null;
  private PU dturb = null;
  private Frequency eps = null;
  private PU gmax = null;
  private PU gmin = null;
  private PU gv1 = null;
  private PU gv2 = null;
  private PU gv3 = null;
  private PU gv4 = null;
  private PU gv5 = null;
  private PU gv6 = null;
  private PU h0 = null;
  private BooleanProxy inputSignal = null;
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
  private PU r = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Seconds t6 = null;
  private Seconds t7 = null;
  private Seconds t8 = null;
  private Seconds td = null;
  private Seconds tp = null;
  private Seconds tt = null;
  private Seconds tw = null;
  private Simple_Float velcl = null;
  private Simple_Float velop = null;

  private static final Logger LOGGER = Logger.getLogger(GovHydroRAggregate.class.getName());
}
