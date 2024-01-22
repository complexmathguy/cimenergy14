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
 * Aggregate handler for GovHydroPelton as outlined for the CQRS pattern, all write responsibilities
 * related to GovHydroPelton are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovHydroPeltonAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovHydroPeltonAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovHydroPeltonAggregate(CreateGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command CreateGovHydroPeltonCommand");
    CreateGovHydroPeltonEvent event = new CreateGovHydroPeltonEvent(command.getGovHydroPeltonId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("handling command UpdateGovHydroPeltonCommand");
    UpdateGovHydroPeltonEvent event =
        new UpdateGovHydroPeltonEvent(
            command.getGovHydroPeltonId(),
            command.getAv0(),
            command.getAv1(),
            command.getBp(),
            command.getDb1(),
            command.getDb2(),
            command.getH1(),
            command.getH2(),
            command.getHn(),
            command.getKc(),
            command.getKg(),
            command.getQc0(),
            command.getQn(),
            command.getSimplifiedPelton(),
            command.getStaticCompensating(),
            command.getTa(),
            command.getTs(),
            command.getTv(),
            command.getTwnc(),
            command.getTwng(),
            command.getTx(),
            command.getVa(),
            command.getValvmax(),
            command.getValvmin(),
            command.getVav(),
            command.getVc(),
            command.getVcv(),
            command.getWaterTunnelSurgeChamberSimulation(),
            command.getZsfc());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGovHydroPeltonCommand");
    apply(new DeleteGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAv0ToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignAv0ToGovHydroPeltonCommand");

    if (av0 != null && av0.getAreaId() == command.getAssignment().getAreaId())
      throw new ProcessingException(
          "Av0 already assigned with id " + command.getAssignment().getAreaId());

    apply(
        new AssignAv0ToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAv0FromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAv0FromGovHydroPeltonCommand");

    if (av0 == null) throw new ProcessingException("Av0 already has nothing assigned.");

    apply(new UnAssignAv0FromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignAv1ToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignAv1ToGovHydroPeltonCommand");

    if (av1 != null && av1.getAreaId() == command.getAssignment().getAreaId())
      throw new ProcessingException(
          "Av1 already assigned with id " + command.getAssignment().getAreaId());

    apply(
        new AssignAv1ToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAv1FromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAv1FromGovHydroPeltonCommand");

    if (av1 == null) throw new ProcessingException("Av1 already has nothing assigned.");

    apply(new UnAssignAv1FromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignBpToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignBpToGovHydroPeltonCommand");

    if (bp != null && bp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bp already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignBpToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBpFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBpFromGovHydroPeltonCommand");

    if (bp == null) throw new ProcessingException("Bp already has nothing assigned.");

    apply(new UnAssignBpFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignDb1ToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignDb1ToGovHydroPeltonCommand");

    if (db1 != null && db1.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Db1 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(
        new AssignDb1ToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb1FromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb1FromGovHydroPeltonCommand");

    if (db1 == null) throw new ProcessingException("Db1 already has nothing assigned.");

    apply(new UnAssignDb1FromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignDb2ToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignDb2ToGovHydroPeltonCommand");

    if (db2 != null && db2.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Db2 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(
        new AssignDb2ToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb2FromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb2FromGovHydroPeltonCommand");

    if (db2 == null) throw new ProcessingException("Db2 already has nothing assigned.");

    apply(new UnAssignDb2FromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignH1ToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignH1ToGovHydroPeltonCommand");

    if (h1 != null && h1.getLengthId() == command.getAssignment().getLengthId())
      throw new ProcessingException(
          "H1 already assigned with id " + command.getAssignment().getLengthId());

    apply(
        new AssignH1ToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignH1FromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignH1FromGovHydroPeltonCommand");

    if (h1 == null) throw new ProcessingException("H1 already has nothing assigned.");

    apply(new UnAssignH1FromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignH2ToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignH2ToGovHydroPeltonCommand");

    if (h2 != null && h2.getLengthId() == command.getAssignment().getLengthId())
      throw new ProcessingException(
          "H2 already assigned with id " + command.getAssignment().getLengthId());

    apply(
        new AssignH2ToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignH2FromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignH2FromGovHydroPeltonCommand");

    if (h2 == null) throw new ProcessingException("H2 already has nothing assigned.");

    apply(new UnAssignH2FromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignHnToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignHnToGovHydroPeltonCommand");

    if (hn != null && hn.getLengthId() == command.getAssignment().getLengthId())
      throw new ProcessingException(
          "Hn already assigned with id " + command.getAssignment().getLengthId());

    apply(
        new AssignHnToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHnFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignHnFromGovHydroPeltonCommand");

    if (hn == null) throw new ProcessingException("Hn already has nothing assigned.");

    apply(new UnAssignHnFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignKcToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToGovHydroPeltonCommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKcToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromGovHydroPeltonCommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignKgToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignKgToGovHydroPeltonCommand");

    if (kg != null && kg.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kg already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKgToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKgFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKgFromGovHydroPeltonCommand");

    if (kg == null) throw new ProcessingException("Kg already has nothing assigned.");

    apply(new UnAssignKgFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignQc0ToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignQc0ToGovHydroPeltonCommand");

    if (qc0 != null && qc0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Qc0 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQc0ToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQc0FromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQc0FromGovHydroPeltonCommand");

    if (qc0 == null) throw new ProcessingException("Qc0 already has nothing assigned.");

    apply(new UnAssignQc0FromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignQnToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignQnToGovHydroPeltonCommand");

    if (qn != null && qn.getVolumeFlowRateId() == command.getAssignment().getVolumeFlowRateId())
      throw new ProcessingException(
          "Qn already assigned with id " + command.getAssignment().getVolumeFlowRateId());

    apply(
        new AssignQnToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQnFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQnFromGovHydroPeltonCommand");

    if (qn == null) throw new ProcessingException("Qn already has nothing assigned.");

    apply(new UnAssignQnFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignSimplifiedPeltonToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignSimplifiedPeltonToGovHydroPeltonCommand");

    if (simplifiedPelton != null
        && simplifiedPelton.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "SimplifiedPelton already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignSimplifiedPeltonToGovHydroPeltonEvent(
            command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSimplifiedPeltonFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSimplifiedPeltonFromGovHydroPeltonCommand");

    if (simplifiedPelton == null)
      throw new ProcessingException("SimplifiedPelton already has nothing assigned.");

    apply(new UnAssignSimplifiedPeltonFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignStaticCompensatingToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignStaticCompensatingToGovHydroPeltonCommand");

    if (staticCompensating != null
        && staticCompensating.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "StaticCompensating already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignStaticCompensatingToGovHydroPeltonEvent(
            command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignStaticCompensatingFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignStaticCompensatingFromGovHydroPeltonCommand");

    if (staticCompensating == null)
      throw new ProcessingException("StaticCompensating already has nothing assigned.");

    apply(new UnAssignStaticCompensatingFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignTaToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToGovHydroPeltonCommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTaToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromGovHydroPeltonCommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignTsToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignTsToGovHydroPeltonCommand");

    if (ts != null && ts.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ts already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTsToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTsFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTsFromGovHydroPeltonCommand");

    if (ts == null) throw new ProcessingException("Ts already has nothing assigned.");

    apply(new UnAssignTsFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignTvToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignTvToGovHydroPeltonCommand");

    if (tv != null && tv.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tv already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTvToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTvFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTvFromGovHydroPeltonCommand");

    if (tv == null) throw new ProcessingException("Tv already has nothing assigned.");

    apply(new UnAssignTvFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignTwncToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwncToGovHydroPeltonCommand");

    if (twnc != null && twnc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Twnc already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTwncToGovHydroPeltonEvent(
            command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwncFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwncFromGovHydroPeltonCommand");

    if (twnc == null) throw new ProcessingException("Twnc already has nothing assigned.");

    apply(new UnAssignTwncFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignTwngToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwngToGovHydroPeltonCommand");

    if (twng != null && twng.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Twng already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTwngToGovHydroPeltonEvent(
            command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwngFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwngFromGovHydroPeltonCommand");

    if (twng == null) throw new ProcessingException("Twng already has nothing assigned.");

    apply(new UnAssignTwngFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignTxToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignTxToGovHydroPeltonCommand");

    if (tx != null && tx.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tx already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTxToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTxFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTxFromGovHydroPeltonCommand");

    if (tx == null) throw new ProcessingException("Tx already has nothing assigned.");

    apply(new UnAssignTxFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignVaToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignVaToGovHydroPeltonCommand");

    if (va != null && va.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Va already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignVaToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVaFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVaFromGovHydroPeltonCommand");

    if (va == null) throw new ProcessingException("Va already has nothing assigned.");

    apply(new UnAssignVaFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignValvmaxToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignValvmaxToGovHydroPeltonCommand");

    if (valvmax != null && valvmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Valvmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignValvmaxToGovHydroPeltonEvent(
            command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValvmaxFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValvmaxFromGovHydroPeltonCommand");

    if (valvmax == null) throw new ProcessingException("Valvmax already has nothing assigned.");

    apply(new UnAssignValvmaxFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignValvminToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignValvminToGovHydroPeltonCommand");

    if (valvmin != null && valvmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Valvmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignValvminToGovHydroPeltonEvent(
            command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValvminFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValvminFromGovHydroPeltonCommand");

    if (valvmin == null) throw new ProcessingException("Valvmin already has nothing assigned.");

    apply(new UnAssignValvminFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignVavToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignVavToGovHydroPeltonCommand");

    if (vav != null && vav.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vav already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVavToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVavFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVavFromGovHydroPeltonCommand");

    if (vav == null) throw new ProcessingException("Vav already has nothing assigned.");

    apply(new UnAssignVavFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignVcToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignVcToGovHydroPeltonCommand");

    if (vc != null && vc.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Vc already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignVcToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVcFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVcFromGovHydroPeltonCommand");

    if (vc == null) throw new ProcessingException("Vc already has nothing assigned.");

    apply(new UnAssignVcFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignVcvToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignVcvToGovHydroPeltonCommand");

    if (vcv != null && vcv.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vcv already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVcvToGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVcvFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVcvFromGovHydroPeltonCommand");

    if (vcv == null) throw new ProcessingException("Vcv already has nothing assigned.");

    apply(new UnAssignVcvFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonCommand");

    if (waterTunnelSurgeChamberSimulation != null
        && waterTunnelSurgeChamberSimulation.getBooleanProxyId()
            == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "WaterTunnelSurgeChamberSimulation already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonEvent(
            command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonCommand");

    if (waterTunnelSurgeChamberSimulation == null)
      throw new ProcessingException(
          "WaterTunnelSurgeChamberSimulation already has nothing assigned.");

    apply(
        new UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonEvent(
            command.getGovHydroPeltonId()));
  }

  @CommandHandler
  public void handle(AssignZsfcToGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handling command AssignZsfcToGovHydroPeltonCommand");

    if (zsfc != null && zsfc.getLengthId() == command.getAssignment().getLengthId())
      throw new ProcessingException(
          "Zsfc already assigned with id " + command.getAssignment().getLengthId());

    apply(
        new AssignZsfcToGovHydroPeltonEvent(
            command.getGovHydroPeltonId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignZsfcFromGovHydroPeltonCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignZsfcFromGovHydroPeltonCommand");

    if (zsfc == null) throw new ProcessingException("Zsfc already has nothing assigned.");

    apply(new UnAssignZsfcFromGovHydroPeltonEvent(command.getGovHydroPeltonId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing CreateGovHydroPeltonEvent");
    this.govHydroPeltonId = event.getGovHydroPeltonId();
  }

  @EventSourcingHandler
  void on(UpdateGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.av0 = event.getAv0();
    this.av1 = event.getAv1();
    this.bp = event.getBp();
    this.db1 = event.getDb1();
    this.db2 = event.getDb2();
    this.h1 = event.getH1();
    this.h2 = event.getH2();
    this.hn = event.getHn();
    this.kc = event.getKc();
    this.kg = event.getKg();
    this.qc0 = event.getQc0();
    this.qn = event.getQn();
    this.simplifiedPelton = event.getSimplifiedPelton();
    this.staticCompensating = event.getStaticCompensating();
    this.ta = event.getTa();
    this.ts = event.getTs();
    this.tv = event.getTv();
    this.twnc = event.getTwnc();
    this.twng = event.getTwng();
    this.tx = event.getTx();
    this.va = event.getVa();
    this.valvmax = event.getValvmax();
    this.valvmin = event.getValvmin();
    this.vav = event.getVav();
    this.vc = event.getVc();
    this.vcv = event.getVcv();
    this.waterTunnelSurgeChamberSimulation = event.getWaterTunnelSurgeChamberSimulation();
    this.zsfc = event.getZsfc();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAv0ToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignAv0ToGovHydroPeltonEvent");
    this.av0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAv0FromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignAv0FromGovHydroPeltonEvent");
    this.av0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignAv1ToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignAv1ToGovHydroPeltonEvent");
    this.av1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAv1FromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignAv1FromGovHydroPeltonEvent");
    this.av1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBpToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignBpToGovHydroPeltonEvent");
    this.bp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBpFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignBpFromGovHydroPeltonEvent");
    this.bp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb1ToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignDb1ToGovHydroPeltonEvent");
    this.db1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb1FromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignDb1FromGovHydroPeltonEvent");
    this.db1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb2ToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignDb2ToGovHydroPeltonEvent");
    this.db2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb2FromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignDb2FromGovHydroPeltonEvent");
    this.db2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignH1ToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignH1ToGovHydroPeltonEvent");
    this.h1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignH1FromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignH1FromGovHydroPeltonEvent");
    this.h1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignH2ToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignH2ToGovHydroPeltonEvent");
    this.h2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignH2FromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignH2FromGovHydroPeltonEvent");
    this.h2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignHnToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignHnToGovHydroPeltonEvent");
    this.hn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHnFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignHnFromGovHydroPeltonEvent");
    this.hn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignKcToGovHydroPeltonEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromGovHydroPeltonEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKgToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignKgToGovHydroPeltonEvent");
    this.kg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKgFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignKgFromGovHydroPeltonEvent");
    this.kg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQc0ToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignQc0ToGovHydroPeltonEvent");
    this.qc0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQc0FromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignQc0FromGovHydroPeltonEvent");
    this.qc0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQnToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignQnToGovHydroPeltonEvent");
    this.qn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQnFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignQnFromGovHydroPeltonEvent");
    this.qn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSimplifiedPeltonToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignSimplifiedPeltonToGovHydroPeltonEvent");
    this.simplifiedPelton = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSimplifiedPeltonFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignSimplifiedPeltonFromGovHydroPeltonEvent");
    this.simplifiedPelton = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignStaticCompensatingToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignStaticCompensatingToGovHydroPeltonEvent");
    this.staticCompensating = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignStaticCompensatingFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignStaticCompensatingFromGovHydroPeltonEvent");
    this.staticCompensating = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignTaToGovHydroPeltonEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromGovHydroPeltonEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTsToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignTsToGovHydroPeltonEvent");
    this.ts = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTsFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignTsFromGovHydroPeltonEvent");
    this.ts = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTvToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignTvToGovHydroPeltonEvent");
    this.tv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTvFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignTvFromGovHydroPeltonEvent");
    this.tv = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwncToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignTwncToGovHydroPeltonEvent");
    this.twnc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwncFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignTwncFromGovHydroPeltonEvent");
    this.twnc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwngToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignTwngToGovHydroPeltonEvent");
    this.twng = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwngFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignTwngFromGovHydroPeltonEvent");
    this.twng = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTxToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignTxToGovHydroPeltonEvent");
    this.tx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTxFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignTxFromGovHydroPeltonEvent");
    this.tx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVaToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignVaToGovHydroPeltonEvent");
    this.va = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVaFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignVaFromGovHydroPeltonEvent");
    this.va = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignValvmaxToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignValvmaxToGovHydroPeltonEvent");
    this.valvmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValvmaxFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignValvmaxFromGovHydroPeltonEvent");
    this.valvmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignValvminToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignValvminToGovHydroPeltonEvent");
    this.valvmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValvminFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignValvminFromGovHydroPeltonEvent");
    this.valvmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVavToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignVavToGovHydroPeltonEvent");
    this.vav = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVavFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignVavFromGovHydroPeltonEvent");
    this.vav = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVcToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignVcToGovHydroPeltonEvent");
    this.vc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVcFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignVcFromGovHydroPeltonEvent");
    this.vc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVcvToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignVcvToGovHydroPeltonEvent");
    this.vcv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVcvFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignVcvFromGovHydroPeltonEvent");
    this.vcv = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonEvent");
    this.waterTunnelSurgeChamberSimulation = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonEvent");
    this.waterTunnelSurgeChamberSimulation = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignZsfcToGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing AssignZsfcToGovHydroPeltonEvent");
    this.zsfc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignZsfcFromGovHydroPeltonEvent event) {
    LOGGER.info("Event sourcing UnAssignZsfcFromGovHydroPeltonEvent");
    this.zsfc = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govHydroPeltonId;

  private Area av0 = null;
  private Area av1 = null;
  private PU bp = null;
  private Frequency db1 = null;
  private Frequency db2 = null;
  private Length h1 = null;
  private Length h2 = null;
  private Length hn = null;
  private PU kc = null;
  private PU kg = null;
  private PU qc0 = null;
  private VolumeFlowRate qn = null;
  private BooleanProxy simplifiedPelton = null;
  private BooleanProxy staticCompensating = null;
  private Seconds ta = null;
  private Seconds ts = null;
  private Seconds tv = null;
  private Seconds twnc = null;
  private Seconds twng = null;
  private Seconds tx = null;
  private Simple_Float va = null;
  private PU valvmax = null;
  private PU valvmin = null;
  private PU vav = null;
  private Simple_Float vc = null;
  private PU vcv = null;
  private BooleanProxy waterTunnelSurgeChamberSimulation = null;
  private Length zsfc = null;

  private static final Logger LOGGER = Logger.getLogger(GovHydroPeltonAggregate.class.getName());
}
