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
 * Aggregate handler for DCBaseTerminal as outlined for the CQRS pattern, all write responsibilities
 * related to DCBaseTerminal are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DCBaseTerminalAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DCBaseTerminalAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DCBaseTerminalAggregate(CreateDCBaseTerminalCommand command) throws Exception {
    LOGGER.info("Handling command CreateDCBaseTerminalCommand");
    CreateDCBaseTerminalEvent event = new CreateDCBaseTerminalEvent(command.getDCBaseTerminalId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDCBaseTerminalCommand command) throws Exception {
    LOGGER.info("handling command UpdateDCBaseTerminalCommand");
    UpdateDCBaseTerminalEvent event =
        new UpdateDCBaseTerminalEvent(command.getDCBaseTerminalId(), command.getDCTerminals());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDCBaseTerminalCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDCBaseTerminalCommand");
    apply(new DeleteDCBaseTerminalEvent(command.getDCBaseTerminalId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignDCTerminalsToDCBaseTerminalCommand command) throws Exception {
    LOGGER.info("Handling command AssignDCTerminalsToDCBaseTerminalCommand");

    if (dCTerminals.contains(command.getAddTo()))
      throw new ProcessingException(
          "DCTerminals already contains an entity with id "
              + command.getAddTo().getDCBaseTerminalId());

    apply(
        new AssignDCTerminalsToDCBaseTerminalEvent(
            command.getDCBaseTerminalId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveDCTerminalsFromDCBaseTerminalCommand command) throws Exception {
    LOGGER.info("Handling command RemoveDCTerminalsFromDCBaseTerminalCommand");

    if (!dCTerminals.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "DCTerminals does not contain an entity with id "
              + command.getRemoveFrom().getDCBaseTerminalId());

    apply(
        new RemoveDCTerminalsFromDCBaseTerminalEvent(
            command.getDCBaseTerminalId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDCBaseTerminalEvent event) {
    LOGGER.info("Event sourcing CreateDCBaseTerminalEvent");
    this.dCBaseTerminalId = event.getDCBaseTerminalId();
  }

  @EventSourcingHandler
  void on(UpdateDCBaseTerminalEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dCTerminals = event.getDCTerminals();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignDCTerminalsToDCBaseTerminalEvent event) {
    LOGGER.info("Event sourcing AssignDCTerminalsToDCBaseTerminalEvent");
    this.dCTerminals.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveDCTerminalsFromDCBaseTerminalEvent event) {
    LOGGER.info("Event sourcing RemoveDCTerminalsFromDCBaseTerminalEvent");
    this.dCTerminals.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID dCBaseTerminalId;

  private Set<DCBaseTerminal> dCTerminals = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(DCBaseTerminalAggregate.class.getName());
}
