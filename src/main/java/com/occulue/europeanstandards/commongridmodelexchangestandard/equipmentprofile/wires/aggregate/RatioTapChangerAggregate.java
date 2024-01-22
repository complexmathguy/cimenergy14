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
 * Aggregate handler for RatioTapChanger as outlined for the CQRS pattern, all write
 * responsibilities related to RatioTapChanger are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class RatioTapChangerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public RatioTapChangerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public RatioTapChangerAggregate(CreateRatioTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command CreateRatioTapChangerCommand");
    CreateRatioTapChangerEvent event =
        new CreateRatioTapChangerEvent(
            command.getRatioTapChangerId(), command.getTculControlMode());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateRatioTapChangerCommand command) throws Exception {
    LOGGER.info("handling command UpdateRatioTapChangerCommand");
    UpdateRatioTapChangerEvent event =
        new UpdateRatioTapChangerEvent(
            command.getRatioTapChangerId(),
            command.getStepVoltageIncrement(),
            command.getTculControlMode(),
            command.getRatioTapChanger());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteRatioTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command DeleteRatioTapChangerCommand");
    apply(new DeleteRatioTapChangerEvent(command.getRatioTapChangerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignStepVoltageIncrementToRatioTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command AssignStepVoltageIncrementToRatioTapChangerCommand");

    if (stepVoltageIncrement != null
        && stepVoltageIncrement.getPerCentId() == command.getAssignment().getPerCentId())
      throw new ProcessingException(
          "StepVoltageIncrement already assigned with id "
              + command.getAssignment().getPerCentId());

    apply(
        new AssignStepVoltageIncrementToRatioTapChangerEvent(
            command.getRatioTapChangerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignStepVoltageIncrementFromRatioTapChangerCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignStepVoltageIncrementFromRatioTapChangerCommand");

    if (stepVoltageIncrement == null)
      throw new ProcessingException("StepVoltageIncrement already has nothing assigned.");

    apply(new UnAssignStepVoltageIncrementFromRatioTapChangerEvent(command.getRatioTapChangerId()));
  }

  @CommandHandler
  public void handle(AssignRatioTapChangerToRatioTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command AssignRatioTapChangerToRatioTapChangerCommand");

    if (ratioTapChanger != null
        && ratioTapChanger.getRatioTapChangerId() == command.getAssignment().getRatioTapChangerId())
      throw new ProcessingException(
          "RatioTapChanger already assigned with id "
              + command.getAssignment().getRatioTapChangerId());

    apply(
        new AssignRatioTapChangerToRatioTapChangerEvent(
            command.getRatioTapChangerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRatioTapChangerFromRatioTapChangerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRatioTapChangerFromRatioTapChangerCommand");

    if (ratioTapChanger == null)
      throw new ProcessingException("RatioTapChanger already has nothing assigned.");

    apply(new UnAssignRatioTapChangerFromRatioTapChangerEvent(command.getRatioTapChangerId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateRatioTapChangerEvent event) {
    LOGGER.info("Event sourcing CreateRatioTapChangerEvent");
    this.ratioTapChangerId = event.getRatioTapChangerId();
    this.tculControlMode = event.getTculControlMode();
  }

  @EventSourcingHandler
  void on(UpdateRatioTapChangerEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.stepVoltageIncrement = event.getStepVoltageIncrement();
    this.tculControlMode = event.getTculControlMode();
    this.ratioTapChanger = event.getRatioTapChanger();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignStepVoltageIncrementToRatioTapChangerEvent event) {
    LOGGER.info("Event sourcing AssignStepVoltageIncrementToRatioTapChangerEvent");
    this.stepVoltageIncrement = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignStepVoltageIncrementFromRatioTapChangerEvent event) {
    LOGGER.info("Event sourcing UnAssignStepVoltageIncrementFromRatioTapChangerEvent");
    this.stepVoltageIncrement = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRatioTapChangerToRatioTapChangerEvent event) {
    LOGGER.info("Event sourcing AssignRatioTapChangerToRatioTapChangerEvent");
    this.ratioTapChanger = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRatioTapChangerFromRatioTapChangerEvent event) {
    LOGGER.info("Event sourcing UnAssignRatioTapChangerFromRatioTapChangerEvent");
    this.ratioTapChanger = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID ratioTapChangerId;

  private TransformerControlMode tculControlMode;
  private PerCent stepVoltageIncrement = null;
  private RatioTapChanger ratioTapChanger = null;

  private static final Logger LOGGER = Logger.getLogger(RatioTapChangerAggregate.class.getName());
}
