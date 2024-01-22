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
 * Aggregate handler for GovSteamFV4 as outlined for the CQRS pattern, all write responsibilities
 * related to GovSteamFV4 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovSteamFV4Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovSteamFV4Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovSteamFV4Aggregate(CreateGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command CreateGovSteamFV4Command");
    CreateGovSteamFV4Event event = new CreateGovSteamFV4Event(command.getGovSteamFV4Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovSteamFV4Command command) throws Exception {
    LOGGER.info("handling command UpdateGovSteamFV4Command");
    UpdateGovSteamFV4Event event =
        new UpdateGovSteamFV4Event(
            command.getGovSteamFV4Id(),
            command.getCpsmn(),
            command.getCpsmx(),
            command.getCrmn(),
            command.getCrmx(),
            command.getKdc(),
            command.getKf1(),
            command.getKf3(),
            command.getKhp(),
            command.getKic(),
            command.getKip(),
            command.getKit(),
            command.getKmp1(),
            command.getKmp2(),
            command.getKpc(),
            command.getKpp(),
            command.getKpt(),
            command.getKrc(),
            command.getKsh(),
            command.getLpi(),
            command.getLps(),
            command.getMnef(),
            command.getMxef(),
            command.getPr1(),
            command.getPr2(),
            command.getPsmn(),
            command.getRsmimn(),
            command.getRsmimx(),
            command.getRvgmn(),
            command.getRvgmx(),
            command.getSrmn(),
            command.getSrmx(),
            command.getSrsmp(),
            command.getSvmn(),
            command.getSvmx(),
            command.getTa(),
            command.getTam(),
            command.getTc(),
            command.getTcm(),
            command.getTdc(),
            command.getTf1(),
            command.getTf2(),
            command.getThp(),
            command.getTmp(),
            command.getTrh(),
            command.getTv(),
            command.getTy(),
            command.getY(),
            command.getYhpmn(),
            command.getYhpmx(),
            command.getYmpmn(),
            command.getYmpmx());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovSteamFV4Command");
    apply(new DeleteGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignCpsmnToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignCpsmnToGovSteamFV4Command");

    if (cpsmn != null && cpsmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Cpsmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignCpsmnToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCpsmnFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignCpsmnFromGovSteamFV4Command");

    if (cpsmn == null) throw new ProcessingException("Cpsmn already has nothing assigned.");

    apply(new UnAssignCpsmnFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignCpsmxToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignCpsmxToGovSteamFV4Command");

    if (cpsmx != null && cpsmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Cpsmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignCpsmxToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCpsmxFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignCpsmxFromGovSteamFV4Command");

    if (cpsmx == null) throw new ProcessingException("Cpsmx already has nothing assigned.");

    apply(new UnAssignCpsmxFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignCrmnToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignCrmnToGovSteamFV4Command");

    if (crmn != null && crmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Crmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignCrmnToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCrmnFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignCrmnFromGovSteamFV4Command");

    if (crmn == null) throw new ProcessingException("Crmn already has nothing assigned.");

    apply(new UnAssignCrmnFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignCrmxToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignCrmxToGovSteamFV4Command");

    if (crmx != null && crmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Crmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignCrmxToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCrmxFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignCrmxFromGovSteamFV4Command");

    if (crmx == null) throw new ProcessingException("Crmx already has nothing assigned.");

    apply(new UnAssignCrmxFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignKdcToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignKdcToGovSteamFV4Command");

    if (kdc != null && kdc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kdc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdcToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdcFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdcFromGovSteamFV4Command");

    if (kdc == null) throw new ProcessingException("Kdc already has nothing assigned.");

    apply(new UnAssignKdcFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignKf1ToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignKf1ToGovSteamFV4Command");

    if (kf1 != null && kf1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKf1ToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKf1FromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKf1FromGovSteamFV4Command");

    if (kf1 == null) throw new ProcessingException("Kf1 already has nothing assigned.");

    apply(new UnAssignKf1FromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignKf3ToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignKf3ToGovSteamFV4Command");

    if (kf3 != null && kf3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKf3ToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKf3FromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKf3FromGovSteamFV4Command");

    if (kf3 == null) throw new ProcessingException("Kf3 already has nothing assigned.");

    apply(new UnAssignKf3FromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignKhpToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignKhpToGovSteamFV4Command");

    if (khp != null && khp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Khp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKhpToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKhpFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKhpFromGovSteamFV4Command");

    if (khp == null) throw new ProcessingException("Khp already has nothing assigned.");

    apply(new UnAssignKhpFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignKicToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignKicToGovSteamFV4Command");

    if (kic != null && kic.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kic already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKicToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKicFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKicFromGovSteamFV4Command");

    if (kic == null) throw new ProcessingException("Kic already has nothing assigned.");

    apply(new UnAssignKicFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignKipToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignKipToGovSteamFV4Command");

    if (kip != null && kip.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kip already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKipToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKipFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKipFromGovSteamFV4Command");

    if (kip == null) throw new ProcessingException("Kip already has nothing assigned.");

    apply(new UnAssignKipFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignKitToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignKitToGovSteamFV4Command");

    if (kit != null && kit.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kit already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKitToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKitFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKitFromGovSteamFV4Command");

    if (kit == null) throw new ProcessingException("Kit already has nothing assigned.");

    apply(new UnAssignKitFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignKmp1ToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignKmp1ToGovSteamFV4Command");

    if (kmp1 != null && kmp1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kmp1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKmp1ToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKmp1FromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKmp1FromGovSteamFV4Command");

    if (kmp1 == null) throw new ProcessingException("Kmp1 already has nothing assigned.");

    apply(new UnAssignKmp1FromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignKmp2ToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignKmp2ToGovSteamFV4Command");

    if (kmp2 != null && kmp2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kmp2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKmp2ToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKmp2FromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKmp2FromGovSteamFV4Command");

    if (kmp2 == null) throw new ProcessingException("Kmp2 already has nothing assigned.");

    apply(new UnAssignKmp2FromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignKpcToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignKpcToGovSteamFV4Command");

    if (kpc != null && kpc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpcToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpcFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpcFromGovSteamFV4Command");

    if (kpc == null) throw new ProcessingException("Kpc already has nothing assigned.");

    apply(new UnAssignKpcFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignKppToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignKppToGovSteamFV4Command");

    if (kpp != null && kpp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKppToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKppFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKppFromGovSteamFV4Command");

    if (kpp == null) throw new ProcessingException("Kpp already has nothing assigned.");

    apply(new UnAssignKppFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignKptToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignKptToGovSteamFV4Command");

    if (kpt != null && kpt.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpt already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKptToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKptFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKptFromGovSteamFV4Command");

    if (kpt == null) throw new ProcessingException("Kpt already has nothing assigned.");

    apply(new UnAssignKptFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignKrcToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignKrcToGovSteamFV4Command");

    if (krc != null && krc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Krc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKrcToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKrcFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKrcFromGovSteamFV4Command");

    if (krc == null) throw new ProcessingException("Krc already has nothing assigned.");

    apply(new UnAssignKrcFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignKshToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignKshToGovSteamFV4Command");

    if (ksh != null && ksh.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ksh already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKshToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKshFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKshFromGovSteamFV4Command");

    if (ksh == null) throw new ProcessingException("Ksh already has nothing assigned.");

    apply(new UnAssignKshFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignLpiToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignLpiToGovSteamFV4Command");

    if (lpi != null && lpi.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Lpi already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignLpiToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLpiFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignLpiFromGovSteamFV4Command");

    if (lpi == null) throw new ProcessingException("Lpi already has nothing assigned.");

    apply(new UnAssignLpiFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignLpsToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignLpsToGovSteamFV4Command");

    if (lps != null && lps.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Lps already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignLpsToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLpsFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignLpsFromGovSteamFV4Command");

    if (lps == null) throw new ProcessingException("Lps already has nothing assigned.");

    apply(new UnAssignLpsFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignMnefToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignMnefToGovSteamFV4Command");

    if (mnef != null && mnef.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Mnef already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignMnefToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMnefFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMnefFromGovSteamFV4Command");

    if (mnef == null) throw new ProcessingException("Mnef already has nothing assigned.");

    apply(new UnAssignMnefFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignMxefToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignMxefToGovSteamFV4Command");

    if (mxef != null && mxef.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Mxef already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignMxefToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMxefFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMxefFromGovSteamFV4Command");

    if (mxef == null) throw new ProcessingException("Mxef already has nothing assigned.");

    apply(new UnAssignMxefFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignPr1ToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignPr1ToGovSteamFV4Command");

    if (pr1 != null && pr1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pr1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPr1ToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPr1FromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPr1FromGovSteamFV4Command");

    if (pr1 == null) throw new ProcessingException("Pr1 already has nothing assigned.");

    apply(new UnAssignPr1FromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignPr2ToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignPr2ToGovSteamFV4Command");

    if (pr2 != null && pr2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pr2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPr2ToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPr2FromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPr2FromGovSteamFV4Command");

    if (pr2 == null) throw new ProcessingException("Pr2 already has nothing assigned.");

    apply(new UnAssignPr2FromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignPsmnToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignPsmnToGovSteamFV4Command");

    if (psmn != null && psmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Psmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPsmnToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPsmnFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPsmnFromGovSteamFV4Command");

    if (psmn == null) throw new ProcessingException("Psmn already has nothing assigned.");

    apply(new UnAssignPsmnFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignRsmimnToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignRsmimnToGovSteamFV4Command");

    if (rsmimn != null && rsmimn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rsmimn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRsmimnToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRsmimnFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRsmimnFromGovSteamFV4Command");

    if (rsmimn == null) throw new ProcessingException("Rsmimn already has nothing assigned.");

    apply(new UnAssignRsmimnFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignRsmimxToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignRsmimxToGovSteamFV4Command");

    if (rsmimx != null && rsmimx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rsmimx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRsmimxToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRsmimxFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRsmimxFromGovSteamFV4Command");

    if (rsmimx == null) throw new ProcessingException("Rsmimx already has nothing assigned.");

    apply(new UnAssignRsmimxFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignRvgmnToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignRvgmnToGovSteamFV4Command");

    if (rvgmn != null && rvgmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rvgmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRvgmnToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRvgmnFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRvgmnFromGovSteamFV4Command");

    if (rvgmn == null) throw new ProcessingException("Rvgmn already has nothing assigned.");

    apply(new UnAssignRvgmnFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignRvgmxToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignRvgmxToGovSteamFV4Command");

    if (rvgmx != null && rvgmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rvgmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRvgmxToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRvgmxFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRvgmxFromGovSteamFV4Command");

    if (rvgmx == null) throw new ProcessingException("Rvgmx already has nothing assigned.");

    apply(new UnAssignRvgmxFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignSrmnToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignSrmnToGovSteamFV4Command");

    if (srmn != null && srmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Srmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignSrmnToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSrmnFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSrmnFromGovSteamFV4Command");

    if (srmn == null) throw new ProcessingException("Srmn already has nothing assigned.");

    apply(new UnAssignSrmnFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignSrmxToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignSrmxToGovSteamFV4Command");

    if (srmx != null && srmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Srmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignSrmxToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSrmxFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSrmxFromGovSteamFV4Command");

    if (srmx == null) throw new ProcessingException("Srmx already has nothing assigned.");

    apply(new UnAssignSrmxFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignSrsmpToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignSrsmpToGovSteamFV4Command");

    if (srsmp != null && srsmp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Srsmp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignSrsmpToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSrsmpFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSrsmpFromGovSteamFV4Command");

    if (srsmp == null) throw new ProcessingException("Srsmp already has nothing assigned.");

    apply(new UnAssignSrsmpFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignSvmnToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignSvmnToGovSteamFV4Command");

    if (svmn != null && svmn.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Svmn already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSvmnToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSvmnFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSvmnFromGovSteamFV4Command");

    if (svmn == null) throw new ProcessingException("Svmn already has nothing assigned.");

    apply(new UnAssignSvmnFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignSvmxToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignSvmxToGovSteamFV4Command");

    if (svmx != null && svmx.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Svmx already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignSvmxToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSvmxFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSvmxFromGovSteamFV4Command");

    if (svmx == null) throw new ProcessingException("Svmx already has nothing assigned.");

    apply(new UnAssignSvmxFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignTaToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignTaToGovSteamFV4Command");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromGovSteamFV4Command");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignTamToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignTamToGovSteamFV4Command");

    if (tam != null && tam.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tam already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTamToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTamFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTamFromGovSteamFV4Command");

    if (tam == null) throw new ProcessingException("Tam already has nothing assigned.");

    apply(new UnAssignTamFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignTcToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignTcToGovSteamFV4Command");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromGovSteamFV4Command");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignTcmToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignTcmToGovSteamFV4Command");

    if (tcm != null && tcm.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tcm already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcmToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcmFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcmFromGovSteamFV4Command");

    if (tcm == null) throw new ProcessingException("Tcm already has nothing assigned.");

    apply(new UnAssignTcmFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignTdcToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignTdcToGovSteamFV4Command");

    if (tdc != null && tdc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tdc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdcToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdcFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdcFromGovSteamFV4Command");

    if (tdc == null) throw new ProcessingException("Tdc already has nothing assigned.");

    apply(new UnAssignTdcFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignTf1ToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignTf1ToGovSteamFV4Command");

    if (tf1 != null && tf1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf1ToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf1FromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf1FromGovSteamFV4Command");

    if (tf1 == null) throw new ProcessingException("Tf1 already has nothing assigned.");

    apply(new UnAssignTf1FromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignTf2ToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignTf2ToGovSteamFV4Command");

    if (tf2 != null && tf2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf2ToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf2FromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf2FromGovSteamFV4Command");

    if (tf2 == null) throw new ProcessingException("Tf2 already has nothing assigned.");

    apply(new UnAssignTf2FromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignThpToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignThpToGovSteamFV4Command");

    if (thp != null && thp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Thp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignThpToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignThpFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignThpFromGovSteamFV4Command");

    if (thp == null) throw new ProcessingException("Thp already has nothing assigned.");

    apply(new UnAssignThpFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignTmpToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignTmpToGovSteamFV4Command");

    if (tmp != null && tmp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tmp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTmpToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTmpFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTmpFromGovSteamFV4Command");

    if (tmp == null) throw new ProcessingException("Tmp already has nothing assigned.");

    apply(new UnAssignTmpFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignTrhToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignTrhToGovSteamFV4Command");

    if (trh != null && trh.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Trh already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTrhToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrhFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrhFromGovSteamFV4Command");

    if (trh == null) throw new ProcessingException("Trh already has nothing assigned.");

    apply(new UnAssignTrhFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignTvToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignTvToGovSteamFV4Command");

    if (tv != null && tv.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tv already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTvToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTvFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTvFromGovSteamFV4Command");

    if (tv == null) throw new ProcessingException("Tv already has nothing assigned.");

    apply(new UnAssignTvFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignTyToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignTyToGovSteamFV4Command");

    if (ty != null && ty.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ty already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTyToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTyFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTyFromGovSteamFV4Command");

    if (ty == null) throw new ProcessingException("Ty already has nothing assigned.");

    apply(new UnAssignTyFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignYToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignYToGovSteamFV4Command");

    if (y != null && y.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Y already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignYToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignYFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignYFromGovSteamFV4Command");

    if (y == null) throw new ProcessingException("Y already has nothing assigned.");

    apply(new UnAssignYFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignYhpmnToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignYhpmnToGovSteamFV4Command");

    if (yhpmn != null && yhpmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Yhpmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignYhpmnToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignYhpmnFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignYhpmnFromGovSteamFV4Command");

    if (yhpmn == null) throw new ProcessingException("Yhpmn already has nothing assigned.");

    apply(new UnAssignYhpmnFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignYhpmxToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignYhpmxToGovSteamFV4Command");

    if (yhpmx != null && yhpmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Yhpmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignYhpmxToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignYhpmxFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignYhpmxFromGovSteamFV4Command");

    if (yhpmx == null) throw new ProcessingException("Yhpmx already has nothing assigned.");

    apply(new UnAssignYhpmxFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignYmpmnToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignYmpmnToGovSteamFV4Command");

    if (ympmn != null && ympmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ympmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignYmpmnToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignYmpmnFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignYmpmnFromGovSteamFV4Command");

    if (ympmn == null) throw new ProcessingException("Ympmn already has nothing assigned.");

    apply(new UnAssignYmpmnFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  @CommandHandler
  public void handle(AssignYmpmxToGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handling command AssignYmpmxToGovSteamFV4Command");

    if (ympmx != null && ympmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ympmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignYmpmxToGovSteamFV4Event(command.getGovSteamFV4Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignYmpmxFromGovSteamFV4Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignYmpmxFromGovSteamFV4Command");

    if (ympmx == null) throw new ProcessingException("Ympmx already has nothing assigned.");

    apply(new UnAssignYmpmxFromGovSteamFV4Event(command.getGovSteamFV4Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovSteamFV4Event event) {
    LOGGER.info("Event sourcing CreateGovSteamFV4Event");
    this.govSteamFV4Id = event.getGovSteamFV4Id();
  }

  @EventSourcingHandler
  void on(UpdateGovSteamFV4Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.cpsmn = event.getCpsmn();
    this.cpsmx = event.getCpsmx();
    this.crmn = event.getCrmn();
    this.crmx = event.getCrmx();
    this.kdc = event.getKdc();
    this.kf1 = event.getKf1();
    this.kf3 = event.getKf3();
    this.khp = event.getKhp();
    this.kic = event.getKic();
    this.kip = event.getKip();
    this.kit = event.getKit();
    this.kmp1 = event.getKmp1();
    this.kmp2 = event.getKmp2();
    this.kpc = event.getKpc();
    this.kpp = event.getKpp();
    this.kpt = event.getKpt();
    this.krc = event.getKrc();
    this.ksh = event.getKsh();
    this.lpi = event.getLpi();
    this.lps = event.getLps();
    this.mnef = event.getMnef();
    this.mxef = event.getMxef();
    this.pr1 = event.getPr1();
    this.pr2 = event.getPr2();
    this.psmn = event.getPsmn();
    this.rsmimn = event.getRsmimn();
    this.rsmimx = event.getRsmimx();
    this.rvgmn = event.getRvgmn();
    this.rvgmx = event.getRvgmx();
    this.srmn = event.getSrmn();
    this.srmx = event.getSrmx();
    this.srsmp = event.getSrsmp();
    this.svmn = event.getSvmn();
    this.svmx = event.getSvmx();
    this.ta = event.getTa();
    this.tam = event.getTam();
    this.tc = event.getTc();
    this.tcm = event.getTcm();
    this.tdc = event.getTdc();
    this.tf1 = event.getTf1();
    this.tf2 = event.getTf2();
    this.thp = event.getThp();
    this.tmp = event.getTmp();
    this.trh = event.getTrh();
    this.tv = event.getTv();
    this.ty = event.getTy();
    this.y = event.getY();
    this.yhpmn = event.getYhpmn();
    this.yhpmx = event.getYhpmx();
    this.ympmn = event.getYmpmn();
    this.ympmx = event.getYmpmx();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignCpsmnToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignCpsmnToGovSteamFV4Event");
    this.cpsmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCpsmnFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignCpsmnFromGovSteamFV4Event");
    this.cpsmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignCpsmxToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignCpsmxToGovSteamFV4Event");
    this.cpsmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCpsmxFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignCpsmxFromGovSteamFV4Event");
    this.cpsmx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignCrmnToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignCrmnToGovSteamFV4Event");
    this.crmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCrmnFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignCrmnFromGovSteamFV4Event");
    this.crmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignCrmxToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignCrmxToGovSteamFV4Event");
    this.crmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCrmxFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignCrmxFromGovSteamFV4Event");
    this.crmx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdcToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignKdcToGovSteamFV4Event");
    this.kdc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdcFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignKdcFromGovSteamFV4Event");
    this.kdc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKf1ToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignKf1ToGovSteamFV4Event");
    this.kf1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKf1FromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignKf1FromGovSteamFV4Event");
    this.kf1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKf3ToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignKf3ToGovSteamFV4Event");
    this.kf3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKf3FromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignKf3FromGovSteamFV4Event");
    this.kf3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKhpToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignKhpToGovSteamFV4Event");
    this.khp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKhpFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignKhpFromGovSteamFV4Event");
    this.khp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKicToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignKicToGovSteamFV4Event");
    this.kic = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKicFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignKicFromGovSteamFV4Event");
    this.kic = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKipToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignKipToGovSteamFV4Event");
    this.kip = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKipFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignKipFromGovSteamFV4Event");
    this.kip = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKitToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignKitToGovSteamFV4Event");
    this.kit = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKitFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignKitFromGovSteamFV4Event");
    this.kit = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKmp1ToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignKmp1ToGovSteamFV4Event");
    this.kmp1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKmp1FromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignKmp1FromGovSteamFV4Event");
    this.kmp1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKmp2ToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignKmp2ToGovSteamFV4Event");
    this.kmp2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKmp2FromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignKmp2FromGovSteamFV4Event");
    this.kmp2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpcToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignKpcToGovSteamFV4Event");
    this.kpc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpcFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignKpcFromGovSteamFV4Event");
    this.kpc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKppToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignKppToGovSteamFV4Event");
    this.kpp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKppFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignKppFromGovSteamFV4Event");
    this.kpp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKptToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignKptToGovSteamFV4Event");
    this.kpt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKptFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignKptFromGovSteamFV4Event");
    this.kpt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKrcToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignKrcToGovSteamFV4Event");
    this.krc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKrcFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignKrcFromGovSteamFV4Event");
    this.krc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKshToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignKshToGovSteamFV4Event");
    this.ksh = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKshFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignKshFromGovSteamFV4Event");
    this.ksh = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLpiToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignLpiToGovSteamFV4Event");
    this.lpi = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLpiFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignLpiFromGovSteamFV4Event");
    this.lpi = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLpsToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignLpsToGovSteamFV4Event");
    this.lps = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLpsFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignLpsFromGovSteamFV4Event");
    this.lps = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMnefToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignMnefToGovSteamFV4Event");
    this.mnef = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMnefFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignMnefFromGovSteamFV4Event");
    this.mnef = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMxefToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignMxefToGovSteamFV4Event");
    this.mxef = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMxefFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignMxefFromGovSteamFV4Event");
    this.mxef = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPr1ToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignPr1ToGovSteamFV4Event");
    this.pr1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPr1FromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignPr1FromGovSteamFV4Event");
    this.pr1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPr2ToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignPr2ToGovSteamFV4Event");
    this.pr2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPr2FromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignPr2FromGovSteamFV4Event");
    this.pr2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPsmnToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignPsmnToGovSteamFV4Event");
    this.psmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPsmnFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignPsmnFromGovSteamFV4Event");
    this.psmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRsmimnToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignRsmimnToGovSteamFV4Event");
    this.rsmimn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRsmimnFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignRsmimnFromGovSteamFV4Event");
    this.rsmimn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRsmimxToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignRsmimxToGovSteamFV4Event");
    this.rsmimx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRsmimxFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignRsmimxFromGovSteamFV4Event");
    this.rsmimx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRvgmnToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignRvgmnToGovSteamFV4Event");
    this.rvgmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRvgmnFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignRvgmnFromGovSteamFV4Event");
    this.rvgmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRvgmxToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignRvgmxToGovSteamFV4Event");
    this.rvgmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRvgmxFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignRvgmxFromGovSteamFV4Event");
    this.rvgmx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSrmnToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignSrmnToGovSteamFV4Event");
    this.srmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSrmnFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignSrmnFromGovSteamFV4Event");
    this.srmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSrmxToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignSrmxToGovSteamFV4Event");
    this.srmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSrmxFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignSrmxFromGovSteamFV4Event");
    this.srmx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSrsmpToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignSrsmpToGovSteamFV4Event");
    this.srsmp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSrsmpFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignSrsmpFromGovSteamFV4Event");
    this.srsmp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSvmnToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignSvmnToGovSteamFV4Event");
    this.svmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSvmnFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignSvmnFromGovSteamFV4Event");
    this.svmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSvmxToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignSvmxToGovSteamFV4Event");
    this.svmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSvmxFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignSvmxFromGovSteamFV4Event");
    this.svmx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignTaToGovSteamFV4Event");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignTaFromGovSteamFV4Event");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTamToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignTamToGovSteamFV4Event");
    this.tam = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTamFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignTamFromGovSteamFV4Event");
    this.tam = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignTcToGovSteamFV4Event");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignTcFromGovSteamFV4Event");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcmToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignTcmToGovSteamFV4Event");
    this.tcm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcmFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignTcmFromGovSteamFV4Event");
    this.tcm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdcToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignTdcToGovSteamFV4Event");
    this.tdc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdcFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignTdcFromGovSteamFV4Event");
    this.tdc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf1ToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignTf1ToGovSteamFV4Event");
    this.tf1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf1FromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignTf1FromGovSteamFV4Event");
    this.tf1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf2ToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignTf2ToGovSteamFV4Event");
    this.tf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf2FromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignTf2FromGovSteamFV4Event");
    this.tf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignThpToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignThpToGovSteamFV4Event");
    this.thp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignThpFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignThpFromGovSteamFV4Event");
    this.thp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTmpToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignTmpToGovSteamFV4Event");
    this.tmp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTmpFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignTmpFromGovSteamFV4Event");
    this.tmp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrhToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignTrhToGovSteamFV4Event");
    this.trh = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrhFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignTrhFromGovSteamFV4Event");
    this.trh = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTvToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignTvToGovSteamFV4Event");
    this.tv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTvFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignTvFromGovSteamFV4Event");
    this.tv = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTyToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignTyToGovSteamFV4Event");
    this.ty = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTyFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignTyFromGovSteamFV4Event");
    this.ty = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignYToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignYToGovSteamFV4Event");
    this.y = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignYFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignYFromGovSteamFV4Event");
    this.y = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignYhpmnToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignYhpmnToGovSteamFV4Event");
    this.yhpmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignYhpmnFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignYhpmnFromGovSteamFV4Event");
    this.yhpmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignYhpmxToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignYhpmxToGovSteamFV4Event");
    this.yhpmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignYhpmxFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignYhpmxFromGovSteamFV4Event");
    this.yhpmx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignYmpmnToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignYmpmnToGovSteamFV4Event");
    this.ympmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignYmpmnFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignYmpmnFromGovSteamFV4Event");
    this.ympmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignYmpmxToGovSteamFV4Event event) {
    LOGGER.info("Event sourcing AssignYmpmxToGovSteamFV4Event");
    this.ympmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignYmpmxFromGovSteamFV4Event event) {
    LOGGER.info("Event sourcing UnAssignYmpmxFromGovSteamFV4Event");
    this.ympmx = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govSteamFV4Id;

  private PU cpsmn = null;
  private PU cpsmx = null;
  private PU crmn = null;
  private PU crmx = null;
  private PU kdc = null;
  private PU kf1 = null;
  private PU kf3 = null;
  private PU khp = null;
  private PU kic = null;
  private PU kip = null;
  private PU kit = null;
  private PU kmp1 = null;
  private PU kmp2 = null;
  private PU kpc = null;
  private PU kpp = null;
  private PU kpt = null;
  private PU krc = null;
  private PU ksh = null;
  private PU lpi = null;
  private PU lps = null;
  private PU mnef = null;
  private PU mxef = null;
  private PU pr1 = null;
  private PU pr2 = null;
  private PU psmn = null;
  private PU rsmimn = null;
  private PU rsmimx = null;
  private PU rvgmn = null;
  private PU rvgmx = null;
  private PU srmn = null;
  private PU srmx = null;
  private PU srsmp = null;
  private Simple_Float svmn = null;
  private Simple_Float svmx = null;
  private Seconds ta = null;
  private Seconds tam = null;
  private Seconds tc = null;
  private Seconds tcm = null;
  private Seconds tdc = null;
  private Seconds tf1 = null;
  private Seconds tf2 = null;
  private Seconds thp = null;
  private Seconds tmp = null;
  private Seconds trh = null;
  private Seconds tv = null;
  private Seconds ty = null;
  private PU y = null;
  private PU yhpmn = null;
  private PU yhpmx = null;
  private PU ympmn = null;
  private PU ympmx = null;

  private static final Logger LOGGER = Logger.getLogger(GovSteamFV4Aggregate.class.getName());
}
