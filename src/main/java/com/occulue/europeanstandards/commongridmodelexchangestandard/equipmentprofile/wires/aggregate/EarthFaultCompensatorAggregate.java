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
 * Aggregate handler for EarthFaultCompensator as outlined for the CQRS pattern, all write
 * responsibilities related to EarthFaultCompensator are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class EarthFaultCompensatorAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public EarthFaultCompensatorAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public EarthFaultCompensatorAggregate(CreateEarthFaultCompensatorCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateEarthFaultCompensatorCommand");
    CreateEarthFaultCompensatorEvent event =
        new CreateEarthFaultCompensatorEvent(command.getEarthFaultCompensatorId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateEarthFaultCompensatorCommand command) throws Exception {
    LOGGER.info("handling command UpdateEarthFaultCompensatorCommand");
    UpdateEarthFaultCompensatorEvent event =
        new UpdateEarthFaultCompensatorEvent(command.getEarthFaultCompensatorId(), command.getR());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteEarthFaultCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command DeleteEarthFaultCompensatorCommand");
    apply(new DeleteEarthFaultCompensatorEvent(command.getEarthFaultCompensatorId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignRToEarthFaultCompensatorCommand command) throws Exception {
    LOGGER.info("Handling command AssignRToEarthFaultCompensatorCommand");

    if (r != null && r.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignRToEarthFaultCompensatorEvent(
            command.getEarthFaultCompensatorId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromEarthFaultCompensatorCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromEarthFaultCompensatorCommand");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromEarthFaultCompensatorEvent(command.getEarthFaultCompensatorId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateEarthFaultCompensatorEvent event) {
    LOGGER.info("Event sourcing CreateEarthFaultCompensatorEvent");
    this.earthFaultCompensatorId = event.getEarthFaultCompensatorId();
  }

  @EventSourcingHandler
  void on(UpdateEarthFaultCompensatorEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.r = event.getR();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignRToEarthFaultCompensatorEvent event) {
    LOGGER.info("Event sourcing AssignRToEarthFaultCompensatorEvent");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromEarthFaultCompensatorEvent event) {
    LOGGER.info("Event sourcing UnAssignRFromEarthFaultCompensatorEvent");
    this.r = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID earthFaultCompensatorId;

  private Resistance r = null;

  private static final Logger LOGGER =
      Logger.getLogger(EarthFaultCompensatorAggregate.class.getName());
}
