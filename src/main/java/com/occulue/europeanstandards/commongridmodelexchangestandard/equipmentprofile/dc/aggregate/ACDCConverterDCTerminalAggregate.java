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
 * Aggregate handler for ACDCConverterDCTerminal as outlined for the CQRS pattern, all write
 * responsibilities related to ACDCConverterDCTerminal are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ACDCConverterDCTerminalAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ACDCConverterDCTerminalAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ACDCConverterDCTerminalAggregate(CreateACDCConverterDCTerminalCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateACDCConverterDCTerminalCommand");
    CreateACDCConverterDCTerminalEvent event =
        new CreateACDCConverterDCTerminalEvent(
            command.getACDCConverterDCTerminalId(), command.getPolarity());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateACDCConverterDCTerminalCommand command) throws Exception {
    LOGGER.info("handling command UpdateACDCConverterDCTerminalCommand");
    UpdateACDCConverterDCTerminalEvent event =
        new UpdateACDCConverterDCTerminalEvent(
            command.getACDCConverterDCTerminalId(),
            command.getPolarity(),
            command.getDCTerminals());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteACDCConverterDCTerminalCommand command) throws Exception {
    LOGGER.info("Handling command DeleteACDCConverterDCTerminalCommand");
    apply(new DeleteACDCConverterDCTerminalEvent(command.getACDCConverterDCTerminalId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignDCTerminalsToACDCConverterDCTerminalCommand command) throws Exception {
    LOGGER.info("Handling command AssignDCTerminalsToACDCConverterDCTerminalCommand");

    if (dCTerminals.contains(command.getAddTo()))
      throw new ProcessingException(
          "DCTerminals already contains an entity with id "
              + command.getAddTo().getACDCConverterDCTerminalId());

    apply(
        new AssignDCTerminalsToACDCConverterDCTerminalEvent(
            command.getACDCConverterDCTerminalId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveDCTerminalsFromACDCConverterDCTerminalCommand command) throws Exception {
    LOGGER.info("Handling command RemoveDCTerminalsFromACDCConverterDCTerminalCommand");

    if (!dCTerminals.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "DCTerminals does not contain an entity with id "
              + command.getRemoveFrom().getACDCConverterDCTerminalId());

    apply(
        new RemoveDCTerminalsFromACDCConverterDCTerminalEvent(
            command.getACDCConverterDCTerminalId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateACDCConverterDCTerminalEvent event) {
    LOGGER.info("Event sourcing CreateACDCConverterDCTerminalEvent");
    this.aCDCConverterDCTerminalId = event.getACDCConverterDCTerminalId();
    this.polarity = event.getPolarity();
  }

  @EventSourcingHandler
  void on(UpdateACDCConverterDCTerminalEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.polarity = event.getPolarity();
    this.dCTerminals = event.getDCTerminals();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignDCTerminalsToACDCConverterDCTerminalEvent event) {
    LOGGER.info("Event sourcing AssignDCTerminalsToACDCConverterDCTerminalEvent");
    this.dCTerminals.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveDCTerminalsFromACDCConverterDCTerminalEvent event) {
    LOGGER.info("Event sourcing RemoveDCTerminalsFromACDCConverterDCTerminalEvent");
    this.dCTerminals.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID aCDCConverterDCTerminalId;

  private DCPolarityKind polarity;
  private Set<ACDCConverterDCTerminal> dCTerminals = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(ACDCConverterDCTerminalAggregate.class.getName());
}
