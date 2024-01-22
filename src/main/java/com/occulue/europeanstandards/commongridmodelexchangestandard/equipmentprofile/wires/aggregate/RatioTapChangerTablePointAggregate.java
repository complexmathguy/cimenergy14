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
 * Aggregate handler for RatioTapChangerTablePoint as outlined for the CQRS pattern, all write
 * responsibilities related to RatioTapChangerTablePoint are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class RatioTapChangerTablePointAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public RatioTapChangerTablePointAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public RatioTapChangerTablePointAggregate(CreateRatioTapChangerTablePointCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateRatioTapChangerTablePointCommand");
    CreateRatioTapChangerTablePointEvent event =
        new CreateRatioTapChangerTablePointEvent(command.getRatioTapChangerTablePointId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateRatioTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("handling command UpdateRatioTapChangerTablePointCommand");
    UpdateRatioTapChangerTablePointEvent event =
        new UpdateRatioTapChangerTablePointEvent(
            command.getRatioTapChangerTablePointId(), command.getRatioTapChangerTablePoint());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteRatioTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handling command DeleteRatioTapChangerTablePointCommand");
    apply(new DeleteRatioTapChangerTablePointEvent(command.getRatioTapChangerTablePointId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignRatioTapChangerTablePointToRatioTapChangerTablePointCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignRatioTapChangerTablePointToRatioTapChangerTablePointCommand");

    if (ratioTapChangerTablePoint.contains(command.getAddTo()))
      throw new ProcessingException(
          "RatioTapChangerTablePoint already contains an entity with id "
              + command.getAddTo().getRatioTapChangerTablePointId());

    apply(
        new AssignRatioTapChangerTablePointToRatioTapChangerTablePointEvent(
            command.getRatioTapChangerTablePointId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointCommand");

    if (!ratioTapChangerTablePoint.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "RatioTapChangerTablePoint does not contain an entity with id "
              + command.getRemoveFrom().getRatioTapChangerTablePointId());

    apply(
        new RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointEvent(
            command.getRatioTapChangerTablePointId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateRatioTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing CreateRatioTapChangerTablePointEvent");
    this.ratioTapChangerTablePointId = event.getRatioTapChangerTablePointId();
  }

  @EventSourcingHandler
  void on(UpdateRatioTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ratioTapChangerTablePoint = event.getRatioTapChangerTablePoint();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignRatioTapChangerTablePointToRatioTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing AssignRatioTapChangerTablePointToRatioTapChangerTablePointEvent");
    this.ratioTapChangerTablePoint.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointEvent");
    this.ratioTapChangerTablePoint.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID ratioTapChangerTablePointId;

  private Set<RatioTapChangerTablePoint> ratioTapChangerTablePoint = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(RatioTapChangerTablePointAggregate.class.getName());
}
