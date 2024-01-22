package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.aggregate;

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
 * Aggregate handler for PssPTIST3 as outlined for the CQRS pattern, all write responsibilities
 * related to PssPTIST3 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PssPTIST3Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PssPTIST3Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PssPTIST3Aggregate(CreatePssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command CreatePssPTIST3Command");
    CreatePssPTIST3Event event = new CreatePssPTIST3Event(command.getPssPTIST3Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePssPTIST3Command command) throws Exception {
    LOGGER.info("handling command UpdatePssPTIST3Command");
    UpdatePssPTIST3Event event =
        new UpdatePssPTIST3Event(
            command.getPssPTIST3Id(),
            command.getA0(),
            command.getA1(),
            command.getA2(),
            command.getA3(),
            command.getA4(),
            command.getA5(),
            command.getAl(),
            command.getAthres(),
            command.getB0(),
            command.getB1(),
            command.getB2(),
            command.getB3(),
            command.getB4(),
            command.getB5(),
            command.getDl(),
            command.getDtc(),
            command.getDtf(),
            command.getDtp(),
            command.getIsw(),
            command.getK(),
            command.getLthres(),
            command.getM(),
            command.getNav(),
            command.getNcl(),
            command.getNcr(),
            command.getPmin(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getT6(),
            command.getTf(),
            command.getTp());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command DeletePssPTIST3Command");
    apply(new DeletePssPTIST3Event(command.getPssPTIST3Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignA0ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignA0ToPssPTIST3Command");

    if (a0 != null && a0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A0 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA0ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA0FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignA0FromPssPTIST3Command");

    if (a0 == null) throw new ProcessingException("A0 already has nothing assigned.");

    apply(new UnAssignA0FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignA1ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignA1ToPssPTIST3Command");

    if (a1 != null && a1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA1ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA1FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignA1FromPssPTIST3Command");

    if (a1 == null) throw new ProcessingException("A1 already has nothing assigned.");

    apply(new UnAssignA1FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignA2ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignA2ToPssPTIST3Command");

    if (a2 != null && a2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA2ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA2FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignA2FromPssPTIST3Command");

    if (a2 == null) throw new ProcessingException("A2 already has nothing assigned.");

    apply(new UnAssignA2FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignA3ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignA3ToPssPTIST3Command");

    if (a3 != null && a3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA3ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA3FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignA3FromPssPTIST3Command");

    if (a3 == null) throw new ProcessingException("A3 already has nothing assigned.");

    apply(new UnAssignA3FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignA4ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignA4ToPssPTIST3Command");

    if (a4 != null && a4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA4ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA4FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignA4FromPssPTIST3Command");

    if (a4 == null) throw new ProcessingException("A4 already has nothing assigned.");

    apply(new UnAssignA4FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignA5ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignA5ToPssPTIST3Command");

    if (a5 != null && a5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "A5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignA5ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignA5FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignA5FromPssPTIST3Command");

    if (a5 == null) throw new ProcessingException("A5 already has nothing assigned.");

    apply(new UnAssignA5FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignAlToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignAlToPssPTIST3Command");

    if (al != null && al.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Al already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAlToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAlFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAlFromPssPTIST3Command");

    if (al == null) throw new ProcessingException("Al already has nothing assigned.");

    apply(new UnAssignAlFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignAthresToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignAthresToPssPTIST3Command");

    if (athres != null && athres.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Athres already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignAthresToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAthresFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAthresFromPssPTIST3Command");

    if (athres == null) throw new ProcessingException("Athres already has nothing assigned.");

    apply(new UnAssignAthresFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignB0ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignB0ToPssPTIST3Command");

    if (b0 != null && b0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "B0 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignB0ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignB0FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignB0FromPssPTIST3Command");

    if (b0 == null) throw new ProcessingException("B0 already has nothing assigned.");

    apply(new UnAssignB0FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignB1ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignB1ToPssPTIST3Command");

    if (b1 != null && b1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "B1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignB1ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignB1FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignB1FromPssPTIST3Command");

    if (b1 == null) throw new ProcessingException("B1 already has nothing assigned.");

    apply(new UnAssignB1FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignB2ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignB2ToPssPTIST3Command");

    if (b2 != null && b2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "B2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignB2ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignB2FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignB2FromPssPTIST3Command");

    if (b2 == null) throw new ProcessingException("B2 already has nothing assigned.");

    apply(new UnAssignB2FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignB3ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignB3ToPssPTIST3Command");

    if (b3 != null && b3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "B3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignB3ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignB3FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignB3FromPssPTIST3Command");

    if (b3 == null) throw new ProcessingException("B3 already has nothing assigned.");

    apply(new UnAssignB3FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignB4ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignB4ToPssPTIST3Command");

    if (b4 != null && b4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "B4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignB4ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignB4FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignB4FromPssPTIST3Command");

    if (b4 == null) throw new ProcessingException("B4 already has nothing assigned.");

    apply(new UnAssignB4FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignB5ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignB5ToPssPTIST3Command");

    if (b5 != null && b5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "B5 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignB5ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignB5FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignB5FromPssPTIST3Command");

    if (b5 == null) throw new ProcessingException("B5 already has nothing assigned.");

    apply(new UnAssignB5FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignDlToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignDlToPssPTIST3Command");

    if (dl != null && dl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDlToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDlFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDlFromPssPTIST3Command");

    if (dl == null) throw new ProcessingException("Dl already has nothing assigned.");

    apply(new UnAssignDlFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignDtcToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignDtcToPssPTIST3Command");

    if (dtc != null && dtc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Dtc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignDtcToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDtcFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDtcFromPssPTIST3Command");

    if (dtc == null) throw new ProcessingException("Dtc already has nothing assigned.");

    apply(new UnAssignDtcFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignDtfToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignDtfToPssPTIST3Command");

    if (dtf != null && dtf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Dtf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignDtfToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDtfFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDtfFromPssPTIST3Command");

    if (dtf == null) throw new ProcessingException("Dtf already has nothing assigned.");

    apply(new UnAssignDtfFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignDtpToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignDtpToPssPTIST3Command");

    if (dtp != null && dtp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Dtp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignDtpToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDtpFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDtpFromPssPTIST3Command");

    if (dtp == null) throw new ProcessingException("Dtp already has nothing assigned.");

    apply(new UnAssignDtpFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignIswToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignIswToPssPTIST3Command");

    if (isw != null && isw.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Isw already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignIswToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIswFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignIswFromPssPTIST3Command");

    if (isw == null) throw new ProcessingException("Isw already has nothing assigned.");

    apply(new UnAssignIswFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignKToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignKToPssPTIST3Command");

    if (k != null && k.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKFromPssPTIST3Command");

    if (k == null) throw new ProcessingException("K already has nothing assigned.");

    apply(new UnAssignKFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignLthresToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignLthresToPssPTIST3Command");

    if (lthres != null && lthres.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Lthres already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignLthresToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLthresFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignLthresFromPssPTIST3Command");

    if (lthres == null) throw new ProcessingException("Lthres already has nothing assigned.");

    apply(new UnAssignLthresFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignMToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignMToPssPTIST3Command");

    if (m != null && m.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "M already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignMToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMFromPssPTIST3Command");

    if (m == null) throw new ProcessingException("M already has nothing assigned.");

    apply(new UnAssignMFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignNavToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignNavToPssPTIST3Command");

    if (nav != null && nav.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Nav already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignNavToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNavFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignNavFromPssPTIST3Command");

    if (nav == null) throw new ProcessingException("Nav already has nothing assigned.");

    apply(new UnAssignNavFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignNclToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignNclToPssPTIST3Command");

    if (ncl != null && ncl.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ncl already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignNclToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNclFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignNclFromPssPTIST3Command");

    if (ncl == null) throw new ProcessingException("Ncl already has nothing assigned.");

    apply(new UnAssignNclFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignNcrToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignNcrToPssPTIST3Command");

    if (ncr != null && ncr.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ncr already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignNcrToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNcrFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignNcrFromPssPTIST3Command");

    if (ncr == null) throw new ProcessingException("Ncr already has nothing assigned.");

    apply(new UnAssignNcrFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignPminToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignPminToPssPTIST3Command");

    if (pmin != null && pmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPminToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromPssPTIST3Command");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToPssPTIST3Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromPssPTIST3Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignT2ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignT2ToPssPTIST3Command");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromPssPTIST3Command");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToPssPTIST3Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromPssPTIST3Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignT4ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignT4ToPssPTIST3Command");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromPssPTIST3Command");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignT5ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignT5ToPssPTIST3Command");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromPssPTIST3Command");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignT6ToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignT6ToPssPTIST3Command");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromPssPTIST3Command");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignTfToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignTfToPssPTIST3Command");

    if (tf != null && tf.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfFromPssPTIST3Command");

    if (tf == null) throw new ProcessingException("Tf already has nothing assigned.");

    apply(new UnAssignTfFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  @CommandHandler
  public void handle(AssignTpToPssPTIST3Command command) throws Exception {
    LOGGER.info("Handling command AssignTpToPssPTIST3Command");

    if (tp != null && tp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tp already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpToPssPTIST3Event(command.getPssPTIST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpFromPssPTIST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpFromPssPTIST3Command");

    if (tp == null) throw new ProcessingException("Tp already has nothing assigned.");

    apply(new UnAssignTpFromPssPTIST3Event(command.getPssPTIST3Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePssPTIST3Event event) {
    LOGGER.info("Event sourcing CreatePssPTIST3Event");
    this.pssPTIST3Id = event.getPssPTIST3Id();
  }

  @EventSourcingHandler
  void on(UpdatePssPTIST3Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.a0 = event.getA0();
    this.a1 = event.getA1();
    this.a2 = event.getA2();
    this.a3 = event.getA3();
    this.a4 = event.getA4();
    this.a5 = event.getA5();
    this.al = event.getAl();
    this.athres = event.getAthres();
    this.b0 = event.getB0();
    this.b1 = event.getB1();
    this.b2 = event.getB2();
    this.b3 = event.getB3();
    this.b4 = event.getB4();
    this.b5 = event.getB5();
    this.dl = event.getDl();
    this.dtc = event.getDtc();
    this.dtf = event.getDtf();
    this.dtp = event.getDtp();
    this.isw = event.getIsw();
    this.k = event.getK();
    this.lthres = event.getLthres();
    this.m = event.getM();
    this.nav = event.getNav();
    this.ncl = event.getNcl();
    this.ncr = event.getNcr();
    this.pmin = event.getPmin();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.t6 = event.getT6();
    this.tf = event.getTf();
    this.tp = event.getTp();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignA0ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignA0ToPssPTIST3Event");
    this.a0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA0FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignA0FromPssPTIST3Event");
    this.a0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA1ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignA1ToPssPTIST3Event");
    this.a1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA1FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignA1FromPssPTIST3Event");
    this.a1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA2ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignA2ToPssPTIST3Event");
    this.a2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA2FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignA2FromPssPTIST3Event");
    this.a2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA3ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignA3ToPssPTIST3Event");
    this.a3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA3FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignA3FromPssPTIST3Event");
    this.a3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA4ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignA4ToPssPTIST3Event");
    this.a4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA4FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignA4FromPssPTIST3Event");
    this.a4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignA5ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignA5ToPssPTIST3Event");
    this.a5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignA5FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignA5FromPssPTIST3Event");
    this.a5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignAlToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignAlToPssPTIST3Event");
    this.al = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAlFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignAlFromPssPTIST3Event");
    this.al = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignAthresToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignAthresToPssPTIST3Event");
    this.athres = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAthresFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignAthresFromPssPTIST3Event");
    this.athres = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignB0ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignB0ToPssPTIST3Event");
    this.b0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignB0FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignB0FromPssPTIST3Event");
    this.b0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignB1ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignB1ToPssPTIST3Event");
    this.b1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignB1FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignB1FromPssPTIST3Event");
    this.b1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignB2ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignB2ToPssPTIST3Event");
    this.b2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignB2FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignB2FromPssPTIST3Event");
    this.b2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignB3ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignB3ToPssPTIST3Event");
    this.b3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignB3FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignB3FromPssPTIST3Event");
    this.b3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignB4ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignB4ToPssPTIST3Event");
    this.b4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignB4FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignB4FromPssPTIST3Event");
    this.b4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignB5ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignB5ToPssPTIST3Event");
    this.b5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignB5FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignB5FromPssPTIST3Event");
    this.b5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDlToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignDlToPssPTIST3Event");
    this.dl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDlFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignDlFromPssPTIST3Event");
    this.dl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDtcToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignDtcToPssPTIST3Event");
    this.dtc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDtcFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignDtcFromPssPTIST3Event");
    this.dtc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDtfToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignDtfToPssPTIST3Event");
    this.dtf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDtfFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignDtfFromPssPTIST3Event");
    this.dtf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDtpToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignDtpToPssPTIST3Event");
    this.dtp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDtpFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignDtpFromPssPTIST3Event");
    this.dtp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIswToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignIswToPssPTIST3Event");
    this.isw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIswFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignIswFromPssPTIST3Event");
    this.isw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignKToPssPTIST3Event");
    this.k = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignKFromPssPTIST3Event");
    this.k = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLthresToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignLthresToPssPTIST3Event");
    this.lthres = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLthresFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignLthresFromPssPTIST3Event");
    this.lthres = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignMToPssPTIST3Event");
    this.m = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignMFromPssPTIST3Event");
    this.m = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNavToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignNavToPssPTIST3Event");
    this.nav = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNavFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignNavFromPssPTIST3Event");
    this.nav = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNclToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignNclToPssPTIST3Event");
    this.ncl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNclFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignNclFromPssPTIST3Event");
    this.ncl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNcrToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignNcrToPssPTIST3Event");
    this.ncr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNcrFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignNcrFromPssPTIST3Event");
    this.ncr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignPminToPssPTIST3Event");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignPminFromPssPTIST3Event");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignT1ToPssPTIST3Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromPssPTIST3Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignT2ToPssPTIST3Event");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignT2FromPssPTIST3Event");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignT3ToPssPTIST3Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromPssPTIST3Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignT4ToPssPTIST3Event");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignT4FromPssPTIST3Event");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignT5ToPssPTIST3Event");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignT5FromPssPTIST3Event");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignT6ToPssPTIST3Event");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignT6FromPssPTIST3Event");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignTfToPssPTIST3Event");
    this.tf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignTfFromPssPTIST3Event");
    this.tf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpToPssPTIST3Event event) {
    LOGGER.info("Event sourcing AssignTpToPssPTIST3Event");
    this.tp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpFromPssPTIST3Event event) {
    LOGGER.info("Event sourcing UnAssignTpFromPssPTIST3Event");
    this.tp = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pssPTIST3Id;

  private PU a0 = null;
  private PU a1 = null;
  private PU a2 = null;
  private PU a3 = null;
  private PU a4 = null;
  private PU a5 = null;
  private PU al = null;
  private PU athres = null;
  private PU b0 = null;
  private PU b1 = null;
  private PU b2 = null;
  private PU b3 = null;
  private PU b4 = null;
  private PU b5 = null;
  private PU dl = null;
  private Seconds dtc = null;
  private Seconds dtf = null;
  private Seconds dtp = null;
  private BooleanProxy isw = null;
  private PU k = null;
  private PU lthres = null;
  private PU m = null;
  private Simple_Float nav = null;
  private Simple_Float ncl = null;
  private Simple_Float ncr = null;
  private PU pmin = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Seconds t6 = null;
  private Seconds tf = null;
  private Seconds tp = null;

  private static final Logger LOGGER = Logger.getLogger(PssPTIST3Aggregate.class.getName());
}
