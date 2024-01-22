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
 * Aggregate handler for PhaseTapChangerTablePoint as outlined for the CQRS pattern, all write
 * responsibilities related to PhaseTapChangerTablePoint are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PhaseTapChangerTablePointAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PhaseTapChangerTablePointAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PhaseTapChangerTablePointAggregate(CreatePhaseTapChangerTablePointCommand command)
      throws Exception {
    LOGGER.info("Handling command CreatePhaseTapChangerTablePointCommand");
    CreatePhaseTapChangerTablePointEvent event =
        new CreatePhaseTapChangerTablePointEvent(command.getPhaseTapChangerTablePointId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePhaseTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("handling command UpdatePhaseTapChangerTablePointCommand");
    UpdatePhaseTapChangerTablePointEvent event =
        new UpdatePhaseTapChangerTablePointEvent(
            command.getPhaseTapChangerTablePointId(),
            command.getAngle(),
            command.getPhaseTapChangerTablePoint());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePhaseTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handling command DeletePhaseTapChangerTablePointCommand");
    apply(new DeletePhaseTapChangerTablePointEvent(command.getPhaseTapChangerTablePointId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAngleToPhaseTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handling command AssignAngleToPhaseTapChangerTablePointCommand");

    if (angle != null && angle.getAngleDegreesId() == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "Angle already assigned with id " + command.getAssignment().getAngleDegreesId());

    apply(
        new AssignAngleToPhaseTapChangerTablePointEvent(
            command.getPhaseTapChangerTablePointId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAngleFromPhaseTapChangerTablePointCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAngleFromPhaseTapChangerTablePointCommand");

    if (angle == null) throw new ProcessingException("Angle already has nothing assigned.");

    apply(
        new UnAssignAngleFromPhaseTapChangerTablePointEvent(
            command.getPhaseTapChangerTablePointId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointCommand");

    if (phaseTapChangerTablePoint.contains(command.getAddTo()))
      throw new ProcessingException(
          "PhaseTapChangerTablePoint already contains an entity with id "
              + command.getAddTo().getPhaseTapChangerTablePointId());

    apply(
        new AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointEvent(
            command.getPhaseTapChangerTablePointId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointCommand");

    if (!phaseTapChangerTablePoint.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "PhaseTapChangerTablePoint does not contain an entity with id "
              + command.getRemoveFrom().getPhaseTapChangerTablePointId());

    apply(
        new RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointEvent(
            command.getPhaseTapChangerTablePointId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePhaseTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing CreatePhaseTapChangerTablePointEvent");
    this.phaseTapChangerTablePointId = event.getPhaseTapChangerTablePointId();
  }

  @EventSourcingHandler
  void on(UpdatePhaseTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.angle = event.getAngle();
    this.phaseTapChangerTablePoint = event.getPhaseTapChangerTablePoint();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAngleToPhaseTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing AssignAngleToPhaseTapChangerTablePointEvent");
    this.angle = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAngleFromPhaseTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing UnAssignAngleFromPhaseTapChangerTablePointEvent");
    this.angle = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointEvent");
    this.phaseTapChangerTablePoint.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointEvent event) {
    LOGGER.info("Event sourcing RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointEvent");
    this.phaseTapChangerTablePoint.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID phaseTapChangerTablePointId;

  private AngleDegrees angle = null;
  private Set<PhaseTapChangerTablePoint> phaseTapChangerTablePoint = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerTablePointAggregate.class.getName());
}
