package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.aggregate;

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
 * Aggregate handler for VoltageLevel as outlined for the CQRS pattern, all write responsibilities
 * related to VoltageLevel are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class VoltageLevelAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public VoltageLevelAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public VoltageLevelAggregate(CreateVoltageLevelCommand command) throws Exception {
    LOGGER.info("Handling command CreateVoltageLevelCommand");
    CreateVoltageLevelEvent event = new CreateVoltageLevelEvent(command.getVoltageLevelId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateVoltageLevelCommand command) throws Exception {
    LOGGER.info("handling command UpdateVoltageLevelCommand");
    UpdateVoltageLevelEvent event =
        new UpdateVoltageLevelEvent(
            command.getVoltageLevelId(),
            command.getHighVoltageLimit(),
            command.getLowVoltageLimit(),
            command.getVoltageLevel(),
            command.getVoltageLevels());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteVoltageLevelCommand command) throws Exception {
    LOGGER.info("Handling command DeleteVoltageLevelCommand");
    apply(new DeleteVoltageLevelEvent(command.getVoltageLevelId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignHighVoltageLimitToVoltageLevelCommand command) throws Exception {
    LOGGER.info("Handling command AssignHighVoltageLimitToVoltageLevelCommand");

    if (highVoltageLimit != null
        && highVoltageLimit.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "HighVoltageLimit already assigned with id " + command.getAssignment().getVoltageId());

    apply(
        new AssignHighVoltageLimitToVoltageLevelEvent(
            command.getVoltageLevelId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHighVoltageLimitFromVoltageLevelCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignHighVoltageLimitFromVoltageLevelCommand");

    if (highVoltageLimit == null)
      throw new ProcessingException("HighVoltageLimit already has nothing assigned.");

    apply(new UnAssignHighVoltageLimitFromVoltageLevelEvent(command.getVoltageLevelId()));
  }

  @CommandHandler
  public void handle(AssignLowVoltageLimitToVoltageLevelCommand command) throws Exception {
    LOGGER.info("Handling command AssignLowVoltageLimitToVoltageLevelCommand");

    if (lowVoltageLimit != null
        && lowVoltageLimit.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "LowVoltageLimit already assigned with id " + command.getAssignment().getVoltageId());

    apply(
        new AssignLowVoltageLimitToVoltageLevelEvent(
            command.getVoltageLevelId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLowVoltageLimitFromVoltageLevelCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLowVoltageLimitFromVoltageLevelCommand");

    if (lowVoltageLimit == null)
      throw new ProcessingException("LowVoltageLimit already has nothing assigned.");

    apply(new UnAssignLowVoltageLimitFromVoltageLevelEvent(command.getVoltageLevelId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignVoltageLevelToVoltageLevelCommand command) throws Exception {
    LOGGER.info("Handling command AssignVoltageLevelToVoltageLevelCommand");

    if (voltageLevel.contains(command.getAddTo()))
      throw new ProcessingException(
          "VoltageLevel already contains an entity with id "
              + command.getAddTo().getVoltageLevelId());

    apply(
        new AssignVoltageLevelToVoltageLevelEvent(command.getVoltageLevelId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveVoltageLevelFromVoltageLevelCommand command) throws Exception {
    LOGGER.info("Handling command RemoveVoltageLevelFromVoltageLevelCommand");

    if (!voltageLevel.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "VoltageLevel does not contain an entity with id "
              + command.getRemoveFrom().getVoltageLevelId());

    apply(
        new RemoveVoltageLevelFromVoltageLevelEvent(
            command.getVoltageLevelId(), command.getRemoveFrom()));
  }

  @CommandHandler
  public void handle(AssignVoltageLevelsToVoltageLevelCommand command) throws Exception {
    LOGGER.info("Handling command AssignVoltageLevelsToVoltageLevelCommand");

    if (voltageLevels.contains(command.getAddTo()))
      throw new ProcessingException(
          "VoltageLevels already contains an entity with id "
              + command.getAddTo().getVoltageLevelId());

    apply(
        new AssignVoltageLevelsToVoltageLevelEvent(
            command.getVoltageLevelId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveVoltageLevelsFromVoltageLevelCommand command) throws Exception {
    LOGGER.info("Handling command RemoveVoltageLevelsFromVoltageLevelCommand");

    if (!voltageLevels.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "VoltageLevels does not contain an entity with id "
              + command.getRemoveFrom().getVoltageLevelId());

    apply(
        new RemoveVoltageLevelsFromVoltageLevelEvent(
            command.getVoltageLevelId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateVoltageLevelEvent event) {
    LOGGER.info("Event sourcing CreateVoltageLevelEvent");
    this.voltageLevelId = event.getVoltageLevelId();
  }

  @EventSourcingHandler
  void on(UpdateVoltageLevelEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.highVoltageLimit = event.getHighVoltageLimit();
    this.lowVoltageLimit = event.getLowVoltageLimit();
    this.voltageLevel = event.getVoltageLevel();
    this.voltageLevels = event.getVoltageLevels();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignHighVoltageLimitToVoltageLevelEvent event) {
    LOGGER.info("Event sourcing AssignHighVoltageLimitToVoltageLevelEvent");
    this.highVoltageLimit = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHighVoltageLimitFromVoltageLevelEvent event) {
    LOGGER.info("Event sourcing UnAssignHighVoltageLimitFromVoltageLevelEvent");
    this.highVoltageLimit = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLowVoltageLimitToVoltageLevelEvent event) {
    LOGGER.info("Event sourcing AssignLowVoltageLimitToVoltageLevelEvent");
    this.lowVoltageLimit = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLowVoltageLimitFromVoltageLevelEvent event) {
    LOGGER.info("Event sourcing UnAssignLowVoltageLimitFromVoltageLevelEvent");
    this.lowVoltageLimit = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignVoltageLevelToVoltageLevelEvent event) {
    LOGGER.info("Event sourcing AssignVoltageLevelToVoltageLevelEvent");
    this.voltageLevel.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveVoltageLevelFromVoltageLevelEvent event) {
    LOGGER.info("Event sourcing RemoveVoltageLevelFromVoltageLevelEvent");
    this.voltageLevel.remove(event.getRemoveFrom());
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignVoltageLevelsToVoltageLevelEvent event) {
    LOGGER.info("Event sourcing AssignVoltageLevelsToVoltageLevelEvent");
    this.voltageLevels.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveVoltageLevelsFromVoltageLevelEvent event) {
    LOGGER.info("Event sourcing RemoveVoltageLevelsFromVoltageLevelEvent");
    this.voltageLevels.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID voltageLevelId;

  private Voltage highVoltageLimit = null;
  private Voltage lowVoltageLimit = null;
  private Set<VoltageLevel> voltageLevel = new HashSet<>();
  private Set<VoltageLevel> voltageLevels = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(VoltageLevelAggregate.class.getName());
}
