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
 * Aggregate handler for LoadGenericNonLinear as outlined for the CQRS pattern, all write
 * responsibilities related to LoadGenericNonLinear are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class LoadGenericNonLinearAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public LoadGenericNonLinearAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public LoadGenericNonLinearAggregate(CreateLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handling command CreateLoadGenericNonLinearCommand");
    CreateLoadGenericNonLinearEvent event =
        new CreateLoadGenericNonLinearEvent(
            command.getLoadGenericNonLinearId(), command.getGenericNonLinearLoadModelType());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("handling command UpdateLoadGenericNonLinearCommand");
    UpdateLoadGenericNonLinearEvent event =
        new UpdateLoadGenericNonLinearEvent(
            command.getLoadGenericNonLinearId(),
            command.getBs(),
            command.getBt(),
            command.getGenericNonLinearLoadModelType(),
            command.getLs(),
            command.getLt(),
            command.getPt(),
            command.getQt(),
            command.getTp(),
            command.getTq());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handling command DeleteLoadGenericNonLinearCommand");
    apply(new DeleteLoadGenericNonLinearEvent(command.getLoadGenericNonLinearId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBsToLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handling command AssignBsToLoadGenericNonLinearCommand");

    if (bs != null && bs.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Bs already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignBsToLoadGenericNonLinearEvent(
            command.getLoadGenericNonLinearId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBsFromLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBsFromLoadGenericNonLinearCommand");

    if (bs == null) throw new ProcessingException("Bs already has nothing assigned.");

    apply(new UnAssignBsFromLoadGenericNonLinearEvent(command.getLoadGenericNonLinearId()));
  }

  @CommandHandler
  public void handle(AssignBtToLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handling command AssignBtToLoadGenericNonLinearCommand");

    if (bt != null && bt.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Bt already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignBtToLoadGenericNonLinearEvent(
            command.getLoadGenericNonLinearId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBtFromLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBtFromLoadGenericNonLinearCommand");

    if (bt == null) throw new ProcessingException("Bt already has nothing assigned.");

    apply(new UnAssignBtFromLoadGenericNonLinearEvent(command.getLoadGenericNonLinearId()));
  }

  @CommandHandler
  public void handle(AssignLsToLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handling command AssignLsToLoadGenericNonLinearCommand");

    if (ls != null && ls.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ls already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignLsToLoadGenericNonLinearEvent(
            command.getLoadGenericNonLinearId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLsFromLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLsFromLoadGenericNonLinearCommand");

    if (ls == null) throw new ProcessingException("Ls already has nothing assigned.");

    apply(new UnAssignLsFromLoadGenericNonLinearEvent(command.getLoadGenericNonLinearId()));
  }

  @CommandHandler
  public void handle(AssignLtToLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handling command AssignLtToLoadGenericNonLinearCommand");

    if (lt != null && lt.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Lt already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignLtToLoadGenericNonLinearEvent(
            command.getLoadGenericNonLinearId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLtFromLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLtFromLoadGenericNonLinearCommand");

    if (lt == null) throw new ProcessingException("Lt already has nothing assigned.");

    apply(new UnAssignLtFromLoadGenericNonLinearEvent(command.getLoadGenericNonLinearId()));
  }

  @CommandHandler
  public void handle(AssignPtToLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handling command AssignPtToLoadGenericNonLinearCommand");

    if (pt != null && pt.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Pt already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignPtToLoadGenericNonLinearEvent(
            command.getLoadGenericNonLinearId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPtFromLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPtFromLoadGenericNonLinearCommand");

    if (pt == null) throw new ProcessingException("Pt already has nothing assigned.");

    apply(new UnAssignPtFromLoadGenericNonLinearEvent(command.getLoadGenericNonLinearId()));
  }

  @CommandHandler
  public void handle(AssignQtToLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handling command AssignQtToLoadGenericNonLinearCommand");

    if (qt != null && qt.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Qt already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignQtToLoadGenericNonLinearEvent(
            command.getLoadGenericNonLinearId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQtFromLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQtFromLoadGenericNonLinearCommand");

    if (qt == null) throw new ProcessingException("Qt already has nothing assigned.");

    apply(new UnAssignQtFromLoadGenericNonLinearEvent(command.getLoadGenericNonLinearId()));
  }

  @CommandHandler
  public void handle(AssignTpToLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpToLoadGenericNonLinearCommand");

    if (tp != null && tp.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tp already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTpToLoadGenericNonLinearEvent(
            command.getLoadGenericNonLinearId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpFromLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpFromLoadGenericNonLinearCommand");

    if (tp == null) throw new ProcessingException("Tp already has nothing assigned.");

    apply(new UnAssignTpFromLoadGenericNonLinearEvent(command.getLoadGenericNonLinearId()));
  }

  @CommandHandler
  public void handle(AssignTqToLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handling command AssignTqToLoadGenericNonLinearCommand");

    if (tq != null && tq.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tq already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTqToLoadGenericNonLinearEvent(
            command.getLoadGenericNonLinearId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTqFromLoadGenericNonLinearCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTqFromLoadGenericNonLinearCommand");

    if (tq == null) throw new ProcessingException("Tq already has nothing assigned.");

    apply(new UnAssignTqFromLoadGenericNonLinearEvent(command.getLoadGenericNonLinearId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing CreateLoadGenericNonLinearEvent");
    this.loadGenericNonLinearId = event.getLoadGenericNonLinearId();
    this.genericNonLinearLoadModelType = event.getGenericNonLinearLoadModelType();
  }

  @EventSourcingHandler
  void on(UpdateLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.bs = event.getBs();
    this.bt = event.getBt();
    this.genericNonLinearLoadModelType = event.getGenericNonLinearLoadModelType();
    this.ls = event.getLs();
    this.lt = event.getLt();
    this.pt = event.getPt();
    this.qt = event.getQt();
    this.tp = event.getTp();
    this.tq = event.getTq();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBsToLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing AssignBsToLoadGenericNonLinearEvent");
    this.bs = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBsFromLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing UnAssignBsFromLoadGenericNonLinearEvent");
    this.bs = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBtToLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing AssignBtToLoadGenericNonLinearEvent");
    this.bt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBtFromLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing UnAssignBtFromLoadGenericNonLinearEvent");
    this.bt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLsToLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing AssignLsToLoadGenericNonLinearEvent");
    this.ls = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLsFromLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing UnAssignLsFromLoadGenericNonLinearEvent");
    this.ls = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLtToLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing AssignLtToLoadGenericNonLinearEvent");
    this.lt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLtFromLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing UnAssignLtFromLoadGenericNonLinearEvent");
    this.lt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPtToLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing AssignPtToLoadGenericNonLinearEvent");
    this.pt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPtFromLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing UnAssignPtFromLoadGenericNonLinearEvent");
    this.pt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQtToLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing AssignQtToLoadGenericNonLinearEvent");
    this.qt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQtFromLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing UnAssignQtFromLoadGenericNonLinearEvent");
    this.qt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpToLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing AssignTpToLoadGenericNonLinearEvent");
    this.tp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpFromLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing UnAssignTpFromLoadGenericNonLinearEvent");
    this.tp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTqToLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing AssignTqToLoadGenericNonLinearEvent");
    this.tq = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTqFromLoadGenericNonLinearEvent event) {
    LOGGER.info("Event sourcing UnAssignTqFromLoadGenericNonLinearEvent");
    this.tq = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID loadGenericNonLinearId;

  private GenericNonLinearLoadModelKind genericNonLinearLoadModelType;
  private Simple_Float bs = null;
  private Simple_Float bt = null;
  private Simple_Float ls = null;
  private Simple_Float lt = null;
  private Simple_Float pt = null;
  private Simple_Float qt = null;
  private Seconds tp = null;
  private Seconds tq = null;

  private static final Logger LOGGER =
      Logger.getLogger(LoadGenericNonLinearAggregate.class.getName());
}
