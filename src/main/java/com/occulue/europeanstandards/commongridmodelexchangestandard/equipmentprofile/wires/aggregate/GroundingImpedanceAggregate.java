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
 * Aggregate handler for GroundingImpedance as outlined for the CQRS pattern, all write
 * responsibilities related to GroundingImpedance are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GroundingImpedanceAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GroundingImpedanceAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GroundingImpedanceAggregate(CreateGroundingImpedanceCommand command) throws Exception {
    LOGGER.info("Handling command CreateGroundingImpedanceCommand");
    CreateGroundingImpedanceEvent event =
        new CreateGroundingImpedanceEvent(command.getGroundingImpedanceId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGroundingImpedanceCommand command) throws Exception {
    LOGGER.info("handling command UpdateGroundingImpedanceCommand");
    UpdateGroundingImpedanceEvent event =
        new UpdateGroundingImpedanceEvent(command.getGroundingImpedanceId(), command.getX());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGroundingImpedanceCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGroundingImpedanceCommand");
    apply(new DeleteGroundingImpedanceEvent(command.getGroundingImpedanceId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignXToGroundingImpedanceCommand command) throws Exception {
    LOGGER.info("Handling command AssignXToGroundingImpedanceCommand");

    if (x != null && x.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "X already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignXToGroundingImpedanceEvent(
            command.getGroundingImpedanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXFromGroundingImpedanceCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXFromGroundingImpedanceCommand");

    if (x == null) throw new ProcessingException("X already has nothing assigned.");

    apply(new UnAssignXFromGroundingImpedanceEvent(command.getGroundingImpedanceId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGroundingImpedanceEvent event) {
    LOGGER.info("Event sourcing CreateGroundingImpedanceEvent");
    this.groundingImpedanceId = event.getGroundingImpedanceId();
  }

  @EventSourcingHandler
  void on(UpdateGroundingImpedanceEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.x = event.getX();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignXToGroundingImpedanceEvent event) {
    LOGGER.info("Event sourcing AssignXToGroundingImpedanceEvent");
    this.x = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXFromGroundingImpedanceEvent event) {
    LOGGER.info("Event sourcing UnAssignXFromGroundingImpedanceEvent");
    this.x = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID groundingImpedanceId;

  private Reactance x = null;

  private static final Logger LOGGER =
      Logger.getLogger(GroundingImpedanceAggregate.class.getName());
}
