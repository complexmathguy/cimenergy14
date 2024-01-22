package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.aggregate;

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
 * Aggregate handler for DCTerminal as outlined for the CQRS pattern, all write responsibilities
 * related to DCTerminal are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DCTerminalAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DCTerminalAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DCTerminalAggregate(CreateDCTerminalCommand command) throws Exception {
    LOGGER.info("Handling command CreateDCTerminalCommand");
    CreateDCTerminalEvent event = new CreateDCTerminalEvent(command.getDCTerminalId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDCTerminalCommand command) throws Exception {
    LOGGER.info("handling command UpdateDCTerminalCommand");
    UpdateDCTerminalEvent event =
        new UpdateDCTerminalEvent(command.getDCTerminalId(), command.getDCTerminals());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDCTerminalCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDCTerminalCommand");
    apply(new DeleteDCTerminalEvent(command.getDCTerminalId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignDCTerminalsToDCTerminalCommand command) throws Exception {
    LOGGER.info("Handling command AssignDCTerminalsToDCTerminalCommand");

    if (dCTerminals.contains(command.getAddTo()))
      throw new ProcessingException(
          "DCTerminals already contains an entity with id " + command.getAddTo().getDCTerminalId());

    apply(new AssignDCTerminalsToDCTerminalEvent(command.getDCTerminalId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveDCTerminalsFromDCTerminalCommand command) throws Exception {
    LOGGER.info("Handling command RemoveDCTerminalsFromDCTerminalCommand");

    if (!dCTerminals.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "DCTerminals does not contain an entity with id "
              + command.getRemoveFrom().getDCTerminalId());

    apply(
        new RemoveDCTerminalsFromDCTerminalEvent(
            command.getDCTerminalId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDCTerminalEvent event) {
    LOGGER.info("Event sourcing CreateDCTerminalEvent");
    this.dCTerminalId = event.getDCTerminalId();
  }

  @EventSourcingHandler
  void on(UpdateDCTerminalEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dCTerminals = event.getDCTerminals();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignDCTerminalsToDCTerminalEvent event) {
    LOGGER.info("Event sourcing AssignDCTerminalsToDCTerminalEvent");
    this.dCTerminals.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveDCTerminalsFromDCTerminalEvent event) {
    LOGGER.info("Event sourcing RemoveDCTerminalsFromDCTerminalEvent");
    this.dCTerminals.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID dCTerminalId;

  private Set<DCTerminal> dCTerminals = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(DCTerminalAggregate.class.getName());
}
