package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.aggregate;

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
 * Aggregate handler for LoadStatic as outlined for the CQRS pattern, all write responsibilities
 * related to LoadStatic are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class LoadStaticAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public LoadStaticAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public LoadStaticAggregate(CreateLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command CreateLoadStaticCommand");
    CreateLoadStaticEvent event =
        new CreateLoadStaticEvent(command.getLoadStaticId(), command.getStaticLoadModelType());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateLoadStaticCommand command) throws Exception {
    LOGGER.info("handling command UpdateLoadStaticCommand");
    UpdateLoadStaticEvent event =
        new UpdateLoadStaticEvent(
            command.getLoadStaticId(),
            command.getEp1(),
            command.getEp2(),
            command.getEp3(),
            command.getEq1(),
            command.getEq2(),
            command.getEq3(),
            command.getKp1(),
            command.getKp2(),
            command.getKp3(),
            command.getKp4(),
            command.getKpf(),
            command.getKq1(),
            command.getKq2(),
            command.getKq3(),
            command.getKq4(),
            command.getKqf(),
            command.getStaticLoadModelType(),
            command.getLoadStatic());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command DeleteLoadStaticCommand");
    apply(new DeleteLoadStaticEvent(command.getLoadStaticId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEp1ToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignEp1ToLoadStaticCommand");

    if (ep1 != null && ep1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ep1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignEp1ToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEp1FromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEp1FromLoadStaticCommand");

    if (ep1 == null) throw new ProcessingException("Ep1 already has nothing assigned.");

    apply(new UnAssignEp1FromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignEp2ToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignEp2ToLoadStaticCommand");

    if (ep2 != null && ep2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ep2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignEp2ToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEp2FromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEp2FromLoadStaticCommand");

    if (ep2 == null) throw new ProcessingException("Ep2 already has nothing assigned.");

    apply(new UnAssignEp2FromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignEp3ToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignEp3ToLoadStaticCommand");

    if (ep3 != null && ep3.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ep3 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignEp3ToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEp3FromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEp3FromLoadStaticCommand");

    if (ep3 == null) throw new ProcessingException("Ep3 already has nothing assigned.");

    apply(new UnAssignEp3FromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignEq1ToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignEq1ToLoadStaticCommand");

    if (eq1 != null && eq1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Eq1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignEq1ToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEq1FromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEq1FromLoadStaticCommand");

    if (eq1 == null) throw new ProcessingException("Eq1 already has nothing assigned.");

    apply(new UnAssignEq1FromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignEq2ToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignEq2ToLoadStaticCommand");

    if (eq2 != null && eq2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Eq2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignEq2ToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEq2FromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEq2FromLoadStaticCommand");

    if (eq2 == null) throw new ProcessingException("Eq2 already has nothing assigned.");

    apply(new UnAssignEq2FromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignEq3ToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignEq3ToLoadStaticCommand");

    if (eq3 != null && eq3.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Eq3 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignEq3ToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEq3FromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEq3FromLoadStaticCommand");

    if (eq3 == null) throw new ProcessingException("Eq3 already has nothing assigned.");

    apply(new UnAssignEq3FromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignKp1ToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignKp1ToLoadStaticCommand");

    if (kp1 != null && kp1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kp1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKp1ToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKp1FromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKp1FromLoadStaticCommand");

    if (kp1 == null) throw new ProcessingException("Kp1 already has nothing assigned.");

    apply(new UnAssignKp1FromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignKp2ToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignKp2ToLoadStaticCommand");

    if (kp2 != null && kp2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kp2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKp2ToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKp2FromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKp2FromLoadStaticCommand");

    if (kp2 == null) throw new ProcessingException("Kp2 already has nothing assigned.");

    apply(new UnAssignKp2FromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignKp3ToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignKp3ToLoadStaticCommand");

    if (kp3 != null && kp3.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kp3 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKp3ToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKp3FromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKp3FromLoadStaticCommand");

    if (kp3 == null) throw new ProcessingException("Kp3 already has nothing assigned.");

    apply(new UnAssignKp3FromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignKp4ToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignKp4ToLoadStaticCommand");

    if (kp4 != null && kp4.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kp4 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKp4ToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKp4FromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKp4FromLoadStaticCommand");

    if (kp4 == null) throw new ProcessingException("Kp4 already has nothing assigned.");

    apply(new UnAssignKp4FromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignKpfToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpfToLoadStaticCommand");

    if (kpf != null && kpf.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kpf already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKpfToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpfFromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpfFromLoadStaticCommand");

    if (kpf == null) throw new ProcessingException("Kpf already has nothing assigned.");

    apply(new UnAssignKpfFromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignKq1ToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignKq1ToLoadStaticCommand");

    if (kq1 != null && kq1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kq1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKq1ToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKq1FromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKq1FromLoadStaticCommand");

    if (kq1 == null) throw new ProcessingException("Kq1 already has nothing assigned.");

    apply(new UnAssignKq1FromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignKq2ToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignKq2ToLoadStaticCommand");

    if (kq2 != null && kq2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kq2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKq2ToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKq2FromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKq2FromLoadStaticCommand");

    if (kq2 == null) throw new ProcessingException("Kq2 already has nothing assigned.");

    apply(new UnAssignKq2FromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignKq3ToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignKq3ToLoadStaticCommand");

    if (kq3 != null && kq3.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kq3 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKq3ToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKq3FromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKq3FromLoadStaticCommand");

    if (kq3 == null) throw new ProcessingException("Kq3 already has nothing assigned.");

    apply(new UnAssignKq3FromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignKq4ToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignKq4ToLoadStaticCommand");

    if (kq4 != null && kq4.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kq4 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKq4ToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKq4FromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKq4FromLoadStaticCommand");

    if (kq4 == null) throw new ProcessingException("Kq4 already has nothing assigned.");

    apply(new UnAssignKq4FromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignKqfToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignKqfToLoadStaticCommand");

    if (kqf != null && kqf.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kqf already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKqfToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKqfFromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKqfFromLoadStaticCommand");

    if (kqf == null) throw new ProcessingException("Kqf already has nothing assigned.");

    apply(new UnAssignKqfFromLoadStaticEvent(command.getLoadStaticId()));
  }

  @CommandHandler
  public void handle(AssignLoadStaticToLoadStaticCommand command) throws Exception {
    LOGGER.info("Handling command AssignLoadStaticToLoadStaticCommand");

    if (loadStatic != null
        && loadStatic.getLoadStaticId() == command.getAssignment().getLoadStaticId())
      throw new ProcessingException(
          "LoadStatic already assigned with id " + command.getAssignment().getLoadStaticId());

    apply(
        new AssignLoadStaticToLoadStaticEvent(command.getLoadStaticId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLoadStaticFromLoadStaticCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLoadStaticFromLoadStaticCommand");

    if (loadStatic == null)
      throw new ProcessingException("LoadStatic already has nothing assigned.");

    apply(new UnAssignLoadStaticFromLoadStaticEvent(command.getLoadStaticId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateLoadStaticEvent event) {
    LOGGER.info("Event sourcing CreateLoadStaticEvent");
    this.loadStaticId = event.getLoadStaticId();
    this.staticLoadModelType = event.getStaticLoadModelType();
  }

  @EventSourcingHandler
  void on(UpdateLoadStaticEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ep1 = event.getEp1();
    this.ep2 = event.getEp2();
    this.ep3 = event.getEp3();
    this.eq1 = event.getEq1();
    this.eq2 = event.getEq2();
    this.eq3 = event.getEq3();
    this.kp1 = event.getKp1();
    this.kp2 = event.getKp2();
    this.kp3 = event.getKp3();
    this.kp4 = event.getKp4();
    this.kpf = event.getKpf();
    this.kq1 = event.getKq1();
    this.kq2 = event.getKq2();
    this.kq3 = event.getKq3();
    this.kq4 = event.getKq4();
    this.kqf = event.getKqf();
    this.staticLoadModelType = event.getStaticLoadModelType();
    this.loadStatic = event.getLoadStatic();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEp1ToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignEp1ToLoadStaticEvent");
    this.ep1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEp1FromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignEp1FromLoadStaticEvent");
    this.ep1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEp2ToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignEp2ToLoadStaticEvent");
    this.ep2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEp2FromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignEp2FromLoadStaticEvent");
    this.ep2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEp3ToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignEp3ToLoadStaticEvent");
    this.ep3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEp3FromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignEp3FromLoadStaticEvent");
    this.ep3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEq1ToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignEq1ToLoadStaticEvent");
    this.eq1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEq1FromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignEq1FromLoadStaticEvent");
    this.eq1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEq2ToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignEq2ToLoadStaticEvent");
    this.eq2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEq2FromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignEq2FromLoadStaticEvent");
    this.eq2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEq3ToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignEq3ToLoadStaticEvent");
    this.eq3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEq3FromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignEq3FromLoadStaticEvent");
    this.eq3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKp1ToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignKp1ToLoadStaticEvent");
    this.kp1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKp1FromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignKp1FromLoadStaticEvent");
    this.kp1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKp2ToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignKp2ToLoadStaticEvent");
    this.kp2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKp2FromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignKp2FromLoadStaticEvent");
    this.kp2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKp3ToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignKp3ToLoadStaticEvent");
    this.kp3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKp3FromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignKp3FromLoadStaticEvent");
    this.kp3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKp4ToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignKp4ToLoadStaticEvent");
    this.kp4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKp4FromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignKp4FromLoadStaticEvent");
    this.kp4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpfToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignKpfToLoadStaticEvent");
    this.kpf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpfFromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignKpfFromLoadStaticEvent");
    this.kpf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKq1ToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignKq1ToLoadStaticEvent");
    this.kq1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKq1FromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignKq1FromLoadStaticEvent");
    this.kq1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKq2ToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignKq2ToLoadStaticEvent");
    this.kq2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKq2FromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignKq2FromLoadStaticEvent");
    this.kq2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKq3ToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignKq3ToLoadStaticEvent");
    this.kq3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKq3FromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignKq3FromLoadStaticEvent");
    this.kq3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKq4ToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignKq4ToLoadStaticEvent");
    this.kq4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKq4FromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignKq4FromLoadStaticEvent");
    this.kq4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKqfToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignKqfToLoadStaticEvent");
    this.kqf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKqfFromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignKqfFromLoadStaticEvent");
    this.kqf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLoadStaticToLoadStaticEvent event) {
    LOGGER.info("Event sourcing AssignLoadStaticToLoadStaticEvent");
    this.loadStatic = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLoadStaticFromLoadStaticEvent event) {
    LOGGER.info("Event sourcing UnAssignLoadStaticFromLoadStaticEvent");
    this.loadStatic = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID loadStaticId;

  private StaticLoadModelKind staticLoadModelType;
  private Simple_Float ep1 = null;
  private Simple_Float ep2 = null;
  private Simple_Float ep3 = null;
  private Simple_Float eq1 = null;
  private Simple_Float eq2 = null;
  private Simple_Float eq3 = null;
  private Simple_Float kp1 = null;
  private Simple_Float kp2 = null;
  private Simple_Float kp3 = null;
  private Simple_Float kp4 = null;
  private Simple_Float kpf = null;
  private Simple_Float kq1 = null;
  private Simple_Float kq2 = null;
  private Simple_Float kq3 = null;
  private Simple_Float kq4 = null;
  private Simple_Float kqf = null;
  private LoadStatic loadStatic = null;

  private static final Logger LOGGER = Logger.getLogger(LoadStaticAggregate.class.getName());
}
