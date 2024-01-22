package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.aggregate;

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
 * Aggregate handler for WindAeroConstIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindAeroConstIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindAeroConstIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindAeroConstIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindAeroConstIECAggregate(CreateWindAeroConstIECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindAeroConstIECCommand");
    CreateWindAeroConstIECEvent event =
        new CreateWindAeroConstIECEvent(command.getWindAeroConstIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindAeroConstIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindAeroConstIECCommand");
    UpdateWindAeroConstIECEvent event =
        new UpdateWindAeroConstIECEvent(command.getWindAeroConstIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindAeroConstIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindAeroConstIECCommand");
    apply(new DeleteWindAeroConstIECEvent(command.getWindAeroConstIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindAeroConstIECEvent event) {
    LOGGER.info("Event sourcing CreateWindAeroConstIECEvent");
    this.windAeroConstIECId = event.getWindAeroConstIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindAeroConstIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windAeroConstIECId;

  private static final Logger LOGGER = Logger.getLogger(WindAeroConstIECAggregate.class.getName());
}
