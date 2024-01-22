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
 * Aggregate handler for GovSteamEU as outlined for the CQRS pattern, all write responsibilities
 * related to GovSteamEU are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovSteamEUAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovSteamEUAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovSteamEUAggregate(CreateGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command CreateGovSteamEUCommand");
    CreateGovSteamEUEvent event = new CreateGovSteamEUEvent(command.getGovSteamEUId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovSteamEUCommand command) throws Exception {
    LOGGER.info("handling command UpdateGovSteamEUCommand");
    UpdateGovSteamEUEvent event =
        new UpdateGovSteamEUEvent(
            command.getGovSteamEUId(),
            command.getChc(),
            command.getCho(),
            command.getCic(),
            command.getCio(),
            command.getDb1(),
            command.getDb2(),
            command.getHhpmax(),
            command.getKe(),
            command.getKfcor(),
            command.getKhp(),
            command.getKlp(),
            command.getKwcor(),
            command.getMwbase(),
            command.getPmax(),
            command.getPrhmax(),
            command.getSimx(),
            command.getTb(),
            command.getTdp(),
            command.getTen(),
            command.getTf(),
            command.getTfp(),
            command.getThp(),
            command.getTip(),
            command.getTlp(),
            command.getTp(),
            command.getTrh(),
            command.getTvhp(),
            command.getTvip(),
            command.getTw(),
            command.getWfmax(),
            command.getWfmin(),
            command.getWmax1(),
            command.getWmax2(),
            command.getWwmax(),
            command.getWwmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGovSteamEUCommand");
    apply(new DeleteGovSteamEUEvent(command.getGovSteamEUId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignChcToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignChcToGovSteamEUCommand");

    if (chc != null && chc.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Chc already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignChcToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignChcFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignChcFromGovSteamEUCommand");

    if (chc == null) throw new ProcessingException("Chc already has nothing assigned.");

    apply(new UnAssignChcFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignChoToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignChoToGovSteamEUCommand");

    if (cho != null && cho.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Cho already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignChoToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignChoFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignChoFromGovSteamEUCommand");

    if (cho == null) throw new ProcessingException("Cho already has nothing assigned.");

    apply(new UnAssignChoFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignCicToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignCicToGovSteamEUCommand");

    if (cic != null && cic.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Cic already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignCicToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCicFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignCicFromGovSteamEUCommand");

    if (cic == null) throw new ProcessingException("Cic already has nothing assigned.");

    apply(new UnAssignCicFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignCioToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignCioToGovSteamEUCommand");

    if (cio != null && cio.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Cio already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignCioToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCioFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignCioFromGovSteamEUCommand");

    if (cio == null) throw new ProcessingException("Cio already has nothing assigned.");

    apply(new UnAssignCioFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignDb1ToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignDb1ToGovSteamEUCommand");

    if (db1 != null && db1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Db1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDb1ToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb1FromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb1FromGovSteamEUCommand");

    if (db1 == null) throw new ProcessingException("Db1 already has nothing assigned.");

    apply(new UnAssignDb1FromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignDb2ToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignDb2ToGovSteamEUCommand");

    if (db2 != null && db2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Db2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDb2ToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDb2FromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDb2FromGovSteamEUCommand");

    if (db2 == null) throw new ProcessingException("Db2 already has nothing assigned.");

    apply(new UnAssignDb2FromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignHhpmaxToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignHhpmaxToGovSteamEUCommand");

    if (hhpmax != null && hhpmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Hhpmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignHhpmaxToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHhpmaxFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignHhpmaxFromGovSteamEUCommand");

    if (hhpmax == null) throw new ProcessingException("Hhpmax already has nothing assigned.");

    apply(new UnAssignHhpmaxFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignKeToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignKeToGovSteamEUCommand");

    if (ke != null && ke.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKeToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKeFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKeFromGovSteamEUCommand");

    if (ke == null) throw new ProcessingException("Ke already has nothing assigned.");

    apply(new UnAssignKeFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignKfcorToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignKfcorToGovSteamEUCommand");

    if (kfcor != null && kfcor.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kfcor already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKfcorToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfcorFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfcorFromGovSteamEUCommand");

    if (kfcor == null) throw new ProcessingException("Kfcor already has nothing assigned.");

    apply(new UnAssignKfcorFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignKhpToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignKhpToGovSteamEUCommand");

    if (khp != null && khp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Khp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKhpToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKhpFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKhpFromGovSteamEUCommand");

    if (khp == null) throw new ProcessingException("Khp already has nothing assigned.");

    apply(new UnAssignKhpFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignKlpToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignKlpToGovSteamEUCommand");

    if (klp != null && klp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Klp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKlpToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKlpFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKlpFromGovSteamEUCommand");

    if (klp == null) throw new ProcessingException("Klp already has nothing assigned.");

    apply(new UnAssignKlpFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignKwcorToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignKwcorToGovSteamEUCommand");

    if (kwcor != null && kwcor.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kwcor already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKwcorToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKwcorFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKwcorFromGovSteamEUCommand");

    if (kwcor == null) throw new ProcessingException("Kwcor already has nothing assigned.");

    apply(new UnAssignKwcorFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovSteamEUCommand");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovSteamEUCommand");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignPmaxToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmaxToGovSteamEUCommand");

    if (pmax != null && pmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmaxToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxFromGovSteamEUCommand");

    if (pmax == null) throw new ProcessingException("Pmax already has nothing assigned.");

    apply(new UnAssignPmaxFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignPrhmaxToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignPrhmaxToGovSteamEUCommand");

    if (prhmax != null && prhmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Prhmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPrhmaxToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPrhmaxFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPrhmaxFromGovSteamEUCommand");

    if (prhmax == null) throw new ProcessingException("Prhmax already has nothing assigned.");

    apply(new UnAssignPrhmaxFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignSimxToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignSimxToGovSteamEUCommand");

    if (simx != null && simx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Simx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignSimxToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSimxFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSimxFromGovSteamEUCommand");

    if (simx == null) throw new ProcessingException("Simx already has nothing assigned.");

    apply(new UnAssignSimxFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignTbToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToGovSteamEUCommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromGovSteamEUCommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignTdpToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTdpToGovSteamEUCommand");

    if (tdp != null && tdp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tdp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdpToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdpFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdpFromGovSteamEUCommand");

    if (tdp == null) throw new ProcessingException("Tdp already has nothing assigned.");

    apply(new UnAssignTdpFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignTenToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTenToGovSteamEUCommand");

    if (ten != null && ten.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ten already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTenToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTenFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTenFromGovSteamEUCommand");

    if (ten == null) throw new ProcessingException("Ten already has nothing assigned.");

    apply(new UnAssignTenFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignTfToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTfToGovSteamEUCommand");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromGovSteamEUCommand");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignTfpToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTfpToGovSteamEUCommand");

    if (tfp != null && tfp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tfp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfpToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfpFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfpFromGovSteamEUCommand");

    if (tfp == null) throw new ProcessingException("Tfp already has nothing assigned.");

    apply(new UnAssignTfpFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignThpToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignThpToGovSteamEUCommand");

    if (thp != null && thp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Thp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignThpToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignThpFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignThpFromGovSteamEUCommand");

    if (thp == null) throw new ProcessingException("Thp already has nothing assigned.");

    apply(new UnAssignThpFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignTipToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTipToGovSteamEUCommand");

    if (tip != null && tip.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tip already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTipToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTipFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTipFromGovSteamEUCommand");

    if (tip == null) throw new ProcessingException("Tip already has nothing assigned.");

    apply(new UnAssignTipFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignTlpToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTlpToGovSteamEUCommand");

    if (tlp != null && tlp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tlp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTlpToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTlpFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTlpFromGovSteamEUCommand");

    if (tlp == null) throw new ProcessingException("Tlp already has nothing assigned.");

    apply(new UnAssignTlpFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignTpToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpToGovSteamEUCommand");

    if (tp != null && tp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpFromGovSteamEUCommand");

    if (tp == null) throw new ProcessingException("Tp already has nothing assigned.");

    apply(new UnAssignTpFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignTrhToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTrhToGovSteamEUCommand");

    if (trh != null && trh.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Trh already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTrhToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrhFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrhFromGovSteamEUCommand");

    if (trh == null) throw new ProcessingException("Trh already has nothing assigned.");

    apply(new UnAssignTrhFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignTvhpToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTvhpToGovSteamEUCommand");

    if (tvhp != null && tvhp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tvhp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTvhpToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTvhpFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTvhpFromGovSteamEUCommand");

    if (tvhp == null) throw new ProcessingException("Tvhp already has nothing assigned.");

    apply(new UnAssignTvhpFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignTvipToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTvipToGovSteamEUCommand");

    if (tvip != null && tvip.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tvip already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTvipToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTvipFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTvipFromGovSteamEUCommand");

    if (tvip == null) throw new ProcessingException("Tvip already has nothing assigned.");

    apply(new UnAssignTvipFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignTwToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwToGovSteamEUCommand");

    if (tw != null && tw.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTwToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwFromGovSteamEUCommand");

    if (tw == null) throw new ProcessingException("Tw already has nothing assigned.");

    apply(new UnAssignTwFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignWfmaxToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignWfmaxToGovSteamEUCommand");

    if (wfmax != null && wfmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Wfmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignWfmaxToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWfmaxFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignWfmaxFromGovSteamEUCommand");

    if (wfmax == null) throw new ProcessingException("Wfmax already has nothing assigned.");

    apply(new UnAssignWfmaxFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignWfminToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignWfminToGovSteamEUCommand");

    if (wfmin != null && wfmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Wfmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignWfminToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWfminFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignWfminFromGovSteamEUCommand");

    if (wfmin == null) throw new ProcessingException("Wfmin already has nothing assigned.");

    apply(new UnAssignWfminFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignWmax1ToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignWmax1ToGovSteamEUCommand");

    if (wmax1 != null && wmax1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Wmax1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignWmax1ToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWmax1FromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignWmax1FromGovSteamEUCommand");

    if (wmax1 == null) throw new ProcessingException("Wmax1 already has nothing assigned.");

    apply(new UnAssignWmax1FromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignWmax2ToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignWmax2ToGovSteamEUCommand");

    if (wmax2 != null && wmax2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Wmax2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignWmax2ToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWmax2FromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignWmax2FromGovSteamEUCommand");

    if (wmax2 == null) throw new ProcessingException("Wmax2 already has nothing assigned.");

    apply(new UnAssignWmax2FromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignWwmaxToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignWwmaxToGovSteamEUCommand");

    if (wwmax != null && wwmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Wwmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignWwmaxToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWwmaxFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignWwmaxFromGovSteamEUCommand");

    if (wwmax == null) throw new ProcessingException("Wwmax already has nothing assigned.");

    apply(new UnAssignWwmaxFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  @CommandHandler
  public void handle(AssignWwminToGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handling command AssignWwminToGovSteamEUCommand");

    if (wwmin != null && wwmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Wwmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignWwminToGovSteamEUEvent(command.getGovSteamEUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWwminFromGovSteamEUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignWwminFromGovSteamEUCommand");

    if (wwmin == null) throw new ProcessingException("Wwmin already has nothing assigned.");

    apply(new UnAssignWwminFromGovSteamEUEvent(command.getGovSteamEUId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovSteamEUEvent event) {
    LOGGER.info("Event sourcing CreateGovSteamEUEvent");
    this.govSteamEUId = event.getGovSteamEUId();
  }

  @EventSourcingHandler
  void on(UpdateGovSteamEUEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.chc = event.getChc();
    this.cho = event.getCho();
    this.cic = event.getCic();
    this.cio = event.getCio();
    this.db1 = event.getDb1();
    this.db2 = event.getDb2();
    this.hhpmax = event.getHhpmax();
    this.ke = event.getKe();
    this.kfcor = event.getKfcor();
    this.khp = event.getKhp();
    this.klp = event.getKlp();
    this.kwcor = event.getKwcor();
    this.mwbase = event.getMwbase();
    this.pmax = event.getPmax();
    this.prhmax = event.getPrhmax();
    this.simx = event.getSimx();
    this.tb = event.getTb();
    this.tdp = event.getTdp();
    this.ten = event.getTen();
    this.tf = event.getTf();
    this.tfp = event.getTfp();
    this.thp = event.getThp();
    this.tip = event.getTip();
    this.tlp = event.getTlp();
    this.tp = event.getTp();
    this.trh = event.getTrh();
    this.tvhp = event.getTvhp();
    this.tvip = event.getTvip();
    this.tw = event.getTw();
    this.wfmax = event.getWfmax();
    this.wfmin = event.getWfmin();
    this.wmax1 = event.getWmax1();
    this.wmax2 = event.getWmax2();
    this.wwmax = event.getWwmax();
    this.wwmin = event.getWwmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignChcToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignChcToGovSteamEUEvent");
    this.chc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignChcFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignChcFromGovSteamEUEvent");
    this.chc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignChoToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignChoToGovSteamEUEvent");
    this.cho = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignChoFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignChoFromGovSteamEUEvent");
    this.cho = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignCicToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignCicToGovSteamEUEvent");
    this.cic = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCicFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignCicFromGovSteamEUEvent");
    this.cic = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignCioToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignCioToGovSteamEUEvent");
    this.cio = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCioFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignCioFromGovSteamEUEvent");
    this.cio = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb1ToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignDb1ToGovSteamEUEvent");
    this.db1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb1FromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignDb1FromGovSteamEUEvent");
    this.db1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDb2ToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignDb2ToGovSteamEUEvent");
    this.db2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDb2FromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignDb2FromGovSteamEUEvent");
    this.db2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignHhpmaxToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignHhpmaxToGovSteamEUEvent");
    this.hhpmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHhpmaxFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignHhpmaxFromGovSteamEUEvent");
    this.hhpmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKeToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignKeToGovSteamEUEvent");
    this.ke = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKeFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignKeFromGovSteamEUEvent");
    this.ke = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfcorToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignKfcorToGovSteamEUEvent");
    this.kfcor = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfcorFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignKfcorFromGovSteamEUEvent");
    this.kfcor = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKhpToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignKhpToGovSteamEUEvent");
    this.khp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKhpFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignKhpFromGovSteamEUEvent");
    this.khp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKlpToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignKlpToGovSteamEUEvent");
    this.klp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKlpFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignKlpFromGovSteamEUEvent");
    this.klp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKwcorToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignKwcorToGovSteamEUEvent");
    this.kwcor = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKwcorFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignKwcorFromGovSteamEUEvent");
    this.kwcor = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovSteamEUEvent");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovSteamEUEvent");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignPmaxToGovSteamEUEvent");
    this.pmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignPmaxFromGovSteamEUEvent");
    this.pmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPrhmaxToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignPrhmaxToGovSteamEUEvent");
    this.prhmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPrhmaxFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignPrhmaxFromGovSteamEUEvent");
    this.prhmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSimxToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignSimxToGovSteamEUEvent");
    this.simx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSimxFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignSimxFromGovSteamEUEvent");
    this.simx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignTbToGovSteamEUEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromGovSteamEUEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdpToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignTdpToGovSteamEUEvent");
    this.tdp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdpFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignTdpFromGovSteamEUEvent");
    this.tdp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTenToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignTenToGovSteamEUEvent");
    this.ten = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTenFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignTenFromGovSteamEUEvent");
    this.ten = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignTfToGovSteamEUEvent");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignTfFromGovSteamEUEvent");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfpToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignTfpToGovSteamEUEvent");
    this.tfp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfpFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignTfpFromGovSteamEUEvent");
    this.tfp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignThpToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignThpToGovSteamEUEvent");
    this.thp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignThpFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignThpFromGovSteamEUEvent");
    this.thp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTipToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignTipToGovSteamEUEvent");
    this.tip = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTipFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignTipFromGovSteamEUEvent");
    this.tip = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTlpToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignTlpToGovSteamEUEvent");
    this.tlp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTlpFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignTlpFromGovSteamEUEvent");
    this.tlp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignTpToGovSteamEUEvent");
    this.tp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignTpFromGovSteamEUEvent");
    this.tp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrhToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignTrhToGovSteamEUEvent");
    this.trh = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrhFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignTrhFromGovSteamEUEvent");
    this.trh = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTvhpToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignTvhpToGovSteamEUEvent");
    this.tvhp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTvhpFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignTvhpFromGovSteamEUEvent");
    this.tvhp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTvipToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignTvipToGovSteamEUEvent");
    this.tvip = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTvipFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignTvipFromGovSteamEUEvent");
    this.tvip = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignTwToGovSteamEUEvent");
    this.tw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignTwFromGovSteamEUEvent");
    this.tw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignWfmaxToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignWfmaxToGovSteamEUEvent");
    this.wfmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWfmaxFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignWfmaxFromGovSteamEUEvent");
    this.wfmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignWfminToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignWfminToGovSteamEUEvent");
    this.wfmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWfminFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignWfminFromGovSteamEUEvent");
    this.wfmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignWmax1ToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignWmax1ToGovSteamEUEvent");
    this.wmax1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWmax1FromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignWmax1FromGovSteamEUEvent");
    this.wmax1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignWmax2ToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignWmax2ToGovSteamEUEvent");
    this.wmax2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWmax2FromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignWmax2FromGovSteamEUEvent");
    this.wmax2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignWwmaxToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignWwmaxToGovSteamEUEvent");
    this.wwmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWwmaxFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignWwmaxFromGovSteamEUEvent");
    this.wwmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignWwminToGovSteamEUEvent event) {
    LOGGER.info("Event sourcing AssignWwminToGovSteamEUEvent");
    this.wwmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWwminFromGovSteamEUEvent event) {
    LOGGER.info("Event sourcing UnAssignWwminFromGovSteamEUEvent");
    this.wwmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govSteamEUId;

  private Simple_Float chc = null;
  private Simple_Float cho = null;
  private PU cic = null;
  private PU cio = null;
  private PU db1 = null;
  private PU db2 = null;
  private PU hhpmax = null;
  private PU ke = null;
  private PU kfcor = null;
  private PU khp = null;
  private PU klp = null;
  private PU kwcor = null;
  private ActivePower mwbase = null;
  private PU pmax = null;
  private PU prhmax = null;
  private PU simx = null;
  private Seconds tb = null;
  private Seconds tdp = null;
  private Seconds ten = null;
  private Seconds tf = null;
  private Seconds tfp = null;
  private Seconds thp = null;
  private Seconds tip = null;
  private Seconds tlp = null;
  private Seconds tp = null;
  private Seconds trh = null;
  private Seconds tvhp = null;
  private Seconds tvip = null;
  private Seconds tw = null;
  private PU wfmax = null;
  private PU wfmin = null;
  private PU wmax1 = null;
  private PU wmax2 = null;
  private PU wwmax = null;
  private PU wwmin = null;

  private static final Logger LOGGER = Logger.getLogger(GovSteamEUAggregate.class.getName());
}
