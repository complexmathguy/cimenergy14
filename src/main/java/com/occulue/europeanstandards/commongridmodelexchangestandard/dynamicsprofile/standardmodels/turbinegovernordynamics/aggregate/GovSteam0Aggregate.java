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
 * Aggregate handler for GovSteam0 as outlined for the CQRS pattern, all write responsibilities
 * related to GovSteam0 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovSteam0Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovSteam0Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovSteam0Aggregate(CreateGovSteam0Command command) throws Exception {
    LOGGER.info("Handling command CreateGovSteam0Command");
    CreateGovSteam0Event event = new CreateGovSteam0Event(command.getGovSteam0Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovSteam0Command command) throws Exception {
    LOGGER.info("handling command UpdateGovSteam0Command");
    UpdateGovSteam0Event event =
        new UpdateGovSteam0Event(
            command.getGovSteam0Id(),
            command.getDt(),
            command.getMwbase(),
            command.getR(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getVmax(),
            command.getVmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovSteam0Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovSteam0Command");
    apply(new DeleteGovSteam0Event(command.getGovSteam0Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDtToGovSteam0Command command) throws Exception {
    LOGGER.info("Handling command AssignDtToGovSteam0Command");

    if (dt != null && dt.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dt already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDtToGovSteam0Event(command.getGovSteam0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDtFromGovSteam0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDtFromGovSteam0Command");

    if (dt == null) throw new ProcessingException("Dt already has nothing assigned.");

    apply(new UnAssignDtFromGovSteam0Event(command.getGovSteam0Id()));
  }

  @CommandHandler
  public void handle(AssignMwbaseToGovSteam0Command command) throws Exception {
    LOGGER.info("Handling command AssignMwbaseToGovSteam0Command");

    if (mwbase != null && mwbase.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Mwbase already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignMwbaseToGovSteam0Event(command.getGovSteam0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwbaseFromGovSteam0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwbaseFromGovSteam0Command");

    if (mwbase == null) throw new ProcessingException("Mwbase already has nothing assigned.");

    apply(new UnAssignMwbaseFromGovSteam0Event(command.getGovSteam0Id()));
  }

  @CommandHandler
  public void handle(AssignRToGovSteam0Command command) throws Exception {
    LOGGER.info("Handling command AssignRToGovSteam0Command");

    if (r != null && r.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRToGovSteam0Event(command.getGovSteam0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromGovSteam0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromGovSteam0Command");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromGovSteam0Event(command.getGovSteam0Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToGovSteam0Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToGovSteam0Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToGovSteam0Event(command.getGovSteam0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromGovSteam0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromGovSteam0Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromGovSteam0Event(command.getGovSteam0Id()));
  }

  @CommandHandler
  public void handle(AssignT2ToGovSteam0Command command) throws Exception {
    LOGGER.info("Handling command AssignT2ToGovSteam0Command");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToGovSteam0Event(command.getGovSteam0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromGovSteam0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromGovSteam0Command");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromGovSteam0Event(command.getGovSteam0Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToGovSteam0Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToGovSteam0Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToGovSteam0Event(command.getGovSteam0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromGovSteam0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromGovSteam0Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromGovSteam0Event(command.getGovSteam0Id()));
  }

  @CommandHandler
  public void handle(AssignVmaxToGovSteam0Command command) throws Exception {
    LOGGER.info("Handling command AssignVmaxToGovSteam0Command");

    if (vmax != null && vmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVmaxToGovSteam0Event(command.getGovSteam0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVmaxFromGovSteam0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVmaxFromGovSteam0Command");

    if (vmax == null) throw new ProcessingException("Vmax already has nothing assigned.");

    apply(new UnAssignVmaxFromGovSteam0Event(command.getGovSteam0Id()));
  }

  @CommandHandler
  public void handle(AssignVminToGovSteam0Command command) throws Exception {
    LOGGER.info("Handling command AssignVminToGovSteam0Command");

    if (vmin != null && vmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVminToGovSteam0Event(command.getGovSteam0Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVminFromGovSteam0Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVminFromGovSteam0Command");

    if (vmin == null) throw new ProcessingException("Vmin already has nothing assigned.");

    apply(new UnAssignVminFromGovSteam0Event(command.getGovSteam0Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovSteam0Event event) {
    LOGGER.info("Event sourcing CreateGovSteam0Event");
    this.govSteam0Id = event.getGovSteam0Id();
  }

  @EventSourcingHandler
  void on(UpdateGovSteam0Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dt = event.getDt();
    this.mwbase = event.getMwbase();
    this.r = event.getR();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.vmax = event.getVmax();
    this.vmin = event.getVmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDtToGovSteam0Event event) {
    LOGGER.info("Event sourcing AssignDtToGovSteam0Event");
    this.dt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDtFromGovSteam0Event event) {
    LOGGER.info("Event sourcing UnAssignDtFromGovSteam0Event");
    this.dt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwbaseToGovSteam0Event event) {
    LOGGER.info("Event sourcing AssignMwbaseToGovSteam0Event");
    this.mwbase = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwbaseFromGovSteam0Event event) {
    LOGGER.info("Event sourcing UnAssignMwbaseFromGovSteam0Event");
    this.mwbase = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToGovSteam0Event event) {
    LOGGER.info("Event sourcing AssignRToGovSteam0Event");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromGovSteam0Event event) {
    LOGGER.info("Event sourcing UnAssignRFromGovSteam0Event");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToGovSteam0Event event) {
    LOGGER.info("Event sourcing AssignT1ToGovSteam0Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromGovSteam0Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromGovSteam0Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToGovSteam0Event event) {
    LOGGER.info("Event sourcing AssignT2ToGovSteam0Event");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromGovSteam0Event event) {
    LOGGER.info("Event sourcing UnAssignT2FromGovSteam0Event");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToGovSteam0Event event) {
    LOGGER.info("Event sourcing AssignT3ToGovSteam0Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromGovSteam0Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromGovSteam0Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVmaxToGovSteam0Event event) {
    LOGGER.info("Event sourcing AssignVmaxToGovSteam0Event");
    this.vmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVmaxFromGovSteam0Event event) {
    LOGGER.info("Event sourcing UnAssignVmaxFromGovSteam0Event");
    this.vmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVminToGovSteam0Event event) {
    LOGGER.info("Event sourcing AssignVminToGovSteam0Event");
    this.vmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVminFromGovSteam0Event event) {
    LOGGER.info("Event sourcing UnAssignVminFromGovSteam0Event");
    this.vmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govSteam0Id;

  private PU dt = null;
  private ActivePower mwbase = null;
  private PU r = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private PU vmax = null;
  private PU vmin = null;

  private static final Logger LOGGER = Logger.getLogger(GovSteam0Aggregate.class.getName());
}
