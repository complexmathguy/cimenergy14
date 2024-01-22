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
 * Aggregate handler for PhaseTapChanger as outlined for the CQRS pattern, all write
 * responsibilities related to PhaseTapChanger are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PhaseTapChangerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PhaseTapChangerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PhaseTapChangerAggregate(CreatePhaseTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command CreatePhaseTapChangerCommand");
    CreatePhaseTapChangerEvent event =
        new CreatePhaseTapChangerEvent(command.getPhaseTapChangerId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePhaseTapChangerCommand command) throws Exception {
    LOGGER.info("handling command UpdatePhaseTapChangerCommand");
    UpdatePhaseTapChangerEvent event =
        new UpdatePhaseTapChangerEvent(
            command.getPhaseTapChangerId(), command.getPhaseTapChanger());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePhaseTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command DeletePhaseTapChangerCommand");
    apply(new DeletePhaseTapChangerEvent(command.getPhaseTapChangerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignPhaseTapChangerToPhaseTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command AssignPhaseTapChangerToPhaseTapChangerCommand");

    if (phaseTapChanger != null
        && phaseTapChanger.getPhaseTapChangerId() == command.getAssignment().getPhaseTapChangerId())
      throw new ProcessingException(
          "PhaseTapChanger already assigned with id "
              + command.getAssignment().getPhaseTapChangerId());

    apply(
        new AssignPhaseTapChangerToPhaseTapChangerEvent(
            command.getPhaseTapChangerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPhaseTapChangerFromPhaseTapChangerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPhaseTapChangerFromPhaseTapChangerCommand");

    if (phaseTapChanger == null)
      throw new ProcessingException("PhaseTapChanger already has nothing assigned.");

    apply(new UnAssignPhaseTapChangerFromPhaseTapChangerEvent(command.getPhaseTapChangerId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePhaseTapChangerEvent event) {
    LOGGER.info("Event sourcing CreatePhaseTapChangerEvent");
    this.phaseTapChangerId = event.getPhaseTapChangerId();
  }

  @EventSourcingHandler
  void on(UpdatePhaseTapChangerEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.phaseTapChanger = event.getPhaseTapChanger();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignPhaseTapChangerToPhaseTapChangerEvent event) {
    LOGGER.info("Event sourcing AssignPhaseTapChangerToPhaseTapChangerEvent");
    this.phaseTapChanger = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPhaseTapChangerFromPhaseTapChangerEvent event) {
    LOGGER.info("Event sourcing UnAssignPhaseTapChangerFromPhaseTapChangerEvent");
    this.phaseTapChanger = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID phaseTapChangerId;

  private PhaseTapChanger phaseTapChanger = null;

  private static final Logger LOGGER = Logger.getLogger(PhaseTapChangerAggregate.class.getName());
}
