package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.aggregate;

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
 * Aggregate handler for OverexcLimX1 as outlined for the CQRS pattern, all write responsibilities
 * related to OverexcLimX1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class OverexcLimX1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public OverexcLimX1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public OverexcLimX1Aggregate(CreateOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command CreateOverexcLimX1Command");
    CreateOverexcLimX1Event event = new CreateOverexcLimX1Event(command.getOverexcLimX1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateOverexcLimX1Command command) throws Exception {
    LOGGER.info("handling command UpdateOverexcLimX1Command");
    UpdateOverexcLimX1Event event =
        new UpdateOverexcLimX1Event(
            command.getOverexcLimX1Id(),
            command.getEfd1(),
            command.getEfd2(),
            command.getEfd3(),
            command.getEfddes(),
            command.getEfdrated(),
            command.getKmx(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getVlow());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command DeleteOverexcLimX1Command");
    apply(new DeleteOverexcLimX1Event(command.getOverexcLimX1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfd1ToOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignEfd1ToOverexcLimX1Command");

    if (efd1 != null && efd1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd1ToOverexcLimX1Event(command.getOverexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd1FromOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd1FromOverexcLimX1Command");

    if (efd1 == null) throw new ProcessingException("Efd1 already has nothing assigned.");

    apply(new UnAssignEfd1FromOverexcLimX1Event(command.getOverexcLimX1Id()));
  }

  @CommandHandler
  public void handle(AssignEfd2ToOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignEfd2ToOverexcLimX1Command");

    if (efd2 != null && efd2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd2ToOverexcLimX1Event(command.getOverexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd2FromOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd2FromOverexcLimX1Command");

    if (efd2 == null) throw new ProcessingException("Efd2 already has nothing assigned.");

    apply(new UnAssignEfd2FromOverexcLimX1Event(command.getOverexcLimX1Id()));
  }

  @CommandHandler
  public void handle(AssignEfd3ToOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignEfd3ToOverexcLimX1Command");

    if (efd3 != null && efd3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd3ToOverexcLimX1Event(command.getOverexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd3FromOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd3FromOverexcLimX1Command");

    if (efd3 == null) throw new ProcessingException("Efd3 already has nothing assigned.");

    apply(new UnAssignEfd3FromOverexcLimX1Event(command.getOverexcLimX1Id()));
  }

  @CommandHandler
  public void handle(AssignEfddesToOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignEfddesToOverexcLimX1Command");

    if (efddes != null && efddes.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efddes already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignEfddesToOverexcLimX1Event(command.getOverexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfddesFromOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfddesFromOverexcLimX1Command");

    if (efddes == null) throw new ProcessingException("Efddes already has nothing assigned.");

    apply(new UnAssignEfddesFromOverexcLimX1Event(command.getOverexcLimX1Id()));
  }

  @CommandHandler
  public void handle(AssignEfdratedToOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignEfdratedToOverexcLimX1Command");

    if (efdrated != null && efdrated.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdrated already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignEfdratedToOverexcLimX1Event(
            command.getOverexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdratedFromOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdratedFromOverexcLimX1Command");

    if (efdrated == null) throw new ProcessingException("Efdrated already has nothing assigned.");

    apply(new UnAssignEfdratedFromOverexcLimX1Event(command.getOverexcLimX1Id()));
  }

  @CommandHandler
  public void handle(AssignKmxToOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignKmxToOverexcLimX1Command");

    if (kmx != null && kmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKmxToOverexcLimX1Event(command.getOverexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKmxFromOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKmxFromOverexcLimX1Command");

    if (kmx == null) throw new ProcessingException("Kmx already has nothing assigned.");

    apply(new UnAssignKmxFromOverexcLimX1Event(command.getOverexcLimX1Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToOverexcLimX1Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToOverexcLimX1Event(command.getOverexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromOverexcLimX1Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromOverexcLimX1Event(command.getOverexcLimX1Id()));
  }

  @CommandHandler
  public void handle(AssignT2ToOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignT2ToOverexcLimX1Command");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToOverexcLimX1Event(command.getOverexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromOverexcLimX1Command");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromOverexcLimX1Event(command.getOverexcLimX1Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToOverexcLimX1Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToOverexcLimX1Event(command.getOverexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromOverexcLimX1Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromOverexcLimX1Event(command.getOverexcLimX1Id()));
  }

  @CommandHandler
  public void handle(AssignVlowToOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignVlowToOverexcLimX1Command");

    if (vlow != null && vlow.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vlow already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVlowToOverexcLimX1Event(command.getOverexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVlowFromOverexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVlowFromOverexcLimX1Command");

    if (vlow == null) throw new ProcessingException("Vlow already has nothing assigned.");

    apply(new UnAssignVlowFromOverexcLimX1Event(command.getOverexcLimX1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateOverexcLimX1Event event) {
    LOGGER.info("Event sourcing CreateOverexcLimX1Event");
    this.overexcLimX1Id = event.getOverexcLimX1Id();
  }

  @EventSourcingHandler
  void on(UpdateOverexcLimX1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efd1 = event.getEfd1();
    this.efd2 = event.getEfd2();
    this.efd3 = event.getEfd3();
    this.efddes = event.getEfddes();
    this.efdrated = event.getEfdrated();
    this.kmx = event.getKmx();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.vlow = event.getVlow();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfd1ToOverexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignEfd1ToOverexcLimX1Event");
    this.efd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd1FromOverexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignEfd1FromOverexcLimX1Event");
    this.efd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd2ToOverexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignEfd2ToOverexcLimX1Event");
    this.efd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd2FromOverexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignEfd2FromOverexcLimX1Event");
    this.efd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd3ToOverexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignEfd3ToOverexcLimX1Event");
    this.efd3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd3FromOverexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignEfd3FromOverexcLimX1Event");
    this.efd3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfddesToOverexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignEfddesToOverexcLimX1Event");
    this.efddes = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfddesFromOverexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignEfddesFromOverexcLimX1Event");
    this.efddes = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfdratedToOverexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignEfdratedToOverexcLimX1Event");
    this.efdrated = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdratedFromOverexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignEfdratedFromOverexcLimX1Event");
    this.efdrated = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKmxToOverexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignKmxToOverexcLimX1Event");
    this.kmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKmxFromOverexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignKmxFromOverexcLimX1Event");
    this.kmx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToOverexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignT1ToOverexcLimX1Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromOverexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromOverexcLimX1Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToOverexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignT2ToOverexcLimX1Event");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromOverexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignT2FromOverexcLimX1Event");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToOverexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignT3ToOverexcLimX1Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromOverexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromOverexcLimX1Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVlowToOverexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignVlowToOverexcLimX1Event");
    this.vlow = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVlowFromOverexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignVlowFromOverexcLimX1Event");
    this.vlow = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID overexcLimX1Id;

  private PU efd1 = null;
  private PU efd2 = null;
  private PU efd3 = null;
  private PU efddes = null;
  private PU efdrated = null;
  private PU kmx = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private PU vlow = null;

  private static final Logger LOGGER = Logger.getLogger(OverexcLimX1Aggregate.class.getName());
}
