package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.aggregate;

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
 * Aggregate handler for SvVoltage as outlined for the CQRS pattern, all write responsibilities
 * related to SvVoltage are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SvVoltageAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SvVoltageAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SvVoltageAggregate(CreateSvVoltageCommand command) throws Exception {
    LOGGER.info("Handling command CreateSvVoltageCommand");
    CreateSvVoltageEvent event = new CreateSvVoltageEvent(command.getSvVoltageId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSvVoltageCommand command) throws Exception {
    LOGGER.info("handling command UpdateSvVoltageCommand");
    UpdateSvVoltageEvent event =
        new UpdateSvVoltageEvent(
            command.getSvVoltageId(), command.getAngle(), command.getV(), command.getSvVoltage());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSvVoltageCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSvVoltageCommand");
    apply(new DeleteSvVoltageEvent(command.getSvVoltageId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAngleToSvVoltageCommand command) throws Exception {
    LOGGER.info("Handling command AssignAngleToSvVoltageCommand");

    if (angle != null && angle.getAngleDegreesId() == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "Angle already assigned with id " + command.getAssignment().getAngleDegreesId());

    apply(new AssignAngleToSvVoltageEvent(command.getSvVoltageId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAngleFromSvVoltageCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAngleFromSvVoltageCommand");

    if (angle == null) throw new ProcessingException("Angle already has nothing assigned.");

    apply(new UnAssignAngleFromSvVoltageEvent(command.getSvVoltageId()));
  }

  @CommandHandler
  public void handle(AssignVToSvVoltageCommand command) throws Exception {
    LOGGER.info("Handling command AssignVToSvVoltageCommand");

    if (v != null && v.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "V already assigned with id " + command.getAssignment().getVoltageId());

    apply(new AssignVToSvVoltageEvent(command.getSvVoltageId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVFromSvVoltageCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVFromSvVoltageCommand");

    if (v == null) throw new ProcessingException("V already has nothing assigned.");

    apply(new UnAssignVFromSvVoltageEvent(command.getSvVoltageId()));
  }

  @CommandHandler
  public void handle(AssignSvVoltageToSvVoltageCommand command) throws Exception {
    LOGGER.info("Handling command AssignSvVoltageToSvVoltageCommand");

    if (svVoltage != null && svVoltage.getSvVoltageId() == command.getAssignment().getSvVoltageId())
      throw new ProcessingException(
          "SvVoltage already assigned with id " + command.getAssignment().getSvVoltageId());

    apply(new AssignSvVoltageToSvVoltageEvent(command.getSvVoltageId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSvVoltageFromSvVoltageCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignSvVoltageFromSvVoltageCommand");

    if (svVoltage == null) throw new ProcessingException("SvVoltage already has nothing assigned.");

    apply(new UnAssignSvVoltageFromSvVoltageEvent(command.getSvVoltageId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSvVoltageEvent event) {
    LOGGER.info("Event sourcing CreateSvVoltageEvent");
    this.svVoltageId = event.getSvVoltageId();
  }

  @EventSourcingHandler
  void on(UpdateSvVoltageEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.angle = event.getAngle();
    this.v = event.getV();
    this.svVoltage = event.getSvVoltage();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAngleToSvVoltageEvent event) {
    LOGGER.info("Event sourcing AssignAngleToSvVoltageEvent");
    this.angle = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAngleFromSvVoltageEvent event) {
    LOGGER.info("Event sourcing UnAssignAngleFromSvVoltageEvent");
    this.angle = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVToSvVoltageEvent event) {
    LOGGER.info("Event sourcing AssignVToSvVoltageEvent");
    this.v = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVFromSvVoltageEvent event) {
    LOGGER.info("Event sourcing UnAssignVFromSvVoltageEvent");
    this.v = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSvVoltageToSvVoltageEvent event) {
    LOGGER.info("Event sourcing AssignSvVoltageToSvVoltageEvent");
    this.svVoltage = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSvVoltageFromSvVoltageEvent event) {
    LOGGER.info("Event sourcing UnAssignSvVoltageFromSvVoltageEvent");
    this.svVoltage = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID svVoltageId;

  private AngleDegrees angle = null;
  private Voltage v = null;
  private SvVoltage svVoltage = null;

  private static final Logger LOGGER = Logger.getLogger(SvVoltageAggregate.class.getName());
}
