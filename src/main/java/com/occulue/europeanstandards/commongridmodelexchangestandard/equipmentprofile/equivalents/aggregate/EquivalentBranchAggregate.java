package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.aggregate;

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
 * Aggregate handler for EquivalentBranch as outlined for the CQRS pattern, all write
 * responsibilities related to EquivalentBranch are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class EquivalentBranchAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public EquivalentBranchAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public EquivalentBranchAggregate(CreateEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command CreateEquivalentBranchCommand");
    CreateEquivalentBranchEvent event =
        new CreateEquivalentBranchEvent(command.getEquivalentBranchId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateEquivalentBranchCommand command) throws Exception {
    LOGGER.info("handling command UpdateEquivalentBranchCommand");
    UpdateEquivalentBranchEvent event =
        new UpdateEquivalentBranchEvent(
            command.getEquivalentBranchId(),
            command.getNegativeR12(),
            command.getNegativeR21(),
            command.getNegativeX12(),
            command.getNegativeX21(),
            command.getPositiveR12(),
            command.getPositiveR21(),
            command.getPositiveX12(),
            command.getPositiveX21(),
            command.getR(),
            command.getR21(),
            command.getX(),
            command.getX21(),
            command.getZeroR12(),
            command.getZeroR21(),
            command.getZeroX12(),
            command.getZeroX21());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command DeleteEquivalentBranchCommand");
    apply(new DeleteEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignNegativeR12ToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignNegativeR12ToEquivalentBranchCommand");

    if (negativeR12 != null
        && negativeR12.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "NegativeR12 already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignNegativeR12ToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNegativeR12FromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNegativeR12FromEquivalentBranchCommand");

    if (negativeR12 == null)
      throw new ProcessingException("NegativeR12 already has nothing assigned.");

    apply(new UnAssignNegativeR12FromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignNegativeR21ToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignNegativeR21ToEquivalentBranchCommand");

    if (negativeR21 != null
        && negativeR21.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "NegativeR21 already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignNegativeR21ToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNegativeR21FromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNegativeR21FromEquivalentBranchCommand");

    if (negativeR21 == null)
      throw new ProcessingException("NegativeR21 already has nothing assigned.");

    apply(new UnAssignNegativeR21FromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignNegativeX12ToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignNegativeX12ToEquivalentBranchCommand");

    if (negativeX12 != null
        && negativeX12.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "NegativeX12 already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignNegativeX12ToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNegativeX12FromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNegativeX12FromEquivalentBranchCommand");

    if (negativeX12 == null)
      throw new ProcessingException("NegativeX12 already has nothing assigned.");

    apply(new UnAssignNegativeX12FromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignNegativeX21ToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignNegativeX21ToEquivalentBranchCommand");

    if (negativeX21 != null
        && negativeX21.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "NegativeX21 already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignNegativeX21ToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNegativeX21FromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNegativeX21FromEquivalentBranchCommand");

    if (negativeX21 == null)
      throw new ProcessingException("NegativeX21 already has nothing assigned.");

    apply(new UnAssignNegativeX21FromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignPositiveR12ToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignPositiveR12ToEquivalentBranchCommand");

    if (positiveR12 != null
        && positiveR12.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "PositiveR12 already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignPositiveR12ToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPositiveR12FromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPositiveR12FromEquivalentBranchCommand");

    if (positiveR12 == null)
      throw new ProcessingException("PositiveR12 already has nothing assigned.");

    apply(new UnAssignPositiveR12FromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignPositiveR21ToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignPositiveR21ToEquivalentBranchCommand");

    if (positiveR21 != null
        && positiveR21.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "PositiveR21 already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignPositiveR21ToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPositiveR21FromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPositiveR21FromEquivalentBranchCommand");

    if (positiveR21 == null)
      throw new ProcessingException("PositiveR21 already has nothing assigned.");

    apply(new UnAssignPositiveR21FromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignPositiveX12ToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignPositiveX12ToEquivalentBranchCommand");

    if (positiveX12 != null
        && positiveX12.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "PositiveX12 already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignPositiveX12ToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPositiveX12FromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPositiveX12FromEquivalentBranchCommand");

    if (positiveX12 == null)
      throw new ProcessingException("PositiveX12 already has nothing assigned.");

    apply(new UnAssignPositiveX12FromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignPositiveX21ToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignPositiveX21ToEquivalentBranchCommand");

    if (positiveX21 != null
        && positiveX21.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "PositiveX21 already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignPositiveX21ToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPositiveX21FromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPositiveX21FromEquivalentBranchCommand");

    if (positiveX21 == null)
      throw new ProcessingException("PositiveX21 already has nothing assigned.");

    apply(new UnAssignPositiveX21FromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignRToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignRToEquivalentBranchCommand");

    if (r != null && r.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignRToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromEquivalentBranchCommand");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignR21ToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignR21ToEquivalentBranchCommand");

    if (r21 != null && r21.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R21 already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignR21ToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignR21FromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignR21FromEquivalentBranchCommand");

    if (r21 == null) throw new ProcessingException("R21 already has nothing assigned.");

    apply(new UnAssignR21FromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignXToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignXToEquivalentBranchCommand");

    if (x != null && x.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "X already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignXToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXFromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXFromEquivalentBranchCommand");

    if (x == null) throw new ProcessingException("X already has nothing assigned.");

    apply(new UnAssignXFromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignX21ToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignX21ToEquivalentBranchCommand");

    if (x21 != null && x21.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "X21 already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignX21ToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignX21FromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignX21FromEquivalentBranchCommand");

    if (x21 == null) throw new ProcessingException("X21 already has nothing assigned.");

    apply(new UnAssignX21FromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignZeroR12ToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignZeroR12ToEquivalentBranchCommand");

    if (zeroR12 != null && zeroR12.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "ZeroR12 already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignZeroR12ToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignZeroR12FromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignZeroR12FromEquivalentBranchCommand");

    if (zeroR12 == null) throw new ProcessingException("ZeroR12 already has nothing assigned.");

    apply(new UnAssignZeroR12FromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignZeroR21ToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignZeroR21ToEquivalentBranchCommand");

    if (zeroR21 != null && zeroR21.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "ZeroR21 already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignZeroR21ToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignZeroR21FromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignZeroR21FromEquivalentBranchCommand");

    if (zeroR21 == null) throw new ProcessingException("ZeroR21 already has nothing assigned.");

    apply(new UnAssignZeroR21FromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignZeroX12ToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignZeroX12ToEquivalentBranchCommand");

    if (zeroX12 != null && zeroX12.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "ZeroX12 already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignZeroX12ToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignZeroX12FromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignZeroX12FromEquivalentBranchCommand");

    if (zeroX12 == null) throw new ProcessingException("ZeroX12 already has nothing assigned.");

    apply(new UnAssignZeroX12FromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  @CommandHandler
  public void handle(AssignZeroX21ToEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handling command AssignZeroX21ToEquivalentBranchCommand");

    if (zeroX21 != null && zeroX21.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "ZeroX21 already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignZeroX21ToEquivalentBranchEvent(
            command.getEquivalentBranchId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignZeroX21FromEquivalentBranchCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignZeroX21FromEquivalentBranchCommand");

    if (zeroX21 == null) throw new ProcessingException("ZeroX21 already has nothing assigned.");

    apply(new UnAssignZeroX21FromEquivalentBranchEvent(command.getEquivalentBranchId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing CreateEquivalentBranchEvent");
    this.equivalentBranchId = event.getEquivalentBranchId();
  }

  @EventSourcingHandler
  void on(UpdateEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.negativeR12 = event.getNegativeR12();
    this.negativeR21 = event.getNegativeR21();
    this.negativeX12 = event.getNegativeX12();
    this.negativeX21 = event.getNegativeX21();
    this.positiveR12 = event.getPositiveR12();
    this.positiveR21 = event.getPositiveR21();
    this.positiveX12 = event.getPositiveX12();
    this.positiveX21 = event.getPositiveX21();
    this.r = event.getR();
    this.r21 = event.getR21();
    this.x = event.getX();
    this.x21 = event.getX21();
    this.zeroR12 = event.getZeroR12();
    this.zeroR21 = event.getZeroR21();
    this.zeroX12 = event.getZeroX12();
    this.zeroX21 = event.getZeroX21();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignNegativeR12ToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignNegativeR12ToEquivalentBranchEvent");
    this.negativeR12 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNegativeR12FromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignNegativeR12FromEquivalentBranchEvent");
    this.negativeR12 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNegativeR21ToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignNegativeR21ToEquivalentBranchEvent");
    this.negativeR21 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNegativeR21FromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignNegativeR21FromEquivalentBranchEvent");
    this.negativeR21 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNegativeX12ToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignNegativeX12ToEquivalentBranchEvent");
    this.negativeX12 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNegativeX12FromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignNegativeX12FromEquivalentBranchEvent");
    this.negativeX12 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNegativeX21ToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignNegativeX21ToEquivalentBranchEvent");
    this.negativeX21 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNegativeX21FromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignNegativeX21FromEquivalentBranchEvent");
    this.negativeX21 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPositiveR12ToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignPositiveR12ToEquivalentBranchEvent");
    this.positiveR12 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPositiveR12FromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignPositiveR12FromEquivalentBranchEvent");
    this.positiveR12 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPositiveR21ToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignPositiveR21ToEquivalentBranchEvent");
    this.positiveR21 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPositiveR21FromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignPositiveR21FromEquivalentBranchEvent");
    this.positiveR21 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPositiveX12ToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignPositiveX12ToEquivalentBranchEvent");
    this.positiveX12 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPositiveX12FromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignPositiveX12FromEquivalentBranchEvent");
    this.positiveX12 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPositiveX21ToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignPositiveX21ToEquivalentBranchEvent");
    this.positiveX21 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPositiveX21FromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignPositiveX21FromEquivalentBranchEvent");
    this.positiveX21 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignRToEquivalentBranchEvent");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignRFromEquivalentBranchEvent");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignR21ToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignR21ToEquivalentBranchEvent");
    this.r21 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignR21FromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignR21FromEquivalentBranchEvent");
    this.r21 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignXToEquivalentBranchEvent");
    this.x = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXFromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignXFromEquivalentBranchEvent");
    this.x = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignX21ToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignX21ToEquivalentBranchEvent");
    this.x21 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignX21FromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignX21FromEquivalentBranchEvent");
    this.x21 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignZeroR12ToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignZeroR12ToEquivalentBranchEvent");
    this.zeroR12 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignZeroR12FromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignZeroR12FromEquivalentBranchEvent");
    this.zeroR12 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignZeroR21ToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignZeroR21ToEquivalentBranchEvent");
    this.zeroR21 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignZeroR21FromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignZeroR21FromEquivalentBranchEvent");
    this.zeroR21 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignZeroX12ToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignZeroX12ToEquivalentBranchEvent");
    this.zeroX12 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignZeroX12FromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignZeroX12FromEquivalentBranchEvent");
    this.zeroX12 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignZeroX21ToEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing AssignZeroX21ToEquivalentBranchEvent");
    this.zeroX21 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignZeroX21FromEquivalentBranchEvent event) {
    LOGGER.info("Event sourcing UnAssignZeroX21FromEquivalentBranchEvent");
    this.zeroX21 = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID equivalentBranchId;

  private Resistance negativeR12 = null;
  private Resistance negativeR21 = null;
  private Reactance negativeX12 = null;
  private Reactance negativeX21 = null;
  private Resistance positiveR12 = null;
  private Resistance positiveR21 = null;
  private Reactance positiveX12 = null;
  private Reactance positiveX21 = null;
  private Resistance r = null;
  private Resistance r21 = null;
  private Reactance x = null;
  private Reactance x21 = null;
  private Resistance zeroR12 = null;
  private Resistance zeroR21 = null;
  private Reactance zeroX12 = null;
  private Reactance zeroX21 = null;

  private static final Logger LOGGER = Logger.getLogger(EquivalentBranchAggregate.class.getName());
}
