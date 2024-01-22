package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.aggregate;

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
 * Aggregate handler for GrossToNetActivePowerCurve as outlined for the CQRS pattern, all write
 * responsibilities related to GrossToNetActivePowerCurve are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GrossToNetActivePowerCurveAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GrossToNetActivePowerCurveAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GrossToNetActivePowerCurveAggregate(CreateGrossToNetActivePowerCurveCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateGrossToNetActivePowerCurveCommand");
    CreateGrossToNetActivePowerCurveEvent event =
        new CreateGrossToNetActivePowerCurveEvent(command.getGrossToNetActivePowerCurveId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGrossToNetActivePowerCurveCommand command) throws Exception {
    LOGGER.info("handling command UpdateGrossToNetActivePowerCurveCommand");
    UpdateGrossToNetActivePowerCurveEvent event =
        new UpdateGrossToNetActivePowerCurveEvent(
            command.getGrossToNetActivePowerCurveId(), command.getGrossToNetActivePowerCurves());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGrossToNetActivePowerCurveCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGrossToNetActivePowerCurveCommand");
    apply(new DeleteGrossToNetActivePowerCurveEvent(command.getGrossToNetActivePowerCurveId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveCommand");

    if (grossToNetActivePowerCurves.contains(command.getAddTo()))
      throw new ProcessingException(
          "GrossToNetActivePowerCurves already contains an entity with id "
              + command.getAddTo().getGrossToNetActivePowerCurveId());

    apply(
        new AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveEvent(
            command.getGrossToNetActivePowerCurveId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveCommand");

    if (!grossToNetActivePowerCurves.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "GrossToNetActivePowerCurves does not contain an entity with id "
              + command.getRemoveFrom().getGrossToNetActivePowerCurveId());

    apply(
        new RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveEvent(
            command.getGrossToNetActivePowerCurveId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGrossToNetActivePowerCurveEvent event) {
    LOGGER.info("Event sourcing CreateGrossToNetActivePowerCurveEvent");
    this.grossToNetActivePowerCurveId = event.getGrossToNetActivePowerCurveId();
  }

  @EventSourcingHandler
  void on(UpdateGrossToNetActivePowerCurveEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.grossToNetActivePowerCurves = event.getGrossToNetActivePowerCurves();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveEvent event) {
    LOGGER.info(
        "Event sourcing AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveEvent");
    this.grossToNetActivePowerCurves.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveEvent event) {
    LOGGER.info(
        "Event sourcing RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveEvent");
    this.grossToNetActivePowerCurves.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID grossToNetActivePowerCurveId;

  private Set<GrossToNetActivePowerCurve> grossToNetActivePowerCurves = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(GrossToNetActivePowerCurveAggregate.class.getName());
}
