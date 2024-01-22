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
 * Aggregate handler for PssELIN2 as outlined for the CQRS pattern, all write responsibilities
 * related to PssELIN2 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PssELIN2Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PssELIN2Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PssELIN2Aggregate(CreatePssELIN2Command command) throws Exception {
    LOGGER.info("Handling command CreatePssELIN2Command");
    CreatePssELIN2Event event = new CreatePssELIN2Event(command.getPssELIN2Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePssELIN2Command command) throws Exception {
    LOGGER.info("handling command UpdatePssELIN2Command");
    UpdatePssELIN2Event event =
        new UpdatePssELIN2Event(
            command.getPssELIN2Id(),
            command.getApss(),
            command.getKs1(),
            command.getKs2(),
            command.getPpss(),
            command.getPsslim(),
            command.getTs1(),
            command.getTs2(),
            command.getTs3(),
            command.getTs4(),
            command.getTs5(),
            command.getTs6());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePssELIN2Command command) throws Exception {
    LOGGER.info("Handling command DeletePssELIN2Command");
    apply(new DeletePssELIN2Event(command.getPssELIN2Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignApssToPssELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignApssToPssELIN2Command");

    if (apss != null && apss.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Apss already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignApssToPssELIN2Event(command.getPssELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignApssFromPssELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignApssFromPssELIN2Command");

    if (apss == null) throw new ProcessingException("Apss already has nothing assigned.");

    apply(new UnAssignApssFromPssELIN2Event(command.getPssELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignKs1ToPssELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignKs1ToPssELIN2Command");

    if (ks1 != null && ks1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKs1ToPssELIN2Event(command.getPssELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKs1FromPssELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKs1FromPssELIN2Command");

    if (ks1 == null) throw new ProcessingException("Ks1 already has nothing assigned.");

    apply(new UnAssignKs1FromPssELIN2Event(command.getPssELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignKs2ToPssELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignKs2ToPssELIN2Command");

    if (ks2 != null && ks2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKs2ToPssELIN2Event(command.getPssELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKs2FromPssELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKs2FromPssELIN2Command");

    if (ks2 == null) throw new ProcessingException("Ks2 already has nothing assigned.");

    apply(new UnAssignKs2FromPssELIN2Event(command.getPssELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignPpssToPssELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignPpssToPssELIN2Command");

    if (ppss != null && ppss.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ppss already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPpssToPssELIN2Event(command.getPssELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPpssFromPssELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPpssFromPssELIN2Command");

    if (ppss == null) throw new ProcessingException("Ppss already has nothing assigned.");

    apply(new UnAssignPpssFromPssELIN2Event(command.getPssELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignPsslimToPssELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignPsslimToPssELIN2Command");

    if (psslim != null && psslim.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Psslim already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPsslimToPssELIN2Event(command.getPssELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPsslimFromPssELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPsslimFromPssELIN2Command");

    if (psslim == null) throw new ProcessingException("Psslim already has nothing assigned.");

    apply(new UnAssignPsslimFromPssELIN2Event(command.getPssELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignTs1ToPssELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignTs1ToPssELIN2Command");

    if (ts1 != null && ts1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ts1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTs1ToPssELIN2Event(command.getPssELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTs1FromPssELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTs1FromPssELIN2Command");

    if (ts1 == null) throw new ProcessingException("Ts1 already has nothing assigned.");

    apply(new UnAssignTs1FromPssELIN2Event(command.getPssELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignTs2ToPssELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignTs2ToPssELIN2Command");

    if (ts2 != null && ts2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ts2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTs2ToPssELIN2Event(command.getPssELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTs2FromPssELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTs2FromPssELIN2Command");

    if (ts2 == null) throw new ProcessingException("Ts2 already has nothing assigned.");

    apply(new UnAssignTs2FromPssELIN2Event(command.getPssELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignTs3ToPssELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignTs3ToPssELIN2Command");

    if (ts3 != null && ts3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ts3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTs3ToPssELIN2Event(command.getPssELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTs3FromPssELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTs3FromPssELIN2Command");

    if (ts3 == null) throw new ProcessingException("Ts3 already has nothing assigned.");

    apply(new UnAssignTs3FromPssELIN2Event(command.getPssELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignTs4ToPssELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignTs4ToPssELIN2Command");

    if (ts4 != null && ts4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ts4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTs4ToPssELIN2Event(command.getPssELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTs4FromPssELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTs4FromPssELIN2Command");

    if (ts4 == null) throw new ProcessingException("Ts4 already has nothing assigned.");

    apply(new UnAssignTs4FromPssELIN2Event(command.getPssELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignTs5ToPssELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignTs5ToPssELIN2Command");

    if (ts5 != null && ts5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ts5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTs5ToPssELIN2Event(command.getPssELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTs5FromPssELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTs5FromPssELIN2Command");

    if (ts5 == null) throw new ProcessingException("Ts5 already has nothing assigned.");

    apply(new UnAssignTs5FromPssELIN2Event(command.getPssELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignTs6ToPssELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignTs6ToPssELIN2Command");

    if (ts6 != null && ts6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ts6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTs6ToPssELIN2Event(command.getPssELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTs6FromPssELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTs6FromPssELIN2Command");

    if (ts6 == null) throw new ProcessingException("Ts6 already has nothing assigned.");

    apply(new UnAssignTs6FromPssELIN2Event(command.getPssELIN2Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePssELIN2Event event) {
    LOGGER.info("Event sourcing CreatePssELIN2Event");
    this.pssELIN2Id = event.getPssELIN2Id();
  }

  @EventSourcingHandler
  void on(UpdatePssELIN2Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.apss = event.getApss();
    this.ks1 = event.getKs1();
    this.ks2 = event.getKs2();
    this.ppss = event.getPpss();
    this.psslim = event.getPsslim();
    this.ts1 = event.getTs1();
    this.ts2 = event.getTs2();
    this.ts3 = event.getTs3();
    this.ts4 = event.getTs4();
    this.ts5 = event.getTs5();
    this.ts6 = event.getTs6();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignApssToPssELIN2Event event) {
    LOGGER.info("Event sourcing AssignApssToPssELIN2Event");
    this.apss = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignApssFromPssELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignApssFromPssELIN2Event");
    this.apss = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKs1ToPssELIN2Event event) {
    LOGGER.info("Event sourcing AssignKs1ToPssELIN2Event");
    this.ks1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKs1FromPssELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignKs1FromPssELIN2Event");
    this.ks1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKs2ToPssELIN2Event event) {
    LOGGER.info("Event sourcing AssignKs2ToPssELIN2Event");
    this.ks2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKs2FromPssELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignKs2FromPssELIN2Event");
    this.ks2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPpssToPssELIN2Event event) {
    LOGGER.info("Event sourcing AssignPpssToPssELIN2Event");
    this.ppss = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPpssFromPssELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignPpssFromPssELIN2Event");
    this.ppss = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPsslimToPssELIN2Event event) {
    LOGGER.info("Event sourcing AssignPsslimToPssELIN2Event");
    this.psslim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPsslimFromPssELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignPsslimFromPssELIN2Event");
    this.psslim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTs1ToPssELIN2Event event) {
    LOGGER.info("Event sourcing AssignTs1ToPssELIN2Event");
    this.ts1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTs1FromPssELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignTs1FromPssELIN2Event");
    this.ts1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTs2ToPssELIN2Event event) {
    LOGGER.info("Event sourcing AssignTs2ToPssELIN2Event");
    this.ts2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTs2FromPssELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignTs2FromPssELIN2Event");
    this.ts2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTs3ToPssELIN2Event event) {
    LOGGER.info("Event sourcing AssignTs3ToPssELIN2Event");
    this.ts3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTs3FromPssELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignTs3FromPssELIN2Event");
    this.ts3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTs4ToPssELIN2Event event) {
    LOGGER.info("Event sourcing AssignTs4ToPssELIN2Event");
    this.ts4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTs4FromPssELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignTs4FromPssELIN2Event");
    this.ts4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTs5ToPssELIN2Event event) {
    LOGGER.info("Event sourcing AssignTs5ToPssELIN2Event");
    this.ts5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTs5FromPssELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignTs5FromPssELIN2Event");
    this.ts5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTs6ToPssELIN2Event event) {
    LOGGER.info("Event sourcing AssignTs6ToPssELIN2Event");
    this.ts6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTs6FromPssELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignTs6FromPssELIN2Event");
    this.ts6 = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pssELIN2Id;

  private PU apss = null;
  private PU ks1 = null;
  private PU ks2 = null;
  private PU ppss = null;
  private PU psslim = null;
  private Seconds ts1 = null;
  private Seconds ts2 = null;
  private Seconds ts3 = null;
  private Seconds ts4 = null;
  private Seconds ts5 = null;
  private Seconds ts6 = null;

  private static final Logger LOGGER = Logger.getLogger(PssELIN2Aggregate.class.getName());
}
