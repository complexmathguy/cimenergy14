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
 * Aggregate handler for ExcIEEEST5B as outlined for the CQRS pattern, all write responsibilities
 * related to ExcIEEEST5B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcIEEEST5BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcIEEEST5BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcIEEEST5BAggregate(CreateExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcIEEEST5BCommand");
    CreateExcIEEEST5BEvent event = new CreateExcIEEEST5BEvent(command.getExcIEEEST5BId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcIEEEST5BCommand");
    UpdateExcIEEEST5BEvent event =
        new UpdateExcIEEEST5BEvent(
            command.getExcIEEEST5BId(),
            command.getKc(),
            command.getKr(),
            command.getT1(),
            command.getTb1(),
            command.getTb2(),
            command.getTc1(),
            command.getTc2(),
            command.getTob1(),
            command.getTob2(),
            command.getToc1(),
            command.getToc2(),
            command.getTub1(),
            command.getTub2(),
            command.getTuc1(),
            command.getTuc2(),
            command.getVrmax(),
            command.getVrmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcIEEEST5BCommand");
    apply(new DeleteExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKcToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKcToExcIEEEST5BCommand");

    if (kc != null && kc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kc already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKcToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcFromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcFromExcIEEEST5BCommand");

    if (kc == null) throw new ProcessingException("Kc already has nothing assigned.");

    apply(new UnAssignKcFromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignKrToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKrToExcIEEEST5BCommand");

    if (kr != null && kr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kr already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKrToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKrFromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKrFromExcIEEEST5BCommand");

    if (kr == null) throw new ProcessingException("Kr already has nothing assigned.");

    apply(new UnAssignKrFromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignT1ToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToExcIEEEST5BCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromExcIEEEST5BCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignTb1ToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTb1ToExcIEEEST5BCommand");

    if (tb1 != null && tb1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTb1ToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTb1FromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTb1FromExcIEEEST5BCommand");

    if (tb1 == null) throw new ProcessingException("Tb1 already has nothing assigned.");

    apply(new UnAssignTb1FromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignTb2ToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTb2ToExcIEEEST5BCommand");

    if (tb2 != null && tb2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTb2ToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTb2FromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTb2FromExcIEEEST5BCommand");

    if (tb2 == null) throw new ProcessingException("Tb2 already has nothing assigned.");

    apply(new UnAssignTb2FromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignTc1ToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTc1ToExcIEEEST5BCommand");

    if (tc1 != null && tc1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTc1ToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTc1FromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTc1FromExcIEEEST5BCommand");

    if (tc1 == null) throw new ProcessingException("Tc1 already has nothing assigned.");

    apply(new UnAssignTc1FromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignTc2ToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTc2ToExcIEEEST5BCommand");

    if (tc2 != null && tc2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTc2ToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTc2FromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTc2FromExcIEEEST5BCommand");

    if (tc2 == null) throw new ProcessingException("Tc2 already has nothing assigned.");

    apply(new UnAssignTc2FromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignTob1ToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTob1ToExcIEEEST5BCommand");

    if (tob1 != null && tob1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tob1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTob1ToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTob1FromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTob1FromExcIEEEST5BCommand");

    if (tob1 == null) throw new ProcessingException("Tob1 already has nothing assigned.");

    apply(new UnAssignTob1FromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignTob2ToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTob2ToExcIEEEST5BCommand");

    if (tob2 != null && tob2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tob2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTob2ToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTob2FromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTob2FromExcIEEEST5BCommand");

    if (tob2 == null) throw new ProcessingException("Tob2 already has nothing assigned.");

    apply(new UnAssignTob2FromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignToc1ToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignToc1ToExcIEEEST5BCommand");

    if (toc1 != null && toc1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Toc1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignToc1ToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignToc1FromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignToc1FromExcIEEEST5BCommand");

    if (toc1 == null) throw new ProcessingException("Toc1 already has nothing assigned.");

    apply(new UnAssignToc1FromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignToc2ToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignToc2ToExcIEEEST5BCommand");

    if (toc2 != null && toc2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Toc2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignToc2ToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignToc2FromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignToc2FromExcIEEEST5BCommand");

    if (toc2 == null) throw new ProcessingException("Toc2 already has nothing assigned.");

    apply(new UnAssignToc2FromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignTub1ToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTub1ToExcIEEEST5BCommand");

    if (tub1 != null && tub1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tub1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTub1ToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTub1FromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTub1FromExcIEEEST5BCommand");

    if (tub1 == null) throw new ProcessingException("Tub1 already has nothing assigned.");

    apply(new UnAssignTub1FromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignTub2ToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTub2ToExcIEEEST5BCommand");

    if (tub2 != null && tub2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tub2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTub2ToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTub2FromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTub2FromExcIEEEST5BCommand");

    if (tub2 == null) throw new ProcessingException("Tub2 already has nothing assigned.");

    apply(new UnAssignTub2FromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignTuc1ToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTuc1ToExcIEEEST5BCommand");

    if (tuc1 != null && tuc1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tuc1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTuc1ToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTuc1FromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTuc1FromExcIEEEST5BCommand");

    if (tuc1 == null) throw new ProcessingException("Tuc1 already has nothing assigned.");

    apply(new UnAssignTuc1FromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignTuc2ToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTuc2ToExcIEEEST5BCommand");

    if (tuc2 != null && tuc2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tuc2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTuc2ToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTuc2FromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTuc2FromExcIEEEST5BCommand");

    if (tuc2 == null) throw new ProcessingException("Tuc2 already has nothing assigned.");

    apply(new UnAssignTuc2FromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignVrmaxToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmaxToExcIEEEST5BCommand");

    if (vrmax != null && vrmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmaxToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmaxFromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmaxFromExcIEEEST5BCommand");

    if (vrmax == null) throw new ProcessingException("Vrmax already has nothing assigned.");

    apply(new UnAssignVrmaxFromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  @CommandHandler
  public void handle(AssignVrminToExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrminToExcIEEEST5BCommand");

    if (vrmin != null && vrmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrminToExcIEEEST5BEvent(command.getExcIEEEST5BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrminFromExcIEEEST5BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrminFromExcIEEEST5BCommand");

    if (vrmin == null) throw new ProcessingException("Vrmin already has nothing assigned.");

    apply(new UnAssignVrminFromExcIEEEST5BEvent(command.getExcIEEEST5BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing CreateExcIEEEST5BEvent");
    this.excIEEEST5BId = event.getExcIEEEST5BId();
  }

  @EventSourcingHandler
  void on(UpdateExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.kc = event.getKc();
    this.kr = event.getKr();
    this.t1 = event.getT1();
    this.tb1 = event.getTb1();
    this.tb2 = event.getTb2();
    this.tc1 = event.getTc1();
    this.tc2 = event.getTc2();
    this.tob1 = event.getTob1();
    this.tob2 = event.getTob2();
    this.toc1 = event.getToc1();
    this.toc2 = event.getToc2();
    this.tub1 = event.getTub1();
    this.tub2 = event.getTub2();
    this.tuc1 = event.getTuc1();
    this.tuc2 = event.getTuc2();
    this.vrmax = event.getVrmax();
    this.vrmin = event.getVrmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKcToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignKcToExcIEEEST5BEvent");
    this.kc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcFromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignKcFromExcIEEEST5BEvent");
    this.kc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKrToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignKrToExcIEEEST5BEvent");
    this.kr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKrFromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignKrFromExcIEEEST5BEvent");
    this.kr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignT1ToExcIEEEST5BEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromExcIEEEST5BEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTb1ToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignTb1ToExcIEEEST5BEvent");
    this.tb1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTb1FromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignTb1FromExcIEEEST5BEvent");
    this.tb1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTb2ToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignTb2ToExcIEEEST5BEvent");
    this.tb2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTb2FromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignTb2FromExcIEEEST5BEvent");
    this.tb2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTc1ToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignTc1ToExcIEEEST5BEvent");
    this.tc1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTc1FromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignTc1FromExcIEEEST5BEvent");
    this.tc1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTc2ToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignTc2ToExcIEEEST5BEvent");
    this.tc2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTc2FromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignTc2FromExcIEEEST5BEvent");
    this.tc2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTob1ToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignTob1ToExcIEEEST5BEvent");
    this.tob1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTob1FromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignTob1FromExcIEEEST5BEvent");
    this.tob1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTob2ToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignTob2ToExcIEEEST5BEvent");
    this.tob2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTob2FromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignTob2FromExcIEEEST5BEvent");
    this.tob2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignToc1ToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignToc1ToExcIEEEST5BEvent");
    this.toc1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignToc1FromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignToc1FromExcIEEEST5BEvent");
    this.toc1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignToc2ToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignToc2ToExcIEEEST5BEvent");
    this.toc2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignToc2FromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignToc2FromExcIEEEST5BEvent");
    this.toc2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTub1ToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignTub1ToExcIEEEST5BEvent");
    this.tub1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTub1FromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignTub1FromExcIEEEST5BEvent");
    this.tub1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTub2ToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignTub2ToExcIEEEST5BEvent");
    this.tub2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTub2FromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignTub2FromExcIEEEST5BEvent");
    this.tub2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTuc1ToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignTuc1ToExcIEEEST5BEvent");
    this.tuc1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTuc1FromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignTuc1FromExcIEEEST5BEvent");
    this.tuc1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTuc2ToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignTuc2ToExcIEEEST5BEvent");
    this.tuc2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTuc2FromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignTuc2FromExcIEEEST5BEvent");
    this.tuc2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmaxToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignVrmaxToExcIEEEST5BEvent");
    this.vrmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmaxFromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmaxFromExcIEEEST5BEvent");
    this.vrmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrminToExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing AssignVrminToExcIEEEST5BEvent");
    this.vrmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrminFromExcIEEEST5BEvent event) {
    LOGGER.info("Event sourcing UnAssignVrminFromExcIEEEST5BEvent");
    this.vrmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excIEEEST5BId;

  private PU kc = null;
  private PU kr = null;
  private Seconds t1 = null;
  private Seconds tb1 = null;
  private Seconds tb2 = null;
  private Seconds tc1 = null;
  private Seconds tc2 = null;
  private Seconds tob1 = null;
  private Seconds tob2 = null;
  private Seconds toc1 = null;
  private Seconds toc2 = null;
  private Seconds tub1 = null;
  private Seconds tub2 = null;
  private Seconds tuc1 = null;
  private Seconds tuc2 = null;
  private PU vrmax = null;
  private PU vrmin = null;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST5BAggregate.class.getName());
}
