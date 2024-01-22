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
 * Aggregate handler for GovHydroFrancis as outlined for the CQRS pattern, all write
 * responsibilities related to GovHydroFrancis are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovHydroFrancisAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovHydroFrancisAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovHydroFrancisAggregate(CreateGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command CreateGovHydroFrancisCommand");
    CreateGovHydroFrancisEvent event =
        new CreateGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getGovernorControl());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("handling command UpdateGovHydroFrancisCommand");
    UpdateGovHydroFrancisEvent event =
        new UpdateGovHydroFrancisEvent(
            command.getGovHydroFrancisId(),
            command.getAm(),
            command.getAv0(),
            command.getAv1(),
            command.getBp(),
            command.getDb1(),
            command.getEtamax(),
            command.getGovernorControl(),
            command.getH1(),
            command.getH2(),
            command.getHn(),
            command.getKc(),
            command.getKg(),
            command.getKt(),
            command.getQc0(),
            command.getQn(),
            command.getTa(),
            command.getTd(),
            command.getTs(),
            command.getTwnc(),
            command.getTwng(),
            command.getTx(),
            command.getVa(),
            command.getValvmax(),
            command.getValvmin(),
            command.getVc(),
            command.getWaterTunnelSurgeChamberSimulation(),
            command.getZsfc());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGovHydroFrancisCommand");
    apply(new DeleteGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAmToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignAmToGovHydroFrancisCommand");

    if (am != null && am.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Am already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignAmToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAmFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAmFromGovHydroFrancisCommand");

    if (am == null) throw new ProcessingException("Am already has nothing assigned.");

    apply(new UnAssignAmFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignAv0ToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignAv0ToGovHydroFrancisCommand");

    if (av0 != null && av0.getAreaId() == command.getAssignment().getAreaId())
      throw new ProcessingException(
          "Av0 already assigned with id " + command.getAssignment().getAreaId());

    apply(
        new AssignAv0ToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAv0FromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAv0FromGovHydroFrancisCommand");

    if (av0 == null) throw new ProcessingException("Av0 already has nothing assigned.");

    apply(new UnAssignAv0FromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignAv1ToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignAv1ToGovHydroFrancisCommand");

    if (av1 != null && av1.getAreaId() == command.getAssignment().getAreaId())
      throw new ProcessingException(
          "Av1 already assigned with id " + command.getAssignment().getAreaId());

    apply(
        new AssignAv1ToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAv1FromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAv1FromGovHydroFrancisCommand");

    if (av1 == null) throw new ProcessingException("Av1 already has nothing assigned.");

    apply(new UnAssignAv1FromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignBpToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignBpToGovHydroFrancisCommand");

    if (bp != null && bp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bp already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignBpToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBpFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBpFromGovHydroFrancisCommand");

    if (bp == null) throw new ProcessingException("Bp already has nothing assigned.");

    apply(new UnAssignBpFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignDb1ToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignDb1ToGovHydroFrancisCommand");

    if (db1 != null && db1.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Db1 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(
        new AssignDb1ToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb1FromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb1FromGovHydroFrancisCommand");

    if (db1 == null) throw new ProcessingException("Db1 already has nothing assigned.");

    apply(new UnAssignDb1FromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignEtamaxToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignEtamaxToGovHydroFrancisCommand");

    if (etamax != null && etamax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Etamax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignEtamaxToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEtamaxFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEtamaxFromGovHydroFrancisCommand");

    if (etamax == null) throw new ProcessingException("Etamax already has nothing assigned.");

    apply(new UnAssignEtamaxFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignH1ToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignH1ToGovHydroFrancisCommand");

    if (h1 != null && h1.getLengthId() == command.getAssignment().getLengthId())
      throw new ProcessingException(
          "H1 already assigned with id " + command.getAssignment().getLengthId());

    apply(
        new AssignH1ToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignH1FromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignH1FromGovHydroFrancisCommand");

    if (h1 == null) throw new ProcessingException("H1 already has nothing assigned.");

    apply(new UnAssignH1FromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignH2ToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignH2ToGovHydroFrancisCommand");

    if (h2 != null && h2.getLengthId() == command.getAssignment().getLengthId())
      throw new ProcessingException(
          "H2 already assigned with id " + command.getAssignment().getLengthId());

    apply(
        new AssignH2ToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignH2FromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignH2FromGovHydroFrancisCommand");

    if (h2 == null) throw new ProcessingException("H2 already has nothing assigned.");

    apply(new UnAssignH2FromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignHnToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignHnToGovHydroFrancisCommand");

    if (hn != null && hn.getLengthId() == command.getAssignment().getLengthId())
      throw new ProcessingException(
          "Hn already assigned with id " + command.getAssignment().getLengthId());

    apply(
        new AssignHnToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHnFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignHnFromGovHydroFrancisCommand");

    if (hn == null) throw new ProcessingException("Hn already has nothing assigned.");

    apply(new UnAssignHnFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignKcToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToGovHydroFrancisCommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKcToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromGovHydroFrancisCommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignKgToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignKgToGovHydroFrancisCommand");

    if (kg != null && kg.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kg already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKgToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKgFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKgFromGovHydroFrancisCommand");

    if (kg == null) throw new ProcessingException("Kg already has nothing assigned.");

    apply(new UnAssignKgFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignKtToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignKtToGovHydroFrancisCommand");

    if (kt != null && kt.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kt already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKtToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKtFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKtFromGovHydroFrancisCommand");

    if (kt == null) throw new ProcessingException("Kt already has nothing assigned.");

    apply(new UnAssignKtFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignQc0ToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignQc0ToGovHydroFrancisCommand");

    if (qc0 != null && qc0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Qc0 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQc0ToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQc0FromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQc0FromGovHydroFrancisCommand");

    if (qc0 == null) throw new ProcessingException("Qc0 already has nothing assigned.");

    apply(new UnAssignQc0FromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignQnToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignQnToGovHydroFrancisCommand");

    if (qn != null && qn.getVolumeFlowRateId() == command.getAssignment().getVolumeFlowRateId())
      throw new ProcessingException(
          "Qn already assigned with id " + command.getAssignment().getVolumeFlowRateId());

    apply(
        new AssignQnToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQnFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQnFromGovHydroFrancisCommand");

    if (qn == null) throw new ProcessingException("Qn already has nothing assigned.");

    apply(new UnAssignQnFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignTaToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToGovHydroFrancisCommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTaToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromGovHydroFrancisCommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignTdToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignTdToGovHydroFrancisCommand");

    if (td != null && td.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Td already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTdToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdFromGovHydroFrancisCommand");

    if (td == null) throw new ProcessingException("Td already has nothing assigned.");

    apply(new UnAssignTdFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignTsToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignTsToGovHydroFrancisCommand");

    if (ts != null && ts.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ts already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTsToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTsFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTsFromGovHydroFrancisCommand");

    if (ts == null) throw new ProcessingException("Ts already has nothing assigned.");

    apply(new UnAssignTsFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignTwncToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwncToGovHydroFrancisCommand");

    if (twnc != null && twnc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Twnc already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTwncToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwncFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwncFromGovHydroFrancisCommand");

    if (twnc == null) throw new ProcessingException("Twnc already has nothing assigned.");

    apply(new UnAssignTwncFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignTwngToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwngToGovHydroFrancisCommand");

    if (twng != null && twng.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Twng already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTwngToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwngFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwngFromGovHydroFrancisCommand");

    if (twng == null) throw new ProcessingException("Twng already has nothing assigned.");

    apply(new UnAssignTwngFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignTxToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignTxToGovHydroFrancisCommand");

    if (tx != null && tx.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tx already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTxToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTxFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTxFromGovHydroFrancisCommand");

    if (tx == null) throw new ProcessingException("Tx already has nothing assigned.");

    apply(new UnAssignTxFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignVaToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignVaToGovHydroFrancisCommand");

    if (va != null && va.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Va already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignVaToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaFromGovHydroFrancisCommand");

    if (va == null) throw new ProcessingException("Va already has nothing assigned.");

    apply(new UnAssignVaFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignValvmaxToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignValvmaxToGovHydroFrancisCommand");

    if (valvmax != null && valvmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Valvmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignValvmaxToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValvmaxFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValvmaxFromGovHydroFrancisCommand");

    if (valvmax == null) throw new ProcessingException("Valvmax already has nothing assigned.");

    apply(new UnAssignValvmaxFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignValvminToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignValvminToGovHydroFrancisCommand");

    if (valvmin != null && valvmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Valvmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignValvminToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValvminFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValvminFromGovHydroFrancisCommand");

    if (valvmin == null) throw new ProcessingException("Valvmin already has nothing assigned.");

    apply(new UnAssignValvminFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignVcToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignVcToGovHydroFrancisCommand");

    if (vc != null && vc.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Vc already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignVcToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVcFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVcFromGovHydroFrancisCommand");

    if (vc == null) throw new ProcessingException("Vc already has nothing assigned.");

    apply(new UnAssignVcFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisCommand");

    if (waterTunnelSurgeChamberSimulation != null
        && waterTunnelSurgeChamberSimulation.getBooleanProxyId()
            == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "WaterTunnelSurgeChamberSimulation already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisCommand");

    if (waterTunnelSurgeChamberSimulation == null)
      throw new ProcessingException(
          "WaterTunnelSurgeChamberSimulation already has nothing assigned.");

    apply(
        new UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisEvent(
            command.getGovHydroFrancisId()));
  }

  @CommandHandler
  public void handle(AssignZsfcToGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handling command AssignZsfcToGovHydroFrancisCommand");

    if (zsfc != null && zsfc.getLengthId() == command.getAssignment().getLengthId())
      throw new ProcessingException(
          "Zsfc already assigned with id " + command.getAssignment().getLengthId());

    apply(
        new AssignZsfcToGovHydroFrancisEvent(
            command.getGovHydroFrancisId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignZsfcFromGovHydroFrancisCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignZsfcFromGovHydroFrancisCommand");

    if (zsfc == null) throw new ProcessingException("Zsfc already has nothing assigned.");

    apply(new UnAssignZsfcFromGovHydroFrancisEvent(command.getGovHydroFrancisId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing CreateGovHydroFrancisEvent");
    this.govHydroFrancisId = event.getGovHydroFrancisId();
    this.governorControl = event.getGovernorControl();
  }

  @EventSourcingHandler
  void on(UpdateGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.am = event.getAm();
    this.av0 = event.getAv0();
    this.av1 = event.getAv1();
    this.bp = event.getBp();
    this.db1 = event.getDb1();
    this.etamax = event.getEtamax();
    this.governorControl = event.getGovernorControl();
    this.h1 = event.getH1();
    this.h2 = event.getH2();
    this.hn = event.getHn();
    this.kc = event.getKc();
    this.kg = event.getKg();
    this.kt = event.getKt();
    this.qc0 = event.getQc0();
    this.qn = event.getQn();
    this.ta = event.getTa();
    this.td = event.getTd();
    this.ts = event.getTs();
    this.twnc = event.getTwnc();
    this.twng = event.getTwng();
    this.tx = event.getTx();
    this.va = event.getVa();
    this.valvmax = event.getValvmax();
    this.valvmin = event.getValvmin();
    this.vc = event.getVc();
    this.waterTunnelSurgeChamberSimulation = event.getWaterTunnelSurgeChamberSimulation();
    this.zsfc = event.getZsfc();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAmToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignAmToGovHydroFrancisEvent");
    this.am = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAmFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignAmFromGovHydroFrancisEvent");
    this.am = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignAv0ToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignAv0ToGovHydroFrancisEvent");
    this.av0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAv0FromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignAv0FromGovHydroFrancisEvent");
    this.av0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignAv1ToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignAv1ToGovHydroFrancisEvent");
    this.av1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAv1FromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignAv1FromGovHydroFrancisEvent");
    this.av1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBpToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignBpToGovHydroFrancisEvent");
    this.bp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBpFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignBpFromGovHydroFrancisEvent");
    this.bp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb1ToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignDb1ToGovHydroFrancisEvent");
    this.db1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb1FromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignDb1FromGovHydroFrancisEvent");
    this.db1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEtamaxToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignEtamaxToGovHydroFrancisEvent");
    this.etamax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEtamaxFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignEtamaxFromGovHydroFrancisEvent");
    this.etamax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignH1ToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignH1ToGovHydroFrancisEvent");
    this.h1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignH1FromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignH1FromGovHydroFrancisEvent");
    this.h1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignH2ToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignH2ToGovHydroFrancisEvent");
    this.h2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignH2FromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignH2FromGovHydroFrancisEvent");
    this.h2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignHnToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignHnToGovHydroFrancisEvent");
    this.hn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHnFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignHnFromGovHydroFrancisEvent");
    this.hn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignKcToGovHydroFrancisEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromGovHydroFrancisEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKgToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignKgToGovHydroFrancisEvent");
    this.kg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKgFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignKgFromGovHydroFrancisEvent");
    this.kg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKtToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignKtToGovHydroFrancisEvent");
    this.kt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKtFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignKtFromGovHydroFrancisEvent");
    this.kt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQc0ToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignQc0ToGovHydroFrancisEvent");
    this.qc0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQc0FromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignQc0FromGovHydroFrancisEvent");
    this.qc0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQnToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignQnToGovHydroFrancisEvent");
    this.qn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQnFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignQnFromGovHydroFrancisEvent");
    this.qn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignTaToGovHydroFrancisEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromGovHydroFrancisEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignTdToGovHydroFrancisEvent");
    this.td = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignTdFromGovHydroFrancisEvent");
    this.td = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTsToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignTsToGovHydroFrancisEvent");
    this.ts = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTsFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignTsFromGovHydroFrancisEvent");
    this.ts = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwncToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignTwncToGovHydroFrancisEvent");
    this.twnc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwncFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignTwncFromGovHydroFrancisEvent");
    this.twnc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwngToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignTwngToGovHydroFrancisEvent");
    this.twng = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwngFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignTwngFromGovHydroFrancisEvent");
    this.twng = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTxToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignTxToGovHydroFrancisEvent");
    this.tx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTxFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignTxFromGovHydroFrancisEvent");
    this.tx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignVaToGovHydroFrancisEvent");
    this.va = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignVaFromGovHydroFrancisEvent");
    this.va = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignValvmaxToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignValvmaxToGovHydroFrancisEvent");
    this.valvmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValvmaxFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignValvmaxFromGovHydroFrancisEvent");
    this.valvmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignValvminToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignValvminToGovHydroFrancisEvent");
    this.valvmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValvminFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignValvminFromGovHydroFrancisEvent");
    this.valvmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVcToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignVcToGovHydroFrancisEvent");
    this.vc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVcFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignVcFromGovHydroFrancisEvent");
    this.vc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisEvent");
    this.waterTunnelSurgeChamberSimulation = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisEvent");
    this.waterTunnelSurgeChamberSimulation = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignZsfcToGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing AssignZsfcToGovHydroFrancisEvent");
    this.zsfc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignZsfcFromGovHydroFrancisEvent event) {
    LOGGER.info("Event sourcing UnAssignZsfcFromGovHydroFrancisEvent");
    this.zsfc = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govHydroFrancisId;

  private FrancisGovernorControlKind governorControl;
  private PU am = null;
  private Area av0 = null;
  private Area av1 = null;
  private PU bp = null;
  private Frequency db1 = null;
  private PU etamax = null;
  private Length h1 = null;
  private Length h2 = null;
  private Length hn = null;
  private PU kc = null;
  private PU kg = null;
  private PU kt = null;
  private PU qc0 = null;
  private VolumeFlowRate qn = null;
  private Seconds ta = null;
  private Seconds td = null;
  private Seconds ts = null;
  private Seconds twnc = null;
  private Seconds twng = null;
  private Seconds tx = null;
  private Simple_Float va = null;
  private PU valvmax = null;
  private PU valvmin = null;
  private Simple_Float vc = null;
  private BooleanProxy waterTunnelSurgeChamberSimulation = null;
  private Length zsfc = null;

  private static final Logger LOGGER = Logger.getLogger(GovHydroFrancisAggregate.class.getName());
}
