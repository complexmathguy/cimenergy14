package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.aggregate;

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
 * Aggregate handler for SvPowerFlow as outlined for the CQRS pattern, all write responsibilities
 * related to SvPowerFlow are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SvPowerFlowAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SvPowerFlowAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SvPowerFlowAggregate(CreateSvPowerFlowCommand command) throws Exception {
    LOGGER.info("Handling command CreateSvPowerFlowCommand");
    CreateSvPowerFlowEvent event = new CreateSvPowerFlowEvent(command.getSvPowerFlowId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSvPowerFlowCommand command) throws Exception {
    LOGGER.info("handling command UpdateSvPowerFlowCommand");
    UpdateSvPowerFlowEvent event =
        new UpdateSvPowerFlowEvent(
            command.getSvPowerFlowId(), command.getP(), command.getQ(), command.getSvPowerFlow());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSvPowerFlowCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSvPowerFlowCommand");
    apply(new DeleteSvPowerFlowEvent(command.getSvPowerFlowId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignPToSvPowerFlowCommand command) throws Exception {
    LOGGER.info("Handling command AssignPToSvPowerFlowCommand");

    if (p != null && p.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "P already assigned with id " + command.getAssignment().getActivePowerId());

    apply(new AssignPToSvPowerFlowEvent(command.getSvPowerFlowId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPFromSvPowerFlowCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPFromSvPowerFlowCommand");

    if (p == null) throw new ProcessingException("P already has nothing assigned.");

    apply(new UnAssignPFromSvPowerFlowEvent(command.getSvPowerFlowId()));
  }

  @CommandHandler
  public void handle(AssignQToSvPowerFlowCommand command) throws Exception {
    LOGGER.info("Handling command AssignQToSvPowerFlowCommand");

    if (q != null && q.getReactivePowerId() == command.getAssignment().getReactivePowerId())
      throw new ProcessingException(
          "Q already assigned with id " + command.getAssignment().getReactivePowerId());

    apply(new AssignQToSvPowerFlowEvent(command.getSvPowerFlowId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQFromSvPowerFlowCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQFromSvPowerFlowCommand");

    if (q == null) throw new ProcessingException("Q already has nothing assigned.");

    apply(new UnAssignQFromSvPowerFlowEvent(command.getSvPowerFlowId()));
  }

  @CommandHandler
  public void handle(AssignSvPowerFlowToSvPowerFlowCommand command) throws Exception {
    LOGGER.info("Handling command AssignSvPowerFlowToSvPowerFlowCommand");

    if (svPowerFlow != null
        && svPowerFlow.getSvPowerFlowId() == command.getAssignment().getSvPowerFlowId())
      throw new ProcessingException(
          "SvPowerFlow already assigned with id " + command.getAssignment().getSvPowerFlowId());

    apply(
        new AssignSvPowerFlowToSvPowerFlowEvent(
            command.getSvPowerFlowId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSvPowerFlowFromSvPowerFlowCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSvPowerFlowFromSvPowerFlowCommand");

    if (svPowerFlow == null)
      throw new ProcessingException("SvPowerFlow already has nothing assigned.");

    apply(new UnAssignSvPowerFlowFromSvPowerFlowEvent(command.getSvPowerFlowId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSvPowerFlowEvent event) {
    LOGGER.info("Event sourcing CreateSvPowerFlowEvent");
    this.svPowerFlowId = event.getSvPowerFlowId();
  }

  @EventSourcingHandler
  void on(UpdateSvPowerFlowEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.p = event.getP();
    this.q = event.getQ();
    this.svPowerFlow = event.getSvPowerFlow();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignPToSvPowerFlowEvent event) {
    LOGGER.info("Event sourcing AssignPToSvPowerFlowEvent");
    this.p = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPFromSvPowerFlowEvent event) {
    LOGGER.info("Event sourcing UnAssignPFromSvPowerFlowEvent");
    this.p = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQToSvPowerFlowEvent event) {
    LOGGER.info("Event sourcing AssignQToSvPowerFlowEvent");
    this.q = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQFromSvPowerFlowEvent event) {
    LOGGER.info("Event sourcing UnAssignQFromSvPowerFlowEvent");
    this.q = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSvPowerFlowToSvPowerFlowEvent event) {
    LOGGER.info("Event sourcing AssignSvPowerFlowToSvPowerFlowEvent");
    this.svPowerFlow = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSvPowerFlowFromSvPowerFlowEvent event) {
    LOGGER.info("Event sourcing UnAssignSvPowerFlowFromSvPowerFlowEvent");
    this.svPowerFlow = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID svPowerFlowId;

  private ActivePower p = null;
  private ReactivePower q = null;
  private SvPowerFlow svPowerFlow = null;

  private static final Logger LOGGER = Logger.getLogger(SvPowerFlowAggregate.class.getName());
}
