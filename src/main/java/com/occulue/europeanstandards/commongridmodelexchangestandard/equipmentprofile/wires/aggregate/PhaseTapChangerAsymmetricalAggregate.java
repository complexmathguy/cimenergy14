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
 * Aggregate handler for PhaseTapChangerAsymmetrical as outlined for the CQRS pattern, all write
 * responsibilities related to PhaseTapChangerAsymmetrical are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PhaseTapChangerAsymmetricalAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PhaseTapChangerAsymmetricalAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PhaseTapChangerAsymmetricalAggregate(CreatePhaseTapChangerAsymmetricalCommand command)
      throws Exception {
    LOGGER.info("Handling command CreatePhaseTapChangerAsymmetricalCommand");
    CreatePhaseTapChangerAsymmetricalEvent event =
        new CreatePhaseTapChangerAsymmetricalEvent(command.getPhaseTapChangerAsymmetricalId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePhaseTapChangerAsymmetricalCommand command) throws Exception {
    LOGGER.info("handling command UpdatePhaseTapChangerAsymmetricalCommand");
    UpdatePhaseTapChangerAsymmetricalEvent event =
        new UpdatePhaseTapChangerAsymmetricalEvent(
            command.getPhaseTapChangerAsymmetricalId(), command.getWindingConnectionAngle());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePhaseTapChangerAsymmetricalCommand command) throws Exception {
    LOGGER.info("Handling command DeletePhaseTapChangerAsymmetricalCommand");
    apply(new DeletePhaseTapChangerAsymmetricalEvent(command.getPhaseTapChangerAsymmetricalId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignWindingConnectionAngleToPhaseTapChangerAsymmetricalCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignWindingConnectionAngleToPhaseTapChangerAsymmetricalCommand");

    if (windingConnectionAngle != null
        && windingConnectionAngle.getAngleDegreesId()
            == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "WindingConnectionAngle already assigned with id "
              + command.getAssignment().getAngleDegreesId());

    apply(
        new AssignWindingConnectionAngleToPhaseTapChangerAsymmetricalEvent(
            command.getPhaseTapChangerAsymmetricalId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWindingConnectionAngleFromPhaseTapChangerAsymmetricalCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignWindingConnectionAngleFromPhaseTapChangerAsymmetricalCommand");

    if (windingConnectionAngle == null)
      throw new ProcessingException("WindingConnectionAngle already has nothing assigned.");

    apply(
        new UnAssignWindingConnectionAngleFromPhaseTapChangerAsymmetricalEvent(
            command.getPhaseTapChangerAsymmetricalId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePhaseTapChangerAsymmetricalEvent event) {
    LOGGER.info("Event sourcing CreatePhaseTapChangerAsymmetricalEvent");
    this.phaseTapChangerAsymmetricalId = event.getPhaseTapChangerAsymmetricalId();
  }

  @EventSourcingHandler
  void on(UpdatePhaseTapChangerAsymmetricalEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.windingConnectionAngle = event.getWindingConnectionAngle();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignWindingConnectionAngleToPhaseTapChangerAsymmetricalEvent event) {
    LOGGER.info("Event sourcing AssignWindingConnectionAngleToPhaseTapChangerAsymmetricalEvent");
    this.windingConnectionAngle = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWindingConnectionAngleFromPhaseTapChangerAsymmetricalEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignWindingConnectionAngleFromPhaseTapChangerAsymmetricalEvent");
    this.windingConnectionAngle = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID phaseTapChangerAsymmetricalId;

  private AngleDegrees windingConnectionAngle = null;

  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerAsymmetricalAggregate.class.getName());
}
