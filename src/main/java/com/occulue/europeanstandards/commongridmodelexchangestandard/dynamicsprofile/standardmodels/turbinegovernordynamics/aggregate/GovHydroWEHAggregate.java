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
 * Aggregate handler for GovHydroWEH as outlined for the CQRS pattern, all write responsibilities
 * related to GovHydroWEH are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovHydroWEHAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovHydroWEHAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovHydroWEHAggregate(CreateGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command CreateGovHydroWEHCommand");
    CreateGovHydroWEHEvent event = new CreateGovHydroWEHEvent(command.getGovHydroWEHId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovHydroWEHCommand command) throws Exception {
    LOGGER.info("handling command UpdateGovHydroWEHCommand");
    UpdateGovHydroWEHEvent event =
        new UpdateGovHydroWEHEvent(
            command.getGovHydroWEHId(),
            command.getDb(),
            command.getDicn(),
            command.getDpv(),
            command.getDturb(),
            command.getFeedbackSignal(),
            command.getFl1(),
            command.getFl2(),
            command.getFl3(),
            command.getFl4(),
            command.getFl5(),
            command.getFp1(),
            command.getFp10(),
            command.getFp2(),
            command.getFp3(),
            command.getFp4(),
            command.getFp5(),
            command.getFp6(),
            command.getFp7(),
            command.getFp8(),
            command.getFp9(),
            command.getGmax(),
            command.getGmin(),
            command.getGtmxcl(),
            command.getGtmxop(),
            command.getGv1(),
            command.getGv2(),
            command.getGv3(),
            command.getGv4(),
            command.getGv5(),
            command.getKd(),
            command.getKi(),
            command.getKp(),
            command.getMwbase(),
            command.getPmss1(),
            command.getPmss10(),
            command.getPmss2(),
            command.getPmss3(),
            command.getPmss4(),
            command.getPmss5(),
            command.getPmss6(),
            command.getPmss7(),
            command.getPmss8(),
            command.getPmss9(),
            command.getRpg(),
            command.getRpp(),
            command.getTd(),
            command.getTdv(),
            command.getTg(),
            command.getTp(),
            command.getTpe(),
            command.getTw());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGovHydroWEHCommand");
    apply(new DeleteGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDbToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignDbToGovHydroWEHCommand");

    if (db != null && db.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Db already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDbToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDbFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDbFromGovHydroWEHCommand");

    if (db == null) throw new ProcessingException("Db already has nothing assigned.");

    apply(new UnAssignDbFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignDicnToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignDicnToGovHydroWEHCommand");

    if (dicn != null && dicn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dicn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDicnToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDicnFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDicnFromGovHydroWEHCommand");

    if (dicn == null) throw new ProcessingException("Dicn already has nothing assigned.");

    apply(new UnAssignDicnFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignDpvToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignDpvToGovHydroWEHCommand");

    if (dpv != null && dpv.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dpv already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDpvToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDpvFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDpvFromGovHydroWEHCommand");

    if (dpv == null) throw new ProcessingException("Dpv already has nothing assigned.");

    apply(new UnAssignDpvFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignDturbToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignDturbToGovHydroWEHCommand");

    if (dturb != null && dturb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dturb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDturbToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDturbFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDturbFromGovHydroWEHCommand");

    if (dturb == null) throw new ProcessingException("Dturb already has nothing assigned.");

    apply(new UnAssignDturbFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFeedbackSignalToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFeedbackSignalToGovHydroWEHCommand");

    if (feedbackSignal != null
        && feedbackSignal.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "FeedbackSignal already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignFeedbackSignalToGovHydroWEHEvent(
            command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFeedbackSignalFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFeedbackSignalFromGovHydroWEHCommand");

    if (feedbackSignal == null)
      throw new ProcessingException("FeedbackSignal already has nothing assigned.");

    apply(new UnAssignFeedbackSignalFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFl1ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFl1ToGovHydroWEHCommand");

    if (fl1 != null && fl1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fl1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFl1ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFl1FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFl1FromGovHydroWEHCommand");

    if (fl1 == null) throw new ProcessingException("Fl1 already has nothing assigned.");

    apply(new UnAssignFl1FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFl2ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFl2ToGovHydroWEHCommand");

    if (fl2 != null && fl2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fl2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFl2ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFl2FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFl2FromGovHydroWEHCommand");

    if (fl2 == null) throw new ProcessingException("Fl2 already has nothing assigned.");

    apply(new UnAssignFl2FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFl3ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFl3ToGovHydroWEHCommand");

    if (fl3 != null && fl3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fl3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFl3ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFl3FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFl3FromGovHydroWEHCommand");

    if (fl3 == null) throw new ProcessingException("Fl3 already has nothing assigned.");

    apply(new UnAssignFl3FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFl4ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFl4ToGovHydroWEHCommand");

    if (fl4 != null && fl4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fl4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFl4ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFl4FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFl4FromGovHydroWEHCommand");

    if (fl4 == null) throw new ProcessingException("Fl4 already has nothing assigned.");

    apply(new UnAssignFl4FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFl5ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFl5ToGovHydroWEHCommand");

    if (fl5 != null && fl5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fl5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFl5ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFl5FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFl5FromGovHydroWEHCommand");

    if (fl5 == null) throw new ProcessingException("Fl5 already has nothing assigned.");

    apply(new UnAssignFl5FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFp1ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFp1ToGovHydroWEHCommand");

    if (fp1 != null && fp1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fp1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFp1ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFp1FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFp1FromGovHydroWEHCommand");

    if (fp1 == null) throw new ProcessingException("Fp1 already has nothing assigned.");

    apply(new UnAssignFp1FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFp10ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFp10ToGovHydroWEHCommand");

    if (fp10 != null && fp10.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fp10 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFp10ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFp10FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFp10FromGovHydroWEHCommand");

    if (fp10 == null) throw new ProcessingException("Fp10 already has nothing assigned.");

    apply(new UnAssignFp10FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFp2ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFp2ToGovHydroWEHCommand");

    if (fp2 != null && fp2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fp2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFp2ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFp2FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFp2FromGovHydroWEHCommand");

    if (fp2 == null) throw new ProcessingException("Fp2 already has nothing assigned.");

    apply(new UnAssignFp2FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFp3ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFp3ToGovHydroWEHCommand");

    if (fp3 != null && fp3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fp3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFp3ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFp3FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFp3FromGovHydroWEHCommand");

    if (fp3 == null) throw new ProcessingException("Fp3 already has nothing assigned.");

    apply(new UnAssignFp3FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFp4ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFp4ToGovHydroWEHCommand");

    if (fp4 != null && fp4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fp4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFp4ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFp4FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFp4FromGovHydroWEHCommand");

    if (fp4 == null) throw new ProcessingException("Fp4 already has nothing assigned.");

    apply(new UnAssignFp4FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFp5ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFp5ToGovHydroWEHCommand");

    if (fp5 != null && fp5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fp5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFp5ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFp5FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFp5FromGovHydroWEHCommand");

    if (fp5 == null) throw new ProcessingException("Fp5 already has nothing assigned.");

    apply(new UnAssignFp5FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFp6ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFp6ToGovHydroWEHCommand");

    if (fp6 != null && fp6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fp6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFp6ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFp6FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFp6FromGovHydroWEHCommand");

    if (fp6 == null) throw new ProcessingException("Fp6 already has nothing assigned.");

    apply(new UnAssignFp6FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFp7ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFp7ToGovHydroWEHCommand");

    if (fp7 != null && fp7.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fp7 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFp7ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFp7FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFp7FromGovHydroWEHCommand");

    if (fp7 == null) throw new ProcessingException("Fp7 already has nothing assigned.");

    apply(new UnAssignFp7FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFp8ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFp8ToGovHydroWEHCommand");

    if (fp8 != null && fp8.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fp8 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFp8ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFp8FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFp8FromGovHydroWEHCommand");

    if (fp8 == null) throw new ProcessingException("Fp8 already has nothing assigned.");

    apply(new UnAssignFp8FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignFp9ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignFp9ToGovHydroWEHCommand");

    if (fp9 != null && fp9.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Fp9 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignFp9ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFp9FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFp9FromGovHydroWEHCommand");

    if (fp9 == null) throw new ProcessingException("Fp9 already has nothing assigned.");

    apply(new UnAssignFp9FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignGmaxToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignGmaxToGovHydroWEHCommand");

    if (gmax != null && gmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGmaxToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGmaxFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGmaxFromGovHydroWEHCommand");

    if (gmax == null) throw new ProcessingException("Gmax already has nothing assigned.");

    apply(new UnAssignGmaxFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignGminToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignGminToGovHydroWEHCommand");

    if (gmin != null && gmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGminToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGminFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGminFromGovHydroWEHCommand");

    if (gmin == null) throw new ProcessingException("Gmin already has nothing assigned.");

    apply(new UnAssignGminFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignGtmxclToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignGtmxclToGovHydroWEHCommand");

    if (gtmxcl != null && gtmxcl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gtmxcl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGtmxclToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGtmxclFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGtmxclFromGovHydroWEHCommand");

    if (gtmxcl == null) throw new ProcessingException("Gtmxcl already has nothing assigned.");

    apply(new UnAssignGtmxclFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignGtmxopToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignGtmxopToGovHydroWEHCommand");

    if (gtmxop != null && gtmxop.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gtmxop already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGtmxopToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGtmxopFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGtmxopFromGovHydroWEHCommand");

    if (gtmxop == null) throw new ProcessingException("Gtmxop already has nothing assigned.");

    apply(new UnAssignGtmxopFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignGv1ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv1ToGovHydroWEHCommand");

    if (gv1 != null && gv1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv1ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv1FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv1FromGovHydroWEHCommand");

    if (gv1 == null) throw new ProcessingException("Gv1 already has nothing assigned.");

    apply(new UnAssignGv1FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignGv2ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv2ToGovHydroWEHCommand");

    if (gv2 != null && gv2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv2ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv2FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv2FromGovHydroWEHCommand");

    if (gv2 == null) throw new ProcessingException("Gv2 already has nothing assigned.");

    apply(new UnAssignGv2FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignGv3ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv3ToGovHydroWEHCommand");

    if (gv3 != null && gv3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv3ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv3FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv3FromGovHydroWEHCommand");

    if (gv3 == null) throw new ProcessingException("Gv3 already has nothing assigned.");

    apply(new UnAssignGv3FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignGv4ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv4ToGovHydroWEHCommand");

    if (gv4 != null && gv4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv4ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv4FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv4FromGovHydroWEHCommand");

    if (gv4 == null) throw new ProcessingException("Gv4 already has nothing assigned.");

    apply(new UnAssignGv4FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignGv5ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignGv5ToGovHydroWEHCommand");

    if (gv5 != null && gv5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Gv5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignGv5ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGv5FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGv5FromGovHydroWEHCommand");

    if (gv5 == null) throw new ProcessingException("Gv5 already has nothing assigned.");

    apply(new UnAssignGv5FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignKdToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdToGovHydroWEHCommand");

    if (kd != null && kd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdFromGovHydroWEHCommand");

    if (kd == null) throw new ProcessingException("Kd already has nothing assigned.");

    apply(new UnAssignKdFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignKiToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToGovHydroWEHCommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromGovHydroWEHCommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignKpToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpToGovHydroWEHCommand");

    if (kp != null && kp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpFromGovHydroWEHCommand");

    if (kp == null) throw new ProcessingException("Kp already has nothing assigned.");

    apply(new UnAssignKpFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovHydroWEHCommand");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovHydroWEHCommand");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignPmss1ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmss1ToGovHydroWEHCommand");

    if (pmss1 != null && pmss1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmss1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmss1ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmss1FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmss1FromGovHydroWEHCommand");

    if (pmss1 == null) throw new ProcessingException("Pmss1 already has nothing assigned.");

    apply(new UnAssignPmss1FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignPmss10ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmss10ToGovHydroWEHCommand");

    if (pmss10 != null && pmss10.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmss10 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmss10ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmss10FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmss10FromGovHydroWEHCommand");

    if (pmss10 == null) throw new ProcessingException("Pmss10 already has nothing assigned.");

    apply(new UnAssignPmss10FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignPmss2ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmss2ToGovHydroWEHCommand");

    if (pmss2 != null && pmss2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmss2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmss2ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmss2FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmss2FromGovHydroWEHCommand");

    if (pmss2 == null) throw new ProcessingException("Pmss2 already has nothing assigned.");

    apply(new UnAssignPmss2FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignPmss3ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmss3ToGovHydroWEHCommand");

    if (pmss3 != null && pmss3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmss3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmss3ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmss3FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmss3FromGovHydroWEHCommand");

    if (pmss3 == null) throw new ProcessingException("Pmss3 already has nothing assigned.");

    apply(new UnAssignPmss3FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignPmss4ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmss4ToGovHydroWEHCommand");

    if (pmss4 != null && pmss4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmss4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmss4ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmss4FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmss4FromGovHydroWEHCommand");

    if (pmss4 == null) throw new ProcessingException("Pmss4 already has nothing assigned.");

    apply(new UnAssignPmss4FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignPmss5ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmss5ToGovHydroWEHCommand");

    if (pmss5 != null && pmss5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmss5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmss5ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmss5FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmss5FromGovHydroWEHCommand");

    if (pmss5 == null) throw new ProcessingException("Pmss5 already has nothing assigned.");

    apply(new UnAssignPmss5FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignPmss6ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmss6ToGovHydroWEHCommand");

    if (pmss6 != null && pmss6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmss6 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmss6ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmss6FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmss6FromGovHydroWEHCommand");

    if (pmss6 == null) throw new ProcessingException("Pmss6 already has nothing assigned.");

    apply(new UnAssignPmss6FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignPmss7ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmss7ToGovHydroWEHCommand");

    if (pmss7 != null && pmss7.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmss7 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmss7ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmss7FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmss7FromGovHydroWEHCommand");

    if (pmss7 == null) throw new ProcessingException("Pmss7 already has nothing assigned.");

    apply(new UnAssignPmss7FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignPmss8ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmss8ToGovHydroWEHCommand");

    if (pmss8 != null && pmss8.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmss8 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmss8ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmss8FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmss8FromGovHydroWEHCommand");

    if (pmss8 == null) throw new ProcessingException("Pmss8 already has nothing assigned.");

    apply(new UnAssignPmss8FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignPmss9ToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignPmss9ToGovHydroWEHCommand");

    if (pmss9 != null && pmss9.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmss9 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmss9ToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmss9FromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmss9FromGovHydroWEHCommand");

    if (pmss9 == null) throw new ProcessingException("Pmss9 already has nothing assigned.");

    apply(new UnAssignPmss9FromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignRpgToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignRpgToGovHydroWEHCommand");

    if (rpg != null && rpg.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Rpg already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignRpgToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRpgFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRpgFromGovHydroWEHCommand");

    if (rpg == null) throw new ProcessingException("Rpg already has nothing assigned.");

    apply(new UnAssignRpgFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignRppToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignRppToGovHydroWEHCommand");

    if (rpp != null && rpp.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Rpp already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignRppToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRppFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRppFromGovHydroWEHCommand");

    if (rpp == null) throw new ProcessingException("Rpp already has nothing assigned.");

    apply(new UnAssignRppFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignTdToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignTdToGovHydroWEHCommand");

    if (td != null && td.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Td already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdFromGovHydroWEHCommand");

    if (td == null) throw new ProcessingException("Td already has nothing assigned.");

    apply(new UnAssignTdFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignTdvToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignTdvToGovHydroWEHCommand");

    if (tdv != null && tdv.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tdv already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdvToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdvFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdvFromGovHydroWEHCommand");

    if (tdv == null) throw new ProcessingException("Tdv already has nothing assigned.");

    apply(new UnAssignTdvFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignTgToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignTgToGovHydroWEHCommand");

    if (tg != null && tg.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tg already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTgToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTgFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTgFromGovHydroWEHCommand");

    if (tg == null) throw new ProcessingException("Tg already has nothing assigned.");

    apply(new UnAssignTgFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignTpToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpToGovHydroWEHCommand");

    if (tp != null && tp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpFromGovHydroWEHCommand");

    if (tp == null) throw new ProcessingException("Tp already has nothing assigned.");

    apply(new UnAssignTpFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignTpeToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpeToGovHydroWEHCommand");

    if (tpe != null && tpe.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpe already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpeToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpeFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpeFromGovHydroWEHCommand");

    if (tpe == null) throw new ProcessingException("Tpe already has nothing assigned.");

    apply(new UnAssignTpeFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  @CommandHandler
  public void handle(AssignTwToGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwToGovHydroWEHCommand");

    if (tw != null && tw.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTwToGovHydroWEHEvent(command.getGovHydroWEHId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwFromGovHydroWEHCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwFromGovHydroWEHCommand");

    if (tw == null) throw new ProcessingException("Tw already has nothing assigned.");

    apply(new UnAssignTwFromGovHydroWEHEvent(command.getGovHydroWEHId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing CreateGovHydroWEHEvent");
    this.govHydroWEHId = event.getGovHydroWEHId();
  }

  @EventSourcingHandler
  void on(UpdateGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.db = event.getDb();
    this.dicn = event.getDicn();
    this.dpv = event.getDpv();
    this.dturb = event.getDturb();
    this.feedbackSignal = event.getFeedbackSignal();
    this.fl1 = event.getFl1();
    this.fl2 = event.getFl2();
    this.fl3 = event.getFl3();
    this.fl4 = event.getFl4();
    this.fl5 = event.getFl5();
    this.fp1 = event.getFp1();
    this.fp10 = event.getFp10();
    this.fp2 = event.getFp2();
    this.fp3 = event.getFp3();
    this.fp4 = event.getFp4();
    this.fp5 = event.getFp5();
    this.fp6 = event.getFp6();
    this.fp7 = event.getFp7();
    this.fp8 = event.getFp8();
    this.fp9 = event.getFp9();
    this.gmax = event.getGmax();
    this.gmin = event.getGmin();
    this.gtmxcl = event.getGtmxcl();
    this.gtmxop = event.getGtmxop();
    this.gv1 = event.getGv1();
    this.gv2 = event.getGv2();
    this.gv3 = event.getGv3();
    this.gv4 = event.getGv4();
    this.gv5 = event.getGv5();
    this.kd = event.getKd();
    this.ki = event.getKi();
    this.kp = event.getKp();
    this.mwbase = event.getMwbase();
    this.pmss1 = event.getPmss1();
    this.pmss10 = event.getPmss10();
    this.pmss2 = event.getPmss2();
    this.pmss3 = event.getPmss3();
    this.pmss4 = event.getPmss4();
    this.pmss5 = event.getPmss5();
    this.pmss6 = event.getPmss6();
    this.pmss7 = event.getPmss7();
    this.pmss8 = event.getPmss8();
    this.pmss9 = event.getPmss9();
    this.rpg = event.getRpg();
    this.rpp = event.getRpp();
    this.td = event.getTd();
    this.tdv = event.getTdv();
    this.tg = event.getTg();
    this.tp = event.getTp();
    this.tpe = event.getTpe();
    this.tw = event.getTw();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDbToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignDbToGovHydroWEHEvent");
    this.db = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDbFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignDbFromGovHydroWEHEvent");
    this.db = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDicnToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignDicnToGovHydroWEHEvent");
    this.dicn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDicnFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignDicnFromGovHydroWEHEvent");
    this.dicn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDpvToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignDpvToGovHydroWEHEvent");
    this.dpv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDpvFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignDpvFromGovHydroWEHEvent");
    this.dpv = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDturbToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignDturbToGovHydroWEHEvent");
    this.dturb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDturbFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignDturbFromGovHydroWEHEvent");
    this.dturb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFeedbackSignalToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFeedbackSignalToGovHydroWEHEvent");
    this.feedbackSignal = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFeedbackSignalFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFeedbackSignalFromGovHydroWEHEvent");
    this.feedbackSignal = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFl1ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFl1ToGovHydroWEHEvent");
    this.fl1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFl1FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFl1FromGovHydroWEHEvent");
    this.fl1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFl2ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFl2ToGovHydroWEHEvent");
    this.fl2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFl2FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFl2FromGovHydroWEHEvent");
    this.fl2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFl3ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFl3ToGovHydroWEHEvent");
    this.fl3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFl3FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFl3FromGovHydroWEHEvent");
    this.fl3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFl4ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFl4ToGovHydroWEHEvent");
    this.fl4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFl4FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFl4FromGovHydroWEHEvent");
    this.fl4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFl5ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFl5ToGovHydroWEHEvent");
    this.fl5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFl5FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFl5FromGovHydroWEHEvent");
    this.fl5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFp1ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFp1ToGovHydroWEHEvent");
    this.fp1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFp1FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFp1FromGovHydroWEHEvent");
    this.fp1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFp10ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFp10ToGovHydroWEHEvent");
    this.fp10 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFp10FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFp10FromGovHydroWEHEvent");
    this.fp10 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFp2ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFp2ToGovHydroWEHEvent");
    this.fp2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFp2FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFp2FromGovHydroWEHEvent");
    this.fp2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFp3ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFp3ToGovHydroWEHEvent");
    this.fp3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFp3FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFp3FromGovHydroWEHEvent");
    this.fp3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFp4ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFp4ToGovHydroWEHEvent");
    this.fp4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFp4FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFp4FromGovHydroWEHEvent");
    this.fp4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFp5ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFp5ToGovHydroWEHEvent");
    this.fp5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFp5FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFp5FromGovHydroWEHEvent");
    this.fp5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFp6ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFp6ToGovHydroWEHEvent");
    this.fp6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFp6FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFp6FromGovHydroWEHEvent");
    this.fp6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFp7ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFp7ToGovHydroWEHEvent");
    this.fp7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFp7FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFp7FromGovHydroWEHEvent");
    this.fp7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFp8ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFp8ToGovHydroWEHEvent");
    this.fp8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFp8FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFp8FromGovHydroWEHEvent");
    this.fp8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFp9ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignFp9ToGovHydroWEHEvent");
    this.fp9 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFp9FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignFp9FromGovHydroWEHEvent");
    this.fp9 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGmaxToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignGmaxToGovHydroWEHEvent");
    this.gmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGmaxFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignGmaxFromGovHydroWEHEvent");
    this.gmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGminToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignGminToGovHydroWEHEvent");
    this.gmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGminFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignGminFromGovHydroWEHEvent");
    this.gmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGtmxclToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignGtmxclToGovHydroWEHEvent");
    this.gtmxcl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGtmxclFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignGtmxclFromGovHydroWEHEvent");
    this.gtmxcl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGtmxopToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignGtmxopToGovHydroWEHEvent");
    this.gtmxop = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGtmxopFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignGtmxopFromGovHydroWEHEvent");
    this.gtmxop = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv1ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignGv1ToGovHydroWEHEvent");
    this.gv1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv1FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignGv1FromGovHydroWEHEvent");
    this.gv1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv2ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignGv2ToGovHydroWEHEvent");
    this.gv2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv2FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignGv2FromGovHydroWEHEvent");
    this.gv2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv3ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignGv3ToGovHydroWEHEvent");
    this.gv3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv3FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignGv3FromGovHydroWEHEvent");
    this.gv3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv4ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignGv4ToGovHydroWEHEvent");
    this.gv4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv4FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignGv4FromGovHydroWEHEvent");
    this.gv4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGv5ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignGv5ToGovHydroWEHEvent");
    this.gv5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGv5FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignGv5FromGovHydroWEHEvent");
    this.gv5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignKdToGovHydroWEHEvent");
    this.kd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignKdFromGovHydroWEHEvent");
    this.kd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignKiToGovHydroWEHEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromGovHydroWEHEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignKpToGovHydroWEHEvent");
    this.kp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignKpFromGovHydroWEHEvent");
    this.kp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovHydroWEHEvent");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovHydroWEHEvent");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmss1ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignPmss1ToGovHydroWEHEvent");
    this.pmss1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmss1FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignPmss1FromGovHydroWEHEvent");
    this.pmss1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmss10ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignPmss10ToGovHydroWEHEvent");
    this.pmss10 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmss10FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignPmss10FromGovHydroWEHEvent");
    this.pmss10 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmss2ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignPmss2ToGovHydroWEHEvent");
    this.pmss2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmss2FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignPmss2FromGovHydroWEHEvent");
    this.pmss2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmss3ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignPmss3ToGovHydroWEHEvent");
    this.pmss3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmss3FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignPmss3FromGovHydroWEHEvent");
    this.pmss3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmss4ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignPmss4ToGovHydroWEHEvent");
    this.pmss4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmss4FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignPmss4FromGovHydroWEHEvent");
    this.pmss4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmss5ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignPmss5ToGovHydroWEHEvent");
    this.pmss5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmss5FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignPmss5FromGovHydroWEHEvent");
    this.pmss5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmss6ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignPmss6ToGovHydroWEHEvent");
    this.pmss6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmss6FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignPmss6FromGovHydroWEHEvent");
    this.pmss6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmss7ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignPmss7ToGovHydroWEHEvent");
    this.pmss7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmss7FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignPmss7FromGovHydroWEHEvent");
    this.pmss7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmss8ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignPmss8ToGovHydroWEHEvent");
    this.pmss8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmss8FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignPmss8FromGovHydroWEHEvent");
    this.pmss8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmss9ToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignPmss9ToGovHydroWEHEvent");
    this.pmss9 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmss9FromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignPmss9FromGovHydroWEHEvent");
    this.pmss9 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRpgToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignRpgToGovHydroWEHEvent");
    this.rpg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRpgFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignRpgFromGovHydroWEHEvent");
    this.rpg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRppToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignRppToGovHydroWEHEvent");
    this.rpp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRppFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignRppFromGovHydroWEHEvent");
    this.rpp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignTdToGovHydroWEHEvent");
    this.td = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignTdFromGovHydroWEHEvent");
    this.td = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdvToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignTdvToGovHydroWEHEvent");
    this.tdv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdvFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignTdvFromGovHydroWEHEvent");
    this.tdv = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTgToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignTgToGovHydroWEHEvent");
    this.tg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTgFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignTgFromGovHydroWEHEvent");
    this.tg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignTpToGovHydroWEHEvent");
    this.tp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignTpFromGovHydroWEHEvent");
    this.tp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpeToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignTpeToGovHydroWEHEvent");
    this.tpe = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpeFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignTpeFromGovHydroWEHEvent");
    this.tpe = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwToGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing AssignTwToGovHydroWEHEvent");
    this.tw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwFromGovHydroWEHEvent event) {
    LOGGER.info("Event sourcing UnAssignTwFromGovHydroWEHEvent");
    this.tw = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govHydroWEHId;

  private PU db = null;
  private PU dicn = null;
  private PU dpv = null;
  private PU dturb = null;
  private BooleanProxy feedbackSignal = null;
  private PU fl1 = null;
  private PU fl2 = null;
  private PU fl3 = null;
  private PU fl4 = null;
  private PU fl5 = null;
  private PU fp1 = null;
  private PU fp10 = null;
  private PU fp2 = null;
  private PU fp3 = null;
  private PU fp4 = null;
  private PU fp5 = null;
  private PU fp6 = null;
  private PU fp7 = null;
  private PU fp8 = null;
  private PU fp9 = null;
  private PU gmax = null;
  private PU gmin = null;
  private PU gtmxcl = null;
  private PU gtmxop = null;
  private PU gv1 = null;
  private PU gv2 = null;
  private PU gv3 = null;
  private PU gv4 = null;
  private PU gv5 = null;
  private PU kd = null;
  private PU ki = null;
  private PU kp = null;
  private ActivePower mwbase = null;
  private PU pmss1 = null;
  private PU pmss10 = null;
  private PU pmss2 = null;
  private PU pmss3 = null;
  private PU pmss4 = null;
  private PU pmss5 = null;
  private PU pmss6 = null;
  private PU pmss7 = null;
  private PU pmss8 = null;
  private PU pmss9 = null;
  private Simple_Float rpg = null;
  private Simple_Float rpp = null;
  private Seconds td = null;
  private Seconds tdv = null;
  private Seconds tg = null;
  private Seconds tp = null;
  private Seconds tpe = null;
  private Seconds tw = null;

  private static final Logger LOGGER = Logger.getLogger(GovHydroWEHAggregate.class.getName());
}
