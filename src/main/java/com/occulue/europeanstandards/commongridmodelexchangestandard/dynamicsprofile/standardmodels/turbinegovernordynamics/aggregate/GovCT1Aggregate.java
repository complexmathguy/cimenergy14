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
 * Aggregate handler for GovCT1 as outlined for the CQRS pattern, all write responsibilities related
 * to GovCT1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovCT1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovCT1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovCT1Aggregate(CreateGovCT1Command command) throws Exception {
    LOGGER.info("Handling command CreateGovCT1Command");
    CreateGovCT1Event event = new CreateGovCT1Event(command.getGovCT1Id(), command.getRselect());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovCT1Command command) throws Exception {
    LOGGER.info("handling command UpdateGovCT1Command");
    UpdateGovCT1Event event =
        new UpdateGovCT1Event(
            command.getGovCT1Id(),
            command.getAset(),
            command.getDb(),
            command.getDm(),
            command.getKa(),
            command.getKdgov(),
            command.getKigov(),
            command.getKiload(),
            command.getKimw(),
            command.getKpgov(),
            command.getKpload(),
            command.getKturb(),
            command.getLdref(),
            command.getMaxerr(),
            command.getMinerr(),
            command.getMwbase(),
            command.getR(),
            command.getRclose(),
            command.getRdown(),
            command.getRopen(),
            command.getRselect(),
            command.getRup(),
            command.getTa(),
            command.getTact(),
            command.getTb(),
            command.getTc(),
            command.getTdgov(),
            command.getTeng(),
            command.getTfload(),
            command.getTpelec(),
            command.getTsa(),
            command.getTsb(),
            command.getVmax(),
            command.getVmin(),
            command.getWfnl(),
            command.getWfspd());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovCT1Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovCT1Command");
    apply(new DeleteGovCT1Event(command.getGovCT1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAsetToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignAsetToGovCT1Command");

    if (aset != null && aset.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Aset already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignAsetToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAsetFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAsetFromGovCT1Command");

    if (aset == null) throw new ProcessingException("Aset already has nothing assigned.");

    apply(new UnAssignAsetFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignDbToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignDbToGovCT1Command");

    if (db != null && db.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Db already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDbToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDbFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDbFromGovCT1Command");

    if (db == null) throw new ProcessingException("Db already has nothing assigned.");

    apply(new UnAssignDbFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignDmToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignDmToGovCT1Command");

    if (dm != null && dm.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dm already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDmToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDmFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDmFromGovCT1Command");

    if (dm == null) throw new ProcessingException("Dm already has nothing assigned.");

    apply(new UnAssignDmFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignKaToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignKaToGovCT1Command");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromGovCT1Command");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignKdgovToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignKdgovToGovCT1Command");

    if (kdgov != null && kdgov.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kdgov already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdgovToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdgovFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdgovFromGovCT1Command");

    if (kdgov == null) throw new ProcessingException("Kdgov already has nothing assigned.");

    apply(new UnAssignKdgovFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignKigovToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignKigovToGovCT1Command");

    if (kigov != null && kigov.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kigov already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKigovToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKigovFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKigovFromGovCT1Command");

    if (kigov == null) throw new ProcessingException("Kigov already has nothing assigned.");

    apply(new UnAssignKigovFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignKiloadToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignKiloadToGovCT1Command");

    if (kiload != null && kiload.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kiload already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiloadToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiloadFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiloadFromGovCT1Command");

    if (kiload == null) throw new ProcessingException("Kiload already has nothing assigned.");

    apply(new UnAssignKiloadFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignKimwToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignKimwToGovCT1Command");

    if (kimw != null && kimw.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kimw already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKimwToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKimwFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKimwFromGovCT1Command");

    if (kimw == null) throw new ProcessingException("Kimw already has nothing assigned.");

    apply(new UnAssignKimwFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignKpgovToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignKpgovToGovCT1Command");

    if (kpgov != null && kpgov.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpgov already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpgovToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpgovFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpgovFromGovCT1Command");

    if (kpgov == null) throw new ProcessingException("Kpgov already has nothing assigned.");

    apply(new UnAssignKpgovFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignKploadToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignKploadToGovCT1Command");

    if (kpload != null && kpload.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpload already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKploadToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKploadFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKploadFromGovCT1Command");

    if (kpload == null) throw new ProcessingException("Kpload already has nothing assigned.");

    apply(new UnAssignKploadFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignKturbToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignKturbToGovCT1Command");

    if (kturb != null && kturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKturbToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKturbFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKturbFromGovCT1Command");

    if (kturb == null) throw new ProcessingException("Kturb already has nothing assigned.");

    apply(new UnAssignKturbFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignLdrefToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignLdrefToGovCT1Command");

    if (ldref != null && ldref.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ldref already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignLdrefToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLdrefFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignLdrefFromGovCT1Command");

    if (ldref == null) throw new ProcessingException("Ldref already has nothing assigned.");

    apply(new UnAssignLdrefFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignMaxerrToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignMaxerrToGovCT1Command");

    if (maxerr != null && maxerr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Maxerr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignMaxerrToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxerrFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxerrFromGovCT1Command");

    if (maxerr == null) throw new ProcessingException("Maxerr already has nothing assigned.");

    apply(new UnAssignMaxerrFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignMinerrToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignMinerrToGovCT1Command");

    if (minerr != null && minerr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Minerr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignMinerrToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinerrFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMinerrFromGovCT1Command");

    if (minerr == null) throw new ProcessingException("Minerr already has nothing assigned.");

    apply(new UnAssignMinerrFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovCT1Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovCT1Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignRToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignRToGovCT1Command");

    if (r != null && r.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromGovCT1Command");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignRcloseToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignRcloseToGovCT1Command");

    if (rclose != null && rclose.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Rclose already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignRcloseToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRcloseFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRcloseFromGovCT1Command");

    if (rclose == null) throw new ProcessingException("Rclose already has nothing assigned.");

    apply(new UnAssignRcloseFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignRdownToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignRdownToGovCT1Command");

    if (rdown != null && rdown.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rdown already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRdownToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRdownFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRdownFromGovCT1Command");

    if (rdown == null) throw new ProcessingException("Rdown already has nothing assigned.");

    apply(new UnAssignRdownFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignRopenToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignRopenToGovCT1Command");

    if (ropen != null && ropen.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ropen already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignRopenToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRopenFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRopenFromGovCT1Command");

    if (ropen == null) throw new ProcessingException("Ropen already has nothing assigned.");

    apply(new UnAssignRopenFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignRupToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignRupToGovCT1Command");

    if (rup != null && rup.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rup already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRupToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRupFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRupFromGovCT1Command");

    if (rup == null) throw new ProcessingException("Rup already has nothing assigned.");

    apply(new UnAssignRupFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignTaToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignTaToGovCT1Command");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromGovCT1Command");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignTactToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignTactToGovCT1Command");

    if (tact != null && tact.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tact already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTactToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTactFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTactFromGovCT1Command");

    if (tact == null) throw new ProcessingException("Tact already has nothing assigned.");

    apply(new UnAssignTactFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignTbToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignTbToGovCT1Command");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromGovCT1Command");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignTcToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignTcToGovCT1Command");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromGovCT1Command");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignTdgovToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignTdgovToGovCT1Command");

    if (tdgov != null && tdgov.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tdgov already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdgovToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdgovFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdgovFromGovCT1Command");

    if (tdgov == null) throw new ProcessingException("Tdgov already has nothing assigned.");

    apply(new UnAssignTdgovFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignTengToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignTengToGovCT1Command");

    if (teng != null && teng.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Teng already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTengToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTengFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTengFromGovCT1Command");

    if (teng == null) throw new ProcessingException("Teng already has nothing assigned.");

    apply(new UnAssignTengFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignTfloadToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignTfloadToGovCT1Command");

    if (tfload != null && tfload.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tfload already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfloadToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfloadFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfloadFromGovCT1Command");

    if (tfload == null) throw new ProcessingException("Tfload already has nothing assigned.");

    apply(new UnAssignTfloadFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignTpelecToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignTpelecToGovCT1Command");

    if (tpelec != null && tpelec.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpelec already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpelecToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpelecFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpelecFromGovCT1Command");

    if (tpelec == null) throw new ProcessingException("Tpelec already has nothing assigned.");

    apply(new UnAssignTpelecFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignTsaToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignTsaToGovCT1Command");

    if (tsa != null && tsa.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tsa already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTsaToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTsaFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTsaFromGovCT1Command");

    if (tsa == null) throw new ProcessingException("Tsa already has nothing assigned.");

    apply(new UnAssignTsaFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignTsbToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignTsbToGovCT1Command");

    if (tsb != null && tsb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tsb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTsbToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTsbFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTsbFromGovCT1Command");

    if (tsb == null) throw new ProcessingException("Tsb already has nothing assigned.");

    apply(new UnAssignTsbFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignVmaxToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignVmaxToGovCT1Command");

    if (vmax != null && vmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmaxToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmaxFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmaxFromGovCT1Command");

    if (vmax == null) throw new ProcessingException("Vmax already has nothing assigned.");

    apply(new UnAssignVmaxFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignVminToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignVminToGovCT1Command");

    if (vmin != null && vmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVminToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVminFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVminFromGovCT1Command");

    if (vmin == null) throw new ProcessingException("Vmin already has nothing assigned.");

    apply(new UnAssignVminFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignWfnlToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignWfnlToGovCT1Command");

    if (wfnl != null && wfnl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Wfnl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignWfnlToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWfnlFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignWfnlFromGovCT1Command");

    if (wfnl == null) throw new ProcessingException("Wfnl already has nothing assigned.");

    apply(new UnAssignWfnlFromGovCT1Event(command.getGovCT1Id()));
  }

  @CommandHandler
  public void handle(AssignWfspdToGovCT1Command command) throws Exception {
    LOGGER.info("Handling command AssignWfspdToGovCT1Command");

    if (wfspd != null && wfspd.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Wfspd already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignWfspdToGovCT1Event(command.getGovCT1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWfspdFromGovCT1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignWfspdFromGovCT1Command");

    if (wfspd == null) throw new ProcessingException("Wfspd already has nothing assigned.");

    apply(new UnAssignWfspdFromGovCT1Event(command.getGovCT1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovCT1Event event) {
    LOGGER.info("Event sourcing CreateGovCT1Event");
    this.govCT1Id = event.getGovCT1Id();
    this.rselect = event.getRselect();
  }

  @EventSourcingHandler
  void on(UpdateGovCT1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.aset = event.getAset();
    this.db = event.getDb();
    this.dm = event.getDm();
    this.ka = event.getKa();
    this.kdgov = event.getKdgov();
    this.kigov = event.getKigov();
    this.kiload = event.getKiload();
    this.kimw = event.getKimw();
    this.kpgov = event.getKpgov();
    this.kpload = event.getKpload();
    this.kturb = event.getKturb();
    this.ldref = event.getLdref();
    this.maxerr = event.getMaxerr();
    this.minerr = event.getMinerr();
    this.mwbase = event.getMwbase();
    this.r = event.getR();
    this.rclose = event.getRclose();
    this.rdown = event.getRdown();
    this.ropen = event.getRopen();
    this.rselect = event.getRselect();
    this.rup = event.getRup();
    this.ta = event.getTa();
    this.tact = event.getTact();
    this.tb = event.getTb();
    this.tc = event.getTc();
    this.tdgov = event.getTdgov();
    this.teng = event.getTeng();
    this.tfload = event.getTfload();
    this.tpelec = event.getTpelec();
    this.tsa = event.getTsa();
    this.tsb = event.getTsb();
    this.vmax = event.getVmax();
    this.vmin = event.getVmin();
    this.wfnl = event.getWfnl();
    this.wfspd = event.getWfspd();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAsetToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignAsetToGovCT1Event");
    this.aset = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAsetFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignAsetFromGovCT1Event");
    this.aset = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDbToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignDbToGovCT1Event");
    this.db = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDbFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignDbFromGovCT1Event");
    this.db = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDmToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignDmToGovCT1Event");
    this.dm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDmFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignDmFromGovCT1Event");
    this.dm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignKaToGovCT1Event");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignKaFromGovCT1Event");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdgovToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignKdgovToGovCT1Event");
    this.kdgov = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdgovFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignKdgovFromGovCT1Event");
    this.kdgov = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKigovToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignKigovToGovCT1Event");
    this.kigov = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKigovFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignKigovFromGovCT1Event");
    this.kigov = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiloadToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignKiloadToGovCT1Event");
    this.kiload = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiloadFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignKiloadFromGovCT1Event");
    this.kiload = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKimwToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignKimwToGovCT1Event");
    this.kimw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKimwFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignKimwFromGovCT1Event");
    this.kimw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpgovToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignKpgovToGovCT1Event");
    this.kpgov = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpgovFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignKpgovFromGovCT1Event");
    this.kpgov = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKploadToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignKploadToGovCT1Event");
    this.kpload = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKploadFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignKploadFromGovCT1Event");
    this.kpload = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKturbToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignKturbToGovCT1Event");
    this.kturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKturbFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignKturbFromGovCT1Event");
    this.kturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLdrefToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignLdrefToGovCT1Event");
    this.ldref = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLdrefFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignLdrefFromGovCT1Event");
    this.ldref = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxerrToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignMaxerrToGovCT1Event");
    this.maxerr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxerrFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignMaxerrFromGovCT1Event");
    this.maxerr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinerrToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignMinerrToGovCT1Event");
    this.minerr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinerrFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignMinerrFromGovCT1Event");
    this.minerr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovCT1Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovCT1Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignRToGovCT1Event");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignRFromGovCT1Event");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRcloseToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignRcloseToGovCT1Event");
    this.rclose = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRcloseFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignRcloseFromGovCT1Event");
    this.rclose = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRdownToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignRdownToGovCT1Event");
    this.rdown = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRdownFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignRdownFromGovCT1Event");
    this.rdown = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRopenToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignRopenToGovCT1Event");
    this.ropen = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRopenFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignRopenFromGovCT1Event");
    this.ropen = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRupToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignRupToGovCT1Event");
    this.rup = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRupFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignRupFromGovCT1Event");
    this.rup = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignTaToGovCT1Event");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignTaFromGovCT1Event");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTactToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignTactToGovCT1Event");
    this.tact = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTactFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignTactFromGovCT1Event");
    this.tact = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignTbToGovCT1Event");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignTbFromGovCT1Event");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignTcToGovCT1Event");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignTcFromGovCT1Event");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdgovToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignTdgovToGovCT1Event");
    this.tdgov = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdgovFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignTdgovFromGovCT1Event");
    this.tdgov = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTengToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignTengToGovCT1Event");
    this.teng = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTengFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignTengFromGovCT1Event");
    this.teng = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfloadToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignTfloadToGovCT1Event");
    this.tfload = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfloadFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignTfloadFromGovCT1Event");
    this.tfload = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpelecToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignTpelecToGovCT1Event");
    this.tpelec = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpelecFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignTpelecFromGovCT1Event");
    this.tpelec = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTsaToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignTsaToGovCT1Event");
    this.tsa = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTsaFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignTsaFromGovCT1Event");
    this.tsa = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTsbToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignTsbToGovCT1Event");
    this.tsb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTsbFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignTsbFromGovCT1Event");
    this.tsb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmaxToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignVmaxToGovCT1Event");
    this.vmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmaxFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignVmaxFromGovCT1Event");
    this.vmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVminToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignVminToGovCT1Event");
    this.vmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVminFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignVminFromGovCT1Event");
    this.vmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignWfnlToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignWfnlToGovCT1Event");
    this.wfnl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWfnlFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignWfnlFromGovCT1Event");
    this.wfnl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignWfspdToGovCT1Event event) {
    LOGGER.info("Event sourcing AssignWfspdToGovCT1Event");
    this.wfspd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWfspdFromGovCT1Event event) {
    LOGGER.info("Event sourcing UnAssignWfspdFromGovCT1Event");
    this.wfspd = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govCT1Id;

  private DroopSignalFeedbackKind rselect;
  private Simple_Float aset = null;
  private PU db = null;
  private PU dm = null;
  private PU ka = null;
  private PU kdgov = null;
  private PU kigov = null;
  private PU kiload = null;
  private PU kimw = null;
  private PU kpgov = null;
  private PU kpload = null;
  private PU kturb = null;
  private PU ldref = null;
  private PU maxerr = null;
  private PU minerr = null;
  private ActivePower mwbase = null;
  private PU r = null;
  private Simple_Float rclose = null;
  private PU rdown = null;
  private Simple_Float ropen = null;
  private PU rup = null;
  private Seconds ta = null;
  private Seconds tact = null;
  private Seconds tb = null;
  private Seconds tc = null;
  private Seconds tdgov = null;
  private Seconds teng = null;
  private Seconds tfload = null;
  private Seconds tpelec = null;
  private Seconds tsa = null;
  private Seconds tsb = null;
  private PU vmax = null;
  private PU vmin = null;
  private PU wfnl = null;
  private BooleanProxy wfspd = null;

  private static final Logger LOGGER = Logger.getLogger(GovCT1Aggregate.class.getName());
}
