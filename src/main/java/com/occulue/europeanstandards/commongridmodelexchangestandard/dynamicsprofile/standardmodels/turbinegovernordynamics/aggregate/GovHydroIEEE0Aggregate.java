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
 * Aggregate handler for GovHydroIEEE0 as outlined for the CQRS pattern, all write responsibilities
 * related to GovHydroIEEE0 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovHydroIEEE0Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovHydroIEEE0Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovHydroIEEE0Aggregate(CreateGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handling command CreateGovHydroIEEE0Command");
    CreateGovHydroIEEE0Event event = new CreateGovHydroIEEE0Event(command.getGovHydroIEEE0Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("handling command UpdateGovHydroIEEE0Command");
    UpdateGovHydroIEEE0Event event =
        new UpdateGovHydroIEEE0Event(
            command.getGovHydroIEEE0Id(),
            command.getK(),
            command.getMwbase(),
            command.getPmax(),
            command.getPmin(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovHydroIEEE0Command");
    apply(new DeleteGovHydroIEEE0Event(command.getGovHydroIEEE0Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKToGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handling command AssignKToGovHydroIEEE0Command");

    if (k != null && k.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKToGovHydroIEEE0Event(command.getGovHydroIEEE0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKFromGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKFromGovHydroIEEE0Command");

    if (k == null) throw new ProcessingException("K already has nothing assigned.");

    apply(new UnAssignKFromGovHydroIEEE0Event(command.getGovHydroIEEE0Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovHydroIEEE0Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignMwbaseToGovHydroIEEE0Event(
            command.getGovHydroIEEE0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovHydroIEEE0Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovHydroIEEE0Event(command.getGovHydroIEEE0Id()));
  }

  @CommandHandler
  public void handle(AssignPmaxToGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handling command AssignPmaxToGovHydroIEEE0Command");

    if (pmax != null && pmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPmaxToGovHydroIEEE0Event(command.getGovHydroIEEE0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPmaxFromGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPmaxFromGovHydroIEEE0Command");

    if (pmax == null) throw new ProcessingException("Pmax already has nothing assigned.");

    apply(new UnAssignPmaxFromGovHydroIEEE0Event(command.getGovHydroIEEE0Id()));
  }

  @CommandHandler
  public void handle(AssignPminToGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handling command AssignPminToGovHydroIEEE0Command");

    if (pmin != null && pmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPminToGovHydroIEEE0Event(command.getGovHydroIEEE0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPminFromGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPminFromGovHydroIEEE0Command");

    if (pmin == null) throw new ProcessingException("Pmin already has nothing assigned.");

    apply(new UnAssignPminFromGovHydroIEEE0Event(command.getGovHydroIEEE0Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToGovHydroIEEE0Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToGovHydroIEEE0Event(command.getGovHydroIEEE0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromGovHydroIEEE0Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromGovHydroIEEE0Event(command.getGovHydroIEEE0Id()));
  }

  @CommandHandler
  public void handle(AssignT2ToGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handling command AssignT2ToGovHydroIEEE0Command");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToGovHydroIEEE0Event(command.getGovHydroIEEE0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromGovHydroIEEE0Command");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromGovHydroIEEE0Event(command.getGovHydroIEEE0Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToGovHydroIEEE0Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToGovHydroIEEE0Event(command.getGovHydroIEEE0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromGovHydroIEEE0Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromGovHydroIEEE0Event(command.getGovHydroIEEE0Id()));
  }

  @CommandHandler
  public void handle(AssignT4ToGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handling command AssignT4ToGovHydroIEEE0Command");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToGovHydroIEEE0Event(command.getGovHydroIEEE0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromGovHydroIEEE0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromGovHydroIEEE0Command");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromGovHydroIEEE0Event(command.getGovHydroIEEE0Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing CreateGovHydroIEEE0Event");
    this.govHydroIEEE0Id = event.getGovHydroIEEE0Id();
  }

  @EventSourcingHandler
  void on(UpdateGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.k = event.getK();
    this.mwbase = event.getMwbase();
    this.pmax = event.getPmax();
    this.pmin = event.getPmin();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKToGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing AssignKToGovHydroIEEE0Event");
    this.k = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKFromGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing UnAssignKFromGovHydroIEEE0Event");
    this.k = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovHydroIEEE0Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovHydroIEEE0Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPmaxToGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing AssignPmaxToGovHydroIEEE0Event");
    this.pmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPmaxFromGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing UnAssignPmaxFromGovHydroIEEE0Event");
    this.pmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPminToGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing AssignPminToGovHydroIEEE0Event");
    this.pmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPminFromGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing UnAssignPminFromGovHydroIEEE0Event");
    this.pmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing AssignT1ToGovHydroIEEE0Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromGovHydroIEEE0Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing AssignT2ToGovHydroIEEE0Event");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing UnAssignT2FromGovHydroIEEE0Event");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing AssignT3ToGovHydroIEEE0Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromGovHydroIEEE0Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing AssignT4ToGovHydroIEEE0Event");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromGovHydroIEEE0Event event) {
    LOGGER.info("Event sourcing UnAssignT4FromGovHydroIEEE0Event");
    this.t4 = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govHydroIEEE0Id;

  private PU k = null;
  private ActivePower mwbase = null;
  private PU pmax = null;
  private PU pmin = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;

  private static final Logger LOGGER = Logger.getLogger(GovHydroIEEE0Aggregate.class.getName());
}
