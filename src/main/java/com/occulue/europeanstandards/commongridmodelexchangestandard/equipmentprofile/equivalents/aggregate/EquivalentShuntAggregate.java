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
 * Aggregate handler for EquivalentShunt as outlined for the CQRS pattern, all write
 * responsibilities related to EquivalentShunt are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class EquivalentShuntAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public EquivalentShuntAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public EquivalentShuntAggregate(CreateEquivalentShuntCommand command) throws Exception {
    LOGGER.info("Handling command CreateEquivalentShuntCommand");
    CreateEquivalentShuntEvent event =
        new CreateEquivalentShuntEvent(command.getEquivalentShuntId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateEquivalentShuntCommand command) throws Exception {
    LOGGER.info("handling command UpdateEquivalentShuntCommand");
    UpdateEquivalentShuntEvent event =
        new UpdateEquivalentShuntEvent(
            command.getEquivalentShuntId(), command.getB(), command.getG());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteEquivalentShuntCommand command) throws Exception {
    LOGGER.info("Handling command DeleteEquivalentShuntCommand");
    apply(new DeleteEquivalentShuntEvent(command.getEquivalentShuntId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBToEquivalentShuntCommand command) throws Exception {
    LOGGER.info("Handling command AssignBToEquivalentShuntCommand");

    if (b != null && b.getSusceptanceId() == command.getAssignment().getSusceptanceId())
      throw new ProcessingException(
          "B already assigned with id " + command.getAssignment().getSusceptanceId());

    apply(
        new AssignBToEquivalentShuntEvent(command.getEquivalentShuntId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBFromEquivalentShuntCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBFromEquivalentShuntCommand");

    if (b == null) throw new ProcessingException("B already has nothing assigned.");

    apply(new UnAssignBFromEquivalentShuntEvent(command.getEquivalentShuntId()));
  }

  @CommandHandler
  public void handle(AssignGToEquivalentShuntCommand command) throws Exception {
    LOGGER.info("Handling command AssignGToEquivalentShuntCommand");

    if (g != null && g.getConductanceId() == command.getAssignment().getConductanceId())
      throw new ProcessingException(
          "G already assigned with id " + command.getAssignment().getConductanceId());

    apply(
        new AssignGToEquivalentShuntEvent(command.getEquivalentShuntId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGFromEquivalentShuntCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGFromEquivalentShuntCommand");

    if (g == null) throw new ProcessingException("G already has nothing assigned.");

    apply(new UnAssignGFromEquivalentShuntEvent(command.getEquivalentShuntId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateEquivalentShuntEvent event) {
    LOGGER.info("Event sourcing CreateEquivalentShuntEvent");
    this.equivalentShuntId = event.getEquivalentShuntId();
  }

  @EventSourcingHandler
  void on(UpdateEquivalentShuntEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.b = event.getB();
    this.g = event.getG();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBToEquivalentShuntEvent event) {
    LOGGER.info("Event sourcing AssignBToEquivalentShuntEvent");
    this.b = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBFromEquivalentShuntEvent event) {
    LOGGER.info("Event sourcing UnAssignBFromEquivalentShuntEvent");
    this.b = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGToEquivalentShuntEvent event) {
    LOGGER.info("Event sourcing AssignGToEquivalentShuntEvent");
    this.g = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGFromEquivalentShuntEvent event) {
    LOGGER.info("Event sourcing UnAssignGFromEquivalentShuntEvent");
    this.g = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID equivalentShuntId;

  private Susceptance b = null;
  private Conductance g = null;

  private static final Logger LOGGER = Logger.getLogger(EquivalentShuntAggregate.class.getName());
}
