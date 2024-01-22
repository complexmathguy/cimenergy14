package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.aggregate;

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
 * Aggregate handler for AccumulatorReset as outlined for the CQRS pattern, all write
 * responsibilities related to AccumulatorReset are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AccumulatorResetAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AccumulatorResetAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AccumulatorResetAggregate(CreateAccumulatorResetCommand command) throws Exception {
    LOGGER.info("Handling command CreateAccumulatorResetCommand");
    CreateAccumulatorResetEvent event =
        new CreateAccumulatorResetEvent(command.getAccumulatorResetId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAccumulatorResetCommand command) throws Exception {
    LOGGER.info("handling command UpdateAccumulatorResetCommand");
    UpdateAccumulatorResetEvent event =
        new UpdateAccumulatorResetEvent(
            command.getAccumulatorResetId(), command.getAccumulatorReset());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAccumulatorResetCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAccumulatorResetCommand");
    apply(new DeleteAccumulatorResetEvent(command.getAccumulatorResetId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAccumulatorResetToAccumulatorResetCommand command) throws Exception {
    LOGGER.info("Handling command AssignAccumulatorResetToAccumulatorResetCommand");

    if (accumulatorReset != null
        && accumulatorReset.getAccumulatorResetId()
            == command.getAssignment().getAccumulatorResetId())
      throw new ProcessingException(
          "AccumulatorReset already assigned with id "
              + command.getAssignment().getAccumulatorResetId());

    apply(
        new AssignAccumulatorResetToAccumulatorResetEvent(
            command.getAccumulatorResetId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAccumulatorResetFromAccumulatorResetCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAccumulatorResetFromAccumulatorResetCommand");

    if (accumulatorReset == null)
      throw new ProcessingException("AccumulatorReset already has nothing assigned.");

    apply(new UnAssignAccumulatorResetFromAccumulatorResetEvent(command.getAccumulatorResetId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAccumulatorResetEvent event) {
    LOGGER.info("Event sourcing CreateAccumulatorResetEvent");
    this.accumulatorResetId = event.getAccumulatorResetId();
  }

  @EventSourcingHandler
  void on(UpdateAccumulatorResetEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.accumulatorReset = event.getAccumulatorReset();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAccumulatorResetToAccumulatorResetEvent event) {
    LOGGER.info("Event sourcing AssignAccumulatorResetToAccumulatorResetEvent");
    this.accumulatorReset = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAccumulatorResetFromAccumulatorResetEvent event) {
    LOGGER.info("Event sourcing UnAssignAccumulatorResetFromAccumulatorResetEvent");
    this.accumulatorReset = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID accumulatorResetId;

  private AccumulatorReset accumulatorReset = null;

  private static final Logger LOGGER = Logger.getLogger(AccumulatorResetAggregate.class.getName());
}
