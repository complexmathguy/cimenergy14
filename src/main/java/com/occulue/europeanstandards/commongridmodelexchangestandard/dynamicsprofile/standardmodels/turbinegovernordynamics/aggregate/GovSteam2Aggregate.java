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
 * Aggregate handler for GovSteam2 as outlined for the CQRS pattern, all write responsibilities
 * related to GovSteam2 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovSteam2Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovSteam2Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovSteam2Aggregate(CreateGovSteam2Command command) throws Exception {
    LOGGER.info("Handling command CreateGovSteam2Command");
    CreateGovSteam2Event event = new CreateGovSteam2Event(command.getGovSteam2Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovSteam2Command command) throws Exception {
    LOGGER.info("handling command UpdateGovSteam2Command");
    UpdateGovSteam2Event event =
        new UpdateGovSteam2Event(
            command.getGovSteam2Id(),
            command.getDbf(),
            command.getK(),
            command.getMnef(),
            command.getMxef(),
            command.getPmax(),
            command.getPmin(),
            command.getT1(),
            command.getT2());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovSteam2Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovSteam2Command");
    apply(new DeleteGovSteam2Event(command.getGovSteam2Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDbfToGovSteam2Command command) throws Exception {
    LOGGER.info("Handling command AssignDbfToGovSteam2Command");

    if (dbf != null && dbf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dbf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDbfToGovSteam2Event(command.getGovSteam2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDbfFromGovSteam2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDbfFromGovSteam2Command");

    if (dbf == null) throw new ProcessingException("Dbf already has nothing assigned.");

    apply(new UnAssignDbfFromGovSteam2Event(command.getGovSteam2Id()));
  }

  @CommandHandler
  public void handle(AssignKToGovSteam2Command command) throws Exception {
    LOGGER.info("Handling command AssignKToGovSteam2Command");

    if (k != null && k.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKToGovSteam2Event(command.getGovSteam2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKFromGovSteam2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKFromGovSteam2Command");

    if (k == null) throw new ProcessingException("K already has nothing assigned.");

    apply(new UnAssignKFromGovSteam2Event(command.getGovSteam2Id()));
  }

  @CommandHandler
  public void handle(AssignMnefToGovSteam2Command command) throws Exception {
    LOGGER.info("Handling command AssignMnefToGovSteam2Command");

    if (mnef != null && mnef.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Mnef already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignMnefToGovSteam2Event(command.getGovSteam2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMnefFromGovSteam2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMnefFromGovSteam2Command");

    if (mnef == null) throw new ProcessingException("Mnef already has nothing assigned.");

    apply(new UnAssignMnefFromGovSteam2Event(command.getGovSteam2Id()));
  }

  @CommandHandler
  public void handle(AssignMxefToGovSteam2Command command) throws Exception {
    LOGGER.info("Handling command AssignMxefToGovSteam2Command");

    if (mxef != null && mxef.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Mxef already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignMxefToGovSteam2Event(command.getGovSteam2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMxefFromGovSteam2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMxefFromGovSteam2Command");

    if (mxef == null) throw new ProcessingException("Mxef already has nothing assigned.");

    apply(new UnAssignMxefFromGovSteam2Event(command.getGovSteam2Id()));
  }

  @CommandHandler
  public void handle(AssignPmaxToGovSteam2Command command) throws Exception {
    LOGGER.info("Handling command AssignPmaxToGovSteam2Command");

    if (pmax != null && pmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPmaxToGovSteam2Event(command.getGovSteam2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxFromGovSteam2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxFromGovSteam2Command");

    if (pmax == null) throw new ProcessingException("Pmax already has nothing assigned.");

    apply(new UnAssignPmaxFromGovSteam2Event(command.getGovSteam2Id()));
  }

  @CommandHandler
  public void handle(AssignPminToGovSteam2Command command) throws Exception {
    LOGGER.info("Handling command AssignPminToGovSteam2Command");

    if (pmin != null && pmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPminToGovSteam2Event(command.getGovSteam2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromGovSteam2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromGovSteam2Command");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromGovSteam2Event(command.getGovSteam2Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToGovSteam2Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToGovSteam2Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToGovSteam2Event(command.getGovSteam2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromGovSteam2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromGovSteam2Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromGovSteam2Event(command.getGovSteam2Id()));
  }

  @CommandHandler
  public void handle(AssignT2ToGovSteam2Command command) throws Exception {
    LOGGER.info("Handling command AssignT2ToGovSteam2Command");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToGovSteam2Event(command.getGovSteam2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromGovSteam2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromGovSteam2Command");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromGovSteam2Event(command.getGovSteam2Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovSteam2Event event) {
    LOGGER.info("Event sourcing CreateGovSteam2Event");
    this.govSteam2Id = event.getGovSteam2Id();
  }

  @EventSourcingHandler
  void on(UpdateGovSteam2Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dbf = event.getDbf();
    this.k = event.getK();
    this.mnef = event.getMnef();
    this.mxef = event.getMxef();
    this.pmax = event.getPmax();
    this.pmin = event.getPmin();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDbfToGovSteam2Event event) {
    LOGGER.info("Event sourcing AssignDbfToGovSteam2Event");
    this.dbf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDbfFromGovSteam2Event event) {
    LOGGER.info("Event sourcing UnAssignDbfFromGovSteam2Event");
    this.dbf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKToGovSteam2Event event) {
    LOGGER.info("Event sourcing AssignKToGovSteam2Event");
    this.k = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKFromGovSteam2Event event) {
    LOGGER.info("Event sourcing UnAssignKFromGovSteam2Event");
    this.k = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMnefToGovSteam2Event event) {
    LOGGER.info("Event sourcing AssignMnefToGovSteam2Event");
    this.mnef = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMnefFromGovSteam2Event event) {
    LOGGER.info("Event sourcing UnAssignMnefFromGovSteam2Event");
    this.mnef = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMxefToGovSteam2Event event) {
    LOGGER.info("Event sourcing AssignMxefToGovSteam2Event");
    this.mxef = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMxefFromGovSteam2Event event) {
    LOGGER.info("Event sourcing UnAssignMxefFromGovSteam2Event");
    this.mxef = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxToGovSteam2Event event) {
    LOGGER.info("Event sourcing AssignPmaxToGovSteam2Event");
    this.pmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxFromGovSteam2Event event) {
    LOGGER.info("Event sourcing UnAssignPmaxFromGovSteam2Event");
    this.pmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToGovSteam2Event event) {
    LOGGER.info("Event sourcing AssignPminToGovSteam2Event");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromGovSteam2Event event) {
    LOGGER.info("Event sourcing UnAssignPminFromGovSteam2Event");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToGovSteam2Event event) {
    LOGGER.info("Event sourcing AssignT1ToGovSteam2Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromGovSteam2Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromGovSteam2Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToGovSteam2Event event) {
    LOGGER.info("Event sourcing AssignT2ToGovSteam2Event");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromGovSteam2Event event) {
    LOGGER.info("Event sourcing UnAssignT2FromGovSteam2Event");
    this.t2 = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govSteam2Id;

  private PU dbf = null;
  private Simple_Float k = null;
  private PU mnef = null;
  private PU mxef = null;
  private PU pmax = null;
  private PU pmin = null;
  private Seconds t1 = null;
  private Seconds t2 = null;

  private static final Logger LOGGER = Logger.getLogger(GovSteam2Aggregate.class.getName());
}
