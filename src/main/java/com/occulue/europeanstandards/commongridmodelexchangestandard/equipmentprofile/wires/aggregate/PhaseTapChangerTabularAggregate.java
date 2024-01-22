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
 * Aggregate handler for PhaseTapChangerTabular as outlined for the CQRS pattern, all write
 * responsibilities related to PhaseTapChangerTabular are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PhaseTapChangerTabularAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PhaseTapChangerTabularAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PhaseTapChangerTabularAggregate(CreatePhaseTapChangerTabularCommand command)
      throws Exception {
    LOGGER.info("Handling command CreatePhaseTapChangerTabularCommand");
    CreatePhaseTapChangerTabularEvent event =
        new CreatePhaseTapChangerTabularEvent(command.getPhaseTapChangerTabularId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePhaseTapChangerTabularCommand command) throws Exception {
    LOGGER.info("handling command UpdatePhaseTapChangerTabularCommand");
    UpdatePhaseTapChangerTabularEvent event =
        new UpdatePhaseTapChangerTabularEvent(
            command.getPhaseTapChangerTabularId(), command.getPhaseTapChangerTabular());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePhaseTapChangerTabularCommand command) throws Exception {
    LOGGER.info("Handling command DeletePhaseTapChangerTabularCommand");
    apply(new DeletePhaseTapChangerTabularEvent(command.getPhaseTapChangerTabularId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignPhaseTapChangerTabularToPhaseTapChangerTabularCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignPhaseTapChangerTabularToPhaseTapChangerTabularCommand");

    if (phaseTapChangerTabular.contains(command.getAddTo()))
      throw new ProcessingException(
          "PhaseTapChangerTabular already contains an entity with id "
              + command.getAddTo().getPhaseTapChangerTabularId());

    apply(
        new AssignPhaseTapChangerTabularToPhaseTapChangerTabularEvent(
            command.getPhaseTapChangerTabularId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemovePhaseTapChangerTabularFromPhaseTapChangerTabularCommand command)
      throws Exception {
    LOGGER.info("Handling command RemovePhaseTapChangerTabularFromPhaseTapChangerTabularCommand");

    if (!phaseTapChangerTabular.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "PhaseTapChangerTabular does not contain an entity with id "
              + command.getRemoveFrom().getPhaseTapChangerTabularId());

    apply(
        new RemovePhaseTapChangerTabularFromPhaseTapChangerTabularEvent(
            command.getPhaseTapChangerTabularId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePhaseTapChangerTabularEvent event) {
    LOGGER.info("Event sourcing CreatePhaseTapChangerTabularEvent");
    this.phaseTapChangerTabularId = event.getPhaseTapChangerTabularId();
  }

  @EventSourcingHandler
  void on(UpdatePhaseTapChangerTabularEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.phaseTapChangerTabular = event.getPhaseTapChangerTabular();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignPhaseTapChangerTabularToPhaseTapChangerTabularEvent event) {
    LOGGER.info("Event sourcing AssignPhaseTapChangerTabularToPhaseTapChangerTabularEvent");
    this.phaseTapChangerTabular.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemovePhaseTapChangerTabularFromPhaseTapChangerTabularEvent event) {
    LOGGER.info("Event sourcing RemovePhaseTapChangerTabularFromPhaseTapChangerTabularEvent");
    this.phaseTapChangerTabular.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID phaseTapChangerTabularId;

  private Set<PhaseTapChangerTabular> phaseTapChangerTabular = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerTabularAggregate.class.getName());
}
