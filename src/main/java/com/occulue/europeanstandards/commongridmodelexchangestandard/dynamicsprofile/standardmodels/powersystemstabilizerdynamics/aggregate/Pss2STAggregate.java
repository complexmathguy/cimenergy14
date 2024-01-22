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
 * Aggregate handler for Pss2ST as outlined for the CQRS pattern, all write responsibilities related
 * to Pss2ST are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class Pss2STAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public Pss2STAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public Pss2STAggregate(CreatePss2STCommand command) throws Exception {
    LOGGER.info("Handling command CreatePss2STCommand");
    CreatePss2STEvent event =
        new CreatePss2STEvent(
            command.getPss2STId(), command.getInputSignal1Type(), command.getInputSignal2Type());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePss2STCommand command) throws Exception {
    LOGGER.info("handling command UpdatePss2STCommand");
    UpdatePss2STEvent event =
        new UpdatePss2STEvent(
            command.getPss2STId(),
            command.getInputSignal1Type(),
            command.getInputSignal2Type(),
            command.getK1(),
            command.getK2(),
            command.getLsmax(),
            command.getLsmin(),
            command.getT1(),
            command.getT10(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT5(),
            command.getT6(),
            command.getT7(),
            command.getT8(),
            command.getT9(),
            command.getVcl(),
            command.getVcu());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePss2STCommand command) throws Exception {
    LOGGER.info("Handling command DeletePss2STCommand");
    apply(new DeletePss2STEvent(command.getPss2STId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignK1ToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignK1ToPss2STCommand");

    if (k1 != null && k1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK1ToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromPss2STCommand");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignK2ToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignK2ToPss2STCommand");

    if (k2 != null && k2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK2ToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK2FromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK2FromPss2STCommand");

    if (k2 == null) throw new ProcessingException("K2 already has nothing assigned.");

    apply(new UnAssignK2FromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignLsmaxToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignLsmaxToPss2STCommand");

    if (lsmax != null && lsmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Lsmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignLsmaxToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLsmaxFromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLsmaxFromPss2STCommand");

    if (lsmax == null) throw new ProcessingException("Lsmax already has nothing assigned.");

    apply(new UnAssignLsmaxFromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignLsminToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignLsminToPss2STCommand");

    if (lsmin != null && lsmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Lsmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignLsminToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLsminFromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLsminFromPss2STCommand");

    if (lsmin == null) throw new ProcessingException("Lsmin already has nothing assigned.");

    apply(new UnAssignLsminFromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignT1ToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToPss2STCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromPss2STCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignT10ToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignT10ToPss2STCommand");

    if (t10 != null && t10.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T10 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT10ToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT10FromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT10FromPss2STCommand");

    if (t10 == null) throw new ProcessingException("T10 already has nothing assigned.");

    apply(new UnAssignT10FromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignT2ToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToPss2STCommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromPss2STCommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignT3ToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToPss2STCommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromPss2STCommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignT4ToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignT4ToPss2STCommand");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromPss2STCommand");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignT5ToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignT5ToPss2STCommand");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromPss2STCommand");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignT6ToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignT6ToPss2STCommand");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromPss2STCommand");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignT7ToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignT7ToPss2STCommand");

    if (t7 != null && t7.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T7 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT7ToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT7FromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT7FromPss2STCommand");

    if (t7 == null) throw new ProcessingException("T7 already has nothing assigned.");

    apply(new UnAssignT7FromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignT8ToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignT8ToPss2STCommand");

    if (t8 != null && t8.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T8 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT8ToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT8FromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT8FromPss2STCommand");

    if (t8 == null) throw new ProcessingException("T8 already has nothing assigned.");

    apply(new UnAssignT8FromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignT9ToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignT9ToPss2STCommand");

    if (t9 != null && t9.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T9 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT9ToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT9FromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT9FromPss2STCommand");

    if (t9 == null) throw new ProcessingException("T9 already has nothing assigned.");

    apply(new UnAssignT9FromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignVclToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignVclToPss2STCommand");

    if (vcl != null && vcl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vcl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVclToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVclFromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVclFromPss2STCommand");

    if (vcl == null) throw new ProcessingException("Vcl already has nothing assigned.");

    apply(new UnAssignVclFromPss2STEvent(command.getPss2STId()));
  }

  @CommandHandler
  public void handle(AssignVcuToPss2STCommand command) throws Exception {
    LOGGER.info("Handling command AssignVcuToPss2STCommand");

    if (vcu != null && vcu.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vcu already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVcuToPss2STEvent(command.getPss2STId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVcuFromPss2STCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVcuFromPss2STCommand");

    if (vcu == null) throw new ProcessingException("Vcu already has nothing assigned.");

    apply(new UnAssignVcuFromPss2STEvent(command.getPss2STId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePss2STEvent event) {
    LOGGER.info("Event sourcing CreatePss2STEvent");
    this.pss2STId = event.getPss2STId();
    this.inputSignal1Type = event.getInputSignal1Type();
    this.inputSignal2Type = event.getInputSignal2Type();
  }

  @EventSourcingHandler
  void on(UpdatePss2STEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.inputSignal1Type = event.getInputSignal1Type();
    this.inputSignal2Type = event.getInputSignal2Type();
    this.k1 = event.getK1();
    this.k2 = event.getK2();
    this.lsmax = event.getLsmax();
    this.lsmin = event.getLsmin();
    this.t1 = event.getT1();
    this.t10 = event.getT10();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t5 = event.getT5();
    this.t6 = event.getT6();
    this.t7 = event.getT7();
    this.t8 = event.getT8();
    this.t9 = event.getT9();
    this.vcl = event.getVcl();
    this.vcu = event.getVcu();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignK1ToPss2STEvent");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignK1FromPss2STEvent");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK2ToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignK2ToPss2STEvent");
    this.k2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK2FromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignK2FromPss2STEvent");
    this.k2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLsmaxToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignLsmaxToPss2STEvent");
    this.lsmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLsmaxFromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignLsmaxFromPss2STEvent");
    this.lsmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLsminToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignLsminToPss2STEvent");
    this.lsmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLsminFromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignLsminFromPss2STEvent");
    this.lsmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignT1ToPss2STEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromPss2STEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT10ToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignT10ToPss2STEvent");
    this.t10 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT10FromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignT10FromPss2STEvent");
    this.t10 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignT2ToPss2STEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromPss2STEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignT3ToPss2STEvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromPss2STEvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignT4ToPss2STEvent");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignT4FromPss2STEvent");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignT5ToPss2STEvent");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignT5FromPss2STEvent");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignT6ToPss2STEvent");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignT6FromPss2STEvent");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT7ToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignT7ToPss2STEvent");
    this.t7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT7FromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignT7FromPss2STEvent");
    this.t7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT8ToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignT8ToPss2STEvent");
    this.t8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT8FromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignT8FromPss2STEvent");
    this.t8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT9ToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignT9ToPss2STEvent");
    this.t9 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT9FromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignT9FromPss2STEvent");
    this.t9 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVclToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignVclToPss2STEvent");
    this.vcl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVclFromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignVclFromPss2STEvent");
    this.vcl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVcuToPss2STEvent event) {
    LOGGER.info("Event sourcing AssignVcuToPss2STEvent");
    this.vcu = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVcuFromPss2STEvent event) {
    LOGGER.info("Event sourcing UnAssignVcuFromPss2STEvent");
    this.vcu = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pss2STId;

  private InputSignalKind inputSignal1Type;
  private InputSignalKind inputSignal2Type;
  private PU k1 = null;
  private PU k2 = null;
  private PU lsmax = null;
  private PU lsmin = null;
  private Seconds t1 = null;
  private Seconds t10 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t5 = null;
  private Seconds t6 = null;
  private Seconds t7 = null;
  private Seconds t8 = null;
  private Seconds t9 = null;
  private PU vcl = null;
  private PU vcu = null;

  private static final Logger LOGGER = Logger.getLogger(Pss2STAggregate.class.getName());
}
