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
 * Aggregate handler for OverexcLimX2 as outlined for the CQRS pattern, all write responsibilities
 * related to OverexcLimX2 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class OverexcLimX2Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public OverexcLimX2Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public OverexcLimX2Aggregate(CreateOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command CreateOverexcLimX2Command");
    CreateOverexcLimX2Event event = new CreateOverexcLimX2Event(command.getOverexcLimX2Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateOverexcLimX2Command command) throws Exception {
    LOGGER.info("handling command UpdateOverexcLimX2Command");
    UpdateOverexcLimX2Event event =
        new UpdateOverexcLimX2Event(
            command.getOverexcLimX2Id(),
            command.getEfd1(),
            command.getEfd2(),
            command.getEfd3(),
            command.getEfddes(),
            command.getEfdrated(),
            command.getKmx(),
            command.getM(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getVlow());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command DeleteOverexcLimX2Command");
    apply(new DeleteOverexcLimX2Event(command.getOverexcLimX2Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfd1ToOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignEfd1ToOverexcLimX2Command");

    if (efd1 != null && efd1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd1ToOverexcLimX2Event(command.getOverexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd1FromOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd1FromOverexcLimX2Command");

    if (efd1 == null) throw new ProcessingException("Efd1 already has nothing assigned.");

    apply(new UnAssignEfd1FromOverexcLimX2Event(command.getOverexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignEfd2ToOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignEfd2ToOverexcLimX2Command");

    if (efd2 != null && efd2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd2ToOverexcLimX2Event(command.getOverexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd2FromOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd2FromOverexcLimX2Command");

    if (efd2 == null) throw new ProcessingException("Efd2 already has nothing assigned.");

    apply(new UnAssignEfd2FromOverexcLimX2Event(command.getOverexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignEfd3ToOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignEfd3ToOverexcLimX2Command");

    if (efd3 != null && efd3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efd3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfd3ToOverexcLimX2Event(command.getOverexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfd3FromOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfd3FromOverexcLimX2Command");

    if (efd3 == null) throw new ProcessingException("Efd3 already has nothing assigned.");

    apply(new UnAssignEfd3FromOverexcLimX2Event(command.getOverexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignEfddesToOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignEfddesToOverexcLimX2Command");

    if (efddes != null && efddes.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efddes already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignEfddesToOverexcLimX2Event(command.getOverexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfddesFromOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfddesFromOverexcLimX2Command");

    if (efddes == null) throw new ProcessingException("Efddes already has nothing assigned.");

    apply(new UnAssignEfddesFromOverexcLimX2Event(command.getOverexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignEfdratedToOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignEfdratedToOverexcLimX2Command");

    if (efdrated != null && efdrated.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdrated already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignEfdratedToOverexcLimX2Event(
            command.getOverexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdratedFromOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdratedFromOverexcLimX2Command");

    if (efdrated == null) throw new ProcessingException("Efdrated already has nothing assigned.");

    apply(new UnAssignEfdratedFromOverexcLimX2Event(command.getOverexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignKmxToOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignKmxToOverexcLimX2Command");

    if (kmx != null && kmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKmxToOverexcLimX2Event(command.getOverexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKmxFromOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKmxFromOverexcLimX2Command");

    if (kmx == null) throw new ProcessingException("Kmx already has nothing assigned.");

    apply(new UnAssignKmxFromOverexcLimX2Event(command.getOverexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignMToOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignMToOverexcLimX2Command");

    if (m != null && m.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "M already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignMToOverexcLimX2Event(command.getOverexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMFromOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMFromOverexcLimX2Command");

    if (m == null) throw new ProcessingException("M already has nothing assigned.");

    apply(new UnAssignMFromOverexcLimX2Event(command.getOverexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignT1ToOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignT1ToOverexcLimX2Command");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToOverexcLimX2Event(command.getOverexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromOverexcLimX2Command");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromOverexcLimX2Event(command.getOverexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignT2ToOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignT2ToOverexcLimX2Command");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToOverexcLimX2Event(command.getOverexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromOverexcLimX2Command");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromOverexcLimX2Event(command.getOverexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignT3ToOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignT3ToOverexcLimX2Command");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToOverexcLimX2Event(command.getOverexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromOverexcLimX2Command");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromOverexcLimX2Event(command.getOverexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignVlowToOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignVlowToOverexcLimX2Command");

    if (vlow != null && vlow.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vlow already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVlowToOverexcLimX2Event(command.getOverexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVlowFromOverexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVlowFromOverexcLimX2Command");

    if (vlow == null) throw new ProcessingException("Vlow already has nothing assigned.");

    apply(new UnAssignVlowFromOverexcLimX2Event(command.getOverexcLimX2Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateOverexcLimX2Event event) {
    LOGGER.info("Event sourcing CreateOverexcLimX2Event");
    this.overexcLimX2Id = event.getOverexcLimX2Id();
  }

  @EventSourcingHandler
  void on(UpdateOverexcLimX2Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efd1 = event.getEfd1();
    this.efd2 = event.getEfd2();
    this.efd3 = event.getEfd3();
    this.efddes = event.getEfddes();
    this.efdrated = event.getEfdrated();
    this.kmx = event.getKmx();
    this.m = event.getM();
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
  void on(AssignEfd1ToOverexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignEfd1ToOverexcLimX2Event");
    this.efd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd1FromOverexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignEfd1FromOverexcLimX2Event");
    this.efd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd2ToOverexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignEfd2ToOverexcLimX2Event");
    this.efd2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd2FromOverexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignEfd2FromOverexcLimX2Event");
    this.efd2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfd3ToOverexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignEfd3ToOverexcLimX2Event");
    this.efd3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfd3FromOverexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignEfd3FromOverexcLimX2Event");
    this.efd3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfddesToOverexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignEfddesToOverexcLimX2Event");
    this.efddes = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfddesFromOverexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignEfddesFromOverexcLimX2Event");
    this.efddes = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfdratedToOverexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignEfdratedToOverexcLimX2Event");
    this.efdrated = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdratedFromOverexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignEfdratedFromOverexcLimX2Event");
    this.efdrated = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKmxToOverexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignKmxToOverexcLimX2Event");
    this.kmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKmxFromOverexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignKmxFromOverexcLimX2Event");
    this.kmx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMToOverexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignMToOverexcLimX2Event");
    this.m = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMFromOverexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignMFromOverexcLimX2Event");
    this.m = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToOverexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignT1ToOverexcLimX2Event");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromOverexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignT1FromOverexcLimX2Event");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToOverexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignT2ToOverexcLimX2Event");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromOverexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignT2FromOverexcLimX2Event");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToOverexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignT3ToOverexcLimX2Event");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromOverexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignT3FromOverexcLimX2Event");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVlowToOverexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignVlowToOverexcLimX2Event");
    this.vlow = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVlowFromOverexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignVlowFromOverexcLimX2Event");
    this.vlow = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID overexcLimX2Id;

  private PU efd1 = null;
  private PU efd2 = null;
  private PU efd3 = null;
  private PU efddes = null;
  private PU efdrated = null;
  private PU kmx = null;
  private BooleanProxy m = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private PU vlow = null;

  private static final Logger LOGGER = Logger.getLogger(OverexcLimX2Aggregate.class.getName());
}
