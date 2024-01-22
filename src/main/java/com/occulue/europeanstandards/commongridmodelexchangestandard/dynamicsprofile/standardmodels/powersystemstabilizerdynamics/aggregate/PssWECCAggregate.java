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
 * Aggregate handler for PssWECC as outlined for the CQRS pattern, all write responsibilities
 * related to PssWECC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PssWECCAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PssWECCAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PssWECCAggregate(CreatePssWECCCommand command) throws Exception {
    LOGGER.info("Handling command CreatePssWECCCommand");
    CreatePssWECCEvent event =
        new CreatePssWECCEvent(
            command.getPssWECCId(), command.getInputSignal1Type(), command.getInputSignal2Type());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePssWECCCommand command) throws Exception {
    LOGGER.info("handling command UpdatePssWECCCommand");
    UpdatePssWECCEvent event =
        new UpdatePssWECCEvent(
            command.getPssWECCId(),
            command.getInputSignal1Type(),
            command.getInputSignal2Type(),
            command.getK1(),
            command.getK2(),
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
            command.getVcu(),
            command.getVsmax(),
            command.getVsmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePssWECCCommand command) throws Exception {
    LOGGER.info("Handling command DeletePssWECCCommand");
    apply(new DeletePssWECCEvent(command.getPssWECCId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignK1ToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignK1ToPssWECCCommand");

    if (k1 != null && k1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK1ToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromPssWECCCommand");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignK2ToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignK2ToPssWECCCommand");

    if (k2 != null && k2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK2ToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK2FromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK2FromPssWECCCommand");

    if (k2 == null) throw new ProcessingException("K2 already has nothing assigned.");

    apply(new UnAssignK2FromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignT1ToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToPssWECCCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromPssWECCCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignT10ToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT10ToPssWECCCommand");

    if (t10 != null && t10.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T10 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT10ToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT10FromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT10FromPssWECCCommand");

    if (t10 == null) throw new ProcessingException("T10 already has nothing assigned.");

    apply(new UnAssignT10FromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignT2ToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToPssWECCCommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromPssWECCCommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignT3ToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToPssWECCCommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromPssWECCCommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignT4ToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT4ToPssWECCCommand");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromPssWECCCommand");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignT5ToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT5ToPssWECCCommand");

    if (t5 != null && t5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT5ToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT5FromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT5FromPssWECCCommand");

    if (t5 == null) throw new ProcessingException("T5 already has nothing assigned.");

    apply(new UnAssignT5FromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignT6ToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT6ToPssWECCCommand");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromPssWECCCommand");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignT7ToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT7ToPssWECCCommand");

    if (t7 != null && t7.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T7 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT7ToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT7FromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT7FromPssWECCCommand");

    if (t7 == null) throw new ProcessingException("T7 already has nothing assigned.");

    apply(new UnAssignT7FromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignT8ToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT8ToPssWECCCommand");

    if (t8 != null && t8.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T8 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT8ToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT8FromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT8FromPssWECCCommand");

    if (t8 == null) throw new ProcessingException("T8 already has nothing assigned.");

    apply(new UnAssignT8FromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignT9ToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignT9ToPssWECCCommand");

    if (t9 != null && t9.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T9 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT9ToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT9FromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT9FromPssWECCCommand");

    if (t9 == null) throw new ProcessingException("T9 already has nothing assigned.");

    apply(new UnAssignT9FromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignVclToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignVclToPssWECCCommand");

    if (vcl != null && vcl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vcl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVclToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVclFromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVclFromPssWECCCommand");

    if (vcl == null) throw new ProcessingException("Vcl already has nothing assigned.");

    apply(new UnAssignVclFromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignVcuToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignVcuToPssWECCCommand");

    if (vcu != null && vcu.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vcu already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVcuToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVcuFromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVcuFromPssWECCCommand");

    if (vcu == null) throw new ProcessingException("Vcu already has nothing assigned.");

    apply(new UnAssignVcuFromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignVsmaxToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsmaxToPssWECCCommand");

    if (vsmax != null && vsmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsmaxToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsmaxFromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsmaxFromPssWECCCommand");

    if (vsmax == null) throw new ProcessingException("Vsmax already has nothing assigned.");

    apply(new UnAssignVsmaxFromPssWECCEvent(command.getPssWECCId()));
  }

  @CommandHandler
  public void handle(AssignVsminToPssWECCCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsminToPssWECCCommand");

    if (vsmin != null && vsmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsminToPssWECCEvent(command.getPssWECCId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsminFromPssWECCCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsminFromPssWECCCommand");

    if (vsmin == null) throw new ProcessingException("Vsmin already has nothing assigned.");

    apply(new UnAssignVsminFromPssWECCEvent(command.getPssWECCId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePssWECCEvent event) {
    LOGGER.info("Event sourcing CreatePssWECCEvent");
    this.pssWECCId = event.getPssWECCId();
    this.inputSignal1Type = event.getInputSignal1Type();
    this.inputSignal2Type = event.getInputSignal2Type();
  }

  @EventSourcingHandler
  void on(UpdatePssWECCEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.inputSignal1Type = event.getInputSignal1Type();
    this.inputSignal2Type = event.getInputSignal2Type();
    this.k1 = event.getK1();
    this.k2 = event.getK2();
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
    this.vsmax = event.getVsmax();
    this.vsmin = event.getVsmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignK1ToPssWECCEvent");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignK1FromPssWECCEvent");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK2ToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignK2ToPssWECCEvent");
    this.k2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK2FromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignK2FromPssWECCEvent");
    this.k2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignT1ToPssWECCEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromPssWECCEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT10ToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignT10ToPssWECCEvent");
    this.t10 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT10FromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignT10FromPssWECCEvent");
    this.t10 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignT2ToPssWECCEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromPssWECCEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignT3ToPssWECCEvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromPssWECCEvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignT4ToPssWECCEvent");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignT4FromPssWECCEvent");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT5ToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignT5ToPssWECCEvent");
    this.t5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT5FromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignT5FromPssWECCEvent");
    this.t5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignT6ToPssWECCEvent");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignT6FromPssWECCEvent");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT7ToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignT7ToPssWECCEvent");
    this.t7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT7FromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignT7FromPssWECCEvent");
    this.t7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT8ToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignT8ToPssWECCEvent");
    this.t8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT8FromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignT8FromPssWECCEvent");
    this.t8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT9ToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignT9ToPssWECCEvent");
    this.t9 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT9FromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignT9FromPssWECCEvent");
    this.t9 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVclToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignVclToPssWECCEvent");
    this.vcl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVclFromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignVclFromPssWECCEvent");
    this.vcl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVcuToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignVcuToPssWECCEvent");
    this.vcu = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVcuFromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignVcuFromPssWECCEvent");
    this.vcu = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsmaxToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignVsmaxToPssWECCEvent");
    this.vsmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsmaxFromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignVsmaxFromPssWECCEvent");
    this.vsmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsminToPssWECCEvent event) {
    LOGGER.info("Event sourcing AssignVsminToPssWECCEvent");
    this.vsmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsminFromPssWECCEvent event) {
    LOGGER.info("Event sourcing UnAssignVsminFromPssWECCEvent");
    this.vsmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pssWECCId;

  private InputSignalKind inputSignal1Type;
  private InputSignalKind inputSignal2Type;
  private PU k1 = null;
  private PU k2 = null;
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
  private PU vsmax = null;
  private PU vsmin = null;

  private static final Logger LOGGER = Logger.getLogger(PssWECCAggregate.class.getName());
}
