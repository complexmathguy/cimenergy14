package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.aggregate;

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
 * Aggregate handler for Terminal as outlined for the CQRS pattern, all write responsibilities
 * related to Terminal are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TerminalAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TerminalAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TerminalAggregate(CreateTerminalCommand command) throws Exception {
    LOGGER.info("Handling command CreateTerminalCommand");
    CreateTerminalEvent event = new CreateTerminalEvent(command.getTerminalId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTerminalCommand command) throws Exception {
    LOGGER.info("handling command UpdateTerminalCommand");
    UpdateTerminalEvent event =
        new UpdateTerminalEvent(command.getTerminalId(), command.getTerminals());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteTerminalCommand command) throws Exception {
    LOGGER.info("Handling command DeleteTerminalCommand");
    apply(new DeleteTerminalEvent(command.getTerminalId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignTerminalsToTerminalCommand command) throws Exception {
    LOGGER.info("Handling command AssignTerminalsToTerminalCommand");

    if (terminals.contains(command.getAddTo()))
      throw new ProcessingException(
          "Terminals already contains an entity with id " + command.getAddTo().getTerminalId());

    apply(new AssignTerminalsToTerminalEvent(command.getTerminalId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveTerminalsFromTerminalCommand command) throws Exception {
    LOGGER.info("Handling command RemoveTerminalsFromTerminalCommand");

    if (!terminals.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "Terminals does not contain an entity with id "
              + command.getRemoveFrom().getTerminalId());

    apply(new RemoveTerminalsFromTerminalEvent(command.getTerminalId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTerminalEvent event) {
    LOGGER.info("Event sourcing CreateTerminalEvent");
    this.terminalId = event.getTerminalId();
  }

  @EventSourcingHandler
  void on(UpdateTerminalEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.terminals = event.getTerminals();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignTerminalsToTerminalEvent event) {
    LOGGER.info("Event sourcing AssignTerminalsToTerminalEvent");
    this.terminals.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveTerminalsFromTerminalEvent event) {
    LOGGER.info("Event sourcing RemoveTerminalsFromTerminalEvent");
    this.terminals.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID terminalId;

  private Set<Terminal> terminals = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(TerminalAggregate.class.getName());
}
