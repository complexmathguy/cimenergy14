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
 * Aggregate handler for PssSK as outlined for the CQRS pattern, all write responsibilities related
 * to PssSK are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PssSKAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PssSKAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PssSKAggregate(CreatePssSKCommand command) throws Exception {
    LOGGER.info("Handling command CreatePssSKCommand");
    CreatePssSKEvent event = new CreatePssSKEvent(command.getPssSKId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePssSKCommand command) throws Exception {
    LOGGER.info("handling command UpdatePssSKCommand");
    UpdatePssSKEvent event =
        new UpdatePssSKEvent(
            command.getPssSKId(),
            command.getK1(),
            command.getK2(),
            command.getK3(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getT6(),
            command.getVsmax(),
            command.getVsmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePssSKCommand command) throws Exception {
    LOGGER.info("Handling command DeletePssSKCommand");
    apply(new DeletePssSKEvent(command.getPssSKId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignK1ToPssSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignK1ToPssSKCommand");

    if (k1 != null && k1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK1ToPssSKEvent(command.getPssSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromPssSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromPssSKCommand");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromPssSKEvent(command.getPssSKId()));
  }

  @CommandHandler
  public void handle(AssignK2ToPssSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignK2ToPssSKCommand");

    if (k2 != null && k2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK2ToPssSKEvent(command.getPssSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK2FromPssSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK2FromPssSKCommand");

    if (k2 == null) throw new ProcessingException("K2 already has nothing assigned.");

    apply(new UnAssignK2FromPssSKEvent(command.getPssSKId()));
  }

  @CommandHandler
  public void handle(AssignK3ToPssSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignK3ToPssSKCommand");

    if (k3 != null && k3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK3ToPssSKEvent(command.getPssSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK3FromPssSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK3FromPssSKCommand");

    if (k3 == null) throw new ProcessingException("K3 already has nothing assigned.");

    apply(new UnAssignK3FromPssSKEvent(command.getPssSKId()));
  }

  @CommandHandler
  public void handle(AssignT1ToPssSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToPssSKCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToPssSKEvent(command.getPssSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromPssSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromPssSKCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromPssSKEvent(command.getPssSKId()));
  }

  @CommandHandler
  public void handle(AssignT2ToPssSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToPssSKCommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToPssSKEvent(command.getPssSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromPssSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromPssSKCommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromPssSKEvent(command.getPssSKId()));
  }

  @CommandHandler
  public void handle(AssignT3ToPssSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToPssSKCommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToPssSKEvent(command.getPssSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromPssSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromPssSKCommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromPssSKEvent(command.getPssSKId()));
  }

  @CommandHandler
  public void handle(AssignT4ToPssSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignT4ToPssSKCommand");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToPssSKEvent(command.getPssSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromPssSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromPssSKCommand");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromPssSKEvent(command.getPssSKId()));
  }

  @CommandHandler
  public void handle(AssignT5ToPssSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignT5ToPssSKCommand");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToPssSKEvent(command.getPssSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromPssSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromPssSKCommand");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromPssSKEvent(command.getPssSKId()));
  }

  @CommandHandler
  public void handle(AssignT6ToPssSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignT6ToPssSKCommand");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToPssSKEvent(command.getPssSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromPssSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromPssSKCommand");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromPssSKEvent(command.getPssSKId()));
  }

  @CommandHandler
  public void handle(AssignVsmaxToPssSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsmaxToPssSKCommand");

    if (vsmax != null && vsmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsmaxToPssSKEvent(command.getPssSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsmaxFromPssSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsmaxFromPssSKCommand");

    if (vsmax == null) throw new ProcessingException("Vsmax already has nothing assigned.");

    apply(new UnAssignVsmaxFromPssSKEvent(command.getPssSKId()));
  }

  @CommandHandler
  public void handle(AssignVsminToPssSKCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsminToPssSKCommand");

    if (vsmin != null && vsmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsminToPssSKEvent(command.getPssSKId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsminFromPssSKCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsminFromPssSKCommand");

    if (vsmin == null) throw new ProcessingException("Vsmin already has nothing assigned.");

    apply(new UnAssignVsminFromPssSKEvent(command.getPssSKId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePssSKEvent event) {
    LOGGER.info("Event sourcing CreatePssSKEvent");
    this.pssSKId = event.getPssSKId();
  }

  @EventSourcingHandler
  void on(UpdatePssSKEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.k1 = event.getK1();
    this.k2 = event.getK2();
    this.k3 = event.getK3();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.t6 = event.getT6();
    this.vsmax = event.getVsmax();
    this.vsmin = event.getVsmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToPssSKEvent event) {
    LOGGER.info("Event sourcing AssignK1ToPssSKEvent");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromPssSKEvent event) {
    LOGGER.info("Event sourcing UnAssignK1FromPssSKEvent");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK2ToPssSKEvent event) {
    LOGGER.info("Event sourcing AssignK2ToPssSKEvent");
    this.k2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK2FromPssSKEvent event) {
    LOGGER.info("Event sourcing UnAssignK2FromPssSKEvent");
    this.k2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK3ToPssSKEvent event) {
    LOGGER.info("Event sourcing AssignK3ToPssSKEvent");
    this.k3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK3FromPssSKEvent event) {
    LOGGER.info("Event sourcing UnAssignK3FromPssSKEvent");
    this.k3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToPssSKEvent event) {
    LOGGER.info("Event sourcing AssignT1ToPssSKEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromPssSKEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromPssSKEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToPssSKEvent event) {
    LOGGER.info("Event sourcing AssignT2ToPssSKEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromPssSKEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromPssSKEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToPssSKEvent event) {
    LOGGER.info("Event sourcing AssignT3ToPssSKEvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromPssSKEvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromPssSKEvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToPssSKEvent event) {
    LOGGER.info("Event sourcing AssignT4ToPssSKEvent");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromPssSKEvent event) {
    LOGGER.info("Event sourcing UnAssignT4FromPssSKEvent");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToPssSKEvent event) {
    LOGGER.info("Event sourcing AssignT5ToPssSKEvent");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromPssSKEvent event) {
    LOGGER.info("Event sourcing UnAssignT5FromPssSKEvent");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToPssSKEvent event) {
    LOGGER.info("Event sourcing AssignT6ToPssSKEvent");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromPssSKEvent event) {
    LOGGER.info("Event sourcing UnAssignT6FromPssSKEvent");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsmaxToPssSKEvent event) {
    LOGGER.info("Event sourcing AssignVsmaxToPssSKEvent");
    this.vsmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsmaxFromPssSKEvent event) {
    LOGGER.info("Event sourcing UnAssignVsmaxFromPssSKEvent");
    this.vsmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsminToPssSKEvent event) {
    LOGGER.info("Event sourcing AssignVsminToPssSKEvent");
    this.vsmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsminFromPssSKEvent event) {
    LOGGER.info("Event sourcing UnAssignVsminFromPssSKEvent");
    this.vsmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pssSKId;

  private PU k1 = null;
  private PU k2 = null;
  private PU k3 = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Seconds t6 = null;
  private PU vsmax = null;
  private PU vsmin = null;

  private static final Logger LOGGER = Logger.getLogger(PssSKAggregate.class.getName());
}
