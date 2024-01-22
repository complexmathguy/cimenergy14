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
 * Aggregate handler for GovCT2 as outlined for the CQRS pattern, all write responsibilities related
 * to GovCT2 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovCT2Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovCT2Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovCT2Aggregate(CreateGovCT2Command command) throws Exception {
    LOGGER.info("Handling command CreateGovCT2Command");
    CreateGovCT2Event event = new CreateGovCT2Event(command.getGovCT2Id(), command.getRselect());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovCT2Command command) throws Exception {
    LOGGER.info("handling command UpdateGovCT2Command");
    UpdateGovCT2Event event =
        new UpdateGovCT2Event(
            command.getGovCT2Id(),
            command.getAset(),
            command.getDb(),
            command.getDm(),
            command.getFlim1(),
            command.getFlim10(),
            command.getFlim2(),
            command.getFlim3(),
            command.getFlim4(),
            command.getFlim5(),
            command.getFlim6(),
            command.getFlim7(),
            command.getFlim8(),
            command.getFlim9(),
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
            command.getPlim1(),
            command.getPlim10(),
            command.getPlim2(),
            command.getPlim3(),
            command.getPlim4(),
            command.getPlim5(),
            command.getPlim6(),
            command.getPlim7(),
            command.getPlim8(),
            command.getPlim9(),
            command.getPrate(),
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
  public void handle(DeleteGovCT2Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovCT2Command");
    apply(new DeleteGovCT2Event(command.getGovCT2Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAsetToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignAsetToGovCT2Command");

    if (aset != null && aset.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Aset already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignAsetToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAsetFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAsetFromGovCT2Command");

    if (aset == null) throw new ProcessingException("Aset already has nothing assigned.");

    apply(new UnAssignAsetFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignDbToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignDbToGovCT2Command");

    if (db != null && db.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Db already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDbToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDbFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDbFromGovCT2Command");

    if (db == null) throw new ProcessingException("Db already has nothing assigned.");

    apply(new UnAssignDbFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignDmToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignDmToGovCT2Command");

    if (dm != null && dm.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dm already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDmToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDmFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDmFromGovCT2Command");

    if (dm == null) throw new ProcessingException("Dm already has nothing assigned.");

    apply(new UnAssignDmFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignFlim1ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignFlim1ToGovCT2Command");

    if (flim1 != null && flim1.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Flim1 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignFlim1ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFlim1FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFlim1FromGovCT2Command");

    if (flim1 == null) throw new ProcessingException("Flim1 already has nothing assigned.");

    apply(new UnAssignFlim1FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignFlim10ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignFlim10ToGovCT2Command");

    if (flim10 != null && flim10.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Flim10 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignFlim10ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFlim10FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFlim10FromGovCT2Command");

    if (flim10 == null) throw new ProcessingException("Flim10 already has nothing assigned.");

    apply(new UnAssignFlim10FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignFlim2ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignFlim2ToGovCT2Command");

    if (flim2 != null && flim2.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Flim2 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignFlim2ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFlim2FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFlim2FromGovCT2Command");

    if (flim2 == null) throw new ProcessingException("Flim2 already has nothing assigned.");

    apply(new UnAssignFlim2FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignFlim3ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignFlim3ToGovCT2Command");

    if (flim3 != null && flim3.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Flim3 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignFlim3ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFlim3FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFlim3FromGovCT2Command");

    if (flim3 == null) throw new ProcessingException("Flim3 already has nothing assigned.");

    apply(new UnAssignFlim3FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignFlim4ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignFlim4ToGovCT2Command");

    if (flim4 != null && flim4.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Flim4 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignFlim4ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFlim4FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFlim4FromGovCT2Command");

    if (flim4 == null) throw new ProcessingException("Flim4 already has nothing assigned.");

    apply(new UnAssignFlim4FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignFlim5ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignFlim5ToGovCT2Command");

    if (flim5 != null && flim5.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Flim5 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignFlim5ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFlim5FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFlim5FromGovCT2Command");

    if (flim5 == null) throw new ProcessingException("Flim5 already has nothing assigned.");

    apply(new UnAssignFlim5FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignFlim6ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignFlim6ToGovCT2Command");

    if (flim6 != null && flim6.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Flim6 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignFlim6ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFlim6FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFlim6FromGovCT2Command");

    if (flim6 == null) throw new ProcessingException("Flim6 already has nothing assigned.");

    apply(new UnAssignFlim6FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignFlim7ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignFlim7ToGovCT2Command");

    if (flim7 != null && flim7.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Flim7 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignFlim7ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFlim7FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFlim7FromGovCT2Command");

    if (flim7 == null) throw new ProcessingException("Flim7 already has nothing assigned.");

    apply(new UnAssignFlim7FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignFlim8ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignFlim8ToGovCT2Command");

    if (flim8 != null && flim8.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Flim8 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignFlim8ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFlim8FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFlim8FromGovCT2Command");

    if (flim8 == null) throw new ProcessingException("Flim8 already has nothing assigned.");

    apply(new UnAssignFlim8FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignFlim9ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignFlim9ToGovCT2Command");

    if (flim9 != null && flim9.getFrequencyId() == command.getAssignment().getFrequencyId())
      throw new ProcessingException(
          "Flim9 already assigned with id " + command.getAssignment().getFrequencyId());

    apply(new AssignFlim9ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFlim9FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFlim9FromGovCT2Command");

    if (flim9 == null) throw new ProcessingException("Flim9 already has nothing assigned.");

    apply(new UnAssignFlim9FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignKaToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignKaToGovCT2Command");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromGovCT2Command");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignKdgovToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignKdgovToGovCT2Command");

    if (kdgov != null && kdgov.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kdgov already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdgovToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdgovFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdgovFromGovCT2Command");

    if (kdgov == null) throw new ProcessingException("Kdgov already has nothing assigned.");

    apply(new UnAssignKdgovFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignKigovToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignKigovToGovCT2Command");

    if (kigov != null && kigov.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kigov already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKigovToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKigovFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKigovFromGovCT2Command");

    if (kigov == null) throw new ProcessingException("Kigov already has nothing assigned.");

    apply(new UnAssignKigovFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignKiloadToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignKiloadToGovCT2Command");

    if (kiload != null && kiload.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kiload already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiloadToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiloadFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiloadFromGovCT2Command");

    if (kiload == null) throw new ProcessingException("Kiload already has nothing assigned.");

    apply(new UnAssignKiloadFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignKimwToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignKimwToGovCT2Command");

    if (kimw != null && kimw.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kimw already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKimwToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKimwFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKimwFromGovCT2Command");

    if (kimw == null) throw new ProcessingException("Kimw already has nothing assigned.");

    apply(new UnAssignKimwFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignKpgovToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignKpgovToGovCT2Command");

    if (kpgov != null && kpgov.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpgov already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpgovToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpgovFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpgovFromGovCT2Command");

    if (kpgov == null) throw new ProcessingException("Kpgov already has nothing assigned.");

    apply(new UnAssignKpgovFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignKploadToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignKploadToGovCT2Command");

    if (kpload != null && kpload.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpload already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKploadToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKploadFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKploadFromGovCT2Command");

    if (kpload == null) throw new ProcessingException("Kpload already has nothing assigned.");

    apply(new UnAssignKploadFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignKturbToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignKturbToGovCT2Command");

    if (kturb != null && kturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKturbToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKturbFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKturbFromGovCT2Command");

    if (kturb == null) throw new ProcessingException("Kturb already has nothing assigned.");

    apply(new UnAssignKturbFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignLdrefToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignLdrefToGovCT2Command");

    if (ldref != null && ldref.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ldref already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignLdrefToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLdrefFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignLdrefFromGovCT2Command");

    if (ldref == null) throw new ProcessingException("Ldref already has nothing assigned.");

    apply(new UnAssignLdrefFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignMaxerrToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignMaxerrToGovCT2Command");

    if (maxerr != null && maxerr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Maxerr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignMaxerrToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxerrFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxerrFromGovCT2Command");

    if (maxerr == null) throw new ProcessingException("Maxerr already has nothing assigned.");

    apply(new UnAssignMaxerrFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignMinerrToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignMinerrToGovCT2Command");

    if (minerr != null && minerr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Minerr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignMinerrToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinerrFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMinerrFromGovCT2Command");

    if (minerr == null) throw new ProcessingException("Minerr already has nothing assigned.");

    apply(new UnAssignMinerrFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovCT2Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovCT2Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignPlim1ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignPlim1ToGovCT2Command");

    if (plim1 != null && plim1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Plim1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPlim1ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPlim1FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPlim1FromGovCT2Command");

    if (plim1 == null) throw new ProcessingException("Plim1 already has nothing assigned.");

    apply(new UnAssignPlim1FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignPlim10ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignPlim10ToGovCT2Command");

    if (plim10 != null && plim10.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Plim10 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPlim10ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPlim10FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPlim10FromGovCT2Command");

    if (plim10 == null) throw new ProcessingException("Plim10 already has nothing assigned.");

    apply(new UnAssignPlim10FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignPlim2ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignPlim2ToGovCT2Command");

    if (plim2 != null && plim2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Plim2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPlim2ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPlim2FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPlim2FromGovCT2Command");

    if (plim2 == null) throw new ProcessingException("Plim2 already has nothing assigned.");

    apply(new UnAssignPlim2FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignPlim3ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignPlim3ToGovCT2Command");

    if (plim3 != null && plim3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Plim3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPlim3ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPlim3FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPlim3FromGovCT2Command");

    if (plim3 == null) throw new ProcessingException("Plim3 already has nothing assigned.");

    apply(new UnAssignPlim3FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignPlim4ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignPlim4ToGovCT2Command");

    if (plim4 != null && plim4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Plim4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPlim4ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPlim4FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPlim4FromGovCT2Command");

    if (plim4 == null) throw new ProcessingException("Plim4 already has nothing assigned.");

    apply(new UnAssignPlim4FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignPlim5ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignPlim5ToGovCT2Command");

    if (plim5 != null && plim5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Plim5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPlim5ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPlim5FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPlim5FromGovCT2Command");

    if (plim5 == null) throw new ProcessingException("Plim5 already has nothing assigned.");

    apply(new UnAssignPlim5FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignPlim6ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignPlim6ToGovCT2Command");

    if (plim6 != null && plim6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Plim6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPlim6ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPlim6FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPlim6FromGovCT2Command");

    if (plim6 == null) throw new ProcessingException("Plim6 already has nothing assigned.");

    apply(new UnAssignPlim6FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignPlim7ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignPlim7ToGovCT2Command");

    if (plim7 != null && plim7.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Plim7 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPlim7ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPlim7FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPlim7FromGovCT2Command");

    if (plim7 == null) throw new ProcessingException("Plim7 already has nothing assigned.");

    apply(new UnAssignPlim7FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignPlim8ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignPlim8ToGovCT2Command");

    if (plim8 != null && plim8.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Plim8 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPlim8ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPlim8FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPlim8FromGovCT2Command");

    if (plim8 == null) throw new ProcessingException("Plim8 already has nothing assigned.");

    apply(new UnAssignPlim8FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignPlim9ToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignPlim9ToGovCT2Command");

    if (plim9 != null && plim9.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Plim9 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPlim9ToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPlim9FromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPlim9FromGovCT2Command");

    if (plim9 == null) throw new ProcessingException("Plim9 already has nothing assigned.");

    apply(new UnAssignPlim9FromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignPrateToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignPrateToGovCT2Command");

    if (prate != null && prate.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Prate already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPrateToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPrateFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPrateFromGovCT2Command");

    if (prate == null) throw new ProcessingException("Prate already has nothing assigned.");

    apply(new UnAssignPrateFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignRToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignRToGovCT2Command");

    if (r != null && r.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromGovCT2Command");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignRcloseToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignRcloseToGovCT2Command");

    if (rclose != null && rclose.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Rclose already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignRcloseToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRcloseFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRcloseFromGovCT2Command");

    if (rclose == null) throw new ProcessingException("Rclose already has nothing assigned.");

    apply(new UnAssignRcloseFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignRdownToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignRdownToGovCT2Command");

    if (rdown != null && rdown.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rdown already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRdownToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRdownFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRdownFromGovCT2Command");

    if (rdown == null) throw new ProcessingException("Rdown already has nothing assigned.");

    apply(new UnAssignRdownFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignRopenToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignRopenToGovCT2Command");

    if (ropen != null && ropen.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ropen already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignRopenToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRopenFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRopenFromGovCT2Command");

    if (ropen == null) throw new ProcessingException("Ropen already has nothing assigned.");

    apply(new UnAssignRopenFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignRupToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignRupToGovCT2Command");

    if (rup != null && rup.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rup already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRupToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRupFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRupFromGovCT2Command");

    if (rup == null) throw new ProcessingException("Rup already has nothing assigned.");

    apply(new UnAssignRupFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignTaToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignTaToGovCT2Command");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromGovCT2Command");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignTactToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignTactToGovCT2Command");

    if (tact != null && tact.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tact already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTactToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTactFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTactFromGovCT2Command");

    if (tact == null) throw new ProcessingException("Tact already has nothing assigned.");

    apply(new UnAssignTactFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignTbToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignTbToGovCT2Command");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromGovCT2Command");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignTcToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignTcToGovCT2Command");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromGovCT2Command");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignTdgovToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignTdgovToGovCT2Command");

    if (tdgov != null && tdgov.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tdgov already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdgovToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdgovFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdgovFromGovCT2Command");

    if (tdgov == null) throw new ProcessingException("Tdgov already has nothing assigned.");

    apply(new UnAssignTdgovFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignTengToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignTengToGovCT2Command");

    if (teng != null && teng.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Teng already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTengToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTengFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTengFromGovCT2Command");

    if (teng == null) throw new ProcessingException("Teng already has nothing assigned.");

    apply(new UnAssignTengFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignTfloadToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignTfloadToGovCT2Command");

    if (tfload != null && tfload.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tfload already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfloadToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfloadFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfloadFromGovCT2Command");

    if (tfload == null) throw new ProcessingException("Tfload already has nothing assigned.");

    apply(new UnAssignTfloadFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignTpelecToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignTpelecToGovCT2Command");

    if (tpelec != null && tpelec.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpelec already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpelecToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpelecFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpelecFromGovCT2Command");

    if (tpelec == null) throw new ProcessingException("Tpelec already has nothing assigned.");

    apply(new UnAssignTpelecFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignTsaToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignTsaToGovCT2Command");

    if (tsa != null && tsa.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tsa already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTsaToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTsaFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTsaFromGovCT2Command");

    if (tsa == null) throw new ProcessingException("Tsa already has nothing assigned.");

    apply(new UnAssignTsaFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignTsbToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignTsbToGovCT2Command");

    if (tsb != null && tsb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tsb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTsbToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTsbFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTsbFromGovCT2Command");

    if (tsb == null) throw new ProcessingException("Tsb already has nothing assigned.");

    apply(new UnAssignTsbFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignVmaxToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignVmaxToGovCT2Command");

    if (vmax != null && vmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmaxToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmaxFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmaxFromGovCT2Command");

    if (vmax == null) throw new ProcessingException("Vmax already has nothing assigned.");

    apply(new UnAssignVmaxFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignVminToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignVminToGovCT2Command");

    if (vmin != null && vmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVminToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVminFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVminFromGovCT2Command");

    if (vmin == null) throw new ProcessingException("Vmin already has nothing assigned.");

    apply(new UnAssignVminFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignWfnlToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignWfnlToGovCT2Command");

    if (wfnl != null && wfnl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Wfnl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignWfnlToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWfnlFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignWfnlFromGovCT2Command");

    if (wfnl == null) throw new ProcessingException("Wfnl already has nothing assigned.");

    apply(new UnAssignWfnlFromGovCT2Event(command.getGovCT2Id()));
  }

  @CommandHandler
  public void handle(AssignWfspdToGovCT2Command command) throws Exception {
    LOGGER.info("Handling command AssignWfspdToGovCT2Command");

    if (wfspd != null && wfspd.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Wfspd already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignWfspdToGovCT2Event(command.getGovCT2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWfspdFromGovCT2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignWfspdFromGovCT2Command");

    if (wfspd == null) throw new ProcessingException("Wfspd already has nothing assigned.");

    apply(new UnAssignWfspdFromGovCT2Event(command.getGovCT2Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovCT2Event event) {
    LOGGER.info("Event sourcing CreateGovCT2Event");
    this.govCT2Id = event.getGovCT2Id();
    this.rselect = event.getRselect();
  }

  @EventSourcingHandler
  void on(UpdateGovCT2Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.aset = event.getAset();
    this.db = event.getDb();
    this.dm = event.getDm();
    this.flim1 = event.getFlim1();
    this.flim10 = event.getFlim10();
    this.flim2 = event.getFlim2();
    this.flim3 = event.getFlim3();
    this.flim4 = event.getFlim4();
    this.flim5 = event.getFlim5();
    this.flim6 = event.getFlim6();
    this.flim7 = event.getFlim7();
    this.flim8 = event.getFlim8();
    this.flim9 = event.getFlim9();
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
    this.plim1 = event.getPlim1();
    this.plim10 = event.getPlim10();
    this.plim2 = event.getPlim2();
    this.plim3 = event.getPlim3();
    this.plim4 = event.getPlim4();
    this.plim5 = event.getPlim5();
    this.plim6 = event.getPlim6();
    this.plim7 = event.getPlim7();
    this.plim8 = event.getPlim8();
    this.plim9 = event.getPlim9();
    this.prate = event.getPrate();
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
  void on(AssignAsetToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignAsetToGovCT2Event");
    this.aset = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAsetFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignAsetFromGovCT2Event");
    this.aset = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDbToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignDbToGovCT2Event");
    this.db = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDbFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignDbFromGovCT2Event");
    this.db = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDmToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignDmToGovCT2Event");
    this.dm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDmFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignDmFromGovCT2Event");
    this.dm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFlim1ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignFlim1ToGovCT2Event");
    this.flim1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFlim1FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignFlim1FromGovCT2Event");
    this.flim1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFlim10ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignFlim10ToGovCT2Event");
    this.flim10 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFlim10FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignFlim10FromGovCT2Event");
    this.flim10 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFlim2ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignFlim2ToGovCT2Event");
    this.flim2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFlim2FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignFlim2FromGovCT2Event");
    this.flim2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFlim3ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignFlim3ToGovCT2Event");
    this.flim3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFlim3FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignFlim3FromGovCT2Event");
    this.flim3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFlim4ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignFlim4ToGovCT2Event");
    this.flim4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFlim4FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignFlim4FromGovCT2Event");
    this.flim4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFlim5ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignFlim5ToGovCT2Event");
    this.flim5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFlim5FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignFlim5FromGovCT2Event");
    this.flim5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFlim6ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignFlim6ToGovCT2Event");
    this.flim6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFlim6FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignFlim6FromGovCT2Event");
    this.flim6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFlim7ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignFlim7ToGovCT2Event");
    this.flim7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFlim7FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignFlim7FromGovCT2Event");
    this.flim7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFlim8ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignFlim8ToGovCT2Event");
    this.flim8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFlim8FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignFlim8FromGovCT2Event");
    this.flim8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFlim9ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignFlim9ToGovCT2Event");
    this.flim9 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFlim9FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignFlim9FromGovCT2Event");
    this.flim9 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignKaToGovCT2Event");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignKaFromGovCT2Event");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdgovToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignKdgovToGovCT2Event");
    this.kdgov = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdgovFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignKdgovFromGovCT2Event");
    this.kdgov = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKigovToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignKigovToGovCT2Event");
    this.kigov = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKigovFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignKigovFromGovCT2Event");
    this.kigov = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiloadToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignKiloadToGovCT2Event");
    this.kiload = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiloadFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignKiloadFromGovCT2Event");
    this.kiload = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKimwToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignKimwToGovCT2Event");
    this.kimw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKimwFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignKimwFromGovCT2Event");
    this.kimw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpgovToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignKpgovToGovCT2Event");
    this.kpgov = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpgovFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignKpgovFromGovCT2Event");
    this.kpgov = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKploadToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignKploadToGovCT2Event");
    this.kpload = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKploadFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignKploadFromGovCT2Event");
    this.kpload = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKturbToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignKturbToGovCT2Event");
    this.kturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKturbFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignKturbFromGovCT2Event");
    this.kturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLdrefToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignLdrefToGovCT2Event");
    this.ldref = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLdrefFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignLdrefFromGovCT2Event");
    this.ldref = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxerrToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignMaxerrToGovCT2Event");
    this.maxerr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxerrFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignMaxerrFromGovCT2Event");
    this.maxerr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinerrToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignMinerrToGovCT2Event");
    this.minerr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinerrFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignMinerrFromGovCT2Event");
    this.minerr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovCT2Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovCT2Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPlim1ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignPlim1ToGovCT2Event");
    this.plim1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPlim1FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignPlim1FromGovCT2Event");
    this.plim1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPlim10ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignPlim10ToGovCT2Event");
    this.plim10 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPlim10FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignPlim10FromGovCT2Event");
    this.plim10 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPlim2ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignPlim2ToGovCT2Event");
    this.plim2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPlim2FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignPlim2FromGovCT2Event");
    this.plim2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPlim3ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignPlim3ToGovCT2Event");
    this.plim3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPlim3FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignPlim3FromGovCT2Event");
    this.plim3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPlim4ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignPlim4ToGovCT2Event");
    this.plim4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPlim4FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignPlim4FromGovCT2Event");
    this.plim4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPlim5ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignPlim5ToGovCT2Event");
    this.plim5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPlim5FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignPlim5FromGovCT2Event");
    this.plim5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPlim6ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignPlim6ToGovCT2Event");
    this.plim6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPlim6FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignPlim6FromGovCT2Event");
    this.plim6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPlim7ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignPlim7ToGovCT2Event");
    this.plim7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPlim7FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignPlim7FromGovCT2Event");
    this.plim7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPlim8ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignPlim8ToGovCT2Event");
    this.plim8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPlim8FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignPlim8FromGovCT2Event");
    this.plim8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPlim9ToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignPlim9ToGovCT2Event");
    this.plim9 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPlim9FromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignPlim9FromGovCT2Event");
    this.plim9 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPrateToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignPrateToGovCT2Event");
    this.prate = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPrateFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignPrateFromGovCT2Event");
    this.prate = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignRToGovCT2Event");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignRFromGovCT2Event");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRcloseToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignRcloseToGovCT2Event");
    this.rclose = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRcloseFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignRcloseFromGovCT2Event");
    this.rclose = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRdownToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignRdownToGovCT2Event");
    this.rdown = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRdownFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignRdownFromGovCT2Event");
    this.rdown = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRopenToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignRopenToGovCT2Event");
    this.ropen = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRopenFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignRopenFromGovCT2Event");
    this.ropen = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRupToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignRupToGovCT2Event");
    this.rup = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRupFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignRupFromGovCT2Event");
    this.rup = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignTaToGovCT2Event");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignTaFromGovCT2Event");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTactToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignTactToGovCT2Event");
    this.tact = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTactFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignTactFromGovCT2Event");
    this.tact = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignTbToGovCT2Event");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignTbFromGovCT2Event");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignTcToGovCT2Event");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignTcFromGovCT2Event");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdgovToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignTdgovToGovCT2Event");
    this.tdgov = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdgovFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignTdgovFromGovCT2Event");
    this.tdgov = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTengToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignTengToGovCT2Event");
    this.teng = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTengFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignTengFromGovCT2Event");
    this.teng = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfloadToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignTfloadToGovCT2Event");
    this.tfload = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfloadFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignTfloadFromGovCT2Event");
    this.tfload = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpelecToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignTpelecToGovCT2Event");
    this.tpelec = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpelecFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignTpelecFromGovCT2Event");
    this.tpelec = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTsaToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignTsaToGovCT2Event");
    this.tsa = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTsaFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignTsaFromGovCT2Event");
    this.tsa = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTsbToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignTsbToGovCT2Event");
    this.tsb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTsbFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignTsbFromGovCT2Event");
    this.tsb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmaxToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignVmaxToGovCT2Event");
    this.vmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmaxFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignVmaxFromGovCT2Event");
    this.vmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVminToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignVminToGovCT2Event");
    this.vmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVminFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignVminFromGovCT2Event");
    this.vmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignWfnlToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignWfnlToGovCT2Event");
    this.wfnl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWfnlFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignWfnlFromGovCT2Event");
    this.wfnl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignWfspdToGovCT2Event event) {
    LOGGER.info("Event sourcing AssignWfspdToGovCT2Event");
    this.wfspd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWfspdFromGovCT2Event event) {
    LOGGER.info("Event sourcing UnAssignWfspdFromGovCT2Event");
    this.wfspd = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govCT2Id;

  private DroopSignalFeedbackKind rselect;
  private Simple_Float aset = null;
  private PU db = null;
  private PU dm = null;
  private Frequency flim1 = null;
  private Frequency flim10 = null;
  private Frequency flim2 = null;
  private Frequency flim3 = null;
  private Frequency flim4 = null;
  private Frequency flim5 = null;
  private Frequency flim6 = null;
  private Frequency flim7 = null;
  private Frequency flim8 = null;
  private Frequency flim9 = null;
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
  private PU plim1 = null;
  private PU plim10 = null;
  private PU plim2 = null;
  private PU plim3 = null;
  private PU plim4 = null;
  private PU plim5 = null;
  private PU plim6 = null;
  private PU plim7 = null;
  private PU plim8 = null;
  private PU plim9 = null;
  private PU prate = null;
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

  private static final Logger LOGGER = Logger.getLogger(GovCT2Aggregate.class.getName());
}
