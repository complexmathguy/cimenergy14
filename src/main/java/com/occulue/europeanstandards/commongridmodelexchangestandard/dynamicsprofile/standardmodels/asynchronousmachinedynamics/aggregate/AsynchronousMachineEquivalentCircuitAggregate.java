package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.asynchronousmachinedynamics.aggregate;

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
 * Aggregate handler for AsynchronousMachineEquivalentCircuit as outlined for the CQRS pattern, all
 * write responsibilities related to AsynchronousMachineEquivalentCircuit are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AsynchronousMachineEquivalentCircuitAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AsynchronousMachineEquivalentCircuitAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AsynchronousMachineEquivalentCircuitAggregate(
      CreateAsynchronousMachineEquivalentCircuitCommand command) throws Exception {
    LOGGER.info("Handling command CreateAsynchronousMachineEquivalentCircuitCommand");
    CreateAsynchronousMachineEquivalentCircuitEvent event =
        new CreateAsynchronousMachineEquivalentCircuitEvent(
            command.getAsynchronousMachineEquivalentCircuitId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAsynchronousMachineEquivalentCircuitCommand command) throws Exception {
    LOGGER.info("handling command UpdateAsynchronousMachineEquivalentCircuitCommand");
    UpdateAsynchronousMachineEquivalentCircuitEvent event =
        new UpdateAsynchronousMachineEquivalentCircuitEvent(
            command.getAsynchronousMachineEquivalentCircuitId(),
            command.getRr1(),
            command.getRr2(),
            command.getXlr1(),
            command.getXlr2(),
            command.getXm());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAsynchronousMachineEquivalentCircuitCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAsynchronousMachineEquivalentCircuitCommand");
    apply(
        new DeleteAsynchronousMachineEquivalentCircuitEvent(
            command.getAsynchronousMachineEquivalentCircuitId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignRr1ToAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignRr1ToAsynchronousMachineEquivalentCircuitCommand");

    if (rr1 != null && rr1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rr1 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignRr1ToAsynchronousMachineEquivalentCircuitEvent(
            command.getAsynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRr1FromAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignRr1FromAsynchronousMachineEquivalentCircuitCommand");

    if (rr1 == null) throw new ProcessingException("Rr1 already has nothing assigned.");

    apply(
        new UnAssignRr1FromAsynchronousMachineEquivalentCircuitEvent(
            command.getAsynchronousMachineEquivalentCircuitId()));
  }

  @CommandHandler
  public void handle(AssignRr2ToAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignRr2ToAsynchronousMachineEquivalentCircuitCommand");

    if (rr2 != null && rr2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rr2 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignRr2ToAsynchronousMachineEquivalentCircuitEvent(
            command.getAsynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRr2FromAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignRr2FromAsynchronousMachineEquivalentCircuitCommand");

    if (rr2 == null) throw new ProcessingException("Rr2 already has nothing assigned.");

    apply(
        new UnAssignRr2FromAsynchronousMachineEquivalentCircuitEvent(
            command.getAsynchronousMachineEquivalentCircuitId()));
  }

  @CommandHandler
  public void handle(AssignXlr1ToAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignXlr1ToAsynchronousMachineEquivalentCircuitCommand");

    if (xlr1 != null && xlr1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xlr1 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXlr1ToAsynchronousMachineEquivalentCircuitEvent(
            command.getAsynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXlr1FromAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignXlr1FromAsynchronousMachineEquivalentCircuitCommand");

    if (xlr1 == null) throw new ProcessingException("Xlr1 already has nothing assigned.");

    apply(
        new UnAssignXlr1FromAsynchronousMachineEquivalentCircuitEvent(
            command.getAsynchronousMachineEquivalentCircuitId()));
  }

  @CommandHandler
  public void handle(AssignXlr2ToAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignXlr2ToAsynchronousMachineEquivalentCircuitCommand");

    if (xlr2 != null && xlr2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xlr2 already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXlr2ToAsynchronousMachineEquivalentCircuitEvent(
            command.getAsynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXlr2FromAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignXlr2FromAsynchronousMachineEquivalentCircuitCommand");

    if (xlr2 == null) throw new ProcessingException("Xlr2 already has nothing assigned.");

    apply(
        new UnAssignXlr2FromAsynchronousMachineEquivalentCircuitEvent(
            command.getAsynchronousMachineEquivalentCircuitId()));
  }

  @CommandHandler
  public void handle(AssignXmToAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignXmToAsynchronousMachineEquivalentCircuitCommand");

    if (xm != null && xm.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xm already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXmToAsynchronousMachineEquivalentCircuitEvent(
            command.getAsynchronousMachineEquivalentCircuitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXmFromAsynchronousMachineEquivalentCircuitCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignXmFromAsynchronousMachineEquivalentCircuitCommand");

    if (xm == null) throw new ProcessingException("Xm already has nothing assigned.");

    apply(
        new UnAssignXmFromAsynchronousMachineEquivalentCircuitEvent(
            command.getAsynchronousMachineEquivalentCircuitId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing CreateAsynchronousMachineEquivalentCircuitEvent");
    this.asynchronousMachineEquivalentCircuitId = event.getAsynchronousMachineEquivalentCircuitId();
  }

  @EventSourcingHandler
  void on(UpdateAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.rr1 = event.getRr1();
    this.rr2 = event.getRr2();
    this.xlr1 = event.getXlr1();
    this.xlr2 = event.getXlr2();
    this.xm = event.getXm();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignRr1ToAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignRr1ToAsynchronousMachineEquivalentCircuitEvent");
    this.rr1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRr1FromAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignRr1FromAsynchronousMachineEquivalentCircuitEvent");
    this.rr1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRr2ToAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignRr2ToAsynchronousMachineEquivalentCircuitEvent");
    this.rr2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRr2FromAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignRr2FromAsynchronousMachineEquivalentCircuitEvent");
    this.rr2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXlr1ToAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignXlr1ToAsynchronousMachineEquivalentCircuitEvent");
    this.xlr1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXlr1FromAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignXlr1FromAsynchronousMachineEquivalentCircuitEvent");
    this.xlr1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXlr2ToAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignXlr2ToAsynchronousMachineEquivalentCircuitEvent");
    this.xlr2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXlr2FromAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignXlr2FromAsynchronousMachineEquivalentCircuitEvent");
    this.xlr2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXmToAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing AssignXmToAsynchronousMachineEquivalentCircuitEvent");
    this.xm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXmFromAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("Event sourcing UnAssignXmFromAsynchronousMachineEquivalentCircuitEvent");
    this.xm = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID asynchronousMachineEquivalentCircuitId;

  private PU rr1 = null;
  private PU rr2 = null;
  private PU xlr1 = null;
  private PU xlr2 = null;
  private PU xm = null;

  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineEquivalentCircuitAggregate.class.getName());
}
