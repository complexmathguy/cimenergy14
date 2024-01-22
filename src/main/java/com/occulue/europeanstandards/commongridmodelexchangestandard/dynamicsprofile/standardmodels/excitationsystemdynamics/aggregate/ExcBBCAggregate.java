package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.aggregate;

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
 * Aggregate handler for ExcBBC as outlined for the CQRS pattern, all write responsibilities related
 * to ExcBBC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcBBCAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcBBCAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcBBCAggregate(CreateExcBBCCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcBBCCommand");
    CreateExcBBCEvent event = new CreateExcBBCEvent(command.getExcBBCId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcBBCCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcBBCCommand");
    UpdateExcBBCEvent event =
        new UpdateExcBBCEvent(
            command.getExcBBCId(),
            command.getEfdmax(),
            command.getEfdmin(),
            command.getK(),
            command.getSwitchIt(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getVrmax(),
            command.getVrmin(),
            command.getXe());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcBBCCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcBBCCommand");
    apply(new DeleteExcBBCEvent(command.getExcBBCId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfdmaxToExcBBCCommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdmaxToExcBBCCommand");

    if (efdmax != null && efdmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdmaxToExcBBCEvent(command.getExcBBCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdmaxFromExcBBCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdmaxFromExcBBCCommand");

    if (efdmax == null) throw new ProcessingException("Efdmax already has nothing assigned.");

    apply(new UnAssignEfdmaxFromExcBBCEvent(command.getExcBBCId()));
  }

  @CommandHandler
  public void handle(AssignEfdminToExcBBCCommand command) throws Exception {
    LOGGER.info("Handling command AssignEfdminToExcBBCCommand");

    if (efdmin != null && efdmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdminToExcBBCEvent(command.getExcBBCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdminFromExcBBCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdminFromExcBBCCommand");

    if (efdmin == null) throw new ProcessingException("Efdmin already has nothing assigned.");

    apply(new UnAssignEfdminFromExcBBCEvent(command.getExcBBCId()));
  }

  @CommandHandler
  public void handle(AssignKToExcBBCCommand command) throws Exception {
    LOGGER.info("Handling command AssignKToExcBBCCommand");

    if (k != null && k.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKToExcBBCEvent(command.getExcBBCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKFromExcBBCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKFromExcBBCCommand");

    if (k == null) throw new ProcessingException("K already has nothing assigned.");

    apply(new UnAssignKFromExcBBCEvent(command.getExcBBCId()));
  }

  @CommandHandler
  public void handle(AssignSwitchItToExcBBCCommand command) throws Exception {
    LOGGER.info("Handling command AssignSwitchItToExcBBCCommand");

    if (switchIt != null
        && switchIt.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "SwitchIt already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignSwitchItToExcBBCEvent(command.getExcBBCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSwitchItFromExcBBCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSwitchItFromExcBBCCommand");

    if (switchIt == null) throw new ProcessingException("SwitchIt already has nothing assigned.");

    apply(new UnAssignSwitchItFromExcBBCEvent(command.getExcBBCId()));
  }

  @CommandHandler
  public void handle(AssignT1ToExcBBCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToExcBBCCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToExcBBCEvent(command.getExcBBCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromExcBBCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromExcBBCCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromExcBBCEvent(command.getExcBBCId()));
  }

  @CommandHandler
  public void handle(AssignT2ToExcBBCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToExcBBCCommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToExcBBCEvent(command.getExcBBCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromExcBBCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromExcBBCCommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromExcBBCEvent(command.getExcBBCId()));
  }

  @CommandHandler
  public void handle(AssignT3ToExcBBCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToExcBBCCommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToExcBBCEvent(command.getExcBBCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromExcBBCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromExcBBCCommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromExcBBCEvent(command.getExcBBCId()));
  }

  @CommandHandler
  public void handle(AssignT4ToExcBBCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT4ToExcBBCCommand");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToExcBBCEvent(command.getExcBBCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromExcBBCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromExcBBCCommand");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromExcBBCEvent(command.getExcBBCId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcBBCCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcBBCCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcBBCEvent(command.getExcBBCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcBBCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcBBCCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcBBCEvent(command.getExcBBCId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcBBCCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcBBCCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcBBCEvent(command.getExcBBCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcBBCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcBBCCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcBBCEvent(command.getExcBBCId()));
  }

  @CommandHandler
  public void handle(AssignXeToExcBBCCommand command) throws Exception {
    LOGGER.info("Handling command AssignXeToExcBBCCommand");

    if (xe != null && xe.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xe already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignXeToExcBBCEvent(command.getExcBBCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXeFromExcBBCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXeFromExcBBCCommand");

    if (xe == null) throw new ProcessingException("Xe already has nothing assigned.");

    apply(new UnAssignXeFromExcBBCEvent(command.getExcBBCId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcBBCEvent event) {
    LOGGER.info("Event sourcing CreateExcBBCEvent");
    this.excBBCId = event.getExcBBCId();
  }

  @EventSourcingHandler
  void on(UpdateExcBBCEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efdmax = event.getEfdmax();
    this.efdmin = event.getEfdmin();
    this.k = event.getK();
    this.switchIt = event.getSwitchIt();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
    this.xe = event.getXe();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfdmaxToExcBBCEvent event) {
    LOGGER.info("Event sourcing AssignEfdmaxToExcBBCEvent");
    this.efdmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdmaxFromExcBBCEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdmaxFromExcBBCEvent");
    this.efdmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfdminToExcBBCEvent event) {
    LOGGER.info("Event sourcing AssignEfdminToExcBBCEvent");
    this.efdmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdminFromExcBBCEvent event) {
    LOGGER.info("Event sourcing UnAssignEfdminFromExcBBCEvent");
    this.efdmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKToExcBBCEvent event) {
    LOGGER.info("Event sourcing AssignKToExcBBCEvent");
    this.k = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKFromExcBBCEvent event) {
    LOGGER.info("Event sourcing UnAssignKFromExcBBCEvent");
    this.k = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSwitchItToExcBBCEvent event) {
    LOGGER.info("Event sourcing AssignSwitchItToExcBBCEvent");
    this.switchIt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSwitchItFromExcBBCEvent event) {
    LOGGER.info("Event sourcing UnAssignSwitchItFromExcBBCEvent");
    this.switchIt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToExcBBCEvent event) {
    LOGGER.info("Event sourcing AssignT1ToExcBBCEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromExcBBCEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromExcBBCEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToExcBBCEvent event) {
    LOGGER.info("Event sourcing AssignT2ToExcBBCEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromExcBBCEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromExcBBCEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToExcBBCEvent event) {
    LOGGER.info("Event sourcing AssignT3ToExcBBCEvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromExcBBCEvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromExcBBCEvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToExcBBCEvent event) {
    LOGGER.info("Event sourcing AssignT4ToExcBBCEvent");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromExcBBCEvent event) {
    LOGGER.info("Event sourcing UnAssignT4FromExcBBCEvent");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcBBCEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcBBCEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcBBCEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcBBCEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcBBCEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcBBCEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcBBCEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcBBCEvent");
    this.vrmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXeToExcBBCEvent event) {
    LOGGER.info("Event sourcing AssignXeToExcBBCEvent");
    this.xe = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXeFromExcBBCEvent event) {
    LOGGER.info("Event sourcing UnAssignXeFromExcBBCEvent");
    this.xe = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excBBCId;

  private PU efdmax = null;
  private PU efdmin = null;
  private PU k = null;
  private BooleanProxy switchIt = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private PU vrmax = null;
  private PU vrmin = null;
  private PU xe = null;

  private static final Logger LOGGER = Logger.getLogger(ExcBBCAggregate.class.getName());
}
