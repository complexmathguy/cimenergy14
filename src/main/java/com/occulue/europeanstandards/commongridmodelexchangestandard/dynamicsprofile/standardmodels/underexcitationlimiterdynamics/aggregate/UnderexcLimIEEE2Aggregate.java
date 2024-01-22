package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.aggregate;

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
 * Aggregate handler for UnderexcLimIEEE2 as outlined for the CQRS pattern, all write
 * responsibilities related to UnderexcLimIEEE2 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class UnderexcLimIEEE2Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public UnderexcLimIEEE2Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public UnderexcLimIEEE2Aggregate(CreateUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command CreateUnderexcLimIEEE2Command");
    CreateUnderexcLimIEEE2Event event =
        new CreateUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("handling command UpdateUnderexcLimIEEE2Command");
    UpdateUnderexcLimIEEE2Event event =
        new UpdateUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(),
            command.getK1(),
            command.getK2(),
            command.getKfb(),
            command.getKuf(),
            command.getKui(),
            command.getKul(),
            command.getP0(),
            command.getP1(),
            command.getP10(),
            command.getP2(),
            command.getP3(),
            command.getP4(),
            command.getP5(),
            command.getP6(),
            command.getP7(),
            command.getP8(),
            command.getP9(),
            command.getQ0(),
            command.getQ1(),
            command.getQ10(),
            command.getQ2(),
            command.getQ3(),
            command.getQ4(),
            command.getQ5(),
            command.getQ6(),
            command.getQ7(),
            command.getQ8(),
            command.getQ9(),
            command.getTu1(),
            command.getTu2(),
            command.getTu3(),
            command.getTu4(),
            command.getTul(),
            command.getTup(),
            command.getTuq(),
            command.getTuv(),
            command.getVuimax(),
            command.getVuimin(),
            command.getVulmax(),
            command.getVulmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command DeleteUnderexcLimIEEE2Command");
    apply(new DeleteUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignK1ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignK1ToUnderexcLimIEEE2Command");

    if (k1 != null && k1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignK1ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromUnderexcLimIEEE2Command");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignK2ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignK2ToUnderexcLimIEEE2Command");

    if (k2 != null && k2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignK2ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK2FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK2FromUnderexcLimIEEE2Command");

    if (k2 == null) throw new ProcessingException("K2 already has nothing assigned.");

    apply(new UnAssignK2FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignKfbToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignKfbToUnderexcLimIEEE2Command");

    if (kfb != null && kfb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kfb already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKfbToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKfbFromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKfbFromUnderexcLimIEEE2Command");

    if (kfb == null) throw new ProcessingException("Kfb already has nothing assigned.");

    apply(new UnAssignKfbFromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignKufToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignKufToUnderexcLimIEEE2Command");

    if (kuf != null && kuf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kuf already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKufToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKufFromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKufFromUnderexcLimIEEE2Command");

    if (kuf == null) throw new ProcessingException("Kuf already has nothing assigned.");

    apply(new UnAssignKufFromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignKuiToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignKuiToUnderexcLimIEEE2Command");

    if (kui != null && kui.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kui already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKuiToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKuiFromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKuiFromUnderexcLimIEEE2Command");

    if (kui == null) throw new ProcessingException("Kui already has nothing assigned.");

    apply(new UnAssignKuiFromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignKulToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignKulToUnderexcLimIEEE2Command");

    if (kul != null && kul.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kul already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKulToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKulFromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKulFromUnderexcLimIEEE2Command");

    if (kul == null) throw new ProcessingException("Kul already has nothing assigned.");

    apply(new UnAssignKulFromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignP0ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignP0ToUnderexcLimIEEE2Command");

    if (p0 != null && p0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P0 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignP0ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP0FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignP0FromUnderexcLimIEEE2Command");

    if (p0 == null) throw new ProcessingException("P0 already has nothing assigned.");

    apply(new UnAssignP0FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignP1ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignP1ToUnderexcLimIEEE2Command");

    if (p1 != null && p1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P1 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignP1ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP1FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignP1FromUnderexcLimIEEE2Command");

    if (p1 == null) throw new ProcessingException("P1 already has nothing assigned.");

    apply(new UnAssignP1FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignP10ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignP10ToUnderexcLimIEEE2Command");

    if (p10 != null && p10.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P10 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignP10ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP10FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignP10FromUnderexcLimIEEE2Command");

    if (p10 == null) throw new ProcessingException("P10 already has nothing assigned.");

    apply(new UnAssignP10FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignP2ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignP2ToUnderexcLimIEEE2Command");

    if (p2 != null && p2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P2 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignP2ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP2FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignP2FromUnderexcLimIEEE2Command");

    if (p2 == null) throw new ProcessingException("P2 already has nothing assigned.");

    apply(new UnAssignP2FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignP3ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignP3ToUnderexcLimIEEE2Command");

    if (p3 != null && p3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P3 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignP3ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP3FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignP3FromUnderexcLimIEEE2Command");

    if (p3 == null) throw new ProcessingException("P3 already has nothing assigned.");

    apply(new UnAssignP3FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignP4ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignP4ToUnderexcLimIEEE2Command");

    if (p4 != null && p4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P4 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignP4ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP4FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignP4FromUnderexcLimIEEE2Command");

    if (p4 == null) throw new ProcessingException("P4 already has nothing assigned.");

    apply(new UnAssignP4FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignP5ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignP5ToUnderexcLimIEEE2Command");

    if (p5 != null && p5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P5 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignP5ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP5FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignP5FromUnderexcLimIEEE2Command");

    if (p5 == null) throw new ProcessingException("P5 already has nothing assigned.");

    apply(new UnAssignP5FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignP6ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignP6ToUnderexcLimIEEE2Command");

    if (p6 != null && p6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P6 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignP6ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP6FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignP6FromUnderexcLimIEEE2Command");

    if (p6 == null) throw new ProcessingException("P6 already has nothing assigned.");

    apply(new UnAssignP6FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignP7ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignP7ToUnderexcLimIEEE2Command");

    if (p7 != null && p7.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P7 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignP7ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP7FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignP7FromUnderexcLimIEEE2Command");

    if (p7 == null) throw new ProcessingException("P7 already has nothing assigned.");

    apply(new UnAssignP7FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignP8ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignP8ToUnderexcLimIEEE2Command");

    if (p8 != null && p8.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P8 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignP8ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP8FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignP8FromUnderexcLimIEEE2Command");

    if (p8 == null) throw new ProcessingException("P8 already has nothing assigned.");

    apply(new UnAssignP8FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignP9ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignP9ToUnderexcLimIEEE2Command");

    if (p9 != null && p9.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "P9 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignP9ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignP9FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignP9FromUnderexcLimIEEE2Command");

    if (p9 == null) throw new ProcessingException("P9 already has nothing assigned.");

    apply(new UnAssignP9FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignQ0ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignQ0ToUnderexcLimIEEE2Command");

    if (q0 != null && q0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Q0 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQ0ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQ0FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQ0FromUnderexcLimIEEE2Command");

    if (q0 == null) throw new ProcessingException("Q0 already has nothing assigned.");

    apply(new UnAssignQ0FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignQ1ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignQ1ToUnderexcLimIEEE2Command");

    if (q1 != null && q1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Q1 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQ1ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQ1FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQ1FromUnderexcLimIEEE2Command");

    if (q1 == null) throw new ProcessingException("Q1 already has nothing assigned.");

    apply(new UnAssignQ1FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignQ10ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignQ10ToUnderexcLimIEEE2Command");

    if (q10 != null && q10.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Q10 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQ10ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQ10FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQ10FromUnderexcLimIEEE2Command");

    if (q10 == null) throw new ProcessingException("Q10 already has nothing assigned.");

    apply(new UnAssignQ10FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignQ2ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignQ2ToUnderexcLimIEEE2Command");

    if (q2 != null && q2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Q2 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQ2ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQ2FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQ2FromUnderexcLimIEEE2Command");

    if (q2 == null) throw new ProcessingException("Q2 already has nothing assigned.");

    apply(new UnAssignQ2FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignQ3ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignQ3ToUnderexcLimIEEE2Command");

    if (q3 != null && q3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Q3 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQ3ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQ3FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQ3FromUnderexcLimIEEE2Command");

    if (q3 == null) throw new ProcessingException("Q3 already has nothing assigned.");

    apply(new UnAssignQ3FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignQ4ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignQ4ToUnderexcLimIEEE2Command");

    if (q4 != null && q4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Q4 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQ4ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQ4FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQ4FromUnderexcLimIEEE2Command");

    if (q4 == null) throw new ProcessingException("Q4 already has nothing assigned.");

    apply(new UnAssignQ4FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignQ5ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignQ5ToUnderexcLimIEEE2Command");

    if (q5 != null && q5.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Q5 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQ5ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQ5FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQ5FromUnderexcLimIEEE2Command");

    if (q5 == null) throw new ProcessingException("Q5 already has nothing assigned.");

    apply(new UnAssignQ5FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignQ6ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignQ6ToUnderexcLimIEEE2Command");

    if (q6 != null && q6.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Q6 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQ6ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQ6FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQ6FromUnderexcLimIEEE2Command");

    if (q6 == null) throw new ProcessingException("Q6 already has nothing assigned.");

    apply(new UnAssignQ6FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignQ7ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignQ7ToUnderexcLimIEEE2Command");

    if (q7 != null && q7.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Q7 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQ7ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQ7FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQ7FromUnderexcLimIEEE2Command");

    if (q7 == null) throw new ProcessingException("Q7 already has nothing assigned.");

    apply(new UnAssignQ7FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignQ8ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignQ8ToUnderexcLimIEEE2Command");

    if (q8 != null && q8.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Q8 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQ8ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQ8FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQ8FromUnderexcLimIEEE2Command");

    if (q8 == null) throw new ProcessingException("Q8 already has nothing assigned.");

    apply(new UnAssignQ8FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignQ9ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignQ9ToUnderexcLimIEEE2Command");

    if (q9 != null && q9.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Q9 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignQ9ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQ9FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQ9FromUnderexcLimIEEE2Command");

    if (q9 == null) throw new ProcessingException("Q9 already has nothing assigned.");

    apply(new UnAssignQ9FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignTu1ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignTu1ToUnderexcLimIEEE2Command");

    if (tu1 != null && tu1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tu1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTu1ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTu1FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTu1FromUnderexcLimIEEE2Command");

    if (tu1 == null) throw new ProcessingException("Tu1 already has nothing assigned.");

    apply(new UnAssignTu1FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignTu2ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignTu2ToUnderexcLimIEEE2Command");

    if (tu2 != null && tu2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tu2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTu2ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTu2FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTu2FromUnderexcLimIEEE2Command");

    if (tu2 == null) throw new ProcessingException("Tu2 already has nothing assigned.");

    apply(new UnAssignTu2FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignTu3ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignTu3ToUnderexcLimIEEE2Command");

    if (tu3 != null && tu3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tu3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTu3ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTu3FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTu3FromUnderexcLimIEEE2Command");

    if (tu3 == null) throw new ProcessingException("Tu3 already has nothing assigned.");

    apply(new UnAssignTu3FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignTu4ToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignTu4ToUnderexcLimIEEE2Command");

    if (tu4 != null && tu4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tu4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTu4ToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTu4FromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTu4FromUnderexcLimIEEE2Command");

    if (tu4 == null) throw new ProcessingException("Tu4 already has nothing assigned.");

    apply(new UnAssignTu4FromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignTulToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignTulToUnderexcLimIEEE2Command");

    if (tul != null && tul.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tul already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTulToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTulFromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTulFromUnderexcLimIEEE2Command");

    if (tul == null) throw new ProcessingException("Tul already has nothing assigned.");

    apply(new UnAssignTulFromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignTupToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignTupToUnderexcLimIEEE2Command");

    if (tup != null && tup.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tup already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTupToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTupFromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTupFromUnderexcLimIEEE2Command");

    if (tup == null) throw new ProcessingException("Tup already has nothing assigned.");

    apply(new UnAssignTupFromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignTuqToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignTuqToUnderexcLimIEEE2Command");

    if (tuq != null && tuq.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tuq already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTuqToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTuqFromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTuqFromUnderexcLimIEEE2Command");

    if (tuq == null) throw new ProcessingException("Tuq already has nothing assigned.");

    apply(new UnAssignTuqFromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignTuvToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignTuvToUnderexcLimIEEE2Command");

    if (tuv != null && tuv.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tuv already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTuvToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTuvFromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTuvFromUnderexcLimIEEE2Command");

    if (tuv == null) throw new ProcessingException("Tuv already has nothing assigned.");

    apply(new UnAssignTuvFromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignVuimaxToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignVuimaxToUnderexcLimIEEE2Command");

    if (vuimax != null && vuimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vuimax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVuimaxToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVuimaxFromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVuimaxFromUnderexcLimIEEE2Command");

    if (vuimax == null) throw new ProcessingException("Vuimax already has nothing assigned.");

    apply(new UnAssignVuimaxFromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignVuiminToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignVuiminToUnderexcLimIEEE2Command");

    if (vuimin != null && vuimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vuimin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVuiminToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVuiminFromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVuiminFromUnderexcLimIEEE2Command");

    if (vuimin == null) throw new ProcessingException("Vuimin already has nothing assigned.");

    apply(new UnAssignVuiminFromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignVulmaxToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignVulmaxToUnderexcLimIEEE2Command");

    if (vulmax != null && vulmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vulmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVulmaxToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVulmaxFromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVulmaxFromUnderexcLimIEEE2Command");

    if (vulmax == null) throw new ProcessingException("Vulmax already has nothing assigned.");

    apply(new UnAssignVulmaxFromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  @CommandHandler
  public void handle(AssignVulminToUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handling command AssignVulminToUnderexcLimIEEE2Command");

    if (vulmin != null && vulmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vulmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVulminToUnderexcLimIEEE2Event(
            command.getUnderexcLimIEEE2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVulminFromUnderexcLimIEEE2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVulminFromUnderexcLimIEEE2Command");

    if (vulmin == null) throw new ProcessingException("Vulmin already has nothing assigned.");

    apply(new UnAssignVulminFromUnderexcLimIEEE2Event(command.getUnderexcLimIEEE2Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing CreateUnderexcLimIEEE2Event");
    this.underexcLimIEEE2Id = event.getUnderexcLimIEEE2Id();
  }

  @EventSourcingHandler
  void on(UpdateUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.k1 = event.getK1();
    this.k2 = event.getK2();
    this.kfb = event.getKfb();
    this.kuf = event.getKuf();
    this.kui = event.getKui();
    this.kul = event.getKul();
    this.p0 = event.getP0();
    this.p1 = event.getP1();
    this.p10 = event.getP10();
    this.p2 = event.getP2();
    this.p3 = event.getP3();
    this.p4 = event.getP4();
    this.p5 = event.getP5();
    this.p6 = event.getP6();
    this.p7 = event.getP7();
    this.p8 = event.getP8();
    this.p9 = event.getP9();
    this.q0 = event.getQ0();
    this.q1 = event.getQ1();
    this.q10 = event.getQ10();
    this.q2 = event.getQ2();
    this.q3 = event.getQ3();
    this.q4 = event.getQ4();
    this.q5 = event.getQ5();
    this.q6 = event.getQ6();
    this.q7 = event.getQ7();
    this.q8 = event.getQ8();
    this.q9 = event.getQ9();
    this.tu1 = event.getTu1();
    this.tu2 = event.getTu2();
    this.tu3 = event.getTu3();
    this.tu4 = event.getTu4();
    this.tul = event.getTul();
    this.tup = event.getTup();
    this.tuq = event.getTuq();
    this.tuv = event.getTuv();
    this.vuimax = event.getVuimax();
    this.vuimin = event.getVuimin();
    this.vulmax = event.getVulmax();
    this.vulmin = event.getVulmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignK1ToUnderexcLimIEEE2Event");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignK1FromUnderexcLimIEEE2Event");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK2ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignK2ToUnderexcLimIEEE2Event");
    this.k2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK2FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignK2FromUnderexcLimIEEE2Event");
    this.k2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKfbToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignKfbToUnderexcLimIEEE2Event");
    this.kfb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKfbFromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignKfbFromUnderexcLimIEEE2Event");
    this.kfb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKufToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignKufToUnderexcLimIEEE2Event");
    this.kuf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKufFromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignKufFromUnderexcLimIEEE2Event");
    this.kuf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKuiToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignKuiToUnderexcLimIEEE2Event");
    this.kui = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKuiFromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignKuiFromUnderexcLimIEEE2Event");
    this.kui = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKulToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignKulToUnderexcLimIEEE2Event");
    this.kul = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKulFromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignKulFromUnderexcLimIEEE2Event");
    this.kul = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP0ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignP0ToUnderexcLimIEEE2Event");
    this.p0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP0FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignP0FromUnderexcLimIEEE2Event");
    this.p0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP1ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignP1ToUnderexcLimIEEE2Event");
    this.p1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP1FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignP1FromUnderexcLimIEEE2Event");
    this.p1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP10ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignP10ToUnderexcLimIEEE2Event");
    this.p10 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP10FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignP10FromUnderexcLimIEEE2Event");
    this.p10 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP2ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignP2ToUnderexcLimIEEE2Event");
    this.p2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP2FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignP2FromUnderexcLimIEEE2Event");
    this.p2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP3ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignP3ToUnderexcLimIEEE2Event");
    this.p3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP3FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignP3FromUnderexcLimIEEE2Event");
    this.p3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP4ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignP4ToUnderexcLimIEEE2Event");
    this.p4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP4FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignP4FromUnderexcLimIEEE2Event");
    this.p4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP5ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignP5ToUnderexcLimIEEE2Event");
    this.p5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP5FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignP5FromUnderexcLimIEEE2Event");
    this.p5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP6ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignP6ToUnderexcLimIEEE2Event");
    this.p6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP6FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignP6FromUnderexcLimIEEE2Event");
    this.p6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP7ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignP7ToUnderexcLimIEEE2Event");
    this.p7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP7FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignP7FromUnderexcLimIEEE2Event");
    this.p7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP8ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignP8ToUnderexcLimIEEE2Event");
    this.p8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP8FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignP8FromUnderexcLimIEEE2Event");
    this.p8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignP9ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignP9ToUnderexcLimIEEE2Event");
    this.p9 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignP9FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignP9FromUnderexcLimIEEE2Event");
    this.p9 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQ0ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignQ0ToUnderexcLimIEEE2Event");
    this.q0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQ0FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignQ0FromUnderexcLimIEEE2Event");
    this.q0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQ1ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignQ1ToUnderexcLimIEEE2Event");
    this.q1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQ1FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignQ1FromUnderexcLimIEEE2Event");
    this.q1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQ10ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignQ10ToUnderexcLimIEEE2Event");
    this.q10 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQ10FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignQ10FromUnderexcLimIEEE2Event");
    this.q10 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQ2ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignQ2ToUnderexcLimIEEE2Event");
    this.q2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQ2FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignQ2FromUnderexcLimIEEE2Event");
    this.q2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQ3ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignQ3ToUnderexcLimIEEE2Event");
    this.q3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQ3FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignQ3FromUnderexcLimIEEE2Event");
    this.q3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQ4ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignQ4ToUnderexcLimIEEE2Event");
    this.q4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQ4FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignQ4FromUnderexcLimIEEE2Event");
    this.q4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQ5ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignQ5ToUnderexcLimIEEE2Event");
    this.q5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQ5FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignQ5FromUnderexcLimIEEE2Event");
    this.q5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQ6ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignQ6ToUnderexcLimIEEE2Event");
    this.q6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQ6FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignQ6FromUnderexcLimIEEE2Event");
    this.q6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQ7ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignQ7ToUnderexcLimIEEE2Event");
    this.q7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQ7FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignQ7FromUnderexcLimIEEE2Event");
    this.q7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQ8ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignQ8ToUnderexcLimIEEE2Event");
    this.q8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQ8FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignQ8FromUnderexcLimIEEE2Event");
    this.q8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQ9ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignQ9ToUnderexcLimIEEE2Event");
    this.q9 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQ9FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignQ9FromUnderexcLimIEEE2Event");
    this.q9 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTu1ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignTu1ToUnderexcLimIEEE2Event");
    this.tu1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTu1FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignTu1FromUnderexcLimIEEE2Event");
    this.tu1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTu2ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignTu2ToUnderexcLimIEEE2Event");
    this.tu2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTu2FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignTu2FromUnderexcLimIEEE2Event");
    this.tu2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTu3ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignTu3ToUnderexcLimIEEE2Event");
    this.tu3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTu3FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignTu3FromUnderexcLimIEEE2Event");
    this.tu3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTu4ToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignTu4ToUnderexcLimIEEE2Event");
    this.tu4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTu4FromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignTu4FromUnderexcLimIEEE2Event");
    this.tu4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTulToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignTulToUnderexcLimIEEE2Event");
    this.tul = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTulFromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignTulFromUnderexcLimIEEE2Event");
    this.tul = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTupToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignTupToUnderexcLimIEEE2Event");
    this.tup = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTupFromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignTupFromUnderexcLimIEEE2Event");
    this.tup = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTuqToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignTuqToUnderexcLimIEEE2Event");
    this.tuq = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTuqFromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignTuqFromUnderexcLimIEEE2Event");
    this.tuq = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTuvToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignTuvToUnderexcLimIEEE2Event");
    this.tuv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTuvFromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignTuvFromUnderexcLimIEEE2Event");
    this.tuv = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVuimaxToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignVuimaxToUnderexcLimIEEE2Event");
    this.vuimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVuimaxFromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignVuimaxFromUnderexcLimIEEE2Event");
    this.vuimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVuiminToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignVuiminToUnderexcLimIEEE2Event");
    this.vuimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVuiminFromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignVuiminFromUnderexcLimIEEE2Event");
    this.vuimin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVulmaxToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignVulmaxToUnderexcLimIEEE2Event");
    this.vulmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVulmaxFromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignVulmaxFromUnderexcLimIEEE2Event");
    this.vulmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVulminToUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing AssignVulminToUnderexcLimIEEE2Event");
    this.vulmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVulminFromUnderexcLimIEEE2Event event) {
    LOGGER.info("Event sourcing UnAssignVulminFromUnderexcLimIEEE2Event");
    this.vulmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID underexcLimIEEE2Id;

  private Simple_Float k1 = null;
  private Simple_Float k2 = null;
  private PU kfb = null;
  private PU kuf = null;
  private PU kui = null;
  private PU kul = null;
  private PU p0 = null;
  private PU p1 = null;
  private PU p10 = null;
  private PU p2 = null;
  private PU p3 = null;
  private PU p4 = null;
  private PU p5 = null;
  private PU p6 = null;
  private PU p7 = null;
  private PU p8 = null;
  private PU p9 = null;
  private PU q0 = null;
  private PU q1 = null;
  private PU q10 = null;
  private PU q2 = null;
  private PU q3 = null;
  private PU q4 = null;
  private PU q5 = null;
  private PU q6 = null;
  private PU q7 = null;
  private PU q8 = null;
  private PU q9 = null;
  private Seconds tu1 = null;
  private Seconds tu2 = null;
  private Seconds tu3 = null;
  private Seconds tu4 = null;
  private Seconds tul = null;
  private Seconds tup = null;
  private Seconds tuq = null;
  private Seconds tuv = null;
  private PU vuimax = null;
  private PU vuimin = null;
  private PU vulmax = null;
  private PU vulmin = null;

  private static final Logger LOGGER = Logger.getLogger(UnderexcLimIEEE2Aggregate.class.getName());
}
