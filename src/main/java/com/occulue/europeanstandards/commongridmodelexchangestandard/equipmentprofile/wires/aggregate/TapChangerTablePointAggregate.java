package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.aggregate;

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
 * Aggregate handler for TapChangerTablePoint as outlined for the CQRS pattern, all write
 * responsibilities related to TapChangerTablePoint are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TapChangerTablePointAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TapChangerTablePointAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TapChangerTablePointAggregate(CreateTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handling command CreateTapChangerTablePointCommand");
    CreateTapChangerTablePointEvent event =
        new CreateTapChangerTablePointEvent(command.getTapChangerTablePointId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("handling command UpdateTapChangerTablePointCommand");
    UpdateTapChangerTablePointEvent event =
        new UpdateTapChangerTablePointEvent(
            command.getTapChangerTablePointId(),
            command.getB(),
            command.getG(),
            command.getR(),
            command.getRatio(),
            command.getStep(),
            command.getX());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handling command DeleteTapChangerTablePointCommand");
    apply(new DeleteTapChangerTablePointEvent(command.getTapChangerTablePointId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBToTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handling command AssignBToTapChangerTablePointCommand");

    if (b != null && b.getPerCentId() == command.getAssignment().getPerCentId())
      throw new ProcessingException(
          "B already assigned with id " + command.getAssignment().getPerCentId());

    apply(
        new AssignBToTapChangerTablePointEvent(
            command.getTapChangerTablePointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBFromTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBFromTapChangerTablePointCommand");

    if (b == null) throw new ProcessingException("B already has nothing assigned.");

    apply(new UnAssignBFromTapChangerTablePointEvent(command.getTapChangerTablePointId()));
  }

  @CommandHandler
  public void handle(AssignGToTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handling command AssignGToTapChangerTablePointCommand");

    if (g != null && g.getPerCentId() == command.getAssignment().getPerCentId())
      throw new ProcessingException(
          "G already assigned with id " + command.getAssignment().getPerCentId());

    apply(
        new AssignGToTapChangerTablePointEvent(
            command.getTapChangerTablePointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGFromTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGFromTapChangerTablePointCommand");

    if (g == null) throw new ProcessingException("G already has nothing assigned.");

    apply(new UnAssignGFromTapChangerTablePointEvent(command.getTapChangerTablePointId()));
  }

  @CommandHandler
  public void handle(AssignRToTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handling command AssignRToTapChangerTablePointCommand");

    if (r != null && r.getPerCentId() == command.getAssignment().getPerCentId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getPerCentId());

    apply(
        new AssignRToTapChangerTablePointEvent(
            command.getTapChangerTablePointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromTapChangerTablePointCommand");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromTapChangerTablePointEvent(command.getTapChangerTablePointId()));
  }

  @CommandHandler
  public void handle(AssignRatioToTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handling command AssignRatioToTapChangerTablePointCommand");

    if (ratio != null && ratio.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ratio already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignRatioToTapChangerTablePointEvent(
            command.getTapChangerTablePointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRatioFromTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRatioFromTapChangerTablePointCommand");

    if (ratio == null) throw new ProcessingException("Ratio already has nothing assigned.");

    apply(new UnAssignRatioFromTapChangerTablePointEvent(command.getTapChangerTablePointId()));
  }

  @CommandHandler
  public void handle(AssignStepToTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handling command AssignStepToTapChangerTablePointCommand");

    if (step != null && step.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "Step already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignStepToTapChangerTablePointEvent(
            command.getTapChangerTablePointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignStepFromTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignStepFromTapChangerTablePointCommand");

    if (step == null) throw new ProcessingException("Step already has nothing assigned.");

    apply(new UnAssignStepFromTapChangerTablePointEvent(command.getTapChangerTablePointId()));
  }

  @CommandHandler
  public void handle(AssignXToTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handling command AssignXToTapChangerTablePointCommand");

    if (x != null && x.getPerCentId() == command.getAssignment().getPerCentId())
      throw new ProcessingException(
          "X already assigned with id " + command.getAssignment().getPerCentId());

    apply(
        new AssignXToTapChangerTablePointEvent(
            command.getTapChangerTablePointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXFromTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXFromTapChangerTablePointCommand");

    if (x == null) throw new ProcessingException("X already has nothing assigned.");

    apply(new UnAssignXFromTapChangerTablePointEvent(command.getTapChangerTablePointId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing CreateTapChangerTablePointEvent");
    this.tapChangerTablePointId = event.getTapChangerTablePointId();
  }

  @EventSourcingHandler
  void on(UpdateTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.b = event.getB();
    this.g = event.getG();
    this.r = event.getR();
    this.ratio = event.getRatio();
    this.step = event.getStep();
    this.x = event.getX();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBToTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing AssignBToTapChangerTablePointEvent");
    this.b = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBFromTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing UnAssignBFromTapChangerTablePointEvent");
    this.b = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGToTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing AssignGToTapChangerTablePointEvent");
    this.g = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGFromTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing UnAssignGFromTapChangerTablePointEvent");
    this.g = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing AssignRToTapChangerTablePointEvent");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing UnAssignRFromTapChangerTablePointEvent");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRatioToTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing AssignRatioToTapChangerTablePointEvent");
    this.ratio = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRatioFromTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing UnAssignRatioFromTapChangerTablePointEvent");
    this.ratio = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignStepToTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing AssignStepToTapChangerTablePointEvent");
    this.step = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignStepFromTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing UnAssignStepFromTapChangerTablePointEvent");
    this.step = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXToTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing AssignXToTapChangerTablePointEvent");
    this.x = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXFromTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing UnAssignXFromTapChangerTablePointEvent");
    this.x = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID tapChangerTablePointId;

  private PerCent b = null;
  private PerCent g = null;
  private PerCent r = null;
  private Simple_Float ratio = null;
  private IntegerProxy step = null;
  private PerCent x = null;

  private static final Logger LOGGER =
      Logger.getLogger(TapChangerTablePointAggregate.class.getName());
}
